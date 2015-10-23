package presidents.sglazerpresident;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by student1 on 10/22/2015.
 */
public class PresidentAdapter extends RecyclerView.Adapter<PresidentViewHolder>{

    private President [] presidents;
    public PresidentAdapter(President[] presidents){
        this.presidents= presidents;
    }
    @Override
    public PresidentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.president_list_item,parent,false);
        return new PresidentViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(PresidentViewHolder holder, int position) {
    holder.bind(presidents[position]);
    }


    @Override
    public int getItemCount() {
        return presidents.length;
    }
}
