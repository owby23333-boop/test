package com.anythink.core.common;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class b {
    public static final String a = "1";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile b f6767c;
    ConcurrentHashMap<String, List<a>> b = new ConcurrentHashMap<>();

    public interface a {
        void a(Object obj);
    }

    private b() {
    }

    public static b a() {
        if (f6767c == null) {
            synchronized (b.class) {
                if (f6767c == null) {
                    f6767c = new b();
                }
            }
        }
        return f6767c;
    }

    public final synchronized void b(final String str, final a aVar) {
        if (!TextUtils.isEmpty(str) && aVar != null) {
            com.anythink.core.common.k.b.a.a().a(new Runnable() { // from class: com.anythink.core.common.b.2
                @Override // java.lang.Runnable
                public final void run() {
                    synchronized (b.this) {
                        List<a> list = b.this.b.get(str);
                        if (list != null) {
                            list.remove(aVar);
                        }
                    }
                }
            });
        }
    }

    public final synchronized void a(final String str, final a aVar) {
        if (!TextUtils.isEmpty(str) && aVar != null) {
            com.anythink.core.common.k.b.a.a().a(new Runnable() { // from class: com.anythink.core.common.b.1
                @Override // java.lang.Runnable
                public final void run() {
                    synchronized (b.this) {
                        List<a> arrayList = b.this.b.get(str);
                        if (arrayList == null) {
                            arrayList = new ArrayList<>();
                            b.this.b.put(str, arrayList);
                        }
                        arrayList.add(aVar);
                    }
                }
            });
        }
    }

    public final synchronized void a(final String str, final Object obj) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.anythink.core.common.k.b.a.a().a(new Runnable() { // from class: com.anythink.core.common.b.3
            @Override // java.lang.Runnable
            public final void run() {
                synchronized (b.this) {
                    List<a> list = b.this.b.get(str);
                    if (list == null) {
                        return;
                    }
                    for (a aVar : list) {
                        if (aVar != null) {
                            aVar.a(obj);
                        }
                    }
                }
            }
        });
    }
}
