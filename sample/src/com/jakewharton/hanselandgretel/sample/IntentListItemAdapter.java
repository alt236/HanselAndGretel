package com.jakewharton.hanselandgretel.sample;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class IntentListItemAdapter extends BaseAdapter{
	private final List<IntentListItem> mItems;
	private final Context mContext;
	private final int mLayout;

	public IntentListItemAdapter(Context context, List<IntentListItem> items){
		mContext = context;
		mItems = items;
		mLayout = R.layout.list_item_icon_text;
	}

	@Override
	public int getCount() {
		return mItems.size();
	}

	@Override
	public Object getItem(int position) {
		return mItems.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		final View v;
		final ImageView i;
		final TextView t;

		final IntentListItem item = mItems.get(position);

		if (convertView == null) {
			v = ((Activity) mContext).getLayoutInflater().inflate(mLayout, null);
		} else {
			v = convertView;
		}

		i = (ImageView) v.findViewById(R.id.icon);
		t = (TextView) v.findViewById(android.R.id.text1);

		t.setText(item.getLabel(mContext));

		if(item.getDrawable() == null){
			i.setVisibility(View.INVISIBLE);
		} else {
			i.setVisibility(View.VISIBLE);
			i.setImageResource(item.getDrawable());
		}

		v.setTag(item);
		return v;
	}
}
