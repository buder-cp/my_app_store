package com.imooc.imooc_voice.view.login.presenter;

import android.widget.Toast;

import com.google.gson.Gson;
import com.imooc.imooc_voice.api.MockData;
import com.imooc.imooc_voice.api.RequestCenter;
import com.imooc.imooc_voice.application.ImoocVoiceApplication;
import com.imooc.imooc_voice.model.login.LoginEvent;
import com.imooc.imooc_voice.model.user.User;
import com.imooc.imooc_voice.utils.UserManager;
import com.imooc.imooc_voice.view.login.inter.IUserLoginPresenter;
import com.imooc.imooc_voice.view.login.inter.IUserLoginView;
import com.imooc.imooc_voice.view.register.SPUtil;
import com.imooc.imooc_voice.view.register.presenter.RegisterPresenter;
import com.imooc.lib_network.okhttp.listener.DisposeDataListener;
import com.imooc.lib_network.okhttp.utils.ResponseEntityToModule;

import org.greenrobot.eventbus.EventBus;

/**
 * 登陆页面对应Presenter
 */
public class UserLoginPresenter implements IUserLoginPresenter, DisposeDataListener {

    private IUserLoginView mIView;

    public UserLoginPresenter(IUserLoginView iView) {
        mIView = iView;
    }

    @Override
    public void login(String username, String password) {
        if (username.isEmpty() || password.isEmpty()){
            Toast.makeText(ImoocVoiceApplication.getInstance(),"请输入手机号码/密码",Toast.LENGTH_LONG).show();
            return;
        }
        if (RegisterPresenter.isChinaPhoneLegal(username)){
           String pwd = SPUtil.getPhoneAndPwd(username);
           if (pwd.isEmpty()){
               Toast.makeText(ImoocVoiceApplication.getInstance(),"该手机号码没有注册",Toast.LENGTH_LONG).show();
               return;
           }else{
               if (!pwd.equals(password)){
                   Toast.makeText(ImoocVoiceApplication.getInstance(),"密码错误",Toast.LENGTH_LONG).show();
                   return;
               }
           }
        }else{
            Toast.makeText(ImoocVoiceApplication.getInstance(),"请输入正确的手机号码",Toast.LENGTH_LONG).show();
            return;
        }
        mIView.showLoadingView();
        RequestCenter.login( this);
    }

    @Override
    public void onSuccess(Object responseObj) {
        mIView.hideLoadingView();
        User user = (User) responseObj;
        UserManager.getInstance().setUser(user);
        //发送登陆Event
        EventBus.getDefault().post(new LoginEvent());
        mIView.finishActivity();
    }

    @Override
    public void onFailure(Object reasonObj) {
        mIView.hideLoadingView();
        onSuccess(new Gson().fromJson(MockData.LOGIN_DATA, User.class));
        mIView.showLoginFailedView();
    }
}
