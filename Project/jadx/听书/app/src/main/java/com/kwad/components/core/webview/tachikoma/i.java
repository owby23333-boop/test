package com.kwad.components.core.webview.tachikoma;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.internal.view.SupportMenu;
import com.funny.audio.core.utils.FileUtils;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.t.i;
import com.kwad.components.core.video.m;
import com.kwad.components.core.webview.jshandler.a;
import com.kwad.components.core.webview.jshandler.aa;
import com.kwad.components.core.webview.jshandler.ab;
import com.kwad.components.core.webview.jshandler.ae;
import com.kwad.components.core.webview.jshandler.af;
import com.kwad.components.core.webview.jshandler.ai;
import com.kwad.components.core.webview.jshandler.al;
import com.kwad.components.core.webview.jshandler.am;
import com.kwad.components.core.webview.jshandler.ar;
import com.kwad.components.core.webview.jshandler.as;
import com.kwad.components.core.webview.jshandler.aw;
import com.kwad.components.core.webview.jshandler.ay;
import com.kwad.components.core.webview.jshandler.az;
import com.kwad.components.core.webview.jshandler.bc;
import com.kwad.components.core.webview.jshandler.bd;
import com.kwad.components.core.webview.jshandler.n;
import com.kwad.components.core.webview.tachikoma.b.p;
import com.kwad.components.core.webview.tachikoma.b.s;
import com.kwad.components.core.webview.tachikoma.b.t;
import com.kwad.components.core.webview.tachikoma.b.v;
import com.kwad.components.core.webview.tachikoma.b.x;
import com.kwad.components.core.webview.tachikoma.c.u;
import com.kwad.components.core.webview.tachikoma.c.z;
import com.kwad.components.core.webview.tachikoma.d.e;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.components.offline.api.OfflineHostProvider;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.components.offline.api.tk.ITkOfflineCompo;
import com.kwad.components.offline.api.tk.TKDownloadListener;
import com.kwad.components.offline.api.tk.TkLoggerReporter;
import com.kwad.components.offline.api.tk.model.StyleTemplate;
import com.kwad.components.offline.api.tk.model.report.TKPerformMsg;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.components.l;
import com.kwad.sdk.components.o;
import com.kwad.sdk.components.q;
import com.kwad.sdk.components.r;
import com.kwad.sdk.components.s;
import com.kwad.sdk.components.t;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.export.proxy.AdHttpBodyBuilder;
import com.kwad.sdk.export.proxy.AdHttpFormDataBuilder;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.utils.aq;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bw;
import com.kwad.sdk.utils.w;
import com.umeng.umcrash.UMCrash;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Future;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class i implements com.kwad.components.core.e.e.f, q, com.kwad.sdk.core.view.b, com.kwad.sdk.core.webview.d.a.a {
    private static Map<Integer, WeakReference<com.kwad.components.core.webview.tachikoma.d.e>> afB = new HashMap();
    protected long AO;
    private long II;
    private long YY;
    private long YZ;
    private StyleTemplate Yf;
    private aw abN;
    private com.kwad.sdk.core.download.d abO;
    private Map<String, Object> afA;
    private int afC;
    private int afD;
    private boolean afE;
    private String afF;
    private String afG;
    private boolean afH;
    protected com.kwad.sdk.core.webview.e afI;
    private o afJ;
    private int afK;
    private long afL;
    private long afM;
    private long afN;
    private long afO;
    private long afP;
    private com.kwad.components.core.webview.tachikoma.a.e afQ;
    private KsAdWebView.b afR;
    private a afS;
    private r afT;
    private com.kwad.sdk.components.k afU;
    private final Runnable afV;
    private final Runnable afW;
    private WeakReference<Activity> afh;
    private com.kwad.components.core.webview.tachikoma.d.e afi;
    protected j afj;
    private com.kwad.sdk.core.webview.c.g afk;
    private com.kwad.components.core.o.a.e.c afl;
    private Future<?> afm;
    private t afn;
    private p afo;
    private ay afp;
    private bc afq;
    private com.kwad.sdk.core.view.d afr;
    private TextView afs;
    private boolean aft;
    private boolean afu;
    private boolean afv;
    private boolean afw;
    private boolean afx;
    private int afy;
    private long afz;
    private az eS;
    private final m jE;
    private AdResultData mAdResultData;
    protected final Context mContext;
    private final z zK;

    /* JADX INFO: loaded from: classes4.dex */
    interface a {
        void onFailed();

        void onSuccess();
    }

    protected void a(com.kwad.sdk.core.webview.b bVar, com.kwad.components.core.e.d.c cVar, t tVar, ViewGroup viewGroup) {
    }

    protected void f(String str, String str2) {
    }

    protected void g(String str, String str2) {
    }

    protected boolean oP() {
        return false;
    }

    static /* synthetic */ boolean a(i iVar, boolean z) {
        iVar.aft = true;
        return true;
    }

    static /* synthetic */ boolean b(i iVar, boolean z) {
        iVar.afu = true;
        return true;
    }

    static /* synthetic */ boolean c(i iVar, boolean z) {
        iVar.afx = true;
        return true;
    }

    public i(Context context) {
        this(context, true);
    }

    public i(Context context, boolean z) {
        this.aft = false;
        this.afu = false;
        this.afv = false;
        this.afw = false;
        this.afx = false;
        this.afy = 0;
        this.AO = -1L;
        this.afC = 1000;
        this.afD = 0;
        this.afE = true;
        this.afI = new com.kwad.sdk.core.webview.e();
        this.afR = new KsAdWebView.b() { // from class: com.kwad.components.core.webview.tachikoma.i.1
            @Override // com.kwad.sdk.core.webview.KsAdWebView.b
            public final void onSuccess() {
                if (i.this.abN != null) {
                    i.this.abN.onSuccess();
                }
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.b
            public final void onFailed() {
                if (i.this.abN != null) {
                    i.this.abN.onFailed();
                }
            }
        };
        this.afS = new a() { // from class: com.kwad.components.core.webview.tachikoma.i.47
            @Override // com.kwad.components.core.webview.tachikoma.i.a
            public final void onSuccess() {
                com.kwad.sdk.core.d.c.d("TKLoadController", "JS执行成功");
            }

            @Override // com.kwad.components.core.webview.tachikoma.i.a
            public final void onFailed() {
                i.this.b(TKRenderFailReason.RENDER_ERROR);
                com.kwad.sdk.core.d.c.d("TKLoadController", "JS执行失败");
            }
        };
        this.afT = new r() { // from class: com.kwad.components.core.webview.tachikoma.i.4
            @Override // com.kwad.sdk.components.r
            public final void a(l lVar) {
                StyleTemplate styleTemplate;
                Activity activityUV = i.this.uV();
                if (activityUV == null) {
                    com.kwad.sdk.core.c.b.Ho();
                    activityUV = com.kwad.sdk.core.c.b.getCurrentActivity();
                }
                if (activityUV == null || activityUV.isFinishing()) {
                    lVar.callbackPageStatus(false, "no host activity");
                    return;
                }
                final String viewKey = lVar.getViewKey();
                if (viewKey == null) {
                    styleTemplate = new StyleTemplate();
                    try {
                        styleTemplate.parseJson(styleTemplate, new JSONObject(lVar.getStyleTemplate()));
                    } catch (Throwable th) {
                        com.kwad.sdk.core.d.c.printStackTrace(th);
                        lVar.callbackPageStatus(false, "template parse failed");
                        return;
                    }
                } else {
                    styleTemplate = null;
                }
                e.b bVar = new e.b();
                bVar.a(i.this.mAdResultData);
                bVar.c(lVar);
                if (styleTemplate != null) {
                    bVar.a(styleTemplate);
                }
                if (viewKey != null) {
                    bVar.a(new k() { // from class: com.kwad.components.core.webview.tachikoma.i.4.1
                        @Override // com.kwad.components.core.webview.tachikoma.k
                        public final o a(Object... objArr) {
                            if (i.this.afn != null) {
                                return i.this.afn.a(viewKey, objArr);
                            }
                            return null;
                        }
                    });
                }
                com.kwad.components.core.webview.tachikoma.d.e eVarB = com.kwad.components.core.webview.tachikoma.d.e.b(bVar);
                eVarB.show(activityUV.getFragmentManager(), "");
                i.afB.put(Integer.valueOf(lVar.getDialogId()), new WeakReference(eVarB));
            }

            @Override // com.kwad.sdk.components.r
            public final void b(l lVar) {
                WeakReference weakReference = (WeakReference) i.afB.get(Integer.valueOf(lVar.getDialogId()));
                if (weakReference == null || weakReference.get() == null) {
                    return;
                }
                ((com.kwad.components.core.webview.tachikoma.d.e) weakReference.get()).dismiss();
            }

            /* JADX WARN: Removed duplicated region for block: B:6:0x0011  */
            @Override // com.kwad.sdk.components.r
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void a(com.kwad.sdk.components.n r8) {
                /*
                    Method dump skipped, instruction units count: 253
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.core.webview.tachikoma.i.AnonymousClass4.a(com.kwad.sdk.components.n):void");
            }
        };
        this.afU = new com.kwad.sdk.components.k() { // from class: com.kwad.components.core.webview.tachikoma.i.5
            @Override // com.kwad.sdk.components.k
            public final com.kwad.sdk.components.j bi(int i) {
                return i.this.aN(com.kwad.sdk.core.response.b.c.r(com.kwad.components.core.o.a.e.a.a.aI(i)));
            }

            @Override // com.kwad.sdk.components.k
            public final com.kwad.sdk.components.j bf(String str) {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    AdTemplate adTemplate = new AdTemplate();
                    adTemplate.parseJson(jSONObject);
                    return i.this.aN(adTemplate);
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.c.printStackTrace(th);
                    return null;
                }
            }
        };
        this.afV = new Runnable() { // from class: com.kwad.components.core.webview.tachikoma.i.7
            @Override // java.lang.Runnable
            public final void run() {
                com.kwad.sdk.core.d.c.d("TKLoadController", "已经超时" + i.this.afj.getTkTemplateId());
                i.this.vq();
                i.a(i.this, true);
                i.this.b(TKRenderFailReason.TK_FILE_LOAD_TIMEOUT);
            }
        };
        this.afW = new Runnable() { // from class: com.kwad.components.core.webview.tachikoma.i.8
            @Override // java.lang.Runnable
            public final void run() {
                i.b(i.this, true);
                i.this.b(TKRenderFailReason.TK_FILE_LOAD_TIMEOUT);
            }
        };
        this.jE = new m() { // from class: com.kwad.components.core.webview.tachikoma.i.39
            @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
            public final void onMediaPreparing() {
                g(0.0d);
            }

            @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
            public final void onMediaPlayProgress(long j, long j2) {
                g(j2);
            }

            @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
            public final void onMediaPlayStart() {
                g(0.0d);
            }

            @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
            public final void onMediaPlayCompleted() {
                i.this.zK.Wy = true;
                i.this.zK.aho = false;
                i.this.zK.qz = com.kwad.sdk.core.response.b.a.L(com.kwad.sdk.core.response.b.e.el(i.this.vj()));
                ke();
            }

            @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
            public final void onMediaPlayError(int i, int i2) {
                i.this.zK.aho = true;
                i.this.zK.Wy = false;
                ke();
            }

            private void g(double d) {
                i.this.zK.aho = false;
                i.this.zK.Wy = false;
                i.this.zK.qz = (int) ((d / 1000.0d) + 0.5d);
                ke();
            }

            private void ke() {
                if (i.this.afo == null || i.this.zK == null) {
                    return;
                }
                i.this.afo.a(i.this.zK);
            }
        };
        this.mContext = context;
        this.AO = -1L;
        this.afC = 1000;
        this.afE = z;
        this.zK = new z();
    }

    public i(long j, Context context) {
        this.aft = false;
        this.afu = false;
        this.afv = false;
        this.afw = false;
        this.afx = false;
        this.afy = 0;
        this.AO = -1L;
        this.afC = 1000;
        this.afD = 0;
        this.afE = true;
        this.afI = new com.kwad.sdk.core.webview.e();
        this.afR = new KsAdWebView.b() { // from class: com.kwad.components.core.webview.tachikoma.i.1
            @Override // com.kwad.sdk.core.webview.KsAdWebView.b
            public final void onSuccess() {
                if (i.this.abN != null) {
                    i.this.abN.onSuccess();
                }
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.b
            public final void onFailed() {
                if (i.this.abN != null) {
                    i.this.abN.onFailed();
                }
            }
        };
        this.afS = new a() { // from class: com.kwad.components.core.webview.tachikoma.i.47
            @Override // com.kwad.components.core.webview.tachikoma.i.a
            public final void onSuccess() {
                com.kwad.sdk.core.d.c.d("TKLoadController", "JS执行成功");
            }

            @Override // com.kwad.components.core.webview.tachikoma.i.a
            public final void onFailed() {
                i.this.b(TKRenderFailReason.RENDER_ERROR);
                com.kwad.sdk.core.d.c.d("TKLoadController", "JS执行失败");
            }
        };
        this.afT = new r() { // from class: com.kwad.components.core.webview.tachikoma.i.4
            @Override // com.kwad.sdk.components.r
            public final void a(l lVar) {
                StyleTemplate styleTemplate;
                Activity activityUV = i.this.uV();
                if (activityUV == null) {
                    com.kwad.sdk.core.c.b.Ho();
                    activityUV = com.kwad.sdk.core.c.b.getCurrentActivity();
                }
                if (activityUV == null || activityUV.isFinishing()) {
                    lVar.callbackPageStatus(false, "no host activity");
                    return;
                }
                final String viewKey = lVar.getViewKey();
                if (viewKey == null) {
                    styleTemplate = new StyleTemplate();
                    try {
                        styleTemplate.parseJson(styleTemplate, new JSONObject(lVar.getStyleTemplate()));
                    } catch (Throwable th) {
                        com.kwad.sdk.core.d.c.printStackTrace(th);
                        lVar.callbackPageStatus(false, "template parse failed");
                        return;
                    }
                } else {
                    styleTemplate = null;
                }
                e.b bVar = new e.b();
                bVar.a(i.this.mAdResultData);
                bVar.c(lVar);
                if (styleTemplate != null) {
                    bVar.a(styleTemplate);
                }
                if (viewKey != null) {
                    bVar.a(new k() { // from class: com.kwad.components.core.webview.tachikoma.i.4.1
                        @Override // com.kwad.components.core.webview.tachikoma.k
                        public final o a(Object... objArr) {
                            if (i.this.afn != null) {
                                return i.this.afn.a(viewKey, objArr);
                            }
                            return null;
                        }
                    });
                }
                com.kwad.components.core.webview.tachikoma.d.e eVarB = com.kwad.components.core.webview.tachikoma.d.e.b(bVar);
                eVarB.show(activityUV.getFragmentManager(), "");
                i.afB.put(Integer.valueOf(lVar.getDialogId()), new WeakReference(eVarB));
            }

            @Override // com.kwad.sdk.components.r
            public final void b(l lVar) {
                WeakReference weakReference = (WeakReference) i.afB.get(Integer.valueOf(lVar.getDialogId()));
                if (weakReference == null || weakReference.get() == null) {
                    return;
                }
                ((com.kwad.components.core.webview.tachikoma.d.e) weakReference.get()).dismiss();
            }

            /* JADX WARN: Removed duplicated region for block: B:6:0x0011  */
            @Override // com.kwad.sdk.components.r
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void a(com.kwad.sdk.components.n r8) {
                /*
                    Method dump skipped, instruction units count: 253
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.core.webview.tachikoma.i.AnonymousClass4.a(com.kwad.sdk.components.n):void");
            }
        };
        this.afU = new com.kwad.sdk.components.k() { // from class: com.kwad.components.core.webview.tachikoma.i.5
            @Override // com.kwad.sdk.components.k
            public final com.kwad.sdk.components.j bi(int i) {
                return i.this.aN(com.kwad.sdk.core.response.b.c.r(com.kwad.components.core.o.a.e.a.a.aI(i)));
            }

            @Override // com.kwad.sdk.components.k
            public final com.kwad.sdk.components.j bf(String str) {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    AdTemplate adTemplate = new AdTemplate();
                    adTemplate.parseJson(jSONObject);
                    return i.this.aN(adTemplate);
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.c.printStackTrace(th);
                    return null;
                }
            }
        };
        this.afV = new Runnable() { // from class: com.kwad.components.core.webview.tachikoma.i.7
            @Override // java.lang.Runnable
            public final void run() {
                com.kwad.sdk.core.d.c.d("TKLoadController", "已经超时" + i.this.afj.getTkTemplateId());
                i.this.vq();
                i.a(i.this, true);
                i.this.b(TKRenderFailReason.TK_FILE_LOAD_TIMEOUT);
            }
        };
        this.afW = new Runnable() { // from class: com.kwad.components.core.webview.tachikoma.i.8
            @Override // java.lang.Runnable
            public final void run() {
                i.b(i.this, true);
                i.this.b(TKRenderFailReason.TK_FILE_LOAD_TIMEOUT);
            }
        };
        this.jE = new m() { // from class: com.kwad.components.core.webview.tachikoma.i.39
            @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
            public final void onMediaPreparing() {
                g(0.0d);
            }

            @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
            public final void onMediaPlayProgress(long j2, long j22) {
                g(j22);
            }

            @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
            public final void onMediaPlayStart() {
                g(0.0d);
            }

            @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
            public final void onMediaPlayCompleted() {
                i.this.zK.Wy = true;
                i.this.zK.aho = false;
                i.this.zK.qz = com.kwad.sdk.core.response.b.a.L(com.kwad.sdk.core.response.b.e.el(i.this.vj()));
                ke();
            }

            @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
            public final void onMediaPlayError(int i, int i2) {
                i.this.zK.aho = true;
                i.this.zK.Wy = false;
                ke();
            }

            private void g(double d) {
                i.this.zK.aho = false;
                i.this.zK.Wy = false;
                i.this.zK.qz = (int) ((d / 1000.0d) + 0.5d);
                ke();
            }

            private void ke() {
                if (i.this.afo == null || i.this.zK == null) {
                    return;
                }
                i.this.afo.a(i.this.zK);
            }
        };
        this.mContext = context;
        this.AO = j;
        this.zK = new z();
    }

    public i(Context context, int i, int i2) {
        this.aft = false;
        this.afu = false;
        this.afv = false;
        this.afw = false;
        this.afx = false;
        this.afy = 0;
        this.AO = -1L;
        this.afC = 1000;
        this.afD = 0;
        this.afE = true;
        this.afI = new com.kwad.sdk.core.webview.e();
        this.afR = new KsAdWebView.b() { // from class: com.kwad.components.core.webview.tachikoma.i.1
            @Override // com.kwad.sdk.core.webview.KsAdWebView.b
            public final void onSuccess() {
                if (i.this.abN != null) {
                    i.this.abN.onSuccess();
                }
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.b
            public final void onFailed() {
                if (i.this.abN != null) {
                    i.this.abN.onFailed();
                }
            }
        };
        this.afS = new a() { // from class: com.kwad.components.core.webview.tachikoma.i.47
            @Override // com.kwad.components.core.webview.tachikoma.i.a
            public final void onSuccess() {
                com.kwad.sdk.core.d.c.d("TKLoadController", "JS执行成功");
            }

            @Override // com.kwad.components.core.webview.tachikoma.i.a
            public final void onFailed() {
                i.this.b(TKRenderFailReason.RENDER_ERROR);
                com.kwad.sdk.core.d.c.d("TKLoadController", "JS执行失败");
            }
        };
        this.afT = new r() { // from class: com.kwad.components.core.webview.tachikoma.i.4
            @Override // com.kwad.sdk.components.r
            public final void a(l lVar) {
                StyleTemplate styleTemplate;
                Activity activityUV = i.this.uV();
                if (activityUV == null) {
                    com.kwad.sdk.core.c.b.Ho();
                    activityUV = com.kwad.sdk.core.c.b.getCurrentActivity();
                }
                if (activityUV == null || activityUV.isFinishing()) {
                    lVar.callbackPageStatus(false, "no host activity");
                    return;
                }
                final String viewKey = lVar.getViewKey();
                if (viewKey == null) {
                    styleTemplate = new StyleTemplate();
                    try {
                        styleTemplate.parseJson(styleTemplate, new JSONObject(lVar.getStyleTemplate()));
                    } catch (Throwable th) {
                        com.kwad.sdk.core.d.c.printStackTrace(th);
                        lVar.callbackPageStatus(false, "template parse failed");
                        return;
                    }
                } else {
                    styleTemplate = null;
                }
                e.b bVar = new e.b();
                bVar.a(i.this.mAdResultData);
                bVar.c(lVar);
                if (styleTemplate != null) {
                    bVar.a(styleTemplate);
                }
                if (viewKey != null) {
                    bVar.a(new k() { // from class: com.kwad.components.core.webview.tachikoma.i.4.1
                        @Override // com.kwad.components.core.webview.tachikoma.k
                        public final o a(Object... objArr) {
                            if (i.this.afn != null) {
                                return i.this.afn.a(viewKey, objArr);
                            }
                            return null;
                        }
                    });
                }
                com.kwad.components.core.webview.tachikoma.d.e eVarB = com.kwad.components.core.webview.tachikoma.d.e.b(bVar);
                eVarB.show(activityUV.getFragmentManager(), "");
                i.afB.put(Integer.valueOf(lVar.getDialogId()), new WeakReference(eVarB));
            }

            @Override // com.kwad.sdk.components.r
            public final void b(l lVar) {
                WeakReference weakReference = (WeakReference) i.afB.get(Integer.valueOf(lVar.getDialogId()));
                if (weakReference == null || weakReference.get() == null) {
                    return;
                }
                ((com.kwad.components.core.webview.tachikoma.d.e) weakReference.get()).dismiss();
            }

            /* JADX WARN: Removed duplicated region for block: B:6:0x0011  */
            @Override // com.kwad.sdk.components.r
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void a(com.kwad.sdk.components.n r8) {
                /*
                    Method dump skipped, instruction units count: 253
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.core.webview.tachikoma.i.AnonymousClass4.a(com.kwad.sdk.components.n):void");
            }
        };
        this.afU = new com.kwad.sdk.components.k() { // from class: com.kwad.components.core.webview.tachikoma.i.5
            @Override // com.kwad.sdk.components.k
            public final com.kwad.sdk.components.j bi(int i3) {
                return i.this.aN(com.kwad.sdk.core.response.b.c.r(com.kwad.components.core.o.a.e.a.a.aI(i3)));
            }

            @Override // com.kwad.sdk.components.k
            public final com.kwad.sdk.components.j bf(String str) {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    AdTemplate adTemplate = new AdTemplate();
                    adTemplate.parseJson(jSONObject);
                    return i.this.aN(adTemplate);
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.c.printStackTrace(th);
                    return null;
                }
            }
        };
        this.afV = new Runnable() { // from class: com.kwad.components.core.webview.tachikoma.i.7
            @Override // java.lang.Runnable
            public final void run() {
                com.kwad.sdk.core.d.c.d("TKLoadController", "已经超时" + i.this.afj.getTkTemplateId());
                i.this.vq();
                i.a(i.this, true);
                i.this.b(TKRenderFailReason.TK_FILE_LOAD_TIMEOUT);
            }
        };
        this.afW = new Runnable() { // from class: com.kwad.components.core.webview.tachikoma.i.8
            @Override // java.lang.Runnable
            public final void run() {
                i.b(i.this, true);
                i.this.b(TKRenderFailReason.TK_FILE_LOAD_TIMEOUT);
            }
        };
        this.jE = new m() { // from class: com.kwad.components.core.webview.tachikoma.i.39
            @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
            public final void onMediaPreparing() {
                g(0.0d);
            }

            @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
            public final void onMediaPlayProgress(long j2, long j22) {
                g(j22);
            }

            @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
            public final void onMediaPlayStart() {
                g(0.0d);
            }

            @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
            public final void onMediaPlayCompleted() {
                i.this.zK.Wy = true;
                i.this.zK.aho = false;
                i.this.zK.qz = com.kwad.sdk.core.response.b.a.L(com.kwad.sdk.core.response.b.e.el(i.this.vj()));
                ke();
            }

            @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
            public final void onMediaPlayError(int i3, int i22) {
                i.this.zK.aho = true;
                i.this.zK.Wy = false;
                ke();
            }

            private void g(double d) {
                i.this.zK.aho = false;
                i.this.zK.Wy = false;
                i.this.zK.qz = (int) ((d / 1000.0d) + 0.5d);
                ke();
            }

            private void ke() {
                if (i.this.afo == null || i.this.zK == null) {
                    return;
                }
                i.this.afo.a(i.this.zK);
            }
        };
        this.mContext = context;
        this.afC = i;
        this.zK = new z();
        this.afD = i2;
    }

    public final void a(StyleTemplate styleTemplate) {
        this.Yf = styleTemplate;
    }

    public final com.kwad.sdk.core.webview.b uU() {
        return this.afI;
    }

    public void a(Activity activity, AdResultData adResultData, j jVar) {
        this.afh = new WeakReference<>(activity);
        this.mAdResultData = adResultData;
        this.afI.a(adResultData);
        this.afj = jVar;
        this.afF = jVar.getTkTemplateId();
        this.afG = this.afj.getTKReaderScene();
        ve();
        FrameLayout tKContainer = this.afj.getTKContainer();
        if (tKContainer != null) {
            tKContainer.removeAllViews();
        }
        if (!com.kwad.sdk.core.config.e.Fq()) {
            b(TKRenderFailReason.SWITCH_CLOSE);
            return;
        }
        this.afl = (com.kwad.components.core.o.a.e.c) com.kwad.sdk.components.d.f(com.kwad.components.core.o.a.e.c.class);
        vl();
        com.kwad.sdk.core.d.c.d("TKLoadController", "bind mTKPlugin: " + this.afl);
        if (TextUtils.isEmpty(this.afF)) {
            com.kwad.sdk.commercial.e.a.e(vj(), this.afG);
        }
        if (this.afl != null) {
            if (vc()) {
                uW();
                return;
            } else {
                vf();
                return;
            }
        }
        b(TKRenderFailReason.PLUGIN_NOT_READY);
        f(this.afF, TKPerformMsg.ERROR_REASON.KSAD_TK_OFFLINE_FAILED);
        TkLoggerReporter.get().reportTKPerform(ILoggerReporter.Category.ERROR_LOG, new TKPerformMsg(this.afy).setRenderState(4).setErrorReason(TKPerformMsg.ERROR_REASON.KSAD_TK_OFFLINE_FAILED).setTemplateId(this.afF).toJson());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Activity uV() {
        WeakReference<Activity> weakReference = this.afh;
        if (weakReference == null || weakReference.get() == null) {
            return null;
        }
        return this.afh.get();
    }

    private void uW() {
        StyleTemplate styleTemplateVh = vh();
        if (styleTemplateVh == null) {
            bb("no template");
            return;
        }
        int iB = b(styleTemplateVh);
        this.afK = iB;
        try {
            t tVarA = com.kwad.components.core.t.i.a(Integer.valueOf(iB));
            if (tVarA != null) {
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                this.afz = jElapsedRealtime;
                this.afO = jElapsedRealtime;
                a(tVarA);
                return;
            }
            if (com.kwad.components.core.webview.tachikoma.e.b.vM().bn(this.afK)) {
                vf();
            } else {
                this.afL = SystemClock.elapsedRealtime();
                com.kwad.components.core.webview.tachikoma.e.b.vM().a(this.afK, new com.kwad.components.core.webview.tachikoma.f.f() { // from class: com.kwad.components.core.webview.tachikoma.i.12
                    @Override // com.kwad.components.core.webview.tachikoma.f.f
                    public final void vw() {
                        i.this.c(TKRenderFailReason.RENDER_ERROR);
                        i.this.be(TKPerformMsg.ERROR_REASON.KSAD_TK_RENDER_FAIL);
                    }

                    @Override // com.kwad.components.core.webview.tachikoma.f.f
                    public final void vx() {
                        i.a aVarB = com.kwad.components.core.t.i.b(Integer.valueOf(i.this.afK));
                        t tVarTk = aVarB.tk();
                        i.this.YY = aVarB.tg();
                        i.this.YZ = aVarB.ti();
                        i.this.II = aVarB.th();
                        i.this.afM = aVarB.tj();
                        i.this.afz = SystemClock.elapsedRealtime();
                        i iVar = i.this;
                        iVar.afO = iVar.afz;
                        i.this.uX();
                        i.this.a(tVarTk);
                    }
                });
            }
        } catch (Exception e) {
            b(TKRenderFailReason.RENDER_ERROR);
            be(e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uX() {
        long j = this.afL;
        long j2 = this.afM;
        if (j >= j2) {
            this.YY = 0L;
            this.YZ = 0L;
            this.II = 0L;
            this.afN = 0L;
            return;
        }
        long j3 = this.YZ;
        long j4 = this.YY;
        if (j >= j3 + j4) {
            this.YY = 0L;
            this.YZ = 0L;
            this.II = 0L;
            this.afN = j2 - j;
            this.afz = j2;
            return;
        }
        if (j3 >= j && j >= this.II) {
            this.II = j;
        } else if (j3 + j4 > j) {
            this.YY = (j3 + j4) - this.II;
            this.YZ = 0L;
            this.II = 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(t tVar) {
        try {
            if (this.Yf == null) {
                this.Yf = vh();
            }
            if (tVar == null) {
                return;
            }
            this.afn = tVar;
            vm();
            int iHashCode = this.mAdResultData.hashCode();
            com.kwad.components.core.o.a.e.a.a.a(iHashCode, this.mAdResultData);
            this.mAdResultData.mAdCacheId = iHashCode;
            com.kwad.sdk.core.d.c.d("TKLoadController", "renderTKTemplate tachikomaContext is not null");
            o oVarA = tVar.a(this.afj.getRegisterViewKey(), new af.a(this.mAdResultData).toJson().toString(), uZ(), uY());
            this.afJ = oVarA;
            va();
            View view = oVarA.getView();
            if (view != null) {
                FrameLayout tKContainer = this.afj.getTKContainer();
                if (tKContainer != 0 && this.afE) {
                    if (tKContainer instanceof com.kwad.sdk.core.view.d) {
                        com.kwad.sdk.core.view.d dVar = (com.kwad.sdk.core.view.d) tKContainer;
                        this.afr = dVar;
                        dVar.getWindowFocusChangeHelper().a(this);
                    }
                    view.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                    tKContainer.addView(view);
                }
                d(vh());
                vu();
                return;
            }
            com.kwad.components.core.t.i.c(Integer.valueOf(this.afK));
            b(TKRenderFailReason.RENDER_ERROR);
            be(TKPerformMsg.ERROR_REASON.KSAD_TK_RENDER_FAIL);
        } catch (Exception e) {
            com.kwad.components.core.t.i.c(Integer.valueOf(this.afK));
            b(TKRenderFailReason.RENDER_ERROR);
            be(e.getMessage());
            ServiceProvider.reportSdkCaughtException(e);
        }
    }

    private static String uY() {
        ai.a aVar = new ai.a();
        aVar.screenOrientation = !aq.isOrientationPortrait() ? 1 : 0;
        return aVar.toJson().toString();
    }

    private String uZ() {
        ae.a aVar = new ae.a();
        j jVar = this.afj;
        if (jVar != null) {
            jVar.a(aVar);
        } else {
            aVar.width = this.afI.TG.getWidth();
            aVar.height = this.afI.TG.getHeight();
        }
        return aVar.toJson().toString();
    }

    private void va() {
        vi();
        this.afj.aB();
        vb();
        a("setCloseAction", (String) null, new com.kwad.components.core.webview.tachikoma.a.b() { // from class: com.kwad.components.core.webview.tachikoma.i.23
            @Override // com.kwad.components.core.webview.tachikoma.a.b
            public final void c(WebCloseStatus webCloseStatus) {
                if (i.this.afj != null) {
                    i.this.afj.a(webCloseStatus);
                }
            }
        });
        a("setAdOutClickCallback", (String) null, new com.kwad.components.core.webview.tachikoma.a.c() { // from class: com.kwad.components.core.webview.tachikoma.i.34
            @Override // com.kwad.components.core.webview.tachikoma.a.c
            public final void b(a.C0354a c0354a) {
                if (i.this.afj != null) {
                    i.this.afj.a(c0354a);
                }
            }
        });
        a("setUpdatePositionCallback", (String) null, new com.kwad.components.core.webview.tachikoma.a.f() { // from class: com.kwad.components.core.webview.tachikoma.i.43
            @Override // com.kwad.components.core.webview.tachikoma.a.f
            public final void a(al.a aVar) {
                i.this.b(aVar);
            }
        });
        a("setCancelDownloadCallback", (String) null, new com.kwad.components.core.webview.tachikoma.a.d() { // from class: com.kwad.components.core.webview.tachikoma.i.44
            @Override // com.kwad.components.core.webview.tachikoma.a.d
            public final AdTemplate vy() {
                return i.this.vj();
            }
        });
    }

    private void vb() {
        com.kwad.components.core.e.d.c cVar = vj() != null ? new com.kwad.components.core.e.d.c(vj()) : null;
        this.afQ = new com.kwad.components.core.webview.tachikoma.a.e(cVar, this.afI, this.afJ);
        a("setClickAction", (String) null, new com.kwad.components.core.webview.tachikoma.a.a(uU(), cVar, this, true));
    }

    private static int b(StyleTemplate styleTemplate) {
        if (styleTemplate == null) {
            return 0;
        }
        return (styleTemplate.templateId + " " + styleTemplate.templateVersionCode).hashCode();
    }

    public final Object a(String str, String str2, com.kwad.sdk.components.m mVar) {
        o oVar = this.afJ;
        if (oVar != null) {
            return oVar.b(str, str2, mVar);
        }
        return null;
    }

    private boolean vc() {
        try {
            boolean z = (this.afG.equals("tk_feed_tk_card") && com.kwad.sdk.core.config.e.Gm()) || this.afG.equals("tk_draw_card");
            this.afH = z;
            return z;
        } catch (Exception unused) {
            return false;
        }
    }

    public final boolean vd() {
        return this.afH;
    }

    public final void a(com.kwad.sdk.core.webview.c.g gVar) {
        this.afk = gVar;
    }

    private void ve() {
        this.afv = false;
        this.afw = false;
        this.aft = false;
        this.afu = false;
        this.afx = false;
        this.II = 0L;
        this.YZ = 0L;
        this.YY = 0L;
        this.afz = 0L;
    }

    private void vf() {
        if (isLocalDebugEnable()) {
            this.afC = 2000;
            this.afD = 3000;
        }
        bw.runOnUiThreadDelay(this.afV, this.afC);
        int i = this.afD;
        if (i > 0) {
            bw.runOnUiThreadDelay(this.afW, i);
        }
        this.afm = GlobalThreadPools.Jt().submit(new bg() { // from class: com.kwad.components.core.webview.tachikoma.i.45
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                i.this.II = SystemClock.elapsedRealtime();
                com.kwad.sdk.core.d.c.d("TKLoadController", "开始读取模板 id: " + i.this.afj.getTkTemplateId());
                i.this.a(new TKDownloadListener() { // from class: com.kwad.components.core.webview.tachikoma.i.45.1
                    @Override // com.kwad.components.offline.api.tk.TKDownloadListener
                    public final void onSuccess(StyleTemplate styleTemplate) {
                        i.this.c(styleTemplate);
                    }

                    @Override // com.kwad.components.offline.api.tk.TKDownloadListener
                    public final void onFailed(String str) {
                        i.this.bb(str);
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final StyleTemplate styleTemplate) {
        com.kwad.sdk.utils.k.b("", "renderType_tk", styleTemplate.templateId, styleTemplate.templateUrl);
        com.kwad.sdk.core.d.c.d("TKLoadController", "读取完毕，总耗时" + (SystemClock.elapsedRealtime() - this.II) + ", 读取成功" + styleTemplate.templateId);
        if (this.aft) {
            return;
        }
        com.kwad.sdk.core.d.c.d("TKLoadController", "没有超时");
        bw.c(this.afV);
        bw.runOnUiThread(new bg() { // from class: com.kwad.components.core.webview.tachikoma.i.46
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                i iVar = i.this;
                iVar.a(styleTemplate, iVar.afS);
            }
        });
        ViewParent tKContainer = this.afj.getTKContainer();
        if (tKContainer instanceof com.kwad.sdk.core.view.d) {
            com.kwad.sdk.core.view.d dVar = (com.kwad.sdk.core.view.d) tKContainer;
            this.afr = dVar;
            dVar.getWindowFocusChangeHelper().a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bb(String str) {
        b(TKRenderFailReason.TK_FILE_LOAD_ERROR);
        bd(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TKDownloadListener tKDownloadListener) {
        StyleTemplate styleTemplateVh = vh();
        if (styleTemplateVh == null) {
            tKDownloadListener.onFailed("no template");
            return;
        }
        if (!isLocalDebugEnable()) {
            String strN = h.uS().n(styleTemplateVh.templateId, styleTemplateVh.templateVersionCode);
            if (!TextUtils.isEmpty(strN) && !isLocalDebugEnable()) {
                styleTemplateVh.jsStr = strN;
                styleTemplateVh.tkSouce = 4;
                com.kwad.sdk.core.d.c.d("TKLoadController", "使用TK模板缓存");
                tKDownloadListener.onSuccess(styleTemplateVh);
                return;
            }
        }
        this.afl.loadTkFileByTemplateId(this.mContext, styleTemplateVh.templateId, styleTemplateVh.templateMd5, styleTemplateVh.templateUrl, styleTemplateVh.templateVersionCode, tKDownloadListener);
    }

    private static boolean isLocalDebugEnable() {
        com.kwad.sdk.components.d.f(DevelopMangerComponents.class);
        return false;
    }

    private static boolean vg() {
        com.kwad.sdk.components.d.f(DevelopMangerComponents.class);
        return false;
    }

    private static StyleTemplate bc(String str) {
        com.kwad.sdk.components.d.f(DevelopMangerComponents.class);
        return null;
    }

    private StyleTemplate vh() {
        AdMatrixInfo.MatrixTemplate matrixTemplateK;
        String tkTemplateId = this.afj.getTkTemplateId();
        StyleTemplate styleTemplate = this.Yf;
        if (styleTemplate != null) {
            tkTemplateId = styleTemplate.templateId;
        }
        StyleTemplate styleTemplateBc = bc(tkTemplateId);
        if (styleTemplateBc != null) {
            return styleTemplateBc;
        }
        if (isLocalDebugEnable()) {
            StyleTemplate styleTemplate2 = new StyleTemplate();
            styleTemplate2.templateId = tkTemplateId;
            styleTemplate2.templateVersion = "1.0.4";
            styleTemplate2.templateVersionCode = 104;
            if (vg()) {
                styleTemplate2.templateUrl = "http://" + OfflineHostProvider.getApi().env().localIpAddress() + ":24680/" + tkTemplateId + ".104.coverage.zip";
            } else {
                styleTemplate2.templateUrl = "http://" + OfflineHostProvider.getApi().env().localIpAddress() + ":24680/" + tkTemplateId + ".104.zip";
            }
            return styleTemplate2;
        }
        StyleTemplate styleTemplate3 = this.Yf;
        if (styleTemplate3 != null) {
            return styleTemplate3;
        }
        AdTemplate adTemplateVj = vj();
        if (adTemplateVj == null || (matrixTemplateK = com.kwad.sdk.core.response.b.b.k(adTemplateVj, this.afj.getTkTemplateId())) == null) {
            return null;
        }
        com.kwad.components.core.o.a.e.c cVar = this.afl;
        if (cVar == null) {
            StyleTemplate styleTemplate4 = new StyleTemplate();
            styleTemplate4.templateId = matrixTemplateK.templateId;
            styleTemplate4.templateMd5 = matrixTemplateK.templateMd5;
            styleTemplate4.templateUrl = matrixTemplateK.templateUrl;
            styleTemplate4.templateVersionCode = (int) matrixTemplateK.templateVersionCode;
            styleTemplate4.tkSouce = 0;
            return styleTemplate4;
        }
        return cVar.checkStyleTemplateById(this.mContext, matrixTemplateK.templateId, matrixTemplateK.templateMd5, matrixTemplateK.templateUrl, (int) matrixTemplateK.templateVersionCode);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(StyleTemplate styleTemplate, a aVar) {
        this.Yf = styleTemplate;
        com.kwad.sdk.core.d.c.w("TKLoadController", "addTKView mTKPlugin.getState(): " + this.afl.getState());
        if (this.afl.getState() == ITkOfflineCompo.TKState.SO_FAIL) {
            bd(TKPerformMsg.ERROR_REASON.KSAD_TK_SO_FAIL);
            if (aVar != null) {
                aVar.onFailed();
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(styleTemplate.jsStr)) {
            be(TKPerformMsg.ERROR_REASON.KSAD_TK_NO_TEMPLATE);
            if (aVar != null) {
                aVar.onFailed();
                return;
            }
            return;
        }
        try {
            if (this.afH) {
                b(styleTemplate, aVar);
            } else {
                c(styleTemplate, aVar);
            }
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTrace(th);
            f(th);
            if (aVar != null) {
                aVar.onFailed();
            }
        }
    }

    private void b(StyleTemplate styleTemplate, final a aVar) {
        vm();
        this.YZ = SystemClock.elapsedRealtime();
        t tVarA = this.afl.a(this.mContext, styleTemplate.templateId, styleTemplate.templateVersionCode, styleTemplate.tkSouce, this.afE);
        com.kwad.components.core.o.a.e.a.a.a(this.mAdResultData.hashCode(), this.mAdResultData);
        tVarA.a(this.afT);
        tVarA.a(this.afU);
        if (this.Yf != null) {
            vr().put("styleTemplate", this.Yf.toJson().toString());
        }
        vr().put("appId", ServiceProvider.getAppId());
        vr().put("isDebug", com.kwad.components.core.a.oz);
        vr().put("newRenderType", Boolean.valueOf(this.afH));
        tVarA.setCustomEnv(vr());
        this.afn = tVarA;
        com.kwad.sdk.core.c.b.Ho();
        Activity currentActivity = com.kwad.sdk.core.c.b.getCurrentActivity();
        if (currentActivity != null) {
            ViewGroup viewGroup = (ViewGroup) currentActivity.getWindow().getDecorView();
            vr().put("isImmersiveMode", Boolean.valueOf(com.kwad.sdk.c.a.a.G(viewGroup) && com.kwad.sdk.c.a.a.bi(currentActivity) == viewGroup.getHeight()));
        }
        tVarA.setCustomEnv(vr());
        com.kwad.sdk.core.webview.c.g gVar = this.afk;
        if (gVar != null) {
            tVarA.b(gVar);
        }
        this.YY = SystemClock.elapsedRealtime() - this.YZ;
        this.afz = SystemClock.elapsedRealtime();
        c(tVarA);
        tVarA.a(styleTemplate.jsStr, new File(this.afl.getJsBaseDir(this.mContext, this.afj.getTkTemplateId())).getAbsolutePath() + "/", new s() { // from class: com.kwad.components.core.webview.tachikoma.i.2
            @Override // com.kwad.sdk.components.s
            public final void onSuccess() {
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.onSuccess();
                }
            }

            @Override // com.kwad.sdk.components.s
            public final void onFailed(Throwable th) {
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.onFailed();
                }
                i.this.f(th);
            }
        });
    }

    private void c(StyleTemplate styleTemplate, final a aVar) {
        vm();
        this.YZ = SystemClock.elapsedRealtime();
        t tVarA = this.afl.a(this.mContext, styleTemplate.templateId, styleTemplate.templateVersionCode, styleTemplate.tkSouce, this.afE);
        com.kwad.components.core.o.a.e.a.a.a(tVarA.getUniqId(), this.mAdResultData);
        tVarA.a(this.afT);
        tVarA.a(this.afU);
        AdResultData adResultData = this.mAdResultData;
        if (adResultData != null && com.kwad.sdk.core.response.b.c.r(adResultData).mAdScene != null) {
            vr().put("adStyle", Integer.valueOf(com.kwad.sdk.core.response.b.c.r(this.mAdResultData).mAdScene.getAdStyle()));
            vr().put("adScene", com.kwad.sdk.core.response.b.c.r(this.mAdResultData).mAdScene.toJson().toString());
        }
        if (this.Yf != null) {
            vr().put("styleTemplate", this.Yf.toJson().toString());
        }
        vr().put("adCacheId", Integer.valueOf(tVarA.getUniqId()));
        vr().put("appId", ServiceProvider.getAppId());
        vr().put("isDebug", com.kwad.components.core.a.oz);
        vr().put("newRenderType", Boolean.valueOf(this.afH));
        tVarA.setCustomEnv(vr());
        this.afn = tVarA;
        com.kwad.sdk.core.c.b.Ho();
        Activity currentActivity = com.kwad.sdk.core.c.b.getCurrentActivity();
        if (currentActivity != null) {
            ViewGroup viewGroup = (ViewGroup) currentActivity.getWindow().getDecorView();
            vr().put("isImmersiveMode", Boolean.valueOf(com.kwad.sdk.c.a.a.G(viewGroup) && com.kwad.sdk.c.a.a.bi(currentActivity) == viewGroup.getHeight()));
        }
        tVarA.setCustomEnv(vr());
        com.kwad.sdk.core.webview.c.g gVar = this.afk;
        if (gVar != null) {
            tVarA.b(gVar);
        }
        this.YY = SystemClock.elapsedRealtime() - this.YZ;
        this.afz = SystemClock.elapsedRealtime();
        vi();
        b(tVarA);
        tVarA.a(styleTemplate.jsStr, new File(this.afl.getJsBaseDir(this.mContext, this.afj.getTkTemplateId())).getAbsolutePath() + "/", new s() { // from class: com.kwad.components.core.webview.tachikoma.i.3
            @Override // com.kwad.sdk.components.s
            public final void onSuccess() {
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.onSuccess();
                }
            }

            @Override // com.kwad.sdk.components.s
            public final void onFailed(Throwable th) {
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.onFailed();
                }
                i.this.f(th);
            }
        });
        FrameLayout tKContainer = this.afj.getTKContainer();
        if (tKContainer == null || !this.afE) {
            return;
        }
        View view = tVarA.getView();
        view.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        tKContainer.addView(view);
        d(styleTemplate);
    }

    private void d(StyleTemplate styleTemplate) {
        if (com.kwad.components.core.a.oz.booleanValue() && this.afj.getTKContainer() != null) {
            if (this.afs == null) {
                TextView textView = new TextView(this.mContext);
                this.afs = textView;
                textView.setTextSize(12.0f);
                this.afs.setTextColor(SupportMenu.CATEGORY_MASK);
                this.afj.getTKContainer().addView(this.afs);
            }
            this.afs.setText(styleTemplate.templateId + " " + styleTemplate.templateVersionCode);
            this.afs.setVisibility(0);
        }
    }

    private void vi() {
        this.afI.a(!aq.QW() ? 1 : 0, this.afj.getTouchCoordsView(), this.afj.getTKContainer(), this.afj.getTkTemplateId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.kwad.sdk.components.j aN(final AdTemplate adTemplate) {
        final com.kwad.components.core.e.d.c cVar = new com.kwad.components.core.e.d.c(adTemplate);
        cVar.pG();
        return new com.kwad.sdk.components.j() { // from class: com.kwad.components.core.webview.tachikoma.i.6
            @Override // com.kwad.sdk.components.j
            public final void setCustomReportParam(String str) {
                try {
                    cVar.d(new JSONObject(str));
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.c.printStackTrace(th);
                }
            }

            @Override // com.kwad.sdk.components.j
            public final void a(final com.kwad.sdk.components.i iVar) {
                cVar.b(new com.kwad.sdk.core.download.a.a() { // from class: com.kwad.components.core.webview.tachikoma.i.6.1
                    @Override // com.kwad.sdk.api.KsAppDownloadListener
                    public final void onIdle() {
                        iVar.onIdle();
                    }

                    @Override // com.kwad.sdk.core.download.a.a, com.kwad.sdk.api.KsAppDownloadListener
                    public final void onDownloadStarted() {
                        iVar.onDownloadStarted();
                    }

                    @Override // com.kwad.sdk.api.KsAppDownloadListener
                    public final void onProgressUpdate(int i) {
                        long j;
                        long j2;
                        AdTemplate adTemplate2 = i.this.afI.getAdTemplate();
                        if (adTemplate2 != null) {
                            j = com.kwad.sdk.core.response.b.e.el(adTemplate2).totalBytes;
                            j2 = com.kwad.sdk.core.response.b.e.el(adTemplate2).soFarBytes;
                        } else {
                            j = 0;
                            j2 = 0;
                        }
                        iVar.onProgressUpdate(i, j, j2);
                    }

                    @Override // com.kwad.sdk.api.KsAppDownloadListener
                    public final void onDownloadFinished() {
                        iVar.onDownloadFinished();
                    }

                    @Override // com.kwad.sdk.api.KsAppDownloadListener
                    public final void onInstalled() {
                        iVar.onInstalled();
                    }

                    @Override // com.kwad.sdk.api.KsAppDownloadListener
                    public final void onDownloadFailed() {
                        iVar.onDownloadFailed();
                    }

                    @Override // com.kwad.sdk.core.download.a.a
                    public final void onPaused(int i) {
                        long j;
                        long j2;
                        AdTemplate adTemplate2 = i.this.afI.getAdTemplate();
                        if (adTemplate2 != null) {
                            j = com.kwad.sdk.core.response.b.e.el(adTemplate2).totalBytes;
                            j2 = com.kwad.sdk.core.response.b.e.el(adTemplate2).soFarBytes;
                        } else {
                            j = 0;
                            j2 = 0;
                        }
                        iVar.onPaused(i, j, j2);
                    }
                });
            }

            @Override // com.kwad.sdk.components.j
            public final void startDownload() {
                cVar.pM();
            }

            @Override // com.kwad.sdk.components.j
            public final void pauseDownload() {
                cVar.pN();
            }

            @Override // com.kwad.sdk.components.j
            public final void resumeDownload() {
                cVar.pO();
            }

            @Override // com.kwad.sdk.components.j
            public final void stopDownload() {
                cVar.pN();
            }

            @Override // com.kwad.sdk.components.j
            public final void cancelDownload() {
                com.kwad.sdk.core.download.a.dM(com.kwad.sdk.core.response.b.e.eo(adTemplate));
            }

            @Override // com.kwad.sdk.components.j
            public final void installApp() {
                cVar.pL();
            }

            @Override // com.kwad.sdk.components.j
            public final void openApp() {
                cVar.pJ();
            }
        };
    }

    protected final AdTemplate vj() {
        return this.afI.getAdTemplate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final TKRenderFailReason tKRenderFailReason) {
        bw.postOnUiThread(new bg() { // from class: com.kwad.components.core.webview.tachikoma.i.9
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                if (i.this.afx) {
                    return;
                }
                i.c(i.this, true);
                i.this.afj.a(tKRenderFailReason);
                com.kwad.components.core.e.e.g.pY().b(i.this);
                com.kwad.components.core.webview.tachikoma.e.c.vO().t(i.this.afF, i.this.afG);
                com.kwad.components.core.webview.tachikoma.e.b.vM().b(i.this.afK, i.this.afF, i.this.afG);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final TKRenderFailReason tKRenderFailReason) {
        bw.postOnUiThread(new bg() { // from class: com.kwad.components.core.webview.tachikoma.i.10
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                if (i.this.afx) {
                    return;
                }
                i.c(i.this, true);
                i.this.afj.a(tKRenderFailReason);
                com.kwad.components.core.e.e.g.pY().b(i.this);
                com.kwad.components.core.webview.tachikoma.e.c.vO().t(i.this.afF, i.this.afG);
            }
        });
    }

    private void b(t tVar) {
        com.kwad.components.core.e.d.c cVar = vj() != null ? new com.kwad.components.core.e.d.c(vj()) : null;
        this.afj.a(tVar, this.afI);
        a(tVar, new com.kwad.components.core.webview.jshandler.q());
        a(tVar, new com.kwad.components.core.webview.jshandler.r());
        com.kwad.components.core.webview.tachikoma.b.s sVar = new com.kwad.components.core.webview.tachikoma.b.s();
        sVar.a(new s.a() { // from class: com.kwad.components.core.webview.tachikoma.i.11
            @Override // com.kwad.components.core.webview.tachikoma.b.s.a
            public final void a(com.kwad.components.core.webview.tachikoma.c.t tVar2) {
                if (TextUtils.isEmpty(tVar2.message)) {
                    return;
                }
                ac.d(i.this.mContext, tVar2.message, 0L);
            }
        });
        a(tVar, sVar);
        a(tVar, c(this.afI));
        a(tVar, new n(this.afI));
        a(tVar, new com.kwad.components.core.webview.jshandler.o(this.afI));
        a(tVar, new com.kwad.sdk.core.webview.d.a());
        a(tVar, new com.kwad.components.core.webview.tachikoma.b.f());
        a(tVar, new x());
        if (oP()) {
            com.kwad.components.core.webview.jshandler.z zVar = new com.kwad.components.core.webview.jshandler.z(this.afI, cVar, this);
            if (!this.afF.equals(com.kwad.sdk.core.response.b.b.df(this.afI.getAdTemplate()))) {
                com.kwad.components.core.e.e.g.pY().a(this);
            }
            a(tVar, zVar);
        } else {
            a(tVar, new com.kwad.components.core.webview.jshandler.ac(this.afI, cVar, this, (byte) 0));
        }
        a(tVar, new ab(this.afI));
        a(tVar, new com.kwad.components.core.webview.tachikoma.b.k());
        a(tVar, new af(this.afI));
        a(tVar, new ai(this.afI));
        a(tVar, new ar(this.mContext, vj()));
        ae aeVar = new ae(this.afI);
        aeVar.a(new ae.b() { // from class: com.kwad.components.core.webview.tachikoma.i.13
            @Override // com.kwad.components.core.webview.jshandler.ae.b
            public final void c(ae.a aVar) {
                i.this.afj.a(aVar);
            }
        });
        a(tVar, aeVar);
        a(tVar, new bd(this.afI, new bd.a() { // from class: com.kwad.components.core.webview.tachikoma.i.14
            @Override // com.kwad.components.core.webview.jshandler.bd.a
            public final void f(AdTemplate adTemplate) {
                try {
                    i.this.afI.KI().remove(0);
                    i.this.afI.KI().add(adTemplate);
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(adTemplate);
                    AdResultData adResultData = new AdResultData();
                    adResultData.setAdTemplateList(arrayList);
                    adResultData.llsid = adTemplate.llsid;
                    i.this.mAdResultData = adResultData;
                    i.this.afj.f(com.kwad.sdk.core.response.b.c.r(i.this.mAdResultData));
                    if (i.this.afn != null) {
                        com.kwad.components.core.o.a.e.a.a.a(i.this.afn.getUniqId(), i.this.mAdResultData);
                    }
                    i.this.afq.setApkDownloadHelper(new com.kwad.components.core.e.d.c(adTemplate));
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.c.printStackTrace(th);
                }
            }
        }));
        a(tVar, new al(this.afI, new al.b() { // from class: com.kwad.components.core.webview.tachikoma.i.15
            @Override // com.kwad.components.core.webview.jshandler.al.b
            public final void a(al.a aVar) {
                i.this.b(aVar);
            }
        }));
        a(tVar, new as(new as.b() { // from class: com.kwad.components.core.webview.tachikoma.i.16
            @Override // com.kwad.components.core.webview.jshandler.as.b
            public final void a(as.a aVar) {
                if (aVar.status != 1) {
                    i.this.b(TKRenderFailReason.RENDER_ERROR);
                    i.this.be(aVar.errorMsg);
                } else {
                    i.this.vu();
                }
            }
        }));
        az azVar = new az();
        this.eS = azVar;
        a(tVar, azVar);
        this.afj.a(this.eS);
        ay ayVar = new ay();
        this.afp = ayVar;
        a(tVar, ayVar);
        bc bcVar = new bc(this.afI, cVar);
        this.afq = bcVar;
        a(tVar, bcVar);
        p pVar = new p();
        this.afo = pVar;
        a(tVar, pVar);
        this.afj.a(this.afo);
        a(tVar, new com.kwad.components.core.webview.jshandler.a(new a.b() { // from class: com.kwad.components.core.webview.tachikoma.i.17
            @Override // com.kwad.components.core.webview.jshandler.a.b
            public final void c(a.C0354a c0354a) {
                i.this.afj.a(c0354a);
            }
        }));
        if (vj() != null && com.kwad.sdk.core.response.b.a.aF(com.kwad.sdk.core.response.b.e.el(vj()))) {
            final com.kwad.components.core.webview.tachikoma.b.l lVar = new com.kwad.components.core.webview.tachikoma.b.l();
            a(tVar, lVar);
            this.abO = new com.kwad.sdk.core.download.d(vj()) { // from class: com.kwad.components.core.webview.tachikoma.i.18
                @Override // com.kwad.sdk.core.download.d, com.kwad.sdk.core.download.c
                public final void b(String str, String str2, com.kwad.sdk.core.download.e eVar) {
                    super.b(str, str2, eVar);
                    com.kwad.components.core.webview.tachikoma.c.b bVar = new com.kwad.components.core.webview.tachikoma.c.b();
                    bVar.agU = 1;
                    lVar.a(bVar);
                }
            };
            com.kwad.sdk.core.download.b.GR().a(this.abO, vj());
        }
        com.kwad.components.core.webview.tachikoma.b.t tVar2 = new com.kwad.components.core.webview.tachikoma.b.t();
        tVar2.a(new t.a() { // from class: com.kwad.components.core.webview.tachikoma.i.19
            @Override // com.kwad.components.core.webview.tachikoma.b.t.a
            public final void b(u uVar) {
                i.this.afj.a(uVar);
            }
        });
        a(tVar, tVar2);
        v vVar = new v();
        vVar.a(new v.a() { // from class: com.kwad.components.core.webview.tachikoma.i.20
            @Override // com.kwad.components.core.webview.tachikoma.b.v.a
            public final void b(com.kwad.components.core.webview.tachikoma.c.n nVar) {
                i.this.afj.a(nVar);
            }
        });
        a(tVar, vVar);
        com.kwad.components.core.webview.tachikoma.b.o oVar = new com.kwad.components.core.webview.tachikoma.b.o();
        a(tVar, oVar);
        this.afj.a(oVar);
        a(tVar, new com.kwad.components.core.webview.tachikoma.b.r() { // from class: com.kwad.components.core.webview.tachikoma.i.21
            @Override // com.kwad.components.core.webview.tachikoma.b.r
            public final void a(com.kwad.components.core.webview.tachikoma.c.s sVar2) {
                super.a(sVar2);
                Activity activityUV = i.this.uV();
                if (activityUV == null) {
                    com.kwad.sdk.core.c.b.Ho();
                    activityUV = com.kwad.sdk.core.c.b.getCurrentActivity();
                }
                if (activityUV == null || activityUV.isFinishing()) {
                    return;
                }
                if (i.this.afi != null) {
                    i.this.afi.dismiss();
                }
                e.b bVar = new e.b();
                bVar.a(i.this.mAdResultData);
                bVar.bg(sVar2.templateId);
                i.this.afi = com.kwad.components.core.webview.tachikoma.d.e.b(bVar);
                i.this.afi.show(activityUV.getFragmentManager(), "");
            }
        });
        a(tVar, new com.kwad.components.core.webview.tachikoma.b.c() { // from class: com.kwad.components.core.webview.tachikoma.i.22
            @Override // com.kwad.components.core.webview.tachikoma.b.c
            public final void kh() {
                super.kh();
                if (i.this.afi != null) {
                    i.this.afi.dismiss();
                }
                if (i.this.afj != null) {
                    i.this.afj.aA();
                }
            }
        });
        a(tVar, new aa(new com.kwad.sdk.core.webview.d.a.b() { // from class: com.kwad.components.core.webview.tachikoma.i.24
            @Override // com.kwad.sdk.core.webview.d.a.b
            public final void b(WebCloseStatus webCloseStatus) {
                i.this.afj.a(webCloseStatus);
            }
        }));
        a(tVar, new com.kwad.components.core.webview.tachikoma.b.d() { // from class: com.kwad.components.core.webview.tachikoma.i.25
            @Override // com.kwad.components.core.webview.tachikoma.b.d
            public final void a(com.kwad.components.core.webview.tachikoma.c.g gVar) {
                AdTemplate adTemplateA = gVar.acb >= 0 ? com.kwad.sdk.core.response.b.c.a(com.kwad.components.core.o.a.e.a.a.aI(gVar.acb), gVar.NN) : null;
                if (adTemplateA == null) {
                    adTemplateA = i.this.vj();
                }
                com.kwad.components.core.p.a.se().a(gVar.actionType, adTemplateA, gVar.Pj);
            }
        });
        a(tVar, new com.kwad.components.core.webview.tachikoma.b.j() { // from class: com.kwad.components.core.webview.tachikoma.i.26
            @Override // com.kwad.components.core.webview.tachikoma.b.j
            public final void a(com.kwad.components.core.webview.tachikoma.c.o oVar2) {
                super.a(oVar2);
                AdWebViewActivityProxy.launch(i.this.mContext, new AdWebViewActivityProxy.a.C0344a().az(oVar2.title).aA(oVar2.url).aH(!oVar2.ahh).q(i.this.mAdResultData).qW());
            }
        });
        a(tVar, new com.kwad.components.core.webview.tachikoma.b.a(vj()));
        a(tVar, new com.kwad.components.core.webview.tachikoma.a(vj()));
        a(this.afI, cVar, tVar, this.afj.getTKContainer());
        a(tVar, new com.kwad.components.core.webview.jshandler.a.f(this.mContext));
        a(tVar, new com.kwad.components.core.webview.jshandler.a.d(this.mContext));
        a(tVar, new com.kwad.components.core.webview.jshandler.a.a());
        a(tVar, new com.kwad.components.core.webview.jshandler.a.e(this.mContext));
        aw awVar = new aw();
        this.abN = awVar;
        a(tVar, awVar);
        a(tVar, new com.kwad.components.core.webview.jshandler.c(this.afI));
    }

    private void c(final com.kwad.sdk.components.t tVar) {
        com.kwad.components.core.e.d.c cVar = vj() != null ? new com.kwad.components.core.e.d.c(vj()) : null;
        this.afj.a(tVar, this.afI);
        a(tVar, new com.kwad.components.core.webview.jshandler.q());
        a(tVar, new com.kwad.components.core.webview.jshandler.r());
        com.kwad.components.core.webview.tachikoma.b.s sVar = new com.kwad.components.core.webview.tachikoma.b.s();
        sVar.a(new s.a() { // from class: com.kwad.components.core.webview.tachikoma.i.27
            @Override // com.kwad.components.core.webview.tachikoma.b.s.a
            public final void a(com.kwad.components.core.webview.tachikoma.c.t tVar2) {
                if (TextUtils.isEmpty(tVar2.message)) {
                    return;
                }
                ac.d(i.this.mContext, tVar2.message, 0L);
            }
        });
        a(tVar, sVar);
        a(tVar, c(this.afI));
        a(tVar, new com.kwad.sdk.core.webview.d.a());
        a(tVar, new com.kwad.components.core.webview.tachikoma.b.f());
        a(tVar, new x());
        if (oP()) {
            com.kwad.components.core.webview.jshandler.z zVar = new com.kwad.components.core.webview.jshandler.z(this.afI, cVar, this);
            if (!this.afF.equals(com.kwad.sdk.core.response.b.b.df(this.afI.getAdTemplate()))) {
                com.kwad.components.core.e.e.g.pY().a(this);
            }
            a(tVar, zVar);
        } else {
            a(tVar, new com.kwad.components.core.webview.jshandler.ac(this.afI, cVar, this, (byte) 0));
        }
        a(tVar, new ab(this.afI));
        a(tVar, new com.kwad.components.core.webview.tachikoma.b.k());
        a(tVar, new ar(this.mContext, vj()));
        a(tVar, new bd(this.afI, new bd.a() { // from class: com.kwad.components.core.webview.tachikoma.i.28
            @Override // com.kwad.components.core.webview.jshandler.bd.a
            public final void f(AdTemplate adTemplate) {
                try {
                    i.this.afI.KI().remove(0);
                    i.this.afI.KI().add(adTemplate);
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(adTemplate);
                    AdResultData adResultData = new AdResultData();
                    adResultData.setAdTemplateList(arrayList);
                    adResultData.llsid = adTemplate.llsid;
                    i.this.mAdResultData = adResultData;
                    i.this.afj.f(com.kwad.sdk.core.response.b.c.r(i.this.mAdResultData));
                    if (i.this.afn != null) {
                        com.kwad.components.core.o.a.e.a.a.a(i.this.afn.getUniqId(), i.this.mAdResultData);
                    }
                    i.this.afq.setApkDownloadHelper(new com.kwad.components.core.e.d.c(adTemplate));
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.c.printStackTrace(th);
                }
            }
        }));
        a(tVar, new as(new as.b() { // from class: com.kwad.components.core.webview.tachikoma.i.29
            @Override // com.kwad.components.core.webview.jshandler.as.b
            public final void a(as.a aVar) {
                if (aVar.status == 2 && i.this.afH) {
                    try {
                        i.this.afM = SystemClock.elapsedRealtime();
                        i iVar = i.this;
                        iVar.afO = iVar.afM;
                        i iVar2 = i.this;
                        iVar2.afN = iVar2.afM - i.this.afz;
                        com.kwad.sdk.core.d.c.d("WebCardPageStatusHandler", "registerTKContext");
                        com.kwad.components.core.t.i.a(Integer.valueOf(i.this.afK), tVar, i.this.YY, i.this.II, i.this.YZ, i.this.afM);
                        i.this.a(tVar);
                        com.kwad.components.core.webview.tachikoma.e.b.vM().bp(i.this.afK);
                        return;
                    } catch (Exception e) {
                        com.kwad.components.core.t.i.c(Integer.valueOf(i.this.afK));
                        i.this.b(TKRenderFailReason.RENDER_ERROR);
                        i.this.be(e.getMessage());
                        return;
                    }
                }
                if (aVar.status == 0) {
                    i.this.b(TKRenderFailReason.RENDER_ERROR);
                    i.this.be(aVar.errorMsg);
                }
            }
        }));
        ay ayVar = new ay();
        this.afp = ayVar;
        a(tVar, ayVar);
        p pVar = new p();
        this.afo = pVar;
        a(tVar, pVar);
        this.afj.a(this.afo);
        if (vj() != null && com.kwad.sdk.core.response.b.a.aF(com.kwad.sdk.core.response.b.e.el(vj()))) {
            final com.kwad.components.core.webview.tachikoma.b.l lVar = new com.kwad.components.core.webview.tachikoma.b.l();
            a(tVar, lVar);
            this.abO = new com.kwad.sdk.core.download.d(vj()) { // from class: com.kwad.components.core.webview.tachikoma.i.30
                @Override // com.kwad.sdk.core.download.d, com.kwad.sdk.core.download.c
                public final void b(String str, String str2, com.kwad.sdk.core.download.e eVar) {
                    super.b(str, str2, eVar);
                    com.kwad.components.core.webview.tachikoma.c.b bVar = new com.kwad.components.core.webview.tachikoma.c.b();
                    bVar.agU = 1;
                    lVar.a(bVar);
                }
            };
            com.kwad.sdk.core.download.b.GR().a(this.abO, vj());
        }
        com.kwad.components.core.webview.tachikoma.b.t tVar2 = new com.kwad.components.core.webview.tachikoma.b.t();
        tVar2.a(new t.a() { // from class: com.kwad.components.core.webview.tachikoma.i.31
            @Override // com.kwad.components.core.webview.tachikoma.b.t.a
            public final void b(u uVar) {
                i.this.afj.a(uVar);
            }
        });
        a(tVar, tVar2);
        v vVar = new v();
        vVar.a(new v.a() { // from class: com.kwad.components.core.webview.tachikoma.i.32
            @Override // com.kwad.components.core.webview.tachikoma.b.v.a
            public final void b(com.kwad.components.core.webview.tachikoma.c.n nVar) {
                i.this.afj.a(nVar);
            }
        });
        a(tVar, vVar);
        a(tVar, new com.kwad.components.core.webview.tachikoma.b.r() { // from class: com.kwad.components.core.webview.tachikoma.i.33
            @Override // com.kwad.components.core.webview.tachikoma.b.r
            public final void a(com.kwad.components.core.webview.tachikoma.c.s sVar2) {
                super.a(sVar2);
                Activity activityUV = i.this.uV();
                if (activityUV == null) {
                    com.kwad.sdk.core.c.b.Ho();
                    activityUV = com.kwad.sdk.core.c.b.getCurrentActivity();
                }
                if (activityUV == null || activityUV.isFinishing()) {
                    return;
                }
                if (i.this.afi != null) {
                    i.this.afi.dismiss();
                }
                e.b bVar = new e.b();
                bVar.a(i.this.mAdResultData);
                bVar.bg(sVar2.templateId);
                i.this.afi = com.kwad.components.core.webview.tachikoma.d.e.b(bVar);
                i.this.afi.show(activityUV.getFragmentManager(), "");
            }
        });
        a(tVar, new com.kwad.components.core.webview.tachikoma.b.c() { // from class: com.kwad.components.core.webview.tachikoma.i.35
            @Override // com.kwad.components.core.webview.tachikoma.b.c
            public final void kh() {
                super.kh();
                if (i.this.afi != null) {
                    i.this.afi.dismiss();
                }
                if (i.this.afj != null) {
                    i.this.afj.aA();
                }
            }
        });
        a(tVar, new aa(new com.kwad.sdk.core.webview.d.a.b() { // from class: com.kwad.components.core.webview.tachikoma.i.36
            @Override // com.kwad.sdk.core.webview.d.a.b
            public final void b(WebCloseStatus webCloseStatus) {
                i.this.afj.a(webCloseStatus);
            }
        }));
        a(tVar, new com.kwad.components.core.webview.tachikoma.b.d() { // from class: com.kwad.components.core.webview.tachikoma.i.37
            @Override // com.kwad.components.core.webview.tachikoma.b.d
            public final void a(com.kwad.components.core.webview.tachikoma.c.g gVar) {
                AdTemplate adTemplateA = gVar.acb >= 0 ? com.kwad.sdk.core.response.b.c.a(com.kwad.components.core.o.a.e.a.a.aI(gVar.acb), gVar.NN) : null;
                if (adTemplateA == null) {
                    adTemplateA = i.this.vj();
                }
                com.kwad.components.core.p.a.se().a(gVar.actionType, adTemplateA, gVar.Pj);
            }
        });
        a(tVar, new com.kwad.components.core.webview.tachikoma.b.j() { // from class: com.kwad.components.core.webview.tachikoma.i.38
            @Override // com.kwad.components.core.webview.tachikoma.b.j
            public final void a(com.kwad.components.core.webview.tachikoma.c.o oVar) {
                super.a(oVar);
                AdWebViewActivityProxy.launch(i.this.mContext, new AdWebViewActivityProxy.a.C0344a().az(oVar.title).aA(oVar.url).aH(!oVar.ahh).q(i.this.mAdResultData).qW());
            }
        });
        a(tVar, new com.kwad.components.core.webview.tachikoma.b.a(vj()));
        a(tVar, new com.kwad.components.core.webview.tachikoma.a(vj()));
        a(this.afI, cVar, tVar, this.afj.getTKContainer());
        a(tVar, new com.kwad.components.core.webview.jshandler.a.f(this.mContext));
        a(tVar, new com.kwad.components.core.webview.jshandler.a.d(this.mContext));
        a(tVar, new com.kwad.components.core.webview.jshandler.a.a());
        a(tVar, new com.kwad.components.core.webview.jshandler.a.e(this.mContext));
        aw awVar = new aw();
        this.abN = awVar;
        a(tVar, awVar);
    }

    private static void a(com.kwad.sdk.components.t tVar, com.kwad.sdk.core.webview.c.a aVar) {
        tVar.c(aVar);
    }

    protected am c(com.kwad.sdk.core.webview.b bVar) {
        return new am(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(al.a aVar) {
        FrameLayout tKContainer = this.afj.getTKContainer();
        if (tKContainer != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) tKContainer.getLayoutParams();
            layoutParams.height = com.kwad.sdk.c.a.a.a(this.mContext, aVar.height);
            layoutParams.leftMargin = com.kwad.sdk.c.a.a.a(this.mContext, aVar.leftMargin);
            layoutParams.rightMargin = com.kwad.sdk.c.a.a.a(this.mContext, aVar.rightMargin);
            layoutParams.bottomMargin = com.kwad.sdk.c.a.a.a(this.mContext, aVar.bottomMargin);
            layoutParams.width = -1;
            tKContainer.setLayoutParams(layoutParams);
        }
    }

    private int vk() {
        return com.kwad.sdk.core.config.e.ci(new StringBuffer().append(this.afj.getTkTemplateId()).append("#").append(vh() != null ? vh().templateVersionCode : 0).toString());
    }

    private void vl() {
        StyleTemplate styleTemplateVh = vh();
        if (styleTemplateVh == null) {
            return;
        }
        this.afy = styleTemplateVh.tkSouce;
        TkLoggerReporter.get().reportTKPerform(ILoggerReporter.Category.APM_LOG, new TKPerformMsg(this.afy).setRenderState(-1).setTemplateId(this.afj.getTkTemplateId()).setVersionCode(String.valueOf(styleTemplateVh.templateVersionCode)).setTKPublishType(vk()).setRenderType(vo()).setRenderIdleTime(vp()).toJson());
    }

    private void bd(String str) {
        f(this.afj.getTkTemplateId(), str);
        StyleTemplate styleTemplateVh = vh();
        if (styleTemplateVh == null) {
            return;
        }
        TkLoggerReporter.get().reportTKPerform(ILoggerReporter.Category.ERROR_LOG, new TKPerformMsg(this.afy).setRenderState(4).setErrorReason(str).setTemplateId(this.afj.getTkTemplateId()).setVersionCode(String.valueOf(styleTemplateVh.templateVersionCode)).setTKPublishType(vk()).setRenderType(vo()).setRenderIdleTime(vp()).toJson());
    }

    private void vm() {
        if (this.afv) {
            return;
        }
        this.afv = true;
        TkLoggerReporter.get().reportTKPerform(ILoggerReporter.Category.APM_LOG, new TKPerformMsg(this.afy).setRenderState(0).setTemplateId(this.afj.getTkTemplateId()).setVersionCode(String.valueOf(this.Yf.templateVersionCode)).setTKPublishType(vk()).setRenderType(vo()).setRenderIdleTime(vp()).toJson());
    }

    private void vn() {
        StringBuilder sbAppend = new StringBuilder("logTkRenderSuccess, templateId = ").append(this.afj.getTkTemplateId()).append(":");
        StyleTemplate styleTemplate = this.Yf;
        com.kwad.sdk.core.d.c.d("TKLoadController", sbAppend.append(styleTemplate != null ? styleTemplate.templateVersionCode : 0).toString());
        if (!this.afv || this.afw) {
            return;
        }
        this.afw = true;
        long jElapsedRealtime = this.afz > 0 ? SystemClock.elapsedRealtime() - this.afz : 0L;
        com.kwad.sdk.core.d.c.d("TKLoadController", "render time, templateId = " + this.afj.getTkTemplateId() + " init:" + this.YY + " load:" + (this.YZ - this.II) + " render:" + jElapsedRealtime);
        if (this.afH) {
            this.afP = SystemClock.elapsedRealtime() - this.afO;
        }
        TkLoggerReporter.get().reportTKPerform(ILoggerReporter.Category.APM_LOG, new TKPerformMsg(this.afy).setRenderState(1).setRenderTime(jElapsedRealtime).setTemplateId(this.afj.getTkTemplateId()).setLoadTime(this.YZ - this.II).setInitTime(this.YY).setRegisterEndTime(this.afN).setGetViewEndTime(this.afP).setTemplateId(this.afj.getTkTemplateId()).setVersionCode(String.valueOf(this.Yf.templateVersionCode)).setTKPublishType(vk()).setRenderType(vo()).setRenderIdleTime(vp()).toJson());
    }

    private int vo() {
        return this.afH ? 1 : 0;
    }

    private long vp() {
        if (vo() == 1) {
            return com.kwad.sdk.core.config.e.Gn().longValue();
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void be(String str) {
        com.kwad.sdk.core.d.c.d("TKLoadController", "logTkRenderFail : " + str + ", templateId = " + this.afj.getTkTemplateId());
        g(this.afj.getTkTemplateId(), str);
        if (!this.afv || this.afw) {
            return;
        }
        this.afw = true;
        TkLoggerReporter.get().reportTKPerform(ILoggerReporter.Category.ERROR_LOG, new TKPerformMsg(this.afy).setRenderState(2).setErrorReason(str).setTemplateId(this.afj.getTkTemplateId()).setVersionCode(String.valueOf(this.Yf.templateVersionCode)).setTKPublishType(vk()).setRenderType(vo()).setRenderIdleTime(vp()).toJson());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vq() {
        com.kwad.sdk.core.d.c.d("TKLoadController", "logTkRenderFail : timeout, templateId = " + this.afj.getTkTemplateId());
        StyleTemplate styleTemplateVh = vh();
        if (styleTemplateVh == null) {
            return;
        }
        TkLoggerReporter.get().reportTKPerform(ILoggerReporter.Category.ERROR_LOG, new TKPerformMsg(this.afy).setRenderState(3).setErrorReason("timeout").setTemplateId(this.afj.getTkTemplateId()).setVersionCode(String.valueOf(styleTemplateVh.templateVersionCode)).setTKPublishType(vk()).setRenderType(vo()).setRenderIdleTime(vp()).toJson());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(Throwable th) {
        com.kwad.sdk.core.d.c.d("TKLoadController", "logTkRenderFail : " + th + ", templateId = " + this.afj.getTkTemplateId());
        g(this.afj.getTkTemplateId(), "error:" + th.toString());
        TkLoggerReporter.get().reportTKPerform(ILoggerReporter.Category.ERROR_LOG, new TKPerformMsg(this.afy).setRenderState(3).setErrorReason(th.toString()).setTemplateId(this.afj.getTkTemplateId()).setVersionCode(String.valueOf(this.Yf.templateVersionCode)).setTKPublishType(vk()).setRenderType(vo()).setRenderIdleTime(vp()).toJson());
    }

    @Override // com.kwad.sdk.components.q
    public final void callJS(String str) {
        com.kwad.sdk.components.t tVar = this.afn;
        if (tVar != null) {
            tVar.a(str, null, null);
        }
    }

    private Map<String, Object> vr() {
        if (this.afA == null) {
            HashMap map = new HashMap();
            this.afA = map;
            map.put("TKVersion", "6.1.7");
            this.afA.put("SDKVersion", BuildConfig.VERSION_NAME);
            this.afA.put("sdkType", 1);
        }
        return this.afA;
    }

    public final void a(String str, Object obj) {
        vr().put(str, obj);
    }

    @Override // com.kwad.sdk.core.webview.d.a.a
    public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
        j jVar = this.afj;
        if (jVar != null) {
            jVar.a(aVar);
        }
    }

    @Override // com.kwad.sdk.core.view.b
    public final void i(View view, boolean z) {
        ay ayVar;
        FrameLayout tKContainer = this.afj.getTKContainer();
        if (tKContainer == null || !tKContainer.equals(view) || (ayVar = this.afp) == null) {
            return;
        }
        ayVar.aX(z);
    }

    @Override // com.kwad.components.core.e.e.f
    public void show() {
        az azVar = this.eS;
        if (azVar != null) {
            azVar.uK();
        }
    }

    @Override // com.kwad.components.core.e.e.f
    public void dismiss() {
        az azVar = this.eS;
        if (azVar != null) {
            azVar.uJ();
        }
    }

    public void kz() {
        if (this.afh != null) {
            this.afh = null;
        }
        com.kwad.sdk.core.view.d dVar = this.afr;
        if (dVar != null) {
            dVar.getWindowFocusChangeHelper().b(this);
            this.afr = null;
        }
        Future<?> future = this.afm;
        if (future != null) {
            future.cancel(true);
        }
        bw.c(this.afV);
        bw.c(this.afW);
        com.kwad.components.core.e.e.g.pY().b(this);
        if (this.abO != null) {
            com.kwad.sdk.core.download.b.GR().a(this.abO);
        }
        com.kwad.components.core.webview.tachikoma.d.e eVar = this.afi;
        if (eVar != null) {
            eVar.dismiss();
        }
        if (com.kwad.components.core.a.oz.booleanValue()) {
            vs();
        }
        com.kwad.components.core.o.a.e.c cVar = this.afl;
        if (cVar != null) {
            cVar.onDestroy();
        }
        final com.kwad.sdk.components.t tVar = this.afn;
        if (tVar != null) {
            this.afn = null;
            if (this.afH) {
                com.kwad.components.core.t.i.c(Integer.valueOf(this.afK));
            } else {
                bw.postOnUiThread(new Runnable() { // from class: com.kwad.components.core.webview.tachikoma.i.40
                    @Override // java.lang.Runnable
                    public final void run() {
                        com.kwad.sdk.components.t tVar2 = tVar;
                        if (tVar2 != null) {
                            tVar2.onDestroy();
                        }
                    }
                });
            }
        }
    }

    private void vs() {
        if (this.afl == null || this.afn == null) {
            return;
        }
        File file = new File(new File(this.afl.getJsBaseDir(this.mContext, this.afj.getTkTemplateId())), "kcov.json");
        if (file.exists()) {
            try {
                String strW = w.W(file);
                if (TextUtils.isEmpty(strW)) {
                    return;
                }
                com.kwad.sdk.core.d.c.d("TKLoadController", "kcov.json:" + strW);
                JSONObject jSONObject = new JSONObject(strW);
                final String string = jSONObject.getString("gitHeadCommit");
                final String string2 = jSONObject.getString("coverageApi");
                final String string3 = jSONObject.getString("coverageTaskId");
                final String string4 = jSONObject.getString("currentBranch");
                if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2) && !TextUtils.isEmpty(string3) && !TextUtils.isEmpty(string4)) {
                    com.kwad.sdk.core.d.c.d("TKLoadController", new StringBuilder("尝试获取覆盖率统计... ").append(this.Yf).toString() != null ? this.Yf.templateId : "");
                    Object objExecute = this.afn.execute("JSON.stringify(this.__coverage__)");
                    if (objExecute instanceof String) {
                        final String str = (String) objExecute;
                        com.kwad.sdk.utils.h.execute(new Runnable() { // from class: com.kwad.components.core.webview.tachikoma.i.41
                            @Override // java.lang.Runnable
                            public final void run() {
                                JSONObject jSONObject2 = new JSONObject();
                                try {
                                    jSONObject2.put("coverage_task_id", Integer.valueOf(string3));
                                    jSONObject2.put(com.umeng.analytics.pro.z.m, "");
                                    jSONObject2.put(UMCrash.SP_KEY_TIMESTAMP, System.currentTimeMillis() / 1000);
                                    jSONObject2.put("branch_name", string4);
                                    jSONObject2.put("version", BuildConfig.VERSION_NAME);
                                    jSONObject2.put("tk_version", String.valueOf(i.this.Yf.templateVersionCode));
                                    jSONObject2.put("tk_template_ids", i.this.Yf.templateId);
                                } catch (JSONException e) {
                                    com.kwad.sdk.core.d.c.printStackTrace(e);
                                }
                                com.kwad.sdk.core.network.c cVarDoPost = com.kwad.sdk.g.AI().doPost(string2 + "/analysis/add/pkg/info", (Map<String, String>) null, jSONObject2);
                                if (cVarDoPost.Hx()) {
                                    com.kwad.sdk.core.d.c.d("TKLoadController", "上传TK覆盖率pkg完成:" + cVarDoPost.aEk);
                                } else {
                                    com.kwad.sdk.core.d.c.d("TKLoadController", "上传覆盖率pkg失败");
                                }
                                com.kwad.sdk.core.network.c cVarDoPost2 = com.kwad.sdk.g.AI().doPost(string2 + "/attachment/ec", (Map<String, String>) null, new AdHttpBodyBuilder() { // from class: com.kwad.components.core.webview.tachikoma.i.41.1
                                    @Override // com.kwad.sdk.export.proxy.AdHttpBodyBuilder
                                    public final void buildFormData(AdHttpFormDataBuilder adHttpFormDataBuilder) {
                                        adHttpFormDataBuilder.addFormDataPart("task_id", string3);
                                        adHttpFormDataBuilder.addFormDataPart("os_build_model", Build.MODEL);
                                        adHttpFormDataBuilder.addFormDataPart("os_build_serial", "unknown");
                                        adHttpFormDataBuilder.addFormDataPart("os_build_brand", Build.BRAND);
                                        adHttpFormDataBuilder.addFormDataPart("app_version", BuildConfig.VERSION_NAME);
                                        adHttpFormDataBuilder.addFormDataPart("git_head_commit", string);
                                        adHttpFormDataBuilder.addFormDataPart("execute_type", "manual_qa");
                                        adHttpFormDataBuilder.addFormDataPart("uid", "");
                                        adHttpFormDataBuilder.addFormDataPart("did", com.kwad.sdk.utils.bd.getDeviceId());
                                        adHttpFormDataBuilder.addFormDataPart("execute_user", "");
                                        adHttpFormDataBuilder.addFormDataPart("url_type", "transform");
                                        try {
                                            adHttpFormDataBuilder.addFormDataPart(FileUtils.URI_TYPE_FILE, UUID.randomUUID().toString() + ".json", "application/octet-stream", str.getBytes("UTF-8"));
                                        } catch (UnsupportedEncodingException e2) {
                                            com.kwad.sdk.core.d.c.printStackTrace(e2);
                                        }
                                    }
                                });
                                if (cVarDoPost2.Hx()) {
                                    com.kwad.sdk.core.d.c.d("TKLoadController", "上传TK覆盖率完成:" + cVarDoPost2.aEk);
                                } else {
                                    com.kwad.sdk.core.d.c.d("TKLoadController", "上传TK覆盖率失败");
                                }
                            }
                        });
                        return;
                    }
                    return;
                }
                com.kwad.sdk.core.d.c.d("TKLoadController", "kcov.json数据不合法，缺少关键字段gitHeadCommit | coverageApi | coverageTaskId | currentBranch");
            } catch (Throwable th) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(th);
            }
        }
    }

    public final String getTkTemplateId() {
        j jVar = this.afj;
        if (jVar == null) {
            return null;
        }
        return jVar.getTkTemplateId();
    }

    public final o vt() {
        return this.afJ;
    }

    public final void vu() {
        if (this.afu) {
            b(TKRenderFailReason.TK_FILE_LOAD_TIMEOUT);
            return;
        }
        bw.c(this.afW);
        vn();
        if (this.afj != null) {
            bw.runOnUiThread(new Runnable() { // from class: com.kwad.components.core.webview.tachikoma.i.42
                @Override // java.lang.Runnable
                public final void run() {
                    i.this.afj.az();
                }
            });
            com.kwad.components.core.webview.tachikoma.e.c.vO().c(this.afj.getTkTemplateId(), this.YZ - this.II, this.YY, this.afz > 0 ? SystemClock.elapsedRealtime() - this.afz : 0L);
        }
    }
}
