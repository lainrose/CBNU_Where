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
import android.view.animation.Animation;

import com.labo.kaji.fragmentanimations.CubeAnimation;


public class TabFragment extends Fragment {

    public static TabLayout tlTabs;
    public static ViewPager vpTabViewPager;
    public static int int_items = 3 ;

    public static TabFragment newInstance(@DataBase.AnimationDirection int direction) {
        TabFragment tabFragment = new TabFragment();
        tabFragment.setArguments(new Bundle());
        tabFragment.getArguments().putInt("direction", direction);
        return tabFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_tab,null);

        tlTabs = (TabLayout) view.findViewById(R.id.tlTabs);
        vpTabViewPager = (ViewPager) view.findViewById(R.id.vpTabViewPager);
        if(DataBase.getSwitchParm()){
            vpTabViewPager.setAdapter(new TabAdapter(getChildFragmentManager(), new FragmentRecyclerView(), new FragmentMap(), new FragmentLike()));
        }
        else{
            vpTabViewPager.setAdapter(new TabAdapter(getChildFragmentManager(), new FragmentHome(), new FragmentMap(), new FragmentLike()));
        }
        tlTabs.post(new Runnable() {
                @Override
                public void run() {
                    tlTabs.setupWithViewPager(vpTabViewPager);
                }
            });
        DataBase.setSwitchParm(false);
        return view;
    }

    @Override
    public Animation onCreateAnimation(int transit, boolean enter, int nextAnim) {
        switch (getArguments().getInt("direction")) {
            case DataBase.UP:
                return CubeAnimation.create(CubeAnimation.UP, enter, DataBase.DURATION);
            case DataBase.DOWN:
                return CubeAnimation.create(CubeAnimation.DOWN, enter, DataBase.DURATION);
            case DataBase.LEFT:
                return CubeAnimation.create(CubeAnimation.LEFT, enter, DataBase.DURATION);
            case DataBase.RIGHT:
                return CubeAnimation.create(CubeAnimation.RIGHT, enter, DataBase.DURATION);
            default:
                return null;
        }
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
