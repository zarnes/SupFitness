package com.supinfo.supfitness;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            boolean[] shows = {false, false, false};

            View[] views = new View[3];
            views[0] = findViewById(R.id.view_weight);
            views[1] = findViewById(R.id.view_curve);
            views[2] = findViewById(R.id.view_map);

            switch (item.getItemId()) {
                case R.id.navigation_weight:
                    shows[0] = true;
                    break;
                case R.id.navigation_curve:
                    shows[1] = true;
                    break;
                case R.id.navigation_map:
                    shows[2] = true;
                    break;
            }

            for (int i =0; i < 3; ++i)
            {
                if (views[i] != null)
                    views[i].setVisibility(shows[i] ? View.VISIBLE : View.GONE);
                else
                    return false;
            }
            return true;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
