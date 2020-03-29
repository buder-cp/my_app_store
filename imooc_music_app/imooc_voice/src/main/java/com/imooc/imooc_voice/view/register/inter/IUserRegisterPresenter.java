package com.imooc.imooc_voice.view.register.inter;

/**
 * Presenter层对外提供的方法
 */
public interface IUserRegisterPresenter {
     void register(String phone , String pwd,String pwda );
     void onDestory();
}
