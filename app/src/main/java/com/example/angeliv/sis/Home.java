package com.example.angeliv.sis;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Home extends AppCompatActivity implements View.OnClickListener{
    private CardView listmobilCard, perhitungankreditCard, profileCard, registerCard, logoutCard;
    Button btn_logout;
    TextView txt_id, txt_username;
    String id, username;
    SharedPreferences sharedpreferences;

    public static final String TAG_ID = "id";
    public static final String TAG_USERNAME = "username";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        txt_id = (TextView) findViewById(R.id.txt_id);
        txt_username = (TextView) findViewById(R.id.txt_username);
        //btn_logout = (Button) findViewById(R.id.btn_logout);

        sharedpreferences = getSharedPreferences(MainActivity.my_shared_preferences, Context.MODE_PRIVATE);

        id = getIntent().getStringExtra(TAG_ID);
        username = getIntent().getStringExtra(TAG_USERNAME);

        txt_id.setText("ID : " + id);
        txt_username.setText("USERNAME : " + username);
        // defining Cards
        listmobilCard = (CardView) findViewById(R.id.listmobil_card);
        perhitungankreditCard = (CardView) findViewById(R.id.perhitungankredit_card);
        profileCard = (CardView) findViewById(R.id.profile_card);
        registerCard = (CardView) findViewById(R.id.register_card);
        logoutCard = (CardView) findViewById(R.id.logout_card);
        // Add Click Listener to the cards
        listmobilCard.setOnClickListener(this);
        perhitungankreditCard.setOnClickListener(this);
        profileCard.setOnClickListener(this);
        registerCard.setOnClickListener(this);
        //logoutCard.setOnClickListener(this);

        logoutCard.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                // update login session ke FALSE dan mengosongkan nilai id dan username
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putBoolean(MainActivity.session_status, false);
                editor.putString(TAG_ID, null);
                editor.putString(TAG_USERNAME, null);
                editor.commit();

                Intent intent = new Intent(Home.this, MainActivity.class);
                finish();
                startActivity(intent);
            }
        });
    }

    @Override
    public void onClick(View v){
        Intent i;

        switch (v.getId()) {
            case R.id.listmobil_card: i = new Intent(this,ListMobil.class); startActivity(i); break;
            case R.id.perhitungankredit_card: i = new Intent(this,PerhitunganKredit.class); startActivity(i); break;
            case R.id.profile_card: i = new Intent(this,Profile.class); startActivity(i); break;
            case R.id.register_card: i = new Intent(this,Register.class); startActivity(i); break;
            //case R.id.logout_card: i = new Intent(this,MainActivity.class); startActivity(i); break;
            default:break;
        }
    }
}