package com.example.yashshah.bonappetit;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;
import android.widget.*;
import android.widget.ArrayAdapter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class Checkout_activity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener,View.OnClickListener{

    EditText editText_datepicker_checkIn,editText_checkout_name,editText_checkout_age,editText_checkout_number;
    private int _day;
    private int _month;
    private int _birthYear;
    private Context _context;
    Boolean datefixer=true;
    TextInputLayout Checkout_name,Checkout_age,Checkout_contact_no;
    TextView hotelName;
    ImageView hotelImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.checkout_screen);
        editText_checkout_name=(EditText)findViewById(R.id.Checkout_name);
        editText_checkout_age=(EditText)findViewById(R.id.Checkout_age);
        editText_checkout_number=(EditText)findViewById(R.id.Checkout_number);
        Checkout_name=(TextInputLayout)findViewById(R.id.Checkout_name_textInputLayout);
        Checkout_age=(TextInputLayout)findViewById(R.id.Checkout_age_textInputLayout);
        Checkout_contact_no=(TextInputLayout)findViewById(R.id.Checkout_contactno_textInputLayout);
        Spinner spinner=(Spinner)findViewById(R.id.Spinner1);
        ArrayList<Integer> members=new ArrayList<Integer>();
        members.add(1);members.add(2);members.add(3);members.add(4);members.add(5);members.add(6);
        android.widget.ArrayAdapter arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_spinner_item,members);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
        editText_datepicker_checkIn=(EditText)findViewById(R.id.datePicker);
        editText_datepicker_checkIn.setOnClickListener(this);
        _context=this;
        Button button_booking_confirmed=(Button)findViewById(R.id.button_booking_confirmed);
        button_booking_confirmed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!validateName()) {
                    return;
                }

                if (!validateAge()) {
                    return;
                }

                if (!validateNumber()) {
                    return;
                }



                Intent intent=new Intent(getApplicationContext(),booking_confirmed.class);
                startActivity(intent);
                finish();
            }
        });
        Toolbar toolbar2 = (Toolbar) findViewById(R.id.toolbar3);
        setSupportActionBar(toolbar2);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar2.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        hotelName=(TextView)findViewById(R.id.textView4_hotel_Name);
        hotelImage=(ImageView)findViewById(R.id.imageView6_hotelImage);
        Intent intent=getIntent();
        hotelName.setText(intent.getStringExtra("Name"));
        Glide.with(getApplicationContext()).load(intent.getStringExtra("id"))
                .thumbnail(0.5f)
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(hotelImage);
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

        _birthYear = year;
        _month = month;
        _day = dayOfMonth;
        updateDisplay();
    }

    @Override
    public void onClick(View v) {
        Date d=new Date();
        if(v.getId()==R.id.datePicker) {
            Calendar calendar = Calendar.getInstance(TimeZone.getDefault());

            DatePickerDialog dialog = new DatePickerDialog(_context, this,
                    calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                    calendar.get(Calendar.DAY_OF_MONTH));
            SimpleDateFormat sdf = null;
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                sdf = new SimpleDateFormat("dd/MM/yyyy");
            }
            try {
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                    d = sdf.parse("21/12/2012");
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
            dialog.getDatePicker().setMinDate(d.getTime());
            dialog.show();
            datefixer=true;
        }

    }

    private void updateDisplay() {

        if(datefixer) {
            editText_datepicker_checkIn.setText(new StringBuilder()
                    // Month is 0 based so add 1
                    .append(_day).append("/").append(_month + 1).append("/").append(_birthYear).append(" "));
        }
        }

    private boolean validateName() {
        if (editText_checkout_name.getText().toString().trim().isEmpty()) {
            Checkout_name.setError("Please Enter Name");
            requestFocus(editText_checkout_name);
            return false;
        } else {
            Checkout_name.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validateAge() {
        if (editText_checkout_age.getText().toString().trim().isEmpty()) {
            Checkout_age.setError("Please Enter Your Age");
            requestFocus(editText_checkout_age);
            return false;
        } else {
            Checkout_age.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validateNumber() {
        if (editText_checkout_number.getText().toString().trim().isEmpty()) {
            Checkout_contact_no.setError("Please Enter Your Number");
            requestFocus(editText_checkout_number);
            return false;
        } else {
            Checkout_contact_no.setErrorEnabled(false);
        }

        return true;
    }

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }

}
