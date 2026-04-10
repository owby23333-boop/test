package com.bytedance.msdk.core.gz;

import android.text.TextUtils;
import android.util.Pair;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class i {
    private Map<String, Pair<String, String>> g;
    private Map<String, Long> z;

    private i() {
        g();
    }

    public static i z() {
        return z.z;
    }

    private static class z {
        private static i z = new i();
    }

    public void g() {
        this.g = new ConcurrentHashMap();
        this.z = new ConcurrentHashMap();
    }

    public long z(String str) {
        Long l = this.z.get(str);
        if (l == null) {
            return -2L;
        }
        return l.longValue();
    }

    public void g(final String str) {
        com.bytedance.msdk.z.gc.m.z(new Runnable() { // from class: com.bytedance.msdk.core.gz.i.1
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.msdk.z.gc.dl.z("TTMediationSDK_IntervalShowControl", "updateShowPacingTime ritId = " + str);
                fo foVarGc = i.this.gc(str);
                if (foVarGc == null || !foVarGc.gz()) {
                    return;
                }
                Date date = new Date();
                com.bytedance.msdk.z.gc.dl.z("TTMediationSDK_IntervalShowControl", "updateShowPacingTime save time = " + m.g(date.getTime()));
                i.this.z(str, date.getTime());
            }
        });
    }

    public boolean dl(String str) {
        fo foVarGc = gc(str);
        if (foVarGc != null && foVarGc.gz() && foVarGc.wp()) {
            long time = new Date().getTime();
            long jKb = foVarGc.kb();
            long jKb2 = foVarGc.kb() + foVarGc.fo();
            com.bytedance.msdk.z.gc.dl.z("TTMediationSDK_IntervalShowControl", "checkPacing currentTime = " + m.g(time) + " showTime = " + m.g(jKb) + " pacingBean.getPacing() = " + foVarGc.fo() + " pacingTime = " + m.g(jKb2));
            if (time <= jKb2) {
                this.z.put(str, Long.valueOf(time - jKb));
                return false;
            }
        }
        return true;
    }

    public boolean z(fo foVar) {
        if (foVar == null) {
            return false;
        }
        fo foVarGc = gc(foVar.g());
        if (foVarGc == null) {
            com.bytedance.msdk.z.gc.dl.z("TTMediationSDK_IntervalShowControl", "pacing 规则为空直接存储");
            return true;
        }
        if (TextUtils.isEmpty(foVar.uy())) {
            com.bytedance.msdk.z.gc.dl.z("TTMediationSDK_IntervalShowControl", "pacing ruleId 为空 清空本地数据 ");
            a(foVar.a());
            return false;
        }
        if (TextUtils.equals(foVarGc.uy(), foVar.uy())) {
            com.bytedance.msdk.z.gc.dl.z("TTMediationSDK_IntervalShowControl", "pacing ruleId 一致 ruleId = " + foVarGc.uy() + " 无需处理");
            return false;
        }
        com.bytedance.msdk.z.gc.dl.z("TTMediationSDK_IntervalShowControl", "pacing ruleId不一致，缓存新规则 old ruleId = " + foVarGc.uy() + "  new ruleId = " + foVar.uy());
        com.bytedance.msdk.z.gc.dl.z("TTMediationSDK_IntervalShowControl", "pacing 删除 ritId = " + foVar.a());
        a(foVar.a());
        return true;
    }

    public void z(String str, long j) {
        uy.z().z(str, j);
    }

    public void a(String str) {
        uy.z().z(str);
    }

    public void g(fo foVar) {
        uy.z().z(foVar);
    }

    public fo gc(String str) {
        return uy.z().g(str);
    }

    public Pair<String, String> m(String str) {
        return this.g.get(str);
    }

    public void e(final String str) {
        com.bytedance.msdk.z.gc.m.z(new Runnable() { // from class: com.bytedance.msdk.core.gz.i.2
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.msdk.z.gc.dl.z("TTMediationSDK_IntervalShowControl", "addShowFreqctlCount ritId = " + str);
                e eVarUy = i.this.uy(str);
                if (eVarUy == null || !eVarUy.gz()) {
                    return;
                }
                for (gc gcVar : eVarUy.kb()) {
                    if (gcVar.gc() < gcVar.z()) {
                        i.this.z(eVarUy, gcVar.dl(), gcVar.gc() + 1);
                    }
                }
            }
        });
    }

    public boolean gz(String str) {
        e eVarUy = uy(str);
        if (eVarUy == null || !eVarUy.gz()) {
            return true;
        }
        for (gc gcVar : eVarUy.kb()) {
            Date date = new Date();
            com.bytedance.msdk.z.gc.dl.z("TTMediationSDK_IntervalShowControl", "checkFreqctl date = " + date.getTime() + " item.getEffectiveTime() = " + gcVar.a());
            if (date.getTime() <= gcVar.a()) {
                if (gcVar.gc() < gcVar.z()) {
                    com.bytedance.msdk.z.gc.dl.z("TTMediationSDK_IntervalShowControl", "checkFreqctl 未到上线可以展示 ruleId = " + gcVar.dl() + " count = " + gcVar.gc());
                } else {
                    com.bytedance.msdk.z.gc.dl.z("TTMediationSDK_IntervalShowControl", "checkFreqctl 到了上线不可以展示 ruleId = " + gcVar.dl() + " count = " + gcVar.gc());
                    this.g.put(str, new Pair<>(gcVar.dl(), new StringBuilder().append(gcVar.gc()).toString()));
                    return false;
                }
            } else {
                z(eVarUy, gcVar.dl(), 0);
                z(eVarUy, gcVar.dl(), m.z(gcVar.g()));
                com.bytedance.msdk.z.gc.dl.z("TTMediationSDK_IntervalShowControl", "checkFreqctl 有效期外计数需要清0，过期时间需要更新 = " + gcVar.dl());
            }
        }
        return true;
    }

    public boolean z(e eVar) {
        if (eVar == null) {
            return false;
        }
        e eVarUy = uy(eVar.g());
        if (eVarUy == null) {
            com.bytedance.msdk.z.gc.dl.z("TTMediationSDK_IntervalShowControl", "freqctl 规则为空直接存储");
            return true;
        }
        if (TextUtils.isEmpty(eVar.gc())) {
            com.bytedance.msdk.z.gc.dl.z("TTMediationSDK_IntervalShowControl", "freqctl version 为空 清空本地数据 ");
            fo(eVarUy.g());
            return false;
        }
        if (TextUtils.equals(eVarUy.gc(), eVar.gc())) {
            com.bytedance.msdk.z.gc.dl.z("TTMediationSDK_IntervalShowControl", "freqctl version 一致 version = " + eVarUy.gc() + "无需处理");
            return false;
        }
        com.bytedance.msdk.z.gc.dl.z("TTMediationSDK_IntervalShowControl", "freqctl version不一致，缓存新规则 old version = " + eVarUy.gc() + "  new version " + eVar.gc());
        return true;
    }

    public void fo(String str) {
        gz.z().z(str);
    }

    public void g(e eVar) {
        gz.z().z(eVar);
    }

    public e uy(String str) {
        return gz.z().g(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(e eVar, String str, int i) {
        gz.z().z(eVar, str, i);
    }

    private void z(e eVar, String str, long j) {
        gz.z().z(eVar, str, j);
    }
}
