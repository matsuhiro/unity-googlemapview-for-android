package jp.unitygames.googlemapview;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.OverlayItem;

public class PinOverlayItem extends OverlayItem {

	public PinOverlayItem(GeoPoint point) {
		super(point, "", "");
	}
}