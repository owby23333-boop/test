package com.qq.e.comm.managers;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.qq.e.ads.dfa.GDTAppDialogClickListener;
import com.qq.e.comm.managers.devtool.DevTools;
import com.qq.e.comm.managers.plugin.PM;
import com.qq.e.comm.util.GDTLogger;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes3.dex */
public class b implements IGDTAdManager {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ExecutorService f17802g = Executors.newSingleThreadExecutor();
    private volatile Boolean a;
    private volatile boolean b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile Context f17803c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile PM f17804d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile DevTools f17805e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private volatile String f17806f;

    private static final class a {
        private static b a = new b(null);
    }

    private b() {
        this.a = Boolean.FALSE;
        this.b = false;
    }

    /* synthetic */ b(com.qq.e.comm.managers.a aVar) {
        this();
    }

    public static b b() {
        return a.a;
    }

    public String a() {
        return this.f17806f;
    }

    synchronized boolean a(Context context, String str) {
        if (Build.VERSION.SDK_INT < 14) {
            GDTLogger.e("GDTADManager初始化错误，SDK不支持Android 4.0以下版本");
            return false;
        }
        if (this.a.booleanValue()) {
            return true;
        }
        if (context == null || TextUtils.isEmpty(str)) {
            GDTLogger.e("GDTADManager初始化错误，context和appId不能为空");
            return false;
        }
        try {
            this.f17806f = str;
            this.f17803c = context.getApplicationContext();
            this.f17804d = new PM(this.f17803c, null);
            f17802g.submit(new com.qq.e.comm.managers.a(this));
            this.a = Boolean.TRUE;
            return true;
        } catch (Throwable th) {
            GDTLogger.e("GDTADManager初始化错误", th);
            return false;
        }
    }

    public PM c() {
        return this.f17804d;
    }

    public boolean d() {
        if (this.a != null && this.a.booleanValue()) {
            return true;
        }
        GDTLogger.e("SDK 尚未初始化，请在 Application 中调用 GDTAdSdk.init() 初始化");
        return false;
    }

    @Override // com.qq.e.comm.managers.IGDTAdManager
    public String getBuyerId(Map<String, Object> map) {
        if (!d()) {
            return "";
        }
        try {
            return this.f17804d.getPOFactory().getBuyerId(map);
        } catch (Exception e2) {
            GDTLogger.e("SDK 初始化异常", e2);
            return "";
        }
    }

    @Override // com.qq.e.comm.managers.IGDTAdManager
    public DevTools getDevTools() {
        if (this.f17805e == null) {
            this.f17805e = new DevTools();
        }
        return this.f17805e;
    }

    @Override // com.qq.e.comm.managers.IGDTAdManager
    public String getSDKInfo(String str) {
        if (!d()) {
            return "";
        }
        try {
            return this.f17804d.getPOFactory().getSDKInfo(str);
        } catch (Exception e2) {
            GDTLogger.e("SDK 初始化异常", e2);
            return "";
        }
    }

    @Override // com.qq.e.comm.managers.IGDTAdManager
    public int showOpenOrInstallAppDialog(GDTAppDialogClickListener gDTAppDialogClickListener) {
        if (!this.b) {
            return 0;
        }
        try {
            return this.f17804d.getPOFactory().showOpenOrInstallAppDialog(gDTAppDialogClickListener);
        } catch (Exception e2) {
            GDTLogger.e("SDK 初始化异常", e2);
            return 0;
        }
    }
}
