package com.alibaba.sdk.android.utils;

import android.text.TextUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class SdkInfo {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    String f2240c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    String f2241d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    String f2242e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    Map<String, String> f2243f;

    String b() {
        if (TextUtils.isEmpty(this.f2240c) || TextUtils.isEmpty(this.f2241d)) {
            return null;
        }
        return this.f2240c + "_" + this.f2241d;
    }

    public SdkInfo setAppKey(String str) {
        this.f2242e = str;
        return this;
    }

    public SdkInfo setExt(Map<String, String> map) {
        this.f2243f = map;
        return this;
    }

    public SdkInfo setSdkId(String str) {
        this.f2240c = str;
        return this;
    }

    public SdkInfo setSdkVersion(String str) {
        this.f2241d = str;
        return this;
    }
}
