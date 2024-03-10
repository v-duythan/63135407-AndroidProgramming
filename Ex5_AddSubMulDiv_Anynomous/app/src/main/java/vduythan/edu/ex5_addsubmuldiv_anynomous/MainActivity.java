package vduythan.edu.ex5_addsubmuldiv_anynomous;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText editTextNum1;
    EditText editTextNum2;
    EditText displayKQ;
    Button nutCong, nutTru, nutNhan, nutChia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TimDieuKhien();
        View.OnClickListener boLangNgheCong = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strnum1 = editTextNum1.getText().toString();
                String strnum2 = editTextNum2.getText().toString();

                float num1 = Float.parseFloat(strnum1);
                float num2 = Float.parseFloat(strnum2);

                float sum = num1 + num2;

                String strKQ = String.valueOf(sum);

                displayKQ.setText(strKQ);
            }
        };
        nutCong.setOnClickListener(boLangNgheCong);

        nutTru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strnum1 = editTextNum1.getText().toString();
                String strnum2 = editTextNum2.getText().toString();

                float num1 = Float.parseFloat(strnum1);
                float num2 = Float.parseFloat(strnum2);

                float sum = num1 - num2;

                String strKQ = String.valueOf(sum);

                displayKQ.setText(strKQ);
            }
        });

        nutNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strnum1 = editTextNum1.getText().toString();
                String strnum2 = editTextNum2.getText().toString();

                float num1 = Float.parseFloat(strnum1);
                float num2 = Float.parseFloat(strnum2);

                float sum = num1 * num2;

                String strKQ = String.valueOf(sum);

                displayKQ.setText(strKQ);
            }
        });

        nutChia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strnum1 = editTextNum1.getText().toString();
                String strnum2 = editTextNum2.getText().toString();

                float num1 = Float.parseFloat(strnum1);
                float num2 = Float.parseFloat(strnum2);

                float sum = num1 / num2;

                String strKQ = String.valueOf(sum);

                displayKQ.setText(strKQ);
            }
        });
    }
    public void TimDieuKhien(){
        editTextNum1 = (EditText)findViewById(R.id.inputNum1);
        editTextNum2 = (EditText)findViewById(R.id.inputNum2);
        displayKQ = (EditText)findViewById(R.id.outputKQ);
        nutCong = (Button)findViewById(R.id.btnCong);
        nutTru = (Button)findViewById(R.id.btnTru);
        nutNhan = (Button)findViewById(R.id.btnNhan);
        nutChia = (Button)findViewById(R.id.btnChia);
    }

}