package com.kwad.components.core.o.b.a;

import android.content.Context;
import android.os.Vibrator;
import com.kwad.components.offline.api.core.api.IVibratorUtil;
import com.kwad.sdk.utils.bw;

/* JADX INFO: loaded from: classes3.dex */
public final class q implements IVibratorUtil {
    @Override // com.kwad.components.offline.api.core.api.IVibratorUtil
    public final void vibrate(Context context, Vibrator vibrator, long j) {
        bw.vibrate(context, vibrator, j);
    }

    @Override // com.kwad.components.offline.api.core.api.IVibratorUtil
    public final void cancelVibrate(Context context, Vibrator vibrator) {
        bw.b(context, vibrator);
    }
}
