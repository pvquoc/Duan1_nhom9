package fpl.poly.nhom9.duan1ht.Adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DecimalFormat;
import java.util.ArrayList;

import fpl.poly.nhom9.duan1ht.ChiTietSanPhamActivity;
import fpl.poly.nhom9.duan1ht.DTO.SanPhamTrangChuDTO;
import fpl.poly.nhom9.duan1ht.R;

public class AdapterSanPhamPhan1Admin extends RecyclerView.Adapter<AdapterSanPhamPhan1Admin.ViewHolderAdmin>{
    ArrayList<SanPhamTrangChuDTO> list;
    Context context;

    private SanPhamAdminInterface listen;
    DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
    public AdapterSanPhamPhan1Admin(ArrayList<SanPhamTrangChuDTO> list, Context context, SanPhamAdminInterface listen) {
        this.list = list;
        this.context = context;
        this.listen = listen;
    }

    public AdapterSanPhamPhan1Admin(ArrayList<SanPhamTrangChuDTO> list, Context context) {
        this.list = list;
        this.context = context;
    }

    public interface SanPhamAdminInterface {
        void updateSanPham(SanPhamTrangChuDTO dto);
    }

    @NonNull
    @Override
    public ViewHolderAdmin onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        View view = inflater.inflate(R.layout.item_phan_1, parent, false);
        return new ViewHolderAdmin(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderAdmin holder, @SuppressLint("RecyclerView") int position) {

        SanPhamTrangChuDTO id = list.get(position);

        String nameImg = list.get(position).getImg_url();
        int resourceImg = ((Activity) context).getResources().getIdentifier(nameImg, "drawable", ((Activity) context).getPackageName());
        holder.imgDanhSachSanPhamAdmin.setImageResource(resourceImg);

        String base64 = list.get(position).getImg_url();
        try {
            byte[] imageBytes = android.util.Base64.decode(base64, Base64.DEFAULT);
            Bitmap bitmap = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.length);

            if (bitmap != null) {
                holder.imgDanhSachSanPhamAdmin.setImageBitmap(bitmap);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        holder.tvGiaSanPhamDanhSachSanPhamAdmin.setText(decimalFormat.format(list.get(position).getDon_gia()) + " VND");
        holder.tvTenDanhSachSanPhamAdmin.setText(list.get(position).getTen_san_pham());

        holder.ivSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//
                listen.updateSanPham(list.get(position));

            }
        });

        //Xem chi tiết sản phẩm
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//
                remenBerProduct(id.getTen_san_pham(), id.getDon_gia(), id.getImg_url(), id.getMo_ta());
                context.startActivity(new Intent(context, ChiTietSanPhamActivity.class));
//
//
            }
        });


    }

    private void remenBerProduct(String tenSanPham, int donGia, String imgUrl, String moTa) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("PRODUCT", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("tenSp", tenSanPham);
        editor.putInt("doGia", donGia);
        editor.putString("anhSp", imgUrl);
        editor.putString("moTa", moTa);

        editor.apply();


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolderAdmin extends RecyclerView.ViewHolder {
        ImageView imgDanhSachSanPhamAdmin, ivSua;
        TextView tvTenDanhSachSanPhamAdmin, tvGiaSanPhamDanhSachSanPhamAdmin;


        public ViewHolderAdmin(@NonNull View itemView) {
            super(itemView);
            imgDanhSachSanPhamAdmin = itemView.findViewById(R.id.imgDanhSachSanPhamP1Admin);
            tvTenDanhSachSanPhamAdmin = itemView.findViewById(R.id.tvTenDanhSachSanPhamP1Admin);
            tvGiaSanPhamDanhSachSanPhamAdmin = itemView.findViewById(R.id.tvGiaSanPhamDanhSachSanPhamquaAdmin);
            ivSua = itemView.findViewById(R.id.ivIconSuaItem);


        }
    }

}
