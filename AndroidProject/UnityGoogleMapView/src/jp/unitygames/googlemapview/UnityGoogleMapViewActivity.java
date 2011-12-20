package jp.unitygames.googlemapview;

import android.app.ActivityGroup;
import android.app.LocalActivityManager;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.widget.FrameLayout;

public class UnityGoogleMapViewActivity extends ActivityGroup {
	/** Called when the activity is first created. */
	private LocalActivityManager lam;

	private MapViewActivity mMapViewActivity;
	private UnityViewActivity mUnityViewActivity;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.main);

		lam = getLocalActivityManager();
		//先にUnityViewActivityを追加する。逆だとGoogleMap表示されず。
		{
			Intent intent = new Intent(this, UnityViewActivity.class);
			Window window = lam.startActivity("10001", intent);
			FrameLayout l2 = (FrameLayout) findViewById(R.id.l2);
			l2.addView(window.getDecorView());

			mUnityViewActivity = (UnityViewActivity) lam.getActivity("10001");
		}
		{
			Intent intent = new Intent(this, MapViewActivity.class);
			Window window = lam.startActivity("10000", intent);
			Log.d("Unity", "" + window.getClass());
			FrameLayout l1 = (FrameLayout) findViewById(R.id.l1);
			l1.addView(window.getDecorView());

			mMapViewActivity = (MapViewActivity) lam.getActivity("10000");

		}
		mUnityViewActivity.setmMapViewActivity(mMapViewActivity);
	}

	@Override
	protected void onResume() {
		super.onResume();
	}
}