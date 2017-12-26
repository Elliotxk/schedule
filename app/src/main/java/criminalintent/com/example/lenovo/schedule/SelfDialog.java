package criminalintent.com.example.lenovo.schedule;

import android.content.Context;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by lenovo on 2017/12/18.
 */

public class SelfDialog extends AlertDialog {

    private ImageView mProjeceNameImageView;
    private TextView mProjectNameTextView;
    private TextView mDDLTextView;
    private TextView mOwnerTextView;
    private TextView mAddMemberTextView;



    public SelfDialog(Context context) {
        super(context, R.style.MyDialog);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selfdialog);
        //按空白处不能取消动画
        setCanceledOnTouchOutside(false);

        //初始化界面控件
        initView();
        //初始化界面数据
        //initData();
        //初始化界面控件的事件
        initEvent();

    }

    public void initView(){
        mProjeceNameImageView=(ImageView)findViewById(R.id.projectNameIcon);
        mProjectNameTextView=(TextView)findViewById(R.id.projectName);
        mDDLTextView=(TextView)findViewById(R.id.projectddllabel);
        mAddMemberTextView=(TextView)findViewById(R.id.addmember);
        mOwnerTextView=(TextView)findViewById(R.id.owner);

        mAddMemberTextView.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);
        mOwnerTextView.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);
    }

    public void initEvent(){
        mDDLTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getOwnerActivity(),"ddddd", Toast.LENGTH_SHORT).show();
            }
        });
    }



}
