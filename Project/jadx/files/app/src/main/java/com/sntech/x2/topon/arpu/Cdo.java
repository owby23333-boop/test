package com.sntech.x2.topon.arpu;

import android.text.TextUtils;
import com.anythink.core.api.ATSDK;
import com.bytedance.msdk.adapter.pangle.PangleAdapterUtils;
import com.sntech.event.SNEvent;
import com.sntech.x2.topon.arpu.ARPUStore;
import com.sntech.x2.topon.strategy.ARPUStrategy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import z0.o;

/* JADX INFO: renamed from: com.sntech.x2.topon.arpu.do, reason: invalid class name */
/* JADX INFO: compiled from: ARPUController.java */
/* JADX INFO: loaded from: classes3.dex */
public class Cdo {

    /* JADX INFO: renamed from: if, reason: not valid java name */
    public static Cdo f141if;

    /* JADX INFO: renamed from: do, reason: not valid java name */
    public ARPUStore f142do = new ARPUStore();

    /* JADX INFO: renamed from: do, reason: not valid java name */
    public static Cdo m161do() {
        if (f141if == null) {
            synchronized (Cdo.class) {
                if (f141if == null) {
                    f141if = new Cdo();
                }
            }
        }
        return f141if;
    }

    /* JADX INFO: renamed from: if, reason: not valid java name */
    public void m167if() {
        if (this.f142do.m156do().placementPlatform != null && m170new()) {
            for (String str : this.f142do.m156do().placementPlatform.keySet()) {
                ARPUStore.PlatformStat platformStat = this.f142do.m156do().placementPlatform.get(str);
                HashMap map = new HashMap();
                map.putAll(platformStat.platformState);
                ATSDK.initPlacementCustomMap(str, map);
            }
        }
        new Thread(new Runnable() { // from class: com.sntech.x2.topon.arpu.b
            @Override // java.lang.Runnable
            public final void run() {
                x.a.b().a();
            }
        }).start();
    }

