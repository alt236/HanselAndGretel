package com.jakewharton.hanselandgretel.sample;

import android.content.Context;
import android.content.Intent;

public class IntentListItem {
	private final String mLabel;
	private final Intent mIntent;
	private final int mDrawable;
	private final int mLabelResource;

	public IntentListItem (String label, int drawable, Intent intent){
		mLabel = label;
		mDrawable = drawable;
		mIntent = intent;
		mLabelResource = 0;
	}

	public IntentListItem (int stringResId, int drawable, Intent intent){
		mLabel = null;
		mDrawable = drawable;
		mIntent = intent;
		mLabelResource = stringResId;
	}

	public String getLabel(Context context) {
		if(mLabelResource > 0){
			return context.getString(mLabelResource);
		} else {
			return mLabel;
		}
	}

	public Intent getIntent() {
		return mIntent;
	}

	public Integer getDrawable() {
		return mDrawable;
	}
}
