package com.bytedance.adsdk.ugeno.z.g;

import android.animation.ArgbEvaluator;
import android.animation.IntEvaluator;
import android.animation.Keyframe;
import android.animation.TypeEvaluator;
import android.content.Context;
import com.bytedance.adsdk.ugeno.z.gc;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes2.dex */
public class dl extends z {
    public dl(Context context, com.bytedance.adsdk.ugeno.g.dl dlVar, String str, TreeMap<Float, String> treeMap) {
        super(context, dlVar, str, treeMap);
    }

    @Override // com.bytedance.adsdk.ugeno.z.g.z
    public void g() {
        if (this.f270a == gc.BACKGROUND_COLOR) {
            this.gc.add(Keyframe.ofInt(0.0f, this.e.oq()));
        }
    }

    @Override // com.bytedance.adsdk.ugeno.z.g.z
    public void z(float f, String str) {
        Keyframe keyframeOfInt;
        if (this.f270a == gc.BACKGROUND_COLOR) {
            keyframeOfInt = Keyframe.ofInt(f, com.bytedance.adsdk.ugeno.m.z.z(str));
        } else {
            keyframeOfInt = Keyframe.ofInt(f, com.bytedance.adsdk.ugeno.m.dl.z(str, 0));
        }
        this.gc.add(keyframeOfInt);
    }

    @Override // com.bytedance.adsdk.ugeno.z.g.z
    public TypeEvaluator m() {
        if (this.f270a == gc.BACKGROUND_COLOR) {
            return new ArgbEvaluator();
        }
        return new IntEvaluator();
    }
}
