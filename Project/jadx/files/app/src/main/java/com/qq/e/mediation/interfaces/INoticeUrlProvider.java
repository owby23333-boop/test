package com.qq.e.mediation.interfaces;

/* JADX INFO: loaded from: classes3.dex */
public interface INoticeUrlProvider {
    public static final String IMPL_CLASS_NAME = "util.NoticeUrlProviderImpl";

    String getAssembledLossNoticeUrl(String str, String str2, boolean z2);

    String getAssembledWinNoticeUrl(String str, String str2, boolean z2);

    String getOtherAssembledLossNoticeUrl(String str, String str2);
}
