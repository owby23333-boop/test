package com.bytedance.sdk.component.v.bf;

import android.text.TextUtils;
import com.bytedance.sdk.component.bf.e.bh;
import com.bytedance.sdk.component.bf.e.wu;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public abstract class d {
    protected wu d;
    private Map<String, Object> e;
    protected String tg = null;
    protected final Map<String, String> ga = new HashMap();
    protected String vn = null;

    public d(wu wuVar) {
        this.d = wuVar;
        bf(UUID.randomUUID().toString());
    }

    public void bf(String str, String str2) {
        this.ga.put(str, str2);
    }

    public Map<String, Object> d() {
        return this.e;
    }

    public abstract com.bytedance.sdk.component.v.bf e();

    public abstract void e(com.bytedance.sdk.component.v.e.e eVar);

    public void e(String str) {
        this.vn = str;
    }

    public void ga(Map<String, Object> map) {
        this.e = map;
    }

    public void tg(Map<String, String> map) {
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                this.ga.put(entry.getKey(), entry.getValue());
            }
        }
    }

    public void bf(String str) {
        this.tg = str;
    }

    public void e(bh.e eVar) {
        if (eVar != null && this.ga.size() > 0) {
            for (Map.Entry<String, String> entry : this.ga.entrySet()) {
                String key = entry.getKey();
                if (!TextUtils.isEmpty(key)) {
                    String value = entry.getValue();
                    if (value == null) {
                        value = "";
                    }
                    eVar.bf(key, value);
                }
            }
        }
    }

    public String bf() {
        return this.tg;
    }
}
