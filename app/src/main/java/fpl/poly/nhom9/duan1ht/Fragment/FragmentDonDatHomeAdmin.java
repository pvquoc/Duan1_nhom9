package fpl.poly.nhom9.duan1ht.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import fpl.poly.nhom9.duan1ht.Adapter.ViewPagerDonDatAdmin;
import fpl.poly.nhom9.duan1ht.R;

public class FragmentDonDatHomeAdmin extends Fragment {
    private TabLayout tabLayout;
    private ViewPager2 viewPager2;
    private ViewPagerDonDatAdmin viewPagerDonDatAdmin;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_danh_sach_don_admin, container, false);
        return view;    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tabLayout=view.findViewById(R.id.tabLayoutDonDatAdmin);
        viewPager2=view.findViewById(R.id.viewPager2DonDatAdmin);
        viewPagerDonDatAdmin=new ViewPagerDonDatAdmin(getActivity());
        viewPager2.setAdapter(viewPagerDonDatAdmin);
        new TabLayoutMediator(tabLayout, viewPager2, (tab, position) -> {
            switch (position) {
                case 0:
                    tab.setText("Đơn đặt");
                    break;
                case 1:
                    tab.setText("Giao hàng");
                    break;
                case 2:
                    tab.setText("Hoàn thành");
                    break;
            }
        }).attach();
    }
}
