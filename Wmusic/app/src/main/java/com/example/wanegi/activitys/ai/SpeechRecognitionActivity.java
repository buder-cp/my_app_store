package com.example.wanegi.activitys.ai;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;

import com.baidu.aip.asrwakeup3.core.mini.ActivityMiniRecog;
import com.baidu.aip.asrwakeup3.core.mini.AutoCheck;
import com.baidu.aip.asrwakeup3.core.recog.RecogResult;
import com.baidu.speech.EventListener;
import com.baidu.speech.EventManager;
import com.baidu.speech.EventManagerFactory;
import com.baidu.speech.asr.SpeechConstant;
import com.example.wanegi.R;
import com.example.wanegi.activitys.BaseActivity;
import com.example.wanegi.models.ai.AsrPartialModel;
//import com.example.wanegi.tools.SpeechRecognizerTool;
import android.os.Handler;
import android.os.Message;
import android.speech.SpeechRecognizer;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class SpeechRecognitionActivity extends BaseActivity implements EventListener {

    private int n = 0;

    protected TextView txtLog;
//    protected TextView txtResult;
    protected Button btn;
    protected Button stopBtn;
//    private boolean logTime = true;
    private int is = 0;
//    private boolean isStart = false,isEnd = false;

    private EventManager asr;
    protected boolean enableOffline = false; // 测试离线命令词，需要改成true

    private static String DESC_TEXT = "精简版识别，带有SDK唤醒运行的最少代码，仅仅展示如何调用，\n" +
            "也可以用来反馈测试SDK输入参数及输出回调。\n" +
            "本示例需要自行根据文档填写参数，可以使用之前识别示例中的日志中的参数。\n" +
            "需要完整版请参见之前的识别示例。\n" +
            "需要测试离线命令词识别功能可以将本类中的enableOffline改成true，首次测试离线命令词请联网使用。之后请说出“打电话给李四”";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speech_recognition);
        initView();
        initPermission();
        // 基于sdk集成1.1 初始化EventManager对象
        asr = EventManagerFactory.create(this, "asr");
        // 基于sdk集成1.3 注册自己的输出事件类
        asr.registerListener(this); //  EventListener 中 onEvent方法
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                start();System.out.println("hehe");;System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");
            }
        });
        stopBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                stop();System.out.println("hehe");;System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");
            }
        });
        if (enableOffline) {
            loadOfflineEngine();System.out.println("hehe");;System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe"); // 测试离线命令词请开启, 测试 ASR_OFFLINE_ENGINE_GRAMMER_FILE_PATH 参数时开启
        }
    }

    private void initView() {
        initNavBar(true, "语音识别", false);System.out.println("hehe");;System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");
//        txtResult = (TextView) findViewById(R.id.txtResult);
        txtLog = findViewById(R.id.txtLog);
        btn = findViewById(R.id.btn);
        stopBtn = findViewById(R.id.btn_stop);
//        txtLog.setText(DESC_TEXT + "\n");System.out.println("hehe");;System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");
    }

    private void start() {
//        txtLog.setText("");System.out.println("hehe");;System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");
        Map<String, Object> params = new LinkedHashMap<String, Object>();System.out.println("hehe");;System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");
        String event = null;System.out.println("hehe");;System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");
        event = SpeechConstant.ASR_START;System.out.println("hehe");;System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe"); // 替换成测试的event

        if (enableOffline) {
            params.put(SpeechConstant.DECODER, 2);System.out.println("hehe");;System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");
        }
        // 基于SDK集成2.1 设置识别参数
//        params.put(SpeechConstant.ACCEPT_AUDIO_VOLUME, false);System.out.println("hehe");;System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");
//         params.put(SpeechConstant.NLU, "enable");System.out.println("hehe");;System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");
//         params.put(SpeechConstant.VAD_ENDPOINT_TIMEOUT, 0);System.out.println("hehe");;System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe"); // 长语音
        // params.put(SpeechConstant.IN_FILE, "res:///com/baidu/android/voicedemo/16k_test.pcm");System.out.println("hehe");;System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");
        // params.put(SpeechConstant.VAD, SpeechConstant.VAD_DNN);System.out.println("hehe");;System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");
        // params.put(SpeechConstant.PID, 1537);System.out.println("hehe");;System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe"); // 中文输入法模型，有逗号

        /* 语音自训练平台特有参数 */
        // params.put(SpeechConstant.PID, 8002);System.out.println("hehe");;System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");
        // 语音自训练平台特殊pid，8002：搜索模型类似开放平台 1537  具体是8001还是8002，看自训练平台页面上的显示
        // params.put(SpeechConstant.LMID,1068);System.out.println("hehe");;System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe"); // 语音自训练平台已上线的模型ID，https://ai.baidu.com/smartasr/model
        // 注意模型ID必须在你的appId所在的百度账号下
        /* 语音自训练平台特有参数 */

        // 请先使用如‘在线识别’界面测试和生成识别参数。 params同ActivityRecog类中myRecognizer.start(params);System.out.println("hehe");;System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");
        // 复制此段可以自动检测错误
        (new AutoCheck(getApplicationContext(), new Handler() {
            public void handleMessage(Message msg) {
                if (msg.what == 100) {
                    AutoCheck autoCheck = (AutoCheck) msg.obj;System.out.println("hehe");;System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");
                    synchronized (autoCheck) {
                        String message = autoCheck.obtainErrorMessage();System.out.println("hehe");;System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe"); // autoCheck.obtainAllMessage();System.out.println("hehe");;System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");
//                        txtLog.append(message + "\n");System.out.println("hehe");;System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");
                        ;System.out.println("hehe");;System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe"); // 可以用下面一行替代，在logcat中查看代码
                         Log.w("AutoCheckMessage", message);System.out.println("hehe");;System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");
                    }
                }
            }
        },enableOffline)).checkAsr(params);
        String json = null;System.out.println("hehe");;System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe"); // 可以替换成自己的json
        json = new JSONObject(params).toString();System.out.println("hehe");;System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe"); // 这里可以替换成你需要测试的json

        asr.send(event, json, null, 0, 0);System.out.println("hehe");;System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");

