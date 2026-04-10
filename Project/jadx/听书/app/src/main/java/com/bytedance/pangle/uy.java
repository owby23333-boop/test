package com.bytedance.pangle;

import android.app.Application;
import android.content.pm.PackageInfo;
import android.content.pm.ProviderInfo;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.bytedance.pangle.log.IZeusReporter;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.provider.ContentProviderManager;
import com.bytedance.pangle.servermanager.MainServerManager;
import com.bytedance.pangle.util.FieldUtils;
import com.bytedance.pangle.util.MethodUtils;
import com.bytedance.pangle.util.kb;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class uy {
    private static volatile uy z;
    private boolean g;
    private final List<ZeusPluginStateListener> dl = new CopyOnWriteArrayList();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<ZeusPluginEventCallback> f538a = new ArrayList();
    private final Handler gc = new Handler(Looper.getMainLooper());
    private ZeusPluginDecodeCallback m = null;
    private Map<String, JSONObject> e = new ConcurrentHashMap();

    public static uy z() {
        if (z == null) {
            synchronized (uy.class) {
                if (z == null) {
                    z = new uy();
                }
            }
        }
        return z;
    }

    synchronized void z(Application application) {
        if (this.g) {
            ZeusLogger.w(ZeusLogger.TAG_INIT, "ZeusManager zeus has been inited!");
            return;
        }
        z(3000, 0, null, -1, null);
        Zeus.setAppContext(application);
        GlobalParam globalParam = GlobalParam.getInstance();
        globalParam.init();
        if (application == null) {
            GlobalParam.getInstance().getReporter().saveRecord(IZeusReporter.ZEUS_STAGE_ERROR, "context is null");
            throw new IllegalArgumentException("context must be not null !!!");
        }
        ZeusLogger.setDebug(globalParam.isDebug());
        ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusManager init, context = " + application + ", hParam = " + globalParam);
        com.bytedance.pangle.gc.gc.g(new Runnable() { // from class: com.bytedance.pangle.uy.1
            @Override // java.lang.Runnable
            public void run() {
                kb.g();
            }
        });
        if (GlobalParam.getInstance().isPostBgDexOptByInit()) {
            com.bytedance.pangle.m.m.z();
        }
        com.bytedance.pangle.a.g.z().z(new com.bytedance.pangle.a.z() { // from class: com.bytedance.pangle.uy.2
            @Override // com.bytedance.pangle.a.z
            public void z(String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
                com.bytedance.pangle.log.g.z(str, jSONObject, jSONObject2, jSONObject3);
            }
        });
        if (!globalParam.isCloseFlipped()) {
            g.z();
        }
        if (com.bytedance.pangle.util.fo.p()) {
            com.bytedance.pangle.gc.gc.z(new Runnable() { // from class: com.bytedance.pangle.uy.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        GlobalParam.getInstance().getReporter().saveRecord(IZeusReporter.ZEUS_STAGE_COMMON, "invoke SystemConfig");
                        MethodUtils.invokeStaticMethod(Class.forName("com.android.server.SystemConfig"), "getInstance", new Object[0]);
                    } catch (Throwable th) {
                        GlobalParam.getInstance().getReporter().saveRecord(IZeusReporter.ZEUS_STAGE_ERROR, "invoke SystemConfig error : ".concat(String.valueOf(th)));
                    }
                }
            });
        }
        if (com.bytedance.pangle.util.fo.pf()) {
            e();
        }
        m();
        ContentProviderManager.getInstance().initSystemContentProviderInfo();
        if (!globalParam.closeHookHuaweiOnInit()) {
            Zeus.hookHuaWeiVerifier(application);
        }
        this.g = true;
        z(ZeusPluginEventCallback.EVENT_FINISH_INITIALIZATION, 0, null, -1, null);
    }

    private void m() {
        GlobalParam.getInstance().getReporter().saveRecord(IZeusReporter.ZEUS_STAGE_SERVER_MANAGER, TtmlNode.START);
        try {
            PackageInfo packageInfo = Zeus.getAppApplication().getPackageManager().getPackageInfo(Zeus.getAppApplication().getPackageName(), 8);
            if (packageInfo != null && packageInfo.providers != null) {
                for (ProviderInfo providerInfo : packageInfo.providers) {
                    if (!TextUtils.isEmpty(providerInfo.authority) && providerInfo.authority.contains(Zeus.getAppApplication().getPackageName() + ".pangle.servermanager.")) {
                        String str = (TextUtils.isEmpty(providerInfo.processName) || !providerInfo.processName.contains(":")) ? "main" : providerInfo.processName.split(":")[1];
                        if (Zeus.getServerManagerHashMap().get(str) == null || !TextUtils.equals(str, "main") || !TextUtils.equals(providerInfo.name, MainServerManager.class.getName())) {
                            Zeus.getServerManagerHashMap().put(str, providerInfo);
                        }
                    }
                }
                GlobalParam.getInstance().getReporter().saveRecord(IZeusReporter.ZEUS_STAGE_SERVER_MANAGER, "finish");
                return;
            }
            ZeusLogger.errReport(ZeusLogger.TAG_INIT, "initServerManager failed. packageInfo:".concat(String.valueOf(packageInfo)));
        } catch (Exception e) {
            GlobalParam.getInstance().getReporter().saveRecord(IZeusReporter.ZEUS_STAGE_SERVER_MANAGER, "error:".concat(String.valueOf(e)));
            throw new RuntimeException(e);
        }
    }

    public boolean g() {
        return this.g;
    }

    public List<ZeusPluginStateListener> dl() {
        return this.dl;
    }

    public void z(ZeusPluginStateListener zeusPluginStateListener) {
        this.dl.add(zeusPluginStateListener);
    }

    public void g(ZeusPluginStateListener zeusPluginStateListener) {
        List<ZeusPluginStateListener> list = this.dl;
        if (list != null) {
            list.remove(zeusPluginStateListener);
        }
    }

    public void z(ZeusPluginEventCallback zeusPluginEventCallback) {
        if (zeusPluginEventCallback == null) {
            return;
        }
        synchronized (this.f538a) {
            this.f538a.add(zeusPluginEventCallback);
        }
    }

    public void g(ZeusPluginEventCallback zeusPluginEventCallback) {
        if (zeusPluginEventCallback == null) {
            return;
        }
        synchronized (this.f538a) {
            this.f538a.remove(zeusPluginEventCallback);
        }
    }

    public void z(final int i, final int i2, final String str, final int i3, final Throwable th) {
        for (final Object obj : gz()) {
            this.gc.post(new Runnable() { // from class: com.bytedance.pangle.uy.4
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        ((ZeusPluginEventCallback) obj).onPluginEvent(i, i2, str, i3, th);
                    } catch (Throwable unused) {
                    }
                }
            });
        }
    }

    private void e() {
        try {
            GlobalParam.getInstance().getReporter().saveRecord(IZeusReporter.ZEUS_STAGE_COMMON, "invoke disableApiWarning");
            FieldUtils.writeField(com.bytedance.pangle.gc.z.z(), "mHiddenApiWarningShown", Boolean.TRUE);
            ZeusLogger.w(ZeusLogger.TAG_INIT, "ZeusManager disableApiWarningShownForAndroidP, true");
        } catch (Exception e) {
            ZeusLogger.errReport(ZeusLogger.TAG_INIT, "disableApiWarningShownForAndroidP failed", e);
        }
    }

    private Object[] gz() {
        Object[] array;
        synchronized (this.f538a) {
            array = !this.f538a.isEmpty() ? this.f538a.toArray() : null;
        }
        return array == null ? new Object[0] : array;
    }

    public void z(ZeusPluginDecodeCallback zeusPluginDecodeCallback) {
        this.m = zeusPluginDecodeCallback;
    }

    public ZeusPluginDecodeCallback a() {
        return this.m;
    }

    public Map<String, JSONObject> gc() {
        return this.e;
    }
}
