package android.stakbrowser.amitrai.retrofitexample.Activity;

import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.stakbrowser.amitrai.retrofitexample.Fragments.FragmentJsonSearch;
import android.stakbrowser.amitrai.retrofitexample.Fragments.FragmentWebSearch;
import android.stakbrowser.amitrai.retrofitexample.R;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.FrameLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements FragmentWebSearch.OnFragmentInteractionListener , FragmentJsonSearch.OnFragmentInteractionListener{

    private RecyclerView recycle_navigationlist = null;

    private FrameLayout container = null;
    private boolean doubleBackToExitPressedOnce = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.collapseview);

        initview();
        replaceFragment(new FragmentJsonSearch());

    }




    private void replaceFragment (Fragment fragment){
        String backStateName = fragment.getClass().getName();

        FragmentManager manager = getSupportFragmentManager();
        boolean fragmentPopped = manager.popBackStackImmediate (backStateName, 0);

        if (!fragmentPopped){ //fragment not in back stack, create it.
            android.support.v4.app.FragmentTransaction ft = manager.beginTransaction();
            ft.replace(R.id.container, fragment);
            ft.addToBackStack(backStateName);
            ft.commit();
        }
    }

    private void initview(){
        recycle_navigationlist = (RecyclerView) findViewById(R.id.recycle_navigationlist);
        container = (FrameLayout) findViewById(R.id.container);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onBackPressed() {
        if(getSupportFragmentManager().getBackStackEntryCount() == 1){
            if (doubleBackToExitPressedOnce) {
                finish();
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
        }else
            super.onBackPressed();
    }
}
