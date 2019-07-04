package com.tdd.airport;

import java.util.*;

public abstract class Flight {
    private String _id;
    private int distance;
    Set<Passenger> passengersSet = new HashSet<>();

    public Flight(String _id) {
        this._id = _id;
    }

    public String get_id() {
        return _id;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public Set<Passenger> getPassengersSet() {
        return Collections.unmodifiableSet(passengersSet);
    }

    public abstract boolean addPassenger(Passenger passenger);

    public abstract boolean removePassenger(Passenger passenger);

}
