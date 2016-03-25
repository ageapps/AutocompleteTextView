package es.age.apps.autocompletetextview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

/**
 * Created by Adrián García Espinosa on 25/3/16.
 */
public class AutoCompleteArrray extends AppCompatActivity {

    String[] brands = { "Samsung","Sony","Google","Huawei","LG","Motorola","HTC","Xiaomi","Apple", "Alcatel", "BQ", "Nokia" };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.autocomplete_layout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, brands);
        //Find the AutoCompleteTextView control
        AutoCompleteTextView acmpTxt = (AutoCompleteTextView) findViewById(R.id.autocmp);
        //Set the number of characters the user must type before the drop down list is shown
        acmpTxt.setThreshold(1);
        //Set the adapter
        acmpTxt.setAdapter(adapter);
        //Set OnItemClickListener
        acmpTxt.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Show Toast with item selected
                Toast.makeText(AutoCompleteArrray.this,(CharSequence) parent.getItemAtPosition(position), Toast.LENGTH_SHORT).show();
            }
        });

    }
}
