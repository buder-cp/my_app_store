package com.imooc.imooc_voice.view.register.inter;
/**
 * UI层对外提供的方法
 */
public interface IUserRegisterView {
    String getUserName();

    String getPassword();

    void finishActivity();

    void showLoginFailedView();

    void showLoadingView();

    void hideLoadingView();
}
