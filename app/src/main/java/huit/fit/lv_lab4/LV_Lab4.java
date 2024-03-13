package huit.fit.lv_lab4;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class LV_Lab4 extends AppCompatActivity {

    EditText edtTen;
    Button btnThemTen;
    TextView tvKq;
    ListView lvTen;
    ListView lvTenQG;
    //---------------------
    ArrayList<String> dsTen = new ArrayList<>();
    ArrayAdapter adapter;
    //----------------
    ArrayList<QG> dsQG = new ArrayList<>();
    CustomAdapterQG adapterQG;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lv_lab4);
        addControl();

        //---------------------------
        //1. gắn dữ liệu và hiển thị lên LV
      dsTen.addAll(Arrays.asList(new String[]{"Lan", "Hoa", "hung", "Phúc","ha", "Lan","Minh"}));
      dsTen.add("Binh");
      adapter  =new ArrayAdapter(LV_Lab4.this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,dsTen);
      lvTen.setAdapter(adapter);
      //-----------------------------
        dsQG.add(new QG(R.drawable.france,"Pháp"));
        dsQG.add(new QG(R.drawable.italy,"Ý"));
        dsQG.add(new QG(R.drawable.lao,"Lào"));

        adapterQG = new CustomAdapterQG(LV_Lab4.this,R.layout.layout_item_qgia,dsQG);
        lvTenQG.setAdapter(adapterQG);
      //------------------
        addEvent();

    }

    void addControl()
    {
        edtTen=(EditText) findViewById(R.id.edtTen);
        btnThemTen=(Button) findViewById(R.id.btnThemTen);
        tvKq = (TextView) findViewById(R.id.tvKq);
        lvTen=(ListView) findViewById(R.id.lvHoTen);
        lvTenQG =(ListView) findViewById(R.id.lvQG);

    }
    void addEvent()
    {
        //2. CHọn 1 item của LV
        lvTen.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                tvKq.setText(dsTen.get(position));
            }
        });
        //3. Thêm 1 item của LV
        btnThemTen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String st = edtTen.getText().toString();
                if(!st.isEmpty())
                {
                    dsTen.add(st);
                    adapter.notifyDataSetChanged();
                }
            }
        });
        //4. Xoa item
        lvTen.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog alertDialog = createAlertDialog(position, adapter);
                alertDialog.show();
                return false;
            }
        });
    }

    private AlertDialog createAlertDialog (int position,ArrayAdapter adapter )
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(LV_Lab4.this);
        builder.setTitle("Delete item!");
        builder.setMessage("Do you want to delete this item?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dsTen.remove(position);
                adapter.notifyDataSetChanged();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        return builder.create();
    }
}