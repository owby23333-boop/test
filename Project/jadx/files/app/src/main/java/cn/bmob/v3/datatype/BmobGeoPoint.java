package cn.bmob.v3.datatype;

import com.bytedance.msdk.adapter.pangle.PangleAdapterUtils;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class BmobGeoPoint implements Serializable {
    public static double EARTH_MEAN_RADIUS_KM = 6371.0d;
    public static double EARTH_MEAN_RADIUS_MILE = 3958.8d;
    private static final long serialVersionUID = -2527515194340586771L;
    private String __type;
    private Double latitude;
    private Double longitude;

    public BmobGeoPoint() {
        Double dValueOf = Double.valueOf(PangleAdapterUtils.CPM_DEFLAUT_VALUE);
        this.latitude = dValueOf;
        this.longitude = dValueOf;
        this.__type = "GeoPoint";
    }

    private String get__type() {
        return this.__type;
    }

    public double distanceInKilometersTo(BmobGeoPoint bmobGeoPoint) {
        return distanceInRadiansTo(bmobGeoPoint) * EARTH_MEAN_RADIUS_KM;
    }

    public double distanceInMilesTo(BmobGeoPoint bmobGeoPoint) {
        return distanceInRadiansTo(bmobGeoPoint) * EARTH_MEAN_RADIUS_MILE;
    }

    public double distanceInRadiansTo(BmobGeoPoint bmobGeoPoint) {
        double dDoubleValue = this.latitude.doubleValue() * 0.0174532925199433d;
        double dDoubleValue2 = this.longitude.doubleValue() * 0.0174532925199433d;
        double latitude = bmobGeoPoint.getLatitude() * 0.0174532925199433d;
        double longitude = dDoubleValue2 - (bmobGeoPoint.getLongitude() * 0.0174532925199433d);
        double dSin = Math.sin((dDoubleValue - latitude) / 2.0d);
        double dSin2 = Math.sin(longitude / 2.0d);
        return Math.asin(Math.sqrt(Math.min(1.0d, (dSin * dSin) + (Math.cos(dDoubleValue) * Math.cos(latitude) * dSin2 * dSin2)))) * 2.0d;
    }

    public double getLatitude() {
        return this.latitude.doubleValue();
    }

    public double getLongitude() {
        return this.longitude.doubleValue();
    }

    public void setLatitude(double d2) {
        if (d2 > 90.0d || d2 < -90.0d) {
            throw new IllegalArgumentException("Latitude must be within the range (-90.0, 90.0).");
        }
        this.latitude = Double.valueOf(d2);
    }

    public void setLongitude(double d2) {
        if (d2 > 180.0d || d2 < -180.0d) {
            throw new IllegalArgumentException("Longitude must be within the range (-180.0, 180.0).");
        }
        this.longitude = Double.valueOf(d2);
    }

    public BmobGeoPoint(double d2, double d3) {
        Double dValueOf = Double.valueOf(PangleAdapterUtils.CPM_DEFLAUT_VALUE);
        this.latitude = dValueOf;
        this.longitude = dValueOf;
        this.__type = "GeoPoint";
        setLongitude(d2);
        setLatitude(d3);
        this.latitude = Double.valueOf(d3);
        this.longitude = Double.valueOf(d2);
    }
}
