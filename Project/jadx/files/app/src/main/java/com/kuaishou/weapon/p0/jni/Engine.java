package com.kuaishou.weapon.p0.jni;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.c.e;
import com.kuaishou.weapon.p0.bg;
import com.kuaishou.weapon.p0.bo;
import com.kuaishou.weapon.p0.bp;
import com.kuaishou.weapon.p0.cj;
import com.kuaishou.weapon.p0.de;
import com.kuaishou.weapon.p0.h;
import java.lang.reflect.Member;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class Engine {
    private static volatile Engine instance = null;
    public static volatile int loadSoCount = 0;
    public static volatile boolean loadSuccess = false;
    public static volatile String soPath;
    public static volatile String soVersion;

    public static native String abc();

    public static native String bcd();

    public static Engine getInstance(Context context) {
        if (!TextUtils.isEmpty(soVersion) && !loadSuccess && instance == null) {
            synchronized (Engine.class) {
                if (instance == null) {
                    instance = new Engine();
                }
                h hVarA = h.a(context, "re_po_rt");
                try {
                } catch (Throwable th) {
                    loadSuccess = false;
                    try {
                        HashMap map = new HashMap();
                        map.put(e.a, th.getMessage());
                        map.put("v", soVersion);
                        map.put("l", cj.f16636k);
                        bg.a(context, cj.a, map);
                    } catch (Exception unused) {
                    }
                }
                if (!bo.a(context, bp.f16590d + soVersion.replace(".", "") + ".so")) {
                    HashMap map2 = new HashMap();
                    map2.put("l", cj.f16637l);
                    bg.a(context, cj.a, map2);
                    loadSuccess = false;
                    return instance;
                }
                String strB = hVarA.b(de.f16685f, "");
                if (TextUtils.isEmpty(strB)) {
                    strB = soVersion;
                    hVarA.c(de.f16685f, strB, false);
                }
                loadSoCount = hVarA.c(de.aY);
                if (!TextUtils.equals(strB, soVersion)) {
                    String str = soVersion;
                    loadSoCount = 0;
                    hVarA.c(de.f16685f, str, false);
                }
                if (loadSoCount + 1 < 10) {
                    loadSoCount++;
                    hVarA.d(de.aY, loadSoCount);
                    System.loadLibrary(bp.f16590d + soVersion.replace(".", ""));
                    bcd();
                    HashMap map3 = new HashMap();
                    StringBuilder sb = new StringBuilder();
                    sb.append(loadSoCount);
                    map3.put("c", sb.toString());
                    map3.put("v", soVersion);
                    map3.put("l", "s");
                    bg.a(context, "1003001", map3);
                    loadSoCount = 0;
                    loadSuccess = true;
                }
                hVarA.d(de.aY, loadSoCount);
            }
        }
        return instance;
    }

    public static native int mmo(Member member, int i2, int i3);

    public static native int mqc(Member member, int i2);

    public static native int off();

    public static native String tao(int i2, long j2, Object obj);

    public native byte[] ac(byte[] bArr, byte[] bArr2);

    public native byte[] ar(byte[] bArr, byte[] bArr2);

    public native String cde();

    public native byte[] dc(byte[] bArr, byte[] bArr2);

    public native String def();

    public native byte[] dr(byte[] bArr, byte[] bArr2);

    public native String efg();

    public native String eopq(int i2, int i3, int i4, String str);

    public native String fgh();

    public native String ghi();

    public native String hij();

    public native String klm(int i2, String str);

    public native String nop();

    public native String pqr(int i2, int i3, int i4, String str);

    public native String qrs();

    public native String stu(int i2, int i3, int i4, int i5, String str);
}
