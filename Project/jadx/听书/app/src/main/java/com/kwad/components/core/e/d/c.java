package com.kwad.components.core.e.d;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.kwad.components.core.e.c.b;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.page.AdWebViewVideoActivityProxy;
import com.kwad.components.core.page.DownloadLandPageActivity;
import com.kwad.sdk.api.KsApkDownloadListener;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.NetworkMonitor;
import com.kwad.sdk.core.adlog.c;
import com.kwad.sdk.core.diskcache.ApkCacheManager;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.o.m;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.utils.ae;
import com.kwad.sdk.utils.al;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.as;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.h;
import com.kwad.sdk.utils.t;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements NetworkMonitor.a, com.kwad.sdk.core.download.c, com.kwad.sdk.core.webview.a {
    private List<KsAppDownloadListener> PA;
    private AdTemplate Pw;
    private boolean Px;
    private a Py;
    private DialogInterface.OnShowListener Pz;
    private boolean downloadPauseEnable;
    private Handler iK;
    private AdInfo mAdInfo;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private JSONObject mReportExtData;

    public interface a {
        boolean handleDownloadDialog(DialogInterface.OnClickListener onClickListener);
    }

    public c(AdTemplate adTemplate, JSONObject jSONObject, KsAppDownloadListener ksAppDownloadListener) {
        this.iK = new Handler(Looper.getMainLooper());
        this.PA = new ArrayList();
        this.Pw = adTemplate;
        this.mAdInfo = com.kwad.sdk.core.response.b.e.el(adTemplate);
        this.mReportExtData = jSONObject;
        if (ksAppDownloadListener != null) {
            b(ksAppDownloadListener);
        }
        pA();
        this.downloadPauseEnable = com.kwad.sdk.core.response.b.a.cH(com.kwad.sdk.core.response.b.e.el(this.Pw));
        pz();
        com.kwad.sdk.a.a.c.CU().aZ(this.Pw);
    }

    public final void pz() {
        com.kwad.sdk.core.download.b.GR().a(this, this.Pw);
        if (com.kwad.sdk.core.config.e.FG()) {
            NetworkMonitor.getInstance().a(ServiceProvider.getContext(), this, this.Pw);
        }
    }

    private void pA() {
        com.kwad.sdk.core.download.b.GR();
        int iDO = com.kwad.sdk.core.download.b.dO(pC());
        if (iDO != 0) {
            this.mAdInfo.status = iDO;
        }
        pG();
        pF();
    }

    public final void aG(int i) {
        this.Pw.downloadSource = i;
    }

    public final void d(JSONObject jSONObject) {
        this.mReportExtData = jSONObject;
    }

    public final int pB() {
        pG();
        if (this.mAdInfo.status == 3) {
            return 2;
        }
        return this.mAdInfo.status;
    }

    public c(AdTemplate adTemplate, KsAppDownloadListener ksAppDownloadListener) {
        this(adTemplate, null, ksAppDownloadListener);
    }

    public c(AdTemplate adTemplate, JSONObject jSONObject) {
        this(adTemplate, jSONObject, null);
    }

    public c(AdTemplate adTemplate) {
        this(adTemplate, null, null);
    }

    public c(AdTemplate adTemplate, KsAppDownloadListener ksAppDownloadListener, String str, String str2) {
        this(adTemplate, null, null);
        this.mAdInfo.adConversionInfo.appDownloadUrl = str;
        this.mAdInfo.adBaseInfo.appPackageName = str2;
        this.mAdInfo.downloadId = al.md5(str);
    }

    @Override // com.kwad.sdk.core.download.c
    public final String pC() {
        return this.mAdInfo.downloadId;
    }

    @Override // com.kwad.sdk.core.download.c
    public final String pD() {
        return this.mAdInfo.adBaseInfo.appPackageName;
    }

    @Override // com.kwad.sdk.core.download.c
    public final void a(String str, com.kwad.sdk.core.download.e eVar) {
        if (this.mAdInfo.downloadId.equals(str)) {
            this.mAdInfo.status = 1;
            pF();
            if (eVar.GV()) {
                this.mAdInfo.mStartDownloadTime = SystemClock.elapsedRealtime();
                com.kwad.sdk.core.adlog.c.bS(this.Pw);
                eVar.GU();
                com.kwad.sdk.commercial.a.a.x(this.Pw);
            }
        }
    }

    @Override // com.kwad.sdk.core.download.c
    public final void a(String str, int i, int i2, int i3) {
        if (this.mAdInfo.downloadId.equals(str)) {
            this.mAdInfo.status = 3;
            this.mAdInfo.progress = i;
            this.mAdInfo.soFarBytes = i2;
            this.mAdInfo.totalBytes = i3;
            pF();
        }
    }

    @Override // com.kwad.sdk.core.download.c
    public final void a(String str, String str2, com.kwad.sdk.core.download.e eVar) {
        if (this.mAdInfo.downloadId.equals(str)) {
            this.mAdInfo.downloadFilePath = str2;
            this.mAdInfo.progress = 100;
            this.mAdInfo.status = 8;
            pF();
            if (eVar.GV()) {
                eVar.GU();
                com.kwad.sdk.core.adlog.c.c(this.Pw, this.mReportExtData);
                com.kwad.sdk.commercial.a.a.k(this.Pw, SystemClock.elapsedRealtime() - this.mAdInfo.mStartDownloadTime);
                com.kwad.sdk.core.a.Em().e(str, this.Pw);
                h.execute(new Runnable() { // from class: com.kwad.components.core.e.d.c.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        com.kwad.sdk.components.d.f(com.kwad.components.a.a.a.class);
                    }
                });
                com.kwad.sdk.a.a.c.CU().bb(this.Pw);
                com.kwad.sdk.a.a.c.CU().aZ(this.Pw);
                com.kwad.sdk.a.a.b.CR().aU(this.Pw);
                ApkCacheManager.getInstance().GE();
            }
        }
    }

    @Override // com.kwad.sdk.core.download.c
    public final void a(String str, int i, String str2, com.kwad.sdk.core.download.e eVar) {
        if (this.mAdInfo.downloadId.equals(str)) {
            this.mAdInfo.status = 7;
            pF();
            if (eVar.GV()) {
                c.a aVar = new c.a(i, str2);
                com.kwad.sdk.core.adlog.c.a(this.Pw, aVar);
                com.kwad.components.core.p.a.se().a(this.Pw, this.mAdInfo.adConversionInfo.appDownloadUrl, aVar.toJson().toString());
                eVar.GU();
                com.kwad.sdk.commercial.a.a.h(this.Pw, i, str2);
            }
            if (this.mAdInfo.adConversionInfo.retryH5TimeStep <= 0 || this.Px || SystemClock.elapsedRealtime() - this.mAdInfo.mStartDownloadTime >= this.mAdInfo.adConversionInfo.retryH5TimeStep || TextUtils.isEmpty(com.kwad.sdk.core.response.b.a.aS(this.mAdInfo))) {
                return;
            }
            AdWebViewActivityProxy.launch(ServiceProvider.getContext(), this.Pw);
            this.Px = true;
        }
    }

    @Override // com.kwad.sdk.core.download.c
    public final void b(String str, com.kwad.sdk.core.download.e eVar) {
        if (this.mAdInfo.downloadId.equals(str)) {
            if (this.mAdInfo.status != 4 && eVar.GV()) {
                com.kwad.sdk.core.adlog.c.a(this.Pw, this.mReportExtData);
                eVar.GU();
                com.kwad.sdk.commercial.a.a.bg(this.Pw);
            }
            this.mAdInfo.status = 4;
            pF();
        }
    }

    @Override // com.kwad.sdk.core.download.c
    public final void c(String str, com.kwad.sdk.core.download.e eVar) {
        if (this.mAdInfo.downloadId.equals(str)) {
            Integer num = com.kwad.sdk.core.download.b.aDk.get(str);
            if (num != null && num.intValue() == 2) {
                this.Pw.downLoadType = 2;
                com.kwad.sdk.core.download.b.aDk.remove(str);
            }
            if (this.mAdInfo.status != 2 && eVar.GV()) {
                com.kwad.sdk.core.adlog.c.b(this.Pw, this.mReportExtData);
                eVar.GU();
                com.kwad.sdk.commercial.a.a.bh(this.Pw);
            }
            this.mAdInfo.status = 2;
            pF();
        }
    }

    @Override // com.kwad.sdk.core.download.c
    public final void d(String str, com.kwad.sdk.core.download.e eVar) {
        if (this.mAdInfo.downloadId.equals(str)) {
            if (this.mAdInfo.status != 5 && eVar.GV()) {
                com.kwad.sdk.core.adlog.c.d(this.Pw, this.mReportExtData);
                eVar.GU();
                com.kwad.sdk.commercial.a.a.bi(this.Pw);
            }
            com.kwad.sdk.a.a.c.CU().ba(this.Pw);
            com.kwad.sdk.a.a.b.CR().aV(this.Pw);
            this.mAdInfo.status = 5;
            pF();
        }
    }

    @Override // com.kwad.sdk.core.download.c
    public final void e(String str, com.kwad.sdk.core.download.e eVar) {
        if (this.mAdInfo.downloadId.equals(str)) {
            this.mAdInfo.status = 9;
            pF();
            if (eVar.GV()) {
                com.kwad.sdk.core.adlog.c.h(this.Pw, 2);
                eVar.GU();
                com.kwad.sdk.commercial.a.a.bk(this.Pw);
            }
        }
    }

    @Override // com.kwad.sdk.core.download.c
    public final void b(String str, String str2, com.kwad.sdk.core.download.e eVar) {
        final boolean zPE;
        this.mAdInfo.status = 12;
        pF();
        if (eVar.GV()) {
            com.kwad.sdk.core.adlog.c.e(this.Pw, this.mReportExtData);
            eVar.GU();
            com.kwad.sdk.commercial.a.a.bl(this.Pw);
            zPE = pE();
            com.kwad.sdk.a.a.c.CU().bc(this.Pw);
            com.kwad.sdk.a.a.c.CU().ba(this.Pw);
            com.kwad.sdk.a.a.b.CR().aV(this.Pw);
            com.kwad.components.core.e.a.e.oK().ax(this.Pw);
            com.kwad.sdk.core.a.Em().dl(pC());
        } else {
            zPE = false;
        }
        h.execute(new bg() { // from class: com.kwad.components.core.e.d.c.2
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                com.kwad.sdk.components.d.f(com.kwad.components.a.a.a.class);
            }
        });
    }

    @Override // com.kwad.sdk.core.download.c
    public final void f(String str, com.kwad.sdk.core.download.e eVar) {
        if (this.mAdInfo.downloadId.equals(str)) {
            pG();
            if (eVar.GV()) {
                eVar.GU();
                com.kwad.sdk.commercial.a.a.bm(this.Pw);
            }
        }
    }

    @Override // com.kwad.sdk.core.download.c
    public final void a(String str, Throwable th, com.kwad.sdk.core.download.e eVar) {
        if (this.mAdInfo.downloadId.equals(str)) {
            this.mAdInfo.status = 11;
            pF();
            if (eVar.GV()) {
                eVar.GU();
                com.kwad.sdk.commercial.a.a.i(this.Pw, 100003, Log.getStackTraceString(th));
            }
        }
    }

    @Override // com.kwad.sdk.core.download.c
    public final void g(String str, com.kwad.sdk.core.download.e eVar) {
        if (this.mAdInfo.downloadId.equals(str) && eVar.GV()) {
            eVar.GU();
            com.kwad.sdk.core.adlog.c.bT(this.Pw);
            com.kwad.sdk.commercial.a.a.bj(this.Pw);
        }
    }

    private boolean pE() {
        if (Build.VERSION.SDK_INT < 29) {
            if (this.Pw.mIsFromContent && com.kwad.sdk.core.config.e.EO()) {
                zPK = pK();
                if (zPK) {
                    com.kwad.sdk.core.adlog.c.bV(this.Pw);
                }
            } else if (!this.Pw.mIsFromContent && com.kwad.sdk.core.config.e.Fu()) {
                boolean zAv = com.kwad.components.core.l.b.av(ServiceProvider.getContext());
                com.kwad.sdk.core.d.c.d("ApkDownloadHelper", "handleForceOpenApp enableForceOpen: " + zAv);
                zPK = zAv ? pK() : false;
                if (zPK) {
                    com.kwad.sdk.core.adlog.c.bW(this.Pw);
                }
            }
        }
        return zPK;
    }

    private void pF() {
        this.iK.post(new bg() { // from class: com.kwad.components.core.e.d.c.3
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                ArrayList<KsAppDownloadListener> arrayList = new ArrayList(c.this.PA.size());
                arrayList.addAll(c.this.PA);
                for (KsAppDownloadListener ksAppDownloadListener : arrayList) {
                    if (ksAppDownloadListener != null) {
                        c.this.a(ksAppDownloadListener);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(KsAppDownloadListener ksAppDownloadListener) {
        int iBY = com.kwad.sdk.core.config.e.BY();
        boolean zBX = com.kwad.sdk.core.config.e.BX();
        com.kwad.sdk.core.d.c.d("ApkDownloadHelper", "DownloadProgressTransformUtil  go in updateDownloadProgress");
        int iA = t.a(this.mAdInfo.soFarBytes, this.mAdInfo.totalBytes, zBX, iBY);
        switch (this.mAdInfo.status) {
            case 0:
            case 5:
                ksAppDownloadListener.onIdle();
                break;
            case 1:
                ksAppDownloadListener.onProgressUpdate(0);
                if (ksAppDownloadListener instanceof com.kwad.sdk.core.download.a.a) {
                    ((com.kwad.sdk.core.download.a.a) ksAppDownloadListener).onDownloadStarted();
                } else {
                    try {
                        ksAppDownloadListener.onDownloadStarted();
                    } catch (Throwable th) {
                        com.kwad.sdk.core.d.c.printStackTraceOnly(th);
                        return;
                    }
                }
                break;
            case 2:
            case 3:
                ksAppDownloadListener.onProgressUpdate(iA);
                break;
            case 4:
                if (ksAppDownloadListener instanceof com.kwad.sdk.core.download.a.a) {
                    ((com.kwad.sdk.core.download.a.a) ksAppDownloadListener).onPaused(iA);
                }
                try {
                    if (ksAppDownloadListener instanceof KsApkDownloadListener) {
                        ((KsApkDownloadListener) ksAppDownloadListener).onPaused(iA);
                    }
                } catch (Throwable unused) {
                    return;
                }
                break;
            case 7:
                ksAppDownloadListener.onDownloadFailed();
                break;
            case 8:
            case 9:
                ksAppDownloadListener.onDownloadFinished();
                break;
            case 12:
                ksAppDownloadListener.onInstalled();
                break;
        }
    }

    public final void pG() {
        if (as.aq(ServiceProvider.getContext(), this.mAdInfo.adBaseInfo.appPackageName)) {
            this.mAdInfo.status = 12;
            return;
        }
        if (this.mAdInfo.status == 12) {
            this.mAdInfo.status = 0;
            this.mAdInfo.progress = 0;
        }
        if (this.mAdInfo.status == 8 || this.mAdInfo.status == 9) {
            String str = this.mAdInfo.downloadFilePath;
            if (TextUtils.isEmpty(str) || !new File(str).exists()) {
                this.mAdInfo.status = 0;
                this.mAdInfo.progress = 0;
            }
        }
        if (this.mAdInfo.status == 0) {
            String strH = com.kwad.sdk.core.download.a.H(this.mAdInfo);
            if (TextUtils.isEmpty(strH) || !new File(strH).exists()) {
                return;
            }
            this.mAdInfo.downloadFilePath = strH;
            this.mAdInfo.status = 8;
        }
    }

    public final int q(a.C0333a c0333a) {
        int i = this.mAdInfo.status;
        if (i != 0 && i != 1) {
            switch (i) {
                case 4:
                case 5:
                case 6:
                case 7:
                    break;
                case 8:
                case 9:
                case 10:
                case 11:
                    return pL();
                case 12:
                    return z(c0333a);
                default:
                    return 0;
            }
        }
        return t(c0333a) ? 11 : 0;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final int r(a.C0333a c0333a) {
        this.Px = false;
        pG();
        switch (this.mAdInfo.status) {
            case 0:
            case 1:
            case 5:
            case 6:
            case 7:
                return u(c0333a);
            case 2:
            case 3:
                if (c0333a.pm() && this.downloadPauseEnable) {
                    return pN();
                }
                return 0;
            case 4:
                return pO();
            case 8:
            case 9:
            case 11:
                return pL();
            case 10:
            default:
                return 0;
            case 12:
                return z(c0333a);
        }
    }

    public final AdTemplate pH() {
        return this.Pw;
    }

    public final boolean s(a.C0333a c0333a) {
        return this.mAdInfo.status == 0 && t(c0333a);
    }

    private boolean t(a.C0333a c0333a) {
        boolean zI = com.kwad.sdk.utils.e.i(c0333a.getContext(), this.Pw);
        if (zI) {
            com.kwad.sdk.core.adlog.c.k(this.Pw, 0);
        }
        return zI;
    }

    private int u(a.C0333a c0333a) {
        Context context = c0333a.getContext();
        if (com.kwad.sdk.utils.e.a(context, com.kwad.sdk.core.response.b.a.cW(this.mAdInfo), this.Pw)) {
            com.kwad.sdk.core.adlog.c.k(this.Pw, 1);
            return 11;
        }
        if (t(c0333a)) {
            return 11;
        }
        if (pI()) {
            return 10;
        }
        if (!ao.isNetworkConnected(context)) {
            ac.Q(context, ae.cQ(context));
            return 2;
        }
        if (c0333a.pv() && com.kwad.sdk.core.config.e.Fg()) {
            return v(c0333a);
        }
        if (com.kwad.sdk.core.response.b.e.eA(this.Pw) && c0333a.px() != 2) {
            return d(c0333a.getContext(), c0333a.getAdTemplate());
        }
        if (c0333a.pr()) {
            return w(c0333a);
        }
        if (x(c0333a)) {
            return 8;
        }
        return pM();
    }

    private int v(a.C0333a c0333a) {
        Context context = c0333a.getContext();
        AdTemplate adTemplate = c0333a.getAdTemplate();
        int iPw = c0333a.pw();
        if (iPw == 1) {
            return pM();
        }
        if (iPw != 2) {
            return 1;
        }
        if (!com.kwad.sdk.core.response.b.b.dp(adTemplate)) {
            return 8;
        }
        com.kwad.components.core.e.c.b.a(context, new b.a().aA(adTemplate).ak(com.kwad.sdk.core.response.b.b.m615do(adTemplate)).a(this.Pz).c(this.mOnDismissListener).oZ());
        return 8;
    }

    private int w(a.C0333a c0333a) {
        Context context = c0333a.getContext();
        AdTemplate adTemplate = c0333a.getAdTemplate();
        int iA = A(c0333a);
        if (iA == 1) {
            if (com.kwad.sdk.core.response.b.b.dp(adTemplate)) {
                com.kwad.components.core.e.c.b.a(context, new b.a().aA(adTemplate).ak(com.kwad.sdk.core.response.b.b.m615do(adTemplate)).a(this.Pz).c(this.mOnDismissListener).oZ());
            }
            return 8;
        }
        if (iA == 2) {
            return d(c0333a.getContext(), c0333a.getAdTemplate());
        }
        if (iA == 3) {
            return 1;
        }
        if (x(c0333a)) {
            return 8;
        }
        return pM();
    }

    private boolean x(a.C0333a c0333a) {
        if (c0333a.po() || this.mAdInfo.status == 4 || !com.kwad.sdk.core.response.b.b.ds(this.Pw) || !y(c0333a)) {
            return false;
        }
        return com.kwad.components.core.e.c.b.a(c0333a.getContext(), new b.a().aA(this.Pw).ak(com.kwad.sdk.core.response.b.b.dr(this.Pw)).a(this.Pz).c(this.mOnDismissListener).oZ());
    }

    private static boolean y(a.C0333a c0333a) {
        AdInfo adInfoEl = com.kwad.sdk.core.response.b.e.el(c0333a.getAdTemplate());
        if (com.kwad.sdk.core.response.b.a.bw(adInfoEl) && (DownloadLandPageActivity.showingAdWebViewLandPage || AdWebViewVideoActivityProxy.showingAdWebViewVideoActivity || c0333a.getAdTemplate().isWebViewDownload)) {
            return true;
        }
        return com.kwad.sdk.core.response.b.a.bx(adInfoEl) && !ao.isWifiConnected(c0333a.getContext());
    }

    private boolean pI() {
        a aVar = this.Py;
        if (aVar != null) {
            return aVar.handleDownloadDialog(new DialogInterface.OnClickListener() { // from class: com.kwad.components.core.e.d.c.4
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    if (i == -1) {
                        switch (c.this.mAdInfo.status) {
                            case 0:
                            case 1:
                            case 5:
                            case 6:
                            case 7:
                                c.this.pM();
                                break;
                            case 4:
                                c.this.pO();
                                break;
                            case 8:
                            case 9:
                            case 11:
                                c.this.pL();
                                break;
                            case 12:
                                c.this.pJ();
                                break;
                        }
                    }
                }
            });
        }
        return false;
    }

    private int z(a.C0333a c0333a) {
        Activity activityEj = m.ej(c0333a.getContext());
        if (activityEj != null && com.kwad.sdk.core.response.b.a.T(this.mAdInfo) && !c0333a.pf() && !c0333a.pk()) {
            c0333a.ay(1);
            com.kwad.components.core.e.e.e.a(activityEj, c0333a);
            return 18;
        }
        return pJ();
    }

    public final int pJ() {
        h.execute(new bg() { // from class: com.kwad.components.core.e.d.c.5
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                com.kwad.sdk.components.d.f(com.kwad.components.a.a.a.class);
            }
        });
        if (!as.as(ServiceProvider.getContext(), com.kwad.sdk.core.response.b.a.ay(this.mAdInfo))) {
            return 6;
        }
        com.kwad.sdk.core.adlog.c.bU(this.Pw);
        return 6;
    }

    private boolean pK() {
        Context context = ServiceProvider.getContext();
        if (d.a(new a.C0333a(context).aB(this.Pw), 1) == 1) {
            return true;
        }
        boolean zAs = as.as(context, com.kwad.sdk.core.response.b.a.ay(this.mAdInfo));
        if (zAs) {
            com.kwad.sdk.core.adlog.c.bU(this.Pw);
        }
        return zAs;
    }

    public final int pL() {
        as.a(this.mAdInfo.downloadFilePath, new as.a() { // from class: com.kwad.components.core.e.d.c.6
            @Override // com.kwad.sdk.utils.as.a
            public final void pR() {
                com.kwad.sdk.core.adlog.c.h(c.this.Pw, 1);
                com.kwad.sdk.commercial.a.a.bk(c.this.Pw);
            }

            @Override // com.kwad.sdk.utils.as.a
            public final void d(Throwable th) {
                com.kwad.sdk.commercial.a.a.i(c.this.Pw, 100003, Log.getStackTraceString(th));
            }
        });
        return 7;
    }

    public final int pM() {
        com.kwad.sdk.core.download.a.I(this.mAdInfo);
        return 3;
    }

    public final int pN() {
        com.kwad.sdk.core.download.a.dL(this.mAdInfo.downloadId);
        return 4;
    }

    public final int pO() {
        this.Pw.downLoadType = 2;
        pM();
        return 5;
    }

    private int pP() {
        this.Pw.downLoadType = 1;
        pM();
        return 5;
    }

    public final void b(final KsAppDownloadListener ksAppDownloadListener) {
        if (ksAppDownloadListener == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            if (!this.PA.contains(ksAppDownloadListener)) {
                this.PA.add(0, ksAppDownloadListener);
            }
        } else {
            this.iK.post(new bg() { // from class: com.kwad.components.core.e.d.c.7
                @Override // com.kwad.sdk.utils.bg
                public final void doTask() {
                    if (c.this.PA.contains(ksAppDownloadListener)) {
                        return;
                    }
                    c.this.PA.add(0, ksAppDownloadListener);
                }
            });
        }
        pG();
        a(ksAppDownloadListener);
    }

    public final void c(final KsAppDownloadListener ksAppDownloadListener) {
        if (ksAppDownloadListener == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            this.PA.remove(ksAppDownloadListener);
        } else {
            this.iK.post(new bg() { // from class: com.kwad.components.core.e.d.c.8
                @Override // com.kwad.sdk.utils.bg
                public final void doTask() {
                    c.this.PA.remove(ksAppDownloadListener);
                }
            });
        }
    }

    public final void d(KsAppDownloadListener ksAppDownloadListener) {
        if (ksAppDownloadListener == null) {
            return;
        }
        pG();
        a(ksAppDownloadListener);
    }

    public static int A(a.C0333a c0333a) {
        AdInfo adInfoEl = com.kwad.sdk.core.response.b.e.el(c0333a.getAdTemplate());
        if (adInfoEl.downloadSafeInfo.complianceInfo == null) {
            return 0;
        }
        int iDW = c0333a.dW();
        if (iDW == 2) {
            return adInfoEl.downloadSafeInfo.complianceInfo.describeBarType;
        }
        if (iDW == 3) {
            return adInfoEl.downloadSafeInfo.complianceInfo.materialJumpType;
        }
        return adInfoEl.downloadSafeInfo.complianceInfo.actionBarType;
    }

    private static int d(Context context, AdTemplate adTemplate) {
        if (context == null || adTemplate == null) {
            return 9;
        }
        DownloadLandPageActivity.launch(context, adTemplate, false);
        return 9;
    }

    public final void clear() {
        pQ();
    }

    @Override // com.kwad.sdk.core.webview.a
    public final void pQ() {
        List<KsAppDownloadListener> list = this.PA;
        if (list != null) {
            list.clear();
        }
    }

    public final void a(a aVar) {
        this.Py = aVar;
    }

    public final void setOnShowListener(DialogInterface.OnShowListener onShowListener) {
        this.Pz = onShowListener;
    }

    public final void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        this.mOnDismissListener = onDismissListener;
    }

    @Override // com.kwad.sdk.core.NetworkMonitor.a
    public final void a(NetworkMonitor.NetworkState networkState) {
        if (this.mAdInfo.status == 7 && networkState == NetworkMonitor.NetworkState.NETWORK_WIFI) {
            pP();
        }
    }
}
