package com.example.ahmaadyunus.navigationdrawmultipleactivitytest;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileDescriptor;
import java.io.IOException;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    protected Toolbar toolbar;
    protected DrawerLayout drawerLayout;
    protected NavigationView navigationView;
    private static boolean isLaunch=true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawerLayout);
        if(isLaunch){
            openActivity(R.id.nav_home);
            isLaunch=false;
        }
        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        NavigationView navigationView = findViewById(R.id.nav_view);
        View headerView = navigationView.getHeaderView(0);
        TextView navUsername = headerView.findViewById(R.id.navUsername);
        navUsername.setText("名前を入力してください");
        TextView navUsermail = headerView.findViewById(R.id.navUsermail);
        navUsermail.setText("メールを入力");
    }
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        openActivity(id);
//        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    protected void openActivity(int id) {
        switch (id) {
            case R.id.nav_home:
                startActivity(new Intent(this, HomeActivity.class));
                break;
            case R.id.nav_profile:
                startActivity(new Intent(this, ProfileActivity.class));
                break;
            case R.id.nav_contact:
                startActivity(new Intent(this, ContactActivity.class));
                break;
            case R.id.nav_hello:
                startActivity(new Intent(this, HelloActivity.class));
                break;
            default:
                break;
        }
    }
}
