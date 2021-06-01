package cz.educanet.jaxrs;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;

@ApplicationScoped
public class ZooManager {
    static ArrayList<Animal> animals = new ArrayList<>();

    public ArrayList<Animal> getAnimal(){
        return animals;
    }
}