package com.bytedance.sdk.openadsdk.core.component.reward.dl;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.bytedance.adsdk.ugeno.dl.fv;
import com.bytedance.adsdk.ugeno.dl.ls;
import com.bytedance.adsdk.ugeno.dl.pf;
import com.bytedance.adsdk.ugeno.gc.m;
import com.bytedance.sdk.component.kb.z.g;
import com.bytedance.sdk.openadsdk.core.iq.bm;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.ugeno.e.gc;
import com.bytedance.sdk.openadsdk.core.un.eo;
import com.bytedance.sdk.openadsdk.core.un.oq;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class g {
    protected na e;
    protected bm fo;
    protected Activity gz;
    protected z i;
    protected String kb;
    protected Map<String, Object> ls;
    protected String pf;
    protected pf uy;
    protected AtomicBoolean v;
    protected String wp;

    public void a() {
    }

    public void dl() {
    }

    public int e() {
        return 0;
    }

    public boolean g() {
        return false;
    }

    public void gc() {
    }

    protected float gz() {
        return 0.55f;
    }

    public boolean m() {
        return true;
    }

    public abstract String z();

    public g(Activity activity, na naVar) {
        this.i = new z(false, 0, "");
        this.v = new AtomicBoolean(false);
        this.gz = activity;
        this.e = naVar;
    }

    public g(Activity activity, na naVar, bm bmVar) {
        this(activity, naVar);
        this.fo = bmVar;
    }

    public void dl(String str) {
        this.wp = str;
    }

    public void a(String str) {
        this.kb = str;
    }

    public z g(uy uyVar) {
        return new z(false, 0, "");
    }

    public z z(uy uyVar) {
        return new z(false, 0, "");
    }

    public void z(Map<String, Object> map) {
        if (map == null) {
            return;
        }
        Map<String, Object> map2 = this.ls;
        if (map2 == null) {
            this.ls = map;
        } else {
            map2.putAll(map);
        }
    }

    public void g(String str) {
        this.pf = str;
    }

    protected String fo() {
        if (!TextUtils.isEmpty(this.pf)) {
            return this.pf;
        }
        return z();
    }

    protected z dl(final uy uyVar) {
        if (!m()) {
            return new z(false, 0, "");
        }
        final com.bytedance.sdk.openadsdk.core.widget.m mVar = new com.bytedance.sdk.openadsdk.core.widget.m(this.gz);
        z(mVar);
        final FrameLayout frameLayout = new FrameLayout(this.gz);
        mVar.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.dl.g.1
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (g.this.uy != null) {
                    g.this.uy.z((fv) null);
                }
            }
        });
        com.bytedance.sdk.openadsdk.core.ugeno.m.z zVar = new com.bytedance.sdk.openadsdk.core.ugeno.m.z();
        zVar.z(this.fo.a());
        zVar.g(this.fo.gc());
        zVar.dl(this.fo.a());
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        com.bytedance.sdk.openadsdk.core.ugeno.e.gc.z(zVar, new gc.z() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.dl.g.2
            @Override // com.bytedance.sdk.openadsdk.core.ugeno.e.gc.z
            public void z(JSONObject jSONObject) {
                if (g.this.v.get()) {
                    return;
                }
                if (jSONObject == null) {
                    g.this.i = new z(false, 0, "");
                    countDownLatch.countDown();
                } else {
                    g.this.z(mVar, frameLayout, uyVar, jSONObject);
                    g.this.i = new z(true, g.this.e(), g.this.fo.a(), mVar);
                    countDownLatch.countDown();
                }
            }
        });
        try {
            countDownLatch.await(500L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            com.bytedance.sdk.component.utils.wp.z(e);
        }
        this.v.set(true);
        return this.i;
    }

    public void z(final com.bytedance.sdk.openadsdk.core.widget.m mVar, final ViewGroup viewGroup, final uy uyVar, final JSONObject jSONObject) {
        JSONObject jSONObject2;
        try {
            jSONObject2 = new JSONObject(fo());
        } catch (JSONException unused) {
            jSONObject2 = new JSONObject();
        }
        final View viewZ = z(jSONObject, jSONObject2, new fv() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.dl.g.3
            @Override // com.bytedance.adsdk.ugeno.dl.fv
            public void z(com.bytedance.adsdk.ugeno.g.dl dlVar, String str, m.z zVar) {
            }

            @Override // com.bytedance.adsdk.ugeno.dl.fv
            public void z(ls lsVar, fv.g gVar, fv.z zVar) {
                JSONObject jSONObjectDl = lsVar.dl();
                if (jSONObjectDl == null) {
                    return;
                }
                String strOptString = jSONObjectDl.optString("type");
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("event_template");
                boolean zOptBoolean = jSONObjectDl.optBoolean("uchain", false);
                if (jSONObjectOptJSONObject != null && zOptBoolean && g.this.e != null) {
                    mVar.dismiss();
                    eo.hh();
                    com.bytedance.sdk.component.kb.dl.g.INSTANCE.z(jSONObjectOptJSONObject);
                    HashMap map = new HashMap();
                    map.put("reward_dialog_callback", uyVar);
                    new g.z(strOptString).z(g.this.e.kv()).z(map).z().z();
                    return;
                }
                strOptString.hashCode();
                if (!strOptString.equals("exit_watch")) {
                    if (strOptString.equals("continue_watch")) {
                        mVar.dismiss();
                        g.this.a(uyVar);
                        return;
                    }
                    return;
                }
                mVar.dismiss();
                uy uyVar2 = uyVar;
                if (uyVar2 != null) {
                    uyVar2.g();
                }
            }
        });
        if (viewZ == null) {
            return;
        }
        this.gz.getWindow().getDecorView().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.dl.g.4
            @Override // java.lang.Runnable
            public void run() {
                viewGroup.addView(viewZ);
                g gVar = g.this;
                gVar.z(mVar, viewZ, gVar.gz());
                mVar.z(viewGroup);
                mVar.show();
            }
        });
    }

    protected void z(com.bytedance.sdk.openadsdk.core.widget.m mVar) {
        mVar.getWindow().setBackgroundDrawable(new ColorDrawable(0));
    }

    protected void a(uy uyVar) {
        if (uyVar != null) {
            uyVar.z();
        }
    }

    public View z(JSONObject jSONObject, JSONObject jSONObject2, fv fvVar) {
        pf pfVar = new pf(this.gz);
        this.uy = pfVar;
        com.bytedance.adsdk.ugeno.g.dl<View> dlVarZ = pfVar.z(jSONObject);
        this.uy.z(fvVar);
        this.uy.g(jSONObject2);
        if (dlVarZ == null) {
            return null;
        }
        return dlVarZ.fo();
    }

    public void z(Dialog dialog, View view, float f) {
        if (dialog == null || view == null) {
            return;
        }
        if (this.e.zr() == 1) {
            WindowManager.LayoutParams attributes = dialog.getWindow().getAttributes();
            attributes.y = oq.dl(this.gz, -20.0f);
            dialog.getWindow().setAttributes(attributes);
        }
        if (this.e.zr() == 2) {
            view.setScaleX(f);
            view.setScaleY(f);
            view.setPivotY(0.0f);
            view.measure(0, 0);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, view.getMeasuredHeight());
            layoutParams.leftMargin = (int) (view.getMeasuredWidth() * (1.0f - f));
            layoutParams.topMargin = (int) Math.max(((oq.gc((Context) this.gz) - (view.getMeasuredHeight() * f)) / 2.0f) - oq.kb((Context) this.gz), oq.kb((Context) this.gz));
            view.setLayoutParams(layoutParams);
        }
    }

    public static class z {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Dialog f943a;
        private String dl;
        private int g;
        private boolean z;

        public z(boolean z, int i, String str, Dialog dialog) {
            this.z = z;
            this.g = i;
            this.dl = str;
            this.f943a = dialog;
        }

        public z(boolean z, int i, String str) {
            this(z, i, str, null);
        }

        public int z() {
            return this.g;
        }

        public String g() {
            return this.dl;
        }

        public boolean dl() {
            return this.z;
        }

        public boolean a() {
            Dialog dialog = this.f943a;
            if (dialog == null) {
                return false;
            }
            return dialog.isShowing();
        }

        public void gc() {
            Dialog dialog = this.f943a;
            if (dialog != null) {
                dialog.dismiss();
            }
        }
    }
}
