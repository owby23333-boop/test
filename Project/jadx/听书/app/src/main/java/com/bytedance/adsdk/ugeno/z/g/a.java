package com.bytedance.adsdk.ugeno.z.g;

import android.animation.FloatEvaluator;
import android.animation.Keyframe;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.content.Context;
import android.text.TextUtils;
import com.bytedance.adsdk.ugeno.m.gz;
import com.bytedance.adsdk.ugeno.z.gc;
import com.bytedance.sdk.component.utils.wp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: loaded from: classes2.dex */
public class a extends z {
    private List<Keyframe> gz;

    public a(Context context, com.bytedance.adsdk.ugeno.g.dl dlVar, String str, Map<Float, String> map) {
        super(context, dlVar, str, map);
        this.gz = new ArrayList();
    }

    /* JADX INFO: renamed from: com.bytedance.adsdk.ugeno.z.g.a$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] z;

        static {
            int[] iArr = new int[gc.values().length];
            z = iArr;
            try {
                iArr[gc.TRANSLATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                z[gc.SCALE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    @Override // com.bytedance.adsdk.ugeno.z.g.z
    public void g() {
        Keyframe keyframeOfFloat;
        Keyframe keyframeOfFloat2;
        int i = AnonymousClass1.z[this.f270a.ordinal()];
        if (i == 1) {
            keyframeOfFloat = Keyframe.ofFloat(0.0f, this.e.i());
            keyframeOfFloat2 = Keyframe.ofFloat(0.0f, this.e.v());
        } else if (i != 2) {
            keyframeOfFloat = null;
            keyframeOfFloat2 = null;
        } else {
            keyframeOfFloat = Keyframe.ofFloat(0.0f, this.e.pf());
            keyframeOfFloat2 = Keyframe.ofFloat(0.0f, this.e.ls());
        }
        if (keyframeOfFloat != null) {
            this.gc.add(keyframeOfFloat);
        }
        if (keyframeOfFloat2 != null) {
            this.gz.add(keyframeOfFloat2);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.z.g.z
    public void z(float f, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() != 2) {
                return;
            }
            float fOptDouble = (float) jSONArray.optDouble(0);
            float fOptDouble2 = (float) jSONArray.optDouble(1);
            if (this.f270a == gc.TRANSLATE) {
                fOptDouble = gz.z(this.z, fOptDouble);
                fOptDouble2 = gz.z(this.z, fOptDouble2);
            }
            this.gc.add(Keyframe.ofFloat(f, fOptDouble));
            this.gz.add(Keyframe.ofFloat(f, fOptDouble2));
        } catch (JSONException e) {
            wp.z(e);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.z.g.z
    public List<PropertyValuesHolder> gc() {
        String strG = this.f270a.g();
        a();
        PropertyValuesHolder propertyValuesHolderOfKeyframe = PropertyValuesHolder.ofKeyframe(strG + "X", (Keyframe[]) this.gc.toArray(new Keyframe[0]));
        this.m.add(propertyValuesHolderOfKeyframe);
        PropertyValuesHolder propertyValuesHolderOfKeyframe2 = PropertyValuesHolder.ofKeyframe(strG + "Y", (Keyframe[]) this.gz.toArray(new Keyframe[0]));
        this.m.add(propertyValuesHolderOfKeyframe2);
        TypeEvaluator typeEvaluatorM = m();
        if (typeEvaluatorM != null) {
            propertyValuesHolderOfKeyframe.setEvaluator(typeEvaluatorM);
            propertyValuesHolderOfKeyframe2.setEvaluator(typeEvaluatorM);
        }
        return this.m;
    }

    @Override // com.bytedance.adsdk.ugeno.z.g.z
    public TypeEvaluator m() {
        return new FloatEvaluator();
    }
}
