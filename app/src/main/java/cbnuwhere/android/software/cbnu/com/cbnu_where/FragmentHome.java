package cbnuwhere.android.software.cbnu.com.cbnu_where;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.LinearLayout;

import com.labo.kaji.fragmentanimations.CubeAnimation;

public class FragmentHome extends Fragment implements View.OnClickListener {



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        LinearLayout llPcBang = (LinearLayout) view.findViewById(R.id.llPcBang);
        llPcBang.setOnClickListener(this);
        LinearLayout llClawGame = (LinearLayout) view.findViewById(R.id.llClawGame);
        llClawGame.setOnClickListener(this);
        LinearLayout llKaraoke = (LinearLayout) view.findViewById(R.id.llKaraoke);
        llKaraoke.setOnClickListener(this);
        LinearLayout llDringkingBar = (LinearLayout) view.findViewById(R.id.llDringkingBar);
        llDringkingBar.setOnClickListener(this);
        LinearLayout llAll = (LinearLayout) view.findViewById(R.id.llAll);
        llAll.setOnClickListener(this);
        LinearLayout llFoodStore = (LinearLayout) view.findViewById(R.id.llFoodStore);
        llFoodStore.setOnClickListener(this);
        LinearLayout llBilliards = (LinearLayout) view.findViewById(R.id.llBilliards);
        llBilliards.setOnClickListener(this);

        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayShowCustomEnabled(false);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayShowHomeEnabled(false);
        return view;
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.llPcBang) {
            DataBase.category = "pcBang";
            DataBase.animationDirection = "downIn";
            Transaction(new FragmentRecyclerView(), "left");
        }
        else if(view.getId() == R.id.llClawGame) {
            DataBase.category = "clawGame";
            DataBase.animationDirection = "downIn";
            Transaction(new FragmentRecyclerView(), "top");
        }
        else if(view.getId() == R.id.llKaraoke) {
            DataBase.category = "karaoke";
            DataBase.animationDirection = "leftIn";
            Transaction(new FragmentRecyclerView(), "top");
        }
        else if(view.getId() == R.id.llDringkingBar) {
            DataBase.category = "dringkingBar";
            DataBase.animationDirection = "rightIn";
            Transaction(new FragmentRecyclerView(), "left");
        }
        else if(view.getId() == R.id.llAll) {
            DataBase.category = "all";
            Transaction(new FragmentRecyclerView(), "");
        }
        else if(view.getId() == R.id.llFoodStore) {
            DataBase.category = "foodStore";
            DataBase.animationDirection = "leftIn";
            Transaction(new FragmentRecyclerView(), "right");
        }
        else if(view.getId() == R.id.llBilliards) {
            DataBase.category = "billiards";
            DataBase.animationDirection = "upIn";
            Transaction(new FragmentRecyclerView(), "bottom");
        }
    }

    private void Transaction(Fragment fragment, String strParm){
        FragmentTransaction fragmentTransaction = FragmentMain.fragmentManager.beginTransaction();

        if(strParm.equals("top")){
            fragmentTransaction.setCustomAnimations(R.anim.trans_bottom_in, R.anim.trans_top_out);
        }
        else if(strParm.equals("bottom")){
            fragmentTransaction.setCustomAnimations(R.anim.trans_bottom_in, R.anim.trans_top_out);
        }
        else if(strParm.equals("left")){
            fragmentTransaction.setCustomAnimations(R.anim.trans_left_in, R.anim.trans_top_out);
        }
        else if(strParm.equals("right")){
            fragmentTransaction.setCustomAnimations(R.anim.trans_right_in, R.anim.trans_top_out);
        }
        else{
            //
        }

        fragmentTransaction.replace(R.id.flMainContainer, fragment).addToBackStack(null).commit();
    }

    @Override
    public Animation onCreateAnimation(int transit, boolean enter, int nextAnim) {
        if(DataBase.animationDirection.equals("leftIn")){
            return CubeAnimation.create(CubeAnimation.LEFT, enter, 550);
        }
        else if(DataBase.animationDirection.equals("leftOut")){
            return CubeAnimation.create(CubeAnimation.RIGHT, enter, 550);
        }
        else if(DataBase.animationDirection.equals("rightIn")){
            return CubeAnimation.create(CubeAnimation.RIGHT, enter, 550);
        }
        else if(DataBase.animationDirection.equals("rightOut")){
            return CubeAnimation.create(CubeAnimation.LEFT, enter, 550);
        }
        else if(DataBase.animationDirection.equals("upIn")){
            return CubeAnimation.create(CubeAnimation.UP, enter, 550);
        }
        else if(DataBase.animationDirection.equals("upOut")){
            return CubeAnimation.create(CubeAnimation.DOWN, enter, 550);
        }
        else if(DataBase.animationDirection.equals("downIn")){
            return CubeAnimation.create(CubeAnimation.DOWN, enter, 550);
        }
        else if(DataBase.animationDirection.equals("downOut")){
            return CubeAnimation.create(CubeAnimation.UP, enter, 550);
        }
        else {
            return CubeAnimation.create(CubeAnimation.UP, enter, 550);
        }
    }
}
