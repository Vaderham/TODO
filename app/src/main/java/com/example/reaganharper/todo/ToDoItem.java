package com.example.reaganharper.todo;

import android.os.Parcel;
import android.os.Parcelable;

public class ToDoItem implements Parcelable {

    private String name;
    private Long date;

    public ToDoItem(String name) {
        this.name = name;
    }

    public ToDoItem(String name, Long date) {
        this.name = name;
        this.date = date;
    }

    protected ToDoItem(Parcel in) {
        name = in.readString();
        date = in.readLong();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeLong(date);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<ToDoItem> CREATOR = new Parcelable.Creator<ToDoItem>() {
        @Override
        public ToDoItem createFromParcel(Parcel in) {
            return new ToDoItem(in);
        }

        @Override
        public ToDoItem[] newArray(int size) {
            return new ToDoItem[size];
        }
    };

    public String getName() {
        return name;
    }
}
