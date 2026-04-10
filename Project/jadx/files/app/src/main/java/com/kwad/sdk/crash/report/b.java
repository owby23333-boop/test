package com.kwad.sdk.crash.report;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.sdk.crash.model.message.AnrExceptionMessage;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import com.kwad.sdk.utils.p;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends d {
    private void a(AnrExceptionMessage anrExceptionMessage, File file) throws Throwable {
        String str;
        anrExceptionMessage.mLogUUID = com.kwad.sdk.crash.utils.g.dE(file.getName());
        anrExceptionMessage.mIndex = com.kwad.sdk.crash.utils.g.getIndex(anrExceptionMessage.mLogUUID);
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        BufferedReader bufferedReader = null;
        try {
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file));
                boolean z2 = false;
                while (true) {
                    try {
                        String line = bufferedReader2.readLine();
                        if (line == null) {
                            break;
                        }
                        if (!z2 && line.startsWith("\"main\" prio")) {
                            sb2.append(line);
                            sb2.append('\n');
                            String[] strArrSplit = line.split("\\s+");
                            anrExceptionMessage.mThreadStatus = strArrSplit[strArrSplit.length - 1];
                            z2 = true;
                        } else if (!z2) {
                            continue;
                        } else {
                            if (line.length() == 0) {
                                break;
                            }
                            if (line.startsWith("  |")) {
                                sb2.append(line);
                                sb2.append('\n');
                            } else {
                                sb.append(line);
                                sb.append('\n');
                            }
                        }
                    } catch (FileNotFoundException e2) {
                        e = e2;
                        bufferedReader = bufferedReader2;
                        str = this.mErrorMessage + e + "\n";
                        this.mErrorMessage = str;
                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                    } catch (IOException e3) {
                        e = e3;
                        bufferedReader = bufferedReader2;
                        str = this.mErrorMessage + e + "\n";
                        this.mErrorMessage = str;
                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader = bufferedReader2;
                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                        throw th;
                    }
                }
                com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader2);
            } catch (FileNotFoundException e4) {
                e = e4;
            } catch (IOException e5) {
                e = e5;
            }
            if (sb.length() > 1) {
                anrExceptionMessage.mCrashDetail = sb.substring(0, sb.length() - 1);
            }
            if (TextUtils.isEmpty(anrExceptionMessage.mCrashDetail)) {
                anrExceptionMessage.mCrashSource = 0;
            } else if (dz(anrExceptionMessage.mCrashDetail)) {
                anrExceptionMessage.mCrashSource = 1;
            } else {
                anrExceptionMessage.mCrashSource = 2;
            }
            com.kwad.sdk.core.d.b.d("AnrReporter", " message.mCrashSource=" + anrExceptionMessage.mCrashSource + "message.mCrashDetail = " + anrExceptionMessage.mCrashDetail);
            if (sb2.length() > 1) {
                anrExceptionMessage.mThreadDetail = sb2.substring(0, sb2.length() - 1);
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private String dy(String str) {
        File file = new File(str + ".anr");
        String strQ = "";
        if (file.exists()) {
            try {
                strQ = p.Q(file);
            } catch (IOException e2) {
                this.mErrorMessage += e2 + "\n";
            }
            p.N(file);
        }
        return strQ;
    }

    private static boolean dz(@NonNull String str) {
        for (String str2 : com.kwad.sdk.crash.e.zJ().zK()) {
            if (str.contains(str2)) {
                com.kwad.sdk.core.d.b.d("AnrReporter", " tag=" + str2);
                return true;
            }
        }
        return false;
    }

    private AnrExceptionMessage w(File file) {
        String strQ;
        try {
            strQ = p.Q(file);
        } catch (IOException e2) {
            this.mErrorMessage += e2 + "\n";
            strQ = null;
        }
        AnrExceptionMessage anrExceptionMessage = new AnrExceptionMessage();
        if (strQ != null) {
            try {
                anrExceptionMessage.parseJson(new JSONObject(strQ));
            } catch (Exception e3) {
                this.mErrorMessage += e3 + "\n";
            }
        }
        p.N(file);
        return anrExceptionMessage;
    }

    @Override // com.kwad.sdk.crash.report.d
    protected final ExceptionMessage a(@NonNull File file, File file2, File file3, String str) throws Throwable {
        com.kwad.sdk.core.d.b.d("AnrReporter", "AnrReporter parseExceptionInfo basePath=" + str);
        AnrExceptionMessage anrExceptionMessageW = w(file2);
        try {
            anrExceptionMessageW.mReason = dy(str);
            a(anrExceptionMessageW, file);
            b(file3, anrExceptionMessageW);
            com.kwad.sdk.crash.utils.g.a(file, (CharSequence) anrExceptionMessageW.toString(), true);
            com.kwad.sdk.crash.utils.g.b(file3, file);
            file.renameTo(file3);
            new StringBuilder("------ ANR Report Begin ------\n").append(anrExceptionMessageW);
            anrExceptionMessageW.mDumpsys = p.Q(new File(str + ".minfo"));
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
            this.mErrorMessage += e2 + "\n";
        }
        if (!TextUtils.isEmpty(this.mErrorMessage)) {
            anrExceptionMessageW.mErrorMessage += this.mErrorMessage;
        }
        return anrExceptionMessageW;
    }
}
