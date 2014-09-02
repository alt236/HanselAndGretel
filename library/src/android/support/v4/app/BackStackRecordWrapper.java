package android.support.v4.app;


public class BackStackRecordWrapper implements BackStackEntryWithIcon{
	private int mIconRes;
	private final BackStackRecord mRecord;

	public BackStackRecordWrapper(final BackStackRecord record){
		mRecord = record;
	}

	public BackStackRecord getBackStackRecord(){
		return mRecord;
	}

	@Override
	public CharSequence getBreadCrumbShortTitle() {
		return mRecord.getBreadCrumbShortTitle();
	}

	@Override
	public int getBreadCrumbShortTitleRes() {
		return mRecord.getBreadCrumbShortTitleRes();
	}

	@Override
	public CharSequence getBreadCrumbTitle() {
		return mRecord.getBreadCrumbTitle();
	}

	@Override
	public int getBreadCrumbTitleRes() {
		return mRecord.getBreadCrumbTitleRes();
	}

	@Override
	public int getIconResId() {
		return mIconRes;
	}

	@Override
	public int getId() {
		return mRecord.getId();
	}

	@Override
	public String getName() {
		return mRecord.getName();
	}

	public void setIconRes(int drawableRes) {
		mIconRes = drawableRes;
	}

}
