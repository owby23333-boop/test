package com.sntech.ads;

import android.app.Activity;
import androidx.annotation.Keep;
import com.sntech.a4.A4AdListener;

/* JADX INFO: loaded from: classes.dex */
@Keep
public interface A4AdManager {
    @Keep
    void showA4InterstitialAd(Activity activity, String str, A4AdListener a4AdListener);
}
