package com.example.imagegallary;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Dell-pc on 11/7/2018.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {


    private Context mcontext;
    private List<ShareImage> mData;


    public RecyclerViewAdapter(Context mcontext, List<ShareImage> mData) {
        this.mcontext = mcontext;
        this.mData = mData;
    }



    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view;
        LayoutInflater inflater=LayoutInflater.from(mcontext);
        view=inflater.inflate(R.layout.card_view,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        holder.img_title.setText(mData.get(position).getProdutName());
        holder.img_Thumbnail.setImageResource(mData.get(position).getThumbname());
        Log.d("bitmap","  bitmap "+String.valueOf(bitmap));
        holder.cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mcontext,ImageFull.class);

                intent.putExtra("Title",mData.get(position).getProdutName());
                intent.putExtra("Price",mData.get(position).getProductPrice());
                intent.putExtra("Thumbnale",mData.get(position).getThumbname());

                mcontext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {

        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{


        TextView img_title;
        ImageView img_Thumbnail;
        CardView cardview;

        public MyViewHolder(View itemView) {
            super(itemView);

            img_title=(TextView) itemView.findViewById(R.id.tv_imgName);
            img_Thumbnail=(ImageView) itemView.findViewById(R.id.img_image);
            cardview=(CardView) itemView.findViewById(R.id.cardview_id);

        }


    }

}
