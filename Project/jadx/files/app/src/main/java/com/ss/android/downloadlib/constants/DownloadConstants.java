package com.ss.android.downloadlib.constants;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes3.dex */
public class DownloadConstants {

    /* JADX INFO: loaded from: classes.dex */
    @Retention(RetentionPolicy.SOURCE)
    public @interface DOWNLOAD_STATUS {
    }

    /* JADX INFO: loaded from: classes.dex */
    @Retention(RetentionPolicy.SOURCE)
    public @interface Message {
        public static final int FROM_DOWNLOADER = 3;
        public static final int QUICK_APP_BUTTON_CLICK = 4;
        public static final int QUICK_APP_ITEM_CLICK = 5;
        public static final int QUICK_APP_VIDEO_ITEM_CLICK = 7;
    }
}
