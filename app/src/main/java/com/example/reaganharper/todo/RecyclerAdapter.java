package com.example.reaganharper.todo;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder>{

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView todoTextView;
        public CheckBox mDone;

        public ViewHolder(View itemView) {
            super(itemView);

            todoTextView = itemView.findViewById(R.id.text);
            mDone = itemView.findViewById(R.id.done);
        }
    }

    private List<ToDoItem> ToDoItemList;
    private Context mContext;

    public RecyclerAdapter(Context context, List<ToDoItem> ToDoItems) {
        ToDoItemList = ToDoItems;
        mContext = context;
    }

    private Context getContext() {
        return mContext;
    }

    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View contactView = inflater.inflate(R.layout.list_view_layout, parent, false);

        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerAdapter.ViewHolder viewHolder, int position) {
        ToDoItem toDoItem = ToDoItemList.get(position);

        TextView textView = viewHolder.todoTextView;
        textView.setText(toDoItem.getName());
    }

    @Override
    public int getItemCount() {
        return ToDoItemList.size();
    }
}
