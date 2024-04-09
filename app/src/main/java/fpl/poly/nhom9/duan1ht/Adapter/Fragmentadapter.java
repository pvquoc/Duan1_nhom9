package fpl.poly.nhom9.duan1ht.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import fpl.poly.nhom9.duan1ht.Fragment.fragmentthongkedoanhthu;
import fpl.poly.nhom9.duan1ht.Fragment.thongketop10Fragment;

public class Fragmentadapter extends FragmentStateAdapter {
    public Fragmentadapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position==0)
            return new fragmentthongkedoanhthu();
        else  {
            return new thongketop10Fragment();
        }}


    @Override
    public int getItemCount() {
        return 2;
    }
}
