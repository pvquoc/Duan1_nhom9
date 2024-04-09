package fpl.poly.nhom9.duan1ht.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import fpl.poly.nhom9.duan1ht.Fragment.LoginFrament;
import fpl.poly.nhom9.duan1ht.Fragment.SingUpFragment;



public class AdapterViewPagerLoginSigUp extends FragmentStateAdapter {
    public AdapterViewPagerLoginSigUp(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        switch (position){

            case 0:
                return new LoginFrament();
            case 1:
                return new SingUpFragment();
            default:
                return new LoginFrament();

        }


    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
