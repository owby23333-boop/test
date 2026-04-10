package com.chinaums.pppay.unify;

/* JADX INFO: loaded from: classes10.dex */
public class UnifyPayRequest {
    public static final String APPID_NO_SET = "appid或跳转路径未配置请联系客户经理";
    public static final String APP_SCHEME_NOT_OK = "appScheme配置不合规范请联系客户经理";
    public static final String APP_SCHEME_NO_SET = "appScheme未配置请联系客户经理";
    public static final String CHANNEL_ALIPAY = "02";
    public static final String CHANNEL_ALIPAY_MINI_PROGRAM = "04";
    public static final String CHANNEL_UMSPAY = "03";
    public static final String CHANNEL_WEIXIN = "01";
    public static final String KEY_APPID = "appid";
    public static final String KEY_NONCESTR = "noncestr";
    public static final String KEY_PACKAGE = "package";
    public static final String KEY_PARTNERID = "partnerid";
    public static final String KEY_PREPAYID = "prepayid";
    public static final String KEY_QRCODE = "qrCode";
    public static final String KEY_SIGN = "sign";
    public static final String KEY_TIMESTAMP = "timestamp";
    public String payChannel = CHANNEL_WEIXIN;
    public String payData;
}
