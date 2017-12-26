package criminalintent.com.example.lenovo.schedule;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import criminalintent.com.example.lenovo.schedule.customizeWidget.CircularImage;
import criminalintent.com.example.lenovo.schedule.toolClass.CheckInput;

public class RegisterActivity extends AppCompatActivity {

    private TextInputLayout mRegisterUserName;
    private TextInputLayout mRegisterPassword;
    private TextInputLayout mRegisterPasswordConfirm;
    private Button mRegisterButton;
    private CircularImage mCircularImage;

    private String userName;
    private String passWord;

    private boolean isUserNameOk = false;
    private boolean isPasswordOk = false;
    private boolean isConfirmOk = false;

    ///////////////一个用于检验用户输入的工具类
    private CheckInput mCheckInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        initView();
        mCheckInput = new CheckInput();

        mRegisterUserName.getEditText().setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus){
                    ///////////////这里调用接口判断用户名是否唯一
                    if(mCheckInput.checkUserName(mRegisterUserName)){
                        isUserNameOk=true;
                    }
                    setButtonEnable();
                }
            }
        });

        mRegisterPassword.getEditText().setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus){
                    if(mCheckInput.checkPassword(mRegisterPassword)){
                        isPasswordOk=true;
                    }
                    setButtonEnable();
                }
            }
        });
        mRegisterPasswordConfirm.getEditText().setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus){
                    if(mCheckInput.checkPasswordAgain(mRegisterPasswordConfirm,mRegisterPassword)){
                        isConfirmOk=true;
                    }
                    setButtonEnable();
                }
            }
        });

        mRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mCheckInput.checkUserName(mRegisterUserName)&&mCheckInput.checkPassword(mRegisterPassword)&&mCheckInput.checkPasswordAgain(mRegisterPasswordConfirm,mRegisterPassword)){
                    userName=mRegisterUserName.getEditText().getText().toString();
                    passWord=mRegisterPassword.getEditText().getText().toString();
                    Bundle mbundle = new Bundle();
                    mbundle.putString("USERNAME",userName);
                    mbundle.putString("PASSWORD",passWord);
                    Intent intent =new Intent(RegisterActivity.this,MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    intent.putExtras(mbundle);
                    startActivity(intent);
                }
            }
        });
    }

    public void setButtonEnable(){
      /*  if(isUserNameOk&&isPasswordOk&&isConfirmOk){
            mRegisterButton.setEnabled(true);
        }
        else{
            mRegisterButton.setEnabled(false);
        }*/
    }
    public void initView(){
        mRegisterUserName =(TextInputLayout)findViewById(R.id.registerUserName);
        mRegisterPassword=(TextInputLayout)findViewById(R.id.registerPassword);
        mRegisterPasswordConfirm=(TextInputLayout)findViewById(R.id.registerPasswordConfirm);

        mRegisterButton =(Button)findViewById(R.id.register);
        mCircularImage=(CircularImage)findViewById(R.id.cover_user_photo);
        mCircularImage.setImageResource(R.drawable.head);
    }
}
