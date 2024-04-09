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

import java.util.List;

import fpl.poly.nhom9.duan1ht.Adapter.DangGiaoHangAdminAdapter;
import fpl.poly.nhom9.duan1ht.DAO.DonDatUseDAO;
import fpl.poly.nhom9.duan1ht.DTO.DonDatUserDTO;
import fpl.poly.nhom9.duan1ht.R;

public class FragmentDangGiaoHangFragment extends Fragment {
    RecyclerView recyclerChuanBijHang;
    List<DonDatUserDTO> list;
    DonDatUseDAO donDatUserDAO;
    DangGiaoHangAdminAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dang_chuan_bi_hang_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerChuanBijHang = view.findViewById(R.id.recyclerChuanBiHang);

        donDatUserDAO = new DonDatUseDAO(getContext());
        list = donDatUserDAO.selectDangGiaoHang();

        adapter = new DangGiaoHangAdminAdapter(list, getContext());
        LinearLayoutManager manager = new LinearLayoutManager(getContext(),
                LinearLayoutManager.VERTICAL, false);
        recyclerChuanBijHang.setLayoutManager(manager);
        recyclerChuanBijHang.setAdapter(adapter);
    }
    @Override
    public void onResume() {
        super.onResume();
        donDatUserDAO = new DonDatUseDAO(getContext());
        list = donDatUserDAO.selectDangGiaoHang();
        adapter = new DangGiaoHangAdminAdapter(list, getContext());
        LinearLayoutManager manager = new LinearLayoutManager(getContext(),
                LinearLayoutManager.VERTICAL, false);
        recyclerChuanBijHang.setLayoutManager(manager);
        recyclerChuanBijHang.setAdapter(adapter);
    }
}
