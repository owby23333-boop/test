package com.bytedance.sdk.openadsdk.core.iq;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<na> f1207a = new ArrayList();
    private String dl;
    private int g;
    private JSONObject gc;
    private long m;
    private String z;

    public void z(String str) {
        this.z = str;
    }

    public int z() {
        return this.g;
    }

    public void z(int i) {
        this.g = i;
    }

    public void g(String str) {
        this.dl = str;
    }

    public List<na> g() {
        return this.f1207a;
    }

    public void z(na naVar) {
        this.f1207a.add(naVar);
    }

    public void z(List<na> list) {
        this.f1207a = list;
    }

    public JSONObject dl() {
        return this.gc;
    }

    public void z(JSONObject jSONObject) {
        this.gc = jSONObject;
    }

    public void z(long j) {
        this.m = j;
    }
}
