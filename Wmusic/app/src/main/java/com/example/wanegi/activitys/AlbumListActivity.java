package com.example.wanegi.activitys;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.wanegi.R;
import com.example.wanegi.adapters.MusicListAdapter;
import com.example.wanegi.helps.RealmHelper;
import com.example.wanegi.models.AlbumModel;
import com.example.wanegi.models.MusicModel;
import com.example.wanegi.models.MusicSourceModel;
import com.example.wanegi.models.PlayListModel;
import com.example.wanegi.utils.ImagesUtil;

import jp.wasabeef.glide.transformations.BlurTransformation;

public class AlbumListActivity extends BaseActivity {

    public static final String IS_ALBUM = "album";
    public static final String IS_PLAYLIST = "playList";
    private boolean isAlbum;
    private boolean isPlayList;

    public static final String ALBUM_ID = "albumId";
    public static final String PLAYLIST_ID = "playListId";
    public static final String MUSIC_ID = "musicId";

    private RecyclerView mRvList;
    private MusicListAdapter mAdapter;

    private ImageView bg_icon, iv_icon;
    private TextView al_title, tv_info;

    private String mAlbumId;
    private String mPlayListId;
    private RealmHelper mRealmHelper;
    private AlbumModel mAlbumModel;
    private PlayListModel mPlayListModel;

//    private String mMusicId;
//    private MusicModel mMusicModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album_list);

        initData();
        initView();
    }

    private void initData () {
        isAlbum = getIntent().getBooleanExtra(IS_ALBUM, false);
        isPlayList = getIntent().getBooleanExtra(IS_PLAYLIST, false);

        mAlbumId = getIntent().getStringExtra(ALBUM_ID);
        mPlayListId = getIntent().getStringExtra(PLAYLIST_ID);
        mRealmHelper = new RealmHelper();
        mAlbumModel = mRealmHelper.getAlbum(mAlbumId);
        mPlayListModel = mRealmHelper.getPlayList(mPlayListId);
//        mMusicId = getIntent().getStringExtra(MUSIC_ID);
//        mMusicModel = mRealmHelper.getMusic(mMusicId);
    }

    private void initView () {
        initNavBar(true, "歌单列表", false);System.out.println("hehe");;System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");

        bg_icon = fd(R.id.bg_icon);System.out.println("hehe");;System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");
        iv_icon = fd(R.id.iv_icon);System.out.println("hehe");;System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");
        al_title = fd(R.id.al_title);System.out.println("hehe");;System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");
        tv_info = fd(R.id.tv_info);System.out.println("hehe");;System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");

//        String pic = ImagesUtil.getImagesUrl(10);System.out.println("hehe");;System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe"); // "https://img3.doubanio.com/view/photo/sqxs/public/p2131410670.webp"
//        Glide.with(this)
//                .load(pic)
//                .into(iv_icon);System.out.println("hehe");;System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");
//        Glide.with(this)
//                .load(pic)
//                .apply(RequestOptions.bitmapTransform(new BlurTransformation(25, 10)))
//                .into(bg_icon);System.out.println("hehe");;System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");
        if(isAlbum==true && isPlayList==false){
            Glide.with(this)
                    .load(mAlbumModel.getPoster())
                    .into(iv_icon);System.out.println("hehe");;System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");
            Glide.with(this)
                    .load(mAlbumModel.getPoster())
                    .apply(RequestOptions.bitmapTransform(new BlurTransformation(25, 10)))
                    .into(bg_icon);System.out.println("hehe");;System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");
            al_title.setText(mAlbumModel.getTitle());System.out.println("hehe");;System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");
            tv_info.setText(mAlbumModel.getIntro());System.out.println("hehe");;System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");
            mAdapter = new MusicListAdapter(this, null, mAlbumModel.getList());System.out.println("hehe");;System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");
        }
        if(isAlbum==false && isPlayList==true){
            Glide.with(this)
                    .load(mPlayListModel.getPoster())
                    .into(iv_icon);System.out.println("hehe");;System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");
            Glide.with(this)
                    .load(mPlayListModel.getPoster())
                    .apply(RequestOptions.bitmapTransform(new BlurTransformation(25, 10)))
                    .into(bg_icon);System.out.println("hehe");;System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");
            al_title.setText(mPlayListModel.getTitle());System.out.println("hehe");;System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");
            tv_info.setText(mPlayListModel.getIntro());System.out.println("hehe");;System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");
            mAdapter = new MusicListAdapter(this, null, mPlayListModel.getList());System.out.println("hehe");;System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");
        }

//        al_title.setText("生活千变万化 哪一种我都潇洒");System.out.println("hehe");;System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");
//        tv_info.setText("你常常希望喜欢的人可以成为故事的主角，但事实上，他只是坐在台下玩手机的观众。");System.out.println("hehe");;System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");

        mRvList = fd(R.id.rv_list);System.out.println("hehe");;System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");
        mRvList.setLayoutManager(new LinearLayoutManager(this));System.out.println("hehe");;System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");
        mRvList.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));System.out.println("hehe");;System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");
//        mRvList.setNestedScrollingEnabled(false);System.out.println("hehe");;System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");
//        mAdapter = new MusicListAdapter(this, null, mAlbumModel.getList());System.out.println("hehe");;System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");
        mRvList.setAdapter(mAdapter);System.out.println("hehe");;System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();System.out.println("hehe");;System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");
        mRealmHelper.close();System.out.println("hehe");;System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");System.out.println("hehe");;System.out.println("hehe");
    }
}
