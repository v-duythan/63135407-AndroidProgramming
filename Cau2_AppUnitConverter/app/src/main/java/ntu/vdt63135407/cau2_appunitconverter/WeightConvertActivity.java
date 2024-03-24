package ntu.vdt63135407.cau2_appunitconverter;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
public class WeightConvertActivity extends AppCompatActivity {

    private Spinner spinnerInputUnit;
    private Spinner spinnerOutputUnit;
    private EditText editTextInput;
    private TextView textViewResult;
    private Button buttonConvert;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight_convert);

        // Ánh xạ các thành phần giao diện
        spinnerInputUnit = findViewById(R.id.spinnerInputUnit);
        spinnerOutputUnit = findViewById(R.id.spinnerOutputUnit);
        editTextInput = findViewById(R.id.editTextInput);
        textViewResult = findViewById(R.id.textViewResult);
        buttonConvert = findViewById(R.id.buttonConvert);

        // Thiết lập adapter cho spinner đơn vị đầu vào và đầu ra
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.weight_units, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerInputUnit.setAdapter(adapter);
        spinnerOutputUnit.setAdapter(adapter);

        // Thiết lập sự kiện khi nhấn nút chuyển đổi
        buttonConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertUnit();
            }
        });
    }
    // Phương thức để chuyển đổi đơn vị
    private void convertUnit() {
        try {
            // Lấy giá trị từ trường nhập
            double inputValue = Double.parseDouble(editTextInput.getText().toString());

            // Lấy đơn vị đầu vào và đầu ra từ spinner
            String inputUnit = spinnerInputUnit.getSelectedItem().toString();
            String outputUnit = spinnerOutputUnit.getSelectedItem().toString();

            // Thực hiện chuyển đổi đơn vị
            double outputValue = 0.0;
            if (inputUnit.equals("Kilogram")) {
                if (outputUnit.equals("Gram")) {
                    outputValue = inputValue * 1000;
                } else if (outputUnit.equals("Ounce")) {
                    outputValue = inputValue * 35.274;
                } else if (outputUnit.equals("Pound")) {
                    outputValue = inputValue * 2.205;
                }
            } else if (inputUnit.equals("Gram")) {
                if (outputUnit.equals("Kilogram")) {
                    outputValue = inputValue / 1000;
                } else if (outputUnit.equals("Ounce")) {
                    outputValue = inputValue / 28.35;
                } else if (outputUnit.equals("Pound")) {
                    outputValue = inputValue / 454;
                }
            } else if (inputUnit.equals("Ounce")) {
                if (outputUnit.equals("Kilogram")) {
                    outputValue = inputValue / 35.274;
                } else if (outputUnit.equals("Gram")) {
                    outputValue = inputValue * 28.35;
                } else if (outputUnit.equals("Pound")) {
                    outputValue = inputValue / 16;
                }
            } else if (inputUnit.equals("Pound")) {
                if (outputUnit.equals("Kilogram")) {
                    outputValue = inputValue / 2.205;
                } else if (outputUnit.equals("Gram")) {
                    outputValue = inputValue * 454;
                } else if (outputUnit.equals("Ounce")) {
                    outputValue = inputValue * 16;
                }
            }

            // Hiển thị kết quả
            textViewResult.setText(String.format("%.2f", outputValue));
        } catch (NumberFormatException e) {
            // Xử lý nếu có lỗi khi nhập giá trị
            textViewResult.setText("Invalid input");
        }
    }
}
