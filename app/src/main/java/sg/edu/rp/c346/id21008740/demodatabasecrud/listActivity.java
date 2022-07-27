package sg.edu.rp.c346.id21008740.demodatabasecrud;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class listActivity extends AppCompatActivity {
    Button btnShowSongs, btn5Stars;
    ListView lv;
    ArrayList<Songps> alS;
    ArrayList<Songps> alS2;
    ArrayAdapter<Songps> AA;
    CustomeAdapter adapter;


    @Override
    protected void onResume() {
        super.onResume();

        btnShowSongs.performClick();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listactivity);

        //initialize the variables with UI here
        lv = findViewById(R.id.listView);
        btnShowSongs = findViewById(R.id.btnShowSongs);
        btn5Stars = findViewById(R.id.btn5stars);

        alS = new ArrayList<Songps>();
        alS2 = new ArrayList<Songps>();
        ArrayList<String> str = new ArrayList<String>();
        adapter = new CustomeAdapter(this, R.layout.songrow, alS);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int
                    position, long identity) {
                Songps data = alS.get(position);
                Intent i = new Intent(listActivity.this,
                        EditActivity.class);
                i.putExtra("data",data);
                startActivity(i);
            }
        });

        btnShowSongs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(listActivity.this);
                alS.clear();
                alS.addAll(dbh.getAllSongs());

                adapter.notifyDataSetChanged();
            }
        });

        btn5Stars.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(listActivity.this);
                alS2.clear();
                ArrayList<Songps> list = dbh.getAllSongs();
                for (int i = 0; i < list.size(); i++ ) {
                    alS.add(list.get(i).toStringClass());
                    alS2.add(list.get(i));
                }
                lv.setAdapter(adapter);
            }
        });
    }
}
