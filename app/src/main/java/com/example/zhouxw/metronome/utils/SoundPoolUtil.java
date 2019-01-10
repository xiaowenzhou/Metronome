package com.example.zhouxw.metronome.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;

/**
 * @author zhouxw
 */
public class SoundPoolUtil {
    @SuppressLint("StaticFieldLeak")
    private static       SoundPoolUtil mInstance;
    private              SoundPool     mSoundPool;
    private              AudioManager  mAudioManager;
    private              Context       mContext;
    private              float         volume;
    /**
     * Max sound stream
     */
    private static final int           MAX_STREAMS = 5;
    //stream type
    private static final int           streamType  = AudioManager.STREAM_MUSIC;


    private SoundPoolUtil(Context context) {
        mContext = context;
    }

    public static SoundPoolUtil getInstance(Context context) {
        if (mInstance == null) {
            synchronized (SoundPoolUtil.class) {
                if (mInstance == null) {
                    mInstance = new SoundPoolUtil(context.getApplicationContext());
                }
            }
        }
        return mInstance;
    }

    public void init() {
        mAudioManager = (AudioManager) this.mContext.getSystemService(Context.AUDIO_SERVICE);
        float currentVolumeIndex = mAudioManager.getStreamVolume(streamType);
        float maxVolumeIndex = mAudioManager.getStreamMaxVolume(streamType);
        this.volume = currentVolumeIndex / maxVolumeIndex;
        ((Activity) this.mContext).setVolumeControlStream(streamType);
        AudioAttributes audioAttributes = new AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_GAME)
                .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                .build();
        this.mSoundPool = new SoundPool.Builder().setAudioAttributes(audioAttributes).setMaxStreams(MAX_STREAMS).build();

    }


    public int loadSound(int reId) {
        return  mSoundPool.load(mContext, reId, 1);
    }

    public void playSound(final int resId) {
        final float lefVolume = volume;
        final float rightVolume = volume;
        mSoundPool.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() {
            @Override
            public void onLoadComplete(SoundPool soundPool, int i, int i1) {
                mSoundPool.play(resId, lefVolume, rightVolume, 1, 0, 1f);
            }
        });
    }


}



