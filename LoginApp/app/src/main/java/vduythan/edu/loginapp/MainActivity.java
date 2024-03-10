package vduythan.edu.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView taikhoan;
    TextView matkhau;
    Button Login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TimDieuKhien();
        Login.setOnClickListener(LoginAccount);
    }
    public void TimDieuKhien(){
        taikhoan= (TextView)findViewById(R.id.account);
        matkhau= (TextView)findViewById(R.id.editTextPassword);
        Login= (Button)findViewById(R.id.btnLogin);
    }

    View.OnClickListener LoginAccount = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String ACC= taikhoan.getText().toString();
            String PASS= matkhau.getText().toString();
            if (ACC.equals("hlam79") && PASS.equals("123")) {
                // Nếu đúng, chuyển sang activity mới
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            } else {
                // Nếu không đúng, hiển thị thông báo lỗi
                Toast.makeText(MainActivity.this, "Tên đăng nhập hoặc mật khẩu không đúng", Toast.LENGTH_SHORT).show();
            }
        }
    };
}