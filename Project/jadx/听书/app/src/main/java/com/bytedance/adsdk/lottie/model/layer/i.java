package com.bytedance.adsdk.lottie.model.layer;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.view.View;
import com.bytedance.adsdk.lottie.q;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class i extends e {
    private int fo;
    private int gz;
    private final Map<String, Object> uy;

    public i(com.bytedance.adsdk.lottie.gz gzVar, gz gzVar2, Context context) {
        super(gzVar, gzVar2);
        this.gz = -1;
        this.fo = -1;
        HashMap map = new HashMap();
        this.uy = map;
        if (this.e != null) {
            float fZ = com.bytedance.adsdk.lottie.gc.fo.z();
            this.gz = (int) (this.e.z() * fZ);
            this.fo = (int) (this.e.g() * fZ);
            map.put("ugen_url", this.e.a());
            map.put("ugen_md5", this.e.gc());
            map.put("ugen_v", this.e.m());
            map.put("ugen_w", Integer.valueOf(this.gz));
            map.put("ugen_h", Integer.valueOf(this.fo));
        }
    }

    @Override // com.bytedance.adsdk.lottie.model.layer.e, com.bytedance.adsdk.lottie.model.layer.dl
    public void g(Canvas canvas, Matrix matrix, int i) {
        q qVarZ = this.g.z();
        View viewZ = qVarZ != null ? qVarZ.z("view:", this.uy) : null;
        if (this.gz <= 0 || viewZ == null) {
            return;
        }
        canvas.save();
        canvas.concat(matrix);
        z(i);
        float fGz = gz();
        z(viewZ, this.gz, this.fo);
        viewZ.setAlpha(fGz);
        viewZ.draw(canvas);
        canvas.restore();
    }

    private static void z(View view, int i, int i2) {
        view.layout(0, 0, i, i2);
        view.measure(View.MeasureSpec.makeMeasureSpec(i, 1073741824), View.MeasureSpec.makeMeasureSpec(i2, 1073741824));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
    }
}
