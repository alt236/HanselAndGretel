package com.jakewharton.hanselandgretel.sample;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

public class ListSamples extends ListActivity {
	final List<IntentListItem> mIntentList = new ArrayList<IntentListItem>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent;

        intent = new Intent(this, SampleDefaultDark.class);
        mIntentList.add(new IntentListItem("Default (Dark)", 0, intent));

        intent = new Intent(this, SampleDefaultLight.class);
        mIntentList.add(new IntentListItem("Default (Light)", 0, intent));

        intent = new Intent(this, SampleStyled.class);
        mIntentList.add(new IntentListItem("Styled", 0, intent));

        intent = new Intent(this, SampleDefaultDark.class);
        intent.putExtra(Constants.EXTRA_USE_ICON_AS_HOME, true);
        mIntentList.add(new IntentListItem("Default (Dark) - With Icon", 0, intent));

        intent = new Intent(this, SampleDefaultLight.class);
        intent.putExtra(Constants.EXTRA_USE_ICON_AS_HOME, true);
        mIntentList.add(new IntentListItem("Default (Light) - With Icon", 0, intent));

        intent = new Intent(this, SampleStyled.class);
        intent.putExtra(Constants.EXTRA_USE_ICON_AS_HOME, true);
        mIntentList.add(new IntentListItem("Styled - With Icon", 0, intent));

        Collections.sort(mIntentList, new Comparator<IntentListItem>() {
			@Override
			public int compare(IntentListItem lhs, IntentListItem rhs) {
				return lhs.getLabel(ListSamples.this).compareTo(rhs.getLabel(ListSamples.this));
			}
		});

        setListAdapter(new IntentListItemAdapter(this, mIntentList));
        getListView().setTextFilterEnabled(true);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
    	final IntentListItem item = mIntentList.get(position);
    	startActivity(item.getIntent());
    }
}
