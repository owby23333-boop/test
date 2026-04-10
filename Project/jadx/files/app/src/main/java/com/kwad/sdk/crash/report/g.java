package com.kwad.sdk.crash.report;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import com.kwad.sdk.crash.model.message.MemoryInfo;
import com.kwad.sdk.crash.model.message.NativeExceptionMessage;
import com.kwad.sdk.crash.model.message.ThreadInfo;
import com.kwad.sdk.utils.p;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class g extends d {
    public static final Pattern arT = Pattern.compile("(.*)\\s\\(tid=(\\d+), index=(\\d+)*");
    public static final Pattern arU = Pattern.compile("\\sd+\\spc");

    private void a(NativeExceptionMessage nativeExceptionMessage, File file) {
        nativeExceptionMessage.mLogUUID = com.kwad.sdk.crash.utils.g.dE(file.getName());
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        boolean z2 = false;
        boolean z3 = false;
        while (true) {
            try {
                try {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        break;
                    }
                    if (z2 && line.startsWith("backtrace:")) {
                        z2 = false;
                        z3 = true;
                    } else if (z3) {
                        if (line.startsWith("###### ending of java stack trace ######")) {
                            break;
                        }
                        sb.append(line);
                        sb.append('\n');
                    } else if (z2) {
                        a(nativeExceptionMessage, line, sb2);
                    } else if (line.startsWith("*** ***")) {
                        z2 = true;
                    }
                } catch (IOException e2) {
                    this.mErrorMessage += e2 + "\n";
                }
            } finally {
                com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
            }
        }
        if (sb.length() > 1) {
            nativeExceptionMessage.mCrashDetail = sb.substring(0, sb.length() - 1);
        }
        if (sb2.length() > 1) {
            nativeExceptionMessage.mRegister = sb2.substring(0, sb2.length() - 1);
        }
    }

    private static void a(NativeExceptionMessage nativeExceptionMessage, String str, StringBuilder sb) {
        if (str.startsWith("Build fingerprint: ")) {
            nativeExceptionMessage.mFingerprint = str.substring(19);
            return;
        }
        if (str.startsWith("Revision: ")) {
            nativeExceptionMessage.mRevision = str.substring(10);
            return;
        }
        if (str.startsWith("ABI: ")) {
            nativeExceptionMessage.mAbi = str.substring(5);
            return;
        }
        if (str.startsWith("Current UTC: ")) {
            nativeExceptionMessage.mCurrentTimeStamp = Long.parseLong(str.substring(13));
            return;
        }
        if (str.startsWith("Abort message: ")) {
            nativeExceptionMessage.mAbortMsg = str.substring(15);
            return;
        }
        if (str.startsWith("    r") || str.startsWith("    ip") || str.startsWith("    x") || str.startsWith("    sp")) {
            sb.append(str);
            sb.append('\n');
            return;
        }
        if (!str.startsWith("pid: ")) {
            if (str.startsWith("signal ")) {
                String[] strArrSplit = str.split("\\s+");
                if (strArrSplit.length >= 9) {
                    nativeExceptionMessage.mSignal = com.kwad.sdk.crash.utils.g.dF(strArrSplit[2]);
                    nativeExceptionMessage.mCode = com.kwad.sdk.crash.utils.g.dF(strArrSplit[5]);
                    nativeExceptionMessage.mFaultAddr = strArrSplit[strArrSplit.length - 1];
                    nativeExceptionMessage.mManuallyKill = "--------".equals(strArrSplit[strArrSplit.length + (-1)]) ? "True" : "False";
                    return;
                }
                return;
            }
            return;
        }
        String[] strArrSplit2 = str.split("\\s+");
        if (strArrSplit2.length < 9) {
            return;
        }
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < strArrSplit2.length; i5++) {
            if ("name:".equals(strArrSplit2[i5])) {
                i2 = i5;
            } else if (">>>".equals(strArrSplit2[i5])) {
                i3 = i5;
            } else if ("<<<".equals(strArrSplit2[i5])) {
                i4 = i5;
            }
        }
        StringBuilder sb2 = new StringBuilder();
        int i6 = i2 + 1;
        String str2 = strArrSplit2[i6];
        while (true) {
            sb2.append(str2);
            i6++;
            if (i6 >= i3) {
                break;
            }
            sb2.append(" ");
            str2 = strArrSplit2[i6];
        }
        nativeExceptionMessage.mThreadName = sb2.toString();
        sb2.setLength(0);
        int i7 = i3 + 1;
        String str3 = strArrSplit2[i7];
        while (true) {
            sb2.append(str3);
            i7++;
            if (i7 >= i4) {
                nativeExceptionMessage.mProcessName = sb2.toString();
                return;
            } else {
                sb2.append(" ");
                str3 = strArrSplit2[i7];
            }
        }
    }

    private static void c(File file, ExceptionMessage exceptionMessage) {
        try {
            MemoryInfo memoryInfo = new MemoryInfo(exceptionMessage.mMemoryInfo);
            ArrayList arrayList = new ArrayList();
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            try {
                try {
                    ThreadInfo threadInfo = new ThreadInfo();
                    while (true) {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            break;
                        }
                        if (line.isEmpty()) {
                            arrayList.add(threadInfo);
                            threadInfo = new ThreadInfo();
                        } else if (arU.matcher(line).matches()) {
                            if (threadInfo.mTrace != null) {
                                line = threadInfo.mTrace + line;
                            }
                            threadInfo.mTrace = line;
                            threadInfo.mTrace += "\n";
                        } else {
                            Matcher matcher = arT.matcher(line);
                            if (matcher.lookingAt()) {
                                threadInfo.mName = matcher.group(1);
                                threadInfo.mTid = Integer.parseInt(matcher.group(2));
                                threadInfo.mIndex = Integer.parseInt(matcher.group(3));
                            }
                        }
                    }
                    memoryInfo.mNativeThreads = arrayList;
                    exceptionMessage.mMemoryInfo = memoryInfo.toJson().toString();
                } catch (IOException e2) {
                    com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
                }
            } finally {
                com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
            }
        } catch (Exception e3) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e3);
        }
    }

    private NativeExceptionMessage y(File file) {
        String strQ;
        try {
            strQ = p.Q(file);
        } catch (IOException e2) {
            this.mErrorMessage += e2 + "\n";
            strQ = null;
        }
        NativeExceptionMessage nativeExceptionMessage = new NativeExceptionMessage();
        if (strQ != null) {
            try {
                nativeExceptionMessage.parseJson(new JSONObject(strQ));
            } catch (Exception e3) {
                this.mErrorMessage += e3 + "\n";
            }
        }
        p.N(file);
        return nativeExceptionMessage;
    }

    @Override // com.kwad.sdk.crash.report.d
    protected final ExceptionMessage a(@NonNull File file, File file2, File file3, String str) throws Throwable {
        File file4 = new File(str + ".jtrace");
        NativeExceptionMessage nativeExceptionMessageY = y(file2);
        try {
            a(nativeExceptionMessageY, file);
            b(file3, nativeExceptionMessageY);
            d.a(file4, nativeExceptionMessageY);
            c(new File(str + ".ntrace"), nativeExceptionMessageY);
            com.kwad.sdk.crash.utils.g.a(file, (CharSequence) nativeExceptionMessageY.toString(), true);
            com.kwad.sdk.crash.utils.g.b(file3, file);
            file.renameTo(file3);
            new StringBuilder("------ Native Crash Report Begin ------\n").append(nativeExceptionMessageY);
            nativeExceptionMessageY.mDumpsys = p.Q(new File(str + ".minfo"));
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
            this.mErrorMessage += e2 + "\n";
        }
        if (!TextUtils.isEmpty(this.mErrorMessage)) {
            nativeExceptionMessageY.mErrorMessage += this.mErrorMessage;
        }
        return nativeExceptionMessageY;
    }
}
