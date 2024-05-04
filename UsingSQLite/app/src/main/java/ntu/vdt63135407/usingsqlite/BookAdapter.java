package ntu.vdt63135407.usingsqlite;
import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookViewHolder> {
    private Context mContext;
    private ArrayList<Book> mBooks;

    public BookAdapter(Context context, ArrayList<Book> books) {
        mContext = context;
        mBooks = books;
    }

    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_book, parent, false);
        return new BookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder holder, int position) {
        Book book = mBooks.get(position);
        holder.textViewBookName.setText(book.getBookName());
        holder.textViewPage.setText("Page: " + book.getPage());
        holder.textViewPrice.setText("Price: $" + book.getPrice());
        holder.textViewDescription.setText(book.getDescription());
    }

    @Override
    public int getItemCount() {
        return mBooks.size();
    }

    public static class BookViewHolder extends RecyclerView.ViewHolder {
        TextView textViewBookName;
        TextView textViewPage;
        TextView textViewPrice;
        TextView textViewDescription;

        public BookViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewBookName = itemView.findViewById(R.id.textViewBookName);
            textViewPage = itemView.findViewById(R.id.textViewPage);
            textViewPrice = itemView.findViewById(R.id.textViewPrice);
            textViewDescription = itemView.findViewById(R.id.textViewDescription);
        }
    }
}
