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
import fpl.poly.nhom9.duan1ht.Adapter.AdapterSanPhamPhan2Admin;
import fpl.poly.nhom9.duan1ht.DAO.TrangChuAdminDAO;
import fpl.poly.nhom9.duan1ht.DTO.SanPhamTrangChuDTO;
import fpl.poly.nhom9.duan1ht.R;
import fpl.poly.nhom9.duan1ht.SuaSanPhamActivity;
import fpl.poly.nhom9.duan1ht.ThemSanPhamAdminActivity;

public class FragmentPhan3TrangChuAdmin extends Fragment  implements AdapterSanPhamPhan2Admin.SanPhamAdminInterface, AdapterSanPhamPhan1Admin.SanPhamAdminInterface  {
    public static RecyclerView recyclerViewPhan3;
    private FloatingActionButton flp3;
    private AdapterSanPhamPhan1Admin.SanPhamAdminInterface listen;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_phan3,container,false);
        return view;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        listen=this;
        recyclerViewPhan3=view.findViewById(R.id.rcphan3);
        flp3=view.findViewById(R.id.flphan3);
        loadData();
        flp3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), ThemSanPhamAdminActivity.class));
            }
        });
        recyclerViewPhan3.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                startActivity(new Intent(getContext(), SuaSanPhamActivity.class));
                return false;
            }
        });
    }
    private void loadData(){
        TrangChuAdminDAO trangChuAdminDAO=new TrangChuAdminDAO(getContext());
        ArrayList<SanPhamTrangChuDTO> list=trangChuAdminDAO.getDSSanPhamP3Admin();
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2, GridLayoutManager.VERTICAL, false);
        recyclerViewPhan3.setLayoutManager(gridLayoutManager);
        AdapterSanPhamAdmin adapterSanPhamAdmin=new AdapterSanPhamAdmin(list,getContext(),listen);
        recyclerViewPhan3.setAdapter(adapterSanPhamAdmin);
    }
    public void onResume(){
        super.onResume();
        loadData();
    }

    @Override

    public void updateSanPham(SanPhamTrangChuDTO dto) {
        Intent intent=new Intent(requireActivity(), SuaSanPhamActivity.class);
        intent.putExtra("dto", dto);
        requireActivity().startActivity(intent);
    }
}
