package criminalintent.com.example.lenovo.schedule;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.daimajia.numberprogressbar.NumberProgressBar;

import java.util.List;

import criminalintent.com.example.lenovo.schedule.Data.Projects;

/**
 * Created by lenovo on 2017/11/28.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ProjectsViewHolder> {

    private List<Projects> mProjectses;
    private Context mContext;

    public RecyclerViewAdapter(List<Projects> projectses , Context context){
        this.mProjectses = projectses;
        this.mContext = context;
    }

    static class ProjectsViewHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        ImageView imageView;
        TextView newsTitle;
        TextView newsDesc;
        Button share;
        Button readMore;
        NumberProgressBar mNumberProgressBar;

        public ProjectsViewHolder(final View itemView){
            super(itemView);
            cardView= (CardView) itemView.findViewById(R.id.card_view);
            imageView= (ImageView) itemView.findViewById(R.id.news_photo);
            newsTitle = (TextView) itemView.findViewById(R.id.news_title);
            newsDesc = (TextView) itemView.findViewById(R.id.news_desc);
            share= (Button) itemView.findViewById(R.id.btn_share);
            readMore= (Button) itemView.findViewById(R.id.btn_more);
            //设置TextView背景为半透明
            newsTitle.setBackgroundColor(Color.argb(20, 0, 0, 0));
            mNumberProgressBar=(NumberProgressBar) itemView.findViewById(R.id.projectsProgress);
        }
    }

    @Override
    public RecyclerViewAdapter.ProjectsViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v= LayoutInflater.from(mContext).inflate(R.layout.project_item,viewGroup,false);
        ProjectsViewHolder projectsViewHolder=new ProjectsViewHolder(v);
        return projectsViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewAdapter.ProjectsViewHolder personViewHolder, int i) {
        final int j=i;
        Glide.with(mContext).load(mProjectses.get(i).getPhotoId()).into(personViewHolder.imageView);
        personViewHolder.newsTitle.setText(mProjectses.get(i).getTitle());
        personViewHolder.newsDesc.setText(mProjectses.get(i).getDesc());
        personViewHolder.mNumberProgressBar.setProgress(mProjectses.get(i).getProgress());

        //为btn_share btn_readMore cardView设置点击事件
        personViewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mContext,MainActivity.class);
                intent.putExtra("News",mProjectses.get(j));
                mContext.startActivity(intent);
                Toast.makeText(mContext,"dsdsdfsdf",Toast.LENGTH_SHORT).show();
            }
        });

        personViewHolder.share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_SUBJECT, "分享");
                intent.putExtra(Intent.EXTRA_TEXT, mProjectses.get(j).getDesc());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                mContext.startActivity(Intent.createChooser(intent, mProjectses.get(j).getTitle()));
            }
        });

        personViewHolder.readMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mContext,MainActivity.class);
                intent.putExtra("News",mProjectses.get(j));
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mProjectses.size();
    }
}
