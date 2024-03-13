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

public class CustomAdapterFlag extends ArrayAdapter {

    Context context;
    int layoutItem;
    ArrayList<Flag> lsFlags = new ArrayList<>();


    public CustomAdapterFlag(@NonNull Context context, int layoutItem, @NonNull ArrayList<Flag> lsFlags) {
        super(context, layoutItem, lsFlags);
         this.context=context;
         this.layoutItem = layoutItem;
         this.lsFlags=lsFlags;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Flag flag = lsFlags.get(position);
        if(convertView==null)
        {
            convertView= LayoutInflater.from(context).inflate(layoutItem,null);
        }
        ImageView imgFlag = (ImageView) convertView.findViewById(R.id.imagFlag);
        imgFlag.setImageResource(flag.getIdAnh());

        TextView tvQG = (TextView) convertView.findViewById(R.id.tvTenQG);
        tvQG.setText(flag.getTenQG());

        return convertView;
    }
}
