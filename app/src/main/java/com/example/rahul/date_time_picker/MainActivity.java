package com.example.rahul.date_time_picker;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView etDate, etTime;
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        IntiUi();
        InitListner();

    }

    private void InitListner() {
        etTime.setOnClickListener(this);
        etDate.setOnClickListener(this);
    }

    private void IntiUi() {
        etDate = findViewById(R.id.etDate);
        etTime = findViewById(R.id.etTime);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.etDate:
                ShowDate();
                break;
            case R.id.etTime:
                ShowTime();
        }
    }

    private void ShowTime() {
        Calendar t = Calendar.getInstance();
        final int tHour = t.get(Calendar.HOUR_OF_DAY);
        final int tMinute = t.get(Calendar.MINUTE);

        TimePickerDialog tpd = new TimePickerDialog(context, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int hour, int min) {
                String timeString = hour + ":" + min;
                etTime.setText(timeString);

            }
        }, tHour, tMinute,false);
        tpd.show();


    }

    private void ShowDate() {

        Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR);
        int mMonth = c.get(Calendar.MONTH);
        int mDay = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog dpd = new DatePickerDialog(context, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                String dateString = day + "/" + month + "/" + year;
                etDate.setText(dateString);
            }
        }, mYear, mMonth, mDay);
        dpd.show();


    }
}
