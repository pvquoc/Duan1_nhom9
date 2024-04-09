package fpl.poly.nhom9.duan1ht.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import fpl.poly.nhom9.duan1ht.DTO.DanhSachSanPhamDTO;
import fpl.poly.nhom9.duan1ht.DTO.GioHangDTO;
import fpl.poly.nhom9.duan1ht.R;

public class AdapterTop10 extends RecyclerView.Adapter<AdapterTop10.ViewHolder> {

   private Context context;
   private ArrayList<GioHangDTO> list;

    public AdapterTop10(Context context, ArrayList<GioHangDTO> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater=((Activity)context).getLayoutInflater();
        View view=inflater.inflate(R.layout.item_recyclertop10,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        String nameImg = list.get(position).getImgSanPham();
        int resourceImg = ((Activity) context).getResources().getIdentifier(nameImg, "drawable", ((Activity) context).getPackageName());
        holder.imganh.setImageResource(resourceImg);
        holder.txtIDSP.setText("ID: "+list.get(position).getIdSanPham());
        holder.txttensp.setText("Tên sản phẩm: "+list.get(position).getTenSanPham());
        holder.txtsoluongdamua.setText("Số lượng đã mua: "+list.get(position).getSoLuongSanPham());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imganh;
        TextView txttensp,txtsoluongdamua,txtIDSP;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imganh=itemView.findViewById(R.id.imganh);
            txttensp=itemView.findViewById(R.id.txttensp);
            txtIDSP=itemView.findViewById(R.id.txtIDSP);
            txtsoluongdamua=itemView.findViewById(R.id.txtsoluongdamua);
        }
    }
}
