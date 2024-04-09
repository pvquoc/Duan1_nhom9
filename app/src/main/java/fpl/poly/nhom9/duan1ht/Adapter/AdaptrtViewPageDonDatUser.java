package fpl.poly.nhom9.duan1ht.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import fpl.poly.nhom9.duan1ht.Fragment.FragmentDonDangGiaoUser;
import fpl.poly.nhom9.duan1ht.Fragment.FragmentDonHuyUSER;
import fpl.poly.nhom9.duan1ht.Fragment.FragmetDonHoanThanhUse;
import fpl.poly.nhom9.duan1ht.Fragment.FramentDonDatUser;

public class AdaptrtViewPageDonDatUser extends FragmentStateAdapter {
    public AdaptrtViewPageDonDatUser(@NonNull Fragment fragment){
        super(fragment);
    }
    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new FramentDonDatUser();
            case 1:
                return new FragmentDonDangGiaoUser();
            case 2:
                return new FragmetDonHoanThanhUse();
            case 3:
                return new FragmentDonHuyUSER();
            case 4:
                return new FragmetDonHoanThanhUse();
            default:
                return new FramentDonDatUser();
        }
    }

    @Override
    public int getItemCount() {
        return 5;
    }
}
