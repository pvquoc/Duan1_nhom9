package fpl.poly.nhom9.duan1ht.Fragment;

import android.annotation.SuppressLint;
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

import fpl.poly.nhom9.duan1ht.Adapter.AdapterDonHoanThanhUsse;
import fpl.poly.nhom9.duan1ht.DAO.DonDatUseDAO;
import fpl.poly.nhom9.duan1ht.DTO.DonDatUserDTO;
import fpl.poly.nhom9.duan1ht.R;

public class FragmetDonHoanThanhUse extends Fragment {
    RecyclerView recyclerView;
    AdapterDonHoanThanhUsse adapterDonHoanThanhUser;
    List<DonDatUserDTO> list;
    DonDatUseDAO donDatUserDAO;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.frag_hoan_thanh_user, container, false);
    }
    @SuppressLint("NotifyDataSetChanged")
    @Override
    public void onResume() {
        super.onResume();
        donDatUserDAO = new DonDatUseDAO(getContext());
        list = donDatUserDAO.selectHoanThanhGiaoHang();
        adapterDonHoanThanhUser = new AdapterDonHoanThanhUsse(getContext(), list);
        LinearLayoutManager manager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapterDonHoanThanhUser);
        adapterDonHoanThanhUser.notifyDataSetChanged();


    }
    @SuppressLint("NotifyDataSetChanged")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        recyclerView = view.findViewById(R.id.rcvHoanHangDonUser);
        donDatUserDAO = new DonDatUseDAO(getContext());
        list = donDatUserDAO.selectHoanThanhGiaoHang();
        adapterDonHoanThanhUser = new AdapterDonHoanThanhUsse(getContext(), list);
        LinearLayoutManager manager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapterDonHoanThanhUser);
        adapterDonHoanThanhUser.notifyDataSetChanged();


        super.onViewCreated(view, savedInstanceState);
    }

}
