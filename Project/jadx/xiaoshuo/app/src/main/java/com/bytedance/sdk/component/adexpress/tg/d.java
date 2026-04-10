package com.bytedance.sdk.component.adexpress.tg;

import android.webkit.JavascriptInterface;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public class d {
    private WeakReference<bf> e;

    public d(bf bfVar) {
        this.e = new WeakReference<>(bfVar);
    }

    @JavascriptInterface
    public void adAnalysisData(String str) {
        WeakReference<bf> weakReference = this.e;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.e.get().adAnalysisData(str);
    }

    @JavascriptInterface
    public String adInfo() {
        WeakReference<bf> weakReference = this.e;
        return (weakReference == null || weakReference.get() == null) ? "" : this.e.get().adInfo();
    }

    @JavascriptInterface
    public String appInfo() {
        WeakReference<bf> weakReference = this.e;
        return (weakReference == null || weakReference.get() == null) ? "" : this.e.get().appInfo();
    }

    @JavascriptInterface
    public void changeVideoState(String str) {
        WeakReference<bf> weakReference = this.e;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.e.get().changeVideoState(str);
    }

    @JavascriptInterface
    public void clickEvent(String str) {
        WeakReference<bf> weakReference = this.e;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.e.get().clickEvent(str);
    }

    @JavascriptInterface
    public void dynamicTrack(String str) {
        WeakReference<bf> weakReference = this.e;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.e.get().dynamicTrack(str);
    }

    public void e(bf bfVar) {
        this.e = new WeakReference<>(bfVar);
    }

    @JavascriptInterface
    public String getCurrentVideoState() {
        WeakReference<bf> weakReference = this.e;
        return (weakReference == null || weakReference.get() == null) ? "" : this.e.get().getCurrentVideoState();
    }

    @JavascriptInterface
    public String getTemplateInfo() {
        WeakReference<bf> weakReference = this.e;
        return (weakReference == null || weakReference.get() == null) ? "" : this.e.get().getTemplateInfo();
    }

    @JavascriptInterface
    public void initRenderFinish() {
        WeakReference<bf> weakReference = this.e;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.e.get().initRenderFinish();
    }

    @JavascriptInterface
    public void muteVideo(String str) {
        WeakReference<bf> weakReference = this.e;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.e.get().muteVideo(str);
    }

    @JavascriptInterface
    public void renderDidFinish(String str) {
        WeakReference<bf> weakReference = this.e;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.e.get().renderDidFinish(str);
    }

    @JavascriptInterface
    public void requestPauseVideo(String str) {
        WeakReference<bf> weakReference = this.e;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.e.get().requestPauseVideo(str);
    }

    @JavascriptInterface
    public void skipVideo() {
        WeakReference<bf> weakReference = this.e;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.e.get().skipVideo();
    }
}
