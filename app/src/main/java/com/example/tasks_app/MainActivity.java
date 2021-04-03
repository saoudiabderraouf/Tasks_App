package com.example.tasks_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    RelativeLayout relativeLayout_home , relativeLayout_tasks;
    ImageView imageView_home , imageView_tasks;
    TextView textView_home , textView_tasks;
    Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        relativeLayout_home = findViewById(R.id.home);
        relativeLayout_tasks = findViewById(R.id.tasks);
        imageView_home = findViewById(R.id.home_img);
        imageView_tasks = findViewById(R.id.tasks_img);
        textView_home = findViewById(R.id.home_txt);
        textView_tasks = findViewById(R.id.tasks_txt);

        fragment = new HomeFragment() ;
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout,fragment) ;
        fragmentTransaction.commit() ;

        relativeLayout_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageView_home.setVisibility(View.GONE);
                textView_home.setVisibility(View.VISIBLE);
                textView_tasks.setVisibility(View.GONE);
                imageView_tasks.setVisibility(View.VISIBLE);

                fragment = new HomeFragment() ;
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frame_layout,fragment) ;
                fragmentTransaction.commit() ;
            }
        });

        relativeLayout_tasks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageView_home.setVisibility(View.VISIBLE);
                textView_home.setVisibility(View.GONE);
                textView_tasks.setVisibility(View.VISIBLE);
                imageView_tasks.setVisibility(View.GONE);

                fragment = new TasksFragment() ;
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frame_layout,fragment) ;
                fragmentTransaction.commit() ;
            }
        });

    }
}