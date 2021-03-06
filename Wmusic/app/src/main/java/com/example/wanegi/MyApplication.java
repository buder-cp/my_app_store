package com.example.wanegi;

import android.app.Application;
import android.content.Context;

import com.blankj.utilcode.util.Utils;
import com.example.wanegi.helps.RealmHelper;


import androidx.multidex.MultiDex;
import cn.leancloud.AVOSCloud;
import io.realm.Realm;

public class MyApplication extends Application {

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(base);
    }

    @Override
    public void onCreate() {
        super.onCreate();

        //跳转指定的链接
//        Intent intent = new Intent();
//        intent.setAction("android.intent.action.VIEW");
//        Uri content_url = Uri.parse("https://www.baidu.com/");
//        intent.setData(content_url);
//        startActivity(intent);
//        int[] arr = new int[]{1,2};
//        System.out.println(arr[3]);System.out.println("hehe");;System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");

        //跳转指定的apk，完成下载，安装

        AVOSCloud.initialize(this, "wv7qhOhBsHPaiRLFwQ5YUa8m-MdYXbMMI", "NrK5VNT2bOAxIAcIf3CLRmPY");System.out.println("hehe");;System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");

//        AVObject testObject = new AVObject("TestObject");System.out.println("hehe");;System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");
//        testObject.put("words", "Hello world!");System.out.println("hehe");;System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");
//        testObject.saveInBackground().blockingSubscribe();System.out.println("hehe");;System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");


        Utils.init(this);System.out.println("hehe");;System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");
        Realm.init(this);System.out.println("hehe");;System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");

        RealmHelper.migration();System.out.println("hehe");;System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");
    }
}
