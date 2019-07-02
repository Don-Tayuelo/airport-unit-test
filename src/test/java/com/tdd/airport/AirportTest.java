package com.tdd.airport;

import com.sun.xml.internal.ws.api.pipe.PipelineAssembler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
                        () -> assertEquals(0, businessFlight.getPassengersList().size()),
                        () -> assertEquals(false, businessFlight.removePassenger(Mike)),
                        () -> assertEquals(0, businessFlight.getPassengersList().size()));
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
                        () -> assertEquals(1, businessFlight.getPassengersList().size()),
                        () -> assertEquals(false, businessFlight.removePassenger(Jhon)),
                        () -> assertEquals(1, businessFlight.getPassengersList().size()));
            }
        }
    }

    @DisplayName("Given a economy flight.")
    @Nested
    class EconomyFlightTest {
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
                        () -> assertEquals(1, economyFlight.getPassengersList().size()),
                        () -> assertEquals("Mike", economyFlight.getPassengersList().get(0).getName()),
                        () -> assertEquals(true, economyFlight.removePassenger(Mike)),
                        () -> assertEquals(0, economyFlight.getPassengersList().size())
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
                        () -> assertEquals(1, economyFlight.getPassengersList().size()),
                        () -> assertEquals("Jhon", economyFlight.getPassengersList().get(0).getName()),
                        () -> assertEquals(false, economyFlight.removePassenger(Jhon)),
                        () -> assertEquals(1, economyFlight.getPassengersList().size()));
            }
        }
    }
}
