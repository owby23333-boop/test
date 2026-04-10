package com.bykv.vk.component.ttvideo.log;

import android.content.Context;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f2048a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f2049b;
    public String g;
    public String c = "";
    public String d = "";
    public String e = "";
    public int h = Integer.MIN_VALUE;
    public String f = com.bykv.vk.component.ttvideo.utils.b.a(null);

    public c(a aVar, Context context) {
        this.f2048a = aVar;
    }

    public void a() {
        b();
    }

    public void b() {
        Map mapVersionInfo;
        a aVar = this.f2048a;
        if (aVar == null || (mapVersionInfo = aVar.versionInfo()) == null) {
            return;
        }
        this.c = (String) mapVersionInfo.get("pc");
        this.d = (String) mapVersionInfo.get("sv");
        this.e = (String) mapVersionInfo.get("sdk_version");
    }

    public void a(String str) {
        this.f2049b = str;
        this.f = com.bykv.vk.component.ttvideo.utils.b.b(str);
    }

    public void b(String str) {
    }
}
