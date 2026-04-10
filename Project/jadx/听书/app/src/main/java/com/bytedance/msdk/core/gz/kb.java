package com.bytedance.msdk.core.gz;

import android.text.TextUtils;
import android.util.Pair;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class kb {
    private static final String z = "TTMediationSDK_kb";
    private Map<String, Pair<String, String>> g;

    private kb() {
        this.g = new ConcurrentHashMap();
    }

    public static kb z() {
        return z.z;
    }

    private static class z {
        private static kb z = new kb();
    }

    public Pair<String, String> z(String str, String str2) {
        return this.g.get(str + "_" + str2);
    }

    public void g(final String str, final String str2) {
        com.bytedance.msdk.z.gc.m.z(new Runnable() { // from class: com.bytedance.msdk.core.gz.kb.1
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.msdk.z.gc.dl.z(kb.z, "adn addShowFreqctlCount ritId = " + str + " adnSlotId = " + str2);
                e eVarA = kb.this.a(str, str2);
                if (eVarA == null || !eVarA.gz()) {
                    return;
                }
                for (gc gcVar : eVarA.kb()) {
                    if (gcVar.gc() < gcVar.z()) {
                        kb.this.z(eVarA, gcVar.dl(), gcVar.gc() + 1);
                    }
                }
            }
        });
    }

    public boolean dl(String str, String str2) {
        com.bytedance.msdk.z.gc.dl.z(z, "adn checkFreqctl ritId = " + str + " adnSlotId = " + str2);
        e eVarA = a(str, str2);
        if (eVarA == null || !eVarA.gz()) {
            return true;
        }
        for (gc gcVar : eVarA.kb()) {
            Date date = new Date();
            String str3 = z;
            com.bytedance.msdk.z.gc.dl.z(str3, "adn checkFreqctl ritId = " + str + " adnSlotId = " + str2 + "  date = " + date.getTime() + " item.getEffectiveTime() = " + gcVar.a());
            if (date.getTime() <= gcVar.a()) {
                if (gcVar.gc() < gcVar.z()) {
                    com.bytedance.msdk.z.gc.dl.z(str3, "adn checkFreqctl 未到上线可以展示 ritId = " + str + " adnSlotId = " + str2 + " ruleId = " + gcVar.dl() + " count = " + gcVar.gc());
                } else {
                    com.bytedance.msdk.z.gc.dl.z(str3, "adn checkFreqctl 到了上线不可以展示 ritId = " + str + " adnSlotId = " + str2 + " ruleId = " + gcVar.dl() + " count = " + gcVar.gc());
                    this.g.put(str + "_" + str2, new Pair<>(gcVar.dl(), new StringBuilder().append(gcVar.gc()).toString()));
                    return false;
                }
            } else {
                z(eVarA, gcVar.dl(), 0);
                z(eVarA, gcVar.dl(), m.z(gcVar.g()));
                com.bytedance.msdk.z.gc.dl.z(str3, "adn checkFreqctl 有效期外计数需要清0，过期时间需要更新 = " + gcVar.dl());
            }
        }
        return true;
    }

    public boolean z(e eVar) {
        if (eVar == null) {
            return false;
        }
        e eVarA = a(eVar.g(), eVar.dl());
        if (eVarA == null) {
            com.bytedance.msdk.z.gc.dl.z(z, "adn freqctl 规则为空直接存储");
            return true;
        }
        if (TextUtils.isEmpty(eVar.m())) {
            com.bytedance.msdk.z.gc.dl.z(z, "adn freqctl version 为空 清空本地数据 ");
            delete(eVarA.g(), eVarA.dl());
            return false;
        }
        if (TextUtils.equals(eVarA.m(), eVar.m())) {
            com.bytedance.msdk.z.gc.dl.z(z, "adn freqctl version 一致 version = " + eVarA.m() + " 无需处理");
            return false;
        }
        com.bytedance.msdk.z.gc.dl.z(z, "adn freqctl version不一致，缓存新规则 old version = " + eVarA.m() + "  new version " + eVar.m());
        return true;
    }

    public void g(e eVar) {
        i.z().g(eVar);
    }

    public void delete(String str, String str2) {
        gz.z().z(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public e a(String str, String str2) {
        return gz.z().g(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(e eVar, String str, int i) {
        gz.z().z(eVar, str, i);
    }

    private void z(e eVar, String str, long j) {
        gz.z().z(eVar, str, j);
    }
}