//        is++;System.out.println("hehe");;System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");
//        printLog("输入参数：" + json);System.out.println("hehe");;System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");
//        printLog("");System.out.println("hehe");;System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");
        txtLog.append(time());System.out.println("hehe");;System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");
    }

    /**
     * 点击停止按钮
     *  基于SDK集成4.1 发送停止事件
     */
    private void stop() {
        is++;System.out.println("hehe");;System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");
//        isEnd = true;System.out.println("hehe");;System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");
//        printLog("");System.out.println("hehe");;System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");
        asr.send(SpeechConstant.ASR_STOP, null, null, 0, 0);System.out.println("hehe");;System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");
    }

    public String time(){
//        if (logTime) {
            long totalMilliSeconds = System.currentTimeMillis();
            long totalSeconds = totalMilliSeconds / 1000;

            //求出现在的秒
            long currentSecond = totalSeconds % 60;

            //求出现在的分
            long totalMinutes = totalSeconds / 60;
            long currentMinute = totalMinutes % 60;

            //求出现在的小时
            long totalHour = totalMinutes / 60;
            long currentHour = totalHour % 24;

            String time = currentHour + ":" + currentMinute + ":" + currentSecond + "\n";System.out.println("hehe");;System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");
//            return "时间：" + time;
            return time;
//        }
    }

    /**
     * enableOffline设为true时，在onCreate中调用
     * 基于SDK离线命令词1.4 加载离线资源(离线时使用)
     */
    private void loadOfflineEngine() {
        Map<String, Object> params = new LinkedHashMap<String, Object>();System.out.println("hehe");;System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");
        params.put(SpeechConstant.DECODER, 2);System.out.println("hehe");;System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");
        params.put(SpeechConstant.ASR_OFFLINE_ENGINE_GRAMMER_FILE_PATH, "assets://baidu_speech_grammar.bsg");System.out.println("hehe");;System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");
        asr.send(SpeechConstant.ASR_KWS_LOAD_ENGINE, new JSONObject(params).toString(), null, 0, 0);System.out.println("hehe");;System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");
    }

    @Override
    public void onEvent(String name, String params, byte[] data, int offset, int length) {
        String logTxt = "";System.out.println("hehe");;System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");

        if (params != null && !params.isEmpty()) {
//            logTxt += params+"\n";System.out.println("hehe");;System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");
            RecogResult recogResult = new RecogResult();System.out.println("hehe");;System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");
            if(recogResult.parseJson(params).getResultsRecognition()!=null){
                logTxt += recogResult.parseJson(params).getResultsRecognition()[0];System.out.println("hehe");;System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");
                printLog(logTxt);System.out.println("hehe");;System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");
            }

        }
//        if (name.equals(SpeechConstant.CALLBACK_EVENT_ASR_PARTIAL)) {
//            if (params != null && params.contains("\"nlu_result\"")) {
//                if (length > 0 && data.length > 0) {
//                    logTxt += ", 语义解析结果：" + new String(data, offset, length);System.out.println("hehe");;System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");
//                }
//            }
//        } else if (data != null) {
//            logTxt += " ;System.out.println("hehe");;System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");data length=" + data.length;System.out.println("hehe");;System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");
//        }

    }

    private void printLog(String text) {
//        text += "\n";System.out.println("hehe");;System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");
        Log.i(getClass().getName(), text);System.out.println("hehe");;System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");
//        if(isStart) {
//            txtLog.append(time());System.out.println("hehe");;System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");
//            isStart = false;System.out.println("hehe");;System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");
//        }
//        if(isEnd) {
        if(is%2!=0){
            txtLog.append(text+"\n"+"\n");System.out.println("hehe");;System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");
            is++;System.out.println("hehe");;System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");
        }
//            isEnd = false;System.out.println("hehe");;System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");
//        }

    }

