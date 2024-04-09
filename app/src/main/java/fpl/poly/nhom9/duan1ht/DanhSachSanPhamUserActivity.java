package fpl.poly.nhom9.duan1ht;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import fpl.poly.nhom9.duan1ht.Adapter.AdapterDanhSachSanPhamP1;
import fpl.poly.nhom9.duan1ht.Adapter.AdapterDanhSachSanPhamP2;
import fpl.poly.nhom9.duan1ht.Adapter.AdapterDanhSachSanPhamP3;
import fpl.poly.nhom9.duan1ht.Adapter.MyViewPagerAdapter;
import fpl.poly.nhom9.duan1ht.DAO.DanhSachSanPhamDAO;
import fpl.poly.nhom9.duan1ht.DTO.DanhSachSanPhamDTO;
import fpl.poly.nhom9.duan1ht.Fragment.FragmentDanhSachSanPhamP1;
import fpl.poly.nhom9.duan1ht.Fragment.FragmentDanhSachSanPhamP2;
import fpl.poly.nhom9.duan1ht.Fragment.FragmentDanhSachSanPhamP3;

public class DanhSachSanPhamUserActivity extends AppCompatActivity {
    TabLayout mTabLayout;
    ViewPager2 viewPager2;
    MyViewPagerAdapter myViewPagerAdapter;
    EditText edtSearch;
    AdapterDanhSachSanPhamP1 danhSachSanPham;
    ImageView ivBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_sach_san_pham_user);

        mTabLayout = findViewById(R.id.tab_layout);
        viewPager2 = findViewById(R.id.view_paper);
        edtSearch = findViewById(R.id.edt_search);
        ivBack = findViewById(R.id.ivBackDanhSachSanPham);
        myViewPagerAdapter = new MyViewPagerAdapter(this);
        viewPager2.setAdapter(myViewPagerAdapter);

        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        // cố định tab ko cho vuốt
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                mTabLayout.getTabAt(position).select();
            }
        });
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        //Chức năng tìm kiếm
        edtSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {



                if (mTabLayout.getSelectedTabPosition() == 0) {

                    String tenSanPhamP1 = s.toString();
                    timKiemSanPhamP1(tenSanPhamP1);

                } else if (mTabLayout.getSelectedTabPosition() == 1) {

                    String tenSanPhamP2 = s.toString();
                    timKiemSanPhamP2(tenSanPhamP2);

                }else if (mTabLayout.getSelectedTabPosition() == 2) {

                    String tenSanPhamP3 = s.toString();
                    timKiemSanPhamP3(tenSanPhamP3);

                }


            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private void timKiemSanPhamP3(String tenSanPhamP3 ){
        DanhSachSanPhamDAO sachSanPhamDAO = new DanhSachSanPhamDAO(this);

        ArrayList<DanhSachSanPhamDTO> list = sachSanPhamDAO.timKiemP3(tenSanPhamP3);
        AdapterDanhSachSanPhamP3 adapterDanhSachSanPham = new AdapterDanhSachSanPhamP3(list, this);

        if (list.size() > 0) {

            FragmentDanhSachSanPhamP3.recyclerviewDanhSachSanPhamP3.setAdapter(adapterDanhSachSanPham);
            adapterDanhSachSanPham.notifyDataSetChanged();


        } else {
            Toast.makeText(this, "Không có sản phẩm ", Toast.LENGTH_SHORT).show();

        }

    }
    private void timKiemSanPhamP2(String tenSanPhamP2) {
        DanhSachSanPhamDAO sachSanPhamDAO = new DanhSachSanPhamDAO(this);

        ArrayList<DanhSachSanPhamDTO> list = sachSanPhamDAO.timKiemP2(tenSanPhamP2);
        AdapterDanhSachSanPhamP2 adapterDanhSachSanPham = new AdapterDanhSachSanPhamP2(list, this);

        if (list.size() > 0) {

            FragmentDanhSachSanPhamP2.recyclerviewDanhSachSanPhamP2.setAdapter(adapterDanhSachSanPham);
            adapterDanhSachSanPham.notifyDataSetChanged();


        } else {


            Toast.makeText(this, "Không có sản phẩm ", Toast.LENGTH_SHORT).show();

        }

    }
    private void timKiemSanPhamP1(String tenSanPhamP1) {

        DanhSachSanPhamDAO sachSanPhamDAO = new DanhSachSanPhamDAO(this);

        ArrayList<DanhSachSanPhamDTO> list = sachSanPhamDAO.timKiemP1(tenSanPhamP1);
        AdapterDanhSachSanPhamP1 adapterDanhSachSanPham = new AdapterDanhSachSanPhamP1(list, this);

        if (list.size() > 0) {

            FragmentDanhSachSanPhamP1.recyclerDanhSachSanPhamUse.setAdapter(adapterDanhSachSanPham);
            adapterDanhSachSanPham.notifyDataSetChanged();


        } else {


            Toast.makeText(this, "Không có sản phẩm ", Toast.LENGTH_SHORT).show();

        }


    }

}