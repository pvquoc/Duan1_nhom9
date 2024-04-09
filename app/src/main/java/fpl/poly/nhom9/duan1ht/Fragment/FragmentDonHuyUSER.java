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

import fpl.poly.nhom9.duan1ht.Adapter.AdapterDonHuyUser;
import fpl.poly.nhom9.duan1ht.DAO.DonDatUseDAO;
import fpl.poly.nhom9.duan1ht.DTO.DonDatUserDTO;
import fpl.poly.nhom9.duan1ht.R;

public class FragmentDonHuyUSER extends Fragment {
    RecyclerView rc;
    List<DonDatUserDTO> list;
    DonDatUseDAO donDatUseDAO;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_don_huy_user,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rc=view.findViewById(R.id.rcvDonHuyFragment);
        donDatUseDAO=new DonDatUseDAO(getContext());
        list=donDatUseDAO.donHuy();
        AdapterDonHuyUser adapterDonHuyUser=new AdapterDonHuyUser(getContext(),list);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        rc.setLayoutManager(linearLayoutManager);
        rc.setAdapter(adapterDonHuyUser);
        adapterDonHuyUser.notifyDataSetChanged();
    }
    @Override
    public void onResume() {
        super.onResume();
        donDatUseDAO = new DonDatUseDAO(getContext());
        list = donDatUseDAO.donHuy();
        AdapterDonHuyUser adapterDonHuyUser = new AdapterDonHuyUser(getContext(),list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext()
                ,LinearLayoutManager.VERTICAL,false);
        rc.setLayoutManager(linearLayoutManager);
        rc.setAdapter(adapterDonHuyUser);
        adapterDonHuyUser.notifyDataSetChanged();


    }
}
