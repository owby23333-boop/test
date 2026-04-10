package com.umeng.commonsdk.statistics;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.analytics.pro.ay;
import com.umeng.analytics.pro.bn;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMFrUtils;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.statistics.idtracking.ImprintHandler;
import com.umeng.commonsdk.statistics.idtracking.e;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.statistics.internal.StatTracer;
import com.umeng.commonsdk.statistics.internal.d;
import com.umeng.commonsdk.statistics.noise.ABTest;
import com.umeng.commonsdk.statistics.noise.Defcon;
import com.umeng.commonsdk.statistics.proto.Response;
import java.io.File;

/* JADX INFO: compiled from: NetWorkManager.java */
/* JADX INFO: loaded from: classes3.dex */
public class c {
    private static final int b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f20059c = 2;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f20060d = 3;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final String f20061o = "thtstart";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final String f20062p = "gkvc";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final String f20063q = "ekvc";
    String a;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private com.umeng.commonsdk.statistics.internal.c f20065f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ImprintHandler f20066g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private e f20067h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private ImprintHandler.a f20068i;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Defcon f20070k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private long f20071l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f20072m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f20073n;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private Context f20074r;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f20064e = 1;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private ABTest f20069j = null;

    public c(Context context) {
        this.f20067h = null;
        this.f20068i = null;
        this.f20070k = null;
        this.f20071l = 0L;
        this.f20072m = 0;
        this.f20073n = 0;
        this.a = null;
        this.f20074r = context;
        this.f20068i = ImprintHandler.getImprintService(this.f20074r).c();
        this.f20070k = Defcon.getService(this.f20074r);
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(this.f20074r);
        this.f20071l = sharedPreferences.getLong(f20061o, 0L);
        this.f20072m = sharedPreferences.getInt(f20062p, 0);
        this.f20073n = sharedPreferences.getInt(f20063q, 0);
        this.a = UMEnvelopeBuild.imprintProperty(this.f20074r, "track_list", null);
        this.f20066g = ImprintHandler.getImprintService(this.f20074r);
        this.f20066g.a(new d() { // from class: com.umeng.commonsdk.statistics.c.1
            @Override // com.umeng.commonsdk.statistics.internal.d
            public void onImprintChanged(ImprintHandler.a aVar) {
                c.this.f20070k.onImprintChanged(aVar);
                c cVar = c.this;
                cVar.a = UMEnvelopeBuild.imprintProperty(cVar.f20074r, "track_list", null);
            }
        });
        if (!UMConfigure.needSendZcfgEnv(this.f20074r)) {
            this.f20067h = e.a(this.f20074r);
        }
        this.f20065f = new com.umeng.commonsdk.statistics.internal.c(this.f20074r);
        this.f20065f.a(StatTracer.getInstance(this.f20074r));
    }

    public boolean a(File file) {
        if (file == null) {
            return false;
        }
        try {
            byte[] byteArray = UMFrUtils.toByteArray(file.getPath());
            if (byteArray == null) {
                return false;
            }
            String name = file.getName();
            if (TextUtils.isEmpty(name)) {
                return false;
            }
            com.umeng.commonsdk.statistics.internal.a aVarA = com.umeng.commonsdk.statistics.internal.a.a(this.f20074r);
            aVarA.e(name);
            boolean zA = aVarA.a(name);
            boolean zB = aVarA.b(name);
            boolean zC = aVarA.c(name);
            boolean zD = aVarA.d(name);
            String strD = com.umeng.commonsdk.stateless.d.d(name);
            byte[] bArrA = this.f20065f.a(byteArray, zA, zC, !TextUtils.isEmpty(strD) ? com.umeng.commonsdk.stateless.d.c(strD) : zD ? UMServerURL.SILENT_HEART_BEAT : zC ? UMServerURL.ZCFG_PATH : UMServerURL.PATH_ANALYTICS);
            int iA = bArrA == null ? 1 : a(bArrA);
            if (UMConfigure.isDebugLog()) {
                if (zD && iA == 2) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "heart beat req: succeed.");
                } else if (zC && iA == 2) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "Zero req: succeed.");
                } else if (zB && iA == 2) {
                    MLog.d("本次启动数据: 发送成功!");
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "Send instant data: succeed.");
                } else if (zA && iA == 2) {
                    MLog.d("普通统计数据: 发送成功!");
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "Send analytics data: succeed.");
                } else if (iA == 2) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "Inner req: succeed.");
                }
            }
            if (iA != 1) {
                if (iA == 2) {
                    if (this.f20067h != null) {
                        this.f20067h.e();
                    }
                    StatTracer.getInstance(this.f20074r).saveSate();
                    if (zD) {
                        String strImprintProperty = UMEnvelopeBuild.imprintProperty(this.f20074r, "iss", "");
                        if (!TextUtils.isEmpty(strImprintProperty)) {
                            if ("1".equalsIgnoreCase(strImprintProperty)) {
                                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 更新静默心跳最后一次成功请求时间.");
                                com.umeng.commonsdk.utils.c.a(this.f20074r, System.currentTimeMillis());
                            } else if ("0".equalsIgnoreCase(strImprintProperty)) {
                                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 静默模式 -> 正常模式。重置 last req time");
                                com.umeng.commonsdk.utils.c.a(this.f20074r, 0L);
                                com.umeng.commonsdk.utils.c.d(this.f20074r);
                            }
                        }
                    }
                } else if (iA == 3) {
                    StatTracer.getInstance(this.f20074r).saveSate();
                    if (zC) {
                        FieldManager.a().a(this.f20074r);
                        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 零号报文应答内容报错!!! ，特殊处理!，继续正常流程。");
                        UMWorkDispatch.sendEvent(this.f20074r, com.umeng.commonsdk.internal.a.f19987s, com.umeng.commonsdk.internal.b.a(this.f20074r).a(), null);
                        return true;
                    }
                }
            }
            return iA == 2;
        } catch (Throwable th) {
            UMCrashManager.reportCrash(this.f20074r, th);
            return false;
        }
    }

    private int a(byte[] bArr) {
        Response response = new Response();
        try {
            new ay(new bn.a()).a(response, bArr);
            if (response.resp_code == 1) {
                this.f20066g.b(response.getImprint());
                this.f20066g.d();
            }
        } catch (Throwable th) {
            UMCrashManager.reportCrash(this.f20074r, th);
        }
        return response.resp_code == 1 ? 2 : 3;
    }
}
