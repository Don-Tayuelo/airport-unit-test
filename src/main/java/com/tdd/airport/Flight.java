package com.tdd.airport;

import java.util.ArrayList;
import java.util.List;

public abstract class Flight {

    private String _id;

    List<Passenger> passengersList = new ArrayList<Passenger>();

    public Flight (String _id){
        this._id = _id;
    }

    public String get_id() {return _id;}

    public List<Passenger> getPassengersList() {return passengersList;}

    public abstract boolean addPassenger(Passenger passenger);

    public abstract boolean removePassenger(Passenger passenger);
}
