package anet.channel;

import android.text.TextUtils;
import anet.channel.strategy.ConnProtocol;
import anet.channel.strategy.StrategyTemplate;
import anet.channel.util.ALog;
import com.taobao.accs.common.Constants;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
public class AwcnConfig {
    public static final String HTTP3_ENABLE = "HTTP3_ENABLE";
    public static final String NEXT_LAUNCH_FORBID = "NEXT_LAUNCH_FORBID";
    private static volatile boolean a = false;
    private static volatile boolean b = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile boolean f206c = true;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile boolean f207d = true;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static volatile boolean f208e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static volatile boolean f209f = true;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static volatile long f210g = 43200000;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static volatile boolean f211h = true;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static volatile boolean f212i = true;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static boolean f213j = true;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static boolean f214k = false;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static volatile boolean f215l = false;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static volatile boolean f216m = true;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static volatile boolean f217n = false;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static volatile int f218o = 10000;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static volatile boolean f219p = false;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static volatile boolean f220q = true;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static volatile int f221r = -1;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static volatile boolean f222s = true;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static volatile boolean f223t = true;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static volatile boolean f224u = false;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static volatile boolean f225v = true;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private static volatile CopyOnWriteArrayList<String> f226w = null;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static volatile boolean f227x = true;

    public static int getAccsReconnectionDelayPeriod() {
        return f218o;
    }

    public static long getIpv6BlackListTtl() {
        return f210g;
    }

    public static int getXquicCongControl() {
        return f221r;
    }

    public static boolean isAccsSessionCreateForbiddenInBg() {
        return a;
    }

    public static boolean isAllowHttpDnsNotify(String str) {
        if (f226w == null || TextUtils.isEmpty(str)) {
            return false;
        }
        return f226w.contains(str);
    }

    public static boolean isAppLifeCycleListenerEnable() {
        return f213j;
    }

    public static boolean isAsyncLoadStrategyEnable() {
        return f214k;
    }

    public static boolean isCookieHeaderRedundantFix() {
        return f223t;
    }

    public static boolean isHorseRaceEnable() {
        return f206c;
    }

    public static boolean isHttp3Enable() {
        return f219p;
    }

    public static boolean isHttp3OrangeEnable() {
        return f220q;
    }

    public static boolean isHttpsSniEnable() {
        return b;
    }

    public static boolean isIdleSessionCloseEnable() {
        return f209f;
    }

    public static boolean isIpStackDetectByUdpConnect() {
        return f222s;
    }

    public static boolean isIpv6BlackListEnable() {
        return f212i;
    }

    public static boolean isIpv6Enable() {
        return f211h;
    }

    public static boolean isNetworkDetectEnable() {
        return f217n;
    }

    public static boolean isPing6Enable() {
        return f216m;
    }

    public static boolean isQuicEnable() {
        return f208e;
    }

    public static boolean isSendConnectInfoByBroadcast() {
        return f224u;
    }

    public static boolean isSendConnectInfoByService() {
        return f225v;
    }

    public static boolean isTbNextLaunch() {
        return f215l;
    }

    public static boolean isTnetHeaderCacheEnable() {
        return f207d;
    }

    public static boolean isWifiInfoEnable() {
        return f227x;
    }

    public static void registerPresetSessions(String str) {
        if (GlobalAppRuntimeInfo.isTargetProcess() && !TextUtils.isEmpty(str)) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                int length = jSONArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i2);
                    String string = jSONObject.getString(Constants.KEY_HOST);
                    if (!anet.channel.strategy.utils.c.c(string)) {
                        return;
                    }
                    StrategyTemplate.getInstance().registerConnProtocol(string, ConnProtocol.valueOf(jSONObject.getString("protocol"), jSONObject.getString("rtt"), jSONObject.getString("publicKey")));
                    if (jSONObject.getBoolean("isKeepAlive")) {
                        SessionCenter.getInstance().registerSessionInfo(SessionInfo.create(string, true, false, null, null, null));
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    public static void setAccsReconnectionDelayPeriod(int i2) {
        if (i2 < 0) {
            i2 = 0;
        }
        if (i2 > 10000) {
            i2 = 10000;
        }
        f218o = i2;
    }

    public static void setAccsSessionCreateForbiddenInBg(boolean z2) {
        a = z2;
    }

    public static void setAppLifeCycleListenerEnable(boolean z2) {
        f213j = z2;
    }

    public static void setAsyncLoadStrategyEnable(boolean z2) {
        f214k = z2;
    }

    public static void setCookieHeaderRedundantFix(boolean z2) {
        f223t = z2;
    }

    public static void setHorseRaceEnable(boolean z2) {
        f206c = z2;
    }

    public static void setHttp3Enable(boolean z2) {
        f219p = z2;
        ALog.e("awcn.AwcnConfig", "[setHttp3Enable]", null, "enable", Boolean.valueOf(z2));
    }

    public static void setHttp3OrangeEnable(boolean z2) {
        f220q = z2;
    }

    public static void setHttpDnsNotifyWhiteList(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            JSONArray jSONArray = new JSONArray(str);
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                String string = jSONArray.getString(i2);
                if (!TextUtils.isEmpty(string)) {
                    copyOnWriteArrayList.add(string);
                }
            }
            f226w = copyOnWriteArrayList;
        } catch (Exception e2) {
            ALog.e("awcn.AwcnConfig", "[setHttpDnsNotifyWhiteList] error", null, e2, new Object[0]);
        }
    }

    public static void setHttpsSniEnable(boolean z2) {
        b = z2;
    }

    public static void setIdleSessionCloseEnable(boolean z2) {
        f209f = z2;
    }

    public static void setIpStackDetectByUdpConnect(boolean z2) {
        f222s = z2;
    }

    public static void setIpv6BlackListEnable(boolean z2) {
        f212i = z2;
    }

    public static void setIpv6BlackListTtl(long j2) {
        f210g = j2;
    }

    public static void setIpv6Enable(boolean z2) {
        f211h = z2;
    }

    public static void setNetworkDetectEnable(boolean z2) {
        f217n = z2;
    }

    public static void setPing6Enable(boolean z2) {
        f216m = z2;
    }

    public static void setQuicEnable(boolean z2) {
        f208e = z2;
    }

    public static void setSendConnectInfoByBroadcast(boolean z2) {
        f224u = z2;
    }

    public static void setSendConnectInfoByService(boolean z2) {
        f225v = z2;
    }

    public static void setTbNextLaunch(boolean z2) {
        f215l = z2;
    }

    public static void setTnetHeaderCacheEnable(boolean z2) {
        f207d = z2;
    }

    public static void setWifiInfoEnable(boolean z2) {
        f227x = z2;
    }

    public static void setXquicCongControl(int i2) {
        if (i2 < 0) {
            return;
        }
        f221r = i2;
    }
}
