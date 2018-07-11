package com.ksemin.realemexample;

import io.realm.RealmObject;
public class Informations extends RealmObject {

    String name,Blood_group;
    String age;
    String gender;

    @Override
    public String toString() {
        return "Information{" +
                "name='" + name + '\'' +
                ",Blood_group ='" + Blood_group + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name1) {
        this.name = name1;
    }

    public String getBlood_group() {
        return Blood_group;
    }

    public void setBlood_group(String Blood_group1) {
        this.Blood_group = Blood_group1;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age1) {
        this.age = age1;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender1) {
        this.gender = gender1;
    }
}
