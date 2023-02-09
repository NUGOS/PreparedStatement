package ua.goit.preparedstatement.model;

public enum Level {
    TRAINEE("Trainee"),
    JUNIOR("Junior"),
    MIDDLE("Middle"),
    SENIOR("Senior");
    private final String name;

    Level(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
