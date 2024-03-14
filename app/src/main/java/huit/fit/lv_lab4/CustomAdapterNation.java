package huit.fit.lv_lab4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapterNation extends ArrayAdapter {
    Context context;
    int layoutItem;
    ArrayList<Nation>listNation=new ArrayList<>();


    public CustomAdapterNation(@NonNull Context context, int layoutItem, @NonNull ArrayList<Nation>listNation) {
        super(context, layoutItem, listNation);
        this.context=context;
        this.layoutItem=layoutItem;
        this.listNation=listNation;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Nation nation = listNation.get(position);
        if(convertView==null)
        {
            convertView= LayoutInflater.from(context).inflate(layoutItem,null);
        }
        ImageView imgAnh = (ImageView) convertView.findViewById(R.id.imgNation);
        imgAnh.setImageResource(nation.getIdAnh());

        TextView nationName = (TextView) convertView.findViewById(R.id.tvNation);
        nationName.setText(nation.getNationName());

        return convertView;
    }
}
