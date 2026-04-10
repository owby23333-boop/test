package com.alipay.sdk.m.h0;

import android.annotation.SuppressLint;
import android.content.Context;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public File f1821a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.alipay.sdk.m.l0.a f1822b;

    public b(String str, com.alipay.sdk.m.l0.a aVar) {
        this.f1821a = null;
        this.f1822b = null;
        this.f1821a = new File(str);
        this.f1822b = aVar;
    }

    public static String a(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", "id");
            jSONObject.put("error", str);
            return jSONObject.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    @SuppressLint({"SimpleDateFormat"})
    public static String b() {
        return new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime()) + ".log";
    }

    public final synchronized void a() {
        File file = this.f1821a;
        if (file == null) {
            return;
        }
        if (file.exists() && this.f1821a.isDirectory() && this.f1821a.list().length != 0) {
            ArrayList arrayList = new ArrayList();
            for (String str : this.f1821a.list()) {
                arrayList.add(str);
            }
            Collections.sort(arrayList);
            String str2 = (String) arrayList.get(arrayList.size() - 1);
            int size = arrayList.size();
            if (str2.equals(b())) {
                if (arrayList.size() < 2) {
                    return;
                }
                str2 = (String) arrayList.get(arrayList.size() - 2);
                size--;
            }
            if (!this.f1822b.logCollect(a(com.alipay.sdk.m.d0.b.a(this.f1821a.getAbsolutePath(), str2)))) {
                size--;
            }
            for (int i = 0; i < size; i++) {
                new File(this.f1821a, (String) arrayList.get(i)).delete();
            }
        }
    }

    public void a(Context context) {
        new Thread(new c(this)).start();
    }
}
