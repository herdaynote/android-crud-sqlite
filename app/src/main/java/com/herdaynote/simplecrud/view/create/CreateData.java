package com.herdaynote.simplecrud.view.create;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.herdaynote.simplecrud.R;
import com.herdaynote.simplecrud.controller.DBDataSource;

public class CreateData extends Activity implements OnClickListener {
    private EditText edtBookName, edtBookAuthor;
    private Button btnCreate;
    private DBDataSource dataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_data);

        edtBookName = findViewById(R.id.edtBookName);
        edtBookAuthor = findViewById(R.id.edtBookAuthor);

        btnCreate = findViewById(R.id.btnCreate);
        btnCreate.setOnClickListener(this);

        dataSource = new DBDataSource(this);
        dataSource.open();
    }

    @Override
    protected void onResume() {
        super.onResume();
        this.onCreate(null);
    }

    public void onClick(View v) {
        try {
            String bookName = edtBookName.getText().toString();
            String bookAuthor = edtBookAuthor.getText().toString();

            if (v.getId() == R.id.btnCreate) {
                dataSource.createData(bookName, bookAuthor);

                Toast.makeText(this, "Data saved!", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent();
                setResult(RESULT_OK, intent);
                this.recreate();
            }
        } catch (Exception e) {
            Toast.makeText(this, "Please fill in the data!", Toast.LENGTH_SHORT).show();
        }
    }
}