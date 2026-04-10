package com.sntech.cc.data;

import com.bytedance.pangle.provider.ContentProviderManager;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;

/* JADX INFO: loaded from: classes3.dex */
public class BroadCastItemInfo {

    @SerializedName("ad_platform")
    @Expose
    private String ad_platform;

    @SerializedName("class_name")
    @Expose
    private String class_name;

    @SerializedName("data_dir")
    @Expose
    private String data_dir;

    @SerializedName("device_protected_data_dir")
    @Expose
    private String device_protected_data_dir;

    @SerializedName("first_install_time")
    @Expose
    private long first_install_time;

    @SerializedName("last_update_time")
    @Expose
    private long last_update_time;

    @SerializedName("native_library_dir")
    @Expose
    private String native_library_dir;

    @SerializedName("package_info_origin")
    @Expose
    private String package_info_origin;

    @SerializedName("package_name")
    @Expose
    private String package_name;

    @SerializedName(ContentProviderManager.PLUGIN_PROCESS_NAME)
    @Expose
    private String process_name;

    @SerializedName("public_source_dir")
    @Expose
    private String public_source_dir;

    @SerializedName("source_dir")
    @Expose
    private String source_dir;

    @SerializedName("uid")
    @Expose
    private int uid;

    @SerializedName("version_code")
    @Expose
    private int version_code;

    @SerializedName(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME)
    @Expose
    private String version_name;

    public String getAd_platform() {
        return this.ad_platform;
    }

    public String getClass_name() {
        return this.class_name;
    }

    public String getData_dir() {
        return this.data_dir;
    }

    public String getDevice_protected_data_dir() {
        return this.device_protected_data_dir;
    }

    public long getFirst_install_time() {
        return this.first_install_time;
    }

    public long getLast_update_time() {
        return this.last_update_time;
    }

    public String getNative_library_dir() {
        return this.native_library_dir;
    }

    public String getPackage_info_origin() {
        return this.package_info_origin;
    }

    public String getPackage_name() {
        return this.package_name;
    }

    public String getProcess_name() {
        return this.process_name;
    }

    public String getPublic_source_dir() {
        return this.public_source_dir;
    }

    public String getSource_dir() {
        return this.source_dir;
    }

    public int getUid() {
        return this.uid;
    }

    public int getVersion_code() {
        return this.version_code;
    }

    public String getVersion_name() {
        return this.version_name;
    }

    public void setAd_platform(String str) {
        this.ad_platform = str;
    }

    public void setClass_name(String str) {
        this.class_name = str;
    }

    public void setData_dir(String str) {
        this.data_dir = str;
    }

    public void setDevice_protected_data_dir(String str) {
        this.device_protected_data_dir = str;
    }

    public void setFirst_install_time(long j2) {
        this.first_install_time = j2;
    }

    public void setLast_update_time(long j2) {
        this.last_update_time = j2;
    }

    public void setNative_library_dir(String str) {
        this.native_library_dir = str;
    }

    public void setPackage_info_origin(String str) {
        this.package_info_origin = str;
    }

    public void setPackage_name(String str) {
        this.package_name = str;
    }

    public void setProcess_name(String str) {
        this.process_name = str;
    }

    public void setPublic_source_dir(String str) {
        this.public_source_dir = str;
    }

    public void setSource_dir(String str) {
        this.source_dir = str;
    }

    public void setUid(int i2) {
        this.uid = i2;
    }

    public void setVersion_code(int i2) {
        this.version_code = i2;
    }

    public void setVersion_name(String str) {
        this.version_name = str;
    }
}
