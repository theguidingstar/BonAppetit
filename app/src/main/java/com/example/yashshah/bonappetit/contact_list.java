package com.example.yashshah.bonappetit;

import android.content.ContentResolver;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class contact_list extends AppCompatActivity {

    EditText SearchText;
    ListViewAdapter adapter;
    ListView listView;
    ArrayList<String> match=new ArrayList<String>();
    ArrayList<contactdetail> arrayList=new ArrayList<contactdetail>();
    ArrayList<String> mArrayListAll = new ArrayList<String>();
    String messageToWhatsapp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        getAllContacts(this.getContentResolver());
        adapter= new ListViewAdapter(this,arrayList,mArrayListAll,match);
        listView =(ListView)findViewById(R.id.listView);
        listView.setAdapter(adapter);
        DBHelper mydb;
        Button button=(Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mydb=new DBHelper(getApplicationContext());
        List<String> phoneRegistered1=new ArrayList<String>();
        List<details> phoneRegistered=mydb.getAllContactsPhone();
        for (details cn : phoneRegistered) {
            phoneRegistered1.add(cn.getPhoneNo());
        }
        match.addAll(phoneRegistered1);


        SearchText=(EditText)findViewById(R.id.editText);
        SearchText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String text = SearchText.getText().toString().toLowerCase(Locale.getDefault());
                adapter.filter(text);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

    public  void getAllContacts(ContentResolver cr) {

        Cursor phones = cr.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,null,null, null);
        while (phones.moveToNext())
        {
            String name=phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
            String phoneNumber = phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
            System.out.println(".................."+phoneNumber);
            contactdetail cd=new contactdetail(name,phoneNumber);
            mArrayListAll.add(phoneNumber);
            arrayList.add(cd);
        }

        phones.close();
    }
}
