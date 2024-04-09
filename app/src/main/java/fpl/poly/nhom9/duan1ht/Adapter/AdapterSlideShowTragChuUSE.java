package fpl.poly.nhom9.duan1ht.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import fpl.poly.nhom9.duan1ht.DTO.SliderDTO;
import fpl.poly.nhom9.duan1ht.R;

public class AdapterSlideShowTragChuUSE extends RecyclerView.Adapter<AdapterSlideShowTragChuUSE.ViewHolder> {
    private List<SliderDTO> list;

    public AdapterSlideShowTragChuUSE(List<SliderDTO> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_slider,parent,false);
       return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.ivAnhSlider.setImageResource(list.get(position).getImgSlider());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView ivAnhSlider;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            ivAnhSlider = itemView.findViewById(R.id.ivSliderItem);


        }
    }
}
