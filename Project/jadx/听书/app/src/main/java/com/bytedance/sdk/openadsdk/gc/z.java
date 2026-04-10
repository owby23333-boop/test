package com.bytedance.sdk.openadsdk.gc;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.bytedance.adsdk.ugeno.dl.fo;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.core.iq.gk;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.iq.p;
import com.bytedance.sdk.openadsdk.core.iq.sy;
import com.bytedance.sdk.openadsdk.core.iq.tf;
import com.bytedance.sdk.openadsdk.core.q.v;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.UGenVideoOrImgPanelView;
import com.bytedance.sdk.openadsdk.core.zw;
import com.bytedance.sdk.openadsdk.hh.e;
import com.bytedance.sdk.openadsdk.upie.image.lottie.UpieImageView;
import com.bytedance.sdk.openadsdk.upie.z;
import com.qmuiteam.qmui.skin.QMUISkinValueBuilder;
import com.uc.crashsdk.export.LogType;
import com.umeng.analytics.pro.an;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class z {
    public static boolean z(na naVar) {
        return g(naVar) || dl(naVar);
    }

    public static boolean g(na naVar) {
        return naVar != null && naVar.pc() == 15;
    }

    public static boolean dl(na naVar) {
        return naVar != null && naVar.pc() == 16;
    }

    public static boolean a(na naVar) {
        return gc(naVar) || m(naVar);
    }

    public static boolean gc(na naVar) {
        return naVar != null && naVar.pc() == 17;
    }

    public static boolean m(na naVar) {
        return naVar != null && naVar.pc() == 18;
    }

    public static boolean e(na naVar) {
        int[] iArrGc;
        if (naVar == null || (iArrGc = tf.gc(naVar)) == null || iArrGc.length < 2) {
            return true;
        }
        int i = iArrGc[0];
        int i2 = iArrGc[1];
        int iA = tf.a(naVar);
        int iDl = tf.dl(naVar);
        return (i >= i2 && iA >= iDl) || (i <= i2 && iA <= iDl);
    }

    public static boolean gz(na naVar) {
        if (naVar != null && !na.g(naVar)) {
            if (a(naVar)) {
                return true;
            }
            if (!zw.g().zt() && (sy.z(naVar) || sy.g(naVar) || UGenVideoOrImgPanelView.z(naVar))) {
                return true;
            }
        }
        return false;
    }

    private static z.C0226z kb(na naVar) {
        int[] iArrGc = tf.gc(naVar);
        p pVarV = naVar.v();
        String strDl = pVarV != null ? pVarV.dl() : null;
        z.C0226z c0226z = new z.C0226z();
        if (TextUtils.isEmpty(strDl)) {
            strDl = "";
        }
        z.C0226z c0226zG = c0226z.z(strDl).z((iArrGc == null || iArrGc.length < 2) ? LogType.UNEXP_ANR : iArrGc[0]).g((iArrGc == null || iArrGc.length < 2) ? 720 : iArrGc[1]);
        if (g(naVar)) {
            com.bykv.vk.openvk.component.video.api.dl.z zVarLs = tf.ls(naVar);
            c0226zG.dl(wp(naVar)).g(zVarLs != null ? zVarLs.gc() : "").z(((long) tf.m(naVar)) * 1000);
        }
        if (a(naVar)) {
            c0226zG.dl(wp(naVar));
        }
        return c0226zG;
    }

    public static com.bytedance.sdk.openadsdk.upie.z fo(na naVar) {
        if (!a(naVar) && !z(naVar)) {
            return new z.C0226z().dl(wp(naVar)).z();
        }
        z.C0226z c0226zKb = kb(naVar);
        JSONObject jSONObjectKv = naVar.kv();
        if (jSONObjectKv != null) {
            try {
                jSONObjectKv.put(an.x, "android");
            } catch (JSONException unused) {
            }
        }
        c0226zKb.z(jSONObjectKv);
        return c0226zKb.z();
    }

    public static com.bytedance.sdk.openadsdk.upie.z z(na naVar, JSONObject jSONObject) {
        z.C0226z c0226zKb = kb(naVar);
        if (jSONObject != null) {
            try {
                jSONObject.put(an.x, "android");
            } catch (JSONException unused) {
            }
        }
        c0226zKb.z(jSONObject);
        return c0226zKb.z();
    }

    private static String wp(na naVar) {
        List<gk> listJz;
        if (naVar == null || (listJz = naVar.jz()) == null || listJz.size() <= 0) {
            return null;
        }
        return listJz.get(0).z();
    }

    public static void z(JSONObject jSONObject, na naVar) {
        if (jSONObject != null) {
            if (z(naVar) || a(naVar)) {
                try {
                    jSONObject.put("dynamic_join_type", naVar.pc());
                } catch (JSONException e) {
                    wp.z(e);
                }
            }
        }
    }

    public static void z(boolean z, fo.z zVar) {
        JSONObject jSONObjectA;
        if (zVar == null || (jSONObjectA = zVar.a()) == null || !TextUtils.equals("${image[0].url}", jSONObjectA.optString(QMUISkinValueBuilder.SRC))) {
            return;
        }
        try {
            if (z) {
                jSONObjectA.put("type", "UpieImage");
            } else {
                jSONObjectA.put("name", "UpieImage");
            }
        } catch (JSONException e) {
            wp.z(e);
        }
        zVar.z("UpieImage");
    }

    public static void z(final ImageView imageView, final UpieImageView upieImageView) {
        e.z(new Runnable() { // from class: com.bytedance.sdk.openadsdk.gc.z.1
            @Override // java.lang.Runnable
            public void run() {
                final ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.bytedance.sdk.openadsdk.gc.z.1.1
                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    public void onGlobalLayout() {
                        int width = imageView.getWidth();
                        int height = imageView.getHeight();
                        if (width <= 90 || height <= 90) {
                            return;
                        }
                        imageView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                        z.dl(imageView, upieImageView);
                    }
                };
                imageView.getViewTreeObserver().addOnGlobalLayoutListener(onGlobalLayoutListener);
                imageView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.bytedance.sdk.openadsdk.gc.z.1.2
                    @Override // android.view.View.OnAttachStateChangeListener
                    public void onViewAttachedToWindow(View view) {
                    }

                    @Override // android.view.View.OnAttachStateChangeListener
                    public void onViewDetachedFromWindow(View view) {
                        if (imageView == view) {
                            imageView.getViewTreeObserver().removeOnGlobalLayoutListener(onGlobalLayoutListener);
                        }
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void dl(ImageView imageView, UpieImageView upieImageView) {
        ViewGroup.LayoutParams layoutParams;
        ViewParent parent = imageView.getParent();
        if (parent instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) parent;
            int i = 0;
            while (true) {
                if (i >= viewGroup.getChildCount()) {
                    i = -1;
                    break;
                } else if (imageView == viewGroup.getChildAt(i)) {
                    break;
                } else {
                    i++;
                }
            }
            if (i != -1) {
                if (viewGroup instanceof FrameLayout) {
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(imageView.getWidth(), imageView.getHeight());
                    layoutParams2.gravity = 17;
                    layoutParams = layoutParams2;
                } else if (viewGroup instanceof RelativeLayout) {
                    RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(imageView.getWidth(), imageView.getHeight());
                    layoutParams3.addRule(13);
                    layoutParams = layoutParams3;
                } else if (viewGroup instanceof LinearLayout) {
                    LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(imageView.getWidth(), imageView.getHeight());
                    layoutParams4.gravity = 17;
                    layoutParams = layoutParams4;
                } else {
                    layoutParams = new ViewGroup.LayoutParams(imageView.getWidth(), imageView.getHeight());
                }
                viewGroup.addView(upieImageView, i, layoutParams);
                viewGroup.removeView(imageView);
            }
        }
    }

    public static com.bytedance.sdk.openadsdk.upie.image.lottie.z uy(final na naVar) {
        if (naVar == null) {
            return null;
        }
        return new com.bytedance.sdk.openadsdk.upie.image.lottie.z() { // from class: com.bytedance.sdk.openadsdk.gc.z.2
            @Override // com.bytedance.sdk.openadsdk.upie.image.lottie.z
            public void z(Map<String, Object> map) {
                v.z().z(naVar, map.get("duration"));
            }

            @Override // com.bytedance.sdk.openadsdk.upie.image.lottie.z
            public void z(int i, String str) {
                v.z().z(naVar, i, str);
            }
        };
    }
}
