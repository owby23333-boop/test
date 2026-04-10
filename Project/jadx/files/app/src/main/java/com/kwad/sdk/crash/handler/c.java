package com.kwad.sdk.crash.handler;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.crash.f;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.kwai.e;
import java.io.File;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes3.dex */
public final class c extends b {

    static class a {
        private static final c aqO = new c(0);
    }

    private c() {
    }

    /* synthetic */ c(byte b) {
        this();
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x0221  */
    /* JADX WARN: Removed duplicated region for block: B:11:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x008c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:185:0x00b3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00b1 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x010b A[Catch: all -> 0x0199, TRY_LEAVE, TryCatch #16 {all -> 0x0199, blocks: (B:37:0x00fd, B:39:0x010b, B:27:0x00b3), top: B:185:0x00b3 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x011e A[Catch: all -> 0x0186, TryCatch #7 {all -> 0x0186, blocks: (B:40:0x0114, B:42:0x011e, B:44:0x0131, B:46:0x0138, B:48:0x0142, B:49:0x0150, B:51:0x0158, B:52:0x015b, B:54:0x0162, B:56:0x0167, B:58:0x016f, B:60:0x017c), top: B:168:0x0114 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01e0 A[Catch: all -> 0x0246, TryCatch #6 {all -> 0x0246, blocks: (B:92:0x01d6, B:94:0x01e0, B:96:0x01f3, B:98:0x01fa, B:100:0x0204, B:101:0x0212, B:103:0x021a, B:104:0x021d, B:106:0x0223, B:108:0x0228, B:110:0x0230, B:112:0x023d), top: B:167:0x01d6 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(@androidx.annotation.NonNull java.lang.Throwable r21, @androidx.annotation.NonNull com.kwad.sdk.crash.model.message.ExceptionMessage r22, @androidx.annotation.Nullable android.content.Context r23, boolean r24) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 709
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.crash.handler.c.a(java.lang.Throwable, com.kwad.sdk.crash.model.message.ExceptionMessage, android.content.Context, boolean):void");
    }

    public static c zZ() {
        return a.aqO;
    }

    public final void a(@NonNull Throwable th, @NonNull ExceptionMessage exceptionMessage, @Nullable Context context) throws Throwable {
        a(th, exceptionMessage, context, ((e) ServiceProvider.get(e.class)).getIsExternal());
    }

    @Override // com.kwad.sdk.crash.handler.b
    protected final int getCrashType() {
        return 1;
    }

    @Override // com.kwad.sdk.crash.handler.b
    public final void init(File file, f fVar, com.kwad.sdk.crash.report.e eVar) {
        super.init(file, fVar, eVar);
        if (com.kwad.sdk.crash.e.zJ().isDebug()) {
            b.initBackupDir(new File("sdcard/kwad_ex/java_crash/dump"));
        }
    }

    @Override // com.kwad.sdk.crash.handler.b
    protected final void reportException(@NonNull File[] fileArr, @Nullable CountDownLatch countDownLatch) {
        com.kwad.sdk.crash.report.f fVar = new com.kwad.sdk.crash.report.f();
        fVar.a(getUploader());
        for (File file : fileArr) {
            fVar.a(file, countDownLatch);
        }
    }
}
