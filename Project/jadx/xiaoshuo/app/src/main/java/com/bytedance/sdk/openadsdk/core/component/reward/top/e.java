package com.bytedance.sdk.openadsdk.core.component.reward.top;

import android.view.View;

/* JADX INFO: loaded from: classes10.dex */
public interface e<T extends View> {
    void bf();

    void d();

    void e();

    void e(boolean z, String str, String str2, boolean z2, boolean z3);

    View getCloseButton();

    boolean getSkipOrCloseVisible();

    void setDislikeLeft(boolean z);

    void setListener(bf bfVar);

    void setPlayAgainEntranceText(String str);

    void setShowAgain(boolean z);

    void setShowBack(boolean z);

    void setShowDislike(boolean z);

    void setShowSound(boolean z);

    void setSoundMute(boolean z);

    void setVisible(boolean z);
}
