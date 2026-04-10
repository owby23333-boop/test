package anet.channel;

import android.text.TextUtils;
import anet.channel.entity.ENV;
import anet.channel.security.ISecurity;
import anet.channel.util.ALog;
import anet.channel.util.StringUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
public final class Config {
    private String b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f228c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ENV f229d = ENV.ONLINE;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ISecurity f230e;
    private static Map<String, Config> a = new HashMap();
    public static final Config DEFAULT_CONFIG = new Builder().setTag("[default]").setAppkey("[default]").setEnv(ENV.ONLINE).build();

    /* JADX INFO: compiled from: Taobao */
    public static class Builder {
        private String a;
        private String b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private ENV f231c = ENV.ONLINE;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f232d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private String f233e;

        public Config build() {
            if (TextUtils.isEmpty(this.b)) {
                throw new RuntimeException("appkey can not be null or empty!");
            }
            synchronized (Config.a) {
                for (Config config : Config.a.values()) {
                    if (config.f229d == this.f231c && config.f228c.equals(this.b)) {
                        ALog.w("awcn.Config", "duplicated config exist!", null, "appkey", this.b, "env", this.f231c);
                        if (!TextUtils.isEmpty(this.a)) {
                            Config.a.put(this.a, config);
                        }
                        return config;
                    }
                }
                Config config2 = new Config();
                config2.f228c = this.b;
                config2.f229d = this.f231c;
                if (TextUtils.isEmpty(this.a)) {
                    config2.b = StringUtils.concatString(this.b, "$", this.f231c.toString());
                } else {
                    config2.b = this.a;
                }
                if (TextUtils.isEmpty(this.f233e)) {
                    config2.f230e = anet.channel.security.c.a().createSecurity(this.f232d);
                } else {
                    config2.f230e = anet.channel.security.c.a().createNonSecurity(this.f233e);
                }
                synchronized (Config.a) {
                    Config.a.put(config2.b, config2);
                }
                return config2;
            }
        }

        public Builder setAppSecret(String str) {
            this.f233e = str;
            return this;
        }

        public Builder setAppkey(String str) {
            this.b = str;
            return this;
        }

        public Builder setAuthCode(String str) {
            this.f232d = str;
            return this;
        }

        public Builder setEnv(ENV env) {
            this.f231c = env;
            return this;
        }

        public Builder setTag(String str) {
            this.a = str;
            return this;
        }
    }

    protected Config() {
    }

    public static Config getConfig(String str, ENV env) {
        synchronized (a) {
            for (Config config : a.values()) {
                if (config.f229d == env && config.f228c.equals(str)) {
                    return config;
                }
            }
            return null;
        }
    }

    public static Config getConfigByTag(String str) {
        Config config;
        synchronized (a) {
            config = a.get(str);
        }
        return config;
    }

    public String getAppkey() {
        return this.f228c;
    }

    public ENV getEnv() {
        return this.f229d;
    }

    public ISecurity getSecurity() {
        return this.f230e;
    }

    public String getTag() {
        return this.b;
    }

    public String toString() {
        return this.b;
    }
}
