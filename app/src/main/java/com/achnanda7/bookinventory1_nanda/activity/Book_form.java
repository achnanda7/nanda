package com.achnanda7.bookinventory1_nanda.activity;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import butterknife.BindView;
import butterknife.ButterKnife;
import com.achnanda7.smktelkom_mlg.www.bookinventory1_nanda.R;

public class Book_form extends AppCompatActivity {
    @BindView (R.id.toolbar) Toolbar toolbar;
    @BindView (R.id.editTitle) EditText editTitle;
    @BindView (R.id.editAuthor) EditText editAuthor;
    @BindView (R.id.editGenre) EditText editGenre;
    @BindView (R.id.editIsbn) EditText editISBN;
    @BindView (R.id.editPublished) EditText editPublished;
    @BindView (R.id.editSynopsis) EditText editSynopsis;
    @BindView(R.id.btnsave) Button btnSave;
    Book book;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_form);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validate()) {
                    Toast.makeText(Book_form.this, "Data Valid", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean validate(){
        boolean valid = true;

        String isbn = editISBN.getText().toString();
        String booktitle = editTitle.getText().toString();
        String bookauthor = editAuthor.getText().toString();
        String publishedyear = editPublished.getText().toString();

        if (isbn.isEmpty()){
            editISBN.setError("Enter ISBN");
            valid = false;
        } else {
            editISBN.setError(null);
        }

        if (booktitle.isEmpty()){
            editTitle.setError("Enter Book Title");
            valid = false;
        } else {
            editTitle.setError(null);
        }

        if (bookauthor.isEmpty()){
            editAuthor.setError("Enter Author");
            valid = false;
        } else {
            editAuthor.setError(null);
        }

        if (publishedyear.isEmpty()|| publishedyear.length()<4){
            editPublished.setError("Enter Published");
            valid = false;
        } else {
            editPublished.setError(null);
        }

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        return valid;
    }
}

