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

import fpl.poly.nhom9.duan1ht.Adapter.AdapterDonDatAdmin;
import fpl.poly.nhom9.duan1ht.DAO.DonDatUseDAO;
import fpl.poly.nhom9.duan1ht.DTO.DonDatUserDTO;
import fpl.poly.nhom9.duan1ht.R;

public class FragmentDonDatAdmin extends Fragment {
    RecyclerView rc;
    List<DonDatUserDTO> list;
    DonDatUseDAO donDatUseDAO;
    AdapterDonDatAdmin adapterDonDatAdmin;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cho_xac_nhan_don_admin, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rc=view.findViewById(R.id.recyclerChoXacNhan);
        donDatUseDAO=new DonDatUseDAO(getContext());
        list=donDatUseDAO.donDat();

        adapterDonDatAdmin=new AdapterDonDatAdmin(list,getContext());
        LinearLayoutManager manager=new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        rc.setLayoutManager(manager);
        rc.setAdapter(adapterDonDatAdmin);
    }
    public void onResume(){
        super.onResume();
        donDatUseDAO=new DonDatUseDAO(getContext());
        list=donDatUseDAO.donDat();
        adapterDonDatAdmin=new AdapterDonDatAdmin(list,getContext());
        LinearLayoutManager manager = new LinearLayoutManager(getContext(),
                LinearLayoutManager.VERTICAL, false);
        rc.setLayoutManager(manager);
        rc.setAdapter(adapterDonDatAdmin);
    }
}
