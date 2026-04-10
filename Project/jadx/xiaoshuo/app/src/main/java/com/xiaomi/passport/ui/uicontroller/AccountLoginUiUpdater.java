package com.xiaomi.passport.ui.uicontroller;

import androidx.annotation.Nullable;
import com.xiaomi.passport.ui.data.PhoneAccount;

/* JADX INFO: loaded from: classes8.dex */
public interface AccountLoginUiUpdater {
    void updateFooterVisibility(boolean z, boolean z2);

    void updateHeaderVisibility(boolean z, boolean z2);

    void updateUserAgreement(@Nullable PhoneAccount[] phoneAccountArr);
}
