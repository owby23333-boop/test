package com.bytedance.sdk.openadsdk.core.un;

import android.view.View;
import android.view.ViewGroup;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class mc {
    public static final int z = com.bytedance.sdk.component.utils.tb.m(com.bytedance.sdk.openadsdk.core.zw.getContext(), "tt_shake_tag_key");
    private static final ConcurrentHashMap<ViewGroup, Object> g = new ConcurrentHashMap<>();
    private static final Object dl = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile boolean f1381a = false;

    private mc() {
    }

    public static void z(WeakReference<ViewGroup> weakReference, com.bytedance.sdk.openadsdk.core.g.dl dlVar) {
        if (weakReference == null || dlVar == null) {
            return;
        }
        ViewGroup viewGroup = weakReference.get();
        if (!com.bytedance.sdk.openadsdk.core.ti.z(viewGroup)) {
            z(viewGroup, false);
            return;
        }
        g.put(viewGroup, dlVar);
        if (f1381a) {
            z(viewGroup, false);
            return;
        }
        synchronized (mc.class) {
            if (f1381a) {
                z(viewGroup, false);
            } else {
                f1381a = true;
                com.bytedance.sdk.openadsdk.core.q.m().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.un.mc.1
                    @Override // java.lang.Runnable
                    public void run() {
                        mc.dl();
                    }
                }, 50L);
            }
        }
    }

    public static boolean z(View view) {
        if (view == null) {
            return false;
        }
        Object tag = view.getTag(z);
        if (tag instanceof Map) {
            Object obj = ((Map) tag).get("is_shake_efficient");
            if (obj instanceof Boolean) {
                return ((Boolean) obj).booleanValue();
            }
        }
        return false;
    }

    private static void z(ViewGroup viewGroup, boolean z2) {
        if (viewGroup == null) {
            return;
        }
        HashMap map = new HashMap();
        map.put("is_shake_efficient", Boolean.valueOf(z2));
        int i = z;
        Object tag = viewGroup.getTag(i);
        if (tag != null) {
            try {
                if (!(tag instanceof HashMap)) {
                    return;
                }
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.wp.a("TTShakeChecker", th.getMessage());
                z(z, th.getMessage());
                return;
            }
        }
        viewGroup.setTag(i, map);
    }

    public static void z(final int i, final String str) {
        com.bytedance.sdk.openadsdk.core.q.g.dl().z(new com.bytedance.sdk.openadsdk.kb.z.z() { // from class: com.bytedance.sdk.openadsdk.core.un.mc.2
            @Override // com.bytedance.sdk.openadsdk.kb.z.z
            public com.bytedance.sdk.openadsdk.core.q.z.z z() {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("shake_tag", i);
                    jSONObject.put("error_msg", str);
                } catch (Throwable unused) {
                }
                return com.bytedance.sdk.openadsdk.core.q.z.g.g().z("stats_shake_tag_key").g(jSONObject.toString());
            }
        }, "stats_shake_tag_key", false);
    }

    public static void z(WeakReference<ViewGroup> weakReference, float f, float f2, long j) {
        if (weakReference == null) {
            return;
        }
        ViewGroup viewGroup = weakReference.get();
        if (com.bytedance.sdk.openadsdk.core.ti.z(viewGroup) && z(f, f2, j)) {
            g.put(viewGroup, dl);
            if (f1381a) {
                return;
            }
            synchronized (mc.class) {
                if (f1381a) {
                    return;
                }
                f1381a = true;
                com.bytedance.sdk.openadsdk.core.q.m().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.un.mc.3
                    @Override // java.lang.Runnable
                    public void run() {
                        mc.a();
                    }
                }, 50L);
            }
        }
    }

    private static boolean z(float f, float f2, long j) {
        if (f == -1.0f) {
            return true;
        }
        if (f < 0.0f) {
            return false;
        }
        if (f == 0.0f && f2 == 2.1474836E9f) {
            return true;
        }
        if (f2 <= f) {
            return false;
        }
        float fCurrentTimeMillis = (System.currentTimeMillis() - j) / 1000.0f;
        return fCurrentTimeMillis >= f && fCurrentTimeMillis <= f2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0093  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void dl() {
        /*
            java.util.concurrent.ConcurrentHashMap<android.view.ViewGroup, java.lang.Object> r0 = com.bytedance.sdk.openadsdk.core.un.mc.g
            boolean r1 = r0.isEmpty()
            if (r1 == 0) goto L9
            return
        L9:
            android.content.Context r1 = com.bytedance.sdk.openadsdk.core.zw.getContext()
            int r1 = com.bytedance.sdk.openadsdk.core.un.oq.gc(r1)
            java.util.Set r0 = r0.keySet()
            java.util.Iterator r0 = r0.iterator()
            r2 = 2147483647(0x7fffffff, float:NaN)
            r3 = 0
            r4 = r2
            r5 = r3
            r6 = r5
        L20:
            boolean r7 = r0.hasNext()
            if (r7 == 0) goto L77
            java.lang.Object r7 = r0.next()
            android.view.ViewGroup r7 = (android.view.ViewGroup) r7
            if (r7 == 0) goto L20
            android.graphics.Rect r8 = new android.graphics.Rect
            r8.<init>()
            boolean r9 = r7.getGlobalVisibleRect(r8)
            if (r9 != 0) goto L3f
            java.util.concurrent.ConcurrentHashMap<android.view.ViewGroup, java.lang.Object> r8 = com.bytedance.sdk.openadsdk.core.un.mc.g
            r8.remove(r7)
            goto L20
        L3f:
            boolean r9 = com.bytedance.sdk.openadsdk.core.ti.z(r7)
            if (r9 != 0) goto L4b
            java.util.concurrent.ConcurrentHashMap<android.view.ViewGroup, java.lang.Object> r8 = com.bytedance.sdk.openadsdk.core.un.mc.g
            r8.remove(r7)
            goto L20
        L4b:
            int r9 = r1 / 2
            int r10 = r8.bottom
            if (r10 > r9) goto L56
            int r10 = r8.bottom
            int r10 = r9 - r10
            goto L57
        L56:
            r10 = r2
        L57:
            int r11 = r8.top
            if (r11 < r9) goto L5f
            int r11 = r8.top
            int r11 = r11 - r9
            goto L60
        L5f:
            r11 = r2
        L60:
            int r12 = r8.bottom
            if (r12 <= r9) goto L6a
            int r8 = r8.top
            if (r8 >= r9) goto L6a
            r5 = r7
            goto L77
        L6a:
            int r8 = java.lang.Math.min(r11, r10)
            if (r8 >= r4) goto L73
            r5 = r7
            r4 = r8
            goto L20
        L73:
            if (r8 != r4) goto L20
            r6 = r7
            goto L20
        L77:
            if (r5 != 0) goto L7a
            return
        L7a:
            if (r6 == 0) goto L93
            android.graphics.Rect r0 = new android.graphics.Rect
            r0.<init>()
            r5.getGlobalVisibleRect(r0)
            android.graphics.Rect r1 = new android.graphics.Rect
            r1.<init>()
            r6.getGlobalVisibleRect(r1)
            int r0 = r0.top
            int r1 = r1.top
            if (r0 >= r1) goto L93
            goto L94
        L93:
            r6 = r5
        L94:
            java.util.concurrent.ConcurrentHashMap<android.view.ViewGroup, java.lang.Object> r0 = com.bytedance.sdk.openadsdk.core.un.mc.g
            java.lang.Object r1 = r0.get(r6)
            boolean r1 = r1 instanceof com.bytedance.sdk.openadsdk.core.g.dl
            if (r1 == 0) goto La5
            java.lang.Object r1 = r0.get(r6)
            r3 = r1
            com.bytedance.sdk.openadsdk.core.g.dl r3 = (com.bytedance.sdk.openadsdk.core.g.dl) r3
        La5:
            r1 = 1
            z(r6, r1)
            r0.clear()
            r0 = 0
            com.bytedance.sdk.openadsdk.core.un.mc.f1381a = r0
            if (r3 == 0) goto Lb4
            r3.z()
        Lb4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.un.mc.dl():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00ba  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a() {
        /*
            Method dump skipped, instruction units count: 232
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.un.mc.a():void");
    }
}
