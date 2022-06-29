/*
Java activity for adding new expense, this take the user information converts items to strings as
needed.
 */

package com.example.expenseapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {

    EditText expense_type_input, date_input, amount_input;
    Button add_button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        expense_type_input = findViewById(R.id.expense_type_input);
        date_input = findViewById(R.id.date_input);
        amount_input = findViewById(R.id.amount_input);
        add_button = findViewById(R.id.add_button);
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(AddActivity.this);
                myDB.addExpense(expense_type_input.getText().toString().trim(),
                        date_input.getText().toString().trim(),Double.valueOf(amount_input.getText().toString().trim()));

            }
        });

    }
}