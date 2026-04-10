package com.bytedance.sdk.component.fo.g;

import android.text.TextUtils;
import com.bytedance.sdk.component.g.z.v;
import com.bytedance.sdk.component.g.z.wp;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {
    protected wp dl;
    private Object g;
    private Map<String, Object> z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected String f710a = null;
    protected final Map<String, String> gc = new HashMap();
    protected String m = null;
    protected boolean e = false;

    public abstract com.bytedance.sdk.component.fo.g z();

    public a(wp wpVar) {
        this.dl = wpVar;
        g(UUID.randomUUID().toString());
    }

    public void z(String str) {
        this.m = str;
    }

    public void g(String str, String str2) {
        this.gc.put(str, str2);
    }

    public void a(Map<String, String> map) {
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                this.gc.put(entry.getKey(), entry.getValue());
            }
        }
    }

    public void g(String str) {
        this.f710a = str;
    }

    public String g() {
        return this.f710a;
    }

    public Map<String, Object> dl() {
        return this.z;
    }

    public void gc(Map<String, Object> map) {
        this.z = map;
    }

    public Object a() {
        return this.g;
    }

    protected void z(v.z zVar) {
        if (zVar != null && this.gc.size() > 0) {
            for (Map.Entry<String, String> entry : this.gc.entrySet()) {
                String key = entry.getKey();
                if (!TextUtils.isEmpty(key)) {
                    String value = entry.getValue();
                    if (value == null) {
                        value = "";
                    }
                    zVar.g(key, value);
                }
            }
        }
    }

    public void z(boolean z) {
        this.e = z;
    }
}
