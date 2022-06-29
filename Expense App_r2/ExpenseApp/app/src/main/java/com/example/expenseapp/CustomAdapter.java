/*
Main screen with view recycler.
 */

package com.example.expenseapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.icu.text.NumberFormat;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
    //Using arraylists for the Recycler views as needed.
    private Context context;
    private ArrayList expense_id, expense_type, expense_date, expense_amount;
    private static final android.icu.text.NumberFormat currencyFormat =
            NumberFormat.getCurrencyInstance();

    CustomAdapter (Context context, ArrayList expense_id,
                   ArrayList expense_type, ArrayList expense_date,
                   ArrayList expense_amount) {

        this.context = context;
        this.expense_id = expense_id;
        this.expense_type = expense_type;
        this.expense_date = expense_date;
        this.expense_amount = expense_amount;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.MyViewHolder holder, int position) {
        holder.expense_id_text.setText(String.valueOf(expense_id.get(position)));
        holder.expense_type_text.setText(String.valueOf(expense_type.get(position)));
        holder.expense_date_text.setText(String.valueOf(expense_date.get(position)));
        holder.expense_amount_text.setText(String.valueOf(expense_amount.get(position)));


    }

    @Override
    public int getItemCount() {
        return expense_id.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView expense_id_text, expense_type_text, expense_date_text, expense_amount_text;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            expense_id_text = itemView.findViewById(R.id.expense_id_text);
            expense_type_text = itemView.findViewById(R.id.expense_type_text);
            expense_date_text = itemView.findViewById(R.id.expense_date_text);
            expense_amount_text = itemView.findViewById(R.id.expense_amount_text);




        }
    }
}
