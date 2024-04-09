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

import fpl.poly.nhom9.duan1ht.Adapter.AdaptrtViewPageDonDatUser;
import fpl.poly.nhom9.duan1ht.R;

public class FragmetDonDatHomeUser extends Fragment {
    private TabLayout tabLayout;
    private ViewPager2 viewPager2;
    private AdaptrtViewPageDonDatUser adapterViewPagerDonDat;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_don_dat_home_user, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tabLayout = view.findViewById(R.id.myTabLayoutDonDat);
        viewPager2 = view.findViewById(R.id.viewPager2DonDat);

        adapterViewPagerDonDat = new AdaptrtViewPageDonDatUser(this);
        viewPager2.setAdapter(adapterViewPagerDonDat);
        TabLayoutMediator mediator = new TabLayoutMediator(tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {

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
                    case 3:
                        tab.setText("Đơn hủy");
                        break;
                    case 4:
                        tab.setText("Lịch sử đơn mua");
                        break;
                }

            }
        });
        mediator.attach();

    }
}
