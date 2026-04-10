package com.chinaums.pppay.unify;

/* JADX INFO: loaded from: classes10.dex */
public interface UnifyPayListener {
    public static final String ERR_AUTH_DENIED = "005";
    public static final String ERR_BAN = "007";
    public static final String ERR_CLIENT_UNINSTALL = "1003";
    public static final String ERR_COMM = "9999";
    public static final String ERR_OK = "0000";
    public static final String ERR_ORDER_DUPLICATE = "2002";
    public static final String ERR_ORDER_PROCESS = "2001";
    public static final String ERR_PARARM = "1001";
    public static final String ERR_PAY_FAIL = "2003";
    public static final String ERR_SENT_FAILED = "1002";
    public static final String ERR_UNSUPPORT = "006";
    public static final String ERR_USER_CANCEL = "1000";

    void onResult(String str, String str2);
}
