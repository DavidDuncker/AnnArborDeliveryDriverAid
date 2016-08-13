package com.david_duncker.zoomeraid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.database.Cursor;

//Begin Main Activity class

public class MainActivity extends AppCompatActivity {

    public final static String sr_address = "com.david_duncker.zoomeraid.sr_address";
    public final static String sr_num1 = "com.david_duncker.zoomeraid.sr_num1";
    public final static String sr_num2 = "com.david_duncker.zoomeraid.sr_num2";
    public final static String sr_preimg = "com.david_duncker.zoomeraid.sr_preimg";
    public final static String sr_postimg = "com.david_duncker.zoomeraid.sr_postimg";
    public final static String sr_img = "com.david_duncker.zoomeraid.sr_img";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Basic android setup
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final EditText search_text = (EditText) findViewById(R.id.search_terms);

        search_text.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) { }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                edit_search(search_text);
            }
        });
    }
    protected void onStart(Bundle savedInstanceState) {
        EditText search_text = (EditText) findViewById(R.id.search_terms);
        edit_search(search_text); }

    public void edit_search(View view) {
        ListView list = (ListView) findViewById(android.R.id.list);
        EditText editText = (EditText) findViewById(R.id.search_terms);
        String search = editText.getText().toString();
        DataBaseHelper myDbHelper = new DataBaseHelper(this);
        Integer i=0;
        boolean isint = true;
        if (search.length()<=0) {
            isint = false;
        }
        while (isint) {
            char str=search.charAt(i);
            if (str == '-') {
                isint = false;
            }
            else if (str < '0' || str > '9') {
                isint = false;
            }
            else {
                i++;
            }
        }
        String streetnumber=search.substring(0, i);
        String address=search.substring(i, search.length());

        String streetnumber1 = "";
        String streetnumber2 = "";

        if (streetnumber.equals(" ") || streetnumber.equals("")) {
            streetnumber1 = "9999999";
            streetnumber2 = "0";
        } else {
            streetnumber1 = streetnumber;
            streetnumber2 = streetnumber;
        }

        String address_split[] = address.split(" ");
        String longestWordInAddress = "";

        for (i = 0; i < address_split.length; i++) {
            if (address_split[i].length() > longestWordInAddress.length()) {
                longestWordInAddress = address_split[i];
            }
        }

        String query = "SELECT rowid AS _id, Address, StreetNumber1, StreetNumber2, Text1, Image, Text2 FROM Addresses " +
                "WHERE StreetNumber1<" + streetnumber1
                + " AND StreetNumber2>" + streetnumber2
                + " AND Address LIKE '%" + longestWordInAddress + "%'";

        Cursor cursor = myDbHelper.getReadableDatabase().rawQuery(query, null);
        String fromColumns[] = new String[]{"StreetNumber1", "StreetNumber2", "Address"};
        int toViews[] = new int[]{R.id.address_number1, R.id.address_number2, R.id.address_street};
        SimpleCursorAdapter dataAdapter = new SimpleCursorAdapter(this,
                R.layout.search_layout, cursor,
                fromColumns, toViews, 0);

        list.setAdapter(dataAdapter);
        myDbHelper.close();

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View v, int position, long id) {
                Cursor cursor = (Cursor) adapter.getItemAtPosition(position);
                cursor.moveToPosition(position);
                int rowId = cursor.getInt(cursor.getColumnIndexOrThrow("_id"));
                String Address = cursor.getString(cursor.getColumnIndexOrThrow("Address"));
                String StreetNumber1 = cursor.getString(cursor.getColumnIndexOrThrow("StreetNumber1"));
                String StreetNumber2 = cursor.getString(cursor.getColumnIndexOrThrow("StreetNumber2"));
                String preimg = cursor.getString(cursor.getColumnIndexOrThrow("Text1"));
                String img = cursor.getString(cursor.getColumnIndexOrThrow("Image"));
                String postimg = cursor.getString(cursor.getColumnIndexOrThrow("Text2"));

                Intent intent2 = new Intent(getApplicationContext(), SearchResult.class);
                intent2.putExtra(sr_address, Address);
                intent2.putExtra(sr_num1, StreetNumber1);
                intent2.putExtra(sr_num2, StreetNumber2);
                intent2.putExtra(sr_preimg, preimg);
                intent2.putExtra(sr_img, img);
                intent2.putExtra(sr_postimg, postimg);

                startActivity(intent2);


            }
        }
    );}







}
