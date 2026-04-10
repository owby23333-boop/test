package com.bytedance.adsdk.ugeno.z.z;

import android.animation.PropertyValuesHolder;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import androidx.media3.extractor.text.ttml.TtmlNode;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class gc extends z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f278a;
    private float dl;
    private String e;
    private boolean fo;
    private Paint gc;
    private boolean gz;
    private PorterDuffXfermode i;
    private Path kb;
    private float m;
    private Path uy;
    private Path wp;

    public gc(com.bytedance.adsdk.ugeno.g.dl dlVar, JSONObject jSONObject) {
        super(dlVar, jSONObject);
        this.gz = true;
        this.fo = true;
        Paint paint = new Paint();
        this.gc = paint;
        paint.setAntiAlias(true);
        this.g.fo().setLayerType(2, null);
        this.i = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
        this.uy = new Path();
        this.kb = new Path();
        this.wp = new Path();
    }

    @Override // com.bytedance.adsdk.ugeno.z.z.z
    public void g() {
        this.m = (float) this.z.optDouble(TtmlNode.START, 0.0d);
        this.e = this.z.optString("direction", TtmlNode.CENTER);
    }

    @Override // com.bytedance.adsdk.ugeno.z.z.z
    public void z(Canvas canvas) {
        int iY;
        int iY2;
        if (this.g.y() > 0.0f) {
            iY = (int) (this.dl * this.g.y());
            iY2 = (int) (this.f278a * this.g.y());
            this.gc.setXfermode(this.i);
            String str = this.e;
            str.hashCode();
            switch (str) {
                case "bottom":
                    canvas.drawRect(0.0f, iY2, this.dl, this.f278a, this.gc);
                    break;
                case "center":
                    this.uy.reset();
                    this.kb.reset();
                    this.wp.reset();
                    this.uy.addCircle(this.dl / 2.0f, this.f278a / 2.0f, iY, Path.Direction.CW);
                    Path path = this.kb;
                    float f = this.dl;
                    path.addRect(f / 2.0f, 0.0f, f, this.f278a, Path.Direction.CW);
                    this.kb.op(this.uy, Path.Op.DIFFERENCE);
                    this.wp.addRect(0.0f, 0.0f, this.dl / 2.0f, this.f278a, Path.Direction.CW);
                    this.wp.op(this.uy, Path.Op.DIFFERENCE);
                    canvas.drawPath(this.kb, this.gc);
                    canvas.drawPath(this.wp, this.gc);
                    break;
                case "top":
                    canvas.drawRect(0.0f, 0.0f, this.dl, this.f278a - iY2, this.gc);
                    break;
                case "left":
                    canvas.drawRect(0.0f, 0.0f, this.dl - iY, this.f278a, this.gc);
                    break;
                case "right":
                    canvas.drawRect(iY, 0.0f, this.dl, this.f278a, this.gc);
                    break;
            }
        }
    }

    @Override // com.bytedance.adsdk.ugeno.z.z.z
    public void z(int i, int i2) {
        if (i > 0 && this.gz) {
            this.dl = i;
            this.gz = false;
        }
        if (i2 <= 0 || !this.fo) {
            return;
        }
        this.f278a = i2;
        this.fo = false;
    }

    @Override // com.bytedance.adsdk.ugeno.z.z.z
    public List<PropertyValuesHolder> dl() {
        PropertyValuesHolder propertyValuesHolderOfFloat = PropertyValuesHolder.ofFloat(a(), this.m, 1.0f);
        ArrayList arrayList = new ArrayList();
        arrayList.add(propertyValuesHolderOfFloat);
        return arrayList;
    }
}
