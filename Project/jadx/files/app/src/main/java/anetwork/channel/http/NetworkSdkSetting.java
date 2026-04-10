package anetwork.channel.http;

import android.content.Context;
import anet.channel.AwcnConfig;
import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.SessionCenter;
import anet.channel.entity.ENV;
import anet.channel.util.ALog;
import anet.channel.util.Utils;
import d.a.j.b;
import java.io.Serializable;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
public class NetworkSdkSetting implements Serializable {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static Context f596u;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static ENV f594s = ENV.ONLINE;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static AtomicBoolean f595t = new AtomicBoolean(false);

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static HashMap<String, Object> f597v = null;

    public static void a(Context context) {
        if (context == null) {
            return;
        }
        try {
            if (f595t.compareAndSet(false, true)) {
                ALog.e("anet.NetworkSdkSetting", "NetworkSdkSetting init", null, new Object[0]);
                f596u = context;
                GlobalAppRuntimeInfo.setInitTime(System.currentTimeMillis());
                GlobalAppRuntimeInfo.setContext(context);
                b.c();
                f();
                d.a.n.a.a();
                if (!AwcnConfig.isTbNextLaunch()) {
                    d.a.k.a.a(context);
                }
                SessionCenter.init(context);
            }
        } catch (Throwable th) {
            ALog.e("anet.NetworkSdkSetting", "Network SDK initial failed!", null, th, new Object[0]);
        }
    }

    private static void f() {
        try {
            Utils.invokeStaticMethodThrowException("anet.channel.TaobaoNetworkAdapter", "init", new Class[]{Context.class, HashMap.class}, f596u, f597v);
            ALog.i("anet.NetworkSdkSetting", "init taobao adapter success", null, new Object[0]);
        } catch (Exception e2) {
            ALog.i("anet.NetworkSdkSetting", "initTaobaoAdapter failed. maybe not taobao app", null, e2);
        }
    }

    public static Context getContext() {
        return f596u;
    }
}
