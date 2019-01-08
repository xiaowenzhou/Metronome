package com.example.zhouxw.metronome;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * @author zhouxw
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView tvSpeed;
    private ImageButton btnAdd,btnIncrease,btnPlay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void initView(){
        tvSpeed = findViewById(R.id.tv_speed);
        btnAdd = findViewById(R.id.btn_add);
        btnIncrease =  findViewById(R.id.btn_increase);
        btnPlay = findViewById(R.id.btn_play);
        btnAdd.setOnClickListener(this);
        btnPlay.setOnClickListener(this);
        btnIncrease.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_add:{
                break;
            }
            case R.id.btn_increase:{
                break;
            }
            case R.id.btn_play:{
                break;
            }
            default:
        }

    }
}
