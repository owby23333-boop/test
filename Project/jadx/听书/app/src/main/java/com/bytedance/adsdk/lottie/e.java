package com.bytedance.adsdk.lottie;

import android.content.Context;
import android.content.res.Resources;
import android.util.JsonReader;
import com.bytedance.adsdk.lottie.a.zw;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.zip.ZipInputStream;

/* JADX INFO: loaded from: classes2.dex */
public class e {
    private static final Map<String, i<m>> z = new HashMap();
    private static final Set<Object> g = new HashSet();
    private static final byte[] dl = {80, 75, 3, 4};

    public static i<m> z(Context context, String str) {
        return z(context, str, "url_" + str);
    }

    public static i<m> z(final Context context, final String str, final String str2) {
        return z(str2, new Callable<wp<m>>() { // from class: com.bytedance.adsdk.lottie.e.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public wp<m> call() throws Exception {
                wp<m> wpVarZ = gc.z(context).z(context, str, str2);
                if (str2 != null && wpVarZ.z() != null) {
                    com.bytedance.adsdk.lottie.model.gc.z().z(str2, wpVarZ.z());
                }
                return wpVarZ;
            }
        });
    }

    public static i<m> g(Context context, String str) {
        return g(context, str, "asset_" + str);
    }

    public static i<m> g(Context context, final String str, final String str2) {
        final Context applicationContext = context.getApplicationContext();
        return z(str2, new Callable<wp<m>>() { // from class: com.bytedance.adsdk.lottie.e.4
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public wp<m> call() throws Exception {
                return e.dl(applicationContext, str, str2);
            }
        });
    }

    public static wp<m> dl(Context context, String str) {
        return dl(context, str, "asset_" + str);
    }

    public static wp<m> dl(Context context, String str, String str2) {
        try {
            if (!str.endsWith(".zip") && !str.endsWith(".lottie")) {
                return g(context.getAssets().open(str), str2);
            }
            return z(context, new ZipInputStream(context.getAssets().open(str)), str2);
        } catch (IOException e) {
            return new wp<>((Throwable) e);
        }
    }

    public static i<m> z(Context context, int i) {
        return z(context, i, dl(context, i));
    }

    public static i<m> z(Context context, final int i, final String str) {
        final WeakReference weakReference = new WeakReference(context);
        final Context applicationContext = context.getApplicationContext();
        return z(str, new Callable<wp<m>>() { // from class: com.bytedance.adsdk.lottie.e.5
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public wp<m> call() throws Exception {
                Context context2 = (Context) weakReference.get();
                if (context2 == null) {
                    context2 = applicationContext;
                }
                return e.g(context2, i, str);
            }
        });
    }

    public static wp<m> g(Context context, int i) {
        return g(context, i, dl(context, i));
    }

    public static wp<m> g(Context context, int i, String str) {
        try {
            return g(context.getResources().openRawResource(i), dl(context, i));
        } catch (Resources.NotFoundException e) {
            return new wp<>((Throwable) e);
        }
    }

    private static String dl(Context context, int i) {
        return "rawRes" + (z(context) ? "_night_" : "_day_") + i;
    }

    private static boolean z(Context context) {
        return (context.getResources().getConfiguration().uiMode & 48) == 32;
    }

    public static i<m> z(final InputStream inputStream, final String str) {
        return z(str, new Callable<wp<m>>() { // from class: com.bytedance.adsdk.lottie.e.6
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public wp<m> call() throws Exception {
                return e.g(inputStream, str);
            }
        });
    }

    public static wp<m> g(InputStream inputStream, String str) {
        return z(inputStream, str, true);
    }

    private static wp<m> z(InputStream inputStream, String str, boolean z2) {
        try {
            return z(new JsonReader(new InputStreamReader(inputStream)), str);
        } finally {
            if (z2) {
                com.bytedance.adsdk.lottie.gc.fo.z(inputStream);
            }
        }
    }

    public static wp<m> z(JsonReader jsonReader, String str) {
        return z(jsonReader, str, true);
    }

    private static wp<m> z(JsonReader jsonReader, String str, boolean z2) {
        try {
            try {
                m mVarZ = zw.z(jsonReader);
                com.bytedance.adsdk.lottie.model.gc.z().z(str, mVarZ);
                wp<m> wpVar = new wp<>(mVarZ);
                if (z2) {
                    z(jsonReader);
                }
                return wpVar;
            } catch (Exception e) {
                wp<m> wpVar2 = new wp<>(e);
                if (z2) {
                    z(jsonReader);
                }
                return wpVar2;
            }
        } catch (Throwable th) {
            if (z2) {
                z(jsonReader);
            }
            throw th;
        }
    }

    public static void z(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception unused) {
            }
        }
    }

    public static wp<m> z(Context context, ZipInputStream zipInputStream, String str) {
        try {
            return g(context, zipInputStream, str);
        } finally {
            com.bytedance.adsdk.lottie.gc.fo.z(zipInputStream);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x0116 A[Catch: IOException -> 0x02c2, TryCatch #3 {IOException -> 0x02c2, blocks: (B:3:0x000a, B:6:0x0014, B:8:0x0020, B:62:0x0154, B:9:0x0025, B:11:0x0031, B:12:0x0036, B:14:0x0042, B:15:0x0059, B:18:0x0065, B:20:0x006d, B:22:0x0075, B:25:0x007f, B:27:0x0087, B:30:0x0090, B:31:0x0095, B:33:0x009b, B:34:0x00a4, B:54:0x010c, B:56:0x0116, B:57:0x0132, B:53:0x00ea, B:58:0x0136, B:60:0x013c, B:61:0x0145, B:35:0x00c2, B:42:0x00d9, B:51:0x00e8, B:50:0x00e5, B:47:0x00e0, B:37:0x00c9, B:38:0x00cb, B:40:0x00d2, B:41:0x00d6, B:45:0x00de), top: B:121:0x000a, inners: #2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.bytedance.adsdk.lottie.wp<com.bytedance.adsdk.lottie.m> g(android.content.Context r12, java.util.zip.ZipInputStream r13, java.lang.String r14) {
        /*
            Method dump skipped, instruction units count: 713
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.lottie.e.g(android.content.Context, java.util.zip.ZipInputStream, java.lang.String):com.bytedance.adsdk.lottie.wp");
    }

    private static fo z(m mVar, String str) {
        for (fo foVar : mVar.p().values()) {
            if (foVar.wp().equals(str)) {
                return foVar;
            }
        }
        return null;
    }

    private static i<m> z(final String str, Callable<wp<m>> callable) {
        final m mVarZ = str == null ? null : com.bytedance.adsdk.lottie.model.gc.z().z(str);
        if (mVarZ != null) {
            return new i<>(new Callable<wp<m>>() { // from class: com.bytedance.adsdk.lottie.e.7
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public wp<m> call() throws Exception {
                    return new wp<>(mVarZ);
                }
            });
        }
        if (str != null) {
            Map<String, i<m>> map = z;
            if (map.containsKey(str)) {
                return map.get(str);
            }
        }
        i<m> iVar = new i<>(callable);
        if (str != null) {
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            iVar.z(new uy<m>() { // from class: com.bytedance.adsdk.lottie.e.2
                @Override // com.bytedance.adsdk.lottie.uy
                public void z(m mVar) {
                    e.z.remove(str);
                    atomicBoolean.set(true);
                    if (e.z.size() == 0) {
                        e.g(true);
                    }
                }
            });
            iVar.dl(new uy<Throwable>() { // from class: com.bytedance.adsdk.lottie.e.3
                @Override // com.bytedance.adsdk.lottie.uy
                public void z(Throwable th) {
                    e.z.remove(str);
                    atomicBoolean.set(true);
                    if (e.z.size() == 0) {
                        e.g(true);
                    }
                }
            });
            if (!atomicBoolean.get()) {
                Map<String, i<m>> map2 = z;
                map2.put(str, iVar);
                if (map2.size() == 1) {
                    g(false);
                }
            }
        }
        return iVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void g(boolean z2) {
        ArrayList arrayList = new ArrayList(g);
        for (int i = 0; i < arrayList.size(); i++) {
            arrayList.get(i);
        }
    }
}
