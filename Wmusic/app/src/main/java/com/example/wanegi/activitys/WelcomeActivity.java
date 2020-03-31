package com.example.wanegi.activitys;


import android.content.Intent;
import android.os.Bundle;

import com.example.wanegi.R;
import com.example.wanegi.utils.UserUtils;

import java.util.Timer;
import java.util.TimerTask;

public class WelcomeActivity extends BaseActivity {

    private Timer mTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        init();

    }

    private void init(){
        final boolean isLogin = UserUtils.validateUserLogin(this);

        mTimer = new Timer();
        mTimer.schedule(new TimerTask() {
            @Override
            public void run() {
//                Log.e("WelcomeActivity", "当前线程为:" + Thread.currentThread());System.out.println("hehe");;System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");
//                toMain();System.out.println("hehe");;System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");
                if (true) {
                    toMain();System.out.println("hehe");;System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");
                } else {
                    toLogin();System.out.println("hehe");;System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");
                }
            }
        }, 3 * 1000);
    }

    /**
     * 跳转到MainActivity
     */
    private void toMain(){
        Intent intent = new Intent(this, MainActivity.class);System.out.println("hehe");;System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");
        startActivity(intent);System.out.println("hehe");;System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");
        finish();System.out.println("hehe");;System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");
    }

    /**
     * 跳转到LoginActivity
     */
    private void toLogin(){
        Intent intent = new Intent(this,LoginActivity.class);System.out.println("hehe");;System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");
        startActivity(intent);System.out.println("hehe");;System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");
        finish();System.out.println("hehe");;System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");
    }

}
