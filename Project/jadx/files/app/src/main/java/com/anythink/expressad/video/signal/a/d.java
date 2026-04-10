package com.anythink.expressad.video.signal.a;

import android.content.res.Configuration;

/* JADX INFO: loaded from: classes2.dex */
public class d implements com.anythink.expressad.video.signal.e, com.anythink.expressad.video.signal.h {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    protected static final String f11930j = "DefaultJSContainerModule";

    @Override // com.anythink.expressad.video.signal.e
    public void configurationChanged(int i2, int i3, int i4) {
    }

    @Override // com.anythink.expressad.video.signal.e
    public boolean endCardShowing() {
        com.anythink.expressad.foundation.h.o.a(f11930j, "endCardShowing");
        return true;
    }

    @Override // com.anythink.expressad.video.signal.e, com.anythink.expressad.video.signal.h
    public void handlerPlayableException(String str) {
        com.anythink.expressad.foundation.h.o.a(f11930j, "handlerPlayableException ,msg=".concat(String.valueOf(str)));
    }

    @Override // com.anythink.expressad.video.signal.e
    public void hideAlertWebview() {
        com.anythink.expressad.foundation.h.o.a(f11930j, "hideAlertWebview ,msg=");
    }

    @Override // com.anythink.expressad.video.signal.h
    public void install(com.anythink.expressad.foundation.d.c cVar) {
        com.anythink.expressad.foundation.h.o.a(f11930j, "install ,campaign=".concat(String.valueOf(cVar)));
    }

    @Override // com.anythink.expressad.video.signal.e
    public void ivRewardAdsWithoutVideo(String str) {
        com.anythink.expressad.foundation.h.o.a(f11930j, "ivRewardAdsWithoutVideo,params=");
    }

    @Override // com.anythink.expressad.video.signal.e
    public boolean miniCardLoaded() {
        com.anythink.expressad.foundation.h.o.a(f11930j, "miniCardLoaded");
        return false;
    }

    @Override // com.anythink.expressad.video.signal.e
    public boolean miniCardShowing() {
        com.anythink.expressad.foundation.h.o.a(f11930j, "miniCardShowing");
        return false;
    }

    @Override // com.anythink.expressad.video.signal.h
    public void notifyCloseBtn(int i2) {
        com.anythink.expressad.foundation.h.o.a(f11930j, "notifyCloseBtn:state = ".concat(String.valueOf(i2)));
    }

    @Override // com.anythink.expressad.video.signal.h
    public void orientation(Configuration configuration) {
        com.anythink.expressad.foundation.h.o.a(f11930j, "orientation ,config=".concat(String.valueOf(configuration)));
    }

    @Override // com.anythink.expressad.video.signal.f
    public void preLoadData(com.anythink.expressad.video.signal.factory.b bVar) {
        com.anythink.expressad.foundation.h.o.a(f11930j, "preLoadData");
    }

    @Override // com.anythink.expressad.video.signal.e, com.anythink.expressad.video.signal.h
    public void readyStatus(int i2) {
        com.anythink.expressad.foundation.h.o.a(f11930j, "readyStatus:isReady=".concat(String.valueOf(i2)));
    }

    @Override // com.anythink.expressad.video.signal.e
    public void resizeMiniCard(int i2, int i3, int i4) {
        com.anythink.expressad.foundation.h.o.a(f11930j, "showMiniCard width = " + i2 + " height = " + i3 + " radius = " + i4);
    }

    @Override // com.anythink.expressad.video.signal.e
    public boolean showAlertWebView() {
        com.anythink.expressad.foundation.h.o.a(f11930j, "showAlertWebView ,msg=");
        return false;
    }

    @Override // com.anythink.expressad.video.signal.e
    public void showEndcard(int i2) {
        com.anythink.expressad.foundation.h.o.a(f11930j, "showEndcard,type=".concat(String.valueOf(i2)));
    }

    @Override // com.anythink.expressad.video.signal.e
    public void showMiniCard(int i2, int i3, int i4, int i5, int i6) {
        com.anythink.expressad.foundation.h.o.a(f11930j, "showMiniCard top = " + i2 + " left = " + i3 + " width = " + i4 + " height = " + i5 + " radius = " + i6);
    }

    @Override // com.anythink.expressad.video.signal.e
    public void showPlayableView() {
        com.anythink.expressad.foundation.h.o.a(f11930j, "showPlayableView");
    }

    @Override // com.anythink.expressad.video.signal.e
    public void showVideoClickView(int i2) {
        com.anythink.expressad.foundation.h.o.a(f11930j, "showVideoClickView:".concat(String.valueOf(i2)));
    }

    @Override // com.anythink.expressad.video.signal.e
    public void showVideoEndCover() {
        com.anythink.expressad.foundation.h.o.a(f11930j, "showVideoEndCover");
    }

    @Override // com.anythink.expressad.video.signal.h
    public void toggleCloseBtn(int i2) {
        com.anythink.expressad.foundation.h.o.a(f11930j, "toggleCloseBtn:state=".concat(String.valueOf(i2)));
    }

    @Override // com.anythink.expressad.video.signal.h
    public void webviewshow() {
        com.anythink.expressad.foundation.h.o.a(f11930j, "webviewshow");
    }
}
