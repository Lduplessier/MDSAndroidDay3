package fr.mds.demo_project.model;

public class ProgramingLanguage {

    private String name;

    @Override
    public String toString() {
        return name;
    }

    private String description;

    public ProgramingLanguage(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ProgramingLanguage(String name, String description) {
        this.name = name;
        this.description = description;
    }

}
