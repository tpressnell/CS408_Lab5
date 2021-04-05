package com.example.lab5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView output;
    private Button btnAddMemo;
    private Button btnDelete;
    private EditText memoInput;
    private EditText memoDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        output = (TextView) findViewById(R.id.output);
        btnAddMemo = (Button) findViewById(R.id.btnAddMemo);
        btnDelete = (Button) findViewById(R.id.btnDelete);
        memoInput = (EditText) findViewById(R.id.memoInput);
        memoDelete = (EditText) findViewById(R.id.memoDelete);

        DatabaseHandler db = new DatabaseHandler(this,null,null,1);
        output.setText(db.getAllMemos());


    }

    public void addMemo(View v){
        DatabaseHandler db = new DatabaseHandler(this,null,null,1);
        String memo = memoInput.getText().toString();
        db.addMemo(memo);

        output.setText(db.getAllMemos());
    }

    public void deleteMemo(View v){
        DatabaseHandler db = new DatabaseHandler(this,null,null,1);
        int memoNum = Integer.parseInt(memoDelete.getText().toString());
        db.deleteMemo(memoNum);

        output.setText(db.getAllMemos());
    }
}