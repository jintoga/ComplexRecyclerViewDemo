package com.dat.complexrecyclerviewdemo.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DAT on 2/13/2017.
 */

public class MyGroupItem {
    private long id;
    private String text;

    public final List<MyItem> children;

    public MyGroupItem(long id, String text) {
        this.id = id;
        this.text = text;
        this.children = new ArrayList<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
