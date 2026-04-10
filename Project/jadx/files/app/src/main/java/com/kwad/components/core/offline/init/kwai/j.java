package com.kwad.components.core.offline.init.kwai;

import android.content.Context;
import android.os.Vibrator;
import com.kwad.components.offline.api.core.api.IVibratorUtil;
import com.kwad.sdk.utils.bh;

/* JADX INFO: loaded from: classes3.dex */
public final class j implements IVibratorUtil {
    @Override // com.kwad.components.offline.api.core.api.IVibratorUtil
    public final void cancelVibrate(Context context, Vibrator vibrator) {
        bh.b(context, vibrator);
    }

    @Override // com.kwad.components.offline.api.core.api.IVibratorUtil
    public final void vibrate(Context context, Vibrator vibrator, long j2) {
        bh.vibrate(context, vibrator, j2);
    }
}
