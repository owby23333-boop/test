package com.ta.utdid2.device;

import android.content.Context;
import com.ta.utdid2.a.a.f;
import java.util.zip.Adler32;

/* JADX INFO: loaded from: classes3.dex */
public class b {
    private static a a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    static final Object f153a = new Object();

    static long a(a aVar) {
        if (aVar == null) {
            return 0L;
        }
        String str = String.format("%s%s%s%s%s", aVar.e(), aVar.getDeviceId(), Long.valueOf(aVar.a()), aVar.getImsi(), aVar.d());
        if (f.m175a(str)) {
            return 0L;
        }
        Adler32 adler32 = new Adler32();
        adler32.reset();
        adler32.update(str.getBytes());
        return adler32.getValue();
    }

    public static synchronized a b(Context context) {
        if (a != null) {
            return a;
        }
        if (context == null) {
            return null;
        }
        a aVarA = a(context);
        a = aVarA;
        return aVarA;
    }

    private static a a(Context context) {
        if (context == null) {
            return null;
        }
        synchronized (f153a) {
            String value = c.a(context).getValue();
            if (f.m175a(value)) {
                return null;
            }
            if (value.endsWith("\n")) {
                value = value.substring(0, value.length() - 1);
            }
            a aVar = new a();
            long jCurrentTimeMillis = System.currentTimeMillis();
            String strA = com.ta.utdid2.a.a.d.a(context);
            String strB = com.ta.utdid2.a.a.d.b(context);
            aVar.c(strA);
            aVar.a(strA);
            aVar.b(jCurrentTimeMillis);
            aVar.b(strB);
            aVar.d(value);
            aVar.a(a(aVar));
            return aVar;
        }
    }
}
