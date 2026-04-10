package com.yuewen;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class wz0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f19743a;

    public wz0(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.f19743a = jSONObject.optInt("titlePageStyle", 1);
        } else {
            this.f19743a = 1;
        }
    }
}
