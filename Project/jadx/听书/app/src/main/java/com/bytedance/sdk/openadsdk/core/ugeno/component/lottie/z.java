package com.bytedance.sdk.openadsdk.core.ugeno.component.lottie;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.bytedance.adsdk.lottie.LottieAnimationView;
import com.bytedance.adsdk.lottie.a;
import com.bytedance.adsdk.lottie.fo;
import com.bytedance.adsdk.lottie.q;
import com.bytedance.adsdk.lottie.tb;
import com.bytedance.adsdk.ugeno.dl.fv;
import com.bytedance.adsdk.ugeno.dl.ls;
import com.bytedance.adsdk.ugeno.dl.pf;
import com.bytedance.adsdk.ugeno.g.dl;
import com.bytedance.adsdk.ugeno.m.gz;
import com.bytedance.adsdk.ugeno.z;
import com.bytedance.android.live.base.api.push.ILivePush;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.core.ugeno.uy;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class z extends g {
    private boolean cb;
    private View o;

    public z(Context context) {
        super(context);
        this.cb = false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.lottie.g, com.bytedance.adsdk.ugeno.g.dl
    /* JADX INFO: renamed from: e */
    public UgenLottieView z() {
        UgenLottieView ugenLottieViewZ = super.z();
        ugenLottieViewZ.setTextDelegate(new tb(ugenLottieViewZ) { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.lottie.z.1
            @Override // com.bytedance.adsdk.lottie.tb
            public String z(String str) {
                return com.bytedance.adsdk.ugeno.a.g.z(str, z.this.f239a);
            }
        });
        ugenLottieViewZ.setViewDelegate(new q() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.lottie.z.2
            @Override // com.bytedance.adsdk.lottie.q
            public View z(String str, Map<String, Object> map) {
                if (!"view:".equals(str) || map == null || map.isEmpty()) {
                    return null;
                }
                if (!z.this.cb) {
                    z.this.cb = true;
                    z.this.z(map);
                }
                return z.this.o;
            }
        });
        ugenLottieViewZ.setLottieClicklistener(new LottieAnimationView.g() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.lottie.z.3
            @Override // com.bytedance.adsdk.lottie.LottieAnimationView.g
            public void z(String str, JSONArray jSONArray) {
                ls lsVar = new ls();
                lsVar.z(1);
                lsVar.z(z.this);
                if (jSONArray != null && jSONArray.length() > 0) {
                    z.this.z(lsVar, jSONArray);
                }
                if (z.this.u != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("lottieEvent", true);
                        jSONObject.put("uttieUrl", z.this.z);
                        if (TextUtils.equals("CSJCLOSE", str)) {
                            jSONObject.put("type", ILivePush.ClickType.CLOSE);
                        } else if (TextUtils.equals("clickEvent", str)) {
                            jSONObject.put("type", "clickEvent");
                        }
                        lsVar.z(jSONObject);
                        fv fvVar = z.this.u;
                        z zVar = z.this;
                        fvVar.z(lsVar, zVar, zVar);
                    } catch (JSONException e) {
                        wp.z(e);
                    }
                }
            }
        });
        ugenLottieViewZ.setLottieAnimListener(new LottieAnimationView.z() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.lottie.z.4
            @Override // com.bytedance.adsdk.lottie.LottieAnimationView.z
            public void z(Map<String, Object> map) {
                z.this.z(map, 19);
            }

            @Override // com.bytedance.adsdk.lottie.LottieAnimationView.z
            public void g(Map<String, Object> map) {
                z.this.z(map, 20);
            }
        });
        return ugenLottieViewZ;
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.ugeno.component.lottie.z$5, reason: invalid class name */
    /* JADX INFO: loaded from: classes2.dex */
    class AnonymousClass5 implements a {
        AnonymousClass5() {
        }

        @Override // com.bytedance.adsdk.lottie.a
        public Bitmap z(final fo foVar) {
            final String strZ;
            if (foVar == null) {
                return null;
            }
            String strI = foVar.i();
            String strWp = foVar.wp();
            String strA = foVar.a();
            if (!TextUtils.isEmpty(strA) && strA.startsWith("${") && "image:".equals(strI)) {
                strZ = com.bytedance.adsdk.ugeno.a.g.z(strA, z.this.f239a);
            } else {
                strZ = (TextUtils.isEmpty(strI) || !TextUtils.isEmpty(strWp)) ? (TextUtils.isEmpty(strWp) || !TextUtils.isEmpty(strI)) ? (TextUtils.isEmpty(strWp) || TextUtils.isEmpty(strI)) ? null : com.bytedance.adsdk.ugeno.a.g.z(strI, z.this.f239a) + com.bytedance.adsdk.ugeno.a.g.z(strWp, z.this.f239a) : com.bytedance.adsdk.ugeno.a.g.z(strWp, z.this.f239a) : com.bytedance.adsdk.ugeno.a.g.z(strI, z.this.f239a);
            }
            if (TextUtils.isEmpty(strZ)) {
                return null;
            }
            Bitmap bitmap = z.this.wo.get(strZ);
            if (bitmap != null) {
                return bitmap;
            }
            com.bytedance.adsdk.ugeno.a.z().g().z(z.this.fo, strZ, new z.InterfaceC0053z() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.lottie.z.5.1
                @Override // com.bytedance.adsdk.ugeno.z.InterfaceC0053z
                public void z(Bitmap bitmap2) {
                    if (bitmap2 != null) {
                        final Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap2, foVar.z(), foVar.g(), false);
                        z.this.wo.put(strZ, bitmapCreateScaledBitmap);
                        gz.z(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.lottie.z.5.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                ((UgenLottieView) z.this.gc).z(foVar.kb(), bitmapCreateScaledBitmap);
                            }
                        });
                    }
                }
            });
            return z.this.wo.get(strZ);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.lottie.g
    protected void gz() {
        if (this.gc == 0 || ((UgenLottieView) this.gc).getVisibility() != 0) {
            return;
        }
        ((UgenLottieView) this.gc).setImageAssetDelegate(new AnonymousClass5());
        ((UgenLottieView) this.gc).z();
        jq();
    }

    private void jq() {
        ls lsVar = new ls();
        lsVar.z(21);
        lsVar.z(this);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("lottieEvent", true);
            jSONObject.put("uttieUrl", this.z);
            lsVar.z(jSONObject);
            this.u.z(lsVar, this, this);
        } catch (JSONException e) {
            wp.z(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(Map<String, Object> map, int i) {
        ls lsVar = new ls();
        lsVar.z(i);
        lsVar.z(this);
        if (map != null) {
            Object obj = map.get("lel");
            if (obj instanceof JSONArray) {
                z(lsVar, (JSONArray) obj);
            }
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("lottieEvent", true);
            if (map != null) {
                Object obj2 = map.get("duration");
                if (obj2 instanceof Long) {
                    jSONObject.put("duration", obj2);
                    jSONObject.put("uttieUrl", this.z);
                }
            }
            lsVar.z(jSONObject);
            this.u.z(lsVar, this, this);
        } catch (JSONException e) {
            wp.z(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(ls lsVar, JSONArray jSONArray) {
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    String strOptString = jSONObjectOptJSONObject.optString("vid");
                    if (!TextUtils.isEmpty(strOptString)) {
                        int iOptInt = jSONObjectOptJSONObject.optInt(LiveConfigKey.HIGH, 0);
                        dl dlVarZ = z(lsVar.z(), strOptString);
                        if (dlVarZ != null) {
                            dlVarZ.g(iOptInt == 0 ? 0 : 8);
                            View viewFo = dlVarZ.fo();
                            if (viewFo instanceof UgenLottieView) {
                                UgenLottieView ugenLottieView = (UgenLottieView) viewFo;
                                if (iOptInt == 0) {
                                    ugenLottieView.z();
                                    jq();
                                } else {
                                    ugenLottieView.m();
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private dl z(dl dlVar, String str) {
        if (dlVar == null) {
            return null;
        }
        while (dlVar.gk() != null) {
            dlVar = dlVar.gk();
        }
        return dlVar.a(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(Map<String, Object> map) {
        Object obj = map.get("ugen_url");
        String str = obj instanceof String ? (String) obj : null;
        Object obj2 = map.get("ugen_md5");
        String str2 = obj2 instanceof String ? (String) obj2 : null;
        Object obj3 = map.get("ugen_v");
        final String str3 = obj3 instanceof String ? (String) obj3 : null;
        Object obj4 = map.get("ugen_w");
        final int iIntValue = obj4 instanceof Integer ? ((Integer) obj4).intValue() : 0;
        Object obj5 = map.get("ugen_h");
        final int iIntValue2 = obj5 instanceof Integer ? ((Integer) obj5).intValue() : 0;
        if (iIntValue <= 0 || iIntValue2 <= 0 || TextUtils.isEmpty(str) || TextUtils.isEmpty(str3)) {
            return;
        }
        uy.z(str, str2, new com.bytedance.sdk.openadsdk.core.ugeno.dl() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.lottie.z.6
            @Override // com.bytedance.sdk.openadsdk.core.ugeno.dl
            public void z() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.dl
            public void z(String str4) {
                try {
                    z.this.z(new JSONObject(str4), iIntValue, iIntValue2, str3);
                } catch (Throwable th) {
                    wp.z(th);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(JSONObject jSONObject, int i, int i2, String str) {
        dl<View> dlVarZ;
        pf pfVar = new pf(this.g);
        if (str.startsWith("2")) {
            dlVarZ = pfVar.z(jSONObject);
            pfVar.g(this.f239a);
        } else {
            dlVarZ = str.startsWith("3") ? pfVar.z(jSONObject, this.f239a, (JSONObject) null) : null;
        }
        if (dlVarZ != null) {
            this.o = dlVarZ.fo();
        }
    }
}
