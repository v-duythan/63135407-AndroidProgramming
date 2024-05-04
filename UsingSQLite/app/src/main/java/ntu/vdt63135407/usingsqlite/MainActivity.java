package ntu.vdt63135407.usingsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Bước 0. Tạo file cơ sở dữ liệu
        SQLiteDatabase db = openOrCreateDatabase("QLSach.db", MODE_PRIVATE, null);

        // B1. Tạo bảng
        insertTable(db);
        addData(db);
        db.close();
    }

    private void addData(SQLiteDatabase db) {
        // Câu lệnh SQL để thêm dữ liệu vào bảng
        String sqlThem1 = "INSERT INTO Books (BookID, BookName, Page, Price, Description) VALUES (1, 'Java', 100, 9.99, 'sách về java')";
        String sqlThem2 = "INSERT INTO Books (BookID, BookName, Page, Price, Description) VALUES (2, 'Android', 320, 19.00, 'Android cơ bản')";
        String sqlThem3 = "INSERT INTO Books (BookID, BookName, Page, Price, Description) VALUES (3, 'Học làm giàu', 120, 0.99, 'sách đọc cho vui')";
        String sqlThem4 = "INSERT INTO Books (BookID, BookName, Page, Price, Description) VALUES (4, 'Tử điển Anh-Việt', 1000, 29.50, 'Từ điển 100.000 từ')";
        String sqlThem5 = "INSERT INTO Books (BookID, BookName, Page, Price, Description) VALUES (5, 'CNXH', 1, 1, 'chuyện cổ tích')";

        // Thực thi câu lệnh SQL để thêm dữ liệu
        db.execSQL(sqlThem1);
        db.execSQL(sqlThem2);
        db.execSQL(sqlThem3);
        db.execSQL(sqlThem4);
        db.execSQL(sqlThem5);
    }

    private void insertTable(SQLiteDatabase db) {
        // câu lêệnh tạo bảng
        String sqlXoaBangNeuDaCo="DROP TABLE IF EXISTS Books;";

        String sqlTaoBang = "CREATE TABLE Books( BookID integer PRIMARY KEY, " +
                "BookName text, " +
                "Page integer, " +
                "Price Float, " +
                "Description text);";
        // thực hiện lệnh sql
        db.execSQL(sqlXoaBangNeuDaCo);
        db.execSQL(sqlTaoBang);
    }
}