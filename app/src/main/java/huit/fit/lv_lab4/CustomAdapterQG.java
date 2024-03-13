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

public class CustomAdapterQG extends ArrayAdapter {
    Context context;
    int layoutItem;
    ArrayList<QG> dsQG=new ArrayList<>();


    public CustomAdapterQG(@NonNull Context context, int layoutItem, @NonNull ArrayList<QG> dsQG) {
        super(context, layoutItem, dsQG);
        this.context=context;
        this.layoutItem=layoutItem;
        this.dsQG = dsQG;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        QG qg = dsQG.get(position);
        if(convertView==null)
        {
            convertView= LayoutInflater.from(context).inflate(layoutItem,null);
        }
        ImageView imgFlag = (ImageView) convertView.findViewById(R.id.imgAnhCo);
        imgFlag.setImageResource(qg.getImgAnh());

        TextView tvQG = (TextView) convertView.findViewById(R.id.tvTenQG);
        tvQG.setText(qg.getTenQG());

        return convertView;

    }
}
