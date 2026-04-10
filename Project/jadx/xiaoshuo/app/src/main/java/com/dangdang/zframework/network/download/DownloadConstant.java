package com.dangdang.zframework.network.download;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes10.dex */
public class DownloadConstant {

    public enum DownloadType {
        BYTE,
        FILE,
        FILE_FROM_START
    }

    public enum Status {
        UNSTART("UNSTART"),
        WAIT("WAIT"),
        PENDING("PENDING"),
        DOWNLOADING("DOWNLOADING"),
        PAUSE("PAUSE"),
        RESUME("RESUME"),
        FINISH("FINISH"),
        FAILED("FAILED");

        public String status;

        Status(String str) {
            this.status = str;
        }

        public static Status convert(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return (Status) Enum.valueOf(Status.class, str);
        }

        public String getStatus() {
            return this.status;
        }
    }
}
