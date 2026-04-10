package com.bytedance.sdk.openadsdk.api.plugin;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.EventListener;
import com.bykv.vk.openvk.api.proto.Result;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.pangle.GlobalParam;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.ZeusPluginDecodeCallback;
import com.bytedance.pangle.ZeusPluginInstallListener;
import com.bytedance.pangle.ZeusPluginStateListener;
import com.bytedance.pangle.log.IZeusLogger;
import com.bytedance.pangle.log.IZeusReporter;
import com.bytedance.pangle.plugin.Plugin;
import com.bytedance.pangle.plugin.PluginManager;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.TTAdManager;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTAppContextHolder;
import com.bytedance.sdk.openadsdk.TTPluginListener;
import com.funny.audio.core.utils.FileUtils;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import com.umeng.analytics.pro.an;
import dalvik.system.BaseDexClassLoader;
import java.io.File;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class fo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile BaseDexClassLoader f896a;
    private static volatile TTPluginListener wp;
    private final Context fo;
    private static final String z = "next" + File.separator;
    private static final HashMap<String, TTPluginListener> g = new HashMap<>();
    private static final HashMap<String, Handler> dl = new HashMap<>();
    private static volatile fo gc = null;
    private final CountDownLatch m = new CountDownLatch(1);
    private volatile boolean e = false;
    private volatile String gz = "none";
    private JSONObject uy = new JSONObject();
    private EventListener kb = null;

    private fo(Context context) {
        this.fo = context.getApplicationContext();
        try {
            GlobalParam.getInstance().closeHookHuaweiOnInit(true);
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.api.m.a("TTPluginManager", "Unexpected error for closeHookHuaweiOnInit.", th);
        }
        g(context.getApplicationContext());
    }

    public static fo z(Context context) {
        if (gc == null) {
            synchronized (fo.class) {
                if (gc == null) {
                    gc = new fo(context);
                }
            }
        }
        return gc;
    }

    public JSONObject z() {
        return this.uy;
    }

    public void g() {
        try {
            Zeus.installFromDownloadDir();
        } catch (Throwable th) {
            wp.z(th);
        }
    }

    public BaseDexClassLoader z(e eVar, int i) throws Exception {
        boolean z2;
        String str;
        if (!this.e) {
            com.bytedance.sdk.openadsdk.api.m.a("TTPluginManager", "Zeus init failed.");
            throw new a(4, this.gz);
        }
        boolean zG = com.bytedance.sdk.openadsdk.api.plugin.dl.dl.g();
        int i2 = 8;
        if (!Zeus.isPluginInstalled("com.byted.pangle")) {
            if (zG) {
                new gz(this.fo).z();
            }
            if (a(this.fo)) {
                Zeus.installFromDownloadDir();
            }
            try {
                if (!zG) {
                    com.bytedance.sdk.openadsdk.api.m.g("TTPluginManager", "dont wait pl");
                } else {
                    com.bytedance.sdk.openadsdk.api.m.g("TTPluginManager", "wait start");
                    this.m.await(i, TimeUnit.MILLISECONDS);
                }
                com.bytedance.sdk.openadsdk.api.m.g("TTPluginManager", "wait done");
                eVar.g("wait_install_cost");
            } catch (Exception unused) {
                com.bytedance.sdk.openadsdk.api.m.g("TTPluginManager", "Install wait time out");
                throw new a(8, "install wait timeout");
            }
        }
        if (Zeus.isPluginLoaded("com.byted.pangle") || Zeus.loadPlugin("com.byted.pangle")) {
            f896a = Zeus.getPlugin("com.byted.pangle").mClassLoader;
            z2 = true;
        } else {
            z2 = false;
        }
        eVar.g("get_classloader_cost");
        Zeus.installFromDownloadDir();
        if (f896a == null) {
            if (this.m.getCount() != 0) {
                if (zG) {
                    i2 = 10;
                    str = "this device does not support arm64-v8a, and install wait time out";
                } else {
                    str = "install wait time out";
                }
                com.bytedance.sdk.openadsdk.api.m.a("TTPluginManager", "Install wait time out");
                throw new a(i2, str);
            }
            if (z2) {
                com.bytedance.sdk.openadsdk.api.m.a("TTPluginManager", "Get null after load");
                throw new a(9, "Get null after load");
            }
        }
        eVar.g("get_classloader_done");
        return f896a;
    }

    private void g(Context context) {
        try {
            com.bytedance.pangle.gc.gc.z(new com.bytedance.pangle.m() { // from class: com.bytedance.sdk.openadsdk.api.plugin.fo.1
                @Override // com.bytedance.pangle.m
                public void z(Runnable runnable) {
                    com.bytedance.sdk.openadsdk.fv.z.z().dl().execute(runnable);
                }

                @Override // com.bytedance.pangle.m
                public void g(Runnable runnable) {
                    com.bytedance.sdk.openadsdk.fv.z.z().dl().execute(runnable);
                }

                @Override // com.bytedance.pangle.m
                public void dl(Runnable runnable) {
                    new Handler(Looper.getMainLooper()).post(runnable);
                }
            });
            IZeusReporter iZeusReporter = new IZeusReporter() { // from class: com.bytedance.sdk.openadsdk.api.plugin.fo.2
                @Override // com.bytedance.pangle.log.IZeusReporter
                public void report(String str, JSONObject jSONObject) {
                    if ("load_finish".equals(str) && jSONObject != null && "com.byted.pangle".endsWith(jSONObject.optString("plugin_package_name"))) {
                        try {
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("duration", jSONObject.opt("duration"));
                            jSONObject2.put("message", jSONObject.opt("message"));
                            fo.this.uy.put("zeus", jSONObject2);
                        } catch (Exception e) {
                            com.bytedance.sdk.openadsdk.api.m.z(e);
                        }
                    }
                    if (TTAdSdk.isInitSuccess()) {
                        m.z(str, jSONObject);
                    } else {
                        m.g(str, jSONObject);
                    }
                }

                @Override // com.bytedance.pangle.log.IZeusReporter
                public void saveRecord(String str, String str2) {
                    gc.z(str, str2);
                }
            };
            com.bytedance.pangle.gc.gc.z(new com.bytedance.pangle.m() { // from class: com.bytedance.sdk.openadsdk.api.plugin.fo.3
                @Override // com.bytedance.pangle.m
                public void z(Runnable runnable) {
                    com.bytedance.sdk.openadsdk.fv.z.z().dl().execute(runnable);
                }

                @Override // com.bytedance.pangle.m
                public void g(Runnable runnable) {
                    com.bytedance.sdk.openadsdk.fv.z.z().dl().execute(runnable);
                }

                @Override // com.bytedance.pangle.m
                public void dl(Runnable runnable) {
                    new Handler(Looper.getMainLooper()).post(runnable);
                }
            });
            GlobalParam globalParam = GlobalParam.getInstance();
            globalParam.setReporter(iZeusReporter);
            globalParam.setCheckPermission(false);
            globalParam.setDownloadDir(dl(context));
            globalParam.setLogger(new g());
            globalParam.setSignature("com.byted.pangle", "MIIDfTCCAmWgAwIBAgIEfRwYPjANBgkqhkiG9w0BAQsFADBvMQswCQYDVQQGEwJDTjEQMA4GA1UECBMHQmVpamluZzEQMA4GA1UEBxMHQmVpamluZzESMBAGA1UEChMJQnl0ZURhbmNlMQ8wDQYDVQQLEwZQYW5nbGUxFzAVBgNVBAMTDkNodWFuIFNoYW4gSmlhMB4XDTIxMTEwODA2MjQzOVoXDTQ2MTEwMjA2MjQzOVowbzELMAkGA1UEBhMCQ04xEDAOBgNVBAgTB0JlaWppbmcxEDAOBgNVBAcTB0JlaWppbmcxEjAQBgNVBAoTCUJ5dGVEYW5jZTEPMA0GA1UECxMGUGFuZ2xlMRcwFQYDVQQDEw5DaHVhbiBTaGFuIEppYTCCASIwDQYJKoZIhvcNAQEBBQADggEPADCCAQoCggEBAIBKeRL+4mfCn1SLYv6OemfwwItkjlLPyqOEugkV6lanFTcZgLwEl5LIkL0y28UncPtMX1Mii6DzCdJ/plw7S9+RT/hYDneu339IKWojaU2qai/5FokHlQ0MMnYl5yry00ghVPsl1u+03cQA2ZnjIMiFhrBJpQzHt7IYvq2aEEMBcY8uT7iFoBI848e1mL1joVS2z02C3NliP7ZNARkXH+rTQAlCJulT5IZk+V/PTaKqzgNrkhsKh0/tBmU7m8u79x/xpgGsE19H18AgS4P/9/MDCRe2Z35boZeccaUy2MXCwv3djzUcDk3rRzQPYzdpyyRnrFMuhiKesc5VHgUMs9kCAwEAAaMhMB8wHQYDVR0OBBYEFENENrNWGzc2WhxdvhoMDs57U70zMA0GCSqGSIb3DQEBCwUAA4IBAQAHqDCrmvyBBmIGXwuL1rwS/Qv9ZJIZykBIaNMm+H1IfitCl4yXd9N2n+PjE0UZtxZ21UZOt9wAr+RFiSl5YRXqpt7WLARTy4YW3RiQ+wiL7bshzeSYBoSiC427Bfeq0WjwY0/jHlr8uouppyJOz++6U9hrYX2EW/6UjH5XlWiKQJ6b2ZzPcP8Xpg/TJn4tWvXJP6jw9kRRP2GmMttY78leWQst2QEZILmWJubXRLPj9O+qx2uP9oGTD4sc1vb9hzkOHBIHzGaalqLFbbGaeFpLFHoGTsnOfPTwUVKDZYmxbkcmR1bp7eYOW+nSQNMLn0FjDewZl5l37Sa/gz0WVHon");
            globalParam.setSignature("com.byted.csj.ext", "MIIDezCCAmOgAwIBAgIENkE1KDANBgkqhkiG9w0BAQsFADBtMQswCQYDVQQGEwI4NjEQMA4GA1UECBMHYmVpamluZzEQMA4GA1UEBxMHYmVpamluZzESMBAGA1UEChMJYnl0ZWRhbmNlMRIwEAYDVQQLEwlieXRlZGFuY2UxEjAQBgNVBAMTCWJ5dGVkYW5jZTAgFw0yMjExMDIwODI3MzlaGA8yMDUwMDMyMDA4MjczOVowbTELMAkGA1UEBhMCODYxEDAOBgNVBAgTB2JlaWppbmcxEDAOBgNVBAcTB2JlaWppbmcxEjAQBgNVBAoTCWJ5dGVkYW5jZTESMBAGA1UECxMJYnl0ZWRhbmNlMRIwEAYDVQQDEwlieXRlZGFuY2UwggEiMA0GCSqGSIb3DQEBAQUAA4IBDwAwggEKAoIBAQCc9Z2F3xxOMX1qTXMy2aPmS9OSkqrp8C8bHwS1hkNVR4umKREuqOn73INNo+R706jaCVnlPwxDwWjtX6H74DE4CveivyM9f2wNC3yIyDW+5j7lW/keTQcOlGLDEJQv4O/6FbB/jNU6epjyNaNIZhgZcvTpgaSixbdyHzRTFmvMh+WovdVK/J9LnHOQ+pmPZj7NB6MQRGMUrPEotLHQca3cmnLrnPAaZQaVoaFE9lOt9syyqEuf361SprNIGDtbkJuX3EqV/QOKWFwZX94IS7ZGSvfyCojcD4kaUSbaSoZC7zEuBb7l69g+ZMrJ/v6wkm01wxsNNssUwF7k6Sp0zubbAgMBAAGjITAfMB0GA1UdDgQWBBSxk+gVdDco1dP65hP67qoKNlMEYDANBgkqhkiG9w0BAQsFAAOCAQEAfosExl/AYEbS2xqHBTHa28cvnp/SElUQuzW6aWLqkfk9cxmFSI/euUV3/eB8RN+U2X47Y05u6+XUxTv0tSSEtyXNawm0qWH8jkR4gZY38YqBChKjhea668oT5X3Uocrw7SYXO/BfI8SKPa0uI/U8Cyl3uctbmmq/pPUkd3mKAy+HgyJoThD6K0oyiADlygngUMVTv6Uvid4qPj/bBnxI+LvVeX4l1dxGqWkiafQW9sz+RbFdge3X2XsSH4eo01BsCwOYEv1lHO2FrbAtFNpnIsSqrERdFaAJZ3tlJmg9bA03png8A2AajEjkhaOhduJB8zkSlvHNpoQMIAS9WtkG/w==");
            globalParam.setSignature("com.byted.live.lite", "MIIDSTCCAjGgAwIBAgIEaLy5tzANBgkqhkiG9w0BAQsFADBVMQswCQYDVQQGEwIxMTEMMAoGA1UECBMDMTExMQ4wDAYDVQQHEwUxMTExMTEMMAoGA1UEChMDMTExMQwwCgYDVQQLEwMxMTExDDAKBgNVBAMTAzExMTAeFw0yMDEyMDMxMjQyMTJaFw00NTExMjcxMjQyMTJaMFUxCzAJBgNVBAYTAjExMQwwCgYDVQQIEwMxMTExDjAMBgNVBAcTBTExMTExMQwwCgYDVQQKEwMxMTExDDAKBgNVBAsTAzExMTEMMAoGA1UEAxMDMTExMIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA45E52YdkJm4gPCXZq7KDoM1h6pgSswllC/CwDOmh8pDGvX4ROaYP1vr2biRlXMHg7G0iXpxWVdlTtx+4QFd3dC+cGJQk0f6apGo2n2RpMA0zIsSf0VO1a3GjWLei5INo+4RDdciqJ4jfsoqBIjZETRkky+UU4eO/oyrAwOu4KdMln3Bg3u7eHWU4kMFrXxrRruT3Q/9gzlO90yQa0CZPWVDrk6cGJtJwJGhWm+62S3U8D26HE++eGP7ve83QBDGtKqx7HpCAFWUiYBgXGq12H0amQDkKcPcr/EFCaBlombSgkN0t6zBX80m+wcUPC75IBTmMV/DT2dXcgjZ2I1JSCQIDAQABoyEwHzAdBgNVHQ4EFgQUPDyIeKI0KhZFPHyn36gMMIYrpukwDQYJKoZIhvcNAQELBQADggEBAHkl0DoCRwn+XKsDJE+wGMpBBqUDzL6DSOnJx4SNqb7YZZU0ThcDK7jY4If3QRkvMio6ODrVZc2U/m/Tc3VeMk5h2W2UZRUWHNH3k9Xe0720uL20ZeH2Y6IG4L5HG8kIbTbFtX3gJpPG/xAcez+CzyCFLWQAZt1N+csG0syWkXJ0Nryq8VrgSCyCXD1KzFxrOe+65wtu50Vi68Vlbk7BZe/G8Qm0RhKmxq5BPMBJ4uY3be+03Ba5qC//o1XQHOEAjrJKXcN5wqHdFZTkmuxVyIPogZOzx4JlNl0zOrYGDJxp7aZfKF9FkXQyF7x0Ns3mZEtjx/+flXRzAAU9MDhPr/0=");
            Zeus.registerPluginStateListener(new ZeusPluginStateListener() { // from class: com.bytedance.sdk.openadsdk.api.plugin.fo.4
                @Override // com.bytedance.pangle.ZeusPluginStateListener
                public void onPluginStateChange(String str, int i, Object... objArr) {
                    com.bytedance.sdk.openadsdk.api.m.g("TTPluginManager", str + " state changed, " + i);
                    if (i != 9 || TextUtils.equals(str, "com.byted.pangle")) {
                        return;
                    }
                    fo.this.a(str);
                }
            });
            Zeus.setDecodeCallback(new ZeusPluginDecodeCallback() { // from class: com.bytedance.sdk.openadsdk.api.plugin.fo.5
                @Override // com.bytedance.pangle.ZeusPluginDecodeCallback
                public String decode(String str) {
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        String strOptString = jSONObject.optString("cypher");
                        String strOptString2 = jSONObject.optString("message");
                        if (!TextUtils.equals(strOptString, "3") || TextUtils.isEmpty(strOptString2)) {
                            return null;
                        }
                        return com.bytedance.sdk.openadsdk.api.plugin.dl.g.g(strOptString2);
                    } catch (Throwable th) {
                        com.bytedance.sdk.openadsdk.api.m.g("TTPluginManager", "dex plugin decode throw error ".concat(String.valueOf(th)));
                        return null;
                    }
                }
            });
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("isDexPlugin", 1);
                jSONObject.put("apiVersionCode", 1000);
                jSONObject.put("packageName", "com.byted.mixed");
                jSONObject.put("hostPackageName", "com.byted.pangle");
                jSONObject.put("minPluginVersion", 1000);
                jSONObject.put("maxPluginVersion", 999999999);
                jSONObject.put("internalPath", "");
                jSONObject.put("internalVersionCode", -1);
                jSONObject.put("appKey", "");
                jSONObject.put("appSecretKey", "");
                Zeus.addPackageDexManager("com.byted.mixed", jSONObject);
            } catch (Throwable th) {
                com.bytedance.sdk.openadsdk.api.m.g("TTPluginManager", "init dex plugin config throw error " + th);
            }
            globalParam.closeBgDex2oat(true);
            Zeus.init((Application) context);
            Zeus.registerPluginInstallListener(new ZeusPluginInstallListener() { // from class: com.bytedance.sdk.openadsdk.api.plugin.fo.6
                @Override // com.bytedance.pangle.ZeusPluginInstallListener
                public void onPluginInstall(String str, int i, String str2) {
                    if (i == 7) {
                        fo.this.g(str, i);
                        return;
                    }
                    if (i == 6) {
                        fo.this.g(str, i);
                        if (fo.this.kb != null && "com.byted.pangle".equals(str)) {
                            fo.this.kb.onEvent(0, com.bykv.z.z.z.z.g.z().z(true).g());
                        } else {
                            com.bytedance.sdk.openadsdk.api.m.g("TTPluginManager", "no main pl");
                        }
                    }
                }
            });
            this.e = true;
        } catch (Throwable th2) {
            com.bytedance.sdk.openadsdk.api.m.a("TTPluginManager", "Unexpected error for init zeus.", th2);
            this.gz = th2.getMessage();
        }
        PluginManager pluginManager = PluginManager.getInstance();
        pluginManager.registerPlugin("{apiVersionCode:7105,packageName:com.byted.pangle,minPluginVersion:7105,internalPath:'',internalVersionCode:7105}");
        pluginManager.registerPlugin("{apiVersionCode:999,packageName:com.byted.csj.ext,minPluginVersion:1000,maxPluginVersion:999999999,internalPath:'',internalVersionCode:-1,appKey:'',appSecretKey:''}");
        pluginManager.registerPlugin("{apiVersionCode:2114,packageName:com.byted.live.lite,minPluginVersion:211400,maxPluginVersion:999999,isSupportLibIsolate:true}");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        Plugin plugin = Zeus.getPlugin(str, false);
        try {
            if (plugin.mClassLoader != null) {
                TTAdSdk.getAdManager().register(com.bykv.z.z.z.z.dl.z(3).z(0, 1).z(1, str).z(2, plugin.mClassLoader).g().sparseArray());
            }
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.api.m.g("TTPluginManager", "initPluginService failed in " + str, th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(String str, int i) {
        if ("com.byted.pangle".equals(str) && i == 6) {
            com.bytedance.sdk.openadsdk.api.m.a("TTPluginManager", "notify to end wait");
            this.m.countDown();
        }
        z(i == 6, str);
    }

    private static File dl(Context context) {
        return new File(com.bytedance.sdk.openadsdk.api.plugin.g.z(context, "tt_pangle_bykv_file", 0), z);
    }

    private static boolean a(Context context) {
        File fileDl = dl(context);
        return fileDl.exists() && fileDl.listFiles().length != 0;
    }

    public Bundle z(String str, Bundle bundle) {
        String strZ = z(str);
        if (!TextUtils.isEmpty(strZ)) {
            bundle.putString(PluginConstants.KEY_PLUGIN_VERSION, strZ);
        }
        Bundle bundle2 = new Bundle();
        bundle2.putBundle(str, bundle);
        Bundle bundle3 = new Bundle();
        bundle3.putBundle(PluginConstants.KEY_PL_CONFIG_INFO, bundle2);
        return bundle3;
    }

    public static String z(String str) {
        Plugin plugin;
        try {
            if (!Zeus.isPluginInstalled(str, false) || (plugin = Zeus.getPlugin(str, false)) == null) {
                return null;
            }
            return z(plugin.getVersion());
        } catch (Throwable unused) {
            com.bytedance.sdk.openadsdk.api.m.a("TTPluginManager", "Get local version failed");
            return null;
        }
    }

    public static String g(String str) {
        int installedMaxVer;
        try {
            Plugin plugin = Zeus.getPlugin(str, false);
            if (plugin == null || (installedMaxVer = plugin.getInstalledMaxVer()) <= 0) {
                return null;
            }
            return z(installedMaxVer);
        } catch (Throwable unused) {
            com.bytedance.sdk.openadsdk.api.m.a("TTPluginManager", "Get local version failed");
            return null;
        }
    }

    public void z(final TTPluginListener tTPluginListener) {
        if (!this.e) {
            com.bytedance.sdk.openadsdk.api.m.a("TTPluginManager", "Zeus init failed.");
            if (tTPluginListener != null) {
                tTPluginListener.onPluginListener(1002, null, null, null);
                return;
            }
            return;
        }
        Handler handlerG = com.bytedance.sdk.openadsdk.fv.z.z().g();
        Runnable runnable = new Runnable() { // from class: com.bytedance.sdk.openadsdk.api.plugin.fo.7
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.api.m.g("TTPluginManager", "Load plugin failed, caused by timeout.");
                tTPluginListener.onPluginListener(1001, null, null, null);
            }
        };
        handlerG.postDelayed(runnable, 180000L);
        String strPackageName = tTPluginListener.packageName();
        Plugin plugin = (Zeus.isPluginInstalled(strPackageName) && (Zeus.isPluginLoaded(strPackageName) || Zeus.loadPlugin(strPackageName))) ? Zeus.getPlugin(strPackageName) : null;
        com.bytedance.sdk.openadsdk.api.m.g("TTPluginManager", "Find plugin:" + (plugin != null));
        if (plugin != null) {
            z(plugin);
            handlerG.removeCallbacks(runnable);
            tTPluginListener.onPluginListener(1000, plugin.mClassLoader, plugin.mResources, null);
        } else {
            g.put(strPackageName, tTPluginListener);
            dl.put(strPackageName, handlerG);
        }
    }

    public void g(TTPluginListener tTPluginListener) {
        String strPackageName = tTPluginListener.packageName();
        Plugin plugin = (Zeus.isPluginInstalled(strPackageName) && (Zeus.isPluginLoaded(strPackageName) || Zeus.loadPlugin(strPackageName))) ? Zeus.getPlugin(strPackageName) : null;
        com.bytedance.sdk.openadsdk.api.m.g("TTPluginManager", "Find plugin:" + (plugin != null));
        if (plugin != null) {
            z(plugin);
            tTPluginListener.onPluginListener(1000, plugin.mClassLoader, plugin.mResources, null);
        } else {
            wp = tTPluginListener;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static z gc(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return z(new JSONObject(str));
        } catch (JSONException unused) {
            com.bytedance.sdk.openadsdk.api.m.gc("TTPluginManager", "Invalid plugin info:" + str);
            return null;
        }
    }

    private static z z(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        z zVar = new z();
        zVar.dl = jSONObject.optString(an.o);
        zVar.f897a = jSONObject.optInt("version_code");
        zVar.gc = jSONObject.optString("download_url");
        zVar.e = jSONObject.optString(TKDownloadReason.KSAD_TK_MD5);
        zVar.fo = jSONObject.optInt("min_version");
        zVar.uy = jSONObject.optInt("max_version");
        zVar.z = jSONObject.optString("sign");
        zVar.m = jSONObject.optBoolean("is_revert") ? 3 : 2;
        zVar.g = new File(jSONObject.optString("plugin_file"));
        return zVar;
    }

    private static void z(Plugin plugin) {
        if (plugin == null) {
            com.bytedance.sdk.openadsdk.api.m.a("TTPluginManager", "plugin is null.");
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("action", 0);
        bundle.putString("plugin_pkg_name", plugin.mPkgName);
        bundle.putString(PluginConstants.KEY_PLUGIN_VERSION, z(plugin.getVersion()));
        TTAdManager adManager = TTAdSdk.getAdManager();
        if (adManager != null) {
            adManager.getExtra(Bundle.class, bundle);
        }
    }

    public static String z(int i) {
        char[] charArray = String.valueOf(i).toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < charArray.length; i2++) {
            sb.append(charArray[i2]);
            if (i2 < charArray.length - 1) {
                sb.append(FileUtils.FILE_EXTENSION_SEPARATOR);
            }
        }
        return sb.toString();
    }

    private static boolean z(TTPluginListener tTPluginListener, String str) {
        if (tTPluginListener == null || tTPluginListener.packageName() == null) {
            return false;
        }
        return tTPluginListener.packageName().equals(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean g(z zVar) {
        if (zVar == null || zVar.g == null) {
            com.bytedance.sdk.openadsdk.api.m.a("TTPluginManager", "plugin config is null");
            return false;
        }
        boolean zSyncInstallPlugin = Zeus.syncInstallPlugin(zVar.dl, zVar.g.getAbsolutePath());
        z(zSyncInstallPlugin, zVar.dl);
        return zSyncInstallPlugin;
    }

    private static void z(boolean z2, String str) {
        HashMap<String, TTPluginListener> map = g;
        TTPluginListener tTPluginListener = map.get(str);
        com.bytedance.sdk.openadsdk.api.m.g("TTPluginManager", "Install dl plugin " + str + (z2 ? " success" : " failed") + ", need notify: " + (tTPluginListener != null));
        HashMap<String, Handler> map2 = dl;
        Handler handler = map2.get(str);
        if (z2) {
            TTPluginListener tTPluginListener2 = wp;
            if (!z(tTPluginListener2, str) && (tTPluginListener == null || handler == null)) {
                return;
            }
            if (Zeus.loadPlugin(str)) {
                Plugin plugin = Zeus.getPlugin(str);
                z(plugin);
                if (handler != null) {
                    handler.removeCallbacksAndMessages(null);
                }
                if (tTPluginListener != null) {
                    tTPluginListener.onPluginListener(1000, plugin.mClassLoader, plugin.mResources, null);
                }
                if (z(tTPluginListener2, str)) {
                    tTPluginListener2.onPluginListener(1000, plugin.mClassLoader, plugin.mResources, null);
                    wp = null;
                }
            } else {
                com.bytedance.sdk.openadsdk.api.m.g("TTPluginManager", "handle installed, load failed");
                dl(str, 1002);
            }
        } else {
            com.bytedance.sdk.openadsdk.api.m.g("TTPluginManager", "handle installed failed");
            dl(str, 1003);
        }
        map.remove(str);
        map2.remove(str);
    }

    public static void z(Throwable th) {
        if (th instanceof AbstractMethodError) {
            Zeus.unInstallPlugin("com.byted.pangle");
            com.bytedance.sdk.openadsdk.api.m.a("TTPluginManager", "AbstractMethodError, rollback to builtin version.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void dl(String str, int i) {
        com.bytedance.sdk.openadsdk.api.m.a("TTPluginManager", "plugin update failed");
        Bundle bundle = new Bundle();
        bundle.putInt("code", i);
        TTPluginListener tTPluginListener = g.get(str);
        if (tTPluginListener != null) {
            tTPluginListener.onPluginListener(1001, null, null, bundle);
        }
    }

    private static final class g implements IZeusLogger {
        private g() {
        }

        @Override // com.bytedance.pangle.log.IZeusLogger
        public void v(String str, String str2) {
            com.bytedance.sdk.openadsdk.api.m.z(str, str2);
        }

        @Override // com.bytedance.pangle.log.IZeusLogger
        public void i(String str, String str2) {
            com.bytedance.sdk.openadsdk.api.m.dl(str, str2);
        }

        @Override // com.bytedance.pangle.log.IZeusLogger
        public void w(String str, String str2) {
            com.bytedance.sdk.openadsdk.api.m.a(str, str2);
        }

        @Override // com.bytedance.pangle.log.IZeusLogger
        public void w(String str, String str2, Throwable th) {
            com.bytedance.sdk.openadsdk.api.m.a(str, str2, th);
        }

        @Override // com.bytedance.pangle.log.IZeusLogger
        public void e(String str, String str2, Throwable th) {
            com.bytedance.sdk.openadsdk.api.m.gc(str, str2, th);
        }
    }

    static final class dl implements Serializable, Function<SparseArray<Object>, Object> {
        dl() {
        }

        @Override // java.util.function.Function
        /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
        public Object apply(SparseArray<Object> sparseArray) {
            if (sparseArray == null) {
                return null;
            }
            ValueSet valueSetG = com.bykv.z.z.z.z.dl.z(sparseArray).g();
            int iIntValue = valueSetG.intValue(-99999987);
            SparseArray sparseArray2 = (SparseArray) valueSetG.objectValue(-99999979, SparseArray.class);
            if (sparseArray2 == null) {
                return null;
            }
            ValueSet valueSetG2 = com.bykv.z.z.z.z.dl.z((SparseArray<Object>) sparseArray2).g();
            return z(iIntValue, com.bykv.z.z.z.z.g.z().z(valueSetG2.intValue(-999900)).z(valueSetG2.stringValue(-999901)).z(valueSetG2.booleanValue(-999903)).z(com.bykv.z.z.z.z.dl.z((SparseArray<Object>) valueSetG2.objectValue(-999902, SparseArray.class)).g()).g());
        }

        public SparseArray<Object> z(int i, Result result) {
            com.bykv.z.z.z.z.dl dlVarZ = com.bykv.z.z.z.z.dl.z();
            if (i == 1) {
                gc.z("plugin_download", "plugin update start");
                ValueSet valueSetValues = result.values();
                if (valueSetValues == null) {
                    gc.z("plugin_download", "valueSet empty");
                    return null;
                }
                String strStringValue = valueSetValues.stringValue(3);
                int iCode = result.code();
                if (result.isSuccess()) {
                    z zVarGc = fo.gc(valueSetValues.stringValue(2));
                    if (zVarGc == null || TextUtils.isEmpty(zVarGc.dl)) {
                        gc.z("plugin_download", "plugin update received with invalid config");
                        com.bytedance.sdk.openadsdk.api.m.a("TTPluginManager", "plugin update received with invalid config");
                        return null;
                    }
                    gc.z("plugin_download", "plugin update received: " + zVarGc.dl);
                    com.bytedance.sdk.openadsdk.api.m.a("TTPluginManager", "plugin update received: " + zVarGc.dl);
                    if (zVarGc.z()) {
                        gc.z("plugin_download", "plugin revert " + zVarGc.dl);
                        Zeus.unInstallPlugin(zVarGc.dl);
                    } else {
                        z(zVarGc);
                        gc.z("plugin_download", "plugin install");
                        if (fo.g(zVarGc)) {
                            dlVarZ.z(4, true);
                        }
                    }
                } else {
                    gc.z("plugin_download", "plugin update received failed");
                    com.bytedance.sdk.openadsdk.api.m.a("TTPluginManager", "plugin update received failed");
                    fo.dl(strStringValue, iCode);
                    return null;
                }
            }
            return dlVarZ.g().sparseArray();
        }

        private void z(z zVar) {
            try {
                if (TextUtils.isEmpty(zVar.dl) || !zVar.dl.equals("com.byted.pangle")) {
                    return;
                }
                fo.z(TTAppContextHolder.getContext()).dl();
            } catch (Exception unused) {
            }
        }
    }

    public void dl() {
        EventListener eventListener = this.kb;
        if (eventListener != null) {
            eventListener.onEvent(1, com.bykv.z.z.z.z.g.z().z(true).g());
        }
    }

    private static final class z {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f897a;
        public String dl;
        public String e;
        public String gc;
        public int m;
        public String z = "";
        public File g = null;
        public int fo = 0;
        public int uy = Integer.MAX_VALUE;
        public List<String> gz = null;

        z() {
        }

        public boolean z() {
            return this.m == 3;
        }
    }
}
