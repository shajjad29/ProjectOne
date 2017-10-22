package com.example.shajjad.projectone.database;

/**
 * Created by SHAJJAD on 14-Oct-17.
 */

public class TableAttributes {
    public  static final String TABLE_NAME="student";
    public static final String STUDENT_NAME="name";
    public static final String STUDENT_PASSWORD="password";
    public static final String STUDENT_ID="id";
    public static final String STUDENT_EMAIL="email";
    public static final String STUDENT_PHONE="phone";
    public static final String STUDENT_GENDER="gender";
    public static final String STUDENT_CGPA="cgpa";

    public String tableCreation(){
        String query="CREATE TABLE " + TABLE_NAME + "(" + STUDENT_NAME + " TEXT, " + STUDENT_PASSWORD + " TEXT, " + STUDENT_ID + " TEXT, " + STUDENT_EMAIL + " TEXT, " +
                STUDENT_PHONE + " TEXT, " + STUDENT_GENDER + " TEXT, " + STUDENT_CGPA + " TEXT)";

        return query;
    }


}
