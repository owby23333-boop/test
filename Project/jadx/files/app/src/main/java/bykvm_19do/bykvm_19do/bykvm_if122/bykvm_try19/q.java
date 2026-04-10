package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19;

import android.content.Context;
import android.text.TextUtils;
import bykvm_19do.bykvm_19do.bykvm_19do.e;
import com.bytedance.mapplog.util.TTEncryptUtils;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.adapter.util.ThreadHelper;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class q {
    private static volatile String a = "";
    private static volatile String b = "";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile boolean f1778c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile ExecutorService f1779d;

    static final class a implements RejectedExecutionHandler {
        a() {
        }

        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
        }
    }

    static final class b implements Runnable {
        final /* synthetic */ String a;

        b(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            String unused = q.a = this.a;
            w.a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d(), q.a);
            if (TextUtils.isEmpty(q.a)) {
                return;
            }
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.e.f();
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.e.g();
        }
    }

    static final class c implements bykvm_19do.bykvm_19do.bykvm_19do.c {
        c() {
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_19do.c
        public void a(String str, String str2, String str3) {
            Logger.i("TTMediationSDK_SDK_Init", "applod from onIdLoaded ------------: did = " + str);
            q.d(str);
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_19do.c
        public void a(boolean z2, String str, String str2, String str3, String str4, String str5, String str6) {
            Logger.i("TTMediationSDK_SDK_Init", "applod from onRemoteIdGet ------------: did = " + str2);
            q.d(str2);
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_19do.c
        public void a(boolean z2, JSONObject jSONObject) {
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_19do.c
        public void b(boolean z2, JSONObject jSONObject) {
        }
    }

    static final class d implements bykvm_19do.bykvm_19do.bykvm_19do.e {
        d() {
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_19do.e
        public void a(e.a aVar) {
            if (!TextUtils.isEmpty(q.b) || aVar == null || TextUtils.isEmpty(aVar.a)) {
                return;
            }
            Logger.i("TTMediationSDK_SDK_Init", "applod ------------: oaid = " + aVar.a);
            String unused = q.b = aVar.a;
        }
    }

    static final class e implements bykvm_19do.bykvm_19do.bykvm_19do.g {
        final /* synthetic */ Context a;

        e(Context context) {
            this.a = context;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_19do.g
        public String a() {
            return w.i(this.a);
        }
    }

    public static void a(Context context) {
        b(context);
    }

    public static byte[] a(byte[] bArr, int i2) {
        return TTEncryptUtils.a(bArr, i2);
    }

    private static void b(Context context) {
        if (f1778c) {
            return;
        }
        f1778c = true;
        bykvm_19do.bykvm_19do.bykvm_19do.h hVar = new bykvm_19do.bykvm_19do.bykvm_19do.h("299838", "gromore");
        hVar.b(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.J().s().isCanUsePhoneState());
        hVar.c(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.J().s().isCanUseMacAddress());
        hVar.a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.J().s().isCanUseAndroidId());
        hVar.a(new e(context));
        bykvm_19do.bykvm_19do.bykvm_19do.a.a(context, hVar);
        c();
        d();
        HashMap map = new HashMap();
        map.put("host_appid", bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.J().b());
        map.put("is_plugin", false);
        map.put("sdk_version", "3.9.0.2");
        map.put(PluginConstants.KEY_PLUGIN_VERSION, "3.9.0.2");
        map.put("channel", "gromore");
        map.put("sdk_api_version", "3.9.0.2");
        bykvm_19do.bykvm_19do.bykvm_19do.a.a((HashMap<String, Object>) map);
        Logger.i("TTMediationSDK_SDK_Init", "applod ------------: init end ");
    }

    public static String c() {
        if (TextUtils.isEmpty(a)) {
            a = bykvm_19do.bykvm_19do.bykvm_19do.a.g();
            Logger.i("TTMediationSDK_SDK_Init", "applod ------------: did from get = " + a);
            if (TextUtils.isEmpty(a)) {
                e();
            }
        }
        return a;
    }

    public static String d() {
        if (TextUtils.isEmpty(b) && TextUtils.isEmpty(b)) {
            f();
        }
        return b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        g();
        f1779d.execute(new b(str));
    }

    private static void e() {
        bykvm_19do.bykvm_19do.bykvm_19do.a.a(new c());
    }

    private static void f() {
        bykvm_19do.bykvm_19do.bykvm_19do.a.a(new d());
    }

    private static void g() {
        if (f1779d == null) {
            synchronized (q.class) {
                if (f1779d == null) {
                    f1779d = ThreadHelper.initSingleThreadExecutor("applog", 5, new a());
                }
            }
        }
    }

    public static boolean h() {
        return bykvm_19do.bykvm_19do.bykvm_19do.a.n();
    }
}
