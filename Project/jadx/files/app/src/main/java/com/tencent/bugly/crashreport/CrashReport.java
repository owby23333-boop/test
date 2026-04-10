package com.tencent.bugly.crashreport;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.CrashModule;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.crash.h5.H5JavaScriptInterface;
import com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler;
import com.tencent.bugly.proguard.aa;
import com.tencent.bugly.proguard.ac;
import com.tencent.bugly.proguard.ak;
import com.tencent.bugly.proguard.al;
import com.tencent.bugly.proguard.an;
import com.tencent.bugly.proguard.ap;
import com.tencent.bugly.proguard.aq;
import com.tencent.bugly.proguard.at;
import com.tencent.bugly.proguard.au;
import com.tencent.bugly.proguard.bc;
import com.tencent.bugly.proguard.p;
import com.tencent.bugly.proguard.r;
import com.tencent.bugly.proguard.s;
import com.tencent.bugly.proguard.w;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.y;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes.dex */
public class CrashReport {
    private static Context a;

    /* JADX INFO: compiled from: BUGLY */
    /* JADX INFO: loaded from: classes3.dex */
    public static class CrashHandleCallback extends BuglyStrategy.a {
    }

    /* JADX INFO: compiled from: BUGLY */
    public static class UserStrategy extends BuglyStrategy {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        CrashHandleCallback f18389c;

        public UserStrategy(Context context) {
        }

        @Override // com.tencent.bugly.BuglyStrategy
        public synchronized int getCallBackType() {
            return this.a;
        }

        @Override // com.tencent.bugly.BuglyStrategy
        public synchronized boolean getCloseErrorCallback() {
            return this.b;
        }

        @Override // com.tencent.bugly.BuglyStrategy
        public synchronized void setCallBackType(int i2) {
            this.a = i2;
        }

        @Override // com.tencent.bugly.BuglyStrategy
        public synchronized void setCloseErrorCallback(boolean z2) {
            this.b = z2;
        }

        public synchronized void setCrashHandleCallback(CrashHandleCallback crashHandleCallback) {
            this.f18389c = crashHandleCallback;
        }

        @Override // com.tencent.bugly.BuglyStrategy
        public synchronized CrashHandleCallback getCrashHandleCallback() {
            return this.f18389c;
        }
    }

    /* JADX INFO: compiled from: BUGLY */
    /* JADX INFO: loaded from: classes3.dex */
    public interface a {
        String a();

        void a(H5JavaScriptInterface h5JavaScriptInterface, String str);

        void a(String str);

        void b();

        CharSequence c();
    }

    public static void closeBugly() {
        if (p.a && CrashModule.getInstance().hasInitialized() && a != null) {
            aq aqVarA = aq.a();
            if (aqVarA != null) {
                aqVarA.b(a);
            }
            closeCrashReport();
            s.a(a);
            ak akVarA = ak.a();
            if (akVarA != null) {
                akVarA.b();
            }
        }
    }

    public static void closeCrashReport() {
        if (p.a && CrashModule.getInstance().hasInitialized()) {
            at.a().c();
        }
    }

    public static void closeNativeReport() {
        if (p.a && CrashModule.getInstance().hasInitialized()) {
            at.a().d();
        }
    }

    public static void enableBugly(boolean z2) {
        p.a = z2;
    }

    public static void enableObtainId(Context context, boolean z2) {
        setCollectPrivacyInfo(context, z2);
    }

    public static Set<String> getAllUserDataKeys(Context context) {
        return !p.a ? new HashSet() : context == null ? new HashSet() : aa.a(context).w();
    }

    public static String getAppChannel() {
        return (p.a && CrashModule.getInstance().hasInitialized()) ? aa.a(a).f18487s : "unknown";
    }

    public static String getAppID() {
        return (p.a && CrashModule.getInstance().hasInitialized()) ? aa.a(a).e() : "unknown";
    }

    public static String getAppVer() {
        return (p.a && CrashModule.getInstance().hasInitialized()) ? aa.a(a).f18483o : "unknown";
    }

    public static String getBuglyVersion(Context context) {
        if (context != null) {
            return aa.a(context).f18476h;
        }
        al.d("Please call with context.", new Object[0]);
        return "unknown";
    }

    public static Context getContext() {
        return a;
    }

    public static String getDeviceID(Context context) {
        return aa.a(context).g();
    }

