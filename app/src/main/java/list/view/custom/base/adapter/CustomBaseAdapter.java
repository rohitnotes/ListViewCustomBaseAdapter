package list.view.custom.base.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

public class CustomBaseAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<ItemModel> itemModelList;
    private LayoutInflater layoutInflater;

    public CustomBaseAdapter(Context context, ArrayList<ItemModel> itemModels) {
        this.context = context;
        this.itemModelList = itemModels;
        layoutInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return (null != itemModelList ? itemModelList.size() : 0);
    }

    @Override
    public Object getItem(int position) {
        return (null != itemModelList ? itemModelList.get(position) : null);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ItemViewHolder itemViewHolder;

        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.list_item, parent, false);
              /*
            OR
            convertView = layoutInflater.inflate(R.layout.layout_list_item,null);
             */
            itemViewHolder = new ItemViewHolder(convertView);
            convertView.setTag(itemViewHolder);
        } else {
            itemViewHolder = (ItemViewHolder) convertView.getTag();
        }

        ItemModel rowItem = (ItemModel) getItem(position);
        ((ItemViewHolder) itemViewHolder).setData(rowItem);
        return convertView;
    }

    private class ItemViewHolder {
        TextView tvTitle, tvDesc;
        ImageView ivIcon;

        public ItemViewHolder(View item) {
            tvTitle = (TextView) item.findViewById(R.id.tvTitle);
            tvDesc = (TextView) item.findViewById(R.id.tvDesc);
            ivIcon = (ImageView) item.findViewById(R.id.ivIcon);
        }

        public void setData(ItemModel itemPosition) {
            tvTitle.setText(itemPosition.getTitle());
            tvDesc.setText(itemPosition.getDescription());
            ivIcon.setImageResource(itemPosition.getImgResId());
        }
    }
}
