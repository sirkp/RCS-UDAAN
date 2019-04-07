package com.example.sih_rcs;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

//Adapter gives data to View holder in specific format

public class ProgrammingAdapter extends RecyclerView.Adapter<ProgrammingAdapter.ProgrammingViewHolder>{///press alt enter in ProgrammingViewHolder

    //making constructor
    private String[][] data;
    public ProgrammingAdapter(String[][] data)
    {
        this.data=data;
    }
    /////
    @NonNull
    @Override
    public ProgrammingViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {//create view and store in view holder
        LayoutInflater inflater= LayoutInflater.from(viewGroup.getContext());//
        View view=inflater.inflate(R.layout.list_item_layout,viewGroup,false);
        return new ProgrammingViewHolder(view);
    }

    int k=data.length;

        @Override
        public void onBindViewHolder (@NonNull ProgrammingViewHolder programmingViewHolder,int i){
        programmingViewHolder.tvSearchFlightFlightId.setText(data[i][1]);
        //programmingViewHolder.tvSearchFlightAirline.setText(data[i][1]);
        programmingViewHolder.tvSearchFlightDeparture.setText(data[i][2]);
        programmingViewHolder.tvSearchFlightArrival.setText(data[i][3]);
        programmingViewHolder.tvSearchFlightFare.setText(data[i][4]);
        int kk = Integer.parseInt(data[i][3]) - Integer.parseInt(data[i][2]);
        programmingViewHolder.tvSearchFlightDuration.setText("" + kk);

    }
    @Override
    public int getItemCount() {
        return data.length;
    }
///////
    //making nested class for viewHolder

    public class ProgrammingViewHolder extends RecyclerView.ViewHolder{
        private ImageView ivSearchFlightLogo;
        private TextView tvSearchFlightAirline;
        private TextView tvSearchFlightFlightId;
        private TextView tvSearchFlightDeparture;
        private TextView tvSearchFlightArrival;
        private TextView tvSearchFlightDuration;
        private TextView tvSearchFlightFare;
        public ProgrammingViewHolder(@NonNull View itemView) {
            super(itemView);
            ivSearchFlightLogo=(ImageView) itemView.findViewById(R.id.ivSearchFlightLogo);
            tvSearchFlightFlightId=(TextView) itemView.findViewById(R.id.tvSearchFlightFlightId);
            tvSearchFlightDeparture=(TextView) itemView.findViewById(R.id.tvSearchFlightDeparture);
            tvSearchFlightArrival=(TextView) itemView.findViewById(R.id.tvSearchFlightArrival);
            tvSearchFlightDuration=(TextView) itemView.findViewById(R.id.tvSearchFlightDuration);
            tvSearchFlightFare=(TextView) itemView.findViewById(R.id.tvSearchFlightFare);
        }
    }
}
