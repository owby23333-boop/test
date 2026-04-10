package com.bytedance.sdk.openadsdk.core.kb.a;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public interface a {
    boolean dl();

    e g();

    void g(String str);

    boolean g(com.ss.android.z.z.dl.dl dlVar, com.ss.android.socialbase.downloader.e.dl dlVar2);

    AlertDialog z(Activity activity, boolean z, z zVar);

    String z(boolean z);

    JSONObject z();

    void z(int i, String str, Map<String, Object> map, gc gcVar);

    void z(Activity activity, String[] strArr, m mVar);

    void z(gz gzVar, boolean z);

    void z(String str, byte[] bArr, String str2, gc gcVar);

    void z(WeakReference<Context> weakReference, boolean z, z zVar);

    void z(JSONObject jSONObject, String str);

    boolean z(Context context, String str);

    boolean z(com.ss.android.z.z.dl.dl dlVar);

    boolean z(com.ss.android.z.z.dl.dl dlVar, com.ss.android.socialbase.downloader.e.dl dlVar2);

    boolean z(String str);
}
