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

import fpl.poly.nhom9.duan1ht.Adapter.AdapterDonDatUSE;
import fpl.poly.nhom9.duan1ht.DAO.DonDatUseDAO;
import fpl.poly.nhom9.duan1ht.DTO.DonDatUserDTO;
import fpl.poly.nhom9.duan1ht.R;

public class FramentDonDatUser extends Fragment {
    List<DonDatUserDTO> list;
    DonDatUseDAO donDatUserDAO;
    AdapterDonDatUSE adapterDonDatUser;
    RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_don_dat_user,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //Ánh xạ view
        recyclerView = view.findViewById(R.id.rcvDonDatUser);

        //Khởi tạo dao
        donDatUserDAO = new DonDatUseDAO(getContext());
        list = donDatUserDAO.donDat();
        adapterDonDatUser = new AdapterDonDatUSE(getContext(),list);
        LinearLayoutManager manager = new LinearLayoutManager(getContext()
                ,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapterDonDatUser);
        adapterDonDatUser.notifyDataSetChanged();
    }
    @Override
    public void onResume() {
        super.onResume();
        donDatUserDAO = new DonDatUseDAO(getContext());
        list = donDatUserDAO.donDat();
        adapterDonDatUser = new AdapterDonDatUSE(getContext(),list);
        LinearLayoutManager manager = new LinearLayoutManager(getContext()
                ,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapterDonDatUser);
        adapterDonDatUser.notifyDataSetChanged();

    }
}
