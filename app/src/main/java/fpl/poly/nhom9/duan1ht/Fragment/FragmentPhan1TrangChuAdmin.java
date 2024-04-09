package fpl.poly.nhom9.duan1ht.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import fpl.poly.nhom9.duan1ht.Adapter.AdapterSanPhamAdmin;
import fpl.poly.nhom9.duan1ht.Adapter.AdapterSanPhamPhan1Admin;
import fpl.poly.nhom9.duan1ht.DAO.TrangChuAdminDAO;
import fpl.poly.nhom9.duan1ht.DTO.SanPhamTrangChuDTO;
import fpl.poly.nhom9.duan1ht.R;
import fpl.poly.nhom9.duan1ht.SuaSanPhamActivity;
import fpl.poly.nhom9.duan1ht.ThemSanPhamAdminActivity;

public class FragmentPhan1TrangChuAdmin extends Fragment implements AdapterSanPhamAdmin.SanPhamAdminInterface, AdapterSanPhamPhan1Admin.SanPhamAdminInterface {
    public static RecyclerView recyclerViewPhan1;
    private FloatingActionButton flp1;
    private AdapterSanPhamPhan1Admin.SanPhamAdminInterface listen;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_phan1,container,false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        listen=this;
        recyclerViewPhan1=view.findViewById(R.id.rcphan1);
        flp1=view.findViewById(R.id.flphan1);
        loadData();
        flp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), ThemSanPhamAdminActivity.class));
            }
        });
        recyclerViewPhan1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                startActivity(new Intent(getContext(), SuaSanPhamActivity.class));
                return false;
            }
        });
    }
    private void loadData(){
        TrangChuAdminDAO trangChuAdminDAO=new TrangChuAdminDAO(getContext());
        ArrayList<SanPhamTrangChuDTO> list=trangChuAdminDAO.getDSSanPhamP1Admin();
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2, GridLayoutManager.VERTICAL, false);
        recyclerViewPhan1.setLayoutManager(gridLayoutManager);
        AdapterSanPhamPhan1Admin adapterSanPhamAdmin=new AdapterSanPhamPhan1Admin(list,getContext(),listen);
        recyclerViewPhan1.setAdapter(adapterSanPhamAdmin);
        adapterSanPhamAdmin.notifyDataSetChanged();
    }

    @Override
    public void updateSanPham(SanPhamTrangChuDTO dto) {
        Intent intent=new Intent(requireActivity(), SuaSanPhamActivity.class);
        intent.putExtra("dto", dto);
        requireActivity().startActivity(intent);
    }
}
