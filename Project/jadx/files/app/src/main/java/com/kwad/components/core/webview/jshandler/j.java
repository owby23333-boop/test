package com.kwad.components.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.d.b.a;
import com.kwad.sdk.core.report.KSLoggerReporter;
import com.kwad.sdk.internal.api.SceneImpl;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class j implements com.kwad.sdk.core.webview.b.a {
    private final com.kwad.sdk.core.webview.b Sk;
    private boolean Sm;
    private Handler Ss;
    private boolean Sw;

    @Nullable
    private com.kwad.sdk.core.webview.c.kwai.a cV;

    @Nullable
    private final com.kwad.components.core.d.b.c mApkDownloadHelper;

    public j(@NonNull com.kwad.sdk.core.webview.b bVar, @Nullable com.kwad.components.core.d.b.c cVar, @Nullable com.kwad.sdk.core.webview.c.kwai.a aVar) {
        this(bVar, cVar, aVar, false, false);
    }

    public j(@NonNull com.kwad.sdk.core.webview.b bVar, @Nullable com.kwad.components.core.d.b.c cVar, @Nullable com.kwad.sdk.core.webview.c.kwai.a aVar, boolean z2, boolean z3) {
        this.Sm = false;
        this.Sw = false;
        this.Sm = z2;
        this.Ss = new Handler(Looper.getMainLooper());
        this.Sk = bVar;
        this.mApkDownloadHelper = cVar;
        this.Sw = z3;
        if (cVar != null) {
            this.mApkDownloadHelper.as(1);
        }
        this.cV = aVar;
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
        Handler handler;
        Runnable runnable;
        if (this.Sk.zf()) {
            cVar.onError(-1, "native adTemplate is null");
            return;
        }
        final com.kwad.sdk.core.webview.c.a.a aVar = new com.kwad.sdk.core.webview.c.a.a();
        try {
            aVar.parseJson(new JSONObject(str));
            aVar.IV = true;
        } catch (JSONException e2) {
            com.kwad.sdk.core.d.b.printStackTrace(e2);
        }
        if (!this.Sk.aoO) {
            if (this.cV != null) {
                handler = this.Ss;
                runnable = new Runnable() { // from class: com.kwad.components.core.webview.jshandler.j.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (j.this.cV != null) {
                            j.this.cV.onAdClicked(aVar);
                        }
                    }
                };
            }
            cVar.a(null);
        }
        handler = this.Ss;
        runnable = new Runnable() { // from class: com.kwad.components.core.webview.jshandler.j.1
            @Override // java.lang.Runnable
            public final void run() {
                if (j.this.Sk.aoP || aVar.Tw) {
                    SceneImpl sceneImpl = j.this.Sk.getAdTemplate().mAdScene;
                    KSLoggerReporter.ReportClient.CORE_CONVERT.buildMethodCheck(sceneImpl != null ? KSLoggerReporter.bs(sceneImpl.getAdStyle()) : null, "adClick").b("isWebCard", Boolean.TRUE).report();
                    com.kwad.components.core.d.b.a.a(j.this.Sk.LI.getContext(), j.this.Sk.getAdTemplate(), new a.b() { // from class: com.kwad.components.core.webview.jshandler.j.1.1
                        @Override // com.kwad.components.core.d.b.a.b
                        public final void onAdClicked() {
                            if (j.this.cV != null) {
                                j.this.cV.onAdClicked(aVar);
                            }
                        }
                    }, j.this.mApkDownloadHelper, aVar.Tw, j.this.Sm, j.this.Sw);
                }
            }
        };
        handler.post(runnable);
        cVar.a(null);
    }

    @Override // com.kwad.sdk.core.webview.b.a
    @NonNull
    public final String getKey() {
        return "convert";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
        this.Ss.removeCallbacksAndMessages(null);
        this.cV = null;
    }
}
