package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b;

import android.text.TextUtils;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.adapter.util.ThreadHelper;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class l {
    private static final String b = "TTMediationSDK_" + l.class.getSimpleName();
    private Map<String, Long> a;

    class a implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ String b;

        a(String str, String str2) {
            this.a = str;
            this.b = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Logger.d(l.b, "adn updateShowPacingTime ritId = " + this.a + " adnSlotId = " + this.b);
            i iVarD = l.this.d(this.a, this.b);
            if (iVarD == null || !iVarD.a()) {
                return;
            }
            Date date = new Date();
            Logger.d(l.b, "adn updateShowPacingTime save time = " + f.b(date.getTime()));
            l.this.a(this.a, this.b, date.getTime());
        }
    }

    private static class b {
        private static l a = new l(null);
    }

    private l() {
        this.a = new ConcurrentHashMap();
    }

    /* synthetic */ l(a aVar) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, long j2) {
        j.a().a(str, str2, j2);
    }

    public static l b() {
        return b.a;
    }

    public boolean a(i iVar) {
        if (iVar != null) {
            i iVarD = d(iVar.d(), iVar.c());
            if (iVarD == null) {
                Logger.d(b, "adn pacing 规则为空直接存储");
                return true;
            }
            if (TextUtils.isEmpty(iVar.j())) {
                Logger.d(b, "adn pacing ruleId 为空 清空本地数据 ");
                b(iVar.d(), iVar.c());
            } else {
                if (!TextUtils.equals(iVarD.j(), iVar.j())) {
                    Logger.d(b, "adn pacing ruleId不一致，缓存新规则 old ruleId = " + iVarD.j() + "  new ruleId = " + iVar.j());
                    b(iVar.d(), iVar.c());
                    return true;
                }
                Logger.d(b, "adn pacing ruleId 一致 ruleId = " + iVarD.j() + " 无需处理");
            }
        }
        return false;
    }

    public boolean a(String str, String str2) {
        Logger.d(b, "adn checkPacing ritId = " + str + " adnSlotId = " + str2);
        i iVarD = d(str, str2);
        if (iVarD != null && iVarD.a() && iVarD.l()) {
            long time = new Date().getTime();
            long jK = iVarD.k();
            long jK2 = iVarD.k() + iVarD.i();
            Logger.d(b, "adn checkPacing currentTime = " + f.b(time) + " showTime = " + f.b(jK) + " pacingBean.getPacing() = " + iVarD.i() + " pacingTime = " + f.b(jK2));
            if (time <= jK2) {
                this.a.put(str + "_" + str2, Long.valueOf(time - jK));
                return false;
            }
        }
        return true;
    }

    public void b(i iVar) {
        j.a().a(iVar);
    }

    public void b(String str, String str2) {
        j.a().a(str, str2);
    }

    public long c(String str, String str2) {
        Long l2 = this.a.get(str + "_" + str2);
        if (l2 == null) {
            return -2L;
        }
        return l2.longValue();
    }

    public i d(String str, String str2) {
        return j.a().b(str, str2);
    }

    public void e(String str, String str2) {
        ThreadHelper.runOnMSDKThread(new a(str, str2));
    }
}
