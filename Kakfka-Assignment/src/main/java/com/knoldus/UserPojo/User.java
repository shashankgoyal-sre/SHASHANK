package com.knoldus.UserPojo;

public class User {

    //User class fields

    private int user_id;
    private int user_age;
    private String user_name;
    private String user_course;


    public User()
    {}




    public User(int user_id, int age, String user_name, String user_course) {

        //Arg-constructor to initialize fields

        this.user_id = user_id;
        this.user_age = age;
        this.user_name = user_name;
        this.user_course = user_course;

    }

    //Getters for user class fields

    public int getUser_id() {
        return user_id;
    }

    public int getUser_age() {
        return user_age;
    }

    public String getUser_name() {
        return user_name;
    }

    public String getUser_course() {
        return user_course;
    }
}
