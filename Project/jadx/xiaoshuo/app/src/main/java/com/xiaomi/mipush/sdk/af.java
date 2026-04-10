package com.xiaomi.mipush.sdk;

import com.xiaomi.push.ib;

/* JADX INFO: loaded from: classes8.dex */
/* synthetic */ class af {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ int[] f7415a;

    static {
        int[] iArr = new int[ib.values().length];
        f7415a = iArr;
        try {
            iArr[ib.Registration.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f7415a[ib.UnRegistration.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f7415a[ib.Subscription.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f7415a[ib.UnSubscription.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f7415a[ib.SendMessage.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            f7415a[ib.AckMessage.ordinal()] = 6;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            f7415a[ib.SetConfig.ordinal()] = 7;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            f7415a[ib.ReportFeedback.ordinal()] = 8;
        } catch (NoSuchFieldError unused8) {
        }
        try {
            f7415a[ib.Notification.ordinal()] = 9;
        } catch (NoSuchFieldError unused9) {
        }
        try {
            f7415a[ib.Command.ordinal()] = 10;
        } catch (NoSuchFieldError unused10) {
        }
    }
}
