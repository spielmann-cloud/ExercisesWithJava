package com.sarvar;

public class Planet extends HeavenlyBody {

    public Planet(String name, double orbitalPeriod) {
        super(name, orbitalPeriod, BodyType.PLANET);
    }

    @Override
    public boolean addSatellite(HeavenlyBody body) {
        if(body.getType() == BodyType.MOON) {
            super.addSatellite(body);
            return true;
        }
        return false;
    }
}
