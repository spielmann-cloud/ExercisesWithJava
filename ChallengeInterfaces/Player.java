import java.util.ArrayList;
import java.util.List;

public class Player implements ISaveable{
    public int hitPoints;
    public int strength;
    public String weapon;
    private String name;

    public Player(int hitPoints, int strength, String name) {
        this.hitPoints = hitPoints;
        this.strength = strength;
        this.name = name;
        this.weapon = "Morgenstern";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    @Override
    public String toString() {
        return "Player{" +
                "hitPoints=" + hitPoints +
                ", strength=" + strength +
                ", weapon='" + weapon + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public List<String> write() {
        List<String> myList = new ArrayList<String>();
        myList.add(name);
        myList.add(hitPoints + " ");
        myList.add(weapon);
        myList.add(strength + " ");

        return myList;
    }

    @Override
    public void read(List<String> list) {
        if(list != null && list.size() == 4) {
            this.name = list.get(0);
            this.hitPoints = Integer.parseInt(list.get(1));
            this.strength = Integer.parseInt(list.get(3));
            this.weapon = list.get(2);
        } else {
            System.out.println("Gotta trouble");
        }
    }

}
