package com.xiaomi.verificationsdk.internal;

/* JADX INFO: loaded from: classes8.dex */
public class VerifyError {
    private int code;
    private int dialogMsgId;
    private String msg;

    public static class Build {
        private int code;
        private int dialogMsgId;
        private String msg;

        public VerifyError build() {
            return new VerifyError(this);
        }

        public Build code(int i) {
            this.code = i;
            return this;
        }

        public Build dialogMsg(int i) {
            this.dialogMsgId = i;
            return this;
        }

        public Build msg(String str) {
            this.msg = str;
            return this;
        }
    }

    public VerifyError(Build build) {
        this.code = build.code;
        this.msg = build.msg;
        this.dialogMsgId = build.dialogMsgId;
    }

    public int getCode() {
        return this.code;
    }

    public int getDialogMsgId() {
        return this.dialogMsgId;
    }

    public String getMsg() {
        return this.msg;
    }
}
