package anet.channel.e;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import anet.channel.AwcnConfig;
import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.strategy.IConnStrategy;
import anet.channel.strategy.IStrategyFilter;
import anet.channel.strategy.IStrategyListener;
import anet.channel.strategy.StrategyCenter;
import anet.channel.thread.ThreadPoolExecutorFactory;
import anet.channel.util.ALog;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.android.spdy.SpdyAgent;
import org.android.spdy.SpdySessionKind;
import org.android.spdy.SpdyVersion;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
public class a {
    private static b a;
    private static String b;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static SharedPreferences f319f;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static AtomicBoolean f316c = new AtomicBoolean(false);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static AtomicBoolean f317d = new AtomicBoolean(false);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static long f318e = com.anythink.expressad.d.a.b.aD;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static IStrategyFilter f320g = new anet.channel.e.b();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static AtomicInteger f321h = new AtomicInteger(1);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static IStrategyListener f322i = new c();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static NetworkStatusHelper.INetworkStatusChangeListener f323j = new d();

    /* JADX INFO: renamed from: anet.channel.e.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: Taobao */
    private static class C0006a {
        long a;
        boolean b;

        private C0006a() {
        }

        /* synthetic */ C0006a(anet.channel.e.b bVar) {
            this();
        }
    }

    public static boolean b() {
        b bVar = a;
        if (bVar != null) {
            return bVar.b(NetworkStatusHelper.getUniqueId(NetworkStatusHelper.getStatus()));
        }
        return false;
    }

    public static void a(NetworkStatusHelper.NetworkStatus networkStatus) {
        if (!AwcnConfig.isHttp3Enable()) {
            ALog.i("awcn.Http3ConnDetector", "startDetect", null, "http3 global config close.");
            return;
        }
        if (f317d.get()) {
            ALog.e("awcn.Http3ConnDetector", "tnet exception.", null, new Object[0]);
            return;
        }
        if (NetworkStatusHelper.isConnected()) {
            if (TextUtils.isEmpty(b)) {
                ALog.e("awcn.Http3ConnDetector", "startDetect", null, "host is null");
                return;
            }
            List<IConnStrategy> connStrategyListByHost = StrategyCenter.getInstance().getConnStrategyListByHost(b, f320g);
            if (connStrategyListByHost.isEmpty()) {
                ALog.e("awcn.Http3ConnDetector", "startDetect", null, "http3 strategy is null.");
                return;
            }
            if (f316c.compareAndSet(false, true)) {
                try {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    SpdyAgent.getInstance(GlobalAppRuntimeInfo.getContext(), SpdyVersion.SPDY3, SpdySessionKind.NONE_SESSION).InitializeSecurityStuff();
                    ALog.e("awcn.Http3ConnDetector", "tnet init http3.", null, "cost", Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis));
                } catch (Throwable th) {
                    ALog.e("awcn.Http3ConnDetector", "tnet init http3 error.", null, th, new Object[0]);
                    f317d.set(true);
                    return;
                }
            }
            if (a == null) {
                a = new b();
            }
            if (a.a(NetworkStatusHelper.getUniqueId(networkStatus))) {
                ThreadPoolExecutorFactory.submitDetectTask(new e(connStrategyListByHost, networkStatus));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static IConnStrategy b(IConnStrategy iConnStrategy) {
        return new g(iConnStrategy);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: Taobao */
    static class b {
        private Map<String, C0006a> a = new ConcurrentHashMap();

        b() {
            a();
        }

        private void a() {
            anet.channel.e.b bVar = null;
            String string = a.f319f.getString("networksdk_http3_history_records", null);
            if (TextUtils.isEmpty(string)) {
                return;
            }
            try {
                JSONArray jSONArray = new JSONArray(string);
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    JSONObject jSONObject = (JSONObject) jSONArray.get(i2);
                    C0006a c0006a = new C0006a(bVar);
                    String string2 = jSONObject.getString("networkUniqueId");
                    c0006a.a = jSONObject.getLong("time");
                    c0006a.b = jSONObject.getBoolean("enable");
                    if (a(c0006a.a)) {
                        synchronized (this.a) {
                            this.a.put(string2, c0006a);
                        }
                    }
                }
            } catch (JSONException unused) {
            }
        }

        boolean b(String str) {
            synchronized (this.a) {
                C0006a c0006a = this.a.get(str);
                if (c0006a == null) {
                    return false;
                }
                return c0006a.b;
            }
        }

        boolean a(String str) {
            synchronized (this.a) {
                C0006a c0006a = this.a.get(str);
                boolean z2 = true;
                if (c0006a == null) {
                    return true;
                }
                if (a(c0006a.a)) {
                    z2 = false;
                }
                return z2;
            }
        }

        private boolean a(long j2) {
            return System.currentTimeMillis() - j2 < a.f318e;
        }

        void a(String str, boolean z2) {
            C0006a c0006a = new C0006a(null);
            c0006a.b = z2;
            c0006a.a = System.currentTimeMillis();
            JSONArray jSONArray = new JSONArray();
            synchronized (this.a) {
                this.a.put(str, c0006a);
                for (Map.Entry<String, C0006a> entry : this.a.entrySet()) {
                    String key = entry.getKey();
                    C0006a value = entry.getValue();
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("networkUniqueId", key);
                        jSONObject.put("time", value.a);
                        jSONObject.put("enable", value.b);
                        jSONArray.put(jSONObject);
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
            }
            a.f319f.edit().putString("networksdk_http3_history_records", jSONArray.toString()).apply();
        }
    }

    public static void a() {
        try {
            ALog.e("awcn.Http3ConnDetector", "registerListener", null, "http3Enable", Boolean.valueOf(AwcnConfig.isHttp3Enable()));
            f319f = PreferenceManager.getDefaultSharedPreferences(GlobalAppRuntimeInfo.getContext());
            b = f319f.getString("http3_detector_host", "");
            a(NetworkStatusHelper.getStatus());
            NetworkStatusHelper.addStatusChangeListener(f323j);
            StrategyCenter.getInstance().registerListener(f322i);
        } catch (Exception e2) {
            ALog.e("awcn.Http3ConnDetector", "[registerListener]error", null, e2, new Object[0]);
        }
    }

    public static void a(long j2) {
        if (j2 < 0) {
            return;
        }
        f318e = j2;
    }

    public static void a(boolean z2) {
        b bVar = a;
        if (bVar != null) {
            bVar.a(NetworkStatusHelper.getUniqueId(NetworkStatusHelper.getStatus()), z2);
        }
    }
}
