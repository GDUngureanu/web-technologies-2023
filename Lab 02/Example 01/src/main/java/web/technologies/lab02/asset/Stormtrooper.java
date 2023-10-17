package web.technologies.lab02.asset;

public class Stormtrooper {

    private final String designation;
    private final String rank;
    private final String assignment;
    private final int combatSkillRating;
    private final String armory;

    public Stormtrooper(String designation, String rank, String assignment, int combatSkillRating, String armory) {
        this.designation = designation;
        this.rank = rank;
        this.assignment = assignment;
        this.combatSkillRating = combatSkillRating;
        this.armory = armory;
    }

    public void patrol() {
        System.out.println(rank + " Stormtrooper " + designation + ", armed with a " + armory + ", is now patrolling " + assignment + ".");
    }

}
