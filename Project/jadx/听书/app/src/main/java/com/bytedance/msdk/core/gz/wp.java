package com.bytedance.msdk.core.gz;

import android.text.TextUtils;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class wp {
    private static final String z = "TTMediationSDK_wp";
    private Map<String, Long> g;

    private wp() {
        this.g = new ConcurrentHashMap();
    }

    public static wp z() {
        return z.z;
    }

    private static class z {
        private static wp z = new wp();
    }

    public long z(String str, String str2) {
        Long l = this.g.get(str + "_" + str2);
        if (l == null) {
            return -2L;
        }
        return l.longValue();
    }

    public void g(final String str, final String str2) {
        com.bytedance.msdk.z.gc.m.z(new Runnable() { // from class: com.bytedance.msdk.core.gz.wp.1
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.msdk.z.gc.dl.z(wp.z, "adn updateShowPacingTime ritId = " + str + " adnSlotId = " + str2);
                fo foVarA = wp.this.a(str, str2);
                if (foVarA == null || !foVarA.gz()) {
                    return;
                }
                Date date = new Date();
                com.bytedance.msdk.z.gc.dl.z(wp.z, "adn updateShowPacingTime save time = " + m.g(date.getTime()));
                wp.this.z(str, str2, date.getTime());
            }
        });
    }

    public boolean dl(String str, String str2) {
        String str3 = z;
        com.bytedance.msdk.z.gc.dl.z(str3, "adn checkPacing ritId = " + str + " adnSlotId = " + str2);
        fo foVarA = a(str, str2);
        if (foVarA != null && foVarA.gz() && foVarA.wp()) {
            long time = new Date().getTime();
            long jKb = foVarA.kb();
            long jKb2 = foVarA.kb() + foVarA.fo();
            com.bytedance.msdk.z.gc.dl.z(str3, "adn checkPacing currentTime = " + m.g(time) + " showTime = " + m.g(jKb) + " pacingBean.getPacing() = " + foVarA.fo() + " pacingTime = " + m.g(jKb2));
            if (time <= jKb2) {
                this.g.put(str + "_" + str2, Long.valueOf(time - jKb));
                return false;
            }
        }
        return true;
    }

    public boolean z(fo foVar) {
        if (foVar == null) {
            return false;
        }
        fo foVarA = a(foVar.g(), foVar.dl());
        if (foVarA == null) {
            com.bytedance.msdk.z.gc.dl.z(z, "adn pacing 规则为空直接存储");
            return true;
        }
        if (TextUtils.isEmpty(foVar.uy())) {
            com.bytedance.msdk.z.gc.dl.z(z, "adn pacing ruleId 为空 清空本地数据 ");
            delete(foVar.g(), foVar.dl());
            return false;
        }
        if (TextUtils.equals(foVarA.uy(), foVar.uy())) {
            com.bytedance.msdk.z.gc.dl.z(z, "adn pacing ruleId 一致 ruleId = " + foVarA.uy() + " 无需处理");
            return false;
        }
        com.bytedance.msdk.z.gc.dl.z(z, "adn pacing ruleId不一致，缓存新规则 old ruleId = " + foVarA.uy() + "  new ruleId = " + foVar.uy());
        delete(foVar.g(), foVar.dl());
        return true;
    }

    public void g(fo foVar) {
        uy.z().z(foVar);
    }

    public void delete(String str, String str2) {
        uy.z().z(str, str2);
    }

    public fo a(String str, String str2) {
        return uy.z().g(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(String str, String str2, long j) {
        uy.z().z(str, str2, j);
    }
}
