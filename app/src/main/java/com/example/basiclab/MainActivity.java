package com.example.basiclab;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.fragment.NavHostFragment;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.io.FileReader;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fab = findViewById(R.id.fab);
        /* FloatingActionButton fab = findViewById(R.id.fab);*/
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Set Action in Menu ", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        String message = "";



        switch (id) {
            case R.id.action_settings:
                message = "First fragment";


                break;
            case R.id.action_iitem1:
                message = "Second fragment";

                break;
            case R.id.action_item2:
                message = "Third fragment";

                break;
        }

        Snackbar.make(findViewById(R.id.rootlayout), message, Snackbar.LENGTH_LONG).show();


        return super.onOptionsItemSelected(item);
    }

    private void fragments(int number) {

         int[] frames;
        frames = new int[]{R.id.FirstFragment, R.id.SecondFragment, R.id.ThirdFragment};


        Fragment[] fragments = new Fragment[]{new FirstFragment(), new SecondFragment(), new ThirdFragment()};
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.add(frames[number], fragments[number]);

        transaction.addToBackStack(null);
        transaction.commit();
    }

}

