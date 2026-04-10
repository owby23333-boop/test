package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b;

import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.adapter.util.ThreadHelper;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class m {
    private Map<String, Long> a;
    private Map<String, Pair<String, String>> b;

    class a implements Runnable {
        final /* synthetic */ String a;

        a(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Logger.d("TTMediationSDK_IntervalShowControl", "updateShowPacingTime ritId = " + this.a);
            i iVarI = m.this.i(this.a);
            if (iVarI == null || !iVarI.a()) {
                return;
            }
            Date date = new Date();
            Logger.d("TTMediationSDK_IntervalShowControl", "updateShowPacingTime save time = " + f.b(date.getTime()));
            m.this.a(this.a, date.getTime());
        }
    }

    class b implements Runnable {
        final /* synthetic */ String a;

        b(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Logger.d("TTMediationSDK_IntervalShowControl", "addShowFreqctlCount ritId = " + this.a);
            g gVarH = m.this.h(this.a);
            if (gVarH == null || !gVarH.a()) {
                return;
            }
            for (e eVar : gVarH.i()) {
                if (eVar.a() < eVar.c()) {
                    m.this.a(gVarH, eVar.d(), eVar.a() + 1);
                }
            }
        }
    }

    private static class c {
        private static m a = new m(null);
    }

    private m() {
        a();
    }

    /* synthetic */ m(a aVar) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(g gVar, String str, int i2) {
        h.a().a(gVar, str, i2);
    }

    private void a(g gVar, String str, long j2) {
        h.a().a(gVar, str, j2);
    }

    public static m b() {
        return c.a;
    }

    public void a() {
        this.b = new ConcurrentHashMap();
        this.a = new ConcurrentHashMap();
    }

    public void a(String str) {
        ThreadHelper.runOnMSDKThread(new b(str));
    }

    public void a(String str, long j2) {
        j.a().a(str, j2);
    }

    public boolean a(g gVar) {
        String str;
        if (gVar != null) {
            g gVarH = h(gVar.d());
            if (gVarH == null) {
                str = "freqctl 规则为空直接存储";
            } else if (TextUtils.isEmpty(gVar.e())) {
                Logger.d("TTMediationSDK_IntervalShowControl", "freqctl version 为空 清空本地数据 ");
                d(gVarH.d());
            } else if (TextUtils.equals(gVarH.e(), gVar.e())) {
                Logger.d("TTMediationSDK_IntervalShowControl", "freqctl version 一致 version = " + gVarH.e() + "无需处理");
            } else {
                str = "freqctl version不一致，缓存新规则 old version = " + gVarH.e() + "  new version " + gVar.e();
            }
            Logger.d("TTMediationSDK_IntervalShowControl", str);
            return true;
        }
        return false;
    }

    public boolean a(i iVar) {
        if (iVar != null) {
            i iVarI = i(iVar.d());
            if (iVarI == null) {
                Logger.d("TTMediationSDK_IntervalShowControl", "pacing 规则为空直接存储");
                return true;
            }
            if (TextUtils.isEmpty(iVar.j())) {
                Logger.d("TTMediationSDK_IntervalShowControl", "pacing ruleId 为空 清空本地数据 ");
                e(iVar.g());
            } else {
                if (!TextUtils.equals(iVarI.j(), iVar.j())) {
                    Logger.d("TTMediationSDK_IntervalShowControl", "pacing ruleId不一致，缓存新规则 old ruleId = " + iVarI.j() + "  new ruleId = " + iVar.j());
                    StringBuilder sb = new StringBuilder();
                    sb.append("pacing 删除 ritId = ");
                    sb.append(iVar.g());
                    Logger.d("TTMediationSDK_IntervalShowControl", sb.toString());
                    e(iVar.g());
                    return true;
                }
                Logger.d("TTMediationSDK_IntervalShowControl", "pacing ruleId 一致 ruleId = " + iVarI.j() + " 无需处理");
            }
        }
        return false;
    }

    public void b(g gVar) {
        h.a().a(gVar);
    }

    public void b(i iVar) {
        j.a().a(iVar);
    }

    public boolean b(String str) {
        StringBuilder sb;
        g gVarH = h(str);
        if (gVarH != null && gVarH.a()) {
            for (e eVar : gVarH.i()) {
                Date date = new Date();
                Logger.d("TTMediationSDK_IntervalShowControl", "checkFreqctl date = " + date.getTime() + " item.getEffectiveTime() = " + eVar.b());
                if (date.getTime() > eVar.b()) {
                    a(gVarH, eVar.d(), 0);
                    a(gVarH, eVar.d(), f.a(eVar.e()));
                    sb = new StringBuilder();
                    sb.append("checkFreqctl 有效期外计数需要清0，过期时间需要更新 = ");
                    sb.append(eVar.d());
                } else {
                    if (eVar.a() >= eVar.c()) {
                        Logger.d("TTMediationSDK_IntervalShowControl", "checkFreqctl 到了上线不可以展示 ruleId = " + eVar.d() + " count = " + eVar.a());
                        this.b.put(str, new Pair<>(eVar.d(), eVar.a() + ""));
                        return false;
                    }
                    sb = new StringBuilder();
                    sb.append("checkFreqctl 未到上线可以展示 ruleId = ");
                    sb.append(eVar.d());
                    sb.append(" count = ");
                    sb.append(eVar.a());
                }
                Logger.d("TTMediationSDK_IntervalShowControl", sb.toString());
            }
        }
        return true;
    }

    public boolean c(String str) {
        i iVarI = i(str);
        if (iVarI != null && iVarI.a() && iVarI.l()) {
            long time = new Date().getTime();
            long jK = iVarI.k();
            long jK2 = iVarI.k() + iVarI.i();
            Logger.d("TTMediationSDK_IntervalShowControl", "checkPacing currentTime = " + f.b(time) + " showTime = " + f.b(jK) + " pacingBean.getPacing() = " + iVarI.i() + " pacingTime = " + f.b(jK2));
            if (time <= jK2) {
                this.a.put(str, Long.valueOf(time - jK));
                return false;
            }
        }
        return true;
    }

    public void d(String str) {
        h.a().a(str);
    }

    public void e(String str) {
        j.a().a(str);
    }

    public Pair<String, String> f(String str) {
        return this.b.get(str);
    }

    public long g(String str) {
        Long l2 = this.a.get(str);
        if (l2 == null) {
            return -2L;
        }
        return l2.longValue();
    }

    public g h(String str) {
        return h.a().b(str);
    }

    public i i(String str) {
        return j.a().b(str);
    }

    public void j(String str) {
        ThreadHelper.runOnMSDKThread(new a(str));
    }
}
