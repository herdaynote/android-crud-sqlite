package com.herdaynote.simplecrud.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.herdaynote.simplecrud.R;
import com.herdaynote.simplecrud.view.create.CreateData;
import com.herdaynote.simplecrud.view.delete.DeleteData;
import com.herdaynote.simplecrud.view.read.ReadData;
import com.herdaynote.simplecrud.view.update.ListUpdate;

public class MainActivity extends Activity implements OnClickListener {
    private Button btnCreate, btnRead, btnUpdate, btnDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCreate = findViewById(R.id.btnCreate);
        btnCreate.setOnClickListener(this);

        btnRead = findViewById(R.id.btnRead);
        btnRead.setOnClickListener(this);

        btnUpdate = findViewById(R.id.btnUpdate);
        btnUpdate.setOnClickListener(this);

        btnDelete = findViewById(R.id.btnDelete);
        btnDelete.setOnClickListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnCreate:
                Intent i1 = new Intent(this, CreateData.class);
                startActivity(i1);
                break;
            case R.id.btnRead:
                Intent i2 = new Intent(this, ReadData.class);
                startActivity(i2);
                break;
            case R.id.btnUpdate:
                Intent i3 = new Intent(this, ListUpdate.class);
                startActivity(i3);
                break;
            case R.id.btnDelete:
                Intent i4 = new Intent(this, DeleteData.class);
                startActivity(i4);
                break;
        }
    }
}