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

import fpl.poly.nhom9.duan1ht.Adapter.HoanThanhDonDatAdapter;
import fpl.poly.nhom9.duan1ht.DAO.DonDatUseDAO;
import fpl.poly.nhom9.duan1ht.DTO.DonDatUserDTO;
import fpl.poly.nhom9.duan1ht.R;

public class HoanThanhDonHangFragment extends Fragment {
    RecyclerView recyclerViewHoanThanh;
    List<DonDatUserDTO> list;
    DonDatUseDAO donDatUserDAO;
    HoanThanhDonDatAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dang_giao_hang_fragment, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerViewHoanThanh = view.findViewById(R.id.recyclerHoanThanhGiaoHang);

        donDatUserDAO = new DonDatUseDAO(getContext());
        list = donDatUserDAO.selectHoanThanhGiaoHang();

        adapter = new HoanThanhDonDatAdapter(list, getContext());
        LinearLayoutManager manager = new LinearLayoutManager(getContext(),
                LinearLayoutManager.VERTICAL, false);
        recyclerViewHoanThanh.setLayoutManager(manager);
        recyclerViewHoanThanh.setAdapter(adapter);
    }
    @Override
    public void onResume() {
        super.onResume();
        list = donDatUserDAO.selectHoanThanhGiaoHang();
        adapter.setData(list);
    }

}
