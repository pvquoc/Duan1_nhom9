package fpl.poly.nhom9.duan1ht.Fragment;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import fpl.poly.nhom9.duan1ht.LoginActivity;
import fpl.poly.nhom9.duan1ht.R;

public class FragmentTaiKhoanUSER extends Fragment {
    private AppCompatButton btnThongTinCaNhan, btnViCaNhan, btnLienHeCaNhan, btnDoiMatKhau, btnDangXuat;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tai_khoan_user, container, false);
        return view;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnThongTinCaNhan = view.findViewById(R.id.btnThongTinCaNhan);
        btnViCaNhan = view.findViewById(R.id.btnViCaNhan);
        btnLienHeCaNhan = view.findViewById(R.id.btnLienHeGopY);
        btnDoiMatKhau = view.findViewById(R.id.btnDoiMatKhau);
        btnDangXuat = view.findViewById(R.id.btnDangXuat);

        //xu ly lay ten damg nhap

        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("USER_FILE", Context.MODE_PRIVATE);
        String loggedInUserName = sharedPreferences.getString("userName", "Default UserName");

        TextView txtTenTaiKhoan = view.findViewById(R.id.txtTenTaiKhoanUser);
        txtTenTaiKhoan.setText(loggedInUserName);
        btnThongTinCaNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btnViCaNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btnDangXuat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder=new AlertDialog.Builder(getContext());
                View view1=LayoutInflater.from(getContext()).inflate(R.layout.dialog_xac_nhan,null,false);
                builder.setView(view1);

                AlertDialog dialog=builder.create();
                Window window=dialog.getWindow();
                window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
                window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                AppCompatButton btnxacnhan,btnhuy;
                TextView tvNoiDung;

                btnhuy=view1.findViewById(R.id.btnHuyDialog);
                btnxacnhan=view1.findViewById(R.id.btnXacNhanDialog);
                tvNoiDung=view1.findViewById(R.id.tvNoiDungDialog);
                tvNoiDung.setText("Bạn có muốn đăng xuất không?");
                btnxacnhan.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(getContext(), LoginActivity.class);
                        startActivity(intent);
                        getActivity().finish();
                    }
                });
                btnhuy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });
        btnLienHeCaNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btnDoiMatKhau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

}
    }
