package com.bytedance.embedapplog;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class sf implements dl {
    private static volatile sf z;
    private final CopyOnWriteArraySet<dl> g = new CopyOnWriteArraySet<>();

    public static sf z() {
        if (z == null) {
            synchronized (sf.class) {
                if (z == null) {
                    z = new sf();
                }
            }
        }
        return z;
    }

    private sf() {
    }

    @Override // com.bytedance.embedapplog.dl
    public void z(String str, String str2, String str3) {
        Iterator<dl> it = this.g.iterator();
        while (it.hasNext()) {
            it.next().z(str, str2, str3);
        }
    }

    @Override // com.bytedance.embedapplog.dl
    public void z(boolean z2, String str, String str2, String str3, String str4, String str5, String str6) {
        Iterator<dl> it = this.g.iterator();
        while (it.hasNext()) {
            it.next().z(z2, str, str2, str3, str4, str5, str6);
        }
    }

    @Override // com.bytedance.embedapplog.dl
    public void z(boolean z2, JSONObject jSONObject) {
        Iterator<dl> it = this.g.iterator();
        while (it.hasNext()) {
            it.next().z(z2, jSONObject);
        }
    }

    @Override // com.bytedance.embedapplog.dl
    public void g(boolean z2, JSONObject jSONObject) {
        Iterator<dl> it = this.g.iterator();
        while (it.hasNext()) {
            it.next().g(z2, jSONObject);
        }
    }
}
