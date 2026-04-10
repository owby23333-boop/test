package com.alipay.sdk.m.l;

import com.alipay.sdk.app.OpenAuthTask;

/* JADX INFO: loaded from: classes.dex */
public enum c {
    SUCCEEDED(OpenAuthTask.OK, "处理成功"),
    FAILED(4000, "系统繁忙，请稍后再试"),
    CANCELED(6001, "用户取消"),
    NETWORK_ERROR(6002, "网络连接异常"),
    ACTIVITY_NOT_START_EXIT(6007, "支付未完成"),
    PARAMS_ERROR(OpenAuthTask.NOT_INSTALLED, "参数错误"),
    DOUBLE_REQUEST(5000, "重复请求"),
    PAY_WAITTING(8000, "支付结果确认中");


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1852a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f1853b;

    c(int i, String str) {
        this.f1852a = i;
        this.f1853b = str;
    }

    public void b(int i) {
        this.f1852a = i;
    }

    public int c() {
        return this.f1852a;
    }

    public void a(String str) {
        this.f1853b = str;
    }

    public String b() {
        return this.f1853b;
    }

    public static c a(int i) {
        if (i == 4001) {
            return PARAMS_ERROR;
        }
        if (i == 5000) {
            return DOUBLE_REQUEST;
        }
        if (i == 8000) {
            return PAY_WAITTING;
        }
        if (i == 9000) {
            return SUCCEEDED;
        }
        if (i == 6001) {
            return CANCELED;
        }
        if (i != 6002) {
            return FAILED;
        }
        return NETWORK_ERROR;
    }
}
