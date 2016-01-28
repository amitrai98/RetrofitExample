package android.stakbrowser.amitrai.retrofitexample.Activity;

import android.app.Activity;
import android.content.Context;
import android.demo.amitrai.staksdk.Interfaces.StakListener;
import android.demo.amitrai.staksdk.Interfaces.StakWeblistener;
import android.demo.amitrai.staksdk.Modal.KiTAG;
import android.demo.amitrai.staksdk.StakSearch;
import android.os.Bundle;
import android.os.Handler;
import android.stakbrowser.amitrai.retrofitexample.Adapters.JsonResultAdapter;
import android.stakbrowser.amitrai.retrofitexample.Modal.DataModal;
import android.stakbrowser.amitrai.retrofitexample.R;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class Splash extends AppCompatActivity{

    private WebView webView = null;
    private EditText edt_query = null;
    private Button btn_search = null;

    public static Activity act = null;

    protected final String TAG = getClass().getSimpleName();

    private JsonResultAdapter adapter = null;

    private RecyclerView recycle_result_list = null;

    private ProgressBar progress = null;

    boolean doubleBackToExitPressedOnce = false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        act = this;


        StakSearch search = new StakSearch(this, new StakListener() {
            @Override
            public void onJsonReceived(List<KiTAG> resonse) {
                Log.e(TAG, ""+resonse);
                if(resonse != null){
                    adapter = new JsonResultAdapter(Splash.this, resonse);
                    recycle_result_list.setAdapter(adapter);
                    webView.setVisibility(View.GONE);
                    progress.setVisibility(View.GONE);
                    recycle_result_list.setVisibility(View.VISIBLE);
                    recycle_result_list.setLayoutManager(new LinearLayoutManager(Splash.this));
                    if(resonse.size() >0 && resonse.get(0).getSearchString() != null)
                        edt_query.setText(resonse.get(0).getSearchString());
                }
            }

            @Override
            public void onFailure(String message) {
                Log.e(TAG, ""+message);
            }

            @Override
            public void onListeningStart() {
                progress.setVisibility(View.VISIBLE);
                Log.e(TAG, "progress start");
            }

            @Override
            public void onVoiceDataReceived(String query) {
                edt_query.setText(query);
            }
        });



        initWebView();

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        act = null;
    }

    private Callback<DataModal> callback = new Callback<DataModal>() {
            @Override
            public void onResponse(Response<DataModal> response, Retrofit retrofit) {
                Log.d(TAG, "" + response);
            }

            @Override
            public void onFailure(Throwable t) {
                Log.d(TAG, ""+t);
            }
        };


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_splash, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**setO
     * Method will intialize the WebView and set the WebViewClient and WebChromeClient
     */
    private void initWebView() {
        progress = (ProgressBar) findViewById(R.id.progress);
        webView = (WebView) findViewById(R.id.web_view);
        edt_query = (EditText) findViewById(R.id.edt_query);
        btn_search = (Button) findViewById(R.id.btn_search);
        recycle_result_list = (RecyclerView) findViewById(R.id.recycle_result_list);


        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edt_query.getText() != null && edt_query.getText().toString().trim().length() != 0){
                    onSearchSubmit();
                }else{
                    edt_query.setError("Can not search Empty text");
                    edt_query.requestFocus();
                }

            }
        });


        edt_query.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    onSearchSubmit();
                }
                return false;
            }
        });
    }


    private void onSearchSubmit(){
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(edt_query.getWindowToken(), 0);

        String search_query = edt_query.getText().toString().trim();
        if (search_query.length() > 0) {
            progress.setVisibility(View.GONE);
            recycle_result_list.setVisibility(View.GONE);
            webView.setVisibility(View.VISIBLE);
            new StakSearch(new StakWeblistener() {
                @Override
                public void onProgresStarted() {
                    recycle_result_list.setVisibility(View.GONE);
                    webView.setVisibility(View.GONE);
                    progress.setVisibility(View.VISIBLE);
                }

                @Override
                public void onProgressFinished() {
                    progress.setVisibility(View.GONE);
                    webView.setVisibility(View.VISIBLE);
                }
            }).search(search_query, Splash.this, webView);
        }
    }

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 2000);
    }
}
