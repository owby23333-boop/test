package com.anythink.core.common;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.common.e.al;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class x {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f7957c = "x";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile x f7958d;
    Map<String, al> a;
    Context b;

    private x(Context context) {
        this.b = context.getApplicationContext();
        a();
    }

    public static x a(Context context) {
        if (f7958d == null) {
            synchronized (x.class) {
                if (f7958d == null) {
                    f7958d = new x(context);
                }
            }
        }
        return f7958d;
    }

    private al b(String str) {
        Map<String, al> map = this.a;
        if (map != null) {
            return map.remove(str);
        }
        return null;
    }

    private static void b() {
    }

    private void a() {
        if (this.a == null) {
            this.a = new ConcurrentHashMap(5);
            try {
                Map<String, ?> mapA = com.anythink.core.common.k.p.a(this.b, com.anythink.core.common.b.g.B);
                if (mapA != null) {
                    for (Map.Entry<String, ?> entry : mapA.entrySet()) {
                        String key = entry.getKey();
                        Object value = entry.getValue();
                        if (value instanceof String) {
                            this.a.put(key, al.a((String) value));
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    public final void a(String str, String str2, al.a aVar, al.a aVar2) {
        Map<String, al> map = this.a;
        if (map == null) {
            return;
        }
        al alVar = map.get(str);
        if (alVar == null) {
            synchronized (this) {
                alVar = this.a.get(str);
                if (alVar == null) {
                    alVar = new al();
                    alVar.b(str2);
                    this.a.put(str, alVar);
                }
            }
        }
        if (TextUtils.equals(str2, alVar.b())) {
            if (aVar != null) {
                alVar.a(aVar);
                alVar.a(System.currentTimeMillis());
            }
            if (aVar2 != null) {
                alVar.b(aVar2);
            }
        }
    }

    public final void a(String str) {
        Map<String, al> map = this.a;
        if (map == null) {
            return;
        }
        try {
            al alVar = map.get(str);
            if (alVar != null) {
                com.anythink.core.common.k.p.a(this.b, com.anythink.core.common.b.g.B, str, alVar.a().toString());
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
