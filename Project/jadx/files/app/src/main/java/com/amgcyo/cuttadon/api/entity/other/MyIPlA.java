package com.amgcyo.cuttadon.api.entity.other;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class MyIPlA implements Serializable {
    private String ip;
    private LocationBean location;

    public static class LocationBean implements Serializable {
        private String city;
        private String country_code;
        private String country_name;
        private String latitude;
        private String longitude;
        private String province;

        public String getCity() {
            return this.city;
        }

        public String getCountry_code() {
            return this.country_code;
        }

        public String getCountry_name() {
            return this.country_name;
        }

        public String getLatitude() {
            return this.latitude;
        }

        public String getLongitude() {
            return this.longitude;
        }

        public String getProvince() {
            return this.province;
        }

        public void setCity(String str) {
            this.city = str;
        }

        public void setCountry_code(String str) {
            this.country_code = str;
        }

        public void setCountry_name(String str) {
            this.country_name = str;
        }

        public void setLatitude(String str) {
            this.latitude = str;
        }

        public void setLongitude(String str) {
            this.longitude = str;
        }

        public void setProvince(String str) {
            this.province = str;
        }

        public String toString() {
            return "LocationBean{city='" + this.city + "', country_code='" + this.country_code + "', country_name='" + this.country_name + "', latitude='" + this.latitude + "', longitude='" + this.longitude + "', province='" + this.province + "'}";
        }
    }

    public String getIp() {
        return this.ip;
    }

    public LocationBean getLocation() {
        return this.location;
    }

    public void setIp(String str) {
        this.ip = str;
    }

    public void setLocation(LocationBean locationBean) {
        this.location = locationBean;
    }
}
