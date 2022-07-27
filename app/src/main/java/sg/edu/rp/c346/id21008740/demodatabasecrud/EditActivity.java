package sg.edu.rp.c346.id21008740.demodatabasecrud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class EditActivity extends AppCompatActivity {

    TextView tvID;
    EditText etTitle, etSingers, etYear;
    RadioGroup Stars;
    RadioButton rdBt1, rdBt2, rdBt3, rdBt4, rdBtn5;
    Button btnUpdate, btnDelete, btnCancel;
    Songps data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        //initialize the variables with UI here
        tvID = findViewById(R.id.tvID);
        etTitle = findViewById(R.id.etTitle);
        etSingers = findViewById(R.id.etSingers);
        etYear = findViewById(R.id.etYear);
        Stars = findViewById(R.id.Stars);
        rdBt1 = findViewById(R.id.rdBtn1);
        rdBt2 = findViewById(R.id.rdBtn2);
        rdBt3 = findViewById(R.id.rdBtn3);
        rdBt4 = findViewById(R.id.rdBtn4);
        rdBtn5 = findViewById(R.id.rdBtn5);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnDelete = findViewById(R.id.btnDelete);
        btnUpdate = findViewById(R.id.btnUpdate);

        Intent i = getIntent();
        data = (Songps) i.getSerializableExtra("data");

        tvID.setText("ID: " + data.getId());
        etTitle.setText(data.getTitle());
        etSingers.setText(data.getSingers());
        etYear.setText(data.getYear());

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int stars = 0;
                if(rdBt1.isChecked()){
                    stars = 1;
                } else if(rdBt2.isChecked()){
                    stars = 2;
                }else if(rdBt3.isChecked()) {
                    stars = 3;
                }else if(rdBt4.isChecked()) {
                    stars = 4;
                }else if(rdBtn5.isChecked()) {
                    stars = 5;
                }
                DBHelper dbh = new DBHelper(EditActivity.this);
                data.setTitle(etTitle.getText().toString());
                data.setSingers((etSingers.getText().toString()));
                data.setYear(Integer.valueOf(etYear.getText().toString()));
                data.setStars(Integer.valueOf(stars));
                dbh.updateSong(data);
                dbh.close();
                finish();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(EditActivity.this);
                dbh.deleteNote(data.getId());
                finish();
            }
        });
        btnCancel.setOnClickListener(new  View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


}