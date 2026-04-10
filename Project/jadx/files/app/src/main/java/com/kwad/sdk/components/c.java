package com.kwad.sdk.components;

import android.content.Context;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class c {
    private static final Map<Class, a> abd = new ConcurrentHashMap();

    public static void a(Class cls, a aVar) {
        abd.put(cls, aVar);
    }

    @Nullable
    public static <T extends a> T f(Class<T> cls) {
        T t2 = (T) abd.get(cls);
        if (t2 != null) {
            return t2;
        }
        com.kwad.sdk.core.d.b.w("KSAdSDK", new ComponentsNotFoundException(cls.getSimpleName()));
        try {
            if (!DevelopMangerComponents.class.isAssignableFrom(cls)) {
                return null;
            }
            e eVar = new e();
            abd.put(cls, eVar);
            return eVar;
        } catch (Throwable th) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(th);
            return null;
        }
    }

    public static void init(Context context) {
        ArrayList<a> arrayList = new ArrayList(abd.values());
        Collections.sort(arrayList, new Comparator<a>() { // from class: com.kwad.sdk.components.c.1
            private static int a(a aVar, a aVar2) {
                if (aVar == null) {
                    return -1;
                }
                if (aVar2 == null) {
                    return 1;
                }
                try {
                    try {
                        return aVar.priority() - aVar2.priority();
                    } catch (Exception unused) {
                        return 1;
                    }
                } catch (Exception unused2) {
                    return -1;
                }
            }

            @Override // java.util.Comparator
            public final /* synthetic */ int compare(a aVar, a aVar2) {
                return a(aVar, aVar2);
            }
        });
        for (a aVar : arrayList) {
            if (aVar != null) {
                try {
                    aVar.init(context);
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.b.printStackTrace(th);
                }
            }
        }
    }
}
