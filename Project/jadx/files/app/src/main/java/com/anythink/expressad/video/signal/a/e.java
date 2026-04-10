package com.anythink.expressad.video.signal.a;

import com.anythink.expressad.video.module.AnythinkVideoView;

/* JADX INFO: loaded from: classes2.dex */
public class e implements com.anythink.expressad.video.signal.g {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    protected static final String f11931m = "DefaultJSNotifyProxy";

    @Override // com.anythink.expressad.video.signal.g
    public void a() {
        com.anythink.expressad.foundation.h.o.a(f11931m, "onSignalCommunication");
    }

    @Override // com.anythink.expressad.video.signal.g
    public void a(int i2) {
        com.anythink.expressad.foundation.h.o.a(f11931m, "onVideoStatusNotify:".concat(String.valueOf(i2)));
    }

    @Override // com.anythink.expressad.video.signal.g
    public void a(int i2, String str) {
        com.anythink.expressad.foundation.h.o.a(f11931m, "onClick:" + i2 + ",pt:" + str);
    }

    @Override // com.anythink.expressad.video.signal.g
    public void a(AnythinkVideoView.a aVar) {
        com.anythink.expressad.foundation.h.o.a(f11931m, "onProgressNotify:" + aVar.toString());
    }

    @Override // com.anythink.expressad.video.signal.g
    public void a(Object obj) {
        com.anythink.expressad.foundation.h.o.a(f11931m, "onWebviewShow:".concat(String.valueOf(obj)));
    }

    @Override // com.anythink.expressad.video.signal.g
    public void a(int i2, int i3, int i4, int i5) {
        com.anythink.expressad.foundation.h.o.a(f11931m, "showDataInfo");
    }
}
