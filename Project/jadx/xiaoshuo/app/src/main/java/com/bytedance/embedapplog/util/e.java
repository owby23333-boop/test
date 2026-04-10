package com.bytedance.embedapplog.util;

import com.bytedance.embedapplog.util.UriConfig;

/* JADX INFO: loaded from: classes.dex */
public class e {
    private static final UriConfig e = new UriConfig.e().e("https://log.snssdk.com/service/2/device_register_only/").bf("https://ichannel.snssdk.com/service/2/app_alert_check/").e(new String[]{"https://log.snssdk.com/service/2/app_log/", "https://applog.snssdk.com/service/2/app_log/"}).bf(new String[]{"https://rtlog.snssdk.com/service/2/app_log/", "https://rtapplog.snssdk.com/service/2/app_log/"}).d("https://log.snssdk.com/service/2/log_settings/").e();
    private static final UriConfig bf = new UriConfig.e().e("https://toblog.ctobsnssdk.com/service/2/device_register_only/").bf("https://toblog.ctobsnssdk.com/service/2/app_alert_check/").e(new String[]{"https://toblog.ctobsnssdk.com/service/2/app_log/", "https://tobapplog.ctobsnssdk.com/service/2/app_log/"}).d("https://toblog.ctobsnssdk.com/service/2/log_settings/").tg("https://toblog.ctobsnssdk.com/service/2/abtest_config/").ga("https://success.ctobsnssdk.com/service/2/app_log/").e();

    public static final UriConfig e(int i) {
        return bf;
    }
}
