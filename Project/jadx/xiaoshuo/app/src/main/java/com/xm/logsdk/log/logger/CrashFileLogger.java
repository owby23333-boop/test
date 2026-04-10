package com.xm.logsdk.log.logger;

import com.xm.logsdk.log.logger.lib.LogFileBean;
import com.xm.logsdk.log.logger.lib.thread.IMessageThread;

/* JADX INFO: loaded from: classes8.dex */
public class CrashFileLogger extends BootRollingFileLogger {
    public static final String prefix = "crash";

    public CrashFileLogger(LogFileBean logFileBean, IMessageThread<String> iMessageThread) {
        super(logFileBean, iMessageThread);
    }

    @Override // com.xm.logsdk.log.logger.lib.AppenderSkeleton
    public boolean filter(int i, String str, StringBuilder sb) {
        return str == null || !str.endsWith("crash");
    }
}
