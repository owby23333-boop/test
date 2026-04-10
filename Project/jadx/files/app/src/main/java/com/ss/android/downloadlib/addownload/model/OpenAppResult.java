package com.ss.android.downloadlib.addownload.model;

/* JADX INFO: loaded from: classes3.dex */
public class OpenAppResult {

    @Source
    private String b;

    @Type
    private int mb;

    @Message
    private int ox;

    /* JADX INFO: loaded from: classes.dex */
    public @interface Message {
        public static final int DEFAULT_MARKET_UNINSTALLED = 15;
        public static final int LAUNCH_INTENT_NOT_EXIST = 22;
        public static final int MARKET_UNINSTALLED = 13;
        public static final int OPEN_URL_INVALID = 24;
        public static final int OPEN_URL_NOT_EXIST = 21;
        public static final int PACKAGE_NAME_EMPTY = 11;
        public static final int START_ACTIVITY_EXCEPTION = 23;
        public static final int START_EXCEPTION = 14;
        public static final int TEST_FAILED = 25;
        public static final int URI_ERROR = 12;
    }

    /* JADX INFO: loaded from: classes.dex */
    public @interface Source {
        public static final String AM_HW = "am_hw";
        public static final String AM_KLLK1 = "am_kllk1";
        public static final String AM_KLLK2 = "am_kllk2";
        public static final String AM_M1 = "am_m1";
        public static final String AM_M2 = "am_m2";
        public static final String AM_V1 = "am_v1";
    }

    /* JADX INFO: loaded from: classes.dex */
    public @interface Type {
        public static final int FAILED_BY_PACKAGE = 4;
        public static final int FAILED_BY_URL = 2;
        public static final int FAILED_MARKET = 6;
        public static final int IGNORE_MARKET = 7;
        public static final int NONE = 0;
        public static final int SUCCESS_BY_PACKAGE = 3;
        public static final int SUCCESS_BY_URL = 1;
        public static final int SUCCESS_MARKET = 5;
    }

    public OpenAppResult(@Type int i2) {
        this(i2, 0, null);
    }

    public int getType() {
        return this.mb;
    }

    public int mb() {
        return this.ox;
    }

    public String ox() {
        return this.b;
    }

    public OpenAppResult(@Type int i2, @Message int i3) {
        this(i2, i3, null);
    }

    public OpenAppResult(@Type int i2, @Source String str) {
        this(i2, 0, str);
    }

    public OpenAppResult(@Type int i2, @Message int i3, @Source String str) {
        this.mb = i2;
        this.ox = i3;
        this.b = str;
    }
}
