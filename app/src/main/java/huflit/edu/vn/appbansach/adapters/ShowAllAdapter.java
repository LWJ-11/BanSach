package huflit.edu.vn.appbansach.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import huflit.edu.vn.appbansach.R;
import huflit.edu.vn.appbansach.activities.DetailActivity;
import huflit.edu.vn.appbansach.models.ShowAllModel;

public class ShowAllAdapter extends RecyclerView.Adapter<ShowAllAdapter.ViewHolder> {

    private Context context;
    private List<ShowAllModel> list;

    public ShowAllAdapter(Context context, List<ShowAllModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ShowAllAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.show_all_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ShowAllAdapter.ViewHolder holder, int position) {
        Glide.with(context).load(list.get(position).getImg_url()).into(holder.mItemImage);
        holder.mName.setText(list.get(position).getName());
        holder.mCost.setText(String.valueOf(list.get(position).getPrice() + " VND" ));


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("detailed", list.get(position));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView mItemImage;
        private TextView mCost;
        private TextView mName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mItemImage = itemView.findViewById(R.id.item_image);
            mName = itemView.findViewById(R.id.item_nam);
            mCost = itemView.findViewById(R.id.item_cost);
        }
    }
}
