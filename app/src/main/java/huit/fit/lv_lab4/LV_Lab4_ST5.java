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

public class LV_Lab4_ST5 extends AppCompatActivity {

    EditText edtTen;
    Button btnThemTen;
    TextView tvKq;
    ListView lvTen;
    ListView lvNation;
    //------------------------------
    ArrayList<String>dsHten= new ArrayList<>();
    ArrayAdapter adapter;
    //------------------------
    ArrayList<Nation> listNation = new ArrayList<>();
    CustomAdapterNation customAdapterNation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lv_lab4_st5);
        addControl();
        //------------------
        //1. Gắn dữ liệu và hiển thị trên LV
        dsHten.addAll(Arrays.asList(new String[]{"Lan", "Hung", "Minh", "An"}));
        dsHten.add("Vu");
        adapter=new ArrayAdapter(LV_Lab4_ST5.this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,dsHten);
        lvTen.setAdapter(adapter);
        //---------------------
        //Hiển thị CustomLV
        listNation.add(new Nation(R.drawable.lao,"Lào"));
        listNation.add(new Nation(R.drawable.france,"Pháp"));
        listNation.add(new Nation(R.drawable.italy,"Ý"));
        customAdapterNation=new CustomAdapterNation(LV_Lab4_ST5.this,R.layout.layout_item_nation,listNation);
        lvNation.setAdapter(customAdapterNation);
        //--------------------
       addEvent();

    }

    void addControl()
    {
        edtTen=(EditText) findViewById(R.id.edtHten);
        btnThemTen=(Button) findViewById(R.id.btnThemHten);
        tvKq = (TextView) findViewById(R.id.tvHten);
        lvTen=(ListView) findViewById(R.id.lvHienThiTen);
        lvNation=(ListView) findViewById(R.id.lvNation);

    }
    void addEvent()
    {
        //2.Chọn 1 item của LV
        lvTen.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String st = dsHten.get(position);
                tvKq.setText(st);
            }
        });
        //3. Thêm 1 phần tử vào LV
        btnThemTen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String st = edtTen.getText().toString();
                if(!st.isEmpty())
                {
                    dsHten.add(st);
                    adapter.notifyDataSetChanged();
                }
            }
        });
        //4. Xóa item trên LV
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
        AlertDialog.Builder builder = new AlertDialog.Builder(LV_Lab4_ST5.this);
        builder.setTitle("Delete item!");
        builder.setMessage("Do you want to delete this item?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dsHten.remove(position);
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