package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.text.TextUtils;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.baidu.mobads.sdk.internal.am;
import dalvik.system.DexClassLoader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class d {
    private static volatile d a;

    private d() {
    }

    public static d a() {
        if (a == null) {
            synchronized (d.class) {
                if (a == null) {
                    a = new d();
                }
            }
        }
        return a;
    }

    public void a(double d2, am.b bVar) {
        cn cnVarA = cn.a();
        String strC = cnVarA.c(w.a);
        HashMap<String, String> map = new HashMap<>();
        map.put("v", "" + d2);
        map.put("os", DispatchConstants.ANDROID);
        map.put("tp", a(bj.a((Context) null).d()));
        map.put("bdr", a(bj.a((Context) null).b()));
        am amVar = new am(cnVarA.a(strC, map));
        amVar.a(bVar);
        amVar.b();
    }

    public String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException | NullPointerException unused) {
            return str;
        }
    }

    public DexClassLoader a(String str, String str2, String str3, ClassLoader classLoader) {
        return new DexClassLoader(str, str2, str3, classLoader);
    }
}
