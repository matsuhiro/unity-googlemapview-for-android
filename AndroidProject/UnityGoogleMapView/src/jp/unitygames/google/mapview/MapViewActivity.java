package jp.unitygames.google.mapview;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapView;

public class MapViewActivity extends MapActivity {

	private MapView mMapView;
	private Drawable pin;
	private PinItemizedOverlay pinOverlay;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.map);
		mMapView = (MapView) findViewById(R.id.map);
		mMapView.setClickable(true);
		mMapView.setEnabled(true);

	}

	@Override
	protected boolean isRouteDisplayed() {
		return false;
	}

	public void setLocation(float latitude, float longitude) {
		Log.d("Unity", "latitude = " + latitude + "/longitude=" + longitude);
		GeoPoint point = new GeoPoint(new Double(latitude * 1E6).intValue(),
				new Double(longitude * 1E6).intValue());
		mMapView.getController().animateTo(point);

		if (pinOverlay == null) {
			pin = getResources().getDrawable(R.drawable.pin_image);
			pinOverlay = new PinItemizedOverlay(pin);
			mMapView.getOverlays().add(pinOverlay);
		}
		if (!pinOverlay.contain(point))
			pinOverlay.addPoint(point);
	}

}
