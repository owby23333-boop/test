package com.bytedance.sdk.openadsdk.core.lq;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.sdk.component.utils.wp;
import com.google.common.net.HttpHeaders;
import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class gz {
    private final com.bytedance.sdk.openadsdk.core.lq.g g;
    private final Context z;
    private boolean dl = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f1256a = 0;

    public static final class z {
        public static String z(int i) {
            switch (i) {
                case 200:
                    return "200_但取号失败";
                case 102101:
                    return "无网络状态";
                case 102102:
                    return "网络异常";
                case 102103:
                    return "预取号只开WiFi";
                case 102203:
                    return "输入参数错误";
                case 102204:
                    return "崩溃错误";
                case 102508:
                    return "数据网络切换失败";
                case 200010:
                    return "imsi获取失败或者没有sim卡，预取号失败";
                case 200050:
                    return "EOF异常";
                default:
                    return "wifi取号失败....";
            }
        }
    }

    public gz(Context context, com.bytedance.sdk.openadsdk.core.lq.g gVar) {
        this.z = context;
        this.g = gVar;
    }

    public void z(String str, a aVar) {
        if (aVar == null) {
            return;
        }
        boolean z2 = m.z(this.z);
        this.f1256a = m.z(this.z, z2);
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("headers");
            JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("params");
            Map<String, List<String>> mapZ = z(jSONObjectOptJSONObject);
            String upperCase = jSONObject.optString("method").toUpperCase();
            String strOptString = jSONObject.optString("url");
            this.g.z("method", upperCase);
            this.g.z("url", strOptString);
            try {
                if (z(z2, this.g, aVar)) {
                    if (this.dl) {
                        z(mapZ, jSONObjectOptJSONObject2, aVar);
                    } else {
                        z(null, mapZ, jSONObjectOptJSONObject2, aVar);
                    }
                }
            } catch (Throwable th) {
                wp.z(th);
                aVar.z(false, this.f1256a, 102204, z.z(102204), null, null);
            }
        } catch (JSONException e) {
            wp.z(e);
            aVar.z(false, this.f1256a, 102203, z.z(102203), null, null);
        }
    }

    private Map<String, List<String>> z(JSONObject jSONObject) {
        HashMap map = new HashMap();
        try {
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                String strOptString = jSONObject.optString(next);
                List list = (List) map.get(next);
                if (list == null) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(strOptString);
                    map.put(next, arrayList);
                } else {
                    list.add(strOptString);
                }
            }
        } catch (Exception e) {
            wp.z(e);
        }
        return map;
    }

    private boolean z(boolean z2, com.bytedance.sdk.openadsdk.core.lq.g gVar, a aVar) {
        gVar.z("networktype", this.f1256a);
        wp.z("transmit_business", "preCheck networkType:" + this.f1256a);
        String packageName = this.z.getPackageName();
        String strZ = dl.z(gc.z(this.z, packageName));
        gVar.z("apppackage", packageName);
        gVar.z("appsign", strZ);
        int i = this.f1256a;
        if (i == 3) {
            this.dl = true;
        }
        if (!z2) {
            aVar.z(false, i, 200010, z.z(200010), null, null);
            return false;
        }
        if (i == 0) {
            aVar.z(false, i, 102101, z.z(102101), null, null);
            return false;
        }
        if (i != 2) {
            return true;
        }
        aVar.z(false, i, 102103, z.z(102103), null, null);
        return false;
    }

    private void z(final Map<String, List<String>> map, final JSONObject jSONObject, final a aVar) {
        wp.z("transmit_business", "wifiSwitchAndDoRequest");
        final g gVarZ = g.z(this.z);
        g.z(this.z).z(new ConnectivityManager.NetworkCallback() { // from class: com.bytedance.sdk.openadsdk.core.lq.gz.1
            private final AtomicBoolean m = new AtomicBoolean(false);

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onAvailable(Network network) throws Throwable {
                wp.z("transmit_business", "wifiSwitchAndDoRequest onAvailable:".concat(String.valueOf(network)));
                if (this.m.getAndSet(true) || network == null) {
                    return;
                }
                gz.this.z(network, map, jSONObject, aVar);
                gVarZ.z(1000L);
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onUnavailable() {
                wp.z("transmit_business", "wifiSwitchAndDoRequest onUnavailable");
                aVar.z(false, gz.this.f1256a, 102508, z.z(102508), null, null);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(Network network, Map<String, List<String>> map, JSONObject jSONObject, a aVar) throws Throwable {
        String strZ = this.g.z("url");
        String strZ2 = this.g.z("method");
        fo foVar = new fo(strZ, strZ2, map, jSONObject);
        foVar.z(this.g.z("apppackage"));
        foVar.g(this.g.z("appsign"));
        if ("get".equalsIgnoreCase(strZ2)) {
            foVar.z(HttpHeaders.CONTENT_TYPE, "application/x-www-form-urlencoded");
        }
        try {
            com.bytedance.sdk.openadsdk.core.lq.z.z.z(foVar, this.g.g("networktype"), this.g.z("apppackage"));
            z(network, foVar, aVar);
        } catch (Throwable th) {
            throw new RuntimeException(th);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:109:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x01fa  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x021b  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0226  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0232  */
    /* JADX WARN: Type inference failed for: r12v10 */
    /* JADX WARN: Type inference failed for: r12v11 */
    /* JADX WARN: Type inference failed for: r12v12 */
    /* JADX WARN: Type inference failed for: r12v18 */
    /* JADX WARN: Type inference failed for: r12v19 */
    /* JADX WARN: Type inference failed for: r12v20 */
    /* JADX WARN: Type inference failed for: r12v4, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r12v5 */
    /* JADX WARN: Type inference failed for: r12v6, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r12v9 */
    /* JADX WARN: Type inference failed for: r18v0, types: [com.bytedance.sdk.openadsdk.core.lq.gz] */
    /* JADX WARN: Type inference failed for: r21v0, types: [com.bytedance.sdk.openadsdk.core.lq.a] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void z(android.net.Network r19, com.bytedance.sdk.openadsdk.core.lq.fo r20, com.bytedance.sdk.openadsdk.core.lq.a r21) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 573
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.lq.gz.z(android.net.Network, com.bytedance.sdk.openadsdk.core.lq.fo, com.bytedance.sdk.openadsdk.core.lq.a):void");
    }

    private void z(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                wp.z(e);
            }
        }
    }

    private static class g {
        private static volatile g gc;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f1258a;
        private ConnectivityManager.NetworkCallback dl;
        private final Runnable e = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.lq.gz.g.2
            @Override // java.lang.Runnable
            public void run() {
                g.this.z();
            }
        };
        private Network g;
        private Handler m;
        private ConnectivityManager z;

        private g(Context context) {
            try {
                this.z = (ConnectivityManager) context.getSystemService("connectivity");
                this.m = new Handler(Looper.getMainLooper());
            } catch (Exception e) {
                wp.z(e);
            }
        }

        public static g z(Context context) {
            if (gc == null) {
                synchronized (g.class) {
                    if (gc == null) {
                        gc = new g(context);
                    }
                }
            }
            return gc;
        }

        public void z(final ConnectivityManager.NetworkCallback networkCallback) {
            NetworkInfo networkInfo;
            this.m.removeCallbacks(this.e);
            ConnectivityManager connectivityManager = this.z;
            if (connectivityManager == null) {
                wp.z("transmit_business", "forceNet mConnectivityManager is null");
                return;
            }
            Network network = this.g;
            if (network != null && !this.f1258a && (networkInfo = connectivityManager.getNetworkInfo(network)) != null && networkInfo.isAvailable()) {
                wp.z("transmit_business", "forceNet reuse network");
                networkCallback.onAvailable(this.g);
                return;
            }
            ConnectivityManager.NetworkCallback networkCallback2 = this.dl;
            if (networkCallback2 != null) {
                try {
                    this.z.unregisterNetworkCallback(networkCallback2);
                } catch (Exception e) {
                    wp.z(e);
                    this.dl = null;
                }
                wp.z("transmit_business", "forceNet clear");
            }
            NetworkRequest networkRequestBuild = new NetworkRequest.Builder().addCapability(12).addTransportType(0).build();
            this.dl = new ConnectivityManager.NetworkCallback() { // from class: com.bytedance.sdk.openadsdk.core.lq.gz.g.1
                @Override // android.net.ConnectivityManager.NetworkCallback
                public void onAvailable(Network network2) {
                    try {
                        if (g.this.z.getNetworkCapabilities(network2).hasTransport(0)) {
                            g.this.g = network2;
                            networkCallback.onAvailable(network2);
                            g.this.f1258a = false;
                        } else {
                            wp.z("transmit_business", "forceNet check fail...");
                            g.this.g = null;
                            networkCallback.onAvailable(null);
                            g.this.f1258a = true;
                        }
                    } catch (Exception e2) {
                        wp.z(e2);
                        networkCallback.onAvailable(null);
                    }
                }

                @Override // android.net.ConnectivityManager.NetworkCallback
                public void onLost(Network network2) {
                    g.this.f1258a = true;
                }

                @Override // android.net.ConnectivityManager.NetworkCallback
                public void onUnavailable() {
                    super.onUnavailable();
                    networkCallback.onUnavailable();
                }
            };
            this.z.requestNetwork(networkRequestBuild, this.dl, 5000);
        }

        public void z(long j) {
            this.m.postDelayed(this.e, j);
        }

        public void z() {
            if (this.z == null) {
                return;
            }
            try {
                if (this.dl == null) {
                    return;
                }
                wp.z("transmit_business", "unregisterNetwork");
                this.z.unregisterNetworkCallback(this.dl);
                this.dl = null;
                this.g = null;
            } catch (Exception e) {
                wp.z(e);
            }
        }
    }
}
