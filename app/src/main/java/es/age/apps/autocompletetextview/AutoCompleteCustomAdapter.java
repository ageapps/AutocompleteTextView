package es.age.apps.autocompletetextview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adrián García Espinosa on 25/3/16.
 */
public class AutoCompleteCustomAdapter extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.autocomplete_layout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Get the String Array from XML Resource
        String[] s = getResources().getStringArray(R.array.brands);

        ArrayList<String> brands = new ArrayList<String>();

        for (int i = 0; i < s.length; i++) {
            brands.add(s[i]);
        }

        int[] drawables = {android.R.drawable.ic_menu_help, android.R.drawable.ic_menu_add, android.R.drawable.ic_menu_call,
                android.R.drawable.ic_menu_camera, android.R.drawable.ic_menu_crop, android.R.drawable.ic_menu_close_clear_cancel, android.R.drawable.ic_menu_compass,
                android.R.drawable.ic_menu_delete, android.R.drawable.ic_menu_directions, android.R.drawable.ic_menu_edit, android.R.drawable.ic_menu_gallery
                , android.R.drawable.ic_menu_more
        };

        CustomAdapter adapter = new CustomAdapter(this, drawables, brands);
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
                Toast.makeText(AutoCompleteCustomAdapter.this, (CharSequence) parent.getItemAtPosition(position), Toast.LENGTH_SHORT).show();
            }
        });

    }

}
