package com.bytedance.adsdk.ugeno.z.z;

import android.animation.PropertyValuesHolder;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;
import android.text.TextUtils;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.bytedance.adsdk.ugeno.m.gz;
import com.bytedance.adsdk.ugeno.m.z;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class a extends z {
    private static final float ls;
    private static final float p;
    private static final float pf;
    private static final float v;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Paint f275a;
    private int dl;
    private int e;
    private float fo;
    private float fv;
    private Path gc;
    private int gz;
    private Path i;
    private int kb;
    private z.C0047z m;
    private int uy;
    private boolean wp;

    static {
        float radians = (float) Math.toRadians(30.0d);
        v = radians;
        pf = (float) Math.tan(radians);
        ls = (float) Math.cos(radians);
        p = (float) Math.sin(radians);
    }

    public a(com.bytedance.adsdk.ugeno.g.dl dlVar, JSONObject jSONObject) {
        super(dlVar, jSONObject);
        this.wp = true;
        Paint paint = new Paint();
        this.f275a = paint;
        paint.setAntiAlias(true);
        this.gc = new Path();
        this.fo = this.g.q();
        this.i = new Path();
    }

    @Override // com.bytedance.adsdk.ugeno.z.z.z
    public void g() {
        this.dl = (int) gz.z(this.g.fo().getContext(), this.z.optInt("shineWidth", 30));
        String strOptString = this.z.optString(TtmlNode.ATTR_TTS_BACKGROUND_COLOR, "linear-gradient(90deg, rgba(255, 255, 255, 0), rgba(255, 255, 255, 0.25) 30%, rgba(255, 255, 255, 0.3) 50%, rgba(255, 255, 255, 0.25) 70%, rgba(255, 255, 255, 0))");
        String str = TextUtils.isEmpty(strOptString) ? "linear-gradient(90deg, rgba(255, 255, 255, 0), rgba(255, 255, 255, 0.25) 30%, rgba(255, 255, 255, 0.3) 50%, rgba(255, 255, 255, 0.25) 70%, rgba(255, 255, 255, 0))" : strOptString;
        if (str.startsWith("linear")) {
            this.m = com.bytedance.adsdk.ugeno.m.z.g(str);
        } else {
            int iZ = com.bytedance.adsdk.ugeno.m.z.z(str);
            this.e = iZ;
            this.gz = com.bytedance.adsdk.ugeno.m.z.z(iZ, 32);
            this.wp = false;
        }
        this.fv = ls * this.dl;
    }

    @Override // com.bytedance.adsdk.ugeno.z.z.z
    public void z(Canvas canvas) {
        LinearGradient linearGradient;
        try {
            if (this.g.vm() > 0.0f) {
                int i = this.uy;
                float f = pf;
                float fVm = (i + (i * f)) * this.g.vm();
                this.i.reset();
                this.i.moveTo(fVm, 0.0f);
                int i2 = this.kb;
                float f2 = fVm - (i2 * f);
                this.i.lineTo(f2, i2);
                this.i.lineTo(f2 + this.dl, this.kb);
                this.i.lineTo(this.dl + fVm, 0.0f);
                this.i.close();
                float f3 = this.fv;
                float f4 = ls * f3;
                float f5 = f3 * p;
                if (this.wp && this.m != null) {
                    linearGradient = new LinearGradient(fVm, 0.0f, fVm + f4, f5, this.m.g, (float[]) null, Shader.TileMode.CLAMP);
                } else {
                    float f6 = fVm + f4;
                    int i3 = this.gz;
                    linearGradient = new LinearGradient(fVm, 0.0f, f6, f5, new int[]{i3, this.e, i3}, (float[]) null, Shader.TileMode.CLAMP);
                }
                this.f275a.setShader(linearGradient);
                Path path = this.gc;
                if (path != null) {
                    canvas.clipPath(path, Region.Op.INTERSECT);
                }
                canvas.drawPath(this.i, this.f275a);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.adsdk.ugeno.z.z.z
    public void z(int i, int i2) {
        this.uy = i;
        this.kb = i2;
        try {
            RectF rectF = new RectF(0.0f, 0.0f, i, i2);
            Path path = this.gc;
            float f = this.fo;
            path.addRoundRect(rectF, f, f, Path.Direction.CW);
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.adsdk.ugeno.z.z.z
    public List<PropertyValuesHolder> dl() {
        PropertyValuesHolder propertyValuesHolderOfFloat = PropertyValuesHolder.ofFloat(a(), 0.0f, 1.0f);
        ArrayList arrayList = new ArrayList();
        arrayList.add(propertyValuesHolderOfFloat);
        return arrayList;
    }
}
