package com.fathuriady.torupiah;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import static com.fathuriady.torupiah.R.id.btnKonversi;

public class MainActivity extends AppCompatActivity {
    EditText edtxtInput;
    TextView txtHasil;
    Spinner spinner;
    Double nilai;
    ArrayAdapter<CharSequence> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtxtInput = (EditText) findViewById(R.id.edtxtNominal);
        txtHasil = (TextView) findViewById(R.id.txtHasil);

        spinner = (Spinner) findViewById(R.id.spinner);
        adapter = ArrayAdapter.createFromResource(this,R.array.matauang,android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0){
                    nilai = 13360.00;
                }
                if(position == 1){
                    nilai = 117.74;
                }
                if(position == 2){
                    nilai = 3002.81;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        Button btnKonversi = (Button) findViewById(R.id.btnKonversi);

        btnKonversi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double inp = Double.parseDouble(edtxtInput.getText().toString());
                Double hasil = inp * nilai;
                txtHasil.setText(hasil.toString());
            }
        });
    }
}
