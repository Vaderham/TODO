package com.example.reaganharper.todo;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.my_toolbar) Toolbar myToolbar;
    @BindView(R.id.recycle) RecyclerView recyclerView;
    RecyclerAdapter mAdapter;

    private static final int RESPONSE_CODE = 1;

    private List<ToDoItem> todolist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        // Lookup the recyclerview in activity layout

        todolist = new ArrayList<>();

        // Create adapter passing in the sample user data
        mAdapter = new RecyclerAdapter(this, todolist);
        // Attach the adapter to the recyclerview to populate items
        recyclerView.setAdapter(mAdapter);
        // Set layout manager to position the items
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        // That's all!


        FloatingActionButton button = findViewById(R.id.go);

        setSupportActionBar(myToolbar);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intent = new Intent(view.getContext(), AddItem.class);
                startActivityForResult(intent, RESPONSE_CODE);
            }
        });



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == RESPONSE_CODE) {
            if (resultCode == RESULT_OK) {
                ToDoItem result = data.getParcelableExtra("todo");
                todolist.add(result);
                Log.v("TESTER", todolist.get(0).getName().toString());
                updateAdapter();
            }
        }
    }

    public void removeToDo(int position){
        todolist.remove(position);
        updateAdapter();
    }

    public void updateAdapter(){
        mAdapter.notifyDataSetChanged();
    }

}
