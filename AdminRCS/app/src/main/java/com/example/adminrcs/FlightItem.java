package com.example.adminrcs;

public class FlightItem {

    private int ivSearchFlightLogo;
    private String tvSearchFlightAirline;
    private String tvSearchFlightFlightId;
    private String tvSearchFlightDeparture;
    private String tvSearchFlightArrival;
    private String tvSearchFlightDuration;
    private String tvSearchFlightFare;
    private String tvSearchFlightDate;
    private String tvSearchFlightFrom;
    private String tvSearchFlightTo;


    public FlightItem (int consivSearchFlightLogo ,String constvSearchFlightAirline,String constvSearchFlightFlightId,String constvSearchFlightFrom,String constvSearchFlightTo,String constvSearchFlightDeparture,String constvSearchFlightArrival,String constvSearchFlightDuration,String constvSearchFlightFare,String constvSearchFlightDate)
    {
        ivSearchFlightLogo = consivSearchFlightLogo;
        tvSearchFlightAirline = constvSearchFlightAirline;
        tvSearchFlightFlightId=constvSearchFlightFlightId;
        tvSearchFlightFrom=constvSearchFlightFrom;
        tvSearchFlightTo=constvSearchFlightTo;
        tvSearchFlightDeparture=constvSearchFlightDeparture;
        tvSearchFlightArrival=constvSearchFlightArrival;
        tvSearchFlightDuration=constvSearchFlightDuration;
        tvSearchFlightFare=constvSearchFlightFare;
        tvSearchFlightDate=constvSearchFlightDate;
    }

    public  int getIvSearchFlightLogo()
    {
        return ivSearchFlightLogo;
    }

    public String getTvSearchFlightAirline()
    {
        return tvSearchFlightAirline;
    }

    public String getTvSearchFlightFlightId()
    {
        return  tvSearchFlightFlightId;
    }

    public String getTvSearchFlightDeparture()
    {
        return tvSearchFlightDeparture;
    }

    public String getTvSearchFlightArrival() {
        return tvSearchFlightArrival;
    }

    public String getTvSearchFlightDuration() {
        return tvSearchFlightDuration;
    }

    public String getTvSearchFlightFare() {
        return tvSearchFlightFare;
    }

    public String getTvSearchFlightDate() {
        return tvSearchFlightDate;
    }

    public String getTvSearchFlightFrom() {
        return tvSearchFlightFrom;
    }

    public String getTvSearchFlightTo() {
        return tvSearchFlightTo;
    }
}
