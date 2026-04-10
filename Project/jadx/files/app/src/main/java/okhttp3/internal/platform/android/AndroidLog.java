package okhttp3.internal.platform.android;

import android.util.Log;
import com.baidu.mobads.sdk.internal.bq;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.Metadata;
import kotlin.collections.y;
import kotlin.text.p;
import okhttp3.OkHttpClient;
import okhttp3.internal.SuppressSignatureCheck;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.http2.Http2;

/* JADX INFO: compiled from: AndroidLog.kt */
/* JADX INFO: loaded from: classes3.dex */
@SuppressSignatureCheck
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J/\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0000¢\u0006\u0002\b\u0012J\u0006\u0010\u0013\u001a\u00020\fJ\u0018\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\nH\u0002J\u0010\u0010\u0017\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\nH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lokhttp3/internal/platform/android/AndroidLog;", "", "()V", "MAX_LOG_LENGTH", "", "configuredLoggers", "Ljava/util/concurrent/CopyOnWriteArraySet;", "Ljava/util/logging/Logger;", "knownLoggers", "", "", "androidLog", "", "loggerName", "logLevel", "message", "t", "", "androidLog$okhttp", "enable", "enableLogging", bq.a, "tag", "loggerTag", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class AndroidLog {
    private static final int MAX_LOG_LENGTH = 4000;
    private static final Map<String, String> knownLoggers;
    public static final AndroidLog INSTANCE = new AndroidLog();
    private static final CopyOnWriteArraySet<Logger> configuredLoggers = new CopyOnWriteArraySet<>();

    static {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Package r1 = OkHttpClient.class.getPackage();
        String name = r1 != null ? r1.getName() : null;
        if (name != null) {
            linkedHashMap.put(name, "OkHttp");
        }
        linkedHashMap.put(OkHttpClient.class.getName(), "okhttp.OkHttpClient");
        linkedHashMap.put(Http2.class.getName(), "okhttp.Http2");
        linkedHashMap.put(TaskRunner.class.getName(), "okhttp.TaskRunner");
        linkedHashMap.put("okhttp3.mockwebserver.MockWebServer", "okhttp.MockWebServer");
        knownLoggers = y.c(linkedHashMap);
    }

    private AndroidLog() {
    }

    private final void enableLogging(String logger, String tag) {
        Logger logger2 = Logger.getLogger(logger);
        if (configuredLoggers.add(logger2)) {
            logger2.setUseParentHandlers(false);
            logger2.setLevel(Log.isLoggable(tag, 3) ? Level.FINE : Log.isLoggable(tag, 4) ? Level.INFO : Level.WARNING);
            logger2.addHandler(AndroidLogHandler.INSTANCE);
        }
    }

    private final String loggerTag(String loggerName) {
        String str = knownLoggers.get(loggerName);
        return str != null ? str : p.b(loggerName, 23);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x004c, code lost:
    
        r11 = r1 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void androidLog$okhttp(@org.jetbrains.annotations.NotNull java.lang.String r8, int r9, @org.jetbrains.annotations.NotNull java.lang.String r10, @org.jetbrains.annotations.Nullable java.lang.Throwable r11) {
        /*
            r7 = this;
            java.lang.String r8 = r7.loggerTag(r8)
            boolean r0 = android.util.Log.isLoggable(r8, r9)
            if (r0 == 0) goto L59
            if (r11 == 0) goto L24
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r10)
            java.lang.String r10 = "\n"
            r0.append(r10)
            java.lang.String r10 = android.util.Log.getStackTraceString(r11)
            r0.append(r10)
            java.lang.String r10 = r0.toString()
        L24:
            r11 = 0
            int r6 = r10.length()
        L29:
            if (r11 >= r6) goto L59
            r1 = 10
            r3 = 0
            r4 = 4
            r5 = 0
            r0 = r10
            r2 = r11
            int r0 = kotlin.text.f.a(r0, r1, r2, r3, r4, r5)
            r1 = -1
            if (r0 == r1) goto L3a
            goto L3b
        L3a:
            r0 = r6
        L3b:
            int r1 = r11 + 4000
            int r1 = java.lang.Math.min(r0, r1)
            if (r10 == 0) goto L51
            java.lang.String r11 = r10.substring(r11, r1)
            android.util.Log.println(r9, r8, r11)
            if (r1 < r0) goto L4f
            int r11 = r1 + 1
            goto L29
        L4f:
            r11 = r1
            goto L3b
        L51:
            java.lang.NullPointerException r8 = new java.lang.NullPointerException
            java.lang.String r9 = "null cannot be cast to non-null type java.lang.String"
            r8.<init>(r9)
            throw r8
        L59:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.platform.android.AndroidLog.androidLog$okhttp(java.lang.String, int, java.lang.String, java.lang.Throwable):void");
    }

    public final void enable() {
        for (Map.Entry<String, String> entry : knownLoggers.entrySet()) {
            enableLogging(entry.getKey(), entry.getValue());
        }
    }
}
