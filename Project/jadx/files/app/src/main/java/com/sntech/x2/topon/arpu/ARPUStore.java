package com.sntech.x2.topon.arpu;

import androidx.annotation.Keep;
import com.bytedance.msdk.adapter.pangle.PangleAdapterUtils;
import com.bytedance.msdk.adapter.util.TTLogUtil;
import com.google.gson.Gson;
import com.sntech.x2.topon.strategy.ARPUStrategy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import r.c;
import r.e;

/* JADX INFO: loaded from: classes3.dex */
public class ARPUStore {

    /* JADX INFO: renamed from: do, reason: not valid java name */
    public ARPUStat f138do;

    /* JADX INFO: renamed from: for, reason: not valid java name */
    public Object f139for = new Object();

    /* JADX INFO: renamed from: if, reason: not valid java name */
    public ARPUStat f140if;

    @Keep
    public static class ARPUStat {

        @Keep
        public String date;

        @Keep
        public Map<String, PlatformARPUStat> platformArpu = new HashMap();

        @Keep
        public Map<String, PlatformStat> slotTypePlatform = new HashMap();

        @Keep
        public Map<String, PlatformStat> placementPlatform = new HashMap();
    }

    @Keep
    public static class PlatformARPUStat {

        @Keep
        public Map<String, Double> slotTypeArpu = new HashMap();

        @Keep
        public Map<String, Integer> slotTypeShow = new HashMap();

        @Keep
        public double totalArpu = PangleAdapterUtils.CPM_DEFLAUT_VALUE;
    }

    @Keep
    public static class PlatformStat {

        @Keep
        public Map<String, Integer> platformState = new HashMap();
    }

    /* JADX INFO: renamed from: do, reason: not valid java name */
    public final synchronized ARPUStat m156do() {
        if (this.f138do == null) {
            String strA = c.a("arpu_stat", null);
            if (strA == null) {
                ARPUStat aRPUStat = new ARPUStat();
                this.f138do = aRPUStat;
                aRPUStat.date = e.a();
            } else {
                this.f138do = (ARPUStat) new Gson().fromJson(strA, ARPUStat.class);
            }
        }
        String strA2 = e.a();
        if (!strA2.equals(this.f138do.date)) {
            ARPUStat aRPUStat2 = this.f138do;
            synchronized (this) {
                ARPUStat aRPUStatM160if = m160if();
                if (!strA2.equals(aRPUStatM160if.date)) {
                    aRPUStatM160if.date = strA2;
                    for (String str : aRPUStat2.platformArpu.keySet()) {
                        PlatformARPUStat platformARPUStat = aRPUStat2.platformArpu.get(str);
                        PlatformARPUStat platformARPUStat2 = aRPUStatM160if.platformArpu.get(str);
                        if (platformARPUStat2 != null) {
                            for (String str2 : platformARPUStat.slotTypeArpu.keySet()) {
                                Map<String, Double> map = platformARPUStat2.slotTypeArpu;
                                Double d2 = map.get(str2);
                                Double d3 = platformARPUStat.slotTypeArpu.get(str2);
                                double dDoubleValue = PangleAdapterUtils.CPM_DEFLAUT_VALUE;
                                double dDoubleValue2 = d2 == null ? 0.0d : d2.doubleValue();
                                if (d3 != null) {
                                    dDoubleValue = d3.doubleValue();
                                }
                                map.put(str2, Double.valueOf(dDoubleValue2 + dDoubleValue));
                            }
                            for (String str3 : platformARPUStat.slotTypeShow.keySet()) {
                                Map<String, Integer> map2 = platformARPUStat2.slotTypeShow;
                                Integer num = map2.get(str3);
                                Integer num2 = platformARPUStat.slotTypeShow.get(str3);
                                int iIntValue = 0;
                                int iIntValue2 = num == null ? 0 : num.intValue();
                                if (num2 != null) {
                                    iIntValue = num2.intValue();
                                }
                                map2.put(str3, Integer.valueOf(iIntValue2 + iIntValue));
                            }
                            platformARPUStat2.totalArpu += platformARPUStat.totalArpu;
                        } else {
                            PlatformARPUStat platformARPUStat3 = new PlatformARPUStat();
                            platformARPUStat3.slotTypeArpu.putAll(platformARPUStat.slotTypeArpu);
                            platformARPUStat3.slotTypeShow.putAll(platformARPUStat.slotTypeShow);
                            platformARPUStat3.totalArpu = platformARPUStat.totalArpu;
                            aRPUStatM160if.platformArpu.put(str, platformARPUStat3);
                        }
                    }
                    synchronized (this) {
                        c.b("arpu_stat_global", new Gson().toJson(aRPUStatM160if));
                    }
                }
            }
            ARPUStat aRPUStat3 = new ARPUStat();
            this.f138do = aRPUStat3;
            aRPUStat3.date = e.a();
        }
        return this.f138do;
    }

