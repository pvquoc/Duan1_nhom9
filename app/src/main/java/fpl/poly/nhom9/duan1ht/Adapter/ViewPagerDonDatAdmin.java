package fpl.poly.nhom9.duan1ht.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import fpl.poly.nhom9.duan1ht.Fragment.FragmentDangGiaoHangFragment;
import fpl.poly.nhom9.duan1ht.Fragment.FragmentDonDatAdmin;
import fpl.poly.nhom9.duan1ht.Fragment.HoanThanhDonHangFragment;

public class ViewPagerDonDatAdmin extends FragmentStateAdapter {

    public ViewPagerDonDatAdmin(@NonNull FragmentActivity fragmentActivity){
        super(fragmentActivity);
    }
    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new FragmentDonDatAdmin();
            case 1:
                return new FragmentDangGiaoHangFragment();
            case 2:
                return new HoanThanhDonHangFragment();
            default:
                return null;
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
