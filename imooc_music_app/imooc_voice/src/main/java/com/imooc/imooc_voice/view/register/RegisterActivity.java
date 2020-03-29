package com.imooc.imooc_voice.view.register;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.imooc.imooc_voice.R;
import com.imooc.imooc_voice.view.register.inter.IUserRegisterView;
import com.imooc.imooc_voice.view.register.presenter.RegisterPresenter;
import com.imooc.lib_commin_ui.base.BaseActivity;

public class RegisterActivity extends BaseActivity implements IUserRegisterView {

    private RegisterPresenter mRegiserPresenter ;
    private EditText accountEditText;
    private EditText passwordEditText;
    private EditText passwordAgainEditText;
    public static void start(Context context) {
        Intent intent = new Intent(context, RegisterActivity.class);
        context.startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mRegiserPresenter = new RegisterPresenter(this);
        accountEditText = findViewById(R.id.account);
        passwordEditText= findViewById(R.id.password);
        passwordAgainEditText= findViewById(R.id.password_again);
        findViewById(R.id.register_view).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mRegiserPresenter.register(accountEditText.getText().toString().trim(),
                        passwordEditText.getText().toString().trim(),passwordAgainEditText.getText().toString().trim());
            }
        });
        findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             finish();
            }
        });
    }

    @Override
    public String getUserName() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public void finishActivity() {

    }

    @Override
    public void showLoginFailedView() {

    }

    @Override
    public void showLoadingView() {

    }

    @Override
    public void hideLoadingView() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mRegiserPresenter.onDestory();
    }
}
