package cz.educanet.jaxrs;

import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

@SessionScoped
public class Animal implements Serializable {

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType(String nazev) {
        return nazev;
    }

    public void setType(String type) {
        this.type = type;
    }

    private String id;
    private String name;
    private String type;


}
