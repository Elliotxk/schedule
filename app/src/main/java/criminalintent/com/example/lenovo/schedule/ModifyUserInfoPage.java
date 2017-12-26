package criminalintent.com.example.lenovo.schedule;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.ramotion.foldingcell.FoldingCell;

public class ModifyUserInfoPage extends AppCompatActivity {


    private FoldingCell mFoldingCell;
    private Button mModiftSubmitButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_user_info_page);

        initView();

        mFoldingCell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mFoldingCell.toggle(false);
            }
        });
        mModiftSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ModifyUserInfoPage.this,MainActivity.class);
            }
        });
    }


    public void initView(){
        mFoldingCell=(FoldingCell)findViewById(R.id.folding_cell);
        mModiftSubmitButton=(Button)findViewById(R.id.submitModify);
    }
}
