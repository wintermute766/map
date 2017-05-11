package ru.sberbank.learning.samplemap;

import java.io.Serializable;

/**
 * @author Дмитрий Соколов <DPSokolov.SBT@sberbank.ru>
 */

public class Address implements Serializable {

    private String mAddress;
    private double mLatitude = Double.NaN;
    private double mLongitude = Double.NaN;

    public String getAddress() {
        return mAddress;
    }

    public void setAddress(String address) {
        mAddress = address;
    }

    public double getLatitude() {
        return mLatitude;
    }

    public void setLatitude(double latitude) {
        mLatitude = latitude;
    }

    public double getLongitude() {
        return mLongitude;
    }

    public void setLongitude(double longitude) {
        mLongitude = longitude;
    }

    public boolean hasGeo() {
        return !Double.isNaN(mLatitude) && !Double.isNaN(mLongitude);
    }
}
