package criminalintent.com.example.lenovo.schedule;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.yalantis.jellytoolbar.listener.JellyListener;
import com.yalantis.jellytoolbar.widget.JellyToolbar;

import java.util.ArrayList;
import java.util.List;

import criminalintent.com.example.lenovo.schedule.Data.Projects;

public class HomePageActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private NavigationView mNavigationView;
    private FloatingActionButton mFloatingActionButton;

    private RecyclerView mRecyclerView;
    private RecyclerViewAdapter mRecyclerViewAdapter;
    private List<Projects> projectsList;


    private TextView mTagsTextView;
    private ImageView mToolBarImageView;
    private TextView mToolBarTitleTextView;

    private JellyToolbar toolbar;
    private AppCompatEditText editText;

    private TextView mDDLTextView;

    private AddProjectDialogFragment mAddProjectDialogFragment;

    private static final String ADDPROJECTDIALOGFRAGMENT = "addprojectdialogfragment";

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        getWindow().setSoftInputMode( WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getWindow().setNavigationBarColor(Color.TRANSPARENT);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }

        initView();
        initData();
        showProjects();

        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if(mFloatingActionButton.isShown()){
                    mFloatingActionButton.setVisibility(View.GONE);
                }
                else if(!mFloatingActionButton.isShown()){
                    mFloatingActionButton.setVisibility(View.VISIBLE);
                }
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    mFloatingActionButton.setVisibility(View.VISIBLE);
                }

            }
        });


        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                selectItem(item.getItemId());
                // 关闭侧滑菜单
                mDrawerLayout.closeDrawers();
                return true;
            }
        });

        mFloatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAddProjectDialogFragment.show(getSupportFragmentManager(),ADDPROJECTDIALOGFRAGMENT);
            }
        });

        mToolBarImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDrawerLayout.openDrawer(mNavigationView);
            }
        });

    }

    private JellyListener jellyListener = new JellyListener() {
        @Override
        public void onCancelIconClicked() {
            if (TextUtils.isEmpty(editText.getText())) {
                toolbar.collapse();
                mToolBarImageView.setVisibility(View.VISIBLE);
                mToolBarTitleTextView.setVisibility(View.VISIBLE);
            } else {
                editText.getText().clear();
            }
        }

        @Override
        public void onToolbarExpandingStarted() {
            super.onToolbarExpandingStarted();
            mToolBarImageView.setVisibility(View.GONE);
            mToolBarTitleTextView.setVisibility(View.GONE);
        }
    };


    public void showProjects(){
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
        mRecyclerView.setLayoutManager(gridLayoutManager);
        mRecyclerViewAdapter=new RecyclerViewAdapter(projectsList,HomePageActivity.this);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setAdapter(mRecyclerViewAdapter);
    }

    public void initView(){
        mDrawerLayout=(DrawerLayout)findViewById(R.id.drawer_layout);
        mNavigationView=(NavigationView)findViewById(R.id.nv_layout);
        mRecyclerView=(RecyclerView)findViewById(R.id.project_recyclerView);
        mFloatingActionButton=(FloatingActionButton)findViewById(R.id.addProject);
        mToolBarImageView=(ImageView)findViewById(R.id.toolbarImage);
        mToolBarTitleTextView =(TextView)findViewById(R.id.toolbarTitle);
        mTagsTextView=(TextView) mNavigationView.getHeaderView(0).findViewById(R.id.personaltags);

        mAddProjectDialogFragment= new AddProjectDialogFragment();

        //根据实际用户数据显示该标签
        mTagsTextView.setText("计算机软件");

        toolbar = (JellyToolbar) findViewById(R.id.toolbar);

        toolbar.setJellyListener(jellyListener);

        editText = (AppCompatEditText) LayoutInflater.from(this).inflate(R.layout.edit_text, null);
        editText.setBackgroundResource(R.color.colorTransparent);
        toolbar.setContentView(editText);

        View dialogView = View.inflate(this,R.layout.selfdialog,null);
        mDDLTextView=(TextView)dialogView.findViewById(R.id.projectddllabel);

    }

    public void initData(){
        projectsList=new ArrayList<>();
        projectsList.add(new Projects(getString(R.string.project1_title),getString(R.string.project1_desc),R.drawable.project,27));
        projectsList.add(new Projects(getString(R.string.project2_title),getString(R.string.project2_desc),R.drawable.project,54));
        projectsList.add(new Projects(getString(R.string.project3_title),getString(R.string.project3_desc),R.drawable.project,33));
        projectsList.add(new Projects(getString(R.string.project3_title),getString(R.string.project3_desc),R.drawable.project,33));
        projectsList.add(new Projects(getString(R.string.project3_title),getString(R.string.project3_desc),R.drawable.project,33));
        projectsList.add(new Projects(getString(R.string.project3_title),getString(R.string.project3_desc),R.drawable.project,33));
        projectsList.add(new Projects(getString(R.string.project3_title),getString(R.string.project3_desc),R.drawable.project,33));
        projectsList.add(new Projects(getString(R.string.project3_title),getString(R.string.project3_desc),R.drawable.project,33));
        projectsList.add(new Projects(getString(R.string.project3_title),getString(R.string.project3_desc),R.drawable.project,33));
    }
    public void initData2(){
        projectsList=new ArrayList<>();
        projectsList.add(new Projects(getString(R.string.project1_title),getString(R.string.project1_desc),R.drawable.project,27));
        projectsList.add(new Projects(getString(R.string.project2_title),getString(R.string.project2_desc),R.drawable.project,54));
        projectsList.add(new Projects(getString(R.string.project3_title),getString(R.string.project3_desc),R.drawable.project,33));
        projectsList.add(new Projects(getString(R.string.project3_title),getString(R.string.project3_desc),R.drawable.project,33));
        projectsList.add(new Projects(getString(R.string.project3_title),getString(R.string.project3_desc),R.drawable.project,33));
        projectsList.add(new Projects(getString(R.string.project3_title),getString(R.string.project3_desc),R.drawable.project,33));
    }

    /**
     * 响应item点击事件
     * @param itemid
     */
    private void selectItem(int itemid) {
        switch (itemid) {
            case R.id.menu_notifications:{
                Intent intent = new Intent(HomePageActivity.this,Set.class);
                startActivity(intent);
                Toast.makeText(HomePageActivity.this, "点击Tues", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.menu_logout:{
                Intent intent = new Intent(HomePageActivity.this,MainActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.menu_info: {
                Intent intent = new Intent(HomePageActivity.this,ModifyUserInfoPage.class);
                startActivity(intent);
                Toast.makeText(HomePageActivity.this, "点击Thurs", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.menu_history:{
                Toast.makeText(HomePageActivity.this, "点击Fri", Toast.LENGTH_SHORT).show();
                initData2();
                showProjects();
                break;
            }
            case R.id.menu_about: {
                Toast.makeText(HomePageActivity.this, "点击 Sat", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.menu_set: {
                Toast.makeText(HomePageActivity.this, "点击 Sun", Toast.LENGTH_SHORT).show();
                break;
            }
            default:
                break;
        }
    }
}
