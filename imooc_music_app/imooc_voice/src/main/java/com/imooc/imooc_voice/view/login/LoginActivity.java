package com.imooc.imooc_voice.view.login;

import android.content.Context;
import android.content.Intent;
import android.icu.text.UnicodeSetSpanner;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.imooc.imooc_voice.R;
import com.imooc.imooc_voice.view.home.HomeActivity;
import com.imooc.imooc_voice.view.loading.LoadingActivity;
import com.imooc.imooc_voice.view.login.inter.IUserLoginView;
import com.imooc.imooc_voice.view.login.presenter.UserLoginPresenter;
import com.imooc.imooc_voice.view.register.RegisterActivity;
import com.imooc.lib_commin_ui.base.BaseActivity;

public class LoginActivity extends BaseActivity implements IUserLoginView {

    private UserLoginPresenter mUserLoginPresenter;
    private EditText mAccount;
    private EditText mPassWord;

    boolean isFirst = true;
    long time = 0;
    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 0:
                    isFirst = true;
                    break;
            }
        }
    };

    public static void start(Context context) {
        Intent intent = new Intent(context, LoginActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_layout);
        //初始化P层
        mUserLoginPresenter = new UserLoginPresenter(this);
        mAccount = findViewById(R.id.account);
        mPassWord = findViewById(R.id.password);
        findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mUserLoginPresenter.login(getUserName(), getPassword());
            }
        });
        findViewById(R.id.register_view).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RegisterActivity.start(LoginActivity.this);
            }
        });
    }

    @Override
    public String getUserName() {
        return mAccount.getText().toString().trim();
//        return "18734924592";
    }

    @Override
    public String getPassword() {
        return mPassWord.getText().toString().trim();
//        return "999999q";
    }

    @Override
    public void showLoadingView() {
        //显示加载中UI
    }

    @Override
    public void hideLoadingView() {
        //隐藏加载布局
    }

    @Override
    public void showLoginFailedView() {
        //登陆失败处理
    }

    @Override
    public void finishActivity() {
        startActivity(new Intent(this, HomeActivity.class));
        finish();
    }

    @Override
    public void onBackPressed() {
        if (isFirst){
            Toast.makeText(this,"再点击一次退出软件", Toast.LENGTH_SHORT).show();
            time = System.currentTimeMillis();
            isFirst = false;
            mHandler.sendEmptyMessageDelayed(0,2000);//超过2秒改回第一次点击
        }else{
            if(System.currentTimeMillis() -  time < 2000) {
                System.exit(0);
            }
        }
    }
}
