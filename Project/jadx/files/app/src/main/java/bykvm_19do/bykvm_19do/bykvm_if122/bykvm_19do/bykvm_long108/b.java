package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108;

import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.e;
import com.bytedance.notpluginpro.tmapcloaknotplugin;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets/notplugmapnaveinfoox111.dex
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile b f1570d;
    private final Map<String, double[]> a = new ConcurrentHashMap();
    private final Map<String, double[]> b = new ConcurrentHashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map<String, String> f1571c = new HashMap();

    private b() {
        b();
    }

    public static String a() {
        return (String) tmapcloaknotplugin.obj_bytedance_call_notplugin(2, 1, new Object[0]);
    }

    private String a(String str) {
        return (String) tmapcloaknotplugin.obj_bytedance_call_notplugin(3, 0, this, str);
    }

    private String a(double[] dArr) {
        return (String) tmapcloaknotplugin.obj_bytedance_call_notplugin(4, 0, this, dArr);
    }

    private Map<String, JSONObject> a(String str, double[] dArr) {
        return (Map) tmapcloaknotplugin.obj_bytedance_call_notplugin(5, 0, this, str, dArr);
    }

    private JSONObject a(e eVar) {
        return (JSONObject) tmapcloaknotplugin.obj_bytedance_call_notplugin(6, 0, this, eVar);
    }

    private void b() {
        tmapcloaknotplugin.voi_bytedance_call_notplugin(7, 0, this);
    }

    private void b(JSONObject jSONObject) {
        tmapcloaknotplugin.voi_bytedance_call_notplugin(8, 0, this, jSONObject);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0018  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0013  */
    /*  JADX ERROR: UnsupportedOperationException in pass: RegionMakerVisitor
        java.lang.UnsupportedOperationException
        	at java.base/java.util.Collections$UnmodifiableCollection.add(Unknown Source)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker$1.leaveRegion(SwitchRegionMaker.java:390)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:70)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:23)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaksForCase(SwitchRegionMaker.java:370)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaks(SwitchRegionMaker.java:85)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.leaveRegion(PostProcessRegions.java:33)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:70)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.process(PostProcessRegions.java:23)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:31)
        */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108.b c() {
        /*
            java.lang.Class<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108.b> r0 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108.b.class
        L2:
            r1 = 74
            r2 = 55
        L6:
            switch(r1) {
                case 72: goto L2;
                case 73: goto Lc;
                case 74: goto Lf;
                default: goto L9;
            }
        L9:
            r1 = 72
            goto L6
        Lc:
            switch(r2) {
                case 94: goto L1d;
                case 95: goto L18;
                case 96: goto L22;
                default: goto Lf;
            }
        Lf:
            r1 = 56
            if (r2 == r1) goto L2
            r1 = 57
            if (r2 == r1) goto L18
            goto L1d
        L18:
            r1 = 1
            switch(r1) {
                case 60: goto L2;
                case 61: goto L1d;
                case 62: goto L2;
                default: goto L1c;
            }
        L1c:
            goto L22
        L1d:
            r1 = 73
            r2 = 96
            goto L6
        L22:
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108.b r1 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108.b.f1570d
            if (r1 != 0) goto L37
            monitor-enter(r0)
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108.b r1 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108.b.f1570d     // Catch: java.lang.Throwable -> L34
            if (r1 != 0) goto L32
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108.b r1 = new bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108.b     // Catch: java.lang.Throwable -> L34
            r1.<init>()     // Catch: java.lang.Throwable -> L34
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108.b.f1570d = r1     // Catch: java.lang.Throwable -> L34
        L32:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L34
            goto L37
        L34:
            r1 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L34
            throw r1
        L37:
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108.b r0 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108.b.f1570d
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108.b.c():bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108.b");
    }

    public static String c(int i2) {
        return (String) tmapcloaknotplugin.obj_bytedance_call_notplugin(9, 1, Integer.valueOf(i2));
    }

    public Map<String, JSONObject> a(int i2) {
        return (Map) tmapcloaknotplugin.obj_bytedance_call_notplugin(10, 0, this, Integer.valueOf(i2));
    }

    public void a(int i2, double d2) {
        tmapcloaknotplugin.voi_bytedance_call_notplugin(11, 0, this, Integer.valueOf(i2), Double.valueOf(d2));
    }

    public void a(Map<String, Map<String, List<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.e>>> map) {
        tmapcloaknotplugin.voi_bytedance_call_notplugin(12, 0, this, map);
    }

    public void a(JSONObject jSONObject) {
        tmapcloaknotplugin.voi_bytedance_call_notplugin(13, 0, this, jSONObject);
    }

    public void a(JSONObject jSONObject, JSONObject jSONObject2) {
        tmapcloaknotplugin.voi_bytedance_call_notplugin(14, 0, this, jSONObject, jSONObject2);
    }

    public void a(boolean z2, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.d dVar, JSONObject jSONObject, Map<String, Object> map) {
        tmapcloaknotplugin.voi_bytedance_call_notplugin(15, 0, this, Boolean.valueOf(z2), dVar, jSONObject, map);
    }

    public void b(int i2) {
        tmapcloaknotplugin.voi_bytedance_call_notplugin(16, 0, this, Integer.valueOf(i2));
    }

    public void b(int i2, double d2) {
        tmapcloaknotplugin.voi_bytedance_call_notplugin(17, 0, this, Integer.valueOf(i2), Double.valueOf(d2));
    }
}
