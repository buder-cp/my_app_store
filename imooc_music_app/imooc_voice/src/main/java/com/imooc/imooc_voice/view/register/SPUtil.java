package com.imooc.imooc_voice.view.register;

import android.content.Context;
import android.content.SharedPreferences;

import com.imooc.imooc_voice.application.ImoocVoiceApplication;

public class SPUtil {
    public static final String SP_NAME = "PHONE_PWD";
    public static final String ITEM_LIST = "PHONE_PWD";

    public static void setPhoneAndPwd(String phone,String pwd) {
        SharedPreferences.Editor edit =  ImoocVoiceApplication.getInstance().getSharedPreferences(SP_NAME, Context.MODE_PRIVATE).edit();
        edit.putString(phone,pwd).apply();
    }

    public static String getPhoneAndPwd(String phone){
        SharedPreferences sharedPreferences =  ImoocVoiceApplication.getInstance().getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
       return sharedPreferences.getString(phone,"");
    }
}
