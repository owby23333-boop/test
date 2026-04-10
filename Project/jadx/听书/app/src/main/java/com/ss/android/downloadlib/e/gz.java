package com.ss.android.downloadlib.e;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.ss.android.downloadlib.activity.JumpKllkActivity;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.z.z.g.q;
import com.umeng.analytics.pro.an;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class gz {
    private static final String z = "gz";

    public static com.ss.android.downloadlib.addownload.g.e z(Context context, Uri uri) {
        Intent intent;
        if (!com.ss.android.socialbase.appdownloader.m.gc.dl() && (context == null || uri == null || !"market".equals(uri.getScheme()))) {
            return new com.ss.android.downloadlib.addownload.g.e(6, 12);
        }
        try {
            String strUy = com.ss.android.socialbase.appdownloader.m.gc.uy();
            if (com.ss.android.socialbase.appdownloader.m.gc.p() && (TextUtils.isEmpty(strUy) || !i.gc(context, strUy))) {
                strUy = "com.huawei.appmarket";
                Uri.Builder builderBuildUpon = uri.buildUpon();
                builderBuildUpon.scheme("market");
                intent = new Intent("android.intent.action.VIEW", builderBuildUpon.build());
            } else {
                intent = new Intent("android.intent.action.VIEW", uri);
            }
            if (!i.z(context, intent)) {
                return new com.ss.android.downloadlib.addownload.g.e(6, 13);
            }
            if (i.gc(context, strUy) && !com.ss.android.socialbase.appdownloader.m.gc.e()) {
                intent.setPackage(strUy);
            }
            if (com.ss.android.socialbase.downloader.i.z.dl().z("fix_jump_market")) {
                intent.addFlags(335544320);
            } else if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            if (com.ss.android.socialbase.downloader.i.z.dl().g("test_jump_market_failed") == 1) {
                com.ss.android.downloadlib.gc.dl.z().z(false, "jump market error");
                return new com.ss.android.downloadlib.addownload.g.e(6, 25);
            }
            intent.putExtra("start_only_for_android", true);
            context.startActivity(intent);
            return new com.ss.android.downloadlib.addownload.g.e(5);
        } catch (Exception unused) {
            return new com.ss.android.downloadlib.addownload.g.e(6, 14);
        }
    }

    public static com.ss.android.downloadlib.addownload.g.e z(final Context context, Uri uri, com.ss.android.downloadlib.addownload.g.gc gcVar) {
        if (context == null || !com.ss.android.downloadlib.g.uy.z(uri)) {
            return new com.ss.android.downloadlib.addownload.g.e(6, 12);
        }
        try {
            final Intent intent = new Intent("android.intent.action.VIEW", uri);
            if (!i.z(context, intent)) {
                return new com.ss.android.downloadlib.addownload.g.e(6, 13);
            }
            String strUy = com.ss.android.socialbase.appdownloader.m.gc.uy();
            if (i.gc(context, strUy)) {
                intent.setPackage(strUy);
            }
            intent.addFlags(335544320);
            if (com.ss.android.socialbase.downloader.i.z.dl().g("test_jump_market_failed") == 1 && "local_test".equals(com.ss.android.downloadlib.addownload.wp.uy().dl)) {
                com.ss.android.downloadlib.gc.dl.z().z(false, "jump market error");
                return new com.ss.android.downloadlib.addownload.g.e(6, 25);
            }
            intent.putExtra("start_only_for_android", true);
            long jOptLong = com.ss.android.downloadlib.addownload.wp.fo().optLong("market_jump_delay", 1000L);
            if (jOptLong > 0 && gcVar != null && gcVar.gc != null && !gcVar.gc.rv()) {
                com.ss.android.downloadlib.gz.z().g().post(new Runnable() { // from class: com.ss.android.downloadlib.e.gz.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.ss.android.downloadlib.addownload.wp.dl().z(8, com.ss.android.downloadlib.addownload.wp.getContext(), null, "浏览器跳转失败，正在前往应用商店", null, 0);
                    }
                });
            }
            com.ss.android.downloadlib.gc.z().z(new Runnable() { // from class: com.ss.android.downloadlib.e.gz.2
                @Override // java.lang.Runnable
                public void run() {
                    context.startActivity(intent);
                }
            }, jOptLong);
            return new com.ss.android.downloadlib.addownload.g.e(5);
        } catch (Exception unused) {
            return new com.ss.android.downloadlib.addownload.g.e(6, 14);
        }
    }

    public static com.ss.android.downloadlib.addownload.g.e z(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return new com.ss.android.downloadlib.addownload.g.e(6, 11);
        }
        if (com.ss.android.socialbase.appdownloader.m.gc.e() && i.gc(context, "com.sec.android.app.samsungapps")) {
            return a(context, str);
        }
        return z(context, com.ss.android.z.z.m.z.z(context, str));
    }

    public static com.ss.android.downloadlib.addownload.g.e z(Context context, com.ss.android.downloadlib.addownload.g.gc gcVar, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return new com.ss.android.downloadlib.addownload.g.e(6, 11);
        }
        if (com.ss.android.socialbase.appdownloader.m.gc.e() && i.gc(context, "com.sec.android.app.samsungapps")) {
            return a(context, str);
        }
        if (!gcVar.g.io() || !gcVar.f1987a.ls()) {
            return z(context, Uri.parse("market://details?id=" + str));
        }
        JSONArray jSONArrayOptJSONArray = com.ss.android.downloadlib.addownload.wp.fo().optJSONArray("am_plans");
        if (com.ss.android.socialbase.appdownloader.m.gc.gc() && com.ss.android.socialbase.appdownloader.m.z.z(jSONArrayOptJSONArray, "am_3")) {
            return g(context, gcVar, str);
        }
        if (com.ss.android.socialbase.appdownloader.m.gc.m() && com.ss.android.socialbase.appdownloader.m.z.z(jSONArrayOptJSONArray, "am_2")) {
            gc(context, gcVar, str);
            return new com.ss.android.downloadlib.addownload.g.e(7, "am_m2");
        }
        if (com.ss.android.socialbase.appdownloader.m.gc.a() && com.ss.android.socialbase.appdownloader.m.z.z(jSONArrayOptJSONArray, "am_5")) {
            gz(context, gcVar, str);
            return new com.ss.android.downloadlib.addownload.g.e(7, "am_v1");
        }
        if (com.ss.android.socialbase.appdownloader.m.gc.gc() && com.ss.android.socialbase.appdownloader.m.z.z(jSONArrayOptJSONArray, "am_7") && (gcVar.f1987a instanceof com.ss.android.g.z.z.z) && ((com.ss.android.g.z.z.z) gcVar.f1987a).p()) {
            return a(context, gcVar, str);
        }
        if (com.ss.android.socialbase.appdownloader.m.gc.a() && com.ss.android.socialbase.appdownloader.m.z.z(jSONArrayOptJSONArray, "am_8") && i.z(i.dl(context, "com.bbk.appstore"), "8.7.2.0") >= 0) {
            fo(context, gcVar, str);
            return new com.ss.android.downloadlib.addownload.g.e(7, "am_v2");
        }
        if ((com.ss.android.socialbase.appdownloader.m.gc.z() || com.ss.android.socialbase.appdownloader.m.gc.g()) && com.ss.android.socialbase.appdownloader.m.z.z(jSONArrayOptJSONArray, "am_9")) {
            m(context, gcVar, str);
            return new com.ss.android.downloadlib.addownload.g.e(7, "am_hr");
        }
        if ((com.ss.android.socialbase.appdownloader.m.gc.z() || com.ss.android.socialbase.appdownloader.m.gc.g()) && com.ss.android.socialbase.appdownloader.m.z.z(jSONArrayOptJSONArray, "am_10")) {
            e(context, gcVar, str);
            return new com.ss.android.downloadlib.addownload.g.e(7, "am_hr2");
        }
        if ((gcVar.f1987a instanceof com.ss.android.g.z.z.z) && ((com.ss.android.g.z.z.z) gcVar.f1987a).p() && ((com.ss.android.g.z.z.z) gcVar.f1987a).fv() != null && gcVar.g.fv().optInt("is_use_obm_convert", 0) == 1) {
            dl(context, gcVar, str);
            return new com.ss.android.downloadlib.addownload.g.e(7, "am_kllk4");
        }
        return z(context, com.ss.android.z.z.m.z.z(context, str));
    }

    private static com.ss.android.downloadlib.addownload.g.e a(Context context, String str) {
        try {
            Uri uri = Uri.parse("https://www.samsungapps.com/appquery/appDetail.as?appId=" + str);
            Intent intent = new Intent();
            intent.setClassName("com.sec.android.app.samsungapps", "com.sec.android.app.samsungapps.Main");
            intent.setData(uri);
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            intent.putExtra("start_only_for_android", true);
            context.startActivity(intent);
            return new com.ss.android.downloadlib.addownload.g.e(5);
        } catch (Exception unused) {
            return new com.ss.android.downloadlib.addownload.g.e(6, 14);
        }
    }

    public static boolean z(Context context, com.ss.android.downloadlib.addownload.g.gc gcVar, String str, JSONObject jSONObject, boolean z2, int i) {
        i.z(jSONObject, "download_scene", Integer.valueOf(gcVar.tb()));
        com.ss.android.downloadlib.a.z.z().g("market_click_open", jSONObject, gcVar);
        com.ss.android.downloadlib.addownload.g.e eVarZ = z(context, Uri.parse(str));
        String strZ = i.z(eVarZ.g(), "open_market");
        int type = eVarZ.getType();
        if (type == 5) {
            com.ss.android.downloadlib.g.z.z(strZ, jSONObject, gcVar, true);
        } else {
            if (type == 6) {
                i.z(jSONObject, "error_code", Integer.valueOf(eVarZ.z()));
                i.z(jSONObject, "download_scene", Integer.valueOf(gcVar.tb()));
                com.ss.android.downloadlib.a.z.z().g("market_open_failed", jSONObject, gcVar);
                return false;
            }
            if (type != 7) {
                return false;
            }
        }
        if (z2) {
            com.ss.android.downloadlib.a.z.z().z(gcVar.z, i);
        }
        return true;
    }

    private static com.ss.android.downloadlib.addownload.g.e g(Context context, com.ss.android.downloadlib.addownload.g.gc gcVar, String str) {
        Intent intent = new Intent(context, (Class<?>) JumpKllkActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("p", str);
        intent.putExtra("id", gcVar.z);
        intent.putExtra("start_only_for_android", true);
        JSONObject jSONObject = new JSONObject();
        try {
            context.startActivity(intent);
            return new com.ss.android.downloadlib.addownload.g.e(7, "am_kllk2");
        } catch (Throwable unused) {
            g(gcVar, jSONObject, 1, 3, "market://details?id=" + str);
            return z(context, Uri.parse("market://details?id=" + str));
        }
    }

    private static void dl(Context context, com.ss.android.downloadlib.addownload.g.gc gcVar, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            TTDelegateActivity.z(context, str, gcVar.z);
        } catch (Exception unused) {
            com.ss.android.downloadlib.g.z.z(z(context, Uri.parse("market://details?id=" + str)), gcVar, true);
            g(gcVar, jSONObject, 14, 11, "market://details?id=" + str);
        }
    }

    private static com.ss.android.downloadlib.addownload.g.e a(Context context, com.ss.android.downloadlib.addownload.g.gc gcVar, String str) {
        Intent intent = new Intent(context, (Class<?>) JumpKllkActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("dl", true);
        intent.putExtra("p", str);
        intent.putExtra("id", gcVar.z);
        if (Build.VERSION.SDK_INT >= 29) {
            intent.putExtra("bk", "com.heytap.browser");
        } else if (i.gc(context, "com.android.browser")) {
            intent.putExtra("bk", "com.android.browser");
        } else if (i.gc(context, "com.coloros.browser")) {
            intent.putExtra("bk", "com.coloros.browser");
        } else {
            return z(context, Uri.parse("market://details?id=" + str));
        }
        intent.putExtra("start_only_for_android", true);
        JSONObject jSONObject = new JSONObject();
        try {
            context.startActivity(intent);
            return new com.ss.android.downloadlib.addownload.g.e(7, "am_kllk3");
        } catch (Throwable unused) {
            g(gcVar, jSONObject, 1, 3, "market://details?id=" + str);
            return z(context, Uri.parse("market://details?id=" + str));
        }
    }

    public static void z(Context context, String str, long j, boolean z2) {
        JSONObject jSONObject = new JSONObject();
        com.ss.android.downloadlib.addownload.g.gc gcVarGc = com.ss.android.downloadlib.addownload.g.m.z().gc(j);
        try {
            JSONObject jSONObjectFo = com.ss.android.downloadlib.addownload.wp.fo();
            String strOptString = jSONObjectFo.optString("s");
            String strZ = com.ss.android.socialbase.appdownloader.m.dl.z(jSONObjectFo.optString("aa"), strOptString);
            String strZ2 = com.ss.android.socialbase.appdownloader.m.dl.z(jSONObjectFo.optString("ac"), strOptString);
            String strZ3 = com.ss.android.socialbase.appdownloader.m.dl.z(jSONObjectFo.optString("af"), strOptString);
            boolean z3 = com.ss.android.socialbase.appdownloader.m.z.z(jSONObjectFo, context, strZ2);
            StringBuilder sb = new StringBuilder(String.format(strZ, str, strZ3, strZ2));
            Intent intent = new Intent("android.intent.action.VIEW");
            String strUy = com.ss.android.socialbase.appdownloader.m.gc.uy();
            if (i.gc(context, strUy)) {
                intent.setPackage(strUy);
            }
            if (z2) {
                sb.append(com.ss.android.socialbase.appdownloader.m.dl.z(jSONObjectFo.optString("ae"), strOptString));
            } else {
                intent.addFlags(335544320);
            }
            i.z(jSONObject, "mf", Boolean.valueOf(z3));
            i.z(jSONObject, "if", Boolean.valueOf(z2));
            intent.setData(Uri.parse(sb.toString()));
            intent.putExtra("start_only_for_android", true);
            context.startActivity(intent);
            com.ss.android.downloadlib.g.z.z("am_kllk2", jSONObject, gcVarGc, true);
            if (z3) {
                g(gcVarGc, jSONObject, -1, 3, sb.toString());
            } else {
                g(gcVarGc, jSONObject, 3, 3, sb.toString());
            }
        } catch (Exception unused) {
            com.ss.android.downloadlib.g.z.z(z(com.ss.android.downloadlib.addownload.wp.getContext(), Uri.parse("market://details?id=" + str)), gcVarGc, true);
            g(gcVarGc, jSONObject, 2, 3, "market://details?id=" + str);
        }
    }

    public static void z(final Context context, String str, long j, String str2, boolean z2) {
        JSONObject jSONObject = new JSONObject();
        com.ss.android.downloadlib.addownload.g.gc gcVarGc = com.ss.android.downloadlib.addownload.g.m.z().gc(j);
        try {
            JSONObject jSONObjectFo = com.ss.android.downloadlib.addownload.wp.fo();
            String strOptString = jSONObjectFo.optString("s");
            String strZ = com.ss.android.socialbase.appdownloader.m.dl.z(jSONObjectFo.optString("br"), strOptString);
            String strZ2 = com.ss.android.socialbase.appdownloader.m.dl.z(jSONObjectFo.optString("bs_1"), strOptString);
            String strZ3 = com.ss.android.socialbase.appdownloader.m.dl.z(jSONObjectFo.optString("bs_2"), strOptString);
            String strZ4 = com.ss.android.socialbase.appdownloader.m.dl.z(jSONObjectFo.optString("bs_3"), strOptString);
            String strZ5 = com.ss.android.socialbase.appdownloader.m.dl.z(jSONObjectFo.optString("bt"), strOptString);
            String strZ6 = com.ss.android.socialbase.appdownloader.m.dl.z(jSONObjectFo.optString("bu"), strOptString);
            StringBuilder sb = new StringBuilder(String.format("https://", new Object[0]));
            sb.append(strZ).append(strZ2).append(strZ3).append(strZ4).append(strZ5).append(strZ6);
            final Intent intent = new Intent("android.intent.action.VIEW");
            intent.setPackage(str2);
            if (z2) {
                sb.append("pkg=" + str);
                sb.append("&dl=true");
            } else {
                intent.addFlags(335544320);
            }
            i.z(jSONObject, "dl", Boolean.valueOf(z2));
            intent.setData(Uri.parse(sb.toString()));
            intent.putExtra("start_only_for_android", true);
            long jOptLong = com.ss.android.downloadlib.addownload.wp.fo().optLong("oppo_browser_jump_delay", 1000L);
            if (jOptLong > 0) {
                com.ss.android.downloadlib.gz.z().g().post(new Runnable() { // from class: com.ss.android.downloadlib.e.gz.3
                    @Override // java.lang.Runnable
                    public void run() {
                        com.ss.android.downloadlib.addownload.wp.dl().z(12, com.ss.android.downloadlib.addownload.wp.getContext(), null, "正在前往浏览器下载", null, 0);
                    }
                });
            }
            com.ss.android.downloadlib.gc.z().z(new Runnable() { // from class: com.ss.android.downloadlib.e.gz.4
                @Override // java.lang.Runnable
                public void run() {
                    context.startActivity(intent);
                }
            }, jOptLong);
            if (gcVarGc.gc != null) {
                gcVarGc.gc.iq(true);
            }
            com.ss.android.downloadlib.g.z.z("am_kllk3", jSONObject, gcVarGc, true);
            g(gcVarGc, jSONObject, -1, 7, sb.toString());
        } catch (Exception unused) {
            if (gcVarGc.gc != null) {
                gcVarGc.gc.iq(false);
            }
            com.ss.android.downloadlib.g.z.z(z(com.ss.android.downloadlib.addownload.wp.getContext(), Uri.parse("market://details?id=" + str), gcVarGc), gcVarGc, true);
            g(gcVarGc, jSONObject, 2, 7, "market://details?id=" + str);
        }
    }

    private static boolean z(Activity activity, String str, HashMap<String, String> map) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("market://details?id=" + str));
        intent.putExtra("start_only_for_android", true);
        intent.putExtra("param", map);
        String strUy = com.ss.android.socialbase.appdownloader.m.gc.uy();
        if (i.gc(com.ss.android.downloadlib.addownload.wp.getContext(), strUy)) {
            intent.setPackage(strUy);
        }
        if (!i.z(com.ss.android.downloadlib.addownload.wp.getContext(), intent)) {
            return false;
        }
        try {
            activity.startActivity(intent);
            return true;
        } catch (Exception e) {
            com.ss.android.downloadlib.gc.dl.z().z(e, "start v1");
            return false;
        }
    }

    private static void gc(final Context context, final com.ss.android.downloadlib.addownload.g.gc gcVar, final String str) {
        com.ss.android.downloadlib.gc.z().z(new Runnable() { // from class: com.ss.android.downloadlib.e.gz.5
            @Override // java.lang.Runnable
            public void run() {
                com.ss.android.downloadlib.g.z.z(gz.z(context, Uri.parse("market://details?id=" + str)), gcVar, true);
                JSONObject jSONObject = new JSONObject();
                try {
                    JSONObject jSONObjectFo = com.ss.android.downloadlib.addownload.wp.fo();
                    Thread.sleep(jSONObjectFo.optInt("m2_delay_millis", 1000));
                    com.ss.android.downloadlib.z.z.z.z().z(context, true);
                    com.ss.android.downloadlib.z.z.g gVar = new com.ss.android.downloadlib.z.z.g();
                    gVar.z = 1;
                    gVar.g = 0;
                    String strZ = com.ss.android.socialbase.appdownloader.m.dl.z(jSONObjectFo.optString("v"), jSONObjectFo.optString("s"));
                    gVar.dl = String.format(strZ, str);
                    com.ss.android.downloadlib.z.z.z.z().z(gVar, (com.ss.android.downloadlib.z.z.a) null);
                    com.ss.android.downloadlib.z.z.z.z().g();
                    gz.g(gcVar, jSONObject, -1, 2, String.format(strZ, str));
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.wp.z(th);
                    gz.g(gcVar, jSONObject, 1, 2, "market://details?id=" + str);
                }
            }
        });
    }

    private static void m(final Context context, final com.ss.android.downloadlib.addownload.g.gc gcVar, final String str) {
        com.ss.android.downloadlib.gc.z().z(new Runnable() { // from class: com.ss.android.downloadlib.e.gz.6
            @Override // java.lang.Runnable
            public void run() {
                JSONObject jSONObjectFo = com.ss.android.downloadlib.addownload.wp.fo();
                final JSONObject jSONObject = new JSONObject();
                try {
                    String strOptString = jSONObjectFo.optString("s");
                    String strZ = com.ss.android.socialbase.appdownloader.m.dl.z(jSONObjectFo.optString("bw"), strOptString);
                    String strZ2 = com.ss.android.socialbase.appdownloader.m.dl.z(jSONObjectFo.optString("bx"), strOptString);
                    String strZ3 = com.ss.android.socialbase.appdownloader.m.dl.z(jSONObjectFo.optString("by"), strOptString);
                    Uri.Builder builder = new Uri.Builder();
                    builder.scheme("https").authority(strZ).appendPath(strZ2).appendQueryParameter(strZ3, str);
                    com.ss.android.downloadlib.addownload.wp.a().z("GET", builder.build().toString(), null, new q() { // from class: com.ss.android.downloadlib.e.gz.6.1
                        /* JADX WARN: Removed duplicated region for block: B:9:0x002c  */
                        @Override // com.ss.android.z.z.g.q
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                            To view partially-correct code enable 'Show inconsistent code' option in preferences
                        */
                        public void z(java.lang.String r5) {
                            /*
                                r4 = this;
                                boolean r0 = android.text.TextUtils.isEmpty(r5)
                                r1 = 1
                                if (r0 != 0) goto L2c
                                java.lang.String r5 = com.ss.android.downloadlib.e.gz.z(r5)
                                boolean r0 = android.text.TextUtils.isEmpty(r5)
                                if (r0 != 0) goto L2c
                                java.lang.String r5 = com.ss.android.downloadlib.e.gz.g(r5)
                                boolean r0 = android.text.TextUtils.isEmpty(r5)
                                if (r0 != 0) goto L2c
                                com.ss.android.downloadlib.e.gz$6 r0 = com.ss.android.downloadlib.e.gz.AnonymousClass6.this
                                android.content.Context r0 = r2
                                com.ss.android.downloadlib.e.gz$6 r2 = com.ss.android.downloadlib.e.gz.AnonymousClass6.this
                                com.ss.android.downloadlib.addownload.g.gc r2 = r3
                                com.ss.android.downloadlib.e.gz$6 r3 = com.ss.android.downloadlib.e.gz.AnonymousClass6.this
                                java.lang.String r3 = r1
                                com.ss.android.downloadlib.e.gz.z(r0, r2, r3, r5)
                                r5 = r1
                                goto L2d
                            L2c:
                                r5 = 0
                            L2d:
                                if (r5 != 0) goto L73
                                com.ss.android.downloadlib.e.gz$6 r5 = com.ss.android.downloadlib.e.gz.AnonymousClass6.this
                                android.content.Context r5 = r2
                                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                                java.lang.String r2 = "market://details?id="
                                r0.<init>(r2)
                                com.ss.android.downloadlib.e.gz$6 r3 = com.ss.android.downloadlib.e.gz.AnonymousClass6.this
                                java.lang.String r3 = r1
                                java.lang.StringBuilder r0 = r0.append(r3)
                                java.lang.String r0 = r0.toString()
                                android.net.Uri r0 = android.net.Uri.parse(r0)
                                com.ss.android.downloadlib.addownload.g.e r5 = com.ss.android.downloadlib.e.gz.z(r5, r0)
                                com.ss.android.downloadlib.e.gz$6 r0 = com.ss.android.downloadlib.e.gz.AnonymousClass6.this
                                com.ss.android.downloadlib.addownload.g.gc r0 = r3
                                com.ss.android.downloadlib.g.z.z(r5, r0, r1)
                                com.ss.android.downloadlib.e.gz$6 r5 = com.ss.android.downloadlib.e.gz.AnonymousClass6.this
                                com.ss.android.downloadlib.addownload.g.gc r5 = r3
                                org.json.JSONObject r0 = r2
                                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                                r1.<init>(r2)
                                com.ss.android.downloadlib.e.gz$6 r2 = com.ss.android.downloadlib.e.gz.AnonymousClass6.this
                                java.lang.String r2 = r1
                                java.lang.StringBuilder r1 = r1.append(r2)
                                java.lang.String r1 = r1.toString()
                                r2 = 10
                                r3 = 9
                                com.ss.android.downloadlib.e.gz.z(r5, r0, r2, r3, r1)
                            L73:
                                return
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.ss.android.downloadlib.e.gz.AnonymousClass6.AnonymousClass1.z(java.lang.String):void");
                        }

                        @Override // com.ss.android.z.z.g.q
                        public void z(Throwable th) {
                            com.ss.android.downloadlib.g.z.z(gz.z(context, Uri.parse("market://details?id=" + str)), gcVar, true);
                            i.z(jSONObject, "ttdownloader_message", th != null ? th.getMessage() : "null");
                            gz.g(gcVar, jSONObject, 11, 9, "market://details?id=" + str);
                        }
                    });
                } catch (Exception e) {
                    com.bytedance.sdk.component.utils.wp.z(e);
                    gz.g(gcVar, jSONObject, 4, 9, "market://details?id=" + str);
                }
            }
        });
    }

    private static void e(Context context, com.ss.android.downloadlib.addownload.g.gc gcVar, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            TTDelegateActivity.z(str, gcVar.z);
        } catch (Exception unused) {
            com.ss.android.downloadlib.g.z.z(z(context, Uri.parse("market://details?id=" + str)), gcVar, true);
            g(gcVar, jSONObject, 13, 10, "market://details?id=" + str);
        }
    }

    private static void gz(final Context context, final com.ss.android.downloadlib.addownload.g.gc gcVar, final String str) {
        com.ss.android.downloadlib.gc.z().z(new Runnable() { // from class: com.ss.android.downloadlib.e.gz.7
            @Override // java.lang.Runnable
            public void run() {
                JSONObject jSONObjectFo = com.ss.android.downloadlib.addownload.wp.fo();
                String strOptString = jSONObjectFo.optString("s");
                final JSONObject jSONObject = new JSONObject();
                String strZ = com.ss.android.socialbase.appdownloader.m.dl.z(jSONObjectFo.optString("x"), strOptString);
                JSONObject jSONObject2 = new JSONObject();
                i.z(jSONObject2, an.aI, "v");
                i.z(jSONObject2, "p", str);
                byte[] bytes = jSONObject2.toString().getBytes();
                com.ss.android.downloadlib.addownload.wp.a().z(strZ, com.ss.android.downloadlib.addownload.wp.fv().z(bytes, bytes.length), "application/octet-stream;tt-data=a", 0, new q() { // from class: com.ss.android.downloadlib.e.gz.7.1
                    @Override // com.ss.android.z.z.g.q
                    public void z(String str2) {
                        gz.g(context, str, str2, gcVar, jSONObject);
                    }

                    @Override // com.ss.android.z.z.g.q
                    public void z(Throwable th) {
                        com.ss.android.downloadlib.g.z.z(gz.z(context, Uri.parse("market://details?id=" + str)), gcVar, true);
                        i.z(jSONObject, "ttdownloader_message", th != null ? th.getMessage() : "null");
                        gz.g(gcVar, jSONObject, 7, 5, "market://details?id=" + str);
                    }
                });
            }
        });
    }

    private static void fo(Context context, com.ss.android.downloadlib.addownload.g.gc gcVar, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            TTDelegateActivity.z(str, gcVar.z, "need_comment");
        } catch (Exception unused) {
            com.ss.android.downloadlib.g.z.z(z(context, Uri.parse("market://details?id=" + str)), gcVar, true);
            g(gcVar, jSONObject, 9, 8, "market://details?id=" + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void g(Context context, String str, String str2, com.ss.android.downloadlib.addownload.g.gc gcVar, JSONObject jSONObject) {
        i.z(jSONObject, "ttdownloader_type", (Object) 5);
        try {
            String strZ = com.ss.android.socialbase.appdownloader.m.dl.z(new JSONObject(str2).optString("a"));
            if (!TextUtils.isEmpty(strZ)) {
                TTDelegateActivity.z(str, gcVar.z, strZ, jSONObject);
            } else {
                com.ss.android.downloadlib.g.z.z(z(context, Uri.parse("market://details?id=" + str)), gcVar, true);
                g(gcVar, jSONObject, 5, 5, "market://details?id=" + str);
            }
        } catch (Exception unused) {
            com.ss.android.downloadlib.g.z.z(z(context, Uri.parse("market://details?id=" + str)), gcVar, true);
            g(gcVar, jSONObject, 6, 5, "market://details?id=" + str);
        }
    }

    public static void z(Activity activity, String str, long j, String str2, String str3) {
        JSONObject jSONObject;
        int i;
        try {
            jSONObject = new JSONObject(str3);
        } catch (JSONException unused) {
            jSONObject = new JSONObject();
        }
        com.ss.android.downloadlib.addownload.g.gc gcVarGc = com.ss.android.downloadlib.addownload.g.m.z().gc(j);
        try {
            JSONObject jSONObjectFo = com.ss.android.downloadlib.addownload.wp.fo();
            boolean z2 = com.ss.android.socialbase.appdownloader.m.z.z(jSONObjectFo, activity, com.ss.android.socialbase.appdownloader.m.dl.z(jSONObjectFo.optString("bg"), jSONObjectFo.optString("s")));
            HashMap<String, String> mapG = i.g(new JSONObject(str2));
            if (z2 && !mapG.isEmpty() && z(activity, str, mapG)) {
                g(gcVarGc, jSONObject, -1, 5, "market://details?id=" + str);
                com.ss.android.downloadlib.g.z.z("am_v1", jSONObject, gcVarGc, true);
                return;
            }
            if (z2) {
                i = mapG.isEmpty() ? 1 : 2;
            } else {
                i = 3;
            }
            g(gcVarGc, jSONObject, i, 5, "market://details?id=" + str);
            com.ss.android.downloadlib.g.z.z(z((Context) activity, Uri.parse("market://details?id=" + str)), gcVarGc, true);
        } catch (Exception unused2) {
            com.ss.android.downloadlib.g.z.z(z(com.ss.android.downloadlib.addownload.wp.getContext(), Uri.parse("market://details?id=" + str)), gcVarGc, true);
            g(gcVarGc, jSONObject, 4, 5, "market://details?id=" + str);
        }
    }

    public static void z(Activity activity, String str, long j, String str2) {
        com.ss.android.downloadlib.addownload.g.gc gcVarGc = com.ss.android.downloadlib.addownload.g.m.z().gc(j);
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObjectFo = com.ss.android.downloadlib.addownload.wp.fo();
        String strZ = com.ss.android.socialbase.appdownloader.m.dl.z(jSONObjectFo.optString("bv"), jSONObjectFo.optString("s"));
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("market").authority("details").appendQueryParameter("id", str);
        if (!TextUtils.isEmpty(strZ)) {
            builder.appendQueryParameter(strZ, str2);
        }
        if (z(activity, builder.build())) {
            g(gcVarGc, jSONObject, -1, 8, "market://details?id=" + str);
            com.ss.android.downloadlib.g.z.z("am_v2", jSONObject, gcVarGc, true);
        } else {
            g(gcVarGc, jSONObject, 2, 8, "market://details?id=" + str);
            com.ss.android.downloadlib.g.z.z(z((Context) activity, Uri.parse("market://details?id=" + str)), gcVarGc, true);
        }
    }

    public static boolean z(Activity activity, Uri uri) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(uri);
        intent.putExtra("start_only_for_android", true);
        String strUy = com.ss.android.socialbase.appdownloader.m.gc.uy();
        if (i.gc(com.ss.android.downloadlib.addownload.wp.getContext(), strUy)) {
            intent.setPackage(strUy);
        }
        if (!i.z(com.ss.android.downloadlib.addownload.wp.getContext(), intent)) {
            return false;
        }
        try {
            activity.startActivity(intent);
            return true;
        } catch (Exception e) {
            com.ss.android.downloadlib.gc.dl.z().z(e, "start v2");
            return false;
        }
    }

    public static boolean g(Activity activity, Uri uri) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(uri);
        intent.putExtra("start_only_for_android", true);
        String strUy = com.ss.android.socialbase.appdownloader.m.gc.uy();
        if (i.gc(com.ss.android.downloadlib.addownload.wp.getContext(), strUy)) {
            intent.setPackage(strUy);
        }
        if (!i.z(com.ss.android.downloadlib.addownload.wp.getContext(), intent)) {
            return false;
        }
        try {
            activity.startActivity(intent);
            return true;
        } catch (Exception e) {
            com.ss.android.downloadlib.gc.dl.z().z(e, "start HM1");
            return false;
        }
    }

    public static boolean dl(Activity activity, Uri uri) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(uri);
        intent.putExtra("start_only_for_android", true);
        String strUy = com.ss.android.socialbase.appdownloader.m.gc.uy();
        if (i.gc(com.ss.android.downloadlib.addownload.wp.getContext(), strUy)) {
            intent.setPackage(strUy);
        }
        if (!i.z(com.ss.android.downloadlib.addownload.wp.getContext(), intent)) {
            return false;
        }
        try {
            activity.startActivity(intent);
            return true;
        } catch (Exception e) {
            com.ss.android.downloadlib.gc.dl.z().z(e, "start HM2");
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void g(com.ss.android.downloadlib.addownload.g.gc gcVar, JSONObject jSONObject, int i, int i2, String str) {
        i.z(jSONObject, "error_code", Integer.valueOf(i));
        i.z(jSONObject, "ttdownloader_type", Integer.valueOf(i2));
        i.z(jSONObject, "rmu", str);
        i.z(jSONObject, com.ss.android.socialbase.appdownloader.m.gc.uy(), Integer.valueOf(i.g(com.ss.android.downloadlib.addownload.wp.getContext(), com.ss.android.socialbase.appdownloader.m.gc.uy())));
        com.ss.android.downloadlib.a.z.z().g("am_result", jSONObject, gcVar);
    }

    static com.ss.android.downloadlib.addownload.g.e g(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return new com.ss.android.downloadlib.addownload.g.e(4, 11);
        }
        if (context == null) {
            context = com.ss.android.downloadlib.addownload.wp.getContext();
        }
        Intent intentE = i.e(context, str);
        if (intentE == null) {
            return new com.ss.android.downloadlib.addownload.g.e(4, 22);
        }
        intentE.putExtra("start_only_for_android", true);
        try {
            context.startActivity(intentE);
            return new com.ss.android.downloadlib.addownload.g.e(3);
        } catch (Exception unused) {
            return new com.ss.android.downloadlib.addownload.g.e(4, 23);
        }
    }

    static com.ss.android.downloadlib.addownload.g.e z(Context context, String str, com.ss.android.g.z.g.z zVar) {
        Intent intentZ = z(context, zVar, str, 1, (String) null);
        if (intentZ != null) {
            wp.z().z(z, "tryOpenByPackage", "成功构造了跳转中转Activity的intent");
            com.ss.android.downloadlib.addownload.g.e eVarZ = z(intentZ, true, context, str, zVar);
            if (eVarZ.getType() == 3) {
                return eVarZ;
            }
        }
        Intent intentE = i.e(context, str);
        if (intentE == null) {
            return new com.ss.android.downloadlib.addownload.g.e(4, 22);
        }
        return z(intentE, false, context, str, zVar);
    }

    private static com.ss.android.downloadlib.addownload.g.e z(Intent intent, boolean z2, Context context, String str, com.ss.android.g.z.g.z zVar) {
        if (com.ss.android.downloadlib.addownload.wp.fo().optInt("open_package_mode") == 1 && com.ss.android.downloadlib.addownload.wp.wp() != null && com.ss.android.downloadlib.addownload.wp.wp().z() && zVar.p() && !z2) {
            TTDelegateActivity.g(str, zVar);
            return new com.ss.android.downloadlib.addownload.g.e(3);
        }
        intent.putExtra("start_only_for_android", true);
        try {
            context.startActivity(intent);
            return new com.ss.android.downloadlib.addownload.g.e(3);
        } catch (Exception e) {
            if (z2) {
                wp.z().g(z, "realTryOpenByPackage", "调起中转Activity出现异常，可能是没接转化SDK，回退普通调起" + e.getMessage());
                return new com.ss.android.downloadlib.addownload.g.e(8, 23);
            }
            wp.z().g(z, "realTryOpenByPackage", "包名调起失败了，抛出异常" + e.getMessage());
            return new com.ss.android.downloadlib.addownload.g.e(4, 23);
        }
    }

    static com.ss.android.downloadlib.addownload.g.e z(String str, com.ss.android.g.z.g.z zVar) {
        return z(com.ss.android.downloadlib.addownload.wp.getContext(), str, zVar);
    }

    static com.ss.android.downloadlib.addownload.g.e g(String str, com.ss.android.g.z.g.z zVar) {
        if (TextUtils.isEmpty(str)) {
            return new com.ss.android.downloadlib.addownload.g.e(2, 21);
        }
        Context context = com.ss.android.downloadlib.addownload.wp.getContext();
        String strSy = zVar.q().sy();
        if (!TextUtils.isEmpty(strSy)) {
            wp.z().z(z, "tryOpenByUrl", "获取到跳转中转Activity的intent");
            Intent intentZ = z(context, zVar, strSy, 2, str);
            if (intentZ != null) {
                com.ss.android.downloadlib.addownload.g.e eVarZ = z(context, intentZ, zVar, true, str);
                if (eVarZ.getType() == 1) {
                    return eVarZ;
                }
            }
        }
        Uri uri = Uri.parse(str);
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(uri);
        intent.addFlags(268435456);
        intent.putExtra("open_url", str);
        intent.putExtra("start_only_for_android", true);
        if (com.ss.android.socialbase.downloader.i.z.dl().z("fix_app_link_flag")) {
            intent.addFlags(67108864);
        }
        return z(context, intent, zVar, false, str);
    }

    private static com.ss.android.downloadlib.addownload.g.e z(Context context, Intent intent, com.ss.android.g.z.g.z zVar, boolean z2, String str) {
        if (context == null) {
            context = com.ss.android.downloadlib.addownload.wp.getContext();
        }
        if (i.g(context, intent)) {
            if (com.ss.android.downloadlib.addownload.wp.fo().optInt("open_url_mode") == 0 && com.ss.android.downloadlib.addownload.wp.wp() != null && com.ss.android.downloadlib.addownload.wp.wp().z() && zVar.p() && !z2) {
                TTDelegateActivity.z(str, zVar);
                return new com.ss.android.downloadlib.addownload.g.e(1);
            }
            try {
                context.startActivity(intent);
                return new com.ss.android.downloadlib.addownload.g.e(1);
            } catch (Exception e) {
                if (z2) {
                    wp.z().g(z, "realTryOpenByUrl", "商店直投注入clickId优化url调起场景，抛出异常，没接转化SDK，回退普通调起" + e.getMessage());
                    return new com.ss.android.downloadlib.addownload.g.e(9);
                }
                wp.z().g(z, "realTryOpenByUrl", "url调起失败了，抛出异常" + e.getMessage());
                return new com.ss.android.downloadlib.addownload.g.e(2);
            }
        }
        return new com.ss.android.downloadlib.addownload.g.e(2, 24);
    }

    static com.ss.android.downloadlib.addownload.g.e z(com.ss.android.g.z.g.g gVar, String str, String str2) {
        com.ss.android.downloadlib.addownload.g.e eVarG = g(str, gVar);
        return (com.ss.android.downloadlib.g.m.z(gVar) && eVarG.getType() == 2) ? z(str2, gVar) : eVarG;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void g(Context context, com.ss.android.downloadlib.addownload.g.gc gcVar, String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            TTDelegateActivity.g(str, gcVar.z, str2);
        } catch (Exception unused) {
            com.ss.android.downloadlib.g.z.z(z(context, Uri.parse("market://details?id=" + str)), gcVar, true);
            g(gcVar, jSONObject, 12, 9, "market://details?id=" + str);
        }
    }

    public static void g(Activity activity, String str, long j, String str2) {
        com.ss.android.downloadlib.addownload.g.gc gcVarGc = com.ss.android.downloadlib.addownload.g.m.z().gc(j);
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObjectFo = com.ss.android.downloadlib.addownload.wp.fo();
        String strOptString = jSONObjectFo.optString("s");
        String strZ = com.ss.android.socialbase.appdownloader.m.dl.z(jSONObjectFo.optString("bz"), strOptString);
        String strZ2 = com.ss.android.socialbase.appdownloader.m.dl.z(jSONObjectFo.optString("ca"), strOptString);
        String strZ3 = com.ss.android.socialbase.appdownloader.m.dl.z(jSONObjectFo.optString("cb"), strOptString);
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("hiapplink").authority("com.huawei.appmarket");
        if (!TextUtils.isEmpty(strZ)) {
            builder.appendQueryParameter(strZ, str2);
        }
        if (!TextUtils.isEmpty(strZ2) && !TextUtils.isEmpty(strZ3)) {
            builder.appendQueryParameter(strZ2, strZ3);
        }
        if (g(activity, builder.build())) {
            g(gcVarGc, jSONObject, -1, 9, "market://details?id=" + str);
            com.ss.android.downloadlib.g.z.z("am_hr", jSONObject, gcVarGc, true);
        } else {
            g(gcVarGc, jSONObject, 2, 9, "market://details?id=" + str);
            com.ss.android.downloadlib.g.z.z(z((Context) activity, Uri.parse("market://details?id=" + str)), gcVarGc, true);
        }
    }

    public static void z(Activity activity, String str, long j) {
        com.ss.android.downloadlib.addownload.g.gc gcVarGc = com.ss.android.downloadlib.addownload.g.m.z().gc(j);
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObjectFo = com.ss.android.downloadlib.addownload.wp.fo();
        String strOptString = jSONObjectFo.optString("s");
        String strZ = com.ss.android.socialbase.appdownloader.m.dl.z(jSONObjectFo.optString("ca"), strOptString);
        String strZ2 = com.ss.android.socialbase.appdownloader.m.dl.z(jSONObjectFo.optString("cc"), strOptString);
        StringBuilder sb = new StringBuilder("market://details?id=");
        if (!TextUtils.isEmpty(strZ) && !TextUtils.isEmpty(strZ2)) {
            sb.append(str).append("&").append(strZ).append("=").append(strZ2);
        }
        if (dl(activity, Uri.parse(sb.toString()))) {
            g(gcVarGc, jSONObject, -1, 10, "market://details?id=" + str);
            com.ss.android.downloadlib.g.z.z("am_hr2", jSONObject, gcVarGc, true);
        } else {
            g(gcVarGc, jSONObject, 2, 10, "market://details?id=" + str);
            com.ss.android.downloadlib.g.z.z(z((Context) activity, Uri.parse("market://details?id=" + str)), gcVarGc, true);
        }
    }

    public static void g(Activity activity, String str, long j) {
        com.ss.android.downloadlib.addownload.g.gc gcVarGc = com.ss.android.downloadlib.addownload.g.m.z().gc(j);
        JSONObject jSONObject = new JSONObject();
        boolean zP = ((com.ss.android.g.z.z.z) gcVarGc.f1987a).p();
        HashMap map = new HashMap();
        map.put("is_button", Boolean.valueOf(zP));
        i.z(jSONObject, "is_button", Boolean.valueOf(zP));
        Map<String, Object> mapZ = ((com.ss.android.g.z.z.z) gcVarGc.f1987a).fv().z(map);
        if (mapZ != null && mapZ.get("convert_result") != null && Boolean.parseBoolean(mapZ.get("convert_result").toString())) {
            g(gcVarGc, jSONObject, -1, 11, "market://details?id=" + str);
            com.ss.android.downloadlib.g.z.z("am_kllk4", jSONObject, gcVarGc, true);
        } else {
            g(gcVarGc, jSONObject, 15, 11, "market://details?id=" + str);
            com.ss.android.downloadlib.g.z.z(z((Context) activity, Uri.parse("market://details?id=" + str)), gcVarGc, true);
        }
    }

    static boolean dl(Context context, String str) {
        if (context == null) {
            return false;
        }
        try {
            Uri uri = Uri.parse(str);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(uri);
            intent.addFlags(268435456);
            intent.putExtra("open_url", str);
            intent.putExtra("start_only_for_android", true);
            context.startActivity(intent);
            return true;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.wp.z(th);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String dl(String str) {
        Matcher matcher = Pattern.compile("<input[\\s\\S]*>\\n").matcher(str);
        String strGroup = matcher.find() ? matcher.group() : "";
        if (!strGroup.equals(null) && strGroup.length() > 0) {
            for (String str2 : strGroup.split("\\n")) {
                if (str2.startsWith("<input")) {
                    for (String str3 : str2.split("\\s")) {
                        if (str3.startsWith("value")) {
                            return str3.substring(7, str3.length() - 1);
                        }
                    }
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String a(String str) {
        List<String> pathSegments = Uri.parse(str).getPathSegments();
        if (pathSegments.size() > 0) {
            return pathSegments.get(pathSegments.size() - 1);
        }
        return null;
    }

    private static Intent z(Context context, com.ss.android.g.z.g.z zVar, String str, int i, String str2) {
        if (!zVar.dl() || zVar.zw() == null || zVar.zw().g() != 2 || zVar.q() == null || gc.z(zVar).z("app_link_market_open_add_info", 0) != 1) {
            return null;
        }
        String strDl = com.ss.android.downloadlib.addownload.fo.dl(zVar.q());
        String strA = com.ss.android.downloadlib.addownload.fo.a(zVar.q());
        Intent intent = new Intent();
        intent.setClassName(str, "com.bytedance.ads.convert.BDBridgeActivity");
        ResolveInfo resolveInfoResolveActivity = context.getPackageManager().resolveActivity(intent, 0);
        if (TextUtils.isEmpty(strDl) || resolveInfoResolveActivity == null) {
            return null;
        }
        intent.putExtra("click_id", strDl);
        if (!(context instanceof Activity)) {
            intent.setFlags(268435456);
        }
        if (!TextUtils.isEmpty(strA)) {
            intent.putExtra("intent_extra", strA);
        }
        if (i == 2 && !TextUtils.isEmpty(str2)) {
            intent.putExtra("open_url", str2);
        }
        return intent;
    }
}
