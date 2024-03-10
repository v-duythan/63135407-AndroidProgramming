package vduythan.edu.ex5_addsubmuldiv_var;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    EditText editTextNumA, editTextNumB;
    Button btnCong, btnTru, btnNhan, btnChia;
    TextView textViewKQ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TimView();
        btnCong.setOnClickListener(boLangNghe_XuLyCong);
        btnTru.setOnClickListener(boLangNghe_XuLyTru);
        btnNhan.setOnClickListener(boLangNghe_XuLyNhan);
        btnChia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strNumA = editTextNumA.getText().toString();
                String strNumB = editTextNumB.getText().toString();

                float numA = Float.parseFloat(strNumA);
                float numB = Float.parseFloat(strNumB);

                float sum = numA / numB;

                String strKQ = String.valueOf(sum);
                textViewKQ.setText(strKQ);
            }
        });
    }

    View.OnClickListener boLangNghe_XuLyCong = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String strNumA = editTextNumA.getText().toString();
            String strNumB = editTextNumB.getText().toString();

            float numA = Float.parseFloat(strNumA);
            float numB = Float.parseFloat(strNumB);

            float sum = numA + numB;

            String strKQ = String.valueOf(sum);
            textViewKQ.setText(strKQ);
        }
    };
    View.OnClickListener boLangNghe_XuLyTru = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String strNumA = editTextNumA.getText().toString();
            String strNumB = editTextNumB.getText().toString();

            float numA = Float.parseFloat(strNumA);
            float numB = Float.parseFloat(strNumB);

            float sum = numA - numB;

            String strKQ = String.valueOf(sum);
            textViewKQ.setText(strKQ);
        }
    };View.OnClickListener boLangNghe_XuLyNhan = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String strNumA = editTextNumA.getText().toString();
            String strNumB = editTextNumB.getText().toString();

            float numA = Float.parseFloat(strNumA);
            float numB = Float.parseFloat(strNumB);

            float sum = numA * numB;

            String strKQ = String.valueOf(sum);
            textViewKQ.setText(strKQ);
        }
    };


    void TimView(){
        //Tìm view
        editTextNumA = (EditText)findViewById(R.id.editTextNumber1);
        editTextNumB = (EditText)findViewById(R.id.editTextNumber2);
        btnCong = (Button)findViewById(R.id.buttonCong);
        btnTru = (Button)findViewById(R.id.buttonTru);
        btnNhan = (Button)findViewById(R.id.buttonNhan);
        btnChia = (Button)findViewById(R.id.buttonChia);
        textViewKQ = (TextView)findViewById(R.id.textViewKQ);
    }

}