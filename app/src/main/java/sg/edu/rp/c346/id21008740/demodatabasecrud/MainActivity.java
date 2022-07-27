package sg.edu.rp.c346.id21008740.demodatabasecrud;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnInsert, btnShowList;
    EditText etTitle, etSinger, etYear;
    RadioButton rdBt1, rdBt2, rdBt3, rdBt4, rdBt5;
    RadioGroup Star;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialize the variables with UI here
        btnInsert = findViewById(R.id.btnInsert);
        btnShowList = findViewById(R.id.btnShowList);
        etTitle = findViewById(R.id.etTitle);
        etSinger = findViewById(R.id.etSingers);
        etYear = findViewById(R.id.etYear);
        rdBt1 = findViewById(R.id.rdBtn1);
        rdBt2 = findViewById(R.id.rdBtn2);
        rdBt3 = findViewById(R.id.rdBtn3);
        rdBt4 = findViewById(R.id.rdBtn4);
        rdBt5 = findViewById(R.id.rdBtn5);


        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
            String title = etTitle.getText().toString();
            String singer = etSinger.getText().toString();
            int year = Integer.valueOf(etYear.getText().toString());
            int stars = 0;
            if (rdBt1.isChecked()) {
                {
                    stars = 1;
                }
            }else if(rdBt2.isChecked()){
                {stars = 2;}
            }else if(rdBt3.isChecked()){
                {stars = 3;}
            }else if(rdBt4.isChecked()){
                {stars = 4;}
            }else if(rdBt5.isChecked()){
                {stars = 5;}

                DBHelper dbHelper = new DBHelper((MainActivity.this));
                dbHelper.insertSong(title, singer, year, stars);

                Toast.makeText(MainActivity.this, "Insert successfully",
                        Toast.LENGTH_SHORT).show();
            }
            }
        });


        btnShowList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, ListActivity.class);
                startActivity(i);
            }
        });

    }
}