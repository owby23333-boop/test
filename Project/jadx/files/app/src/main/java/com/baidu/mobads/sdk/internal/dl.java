package com.baidu.mobads.sdk.internal;

import android.app.Activity;
import android.content.Context;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class dl {
    private Boolean a;

    public dl(Context context, Activity activity, Boolean bool) {
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
        return null;
    }
}
