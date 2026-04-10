package com.baidu.mobads.sdk.internal;

import android.app.Activity;
import android.content.Context;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class dj {
    private Boolean a;

    public dj(Context context, Activity activity, Boolean bool) {
        this.a = bool;
        a().booleanValue();
    }

    public Boolean a() {
        return this.a;
    }

    protected HashMap<String, String> b() {
        HashMap<String, String> map = new HashMap<>();
        map.put("xyz", "hihihi");
        return map;
    }

    public String c() {
        return "http://211.151.146.65:8080/wlantest/shanghai_sun/mock_ad_server_intersitial_video.json";
    }
}
