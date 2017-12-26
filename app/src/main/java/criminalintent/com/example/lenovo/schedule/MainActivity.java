package criminalintent.com.example.lenovo.schedule;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import criminalintent.com.example.lenovo.schedule.toolClass.CheckInput;
import criminalintent.com.example.lenovo.schedule.customizeWidget.CircularImage;

public class MainActivity extends AppCompatActivity {

    private TextInputLayout mPasswordText;
    private TextInputLayout mUserNameText;
    private Button mNewUserButton;
    private Button mLogButton;
    private CircularImage mCircularImage;

    boolean isUserNameOk = false;
    boolean isPasswordOk = false;

    private String userName;
    private String password;

    //////检查用户输入的工具类
    private CheckInput mCheckInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        initView();
        mCheckInput = new CheckInput();

        mUserNameText.getEditText().setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus){
                    mCheckInput.checkUserName(mUserNameText);
                }
            }
        });

        mPasswordText.getEditText().setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus){
                    /////////////////判断密码是否正确
                    mCheckInput.checkPassword(mPasswordText);
                }
            }
        });

        mLogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mCheckInput.checkUserName(mUserNameText)&&mCheckInput.checkPassword(mPasswordText)){
                    Intent intent = new Intent(MainActivity.this,HomePageActivity.class);
                    startActivity(intent);
                    Toast.makeText(MainActivity.this,"欢迎："+mUserNameText.getEditText().getText(),Toast.LENGTH_LONG).show();
                }
                Intent intent = new Intent(MainActivity.this,HomePageActivity.class);
                startActivity(intent);
                Toast.makeText(MainActivity.this,"欢迎："+mUserNameText.getEditText().getText(),Toast.LENGTH_LONG).show();

            }
        });

        mNewUserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
    public void initView(){
        mPasswordText =(TextInputLayout)findViewById(R.id.logPassword);
        mUserNameText=(TextInputLayout)findViewById(R.id.logUsername);
        mNewUserButton=(Button)findViewById(R.id.goRegister);
        mLogButton=(Button)findViewById(R.id.log);
        mCircularImage=(CircularImage)findViewById(R.id.logHeadImage);
        mCircularImage.setImageResource(R.drawable.head);

        Intent intent = getIntent();
        Bundle mBundle = intent.getExtras();
        if(mBundle!=null){
            mUserNameText.getEditText().setText(mBundle.get("USERNAME").toString());
            mPasswordText.getEditText().setText(mBundle.get("PASSWORD").toString());
            Toast.makeText(MainActivity.this,"用户名："+mBundle.get("USERNAME")+"\r\n密码： "+mBundle.get("PASSWORD"),Toast.LENGTH_LONG).show();;
        }
    }
}
