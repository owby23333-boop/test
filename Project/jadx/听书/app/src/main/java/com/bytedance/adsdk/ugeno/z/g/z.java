package com.bytedance.adsdk.ugeno.z.g;

import android.animation.Keyframe;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.content.Context;
import com.bytedance.adsdk.ugeno.z.gc;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes2.dex */
public abstract class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected gc f270a;
    protected Map<Float, String> dl;
    protected com.bytedance.adsdk.ugeno.g.dl e;
    protected String g;
    protected Context z;
    protected List<PropertyValuesHolder> m = new ArrayList();
    protected List<Keyframe> gc = new ArrayList();

    public abstract void g();

    public abstract TypeEvaluator m();

    public abstract void z(float f, String str);

    public z(Context context, com.bytedance.adsdk.ugeno.g.dl dlVar, String str, Map<Float, String> map) {
        this.z = context;
        this.g = str;
        this.dl = map;
        this.f270a = gc.z(this.g);
        this.e = dlVar;
    }

    public String getType() {
        return this.f270a.dl();
    }

    public boolean z() {
        Map<Float, String> map = this.dl;
        if (map == null || map.size() <= 0) {
            return false;
        }
        return this.dl.containsKey(Float.valueOf(0.0f));
    }

    public void dl() {
        Map<Float, String> map = this.dl;
        if (map == null || map.size() <= 0) {
            return;
        }
        Map<Float, String> map2 = this.dl;
        if (map2 instanceof TreeMap) {
            float fFloatValue = ((Float) ((TreeMap) map2).lastKey()).floatValue();
            if (fFloatValue != 100.0f) {
                z(100.0f, this.dl.get(Float.valueOf(fFloatValue)));
            }
        }
    }

    public void a() {
        Map<Float, String> map = this.dl;
        if (map == null || map.size() <= 0) {
            return;
        }
        if (!z()) {
            g();
        }
        for (Map.Entry<Float, String> entry : this.dl.entrySet()) {
            if (entry != null) {
                z(entry.getKey().floatValue() / 100.0f, entry.getValue());
            }
        }
        dl();
    }

    public List<PropertyValuesHolder> gc() {
        String strG = this.f270a.g();
        a();
        PropertyValuesHolder propertyValuesHolderOfKeyframe = PropertyValuesHolder.ofKeyframe(strG, (Keyframe[]) this.gc.toArray(new Keyframe[0]));
        TypeEvaluator typeEvaluatorM = m();
        if (typeEvaluatorM != null) {
            propertyValuesHolderOfKeyframe.setEvaluator(typeEvaluatorM);
        }
        this.m.add(propertyValuesHolderOfKeyframe);
        return this.m;
    }
}
