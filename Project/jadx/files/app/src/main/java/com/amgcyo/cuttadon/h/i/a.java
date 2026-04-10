package com.amgcyo.cuttadon.h.i;

import com.amgcyo.cuttadon.f.o;
import com.anythink.core.api.ATAdInfo;
import com.anythink.core.api.ATAdSourceStatusListener;
import com.anythink.core.api.AdError;

/* JADX INFO: compiled from: ToponAdSourceStatusListener.java */
/* JADX INFO: loaded from: classes.dex */
public class a implements ATAdSourceStatusListener {
    private String a;
    private String b;

    public a(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    @Override // com.anythink.core.api.ATAdSourceStatusListener
    public void onAdSourceAttempt(ATAdInfo aTAdInfo) {
        String str = this.a + " 广告源开始加载回调: " + aTAdInfo.toString();
    }

    @Override // com.anythink.core.api.ATAdSourceStatusListener
    public void onAdSourceBiddingAttempt(ATAdInfo aTAdInfo) {
        String str = this.a + " 竞价广告源开始竞价回调: " + aTAdInfo.toString();
    }

    @Override // com.anythink.core.api.ATAdSourceStatusListener
    public void onAdSourceBiddingFail(ATAdInfo aTAdInfo, AdError adError) {
        String str = this.a + " 竞价广告源竞价失败回调 Info: " + aTAdInfo.toString() + " \nerror: " + adError.getFullErrorInfo();
    }

    @Override // com.anythink.core.api.ATAdSourceStatusListener
    public void onAdSourceBiddingFilled(ATAdInfo aTAdInfo) {
        String str = this.a + " 竞价广告源竞价成功回调: " + aTAdInfo.toString();
    }

    @Override // com.anythink.core.api.ATAdSourceStatusListener
    public void onAdSourceLoadFail(ATAdInfo aTAdInfo, AdError adError) {
        String str = "广告源加载失败回调 Info: " + aTAdInfo.toString() + " \nerror: " + adError.getFullErrorInfo();
        o.g(this.a + "广告源加载失败：" + adError.getFullErrorInfo());
    }

    @Override // com.anythink.core.api.ATAdSourceStatusListener
    public void onAdSourceLoadFilled(ATAdInfo aTAdInfo) {
        String str = this.a + " 广告源广告填充回调: " + aTAdInfo.toString();
    }
}
