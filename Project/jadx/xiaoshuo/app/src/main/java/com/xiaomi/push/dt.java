package com.xiaomi.push;

/* JADX INFO: loaded from: classes8.dex */
/* synthetic */ class dt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ int[] f7893a;

    static {
        int[] iArr = new int[ib.values().length];
        f7893a = iArr;
        try {
            iArr[ib.Registration.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f7893a[ib.UnRegistration.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f7893a[ib.Subscription.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f7893a[ib.UnSubscription.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f7893a[ib.SendMessage.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            f7893a[ib.AckMessage.ordinal()] = 6;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            f7893a[ib.SetConfig.ordinal()] = 7;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            f7893a[ib.ReportFeedback.ordinal()] = 8;
        } catch (NoSuchFieldError unused8) {
        }
        try {
            f7893a[ib.MultiConnectionBroadcast.ordinal()] = 9;
        } catch (NoSuchFieldError unused9) {
        }
        try {
            f7893a[ib.MultiConnectionResult.ordinal()] = 10;
        } catch (NoSuchFieldError unused10) {
        }
        try {
            f7893a[ib.Notification.ordinal()] = 11;
        } catch (NoSuchFieldError unused11) {
        }
        try {
            f7893a[ib.Command.ordinal()] = 12;
        } catch (NoSuchFieldError unused12) {
        }
    }
}
