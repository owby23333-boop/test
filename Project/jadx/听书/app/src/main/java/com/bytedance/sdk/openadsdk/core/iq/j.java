package com.bytedance.sdk.openadsdk.core.iq;

import android.os.Bundle;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1172a;
    public int dl;
    public long fo;
    public String g;
    public long kb;
    public Bundle pf;
    public long uy;
    private String ls = com.bytedance.sdk.openadsdk.core.un.eo.gz();
    public int z = -1;
    public JSONArray gc = null;
    public int m = 1;
    public long e = System.currentTimeMillis();
    public long gz = System.currentTimeMillis();
    public JSONObject wp = null;
    public int i = -1;
    public com.bytedance.sdk.openadsdk.core.uf v = com.bytedance.sdk.openadsdk.core.uf.z("");

    public j z() {
        j jVar = new j();
        jVar.z = this.z;
        jVar.gc = this.gc;
        jVar.m = this.m;
        jVar.e = this.e;
        jVar.fo = this.fo;
        jVar.uy = this.uy;
        jVar.kb = this.kb;
        jVar.i = this.i;
        return jVar;
    }

    public void z(String str) {
        this.ls = str;
    }

    public String g() {
        return this.ls;
    }

    public void z(String str, boolean z) {
        com.bytedance.sdk.openadsdk.core.uf ufVar;
        if (!z || (ufVar = this.v) == null || str == null) {
            return;
        }
        ufVar.g("cst_".concat(String.valueOf(str)));
    }

    public void z(String str, long j, boolean z) {
        com.bytedance.sdk.openadsdk.core.uf ufVar;
        if (!z || (ufVar = this.v) == null || str == null) {
            return;
        }
        ufVar.z("cst_".concat(String.valueOf(str)), j);
    }
}
