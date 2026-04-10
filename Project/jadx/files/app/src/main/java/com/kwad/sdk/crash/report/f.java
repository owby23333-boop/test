package com.kwad.sdk.crash.report;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import com.kwad.sdk.crash.model.message.JavaExceptionMessage;
import com.kwad.sdk.utils.p;
import java.io.File;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class f extends d {
    @Override // com.kwad.sdk.crash.report.d
    protected final ExceptionMessage a(@NonNull File file, File file2, File file3, String str) {
        String strQ;
        JavaExceptionMessage javaExceptionMessage;
        Exception e2;
        try {
            strQ = p.Q(file);
        } catch (Exception e3) {
            this.mErrorMessage += e3 + "\n";
            strQ = null;
        }
        if (strQ != null) {
            try {
                javaExceptionMessage = new JavaExceptionMessage();
            } catch (Exception e4) {
                javaExceptionMessage = null;
                e2 = e4;
            }
            try {
                javaExceptionMessage.parseJson(new JSONObject(strQ));
            } catch (Exception e5) {
                e2 = e5;
                this.mErrorMessage += e2 + "\n";
            }
        } else {
            javaExceptionMessage = null;
        }
        if (javaExceptionMessage == null) {
            javaExceptionMessage = new JavaExceptionMessage();
            if (!TextUtils.isEmpty(strQ)) {
                javaExceptionMessage.mCrashDetail = strQ;
            }
        }
        try {
            javaExceptionMessage.mLogUUID = com.kwad.sdk.crash.utils.g.dE(file.getName());
            new StringBuilder("------ Java Crash Report Begin ------\n").append(javaExceptionMessage);
            d.a(new File(str + ".jtrace"), javaExceptionMessage);
            b(file3, javaExceptionMessage);
            com.kwad.sdk.crash.utils.g.a(file, javaExceptionMessage.toString());
            com.kwad.sdk.crash.utils.g.b(file3, file);
            file.renameTo(file3);
            javaExceptionMessage.mDumpsys = p.Q(new File(str + ".minfo"));
        } catch (Throwable th) {
            this.mErrorMessage += th + "\n";
            com.kwad.sdk.core.d.b.printStackTraceOnly(th);
        }
        if (!TextUtils.isEmpty(this.mErrorMessage)) {
            javaExceptionMessage.mErrorMessage += this.mErrorMessage;
        }
        return javaExceptionMessage;
    }
}
