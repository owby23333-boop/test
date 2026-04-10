package com.bytedance.msdk.core.admanager.reward.rewardagain;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.gromore.R;
import com.bytedance.msdk.core.gc.g.a;
import com.bytedance.msdk.core.gz.i;
import com.bytedance.msdk.dl.a.wp;
import com.bytedance.msdk.gc.m;
import com.bytedance.msdk.gz.l;
import java.lang.ref.SoftReference;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class dl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.bytedance.msdk.api.a.z.gz.z f375a;
    private com.bytedance.msdk.api.a.z.gz.z dl;
    private String e;
    private final com.bytedance.msdk.api.z.g g;
    private Activity gc;
    private Object m;
    private final SoftReference<Context> z;
    private static final Map<String, g> uy = new ConcurrentHashMap();
    private static final Map<String, com.bytedance.msdk.core.admanager.reward.rewardagain.z> kb = new ConcurrentHashMap();
    private static z wp = new z();
    private volatile boolean gz = false;
    private volatile boolean fo = false;

    public static class z {
        public Runnable dl;
        public Runnable g;
        public g z;
    }

    public dl(Context context, com.bytedance.msdk.api.z.g gVar, com.bytedance.msdk.api.a.z.gz.z zVar, com.bytedance.msdk.api.a.z.gz.z zVar2) {
        this.z = new SoftReference<>(context);
        this.g = gVar;
        if (zVar != null) {
            this.dl = zVar;
        }
        if (zVar2 != null) {
            this.f375a = zVar2;
        }
    }

    public void z(Activity activity, Object obj, String str) {
        this.gc = activity;
        this.m = obj;
        this.e = str;
    }

    public void z(com.bytedance.msdk.api.a.z.gz.z zVar) {
        if (zVar != null) {
            this.dl = zVar;
        }
    }

    public void g(com.bytedance.msdk.api.a.z.gz.z zVar) {
        if (zVar != null) {
            this.f375a = zVar;
        }
    }

    public void z(final com.bytedance.msdk.core.admanager.reward.rewardagain.z zVar, final com.bytedance.msdk.g.dl dlVar) {
        Activity activity = this.gc;
        if (activity != null && !activity.isFinishing() && !this.gc.isDestroyed()) {
            final Dialog dialog = new Dialog(this.gc);
            View viewInflate = LayoutInflater.from(this.gc.getApplicationContext()).inflate(R.layout.reward_again_dialog, (ViewGroup) null);
            ImageView imageView = (ImageView) viewInflate.findViewById(R.id.ra_pic);
            TextView textView = (TextView) viewInflate.findViewById(R.id.ra_title);
            TextView textView2 = (TextView) viewInflate.findViewById(R.id.ra_btn_ok);
            TextView textView3 = (TextView) viewInflate.findViewById(R.id.ra_btn_cancel);
            g gVar = uy.get(zVar.a());
            if (gVar != null) {
                textView.setText(gVar.g());
                textView2.setText(gVar.a());
                textView3.setText(gVar.gc());
                if (!TextUtils.isEmpty(gVar.dl())) {
                    new com.bytedance.msdk.z.gc.g(imageView).z((Object[]) new String[]{gVar.dl()});
                }
            }
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.msdk.core.admanager.reward.rewardagain.dl.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    dl.this.dl(zVar, dlVar);
                    dialog.dismiss();
                }
            });
            textView3.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.msdk.core.admanager.reward.rewardagain.dl.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    dl.this.gc();
                    dialog.dismiss();
                }
            });
            dialog.setContentView(viewInflate);
            dialog.setCanceledOnTouchOutside(false);
            dialog.setCancelable(false);
            dialog.show();
            return;
        }
        com.bytedance.msdk.z.gc.dl.z("TTMediationSDK", "--==-- reward again show activity dialog");
        g(zVar, dlVar);
    }

    private void g(final com.bytedance.msdk.core.admanager.reward.rewardagain.z zVar, final com.bytedance.msdk.g.dl dlVar) {
        z zVar2 = new z();
        wp = zVar2;
        zVar2.z = uy.get(zVar.a());
        wp.g = new Runnable() { // from class: com.bytedance.msdk.core.admanager.reward.rewardagain.dl.3
            @Override // java.lang.Runnable
            public void run() {
                dl.this.dl(zVar, dlVar);
                dl.gz();
            }
        };
        wp.dl = new Runnable() { // from class: com.bytedance.msdk.core.admanager.reward.rewardagain.dl.4
            @Override // java.lang.Runnable
            public void run() {
                dl.this.gc();
                dl.gz();
            }
        };
        Intent intent = new Intent(com.bytedance.msdk.core.g.getContext(), (Class<?>) GMRewardAgainDialogActivity.class);
        intent.setFlags(268435456);
        com.bytedance.msdk.core.g.getContext().startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dl(com.bytedance.msdk.core.admanager.reward.rewardagain.z zVar, com.bytedance.msdk.g.dl dlVar) {
        int iZ = z(this.g, zVar, dlVar);
        m.dl(this.g, iZ);
        if (iZ == 0) {
            z();
            return;
        }
        com.bytedance.msdk.api.a.z.gz.z zVar2 = this.dl;
        if (zVar2 != null) {
            zVar2.dl();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gc() {
        com.bytedance.msdk.api.a.z.gz.z zVar = this.dl;
        if (zVar != null) {
            zVar.dl();
        }
        m.g(this.g);
    }

    public void z() {
        Context context = this.z.get();
        if (context != null) {
            this.g.gc(1);
            final wp wpVar = new wp(context);
            z(wpVar);
            wpVar.z(this.g, new com.bytedance.msdk.api.a.z.gz.g() { // from class: com.bytedance.msdk.core.admanager.reward.rewardagain.dl.5
                @Override // com.bytedance.msdk.api.a.z.gz.g
                public void z(com.bytedance.msdk.api.z zVar) {
                    if (dl.this.gz) {
                        return;
                    }
                    dl.this.gz = true;
                    if (dl.this.dl != null) {
                        dl.this.dl.dl();
                    }
                }

                @Override // com.bytedance.msdk.api.a.z.gz.g
                public void z() {
                    if (dl.this.gz) {
                        return;
                    }
                    dl.this.gz = true;
                    wpVar.z(dl.this.gc, dl.this.m, dl.this.e);
                }

                @Override // com.bytedance.msdk.api.a.z.gz.g
                public void g() {
                    if (dl.this.gz) {
                        return;
                    }
                    dl.this.gz = true;
                    wpVar.z(dl.this.gc, dl.this.m, dl.this.e);
                }
            });
            com.bytedance.msdk.z.gc.m.g(new Runnable() { // from class: com.bytedance.msdk.core.admanager.reward.rewardagain.dl.6
                @Override // java.lang.Runnable
                public void run() {
                    if (dl.this.gz) {
                        return;
                    }
                    dl.this.gz = true;
                    if (dl.this.dl != null) {
                        dl.this.dl.dl();
                    }
                }
            }, 500L);
        }
    }

    private void z(wp wpVar) {
        wpVar.z(new com.bytedance.msdk.api.a.z.gz.z() { // from class: com.bytedance.msdk.core.admanager.reward.rewardagain.dl.7
            @Override // com.bytedance.msdk.api.a.z.gz.z
            public void i_() {
                String strZw = dl.this.g != null ? dl.this.g.zw() : "";
                dl.g(strZw);
                dl.a(strZw);
                dl.gc(strZw);
                if (dl.this.f375a != null) {
                    dl.this.f375a.i_();
                }
            }

            @Override // com.bytedance.msdk.api.a.z.gz.z
            public void z(com.bytedance.msdk.api.z zVar) {
                if (dl.this.f375a != null) {
                    dl.this.f375a.z(zVar);
                }
            }

            @Override // com.bytedance.msdk.api.a.z.gz.z
            public void j_() {
                if (dl.this.f375a != null) {
                    dl.this.f375a.j_();
                }
            }

            @Override // com.bytedance.msdk.api.a.z.gz.z
            public void dl() {
                if (dl.this.dl != null) {
                    dl.this.dl.dl();
                }
            }

            @Override // com.bytedance.msdk.api.a.z.gz.z
            public void a() {
                if (dl.this.f375a != null) {
                    dl.this.f375a.a();
                }
            }

            @Override // com.bytedance.msdk.api.a.z.gz.z
            public void gc() {
                if (dl.this.f375a != null) {
                    dl.this.f375a.gc();
                }
            }

            @Override // com.bytedance.msdk.api.a.z.gz.z
            public void z(com.bytedance.msdk.api.dl.z zVar) {
                if (dl.this.f375a != null) {
                    dl.this.f375a.z(zVar);
                }
            }

            @Override // com.bytedance.msdk.api.a.z.gz.z
            public void m() {
                if (dl.this.f375a != null) {
                    dl.this.f375a.m();
                }
            }
        });
        wpVar.g(new com.bytedance.msdk.api.a.z.gz.z() { // from class: com.bytedance.msdk.core.admanager.reward.rewardagain.dl.8
            @Override // com.bytedance.msdk.api.a.z.gz.z
            public void i_() {
                if (dl.this.f375a != null) {
                    dl.this.f375a.i_();
                }
            }

            @Override // com.bytedance.msdk.api.a.z.gz.z
            public void z(com.bytedance.msdk.api.z zVar) {
                if (dl.this.f375a != null) {
                    dl.this.f375a.z(zVar);
                }
            }

            @Override // com.bytedance.msdk.api.a.z.gz.z
            public void j_() {
                if (dl.this.f375a != null) {
                    dl.this.f375a.j_();
                }
            }

            @Override // com.bytedance.msdk.api.a.z.gz.z
            public void dl() {
                if (dl.this.dl != null) {
                    dl.this.dl.dl();
                }
            }

            @Override // com.bytedance.msdk.api.a.z.gz.z
            public void a() {
                if (dl.this.f375a != null) {
                    dl.this.f375a.a();
                }
            }

            @Override // com.bytedance.msdk.api.a.z.gz.z
            public void gc() {
                if (dl.this.f375a != null) {
                    dl.this.f375a.gc();
                }
            }

            @Override // com.bytedance.msdk.api.a.z.gz.z
            public void z(com.bytedance.msdk.api.dl.z zVar) {
                if (dl.this.f375a != null) {
                    dl.this.f375a.z(zVar);
                }
            }

            @Override // com.bytedance.msdk.api.a.z.gz.z
            public void m() {
                if (dl.this.f375a != null) {
                    dl.this.f375a.m();
                }
            }
        });
    }

    public void g() {
        this.fo = true;
    }

    public int z(com.bytedance.msdk.api.z.g gVar, com.bytedance.msdk.core.admanager.reward.rewardagain.z zVar, com.bytedance.msdk.g.dl dlVar) {
        if (!this.fo) {
            com.bytedance.msdk.z.gc.dl.z("TTMediationSDK", "--==--ra: 还未触发rewardVerify");
            return 1;
        }
        String strZw = gVar.zw();
        int iGc = zVar.gc();
        int iZ = z(strZw);
        if (iZ >= iGc) {
            com.bytedance.msdk.z.gc.dl.z("TTMediationSDK", "--==--ra: 激励再得展示次数超过天级别限制，限制: " + iGc + ", 已经展示: " + iZ);
            return 2;
        }
        if (uy.get(zVar.a()) == null) {
            com.bytedance.msdk.z.gc.dl.z("TTMediationSDK", "--==--ra: 激励再得样式为空");
            return 3;
        }
        if (com.bytedance.msdk.core.e.z.z().g()) {
            com.bytedance.msdk.z.gc.dl.z("TTMediationSDK", "--==--ra: 命中请求熔断");
            return 4;
        }
        if (!i.z().gz(strZw)) {
            com.bytedance.msdk.z.gc.dl.z("TTMediationSDK", "--==--ra: 命中展示频控");
            return 5;
        }
        if (!i.z().dl(strZw)) {
            com.bytedance.msdk.z.gc.dl.z("TTMediationSDK", "--==--ra: 命中展示间隔");
            return 6;
        }
        double dG = a.z().g(strZw, gVar);
        if (dG <= -1.0d) {
            com.bytedance.msdk.z.gc.dl.z("TTMediationSDK", "--==--ra: 激励再得无缓存可用");
            return 7;
        }
        if (dG < gz(strZw)) {
            com.bytedance.msdk.z.gc.dl.z("TTMediationSDK", "--==--ra: 激励再得有缓存，但是ecpm不符合");
            return 8;
        }
        int iZ2 = zVar.z();
        int iDl = dl(strZw);
        if (iDl >= iZ2) {
            com.bytedance.msdk.z.gc.dl.z("TTMediationSDK", "--==--ra: 激励再得展示次数超过小时级别限制，限制: " + iZ2 + ", 已经展示: " + iDl);
            return 9;
        }
        long jG = zVar.g();
        long jM = m(strZw);
        long jCurrentTimeMillis = System.currentTimeMillis() - jM;
        if (jM != -1 && jCurrentTimeMillis < jG) {
            com.bytedance.msdk.z.gc.dl.z("TTMediationSDK", "--==--ra: 激励再得展示间隔超过限制，config间隔: " + jG + ", 实际间隔: " + jCurrentTimeMillis);
            return 10;
        }
        double dE = e(strZw);
        if (dlVar == null || dE == -1.0d || dG >= dlVar.u() * dE) {
            return 0;
        }
        com.bytedance.msdk.z.gc.dl.z("TTMediationSDK", "--==--ra: 激励再得ecpm下探期间不满足");
        return 11;
    }

    public static int z(String str) {
        String strG = l.z((String) null, com.bytedance.msdk.core.g.getContext()).g("ra_show_count");
        if (!TextUtils.isEmpty(strG)) {
            try {
                JSONObject jSONObjectOptJSONObject = new JSONObject(strG).optJSONObject(m());
                if (jSONObjectOptJSONObject != null) {
                    return jSONObjectOptJSONObject.optInt(str, 0);
                }
            } catch (JSONException e) {
                com.bytedance.sdk.component.utils.wp.z(e);
            }
        }
        return 0;
    }

    public static void g(String str) {
        l lVarZ = l.z((String) null, com.bytedance.msdk.core.g.getContext());
        String strG = lVarZ.g("ra_show_count");
        if (!TextUtils.isEmpty(strG)) {
            try {
                JSONObject jSONObject = new JSONObject(strG);
                String strM = m();
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(strM);
                if (jSONObjectOptJSONObject == null) {
                    lVarZ.z("ra_show_count", "");
                    jSONObjectOptJSONObject = new JSONObject();
                }
                jSONObjectOptJSONObject.put(str, jSONObjectOptJSONObject.optInt(str, 0) + 1);
                jSONObject.put(strM, jSONObjectOptJSONObject);
                lVarZ.z("ra_show_count", jSONObject.toString());
                return;
            } catch (JSONException e) {
                com.bytedance.sdk.component.utils.wp.z(e);
                return;
            }
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(str, 1);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(m(), jSONObject2);
            lVarZ.z("ra_show_count", jSONObject3.toString());
        } catch (JSONException e2) {
            com.bytedance.sdk.component.utils.wp.z(e2);
        }
    }

    private static String m() {
        return new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());
    }

    private static String e() {
        return new SimpleDateFormat("dd-MM-yyyy HH", Locale.getDefault()).format(new Date());
    }

    public static int dl(String str) {
        String strG = l.z((String) null, com.bytedance.msdk.core.g.getContext()).g("ra_show_count_in_hour");
        if (!TextUtils.isEmpty(strG)) {
            try {
                JSONObject jSONObjectOptJSONObject = new JSONObject(strG).optJSONObject(e());
                if (jSONObjectOptJSONObject != null) {
                    return jSONObjectOptJSONObject.optInt(str, 0);
                }
            } catch (JSONException e) {
                com.bytedance.sdk.component.utils.wp.z(e);
            }
        }
        return 0;
    }

    public static void a(String str) {
        l lVarZ = l.z((String) null, com.bytedance.msdk.core.g.getContext());
        String strG = lVarZ.g("ra_show_count_in_hour");
        if (!TextUtils.isEmpty(strG)) {
            try {
                JSONObject jSONObject = new JSONObject(strG);
                String strE = e();
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(strE);
                if (jSONObjectOptJSONObject == null) {
                    lVarZ.z("ra_show_count_in_hour", "");
                    jSONObjectOptJSONObject = new JSONObject();
                }
                jSONObjectOptJSONObject.put(str, jSONObjectOptJSONObject.optInt(str, 0) + 1);
                jSONObject.put(strE, jSONObjectOptJSONObject);
                lVarZ.z("ra_show_count_in_hour", jSONObject.toString());
                return;
            } catch (JSONException e) {
                com.bytedance.sdk.component.utils.wp.z(e);
                return;
            }
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(str, 1);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(e(), jSONObject2);
            lVarZ.z("ra_show_count_in_hour", jSONObject3.toString());
        } catch (JSONException e2) {
            com.bytedance.sdk.component.utils.wp.z(e2);
        }
    }

    public static void gc(String str) {
        JSONObject jSONObject;
        l lVarZ = l.z((String) null, com.bytedance.msdk.core.g.getContext());
        String strG = lVarZ.g("ra_play_rit_ts");
        try {
            if (TextUtils.isEmpty(strG)) {
                jSONObject = new JSONObject();
            } else {
                jSONObject = new JSONObject(strG);
            }
            jSONObject.put(str, System.currentTimeMillis());
            lVarZ.z("ra_play_rit_ts", jSONObject.toString());
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.wp.z(th);
        }
    }

    public static long m(String str) {
        String strG = l.z((String) null, com.bytedance.msdk.core.g.getContext()).g("ra_play_rit_ts");
        try {
            if (!TextUtils.isEmpty(strG)) {
                return new JSONObject(strG).optLong(str, -1L);
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.wp.z(th);
        }
        return -1L;
    }

    public static double e(String str) {
        com.bytedance.msdk.core.admanager.reward.rewardagain.z zVar = kb.get(str);
        if (zVar == null) {
            return -1.0d;
        }
        double dDl = zVar.dl();
        if (dDl < 0.0d || dDl > 1.0d) {
            return -1.0d;
        }
        return dDl;
    }

    public static double gz(String str) {
        com.bytedance.msdk.core.admanager.reward.rewardagain.z zVar = kb.get(str);
        if (zVar != null) {
            return zVar.m();
        }
        return 0.0d;
    }

    public static com.bytedance.msdk.core.admanager.reward.rewardagain.z fo(String str) {
        return kb.get(str);
    }

    public static void z(String str, com.bytedance.msdk.core.admanager.reward.rewardagain.z zVar) {
        if (TextUtils.isEmpty(str) || zVar == null) {
            return;
        }
        kb.put(str, zVar);
    }

    public static void uy(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        kb.remove(str);
    }

    public static void z(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() <= 0) {
            return;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null) {
                g gVar = new g();
                gVar.z(jSONObjectOptJSONObject.optString("ra_id"));
                gVar.g(jSONObjectOptJSONObject.optString("title"));
                gVar.dl(jSONObjectOptJSONObject.optString("pic_url"));
                gVar.a(jSONObjectOptJSONObject.optString("btn_ok"));
                gVar.gc(jSONObjectOptJSONObject.optString("btn_cancel"));
                uy.put(gVar.z(), gVar);
            }
        }
    }

    public static z dl() {
        return wp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void gz() {
        wp.z = null;
        wp.g = null;
        wp.dl = null;
    }
}
