package fpl.poly.nhom9.duan1ht.Fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;

import fpl.poly.nhom9.duan1ht.Adapter.AdapterSanPhamAdmin;
import fpl.poly.nhom9.duan1ht.Adapter.AdapterSanPhamPhan1Admin;
import fpl.poly.nhom9.duan1ht.Adapter.AdapterSanPhamPhan2Admin;
import fpl.poly.nhom9.duan1ht.Adapter.AdapterViewPagerTrangChuADMIN;
import fpl.poly.nhom9.duan1ht.DAO.DanhSachSanPhamDAO;
import fpl.poly.nhom9.duan1ht.DAO.TrangChuAdminDAO;
import fpl.poly.nhom9.duan1ht.DTO.SanPhamTrangChuDTO;
import fpl.poly.nhom9.duan1ht.R;

public class FragmentTrangChuAdmin extends Fragment {
    private TabLayout tabLayoutADm;
    private ViewPager2 viewPager2ADM;
    private AdapterViewPagerTrangChuADMIN adapterViewPagerTrangChuADMIN;
    private EditText edseachsp;
    private TextView tvTenTaiKhoan;
    private TrangChuAdminDAO trangChuAdminDAO;
    private DanhSachSanPhamDAO danhSachSanPhamDAO;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_trangchu,container,false);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        trangChuAdminDAO=new TrangChuAdminDAO(getContext());

        edseachsp=view.findViewById(R.id.edSeachAdmin);
        tvTenTaiKhoan=view.findViewById(R.id.tvTenTaiKhoanAdmin);
        tabLayoutADm=view.findViewById(R.id.tabLayoutAdmin);
        viewPager2ADM=view.findViewById(R.id.viewPager2Admin);
        adapterViewPagerTrangChuADMIN=new AdapterViewPagerTrangChuADMIN(this);
        viewPager2ADM.setAdapter(adapterViewPagerTrangChuADMIN);

        SharedPreferences sharedPreferences= getActivity().getSharedPreferences("USER", Context.MODE_PRIVATE);
        String tenDangNhap=sharedPreferences.getString("tenDangNhap","");


        new TabLayoutMediator(tabLayoutADm, viewPager2ADM, (tab, position) -> {
            switch (position) {
                case 0:
                    tab.setText("Phần 1");
                    break;
                case 1:
                    tab.setText("Phần 2");
                    break;
                case 2:
                    tab.setText("Phần 3");
                    break;
            }
        }).attach();

        edseachsp.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (tabLayoutADm.getSelectedTabPosition()==0){
                    String tenspphan1=s.toString();
                    timKiemSanPhamP1(tenspphan1);
                } else if (tabLayoutADm.getSelectedTabPosition()==1) {
                    String tenspphan2=s.toString();
                    timKiemSanPhamP2(tenspphan2);
                } else if (tabLayoutADm.getSelectedTabPosition()==2) {
                    String tenspphan3=s.toString();
                    timKiemSanPhamP3(tenspphan3);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
    private void timKiemSanPhamP1(String tenspphan1){
        ArrayList<SanPhamTrangChuDTO> list=trangChuAdminDAO.timKiemP1(tenspphan1);
        if (list.size()>0){
            AdapterSanPhamPhan1Admin adapterSanPhamAdmin=new AdapterSanPhamPhan1Admin(list,getContext());
            FragmentPhan1TrangChuAdmin.recyclerViewPhan1.setAdapter(adapterSanPhamAdmin);
            adapterSanPhamAdmin.notifyDataSetChanged();
        }
    }
    private void timKiemSanPhamP2(String tenspphan2){
        ArrayList<SanPhamTrangChuDTO> list=trangChuAdminDAO.timKiemP1(tenspphan2);
        if (list.size()>0){
            AdapterSanPhamAdmin adapterSanPhamAdmin=new AdapterSanPhamAdmin(list,getContext());
            FragmentPhan2TrangChuAdmin.recyclerViewPhan2.setAdapter(adapterSanPhamAdmin);
            adapterSanPhamAdmin.notifyDataSetChanged();
        }
    }
    private void timKiemSanPhamP3(String tenspphan3){
        ArrayList<SanPhamTrangChuDTO> list=trangChuAdminDAO.timKiemP1(tenspphan3);
        if (list.size()>0){
            AdapterSanPhamPhan2Admin adapterSanPhamAdmin=new AdapterSanPhamPhan2Admin(list,getContext());
            FragmentPhan3TrangChuAdmin.recyclerViewPhan3.setAdapter(adapterSanPhamAdmin);
            adapterSanPhamAdmin.notifyDataSetChanged();
        }
    }
}
