package com.bianhailena.project1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.ListFragment;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button instructions;
    Instructions fragment2;
    Cards fragment1;
    boolean frag2 = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragment1 = new Cards();
        fragment2 = new Instructions();
        //getSupportFragmentManager().beginTransaction().replace(R.id.fragment, fragment1).commit();
        instructions = findViewById(R.id.instructionButton);
        instructions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction().remove(fragmentManager.findFragmentById(R.id.fragment)).commit();
//                if(!frag2){
//                    //fragmentManager.beginTransaction().replace(R.id.fragment, fragment2).commit();
//                    instructions.setText("Back");
//                    frag2 = true;
//                }
//                else{
//                    //fragmentManager.beginTransaction().replace(R.id.fragment, fragment1).commit();
//                    instructions.setText("Back");
//                    frag2 = false;
//                }

            }
        });
    }

}