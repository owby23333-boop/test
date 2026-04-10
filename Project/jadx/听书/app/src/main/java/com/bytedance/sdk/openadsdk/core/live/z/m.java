package com.bytedance.sdk.openadsdk.core.live.z;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.core.app.NotificationCompat;
import com.bytedance.android.metrics.EnterFromMerge;
import com.bytedance.android.metrics.EnterMethod;
import com.bytedance.sdk.component.utils.gz;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.core.i.gz;
import com.bytedance.sdk.openadsdk.core.io;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.iq.sv;
import com.bytedance.sdk.openadsdk.core.q.v;
import com.bytedance.sdk.openadsdk.core.un.lq;
import com.bytedance.sdk.openadsdk.core.uy;
import com.umeng.analytics.pro.d;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Function;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class m extends com.bytedance.sdk.openadsdk.core.live.z.z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected String f1241a;
    protected String gc;
    protected volatile SoftReference<na> m;

    protected interface z {
        void z(boolean z);
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.z.a
    @Deprecated
    public int b_(na naVar) {
        return 2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.z.z
    protected boolean x_() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.z.a
    public int z(na naVar, dl dlVar, String str) {
        return -1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.z.z, com.bytedance.sdk.openadsdk.core.live.z.a
    public void z(Function<SparseArray<Object>, Object> function) {
        super.z(function);
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.z.z
    public void a_(String str) {
        this.gc = str;
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.z.a
    public int z(final Context context, final na naVar, final Map<String, Object> map) {
        a(naVar);
        if (!a_(naVar)) {
            return 6;
        }
        wp.z("TTLiveSDkBridge", "openLive key:" + naVar.dc());
        final String str = map != null ? (String) map.get("event_tag") : "";
        final int iWm = naVar.wm();
        if (!m()) {
            z(naVar, str, iWm, 1, iWm == 7 ? 1 : 2);
            return 1;
        }
        naVar.xn();
        if (this.z == null) {
            return 4;
        }
        this.g = str;
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final long jCurrentTimeMillis = System.currentTimeMillis();
        if (gc() != 2 ? z(naVar, new z() { // from class: com.bytedance.sdk.openadsdk.core.live.z.m.1
            @Override // com.bytedance.sdk.openadsdk.core.live.z.m.z
            public void z(boolean z2) {
                boolean z3;
                if (atomicBoolean.compareAndSet(false, true)) {
                    m mVar = m.this;
                    mVar.z(context, naVar, iWm, mVar.g, (Map<String, Object>) map);
                    z3 = false;
                } else {
                    z3 = true;
                }
                v.z().z(naVar, System.currentTimeMillis() - jCurrentTimeMillis, z2, z3);
            }
        }, true) : false) {
            sv svVarDz = naVar.dz();
            if (svVarDz != null) {
                long jGc = svVarDz.gc();
                if (jGc > 0) {
                    gz.dl().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.live.z.m.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (atomicBoolean.compareAndSet(false, true)) {
                                m.this.z(context, naVar, iWm, str, (Map<String, Object>) map);
                            }
                        }
                    }, jGc);
                }
                if (svVarDz.m() == 1 && uy.ls().a() != null) {
                    new com.bytedance.sdk.openadsdk.core.i.gz().z(new gz.z() { // from class: com.bytedance.sdk.openadsdk.core.live.z.m.3
                        @Override // com.bytedance.sdk.openadsdk.core.i.gz.z
                        public void z(boolean z2) {
                        }

                        @Override // com.bytedance.sdk.openadsdk.core.i.gz.z
                        public void z() {
                            if (atomicBoolean.compareAndSet(false, true)) {
                                m.this.z(context, naVar, iWm, str, (Map<String, Object>) map);
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.core.i.gz.z
                        public void z(String str2) {
                            if (atomicBoolean.compareAndSet(false, true)) {
                                m.this.z(context, naVar, iWm, str, (Map<String, Object>) map);
                            }
                        }
                    });
                }
            }
            return 0;
        }
        return z(context, naVar, iWm, str, map);
    }

    protected boolean z(na naVar, final z zVar, boolean z2) {
        sv svVarDz;
        if (this.gc == null || (svVarDz = naVar.dz()) == null || svVarDz.dl() == 0) {
            return false;
        }
        try {
            if (Integer.parseInt(this.gc.replaceAll("\\.", "")) < 211413) {
                return false;
            }
        } catch (Exception unused) {
        }
        int iG = svVarDz.g();
        boolean z3 = iG > 0;
        if (z2) {
            z3 = iG == 3;
        }
        if (z3) {
            this.m = new SoftReference<>(naVar);
            if (z(new com.bytedance.sdk.openadsdk.core.live.g.g() { // from class: com.bytedance.sdk.openadsdk.core.live.z.m.4
                @Override // com.bytedance.sdk.openadsdk.core.live.g.g
                protected void z(Object obj) {
                    if (obj instanceof Map) {
                        Map map = (Map) obj;
                        if (map.containsKey("code")) {
                            Object obj2 = map.get("code");
                            if (obj2 instanceof String) {
                                try {
                                    int i = Integer.parseInt((String) obj2);
                                    z = i == 1;
                                    wp.z("TTLiveSDkBridge", "requestDyAuth result:".concat(String.valueOf(i)));
                                } catch (NumberFormatException unused2) {
                                }
                            }
                        }
                    }
                    zVar.z(z);
                }
            }, iG == 3) == 1) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int z(Context context, na naVar, int i, String str, Map<String, Object> map) {
        int iDl;
        int iIntValue;
        int i2;
        int i3;
        int i4;
        wp.z("TTLiveSDkBridge", "openLive key:" + naVar.xn());
        if (this.z != null) {
            iDl = 0;
            Object objApply = this.z.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(0).z(Integer.class).z(0, new lq().z(d.R, context).z("bundle", dl(context, naVar, map))).g());
            iIntValue = objApply != null ? ((Integer) objApply).intValue() : 0;
            this.g = str;
            this.f1241a = naVar.dc();
            if (iIntValue == 0) {
                this.m = new SoftReference<>(naVar);
                int iZ = com.bytedance.sdk.openadsdk.core.live.gc.dl.z(map);
                if (iZ == 101 || iZ == 102) {
                    iIntValue |= iZ << 8;
                } else if (z(naVar, iZ)) {
                    iDl = dl(naVar);
                    i = 7;
                    if (iDl == 0) {
                        try {
                            new com.bytedance.sdk.openadsdk.core.live.dl.z().z(str).z(context, naVar);
                            iIntValue |= iZ << 8;
                        } catch (Exception e) {
                            wp.z(e);
                        }
                    } else {
                        i4 = 2;
                        i3 = i4;
                        i2 = i;
                    }
                }
            } else {
                iDl = 3;
            }
            i4 = i;
            i3 = i4;
            i2 = i;
        } else {
            iDl = 1;
            iIntValue = 4;
            i2 = i;
            i3 = i2;
        }
        z(naVar, str, i2, i3, iDl);
        return iIntValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x01cf  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0200 A[Catch: Exception -> 0x02ac, TryCatch #2 {Exception -> 0x02ac, blocks: (B:118:0x01d9, B:120:0x0200, B:121:0x0253, B:123:0x0282, B:124:0x0285, B:126:0x0291, B:127:0x0297), top: B:161:0x01d9 }] */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0282 A[Catch: Exception -> 0x02ac, TryCatch #2 {Exception -> 0x02ac, blocks: (B:118:0x01d9, B:120:0x0200, B:121:0x0253, B:123:0x0282, B:124:0x0285, B:126:0x0291, B:127:0x0297), top: B:161:0x01d9 }] */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0291 A[Catch: Exception -> 0x02ac, TryCatch #2 {Exception -> 0x02ac, blocks: (B:118:0x01d9, B:120:0x0200, B:121:0x0253, B:123:0x0282, B:124:0x0285, B:126:0x0291, B:127:0x0297), top: B:161:0x01d9 }] */
    /* JADX WARN: Removed duplicated region for block: B:133:0x02b6  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x031f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0320  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x02e1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x010d A[Catch: Exception -> 0x011b, TryCatch #4 {Exception -> 0x011b, blocks: (B:67:0x00ed, B:74:0x010d, B:76:0x0117), top: B:165:0x00ed }] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0137  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private android.os.Bundle dl(android.content.Context r23, com.bytedance.sdk.openadsdk.core.iq.na r24, java.util.Map<java.lang.String, java.lang.Object> r25) {
        /*
            Method dump skipped, instruction units count: 868
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.live.z.m.dl(android.content.Context, com.bytedance.sdk.openadsdk.core.iq.na, java.util.Map):android.os.Bundle");
    }

    private void z(JSONArray jSONArray, na naVar) {
        com.bytedance.sdk.openadsdk.core.live.a.z zVar;
        if (naVar == null || jSONArray == null || (zVar = (com.bytedance.sdk.openadsdk.core.live.a.z) io.z(naVar.dc(), com.bytedance.sdk.openadsdk.core.live.a.z.class)) == null || zVar.g.isEmpty()) {
            return;
        }
        String strMj = naVar.mj();
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                if (zVar.g.contains(strMj + "_" + jSONObject.optString("type"))) {
                    jSONObject.put(NotificationCompat.CATEGORY_STATUS, 1);
                }
            } catch (Exception unused) {
            }
        }
    }

    private int gc(na naVar) {
        String strVj = naVar.vj();
        Integer num = (Integer) io.z(naVar.dc(), Integer.class);
        if ((num != null && num.intValue() > 0) || TextUtils.isEmpty(strVj)) {
            return 0;
        }
        try {
            return new JSONObject(strVj).optInt("auth_reward_gold");
        } catch (Throwable th) {
            wp.dl("TTLiveSDkBridge", th);
            return 0;
        }
    }

    public static String z(int i) {
        if (i == 7) {
            return EnterFromMerge.AD_UNION_EXCITATION.lowerName();
        }
        if (i == 8) {
            return EnterFromMerge.AD_UNION_INSERT.lowerName();
        }
        if (i == 5) {
            return EnterFromMerge.AD_UNION_FEED.lowerName();
        }
        if (i == 9) {
            return EnterFromMerge.AD_UNION_DRAW.lowerName();
        }
        return i == 1 ? "ad_union_banner" : (i == 3 || i == 4) ? "ad_union_topview" : i == 2 ? "ad_union_former_insert" : i == 6 ? "ad_union_patch" : EnterFromMerge.NO_VALUE.lowerName();
    }

    public static String g(int i) {
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 6:
            case 7:
            case 8:
            case 9:
                return EnterMethod.LIVE_CELL.lowerName();
            case 5:
                return EnterMethod.LIVE_CARD.lowerName();
            default:
                return EnterMethod.NO_VALUE.lowerName();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001f  */
    @Override // com.bytedance.sdk.openadsdk.core.live.z.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int g(android.content.Context r7, com.bytedance.sdk.openadsdk.core.iq.na r8, java.util.Map<java.lang.String, java.lang.Object> r9) {
        /*
            r6 = this;
            r0 = 0
            if (r9 == 0) goto L1f
            java.lang.String r2 = "reward_countdown"
            java.lang.Object r2 = r9.get(r2)     // Catch: java.lang.Exception -> L15
            boolean r3 = r2 instanceof java.lang.Long     // Catch: java.lang.Exception -> L15
            if (r3 == 0) goto L1f
            java.lang.Long r2 = (java.lang.Long) r2     // Catch: java.lang.Exception -> L15
            long r2 = r2.longValue()     // Catch: java.lang.Exception -> L15
            goto L20
        L15:
            r2 = move-exception
            java.lang.String r3 = "TTLiveSDkBridge"
            java.lang.String r2 = r2.toString()
            com.bytedance.sdk.component.utils.wp.g(r3, r2)
        L1f:
            r2 = r0
        L20:
            r4 = 5
            if (r7 == 0) goto L49
            if (r8 != 0) goto L26
            goto L49
        L26:
            boolean r5 = r7 instanceof android.app.Activity
            if (r5 != 0) goto L2c
            r7 = 7
            return r7
        L2c:
            boolean r5 = com.bytedance.sdk.openadsdk.core.iq.ec.z(r8)
            if (r5 != 0) goto L33
            return r4
        L33:
            int r0 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r0 >= 0) goto L3a
            r7 = 8
            return r7
        L3a:
            int r0 = com.bytedance.sdk.openadsdk.core.iq.ec.g(r8)
            r1 = 1
            if (r0 != r1) goto L44
            r7 = 9
            return r7
        L44:
            int r7 = r6.z(r7, r8, r9)
            return r7
        L49:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.live.z.m.g(android.content.Context, com.bytedance.sdk.openadsdk.core.iq.na, java.util.Map):int");
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.z.a
    public boolean z(na naVar) {
        return a_(naVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.z.a
    public String e() {
        return this.gc;
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.z.a
    public int z(String str) {
        if (TextUtils.isEmpty(str)) {
            return 10;
        }
        if (this.z == null) {
            return 12;
        }
        if (!m()) {
            return 11;
        }
        Object objZx = uy.ls().zx();
        if (objZx == null) {
            return 13;
        }
        try {
            Object objApply = this.z.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(8).z(Boolean.class).z(0, new lq().z(d.R, objZx).z("scheme_uri", str)).g());
            return objApply != null ? ((Boolean) objApply).booleanValue() : false ? 1 : 10;
        } catch (Exception unused) {
            return 14;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.z.a
    public int z(com.bytedance.sdk.openadsdk.core.live.g.g gVar, boolean z2) {
        if (this.z == null) {
            return 12;
        }
        if (!m()) {
            return 11;
        }
        HashMap map = new HashMap();
        map.put("expand_method_name", "requestDyAuth");
        map.put("expand_method_param", new Object[]{uy.ls().zx(), gVar, Boolean.valueOf(z2)});
        wp.z("TTLiveSDkBridge", "requestDyAuth:" + this.z.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(7).z(Void.class).z(0, map).g()) + ", syncAuth = " + z2);
        return 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.z.z, com.bytedance.sdk.openadsdk.core.live.z.a
    public void z(String str, na naVar, long j) {
        com.bytedance.sdk.openadsdk.core.video.dl.z.z(str, naVar, j);
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.z.a
    public void z(String str, boolean z2) {
        if (this.z != null && m()) {
            HashMap map = new HashMap();
            map.put("expand_method_name", str);
            map.put("expand_method_param", new Object[]{Boolean.valueOf(z2)});
            this.z.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(7).z(Void.class).z(0, map).g());
        }
    }
}
