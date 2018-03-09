package com.example.yashshah.bonappetit;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

public class profile_edit extends AppCompatActivity {


    String name,phone,email,pass;
    EditText profile_edit_name,profile_edit_phone,profile_edit_email,profile_edit_Address;
    private static DBHelper mydb;
    int id;
    RelativeLayout relative_layout_profile_edit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_edit);

        Toolbar toolbar2 = (Toolbar) findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar2);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar2.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        Button mbutton_update;
        relative_layout_profile_edit=(RelativeLayout)findViewById(R.id.relative_layout_profile_edit);

        mbutton_update=(Button)findViewById(R.id.button21_update);
        mydb=new DBHelper(this);
        profile_edit_name=(EditText)findViewById(R.id.editText2);
        profile_edit_phone=(EditText)findViewById(R.id.editText4);
        profile_edit_email=(EditText)findViewById(R.id.editText5);
        profile_edit_Address=(EditText)findViewById(R.id.editText6);

        final Intent intent=getIntent();
        id=intent.getIntExtra("id",1);
        name=intent.getStringExtra("name");
        phone=intent.getStringExtra("phone");
        email=intent.getStringExtra("email");
        pass=intent.getStringExtra("pass");

        profile_edit_name.setText(name);
        profile_edit_phone.setText(phone);
        profile_edit_email.setText(email);

        mbutton_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String updated_name=profile_edit_name.getText().toString();
                String updated_phone=profile_edit_phone.getText().toString();
                String updated_email=profile_edit_email.getText().toString();
                String updated_address=profile_edit_Address.getText().toString();
                mydb.updateContact(id,updated_name,updated_phone,updated_email,updated_address);
                Snackbar snackbar = Snackbar
                        .make(relative_layout_profile_edit, "Welcome to AndroidHive", Snackbar.LENGTH_SHORT);
                snackbar.show();
                Intent intent1=new Intent(getApplicationContext(),Main_Navigation_activity.class);
                intent1.putExtra("email",updated_email);
                startActivity(intent1);
                finish();
            }
        });


    }
}
