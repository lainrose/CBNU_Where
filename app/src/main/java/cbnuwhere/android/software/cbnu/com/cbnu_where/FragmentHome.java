package cbnuwhere.android.software.cbnu.com.cbnu_where;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.LinearLayout;
import android.widget.Switch;

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
            DataBase.getInstance().setCategory("pcBang");
            DataBase.getInstance().setSwitchParm(true);
            DataBase.getInstance().setDirection(DataBase.NODIR);
            Log.d("방향", ""+DataBase.getInstance().getDirection());
            Transaction(DataBase.getDirection());
        }
        else if(view.getId() == R.id.llClawGame) {
            DataBase.getInstance().setCategory("clawGame");
            DataBase.getInstance().setSwitchParm(true);
            DataBase.getInstance().setDirection(DataBase.UP);
            Log.d("방향", ""+DataBase.getInstance().getDirection());

            Transaction(DataBase.getDirection());
        }
        else if(view.getId() == R.id.llKaraoke) {
            DataBase.getInstance().setCategory("karaoke");
            DataBase.getInstance().setSwitchParm(true);
            DataBase.getInstance().setDirection(DataBase.NODIR);
            Log.d("방향", ""+DataBase.getInstance().getDirection());

            Transaction(DataBase.getDirection());
        }
        else if(view.getId() == R.id.llDringkingBar) {
            DataBase.getInstance().setCategory("dringkingBar");
            DataBase.getInstance().setSwitchParm(true);
            DataBase.getInstance().setDirection(DataBase.LEFT);
            Log.d("방향", ""+DataBase.getInstance().getDirection());

            Transaction(DataBase.getDirection());
        }
        else if(view.getId() == R.id.llAll) {
            DataBase.getInstance().setCategory("all");
            DataBase.getInstance().setSwitchParm(true);
            DataBase.getInstance().setDirection(DataBase.NODIR);
            Log.d("방향", ""+DataBase.getInstance().getDirection());

            Transaction(DataBase.getDirection());
        }
        else if(view.getId() == R.id.llFoodStore) {
            DataBase.getInstance().setCategory("foodStore");
            DataBase.getInstance().setSwitchParm(true);
            DataBase.getInstance().setDirection(DataBase.RIGHT);
            Log.d("방향", ""+DataBase.getInstance().getDirection());

            Transaction(DataBase.getDirection());
        }
        else if(view.getId() == R.id.llBilliards) {
            DataBase.getInstance().setCategory("billiards");
            DataBase.getInstance().setSwitchParm(true);
            DataBase.getInstance().setDirection(DataBase.DOWN);
            Log.d("방향", ""+DataBase.getInstance().getDirection());

            Transaction(DataBase.getDirection());
        }
    }

    private void Transaction(int direction){
        FragmentTransaction fragmentTransaction = FragmentMain.fragmentManager.beginTransaction();
        switch(DataBase.getInstance().getDirection()){
            case DataBase.UP:
                fragmentTransaction.replace(R.id.flMainContainer, new TabFragment().newInstance(DataBase.UP)).commit();
                break;
            case DataBase.DOWN:
                fragmentTransaction.replace(R.id.flMainContainer, new TabFragment().newInstance(DataBase.DOWN)).commit();
                break;
            case DataBase.LEFT:
                fragmentTransaction.replace(R.id.flMainContainer, new TabFragment().newInstance(DataBase.LEFT)).commit();
                break;
            case DataBase.RIGHT:
                fragmentTransaction.replace(R.id.flMainContainer, new TabFragment().newInstance(DataBase.RIGHT)).commit();
                break;
            case DataBase.NODIR :
                fragmentTransaction.replace(R.id.flMainContainer, new TabFragment().newInstance(DataBase.NODIR)).commit();
                break;
        }
    }

}
