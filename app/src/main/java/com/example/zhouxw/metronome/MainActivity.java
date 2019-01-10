package com.example.zhouxw.metronome;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.zhouxw.metronome.utils.SoundPoolUtil;

import java.util.HashMap;

/**
 * @author zhouxw
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String SPEED_PRE= "speedPreferences";
    private static final  String SPEED= "Speed";
    private TextView tvSpeed,tvRhythm;
    private int speed,molecule,deno ;
    private ImageButton btnAdd,btnIncrease,btnPlay,btnMoleculeAdd,btnMoleculeIncr,btnDenoAdd,btnDenoIncr;
    private SharedPreferences mSharedPreferences=getSharedPreferences(SPEED_PRE,Context.MODE_PRIVATE);
    private SoundPoolUtil mSoundPoolUtil;
    HashMap<Integer,Integer> musicId = new HashMap<>();

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
        btnDenoAdd= findViewById(R.id.btn_add_meno);
        btnDenoIncr= findViewById(R.id.btn_increase_deno);
        btnMoleculeAdd =findViewById(R.id.btn_add_molecule);
        btnMoleculeIncr =findViewById(R.id.btn_increase_molecule);
        tvRhythm = findViewById(R.id.tv_rhythm);
        btnAdd.setOnClickListener(this);
        btnPlay.setOnClickListener(this);
        btnIncrease.setOnClickListener(this);
        btnDenoAdd.setOnClickListener(this);
        btnDenoIncr.setOnClickListener(this);
        btnMoleculeAdd.setOnClickListener(this);
        btnMoleculeIncr.setOnClickListener(this);

    }

    private  void initData(){
        mSoundPoolUtil =SoundPoolUtil.getInstance(this);
        speed= mSharedPreferences.getInt(SPEED,60);
        musicId.put(0,mSoundPoolUtil.loadSound(R.raw.metronome1));
        musicId.put(1,mSoundPoolUtil.loadSound(R.raw.metronome2));
        musicId.put(2,mSoundPoolUtil.loadSound(R.raw.metronome3));
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
