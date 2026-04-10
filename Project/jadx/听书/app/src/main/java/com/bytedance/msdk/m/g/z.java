package com.bytedance.msdk.m.g;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final com.bytedance.msdk.core.m.z f498a = new com.bytedance.msdk.core.m.z();
    private static Map<String, Pair<Boolean, String>> gc = new ConcurrentHashMap();
    private static final Map<String, Boolean> gz = new ConcurrentHashMap();
    protected com.bytedance.msdk.core.m.g dl;
    private boolean e;
    private boolean m;
    protected final AtomicBoolean z = new AtomicBoolean(false);
    protected final AtomicBoolean g = new AtomicBoolean(false);

    public static void z(String str, Pair<Boolean, String> pair) {
        gc.put(str, pair);
    }

    public static int z() {
        return gc.size();
    }

    protected z() {
    }

    public static z g() {
        return new z();
    }

    public static synchronized void dl() {
        com.bytedance.msdk.z.gc.m.a(new Runnable() { // from class: com.bytedance.msdk.m.g.z.1
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.msdk.z.gc.dl.g("TTMediationSDK_SDK_Init", "------------------ GroMore 支持ADN初始化信息 start ---------------------");
                for (Map.Entry entry : z.gc.entrySet()) {
                    if (entry.getValue() != null) {
                        if (((Boolean) ((Pair) entry.getValue()).first).booleanValue()) {
                            if (com.bytedance.msdk.core.g.g().dl((String) entry.getKey())) {
                                com.bytedance.msdk.z.gc.dl.a("TTMediationSDK_SDK_Init", "adnName = " + ((String) entry.getKey()) + " 自定义ADN调用初始化方法成功，请开发者确保接入的自定义ADN初始化结果");
                            } else {
                                com.bytedance.msdk.z.gc.dl.g("TTMediationSDK_SDK_Init", "adnName = " + ((String) entry.getKey()) + " 初始化成功");
                            }
                        } else {
                            com.bytedance.msdk.z.gc.dl.a("TTMediationSDK_SDK_Init", "adnName = " + ((String) entry.getKey()) + " 初始化失败 " + ((String) ((Pair) entry.getValue()).second));
                        }
                    }
                }
                com.bytedance.msdk.z.gc.dl.g("TTMediationSDK_SDK_Init", "------------------ GroMore 支持ADN初始化信息 end ---------------------");
            }
        });
    }

    public static com.bytedance.msdk.core.m.z a() {
        return f498a;
    }

    public static String z(Map<String, Object> map, String str) {
        return f498a.z(com.bytedance.msdk.core.g.getContext(), map, str);
    }

    public static Map<String, Object> g(Map<String, Object> map, String str) {
        return f498a.g(com.bytedance.msdk.core.g.getContext(), map, str);
    }

    public static com.bytedance.msdk.api.a.z.g.m.z z(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return f498a.z(str);
    }

    protected void z(Map<String, com.bytedance.msdk.core.uy.z> map) {
        com.bytedance.msdk.core.uy.z zVarRemove;
        if (map == null || (zVarRemove = map.remove(MediationConstant.ADN_GDT)) == null) {
            return;
        }
        new com.bytedance.msdk.m.z.z(zVarRemove).a();
    }

    protected void g(Map<String, com.bytedance.msdk.core.uy.z> map) {
        if (map == null) {
            return;
        }
        com.bytedance.msdk.core.uy.z zVarRemove = map.remove(MediationConstant.ADN_MINTEGRAL);
        final ArrayList arrayList = new ArrayList();
        if (zVarRemove != null) {
            arrayList.add(zVarRemove);
        }
        Runnable runnable = new Runnable() { // from class: com.bytedance.msdk.m.g.z.2
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    new com.bytedance.msdk.m.z.z((com.bytedance.msdk.core.uy.z) it.next()).a();
                }
                z.this.z.set(true);
                z.this.m();
            }
        };
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            runnable.run();
        } else {
            com.bytedance.msdk.z.gc.m.dl(runnable);
        }
    }

    protected void z(final Context context, Map<String, com.bytedance.msdk.core.uy.z> map) {
        if (map == null) {
            return;
        }
        final ArrayList arrayList = new ArrayList();
        final ArrayList arrayList2 = new ArrayList();
        Iterator<Map.Entry<String, com.bytedance.msdk.core.uy.z>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            com.bytedance.msdk.core.uy.z value = it.next().getValue();
            if (value != null) {
                if (value.gc()) {
                    arrayList.add(value);
                } else {
                    arrayList2.add(value);
                }
            }
        }
        com.bytedance.msdk.z.gc.m.a(new Runnable() { // from class: com.bytedance.msdk.m.g.z.3
            @Override // java.lang.Runnable
            public void run() {
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    new com.bytedance.msdk.m.z.z((com.bytedance.msdk.core.uy.z) it2.next()).a();
                }
                com.bytedance.msdk.m.g.z(context, (List<com.bytedance.msdk.core.uy.z>) arrayList);
                z.this.g.set(true);
                z.this.m();
            }
        });
    }

    public void z(Context context, boolean z, boolean z2, com.bytedance.msdk.core.m.g gVar) {
        this.dl = gVar;
        this.z.set(false);
        this.g.set(false);
        this.m = z;
        this.e = z2;
        z(context);
    }

    protected void z(Context context) {
        Map<String, com.bytedance.msdk.core.uy.z> mapDl = com.bytedance.msdk.e.z.g.z().dl();
        z(mapDl);
        gc();
        g(mapDl);
        z(context, mapDl);
    }

    protected void gc() {
        com.bytedance.msdk.z.gc.m.z(new Runnable() { // from class: com.bytedance.msdk.m.g.z.4
            @Override // java.lang.Runnable
            public void run() {
                if (z.this.dl != null) {
                    z.this.dl.z();
                }
            }
        });
    }

    protected void m() {
        if (!this.m && this.e && this.z.get() && this.g.get()) {
            com.bytedance.msdk.m.z.z();
            dl();
        }
    }

    public static void g(String str) {
        com.bytedance.msdk.core.uy.z zVarZ;
        if (TextUtils.isEmpty(str) || TextUtils.equals(MediationConstant.ADN_PANGLE, str) || a(str) || (zVarZ = com.bytedance.msdk.core.g.g().z(str)) == null) {
            return;
        }
        final com.bytedance.msdk.m.z.z zVar = new com.bytedance.msdk.m.z.z(zVarZ);
        if ((TextUtils.equals(MediationConstant.ADN_MINTEGRAL, str) || TextUtils.equals(MediationConstant.ADN_KLEVIN, str)) && !com.bytedance.msdk.z.gc.m.gc()) {
            com.bytedance.msdk.z.gc.m.g(new Runnable() { // from class: com.bytedance.msdk.m.g.z.5
                @Override // java.lang.Runnable
                public void run() {
                    zVar.a();
                }
            });
        } else {
            zVar.a();
        }
    }

    public static final synchronized void dl(String str) {
        if (!TextUtils.isEmpty(str)) {
            gz.put(str, Boolean.TRUE);
        }
    }

    public static final synchronized boolean a(String str) {
        Boolean bool;
        if (TextUtils.isEmpty(str) || (bool = gz.get(str)) == null) {
            return false;
        }
        return bool.booleanValue();
    }
}
