package com.tdd.airport;

import org.junit.jupiter.api.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class AirportTest {

    @DisplayName("Given a business flight.")
    @Nested
    class BusinessFlightTest {
        private Flight businessFlight;
        private Passenger Mike;
        private Passenger Jhon;

        @BeforeEach
        void setUp() {
            businessFlight = new BusinessFlight("2");
            Mike = new Passenger("Mike", false);
            Jhon = new Passenger("Jhon", true);
        }

        @Nested
        @DisplayName("When we have an usual passenger.")
        class UsualPassenger {

            @Test
            @DisplayName("Then you can't add nor remove him from a business flight.")
            public void testBusinessFlightUsualPassenger(){

                assertAll("Verify all conditions for an usual passenger and an business flight.",
                        () -> assertEquals(false, businessFlight.addPassenger(Mike)),
                        () -> assertEquals(0, businessFlight.getPassengersSet().size()),
                        () -> assertEquals(false, businessFlight.removePassenger(Mike)),
                        () -> assertEquals(0, businessFlight.getPassengersSet().size()));
            }
        }

        @Nested
        @DisplayName("When we have a VIP passenger.")
        class VipPassenger {

            @Test
            @DisplayName("Then you can add him but not remove him from any flight.")
            public void testBusinessFlightVipPassenger(){

                assertAll("Verify all conditions for a VIP passenger and an business flight.",
                        () -> assertEquals(true, businessFlight.addPassenger(Jhon)),
                        () -> assertEquals(1, businessFlight.getPassengersSet().size()),
                        () -> assertEquals(false, businessFlight.removePassenger(Jhon)),
                        () -> assertEquals(1, businessFlight.getPassengersSet().size())
                );
            }

            @DisplayName("Then you can't add him to a business flight more than once")
            @RepeatedTest(5)
            public void testBusinessFlightVipPassengerAddedOnlyOnce(RepetitionInfo repetitionInfo) {
                for(int i = 0; i < repetitionInfo.getCurrentRepetition(); i++){
                    businessFlight.addPassenger(Jhon);
                }

                assertAll("Verify VIP passenger can be added only once to a business flight",
                        () -> assertEquals(1, businessFlight.getPassengersSet().size()),
                        () -> assertTrue(businessFlight.getPassengersSet().contains(Jhon)),
                        () -> assertTrue(new ArrayList<>(businessFlight.getPassengersSet()).get(0).getName().equals("Jhon"))
                );
            }
        }
    }

    @DisplayName("Given a economy flight.")
    @Nested
    class EconomyFlightTest   {
        private Flight economyFlight;
        private Passenger Mike;
        private Passenger Jhon;

        @BeforeEach
        void setUp() {
            economyFlight = new EconomyFlight("1");
            Mike = new Passenger("Mike", false);
            Jhon = new Passenger("Jhon", true);
        }

        @Nested
        @DisplayName("When we have an usual passenger.")
        class UsualPassenger {

            @Test
            @DisplayName("Then you can add and remove him from an economy flight.")
            public void testEconomyFlightUsualPassenger(){

                assertAll("Verify all conditions for an usual passenger and an economy flight.",
                        () -> assertEquals("1", economyFlight.get_id()),
                        () -> assertEquals(true, economyFlight.addPassenger(Mike)),
                        () -> assertEquals(1, economyFlight.getPassengersSet().size()),
                        () -> assertTrue(economyFlight.getPassengersSet().contains(Mike)),
                        () -> assertEquals(true, economyFlight.removePassenger(Mike)),
                        () -> assertEquals(0, economyFlight.getPassengersSet().size())
                        );
            }


            @DisplayName("Then you can't add him more than once")
            @RepeatedTest(5)
            public void testEconomyFlightUsualPassengerAddedOnlyOnce(RepetitionInfo repetitionInfo){
                for (int i = 0; i < repetitionInfo.getCurrentRepetition(); i++){
                    economyFlight.addPassenger(Mike);
                }

                assertAll("Verify an usual passenger can only be added to an economy flight once",
                        () -> assertEquals(1, economyFlight.getPassengersSet().size()),
                        () -> assertTrue(economyFlight.getPassengersSet().contains(Mike)),
                        () -> assertTrue(new ArrayList<>(economyFlight.getPassengersSet()).get(0).getName().equals("Mike"))
                );
            }
        }

        @Nested
        @DisplayName("When we have a VIP passenger.")
        class VipPassenger {

            @Test
            @DisplayName("Then you can add him but not remove him from any flight.")
            public void testEconomyFlightVipPassenger(){

                assertAll("Verify all conditions for a VIP passenger and an economy flight.",
                        () -> assertEquals("1", economyFlight.get_id()),
                        () -> assertEquals(true, economyFlight.addPassenger(Jhon)),
                        () -> assertEquals(1, economyFlight.getPassengersSet().size()),
                        () -> assertTrue(economyFlight.getPassengersSet().contains(Jhon)),
                        () -> assertEquals(false, economyFlight.removePassenger(Jhon)),
                        () -> assertEquals(1, economyFlight.getPassengersSet().size()));
            }

            @DisplayName("Then you can't add him more than once")
            @RepeatedTest(5)
            public void testEconomyFlightVipPassengerAddedOnlyOnce(RepetitionInfo repetitionInfo){
                for (int i = 0; i < repetitionInfo.getCurrentRepetition(); i++){
                    economyFlight.addPassenger(Jhon);
                }

                assertAll("Verify a VIP passenger can only be added to an economy flight once",
                        () -> assertEquals(1, economyFlight.getPassengersSet().size()),
                        () -> assertTrue(economyFlight.getPassengersSet().contains(Jhon)),
                        () -> assertTrue(new ArrayList<>(economyFlight.getPassengersSet()).get(0).getName().equals("Jhon"))
                );
            }
        }
    }

    @DisplayName("Given a premium flight.")
    @Nested
    class PremiumFlightTest {
        private PremiumFlight premiumFlight;
        private Passenger Mike;
        private Passenger Jhon;

        @BeforeEach
        void setUp (){
            premiumFlight = new PremiumFlight("3");
            Mike = new Passenger("Mike", false);
            Jhon = new Passenger("Jhon", true);
        }

        @DisplayName("When whe have an usual passenger.")
        @Nested
        class UsualPassenger {

            @Test
            @DisplayName("Then you can't add nor remove him from a premium flight.")
            public void testPremiumFlightUsualPassenger(){

                assertAll("Verify all conditions for usual passenger and premium flight.",
                        () -> assertEquals("3", premiumFlight.get_id()),
                        () -> assertEquals(false, premiumFlight.addPassenger(Mike)),
                        () -> assertEquals(0, premiumFlight.getPassengersSet().size()),
                        () -> assertEquals(false, premiumFlight.removePassenger(Mike)),
                        () -> assertEquals(0, premiumFlight.getPassengersSet().size()));
            }
        }

        @DisplayName("When we have a VIP passenger.")
        @Nested
        class VipPassenger {

            @Test
            @DisplayName("Then you can add him and remove him from a premium flight.")
            public void testPremiumFlightVipPassenger(){

                assertAll("Verify all conditions for VIP passenger and premium flight.",
                        () -> assertEquals("3", premiumFlight.get_id()),
                        () -> assertEquals(true, premiumFlight.addPassenger(Jhon)),
                        () -> assertEquals(1, premiumFlight.getPassengersSet().size()),
                        () -> assertEquals(true, premiumFlight.removePassenger(Jhon)),
                        () -> assertEquals(0, premiumFlight.getPassengersSet().size()));
            }

            @DisplayName("Then you can't add him to a premium flight more than once")
            @RepeatedTest(5)
            public void testBusinessFlightVipPassengerAddedOnlyOnce(RepetitionInfo repetitionInfo) {
                for(int i = 0; i < repetitionInfo.getCurrentRepetition(); i++){
                    premiumFlight.addPassenger(Jhon);
                }

                assertAll("Verify VIP passenger can be added only once to a premium flight",
                        () -> assertEquals(1, premiumFlight.getPassengersSet().size()),
                        () -> assertTrue(premiumFlight.getPassengersSet().contains(Jhon)),
                        () -> assertTrue(new ArrayList<>(premiumFlight.getPassengersSet()).get(0).getName().equals("Jhon"))
                );
            }
        }
    }
}
