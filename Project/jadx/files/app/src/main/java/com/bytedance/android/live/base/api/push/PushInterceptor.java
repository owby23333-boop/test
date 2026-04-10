package com.bytedance.android.live.base.api.push;

/* JADX INFO: loaded from: classes2.dex */
public interface PushInterceptor {

    public static class InterceptResult {
        public final boolean intercept;
        public final String interceptReason;

        public InterceptResult(boolean z2) {
            this(z2, "");
        }

        public InterceptResult(boolean z2, String str) {
            this.intercept = z2;
            this.interceptReason = "";
        }
    }

    InterceptResult intercept();
}
