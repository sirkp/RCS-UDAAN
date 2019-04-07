package com.example.sih_rcs;

public class SearchItem {

    private int ivSearchFlightLogo;
    private String tvSearchFlightAirline;
    private String tvSearchFlightFlightId;
    private String tvSearchFlightDeparture;
    private String tvSearchFlightArrival;
    private String tvSearchFlightDuration;
    private String tvSearchFlightFare;


    public SearchItem (int consivSearchFlightLogo ,String constvSearchFlightAirline,String constvSearchFlightFlightId,String constvSearchFlightDeparture,String constvSearchFlightArrival,String constvSearchFlightDuration,String constvSearchFlightFare)
    {
        ivSearchFlightLogo = consivSearchFlightLogo;
        tvSearchFlightAirline = constvSearchFlightAirline;
        tvSearchFlightFlightId=constvSearchFlightFlightId;
        tvSearchFlightDeparture=constvSearchFlightDeparture;
        tvSearchFlightArrival=constvSearchFlightArrival;
        tvSearchFlightDuration=constvSearchFlightDuration;
        tvSearchFlightFare=constvSearchFlightFare;
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
}
