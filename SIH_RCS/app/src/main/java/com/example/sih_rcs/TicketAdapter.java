package com.example.sih_rcs;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class TicketAdapter extends RecyclerView.Adapter<TicketAdapter.TicketViewHolder> {

    private ArrayList<TicketItem> ticketList;

    public static class TicketViewHolder extends RecyclerView.ViewHolder {

        private ImageView ivTicketAirlineLogo;
        private TextView tvTicketAirline,tvTicketFrom,tvTicketTo,tvTicketDepartTime,tvTicketArrivalTime,tvTicketDuration,tvTicketDayAndDate;


        public TicketViewHolder(@NonNull View itemView) {
            super(itemView);
            ivTicketAirlineLogo=(ImageView) itemView.findViewById(R.id.ivTicketAirlineLogo);
            tvTicketAirline=(TextView) itemView.findViewById(R.id.tvTicketAirline);
            tvTicketFrom=(TextView) itemView.findViewById(R.id.tvTicketFrom);
            tvTicketTo=(TextView) itemView.findViewById(R.id.tvTicketTo);
            tvTicketDepartTime=(TextView) itemView.findViewById(R.id.tvTicketDepartTime);
            tvTicketArrivalTime=(TextView) itemView.findViewById(R.id.tvTicketArrivalTime);
            tvTicketDuration=(TextView) itemView.findViewById(R.id.tvTicketDuration);
            tvTicketDayAndDate=(TextView) itemView.findViewById(R.id.tvTicketDayAndDate);
        }
    }

    public TicketAdapter (ArrayList<TicketItem> consticketList){
        ticketList=consticketList;
    }

    @NonNull
    @Override
    public TicketViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.ticket_item,viewGroup,false);
        TicketViewHolder tvh = new TicketViewHolder(view);
        return tvh;
    }

    @Override
    public void onBindViewHolder(@NonNull TicketViewHolder ticketViewHolder, int i) {

        TicketItem currentTicketItem = ticketList.get(i);
        ticketViewHolder.ivTicketAirlineLogo.setImageResource(currentTicketItem.getIvTicketAirlineLogo());
        ticketViewHolder.tvTicketAirline.setText(currentTicketItem.getTvTicketAirline());
        ticketViewHolder.tvTicketFrom.setText(currentTicketItem.getTvTicketFrom());
        ticketViewHolder.tvTicketTo.setText(currentTicketItem.getTvTicketTo());
        ticketViewHolder.tvTicketDepartTime.setText(currentTicketItem.getTvTicketDepartTime());
        ticketViewHolder.tvTicketArrivalTime.setText(currentTicketItem.getTvTicketArrivalTime());
        ticketViewHolder.tvTicketDuration.setText(currentTicketItem.getTvTicketDuration());
        ticketViewHolder.tvTicketDayAndDate.setText(currentTicketItem.getTvTicketDayAndDate());

        int k=ticketViewHolder.getAdapterPosition();
        Log.d("tvh",""+k);



    }

    @Override
    public int getItemCount() {
        return ticketList.size();
    }
}
