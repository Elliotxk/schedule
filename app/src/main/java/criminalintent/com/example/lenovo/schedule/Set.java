package criminalintent.com.example.lenovo.schedule;

import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Set extends AppCompatActivity {

    private TextView mTextView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set);


        initView();
    }

    public void initView(){
        mTextView=(TextView)findViewById(R.id.txUnderline);
        mTextView.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);
    }
}
