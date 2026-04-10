package com.tencent.smtt.utils;

import com.tencent.smtt.sdk.TbsListener;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class f {
    private static f b;
    private final Map<Integer, String> a = new HashMap();

    private f() {
        this.a.put(Integer.valueOf(TbsListener.ErrorCode.THROWABLE_INITX5CORE), "if NoSuchMethodError, please check the Class in base.apk which is conflict with x5.");
        this.a.put(Integer.valueOf(TbsListener.ErrorCode.ERROR_CPU_NOT_SUPPORT), "your CPU is i686|mips|x86_64? sorry X5 is not support them.");
        this.a.put(402, "QbSdk.forceSysWebView() has been called! Check it.");
        this.a.put(404, "try to restart your app.");
    }

    public static f a() {
        if (b == null) {
            b = new f();
        }
        return b;
    }

    public String a(int i2) {
        if (i2 >= 303 && i2 <= 324) {
            return "Core has some problem, try to reinstall the app.";
        }
        try {
            return this.a.get(Integer.valueOf(i2));
        } catch (Exception unused) {
            return "Unexpected load error.";
        }
    }
}
