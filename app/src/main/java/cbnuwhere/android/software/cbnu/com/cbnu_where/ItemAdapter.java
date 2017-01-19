package cbnuwhere.android.software.cbnu.com.cbnu_where;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.sackcentury.shinebuttonlib.ShineButton;
import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.itemViewHolder> {

    private ArrayList<ItemModel> listItems;
    private Context context = null;

    public ItemAdapter(Context c, ArrayList<ItemModel> listItems) {
        this.context = c;
        this.listItems = listItems;
    }

    @Override
    public itemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item, parent, false);
        return new itemViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final itemViewHolder holder, final int position) {

        holder.tvCoverText.setText(listItems.get(position).getName());
        holder.btOpenAndClose.setBackgroundResource(R.drawable.button_shape_green_main);
        holder.ivCoverImage.setImageResource(listItems.get(position).getImage());
        //holder.btLike


        //트럭 클릭하면 Activity Detail로 이동하는 온클릭 리스너.
        holder.ivCoverImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        //좋아요버튼 리스너
        holder.btLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public static class itemViewHolder extends RecyclerView.ViewHolder {

        public TextView tvCoverText;
        public ImageView ivCoverImage;
        public ShineButton btLike;
        public Button btOpenAndClose;


        public itemViewHolder(View v) {
            super(v);
            tvCoverText = (TextView) v.findViewById(R.id.tvCoverText);
            ivCoverImage = (ImageView) v.findViewById(R.id.ivCoverImage);
            btLike = (ShineButton) v.findViewById(R.id.btLike);
            btOpenAndClose = (Button) v.findViewById(R.id.btOpenAndClose);

        }
    }
}