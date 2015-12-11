package presidents.sglazerpresident;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by student1 on 10/29/2015.
 */
public class DetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstantState){
        super.onCreate(savedInstantState);
        setContentView(R.layout.activity_detail);
        PresidentDetailFragment fragment= (PresidentDetailFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_president_detail);
       President [] presidents= (President []) getIntent().getSerializableExtra("PRESIDENTS");
        int position= getIntent().getIntExtra("POSITION", 0);
        fragment.showPresidentDetail(presidents,position);
    }
}
