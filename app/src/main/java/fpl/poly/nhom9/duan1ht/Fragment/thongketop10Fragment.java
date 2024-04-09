package fpl.poly.nhom9.duan1ht.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import fpl.poly.nhom9.duan1ht.Adapter.AdapterTop10;
import fpl.poly.nhom9.duan1ht.DAO.ThongKeDAO;
import fpl.poly.nhom9.duan1ht.DTO.DanhSachSanPhamDTO;
import fpl.poly.nhom9.duan1ht.DTO.GioHangDTO;
import fpl.poly.nhom9.duan1ht.R;

public class thongketop10Fragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.thongketop10admin,container,false);
        RecyclerView recyclerViewtop10=view.findViewById(R.id.RecycleTop10);
        ThongKeDAO thongkeDao = new ThongKeDAO(getContext());
        ArrayList<GioHangDTO>list=thongkeDao.getTop10();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerViewtop10.setLayoutManager(linearLayoutManager);
        AdapterTop10 adapterTop10 = new AdapterTop10(getContext(),list);
        recyclerViewtop10.setAdapter(adapterTop10);

        return view;
    }
}
