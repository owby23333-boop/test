package com.anythink.expressad.video.signal;

import android.content.res.Configuration;

/* JADX INFO: loaded from: classes2.dex */
public interface h {
    void handlerPlayableException(String str);

    void install(com.anythink.expressad.foundation.d.c cVar);

    void notifyCloseBtn(int i2);

    void orientation(Configuration configuration);

    void readyStatus(int i2);

    void toggleCloseBtn(int i2);

    void webviewshow();
}
