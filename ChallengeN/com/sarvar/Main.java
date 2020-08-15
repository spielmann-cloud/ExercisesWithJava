package com.sarvar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Wonderful hope1 = new Wonderful("Hope", Wonderful.Power.HOPE);
        Wonderful hope2 = new Wonderful("Believe", Wonderful.Power.HOPE);
        Wonderful hope3 = new Wonderful("Atom", Wonderful.Power.TRUST);

        ArrayList<Wonderful> list = new ArrayList<>();
        list.add(hope1);
        list.add(hope2);
        list.add(hope3);

        Collections.sort(list);

        for(Wonderful w : list) {
            System.out.println(w.getName());
        }



        Map<Wonderful, String> map = new HashMap<>();
        map.put(hope1, "Hope1");
        map.put(hope2,"Hope2");
        for(Wonderful wonderful : map.keySet()) {
            System.out.println(map.get(wonderful));
        }

        if(hope2.equals(hope1)) {
            System.out.println("YES");
        } else
            System.out.println("NO");
    }
}
class Wonderful implements Comparable<Wonderful>{
    private final String name;
    private final Power power;

    public Wonderful(String name, Power power){
        this.name = name;
        this.power = power;
    }

    public String getName() {
        return name;
    }

    public Power getPower() {
        return power;
    }

    public enum Power{
       HOPE,
        TRUST
    }
    @Override
    public final boolean equals(Object obj) {
        System.out.println("Equals running of " + getName());
        if(this == obj)
            return true;

        if(obj instanceof Wonderful) {
            if(((Wonderful) obj).getName().equals(this.getName())){
                return ((Wonderful) obj).getPower() == this.getPower();
            }
        }

        return false;
    }
    @Override
    public final int hashCode() {
        System.out.println("Hashcode running of " + getName());
        return getName().hashCode() + getPower().hashCode() + 13;
    }

    @Override
    public String toString() {
        return "Wonderful{" +
                "name='" + name + '\'' +
                ", power=" + power +
                '}';
    }

    @Override
    public int compareTo(Wonderful o) {
        if(o == this)
            return 0;

        if(o != null) {
            return this.name.compareTo(o.getName());
        }

        throw new NullPointerException();
    }
}