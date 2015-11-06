package presidents.sglazerpresident;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
    public President presidents [];
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        LinearLayoutManager layoutManager= new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView= (RecyclerView) findViewById(R.id.list);
        recyclerView.setLayoutManager(layoutManager);
        InputStream in=getResources().openRawResource(R.raw.presidents);

        Gson gson= new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();
        presidents= gson.fromJson(new InputStreamReader(in), President[].class);
        PresidentAdapter adapter= new PresidentAdapter(presidents);
        recyclerView.setAdapter(adapter);

    }
}
