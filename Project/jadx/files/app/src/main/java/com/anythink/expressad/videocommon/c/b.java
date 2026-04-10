package com.anythink.expressad.videocommon.c;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class b {
    private int a;
    private int b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private a f12204c;

    public b(int i2, int i3, a aVar) {
        this.a = i2;
        this.b = i3;
        this.f12204c = aVar;
    }

    private a c() {
        return this.f12204c;
    }

    public final int a() {
        return this.a;
    }

    public final int b() {
        return this.b;
    }

    private void a(int i2) {
        this.a = i2;
    }

    private void b(int i2) {
        this.b = i2;
    }

    private void a(a aVar) {
        this.f12204c = aVar;
    }

    public static List<b> a(JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() > 0) {
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                try {
                    JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i2);
                    int iOptInt = jSONObjectOptJSONObject.optInt("id");
                    int iOptInt2 = jSONObjectOptJSONObject.optInt("timeout");
                    JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("params");
                    arrayList.add(new b(iOptInt, iOptInt2, jSONObjectOptJSONObject2 != null ? a.a(jSONObjectOptJSONObject2) : null));
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            return arrayList;
        }
        return null;
    }
}
