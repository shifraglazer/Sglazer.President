package presidents.sglazerpresident;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by student1 on 10/22/2015.
 */
public class PresidentAdapter extends RecyclerView.Adapter<PresidentViewHolder> {

    private President[] presidents;
    private OnPresidentSelectedListener listener;

    public PresidentAdapter(President[] presidents, OnPresidentSelectedListener listener) {
        this.presidents = presidents;
        this.listener = listener;
    }

    @Override
    public int getItemViewType(int position) {
        return 0;
    }

    @Override
    public PresidentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.president_list_item, parent, false);
        return new PresidentViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final PresidentViewHolder holder, final int position) {
        holder.bind(presidents[position]);
        holder.itemView.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                listener.onSelect(presidents,position);
            }
        });
    }


    @Override
    public int getItemCount() {
        return presidents.length;
    }
}
