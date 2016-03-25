package es.age.apps.autocompletetextview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Adrián García Espinosa on 25/3/16.
 */
public class CustomAdapter extends ArrayAdapter<String> {
    private LayoutInflater layoutInflater;
    private ArrayList<String> items;
    private ArrayList<String> allItems;
    private ArrayList<String> suggestions;
    private int[] drawableIds;



    public CustomAdapter(Context context, int[] drawables, ArrayList<String> stringList) {
        super(context, R.layout.custom_item, stringList);
        this.items = stringList;
        allItems = (ArrayList<String>) items.clone();
        suggestions = new ArrayList<String>();
        this.drawableIds = drawables;
        layoutInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = layoutInflater.inflate(R.layout.custom_item, null);
        }
        //SetUp Custom Item Views
        TextView name = (TextView) view.findViewById(R.id.autoCompleteItem);
        ImageView image = (ImageView) view.findViewById(R.id.autoCompleteDrawable);
        name.setText(items.get(position));
        image.setImageResource(drawableIds[position]);
        return view;
    }

    @Override
    public Filter getFilter() {
        return mFilter;
    }


    //Set a custom filter to the adapter
    public Filter mFilter = new Filter() {

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            if (constraint != null) {
                suggestions.clear();
                for (String s : allItems) {
                    if (s.toLowerCase().startsWith(constraint.toString().toLowerCase())) {
                        suggestions.add(s);
                    }
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = suggestions;
                filterResults.count = suggestions.size();
                return filterResults;
            } else {
                return new FilterResults();
            }
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            ArrayList<String> filteredList = (ArrayList<String>) results.values;
            if (results != null && results.count > 0) {
                clear();
                for (String s : filteredList) {
                    add(s);
                }
                notifyDataSetChanged();
            }
        }

    };
}
