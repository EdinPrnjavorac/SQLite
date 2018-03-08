package com.example.edinprnjavorac.sqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.SQLException;

public class Data extends AppCompatActivity {

    TextView tvData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        tvData = (TextView) findViewById(R.id.tvData);

        try {
        ContactsDB db = new ContactsDB(this);
        db.open();
        tvData.setText(db.getData());
        db.close();
        }
        catch (android.database.SQLException e) {
            Toast.makeText(Data.this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
