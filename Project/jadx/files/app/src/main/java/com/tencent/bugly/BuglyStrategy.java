package com.tencent.bugly;

import com.tencent.bugly.proguard.aa;
import java.util.Map;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes.dex */
public class BuglyStrategy {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f18366c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f18367d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f18368e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f18369f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f18370g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f18371h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f18372i;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private a f18384u;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f18373j = true;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f18374k = true;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f18375l = true;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f18376m = false;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f18377n = true;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private Class<?> f18378o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f18379p = true;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f18380q = true;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f18381r = true;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f18382s = true;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f18383t = false;
    protected int a = 31;
    protected boolean b = false;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private boolean f18385v = false;

    /* JADX INFO: compiled from: BUGLY */
    /* JADX INFO: loaded from: classes3.dex */
    public static class a {
        public static final int CRASHTYPE_ANR = 4;
        public static final int CRASHTYPE_BLOCK = 7;
        public static final int CRASHTYPE_COCOS2DX_JS = 5;
        public static final int CRASHTYPE_COCOS2DX_LUA = 6;
        public static final int CRASHTYPE_JAVA_CATCH = 1;
        public static final int CRASHTYPE_JAVA_CRASH = 0;
        public static final int CRASHTYPE_NATIVE = 2;
        public static final int CRASHTYPE_U3D = 3;
        public static final int MAX_USERDATA_KEY_LENGTH = 100;
        public static final int MAX_USERDATA_VALUE_LENGTH = 100000;

        public synchronized Map<String, String> onCrashHandleStart(int i2, String str, String str2, String str3) {
            return null;
        }

        public synchronized byte[] onCrashHandleStart2GetExtraDatas(int i2, String str, String str2, String str3) {
            return null;
        }
    }

    public synchronized String getAppChannel() {
        if (this.f18367d == null) {
            return aa.b().f18487s;
        }
        return this.f18367d;
    }

    public synchronized String getAppPackageName() {
        if (this.f18368e == null) {
            return aa.b().f18471c;
        }
        return this.f18368e;
    }

    public synchronized long getAppReportDelay() {
        return this.f18369f;
    }

    public synchronized String getAppVersion() {
        if (this.f18366c == null) {
            return aa.b().f18483o;
        }
        return this.f18366c;
    }

    public synchronized int getCallBackType() {
        return this.a;
    }

    public synchronized boolean getCloseErrorCallback() {
        return this.b;
    }

    public synchronized a getCrashHandleCallback() {
        return this.f18384u;
    }

    public synchronized String getDeviceID() {
        return this.f18371h;
    }

    public synchronized String getDeviceModel() {
        return this.f18372i;
    }

    public synchronized String getLibBuglySOFilePath() {
        return this.f18370g;
    }

    public synchronized Class<?> getUserInfoActivity() {
        return this.f18378o;
    }

    public synchronized boolean isBuglyLogUpload() {
        return this.f18379p;
    }

    public synchronized boolean isEnableANRCrashMonitor() {
        return this.f18374k;
    }

    public synchronized boolean isEnableCatchAnrTrace() {
        return this.f18375l;
    }

    public synchronized boolean isEnableNativeCrashMonitor() {
        return this.f18373j;
    }

    public boolean isEnableRecordAnrMainStack() {
        return this.f18376m;
    }

    public synchronized boolean isEnableUserInfo() {
        return this.f18377n;
    }

    public boolean isMerged() {
        return this.f18385v;
    }

    public boolean isReplaceOldChannel() {
        return this.f18380q;
    }

    public synchronized boolean isUploadProcess() {
        return this.f18381r;
    }

    public synchronized boolean isUploadSpotCrash() {
        return this.f18382s;
    }

    public synchronized boolean recordUserInfoOnceADay() {
        return this.f18383t;
    }

    public synchronized BuglyStrategy setAppChannel(String str) {
        this.f18367d = str;
        return this;
    }

    public synchronized BuglyStrategy setAppPackageName(String str) {
        this.f18368e = str;
        return this;
    }

    public synchronized BuglyStrategy setAppReportDelay(long j2) {
        this.f18369f = j2;
        return this;
    }

    public synchronized BuglyStrategy setAppVersion(String str) {
        this.f18366c = str;
        return this;
    }

    public synchronized BuglyStrategy setBuglyLogUpload(boolean z2) {
        this.f18379p = z2;
        return this;
    }

    public synchronized void setCallBackType(int i2) {
        this.a = i2;
    }

    public synchronized void setCloseErrorCallback(boolean z2) {
        this.b = z2;
    }

    public synchronized BuglyStrategy setCrashHandleCallback(a aVar) {
        this.f18384u = aVar;
        return this;
    }

    public synchronized BuglyStrategy setDeviceID(String str) {
        this.f18371h = str;
        return this;
    }

    public synchronized BuglyStrategy setDeviceModel(String str) {
        this.f18372i = str;
        return this;
    }

    public synchronized BuglyStrategy setEnableANRCrashMonitor(boolean z2) {
        this.f18374k = z2;
        return this;
    }

    public void setEnableCatchAnrTrace(boolean z2) {
        this.f18375l = z2;
    }

    public synchronized BuglyStrategy setEnableNativeCrashMonitor(boolean z2) {
        this.f18373j = z2;
        return this;
    }

    public void setEnableRecordAnrMainStack(boolean z2) {
        this.f18376m = z2;
    }

    public synchronized BuglyStrategy setEnableUserInfo(boolean z2) {
        this.f18377n = z2;
        return this;
    }

    public synchronized BuglyStrategy setLibBuglySOFilePath(String str) {
        this.f18370g = str;
        return this;
    }

    @Deprecated
    public void setMerged(boolean z2) {
        this.f18385v = z2;
    }

    public synchronized BuglyStrategy setRecordUserInfoOnceADay(boolean z2) {
        this.f18383t = z2;
        return this;
    }

    public void setReplaceOldChannel(boolean z2) {
        this.f18380q = z2;
    }

    public synchronized BuglyStrategy setUploadProcess(boolean z2) {
        this.f18381r = z2;
        return this;
    }

    public synchronized void setUploadSpotCrash(boolean z2) {
        this.f18382s = z2;
    }

    public synchronized BuglyStrategy setUserInfoActivity(Class<?> cls) {
        this.f18378o = cls;
        return this;
    }
}
