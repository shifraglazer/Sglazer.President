package presidents.sglazerpresident;

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

    public PresidentPagerAdapter( President [] presidents){
        this.presidents=presidents;
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
        life.setText("President's life: "+president.getBirth_year()+ "-"+ president.getDeath_year());
        office.setText("Years in office: "+president.getTook_office().substring(0,4)+ "-"+ president.getLeft_office().substring(0,4));
        party.setText(president.getParty());

        Picasso.with(view.getContext()).load("http://images.tutorcircle.com/cms/images/83/projectile-motion111.PNG").into(picture);
        container.addView(view);
        return view;
    }
}
