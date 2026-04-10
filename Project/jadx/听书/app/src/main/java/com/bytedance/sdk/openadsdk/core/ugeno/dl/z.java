package com.bytedance.sdk.openadsdk.core.ugeno.dl;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.adsdk.ugeno.dl.ls;
import com.bytedance.sdk.component.utils.tb;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.component.uy.fo;
import com.bytedance.sdk.openadsdk.core.activity.base.TTNativePageActivity;
import com.bytedance.sdk.openadsdk.core.i.m;
import com.bytedance.sdk.openadsdk.core.io.g;
import com.bytedance.sdk.openadsdk.core.iq.a;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.iq.tf;
import com.bytedance.sdk.openadsdk.core.kb.dl.gz;
import com.bytedance.sdk.openadsdk.core.kb.dl.uy;
import com.bytedance.sdk.openadsdk.core.ugeno.dl.g;
import com.bytedance.sdk.openadsdk.core.ugeno.e.e;
import com.bytedance.sdk.openadsdk.core.ugeno.e.gc;
import com.bytedance.sdk.openadsdk.core.un.eo;
import com.bytedance.sdk.openadsdk.core.un.m;
import com.bytedance.sdk.openadsdk.core.un.oq;
import com.bytedance.sdk.openadsdk.core.zw;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class z implements g.z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected String f1346a;
    protected com.bytedance.sdk.openadsdk.core.ugeno.a.z dl;
    private Activity e;
    private com.bytedance.adsdk.ugeno.g.dl fo;
    protected g g;
    protected int gc;
    private ViewGroup gz;
    private String i;
    private JSONObject kb;
    private com.bytedance.sdk.openadsdk.core.multipro.g.z ls;
    private m m;
    private com.bytedance.sdk.openadsdk.core.kb.g.z p = new com.bytedance.sdk.openadsdk.core.kb.g.z() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.dl.z.8
        @Override // com.bytedance.sdk.openadsdk.core.kb.g.z
        public void dl(long j, long j2, String str, String str2) {
        }

        @Override // com.bytedance.sdk.openadsdk.core.kb.g.z
        public void g(long j, long j2, String str, String str2) {
        }

        @Override // com.bytedance.sdk.openadsdk.core.kb.g.z
        public void z() {
        }

        @Override // com.bytedance.sdk.openadsdk.core.kb.g.z
        public void z(long j, long j2, String str, String str2) {
        }

        @Override // com.bytedance.sdk.openadsdk.core.kb.g.z
        public void z(long j, String str, String str2) {
        }

        @Override // com.bytedance.sdk.openadsdk.core.kb.g.z
        public void z(String str, String str2) {
        }
    };
    private com.bytedance.adsdk.ugeno.widget.image.g pf;
    private com.bytedance.sdk.openadsdk.core.kb.g.dl uy;
    private com.bytedance.sdk.openadsdk.core.ugeno.component.video.g v;
    private a wp;
    protected na z;

    protected void z(com.bytedance.adsdk.ugeno.g.dl<View> dlVar) {
    }

    protected void z(JSONObject jSONObject) {
    }

    public z(Activity activity, ViewGroup viewGroup, m mVar, na naVar, String str, int i, com.bytedance.sdk.openadsdk.core.multipro.g.z zVar) {
        this.z = naVar;
        this.e = activity;
        this.m = mVar;
        this.gz = viewGroup;
        this.f1346a = str;
        this.gc = i;
        this.ls = zVar;
    }

    public void z(com.bytedance.sdk.openadsdk.core.ugeno.a.z zVar) {
        this.dl = zVar;
    }

    public void z() {
        this.g = new g(this.e, this.m, this.f1346a, this.gc);
        if (this.z.iq() != null) {
            try {
                g(new JSONObject(this.z.iq().toString()));
                return;
            } catch (JSONException e) {
                wp.z(e);
                return;
            }
        }
        int iFv = this.z.fv();
        if (iFv == 5 || iFv == 4) {
            g(new JSONObject());
        } else {
            com.bytedance.sdk.openadsdk.core.io.g.z(this.z.p(), new g.z() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.dl.z.1
                @Override // com.bytedance.sdk.openadsdk.core.io.g.z
                public void z(JSONObject jSONObject) {
                    z.this.g(jSONObject);
                }

                @Override // com.bytedance.sdk.openadsdk.core.io.g.z
                public void z(int i, String str) {
                    z.this.m.z(-3, "ad meta info load fail");
                    if (z.this.dl != null) {
                        z.this.dl.z(-3);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(JSONObject jSONObject) {
        this.kb = jSONObject;
        a(jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dl(final JSONObject jSONObject) {
        gc.z(this.z.js(), "lp_" + this.z.fv(), this.z.tb(), new gc.z() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.dl.z.2
            @Override // com.bytedance.sdk.openadsdk.core.ugeno.e.gc.z
            public void z(JSONObject jSONObject2) {
                if (jSONObject2 == null) {
                    z.this.m.z(-1, "template info load fail");
                    if (z.this.dl != null) {
                        z.this.dl.z(-1);
                        return;
                    }
                    return;
                }
                try {
                    jSONObject.put("creative", z.this.z.kv());
                    z.this.z(jSONObject);
                    z.this.z(jSONObject2, jSONObject);
                } catch (JSONException e) {
                    wp.z(e);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(JSONObject jSONObject, JSONObject jSONObject2) {
        this.m.g();
        this.g.z(this);
        this.g.z(jSONObject, jSONObject2, new e() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.dl.z.3
            @Override // com.bytedance.sdk.openadsdk.core.ugeno.e.e
            public void z(int i, String str) {
                if (z.this.dl != null) {
                    z.this.dl.z(i);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.e.e
            public void z(com.bytedance.adsdk.ugeno.g.dl<View> dlVar) {
                z.this.fo = dlVar;
                z.this.gz.addView(dlVar.fo(), new FrameLayout.LayoutParams(dlVar.mc(), dlVar.un()));
                if (z.this.dl != null) {
                    z.this.dl.z(dlVar.fo());
                }
                z.this.gc();
                z.this.z(dlVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gc() {
        na naVar = this.z;
        if (naVar == null || tf.fo(naVar) != 200) {
            return;
        }
        com.bytedance.adsdk.ugeno.g.dl dlVarA = this.fo.a("video");
        if (dlVarA instanceof com.bytedance.sdk.openadsdk.core.ugeno.component.video.g) {
            com.bytedance.sdk.openadsdk.core.ugeno.component.video.g gVar = (com.bytedance.sdk.openadsdk.core.ugeno.component.video.g) dlVarA;
            this.v = gVar;
            gVar.gc(true);
            fo();
        }
        com.bytedance.adsdk.ugeno.g.dl dlVarA2 = this.fo.a("mute");
        if (dlVarA2 instanceof com.bytedance.adsdk.ugeno.widget.image.g) {
            this.pf = (com.bytedance.adsdk.ugeno.widget.image.g) dlVarA2;
            ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
            shapeDrawable.getPaint().setColor(Color.parseColor("#99333333"));
            shapeDrawable.setIntrinsicWidth(oq.dl(this.e, 28.0f));
            shapeDrawable.setIntrinsicHeight(oq.dl(this.e, 28.0f));
            this.pf.fo().setBackground(shapeDrawable);
        }
        com.bytedance.sdk.openadsdk.core.multipro.g.z zVar = this.ls;
        if (zVar != null) {
            z(zVar.gz);
        } else {
            z(true);
        }
    }

    private void z(boolean z) {
        com.bytedance.sdk.openadsdk.core.ugeno.component.video.g gVar = this.v;
        if (gVar != null) {
            gVar.a(z);
        }
        com.bytedance.adsdk.ugeno.widget.image.g gVar2 = this.pf;
        if (gVar2 == null || gVar2.fo() == null) {
            return;
        }
        tb.z((Context) this.e, z ? "tt_mute" : "tt_unmute", (ImageView) this.pf.fo());
    }

    private void a(final JSONObject jSONObject) {
        if (this.wp != null) {
            try {
                JSONObject jSONObject2 = new JSONObject(this.wp.m());
                jSONObject2.put("is_support_func_desc", "true");
                jSONObject.put("app", jSONObject2);
                dl(jSONObject);
                return;
            } catch (Throwable unused) {
                return;
            }
        }
        String strM = m();
        this.i = strM;
        if (TextUtils.isEmpty(strM)) {
            com.bytedance.sdk.openadsdk.core.ugeno.a.z zVar = this.dl;
            if (zVar != null) {
                zVar.z(-4);
                return;
            }
            return;
        }
        com.bytedance.sdk.component.uy.e.g(new fo("tt_pl_download_check") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.dl.z.4
            @Override // java.lang.Runnable
            public void run() {
                JSONObject jSONObject3;
                z.this.wp = zw.z().z(z.this.z, z.this.i);
                try {
                    if (z.this.wp != null) {
                        jSONObject3 = new JSONObject(z.this.wp.m());
                    } else if (z.this.z.gy() != null) {
                        jSONObject3 = new JSONObject(z.this.z.gy());
                    } else {
                        jSONObject3 = new JSONObject();
                    }
                    jSONObject3.put("is_support_func_desc", "true");
                    jSONObject.put("app", jSONObject3);
                    jSONObject3.put("download_url", z.this.i);
                    z.this.dl(jSONObject);
                } catch (Throwable unused2) {
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.dl.g.z
    public void z(ls lsVar) {
        JSONObject jSONObjectDl;
        com.bytedance.sdk.openadsdk.core.ugeno.component.video.g gVar;
        if (lsVar == null || lsVar.g() != 1 || (jSONObjectDl = lsVar.dl()) == null) {
            return;
        }
        String strOptString = jSONObjectDl.optString("type");
        strOptString.hashCode();
        switch (strOptString) {
            case "openAppPermission":
                z(this.z);
                break;
            case "clickVideo":
                com.bytedance.sdk.openadsdk.core.ugeno.component.video.g gVar2 = this.v;
                if (gVar2 != null) {
                    gVar2.b();
                    break;
                }
                break;
            case "openAppFunctionDesc":
                dl(this.z);
                break;
            case "downloadEvent":
                g(true);
                a(g(lsVar));
                break;
            case "downloadDirect":
                dl(g(lsVar));
                break;
            case "muteVideo":
                if (this.pf != null && (gVar = this.v) != null) {
                    z(!gVar.gz());
                    break;
                }
                break;
            case "openAppPolicy":
                g(this.z);
                break;
            case "openInfringement":
                com.bytedance.sdk.openadsdk.core.un.m.z(this.e, this.f1346a, this.z);
                break;
        }
    }

    private void g(boolean z) {
        gz();
        com.bytedance.sdk.openadsdk.core.kb.g.dl dlVar = this.uy;
        if (dlVar instanceof gz) {
            ((gz) dlVar).m().z(z);
        }
    }

    private void dl(boolean z) {
        g(false);
        a(z);
    }

    private boolean g(ls lsVar) {
        if (lsVar == null) {
            return false;
        }
        View viewFo = lsVar.z().fo();
        if (!(viewFo instanceof TextView)) {
            return false;
        }
        CharSequence text = ((TextView) viewFo).getText();
        if (TextUtils.isEmpty(text)) {
            return false;
        }
        return text.toString().contains("下载");
    }

    private void z(na naVar) {
        String strGy;
        if (naVar == null) {
            return;
        }
        if (this.wp != null) {
            com.bytedance.sdk.openadsdk.core.iq.m mVarBw = naVar.bw();
            if (mVarBw != null) {
                this.wp.z(mVarBw.a());
                this.wp.z(mVarBw.dl());
            }
            strGy = this.wp.m();
        } else {
            strGy = naVar.gy();
        }
        Activity activity = this.e;
        if (activity instanceof TTNativePageActivity) {
            ((TTNativePageActivity) activity).dl();
        }
        com.bytedance.sdk.openadsdk.core.un.m.z(this.e, naVar.mj(), strGy, new m.z() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.dl.z.5
            @Override // com.bytedance.sdk.openadsdk.core.un.m.z
            public void onDialogBtnYes() {
                z.this.a(true);
                if (z.this.e instanceof TTNativePageActivity) {
                    ((TTNativePageActivity) z.this.e).a();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.un.m.z
            public void onDialogBtnNo() {
                if (z.this.e instanceof TTNativePageActivity) {
                    ((TTNativePageActivity) z.this.e).a();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.un.m.z
            public void onDialogCancel() {
                if (z.this.e instanceof TTNativePageActivity) {
                    ((TTNativePageActivity) z.this.e).a();
                }
            }
        });
    }

    private void g(na naVar) {
        String strGy;
        if (naVar == null) {
            return;
        }
        if (this.wp != null) {
            com.bytedance.sdk.openadsdk.core.iq.m mVarBw = naVar.bw();
            if (mVarBw != null) {
                this.wp.z(mVarBw.a());
                this.wp.z(mVarBw.dl());
            }
            strGy = this.wp.m();
        } else {
            strGy = naVar.gy();
        }
        Activity activity = this.e;
        if (activity instanceof TTNativePageActivity) {
            ((TTNativePageActivity) activity).dl();
        }
        com.bytedance.sdk.openadsdk.core.un.m.z(this.e, naVar.mj(), new m.z() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.dl.z.6
            @Override // com.bytedance.sdk.openadsdk.core.un.m.z
            public void onDialogBtnYes() {
                z.this.a(true);
                if (z.this.e instanceof TTNativePageActivity) {
                    ((TTNativePageActivity) z.this.e).a();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.un.m.z
            public void onDialogBtnNo() {
                if (z.this.e instanceof TTNativePageActivity) {
                    ((TTNativePageActivity) z.this.e).a();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.un.m.z
            public void onDialogCancel() {
                if (z.this.e instanceof TTNativePageActivity) {
                    ((TTNativePageActivity) z.this.e).a();
                }
            }
        }, strGy);
    }

    private void dl(na naVar) {
        String strFo;
        if (naVar == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.iq.m mVarBw = naVar.bw();
        a aVar = this.wp;
        if (aVar != null) {
            strFo = aVar.a();
        } else {
            strFo = mVarBw == null ? "" : mVarBw.fo();
        }
        com.bytedance.sdk.openadsdk.core.un.m.g(this.e, strFo, naVar.mj(), new m.z() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.dl.z.7
            @Override // com.bytedance.sdk.openadsdk.core.un.m.z
            public void onDialogBtnYes() {
                z.this.a(true);
                if (z.this.e instanceof TTNativePageActivity) {
                    ((TTNativePageActivity) z.this.e).a();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.un.m.z
            public void onDialogBtnNo() {
                if (z.this.e instanceof TTNativePageActivity) {
                    ((TTNativePageActivity) z.this.e).a();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.un.m.z
            public void onDialogCancel() {
                if (z.this.e instanceof TTNativePageActivity) {
                    ((TTNativePageActivity) z.this.e).a();
                }
            }
        });
    }

    private String m() {
        JSONObject jSONObject = this.kb;
        if (jSONObject == null) {
            return e();
        }
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("download_buttons");
        if (jSONArrayOptJSONArray == null) {
            return e();
        }
        JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(0);
        if (jSONObjectOptJSONObject == null) {
            return e();
        }
        String strOptString = jSONObjectOptJSONObject.optString("url");
        return TextUtils.isEmpty(strOptString) ? e() : strOptString;
    }

    private String e() {
        return eo.ls(this.z);
    }

    private void gz() {
        if (this.uy == null) {
            com.bytedance.sdk.openadsdk.core.kb.g.dl dlVarZ = com.bytedance.sdk.openadsdk.core.kb.gz.z(this.e, this.i, this.z, this.f1346a);
            this.uy = dlVarZ;
            dlVarZ.z(uy.z(this.z));
            this.uy.z(this.p, false);
            this.uy.g(false);
        }
        this.uy.z(this.e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        gz();
        com.bytedance.sdk.openadsdk.core.g.z zVar = new com.bytedance.sdk.openadsdk.core.g.z(this.e, this.z, "embeded_ad_landingpage", this.gc);
        ((com.bytedance.sdk.openadsdk.core.g.z.z.z) zVar.z(com.bytedance.sdk.openadsdk.core.g.z.z.z.class)).dl(true);
        ((com.bytedance.sdk.openadsdk.core.g.z.z.z) zVar.z(com.bytedance.sdk.openadsdk.core.g.z.z.z.class)).z(true);
        this.uy.dl(z);
        this.uy.z(this.z, false);
        ((com.bytedance.sdk.openadsdk.core.g.z.z.z) zVar.z(com.bytedance.sdk.openadsdk.core.g.z.z.z.class)).z(this.uy);
        this.uy.z(eo.js(this.z), false);
    }

    public void g() {
        com.bytedance.sdk.openadsdk.core.ugeno.component.video.g gVar = this.v;
        if (gVar != null) {
            gVar.f();
        }
    }

    private void fo() {
        com.bytedance.sdk.openadsdk.core.ugeno.component.video.g gVar = this.v;
        if (gVar != null) {
            gVar.z(this.ls);
        }
    }

    public void dl() {
        com.bytedance.sdk.openadsdk.core.kb.g.dl dlVar = this.uy;
        if (dlVar != null) {
            dlVar.z();
        }
        com.bytedance.sdk.openadsdk.core.ugeno.component.video.g gVar = this.v;
        if (gVar != null) {
            gVar.sv();
        }
    }

    public void a() {
        com.bytedance.sdk.openadsdk.core.kb.g.dl dlVar = this.uy;
        if (dlVar != null) {
            dlVar.g();
        }
    }
}
