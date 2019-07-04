package com.tdd.airport;

public class PremiumFlight extends Flight {

    public PremiumFlight(String _id) {
        super(_id);
    }

    @Override
    public boolean addPassenger(Passenger passenger) {
        return (passenger.isVip()) ? passengersSet.add(passenger) : false;
    }

    @Override
    public boolean removePassenger(Passenger passenger) {
        return (passenger.isVip()) ? passengersSet.remove(passenger) : false;
    }
}
