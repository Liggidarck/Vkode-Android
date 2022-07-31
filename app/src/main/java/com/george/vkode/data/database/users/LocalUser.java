package com.george.vkode.data.database.users;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "users_table")
public class LocalUser {

    @PrimaryKey(autoGenerate = true)
    int id;

    int userId;
    String firstName;
    String lastName;
    String maidenName;
    String screenName;
    int sex;
    int relation;
    String birthdate;
    int birthdateVisibility;
    String homeTown;
    String status;
    String phone;

    public LocalUser(int userId, String firstName, String lastName, String maidenName, String screenName, int sex, int relation, String birthdate, int birthdateVisibility, String homeTown, String status, String phone) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.maidenName = maidenName;
        this.screenName = screenName;
        this.sex = sex;
        this.relation = relation;
        this.birthdate = birthdate;
        this.birthdateVisibility = birthdateVisibility;
        this.homeTown = homeTown;
        this.status = status;
        this.phone = phone;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMaidenName() {
        return maidenName;
    }

    public String getScreenName() {
        return screenName;
    }

    public int getSex() {
        return sex;
    }

    public int getRelation() {
        return relation;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public int getBirthdateVisibility() {
        return birthdateVisibility;
    }

    public String getHomeTown() {
        return homeTown;
    }

    public String getStatus() {
        return status;
    }

    public String getPhone() {
        return phone;
    }
}
