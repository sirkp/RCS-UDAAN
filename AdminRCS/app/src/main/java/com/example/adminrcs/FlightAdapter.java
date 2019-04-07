package com.example.adminrcs;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class FlightAdapter extends RecyclerView.Adapter<FlightAdapter.SearchViewHolder> {

    public static ArrayList<FlightItem> searchList;
    public static int k;

    public static class SearchViewHolder extends RecyclerView.ViewHolder {

        private ImageView ivSearchFlightLogo;
        private TextView tvSearchFlightAirline;
        private TextView tvSearchFlightFlightId;
        private TextView tvSearchFlightDeparture;
        private TextView tvSearchFlightArrival;
        private TextView tvSearchFlightDuration;
        private TextView tvSearchFlightDate;
        private TextView tvSearchFlightFrom;
        private TextView tvSearchFlightTo;
        //private TextView tvSearchFlightFare;

        public SearchViewHolder(@NonNull View itemView) {
            super(itemView);
            ivSearchFlightLogo=(ImageView) itemView.findViewById(R.id.ivSearchFlightLogo);
            tvSearchFlightAirline=(TextView) itemView.findViewById(R.id.tvSearchFlightAirline);
            tvSearchFlightFlightId=(TextView) itemView.findViewById(R.id.tvSearchFlightFlightId);
            tvSearchFlightDeparture=(TextView) itemView.findViewById(R.id.tvSearchFlightDeparture);
            tvSearchFlightArrival=(TextView) itemView.findViewById(R.id.tvSearchFlightArrival);
            tvSearchFlightDuration=(TextView) itemView.findViewById(R.id.tvSearchFlightDuration);
            tvSearchFlightDate=(TextView) itemView.findViewById(R.id.tvSearchFlightDate);
            //tvSearchFlightFare=(TextView) itemView.findViewById(R.id.tvSearchFlightFare);
        }
    }

    public FlightAdapter(ArrayList<FlightItem> conssearchList){
        searchList=conssearchList;
    }

    @NonNull
    @Override
    public SearchViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.temp,viewGroup,false);
        SearchViewHolder svh = new SearchViewHolder(view);
        return svh;
    }

    @Override
    public void onBindViewHolder(@NonNull final SearchViewHolder searchViewHolder, int i) {

        FlightItem currentSearchItem = searchList.get(i);
        searchViewHolder.ivSearchFlightLogo.setImageResource(currentSearchItem.getIvSearchFlightLogo());
        searchViewHolder.tvSearchFlightAirline.setText(currentSearchItem.getTvSearchFlightAirline());
        searchViewHolder.tvSearchFlightFlightId.setText(currentSearchItem.getTvSearchFlightFlightId());
        searchViewHolder.tvSearchFlightDeparture.setText(currentSearchItem.getTvSearchFlightDeparture());
        searchViewHolder.tvSearchFlightArrival.setText(currentSearchItem.getTvSearchFlightArrival());
        searchViewHolder.tvSearchFlightDuration.setText(currentSearchItem.getTvSearchFlightDuration());
        searchViewHolder.tvSearchFlightDate.setText(currentSearchItem.getTvSearchFlightDate());
        //searchViewHolder.tvSearchFlightFrom.setText(currentSearchItem.getTvSearchFlightFrom());
        //searchViewHolder.tvSearchFlightTo.setText(currentSearchItem.getTvSearchFlightTo());


        //Log.d("svh",""+k);

        searchViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //do nothing
                Context ctx;
                //SecondActivity sa = new SecondActivity(currentSearchItem.getTvSearchFlightFare());
                k = searchViewHolder.getAdapterPosition();
                Log.d("svh",""+k);
                ctx=view.getContext();
                //Intent intent=new Intent(ctx,SecondActivity.class);
                //ctx.startActivity(intent);
                json j = new json(ctx);
                j.execute("hello","hello");
                //Log.d("svh",""+currentSearchItem);
                //int k= (int) SearchViewHolder.getAdapterPosition();


            }});

    }

    public static int getk()
    {
        return k;
    }

    @Override
    public int getItemCount() {
        return searchList.size();
    }
}
