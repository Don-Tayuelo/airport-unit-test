package com.tdd.airport;

public class EconomyFlight extends Flight {

    public EconomyFlight(String _id){
        super(_id);
    }

    @Override
    public boolean addPassenger(Passenger passenger) {
        return passengersList.add(passenger);
    }

    @Override
    public boolean removePassenger(Passenger passenger) {
        if(passenger.isVip()) return false; {
            return passengersList.remove(passenger);
        }
    }
}
