package com.bytedance.mapplog.util;

import com.bytedance.mapplog.util.a;

/* JADX INFO: loaded from: classes2.dex */
public class b {
    private static final a a;

    static {
        new a.b().a("https://log.snssdk.com/service/2/device_register_only/").b("https://ichannel.snssdk.com/service/2/app_alert_check/").a(new String[]{"https://log.snssdk.com/service/2/app_log/", "https://applog.snssdk.com/service/2/app_log/"}).b(new String[]{"https://rtlog.snssdk.com/service/2/app_log/", "https://rtapplog.snssdk.com/service/2/app_log/"}).c("https://log.snssdk.com/service/2/log_settings/").a();
        a = new a.b().a("https://toblog.ctobsnssdk.com/service/2/device_register_only/").b("https://toblog.ctobsnssdk.com/service/2/app_alert_check/").a(new String[]{"https://toblog.ctobsnssdk.com/service/2/app_log/", "https://tobapplog.ctobsnssdk.com/service/2/app_log/"}).c("https://toblog.ctobsnssdk.com/service/2/log_settings/").d("https://toblog.ctobsnssdk.com/service/2/abtest_config/").e("https://success.ctobsnssdk.com/service/2/app_log/").a();
    }

    public static final a a(int i2) {
        return a;
    }
}
