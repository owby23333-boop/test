package com.bytedance.embedapplog;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class yf implements IDataObserver {
    private static volatile yf e;
    private final CopyOnWriteArraySet<IDataObserver> bf = new CopyOnWriteArraySet<>();

    private yf() {
    }

    public static yf e() {
        if (e == null) {
            synchronized (yf.class) {
                if (e == null) {
                    e = new yf();
                }
            }
        }
        return e;
    }

    @Override // com.bytedance.embedapplog.IDataObserver
    public void onIdLoaded(String str, String str2, String str3) {
        Iterator<IDataObserver> it = this.bf.iterator();
        while (it.hasNext()) {
            it.next().onIdLoaded(str, str2, str3);
        }
    }

    @Override // com.bytedance.embedapplog.IDataObserver
    public void onRemoteAbConfigGet(boolean z, JSONObject jSONObject) {
        Iterator<IDataObserver> it = this.bf.iterator();
        while (it.hasNext()) {
            it.next().onRemoteAbConfigGet(z, jSONObject);
        }
    }

    @Override // com.bytedance.embedapplog.IDataObserver
    public void onRemoteConfigGet(boolean z, JSONObject jSONObject) {
        Iterator<IDataObserver> it = this.bf.iterator();
        while (it.hasNext()) {
            it.next().onRemoteConfigGet(z, jSONObject);
        }
    }

    @Override // com.bytedance.embedapplog.IDataObserver
    public void onRemoteIdGet(boolean z, String str, String str2, String str3, String str4, String str5, String str6) {
        Iterator<IDataObserver> it = this.bf.iterator();
        while (it.hasNext()) {
            it.next().onRemoteIdGet(z, str, str2, str3, str4, str5, str6);
        }
    }
}
