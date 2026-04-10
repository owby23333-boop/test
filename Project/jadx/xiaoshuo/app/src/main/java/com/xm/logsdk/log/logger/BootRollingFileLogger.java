package com.xm.logsdk.log.logger;

import com.xm.logsdk.log.LogzConfig;
import com.xm.logsdk.log.logger.lib.FileAppender;
import com.xm.logsdk.log.logger.lib.LogFileBean;
import com.xm.logsdk.log.logger.lib.thread.IMessageThread;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/* JADX INFO: loaded from: classes8.dex */
public class BootRollingFileLogger extends FileAppender {
    private String datePattern;
    private SimpleDateFormat sdf;

    public BootRollingFileLogger(LogFileBean logFileBean, IMessageThread<String> iMessageThread) {
        super(logFileBean);
        this.datePattern = "'.'yyyy-MM-dd";
        setMessageThread(iMessageThread);
        activateOptions();
    }

    @Override // com.xm.logsdk.log.logger.lib.FileAppender, com.xm.logsdk.log.logger.lib.AppenderSkeleton
    public void activateOptions() {
        if (this.datePattern == null || this.mLogFileBean.getFileName() == null) {
            log("Either File or DatePattern options are not set for appender [" + this.name + "].");
        } else {
            this.sdf = new SimpleDateFormat(this.datePattern);
            String str = this.mLogFileBean.getFileName() + this.sdf.format(new Date()) + LogzConfig.sFileSuffix;
            File file = new File(str);
            if (file.exists()) {
                renameFile(str, this.mLogFileBean.getFileName() + this.sdf.format(new Date(file.lastModified())) + LogzConfig.sFileSuffix);
            }
            setFile(str);
        }
        super.activateOptions();
    }

    public void renameFile(String str, String str2) {
        try {
            File file = new File(str2);
            int i = 0;
            while (file.exists()) {
                i++;
                file = new File(str2 + "_" + i);
            }
            if (new File(str).renameTo(file)) {
                log(str + " ->>> " + str2);
                return;
            }
            log("Failed to rename [" + str + "] to [" + str2 + "].");
        } catch (Exception e) {
            loge(e.getMessage(), e);
        }
    }
}