    /* JADX INFO: renamed from: new, reason: not valid java name */
    public final boolean m170new() {
        try {
            Class.forName("com.anythink.core.api.ATSDK");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0050  */
    /* JADX INFO: renamed from: do, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m164do(java.lang.String r8, java.lang.String r9) {
        /*
            r7 = this;
            x.a r0 = x.a.b()
            com.sntech.x2.topon.strategy.ARPUStrategy r0 = r0.a
            if (r0 == 0) goto La1
            java.lang.String[] r1 = r0.supportedPlatforms
            if (r1 == 0) goto La1
            java.util.Map<java.lang.String, java.lang.String> r1 = r0.slotTypeHeadPlatform
            if (r1 == 0) goto La1
            boolean r1 = r1.containsKey(r8)
            if (r1 == 0) goto La1
            java.util.Map<java.lang.String, java.lang.String> r1 = r0.slotTypeHeadPlatform
            java.lang.Object r1 = r1.get(r8)
            java.lang.String r1 = (java.lang.String) r1
            com.sntech.x2.topon.arpu.ARPUStore r2 = r7.f142do
            com.sntech.x2.topon.arpu.ARPUStore$ARPUStat r3 = r2.m160if()
            java.util.Map<java.lang.String, com.sntech.x2.topon.arpu.ARPUStore$PlatformARPUStat> r4 = r3.platformArpu
            if (r4 == 0) goto L50
            boolean r4 = r4.containsKey(r1)
            if (r4 == 0) goto L50
            java.util.Map<java.lang.String, com.sntech.x2.topon.arpu.ARPUStore$PlatformARPUStat> r3 = r3.platformArpu
            java.lang.Object r3 = r3.get(r1)
            com.sntech.x2.topon.arpu.ARPUStore$PlatformARPUStat r3 = (com.sntech.x2.topon.arpu.ARPUStore.PlatformARPUStat) r3
            java.util.Map<java.lang.String, java.lang.Integer> r4 = r3.slotTypeShow
            boolean r4 = r4.containsKey(r8)
            if (r4 == 0) goto L50
            java.util.Map<java.lang.String, java.lang.Integer> r3 = r3.slotTypeShow
            java.lang.Object r3 = r3.get(r8)
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            int r2 = r2.m155do(r1, r8)
            int r2 = r2 + r3
            goto L54
        L50:
            int r2 = r2.m155do(r1, r8)
        L54:
            if (r2 > 0) goto La1
            java.util.HashMap r2 = new java.util.HashMap
            java.lang.String[] r3 = r0.supportedPlatforms
            int r3 = r3.length
            r2.<init>(r3)
            java.lang.String[] r0 = r0.supportedPlatforms
            int r3 = r0.length
            r4 = 0
        L62:
            if (r4 >= r3) goto L74
            r5 = r0[r4]
            boolean r6 = r5.equals(r1)
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            r2.put(r5, r6)
            int r4 = r4 + 1
            goto L62
        L74:
            java.util.ArrayList r0 = new java.util.ArrayList
            r3 = 1
            r0.<init>(r3)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "CheckHeadPlatform: slotType="
            r3.append(r4)
            r3.append(r8)
            java.lang.String r4 = " platform = "
            r3.append(r4)
            r3.append(r1)
            java.lang.String r1 = " placementId = "
            r3.append(r1)
            r3.append(r9)
            java.lang.String r1 = r3.toString()
            r0.add(r1)
            r7.m165do(r9, r8, r2, r0)
        La1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sntech.x2.topon.arpu.Cdo.m164do(java.lang.String, java.lang.String):void");
    }

    /* JADX INFO: renamed from: if, reason: not valid java name */
    public void m168if(final SNEvent.AdPlatform adPlatform, final SNEvent.AdType adType, final String str, final String str2, final double d2) {
        new Thread(new Runnable() { // from class: com.sntech.x2.topon.arpu.a
            @Override // java.lang.Runnable
            public final void run() {
                this.f17918s.m162do(adPlatform, adType, str, str2, d2);
            }
        }).start();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("platform", adPlatform);
            jSONObject.put("slotType", adType);
            jSONObject.put("supportTopOn", m170new());
            jSONObject.put(com.anythink.expressad.videocommon.e.b.f12232v, str);
            jSONObject.put("adId", str2);
            jSONObject.put("ecpm", d2);
        } catch (JSONException unused) {
        }
        o.a().a("PLATFORM_AD_SHOWN", jSONObject);
    }

    /* JADX INFO: renamed from: do, reason: not valid java name */
    public boolean m166do(SNEvent.AdPlatform adPlatform, SNEvent.AdType adType) {
        ARPUStore aRPUStore = this.f142do;
        String string = adPlatform.toString();
        String string2 = adType.toString();
        ARPUStore.ARPUStat aRPUStatM156do = aRPUStore.m156do();
        Map<String, ARPUStore.PlatformStat> map = aRPUStatM156do.slotTypePlatform;
        if (map == null || map.get(string2) == null) {
            return true;
        }
        ARPUStore.PlatformStat platformStat = aRPUStatM156do.slotTypePlatform.get(string2);
        return platformStat.platformState.get(string) == null || platformStat.platformState.get(string).intValue() == 1;
    }

    /* JADX INFO: renamed from: if, reason: not valid java name */
    public final void m169if(String str, String str2, Map<String, Integer> map, List<String> list) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(com.anythink.expressad.videocommon.e.b.f12232v, str);
            jSONObject.put("slotType", str2);
            for (String str3 : map.keySet()) {
                jSONObject.put(str3, map.get(str3));
            }
            jSONObject.put("slotTypeStat", this.f142do.m157do(str2));
            if (list != null && !list.isEmpty()) {
                jSONObject.put("reasons", new JSONArray((Collection) list));
            }
        } catch (JSONException unused) {
        }
        o.a().a("PLATFORM_STATE_CHANGED", jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: do, reason: not valid java name */
    public void m162do(SNEvent.AdPlatform adPlatform, SNEvent.AdType adType, String str, String str2, double d2) {
        boolean z2;
        String[] strArr;
        boolean z3;
        String string = adPlatform.toString();
        String string2 = adType.toString();
        ARPUStrategy aRPUStrategyA = x.a.b().a();
        double dM172do = aRPUStrategyA == null ? d2 : aRPUStrategyA.m172do(string, string2, str2, d2);
        ARPUStore aRPUStore = this.f142do;
        synchronized (aRPUStore.f139for) {
            ARPUStore.ARPUStat aRPUStatM156do = aRPUStore.m156do();
            if (aRPUStatM156do.platformArpu.get(string) == null) {
                aRPUStatM156do.platformArpu.put(string, new ARPUStore.PlatformARPUStat());
            }
            ARPUStore.PlatformARPUStat platformARPUStat = aRPUStatM156do.platformArpu.get(string);
            double dDoubleValue = platformARPUStat.slotTypeArpu.get(string2) != null ? platformARPUStat.slotTypeArpu.get(string2).doubleValue() : PangleAdapterUtils.CPM_DEFLAUT_VALUE;
            int iIntValue = platformARPUStat.slotTypeShow.get(string2) != null ? platformARPUStat.slotTypeShow.get(string2).intValue() : 0;
            double d3 = dM172do / 1000.0d;
            platformARPUStat.slotTypeArpu.put(string2, Double.valueOf(dDoubleValue + d3));
            z2 = true;
            platformARPUStat.slotTypeShow.put(string2, Integer.valueOf(iIntValue + 1));
            platformARPUStat.totalArpu += d3;
            aRPUStore.m158do(aRPUStatM156do);
        }
        if (aRPUStrategyA == null || (strArr = aRPUStrategyA.supportedPlatforms) == null) {
            return;
        }
        ArrayList arrayList = new ArrayList(strArr.length);
        ARPUStore aRPUStore2 = this.f142do;
        aRPUStore2.getClass();
        List<ARPUStrategy.MultiPlatformArpu> list = aRPUStrategyA.multiPlatformArpu;
        if (list == null || list.size() == 0) {
            z3 = false;
        } else {
            ARPUStore.ARPUStat aRPUStatM156do2 = aRPUStore2.m156do();
            for (ARPUStrategy.MultiPlatformArpu multiPlatformArpu : aRPUStrategyA.multiPlatformArpu) {
                int iIntValue2 = 0;
                for (String str3 : multiPlatformArpu.platforms) {
                    if (aRPUStatM156do2.platformArpu.containsKey(str3) && aRPUStatM156do2.platformArpu.get(str3).slotTypeShow.containsKey(string2)) {
                        iIntValue2 += aRPUStatM156do2.platformArpu.get(str3).slotTypeShow.get(string2).intValue();
                    }
                }
                if (multiPlatformArpu.slotTypeShow.get(string2) != null && iIntValue2 > multiPlatformArpu.slotTypeShow.get(string2).intValue()) {
                    arrayList.add("MultiPlatformArpuReachTarget: slotType=" + string2 + " multiTotalShow=" + iIntValue2 + " targetShow=" + multiPlatformArpu.slotTypeShow.get(string2));
                    z3 = true;
                    break;
                }
            }
            z3 = false;
        }
        HashMap map = new HashMap(aRPUStrategyA.supportedPlatforms.length);
        for (String str4 : aRPUStrategyA.supportedPlatforms) {
            map.put(str4, Integer.valueOf((z3 || this.f142do.m159do(aRPUStrategyA, str4, string2, arrayList)) ? 0 : 1));
        }
        if (!TextUtils.isEmpty(str)) {
            m165do(str, string2, map, arrayList);
        }
        ARPUStore aRPUStore3 = this.f142do;
        synchronized (aRPUStore3.f139for) {
            ARPUStore.ARPUStat aRPUStatM156do3 = aRPUStore3.m156do();
            ARPUStore.PlatformStat platformStat = aRPUStatM156do3.slotTypePlatform.get(string2);
            if (platformStat == null || !platformStat.platformState.equals(map)) {
                if (platformStat == null) {
                    platformStat = new ARPUStore.PlatformStat();
                    platformStat.platformState = new HashMap();
                    aRPUStatM156do3.slotTypePlatform.put(string2, platformStat);
                }
                platformStat.platformState.putAll(map);
                aRPUStore3.m158do(aRPUStatM156do3);
            } else {
                z2 = false;
            }
        }
        if (z2) {
            m169if(null, string2, map, arrayList);
        }
    }

    /* JADX INFO: renamed from: do, reason: not valid java name */
    public final void m165do(String str, String str2, Map<String, Integer> map, List<String> list) {
        boolean z2;
        ARPUStore aRPUStore = this.f142do;
        synchronized (aRPUStore.f139for) {
            ARPUStore.ARPUStat aRPUStatM156do = aRPUStore.m156do();
            if (aRPUStatM156do.placementPlatform == null) {
                aRPUStatM156do.placementPlatform = new HashMap();
            }
            ARPUStore.PlatformStat platformStat = aRPUStatM156do.placementPlatform.get(str);
            if (platformStat == null || !platformStat.platformState.equals(map)) {
                if (platformStat == null) {
                    platformStat = new ARPUStore.PlatformStat();
                    platformStat.platformState = new HashMap();
                    aRPUStatM156do.placementPlatform.put(str, platformStat);
                }
                platformStat.platformState.putAll(map);
                aRPUStore.m158do(aRPUStatM156do);
                z2 = true;
            } else {
                z2 = false;
            }
        }
        if (z2 && m170new()) {
            HashMap map2 = new HashMap();
            map2.putAll(map);
            ATSDK.initPlacementCustomMap(str, map2);
            m169if(str, str2, map, list);
        }
    }
}