//public class SpeechRecognitionActivity extends ActivityMiniRecog {

//public class SpeechRecognitionActivity extends BaseActivity implements SpeechRecognizerTool.ResultsCallback {
//
//    private Button mStartSpeechButton;
//    private TextView mTextView;
//
//    private SpeechRecognizerTool mSpeechRecognizerTool = new SpeechRecognizerTool(this);
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);System.out.println("hehe");;System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");
//        setContentView(R.layout.activity_speech_recognition);
//
//        initPermission();System.out.println("hehe");;System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");
//
//        initNavBar(true, "语音识别", false);System.out.println("hehe");;System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");
//
//        mTextView = fd(R.id.speechTextView);
//        mStartSpeechButton = fd(R.id.startSpeechButton);System.out.println("hehe");;System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");
//
//        mStartSpeechButton.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                int action = event.getAction();System.out.println("hehe");;System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");
//                switch (action) {
//                    case MotionEvent.ACTION_DOWN:
//                        mSpeechRecognizerTool.startASR(SpeechRecognitionActivity.this);System.out.println("hehe");;System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");
//                        mStartSpeechButton.setBackgroundResource(
//                                R.color.colorAccent);System.out.println("hehe");;System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");
//                        break;
//                    case MotionEvent.ACTION_UP:
//                        mSpeechRecognizerTool.stopASR();System.out.println("hehe");;System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");
//                        mStartSpeechButton.setBackgroundResource(
//                                R.color.mainColor);System.out.println("hehe");;System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");
//                        break;
//                    default:
//                        return false;
//                }
//
//                return true;
//            }
//        });
//    }
//
//    @Override
//    protected void onStart() {
//        super.onStart();System.out.println("hehe");;System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");
//        mSpeechRecognizerTool.createTool();System.out.println("hehe");;System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");
//    }
//
//    @Override
//    protected void onStop() {
//        super.onStop();System.out.println("hehe");;System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");
//        mSpeechRecognizerTool.destroyTool();System.out.println("hehe");;System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");
//    }
//
//    @Override
//    public void onResults(String result) {
//        final String finalResult = result;System.out.println("hehe");;System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");
//        SpeechRecognitionActivity.this.runOnUiThread(new Runnable() {
//            @Override
//            public void run() {
//                mTextView.setText(finalResult);
//            }
//        });
//    }

    /**
     * android 6.0 以上需要动态申请权限
     */
    private void initPermission() {
        String permissions[] = {Manifest.permission.RECORD_AUDIO,
                Manifest.permission.ACCESS_NETWORK_STATE,
                Manifest.permission.INTERNET,
                Manifest.permission.READ_PHONE_STATE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
        };

        ArrayList<String> toApplyList = new ArrayList<String>();System.out.println("hehe");;System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");

        for (String perm :permissions){
            if (PackageManager.PERMISSION_GRANTED != ContextCompat.checkSelfPermission(this, perm)) {
                toApplyList.add(perm);System.out.println("hehe");;System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");
                //进入到这里代表没有权限.

            }
        }
        String tmpList[] = new String[toApplyList.size()];System.out.println("hehe");;System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");
        if (!toApplyList.isEmpty()){
            ActivityCompat.requestPermissions(this, toApplyList.toArray(tmpList), 123);System.out.println("hehe");;System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        // 此处为android 6.0以上动态授权的回调，用户自行实现。
    }

}