    public static Proxy getHttpProxy() {
        return an.a;
    }

    public static Map<String, String> getSdkExtraData() {
        if (!p.a) {
            return new HashMap();
        }
        if (CrashModule.getInstance().hasInitialized()) {
            return aa.a(a).K;
        }
        return null;
    }

    public static String getUserData(Context context, String str) {
        if (!p.a || context == null) {
            return "unknown";
        }
        if (ap.a(str)) {
            return null;
        }
        return aa.a(context).g(str);
    }

    public static int getUserDatasSize(Context context) {
        if (p.a && context != null) {
            return aa.a(context).v();
        }
        return -1;
    }

    public static String getUserId() {
        return (p.a && CrashModule.getInstance().hasInitialized()) ? aa.a(a).f() : "unknown";
    }

    public static int getUserSceneTagId(Context context) {
        if (p.a && context != null) {
            return aa.a(context).z();
        }
        return -1;
    }

    public static void initCrashReport(Context context) {
        if (context == null) {
            return;
        }
        a = context;
        p.a(CrashModule.getInstance());
        p.a(context);
    }

    public static boolean isLastSessionCrash() {
        if (!p.a || !CrashModule.getInstance().hasInitialized()) {
            return false;
        }
        at atVarA = at.a();
        Boolean bool = atVarA.f18602z;
        if (bool != null) {
            return bool.booleanValue();
        }
        String str = aa.b().f18472d;
        List<y> listA = w.a().a(1);
        ArrayList arrayList = new ArrayList();
        if (listA == null || listA.size() <= 0) {
            atVarA.f18602z = Boolean.FALSE;
            return false;
        }
        for (y yVar : listA) {
            if (str.equals(yVar.f18821c)) {
                atVarA.f18602z = Boolean.TRUE;
                arrayList.add(yVar);
            }
        }
        if (arrayList.size() > 0) {
            w.a().a(arrayList);
        }
        return true;
    }

    public static void postCatchedException(Throwable th) {
        postCatchedException(th, Thread.currentThread());
    }

    public static void postException(Thread thread, int i2, String str, String str2, String str3, Map<String, String> map) {
        if (p.a && CrashModule.getInstance().hasInitialized()) {
            au.a(thread, i2, str, str2, str3, map);
        }
    }

    private static void putSdkData(Context context, String str, String str2) {
        if (context == null || ap.a(str) || ap.a(str2)) {
            return;
        }
        String strReplace = str.replace("[a-zA-Z[0-9]]+", "");
        if (strReplace.length() > 100) {
            String.format("putSdkData key length over limit %d, will be cutted.", 50);
            strReplace = strReplace.substring(0, 50);
        }
        if (str2.length() > 500) {
            String.format("putSdkData value length over limit %d, will be cutted!", 200);
            str2 = str2.substring(0, 200);
        }
        aa.a(context).b(strReplace, str2);
        al.b(String.format("[param] putSdkData data: %s - %s", strReplace, str2), new Object[0]);
    }

    public static void putUserData(Context context, String str, String str2) {
        if (p.a && context != null) {
            if (str == null) {
                new StringBuilder().append(str);
                al.d("putUserData args key should not be null or empty", new Object[0]);
                return;
            }
            if (str2 == null) {
                new StringBuilder().append(str2);
                al.d("putUserData args value should not be null", new Object[0]);
                return;
            }
            if (str2.length() > 200) {
                al.d("user data value length over limit %d, it will be cutted!", 200);
                str2 = str2.substring(0, 200);
            }
            aa aaVarA = aa.a(context);
            if (aaVarA.w().contains(str)) {
                NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance();
                if (nativeCrashHandler != null) {
                    nativeCrashHandler.putKeyValueToNative(str, str2);
                }
                aa.a(context).a(str, str2);
                al.c("replace KV %s %s", str, str2);
                return;
            }
            if (aaVarA.v() >= 50) {
                al.d("user data size is over limit %d, it will be cutted!", 50);
                return;
            }
            if (str.length() > 50) {
                al.d("user data key length over limit %d , will drop this new key %s", 50, str);
                str = str.substring(0, 50);
            }
            NativeCrashHandler nativeCrashHandler2 = NativeCrashHandler.getInstance();
            if (nativeCrashHandler2 != null) {
                nativeCrashHandler2.putKeyValueToNative(str, str2);
            }
            aa.a(context).a(str, str2);
            al.b("[param] set user data: %s - %s", str, str2);
        }
    }

