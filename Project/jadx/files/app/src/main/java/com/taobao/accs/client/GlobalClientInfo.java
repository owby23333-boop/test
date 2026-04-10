package com.taobao.accs.client;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.net.ConnectivityManager;
import android.text.TextUtils;
import androidx.annotation.Keep;
import com.taobao.accs.IAgooAppReceiver;
import com.taobao.accs.IAppReceiver;
import com.taobao.accs.ILoginInfo;
import com.taobao.accs.base.AccsAbstractDataListener;
import com.taobao.accs.base.AccsDataListener;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.accs.utl.ALog;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.android.agoo.common.AgooConstants;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes3.dex */
@Keep
public class GlobalClientInfo {
    public static final String AGOO_SERVICE_ID = "agooSend";
    public static Context a = null;
    public static IAgooAppReceiver b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f18117c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f18118d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f18119e = "com.taobao.accs.client.GlobalClientInfo";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static volatile GlobalClientInfo f18120f;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static Map<String, String> f18121l = new ConcurrentHashMap();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static Map<String, Map<String, String>> f18122m = new ConcurrentHashMap();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ConcurrentHashMap<String, ILoginInfo> f18123g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private ConcurrentHashMap<String, IAppReceiver> f18124h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private ActivityManager f18125i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private ConnectivityManager f18126j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private PackageInfo f18127k;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private Map<String, AccsDataListener> f18128n = new ConcurrentHashMap();

    static {
        f18121l.put(AGOO_SERVICE_ID, "org.android.agoo.accs.AgooService");
        f18121l.put(AgooConstants.AGOO_SERVICE_AGOOACK, "org.android.agoo.accs.AgooService");
        f18121l.put("agooTokenReport", "org.android.agoo.accs.AgooService");
    }

    private GlobalClientInfo(Context context) {
        a = getContext();
        if (a == null && context != null) {
            a = context.getApplicationContext();
        }
        ThreadPoolExecutorFactory.execute(new c(this));
    }

    private void a(String str, Map<String, String> map) {
        if (map == null) {
            return;
        }
        if (f18122m.get(str) == null) {
            f18122m.put(str, new ConcurrentHashMap());
        }
        f18122m.get(str).putAll(map);
    }

    public static Context getContext() {
        return a;
    }

    @Keep
    public static GlobalClientInfo getInstance(Context context) {
        if (f18120f == null) {
            synchronized (GlobalClientInfo.class) {
                if (f18120f == null) {
                    f18120f = new GlobalClientInfo(context);
                }
            }
        }
        return f18120f;
    }

    public void clearLoginInfoImpl() {
        this.f18123g = null;
    }

    public ActivityManager getActivityManager() {
        if (this.f18125i == null) {
            this.f18125i = (ActivityManager) a.getSystemService("activity");
        }
        return this.f18125i;
    }

    public Map<String, String> getAllService(String str) {
        if (f18122m.get(str) == null || f18122m.get(str).isEmpty()) {
            return null;
        }
        return f18122m.get(str);
    }

    public Map<String, IAppReceiver> getAppReceiver() {
        return this.f18124h;
    }

    public ConnectivityManager getConnectivityManager() {
        if (this.f18126j == null) {
            this.f18126j = (ConnectivityManager) a.getSystemService("connectivity");
        }
        return this.f18126j;
    }

    public AccsDataListener getListener(String str) {
        return this.f18128n.get(str);
    }

    public String getNick(String str) {
        ILoginInfo iLoginInfo;
        ConcurrentHashMap<String, ILoginInfo> concurrentHashMap = this.f18123g;
        if (concurrentHashMap == null || (iLoginInfo = concurrentHashMap.get(str)) == null) {
            return null;
        }
        return iLoginInfo.getNick();
    }

    public PackageInfo getPackageInfo() {
        try {
            if (this.f18127k == null) {
                this.f18127k = a.getPackageManager().getPackageInfo(a.getPackageName(), 0);
            }
        } catch (Throwable th) {
            ALog.e("GlobalClientInfo", "getPackageInfo", th, new Object[0]);
        }
        return this.f18127k;
    }

    public String getService(String str) {
        return f18121l.get(str);
    }

    public String getSid(String str) {
        ILoginInfo iLoginInfo;
        ConcurrentHashMap<String, ILoginInfo> concurrentHashMap = this.f18123g;
        if (concurrentHashMap == null || (iLoginInfo = concurrentHashMap.get(str)) == null) {
            return null;
        }
        return iLoginInfo.getSid();
    }

    public String getUserId(String str) {
        ILoginInfo iLoginInfo;
        ConcurrentHashMap<String, ILoginInfo> concurrentHashMap = this.f18123g;
        if (concurrentHashMap == null || (iLoginInfo = concurrentHashMap.get(str)) == null) {
            return null;
        }
        return iLoginInfo.getUserId();
    }

    public void registerAllRemoteService(String str, Map<String, String> map) {
        if (f18122m.get(str) == null) {
            f18122m.put(str, new ConcurrentHashMap());
        }
        f18122m.get(str).putAll(map);
    }

    public void registerListener(String str, AccsAbstractDataListener accsAbstractDataListener) {
        registerListener(str, (AccsDataListener) accsAbstractDataListener);
    }

    @Keep
    public void registerRemoteListener(String str, AccsDataListener accsDataListener) {
        this.f18128n.put(str, accsDataListener);
    }

    public void registerRemoteService(String str, String str2) {
        f18121l.put(str, str2);
    }

    public void registerService(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        f18121l.put(str, str2);
    }

    public void setAppReceiver(String str, IAppReceiver iAppReceiver) {
        if (iAppReceiver != null) {
            if (iAppReceiver instanceof IAgooAppReceiver) {
                b = (IAgooAppReceiver) iAppReceiver;
                return;
            }
            if (this.f18124h == null) {
                this.f18124h = new ConcurrentHashMap<>(2);
            }
            this.f18124h.put(str, iAppReceiver);
            a(str, iAppReceiver.getAllServices());
        }
    }

    public void setLoginInfoImpl(String str, ILoginInfo iLoginInfo) {
        if (this.f18123g == null) {
            this.f18123g = new ConcurrentHashMap<>(1);
        }
        if (iLoginInfo != null) {
            this.f18123g.put(str, iLoginInfo);
        }
    }

    @Keep
    public void setRemoteAgooAppReceiver(IAgooAppReceiver iAgooAppReceiver) {
        b = iAgooAppReceiver;
    }

    @Keep
    public void setRemoteAppReceiver(String str, IAppReceiver iAppReceiver) {
        if (this.f18124h == null) {
            this.f18124h = new ConcurrentHashMap<>(2);
        }
        this.f18124h.put(str, iAppReceiver);
        a(str, iAppReceiver.getAllServices());
    }

    public void unRegisterService(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        f18121l.remove(str);
    }

    public void unregisterListener(String str) {
        this.f18128n.remove(str);
    }

    public void unregisterRemoteListener(String str) {
        this.f18128n.remove(str);
    }

    public void unregisterRemoteService(String str) {
        f18121l.remove(str);
    }

    public String getService(String str, String str2) {
        if (f18122m.get(str) != null) {
            return f18122m.get(str).get(str2);
        }
        return null;
    }

    public void registerListener(String str, AccsDataListener accsDataListener) {
        if (TextUtils.isEmpty(str) || accsDataListener == null) {
            return;
        }
        this.f18128n.put(str, accsDataListener);
    }
}
