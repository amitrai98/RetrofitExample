package android.stakbrowser.amitrai.retrofitexample;

import android.os.Bundle;
import android.stakbrowser.amitrai.retrofitexample.RetrofiltCode.DataModal;
import android.stakbrowser.amitrai.retrofitexample.RetrofiltCode.StakJsonRequester;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class Splash extends AppCompatActivity {

    private WebView webView = null;
    private EditText edt_query = null;
    private Button btn_search = null;

    protected final String TAG = getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        initWebView();
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

    /**
     * Method will intialize the WebView and set the WebViewClient and WebChromeClient
     */
    private void initWebView() {
        webView = (WebView) findViewById(R.id.web_view);
        edt_query = (EditText) findViewById(R.id.edt_query);
        btn_search = (Button) findViewById(R.id.btn_search);


        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String search_query = edt_query.getText().toString().trim();
                if (search_query.length() > 0){
//                    StakSearch.search(search_query, Splash.this, webView);
                    new StakJsonRequester(Splash.this, search_query);
                }
            }
        });


//        webView.loadUrl("http://www.google.co.in");
    }


}