    public static String removeUserData(Context context, String str) {
        if (!p.a || context == null) {
            return "unknown";
        }
        if (ap.a(str)) {
            return null;
        }
        al.b("[param] remove user data: %s", str);
        return aa.a(context).f(str);
    }

    public static void setAllThreadStackEnable(Context context, boolean z2, boolean z3) {
        aa aaVarA = aa.a(context);
        aaVarA.Q = z2;
        aaVarA.R = z3;
    }

    public static void setAppChannel(Context context, String str) {
        if (!p.a || context == null || str == null) {
            return;
        }
        aa.a(context).f18487s = str;
        NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance();
        if (nativeCrashHandler != null) {
            nativeCrashHandler.setNativeAppChannel(str);
        }
    }

    public static void setAppPackage(Context context, String str) {
        if (!p.a || context == null || str == null) {
            return;
        }
        aa.a(context).f18471c = str;
        NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance();
        if (nativeCrashHandler != null) {
            nativeCrashHandler.setNativeAppPackage(str);
        }
    }

    public static void setAppVersion(Context context, String str) {
        if (!p.a || context == null || str == null) {
            return;
        }
        aa.a(context).f18483o = str;
        NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance();
        if (nativeCrashHandler != null) {
            nativeCrashHandler.setNativeAppVersion(str);
        }
    }

    public static void setBuglyDbName(String str) {
        if (p.a) {
            "Set Bugly DB name: ".concat(String.valueOf(str));
            x.a = str;
        }
    }

    public static void setCollectPrivacyInfo(Context context, boolean z2) {
        if (p.a && context != null) {
            "setCollectPrivacyInfo: ".concat(String.valueOf(z2));
            aa.a(context).f18482n = z2;
        }
    }

    public static void setContext(Context context) {
        a = context;
    }

    public static void setCrashFilter(String str) {
        if (p.a) {
            "Set crash stack filter: ".concat(String.valueOf(str));
            at.f18591p = str;
        }
    }

    public static void setCrashRegularFilter(String str) {
        if (p.a) {
            "Set crash stack filter: ".concat(String.valueOf(str));
            at.f18592q = str;
        }
    }

    public static void setDeviceId(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        aa.a(context).a(str);
    }

    public static void setDeviceModel(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        aa.a(context).b(str);
    }

    public static void setDumpFilePath(Context context, String str) {
        if (!p.a || context == null || str == null) {
            return;
        }
        "user set tombstone path: ".concat(String.valueOf(str));
        NativeCrashHandler.setDumpFilePath(str);
    }

    public static void setHandleNativeCrashInJava(boolean z2) {
        if (p.a) {
            "Should handle native crash in Java profile after handled in native profile: ".concat(String.valueOf(z2));
            NativeCrashHandler.setShouldHandleInJava(z2);
        }
    }

