package vduythan.edu.ex_6_listviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ArrayList<String> dsTenTinhThanhVN = new ArrayList<>();

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
    }
}