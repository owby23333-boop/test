package com.efs.sdk.base.core.a;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.efs.sdk.base.BuildConfig;
import com.efs.sdk.base.EfsConstant;
import com.efs.sdk.base.core.controller.ControllerCenter;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.core.util.PackageUtil;
import com.umeng.analytics.pro.an;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    String f1528a;
    String b;
    String c;
    public String d;
    public int e;
    public String f;
    public byte g;
    public String h;
    String i;
    String j;
    String k;
    String l;
    public long m = 0;

    public static c a() {
        c cVar = new c();
        cVar.f1528a = ControllerCenter.getGlobalEnvStruct().getAppid();
        cVar.b = ControllerCenter.getGlobalEnvStruct().getSecret();
        cVar.l = ControllerCenter.getGlobalEnvStruct().getUid();
        cVar.j = BuildConfig.VERSION_NAME;
        cVar.c = PackageUtil.getAppVersionName(ControllerCenter.getGlobalEnvStruct().mAppContext);
        cVar.i = String.valueOf(com.efs.sdk.base.core.config.a.c.a().d.f1548a);
        cVar.k = EfsConstant.UM_SDK_VERSION;
        return cVar;
    }

    public final String b() {
        a.a();
        String strValueOf = String.valueOf(a.b() / 1000);
        String strA = com.efs.sdk.base.core.util.b.b.a(com.efs.sdk.base.core.util.b.a.a(this.l + strValueOf, this.b));
        TreeMap treeMap = new TreeMap();
        treeMap.put("app", this.f1528a);
        treeMap.put(LiveConfigKey.STANDARD, strA);
        if (!TextUtils.isEmpty(this.d)) {
            treeMap.put("cp", this.d);
        }
        if (this.g != 0) {
            treeMap.put("de", String.valueOf(this.e));
            treeMap.put("type", this.h);
            String str = this.f;
            if (TextUtils.isEmpty(str)) {
                a.a();
                long jB = a.b();
                str = String.format(Locale.SIMPLIFIED_CHINESE, "%d%04d", Long.valueOf(jB), Integer.valueOf(new Random(jB).nextInt(10000)));
            }
            treeMap.put("seq", str);
        }
        treeMap.put("cver", this.i);
        treeMap.put(an.x, "android");
        treeMap.put("sver", this.i);
        treeMap.put("tm", strValueOf);
        treeMap.put("ver", this.c);
        treeMap.put("um_sdk_ver", this.k);
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (Map.Entry entry : treeMap.entrySet()) {
            String str2 = ((String) entry.getKey()) + "=" + ((String) entry.getValue());
            sb2.append(str2);
            sb.append(str2).append("&");
        }
        sb.append("sign=").append(com.efs.sdk.base.core.util.b.b.a(sb2.toString() + this.b));
        Log.d("efs.config", sb.toString());
        return com.efs.sdk.base.core.util.b.b.b(sb.toString());
    }
}
