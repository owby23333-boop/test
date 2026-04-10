package com.kwad.components.ad.reward.monitor;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes3.dex */
@Retention(RetentionPolicy.SOURCE)
public @interface FraudVerifyType {
    public static final int KSVideoAdFraudResultDefault = 1;
    public static final int KSVideoAdFraudResultFalse = 2;
    public static final int KSVideoAdFraudResultTrue = 3;
}
