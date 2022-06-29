/*
Helper class for SQLite database
 */

package com.example.expenseapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.icu.text.NumberFormat;
import android.widget.Toast;

import androidx.annotation.Nullable;
//Setting up the format for storing database information.
class MyDatabaseHelper extends SQLiteOpenHelper {
    private Context context;
    private static final  String DATABASE_NAME = "ExpenseReport.db";
    private static final int DATABASE_VERSION = 1;

    private static final  String TABLE_NAME = "my_expenses";
    private static final  String COLUMN_ID = "_id";
    private static final  String COLUMN_EXPENSE_TYPE = "expense_type";
    private static final  String COLUMN_DATE = "expense_date";
    private static final String COLUMN_EXPENSE = "expense_amount";

    private static final android.icu.text.NumberFormat currencyFormat =
            NumberFormat.getCurrencyInstance();


    public MyDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query =
                "CREATE TABLE " + TABLE_NAME + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        COLUMN_EXPENSE_TYPE + " TEXT, " +
                        COLUMN_DATE + " DATE, " +
                        COLUMN_EXPENSE + " DOUBLE);";
        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }
    //Adding expense information
    void addExpense (String expense, String date, Double amount) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_EXPENSE_TYPE,expense);
        cv.put(COLUMN_DATE,date);
        cv.put(COLUMN_EXPENSE,amount);
        long result = db.insert(TABLE_NAME, null, cv);
        if (result ==-1) {
            Toast.makeText(context,"Failed to add", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Expense Added!", Toast.LENGTH_SHORT).show();
        }

    }
    //reading the information from the database.
    Cursor readAllData(){
        String query = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db!=null) {
            cursor = db.rawQuery(query, null);

        }
        return cursor;
    }
}
