package list.view.custom.base.adapter;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;

public class ListViewActivity extends AppCompatActivity {

    private Context context = ListViewActivity.this;
    private ListView listView;
    private ArrayList<ItemModel> itemModelArrayList;
    private CustomBaseAdapter customBaseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        initView();
        initObject();
        generateItemsList();
    }

    private void initView()
    {
        listView=findViewById(R.id.list_view);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                Toast toast = Toast.makeText(getApplicationContext(), "Item " + (position + 1) + ": " + itemModelArrayList.get(position).title, Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL, 0, 0);
                toast.show();
            }
        });
    }

    private void initObject()
    {
        itemModelArrayList = new ArrayList<>();
    }

    private void generateItemsList()
    {
        itemModelArrayList.add(new ItemModel("Guava","Guava Description",R.drawable.guava));
        itemModelArrayList.add(new ItemModel("Jack Fruit","Jack Fruit Description",R.drawable.jackfruit));
        itemModelArrayList.add(new ItemModel("Mix Fruit","Mix Fruit Description",R.drawable.mix_fruit));
        itemModelArrayList.add(new ItemModel("Pizza","Pizza Description",R.drawable.pizza));
        itemModelArrayList.add(new ItemModel("Pome Granate","Pome Granate Description",R.drawable.pomegranate));
        itemModelArrayList.add(new ItemModel("Straw Berry","Straw Berry Description",R.drawable.strawberry));
        itemModelArrayList.add(new ItemModel("Zespri Kiwi","Zespri Kiwi Description",R.drawable.zespri_kiwi));
        customBaseAdapter = new CustomBaseAdapter(context, itemModelArrayList);
        listView.setAdapter(customBaseAdapter);
    }
}
