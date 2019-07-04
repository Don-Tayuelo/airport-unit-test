package com.tdd.airport;

public class EconomyFlight extends Flight {

    public EconomyFlight(String _id){
        super(_id);
    }

    @Override
    public boolean addPassenger(Passenger passenger) {
        return passengersSet.add(passenger);
    }

    @Override
    public boolean removePassenger(Passenger passenger) {
        if(passenger.isVip()) return false; {
            return passengersSet.remove(passenger);
        }
    }
}
