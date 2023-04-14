package gameplay;

public class Character {
    private String name = "Mx.Incognito";
    private RaceManager.Race race = RaceManager.DEFAULT_RACE;
    private ProfessionManager.Profession profession = ProfessionManager.DEFAULT_PROFESSION;
    private long currentHealth;
    private int currentEnergy;
    private long experience = 0;


    public long getLevel() {
        return calculateLevel();
    }
    private long calculateLevel() {
        if (experience <= 0) {
            return 1;
        }
        return (long) Math.floor(Math.sqrt(experience) * 0.07) + 1;
    }
    public void setExperience(long experience) {
        this.experience = experience;
    }

    public long getMaxHealth() {
        return ProfessionManager.getHealthBonus(profession) * getLevel();
    }
    public long getPower() {
        return ProfessionManager.getPowerBonus(profession) * getLevel();
    }
    public long getDefense() {
        return ProfessionManager.getDefenseBonus(profession) * getLevel();
    }
    public long getMaxEnergy() {
        return 100;
    }


    public void setName(String name) {
        this.name = name;
    }
    public void setRace(RaceManager.Race race) {
        this.race = race;
    }
    public RaceManager.Race getRace() {
        return race;
    }
    public void setProfession(ProfessionManager.Profession profession) {
        this.profession = profession;
    }
    public ProfessionManager.Profession getProfession() {
        return profession;
    }
}
