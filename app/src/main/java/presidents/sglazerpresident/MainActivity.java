package presidents.sglazerpresident;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;


import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recylerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LinearLayoutManager layoutManager= new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recylerView= (RecyclerView) findViewById(R.id.list);
        recylerView.setLayoutManager(layoutManager);
        InputStream in=getResources().openRawResource(R.raw.presidents);
        Gson gson= new Gson();
        President presidents []= gson.fromJson(new InputStreamReader(in), President[].class);
        PresidentAdapter adapter= new PresidentAdapter(presidents);
        recylerView.setAdapter(adapter);

    }
}
