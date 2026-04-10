package com.xm.logsdk.log.logger.lib;

/* JADX INFO: loaded from: classes8.dex */
public interface Logger {
    void append(int i, String str, StringBuilder sb);

    void append(StringBuilder sb);

    void close();

    void flush();

    boolean isFileExist(boolean z);

    void writeFooter();

    void writeHeader();
}
