import java.util.Random;

public class Character {
    private String characterType;
    private int healthPoints;
    private int attackStrength;
    private int defenseStrength;

    public Character(String type, int healthLimit) {
        characterType = type;
        Random randNumGen = new Random();
        healthPoints = randNumGen.nextInt(10, healthLimit);
        attackStrength = randNumGen.nextInt(50, 100);
        defenseStrength = randNumGen.nextInt(1, 10);
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int hp) {
        healthPoints = hp;
    }

    public void attack(Character target) {
        System.out.println("The " + this.characterType + " attacks the " + target.characterType + "!");
        int damage = attackStrength / defenseStrength;
        System.out.println("The " + target.characterType + " takes " + damage + " points of damage.");
        target.setHealthPoints(target.getHealthPoints() - damage);
    }

    public void printStats() {
        System.out.println("-- " + characterType + " --");
        System.out.println("Health: " + healthPoints);
        System.out.println("Attack Strength: " + attackStrength);
        System.out.println("Defense Strength: " + defenseStrength);
    }
}