    /* JADX INFO: renamed from: if, reason: not valid java name */
    public final synchronized ARPUStat m160if() {
        if (this.f140if == null) {
            String strA = c.a("arpu_stat_global", null);
            if (strA == null) {
                this.f140if = new ARPUStat();
            } else {
                this.f140if = (ARPUStat) new Gson().fromJson(strA, ARPUStat.class);
            }
        }
        return this.f140if;
    }

    /* JADX INFO: renamed from: do, reason: not valid java name */
    public final synchronized void m158do(ARPUStat aRPUStat) {
        c.b("arpu_stat", new Gson().toJson(aRPUStat));
    }

    /* JADX INFO: renamed from: do, reason: not valid java name */
    public boolean m159do(ARPUStrategy aRPUStrategy, String str, String str2, List<String> list) {
        ARPUStrategy aRPUStrategy2;
        int iIntValue;
        PlatformARPUStat platformARPUStat = m156do().platformArpu.get(str);
        if (platformARPUStat == null) {
            return false;
        }
        double d2 = platformARPUStat.totalArpu;
        Map<String, Double> map = platformARPUStat.slotTypeArpu;
        double dDoubleValue = (map == null || map.get(str2) == null) ? 0.0d : platformARPUStat.slotTypeArpu.get(str2).doubleValue();
        Map<String, Integer> map2 = platformARPUStat.slotTypeShow;
        if (map2 == null || map2.get(str2) == null) {
            aRPUStrategy2 = aRPUStrategy;
            iIntValue = 0;
        } else {
            iIntValue = platformARPUStat.slotTypeShow.get(str2).intValue();
            aRPUStrategy2 = aRPUStrategy;
        }
        List<ARPUStrategy.PlatformArpu> list2 = aRPUStrategy2.platformArpu;
        if (list2 == null) {
            return false;
        }
        for (ARPUStrategy.PlatformArpu platformArpu : list2) {
            if (platformArpu.platform.equals(str)) {
                Map<String, Double> map3 = platformArpu.slotTypeArpu;
                Double d3 = map3 != null ? map3.get(str2) : null;
                Map<String, Integer> map4 = platformArpu.slotTypeShow;
                Integer num = map4 != null ? map4.get(str2) : null;
                if (d3 != null && dDoubleValue >= d3.doubleValue()) {
                    list.add(aRPUStrategy.m173do(str, str2, dDoubleValue, iIntValue, d2, platformArpu, "slotTypeTotalArpu reach target"));
                } else if (num != null && iIntValue >= num.intValue()) {
                    list.add(aRPUStrategy.m173do(str, str2, dDoubleValue, iIntValue, d2, platformArpu, "slotTypeTotalShow reach target"));
                } else {
                    double d4 = platformArpu.totalArpu;
                    if (d4 != PangleAdapterUtils.CPM_DEFLAUT_VALUE && d2 >= d4) {
                        list.add(aRPUStrategy.m173do(str, str2, dDoubleValue, iIntValue, d2, platformArpu, "platformTotalArpu reach target"));
                    }
                }
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: do, reason: not valid java name */
    public JSONObject m157do(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        ARPUStat aRPUStatM156do = m156do();
        if (aRPUStatM156do.platformArpu == null) {
            return jSONObject;
        }
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        for (String str2 : aRPUStatM156do.platformArpu.keySet()) {
            PlatformARPUStat platformARPUStat = aRPUStatM156do.platformArpu.get(str2);
            if (platformARPUStat != null) {
                Map<String, Double> map = platformARPUStat.slotTypeArpu;
                if (map != null && map.get(str) != null) {
                    jSONObject3.put(str2, platformARPUStat.slotTypeArpu.get(str));
                }
                Map<String, Integer> map2 = platformARPUStat.slotTypeShow;
                if (map2 != null && map2.get(str) != null) {
                    jSONObject2.put(str2, platformARPUStat.slotTypeShow.get(str));
                }
            }
        }
        jSONObject.put(TTLogUtil.TAG_EVENT_SHOW, jSONObject2);
        jSONObject.put("arpu", jSONObject3);
        return jSONObject;
    }

    /* JADX INFO: renamed from: do, reason: not valid java name */
    public int m155do(String str, String str2) {
        ARPUStat aRPUStatM156do = m156do();
        Map<String, PlatformARPUStat> map = aRPUStatM156do.platformArpu;
        if (map == null || !map.containsKey(str)) {
            return 0;
        }
        PlatformARPUStat platformARPUStat = aRPUStatM156do.platformArpu.get(str);
        if (platformARPUStat.slotTypeShow.containsKey(str2)) {
            return platformARPUStat.slotTypeShow.get(str2).intValue();
        }
        return 0;
    }
}
