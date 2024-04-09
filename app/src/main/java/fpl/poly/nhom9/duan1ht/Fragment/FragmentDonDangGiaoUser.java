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

import fpl.poly.nhom9.duan1ht.Adapter.AdapterDonDangGiaoUse;
import fpl.poly.nhom9.duan1ht.DAO.DonDatUseDAO;
import fpl.poly.nhom9.duan1ht.DTO.DonDatUserDTO;
import fpl.poly.nhom9.duan1ht.R;

public class FragmentDonDangGiaoUser extends Fragment {
    RecyclerView recyclerView;
    DonDatUseDAO donDatUserDAO;
    List<DonDatUserDTO> list;
    AdapterDonDangGiaoUse adapterDonDangGiaoUser;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.frag_giao_hang_user, container, false);
    }
    @SuppressLint("NotifyDataSetChanged")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        recyclerView = view.findViewById(R.id.rcvDonGiaoHangUser);
        donDatUserDAO = new DonDatUseDAO(getContext());
        list = donDatUserDAO.selectDangGiaoHang();
        adapterDonDangGiaoUser = new AdapterDonDangGiaoUse(getContext(), list);
        LinearLayoutManager manager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapterDonDangGiaoUser);
        adapterDonDangGiaoUser.notifyDataSetChanged();


        super.onViewCreated(view, savedInstanceState);
    }
    @Override
    public void onResume() {
        super.onResume();
        donDatUserDAO = new DonDatUseDAO(getContext());
        list = donDatUserDAO.selectDangGiaoHang();
        adapterDonDangGiaoUser = new AdapterDonDangGiaoUse(getContext(), list);
        LinearLayoutManager manager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapterDonDangGiaoUser);
        adapterDonDangGiaoUser.notifyDataSetChanged();


    }
}
