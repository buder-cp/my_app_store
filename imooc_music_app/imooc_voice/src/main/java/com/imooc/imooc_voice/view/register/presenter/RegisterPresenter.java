package com.imooc.imooc_voice.view.register.presenter;


import android.widget.Toast;

import com.imooc.imooc_voice.application.ImoocVoiceApplication;
import com.imooc.imooc_voice.view.register.SPUtil;
import com.imooc.imooc_voice.view.register.inter.IUserRegisterPresenter;
import com.imooc.imooc_voice.view.register.inter.IUserRegisterView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class RegisterPresenter implements IUserRegisterPresenter{

    private IUserRegisterView mIV;//持有Activity

    public RegisterPresenter(IUserRegisterView iv) {
        mIV = iv;
    }


    @Override
    public void register(String phone, String pwd,String pwda) {
        if (phone.isEmpty() || pwd.isEmpty() || pwda.isEmpty()){
            Toast.makeText(ImoocVoiceApplication.getInstance(),"请输入手机号码/密码",Toast.LENGTH_LONG).show();
           return;
        }
        if (!isChinaPhoneLegal(phone)){
            Toast.makeText(ImoocVoiceApplication.getInstance(),"请输入正确的手机号码",Toast.LENGTH_LONG).show();
            return;
        }
        if (pwd.length() < 6 || pwd.length() < 6){
            Toast.makeText(ImoocVoiceApplication.getInstance(),"请输入不低于6位密码",Toast.LENGTH_LONG).show();
            return;
        }
        if (!pwd.equals(pwda)){
            Toast.makeText(ImoocVoiceApplication.getInstance(),"两次密码不一致",Toast.LENGTH_LONG).show();
            return;
        }
        if (!SPUtil.getPhoneAndPwd(phone).isEmpty()){//有注册过的
            Toast.makeText(ImoocVoiceApplication.getInstance(),"该号码已经注册",Toast.LENGTH_LONG).show();
            return;
        }else{//没注册过的
            mIV.showLoadingView();
            SPUtil.setPhoneAndPwd(phone,pwd);
            Toast.makeText(ImoocVoiceApplication.getInstance(),"注册成功",Toast.LENGTH_LONG).show();
            //UI清除掉页面的数据并返回到首页
            mIV.hideLoadingView();
            mIV.finishActivity();
        }
    }



    public static boolean isChinaPhoneLegal(String str)
            throws PatternSyntaxException {
        String regExp = "^((13[0-9])|(15[^4])|(18[0-9])|(17[0-8])|(147,145))\\d{8}$";
        Pattern p = Pattern.compile(regExp);
        Matcher m = p.matcher(str);
        return m.matches();
    }

    @Override
    public void onDestory(){
        mIV = null;
    }

}
