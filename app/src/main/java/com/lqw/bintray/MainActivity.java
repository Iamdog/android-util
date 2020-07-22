package com.lqw.bintray;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.lqw.library_util.util.DateUtil;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this,DateUtil.formatYmdHmsString(new Date()),Toast.LENGTH_LONG).show();
    }
}