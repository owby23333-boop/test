package com.tencent.bugly;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.crashreport.CrashReport;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.proguard.aa;
import com.tencent.bugly.proguard.al;
import com.tencent.bugly.proguard.aq;
import com.tencent.bugly.proguard.at;
import com.tencent.bugly.proguard.au;
import com.tencent.bugly.proguard.o;
import com.tencent.bugly.proguard.u;
import com.tencent.bugly.proguard.z;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes3.dex */
public class CrashModule extends o {
    public static final int MODULE_ID = 1004;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static int f18386c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static CrashModule f18387e = new CrashModule();
    private long a;
    private BuglyStrategy.a b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f18388d = false;

    private synchronized void a(Context context, BuglyStrategy buglyStrategy) {
        if (buglyStrategy == null) {
            return;
        }
        String libBuglySOFilePath = buglyStrategy.getLibBuglySOFilePath();
        if (!TextUtils.isEmpty(libBuglySOFilePath)) {
            aa.a(context).f18488t = libBuglySOFilePath;
            al.a("setted libBugly.so file path :%s", libBuglySOFilePath);
        }
        if (buglyStrategy.getCrashHandleCallback() != null) {
            this.b = buglyStrategy.getCrashHandleCallback();
            al.a("setted CrashHanldeCallback", new Object[0]);
        }
        if (buglyStrategy.getAppReportDelay() > 0) {
            this.a = buglyStrategy.getAppReportDelay();
            al.a("setted delay: %d", Long.valueOf(this.a));
        }
    }

    public static CrashModule getInstance() {
        CrashModule crashModule = f18387e;
        crashModule.id = 1004;
        return crashModule;
    }

    @Override // com.tencent.bugly.proguard.o
    public String[] getTables() {
        return new String[]{"t_cr"};
    }

    public synchronized boolean hasInitialized() {
        return this.f18388d;
    }

    @Override // com.tencent.bugly.proguard.o
    public synchronized void init(Context context, boolean z2, BuglyStrategy buglyStrategy) {
        if (context != null) {
            if (!this.f18388d) {
                al.a("Initializing crash module.", new Object[0]);
                u uVarA = u.a();
                int i2 = f18386c + 1;
                f18386c = i2;
                uVarA.a(i2);
                this.f18388d = true;
                CrashReport.setContext(context);
                a(context, buglyStrategy);
                at atVarA = at.a(context, z2, this.b);
                atVarA.f18595s.a();
                if (buglyStrategy != null) {
                    atVarA.A = buglyStrategy.getCallBackType();
                    atVarA.B = buglyStrategy.getCloseErrorCallback();
                    at.f18589n = buglyStrategy.isUploadSpotCrash();
                    aa.a(context).S = buglyStrategy.isEnableRecordAnrMainStack();
                    if (buglyStrategy.isEnableCatchAnrTrace()) {
                        atVarA.f18596t.enableCatchAnrTrace();
                    } else {
                        atVarA.f18596t.disableCatchAnrTrace();
                    }
                } else {
                    atVarA.f18596t.enableCatchAnrTrace();
                }
                if (aa.b().f18472d.equals(z.a(atVarA.f18593c))) {
                    atVarA.f18596t.removeEmptyNativeRecordFiles();
                }
                if (buglyStrategy == null || buglyStrategy.isEnableNativeCrashMonitor()) {
                    atVarA.e();
                } else {
                    al.a("[crash] Closed native crash monitor!", new Object[0]);
                    atVarA.d();
                }
                if (buglyStrategy == null || buglyStrategy.isEnableANRCrashMonitor()) {
                    atVarA.f();
                } else {
                    al.a("[crash] Closed ANR monitor!", new Object[0]);
                    atVarA.g();
                }
                if (buglyStrategy != null) {
                    at.f18580e = buglyStrategy.isMerged();
                }
                atVarA.a(buglyStrategy != null ? buglyStrategy.getAppReportDelay() : 0L);
                atVarA.f18596t.checkUploadRecordCrash();
                au.a(context);
                aq aqVarA = aq.a();
                aqVarA.a("android.net.conn.CONNECTIVITY_CHANGE");
                aqVarA.a(context);
                u uVarA2 = u.a();
                int i3 = f18386c - 1;
                f18386c = i3;
                uVarA2.a(i3);
            }
        }
    }

    @Override // com.tencent.bugly.proguard.o
    public void onServerStrategyChanged(StrategyBean strategyBean) {
        at atVarA;
        if (strategyBean == null || (atVarA = at.a()) == null) {
            return;
        }
        atVarA.f18595s.a(strategyBean);
        atVarA.f18596t.onStrategyChanged(strategyBean);
        atVarA.f18599w.b();
    }
}
