package com.kwad.sdk.crash.report;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.report.q;
import com.kwad.sdk.crash.model.message.ExceptionMessage;

/* JADX INFO: loaded from: classes3.dex */
public final class a {
    public static void b(@NonNull ExceptionMessage exceptionMessage) {
        q qVar = new q(10211L);
        qVar.errorMsg = exceptionMessage.getReportMsg();
        com.kwad.sdk.core.report.h.a(qVar);
    }
}
