package com.sntech.cc.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes3.dex */
public class PackageFileInfo {

    @SerializedName("lastModified")
    @Expose
    public long lastModified;

    @SerializedName("packageName")
    @Expose
    public String packageName;
}
