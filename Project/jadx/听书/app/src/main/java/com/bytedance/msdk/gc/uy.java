package com.bytedance.msdk.gc;

import android.content.Context;
import android.os.Looper;
import com.bytedance.msdk.gz.io;
import java.util.concurrent.Executor;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class uy implements com.bytedance.sdk.component.gz.z.a {
    @Override // com.bytedance.sdk.component.gz.z.a
    public boolean a() {
        return true;
    }

    @Override // com.bytedance.sdk.component.gz.z.a
    public boolean dl() {
        return false;
    }

    @Override // com.bytedance.sdk.component.gz.z.a
    public com.bytedance.sdk.component.gz.z.z.g e() {
        return null;
    }

    @Override // com.bytedance.sdk.component.gz.z.a
    public String g() {
        return "mediation_log";
    }

    @Override // com.bytedance.sdk.component.gz.z.a
    public String gc() {
        return "gromore-no-webview";
    }

    @Override // com.bytedance.sdk.component.gz.z.a
    public boolean i() {
        return false;
    }

    @Override // com.bytedance.sdk.component.gz.z.a
    public com.bytedance.sdk.component.gz.g.dl kb() {
        return null;
    }

    @Override // com.bytedance.sdk.component.gz.z.a
    public boolean m() {
        return false;
    }

    @Override // com.bytedance.sdk.component.gz.z.a
    public int uy() {
        return 2;
    }

    @Override // com.bytedance.sdk.component.gz.z.a
    public boolean v() {
        return false;
    }

    @Override // com.bytedance.sdk.component.gz.z.a
    public com.bytedance.sdk.component.gz.z.gz wp() {
        return null;
    }

    @Override // com.bytedance.sdk.component.gz.z.a
    public com.bytedance.sdk.component.gz.z.g z(JSONObject jSONObject) {
        return null;
    }

    @Override // com.bytedance.sdk.component.gz.z.a
    public void z(JSONObject jSONObject, JSONObject jSONObject2) {
    }

    @Override // com.bytedance.sdk.component.gz.z.a
    public boolean z() {
        return false;
    }

    @Override // com.bytedance.sdk.component.gz.z.a
    public boolean z(Context context) {
        return io.z(context);
    }

    @Override // com.bytedance.sdk.component.gz.z.a
    public String z(String str) {
        return dl(str);
    }

    @Override // com.bytedance.sdk.component.gz.z.a
    public String g(String str) {
        return com.bytedance.msdk.gz.z.z(str, com.bytedance.msdk.gz.g.z());
    }

    public static String dl(String str) {
        return com.bytedance.msdk.gz.z.g(str, com.bytedance.msdk.gz.g.z());
    }

    @Override // com.bytedance.sdk.component.gz.z.a
    public Executor gz() {
        return com.bytedance.msdk.z.gc.m.m();
    }

    @Override // com.bytedance.sdk.component.gz.z.a
    public Executor fo() {
        return com.bytedance.msdk.z.gc.m.m();
    }

    @Override // com.bytedance.sdk.component.gz.z.a
    public Looper pf() {
        return com.bytedance.sdk.component.uy.g.z.z().g().getLooper();
    }
}
