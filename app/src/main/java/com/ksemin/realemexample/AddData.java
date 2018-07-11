package com.ksemin.realemexample;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import java.util.Date;
import io.realm.Realm;
import io.realm.RealmConfiguration;

public class AddData extends AppCompatActivity {
    EditText name,age,Blood_group,gender;
    Realm realm;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addview);
        name = (EditText)findViewById(R.id.name);
        age = (EditText)findViewById(R.id.age);
        Blood_group= (EditText)findViewById(R.id.Blood_group);
        gender = (EditText)findViewById(R.id.gender);

        Realm.init(this);    //initialize to access database for this activity  //create a object for read and write database
        try{
            realm = Realm.getDefaultInstance();

        }catch (Exception e){

            // Get a Realm instance for this thread
            RealmConfiguration config = new RealmConfiguration.Builder()
                    .deleteRealmIfMigrationNeeded()
                    .build();
            realm = Realm.getInstance(config);

        }
        findViewById(R.id.addbtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                realm.beginTransaction();  //open the database
                //database operation
                Informations obj = realm.createObject(Informations.class);  //this will create a
             //   information object which will be inserted in dtabase

                obj.setName(name.getText().toString());
                obj.setAge(age.getText().toString());
                obj.setBlood_group(Blood_group.getText().toString());
                obj.setGender(gender.getText().toString());   //inserted all data to database
                realm.commitTransaction(); //close the database
                finish();
            }
        });
    }
}
