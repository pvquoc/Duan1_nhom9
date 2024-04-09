package fpl.poly.nhom9.duan1ht.Adapter;

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
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DecimalFormat;
import java.util.ArrayList;

import fpl.poly.nhom9.duan1ht.ChiTietSanPhamActivity;
import fpl.poly.nhom9.duan1ht.DAO.GioHangDAO;
import fpl.poly.nhom9.duan1ht.DTO.DanhSachSanPhamDTO;
import fpl.poly.nhom9.duan1ht.DTO.GioHangDTO;
import fpl.poly.nhom9.duan1ht.R;

public class AdapterDanhSachSanPhamP2 extends RecyclerView.Adapter<AdapterDanhSachSanPhamP2.ViewHolder> {
    ArrayList<DanhSachSanPhamDTO> list;
    private Context context;
    DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
    GioHangDAO gioHangDAO;

    public AdapterDanhSachSanPhamP2(ArrayList<DanhSachSanPhamDTO> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        View view = inflater.inflate(R.layout.item_p2_danh_sach_san_pham_use, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DanhSachSanPhamDTO id = list.get(position);
        String nameImg = list.get(position).getImg_url();
        int resourceImg = ((Activity) context).getResources().getIdentifier(nameImg, "drawable", ((Activity) context).getPackageName());
        holder.imgDanhSachSanPhamp2.setImageResource(resourceImg);
        holder.tvTenDanhSachSanPhamp2.setText(list.get(position).getTen_san_pham());
        holder.tvGiaSanPhamDanhSachSanPhamp2.setText(decimalFormat.format(list.get(position).getDon_gia()) + " VND ");
        String base64 = list.get(position).getImg_url();
        try {
            byte[] imageBytes = android.util.Base64.decode(base64, Base64.DEFAULT);
            Bitmap bitmap = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.length);
            if (bitmap != null) {
                holder.imgDanhSachSanPhamp2.setImageBitmap(bitmap);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        gioHangDAO = new GioHangDAO(context);
        holder.ivGioHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String tenSp = id.getTen_san_pham();
                int giaSp = id.getDon_gia();
                String tenAnh = id.getImg_url();

                GioHangDTO objGioHang = new GioHangDTO();
                objGioHang.setTenSanPham(tenSp);
                objGioHang.setGiaSanPham(giaSp);
                objGioHang.setImgSanPham(tenAnh);
                objGioHang.setSoLuongSanPham(1);
                objGioHang.setTongTienCuaSp(giaSp);

                long kq = gioHangDAO.addRow(objGioHang);
                if (kq > 0) {

                    Toast.makeText(context, "Thêm thành công", Toast.LENGTH_SHORT).show();


                } else {

                    Toast.makeText(context, "Thêm thất bại", Toast.LENGTH_SHORT).show();

                }


            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(((Activity) context), ChiTietSanPhamActivity.class);

                remenBerProduct(id.getTen_san_pham(), id.getDon_gia(), id.getImg_url(), id.getMo_ta());
                ((Activity) context).startActivity(intent);


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

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgDanhSachSanPhamp2, ivGioHang;
        TextView tvTenDanhSachSanPhamp2, tvGiaSanPhamDanhSachSanPhamp2;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imgDanhSachSanPhamp2 = itemView.findViewById(R.id.imgDanhSachSanPhamP2);
            tvTenDanhSachSanPhamp2 = itemView.findViewById(R.id.tvTenDanhSachSanPhamP2);
            tvGiaSanPhamDanhSachSanPhamp2 = itemView.findViewById(R.id.tvGiaSanPhamDanhSachSanPham);
            ivGioHang = itemView.findViewById(R.id.ivIconGioHangItemP2);


        }
    }
}
