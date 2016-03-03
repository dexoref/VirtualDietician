package com.codedleaf.sylveryte.virutaldietician;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;


import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private static final String FRAGMENT_CODE = "codedleafbro";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        DietLab.createAbsoluteOneCrimeLab(this);
        DietLab.get().initiateDB();
        DietLab.get().readDB();

        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        startFragment(UserFragment.newInstance());

    }

    private void startFragment(Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();

        //clean up any fragments blah blah
        List<Fragment> frags=fm.getFragments();
        if(frags!=null)
        {

            for (Fragment frag:frags)
            {
                if(frag.getTag().toString().equals(FRAGMENT_CODE))
                {
                    fm.beginTransaction().remove(frag).commit();
                }
            }
        }

        fm.beginTransaction()
                    .add(R.id.fragment_main_container, fragment,FRAGMENT_CODE)
                    .commit();
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.main_diet_plan) {
            startFragment(DietPlanFragment.newInstance());
        } else if (id == R.id.add_diet) {
           startFragment(AddDietFragment.newInstance());
        } else if (id == R.id.available_diets) {
            startFragment(FullDietsFragment.newInstance());
        } else if (id == R.id.user_info_edit)  {
            startFragment(UserFragment.newInstance());
        }else if(id==R.id.shopping_list)
            startFragment(ShoppingFragment.newInstance());

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
