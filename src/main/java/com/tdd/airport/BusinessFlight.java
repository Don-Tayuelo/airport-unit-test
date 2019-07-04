package com.tdd.airport;

public class BusinessFlight extends Flight {

    public BusinessFlight(String _id){
        super(_id);
    }

    @Override
    public boolean addPassenger(Passenger passenger){
        if (!passenger.isVip()) return false; {
            return passengersSet.add(passenger);
        }
    }

    @Override
    public boolean removePassenger(Passenger passenger){
        return false;
    }
}
