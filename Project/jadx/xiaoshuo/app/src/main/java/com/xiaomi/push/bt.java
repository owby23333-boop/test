package com.xiaomi.push;

import android.text.TextUtils;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.LinkedHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public class bt extends JSONObject implements br {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f7835a = 2;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f7836b = 3;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final LinkedHashMap<String, Integer> f177a = new LinkedHashMap<>();

    @Override // com.xiaomi.push.br
    public int a() {
        int iIntValue = f7835a;
        Iterator<Integer> it = this.f177a.values().iterator();
        while (it.hasNext()) {
            iIntValue += it.next().intValue();
        }
        return iIntValue + (length() - 1);
    }

    @Override // org.json.JSONObject
    public JSONObject put(String str, int i) {
        if (!TextUtils.isEmpty(str)) {
            this.f177a.put(str, Integer.valueOf(str.length() + String.valueOf(i).length() + f7836b));
        }
        return super.put(str, i);
    }

    @Override // org.json.JSONObject
    public Object remove(String str) {
        this.f177a.remove(str);
        return super.remove(str);
    }

    @Override // org.json.JSONObject
    public JSONObject put(String str, long j) {
        if (!TextUtils.isEmpty(str)) {
            this.f177a.put(str, Integer.valueOf(str.length() + String.valueOf(j).length() + f7836b));
        }
        return super.put(str, j);
    }

    @Override // org.json.JSONObject
    public JSONObject put(String str, double d) {
        if (!TextUtils.isEmpty(str)) {
            this.f177a.put(str, Integer.valueOf(str.length() + String.valueOf(d).length() + f7836b));
        }
        return super.put(str, d);
    }

    @Override // org.json.JSONObject
    public JSONObject put(String str, Object obj) throws JSONException {
        JSONObject jSONObjectPut = super.put(str, obj);
        if (!TextUtils.isEmpty(str) && obj != null) {
            if (obj instanceof br) {
                this.f177a.put(str, Integer.valueOf(str.length() + ((br) obj).a() + f7836b));
            } else {
                this.f177a.put(str, Integer.valueOf(str.length() + String.valueOf(obj).getBytes(StandardCharsets.UTF_8).length + f7836b + f7835a));
            }
        }
        return jSONObjectPut;
    }

    @Override // org.json.JSONObject
    public JSONObject put(String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            this.f177a.put(str, Integer.valueOf(str.length() + String.valueOf(z).length() + f7836b));
        }
        return super.put(str, z);
    }
}
