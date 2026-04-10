package com.funny.audio.ad.loader;

import kotlin.Metadata;

/* JADX INFO: compiled from: RewardVideoAdLoader.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0003H&¨\u0006\u0007"}, d2 = {"Lcom/funny/audio/ad/loader/RewardVideoAdListener;", "", "onAdClose", "", "onAdShow", "onAdSkip", "onRewardVerify", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface RewardVideoAdListener {
    void onAdClose();

    void onAdShow();

    void onAdSkip();

    void onRewardVerify();
}
