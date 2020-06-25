package com.example.lab6flickr.model.entry;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.io.Serializable;

@Root(name = "entry", strict = false)
public class Entry implements Serializable {

    @Element(name = "title")
    private String title;

    @Element(name = "published")
    private String published;

    @Element(required = false, name = "link")
    private Link link;

    public class Link {
        @Attribute (name = "rel")
        private String rel;
        @Attribute (name = "type")
        private String type;
        @Attribute (name = "href")
        private String href;
    }

    public Entry(String title, String published, Link link) {
        this.title = title;
        this.published = published;
        this.link = link;
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

    public Link getLink() {
        return link;
    }

    public void setLink(Link link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return "Entry{" +
                "title='" + title + '\'' +
                ", published='" + published + '\'' +
                ", link='" + link + '\'' +
                '}'+"\n\n";
    }
}
