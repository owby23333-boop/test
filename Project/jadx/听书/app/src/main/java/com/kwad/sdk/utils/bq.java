package com.kwad.sdk.utils;

import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public final class bq {
    public static String get(String str) {
        Object objB = b("get", new Class[]{String.class}, str);
        if (objB instanceof String) {
            return (String) objB;
        }
        return hq(str);
    }

    public static String get(String str, String str2) {
        Object objB = b("get", new Class[]{String.class, String.class}, str, str2);
        if (objB instanceof String) {
            return (String) objB;
        }
        return (String) a(str, str2, new com.kwad.sdk.g.b<String, String>() { // from class: com.kwad.sdk.utils.bq.1
            private static String hr(String str3) {
                return str3;
            }

            @Override // com.kwad.sdk.g.b
            public final /* synthetic */ String apply(String str3) {
                return hr(str3);
            }
        });
    }

    public static int getInt(String str, int i) {
        Object objB = b("getInt", new Class[]{String.class, Integer.TYPE}, str, Integer.valueOf(i));
        if (objB instanceof Integer) {
            return ((Integer) objB).intValue();
        }
        return ((Integer) a(str, Integer.valueOf(i), new com.kwad.sdk.g.b<String, Integer>() { // from class: com.kwad.sdk.utils.bq.2
            @Override // com.kwad.sdk.g.b
            public final /* synthetic */ Integer apply(String str2) {
                return hs(str2);
            }

            private static Integer hs(String str2) {
                return Integer.valueOf(Integer.parseInt(str2));
            }
        })).intValue();
    }

    public static long getLong(String str, long j) {
        Object objB = b("getLong", new Class[]{String.class, Long.TYPE}, str, Long.valueOf(j));
        if (objB instanceof Long) {
            return ((Long) objB).longValue();
        }
        return ((Long) a(str, Long.valueOf(j), new com.kwad.sdk.g.b<String, Long>() { // from class: com.kwad.sdk.utils.bq.3
            @Override // com.kwad.sdk.g.b
            public final /* synthetic */ Long apply(String str2) {
                return ht(str2);
            }

            private static Long ht(String str2) {
                return Long.valueOf(Long.parseLong(str2));
            }
        })).longValue();
    }

    public static boolean getBoolean(String str, boolean z) {
        Object objB = b("getBoolean", new Class[]{String.class, Boolean.TYPE}, str, Boolean.valueOf(z));
        if (objB instanceof Boolean) {
            return ((Boolean) objB).booleanValue();
        }
        return ((Boolean) a(str, Boolean.valueOf(z), new com.kwad.sdk.g.b<String, Boolean>() { // from class: com.kwad.sdk.utils.bq.4
            @Override // com.kwad.sdk.g.b
            public final /* synthetic */ Boolean apply(String str2) {
                return hu(str2);
            }

            private static Boolean hu(String str2) {
                return Boolean.valueOf(Boolean.parseBoolean(str2));
            }
        })).booleanValue();
    }

    private static Object b(String str, Class[] clsArr, Object... objArr) {
        try {
            return z.a("android.os.SystemProperties", str, clsArr, objArr);
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTrace(th);
            return null;
        }
    }

    private static <T> T a(String str, T t, com.kwad.sdk.g.b<String, T> bVar) {
        String strHq = hq(str);
        if (strHq == null) {
            return t;
        }
        try {
            return bVar.apply(strHq);
        } catch (Throwable unused) {
            return t;
        }
    }

    private static String hq(String str) {
        try {
            return com.kwad.sdk.crash.utils.h.c(Runtime.getRuntime().exec("getprop " + str).getInputStream());
        } catch (IOException e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
            return null;
        }
    }
}
