package fpl.poly.nhom9.duan1ht.Fragment;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.text.DecimalFormat;
import java.util.Calendar;

import fpl.poly.nhom9.duan1ht.Adapter.Fragmentadapter;
import fpl.poly.nhom9.duan1ht.DAO.ThongKeDAO;
import fpl.poly.nhom9.duan1ht.R;

public class FragmentThongKeAdmin extends Fragment {
    private TabLayout tabLayout;
    private ViewPager2 viewPager2;
    private Fragmentadapter fragmentadapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_thong_ke_admin, container, false);
         tabLayout=view.findViewById(R.id.Tablayout);
          viewPager2=view.findViewById(R.id.Viewpager2);
        fragmentadapter = new Fragmentadapter(getActivity());
        viewPager2.setAdapter(fragmentadapter);
        new TabLayoutMediator(tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                     switch (position){
                         case 0:
                             tab.setText("Doanh thu");
                             break;
                         case 1:
                             tab.setText("Top 10 sp ban chay nhat");
                             break;
                     }
            }
        }).attach();
          return view;
    }

}
