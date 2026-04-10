package com.ss.android.downloadlib.addownload.model;

import com.ss.android.downloadad.api.download.AdDownloadEventConfig;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes3.dex */
public class OrderDownloadItem {
    public int b;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public AdDownloadModel f18004h;
    public long hj;
    public boolean ko;
    public String mb;
    public String ox;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public AdDownloadEventConfig f18005u;

    /* JADX INFO: loaded from: classes.dex */
    @Retention(RetentionPolicy.SOURCE)
    public @interface OrderCheckStatus {
        public static final int DELETE_LATE_ORDER = 5;
        public static final int INSTALLED = 2;
        public static final int NORMAL = 1;
        public static final int NO_WIFI_PARAM = 4;
        public static final int REPEAT_DOWNLOAD = 3;
    }

    /* JADX INFO: loaded from: classes.dex */
    @Retention(RetentionPolicy.SOURCE)
    public @interface OrderStatus {
        public static final int HANDLE_FAILED = -2;
        public static final int ORDERING = 0;
        public static final int ORDER_CANCEL = 2;
        public static final int ORDER_OVERDUE = 3;
        public static final int QUERY_FAILED = -1;
        public static final int SHELVED = 1;
    }

    public String toString() {
        return "OrderDownloadItem{bizType='" + this.mb + "', orderId='" + this.ox + "', orderStatus=" + this.b + ", nextRequestInterval=" + this.hj + ", downloadModel=" + this.f18004h + ", eventConfig=" + this.f18005u + ", enableDownload=" + this.ko + '}';
    }
}
