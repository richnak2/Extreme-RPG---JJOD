package org.example;

public class Character {
    private String name = "Unknown";
    private long health;
    private long stamina;
    private long defense;
    private long power;
    private Race race;
    private Profession profession;
    private long experience;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getHealth() {
        return health;
    }

    public void setHealth(long health) {
        this.health = health;
    }

    public long getDefense() {
        return defense;
    }

    public void setDefense(long defense) {
        this.defense = defense;
    }

    public long getPower() {
        return power;
    }

    public void setPower(long power) {
        this.power = power;
    }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public Profession getProfession() {
        return profession;
    }

    public void setProfession(Profession profession) {
        this.profession = profession;
    }

    public long getExperience() {
        return experience;
    }

    public void setExperience(long experience) {
        this.experience = experience;
    }
}
