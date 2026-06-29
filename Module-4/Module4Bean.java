package Java;

import java.io.Serializable;
import java.util.*;

//implement Serializable
public class Module4Bean implements Serializable {

    //assign private properties
    private List<String> name;
    private List<String> role;
    private List<String> actor;

    //create no-arg constructor
    public Module4Bean(){}

    //make public setters/getters
    public List<String> getName() {
        return name;
    }

    public void setName(List<String> name) {
        this.name = name;
    }

    public List<String> getRole() {
        return role;
    }

    public void setRole(List<String> role) {
        this.role = role;
    }

    public List<String> getActor() {
        return actor;
    }

    public void setActor(List<String> actor) {
        this.actor = actor;
    }

    public static void main(String[] args){
        Module4Bean bean = new Module4Bean();

        bean.setName(List.of("Chihiro", "Yubaba", "Zeniba", "Haku", "Boh"));
        bean.setRole(List.of("Protagonist", "Antagonist", "Mentor", "Deuteragonist", "Sidekick"));
        bean.setActor(List.of("Daveigh Chase", "Suzanne Pleshette", "Suzanne Pleshette", "Jason Marsden", "Tara Strong"));
    }

}

