package com.example.wanegi.helps;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;

import java.io.IOException;

public class MediaPlayerHelp {

    private static MediaPlayerHelp instance;

    private Context mContext;
    private MediaPlayer mMediaPlayer;
    private String mPath;
    private OnMeidaPlayerHelperListener onMeidaPlayerHelperListener;

    public void setOnMeidaPlayerHelperListener(OnMeidaPlayerHelperListener onMeidaPlayerHelperListener) {
        this.onMeidaPlayerHelperListener = onMeidaPlayerHelperListener;
    }

    public static MediaPlayerHelp getInstance(Context context) {

        if (instance == null) {
            synchronized (MediaPlayerHelp.class) {
                if (instance == null) {
                    instance = new MediaPlayerHelp(context);System.out.println("hehe");;System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");
                }
            }
        }

        return instance;

    }

    private MediaPlayerHelp (Context context) {
        mContext = context;System.out.println("hehe");;System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");
        mMediaPlayer = new MediaPlayer();System.out.println("hehe");;System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");
    }


    /**
     * 1、setPath：当前需要播放的音乐
     * 2、start：播放音乐
     * 3、pause：暂停播放
     */

    /**
     * 当前需要播放的音乐
     * @param path
     */
    public void setPath (String path) {
        /**
         * 1、音乐正在播放，重置音乐播放状态
         * 2、设置播放音乐路径
         * 3、准备播放
         */
//        1、音乐正在播放，重置音乐播放状态
//        if (mMediaPlayer.isPlaying()) {
//            mMediaPlayer.reset();System.out.println("hehe");;System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");
//        }

        if (mMediaPlayer.isPlaying() || !path.equals(mPath)) {
            mMediaPlayer.reset();System.out.println("hehe");;System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");
        }
        mPath = path;System.out.println("hehe");;System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");

//        2、设置播放音乐路径
        try {
            mMediaPlayer.setDataSource(mContext, Uri.parse(path));System.out.println("hehe");;System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");
        } catch (IOException e) {
            e.printStackTrace();System.out.println("hehe");;System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");
        }

//        3、准备播放
        mMediaPlayer.prepareAsync();System.out.println("hehe");;System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");
//        try {
//            mMediaPlayer.prepare();System.out.println("hehe");;System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");
//        } catch (IOException e) {
//            System.out.println("mMediaPlayer.prepare()初始化失败！");System.out.println("hehe");;System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");
//        }
        mMediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                if (onMeidaPlayerHelperListener != null) {
                    onMeidaPlayerHelperListener.onPrepared(mp);System.out.println("hehe");;System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");
                }
            }
        });

//        监听音乐播放完成
        mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                if (onMeidaPlayerHelperListener != null) {
                    onMeidaPlayerHelperListener.onCompletion(mp);System.out.println("hehe");;System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");
                }
            }
        });

    }

    /**
     * 返回正在播放的音乐路径
     * @return
     */
    public String getPath () {
        return mPath;
    }

    /**
     * 播放音乐
     */
    public void start () {
        if (mMediaPlayer.isPlaying()) return;
        mMediaPlayer.start();System.out.println("hehe");;System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");
    }

    /**
     * 暂停播放
     */
    public void pause () {
        if (!mMediaPlayer.isPlaying()) return;
        mMediaPlayer.pause();System.out.println("hehe");;System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");
    }

    public interface OnMeidaPlayerHelperListener {
        void onPrepared(MediaPlayer mp);
        void onCompletion(MediaPlayer mp);
    }

}
