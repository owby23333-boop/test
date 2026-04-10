package com.kwad.sdk.crash.handler;

import com.kwad.sdk.crash.e;
import com.kwad.sdk.crash.model.message.CaughtExceptionMessage;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import com.kwad.sdk.crash.utils.g;
import java.util.ArrayList;
import java.util.UUID;

/* JADX INFO: loaded from: classes4.dex */
public final class a {
    public static void p(Throwable th) throws Throwable {
        CaughtExceptionMessage caughtExceptionMessage = new CaughtExceptionMessage();
        caughtExceptionMessage.mLogUUID = UUID.randomUUID().toString();
        caughtExceptionMessage.mCrashDetail = th.toString();
        caughtExceptionMessage.mCrashSource = 1;
        g.b(th, caughtExceptionMessage, e.Lr().getContext());
        g.a(caughtExceptionMessage, 2);
        a(caughtExceptionMessage);
        com.kwad.sdk.n.b.OQ().gG(caughtExceptionMessage.mCrashDetail);
    }

    private static void a(ExceptionMessage exceptionMessage) {
        com.kwad.sdk.core.d.c.d("AnrAndNativeAdExceptionCollector", "upload msg=" + exceptionMessage);
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(com.kwad.sdk.crash.report.request.c.d(exceptionMessage));
        com.kwad.sdk.crash.report.request.b.a(arrayList, null);
    }
}
