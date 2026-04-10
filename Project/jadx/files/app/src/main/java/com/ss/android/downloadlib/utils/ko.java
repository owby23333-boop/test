package com.ss.android.downloadlib.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ss.android.download.api.config.l;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.downloadlib.activity.JumpKllkActivity;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.downloadlib.addownload.model.OpenAppResult;
import com.ss.android.downloadlib.constants.EventConstants;
import com.ss.android.downloadlib.event.AdEventHandler;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class ko {
    private static OpenAppResult b(Context context, com.ss.android.downloadlib.addownload.model.h hVar, String str) {
        Intent intent = new Intent(context, (Class<?>) JumpKllkActivity.class);
        intent.addFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
        intent.putExtra("p", str);
        intent.putExtra("id", hVar.mb);
        intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
        JSONObject jSONObject = new JSONObject();
        try {
            context.startActivity(intent);
            return new OpenAppResult(7, OpenAppResult.Source.AM_KLLK2);
        } catch (Throwable unused) {
            ox(hVar, jSONObject, 1, 3, BaseConstants.MARKET_PREFIX + str);
            return mb(context, Uri.parse(BaseConstants.MARKET_PREFIX + str));
        }
    }

    private static boolean h(Context context, String str) {
        if (context == null) {
            context = com.ss.android.downloadlib.addownload.x.getContext();
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        if (!(context instanceof Activity)) {
            intent.addFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
            if (DownloadSetting.obtainGlobal().optBugFix("fix_app_link_flag")) {
                intent.addFlags(32768);
            }
        }
        intent.setData(Uri.parse(str));
        intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
        String strLz = com.ss.android.socialbase.appdownloader.u.hj.lz();
        if (jb.hj(com.ss.android.downloadlib.addownload.x.getContext(), strLz)) {
            intent.setPackage(strLz);
        }
        if (!jb.mb(com.ss.android.downloadlib.addownload.x.getContext(), intent)) {
            return false;
        }
        try {
            context.startActivity(intent);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private static OpenAppResult hj(@NonNull Context context, @NonNull String str) {
        try {
            Uri uri = Uri.parse("https://www.samsungapps.com/appquery/appDetail.as?appId=" + str);
            Intent intent = new Intent();
            intent.setClassName("com.sec.android.app.samsungapps", "com.sec.android.app.samsungapps.Main");
            intent.setData(uri);
            if (!(context instanceof Activity)) {
                intent.addFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
            }
            intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
            context.startActivity(intent);
            return new OpenAppResult(5);
        } catch (Exception unused) {
            return new OpenAppResult(6, 14);
        }
    }

    private static void ox(final Context context, final com.ss.android.downloadlib.addownload.model.h hVar, final String str) {
        com.ss.android.downloadlib.hj.mb().mb(new Runnable() { // from class: com.ss.android.downloadlib.utils.ko.1
            @Override // java.lang.Runnable
            public void run() {
                final JSONObject jSONObjectLz = com.ss.android.downloadlib.addownload.x.lz();
                final String strOptString = jSONObjectLz.optString("s");
                final JSONObject jSONObject = new JSONObject();
                String strMb = com.ss.android.socialbase.appdownloader.u.b.mb(jSONObjectLz.optString("x"), strOptString);
                JSONObject jSONObject2 = new JSONObject();
                jb.mb(jSONObject2, "p", str);
                jb.mb(jSONObject2, "i", Build.VERSION.INCREMENTAL);
                jb.mb(jSONObject2, "m", Build.MODEL);
                jb.mb(jSONObject2, "im", com.ss.android.downloadlib.mb.mb.ox.mb(context));
                jb.mb(jSONObject2, "d", com.ss.android.downloadlib.mb.mb.ox.ox(context));
                jb.mb(jSONObject2, "t", "m");
                byte[] bytes = jSONObject2.toString().getBytes();
                com.ss.android.downloadlib.addownload.x.hj().mb(strMb, com.ss.android.downloadlib.addownload.x.e().mb(bytes, bytes.length), "application/octet-stream;tt-data=a", 0, new l() { // from class: com.ss.android.downloadlib.utils.ko.1.1
                    @Override // com.ss.android.download.api.config.l
                    public void mb(String str2) {
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        ko.ox(context, str, str2, hVar, jSONObject, jSONObjectLz, strOptString);
                    }

                    @Override // com.ss.android.download.api.config.l
                    public void mb(Throwable th) {
                        com.ss.android.downloadlib.ox.mb.mb(ko.mb(context, Uri.parse(BaseConstants.MARKET_PREFIX + str)), hVar, true);
                        jb.mb(jSONObject, EventConstants.ExtraJson.KEY_MESSAGE, th != null ? th.getMessage() : "null");
                        ko.ox(hVar, jSONObject, 4, 1, BaseConstants.MARKET_PREFIX + str);
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void ox(Context context, String str, String str2, @NonNull com.ss.android.downloadlib.addownload.model.h hVar, @NonNull JSONObject jSONObject, @NonNull JSONObject jSONObject2, String str3) {
        jb.mb(jSONObject, EventConstants.ExtraJson.KEY_TYPE, (Object) 1);
        try {
            String strMb = mb(com.ss.android.socialbase.appdownloader.u.b.mb(new JSONObject(str2).optString("a")), jSONObject2, str3);
            jb.mb(jSONObject, EventConstants.ExtraJson.OPEN_URL, strMb);
            if (h(context, strMb)) {
                ox(hVar, jSONObject, -1, 1, strMb);
                com.ss.android.downloadlib.ox.mb.mb(OpenAppResult.Source.AM_M1, jSONObject, hVar, true);
            } else {
                com.ss.android.downloadlib.ox.mb.mb(mb(context, Uri.parse(BaseConstants.MARKET_PREFIX + str)), hVar, true);
                ox(hVar, jSONObject, 2, 1, BaseConstants.MARKET_PREFIX + str);
            }
        } catch (Exception unused) {
            com.ss.android.downloadlib.ox.mb.mb(mb(context, Uri.parse(BaseConstants.MARKET_PREFIX + str)), hVar, true);
            ox(hVar, jSONObject, 3, 1, BaseConstants.MARKET_PREFIX + str);
        }
    }

    public static OpenAppResult mb(Context context, Uri uri) {
        if (context != null && uri != null && "market".equals(uri.getScheme())) {
            try {
                Intent intent = new Intent("android.intent.action.VIEW", uri);
                if (!jb.mb(context, intent)) {
                    return new OpenAppResult(6, 13);
                }
                String strLz = com.ss.android.socialbase.appdownloader.u.hj.lz();
                if (jb.hj(context, strLz) && !com.ss.android.socialbase.appdownloader.u.hj.u()) {
                    intent.setPackage(strLz);
                }
                if (DownloadSetting.obtainGlobal().optBugFix("fix_jump_market")) {
                    intent.addFlags(335544320);
                } else if (!(context instanceof Activity)) {
                    intent.addFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
                }
                if (DownloadSetting.obtainGlobal().optInt("test_jump_market_failed") == 1) {
                    com.ss.android.downloadlib.exception.b.mb().mb(false, "jump market error");
                    return new OpenAppResult(6, 25);
                }
                intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
                context.startActivity(intent);
                return new OpenAppResult(5);
            } catch (Exception unused) {
                return new OpenAppResult(6, 14);
            }
        }
        return new OpenAppResult(6, 12);
    }

    static boolean b(Context context, String str) {
        if (context == null) {
            return false;
        }
        try {
            Uri uri = Uri.parse(str);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(uri);
            intent.addFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
            intent.putExtra(EventConstants.ExtraJson.OPEN_URL, str);
            intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
            context.startActivity(intent);
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    private static void hj(final Context context, final com.ss.android.downloadlib.addownload.model.h hVar, final String str) {
        com.ss.android.downloadlib.hj.mb().mb(new Runnable() { // from class: com.ss.android.downloadlib.utils.ko.2
            @Override // java.lang.Runnable
            public void run() {
                com.ss.android.downloadlib.ox.mb.mb(ko.mb(context, Uri.parse(BaseConstants.MARKET_PREFIX + str)), hVar, true);
                JSONObject jSONObject = new JSONObject();
                try {
                    JSONObject jSONObjectLz = com.ss.android.downloadlib.addownload.x.lz();
                    Thread.sleep(jSONObjectLz.optInt("m2_delay_millis", 1000));
                    com.ss.android.downloadlib.mb.ox.mb.mb().mb(context, true);
                    com.ss.android.downloadlib.mb.ox.ox oxVar = new com.ss.android.downloadlib.mb.ox.ox();
                    oxVar.mb = 1;
                    oxVar.ox = 0;
                    String strMb = com.ss.android.socialbase.appdownloader.u.b.mb(jSONObjectLz.optString("v"), jSONObjectLz.optString("s"));
                    oxVar.b = String.format(strMb, str);
                    com.ss.android.downloadlib.mb.ox.mb.mb().mb(oxVar, (com.ss.android.downloadlib.mb.ox.hj) null);
                    com.ss.android.downloadlib.mb.ox.mb.mb().ox();
                    ko.ox(hVar, jSONObject, -1, 2, String.format(strMb, str));
                } catch (Throwable th) {
                    th.printStackTrace();
                    ko.ox(hVar, jSONObject, 1, 2, BaseConstants.MARKET_PREFIX + str);
                }
            }
        });
    }

    private static void h(final Context context, final com.ss.android.downloadlib.addownload.model.h hVar, final String str) {
        com.ss.android.downloadlib.hj.mb().mb(new Runnable() { // from class: com.ss.android.downloadlib.utils.ko.3
            @Override // java.lang.Runnable
            public void run() {
                JSONObject jSONObjectLz = com.ss.android.downloadlib.addownload.x.lz();
                String strOptString = jSONObjectLz.optString("s");
                final JSONObject jSONObject = new JSONObject();
                String strMb = com.ss.android.socialbase.appdownloader.u.b.mb(jSONObjectLz.optString("x"), strOptString);
                JSONObject jSONObject2 = new JSONObject();
                jb.mb(jSONObject2, "t", "v");
                jb.mb(jSONObject2, "p", str);
                byte[] bytes = jSONObject2.toString().getBytes();
                com.ss.android.downloadlib.addownload.x.hj().mb(strMb, com.ss.android.downloadlib.addownload.x.e().mb(bytes, bytes.length), "application/octet-stream;tt-data=a", 0, new l() { // from class: com.ss.android.downloadlib.utils.ko.3.1
                    @Override // com.ss.android.download.api.config.l
                    public void mb(String str2) {
                        AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                        ko.ox(context, str, str2, hVar, jSONObject);
                    }

                    @Override // com.ss.android.download.api.config.l
                    public void mb(Throwable th) {
                        com.ss.android.downloadlib.ox.mb.mb(ko.mb(context, Uri.parse(BaseConstants.MARKET_PREFIX + str)), hVar, true);
                        jb.mb(jSONObject, EventConstants.ExtraJson.KEY_MESSAGE, th != null ? th.getMessage() : "null");
                        ko.ox(hVar, jSONObject, 7, 5, BaseConstants.MARKET_PREFIX + str);
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void ox(Context context, String str, String str2, @NonNull com.ss.android.downloadlib.addownload.model.h hVar, @NonNull JSONObject jSONObject) {
        jb.mb(jSONObject, EventConstants.ExtraJson.KEY_TYPE, (Object) 5);
        try {
            String strMb = com.ss.android.socialbase.appdownloader.u.b.mb(new JSONObject(str2).optString("a"));
            if (!TextUtils.isEmpty(strMb)) {
                TTDelegateActivity.mb(str, hVar.mb, strMb, jSONObject);
            } else {
                com.ss.android.downloadlib.ox.mb.mb(mb(context, Uri.parse(BaseConstants.MARKET_PREFIX + str)), hVar, true);
                ox(hVar, jSONObject, 5, 5, BaseConstants.MARKET_PREFIX + str);
            }
        } catch (Exception unused) {
            com.ss.android.downloadlib.ox.mb.mb(mb(context, Uri.parse(BaseConstants.MARKET_PREFIX + str)), hVar, true);
            ox(hVar, jSONObject, 6, 5, BaseConstants.MARKET_PREFIX + str);
        }
    }

    public static OpenAppResult mb(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            if (com.ss.android.socialbase.appdownloader.u.hj.u() && jb.hj(context, "com.sec.android.app.samsungapps")) {
                return hj(context, str);
            }
            return mb(context, Uri.parse(BaseConstants.MARKET_PREFIX + str));
        }
        return new OpenAppResult(6, 11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void ox(com.ss.android.downloadlib.addownload.model.h hVar, JSONObject jSONObject, int i2, int i3, String str) {
        jb.mb(jSONObject, "error_code", Integer.valueOf(i2));
        jb.mb(jSONObject, EventConstants.ExtraJson.KEY_TYPE, Integer.valueOf(i3));
        jb.mb(jSONObject, EventConstants.ExtraJson.KEY_REAL_MARKET_URL, str);
        jb.mb(jSONObject, com.ss.android.socialbase.appdownloader.u.hj.lz(), Integer.valueOf(jb.ox(com.ss.android.downloadlib.addownload.x.getContext(), com.ss.android.socialbase.appdownloader.u.hj.lz())));
        AdEventHandler.mb().ox(EventConstants.Label.ANTI_MARKET_RESULT, jSONObject, hVar);
    }

    public static OpenAppResult mb(Context context, com.ss.android.downloadlib.addownload.model.h hVar, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            if (com.ss.android.socialbase.appdownloader.u.hj.u() && jb.hj(context, "com.sec.android.app.samsungapps")) {
                return hj(context, str);
            }
            if (hVar.ox.isAd() && hVar.hj.enableAM()) {
                JSONArray jSONArrayOptJSONArray = com.ss.android.downloadlib.addownload.x.lz().optJSONArray("am_plans");
                if (com.ss.android.socialbase.appdownloader.u.hj.ox() && com.ss.android.socialbase.appdownloader.u.mb.mb(jSONArrayOptJSONArray, "am_0")) {
                    ox(context, hVar, str);
                    return new OpenAppResult(7, OpenAppResult.Source.AM_M1);
                }
                if (com.ss.android.socialbase.appdownloader.u.hj.hj() && com.ss.android.socialbase.appdownloader.u.mb.mb(jSONArrayOptJSONArray, "am_3")) {
                    return b(context, hVar, str);
                }
                if (com.ss.android.socialbase.appdownloader.u.hj.h() && com.ss.android.socialbase.appdownloader.u.mb.mb(jSONArrayOptJSONArray, "am_2")) {
                    hj(context, hVar, str);
                    return new OpenAppResult(7, OpenAppResult.Source.AM_M2);
                }
                if (com.ss.android.socialbase.appdownloader.u.hj.ox() && com.ss.android.socialbase.appdownloader.u.mb.mb(jSONArrayOptJSONArray, "am_6")) {
                    return mb(context, mb(hVar));
                }
                if (com.ss.android.socialbase.appdownloader.u.hj.b() && com.ss.android.socialbase.appdownloader.u.mb.mb(jSONArrayOptJSONArray, "am_5")) {
                    h(context, hVar, str);
                    return new OpenAppResult(7, OpenAppResult.Source.AM_V1);
                }
                return mb(context, Uri.parse(BaseConstants.MARKET_PREFIX + str));
            }
            return mb(context, Uri.parse(BaseConstants.MARKET_PREFIX + str));
        }
        return new OpenAppResult(6, 11);
    }

    static OpenAppResult ox(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return new OpenAppResult(4, 11);
        }
        if (context == null) {
            context = com.ss.android.downloadlib.addownload.x.getContext();
        }
        Intent intentU = jb.u(context, str);
        if (intentU == null) {
            return new OpenAppResult(4, 22);
        }
        intentU.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
        try {
            context.startActivity(intentU);
            return new OpenAppResult(3);
        } catch (Exception unused) {
            return new OpenAppResult(4, 23);
        }
    }

    static OpenAppResult ox(String str, @NonNull com.ss.android.downloadad.api.mb.mb mbVar) {
        if (TextUtils.isEmpty(str)) {
            return new OpenAppResult(2, 21);
        }
        Context context = com.ss.android.downloadlib.addownload.x.getContext();
        Uri uri = Uri.parse(str);
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(uri);
        intent.addFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
        intent.putExtra(EventConstants.ExtraJson.OPEN_URL, str);
        intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
        if (DownloadSetting.obtainGlobal().optBugFix("fix_app_link_flag")) {
            intent.addFlags(DownloadExpSwitchCode.BACK_BUGFIX_SIGBUS);
        }
        if (jb.ox(context, intent)) {
            if (com.ss.android.downloadlib.addownload.x.lz().optInt("open_url_mode") == 0 && com.ss.android.downloadlib.addownload.x.jb() != null && com.ss.android.downloadlib.addownload.x.jb().mb() && Build.VERSION.SDK_INT >= 26 && mbVar.e()) {
                TTDelegateActivity.mb(str, mbVar);
            } else {
                try {
                    com.ss.android.downloadlib.addownload.x.getContext().startActivity(intent);
                } catch (Exception unused) {
                    return new OpenAppResult(2);
                }
            }
            return new OpenAppResult(1);
        }
        return new OpenAppResult(2, 24);
    }

    private static String mb(String str, @NonNull JSONObject jSONObject, String str2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String strMb = com.ss.android.socialbase.appdownloader.u.b.mb(jSONObject.optString("g"), str2);
        String strMb2 = com.ss.android.socialbase.appdownloader.u.b.mb(jSONObject.optString("h"), str2);
        return (TextUtils.isEmpty(strMb) || TextUtils.isEmpty(strMb2)) ? str : str.replace(strMb, strMb2);
    }

    public static void mb(Context context, String str, long j2, boolean z2) {
        JSONObject jSONObject = new JSONObject();
        com.ss.android.downloadlib.addownload.model.h hVarH = com.ss.android.downloadlib.addownload.model.u.mb().h(j2);
        try {
            JSONObject jSONObjectLz = com.ss.android.downloadlib.addownload.x.lz();
            String strOptString = jSONObjectLz.optString("s");
            String strMb = com.ss.android.socialbase.appdownloader.u.b.mb(jSONObjectLz.optString(com.anythink.expressad.d.a.b.f8398w), strOptString);
            String strMb2 = com.ss.android.socialbase.appdownloader.u.b.mb(jSONObjectLz.optString(com.anythink.expressad.d.a.b.da), strOptString);
            String strMb3 = com.ss.android.socialbase.appdownloader.u.b.mb(jSONObjectLz.optString("af"), strOptString);
            boolean zMb = com.ss.android.socialbase.appdownloader.u.mb.mb(jSONObjectLz, context, strMb2);
            StringBuilder sb = new StringBuilder(String.format(strMb, str, strMb3, strMb2));
            Intent intent = new Intent("android.intent.action.VIEW");
            String strLz = com.ss.android.socialbase.appdownloader.u.hj.lz();
            if (jb.hj(context, strLz)) {
                intent.setPackage(strLz);
            }
            if (z2) {
                sb.append(com.ss.android.socialbase.appdownloader.u.b.mb(jSONObjectLz.optString("ae"), strOptString));
            } else {
                intent.addFlags(335544320);
            }
            jb.mb(jSONObject, "mf", Boolean.valueOf(zMb));
            jb.mb(jSONObject, "if", Boolean.valueOf(z2));
            intent.setData(Uri.parse(sb.toString()));
            intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
            context.startActivity(intent);
            com.ss.android.downloadlib.ox.mb.mb(OpenAppResult.Source.AM_KLLK2, jSONObject, hVarH, true);
            if (zMb) {
                ox(hVarH, jSONObject, -1, 3, sb.toString());
            } else {
                ox(hVarH, jSONObject, 3, 3, sb.toString());
            }
        } catch (Exception unused) {
            com.ss.android.downloadlib.ox.mb.mb(mb(com.ss.android.downloadlib.addownload.x.getContext(), Uri.parse(BaseConstants.MARKET_PREFIX + str)), hVarH, true);
            ox(hVarH, jSONObject, 2, 3, BaseConstants.MARKET_PREFIX + str);
        }
    }

    private static boolean mb(@NonNull Activity activity, @NonNull String str, @NonNull HashMap<String, String> map) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(BaseConstants.MARKET_PREFIX + str));
        intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
        intent.putExtra("param", map);
        String strLz = com.ss.android.socialbase.appdownloader.u.hj.lz();
        if (jb.hj(com.ss.android.downloadlib.addownload.x.getContext(), strLz)) {
            intent.setPackage(strLz);
        }
        if (!jb.mb(com.ss.android.downloadlib.addownload.x.getContext(), intent)) {
            return false;
        }
        try {
            activity.startActivity(intent);
            return true;
        } catch (Exception e2) {
            com.ss.android.downloadlib.exception.b.mb().mb(e2, "start v1");
            return false;
        }
    }

    public static void mb(@NonNull Activity activity, String str, long j2, String str2, String str3) {
        JSONObject jSONObject;
        int i2;
        try {
            jSONObject = new JSONObject(str3);
        } catch (JSONException unused) {
            jSONObject = new JSONObject();
        }
        com.ss.android.downloadlib.addownload.model.h hVarH = com.ss.android.downloadlib.addownload.model.u.mb().h(j2);
        try {
            JSONObject jSONObjectLz = com.ss.android.downloadlib.addownload.x.lz();
            boolean zMb = com.ss.android.socialbase.appdownloader.u.mb.mb(jSONObjectLz, activity, com.ss.android.socialbase.appdownloader.u.b.mb(jSONObjectLz.optString("bg"), jSONObjectLz.optString("s")));
            HashMap<String, String> mapOx = jb.ox(new JSONObject(str2));
            if (zMb && !mapOx.isEmpty() && mb(activity, str, mapOx)) {
                ox(hVarH, jSONObject, -1, 5, BaseConstants.MARKET_PREFIX + str);
                com.ss.android.downloadlib.ox.mb.mb(OpenAppResult.Source.AM_V1, jSONObject, hVarH, true);
                return;
            }
            if (zMb) {
                i2 = mapOx.isEmpty() ? 1 : 2;
            } else {
                i2 = 3;
            }
            ox(hVarH, jSONObject, i2, 5, BaseConstants.MARKET_PREFIX + str);
            com.ss.android.downloadlib.ox.mb.mb(mb(activity, Uri.parse(BaseConstants.MARKET_PREFIX + str)), hVarH, true);
        } catch (Exception unused2) {
            com.ss.android.downloadlib.ox.mb.mb(mb(com.ss.android.downloadlib.addownload.x.getContext(), Uri.parse(BaseConstants.MARKET_PREFIX + str)), hVarH, true);
            ox(hVarH, jSONObject, 4, 5, BaseConstants.MARKET_PREFIX + str);
        }
    }

    static OpenAppResult mb(Context context, String str, com.ss.android.downloadad.api.mb.mb mbVar) {
        Intent intentU = jb.u(context, str);
        if (intentU == null) {
            return new OpenAppResult(4, 22);
        }
        if (Build.VERSION.SDK_INT >= 26 && com.ss.android.downloadlib.addownload.x.lz().optInt("open_package_mode") == 1 && com.ss.android.downloadlib.addownload.x.jb() != null && com.ss.android.downloadlib.addownload.x.jb().mb() && mbVar.e()) {
            TTDelegateActivity.ox(str, mbVar);
            return new OpenAppResult(3);
        }
        intentU.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
        try {
            context.startActivity(intentU);
            return new OpenAppResult(3);
        } catch (Exception unused) {
            return new OpenAppResult(4, 23);
        }
    }

    static OpenAppResult mb(String str, com.ss.android.downloadad.api.mb.mb mbVar) {
        return mb(com.ss.android.downloadlib.addownload.x.getContext(), str, mbVar);
    }

    static OpenAppResult mb(@NonNull com.ss.android.downloadad.api.mb.ox oxVar, String str, String str2) {
        OpenAppResult openAppResultOx = ox(str, oxVar);
        return (com.ss.android.downloadlib.ox.u.mb(oxVar) && openAppResultOx.getType() == 2) ? mb(str2, oxVar) : openAppResultOx;
    }

    public static Uri mb(com.ss.android.downloadlib.addownload.model.h hVar) {
        String strH = hVar.h();
        Uri.Builder builder = new Uri.Builder();
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObjectLz = com.ss.android.downloadlib.addownload.x.lz();
        String strMb = com.ss.android.socialbase.appdownloader.u.b.mb(jSONObjectLz.optString("bl"), jSONObjectLz.optString("s"));
        builder.scheme("market").authority("details").appendQueryParameter("id", strH);
        if (!TextUtils.isEmpty(strMb)) {
            builder.appendPath(strMb);
        }
        Uri uriBuild = builder.build();
        ox(hVar, jSONObject, -1, 6, uriBuild.toString());
        return uriBuild;
    }
}
