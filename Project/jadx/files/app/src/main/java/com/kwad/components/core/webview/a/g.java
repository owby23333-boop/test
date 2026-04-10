package com.kwad.components.core.webview.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.msdk.adapter.pangle.PangleAdapterUtils;
import com.bytedance.msdk.api.AdError;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.webview.a.a.q;
import com.kwad.components.core.webview.a.a.r;
import com.kwad.components.core.webview.a.a.x;
import com.kwad.components.core.webview.a.b.d;
import com.kwad.components.core.webview.a.kwai.o;
import com.kwad.components.core.webview.a.kwai.p;
import com.kwad.components.core.webview.a.kwai.s;
import com.kwad.components.core.webview.a.kwai.t;
import com.kwad.components.core.webview.a.kwai.u;
import com.kwad.components.core.webview.jshandler.ae;
import com.kwad.components.core.webview.jshandler.l;
import com.kwad.components.core.webview.jshandler.m;
import com.kwad.components.core.webview.jshandler.s;
import com.kwad.components.core.webview.jshandler.z;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.components.offline.api.tk.ITkOfflineCompo;
import com.kwad.components.offline.api.tk.TKDownloadListener;
import com.kwad.components.offline.api.tk.TkLoggerReporter;
import com.kwad.components.offline.api.tk.model.StyleTemplate;
import com.kwad.components.offline.api.tk.model.report.TKPerformMsg;
import com.kwad.sdk.api.proxy.app.FeedDownloadActivity;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.j;
import com.kwad.sdk.components.k;
import com.kwad.sdk.components.l;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ah;
import com.kwad.sdk.utils.bh;
import com.kwad.sdk.utils.u;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class g implements com.kwad.sdk.components.i, com.kwad.sdk.core.webview.c.kwai.a {
    private static final String TAG = "TKLoadController";
    private static final int TIME_OUT = 1000;
    private static Map<Integer, WeakReference<com.kwad.components.core.webview.a.b.d>> mDialogMap = new HashMap();
    private boolean hasDownloadTimeout;
    private boolean isHasCallJsFailed;
    private boolean isTkTemplateRenderComplete;
    private boolean isTkTemplateRenderStart;
    protected com.kwad.sdk.core.webview.b jsBridgeContext;

    @Nullable
    private Activity mActivity;
    private AdTemplate mAdTemplate;
    protected final Context mContext;
    private Map<String, Object> mCustomEnv;
    private com.kwad.sdk.core.download.e mDownloadSyncInterfaceAdapter;
    private final Runnable mDownloadTimeoutRunnable;
    private j mHostActionHandler;
    private long mInitTime;
    private p mJSVideoProgress;
    private long mLoadEndTime;
    private long mLoadStartTime;
    private Future<?> mLoadTkFuture;
    protected long mPlayedDuration;
    private long mRenderStartTime;
    private StyleTemplate mStyleTemplate;
    private com.kwad.sdk.core.webview.b.g mTKBridgeHandler;
    protected h mTKLoadInterface;
    private com.kwad.components.core.offline.api.a.c mTKPlugin;
    private a mTKRenderListenerInner;
    private l mTKView;
    private com.kwad.components.core.webview.a.b.d mTkDialogFragment;
    private final com.kwad.components.core.video.j mVideoPlayStateListener;
    private final x mVideoProgress;
    private int tkLoadTimeOut;
    private int tkSource;

    interface a {
        void onFailed();

        void onSuccess();
    }

    public g(long j2, Context context) {
        this.hasDownloadTimeout = false;
        this.isTkTemplateRenderStart = false;
        this.isTkTemplateRenderComplete = false;
        this.isHasCallJsFailed = false;
        this.tkSource = 0;
        this.mPlayedDuration = -1L;
        this.tkLoadTimeOut = 1000;
        this.jsBridgeContext = new com.kwad.sdk.core.webview.b();
        this.mTKRenderListenerInner = new a() { // from class: com.kwad.components.core.webview.a.g.16
            @Override // com.kwad.components.core.webview.a.g.a
            public final void onFailed() {
                g.this.callbackTkLoadFailed();
                com.kwad.sdk.core.d.b.d(g.TAG, AdError.ERROR_MEDIA_RENDER_MSG);
            }

            @Override // com.kwad.components.core.webview.a.g.a
            public final void onSuccess() {
                com.kwad.sdk.core.d.b.d(g.TAG, "渲染成功");
            }
        };
        this.mHostActionHandler = new j() { // from class: com.kwad.components.core.webview.a.g.18
            @Override // com.kwad.sdk.components.j
            public final void a(com.kwad.sdk.components.g gVar) {
                Activity currentActivity = g.this.mActivity;
                if (currentActivity == null) {
                    com.kwad.sdk.core.b.b.we();
                    currentActivity = com.kwad.sdk.core.b.b.getCurrentActivity();
                }
                if (currentActivity == null || currentActivity.isFinishing()) {
                    gVar.callbackPageStatus(false, "no host activity");
                    return;
                }
                StyleTemplate styleTemplate = new StyleTemplate();
                try {
                    styleTemplate.parseJson(styleTemplate, new JSONObject(gVar.getStyleTemplate()));
                    d.b bVar = new d.b();
                    bVar.setAdTemplate(g.this.obtainAdTemplate());
                    bVar.setStyleTemplate(styleTemplate);
                    bVar.aH(styleTemplate.templateId);
                    bVar.c(gVar);
                    com.kwad.components.core.webview.a.b.d dVarB = com.kwad.components.core.webview.a.b.d.b(bVar);
                    dVarB.show(currentActivity.getFragmentManager(), "");
                    g.mDialogMap.put(Integer.valueOf(gVar.getDialogId()), new WeakReference(dVarB));
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.b.printStackTrace(th);
                    gVar.callbackPageStatus(false, "template parse failed");
                }
            }

            @Override // com.kwad.sdk.components.j
            public final void a(com.kwad.sdk.components.h hVar) {
                String message;
                if (hVar.getTemplateString() == null && hVar.getUrl() == null && hVar.getClassName() == null) {
                    message = "intent invalid";
                } else {
                    Activity currentActivity = g.this.mActivity;
                    if (currentActivity == null) {
                        com.kwad.sdk.core.b.b.we();
                        currentActivity = com.kwad.sdk.core.b.b.getCurrentActivity();
                    }
                    if (currentActivity == null) {
                        hVar.callbackPageStatus(false, "no host activity");
                    }
                    Intent intent = hVar.getIntent();
                    try {
                        if (hVar.getTemplateString() != null) {
                            com.kwad.sdk.service.a.a(FeedDownloadActivity.class, com.kwad.components.core.q.kwai.a.class);
                            int iPT = com.kwad.components.core.q.kwai.a.pT();
                            com.kwad.components.core.q.kwai.a.a(iPT, "native_intent", hVar);
                            AdTemplate adTemplateObtainAdTemplate = g.this.obtainAdTemplate();
                            if (adTemplateObtainAdTemplate != null) {
                                intent.putExtra("tk_ad_template", adTemplateObtainAdTemplate.toJson().toString());
                            }
                            intent.putExtra("tk_style_template", hVar.getTemplateString());
                            intent.putExtra("tk_id", iPT);
                        } else if (hVar.getClassName() == null) {
                            intent.setData(Uri.parse(hVar.getUrl()));
                            currentActivity.startActivity(intent);
                            hVar.callbackPageStatus(true, null);
                            return;
                        } else {
                            try {
                                com.kwad.sdk.service.a.a(FeedDownloadActivity.class, Class.forName(hVar.getClassName()));
                            } catch (ClassNotFoundException e2) {
                                message = e2.getMessage();
                            }
                        }
                        currentActivity.startActivity(intent);
                        hVar.callbackPageStatus(true, null);
                        return;
                    } catch (Throwable th) {
                        message = th.getMessage();
                    }
                    intent.setClass(g.this.mContext, FeedDownloadActivity.class);
                }
                hVar.callbackPageStatus(false, message);
            }

            @Override // com.kwad.sdk.components.j
            public final void b(com.kwad.sdk.components.g gVar) {
                WeakReference weakReference = (WeakReference) g.mDialogMap.get(Integer.valueOf(gVar.getDialogId()));
                if (weakReference.get() != null) {
                    ((com.kwad.components.core.webview.a.b.d) weakReference.get()).dismiss();
                }
            }
        };
        this.mDownloadTimeoutRunnable = new Runnable() { // from class: com.kwad.components.core.webview.a.g.19
            @Override // java.lang.Runnable
            public final void run() {
                com.kwad.sdk.core.d.b.d(g.TAG, "已经超时" + g.this.mTKLoadInterface.getTkTemplateId());
                g.this.logTkDownloadTimeout();
                g.this.hasDownloadTimeout = true;
                g.this.callbackTkLoadFailed();
            }
        };
        this.mVideoPlayStateListener = new com.kwad.components.core.video.j() { // from class: com.kwad.components.core.webview.a.g.14
            private void g(double d2) {
                g.this.mVideoProgress.Vh = false;
                g.this.mVideoProgress.Vd = false;
                g.this.mVideoProgress.nW = (int) ((d2 / 1000.0d) + 0.5d);
                jj();
            }

            private void jj() {
                if (g.this.mJSVideoProgress == null || g.this.mVideoProgress == null) {
                    return;
                }
                g.this.mJSVideoProgress.a(g.this.mVideoProgress);
            }

            @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
            public final void onVideoPlayCompleted() {
                g.this.mVideoProgress.Vd = true;
                g.this.mVideoProgress.Vh = false;
                g.this.mVideoProgress.nW = com.kwad.sdk.core.response.a.a.F(com.kwad.sdk.core.response.a.d.cb(g.this.obtainAdTemplate()));
                jj();
            }

            @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
            public final void onVideoPlayError(int i2, int i3) {
                g.this.mVideoProgress.Vh = true;
                g.this.mVideoProgress.Vd = false;
                jj();
            }

            @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
            public final void onVideoPlayProgress(long j3, long j4) {
                g(j4);
            }

            @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
            public final void onVideoPlayStart() {
                g(PangleAdapterUtils.CPM_DEFLAUT_VALUE);
            }

            @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
            public final void onVideoPreparing() {
                g(PangleAdapterUtils.CPM_DEFLAUT_VALUE);
            }
        };
        this.mContext = context;
        this.mPlayedDuration = j2;
        this.mVideoProgress = new x();
    }

    public g(Context context, int i2) {
        this.hasDownloadTimeout = false;
        this.isTkTemplateRenderStart = false;
        this.isTkTemplateRenderComplete = false;
        this.isHasCallJsFailed = false;
        this.tkSource = 0;
        this.mPlayedDuration = -1L;
        this.tkLoadTimeOut = 1000;
        this.jsBridgeContext = new com.kwad.sdk.core.webview.b();
        this.mTKRenderListenerInner = new a() { // from class: com.kwad.components.core.webview.a.g.16
            @Override // com.kwad.components.core.webview.a.g.a
            public final void onFailed() {
                g.this.callbackTkLoadFailed();
                com.kwad.sdk.core.d.b.d(g.TAG, AdError.ERROR_MEDIA_RENDER_MSG);
            }

            @Override // com.kwad.components.core.webview.a.g.a
            public final void onSuccess() {
                com.kwad.sdk.core.d.b.d(g.TAG, "渲染成功");
            }
        };
        this.mHostActionHandler = new j() { // from class: com.kwad.components.core.webview.a.g.18
            @Override // com.kwad.sdk.components.j
            public final void a(com.kwad.sdk.components.g gVar) {
                Activity currentActivity = g.this.mActivity;
                if (currentActivity == null) {
                    com.kwad.sdk.core.b.b.we();
                    currentActivity = com.kwad.sdk.core.b.b.getCurrentActivity();
                }
                if (currentActivity == null || currentActivity.isFinishing()) {
                    gVar.callbackPageStatus(false, "no host activity");
                    return;
                }
                StyleTemplate styleTemplate = new StyleTemplate();
                try {
                    styleTemplate.parseJson(styleTemplate, new JSONObject(gVar.getStyleTemplate()));
                    d.b bVar = new d.b();
                    bVar.setAdTemplate(g.this.obtainAdTemplate());
                    bVar.setStyleTemplate(styleTemplate);
                    bVar.aH(styleTemplate.templateId);
                    bVar.c(gVar);
                    com.kwad.components.core.webview.a.b.d dVarB = com.kwad.components.core.webview.a.b.d.b(bVar);
                    dVarB.show(currentActivity.getFragmentManager(), "");
                    g.mDialogMap.put(Integer.valueOf(gVar.getDialogId()), new WeakReference(dVarB));
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.b.printStackTrace(th);
                    gVar.callbackPageStatus(false, "template parse failed");
                }
            }

            @Override // com.kwad.sdk.components.j
            public final void a(com.kwad.sdk.components.h hVar) {
                String message;
                if (hVar.getTemplateString() == null && hVar.getUrl() == null && hVar.getClassName() == null) {
                    message = "intent invalid";
                } else {
                    Activity currentActivity = g.this.mActivity;
                    if (currentActivity == null) {
                        com.kwad.sdk.core.b.b.we();
                        currentActivity = com.kwad.sdk.core.b.b.getCurrentActivity();
                    }
                    if (currentActivity == null) {
                        hVar.callbackPageStatus(false, "no host activity");
                    }
                    Intent intent = hVar.getIntent();
                    try {
                        if (hVar.getTemplateString() != null) {
                            com.kwad.sdk.service.a.a(FeedDownloadActivity.class, com.kwad.components.core.q.kwai.a.class);
                            int iPT = com.kwad.components.core.q.kwai.a.pT();
                            com.kwad.components.core.q.kwai.a.a(iPT, "native_intent", hVar);
                            AdTemplate adTemplateObtainAdTemplate = g.this.obtainAdTemplate();
                            if (adTemplateObtainAdTemplate != null) {
                                intent.putExtra("tk_ad_template", adTemplateObtainAdTemplate.toJson().toString());
                            }
                            intent.putExtra("tk_style_template", hVar.getTemplateString());
                            intent.putExtra("tk_id", iPT);
                        } else if (hVar.getClassName() == null) {
                            intent.setData(Uri.parse(hVar.getUrl()));
                            currentActivity.startActivity(intent);
                            hVar.callbackPageStatus(true, null);
                            return;
                        } else {
                            try {
                                com.kwad.sdk.service.a.a(FeedDownloadActivity.class, Class.forName(hVar.getClassName()));
                            } catch (ClassNotFoundException e2) {
                                message = e2.getMessage();
                            }
                        }
                        currentActivity.startActivity(intent);
                        hVar.callbackPageStatus(true, null);
                        return;
                    } catch (Throwable th) {
                        message = th.getMessage();
                    }
                    intent.setClass(g.this.mContext, FeedDownloadActivity.class);
                }
                hVar.callbackPageStatus(false, message);
            }

            @Override // com.kwad.sdk.components.j
            public final void b(com.kwad.sdk.components.g gVar) {
                WeakReference weakReference = (WeakReference) g.mDialogMap.get(Integer.valueOf(gVar.getDialogId()));
                if (weakReference.get() != null) {
                    ((com.kwad.components.core.webview.a.b.d) weakReference.get()).dismiss();
                }
            }
        };
        this.mDownloadTimeoutRunnable = new Runnable() { // from class: com.kwad.components.core.webview.a.g.19
            @Override // java.lang.Runnable
            public final void run() {
                com.kwad.sdk.core.d.b.d(g.TAG, "已经超时" + g.this.mTKLoadInterface.getTkTemplateId());
                g.this.logTkDownloadTimeout();
                g.this.hasDownloadTimeout = true;
                g.this.callbackTkLoadFailed();
            }
        };
        this.mVideoPlayStateListener = new com.kwad.components.core.video.j() { // from class: com.kwad.components.core.webview.a.g.14
            private void g(double d2) {
                g.this.mVideoProgress.Vh = false;
                g.this.mVideoProgress.Vd = false;
                g.this.mVideoProgress.nW = (int) ((d2 / 1000.0d) + 0.5d);
                jj();
            }

            private void jj() {
                if (g.this.mJSVideoProgress == null || g.this.mVideoProgress == null) {
                    return;
                }
                g.this.mJSVideoProgress.a(g.this.mVideoProgress);
            }

            @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
            public final void onVideoPlayCompleted() {
                g.this.mVideoProgress.Vd = true;
                g.this.mVideoProgress.Vh = false;
                g.this.mVideoProgress.nW = com.kwad.sdk.core.response.a.a.F(com.kwad.sdk.core.response.a.d.cb(g.this.obtainAdTemplate()));
                jj();
            }

            @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
            public final void onVideoPlayError(int i22, int i3) {
                g.this.mVideoProgress.Vh = true;
                g.this.mVideoProgress.Vd = false;
                jj();
            }

            @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
            public final void onVideoPlayProgress(long j3, long j4) {
                g(j4);
            }

            @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
            public final void onVideoPlayStart() {
                g(PangleAdapterUtils.CPM_DEFLAUT_VALUE);
            }

            @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
            public final void onVideoPreparing() {
                g(PangleAdapterUtils.CPM_DEFLAUT_VALUE);
            }
        };
        this.mContext = context;
        this.tkLoadTimeOut = i2;
        this.mVideoProgress = new x();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addTKView(StyleTemplate styleTemplate, final a aVar) {
        this.mStyleTemplate = styleTemplate;
        com.kwad.sdk.core.d.b.w(TAG, "addTKView mTKPlugin.getState(): " + this.mTKPlugin.getState());
        if (this.mTKPlugin.getState() == ITkOfflineCompo.TKState.SO_FAIL) {
            logTKEnvNotReady(TKPerformMsg.ERROR_REASON.KSAD_TK_SO_FAIL);
            if (aVar != null) {
                aVar.onFailed();
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(styleTemplate.jsStr)) {
            logTkRenderFail(TKPerformMsg.ERROR_REASON.KSAD_TK_NO_TEMPLATE);
            if (aVar != null) {
                aVar.onFailed();
                return;
            }
            return;
        }
        try {
            logTkRenderStart();
            this.mLoadEndTime = SystemClock.elapsedRealtime();
            l view = this.mTKPlugin.getView(this.mContext, styleTemplate.templateId, styleTemplate.templateVersionCode, styleTemplate.tkSouce);
            com.kwad.components.core.offline.api.a.kwai.a.a(view.getUniqId(), this.mAdTemplate);
            view.a(this.mHostActionHandler);
            if (this.mAdTemplate != null && this.mAdTemplate.mAdScene != null) {
                getCustomEnv().put("adStyle", Integer.valueOf(this.mAdTemplate.mAdScene.getAdStyle()));
            }
            view.setCustomEnv(getCustomEnv());
            this.mTKView = view;
            if (this.mTKBridgeHandler != null) {
                view.a(this.mTKBridgeHandler);
            }
            this.mInitTime = SystemClock.elapsedRealtime() - this.mLoadEndTime;
            this.mRenderStartTime = SystemClock.elapsedRealtime();
            initJsBridgeContext();
            registerWebCardHandler(view);
            File file = new File(this.mTKPlugin.getJsBaseDir(this.mContext, this.mTKLoadInterface.getTkTemplateId()));
            view.a(styleTemplate.jsStr, file.getAbsolutePath() + "/", new k() { // from class: com.kwad.components.core.webview.a.g.17
                @Override // com.kwad.sdk.components.k
                public final void onFailed(Throwable th) {
                    a aVar2 = aVar;
                    if (aVar2 != null) {
                        aVar2.onFailed();
                    }
                    g.this.logTkError(th);
                }

                @Override // com.kwad.sdk.components.k
                public final void onSuccess() {
                    a aVar2 = aVar;
                    if (aVar2 != null) {
                        aVar2.onSuccess();
                    }
                }
            });
            View view2 = view.getView();
            view2.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            this.mTKLoadInterface.getTKContainer().addView(view2);
        } catch (Throwable th) {
            logTkError(th);
            if (aVar != null) {
                aVar.onFailed();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callbackTkLoadFailed() {
        bh.postOnUiThread(new Runnable() { // from class: com.kwad.components.core.webview.a.g.20
            @Override // java.lang.Runnable
            public final void run() {
                if (g.this.isHasCallJsFailed) {
                    return;
                }
                g.this.isHasCallJsFailed = true;
                g.this.mTKLoadInterface.onTkLoadFailed();
                com.kwad.components.core.webview.a.c.a.rE().aJ(g.this.mTKLoadInterface.getTkTemplateId());
            }
        });
    }

    private void doRegisterHandler(l lVar, com.kwad.sdk.core.webview.b.a aVar) {
        lVar.c(aVar);
    }

    private Map<String, Object> getCustomEnv() {
        if (this.mCustomEnv == null) {
            this.mCustomEnv = new HashMap();
            this.mCustomEnv.put("TKVersion", "5.0.0");
            this.mCustomEnv.put("SDKVersion", "3.3.38");
            this.mCustomEnv.put("sdkType", 1);
        }
        return this.mCustomEnv;
    }

    private StyleTemplate getStyleTemplateFromAdInfo() {
        StyleTemplate styleTemplate = this.mStyleTemplate;
        if (styleTemplate != null) {
            return styleTemplate;
        }
        AdMatrixInfo.MatrixTemplate matrixTemplateC = com.kwad.sdk.core.response.a.b.c(obtainAdTemplate(), this.mTKLoadInterface.getTkTemplateId());
        if (matrixTemplateC == null) {
            return null;
        }
        com.kwad.components.core.offline.api.a.c cVar = this.mTKPlugin;
        if (cVar != null) {
            return cVar.checkStyleTemplateById(this.mContext, matrixTemplateC.templateId, matrixTemplateC.templateMd5, matrixTemplateC.templateUrl, (int) matrixTemplateC.templateVersionCode);
        }
        StyleTemplate styleTemplate2 = new StyleTemplate();
        styleTemplate2.templateId = matrixTemplateC.templateId;
        styleTemplate2.templateMd5 = matrixTemplateC.templateMd5;
        styleTemplate2.templateUrl = matrixTemplateC.templateUrl;
        styleTemplate2.templateVersionCode = (int) matrixTemplateC.templateVersionCode;
        styleTemplate2.tkSouce = 0;
        return styleTemplate2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleLoadStyleTemplateFailed(String str) {
        callbackTkLoadFailed();
        logTKEnvNotReady(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleLoadStyleTemplateSuccess(@Nullable final StyleTemplate styleTemplate) {
        com.kwad.sdk.utils.i.e("", "renderType_tk", styleTemplate.templateId, styleTemplate.templateUrl);
        com.kwad.sdk.core.d.b.d(TAG, "读取完毕，总耗时" + (SystemClock.elapsedRealtime() - this.mLoadStartTime) + ", 读取成功" + styleTemplate.templateId);
        if (this.hasDownloadTimeout) {
            return;
        }
        com.kwad.sdk.core.d.b.d(TAG, "没有超时");
        bh.b(this.mDownloadTimeoutRunnable);
        bh.runOnUiThread(new Runnable() { // from class: com.kwad.components.core.webview.a.g.15
            @Override // java.lang.Runnable
            public final void run() {
                g gVar = g.this;
                gVar.addTKView(styleTemplate, gVar.mTKRenderListenerInner);
            }
        });
    }

    private void initJsBridgeContext() {
        this.jsBridgeContext.mScreenOrientation = !ah.cu(this.mContext) ? 1 : 0;
        this.jsBridgeContext.aoM = this.mTKLoadInterface.getTouchCoordsView();
        this.jsBridgeContext.LI = this.mTKLoadInterface.getTKContainer();
        this.jsBridgeContext.Lk = null;
    }

    private void initParam() {
        this.isTkTemplateRenderStart = false;
        this.isTkTemplateRenderComplete = false;
        this.hasDownloadTimeout = false;
        this.isHasCallJsFailed = false;
        this.mLoadStartTime = 0L;
        this.mLoadEndTime = 0L;
        this.mInitTime = 0L;
        this.mRenderStartTime = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadStyleTemplateFromAdInfo(TKDownloadListener tKDownloadListener) {
        StyleTemplate styleTemplate = this.mStyleTemplate;
        if (styleTemplate != null) {
            this.mTKPlugin.loadTkFileByTemplateId(this.mContext, styleTemplate.templateId, styleTemplate.templateMd5, styleTemplate.templateUrl, styleTemplate.templateVersionCode, tKDownloadListener);
            return;
        }
        AdMatrixInfo.MatrixTemplate matrixTemplateC = com.kwad.sdk.core.response.a.b.c(obtainAdTemplate(), this.mTKLoadInterface.getTkTemplateId());
        if (matrixTemplateC == null) {
            return;
        }
        this.mTKPlugin.loadTkFileByTemplateId(this.mContext, matrixTemplateC.templateId, matrixTemplateC.templateMd5, matrixTemplateC.templateUrl, (int) matrixTemplateC.templateVersionCode, tKDownloadListener);
    }

    private void loadTkStyleTemplate() {
        bh.runOnUiThreadDelay(this.mDownloadTimeoutRunnable, this.tkLoadTimeOut);
        this.mLoadTkFuture = com.kwad.sdk.core.threads.b.yc().submit(new Runnable() { // from class: com.kwad.components.core.webview.a.g.12
            @Override // java.lang.Runnable
            public final void run() {
                g.this.mLoadStartTime = SystemClock.elapsedRealtime();
                com.kwad.sdk.core.d.b.d(g.TAG, "开始读取模板 id: " + g.this.mTKLoadInterface.getTkTemplateId());
                g.this.loadStyleTemplateFromAdInfo(new TKDownloadListener() { // from class: com.kwad.components.core.webview.a.g.12.1
                    @Override // com.kwad.components.offline.api.tk.TKDownloadListener
                    public final void onFailed(String str) {
                        g.this.handleLoadStyleTemplateFailed(str);
                    }

                    @Override // com.kwad.components.offline.api.tk.TKDownloadListener
                    public final void onSuccess(@NonNull StyleTemplate styleTemplate) {
                        g.this.handleLoadStyleTemplateSuccess(styleTemplate);
                    }
                });
            }
        });
    }

    private void logEnterTKScene() {
        StyleTemplate styleTemplateFromAdInfo = getStyleTemplateFromAdInfo();
        if (styleTemplateFromAdInfo == null) {
            return;
        }
        this.tkSource = styleTemplateFromAdInfo.tkSouce;
        TkLoggerReporter.get().reportTKPerform(ILoggerReporter.Category.APM_LOG, new TKPerformMsg(this.tkSource).setRenderState(-1).setTemplateId(this.mTKLoadInterface.getTkTemplateId()).setVersionCode(String.valueOf(styleTemplateFromAdInfo.templateVersionCode)).toJson());
    }

    private void logTKEnvNotReady(String str) {
        StyleTemplate styleTemplateFromAdInfo = getStyleTemplateFromAdInfo();
        if (styleTemplateFromAdInfo == null) {
            return;
        }
        TkLoggerReporter.get().reportTKPerform(ILoggerReporter.Category.ERROR_LOG, new TKPerformMsg(this.tkSource).setRenderState(4).setErrorReason(str).setTemplateId(this.mTKLoadInterface.getTkTemplateId()).setVersionCode(String.valueOf(styleTemplateFromAdInfo.templateVersionCode)).toJson());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void logTkDownloadTimeout() {
        com.kwad.sdk.core.d.b.d("tkRender", "logTkRenderFail : timeout, templateId = " + this.mTKLoadInterface.getTkTemplateId());
        StyleTemplate styleTemplateFromAdInfo = getStyleTemplateFromAdInfo();
        if (styleTemplateFromAdInfo == null) {
            return;
        }
        TkLoggerReporter.get().reportTKPerform(ILoggerReporter.Category.ERROR_LOG, new TKPerformMsg(this.tkSource).setRenderState(3).setErrorReason("timeout").setTemplateId(this.mTKLoadInterface.getTkTemplateId()).setVersionCode(String.valueOf(styleTemplateFromAdInfo.templateVersionCode)).toJson());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void logTkError(Throwable th) {
        com.kwad.sdk.core.d.b.d("tkRender", "logTkRenderFail : " + th + ", templateId = " + this.mTKLoadInterface.getTkTemplateId());
        TkLoggerReporter.get().reportTKPerform(ILoggerReporter.Category.ERROR_LOG, new TKPerformMsg(this.tkSource).setRenderState(3).setErrorReason(th.getMessage()).setTemplateId(this.mTKLoadInterface.getTkTemplateId()).setVersionCode(String.valueOf(this.mStyleTemplate.templateVersionCode)).toJson());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void logTkRenderFail(String str) {
        com.kwad.sdk.core.d.b.d("tkRender", "logTkRenderFail : " + str + ", templateId = " + this.mTKLoadInterface.getTkTemplateId());
        if (!this.isTkTemplateRenderStart || this.isTkTemplateRenderComplete) {
            return;
        }
        this.isTkTemplateRenderComplete = true;
        TkLoggerReporter.get().reportTKPerform(ILoggerReporter.Category.ERROR_LOG, new TKPerformMsg(this.tkSource).setRenderState(2).setErrorReason(str).setTemplateId(this.mTKLoadInterface.getTkTemplateId()).setVersionCode(String.valueOf(this.mStyleTemplate.templateVersionCode)).toJson());
    }

    private void logTkRenderStart() {
        this.isTkTemplateRenderStart = true;
        TkLoggerReporter.get().reportTKPerform(ILoggerReporter.Category.APM_LOG, new TKPerformMsg(this.tkSource).setRenderState(0).setTemplateId(this.mTKLoadInterface.getTkTemplateId()).setVersionCode(String.valueOf(this.mStyleTemplate.templateVersionCode)).toJson());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void logTkRenderSuccess() {
        if (!this.isTkTemplateRenderStart || this.isTkTemplateRenderComplete) {
            return;
        }
        this.isTkTemplateRenderComplete = true;
        TkLoggerReporter.get().reportTKPerform(ILoggerReporter.Category.APM_LOG, new TKPerformMsg(this.tkSource).setRenderState(1).setRenderTime(this.mRenderStartTime > 0 ? SystemClock.elapsedRealtime() - this.mRenderStartTime : 0L).setTemplateId(this.mTKLoadInterface.getTkTemplateId()).setLoadTime(this.mLoadEndTime - this.mLoadStartTime).setInitTime(this.mInitTime).setVersionCode(String.valueOf(this.mStyleTemplate.templateVersionCode)).toJson());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onFrameValid(s.a aVar) {
        FrameLayout tKContainer = this.mTKLoadInterface.getTKContainer();
        if (tKContainer != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) tKContainer.getLayoutParams();
            layoutParams.height = com.kwad.sdk.b.kwai.a.a(this.mContext, aVar.height);
            layoutParams.leftMargin = com.kwad.sdk.b.kwai.a.a(this.mContext, aVar.leftMargin);
            layoutParams.rightMargin = com.kwad.sdk.b.kwai.a.a(this.mContext, aVar.rightMargin);
            layoutParams.bottomMargin = com.kwad.sdk.b.kwai.a.a(this.mContext, aVar.bottomMargin);
            layoutParams.width = -1;
            tKContainer.setLayoutParams(layoutParams);
        }
    }

    private void registerWebCardHandler(l lVar) {
        com.kwad.components.core.d.b.c cVar = obtainAdTemplate() != null ? new com.kwad.components.core.d.b.c(obtainAdTemplate()) : null;
        this.mTKLoadInterface.onRegisterWebCardHandler(lVar, this.jsBridgeContext);
        com.kwad.components.core.webview.a.kwai.s sVar = new com.kwad.components.core.webview.a.kwai.s();
        sVar.a(new s.a() { // from class: com.kwad.components.core.webview.a.g.21
            @Override // com.kwad.components.core.webview.a.kwai.s.a
            public final void a(r rVar) {
                if (TextUtils.isEmpty(rVar.message)) {
                    return;
                }
                u.d(g.this.mContext, rVar.message, 0L);
            }
        });
        doRegisterHandler(lVar, sVar);
        doRegisterHandler(lVar, createLogHandler(this.jsBridgeContext));
        doRegisterHandler(lVar, new com.kwad.sdk.core.webview.c.a());
        doRegisterHandler(lVar, new com.kwad.components.core.webview.a.kwai.f());
        doRegisterHandler(lVar, new com.kwad.components.core.webview.jshandler.j(this.jsBridgeContext, cVar, this));
        doRegisterHandler(lVar, new com.kwad.components.core.webview.jshandler.i());
        doRegisterHandler(lVar, new com.kwad.components.core.webview.a.kwai.k());
        doRegisterHandler(lVar, new m(this.jsBridgeContext));
        doRegisterHandler(lVar, new com.kwad.components.core.webview.jshandler.p(this.jsBridgeContext));
        com.kwad.components.core.webview.jshandler.l lVar2 = new com.kwad.components.core.webview.jshandler.l(this.jsBridgeContext);
        lVar2.a(new l.b() { // from class: com.kwad.components.core.webview.a.g.2
            @Override // com.kwad.components.core.webview.jshandler.l.b
            public final void a(l.a aVar) {
                g.this.mTKLoadInterface.onGetContainerLimited(aVar);
            }
        });
        doRegisterHandler(lVar, lVar2);
        doRegisterHandler(lVar, new com.kwad.components.core.webview.jshandler.s(this.jsBridgeContext, new s.b() { // from class: com.kwad.components.core.webview.a.g.3
            @Override // com.kwad.components.core.webview.jshandler.s.b
            public final void a(s.a aVar) {
                g.this.onFrameValid(aVar);
            }
        }));
        doRegisterHandler(lVar, new z(new z.b() { // from class: com.kwad.components.core.webview.a.g.4
            @Override // com.kwad.components.core.webview.jshandler.z.b
            public final void a(z.a aVar) {
                if (aVar.status != 1) {
                    g.this.callbackTkLoadFailed();
                    g.this.logTkRenderFail(aVar.errorMsg);
                    return;
                }
                g.this.logTkRenderSuccess();
                h hVar = g.this.mTKLoadInterface;
                if (hVar != null) {
                    hVar.onTkLoadSuccess();
                }
            }
        }));
        ae aeVar = new ae();
        doRegisterHandler(lVar, aeVar);
        this.mTKLoadInterface.onRegisterLifecycleLisener(aeVar);
        doRegisterHandler(lVar, new com.kwad.components.core.webview.jshandler.ah(this.jsBridgeContext, cVar));
        this.mJSVideoProgress = new p();
        doRegisterHandler(lVar, this.mJSVideoProgress);
        this.mTKLoadInterface.onRegisterVideoProgressListener(this.mJSVideoProgress, this.mVideoPlayStateListener);
        if (obtainAdTemplate() != null && com.kwad.sdk.core.response.a.a.ay(com.kwad.sdk.core.response.a.d.cb(obtainAdTemplate()))) {
            final com.kwad.components.core.webview.a.kwai.l lVar3 = new com.kwad.components.core.webview.a.kwai.l();
            doRegisterHandler(lVar, lVar3);
            this.mDownloadSyncInterfaceAdapter = new com.kwad.sdk.core.download.e(obtainAdTemplate()) { // from class: com.kwad.components.core.webview.a.g.5
                @Override // com.kwad.sdk.core.download.e, com.kwad.sdk.core.download.d
                public final void a(String str, int i2, com.kwad.sdk.core.download.f fVar) {
                    super.a(str, i2, fVar);
                    com.kwad.components.core.webview.a.a.b bVar = new com.kwad.components.core.webview.a.a.b();
                    bVar.UO = 1;
                    lVar3.a(bVar);
                }
            };
            com.kwad.sdk.core.download.c.vG().a(this.mDownloadSyncInterfaceAdapter, obtainAdTemplate());
        }
        t tVar = new t();
        tVar.a(new t.a() { // from class: com.kwad.components.core.webview.a.g.6
            @Override // com.kwad.components.core.webview.a.kwai.t.a
            public final void a(com.kwad.components.core.webview.a.a.s sVar2) {
                g.this.mTKLoadInterface.onSkipClick(sVar2);
            }
        });
        doRegisterHandler(lVar, tVar);
        com.kwad.components.core.webview.a.kwai.u uVar = new com.kwad.components.core.webview.a.kwai.u();
        uVar.a(new u.a() { // from class: com.kwad.components.core.webview.a.g.7
            @Override // com.kwad.components.core.webview.a.kwai.u.a
            public final void a(com.kwad.components.core.webview.a.a.k kVar) {
                g.this.mTKLoadInterface.onUpdateMuteStatus(kVar);
            }
        });
        doRegisterHandler(lVar, uVar);
        o oVar = new o();
        doRegisterHandler(lVar, oVar);
        this.mTKLoadInterface.onRegisterVideoMuteStateListener(oVar);
        doRegisterHandler(lVar, new com.kwad.components.core.webview.a.kwai.r() { // from class: com.kwad.components.core.webview.a.g.8
            @Override // com.kwad.components.core.webview.a.kwai.r
            public final void a(q qVar) {
                super.a(qVar);
                if (g.this.mActivity == null) {
                    g gVar = g.this;
                    com.kwad.sdk.core.b.b.we();
                    gVar.mActivity = com.kwad.sdk.core.b.b.getCurrentActivity();
                }
                if (g.this.mActivity == null || g.this.mActivity.isFinishing()) {
                    return;
                }
                if (g.this.mTkDialogFragment != null) {
                    g.this.mTkDialogFragment.dismiss();
                }
                d.b bVar = new d.b();
                bVar.setAdTemplate(g.this.obtainAdTemplate());
                bVar.aH(qVar.templateId);
                g.this.mTkDialogFragment = com.kwad.components.core.webview.a.b.d.b(bVar);
                g.this.mTkDialogFragment.show(g.this.mActivity.getFragmentManager(), "");
            }
        });
        doRegisterHandler(lVar, new com.kwad.components.core.webview.a.kwai.c() { // from class: com.kwad.components.core.webview.a.g.9
            @Override // com.kwad.components.core.webview.a.kwai.c
            public final void jl() {
                super.jl();
                if (g.this.mTkDialogFragment != null) {
                    g.this.mTkDialogFragment.dismiss();
                }
                h hVar = g.this.mTKLoadInterface;
                if (hVar != null) {
                    hVar.onCloseTKDialogClick();
                }
            }
        });
        doRegisterHandler(lVar, new com.kwad.components.core.webview.jshandler.h(new com.kwad.sdk.core.webview.c.kwai.b() { // from class: com.kwad.components.core.webview.a.g.10
            @Override // com.kwad.sdk.core.webview.c.kwai.b
            public final void a(WebCloseStatus webCloseStatus) {
                g.this.mTKLoadInterface.pageClose(webCloseStatus);
            }
        }));
        doRegisterHandler(lVar, new com.kwad.components.core.webview.a.kwai.d() { // from class: com.kwad.components.core.webview.a.g.11
            @Override // com.kwad.components.core.webview.a.kwai.d
            public final void a(com.kwad.components.core.webview.a.a.g gVar) {
                super.a(gVar);
                com.kwad.components.core.m.a.pr().a(gVar.Tn, g.this.obtainAdTemplate(), gVar.To);
            }
        });
        doRegisterHandler(lVar, new com.kwad.components.core.webview.a.kwai.j() { // from class: com.kwad.components.core.webview.a.g.13
            @Override // com.kwad.components.core.webview.a.kwai.j
            public final void a(com.kwad.components.core.webview.a.a.l lVar4) {
                super.a(lVar4);
                AdWebViewActivityProxy.launch(g.this.mContext, new AdWebViewActivityProxy.a.C0405a().ar(lVar4.title).as(lVar4.url).ax(true).M(g.this.obtainAdTemplate()).ow());
            }
        });
        doRegisterHandler(lVar, new com.kwad.components.core.webview.a.kwai.a(obtainAdTemplate()));
        onRegisterWebCardHandler(this.jsBridgeContext, cVar, lVar, this.mTKLoadInterface.getTKContainer());
    }

    public void addCustomEnv(String str, Object obj) {
        getCustomEnv().put(str, obj);
    }

    public void bind(@Nullable Activity activity, AdTemplate adTemplate, h hVar) {
        this.mActivity = activity;
        this.mAdTemplate = adTemplate;
        this.jsBridgeContext.setAdTemplate(adTemplate);
        this.mTKLoadInterface = hVar;
        initParam();
        FrameLayout tKContainer = this.mTKLoadInterface.getTKContainer();
        if (tKContainer != null) {
            tKContainer.removeAllViews();
        }
        if (!com.kwad.sdk.core.config.d.isCanUseTk()) {
            callbackTkLoadFailed();
            return;
        }
        this.mTKPlugin = (com.kwad.components.core.offline.api.a.c) com.kwad.sdk.components.c.f(com.kwad.components.core.offline.api.a.c.class);
        logEnterTKScene();
        com.kwad.sdk.core.d.b.d(TAG, "bind mTKPlugin: " + this.mTKPlugin);
        if (this.mTKPlugin != null) {
            loadTkStyleTemplate();
        } else {
            callbackTkLoadFailed();
            TkLoggerReporter.get().reportTKPerform(ILoggerReporter.Category.ERROR_LOG, new TKPerformMsg(this.tkSource).setRenderState(4).setErrorReason(TKPerformMsg.ERROR_REASON.KSAD_TK_OFFLINE_FAILED).setTemplateId(this.mTKLoadInterface.getTkTemplateId()).toJson());
        }
    }

    @Override // com.kwad.sdk.components.i
    public void callJS(String str) {
        com.kwad.sdk.components.l lVar = this.mTKView;
        if (lVar != null) {
            lVar.a(str, null, null);
        }
    }

    protected com.kwad.components.core.webview.jshandler.t createLogHandler(com.kwad.sdk.core.webview.b bVar) {
        return new com.kwad.components.core.webview.jshandler.t(bVar);
    }

    public com.kwad.sdk.core.webview.b getJsBridgeContext() {
        return this.jsBridgeContext;
    }

    protected AdTemplate obtainAdTemplate() {
        return this.jsBridgeContext.getAdTemplate();
    }

    @Override // com.kwad.sdk.core.webview.c.kwai.a
    public void onAdClicked(@Nullable com.kwad.sdk.core.webview.c.a.a aVar) {
        h hVar = this.mTKLoadInterface;
        if (hVar != null) {
            hVar.onAdClicked(aVar);
        }
    }

    protected void onRegisterWebCardHandler(com.kwad.sdk.core.webview.b bVar, com.kwad.components.core.d.b.c cVar, com.kwad.sdk.components.l lVar, ViewGroup viewGroup) {
    }

    public void resetAdTemplate(AdTemplate adTemplate) {
        if (adTemplate == null || this.mTKView == null) {
            return;
        }
        this.mAdTemplate = adTemplate;
        this.jsBridgeContext.setAdTemplate(adTemplate);
        com.kwad.components.core.offline.api.a.kwai.a.a(this.mTKView.getUniqId(), adTemplate);
        this.mTKView.unregisterJsBridge();
        registerWebCardHandler(this.mTKView);
    }

    public void setStyleTemplate(StyleTemplate styleTemplate) {
        this.mStyleTemplate = styleTemplate;
    }

    public void setTKBridgeHandler(com.kwad.sdk.core.webview.b.g gVar) {
        this.mTKBridgeHandler = gVar;
    }

    public void unBind() {
        Future<?> future = this.mLoadTkFuture;
        if (future != null) {
            future.cancel(true);
        }
        bh.b(this.mDownloadTimeoutRunnable);
        if (this.mDownloadSyncInterfaceAdapter != null) {
            com.kwad.sdk.core.download.c.vG().a(this.mDownloadSyncInterfaceAdapter);
        }
        com.kwad.components.core.webview.a.b.d dVar = this.mTkDialogFragment;
        if (dVar != null) {
            dVar.dismiss();
        }
        com.kwad.components.core.offline.api.a.c cVar = this.mTKPlugin;
        if (cVar != null) {
            cVar.onDestroy();
        }
        final com.kwad.sdk.components.l lVar = this.mTKView;
        if (lVar != null) {
            com.kwad.components.core.offline.api.a.kwai.a.au(lVar.getUniqId());
            this.mTKView = null;
            bh.postOnUiThread(new Runnable() { // from class: com.kwad.components.core.webview.a.g.1
                @Override // java.lang.Runnable
                public final void run() {
                    com.kwad.sdk.components.l lVar2 = lVar;
                    if (lVar2 != null) {
                        lVar2.onDestroy();
                    }
                }
            });
        }
    }
}
