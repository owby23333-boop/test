package com.bytedance.adsdk.ugeno.z.z;

import android.animation.PropertyValuesHolder;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.view.View;
import androidx.media3.extractor.text.ttml.TtmlNode;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class dl extends z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f276a;
    private String dl;
    private Paint e;
    private PorterDuffXfermode fo;
    private float gc;
    private Paint gz;
    private Matrix kb;
    private View m;
    private LinearGradient uy;

    public dl(com.bytedance.adsdk.ugeno.g.dl dlVar, JSONObject jSONObject) {
        super(dlVar, jSONObject);
        this.m = this.g.fo();
        Paint paint = new Paint();
        this.e = paint;
        paint.setAntiAlias(true);
        this.m.setLayerType(2, null);
        this.fo = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
        this.gz = new Paint();
        this.kb = new Matrix();
    }

    @Override // com.bytedance.adsdk.ugeno.z.z.z
    public void g() {
        this.dl = this.z.optString("direction", TtmlNode.LEFT);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:20:0x005d  */
    @Override // com.bytedance.adsdk.ugeno.z.z.z
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void z(android.graphics.Canvas r23) {
        /*
            Method dump skipped, instruction units count: 494
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.ugeno.z.z.dl.z(android.graphics.Canvas):void");
    }

    @Override // com.bytedance.adsdk.ugeno.z.z.z
    public void z(int i, int i2) {
        this.f276a = i;
        this.gc = i2;
        String str = this.dl;
        str.hashCode();
        switch (str) {
            case "bottom":
                this.uy = new LinearGradient(0.0f, -this.gc, 0.0f, 0.0f, 0, -1, Shader.TileMode.CLAMP);
                break;
            case "top":
                this.uy = new LinearGradient(0.0f, this.gc, 0.0f, 0.0f, 0, -1, Shader.TileMode.CLAMP);
                break;
            case "left":
                this.uy = new LinearGradient(this.f276a, 0.0f, 0.0f, 0.0f, 0, -1, Shader.TileMode.CLAMP);
                break;
            case "right":
                this.uy = new LinearGradient(-this.f276a, 0.0f, 0.0f, this.gc, 0, -1, Shader.TileMode.CLAMP);
                break;
        }
    }

    @Override // com.bytedance.adsdk.ugeno.z.z.z
    public List<PropertyValuesHolder> dl() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(PropertyValuesHolder.ofFloat("rubIn", 0.0f, 1.0f));
        arrayList.add(PropertyValuesHolder.ofFloat(com.bytedance.adsdk.ugeno.z.gc.ALPHA.g(), 0.0f, 1.0f));
        return arrayList;
    }
}
