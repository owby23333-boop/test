package com.amgcyo.cuttadon.h.b;

import android.content.Context;
import android.text.TextUtils;
import com.amgcyo.cuttadon.app.MkApplication;
import com.amgcyo.cuttadon.f.o;
import com.amgcyo.cuttadon.utils.otherutils.g;
import com.amgcyo.cuttadon.utils.otherutils.g0;
import com.bytedance.sdk.openadsdk.TTAdConfig;
import com.bytedance.sdk.openadsdk.TTAdManager;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.fatcatfat.io.R;

/* JADX INFO: compiled from: CsjTTAdManagerHolder.java */
/* JADX INFO: loaded from: classes.dex */
public class d {
    private static boolean a;

    /* JADX INFO: compiled from: CsjTTAdManagerHolder.java */
    class a implements TTAdSdk.InitCallback {
        final /* synthetic */ MkApplication a;
        final /* synthetic */ com.amgcyo.cuttadon.h.f.a b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f3872c;

        a(MkApplication mkApplication, com.amgcyo.cuttadon.h.f.a aVar, String str) {
            this.a = mkApplication;
            this.b = aVar;
            this.f3872c = str;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdSdk.InitCallback
        public void fail(int i2, String str) {
            this.a.setCsjInit(false);
            g0.a().b("ckla5fn6nq", false);
            if (this.b != null) {
                String str2 = "fail:  code = " + i2 + " msg = " + str;
                g.a(new Throwable(str2), "csj init");
                g0.a().b("hcehiuwhrg", "");
                System.out.println("csj init result " + str2);
                this.b.fail(i2, str);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdSdk.InitCallback
        public void success() {
            g0.a().b("ckla5fn6nq", true);
            this.a.setCsjInit(true);
            if (this.b != null) {
                g0.a().b("hcehiuwhrg", this.f3872c);
                System.out.println("csj init result true");
                this.b.success();
            }
        }
    }

    public static TTAdManager a() {
        return TTAdSdk.getAdManager();
    }

    public static void b(Context context, String str, com.amgcyo.cuttadon.h.f.a aVar) {
        if (!TextUtils.isEmpty(str)) {
            a(context, str, aVar);
        } else if (aVar != null) {
            aVar.fail(-123456, "csj appid is null");
        }
    }

    private static void a(Context context, String str, com.amgcyo.cuttadon.h.f.a aVar) {
        MkApplication appContext = MkApplication.getAppContext();
        StringBuilder sb = new StringBuilder();
        sb.append("initSdkListener:");
        sb.append(aVar != null);
        sb.toString();
        if (a) {
            return;
        }
        TTAdConfig tTAdConfigA = a(str);
        if (tTAdConfigA != null) {
            TTAdSdk.init(context, tTAdConfigA, new a(appContext, aVar, str));
            a = true;
            return;
        }
        a = false;
        appContext.setCsjInit(false);
        if (aVar != null) {
            String str2 = "fail:  code = 1 msg = ttAdConfig is null ";
            aVar.fail(1, "ttAdConfig is null ");
        }
    }

    private static TTAdConfig a(String str) {
        int[] iArr = {4, 5, 3};
        int iA = com.amgcyo.cuttadon.sdk.utils.g.a("click_down_switch", 1);
        if (iA <= 0) {
            iArr = new int[]{4};
        } else if (iA == 2) {
            iArr = new int[0];
        }
        return new TTAdConfig.Builder().appId(str).useTextureView(true).appName(o.d(R.string.app_name)).titleBarTheme(1).allowShowNotify(true).debug(false).directDownloadNetworkType(iArr).supportMultiProcess(true).needClearTaskReset(new String[0]).build();
    }
}
