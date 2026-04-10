package com.anythink.expressad.video.signal.a;

import android.content.res.Configuration;

/* JADX INFO: loaded from: classes2.dex */
public class f implements com.anythink.expressad.video.signal.i {
    protected static final String a = "js";

    @Override // com.anythink.expressad.video.signal.i
    public String a() {
        com.anythink.expressad.foundation.h.o.a(a, "getEndScreenInfo");
        return "{}";
    }

    @Override // com.anythink.expressad.video.signal.i
    public void b(String str) {
        com.anythink.expressad.foundation.h.o.a(a, "setOrientation,landscape=".concat(String.valueOf(str)));
    }

    @Override // com.anythink.expressad.video.signal.i, com.anythink.expressad.video.signal.h
    public void handlerPlayableException(String str) {
        com.anythink.expressad.foundation.h.o.a(a, "handlerPlayableException，msg=".concat(String.valueOf(str)));
    }

    @Override // com.anythink.expressad.video.signal.h
    public void install(com.anythink.expressad.foundation.d.c cVar) {
        com.anythink.expressad.foundation.h.o.a(a, "install:campaignEx=".concat(String.valueOf(cVar)));
    }

    @Override // com.anythink.expressad.video.signal.h
    public void notifyCloseBtn(int i2) {
        com.anythink.expressad.foundation.h.o.a(a, "notifyCloseBtn,state=".concat(String.valueOf(i2)));
    }

    @Override // com.anythink.expressad.video.signal.h
    public void orientation(Configuration configuration) {
        com.anythink.expressad.foundation.h.o.a(a, "orientation，config=".concat(String.valueOf(configuration)));
    }

    @Override // com.anythink.expressad.video.signal.h
    public void readyStatus(int i2) {
        com.anythink.expressad.foundation.h.o.a(a, "readyStatus,isReady=".concat(String.valueOf(i2)));
    }

    @Override // com.anythink.expressad.video.signal.h
    public void toggleCloseBtn(int i2) {
        com.anythink.expressad.foundation.h.o.a(a, "toggleCloseBtn,state=".concat(String.valueOf(i2)));
    }

    @Override // com.anythink.expressad.video.signal.h
    public void webviewshow() {
        com.anythink.expressad.foundation.h.o.a(a, "webviewshow");
    }

    @Override // com.anythink.expressad.video.signal.i
    public void a(String str) {
        com.anythink.expressad.foundation.h.o.a(a, "triggerCloseBtn,state=".concat(String.valueOf(str)));
    }
}
