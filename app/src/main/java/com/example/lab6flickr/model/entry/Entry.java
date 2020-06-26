package com.example.lab6flickr.model.entry;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.io.Serializable;
import java.util.List;

@Root(name = "entry", strict = false)
public class Entry implements Serializable {

    @Element(name = "title")
    private String title;

    @Element(name = "published")
    private String published;

    @ElementList(required= false, inline = true, name = "link")
    private List<Link> links;

    public Entry() {   }

    public Entry(String title, String published, List<Link> links) {
        this.title = title;
        this.published = published;
        this.links = links;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublished() {
        return published;
    }

    public void setPublished(String published) {
        this.published = published;
    }

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }

    @Override
    public String toString() {
        return "Entry{" +
                "title='" + title + '\'' +
                ", published='" + published + '\'' +
                ", link='" + links + '\'' +
                '}'+"\n\n";
    }
}
