package com.efs.sdk.base.integrationtesting;

/* JADX INFO: loaded from: classes3.dex */
public class IntegrationTestingUtil {
    private static boolean sIsInPeriod;

    public static void setIntegrationTestingInPeriod(boolean z) {
        sIsInPeriod = z;
    }

    public static boolean isIntegrationTestingInPeriod() {
        return sIsInPeriod;
    }
}
