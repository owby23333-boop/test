package com.bytedance.adsdk.ugeno.z;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import com.bytedance.adsdk.ugeno.z.dl;
import com.bytedance.adsdk.ugeno.z.z.z;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class z extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f274a;
    private ValueAnimator dl;
    private com.bytedance.adsdk.ugeno.z.z.z e;
    private g fo;
    private dl g;
    private int gc;
    private String gz;
    private int m = 1;
    private com.bytedance.adsdk.ugeno.g.dl z;

    public z(Context context, com.bytedance.adsdk.ugeno.g.dl dlVar, dl dlVar2) {
        this.z = dlVar;
        this.g = dlVar2;
        this.f274a = context;
    }

    public void z() {
        ValueAnimator valueAnimator = this.dl;
        if (valueAnimator == null || this.gc == -2 || this.m == 0) {
            return;
        }
        valueAnimator.start();
    }

    public void z(g gVar) {
        this.fo = gVar;
    }

    public void g() {
        ValueAnimator valueAnimator = this.dl;
        if (valueAnimator != null) {
            valueAnimator.start();
        }
    }

    public void dl() {
        ValueAnimator valueAnimator = this.dl;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }

    public ValueAnimator a() {
        String key;
        com.bytedance.adsdk.ugeno.z.g.z dlVar;
        dl dlVar2 = this.g;
        if (dlVar2 == null || this.z == null) {
            return null;
        }
        Map<String, TreeMap<Float, String>> mapG = dlVar2.g();
        ArrayList arrayList = new ArrayList();
        if (mapG != null && !mapG.isEmpty()) {
            for (Map.Entry<String, TreeMap<Float, String>> entry : mapG.entrySet()) {
                if (entry != null) {
                    key = entry.getKey();
                    String strDl = gc.z(key).dl();
                    strDl.hashCode();
                    switch (strDl) {
                        case "int":
                            dlVar = new com.bytedance.adsdk.ugeno.z.g.dl(this.f274a, this.z, key, entry.getValue());
                            break;
                        case "float":
                            dlVar = new com.bytedance.adsdk.ugeno.z.g.g(this.f274a, this.z, key, entry.getValue());
                            break;
                        case "point":
                            dlVar = new com.bytedance.adsdk.ugeno.z.g.a(this.f274a, this.z, key, entry.getValue());
                            break;
                        default:
                            dlVar = null;
                            break;
                    }
                    if (dlVar != null) {
                        arrayList.addAll(dlVar.gc());
                    }
                }
            }
        }
        JSONObject jSONObjectZ = this.g.z();
        if (jSONObjectZ != null) {
            com.bytedance.adsdk.ugeno.z.z.z zVarZ = z.C0054z.z(this.z, jSONObjectZ);
            this.e = zVarZ;
            if (zVarZ != null) {
                arrayList.addAll(zVarZ.dl());
            }
        }
        final View viewFo = this.z.fo();
        if (viewFo == null) {
            return null;
        }
        final dl.z zVarE = this.g.e();
        if (zVarE != null) {
            viewFo.post(new Runnable() { // from class: com.bytedance.adsdk.ugeno.z.z.1
                @Override // java.lang.Runnable
                public void run() {
                    int width = viewFo.getWidth();
                    int height = viewFo.getHeight();
                    viewFo.setPivotX(a.z(zVarE.z, width));
                    viewFo.setPivotY(a.z(zVarE.g, height));
                }
            });
        }
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(viewFo, (PropertyValuesHolder[]) arrayList.toArray(new PropertyValuesHolder[0]));
        this.gc = a.z(this.g.a());
        objectAnimatorOfPropertyValuesHolder.setDuration(this.g.dl());
        int i = this.gc;
        if (i != -2) {
            objectAnimatorOfPropertyValuesHolder.setRepeatCount(i);
        }
        this.m = this.g.uy();
        this.gz = this.g.fo();
        objectAnimatorOfPropertyValuesHolder.setStartDelay(this.g.m());
        objectAnimatorOfPropertyValuesHolder.setRepeatMode(a.z(this.g.gc()));
        objectAnimatorOfPropertyValuesHolder.setInterpolator(a.g(this.g.gz()));
        objectAnimatorOfPropertyValuesHolder.addListener(this);
        this.dl = objectAnimatorOfPropertyValuesHolder;
        return objectAnimatorOfPropertyValuesHolder;
    }

    public void z(Canvas canvas) {
        com.bytedance.adsdk.ugeno.z.z.z zVar = this.e;
        if (zVar != null) {
            zVar.z(canvas);
        }
    }

    public void z(int i, int i2) {
        com.bytedance.adsdk.ugeno.z.z.z zVar = this.e;
        if (zVar != null) {
            zVar.z(i, i2);
        }
    }

    public String gc() {
        return this.gz;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        super.onAnimationStart(animator);
        g gVar = this.fo;
        if (gVar != null) {
            gVar.z();
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        super.onAnimationEnd(animator);
        g gVar = this.fo;
        if (gVar != null) {
            gVar.g();
        }
    }
}
