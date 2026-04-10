package com.bytedance.adsdk.ugeno.z.z;

import android.animation.PropertyValuesHolder;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.ViewGroup;
import androidx.media3.extractor.text.ttml.TtmlNode;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class g extends z {
    private static final int e = Color.parseColor("#7ed321");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f277a;
    private int dl;
    private int gc;
    private Paint m;

    public g(com.bytedance.adsdk.ugeno.g.dl dlVar, JSONObject jSONObject) {
        super(dlVar, jSONObject);
        Paint paint = new Paint();
        this.m = paint;
        paint.setAntiAlias(true);
    }

    @Override // com.bytedance.adsdk.ugeno.z.z.z
    public void g() {
        this.dl = com.bytedance.adsdk.ugeno.m.z.z(this.z.optString(TtmlNode.ATTR_TTS_BACKGROUND_COLOR), e);
    }

    @Override // com.bytedance.adsdk.ugeno.z.z.z
    public void z(Canvas canvas) {
        try {
            if (this.g.t() > 0.0f) {
                this.m.setColor(this.dl);
                this.m.setAlpha((int) ((1.0f - this.g.t()) * 255.0f));
                ((ViewGroup) this.g.fo().getParent()).setClipChildren(true);
                canvas.drawCircle(this.f277a, this.gc, Math.min(r0, r2) * 2 * this.g.t(), this.m);
            }
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.bytedance.adsdk.ugeno.z.z.z
    public void z(int i, int i2) {
        this.f277a = i / 2;
        this.gc = i2 / 2;
    }

    @Override // com.bytedance.adsdk.ugeno.z.z.z
    public List<PropertyValuesHolder> dl() {
        PropertyValuesHolder propertyValuesHolderOfFloat = PropertyValuesHolder.ofFloat(a(), 0.0f, 1.0f);
        ArrayList arrayList = new ArrayList();
        arrayList.add(propertyValuesHolderOfFloat);
        return arrayList;
    }
}
