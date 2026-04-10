package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import com.umeng.analytics.pro.am;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class s {

    static final class a implements bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.e {
        final /* synthetic */ Context a;

        a(Context context) {
            this.a = context;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.e
        public String a() {
            return bykvm_19do.bykvm_19do.bykvm_19do.a.m();
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.e
        public List<String> b() {
            return null;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.e
        public String c() {
            return w.d(this.a);
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.e
        public String d() {
            return null;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.e
        public Map<String, Object> e() {
            HashMap map = new HashMap();
            map.put("host_appid", bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.J().b());
            map.put("sdk_version", "3.9.0.2");
            map.put(PluginConstants.KEY_PLUGIN_VERSION, "3.9.0.2");
            map.put("channel", "gromore");
            return map;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.e
        public Map<String, Object> f() {
            HashMap map = new HashMap();
            String strC = q.c();
            if (TextUtils.isEmpty(strC)) {
                strC = w.d(this.a);
            }
            if (!TextUtils.isEmpty(strC)) {
                map.put("device_id", strC);
            }
            map.put(com.anythink.expressad.d.a.b.da, z.d(this.a));
            map.put("aid", "299838");
            map.put("app_name", "gromore");
            String strE = m0.e();
            if (!TextUtils.isEmpty(strE)) {
                map.put("app_version", strE);
            }
            String strD = m0.d();
            if (!TextUtils.isEmpty(strD)) {
                map.put("version_code", strD);
                map.put("update_version_code", strD);
            }
            map.put(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME, "3.9.0.2");
            map.put("device_platform", DispatchConstants.ANDROID);
            map.put("os", "Android");
            map.put(am.ai, Build.MODEL);
            map.put("device_mode", Build.MODEL);
            map.put("rom", d0.k());
            map.put("cpu_abi", Build.CPU_ABI);
            map.put("device_brand", Build.BRAND);
            map.put("channel", "gromore");
            map.put("language", Locale.getDefault().getLanguage());
            map.put("os_api", String.valueOf(Build.VERSION.SDK_INT));
            try {
                String strSubstring = Build.VERSION.RELEASE;
                if (strSubstring != null && strSubstring.length() > 10) {
                    strSubstring = strSubstring.substring(0, 10);
                }
                map.put("os_version", strSubstring);
            } catch (Exception unused) {
            }
            map.put("openudid", w.a(this.a));
            map.put("dpi", String.valueOf(this.a.getResources().getDisplayMetrics().density));
            map.put("resolution", this.a.getResources().getDisplayMetrics().widthPixels + "*" + this.a.getResources().getDisplayMetrics().heightPixels);
            return map;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.e
        public Map<String, Integer> g() {
            return null;
        }
    }

    static final class b implements bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.g {
        b() {
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.g
        public boolean a(Throwable th, Thread thread) {
            try {
                StringWriter stringWriter = new StringWriter();
                th.printStackTrace(new PrintWriter(stringWriter));
                String string = stringWriter.toString();
                if (string == null) {
                    return false;
                }
                if (!(string.contains("com.bytedance.msdk") || string.contains("bykvm"))) {
                    return false;
                }
                if (c.b().a() != null) {
                    bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.h.a(c.b().a());
                }
                return true;
            } catch (Throwable unused) {
                return false;
            }
        }
    }

    private static class c {
        private static String b = "ad_style";

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static String f1785c = "ad_id";

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static String f1786d = "rit";

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static String f1787e = "request_id";

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static String f1788f = "ad_slot_type";

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private static String f1789g = "net_type";

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static String f1790h = "low_memory";

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private static String f1791i = "total_max_memory_rate";

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private static String f1792j = "category";

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private static String f1793k = "commit_hash";

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private static String f1794l = "branch";

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private static String f1795m = "plugin_version";

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private static volatile c f1796n;
        private Map<String, String> a = new HashMap();

        private c() {
            this.a.put(b, "default");
            this.a.put(f1785c, "default");
            this.a.put(f1786d, "default");
            this.a.put(f1787e, "default");
            this.a.put(f1788f, "default");
            this.a.put(f1789g, "default");
            this.a.put(f1790h, "default");
            this.a.put(f1791i, "default");
            this.a.put(f1792j, "main");
            this.a.put(f1793k, "80ad05d");
            this.a.put(f1794l, "");
            this.a.put(f1795m, "3.9.0.2");
        }

        public static c b() {
            if (f1796n == null) {
                synchronized (c.class) {
                    if (f1796n == null) {
                        f1796n = new c();
                    }
                }
            }
            return f1796n;
        }

        public Map<String, String> a() {
            return this.a;
        }
    }

    private static void a() {
        try {
            if (q.h()) {
                return;
            }
            e0 e0VarA = e0.a((String) null, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d());
            int iA = e0VarA.a("applog_so_fail_upload_time", -1);
            int i2 = Calendar.getInstance().get(6);
            if (iA != i2) {
                e0VarA.b("applog_so_fail_upload_time", i2);
                bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.h.a("applog so load failed");
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void a(Context context) {
        b(context);
    }

    private static void b(Context context) {
        bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.h.a(context, new a(context), true, false);
        bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.h.a(new b());
        a();
    }
}
