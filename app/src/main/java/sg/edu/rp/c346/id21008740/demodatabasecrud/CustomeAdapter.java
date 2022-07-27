package sg.edu.rp.c346.id21008740.demodatabasecrud;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomeAdapter extends ArrayAdapter {
    Context parent_CT;
    int layout_id;
    ArrayList<Songps> songList;

    public CustomeAdapter(Context context, int resource, ArrayList<Songps> objects) {
        super(context, resource, objects);

        parent_CT = context;
        layout_id = resource;
        songList = objects;
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        // Obtain the LayoutInflater object
        LayoutInflater inflater = (LayoutInflater)
                parent_CT.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // "Inflate" the View for each row
        View rowView = inflater.inflate(layout_id, parent, false);

        // Obtain the UI components and do the necessary binding
        TextView TitleName = rowView.findViewById(R.id.tvName);
        TextView SingerName = rowView.findViewById(R.id.tvName2);
        TextView Year = rowView.findViewById(R.id.tvsongList);
        TextView Rating = rowView.findViewById(R.id.tvsongList2);



       Songps currentSongs = songList.get(position);

        // Set values to the TextView to display the corresponding information

        TitleName.setText("Title: " + currentSongs.getTitle());
        SingerName.setText("Singer: " + currentSongs.getSingers());
        Rating.setText("Rating: " + String.valueOf(currentSongs.getStars())+ " *");
        Year.setText("Year: " + String.valueOf(currentSongs.getYear()));

        return rowView;
    }


}
