package com.kwad.sdk.api;

import com.kwad.sdk.api.core.IKsAdSDK;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes4.dex */
public final class c {
    private static List<Throwable> Oe;
    private static IKsAdSDK atA;

    static /* synthetic */ List t(List list) {
        Oe = null;
        return null;
    }

    public static void a(IKsAdSDK iKsAdSDK) {
        atA = iKsAdSDK;
    }

    public static IKsAdSDK Dd() {
        return atA;
    }

    public static boolean De() {
        Boolean bool = (Boolean) g("enableDynamic", new Object[0]);
        return (bool == null || bool.booleanValue()) ? false : true;
    }

    public static int Df() {
        Integer num = (Integer) g("getAutoRevertTime", new Object[0]);
        if (num != null) {
            return num.intValue();
        }
        return -1;
    }

    public static <T> T g(String str, Object... objArr) {
        try {
            T t = (T) atA.dM(str, objArr);
            if (t != null) {
                return t;
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String cm(String str) {
        return (String) g("TRANSFORM_API_HOST", str);
    }

    public static void m(Throwable th) {
        try {
            if (atA != null && KsAdSDK.haseInit()) {
                atA.re(th);
            } else {
                b(th);
            }
        } catch (Throwable unused) {
        }
    }

    private static void b(Throwable th) {
        try {
            if (Oe == null) {
                Oe = new CopyOnWriteArrayList();
            }
            Oe.add(th);
        } catch (Throwable unused) {
        }
    }

    public static void ow() {
        try {
            com.kwad.sdk.api.a.a.a(new com.kwad.sdk.api.a.b() { // from class: com.kwad.sdk.api.c.1
                @Override // com.kwad.sdk.api.a.b
                public final void doTask() {
                    try {
                        if (c.Oe == null) {
                            return;
                        }
                        for (Throwable th : c.Oe) {
                            if (c.atA != null && KsAdSDK.haseInit()) {
                                c.atA.re(th);
                            }
                        }
                        c.Oe.clear();
                        c.t(null);
                    } catch (Throwable unused) {
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }
}
