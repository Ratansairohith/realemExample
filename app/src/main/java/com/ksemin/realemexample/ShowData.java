package com.ksemin.realemexample;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import io.realm.Realm;
import io.realm.RealmResults;

public class ShowData extends AppCompatActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.showview);
        TextView show = (TextView)findViewById(R.id.show);
        Realm.init(this);
        Realm realm = Realm.getDefaultInstance(); //creating  database oject
        RealmResults<Informations> results = realm.where(Informations.class).findAllAsync();
        //fetching the data
        results.load();
        String output="";
        for(Informations informations:results){
            output+=informations.toString();
        }
        show.setText(output);
    }
}