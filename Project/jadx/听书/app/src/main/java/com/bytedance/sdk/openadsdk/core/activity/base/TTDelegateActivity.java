package com.bytedance.sdk.openadsdk.core.activity.base;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.bytedance.sdk.component.utils.g;
import com.bytedance.sdk.component.utils.tb;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.core.dislike.ui.z;
import com.bytedance.sdk.openadsdk.core.iq.m;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.ugeno.e.e;
import com.bytedance.sdk.openadsdk.core.un.eo;
import com.bytedance.sdk.openadsdk.core.un.oq;
import com.bytedance.sdk.openadsdk.core.widget.a;
import com.bytedance.sdk.openadsdk.core.widget.dl;
import com.bytedance.sdk.openadsdk.core.widget.e;
import com.bytedance.sdk.openadsdk.core.widget.fo;
import com.bytedance.sdk.openadsdk.core.widget.g;
import com.bytedance.sdk.openadsdk.core.widget.gc;
import com.bytedance.sdk.openadsdk.core.widget.gz;
import com.bytedance.sdk.openadsdk.core.widget.i;
import com.bytedance.sdk.openadsdk.core.widget.kb;
import com.bytedance.sdk.openadsdk.core.widget.ls;
import com.bytedance.sdk.openadsdk.core.widget.uy;
import com.bytedance.sdk.openadsdk.core.zw;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import java.util.ArrayList;
import java.util.function.Function;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class TTDelegateActivity extends Activity {
    private static String fv;
    private static e ls;
    private static String p;
    public static na z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.dislike.ui.z f914a;
    private AlertDialog dl;
    private gc e;
    private gz fo;
    private Intent g;
    private uy gc;
    private Dialog gz;
    private kb i;
    private dl kb;
    private a m;
    private ls pf;
    private Activity uy;
    private fo v;
    private g wp;

    public static void z(String str, String[] strArr) {
        Intent intent = new Intent(zw.getContext(), (Class<?>) TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("type", 4);
        intent.putExtra("permission_id_key", str);
        intent.putExtra("permission_content_key", strArr);
        if (zw.getContext() != null) {
            com.bytedance.sdk.component.utils.g.z(zw.getContext(), intent, new g.z() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.1
                @Override // com.bytedance.sdk.component.utils.g.z
                public void z() {
                }

                @Override // com.bytedance.sdk.component.utils.g.z
                public void z(Throwable th) {
                    wp.dl("requestPermission->startActivity error :" + th.toString());
                }
            });
        }
    }

    public static void z(Context context, String str, String str2, String str3) {
        if (context == null) {
            context = zw.getContext();
        }
        Intent intentZ = z(context);
        intentZ.putExtra("type", 3);
        intentZ.putExtra("app_download_url", str);
        intentZ.putExtra("dialog_title", str2);
        intentZ.putExtra("dialog_content_key", str3);
        com.bytedance.sdk.component.utils.g.z(context, intentZ, null);
    }

    private static Intent z(Context context) {
        Intent intent = new Intent(context, (Class<?>) TTDelegateActivity.class);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        return intent;
    }

    public static void z(e eVar) {
        ls = eVar;
    }

    public static void z(Context context, String str, String str2, String str3, e eVar, na naVar) {
        try {
            z = naVar;
            ls = eVar;
            if (context == null) {
                context = zw.getContext();
            }
            Intent intentZ = z(context);
            JSONObject jSONObject = new JSONObject(str3);
            intentZ.putExtra("type", 7);
            intentZ.putExtra("app_download_url", str);
            intentZ.putExtra("dialog_app_manage_model", str2);
            if (naVar != null) {
                intentZ.putExtra("event_adId", naVar.mj());
                intentZ.putExtra("event_extInfo", naVar.vk());
                intentZ.putExtra("event_TAG", eo.g(naVar));
            }
            intentZ.putExtra("dialog_title", jSONObject.optString("dialog_title"));
            intentZ.putExtra("dialog_icon_url", jSONObject.optString("dialog_icon_url"));
            intentZ.putExtra("dialog_app_description", jSONObject.optString("dialog_app_description"));
            intentZ.putExtra("is_easy_dl_dialog_pop_up_style", jSONObject.optBoolean("is_easy_dl_dialog_pop_up_style"));
            com.bytedance.sdk.component.utils.g.z(context, intentZ, null);
        } catch (Exception e) {
            wp.z(e);
        }
    }

    public static void z(Context context, String str, String str2, String str3, na naVar) {
        if (context == null) {
            try {
                context = zw.getContext();
            } catch (Exception e) {
                wp.z(e);
                return;
            }
        }
        Intent intentZ = z(context);
        JSONObject jSONObject = new JSONObject(str3);
        intentZ.putExtra("type", 7);
        intentZ.putExtra("app_download_url", str);
        intentZ.putExtra("dialog_app_manage_model", str2);
        if (naVar != null) {
            intentZ.putExtra("event_adId", naVar.mj());
            intentZ.putExtra("event_extInfo", naVar.vk());
            intentZ.putExtra("event_TAG", eo.g(naVar));
        }
        intentZ.putExtra("dialog_title", jSONObject.optString("dialog_title"));
        intentZ.putExtra("dialog_icon_url", jSONObject.optString("dialog_icon_url"));
        intentZ.putExtra("dialog_app_description", jSONObject.optString("dialog_app_description"));
        intentZ.putExtra("is_easy_dl_dialog_pop_up_style", jSONObject.optBoolean("is_easy_dl_dialog_pop_up_style"));
        com.bytedance.sdk.component.utils.g.z(context, intentZ, null);
    }

    public static void z(Context context, String str, String str2) {
        if (context == null) {
            context = zw.getContext();
        }
        Intent intentZ = z(context);
        intentZ.putExtra("type", 8);
        intentZ.putExtra("app_download_url", str);
        intentZ.putExtra("dialog_app_manage_model", str2);
        com.bytedance.sdk.component.utils.g.z(context, intentZ, null);
    }

    public static void z(Context context, String str) {
        if (context == null) {
            context = zw.getContext();
        }
        Intent intentZ = z(context);
        intentZ.putExtra("type", 10);
        intentZ.putExtra("dialog_content_key", str);
        com.bytedance.sdk.component.utils.g.z(context, intentZ, null);
    }

    public static void g(Context context, String str, String str2) {
        if (context == null) {
            context = zw.getContext();
        }
        m mVarA = a(str2);
        if (mVarA == null) {
            return;
        }
        Intent intentZ = z(context);
        intentZ.putExtra("type", 9);
        intentZ.putExtra("dialog_app_privacy_url", mVarA.gz());
        intentZ.putExtra("app_download_url", str);
        com.bytedance.sdk.component.utils.g.z(context, intentZ, null);
    }

    public static void z(Context context, String str, String str2, na naVar) {
        if (context == null) {
            context = zw.getContext();
        }
        m mVarA = a(str2);
        if (mVarA == null) {
            return;
        }
        if (naVar != null) {
            g(eo.g(naVar), naVar.vk(), naVar.mj());
        }
        Intent intentZ = z(context);
        intentZ.putExtra("type", 16);
        intentZ.putExtra("dialog_app_registration_url", mVarA.kb());
        intentZ.putExtra("app_download_url", str);
        com.bytedance.sdk.component.utils.g.z(context, intentZ, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void g(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.i.a.z(str, "click_other", str3, str2, new com.bytedance.sdk.openadsdk.m.z.z() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.12
            @Override // com.bytedance.sdk.openadsdk.m.z.z
            public void z(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("refer", "reg");
                jSONObject.put("ad_extra_data", jSONObject2);
            }
        });
    }

    public static void dl(Context context, String str, String str2) {
        if (context == null) {
            context = zw.getContext();
        }
        Intent intentZ = z(context);
        intentZ.putExtra("type", 14);
        intentZ.putExtra("dialog_app_desc_url", str2);
        intentZ.putExtra("app_download_url", str);
        com.bytedance.sdk.component.utils.g.z(context, intentZ, null);
    }

    public static void a(Context context, String str, String str2) {
        if (context == null) {
            context = zw.getContext();
        }
        Intent intentZ = z(context);
        intentZ.putExtra("type", 12);
        intentZ.putExtra("web_url", str);
        intentZ.putExtra("web_title", str2);
        com.bytedance.sdk.component.utils.g.z(context, intentZ, null);
    }

    public static void z(Context context, String str, String str2, String str3, String str4, String str5) {
        if (context == null) {
            context = zw.getContext();
        }
        Intent intentZ = z(context);
        intentZ.putExtra("type", 5);
        intentZ.putExtra("app_download_url", str);
        intentZ.putExtra("dialog_title", str2);
        intentZ.putExtra("dialog_content_key", str3);
        intentZ.putExtra("dialog_btn_yes_key", str4);
        intentZ.putExtra("dialog_btn_no_key", str5);
        com.bytedance.sdk.component.utils.g.z(context, intentZ, null);
    }

    public static void z(Context context, na naVar) {
        JSONObject jSONObjectKv;
        if (context == null) {
            context = zw.getContext();
        }
        Intent intentZ = z(context);
        intentZ.putExtra("type", 6);
        if (naVar != null && (jSONObjectKv = naVar.kv()) != null) {
            intentZ.putExtra("materialmeta", jSONObjectKv.toString());
        }
        if (context != null) {
            try {
                context.startActivity(intentZ);
            } catch (Throwable unused) {
            }
        }
    }

    public static void g(Context context, String str) {
        if (context == null) {
            context = zw.getContext();
        }
        Intent intentZ = z(context);
        intentZ.putExtra("type", 11);
        intentZ.putExtra("dialog_app_ad_info", str);
        com.bytedance.sdk.component.utils.g.z(context, intentZ, null);
    }

    private void g() {
        try {
            if (this.v == null) {
                this.v = new fo(this.uy, getIntent());
            }
            if (this.v.isShowing()) {
                this.v.dismiss();
            }
            this.v.z(new fo.z() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.15
                @Override // com.bytedance.sdk.openadsdk.core.widget.fo.z
                public void z(Dialog dialog) {
                    TTDelegateActivity.this.finish();
                }
            });
            this.v.show();
        } catch (Throwable unused) {
        }
    }

    private void dl() {
        if (com.bytedance.sdk.openadsdk.core.uy.ls().jq()) {
            if (this.kb == null && this.fo == null && this.i == null) {
                return;
            }
            com.bytedance.sdk.openadsdk.core.uy.ls().gz(false);
            finish();
        }
    }

    public void z(String str) {
        if (this.pf == null) {
            this.pf = new ls(this.uy, str);
        }
        if (this.pf.isShowing()) {
            this.pf.dismiss();
        }
        this.pf.z(new ls.z() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.16
            @Override // com.bytedance.sdk.openadsdk.core.widget.ls.z
            public void z(String str2) {
                com.bytedance.sdk.openadsdk.core.un.m.g(str2);
                TTDelegateActivity.this.finish();
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.ls.z
            public void g(String str2) {
                com.bytedance.sdk.openadsdk.core.un.m.a(str2);
                TTDelegateActivity.this.finish();
            }
        });
        this.pf.show();
    }

    public static void z(Context context, String str, boolean z2) {
        if (context == null) {
            context = zw.getContext();
        }
        Intent intentZ = z(context);
        intentZ.putExtra("type", 15);
        if (!z2) {
            intentZ.putExtra("web_url", str);
        }
        com.bytedance.sdk.component.utils.g.z(context, intentZ, null);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        gz gzVar = this.fo;
        if (gzVar != null) {
            p = gzVar.z();
        }
        dl dlVar = this.kb;
        if (dlVar != null) {
            fv = dlVar.a();
        }
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        dl();
    }

    public static void z(Context context, String str, na naVar) {
        if (context == null) {
            context = zw.getContext();
        }
        Intent intentZ = z(context);
        intentZ.putExtra("type", 13);
        z = naVar;
        intentZ.putExtra("event_tag", str);
        com.bytedance.sdk.component.utils.g.z(context, intentZ, null);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.uy = this;
        a();
        this.g = getIntent();
        if (zw.getContext() == null) {
            zw.z(this.uy);
        }
    }

    private void a() {
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.alpha = 0.0f;
        window.setAttributes(attributes);
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (zw.getContext() == null) {
            zw.z(this.uy);
        }
        try {
            setIntent(intent);
            this.g = intent;
        } catch (Throwable unused) {
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        if (getIntent() != null) {
            gc();
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        try {
            z = null;
            AlertDialog alertDialog = this.dl;
            if (alertDialog != null && alertDialog.isShowing()) {
                this.dl.dismiss();
            }
            gz gzVar = this.fo;
            if (gzVar != null && gzVar.isShowing()) {
                com.bytedance.sdk.openadsdk.core.un.m.z(this.fo.z());
                if (this.fo.isShowing()) {
                    this.fo.dismiss();
                }
            } else {
                com.bytedance.sdk.openadsdk.core.un.m.z(p);
            }
            a aVar = this.m;
            if (aVar != null && aVar.isShowing()) {
                this.m.dismiss();
            }
            dl dlVar = this.kb;
            if (dlVar != null) {
                if (dlVar.isShowing()) {
                    this.kb.dismiss();
                }
                com.bytedance.sdk.openadsdk.core.un.m.z(this.kb.a());
            } else {
                com.bytedance.sdk.openadsdk.core.un.m.z(fv);
            }
            com.bytedance.sdk.openadsdk.core.widget.g gVar = this.wp;
            if (gVar != null && gVar.isShowing()) {
                this.wp.dismiss();
            }
            gc gcVar = this.e;
            if (gcVar != null && gcVar.isShowing()) {
                this.e.dismiss();
            }
            kb kbVar = this.i;
            if (kbVar != null && kbVar.isShowing()) {
                this.i.dismiss();
            }
            Dialog dialog = this.gz;
            if (dialog != null && dialog.isShowing()) {
                this.gz.dismiss();
            }
            p = null;
            fv = null;
        } catch (Throwable th) {
            wp.dl("dialog", "onDestroy", th);
        }
        super.onDestroy();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        dl dlVar = this.kb;
        if (dlVar == null || dlVar.isShowing()) {
            return;
        }
        this.kb.z();
    }

    private void gc() {
        try {
            Intent intent = this.g;
            if (intent == null) {
            }
            int intExtra = intent.getIntExtra("type", 0);
            String stringExtra = this.g.getStringExtra("app_download_url");
            this.g.getStringExtra(NativeUnifiedADAppInfoImpl.Keys.APP_NAME);
            switch (intExtra) {
                case 1:
                    break;
                case 2:
                    m();
                    break;
                case 3:
                    dl(stringExtra, this.g.getStringExtra("dialog_title"), this.g.getStringExtra("dialog_content_key"));
                    break;
                case 4:
                    g(this.g.getStringExtra("permission_id_key"), this.g.getStringArrayExtra("permission_content_key"));
                    break;
                case 5:
                    g(stringExtra, this.g.getStringExtra("dialog_title"), this.g.getStringExtra("dialog_content_key"), this.g.getStringExtra("dialog_btn_yes_key"), this.g.getStringExtra("dialog_btn_no_key"));
                    break;
                case 6:
                    m(this.g.getStringExtra("materialmeta"));
                    break;
                case 7:
                    dl(stringExtra);
                    break;
                case 8:
                    z(this.g.getStringExtra("dialog_app_manage_model"), stringExtra);
                    break;
                case 9:
                    dl(this.g.getStringExtra("dialog_app_privacy_url"), stringExtra);
                    break;
                case 10:
                    g(this.g.getStringExtra("dialog_content_key"));
                    break;
                case 11:
                    gc(this.g.getStringExtra("dialog_app_ad_info"));
                    break;
                case 12:
                    g(this.g.getStringExtra("web_url"), this.g.getStringExtra("web_title"));
                    break;
                case 13:
                    g();
                    break;
                case 14:
                    z(this.g.getStringExtra("dialog_app_desc_url"), stringExtra, 1, true, (Dialog) null);
                    break;
                case 15:
                    z(this.g.getStringExtra("web_url"));
                    break;
                case 16:
                    z(this.g.getStringExtra("dialog_app_registration_url"), stringExtra, 3, true, (Dialog) null);
                    break;
                default:
                    finish();
                    break;
            }
        } catch (Exception unused) {
            finish();
        }
    }

    private void g(String str) {
        try {
            if (oq.fo(this.uy)) {
                Dialog dialog = this.gz;
                if (dialog == null || !dialog.isShowing()) {
                    com.bytedance.sdk.openadsdk.core.widget.z zVar = new com.bytedance.sdk.openadsdk.core.widget.z(this.uy, str);
                    this.gz = zVar;
                    zVar.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.17
                        @Override // android.content.DialogInterface.OnDismissListener
                        public void onDismiss(DialogInterface dialogInterface) {
                            TTDelegateActivity.this.finish();
                        }
                    });
                    this.gz.show();
                }
            }
        } catch (Throwable unused) {
        }
    }

    private void dl(final String str) {
        String str2;
        JSONArray jSONArray;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String strKb;
        String str8;
        String str9;
        float fDl;
        String str10;
        Intent intent = this.g;
        if (intent == null) {
            return;
        }
        final String stringExtra = intent.getStringExtra("event_extInfo");
        final String stringExtra2 = this.g.getStringExtra("event_adId");
        final String stringExtra3 = this.g.getStringExtra("event_TAG");
        String stringExtra4 = this.g.getStringExtra("dialog_app_manage_model");
        String stringExtra5 = this.g.getStringExtra("dialog_title");
        final String stringExtra6 = this.g.getStringExtra("dialog_icon_url");
        final String stringExtra7 = this.g.getStringExtra("dialog_app_description");
        boolean z2 = false;
        boolean booleanExtra = this.g.getBooleanExtra("is_easy_dl_dialog_pop_up_style", false);
        try {
            JSONArray jSONArray2 = null;
            String strOptString = "";
            float f = 0.0f;
            if (TextUtils.isEmpty(stringExtra4)) {
                str2 = stringExtra4;
                jSONArray = null;
                str3 = null;
                str4 = "";
                str5 = str4;
                str6 = str5;
                str7 = str6;
            } else {
                JSONObject jSONObject = new JSONObject(stringExtra4);
                m mVarGc = com.bytedance.sdk.openadsdk.core.z.gc(jSONObject);
                if (mVarGc != null) {
                    String strGc = mVarGc.gc();
                    String strE = mVarGc.e();
                    String strUy = mVarGc.uy();
                    String strV = mVarGc.v();
                    if (!TextUtils.isEmpty(strV)) {
                        stringExtra5 = strV;
                    }
                    JSONArray jSONArrayA = mVarGc.a();
                    fDl = mVarGc.dl();
                    strKb = mVarGc.kb();
                    strOptString = stringExtra5;
                    str8 = strGc;
                    str10 = strE;
                    jSONArray2 = jSONArrayA;
                    str9 = strUy;
                } else {
                    strKb = null;
                    str8 = "";
                    str9 = str8;
                    fDl = 0.0f;
                    str10 = str9;
                }
                String strOptString2 = jSONObject.optString("ugen_url");
                String strOptString3 = jSONObject.optString("ugen_md5");
                if (!TextUtils.isEmpty(strOptString2) && !TextUtils.isEmpty(strOptString3)) {
                    jSONObject.put(NativeUnifiedADAppInfoImpl.Keys.APP_NAME, strOptString);
                    jSONObject.put("icon_url", stringExtra6);
                    jSONObject.put("description", stringExtra7);
                    stringExtra4 = jSONObject.toString();
                    z2 = true;
                }
                str2 = stringExtra4;
                str6 = strOptString;
                str3 = strKb;
                str7 = str9;
                str4 = str8;
                strOptString = jSONObject.optString("hand_icon_url");
                jSONArray = jSONArray2;
                float f2 = fDl;
                str5 = str10;
                f = f2;
            }
            if (booleanExtra) {
                z(str, str2, stringExtra6, stringExtra7, str4, str5, str6, jSONArray, f, str7, str3, stringExtra, stringExtra3, stringExtra2);
                return;
            }
            if (z2) {
                final String str11 = str2;
                final float f3 = f;
                final String str12 = strOptString;
                final JSONArray jSONArray3 = jSONArray;
                final String str13 = str4;
                final String str14 = str5;
                final String str15 = str6;
                final String str16 = str7;
                final String str17 = str3;
                z(str, str2, new e() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.18
                    @Override // com.bytedance.sdk.openadsdk.core.ugeno.e.e
                    public void z(int i, String str18) {
                        TTDelegateActivity.this.z(str, str11, stringExtra6, f3, stringExtra7, str12, jSONArray3, str13, str14, str15, str16, str17, stringExtra2, stringExtra3, stringExtra);
                        if (TTDelegateActivity.this.fo != null) {
                            TTDelegateActivity.this.fo.z((e) null);
                        }
                        if (TTDelegateActivity.ls != null) {
                            TTDelegateActivity.ls.z(i, str18);
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.ugeno.e.e
                    public void z(com.bytedance.adsdk.ugeno.g.dl<View> dlVar) {
                        if (TTDelegateActivity.ls != null) {
                            TTDelegateActivity.ls.z(null);
                        }
                    }
                }, stringExtra2, stringExtra3, stringExtra);
                return;
            }
            z(str, str2, stringExtra6, f, stringExtra7, strOptString, jSONArray, str4, str5, str6, str7, str3, stringExtra2, stringExtra3, stringExtra);
        } catch (Throwable unused) {
        }
    }

    private static m a(String str) {
        try {
            return com.bytedance.sdk.openadsdk.core.z.gc(new JSONObject(str));
        } catch (Exception unused) {
            return null;
        }
    }

    private void z(String str, String str2, e eVar, String str3, String str4, String str5) {
        if (oq.fo(this.uy)) {
            if (TextUtils.isEmpty(str2)) {
                eVar.z(7, "uegnData is empty");
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str2);
                dl dlVar = this.kb;
                if (dlVar == null || !dlVar.isShowing()) {
                    dl dlVarFo = new i(this.uy, jSONObject, eVar).fo(str);
                    this.kb = dlVarFo;
                    ((i) dlVarFo).g(z(str, str2, str3, str4, str5));
                    this.kb.show();
                }
            } catch (Exception unused) {
            }
        }
    }

    private void z(final String str, final String str2, final String str3, final String str4, final String str5, final String str6, final String str7, final JSONArray jSONArray, final float f, final String str8, final String str9, final String str10, final String str11, final String str12) {
        z(str, str2, str7, f, new e() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.19
            @Override // com.bytedance.sdk.openadsdk.core.ugeno.e.e
            public void z(int i, String str13) {
                TTDelegateActivity.this.z(str, str2, str3, f, str4, "", jSONArray, str5, str6, str7, str8, str9, str12, str11, str10);
                if (TTDelegateActivity.this.fo != null) {
                    TTDelegateActivity.this.fo.z((e) null);
                }
                if (TTDelegateActivity.ls != null) {
                    TTDelegateActivity.ls.z(i, str13);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.e.e
            public void z(com.bytedance.adsdk.ugeno.g.dl<View> dlVar) {
                if (TTDelegateActivity.ls != null) {
                    TTDelegateActivity.ls.z(null);
                }
            }
        }, str10, str11, str12);
    }

    private void z(final String str, final String str2, String str3, float f, e eVar, final String str4, final String str5, final String str6) {
        if (oq.fo(this.uy)) {
            if (TextUtils.isEmpty(str2)) {
                eVar.z(7, "uegnData is empty");
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str2);
                if (!TextUtils.isEmpty(str3)) {
                    jSONObject.put(NativeUnifiedADAppInfoImpl.Keys.APP_NAME, str3);
                }
                jSONObject.put("score", f);
                JSONObject jSONObjectZ = com.bytedance.sdk.openadsdk.core.ugeno.uy.z(jSONObject.getString("ugen_dialog_url"), jSONObject.getString("ugen_dialog_md5"), (com.bytedance.sdk.openadsdk.core.ugeno.dl) null);
                if (jSONObjectZ == null) {
                    eVar.z(8, "uegnTemplate is empty");
                    return;
                }
                gz gzVar = this.fo;
                if (gzVar == null || !gzVar.isShowing()) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("easy_dl_dialog", jSONObject);
                    gz gzVar2 = new gz(str, this.uy, jSONObjectZ, jSONObject2, eVar, z);
                    this.fo = gzVar2;
                    gzVar2.z(new e.z() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.20
                        @Override // com.bytedance.sdk.openadsdk.core.widget.e.z
                        public void z(Dialog dialog) {
                            com.bytedance.sdk.openadsdk.core.un.m.g(str);
                            TTDelegateActivity.this.finish();
                        }

                        @Override // com.bytedance.sdk.openadsdk.core.widget.e.z
                        public void g(Dialog dialog) {
                            TTDelegateActivity tTDelegateActivity = TTDelegateActivity.this;
                            tTDelegateActivity.z(str2, str, false, (Dialog) tTDelegateActivity.fo);
                            if (TTDelegateActivity.this.fo != null) {
                                TTDelegateActivity.this.fo.hide();
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.core.widget.e.z
                        public void dl(Dialog dialog) {
                            com.bytedance.sdk.openadsdk.core.un.m.a(str);
                            TTDelegateActivity.this.finish();
                        }

                        @Override // com.bytedance.sdk.openadsdk.core.widget.e.z
                        public void a(Dialog dialog) {
                            try {
                                m mVarGc = com.bytedance.sdk.openadsdk.core.z.gc(new JSONObject(str2));
                                if (mVarGc != null) {
                                    TTDelegateActivity.this.z(mVarGc.gz(), str, 2, false, (Dialog) TTDelegateActivity.this.fo);
                                }
                            } catch (JSONException unused) {
                            }
                            if (TTDelegateActivity.this.fo != null) {
                                TTDelegateActivity.this.fo.hide();
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.core.widget.e.z
                        public void z() {
                            try {
                                m mVarGc = com.bytedance.sdk.openadsdk.core.z.gc(new JSONObject(str2));
                                if (mVarGc != null) {
                                    TTDelegateActivity.this.z(mVarGc.fo(), str, 1, false, (Dialog) TTDelegateActivity.this.fo);
                                }
                            } catch (JSONException unused) {
                            }
                            if (TTDelegateActivity.this.fo != null) {
                                TTDelegateActivity.this.fo.hide();
                            }
                        }
                    });
                    this.fo.show();
                }
            } catch (Exception e) {
                wp.z(e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(String str, String str2, String str3, float f, String str4, String str5, JSONArray jSONArray, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13) {
        if (oq.fo(this.uy)) {
            dl dlVar = this.kb;
            if (dlVar == null || !dlVar.isShowing()) {
                dl dlVarZ = new dl(this.uy).z(str8).gc(str6).m(str9).g(str3).gz(str7).fo(str).dl(str5).z(f).z(jSONArray).e(str10).a(str4).z(z(str, str2, str11, str12, str13));
                this.kb = dlVarZ;
                dlVarZ.show();
            }
        }
    }

    private dl.z z(final String str, final String str2, final String str3, final String str4, final String str5) {
        return new dl.z() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.21
            @Override // com.bytedance.sdk.openadsdk.core.widget.dl.z
            public void z(Dialog dialog) {
                com.bytedance.sdk.openadsdk.core.un.m.g(str);
                TTDelegateActivity.this.finish();
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.dl.z
            public void g(Dialog dialog) {
                TTDelegateActivity.this.z(str2, str, false, (Dialog) null);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.dl.z
            public void dl(Dialog dialog) {
                com.bytedance.sdk.openadsdk.core.un.m.a(str);
                TTDelegateActivity.this.finish();
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.dl.z
            public void a(Dialog dialog) {
                try {
                    m mVarGc = com.bytedance.sdk.openadsdk.core.z.gc(new JSONObject(str2));
                    if (mVarGc != null) {
                        TTDelegateActivity.this.z(mVarGc.gz(), str, 2, false, (Dialog) null);
                    }
                } catch (Exception unused) {
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.dl.z
            public void gc(Dialog dialog) {
                try {
                    m mVarGc = com.bytedance.sdk.openadsdk.core.z.gc(new JSONObject(str2));
                    if (mVarGc == null) {
                        return;
                    }
                    TTDelegateActivity.this.z(mVarGc.fo(), str, 1, false, (Dialog) null);
                } catch (Throwable unused) {
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.dl.z
            public void m(Dialog dialog) {
                try {
                    JSONObject jSONObject = new JSONObject(str2);
                    TTDelegateActivity.g(str4, str5, str3);
                    m mVarGc = com.bytedance.sdk.openadsdk.core.z.gc(jSONObject);
                    if (mVarGc == null) {
                        return;
                    }
                    TTDelegateActivity.this.z(mVarGc.kb(), str, 3, false, (Dialog) null);
                } catch (Exception unused) {
                }
            }
        };
    }

    private void z(String str, String str2) {
        if (this.g == null) {
            return;
        }
        z(str, str2, true, (Dialog) null);
    }

    private void g(String str, String str2) {
        try {
            if (oq.fo(this.uy)) {
                a aVar = this.m;
                if (aVar != null) {
                    aVar.dismiss();
                }
                a aVar2 = new a(this.uy, str, str2);
                this.m = aVar2;
                aVar2.z(new a.z() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.2
                    @Override // com.bytedance.sdk.openadsdk.core.widget.a.z
                    public void z(Dialog dialog) {
                        if (TTDelegateActivity.this.m != null) {
                            TTDelegateActivity.this.m.dismiss();
                            TTDelegateActivity.this.finish();
                        }
                    }
                });
                this.m.show();
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(String str, final String str2, int i, final boolean z2, final Dialog dialog) {
        String str3;
        String str4;
        try {
            if (oq.fo(this.uy)) {
                gc gcVar = this.e;
                if (gcVar != null) {
                    gcVar.dismiss();
                }
                if (i == 1) {
                    str3 = "https://apps.bytesfield.com/app_package_ce/appIntro";
                    str4 = "应用简介";
                } else if (i == 2) {
                    str3 = "https://sf1-amtos-cdn.bytesmanager.com/obj/ad-app-package/personal-privacy-page.html";
                    str4 = "隐私政策";
                } else if (i == 3) {
                    str4 = "备案信息";
                    str3 = null;
                } else {
                    str3 = null;
                    str4 = null;
                }
                gc gcVar2 = new gc(this.uy, str, str3, str4);
                this.e = gcVar2;
                gcVar2.z(new gc.z() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.3
                    @Override // com.bytedance.sdk.openadsdk.core.widget.gc.z
                    public void z(Dialog dialog2) {
                        com.bytedance.sdk.openadsdk.core.un.m.g(str2);
                        TTDelegateActivity.this.finish();
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.widget.gc.z
                    public void g(Dialog dialog2) {
                        com.bytedance.sdk.openadsdk.core.un.m.a(str2);
                        TTDelegateActivity.this.finish();
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.widget.gc.z
                    public void dl(Dialog dialog2) {
                        if (TTDelegateActivity.this.e != null) {
                            if (z2) {
                                com.bytedance.sdk.openadsdk.core.un.m.a(str2);
                                TTDelegateActivity.this.finish();
                            } else {
                                Dialog dialog3 = dialog;
                                if (dialog3 != null) {
                                    dialog3.show();
                                }
                                TTDelegateActivity.this.e.dismiss();
                            }
                        }
                    }
                });
                this.e.show();
            }
        } catch (Throwable unused) {
        }
    }

    private void dl(String str, String str2) {
        if (this.g == null) {
            return;
        }
        z(str, str2, 2, true, (Dialog) null);
    }

    private void gc(String str) {
        try {
            if (oq.fo(this.uy)) {
                kb kbVar = this.i;
                if (kbVar != null) {
                    kbVar.dismiss();
                }
                kb kbVar2 = new kb(this.uy, str);
                this.i = kbVar2;
                kbVar2.z(new kb.z() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.4
                    @Override // com.bytedance.sdk.openadsdk.core.widget.kb.z
                    public void z(Dialog dialog) {
                        TTDelegateActivity.this.finish();
                    }
                });
                this.i.show();
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(String str, final String str2, final boolean z2, final Dialog dialog) {
        try {
            if (oq.fo(this.uy)) {
                com.bytedance.sdk.openadsdk.core.widget.g gVar = this.wp;
                if (gVar != null) {
                    gVar.dismiss();
                }
                com.bytedance.sdk.openadsdk.core.widget.g gVar2 = new com.bytedance.sdk.openadsdk.core.widget.g(this.uy, str);
                this.wp = gVar2;
                gVar2.z(new g.z() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.5
                    @Override // com.bytedance.sdk.openadsdk.core.widget.g.z
                    public void z(Dialog dialog2) {
                        com.bytedance.sdk.openadsdk.core.un.m.g(str2);
                        TTDelegateActivity.this.finish();
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.widget.g.z
                    public void g(Dialog dialog2) {
                        com.bytedance.sdk.openadsdk.core.un.m.a(str2);
                        TTDelegateActivity.this.finish();
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.widget.g.z
                    public void dl(Dialog dialog2) {
                        if (TTDelegateActivity.this.wp != null) {
                            if (z2) {
                                com.bytedance.sdk.openadsdk.core.un.m.a(str2);
                                TTDelegateActivity.this.finish();
                            } else {
                                Dialog dialog3 = dialog;
                                if (dialog3 != null) {
                                    dialog3.show();
                                }
                                TTDelegateActivity.this.wp.dismiss();
                            }
                        }
                    }
                });
                this.wp.show();
            }
        } catch (Throwable unused) {
        }
    }

    private void m(String str) {
        if (oq.fo(this.uy)) {
            if (str != null && this.f914a == null) {
                try {
                    na naVarZ = com.bytedance.sdk.openadsdk.core.z.z(new JSONObject(str));
                    if (naVarZ != null) {
                        com.bytedance.sdk.openadsdk.core.dislike.ui.z zVar = new com.bytedance.sdk.openadsdk.core.dislike.ui.z(this.uy, naVarZ.ct(), false);
                        this.f914a = zVar;
                        com.bytedance.sdk.openadsdk.core.dislike.dl.z(this.uy, naVarZ, zVar);
                        this.f914a.z(new z.InterfaceC0168z() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.6
                            @Override // com.bytedance.sdk.openadsdk.core.dislike.ui.z.InterfaceC0168z
                            public void z() {
                            }

                            @Override // com.bytedance.sdk.openadsdk.core.dislike.ui.z.InterfaceC0168z
                            public void z(int i, String str2, boolean z2) {
                                TTDelegateActivity.this.finish();
                            }

                            @Override // com.bytedance.sdk.openadsdk.core.dislike.ui.z.InterfaceC0168z
                            public void g() {
                                TTDelegateActivity.this.finish();
                            }
                        });
                    }
                } catch (JSONException e) {
                    wp.z(e);
                }
            }
            com.bytedance.sdk.openadsdk.core.dislike.ui.z zVar2 = this.f914a;
            if (zVar2 != null) {
                zVar2.z();
            }
        }
    }

    private void g(final String str, String str2, String str3, String str4, String str5) {
        if (oq.fo(this.uy)) {
            AlertDialog alertDialog = this.dl;
            if (alertDialog != null) {
                alertDialog.dismiss();
            }
            if (this.gc == null) {
                this.gc = new uy(this.uy).z(str2).g(str3).dl(str4).a(str5).z(new uy.z() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.8
                    @Override // com.bytedance.sdk.openadsdk.core.widget.uy.z
                    public void onClickYes(Dialog dialog) {
                        com.bytedance.sdk.openadsdk.core.un.m.g(str);
                        TTDelegateActivity.this.finish();
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.widget.uy.z
                    public void onClickNo(Dialog dialog) {
                        com.bytedance.sdk.openadsdk.core.un.m.dl(str);
                        TTDelegateActivity.this.finish();
                    }
                }).z(new DialogInterface.OnCancelListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.7
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        com.bytedance.sdk.openadsdk.core.un.m.a(str);
                        TTDelegateActivity.this.finish();
                    }
                });
            }
            if (!this.gc.isShowing()) {
                this.gc.show();
            }
            this.dl = this.gc;
        }
    }

    private void g(final String str, String[] strArr) {
        if (TextUtils.isEmpty(str) || strArr == null || strArr.length <= 0) {
            finish();
            return;
        }
        try {
            com.bytedance.sdk.openadsdk.core.uf.gc.z().z(this.uy, strArr, new com.bytedance.sdk.openadsdk.core.uf.m() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.9
                @Override // com.bytedance.sdk.openadsdk.core.uf.m
                public void z() {
                    com.bytedance.sdk.openadsdk.core.un.e.z(str);
                    TTDelegateActivity.this.finish();
                }

                @Override // com.bytedance.sdk.openadsdk.core.uf.m
                public void z(String str2) {
                    com.bytedance.sdk.openadsdk.core.un.e.z(str, str2);
                    TTDelegateActivity.this.finish();
                }
            });
        } catch (Exception unused) {
            finish();
        }
    }

    private void dl(final String str, String str2, String str3) {
        if (oq.fo(this.uy)) {
            if (TextUtils.isEmpty(str2)) {
                str2 = tb.z(this.uy, "tt_tip");
            }
            String str4 = str2;
            if (TextUtils.isEmpty(str3)) {
                str3 = "";
            }
            z(str4, str3, new DialogInterface.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.10
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    com.bytedance.sdk.openadsdk.core.un.m.g(str);
                    TTDelegateActivity.this.finish();
                }
            }, new DialogInterface.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.11
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    com.bytedance.sdk.openadsdk.core.un.m.dl(str);
                    TTDelegateActivity.this.finish();
                }
            }, new DialogInterface.OnCancelListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.13
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    com.bytedance.sdk.openadsdk.core.un.m.a(str);
                    TTDelegateActivity.this.finish();
                }
            });
        }
    }

    private void m() {
        ApplicationInfo applicationInfo;
        try {
            com.bytedance.sdk.openadsdk.ls.dl.dl.a aVarJs = com.bytedance.sdk.openadsdk.core.uy.ls().js();
            boolean zDl = aVarJs.dl();
            boolean zGc = aVarJs.gc();
            ArrayList arrayList = new ArrayList();
            com.bytedance.sdk.openadsdk.pf.g.z(aVarJs, arrayList);
            if (zDl) {
                arrayList.add(com.kuaishou.weapon.p0.g.c);
            }
            if (zGc) {
                arrayList.add(com.kuaishou.weapon.p0.g.j);
            }
            Context context = zw.getContext();
            if (context != null && (applicationInfo = context.getApplicationInfo()) != null && applicationInfo.targetSdkVersion >= 33 && Build.VERSION.SDK_INT >= 33) {
                arrayList.add("android.permission.POST_NOTIFICATIONS");
            }
            String[] strArr = new String[arrayList.size()];
            arrayList.toArray(strArr);
            com.bytedance.sdk.openadsdk.core.uf.gc.z().z(this.uy, strArr, new com.bytedance.sdk.openadsdk.core.uf.m() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.14
                @Override // com.bytedance.sdk.openadsdk.core.uf.m
                public void z() {
                    com.bytedance.sdk.component.uy.e.z(new z("checkNecessaryPermission"), 1);
                    TTDelegateActivity.this.finish();
                }

                @Override // com.bytedance.sdk.openadsdk.core.uf.m
                public void z(String str) {
                    com.kuaishou.weapon.p0.g.c.equals(str);
                    com.bytedance.sdk.component.uy.e.z(new z("checkNecessaryPermission"), 1);
                    TTDelegateActivity.this.finish();
                }
            });
        } catch (Exception unused) {
            finish();
        }
    }

    private void z(String str, String str2, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2, DialogInterface.OnCancelListener onCancelListener) {
        try {
            if (this.dl == null) {
                this.dl = new AlertDialog.Builder(this.uy, tb.gz(this.uy, "Theme.Dialog.TTDownload")).create();
            }
            this.dl.setTitle(String.valueOf(str));
            this.dl.setMessage(String.valueOf(str2));
            this.dl.setButton(-1, tb.z(this.uy, "tt_label_ok"), onClickListener);
            this.dl.setButton(-2, tb.z(this.uy, "tt_label_cancel"), onClickListener2);
            this.dl.setOnCancelListener(onCancelListener);
            if (this.dl.isShowing()) {
                return;
            }
            this.dl.show();
        } catch (Exception e) {
            wp.z(e);
        }
    }

    public static class z extends com.bytedance.sdk.component.uy.fo {
        public z(String str) {
            super(str);
        }

        @Override // java.lang.Runnable
        public void run() {
            com.bytedance.sdk.openadsdk.core.kb.a.a aVarA = com.bytedance.sdk.openadsdk.core.kb.a.i.a();
            if (aVarA != null) {
                Function<SparseArray<Object>, Object> functionOq = com.bytedance.sdk.openadsdk.core.uy.ls().oq();
                if (functionOq != null) {
                    aVarA.z(com.bytedance.sdk.openadsdk.ls.dl.g(functionOq).booleanValue(1));
                }
                com.bytedance.sdk.openadsdk.core.tb.uy();
            }
        }
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        com.bytedance.sdk.openadsdk.core.uf.gc.z().z(this.uy, strArr, iArr);
        com.bytedance.sdk.component.uy.e.z(new z("onRequestPermissionsResult"), 1);
        finish();
    }
}
