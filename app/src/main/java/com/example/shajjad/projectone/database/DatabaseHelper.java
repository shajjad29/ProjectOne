package com.example.shajjad.projectone.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.shajjad.projectone.model.Student;

import java.util.ArrayList;


/**
 * Created by SHAJJAD on 14-Oct-17.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DB_NAME = "shajjad.projectOne";

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        TableAttributes obj = new TableAttributes();
        String query = obj.tableCreation();
        try {
            db.execSQL(query);
            Log.i("Table Create", "Hoise");
        } catch (SQLException e) {
            Log.e("SQL Error", e.toString());
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void registerNewStudent(Student std) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(TableAttributes.STUDENT_NAME, std.getName());
        contentValues.put(TableAttributes.STUDENT_PASSWORD, std.getPassword());
        contentValues.put(TableAttributes.STUDENT_EMAIL, std.getEmail());
        contentValues.put(TableAttributes.STUDENT_PHONE, std.getPhone());
        contentValues.put(TableAttributes.STUDENT_GENDER, std.getGender());
        contentValues.put(TableAttributes.STUDENT_CGPA, std.getCgpa());
        contentValues.put(TableAttributes.STUDENT_ID, std.getId());


        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        try {
            sqLiteDatabase.insert(TableAttributes.TABLE_NAME, null, contentValues);
            Log.i("InsertDone", "Hoise");
        } catch (SQLException e) {
            Log.e("Insert Error", e.toString());
        }
    }

    public String getPassByEmail(String email) {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        String query = "SELECT password From " + TableAttributes.TABLE_NAME + " Where " + TableAttributes.STUDENT_EMAIL + " = '" + email + "'";
        Cursor cursor = sqLiteDatabase.rawQuery(query, null);
        if (cursor.getCount() < 1) {
            cursor.close();
            return null;
        } else {
            cursor.moveToFirst();
            String pass = cursor.getString(cursor.getColumnIndex(TableAttributes.STUDENT_PASSWORD));
            cursor.close();
            return pass;
        }

    }

    public Student getSingleStudentByEmail(String email) {
        Student student = new Student();
        String query = "SELECT * From " + TableAttributes.TABLE_NAME + " Where " + TableAttributes.STUDENT_EMAIL + " = '" + email + "'";
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        Cursor cursor = sqLiteDatabase.rawQuery(query, null);
        cursor.moveToFirst();

        student.setName(cursor.getString(cursor.getColumnIndex(TableAttributes.STUDENT_NAME)));
        student.setPassword(cursor.getString(cursor.getColumnIndex(TableAttributes.STUDENT_PASSWORD)));
        student.setId(cursor.getString(cursor.getColumnIndex(TableAttributes.STUDENT_ID)));
        student.setEmail(cursor.getString(cursor.getColumnIndex(TableAttributes.STUDENT_EMAIL)));
        student.setPhone(cursor.getString(cursor.getColumnIndex(TableAttributes.STUDENT_PHONE)));
        student.setGender(cursor.getString(cursor.getColumnIndex(TableAttributes.STUDENT_GENDER)));
        student.setCgpa(Double.parseDouble(cursor.getString(cursor.getColumnIndex(TableAttributes.STUDENT_CGPA))));

        cursor.close();
        return student;
    }

    public ArrayList<Student> getAllStudent() {
        ArrayList<Student> students = new ArrayList<>();
        String query = "SELECT * From " + TableAttributes.TABLE_NAME + "";
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        Cursor cursor = sqLiteDatabase.rawQuery(query, null);
        cursor.moveToFirst();
        if (cursor.getCount() > 0) {
            while (!cursor.isAfterLast()) {
                Student student = new Student();
                student.setName(cursor.getString(cursor.getColumnIndex(TableAttributes.STUDENT_NAME)));
                student.setPassword(cursor.getString(cursor.getColumnIndex(TableAttributes.STUDENT_PASSWORD)));
                student.setId(cursor.getString(cursor.getColumnIndex(TableAttributes.STUDENT_ID)));
                student.setEmail(cursor.getString(cursor.getColumnIndex(TableAttributes.STUDENT_EMAIL)));
                student.setPhone(cursor.getString(cursor.getColumnIndex(TableAttributes.STUDENT_PHONE)));
                student.setGender(cursor.getString(cursor.getColumnIndex(TableAttributes.STUDENT_GENDER)));
                student.setCgpa(Double.parseDouble(cursor.getString(cursor.getColumnIndex(TableAttributes.STUDENT_CGPA))));
                students.add(student);
                cursor.moveToNext();
            }
        }
                cursor.close();
                return students;


        }
    }




