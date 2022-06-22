package huflit.edu.vn.appbansach.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import huflit.edu.vn.appbansach.R;
import huflit.edu.vn.appbansach.activities.ShowAllProductWIthTopicActivity;
import huflit.edu.vn.appbansach.models.CategoryModel;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {

    private Context context;
    private List<CategoryModel> list;

    public CategoryAdapter(Context context,List<CategoryModel>list){
        this.context=context;
        this.list=list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent,int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.category_list,parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder,int position) {
        Glide.with(context).load(list.get(position).getImg_url()).into(holder.catImg);
        holder.catName.setText(list.get(position).getName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ShowAllProductWIthTopicActivity.class);
                intent.putExtra("type",list.get(position).getType());
                context.startActivity(intent);
            }
        });
    }
    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView catImg;
        TextView catName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            catImg= itemView.findViewById(R.id.cat_img);
            catName=itemView.findViewById(R.id.cat_name);
        }
    }
}

