package cbnuwhere.android.software.cbnu.com.cbnu_where;

import android.content.ClipData;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;

import com.labo.kaji.fragmentanimations.CubeAnimation;

import java.util.ArrayList;

public class FragmentRecyclerView extends Fragment implements SearchView.OnQueryTextListener {

    private RecyclerView rvRecyclerView;
    private ItemAdapter itemAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_recyclerview, container, false);

        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayShowCustomEnabled(true);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayShowHomeEnabled(true);


        rvRecyclerView = (RecyclerView)view.findViewById(R.id.rvRecyclerView);
        rvRecyclerView.setHasFixedSize(true);
        LinearLayoutManager MyLayoutManager = new LinearLayoutManager(getActivity());
        MyLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvRecyclerView.setLayoutManager(MyLayoutManager);
        showListItems(listItems);
        return view;
    }

    // 툴바 버튼 설정
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                FragmentTransaction xfragmentTransaction = FragmentMain.fragmentManager.beginTransaction();
                if(DataBase.animationDirection.equals("leftIn")){
                    DataBase.animationDirection = "leftOut";
                    //xfragmentTransaction.setCustomAnimations(R.anim.trans_left_in, R.anim.trans_bottom_out);
                }
                else if(DataBase.animationDirection.equals("rightIn")){
                    DataBase.animationDirection = "rightOut";
                    //xfragmentTransaction.setCustomAnimations(R.anim.trans_right_in, R.anim.trans_bottom_out);
                }
                else if(DataBase.animationDirection.equals("upIn")){
                    DataBase.animationDirection = "upOut";
                    //xfragmentTransaction.setCustomAnimations(R.anim.trans_top_in, R.anim.trans_bottom_out);
                }
                else if(DataBase.animationDirection.equals("downIn")){
                    DataBase.animationDirection = "downOut";
                    //xfragmentTransaction.setCustomAnimations(R.anim.trans_top_in, R.anim.trans_bottom_out);
                }
                xfragmentTransaction.replace(R.id.flMainContainer, new TabFragment()).commit();
                return true;
            case R.id.action_random:
                Log.d("누름", "누름");
        }
        return super.onOptionsItemSelected(item);
    }

    //툴바검색
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_main, menu);

        //서치바로 검색해서 아이템 찾기
        final MenuItem item = menu.findItem(R.id.action_search);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(item);
        searchView.setOnQueryTextListener(this);

        MenuItemCompat.setOnActionExpandListener(item,
                new MenuItemCompat.OnActionExpandListener() {
                    @Override
                    public boolean onMenuItemActionCollapse(MenuItem item) {
                        // Do something when collapsed 뒤로가기버튼

                        return true;
                    }

                    @Override
                    public boolean onMenuItemActionExpand(MenuItem item) {
                        // Do something when expanded 서치버튼

                        return true;
                    }
                }
        );
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }

    private void showListItems(ArrayList<ItemModel> listItems) {
        for (ItemModel model : listItems) {
            if (model.getCategory().equals(DataBase.category)) {
                categoryListItems.add(model);
            }
        }
        if(DataBase.category.equals("all")){
            categoryListItems.addAll(listItems);
        }
        itemAdapter = new ItemAdapter(getActivity(), categoryListItems);
        rvRecyclerView.setAdapter(itemAdapter);
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
