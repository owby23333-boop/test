package com.liulishuo.filedownloader.exception;

import com.liulishuo.filedownloader.h0.f;

/* JADX INFO: loaded from: classes3.dex */
public class PathConflictException extends IllegalAccessException {
    public PathConflictException(int i2, String str, String str2) {
        super(f.a("There is an another running task(%d) with the same downloading path(%s), because of they are with the same target-file-path(%s), so if the current task is started, the path of the file is sure to be written by multiple tasks, it is wrong, then you receive this exception to avoid such conflict.", Integer.valueOf(i2), str, str2));
    }
}
