package jp.unitygames.google.mapview;

import java.util.ArrayList;
import java.util.List;

import android.graphics.drawable.Drawable;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.ItemizedOverlay;

public class PinItemizedOverlay extends ItemizedOverlay<PinOverlayItem> {

	private List<GeoPoint> points = new ArrayList<GeoPoint>();

	public PinItemizedOverlay(Drawable defaultMarker) {
		super(boundCenterBottom(defaultMarker));
	}

	@Override
	protected PinOverlayItem createItem(int i) {
		GeoPoint point = points.get(i);
		return new PinOverlayItem(point);
	}

	public boolean contain(GeoPoint geo) {
		return points.contains(geo);
	}

	@Override
	public int size() {
		return points.size();
	}

	public void addPoint(GeoPoint point) {
		this.points.add(point);
		populate();
	}

	public void clearPoint() {
		this.points.clear();
		populate();
	}
}