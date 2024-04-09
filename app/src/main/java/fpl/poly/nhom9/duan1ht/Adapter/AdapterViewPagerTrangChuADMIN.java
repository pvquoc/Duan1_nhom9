package fpl.poly.nhom9.duan1ht.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import fpl.poly.nhom9.duan1ht.Fragment.FragmentPhan1TrangChuAdmin;
import fpl.poly.nhom9.duan1ht.Fragment.FragmentPhan2TrangChuAdmin;
import fpl.poly.nhom9.duan1ht.Fragment.FragmentPhan3TrangChuAdmin;

public class AdapterViewPagerTrangChuADMIN extends FragmentStateAdapter {
    public AdapterViewPagerTrangChuADMIN(@NonNull Fragment fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new FragmentPhan1TrangChuAdmin();
            case 1:
                return new FragmentPhan2TrangChuAdmin();
            case 2:
                return new FragmentPhan3TrangChuAdmin();
            default:
                return new FragmentPhan1TrangChuAdmin();
        }

    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
