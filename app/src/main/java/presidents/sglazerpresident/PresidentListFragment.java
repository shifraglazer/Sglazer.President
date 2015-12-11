package presidents.sglazerpresident;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.InputStream;
import java.io.InputStreamReader;

public class PresidentListFragment extends Fragment {

    private RecyclerView recyclerView;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        LinearLayoutManager layoutManager= new LinearLayoutManager(this.getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView= (RecyclerView) view.findViewById(R.id.list);
        recyclerView.setLayoutManager(layoutManager);
        InputStream in=getResources().openRawResource(R.raw.presidents);

        Gson gson= new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();
        President [] presidents= gson.fromJson(new InputStreamReader(in), President[].class);
        PresidentAdapter adapter= new PresidentAdapter(presidents);
        recyclerView.setAdapter(adapter);
    }

    @Override
    @Nullable
public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
    return inflater.inflate(R.layout.fragment_president_list,container,false);


}
}
