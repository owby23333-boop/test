package com.xiaomi.push;

import org.json.JSONArray;

/* JADX INFO: loaded from: classes8.dex */
public class bs extends JSONArray implements br {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f7834a = 2;

    @Override // com.xiaomi.push.br
    public int a() {
        return this.f7834a + (length() - 1);
    }

    @Override // org.json.JSONArray
    public JSONArray put(Object obj) {
        if (obj instanceof br) {
            this.f7834a += ((br) obj).a();
        }
        return super.put(obj);
    }
}
