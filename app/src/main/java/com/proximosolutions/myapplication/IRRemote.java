package com.proximosolutions.myapplication;

import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import static java.security.AccessController.getContext;

public class IRRemote extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private FragmentConnect fragmentConnect;
    private  FragmentRemote fragmentRemote;
    private  FragmentRemote fragmentRemoteLearn;
    public MessageData msg;
    android.app.FragmentManager fragmentManager;
    Remote remote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_irremote);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        MessageData msg = new MessageData();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        fragmentManager = getFragmentManager();
        fragmentConnect = new FragmentConnect();
        fragmentRemote = new FragmentRemote();
        fragmentRemoteLearn = new FragmentRemote();
        msg = new MessageData();


        if(remote==null){
            remote = new Remote();
            remote.retrieve();

        }
        fragmentConnect.msg = msg;
        fragmentRemote.msg = msg;
        fragmentRemoteLearn.msg = msg;
        fragmentRemote.remote = remote;
        fragmentRemoteLearn.remote = remote;
        fragmentManager.beginTransaction()
                .replace(R.id.content_irremote_id, fragmentConnect)
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
        getMenuInflater().inflate(R.menu.irremote, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement


        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.connect) {
            fragmentManager.beginTransaction()
                    .replace(R.id.content_irremote_id, fragmentConnect)
                    .commit();

        } else if (id == R.id.nav_gallery) {
            fragmentRemote.learnMode = false;
            //fragmentRemote.onResume();
            fragmentManager.beginTransaction()
                    .replace(R.id.content_irremote_id, fragmentRemote)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit();
            if(fragmentRemote.getMainText()!=null){
                fragmentRemote.getMainText().setText("REMOTE MODE");
            }


        } else if (id == R.id.nav_slideshow) {
            fragmentRemote.learnMode = true;
            //fragmentRemote.onResume();

            fragmentManager.beginTransaction()
                    .replace(R.id.content_irremote_id, fragmentRemote)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit();
            if(fragmentRemote.getMainText()!=null){
                fragmentRemote.getMainText().setText("LEARN MODE");
            }




        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }







    @Override
    protected void onDestroy() {
        super.onDestroy();
        remote.save(remote);
    }

    @Override
    protected void onPause() {
        super.onPause();
        remote.save(remote);
    }


}