    public static void setHttpProxy(String str, int i2) {
        if (TextUtils.isEmpty(str)) {
            an.a = null;
        } else {
            an.a = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(str, i2));
        }
    }

    @Deprecated
    public static void setIsAppForeground(Context context, boolean z2) {
        al.a("App fore and back status are no longer supported", new Object[0]);
    }

    public static void setIsDevelopmentDevice(Context context, boolean z2) {
        if (p.a) {
            if (context == null) {
                al.d("Context should not be null.", new Object[0]);
                return;
            }
            if (z2) {
                al.c("This is a development device.", new Object[0]);
            } else {
                al.c("This is not a development device.", new Object[0]);
            }
            aa.a(context).I = z2;
        }
    }

    public static boolean setJavascriptMonitor(WebView webView, boolean z2) {
        return setJavascriptMonitor(webView, z2, false);
    }

    public static void setSdkExtraData(Context context, String str, String str2) {
        if (!p.a || context == null || ap.a(str) || ap.a(str2)) {
            return;
        }
        aa aaVarA = aa.a(context);
        if (str == null || str2 == null) {
            return;
        }
        synchronized (aaVarA.T) {
            aaVarA.K.put(str, str2);
        }
    }

    public static void setServerUrl(String str) {
        if (ap.a(str) || !ap.c(str)) {
            return;
        }
        ac.a(str);
        StrategyBean.a = str;
        StrategyBean.b = str;
    }

    public static void setSessionIntervalMills(long j2) {
        if (p.a) {
            s.a(j2);
        }
    }

    public static void setUserId(String str) {
        if (p.a && CrashModule.getInstance().hasInitialized()) {
            setUserId(a, str);
        }
    }

    public static void setUserSceneTag(Context context, int i2) {
        if (p.a && context != null) {
            if (i2 <= 0) {
                al.d("setTag args tagId should > 0", new Object[0]);
            }
            aa aaVarA = aa.a(context);
            synchronized (aaVarA.U) {
                int i3 = aaVarA.f18491w;
                if (i3 != i2) {
                    aaVarA.f18491w = i2;
                    al.a("user scene tag %d changed to tag %d", Integer.valueOf(i3), Integer.valueOf(aaVarA.f18491w));
                }
            }
            al.b("[param] set user scene tag: %d", Integer.valueOf(i2));
        }
    }

    public static void startCrashReport() {
        if (p.a && CrashModule.getInstance().hasInitialized()) {
            at.a().b();
        }
    }

    public static void testANRCrash() {
        if (p.a && CrashModule.getInstance().hasInitialized()) {
            al.a("start to create a anr crash for test!", new Object[0]);
            at.a().h();
        }
    }

    public static void testJavaCrash() {
        int i2;
        if (p.a && CrashModule.getInstance().hasInitialized()) {
            aa aaVarB = aa.b();
            if (aaVarB != null && (i2 = aaVarB.f18492x) != 24096) {
                aaVarB.f18492x = 24096;
                al.a("server scene tag %d changed to tag %d", Integer.valueOf(i2), Integer.valueOf(aaVarB.f18492x));
            }
            throw new RuntimeException("This Crash create for Test! You can go to Bugly see more detail!");
        }
    }

    public static void testNativeCrash() {
        testNativeCrash(true, true, false);
    }

    public static void uploadUserInfo() {
        r rVar;
        if (p.a && (rVar = s.b) != null) {
            rVar.b();
        }
    }

    public static void postCatchedException(Throwable th, Thread thread) {
        postCatchedException(th, thread, false);
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public static boolean setJavascriptMonitor(final WebView webView, boolean z2, boolean z3) {
        if (webView == null) {
            return false;
        }
        webView.getSettings().setSavePassword(false);
        webView.getSettings().setAllowFileAccess(false);
        return setJavascriptMonitor(new a() { // from class: com.tencent.bugly.crashreport.CrashReport.1
            @Override // com.tencent.bugly.crashreport.CrashReport.a
            public final String a() {
                return webView.getUrl();
            }

            @Override // com.tencent.bugly.crashreport.CrashReport.a
            public final void b() {
                WebSettings settings = webView.getSettings();
                if (settings.getJavaScriptEnabled()) {
                    return;
                }
                settings.setJavaScriptEnabled(true);
            }

            @Override // com.tencent.bugly.crashreport.CrashReport.a
            public final CharSequence c() {
                return webView.getContentDescription();
            }

            @Override // com.tencent.bugly.crashreport.CrashReport.a
            public final void a(String str) {
                webView.loadUrl(str);
            }

            @Override // com.tencent.bugly.crashreport.CrashReport.a
            public final void a(H5JavaScriptInterface h5JavaScriptInterface, String str) {
                webView.addJavascriptInterface(h5JavaScriptInterface, str);
            }
        }, z2, z3);
    }

    public static void testNativeCrash(boolean z2, boolean z3, boolean z4) {
        if (p.a && CrashModule.getInstance().hasInitialized()) {
            al.a("start to create a native crash for test!", new Object[0]);
            at.a().a(z2, z3, z4);
        }
    }

    public static void postCatchedException(final Throwable th, final Thread thread, final boolean z2) {
        if (p.a && CrashModule.getInstance().hasInitialized()) {
            if (th == null) {
                al.d("throwable is null, just return", new Object[0]);
                return;
            }
            if (thread == null) {
                thread = Thread.currentThread();
            }
            final at atVarA = at.a();
            atVarA.f18598v.a(new Runnable() { // from class: com.tencent.bugly.proguard.at.3
                final /* synthetic */ boolean a = false;

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f18604d = null;

                /* JADX INFO: renamed from: e, reason: collision with root package name */
                final /* synthetic */ byte[] f18605e = null;

                /* JADX INFO: renamed from: f, reason: collision with root package name */
                final /* synthetic */ boolean f18606f = true;

                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        al.c("post a throwable %b", Boolean.valueOf(this.a));
                        at.this.f18595s.a(thread, th, false, this.f18604d, this.f18605e, this.f18606f);
                        if (z2) {
                            al.a("clear user datas", new Object[0]);
                            aa.a(at.this.f18593c).u();
                        }
                    } catch (Throwable th2) {
                        if (!al.b(th2)) {
                            th2.printStackTrace();
                        }
                        al.e("java catch error: %s", th.toString());
                    }
                }
            });
        }
    }

    public static void initCrashReport(Context context, UserStrategy userStrategy) {
        if (context == null) {
            return;
        }
        a = context;
        p.a(CrashModule.getInstance());
        p.a(context, userStrategy);
    }

    public static void postException(int i2, String str, String str2, String str3, Map<String, String> map) {
        postException(Thread.currentThread(), i2, str, str2, str3, map);
    }

    public static void setUserId(Context context, String str) {
        if (p.a && context != null) {
            if (TextUtils.isEmpty(str)) {
                al.d("userId should not be null", new Object[0]);
                return;
            }
            if (str.length() > 100) {
                String strSubstring = str.substring(0, 100);
                al.d("userId %s length is over limit %d substring to %s", str, 100, strSubstring);
                str = strSubstring;
            }
            if (str.equals(aa.a(context).f())) {
                return;
            }
            aa aaVarA = aa.a(context);
            synchronized (aaVarA.V) {
                aaVarA.f18480l = String.valueOf(str == null ? "10000" : str);
            }
            al.b("[user] set userId : %s", str);
            NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance();
            if (nativeCrashHandler != null) {
                nativeCrashHandler.setNativeUserId(str);
            }
            if (CrashModule.getInstance().hasInitialized()) {
                s.a();
            }
        }
    }

    public static Map<String, String> getSdkExtraData(Context context) {
        if (!p.a) {
            return new HashMap();
        }
        if (context == null) {
            al.d("Context should not be null.", new Object[0]);
            return null;
        }
        return aa.a(context).K;
    }

    public static void setHttpProxy(InetAddress inetAddress, int i2) {
        if (inetAddress == null) {
            an.a = null;
        } else {
            an.a = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(inetAddress, i2));
        }
    }

    public static boolean setJavascriptMonitor(a aVar, boolean z2) {
        return setJavascriptMonitor(aVar, z2, false);
    }

    public static void initCrashReport(Context context, String str, boolean z2) {
        initCrashReport(context, str, z2, null);
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public static boolean setJavascriptMonitor(a aVar, boolean z2, boolean z3) {
        if (aVar == null) {
            return false;
        }
        if (!CrashModule.getInstance().hasInitialized()) {
            al.e("CrashReport has not been initialed! please to call method 'initCrashReport' first!", new Object[0]);
            return false;
        }
        al.a("Set Javascript exception monitor of webview.", new Object[0]);
        if (!p.a) {
            return false;
        }
        al.c("URL of webview is %s", aVar.a());
        if (!z3 && Build.VERSION.SDK_INT < 19) {
            al.e("This interface is only available for Android 4.4 or later.", new Object[0]);
            return false;
        }
        al.a("Enable the javascript needed by webview monitor.", new Object[0]);
        aVar.b();
        H5JavaScriptInterface h5JavaScriptInterface = H5JavaScriptInterface.getInstance(aVar);
        if (h5JavaScriptInterface != null) {
            al.a("Add a secure javascript interface to the webview.", new Object[0]);
            aVar.a(h5JavaScriptInterface, "exceptionUploader");
        }
        if (z2) {
            al.a("Inject bugly.js(v%s) to the webview.", bc.b());
            String strA = bc.a();
            if (strA == null) {
                al.e("Failed to inject Bugly.js.", bc.b());
                return false;
            }
            aVar.a("javascript:".concat(String.valueOf(strA)));
        }
        return true;
    }

    public static void initCrashReport(Context context, String str, boolean z2, UserStrategy userStrategy) {
        if (context == null) {
            return;
        }
        a = context;
        p.a(CrashModule.getInstance());
        p.a(context, str, z2, userStrategy);
    }
}
