package com.example.reaganharper.todo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AddItem extends AppCompatActivity {


    @BindView(R.id.name)
    EditText name;

    @BindView(R.id.date)
    CalendarView date;

    @BindView(R.id.my_toolbar) Toolbar myToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);
        ButterKnife.bind(this);

        setSupportActionBar(myToolbar);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_confirm:
                submitIntent();
                return true;

            default:
                return super.onOptionsItemSelected(item);

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actionbar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public ToDoItem getToDo(){
        String nameText = name.getText().toString();
        Long dateText = date.getDate();
        return new ToDoItem(nameText, dateText);
    }

    public void submitIntent(){
            Intent intent = new Intent();
            intent.putExtra("todo", getToDo());
            setResult(this.RESULT_OK, intent);
            finish();
    }

}
