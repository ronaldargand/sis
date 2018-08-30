package com.example.angeliv.sis;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.support.v7.widget.Toolbar;

public class DetailMobil extends AppCompatActivity {

    Toolbar mToolbar;
    ImageView flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_mobil);

        mToolbar = (Toolbar) findViewById(R.id.toolbar1);
        flag = (ImageView) findViewById(R.id.imageView);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null){
            mToolbar.setTitle(bundle.getString("CarName"));

            if(mToolbar.getTitle().toString().equalsIgnoreCase("Jazz")){
                flag.setImageDrawable(ContextCompat.getDrawable(DetailMobil.this, R.drawable.jazz));
            };
        }
    }
}
