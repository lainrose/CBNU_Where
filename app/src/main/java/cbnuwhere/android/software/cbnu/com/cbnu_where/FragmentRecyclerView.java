package cbnuwhere.android.software.cbnu.com.cbnu_where;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.MenuItemCompat;
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
        itemAdapter = new ItemAdapter(getActivity(), DataBase.getInstance().getCategoryListItems());
        rvRecyclerView.setAdapter(itemAdapter);
        return view;
    }

    // 툴바 버튼 설정
    public boolean onOptionsItemSelected(MenuItem item) {

        FragmentTransaction xfragmentTransaction = FragmentMain.fragmentManager.beginTransaction();
        switch (item.getItemId()) {
            case android.R.id.home:
                switch (DataBase.getDirection()){
                    case DataBase.UP :
                        xfragmentTransaction.replace(R.id.flMainContainer, new TabFragment().newInstance(DataBase.DOWN)).commit();
                        break;
                    case DataBase.DOWN :
                        xfragmentTransaction.replace(R.id.flMainContainer, new TabFragment().newInstance(DataBase.DOWN)).commit();
                        break;
                    case DataBase.LEFT :
                        xfragmentTransaction.replace(R.id.flMainContainer, new TabFragment().newInstance(DataBase.LEFT)).commit();
                        break;
                    case DataBase.RIGHT :
                        xfragmentTransaction.replace(R.id.flMainContainer, new TabFragment().newInstance(DataBase.RIGHT)).commit();
                        break;
                    case DataBase.NODIR :
                        xfragmentTransaction.replace(R.id.flMainContainer, new TabFragment().newInstance(DataBase.NODIR)).commit();
                        break;
                }
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

}
