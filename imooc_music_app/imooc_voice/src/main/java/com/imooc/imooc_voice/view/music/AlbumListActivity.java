package com.imooc.imooc_voice.view.music;


import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.imooc.imooc_voice.R;
import com.imooc.lib_commin_ui.base.BaseActivity;
import com.imooc.lib_image_loader.app.ImageLoaderManager;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class AlbumListActivity extends BaseActivity {

    private RecyclerView mRvList;
    private MusicListAdapter mAdapter;

    private ImageView bg_icon, iv_icon;
    private TextView al_title, tv_info;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album_list);
        initView();
    }

    private void initView () {
        bg_icon = findViewById(R.id.bg_icon);
        iv_icon = findViewById(R.id.iv_icon);
        al_title = findViewById(R.id.al_title);
        tv_info = findViewById(R.id.tv_info);

        ImageLoaderManager.getInstance().displayImageForView(iv_icon, "https://img1.mukewang.com/533e4d660001312002000200-100-100.jpg");
        ImageLoaderManager.getInstance().displayImageForView(bg_icon, "https://img1.mukewang.com/533e4d660001312002000200-100-100.jpg");
        al_title.setText("生活千变万化 哪一种我都潇洒");
        tv_info.setText("你常常希望喜欢的人可以成为故事的主角，但事实上，他只是坐在台下玩手机的观众。");

        mRvList = findViewById(R.id.rv_list);
        mRvList.setLayoutManager(new LinearLayoutManager(this));
        mRvList.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
//        mRvList.setNestedScrollingEnabled(false);
        mAdapter = new MusicListAdapter(this, null, getAlbumList());
        mRvList.setAdapter(mAdapter);
    }

    private List<MusicModel> getAlbumList() {
        List<MusicModel> list = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            MusicModel model = new MusicModel();
            model.setAuthor("buder");
            model.setMusicId("111");
            model.setName("buder");
            model.setPath("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1559698076304&di=e6e99aa943b72ef57b97f0be3e0d2446&imgtype=0&src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fblog%2F201401%2F04%2F20140104170315_XdG38.jpeg");
            model.setPoster("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1559698076304&di=e6e99aa943b72ef57b97f0be3e0d2446&imgtype=0&src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fblog%2F201401%2F04%2F20140104170315_XdG38.jpeg");
            list.add(model);
        }
        return list;
    }

}
