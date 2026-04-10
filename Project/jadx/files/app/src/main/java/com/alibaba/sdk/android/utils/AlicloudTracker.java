package com.alibaba.sdk.android.utils;

import android.text.TextUtils;
import com.taobao.accs.common.Constants;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class AlicloudTracker {
    private c a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f2237c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f2238d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    private Map<String, String> f47d = new HashMap();

    AlicloudTracker(c cVar, String str, String str2) {
        this.a = cVar;
        this.f2237c = str;
        this.f2238d = str2;
    }

    public void removeGlobalProperty(String str) {
        if (TextUtils.isEmpty(str) || !this.f47d.containsKey(str)) {
            return;
        }
        this.f47d.remove(str);
    }

    public void sendCustomHit(String str, long j2, Map<String, String> map) {
        try {
            if (this.a == null) {
                return;
            }
            if (map == null) {
                map = new HashMap<>();
            }
            map.putAll(this.f47d);
            map.put("sdkId", this.f2237c);
            map.put(Constants.KEY_SDK_VERSION, this.f2238d);
            this.a.sendCustomHit(this.f2237c + "_" + str, j2, map);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void setGlobalProperty(String str, String str2) {
        if (TextUtils.isEmpty(str) || str2 == null) {
            return;
        }
        if (this.f47d.containsKey(str)) {
            this.f47d.remove(str);
        }
        this.f47d.put(str, str2);
    }

    public void sendCustomHit(String str, Map<String, String> map) {
        sendCustomHit(str, 0L, map);
    }
}
