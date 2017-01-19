package cbnuwhere.android.software.cbnu.com.cbnu_where;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class TabFragment extends Fragment {

    public static TabLayout tlTabs;
    public static ViewPager vpTabViewPager;
    public static int int_items = 3 ;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

            View view =  inflater.inflate(R.layout.fragment_tab,null);

            tlTabs = (TabLayout) view.findViewById(R.id.tlTabs);
            vpTabViewPager = (ViewPager) view.findViewById(R.id.vpTabViewPager);
            vpTabViewPager.setAdapter(new TabAdapter(getChildFragmentManager(), new FragmentHome(), new FragmentMap(), new FragmentLike()));
            tlTabs.post(new Runnable() {
                @Override
                public void run() {
                    tlTabs.setupWithViewPager(vpTabViewPager);
                }
            });
        return view;
    }

    public static class TabAdapter extends FragmentPagerAdapter {

        private Fragment one;
        private Fragment two;
        private Fragment three;


        public TabAdapter(FragmentManager fragmentManager, Fragment one, Fragment two, Fragment three) {
            super(fragmentManager);
            this.one = one;
            this.two = two;
            this.three = three;
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0 : return one;
                case 1 : return two;
                case 2 : return three;
            }
            return null;
        }

        @Override
        public int getCount() {
            return int_items;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position){
                case 0 :
                    return "홈";
                case 1 :
                    return "지도 검색";
                case 2 :
                    return "좋아요";
            }
            return null;
        }
    }
}
