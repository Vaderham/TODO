package com.example.reaganharper.todo;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder>{

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView todoTextView;
        public TextView date;
        public CheckBox mDone;

        public ViewHolder(View itemView) {
            super(itemView);

            todoTextView = itemView.findViewById(R.id.text);
            date = itemView.findViewById(R.id.date);
            mDone = itemView.findViewById(R.id.done);
        }
    }

    private List<ToDoItem> ToDoItemList;
    private Context mContext;
    private OnCheckboxTickListener mOnCheckboxTickListener;

    public RecyclerAdapter(Context context, List<ToDoItem> ToDoItems, OnCheckboxTickListener onCheckboxTickListener) {
        ToDoItemList = ToDoItems;
        mContext = context;
        mOnCheckboxTickListener = onCheckboxTickListener;
    }

    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View todoview = inflater.inflate(R.layout.list_view_layout, parent, false);
        ViewHolder viewHolder = new ViewHolder(todoview);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerAdapter.ViewHolder viewHolder, final int position) {
        ToDoItem toDoItem = ToDoItemList.get(position);

        TextView textView = viewHolder.todoTextView;
        TextView dateView = viewHolder.date;
        CheckBox checkBox = viewHolder.mDone;

        checkBox.setChecked(false);

        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mOnCheckboxTickListener.onItemCheck(position);
            }
        });

        textView.setText(toDoItem.getName());

        String dateString = new SimpleDateFormat("dd/MM/yyyy").format(new Date(toDoItem.getDate()));

        dateView.setText(dateString);
    }

    @Override
    public int getItemCount() {
        return ToDoItemList.size();
    }
}