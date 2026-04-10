package com.anythink.core.b;

import com.anythink.core.common.l;
import com.bytedance.msdk.adapter.pangle.PangleAdapterUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class j implements Comparable<j> {
    int a;
    String b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    double f6568c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    String f6569d;

    private double a() {
        return this.f6568c;
    }

    private String b() {
        return this.b;
    }

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(j jVar) {
        return this.a < jVar.a ? -1 : 1;
    }

    private void a(double d2) {
        this.f6568c = d2;
    }

    public static j a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            j jVar = new j();
            jVar.a = jSONObject.optInt("prority");
            jVar.b = jSONObject.optString("ad_source_id");
            if (jSONObject.has(l.am)) {
                jVar.f6568c = jSONObject.optDouble(l.am);
            } else if (jSONObject.has("price")) {
                jVar.f6568c = jSONObject.optDouble("price");
            } else {
                jVar.f6568c = PangleAdapterUtils.CPM_DEFLAUT_VALUE;
            }
            jVar.f6569d = jSONObject.optString("tp_bid_id");
            return jVar;
        } catch (Throwable unused) {
            return null;
        }
    }

    private int a(j jVar) {
        return this.a < jVar.a ? -1 : 1;
    }
}
