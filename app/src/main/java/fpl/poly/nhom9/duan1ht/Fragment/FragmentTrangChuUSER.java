package fpl.poly.nhom9.duan1ht.Fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;
import java.util.List;

import fpl.poly.nhom9.duan1ht.Adapter.AdapterSlideShowTragChuUSE;
import fpl.poly.nhom9.duan1ht.Adapter.AdapterTrangChuUser;
import fpl.poly.nhom9.duan1ht.DAO.SanPhamTrangChuUSEDAO;
import fpl.poly.nhom9.duan1ht.DTO.SanPhamTrangChuUserDTO;
import fpl.poly.nhom9.duan1ht.DTO.SliderDTO;
import fpl.poly.nhom9.duan1ht.DanhSachSanPhamUserActivity;
import fpl.poly.nhom9.duan1ht.R;
import me.relex.circleindicator.CircleIndicator3;

public class FragmentTrangChuUSER extends Fragment {
    private TextView tvXemThem,tvName;
    private ViewPager2 viewPager2;
    private CircleIndicator3 circleIndicator3;
    private RecyclerView recyclerView;
    private AdapterTrangChuUser adapterTrangChuUser;
    private LinearLayout layoutP1,layoutP2,layoutP3,layoutHat;
    private SanPhamTrangChuUSEDAO sanPhamTrangChuDAO;
    private List<SanPhamTrangChuUserDTO> list;
    private EditText edTimKiemSanPham;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_trang_chu_user,container,false);
    }
    @SuppressLint("SetTextI18n")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        tvXemThem = view.findViewById(R.id.tvXemThem);
        layoutP2 = view.findViewById(R.id.layoutPhan2);
        layoutP3 = view.findViewById(R.id.layoutPhan3);
        layoutHat = view.findViewById(R.id.layoutHatTrangChuUser);
        layoutP1 = view.findViewById(R.id.layoutPhan1);
        tvName = view.findViewById(R.id.tvNameTrangChuUser);
        viewPager2 = view.findViewById(R.id.viewPager2TrangChuUser);
        circleIndicator3 = view.findViewById(R.id.ci3);
        recyclerView = view.findViewById(R.id.rcvTrangChuUser);
        edTimKiemSanPham = view.findViewById(R.id.edTimKiemTrangChu);

        sanPhamTrangChuDAO = new SanPhamTrangChuUSEDAO(getContext());

        //Hiển thi tên tài khoản
        String tenDangNhap = requireActivity().getIntent().getStringExtra("tenDangNhap");
        tvName.setText("Hi, "+tenDangNhap);

        //slide show
        AdapterSlideShowTragChuUSE  tragChuUSE=new AdapterSlideShowTragChuUSE(getData());
        viewPager2.setAdapter(tragChuUSE);
        circleIndicator3.setViewPager(viewPager2);

        viewPager2.setOffscreenPageLimit(2);
        viewPager2.setClipChildren(false);
        viewPager2.setClipToPadding(false);

        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(2));
        viewPager2.setPageTransformer(compositePageTransformer);


        tvXemThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //xem thêm phần
                startActivity(new Intent(getContext(), DanhSachSanPhamUserActivity.class));
            }
        });
        layoutP2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), DanhSachSanPhamUserActivity.class));

            }
        });
        layoutP1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), DanhSachSanPhamUserActivity.class));

            }
        });
        layoutP3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), DanhSachSanPhamUserActivity.class));

            }
        });
        //Set Data mẫu
        list = sanPhamTrangChuDAO.getAll();
        adapterTrangChuUser = new AdapterTrangChuUser(getContext(),list);
        GridLayoutManager gridLayoutManager =
                new GridLayoutManager(getContext(),2
                        ,GridLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adapterTrangChuUser);

        //tìm kiếm sp
        edTimKiemSanPham.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                String tenSp = s.toString();
                timKiemSanPham(tenSp);

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        super.onViewCreated(view, savedInstanceState);

    }
    private void timKiemSanPham(String tenSp) {

        List<SanPhamTrangChuUserDTO> listSeach = sanPhamTrangChuDAO.timKiemSanPhamTrangChu(tenSp);

        if (listSeach.size() > 0) {

            adapterTrangChuUser = new AdapterTrangChuUser(getContext(), listSeach);

        } else {

            adapterTrangChuUser = new AdapterTrangChuUser(getContext(), list);

        }
        recyclerView.setAdapter(adapterTrangChuUser);
        adapterTrangChuUser.notifyDataSetChanged();
    }
    private List<SanPhamTrangChuUserDTO> getDataSanPham() {

        List<SanPhamTrangChuUserDTO> list = new ArrayList<>();

        return list;

    }
    private List<SliderDTO> getData(){
        List<SliderDTO> sliderDTOS=new ArrayList<>();
        sliderDTOS.add(new SliderDTO(R.drawable.img_slie_3));
        sliderDTOS.add(new SliderDTO(R.drawable.img_slie_4));
        sliderDTOS.add(new SliderDTO(R.drawable.img_slie_1));
        sliderDTOS.add(new SliderDTO(R.drawable.img_slie_2));

        return sliderDTOS;
    }

    }
