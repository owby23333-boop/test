package com.bytedance.sdk.component.adexpress.gc;

import android.webkit.JavascriptInterface;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public class dl {
    private WeakReference<g> z;

    public dl(g gVar) {
        this.z = new WeakReference<>(gVar);
    }

    public void z(g gVar) {
        if (gVar == null) {
            this.z = null;
        } else {
            this.z = new WeakReference<>(gVar);
        }
    }

    @JavascriptInterface
    public String adInfo() {
        WeakReference<g> weakReference = this.z;
        return (weakReference == null || weakReference.get() == null) ? "" : this.z.get().adInfo();
    }

    @JavascriptInterface
    public String appInfo() {
        WeakReference<g> weakReference = this.z;
        return (weakReference == null || weakReference.get() == null) ? "" : this.z.get().appInfo();
    }

    @JavascriptInterface
    public String getTemplateInfo() {
        WeakReference<g> weakReference = this.z;
        return (weakReference == null || weakReference.get() == null) ? "" : this.z.get().getTemplateInfo();
    }

    @JavascriptInterface
    public void renderDidFinish(String str) {
        WeakReference<g> weakReference = this.z;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.z.get().renderDidFinish(str);
    }

    @JavascriptInterface
    public void adAnalysisData(String str) {
        WeakReference<g> weakReference = this.z;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.z.get().adAnalysisData(str);
    }

    @JavascriptInterface
    public void muteVideo(String str) {
        WeakReference<g> weakReference = this.z;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.z.get().muteVideo(str);
    }

    @JavascriptInterface
    public void dynamicTrack(String str) {
        WeakReference<g> weakReference = this.z;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.z.get().dynamicTrack(str);
    }

    @JavascriptInterface
    public void changeVideoState(String str) {
        WeakReference<g> weakReference = this.z;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.z.get().changeVideoState(str);
    }

    @JavascriptInterface
    public void clickEvent(String str) {
        WeakReference<g> weakReference = this.z;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.z.get().clickEvent(str);
    }

    @JavascriptInterface
    public void skipVideo() {
        WeakReference<g> weakReference = this.z;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.z.get().skipVideo();
    }

    @JavascriptInterface
    public String getCurrentVideoState() {
        WeakReference<g> weakReference = this.z;
        return (weakReference == null || weakReference.get() == null) ? "" : this.z.get().getCurrentVideoState();
    }

    @JavascriptInterface
    public void initRenderFinish() {
        WeakReference<g> weakReference = this.z;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.z.get().initRenderFinish();
    }

    @JavascriptInterface
    public void requestPauseVideo(String str) {
        WeakReference<g> weakReference = this.z;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.z.get().requestPauseVideo(str);
    }

    @JavascriptInterface
    public String getData(String str) {
        WeakReference<g> weakReference = this.z;
        return (weakReference == null || weakReference.get() == null) ? "" : this.z.get().getData(str);
    }
}
