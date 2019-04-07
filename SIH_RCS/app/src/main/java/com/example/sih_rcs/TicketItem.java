package com.example.sih_rcs;

public class TicketItem {
    private int ivTicketAirlineLogo;
    private String tvTicketAirline,tvTicketFrom,tvTicketTo,tvTicketDepartTime,tvTicketArrivalTime,tvTicketDuration,tvTicketDayAndDate;
    //LinearLayout llTicketStatus;

    public TicketItem(int consivTicketAirlineLogo,String constvTicketAirline,String constvTicketFrom,String conetvTicketTo,String constvTicketDepartTime,String constvTicketArrivalTime,String constvTicketDuration,String constvTicketDayAndDate/*,LinearLayout consllTicketStatus*/)
    {
        ivTicketAirlineLogo = consivTicketAirlineLogo;
        tvTicketAirline = constvTicketAirline;
        tvTicketFrom = constvTicketFrom;
        tvTicketTo = conetvTicketTo;
        tvTicketDepartTime = constvTicketDepartTime;
        tvTicketArrivalTime = constvTicketArrivalTime;
        tvTicketDuration = constvTicketDuration;
        tvTicketDayAndDate = constvTicketDayAndDate;
        //llTicketStatus = consllTicketStatus;
    }

    public int getIvTicketAirlineLogo() {
        return ivTicketAirlineLogo;
    }

    public String getTvTicketAirline() {
        return tvTicketAirline;
    }

    public String getTvTicketFrom() {
        return tvTicketFrom;
    }

    public String getTvTicketTo() {
        return tvTicketTo;
    }

    public String getTvTicketDepartTime() {
        return tvTicketDepartTime;
    }

    public String getTvTicketArrivalTime() {
        return tvTicketArrivalTime;
    }

    public String getTvTicketDuration() {
        return tvTicketDuration;
    }

    public String getTvTicketDayAndDate() {
        return tvTicketDayAndDate;
    }

    /*public LinearLayout getLlTicketStatus() {
        return llTicketStatus;
    }*/
}
