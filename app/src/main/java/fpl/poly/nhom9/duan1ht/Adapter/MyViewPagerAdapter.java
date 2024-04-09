package fpl.poly.nhom9.duan1ht.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import fpl.poly.nhom9.duan1ht.Fragment.FragmentDanhSachSanPhamP1;
import fpl.poly.nhom9.duan1ht.Fragment.FragmentDanhSachSanPhamP2;
import fpl.poly.nhom9.duan1ht.Fragment.FragmentDanhSachSanPhamP3;


public class MyViewPagerAdapter extends FragmentStateAdapter {


    public MyViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new FragmentDanhSachSanPhamP1();
            case 1:
                return new FragmentDanhSachSanPhamP2();
            case 2:
                return new FragmentDanhSachSanPhamP3();
            default:
                return new FragmentDanhSachSanPhamP1();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
