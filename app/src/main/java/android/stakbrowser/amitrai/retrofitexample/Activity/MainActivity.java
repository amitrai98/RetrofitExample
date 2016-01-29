package android.stakbrowser.amitrai.retrofitexample.Activity;

import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.stakbrowser.amitrai.retrofitexample.Adapters.NavigationItemAdapter;
import android.stakbrowser.amitrai.retrofitexample.Fragments.FloatButton;
import android.stakbrowser.amitrai.retrofitexample.Fragments.FragmentJsonSearch;
import android.stakbrowser.amitrai.retrofitexample.Fragments.FragmentWebSearch;
import android.stakbrowser.amitrai.retrofitexample.Modal.NavigationOptionModal;
import android.stakbrowser.amitrai.retrofitexample.R;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.FrameLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements FragmentWebSearch.OnFragmentInteractionListener ,
        FragmentJsonSearch.OnFragmentInteractionListener, NavigationItemAdapter.NavigationListener,
        FloatButton.OnFragmentInteractionListener{

    private RecyclerView recycle_navigationlist = null;
    private DrawerLayout drawerLayout = null;

    private FrameLayout container = null;
    private boolean doubleBackToExitPressedOnce = false;
    private NavigationItemAdapter adapter = null;

    private List<NavigationOptionModal> list_navigationitems = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.collapseview);

        initview();
        initNavigationAdapter();
        replaceFragment(new FragmentJsonSearch());
        showNavigationHint();
    }


    /**
     * shows navigation drawe for a while to make user undstand that there is a navigation drawer in app
     */
    private void showNavigationHint(){
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                if (drawerLayout != null && !drawerLayout.isDrawerOpen(GravityCompat.START))
                    drawerLayout.openDrawer(GravityCompat.START);

                new Handler().postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        if(drawerLayout != null && drawerLayout.isDrawerOpen(GravityCompat.START))
                            drawerLayout.closeDrawer(GravityCompat.START);
                    }
                }, 500);
            }
        }, 200);

    }

    /**
     * replaces fragment on click of navigation drawer item.
     * @param fragment
     */
    private void replaceFragment (Fragment fragment){


        String backStateName = fragment.getClass().getName();

        FragmentManager manager = getSupportFragmentManager();
        int fragment_count = manager.getBackStackEntryCount();
        if(fragment_count >0 && manager.getBackStackEntryAt(fragment_count-1).getName().equals(backStateName)){
            if(drawerLayout != null && drawerLayout.isDrawerOpen(GravityCompat.START))
                drawerLayout.closeDrawer(GravityCompat.START);
            return;
        }
        boolean fragmentPopped = manager.popBackStackImmediate (backStateName, 0);

        if (!fragmentPopped){ //fragment not in back stack, create it.
            android.support.v4.app.FragmentTransaction ft = manager.beginTransaction();
            ft.replace(R.id.container, fragment);
            ft.addToBackStack(backStateName);
            ft.commit();
        }

        if(drawerLayout != null && drawerLayout.isDrawerOpen(GravityCompat.START))
            drawerLayout.closeDrawer(GravityCompat.START);
    }

    private void initview(){
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
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


    /**
     * initalizing navigation adapter for navigtation items and handling there clicks
     */
    private void initNavigationAdapter(){
        list_navigationitems.clear();
        list_navigationitems.add(new NavigationOptionModal("Html Implemention", null));
        list_navigationitems.add(new NavigationOptionModal("JSON Implemention", null));
        list_navigationitems.add(new NavigationOptionModal("float button Implemention", null));

        adapter = new NavigationItemAdapter(this,list_navigationitems, this);
        recycle_navigationlist.setAdapter(adapter);
        recycle_navigationlist.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    public void onNavigatorClicked(int position) {
        switch (position){
            case 0:
                replaceFragment(new FragmentWebSearch());
                break;
            case 1:
                replaceFragment(new FragmentJsonSearch());
                break;
            case 2:
                replaceFragment(new FloatButton());
                break;

        }
    }
}
