package fpl.poly.nhom9.duan1ht.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import fpl.poly.nhom9.duan1ht.Adapter.AdapterDanhSachSanPhamP2;
import fpl.poly.nhom9.duan1ht.DAO.DanhSachSanPhamDAO;
import fpl.poly.nhom9.duan1ht.DTO.DanhSachSanPhamDTO;
import fpl.poly.nhom9.duan1ht.R;

public class FragmentDanhSachSanPhamP2 extends Fragment {
    public static RecyclerView recyclerviewDanhSachSanPhamP2;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_p2_danh_sach_san_pham_user, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerviewDanhSachSanPhamP2 = view.findViewById(R.id.recyclerviewDanhSachSanPhamP2);
        DanhSachSanPhamDAO danhSachSanPhamDAO = new DanhSachSanPhamDAO(getContext());
        ArrayList<DanhSachSanPhamDTO> list = danhSachSanPhamDAO.getDSSPPhan2();

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2, GridLayoutManager.VERTICAL, false);
        recyclerviewDanhSachSanPhamP2.setLayoutManager(gridLayoutManager);

        AdapterDanhSachSanPhamP2 adapterDanhSachSanPhamP2 = new AdapterDanhSachSanPhamP2(list, getContext());
        recyclerviewDanhSachSanPhamP2.setAdapter(adapterDanhSachSanPhamP2);
    }
}
