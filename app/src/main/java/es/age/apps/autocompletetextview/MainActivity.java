package es.age.apps.autocompletetextview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by Adrián García Espinosa on 25/3/16.
 */
public class MainActivity extends AppCompatActivity {

    String[] names = { "AutoComplete with String Array","AutoComplete with XML Resource",
            "AutoComplete with Custom Item","AutoComplete with Custom Adapter" };
    Class[] activities = {AutoCompleteArrray.class, AutoCompleteXML.class, AutoCompleteCustomItem.class, AutoCompleteCustomAdapter.class };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //SetUp ListView
        ListView list = (ListView) findViewById(R.id.list_main);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,android.R.id.text1, names);
        list.setAdapter(adapter);
        //SetUp ListView OnClick Listener
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(MainActivity.this,activities[position]));
            }
        });


    }

}
