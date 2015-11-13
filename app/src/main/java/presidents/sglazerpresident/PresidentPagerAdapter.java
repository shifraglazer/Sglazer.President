package presidents.sglazerpresident;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by student1 on 10/29/2015.
 */
public class PresidentPagerAdapter extends PagerAdapter {
    private President [] presidents;
    private Context context;

    public PresidentPagerAdapter( President [] presidents, Context context){
        this.presidents=presidents;
        this.context=context;
    }
    @Override
    public int getCount() {
        return presidents.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view== object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View)object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        LayoutInflater inflater= LayoutInflater.from(container.getContext());
        View view= inflater.inflate(R.layout.president_pager_item, null);
        TextView name= (TextView) view.findViewById(R.id.name);
        TextView number= (TextView) view.findViewById(R.id.number);
        TextView life= (TextView) view.findViewById(R.id.life);
        TextView office= (TextView) view.findViewById(R.id.office);
        TextView party= (TextView) view.findViewById(R.id.party);
        ImageView picture= (ImageView) view.findViewById(R.id.picture);

        President president= presidents[position];
        name.setText(president.getPresident());
        number.setText(String.valueOf(president.getNumber()));
        life.setText("Life: "+president.getBirth_year()+ "-"+ president.getDeath_year());
        office.setText("Office: "+president.getTook_office().substring(0,4)+ "-"+ president.getLeft_office().substring(0,4));
        party.setText(president.getParty());
        String url="https://cse.google.com/cse/setup/basic?cx=009527935933081976895:3rz_wfyhsvg:q?"+ "george";
        Picasso.with(context).load("https://upload.wikimedia.org/wikipedia/commons/thumb/6/61/Ideal_projectile_motion_for_different_angles.svg/350px-Ideal_projectile_motion_for_different_angles.svg.png").into(picture);
        container.addView(view);
        return view;
    }
}
