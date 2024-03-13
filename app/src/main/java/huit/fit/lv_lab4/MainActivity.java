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

public class MainActivity extends AppCompatActivity {

    EditText edtTen;
    Button btnThem;
    TextView tvKq;
    ListView lvTen;

    ArrayList<String> dsTen=new ArrayList<>();
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControl();
        //1. Gắn dữ liệu và hiển thị lên LV
        dsTen.addAll(Arrays.asList(new String[]{"Ngân", "Lan", "Lý", "Hoa"}));
        dsTen.add("Thanh");
        adapter=new ArrayAdapter<>(MainActivity.this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,dsTen);
        lvTen.setAdapter(adapter);
        //-------------
        addEvent();

    }

    void addControl()
    {
        edtTen=(EditText) findViewById(R.id.edtTen);
        btnThem=(Button) findViewById(R.id.btnThem);
        tvKq=(TextView) findViewById(R.id.tvKq);
        lvTen = (ListView) findViewById(R.id.lvTen);

    }
    void addEvent()
    {
        //2. Chọn 1 item của LV
        lvTen.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                tvKq.setText(dsTen.get(position));
            }
        });
        //3. Thêm 1 item
        btnThem.setOnClickListener(new View.OnClickListener() {
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
        //4. Xóa item được chọn
        lvTen.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog alertDialog=createAlertDialog(position,adapter);
                alertDialog.show();
                return false;
            }
        });



    }

    private AlertDialog createAlertDialog (int position, ArrayAdapter<String>adapter)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Delete item!");
        builder.setMessage("Are you sure you want to delete item?");
        //Xử lý nút Yes
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dsTen.remove(position);
                adapter.notifyDataSetChanged();// thông báo cho adapter là dữ liệu có thay đổi, cần update giao diện của LV
            }
        });
        //Xử lý nút No
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                dialog.cancel();
            }
        });
        return  builder.create();
    }
}