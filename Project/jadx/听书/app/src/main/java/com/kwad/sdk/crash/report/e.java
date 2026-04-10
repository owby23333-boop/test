package com.kwad.sdk.crash.report;

import com.kwad.sdk.crash.model.message.ExceptionMessage;
import java.io.File;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes4.dex */
public interface e {
    File Lm();

    void a(ExceptionMessage exceptionMessage, CountDownLatch countDownLatch);
}
