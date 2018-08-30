package com.example.angeliv.sis;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

public class PerhitunganKredit extends AppCompatActivity {
    EditText input;
    TextView tdp, phmurni, provisi, totalhutang;
    int count,hasil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perhitungan_kredit);
        input = (EditText) findViewById(R.id.edit_otr);
        tdp = (TextView)findViewById((R.id.edit_tdp));
        phmurni = (TextView)findViewById((R.id.edit_phmurni));
        provisi = (TextView)findViewById((R.id.edit_provisi));
        totalhutang = (TextView)findViewById((R.id.edit_totalhutang));

        //input.setText("1000000");
        input.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String a = input.getText().toString();
                if(a.matches(""))
                {
                    tdp.setText("tdk bole nol");
                }
                else{
                    long resulttdp = Long.parseLong(a) * 3/10;
                    tdp.setText(String.valueOf(resulttdp));

                    long resultphmurni = Long.parseLong(a) - resulttdp;
                    phmurni.setText(String.valueOf(resultphmurni));

                    long resultprovisi = resultphmurni * 5/100 ;
                    provisi.setText(String.valueOf(resultprovisi));

                    long resulttotalhutang = resultphmurni + resultprovisi ;
                    totalhutang.setText(String.valueOf(resulttotalhutang));
                }
            }
        });

    }



}
