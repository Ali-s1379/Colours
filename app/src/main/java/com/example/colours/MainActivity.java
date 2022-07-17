package com.example.colours;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Button> buttons = new ArrayList<>();
    private List<CharSequence> colours = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();
    }

    private void initUI(){
        buttons.add((Button) findViewById(R.id.button_blue));
        buttons.add((Button) findViewById(R.id.button_red));
        buttons.add((Button) findViewById(R.id.button_green));
        buttons.add((Button) findViewById(R.id.button_indigo));
        buttons.add((Button) findViewById(R.id.button_violet));
        buttons.add((Button) findViewById(R.id.button_yellow));
        buttons.add((Button) findViewById(R.id.button_orange));
        for (Button button:buttons){
            colours.add(button.getText());
        }
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.setVisibility(View.GONE);
                for (Button button:buttons){
                    button.setText(((Button) view).getText());
                }
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0;i < 7;i++){
                            buttons.get(i).setText(colours.get(i));
                            buttons.get(i).setVisibility(View.VISIBLE);
                        }
                    }
                }, 5000);
            }
        };
        for (Button button:buttons){
            button.setOnClickListener(listener);
        }
    }

}

