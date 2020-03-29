package com.imooc.imooc_voice.view.music;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.imooc.imooc_voice.R;
import com.imooc.lib_audio.mediaplayer.core.AudioController;
import com.imooc.lib_audio.mediaplayer.view.MusicPlayerActivity;
import com.imooc.lib_image_loader.app.ImageLoaderManager;

import java.util.List;

import javax.sql.ConnectionPoolDataSource;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MusicListAdapter extends RecyclerView.Adapter<MusicListAdapter.ViewHolder> {

    private Context mContext;
    private View mItemView;
    private RecyclerView mRv;
    private boolean isCalcaulationRvHeight;
    private List<MusicModel> mDataSource;
    private int n = 1;

    public MusicListAdapter(Context context, RecyclerView recyclerView, List<MusicModel> dataSource) {
        mContext = context;
        mRv = recyclerView;
        this.mDataSource = dataSource;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if(mRv != null) mItemView = LayoutInflater.from(mContext).inflate(R.layout.item_list_music, viewGroup, false);
        else mItemView = LayoutInflater.from(mContext).inflate(R.layout.album_list_music, viewGroup, false);
        return new ViewHolder(mItemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int position) {
        setRecyclerViewHeight();
        if(mRv != null){
            ImageLoaderManager.getInstance().displayImageForView(viewHolder.ivIcon, "https://img1.mukewang.com/533e4d660001312002000200-100-100.jpg");
        }else{

//            for(int k = 0;k<listCount;k++){
//            String nn = String.valueOf(n++);
////            i++;
//            viewHolder.tvNum.setText(nn);
//                n++;
//            }
        }
        viewHolder.tvNum.setText(String.valueOf(position + 1));
        if (position == 0) {
            viewHolder.tvName.setText("七里香");
            viewHolder.tvAuthor.setText("周杰伦");
        } else if (position == 1) {
            viewHolder.tvName.setText("勇气");
            viewHolder.tvAuthor.setText("梁静茹");
        } else if (position == 2) {
            viewHolder.tvName.setText("春天里");
            viewHolder.tvAuthor.setText("汪峰");
        } else if (position == 3) {
            viewHolder.tvName.setText("小幸运");
            viewHolder.tvAuthor.setText("五月天");
        } else if (position == 4) {
            viewHolder.tvName.setText("七里香");
            viewHolder.tvAuthor.setText("周杰伦");
        } else if (position == 5) {
            viewHolder.tvName.setText("勇气");
            viewHolder.tvAuthor.setText("梁静茹");
        } else if (position == 6) {
            viewHolder.tvName.setText("春天里");
            viewHolder.tvAuthor.setText("汪峰");
        } else if (position == 7) {
            viewHolder.tvName.setText("小幸运");
            viewHolder.tvAuthor.setText("五月天");
        }

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //点击播放音乐
                MusicPlayerActivity.start((Activity) mContext);


                if (position == 0 || position == 4) {
                    AudioController.getInstance().playPosition(0);
                }
                if (position == 1 || position == 5) {
                    AudioController.getInstance().playPosition(1);
                }
                if (position == 2 || position == 6) {
                    AudioController.getInstance().playPosition(2);
                }
                if (position == 3 || position == 7) {
                    AudioController.getInstance().playPosition(3);
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return mDataSource.size();
    }

    /**
     * 1、获取ItemView的高度
     * 2、itemView的数量
     * 3、使用 itemViewHeight * itemViewNum = RecyclerView的高度
     */
    private void setRecyclerViewHeight () {

        if (isCalcaulationRvHeight || mRv == null) return;
//        Log.i("MusicListAdapter", isCalcaulationRvHeight + ":" + mRv);
        isCalcaulationRvHeight = true;

//        获取ItemView的高度
        RecyclerView.LayoutParams itemViewLp = (RecyclerView.LayoutParams) mItemView.getLayoutParams();
//        itemView的数量
        int itemCount = getItemCount();
//        使用 itemViewHeight * itemViewNum = RecyclerView的高度
        int recyclerViewHeight = itemViewLp.height * itemCount;
//        设置RecyclerView高度
        LinearLayout.LayoutParams rvLp = (LinearLayout.LayoutParams) mRv.getLayoutParams();
        rvLp.height = recyclerViewHeight;
        mRv.setLayoutParams(rvLp);
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        View itemView;
        ImageView ivIcon;
        TextView tvName, tvAuthor, tvNum;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemView = itemView;
            ivIcon = itemView.findViewById(R.id.iv_icon);
            tvName = itemView.findViewById(R.id.tv_name);
            tvAuthor = itemView.findViewById(R.id.tv_author);
            tvNum = itemView.findViewById(R.id.tv_num);
        }
    }
}
