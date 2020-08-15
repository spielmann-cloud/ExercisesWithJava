package com.sarvar;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by dev on 12/01/2016.
 */
public abstract class HeavenlyBody {
    private final String name;
    private final double orbitalPeriod;
    private final Set<HeavenlyBody> satellites;
    private final BodyType type;

    public enum BodyType {
        PLANET,
        MOON,
        ASTEROID,
        STAR,
        COMET
    }

    public BodyType getType() {
        return type;
    }

    public HeavenlyBody(String name, double orbitalPeriod, BodyType type) {
        this.name = name;
        this.orbitalPeriod = orbitalPeriod;
        this.satellites = new HashSet<>();
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public boolean addSatellite(HeavenlyBody body) {
        return this.satellites.add(body);
    }

    public Set<HeavenlyBody> getSatellites() {
        return new HashSet<>(this.satellites);
    }


    @Override
    public final boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }

        if(obj instanceof HeavenlyBody){
            if (this.getName().equals(((HeavenlyBody) obj).getName())){
                return this.getType() == ((HeavenlyBody) obj).getType();
            }
        }

        return false;
    }

    @Override
    public final int hashCode() {
        System.out.println("hashcode called");
        return this.name.hashCode() + 57 + this.getType().hashCode() ;
    }

    @Override
    public String toString() {
        return "Name: " + this.getName() + " BodyType " + this.getType() + " Orbital period : " + this.getOrbitalPeriod();
    }
}
