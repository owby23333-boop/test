package com.anythink.expressad.atsignalcommon.mraid;

import com.anythink.expressad.foundation.d.c;

/* JADX INFO: loaded from: classes2.dex */
public interface IMraidSignalCommunication {
    void close();

    void expand(String str, boolean z2);

    c getMraidCampaign();

    void open(String str);

    void unload();

    void useCustomClose(boolean z2);
}
