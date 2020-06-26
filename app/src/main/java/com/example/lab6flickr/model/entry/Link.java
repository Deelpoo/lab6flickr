package com.example.lab6flickr.model.entry;

import org.simpleframework.xml.Attribute;

import java.io.Serializable;

public class Link implements Serializable {

    @Attribute(name = "rel")
    private String rel;
    @Attribute (name = "type")
    private String type;
    @Attribute (name = "href")
    private String href;

    public Link() {   }

    public Link(String rel, String type, String href) {
        this.rel = rel;
        this.type = type;
        this.href = href;
    }

    public String getRel() {
        return rel;
    }

    public void setRel(String rel) {
        this.rel = rel;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    @Override
    public String toString() {
        return "Link{" +
                "rel='" + rel + '\'' +
                ", type='" + type + '\'' +
                ", href='" + href + '\'' +
                '}';
    }
}
