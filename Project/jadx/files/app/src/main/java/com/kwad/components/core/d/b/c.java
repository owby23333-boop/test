package com.kwad.components.core.d.b;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import com.kwad.components.core.d.a.b;
import com.kwad.components.core.d.b.a;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.page.AdWebViewVideoActivityProxy;
import com.kwad.components.core.page.DownloadLandPageActivity;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.api.KsApkDownloadListener;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.NetworkMonitor;
import com.kwad.sdk.core.diskcache.ApkCacheManager;
import com.kwad.sdk.core.download.f;
import com.kwad.sdk.core.report.a;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.utils.af;
import com.kwad.sdk.utils.aj;
import com.kwad.sdk.utils.g;
import com.kwad.sdk.utils.u;
import com.kwad.sdk.utils.v;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements NetworkMonitor.a, com.kwad.sdk.core.download.d, com.kwad.sdk.core.webview.a {

    @NonNull
    private AdTemplate Jm;
    private long Jn;
    private boolean Jo;
    private a Jp;
    private DialogInterface.OnShowListener Jq;
    private List<KsAppDownloadListener> Jr;
    private boolean downloadPauseEnable;

    @NonNull
    private AdInfo mAdInfo;
    private Handler mHandler;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private JSONObject mReportExtData;

    public interface a {
        boolean handleDownloadDialog(DialogInterface.OnClickListener onClickListener);
    }

    public c(@NonNull AdTemplate adTemplate) {
        this(adTemplate, null, null);
    }

    public c(@NonNull AdTemplate adTemplate, @NonNull KsAppDownloadListener ksAppDownloadListener) {
        this(adTemplate, null, ksAppDownloadListener);
    }

    public c(@NonNull AdTemplate adTemplate, KsAppDownloadListener ksAppDownloadListener, String str, String str2) {
        this(adTemplate, null, null);
        AdInfo adInfo = this.mAdInfo;
        adInfo.adConversionInfo.appDownloadUrl = str;
        adInfo.adBaseInfo.appPackageName = str2;
        adInfo.downloadId = ac.el(str);
    }

    public c(@NonNull AdTemplate adTemplate, JSONObject jSONObject) {
        this(adTemplate, jSONObject, null);
    }

    public c(@NonNull AdTemplate adTemplate, JSONObject jSONObject, KsAppDownloadListener ksAppDownloadListener) {
        this.mHandler = new Handler(Looper.getMainLooper());
        this.Jr = new ArrayList();
        this.Jm = adTemplate;
        this.mAdInfo = com.kwad.sdk.core.response.a.d.cb(adTemplate);
        this.mReportExtData = jSONObject;
        if (ksAppDownloadListener != null) {
            b(ksAppDownloadListener);
        }
        nv();
        com.kwad.sdk.core.download.c.vG().a(this, this.Jm);
        com.kwad.sdk.core.download.c.vG().an(this.Jm);
        this.downloadPauseEnable = com.kwad.sdk.core.response.a.a.ce(com.kwad.sdk.core.response.a.d.cb(this.Jm));
        if (com.kwad.sdk.core.config.d.uQ()) {
            NetworkMonitor.getInstance().a(KsAdSDKImpl.get().getContext(), this);
        }
        com.kwad.sdk.kwai.kwai.c.tm().ah(this.Jm);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@NonNull KsAppDownloadListener ksAppDownloadListener) {
        AdInfo adInfo = this.mAdInfo;
        int i2 = adInfo.progress;
        int i3 = adInfo.status;
        if (i3 == 0) {
            ksAppDownloadListener.onIdle();
            return;
        }
        if (i3 == 1) {
            ksAppDownloadListener.onProgressUpdate(0);
            if (ksAppDownloadListener instanceof com.kwad.sdk.core.download.kwai.a) {
                ((com.kwad.sdk.core.download.kwai.a) ksAppDownloadListener).onDownloadStarted();
                return;
            }
            try {
                ksAppDownloadListener.onDownloadStarted();
                return;
            } catch (Throwable th) {
                com.kwad.sdk.core.d.b.printStackTraceOnly(th);
                return;
            }
        }
        if (i3 == 2 || i3 == 3) {
            ksAppDownloadListener.onProgressUpdate(i2);
            return;
        }
        if (i3 == 4) {
            if (ksAppDownloadListener instanceof com.kwad.sdk.core.download.kwai.a) {
                ((com.kwad.sdk.core.download.kwai.a) ksAppDownloadListener).onPaused(i2);
            }
            try {
                if (ksAppDownloadListener instanceof KsApkDownloadListener) {
                    ((KsApkDownloadListener) ksAppDownloadListener).onPaused(i2);
                    return;
                }
                return;
            } catch (Throwable unused) {
                return;
            }
        }
        if (i3 == 7) {
            ksAppDownloadListener.onDownloadFailed();
            return;
        }
        if (i3 == 8 || i3 == 9) {
            ksAppDownloadListener.onDownloadFinished();
        } else {
            if (i3 != 12) {
                return;
            }
            ksAppDownloadListener.onInstalled();
        }
    }

    private static void d(Context context, AdTemplate adTemplate) {
        if (context == null || adTemplate == null) {
            return;
        }
        DownloadLandPageActivity.launch(context, adTemplate, false);
    }

    private int n(a.C0395a c0395a) {
        Context context = c0395a.getContext();
        String strCs = com.kwad.sdk.core.response.a.a.cs(this.mAdInfo);
        if (com.kwad.sdk.utils.d.a(context, strCs, this.Jm)) {
            com.kwad.sdk.core.report.a.k(this.Jm, 1);
            return 0;
        }
        if (com.kwad.sdk.utils.d.g(context, strCs, com.kwad.sdk.core.response.a.a.ar(this.mAdInfo))) {
            com.kwad.sdk.core.report.a.k(this.Jm, 0);
            return 0;
        }
        if (nG()) {
            return 0;
        }
        if (!af.isNetworkConnected(context)) {
            u.F(context, v.cb(context));
            return 0;
        }
        if (c0395a.ns() && com.kwad.sdk.core.config.d.us()) {
            return o(c0395a);
        }
        if (com.kwad.sdk.core.response.a.a.cz(this.mAdInfo)) {
            d(c0395a.getContext(), c0395a.getAdTemplate());
            return 0;
        }
        if (c0395a.no()) {
            return p(c0395a);
        }
        if (q(c0395a)) {
            return 0;
        }
        nK();
        return 0;
    }

    private void nA() {
        this.mHandler.post(new Runnable() { // from class: com.kwad.components.core.d.b.c.3
            @Override // java.lang.Runnable
            public final void run() {
                ArrayList<KsAppDownloadListener> arrayList = new ArrayList(c.this.Jr.size());
                arrayList.addAll(c.this.Jr);
                for (KsAppDownloadListener ksAppDownloadListener : arrayList) {
                    if (ksAppDownloadListener != null) {
                        c.this.a(ksAppDownloadListener);
                    }
                }
            }
        });
    }

    private void nB() {
        String str = this.mAdInfo.adBaseInfo.appPackageName;
        Context context = KsAdSDKImpl.get().getContext();
        if (context == null) {
            return;
        }
        if (aj.ah(context, str)) {
            this.mAdInfo.status = 12;
            return;
        }
        AdInfo adInfo = this.mAdInfo;
        if (adInfo.status == 12) {
            adInfo.status = 0;
            adInfo.progress = 0;
        }
        int i2 = this.mAdInfo.status;
        if (i2 == 8 || i2 == 9) {
            String str2 = this.mAdInfo.downloadFilePath;
            if (TextUtils.isEmpty(str2) || !new File(str2).exists()) {
                AdInfo adInfo2 = this.mAdInfo;
                adInfo2.status = 0;
                adInfo2.progress = 0;
            }
        }
        AdInfo adInfo3 = this.mAdInfo;
        if (adInfo3.status == 0) {
            String strA = com.kwad.sdk.core.download.a.A(adInfo3);
            if (TextUtils.isEmpty(strA) || !new File(strA).exists()) {
                return;
            }
            AdInfo adInfo4 = this.mAdInfo;
            adInfo4.downloadFilePath = strA;
            adInfo4.status = 8;
        }
    }

    private boolean nD() {
        String str = this.mAdInfo.adConversionInfo.marketUrl;
        com.kwad.sdk.core.d.b.i("ApkDownloadHelper", "isMarKet URL Schema=" + str);
        boolean zG = !TextUtils.isEmpty(str) ? com.kwad.sdk.utils.d.g(KsAdSDKImpl.get().getContext(), str, this.mAdInfo.adBaseInfo.appPackageName) : false;
        if (zG) {
            com.kwad.sdk.core.report.a.k(this.Jm, 0);
        }
        return zG;
    }

    private boolean nG() {
        a aVar = this.Jp;
        if (aVar != null) {
            return aVar.handleDownloadDialog(new DialogInterface.OnClickListener() { // from class: com.kwad.components.core.d.b.c.4
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    if (i2 == -1) {
                        switch (c.this.mAdInfo.status) {
                            case 0:
                            case 1:
                            case 4:
                            case 5:
                            case 6:
                            case 7:
                                c.this.nK();
                                break;
                            case 8:
                            case 9:
                            case 11:
                                c.this.nJ();
                                break;
                            case 12:
                                c.this.nH();
                                break;
                        }
                    }
                }
            });
        }
        return false;
    }

    private boolean nI() {
        Context context = KsAdSDKImpl.get().getContext();
        if (d.b(new a.C0395a(context).J(this.Jm), 1) == 1) {
            return true;
        }
        boolean zAj = aj.aj(context, com.kwad.sdk.core.response.a.a.ar(this.mAdInfo));
        if (zAj) {
            com.kwad.sdk.core.report.a.au(this.Jm);
        }
        return zAj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nK() {
        com.kwad.sdk.core.download.a.B(this.mAdInfo);
    }

    private void nv() {
        com.kwad.sdk.core.download.c.vG();
        int iBy = com.kwad.sdk.core.download.c.by(nx());
        if (iBy != 0) {
            this.mAdInfo.status = iBy;
        }
        nB();
        nA();
    }

    private boolean nz() {
        if (Build.VERSION.SDK_INT < 29) {
            if (this.Jm.mIsFromContent && com.kwad.sdk.core.config.d.ug()) {
                zNI = nI();
                if (zNI) {
                    com.kwad.sdk.core.report.a.av(this.Jm);
                }
            } else if (!this.Jm.mIsFromContent && com.kwad.sdk.core.config.d.uE()) {
                boolean zAk = com.kwad.components.core.i.b.ak(KsAdSDKImpl.get().getContext());
                com.kwad.sdk.core.d.b.d("ApkDownloadHelper", "handleForceOpenApp enableForceOpen: " + zAk);
                zNI = zAk ? nI() : false;
                if (zNI) {
                    com.kwad.sdk.core.report.a.aw(this.Jm);
                }
            }
        }
        return zNI;
    }

    private int o(a.C0395a c0395a) {
        Context context = c0395a.getContext();
        AdTemplate adTemplate = c0395a.getAdTemplate();
        int iNt = c0395a.nt();
        if (iNt == 1) {
            nK();
            return 0;
        }
        if (iNt == 2 && com.kwad.sdk.core.response.a.b.bC(adTemplate)) {
            com.kwad.components.core.d.a.b.a(context, new b.a().I(adTemplate).al(com.kwad.sdk.core.response.a.b.bB(adTemplate)).a(this.Jq).c(this.mOnDismissListener).nd());
        }
        return 0;
    }

    private int p(a.C0395a c0395a) {
        Context context = c0395a.getContext();
        AdTemplate adTemplate = c0395a.getAdTemplate();
        int iS = s(c0395a);
        if (iS == 1) {
            if (com.kwad.sdk.core.response.a.b.bC(adTemplate)) {
                com.kwad.components.core.d.a.b.a(context, new b.a().I(adTemplate).al(com.kwad.sdk.core.response.a.b.bB(adTemplate)).a(this.Jq).c(this.mOnDismissListener).nd());
            }
            return 0;
        }
        if (iS == 2) {
            d(c0395a.getContext(), c0395a.getAdTemplate());
            return 0;
        }
        if (iS == 3 || q(c0395a)) {
            return 0;
        }
        nK();
        return 0;
    }

    private boolean q(a.C0395a c0395a) {
        if (c0395a.nm() || this.mAdInfo.status == 4 || !com.kwad.sdk.core.response.a.b.bF(this.Jm) || !r(c0395a)) {
            return false;
        }
        return com.kwad.components.core.d.a.b.a(c0395a.getContext(), new b.a().I(this.Jm).al(com.kwad.sdk.core.response.a.b.bE(this.Jm)).a(this.Jq).c(this.mOnDismissListener).nd());
    }

    private static boolean r(a.C0395a c0395a) {
        AdInfo adInfoCb = com.kwad.sdk.core.response.a.d.cb(c0395a.getAdTemplate());
        if (com.kwad.sdk.core.response.a.a.bj(adInfoCb) && (DownloadLandPageActivity.showingAdWebViewLandPage || AdWebViewVideoActivityProxy.showingAdWebViewVideoActivity || c0395a.getAdTemplate().isWebViewDownload)) {
            return true;
        }
        return com.kwad.sdk.core.response.a.a.bk(adInfoCb) && !af.isWifiConnected(c0395a.getContext());
    }

    public static int s(a.C0395a c0395a) {
        AdInfo adInfoCb = com.kwad.sdk.core.response.a.d.cb(c0395a.getAdTemplate());
        if (adInfoCb.downloadSafeInfo.complianceInfo == null) {
            return 0;
        }
        int iDb = c0395a.db();
        return iDb != 2 ? iDb != 3 ? adInfoCb.downloadSafeInfo.complianceInfo.actionBarType : adInfoCb.downloadSafeInfo.complianceInfo.materialJumpType : adInfoCb.downloadSafeInfo.complianceInfo.describeBarType;
    }

    public final void a(a aVar) {
        this.Jp = aVar;
    }

    @Override // com.kwad.sdk.core.NetworkMonitor.a
    public final void a(NetworkMonitor.NetworkState networkState) {
        if (this.mAdInfo.status == 7 && networkState == NetworkMonitor.NetworkState.NETWORK_WIFI) {
            nK();
        }
    }

    @Override // com.kwad.sdk.core.download.d
    public final void a(String str, int i2, int i3, int i4) {
        if (this.mAdInfo.downloadId.equals(str)) {
            AdInfo adInfo = this.mAdInfo;
            adInfo.status = 3;
            adInfo.progress = i2;
            adInfo.soFarBytes = i3;
            adInfo.totalBytes = i4;
            nA();
        }
    }

    @Override // com.kwad.sdk.core.download.d
    public final void a(String str, int i2, f fVar) {
        final boolean zNz;
        AdInfo adInfoCb = com.kwad.sdk.core.response.a.d.cb(this.Jm);
        if (fVar.vK()) {
            com.kwad.sdk.core.report.a.as(this.Jm);
            fVar.vJ();
            zNz = nz();
            com.kwad.sdk.kwai.kwai.c.tm().ak(this.Jm);
            com.kwad.sdk.kwai.kwai.c.tm().ai(this.Jm);
            com.kwad.sdk.kwai.kwai.b.tj().ad(this.Jm);
        } else {
            zNz = false;
        }
        g.execute(new Runnable() { // from class: com.kwad.components.core.d.b.c.2
            @Override // java.lang.Runnable
            public final void run() {
                com.kwad.sdk.components.c.f(com.kwad.components.kwai.kwai.a.class);
            }
        });
        com.kwad.sdk.core.a.ud().bi(adInfoCb.downloadId);
        this.mAdInfo.status = 12;
        nA();
    }

    @Override // com.kwad.sdk.core.download.d
    public final void a(String str, int i2, String str2, f fVar) {
        if (this.mAdInfo.downloadId.equals(str)) {
            this.mAdInfo.status = 7;
            nA();
            if (fVar.vK()) {
                a.C0443a c0443a = new a.C0443a(i2, str2);
                com.kwad.sdk.core.report.a.a(this.Jm, c0443a);
                com.kwad.components.core.m.a.pr().a(this.Jm, this.mAdInfo.adConversionInfo.appDownloadUrl, c0443a.toJson().toString());
                fVar.vJ();
            }
            if (this.mAdInfo.adConversionInfo.retryH5TimeStep <= 0 || this.Jo) {
                return;
            }
            long jCurrentTimeMillis = System.currentTimeMillis() - this.Jn;
            AdInfo adInfo = this.mAdInfo;
            if (jCurrentTimeMillis >= adInfo.adConversionInfo.retryH5TimeStep || TextUtils.isEmpty(com.kwad.sdk.core.response.a.a.aL(adInfo))) {
                return;
            }
            AdWebViewActivityProxy.launch(KsAdSDKImpl.get().getContext(), this.Jm);
            this.Jo = true;
        }
    }

    @Override // com.kwad.sdk.core.download.d
    public final void a(String str, f fVar) {
        if (this.mAdInfo.downloadId.equals(str)) {
            if (this.mAdInfo.status != 1) {
                if (fVar.vK()) {
                    com.kwad.sdk.core.report.a.ar(this.Jm);
                    fVar.vJ();
                }
                this.Jn = System.currentTimeMillis();
            }
            this.mAdInfo.status = 1;
            nA();
        }
    }

    @Override // com.kwad.sdk.core.download.d
    public final void a(String str, String str2, f fVar) {
        if (this.mAdInfo.downloadId.equals(str)) {
            AdInfo adInfo = this.mAdInfo;
            adInfo.downloadFilePath = str2;
            adInfo.progress = 100;
            if (adInfo.status != 8 && !this.Jm.mDownloadFinishReported) {
                g.execute(new Runnable() { // from class: com.kwad.components.core.d.b.c.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        com.kwad.sdk.components.c.f(com.kwad.components.kwai.kwai.a.class);
                    }
                });
                if (fVar.vK()) {
                    com.kwad.sdk.core.report.a.f(this.Jm, this.mReportExtData);
                    fVar.vJ();
                }
                com.kwad.sdk.kwai.kwai.c.tm().aj(this.Jm);
                com.kwad.sdk.kwai.kwai.c.tm().ah(this.Jm);
                com.kwad.sdk.kwai.kwai.b.tj().ac(this.Jm);
                this.Jm.mDownloadFinishReported = true;
            }
            this.mAdInfo.status = 8;
            nA();
            ApkCacheManager.getInstance().vt();
        }
    }

    @Override // com.kwad.sdk.core.download.d
    public final void an(String str) {
        if (this.mAdInfo.downloadId.equals(str)) {
            com.kwad.sdk.core.report.a.at(this.Jm);
        }
    }

    public final void as(int i2) {
        this.Jm.downloadSource = i2;
    }

    @UiThread
    public final void b(final KsAppDownloadListener ksAppDownloadListener) {
        if (ksAppDownloadListener == null) {
            return;
        }
        if (Looper.myLooper() != Looper.getMainLooper()) {
            this.mHandler.post(new Runnable() { // from class: com.kwad.components.core.d.b.c.6
                @Override // java.lang.Runnable
                public final void run() {
                    if (c.this.Jr.contains(ksAppDownloadListener)) {
                        return;
                    }
                    c.this.Jr.add(0, ksAppDownloadListener);
                }
            });
        } else if (!this.Jr.contains(ksAppDownloadListener)) {
            this.Jr.add(0, ksAppDownloadListener);
        }
        nB();
        a(ksAppDownloadListener);
    }

    @Override // com.kwad.sdk.core.download.d
    public final void b(String str, f fVar) {
        if (this.mAdInfo.downloadId.equals(str)) {
            if (this.mAdInfo.status != 4 && fVar.vK()) {
                com.kwad.sdk.core.report.a.d(this.Jm, this.mReportExtData);
                fVar.vJ();
            }
            this.mAdInfo.status = 4;
            nA();
        }
    }

    public final void c(final KsAppDownloadListener ksAppDownloadListener) {
        if (ksAppDownloadListener == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            this.Jr.remove(ksAppDownloadListener);
        } else {
            this.mHandler.post(new Runnable() { // from class: com.kwad.components.core.d.b.c.7
                @Override // java.lang.Runnable
                public final void run() {
                    c.this.Jr.remove(ksAppDownloadListener);
                }
            });
        }
    }

    @Override // com.kwad.sdk.core.download.d
    public final void c(String str, f fVar) {
        if (this.mAdInfo.downloadId.equals(str)) {
            if (this.mAdInfo.status != 2 && fVar.vK()) {
                com.kwad.sdk.core.report.a.e(this.Jm, this.mReportExtData);
                fVar.vJ();
            }
            this.mAdInfo.status = 2;
            nA();
        }
    }

    public final void clear() {
        nL();
        com.kwad.sdk.core.download.c.vG().a(this);
        if (com.kwad.sdk.core.config.d.uQ()) {
            NetworkMonitor.getInstance().a(this);
        }
    }

    public final void d(KsAppDownloadListener ksAppDownloadListener) {
        if (ksAppDownloadListener == null) {
            return;
        }
        nB();
        a(ksAppDownloadListener);
    }

    @Override // com.kwad.sdk.core.download.d
    public final void d(String str, f fVar) {
        if (this.mAdInfo.downloadId.equals(str)) {
            if (this.mAdInfo.status != 5 && fVar.vK()) {
                com.kwad.sdk.core.report.a.g(this.Jm, this.mReportExtData);
                fVar.vJ();
            }
            this.mAdInfo.status = 5;
            nA();
        }
    }

    @Override // com.kwad.sdk.core.download.d
    public final void e(String str, f fVar) {
        if (this.mAdInfo.downloadId.equals(str)) {
            if (fVar.vK()) {
                com.kwad.sdk.core.report.a.h(this.Jm, 2);
                fVar.vJ();
            }
            this.mAdInfo.status = 9;
            nA();
        }
    }

    public final int m(a.C0395a c0395a) {
        this.Jo = false;
        nB();
        switch (this.mAdInfo.status) {
            case 0:
            case 1:
            case 5:
            case 6:
            case 7:
                return n(c0395a);
            case 2:
            case 3:
                if (!c0395a.nk() || !this.downloadPauseEnable) {
                    return 0;
                }
                com.kwad.sdk.core.download.a.bx(this.mAdInfo.downloadId);
                return 0;
            case 4:
                nK();
                return 0;
            case 8:
            case 9:
            case 11:
                nJ();
                return 0;
            case 10:
            default:
                return 0;
            case 12:
                nH();
                return 0;
        }
    }

    public final boolean nC() {
        switch (this.mAdInfo.status) {
            case 8:
            case 9:
            case 11:
                nJ();
                break;
            case 12:
                nH();
                break;
        }
        return true;
    }

    @NonNull
    public final AdTemplate nE() {
        return this.Jm;
    }

    public final boolean nF() {
        if (this.mAdInfo.status == 0) {
            return nD();
        }
        return false;
    }

    public final void nH() {
        g.execute(new Runnable() { // from class: com.kwad.components.core.d.b.c.5
            @Override // java.lang.Runnable
            public final void run() {
                com.kwad.sdk.components.c.f(com.kwad.components.kwai.kwai.a.class);
            }
        });
        if (aj.aj(KsAdSDKImpl.get().getContext(), com.kwad.sdk.core.response.a.a.ar(this.mAdInfo))) {
            com.kwad.sdk.core.report.a.au(this.Jm);
        }
    }

    public final void nJ() {
        if (aj.ak(KsAdSDKImpl.get().getContext(), this.mAdInfo.downloadFilePath)) {
            com.kwad.sdk.core.report.a.h(this.Jm, 1);
        }
    }

    @Override // com.kwad.sdk.core.webview.a
    public final void nL() {
        List<KsAppDownloadListener> list = this.Jr;
        if (list != null) {
            list.clear();
        }
    }

    public final int nw() {
        nB();
        int i2 = this.mAdInfo.status;
        if (i2 == 3) {
            return 2;
        }
        return i2;
    }

    @Override // com.kwad.sdk.core.download.d
    public final String nx() {
        return this.mAdInfo.downloadId;
    }

    @Override // com.kwad.sdk.core.download.d
    public final String ny() {
        return this.mAdInfo.adBaseInfo.appPackageName;
    }

    public final void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        this.mOnDismissListener = onDismissListener;
    }

    public final void setOnShowListener(DialogInterface.OnShowListener onShowListener) {
        this.Jq = onShowListener;
    }
}
