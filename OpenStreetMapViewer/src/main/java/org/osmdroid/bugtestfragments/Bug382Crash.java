package org.osmdroid.bugtestfragments;

import android.graphics.Color;

import org.osmdroid.R;
import org.osmdroid.api.IGeoPoint;
import org.osmdroid.samplefragments.BaseSampleFragment;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.overlay.Polygon;
import org.osmdroid.views.overlay.Polyline;
import org.osmdroid.views.overlay.infowindow.BasicInfoWindow;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alex on 8/25/16.
 */

public class Bug382Crash extends BaseSampleFragment {
    @Override
    public String getSampleTitle() {
        return "Bug 382 Crash while scrolling";
    }

    private Polygon polygon;
    private Polyline polyline;

    @Override
    protected void addOverlays() {
        super.addOverlays();
        List<GeoPoint> geoPoints = new ArrayList<>();
        geoPoints.add(new GeoPoint(47d, -74d));
        geoPoints.add(new GeoPoint(46d, -75d));
        geoPoints.add(new GeoPoint(47d, -76d));
        geoPoints.add(new GeoPoint(46d, -75d));
        geoPoints.add(new GeoPoint(44d, -73d));
        geoPoints.add(new GeoPoint(43d, -72d));


        polygon = new Polygon();
        polygon.setPoints(geoPoints.subList(0, 3));
        polygon.setFillColor(0x96FF8200);
        polygon.setStrokeColor(Color.RED);
        polygon.setStrokeWidth(4);
        polygon.setInfoWindow(new BasicInfoWindow(R.layout.bonuspack_bubble, mMapView));
        polygon.setTitle("Polygon tapped!");
        mMapView.getOverlays().add(polygon);
        mMapView.invalidate();

        polyline = new Polyline();
        polyline.setPoints(geoPoints.subList(3, 6));
        polyline.setColor(Color.YELLOW);
        polyline.setWidth(8);
        polyline.setInfoWindow(new BasicInfoWindow(R.layout.bonuspack_bubble, mMapView));
        polyline.setTitle("Polyline tapped!");
        mMapView.getOverlays().add(polyline);
        mMapView.invalidate();


    }
}
