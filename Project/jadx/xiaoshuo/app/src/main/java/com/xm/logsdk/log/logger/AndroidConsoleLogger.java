package com.xm.logsdk.log.logger;

import android.text.TextUtils;
import android.util.Log;
import com.xm.logsdk.log.logger.lib.Logger;

/* JADX INFO: loaded from: classes8.dex */
public class AndroidConsoleLogger implements Logger {
    private static final int MAX_CHAR_SIZE_PER_LOG = 3000;
    private final String TAG = "MI_TAG";

    private static void logToSystemLog(int i, String str, StringBuilder sb) {
        if (TextUtils.isEmpty(sb) || sb.length() <= 3000) {
            Log.println(i, str, sb.toString());
            return;
        }
        int length = sb.length();
        int i2 = length / 3000;
        int i3 = 0;
        while (i3 <= i2) {
            int i4 = i3 * 3000;
            i3++;
            int iMin = Math.min(length, i3 * 3000);
            if (i4 < iMin) {
                Log.println(i, str, sb.substring(i4, iMin));
            }
        }
    }

    @Override // com.xm.logsdk.log.logger.lib.Logger
    public void append(int i, String str, StringBuilder sb) {
        logToSystemLog(i, str, sb);
    }

    @Override // com.xm.logsdk.log.logger.lib.Logger
    public void close() {
    }

    @Override // com.xm.logsdk.log.logger.lib.Logger
    public void flush() {
    }

    @Override // com.xm.logsdk.log.logger.lib.Logger
    public boolean isFileExist(boolean z) {
        return false;
    }

    @Override // com.xm.logsdk.log.logger.lib.Logger
    public void writeFooter() {
    }

    @Override // com.xm.logsdk.log.logger.lib.Logger
    public void writeHeader() {
    }

    @Override // com.xm.logsdk.log.logger.lib.Logger
    public void append(StringBuilder sb) {
        logToSystemLog(4, "MI_TAG", sb);
    }
}
