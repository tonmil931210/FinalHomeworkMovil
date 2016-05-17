package com.augustosalazar.as_android_importantlibraries;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by Milton Casanova G on 16/05/2016.
 */

@DatabaseTable(tableName = "user")
public class User {
    public User(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    public User(){}
    @DatabaseField(generatedId = true)
    private Long id;

    @DatabaseField
    private String name;

    @DatabaseField
    private String lastName;

    public String getName() {
        return this.name;
    }

    public void setName(String firstName) {
        this.name = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String toString() {
        return this.name + "-" + this.lastName;
    }

}