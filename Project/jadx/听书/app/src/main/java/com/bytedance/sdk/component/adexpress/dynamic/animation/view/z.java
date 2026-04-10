package com.bytedance.sdk.component.adexpress.dynamic.animation.view;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.internal.view.SupportMenu;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.bytedance.sdk.component.adexpress.a.gz;
import com.bytedance.sdk.component.adexpress.dynamic.dl.e;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicImageView;

/* JADX INFO: loaded from: classes2.dex */
public class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f547a;
    private int gc;
    private int m;
    Paint z;
    Path g = new Path();
    Path dl = new Path();

    public z() {
        Paint paint = new Paint();
        this.z = paint;
        paint.setAntiAlias(true);
    }

    public void z(Canvas canvas, g gVar, View view) {
        int iIntValue;
        int iIntValue2;
        String str;
        float[] fArrG;
        if (gVar.getRippleValue() != 0.0f) {
            if (com.bytedance.sdk.component.adexpress.z.z.z.z().dl() != null) {
                try {
                    str = (String) view.getTag(2097610712);
                } catch (Exception unused) {
                    str = "";
                }
                try {
                    fArrG = e.g(str);
                } catch (Exception unused2) {
                    fArrG = null;
                }
                if (str.startsWith("#")) {
                    this.z.setColor(Color.parseColor(str));
                    this.z.setAlpha(90);
                } else if (fArrG != null) {
                    this.z.setColor(gz.z(fArrG[3] * (1.0f - gVar.getRippleValue()), fArrG[0] / 256.0f, fArrG[1] / 256.0f, fArrG[2] / 256.0f));
                }
            }
            ((ViewGroup) view.getParent()).setClipChildren(true);
            canvas.drawCircle(this.f547a, this.gc, Math.min(r1, r4) * 2 * gVar.getRippleValue(), this.z);
        }
        if (gVar.getShineValue() != 0.0f) {
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).setClipChildren(true);
            }
            if (view.getParent().getParent() != null) {
                ((ViewGroup) view.getParent().getParent()).setClipChildren(true);
            }
            this.g.reset();
            try {
                iIntValue2 = ((Integer) view.getTag(2097610711)).intValue();
            } catch (Exception unused3) {
                iIntValue2 = 0;
            }
            if (iIntValue2 >= 0) {
                int shineValue = ((int) ((((this.f547a * 4) + (iIntValue2 * 2)) + (this.gc * 2)) * gVar.getShineValue())) - ((this.gc * 2) + iIntValue2);
                float f = shineValue;
                int i = this.gc;
                this.z.setShader(new LinearGradient(f, 0.0f, ((iIntValue2 + i) / 2) + shineValue, i / 2, new int[]{Color.parseColor("#20ffffff"), Color.parseColor("#60ffffff"), Color.parseColor("#65ffffff")}, (float[]) null, Shader.TileMode.MIRROR));
                this.z.setStrokeWidth(this.f547a * 2);
                Path path = this.dl;
                if (path != null) {
                    canvas.clipPath(path, Region.Op.INTERSECT);
                }
                int i2 = shineValue + iIntValue2;
                canvas.drawLine(f, 0.0f, i2 + r1, this.gc, this.z);
            }
        }
        if (gVar.getMarqueeValue() != 0.0f) {
            try {
                iIntValue = ((Integer) view.getTag(2097610709)).intValue();
            } catch (Exception unused4) {
                iIntValue = 0;
            }
            if (iIntValue >= 0) {
                this.g.reset();
                this.g.moveTo(0.0f, 0.0f);
                this.g.lineTo(this.f547a * 2, 0.0f);
                this.g.lineTo(this.f547a * 2, this.gc * 2);
                this.g.lineTo(0.0f, this.gc * 2);
                this.g.lineTo(0.0f, 0.0f);
                this.z.setShader(new LinearGradient(0.0f, 0.0f, this.f547a * 2, this.gc * 2, new int[]{(int) (gVar.getMarqueeValue() * (-65536.0f)), (int) ((1.0f - gVar.getMarqueeValue()) * (-65536.0f))}, (float[]) null, Shader.TileMode.CLAMP));
                this.z.setColor(SupportMenu.CATEGORY_MASK);
                this.z.setStyle(Paint.Style.STROKE);
                this.z.setStrokeWidth(iIntValue);
                canvas.drawPath(this.g, this.z);
            }
        }
    }

    public void z(View view, float f) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = (int) (this.m * f);
        view.setTranslationX((this.m - layoutParams.width) / 2);
        if (view instanceof DynamicImageView) {
            int i = 0;
            while (true) {
                ViewGroup viewGroup = (ViewGroup) view;
                if (i >= viewGroup.getChildCount()) {
                    break;
                }
                viewGroup.getChildAt(i).setTranslationX((-(this.m - layoutParams.width)) / 2);
                i++;
            }
        }
        view.setLayoutParams(layoutParams);
    }

    public void z(View view, int i, int i2) {
        String str;
        this.f547a = i / 2;
        this.gc = i2 / 2;
        if (this.m == 0 && view.getLayoutParams().width > 0) {
            this.m = view.getLayoutParams().width;
        }
        try {
            str = (String) view.getTag(2097610710);
            try {
                this.dl.addRoundRect(new RectF(0.0f, 0.0f, i, i2), i2 / 2, i2 / 2, Path.Direction.CW);
            } catch (Exception unused) {
            }
        } catch (Exception unused2) {
            str = "";
        }
        if (TtmlNode.RIGHT.equals(str)) {
            view.setPivotX(this.f547a * 2);
            view.setPivotY(this.gc);
        } else if (TtmlNode.LEFT.equals(str)) {
            view.setPivotX(0.0f);
            view.setPivotY(this.gc);
        } else {
            view.setPivotX(this.f547a);
            view.setPivotY(this.gc);
        }
    }
}
