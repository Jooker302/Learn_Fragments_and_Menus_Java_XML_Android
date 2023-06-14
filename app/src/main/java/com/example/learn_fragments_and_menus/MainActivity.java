package com.example.learn_fragments_and_menus;

//import androidx.appcompat.app.AppCompatActivity;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    OneFragment fragmentOne;
    TwoFragment fragmentTwo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentOne = new OneFragment();
        fragmentTwo = new TwoFragment();

        // Set the initial fragment
        setFragment(fragmentOne);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item){

        int itemId = item.getItemId();

        if(itemId == R.id.action_fragment_one){
            setFragment(fragmentOne);
        } else if (itemId == R.id.action_fragment_two) {
            setFragment(fragmentTwo);
        }


        return super.onOptionsItemSelected(item);
    }

    private void setFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container,fragment);
        fragmentTransaction.commit();
    }


}