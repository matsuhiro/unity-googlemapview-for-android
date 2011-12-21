package jp.unitygames.google.mapview;

import android.os.Bundle;
import android.util.Log;

import com.unity3d.player.UnityPlayerActivity;

public class UnityViewActivity extends UnityPlayerActivity {

	private MapViewActivity mMapViewActivity;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	public void setLocation(float latitude, float longitude) {
		Log.d("Unity", "latitude = " + latitude + "/longitude=" + longitude);
		mMapViewActivity.setLocation(latitude, longitude);
	}
	public MapViewActivity getmMapViewActivity() {
		return mMapViewActivity;
	}

	public void setmMapViewActivity(MapViewActivity mMapViewActivity) {
		this.mMapViewActivity = mMapViewActivity;
	}

}