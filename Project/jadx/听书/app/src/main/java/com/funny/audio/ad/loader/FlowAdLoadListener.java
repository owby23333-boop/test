package com.funny.audio.ad.loader;

import androidx.core.app.NotificationCompat;
import kotlin.Metadata;

/* JADX INFO: compiled from: FeedAdLoader.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u001a\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&J\b\u0010\t\u001a\u00020\u0003H&¨\u0006\n"}, d2 = {"Lcom/funny/audio/ad/loader/FlowAdLoadListener;", "", "onAdLoad", "", "onLoadFail", "code", "", NotificationCompat.CATEGORY_MESSAGE, "", "onRepeatedLoad", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface FlowAdLoadListener {
    void onAdLoad();

    void onLoadFail(int code, String msg);

    void onRepeatedLoad();
}
