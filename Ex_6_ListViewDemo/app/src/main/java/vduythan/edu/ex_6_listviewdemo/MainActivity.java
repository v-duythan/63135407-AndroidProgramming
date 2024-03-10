package vduythan.edu.ex_6_listviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> dsTenTinhThanhVN;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        dsTenTinhThanhVN = new ArrayList<>();

        dsTenTinhThanhVN.add("Hà Nội");
        dsTenTinhThanhVN.add("TP Hồ Chí Minh");
        dsTenTinhThanhVN.add("Nha Trang");
        dsTenTinhThanhVN.add("Đà Nẵng");
        dsTenTinhThanhVN.add("Phú Yên");
        dsTenTinhThanhVN.add("Thanh Hóa");
        dsTenTinhThanhVN.add("Lâm Đồng");

        //Tạo Adapter
        ArrayAdapter<String> adapterTinhThanh;
        adapterTinhThanh = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,
                dsTenTinhThanhVN);

        ListView listView = findViewById(R.id.listView);
        listView.setAdapter(adapterTinhThanh);

        listView.setOnItemClickListener(boLangNgheVaXL);
    }
    AdapterView.OnItemClickListener boLangNgheVaXL = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            String strTenTinhChon = dsTenTinhThanhVN.get(position);
            Toast.makeText(MainActivity.this, "Bạn vừa chọn " + strTenTinhChon, Toast.LENGTH_LONG).show();
        }
    };
}