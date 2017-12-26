package criminalintent.com.example.lenovo.schedule.toolClass;

import android.support.design.widget.TextInputLayout;

/**
 * Created by lenovo on 2017/11/26.
 */

public class CheckInput {

    //////定义字符合法长度
    final private int LENGTH = 16;


    ///////判断字符是否为字母或数字
    public boolean isDigitalorLetter(String str){
        boolean isCharacterOk = true;
        for(int i=0;i<str.length();i++){
            if(!Character.isLetterOrDigit(str.charAt(i))){
                isCharacterOk=false;
            }
        }
        return isCharacterOk;
    }
    /////////////////判断字符程度是否小于合法长度
    private boolean isLengthOk(String str){
        return str.length()<=LENGTH;
    }

    private boolean isNull(String str){
        if(str==""||str.equals("")){
            return true;
        }
        return false;
    }

    //////检查密码
    public boolean checkPassword(TextInputLayout txInputLayout){
        String pwd=txInputLayout.getEditText().getText().toString();
        boolean pass =true;
        if(isNull(pwd)){
            txInputLayout.setError("密码不能为空");
            pass=false;
        }
        if(!isLengthOk(pwd)){
            txInputLayout.setError("密码必须小于16位");
            pass=false;
        }
        if(!isDigitalorLetter(pwd)){
            txInputLayout.setError("密码必须为字母或数字");
            pass=false;
        }
        if(pass){
            txInputLayout.setError(null);
        }
        return pass;
    }

    ////////////判断确认密码
    public boolean checkPasswordAgain(TextInputLayout txInputLayoutConfirm, TextInputLayout txInputLayout){
        String pwd = txInputLayoutConfirm.getEditText().getText().toString();
        String password=txInputLayout.getEditText().getText().toString();
        boolean isSame = true;
        boolean isOk = true;
        if(!pwd.equals(password)){
            txInputLayoutConfirm.setError("密码不一致");
            isSame=false;
            isOk=false;
        }
        if(isSame&&checkPassword(txInputLayoutConfirm)){
            txInputLayoutConfirm.setError(null);
            isOk=true;
        }
        return isOk;
    }

    ///////////检查用户名
    public boolean checkUserName(TextInputLayout txInputLayout){
        String userName = txInputLayout.getEditText().getText().toString();
        ////////////////////////////调用接口判断用户名是否合法
        if(isNull(userName)){
            txInputLayout.setError("用户名为空");
            return false;
        }
        txInputLayout.setError(null);
        return true;
    }




}
