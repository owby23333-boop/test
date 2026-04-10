package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1;

import android.text.TextUtils;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.e0;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.k0;
import com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.adapter.util.TTLogUtil;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.TToast;
import com.bytedance.msdk.base.TTBaseAd;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public class g {
    private static Comparator<TTBaseAd> a = null;
    private static String b = "KEY_LOAD_SEQ";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f1657c = "KEY_LOAD_SEQ_TIME";

    static final class a implements Comparator<TTBaseAd> {
        a() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(TTBaseAd tTBaseAd, TTBaseAd tTBaseAd2) {
            if (tTBaseAd.getCpm() <= tTBaseAd2.getCpm()) {
                if (tTBaseAd.getCpm() < tTBaseAd2.getCpm()) {
                    return 1;
                }
                if (tTBaseAd.getCpm() != tTBaseAd2.getCpm() || tTBaseAd.getAdNetworkPlatformId() != 1) {
                    return 0;
                }
            }
            return -1;
        }
    }

    static int a() {
        long jA = e0.a((String) null, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d()).a(f1657c, 0L);
        long jCurrentTimeMillis = System.currentTimeMillis();
        boolean zA = a(new Date(jA), new Date(jCurrentTimeMillis));
        e0.a((String) null, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d()).b(f1657c, jCurrentTimeMillis);
        int iA = e0.a((String) null, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d()).a(b, 0);
        if (!zA) {
            iA = 0;
        }
        int i2 = iA + 1;
        e0.a((String) null, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d()).b(b, i2);
        return i2;
    }

    static j a(String str, String str2, int i2, int i3) {
        j jVar = new j();
        jVar.b(str2);
        jVar.a(str);
        jVar.c(0);
        jVar.e("0");
        jVar.f("1");
        jVar.g(i2);
        jVar.j(i3);
        jVar.i(3);
        jVar.g("%1$s%2$sAdapter");
        return jVar;
    }

    public static TTAbsAdLoaderAdapter a(String str, j jVar) {
        if (jVar == null) {
            return null;
        }
        String strA = a(jVar.q(), c(jVar.e()), com.bytedance.msdk.base.a.a(jVar.t(), jVar.z()));
        TTAbsAdLoaderAdapter tTAbsAdLoaderAdapterB = b(strA);
        if (tTAbsAdLoaderAdapterB == null) {
            return tTAbsAdLoaderAdapterB;
        }
        Logger.e("TTMediationSDK", TTLogUtil.getTagThirdLevelByEvent(str, TTLogUtil.TAG_EVENT_REQUEST) + "创建adapter成功!! class=" + strA + " adn_version:" + tTAbsAdLoaderAdapterB.getSdkVersion());
        return tTAbsAdLoaderAdapterB;
    }

    public static String a(String str, String str2, String str3) {
        if (TextUtils.equals("pangle", com.bytedance.msdk.base.a.b(str2)) && bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.J().A()) {
            return "com.bytedance.msdk.adapter.panglecustom." + String.format(str, "PangleCustom", str3);
        }
        return "com.bytedance.msdk.adapter." + com.bytedance.msdk.base.a.b(str2) + "." + String.format(str, str2, str3);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0076  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.Map<java.lang.String, java.lang.Object> a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j r7, com.bytedance.msdk.api.AdSlot r8, java.util.Map<java.lang.String, java.lang.Object> r9, com.bytedance.msdk.api.v2.GMNetworkRequestInfo r10, int r11, int r12, boolean r13, long r14) {
        /*
            Method dump skipped, instruction units count: 225
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.g.a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j, com.bytedance.msdk.api.AdSlot, java.util.Map, com.bytedance.msdk.api.v2.GMNetworkRequestInfo, int, int, boolean, long):java.util.Map");
    }

    static void a(AdError adError, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.d dVar) {
        if (!bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f().I() || adError == null || dVar == null) {
            return;
        }
        if (20001 == adError.code) {
            TToast.show(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d(), String.format("error_adn:%1$s no ads，please check ad network", dVar.c()));
        } else {
            TToast.show(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d(), String.format("test error_adn:%1$s  error_slot_id: %2$s  error_code:%3$d  error_message:%4$s", dVar.c(), dVar.d(), Integer.valueOf(adError.thirdSdkErrorCode), adError.thirdSdkErrorMessage));
        }
    }

    static void a(String str, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.d dVar, TTBaseAd tTBaseAd) {
        if (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f().I() && dVar != null && a(str, tTBaseAd)) {
            TToast.show(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d(), String.format("fill_suceess ,test_adn:%1$s,slot_id : %2$s", dVar.c(), dVar.d()));
        }
    }

    public static void a(List<TTBaseAd> list, Comparator<TTBaseAd> comparator) {
        if (comparator == null) {
            k0.a(list);
        } else {
            k0.a(list, comparator);
        }
    }

    public static boolean a(String str) {
        return true;
    }

    private static boolean a(String str, TTBaseAd tTBaseAd) {
        if (tTBaseAd != null) {
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c cVarC = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f().c(str);
            if (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f().f(str) && cVarC != null && cVarC.i() != null && cVarC.i().size() > 0 && cVarC.A() != null && cVarC.A().size() > 0) {
                return true;
            }
        }
        return false;
    }

    private static boolean a(Date date, Date date2) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(date2);
        return ((calendar.get(1) == calendar2.get(1)) && calendar.get(2) == calendar2.get(2)) && calendar.get(5) == calendar2.get(5);
    }

    public static TTAbsAdLoaderAdapter b(String str) {
        try {
            return (TTAbsAdLoaderAdapter) Class.forName(str).newInstance();
        } catch (Exception e2) {
            Logger.e("TTMediationSDK", "创建广告网络adapter加载器失败：class=" + str + ",异常信息：" + e2.toString());
            return null;
        }
    }

    public static Comparator<TTBaseAd> b() {
        a aVar = new a();
        a = aVar;
        return aVar;
    }

    public static void b(String str, TTBaseAd tTBaseAd) {
        if (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f().I() && tTBaseAd != null && a(str, tTBaseAd)) {
            TToast.show(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d(), String.format("test_suceess ,test_adn:%1$s,slot_id : %2$s", com.bytedance.msdk.base.a.a(tTBaseAd.getAdNetworkPlatformId()), tTBaseAd.getAdNetworkSlotId()));
        }
    }

    public static String c(String str) {
        return !TextUtils.isEmpty(str) ? str.substring(0, 1).toUpperCase().concat(str.substring(1).toLowerCase()) : str;
    }

    public static Comparator<TTBaseAd> c() {
        Comparator<TTBaseAd> comparator = a;
        return comparator != null ? comparator : b();
    }

    public static String d() {
        return UUID.randomUUID().toString();
    }

    static void e() {
        if (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f().I()) {
            TToast.show(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d(), "slot setting error");
        }
    }
}
