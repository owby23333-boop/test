package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b;

import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.adapter.util.ThreadHelper;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class k {
    private static final String b = "TTMediationSDK_" + k.class.getSimpleName();
    private Map<String, Pair<String, String>> a;

    class a implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ String b;

        a(String str, String str2) {
            this.a = str;
            this.b = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Logger.d(k.b, "adn addShowFreqctlCount ritId = " + this.a + " adnSlotId = " + this.b);
            g gVarE = k.this.e(this.a, this.b);
            if (gVarE == null || !gVarE.a()) {
                return;
            }
            for (e eVar : gVarE.i()) {
                if (eVar.a() < eVar.c()) {
                    k.this.a(gVarE, eVar.d(), eVar.a() + 1);
                }
            }
        }
    }

    private static class b {
        private static k a = new k(null);
    }

    private k() {
        this.a = new ConcurrentHashMap();
    }

    /* synthetic */ k(a aVar) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(g gVar, String str, int i2) {
        h.a().a(gVar, str, i2);
    }

    private void a(g gVar, String str, long j2) {
        h.a().a(gVar, str, j2);
    }

    public static k b() {
        return b.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public g e(String str, String str2) {
        return h.a().b(str, str2);
    }

    public void a(String str, String str2) {
        ThreadHelper.runOnMSDKThread(new a(str, str2));
    }

    public boolean a(g gVar) {
        if (gVar != null) {
            g gVarE = e(gVar.d(), gVar.c());
            if (gVarE == null) {
                Logger.d(b, "adn freqctl 规则为空直接存储");
                return true;
            }
            if (TextUtils.isEmpty(gVar.b())) {
                Logger.d(b, "adn freqctl version 为空 清空本地数据 ");
                c(gVarE.d(), gVarE.c());
            } else {
                if (!TextUtils.equals(gVarE.b(), gVar.b())) {
                    Logger.d(b, "adn freqctl version不一致，缓存新规则 old version = " + gVarE.b() + "  new version " + gVar.b());
                    return true;
                }
                Logger.d(b, "adn freqctl version 一致 version = " + gVarE.b() + " 无需处理");
            }
        }
        return false;
    }

    public void b(g gVar) {
        m.b().b(gVar);
    }

    public boolean b(String str, String str2) {
        String str3;
        StringBuilder sb;
        Logger.d(b, "adn checkFreqctl ritId = " + str + " adnSlotId = " + str2);
        g gVarE = e(str, str2);
        if (gVarE != null && gVarE.a()) {
            for (e eVar : gVarE.i()) {
                Date date = new Date();
                Logger.d(b, "adn checkFreqctl ritId = " + str + " adnSlotId = " + str2 + "  date = " + date.getTime() + " item.getEffectiveTime() = " + eVar.b());
                if (date.getTime() > eVar.b()) {
                    a(gVarE, eVar.d(), 0);
                    a(gVarE, eVar.d(), f.a(eVar.e()));
                    str3 = b;
                    sb = new StringBuilder();
                    sb.append("adn checkFreqctl 有效期外计数需要清0，过期时间需要更新 = ");
                    sb.append(eVar.d());
                } else {
                    if (eVar.a() >= eVar.c()) {
                        Logger.d(b, "adn checkFreqctl 到了上线不可以展示 ritId = " + str + " adnSlotId = " + str2 + " ruleId = " + eVar.d() + " count = " + eVar.a());
                        Map<String, Pair<String, String>> map = this.a;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(str);
                        sb2.append("_");
                        sb2.append(str2);
                        map.put(sb2.toString(), new Pair<>(eVar.d(), eVar.a() + ""));
                        return false;
                    }
                    str3 = b;
                    sb = new StringBuilder();
                    sb.append("adn checkFreqctl 未到上线可以展示 ritId = ");
                    sb.append(str);
                    sb.append(" adnSlotId = ");
                    sb.append(str2);
                    sb.append(" ruleId = ");
                    sb.append(eVar.d());
                    sb.append(" count = ");
                    sb.append(eVar.a());
                }
                Logger.d(str3, sb.toString());
            }
        }
        return true;
    }

    public void c(String str, String str2) {
        h.a().a(str, str2);
    }

    public Pair<String, String> d(String str, String str2) {
        return this.a.get(str + "_" + str2);
    }
}
