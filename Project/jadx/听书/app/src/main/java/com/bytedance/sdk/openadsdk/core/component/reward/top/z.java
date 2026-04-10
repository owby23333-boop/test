package com.bytedance.sdk.openadsdk.core.component.reward.top;

import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
public interface z<T extends View> {
    void dl();

    void g();

    View getCloseButton();

    boolean getSkipOrCloseVisible();

    void setDislikeLeft(boolean z);

    void setListener(g gVar);

    void setPlayAgainEntranceText(String str);

    void setShowAgain(boolean z);

    void setShowBack(boolean z);

    void setShowDislike(boolean z);

    void setShowSound(boolean z);

    void setSoundMute(boolean z);

    void setVisible(boolean z);

    void z();

    void z(String str, String str2, boolean z);

    void z(boolean z, String str, String str2, boolean z2, boolean z3);
}
