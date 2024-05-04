package ntu.vdt63135407.usingsqlite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Adapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Bước 0. Tạo hoặc mở cơ sở dữ liệu
        SQLiteDatabase db = openOrCreateDatabase("QLSach.db", MODE_PRIVATE, null);

        // B1. Tạo bảng và thêm dữ liệu mẫu
        insertTable(db);
        addData(db);

        // Đóng kết nối cơ sở dữ liệu sau khi sử dụng
        db.close();

        // TRUY VẤN SELECT
        ArrayList<Book> dsTenSach = layDSSach();

        // Hiển thị danh sách tên sách trong RecyclerView
        RecyclerView recyclerViewBooks = findViewById(R.id.recyclerViewBooks);
        recyclerViewBooks.setLayoutManager(new LinearLayoutManager(this));
        BookAdapter bookAdapter = new BookAdapter(this, dsTenSach);
        recyclerViewBooks.setAdapter(bookAdapter);

    }

    private ArrayList<Book> layDSSach() {
        // Mở CSDL
        SQLiteDatabase db = openOrCreateDatabase("QLSach.db", MODE_PRIVATE, null);

        // Thực hiện truy vấn SELECT
        String sqlSelect ="SELECT * FROM Books;";
        Cursor cursor = db.rawQuery(sqlSelect, null);

        // Đổ dữ liệu vào danh sách sách
        ArrayList<Book> dsSach = new ArrayList<>();
        while (cursor.moveToNext()) {
            int bookID = cursor.getInt(cursor.getColumnIndexOrThrow("BookID"));
            String bookName = cursor.getString(cursor.getColumnIndexOrThrow("BookName"));
            int page = cursor.getInt(cursor.getColumnIndexOrThrow("Page"));
            float price = cursor.getFloat(cursor.getColumnIndexOrThrow("Price"));
            String description = cursor.getString(cursor.getColumnIndexOrThrow("Description"));

            // Tạo đối tượng sách từ dữ liệu và thêm vào danh sách
            Book book = new Book(bookID, bookName, page, price, description);
            dsSach.add(book);
        }

        // Đóng CSDL và trả về danh sách sách
        cursor.close();
        db.close();
        return dsSach;
    }

    private Cursor getData(SQLiteDatabase db) {
        return db.rawQuery("SELECT * FROM Books", null);
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
        // câu lệnh tạo bảng
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
