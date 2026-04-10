package com.ss.android.downloadlib.exception;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
@Retention(RetentionPolicy.SOURCE)
public @interface MonitorErrorCode {
    public static final int DOWNLOAD_BUTTON_LISTENER_GC = 7;
    public static final int EXEC_PATH_ERROR = 1;
    public static final int EXEC_PATH_RECORD = 3;
    public static final int INSTALL_GUIDE_ERROR = 6;
    public static final int JSON_EXCEPTION = 8;
    public static final int MIUI_SILENT_INSTALL_FAILED = 5;
    public static final int MIUI_SILENT_INSTALL_SUCCEED = 4;
    public static final int START_DOWNLOAD_FAILED = 2;
}
