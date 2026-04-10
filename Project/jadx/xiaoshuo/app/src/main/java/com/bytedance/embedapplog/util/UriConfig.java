package com.bytedance.embedapplog.util;

/* JADX INFO: loaded from: classes.dex */
public class UriConfig {
    public static final String PATH_AB = "/service/2/abtest_config/";
    public static final String PATH_ACTIVE = "/service/2/app_alert_check/";
    public static final String PATH_CONFIG = "/service/2/log_settings/";
    public static final String PATH_REGISTER = "/service/2/device_register_only/";
    public static final String PATH_SEND = "/service/2/app_log/";
    private final String bf;
    private final String[] d;
    private final String e;
    private final String ga;
    private final String p;
    private final String[] tg;
    private final String v;
    private final String vn;

    public static class e {
        private String bf;
        private String[] d;
        private String e;
        private String ga;
        private String p;
        private String[] tg;
        private String v;
        private String vn;

        public e bf(String str) {
            this.bf = str;
            return this;
        }

        public e d(String str) {
            this.ga = str;
            return this;
        }

        public e e(String str) {
            this.e = str;
            return this;
        }

        public e ga(String str) {
            this.v = str;
            return this;
        }

        public e tg(String str) {
            this.vn = str;
            return this;
        }

        public e bf(String[] strArr) {
            this.tg = strArr;
            return this;
        }

        public e e(String[] strArr) {
            this.d = strArr;
            return this;
        }

        public UriConfig e() {
            return new UriConfig(this);
        }
    }

    public static UriConfig createByDomain(String str, String[] strArr) {
        e eVar = new e();
        eVar.e(str + PATH_REGISTER).bf(str + PATH_ACTIVE);
        if (strArr == null || strArr.length == 0) {
            eVar.e(new String[]{str + PATH_SEND});
        } else {
            int length = strArr.length + 1;
            String[] strArr2 = new String[length];
            strArr2[0] = str + PATH_SEND;
            for (int i = 1; i < length; i++) {
                strArr2[i] = strArr[i - 1] + PATH_SEND;
            }
            eVar.e(strArr2);
        }
        eVar.d(str + PATH_CONFIG).tg(str + PATH_AB);
        return eVar.e();
    }

    public static UriConfig createUriConfig(int i) {
        return com.bytedance.embedapplog.util.e.e(i);
    }

    public String getAbUri() {
        return this.vn;
    }

    public String getActiveUri() {
        return this.bf;
    }

    public String getMonitorUri() {
        return this.v;
    }

    public String getProfileUri() {
        return this.p;
    }

    public String[] getRealUris() {
        return this.tg;
    }

    public String getRegisterUri() {
        return this.e;
    }

    public String[] getSendUris() {
        return this.d;
    }

    public String getSettingUri() {
        return this.ga;
    }

    private UriConfig(e eVar) {
        this.e = eVar.e;
        this.bf = eVar.bf;
        this.d = eVar.d;
        this.tg = eVar.tg;
        this.ga = eVar.ga;
        this.vn = eVar.vn;
        this.p = eVar.p;
        this.v = eVar.v;
    }
}
