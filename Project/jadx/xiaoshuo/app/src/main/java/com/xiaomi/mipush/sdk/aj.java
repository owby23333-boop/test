package com.xiaomi.mipush.sdk;

import com.xiaomi.push.ib;

/* JADX INFO: loaded from: classes8.dex */
/* synthetic */ class aj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ int[] f7418a;

    static {
        int[] iArr = new int[ib.values().length];
        f7418a = iArr;
        try {
            iArr[ib.SendMessage.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f7418a[ib.Registration.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f7418a[ib.UnRegistration.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f7418a[ib.Subscription.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f7418a[ib.UnSubscription.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            f7418a[ib.Command.ordinal()] = 6;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            f7418a[ib.Notification.ordinal()] = 7;
        } catch (NoSuchFieldError unused7) {
        }
    }
}
