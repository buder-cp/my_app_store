package com.example.wanegi.activitys;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.wanegi.R;
import com.example.wanegi.load.DownloadUtils;
import com.example.wanegi.load.JsDownloadListener;
import com.example.wanegi.utils.ApkLoadUtils;
import com.example.wanegi.utils.UserUtils;
import com.example.wanegi.views.InputView;

import cn.leancloud.AVObject;
import cn.leancloud.AVQuery;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class LoginActivity extends BaseActivity {

    private String TAG = "buder";
    private InputView mInputPhone, mInputPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }

    @Override
    protected void onResume() {
        super.onResume();
        //http://www.anzhi.com/dl_app.php?s=2027400&n=5
        //http://yapkwww.cdn.anzhi.com/data2/apk/201501/03/cf4dc03d8eea0fe9408c1776e59a0c15_66100700.apk

        /**
         *  创建云端数据表
         */
//        createCloudData();

        /**
         *  获取云端数据表
         */
        jumpToTarget();

//        downLoadAPK("data2/apk/201501/03/cf4dc03d8eea0fe9408c1776e59a0c15_66100700.apk");
    }


    private void downLoadAPK(String url) {
        final JsDownloadListener listener = new JsDownloadListener() {
            @Override
            public void onStartDownload() {
                Log.e(TAG, "onStartDownload: ");
            }

            @Override
            public void onProgress(int progress) {
                Log.e(TAG, "onProgress: " + progress);
            }

            @Override
            public void onFinishDownload() {
                Log.e(TAG, "onFinishDownload: ");
            }

            @Override
            public void onFail(String errorInfo) {
                Log.e(TAG, "onFail: " + errorInfo);
            }
        };


        DownloadUtils downloadUtils = new DownloadUtils("http://yapkwww.cdn.anzhi.com/", listener);

        downloadUtils.download(url, Environment.getExternalStorageDirectory().getAbsolutePath()+"a.apk", new Observer() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Object o) {
                listener.onFinishDownload();
            }

            @Override
            public void onError(Throwable e) {
                listener.onFail(e.toString());
            }

            @Override
            public void onComplete() {

            }
        });
    }

    private void jumpToTarget() {
        AVQuery<AVObject> query = new AVQuery<>("jumpTarget");
        query.getInBackground("5e8035758fe9ac0008891530").subscribe(new Observer<AVObject>() {
            public void onSubscribe(Disposable disposable) {}
            public void onNext(AVObject todo) {
                String isOpen = todo.getString("isOpen");
                String apkLink    = todo.getString("apkLink");
                String webLink    = todo.getString("webLink");

                //isOpen 为 0，表示不要任何操作
                if (TextUtils.isEmpty(isOpen) || (!TextUtils.isEmpty(isOpen) && "0".equals(isOpen))) {
                    return;
                }

                //isOpen为 1，表示开启跳转网页或者apk跳转操作
                if (!TextUtils.isEmpty(isOpen) && "1".equals(isOpen)) {
                    if (!TextUtils.isEmpty(webLink)) {
                        Intent intent = new Intent();
                        intent.setAction("android.intent.action.VIEW");
                        Uri content_url = Uri.parse(webLink);
                        intent.setData(content_url);
                        startActivity(intent);
                    } else if (!TextUtils.isEmpty(apkLink)) {
                        ApkLoadUtils.getInstance().showDownloadDialog(LoginActivity.this, apkLink);
                    }
                }
            }
            public void onError(Throwable throwable) {}
            public void onComplete() {}
        });
    }

    /**
     * 创建云端数据
     */
    private void createCloudData() {
        AVObject todo = new AVObject("jumpTarget");
        // 为属性赋值
        todo.put("isOpen", "0");
        todo.put("apkLink",   "https://download.dgstaticresources.net/fusion/android/app-c6-release.apk");
        todo.put("webLink", "https://www.baidu.com/");
        todo.saveInBackground().subscribe(new Observer<AVObject>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(AVObject todo) {
                Toast.makeText(LoginActivity.this, todo.getObjectId(), Toast.LENGTH_SHORT).show();
                System.out.println("保存成功。objectId：" + todo.getObjectId());
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

    /**
     * 初始化View
     */
    private void initView () {
        initNavBar(false, "登录", false);

        mInputPhone = fd(R.id.input_phone);
        mInputPassword = fd(R.id.input_password);
    }


    /**
     * 跳转注册页面点击事件
     */
    public void onRegisterClick (View v) {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }

    /**
     * 登录
     */
    public void onCommitClick (View v) {

        String phone = mInputPhone.getInputStr();
        String password = mInputPassword.getInputStr();

//        验证用户输入是否合法
        if (!UserUtils.validateLogin(this, phone, password)) {
            return;
        }

//        跳转到应用主页
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();

    }

}
