package com.example.lab6flickr.model;

import androidx.annotation.NonNull;

import com.example.lab6flickr.model.entry.Entry;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.io.Serializable;
import java.util.List;

@Root(name = "feed", strict = false)
public class Feed implements Serializable {

    @Element(name = "title")
    private String title;

    @ElementList(inline = true, name = "entry")
    private List<Entry> entrys;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Entry> getEntrys() {
        return entrys;
    }

    public void setEntrys(List<Entry> entrys) {
        this.entrys = entrys;
    }

    @NonNull
    @Override
    public String toString() {
        return "Feed: \n [Entrys" + entrys + "]";
    }
}
