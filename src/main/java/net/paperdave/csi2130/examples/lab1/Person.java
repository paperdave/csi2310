package net.paperdave.csi2130.examples.lab1;

/**
 * A person. This is a simple class that represents a person for {@link Lab1}
 */
class Person {
    private String name;
    private int age;
    private int yearsOfExperience;
    private boolean applied;

    public Person(String name, int age, int years, boolean applied) {
        this.name = name;
        this.age = age;
        this.yearsOfExperience = years;
        this.applied = applied;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public boolean isApplied() {
        return applied;
    }

    public void setApplied(boolean applied) {
        this.applied = applied;
    }

    public void addYearsOfExperience(int years) {
        this.yearsOfExperience += years;
    }

    public void apply() {
        this.applied = true;
    }
}
