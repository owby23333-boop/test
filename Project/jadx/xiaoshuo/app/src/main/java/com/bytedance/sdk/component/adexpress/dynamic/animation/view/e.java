package com.bytedance.sdk.component.adexpress.dynamic.animation.view;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Shader;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.component.adexpress.dynamic.d.p;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicImageView;
import com.bytedance.sdk.component.utils.dt;

/* JADX INFO: loaded from: classes.dex */
public class e {
    Path bf = new Path();
    private int d;
    Paint e;
    private int ga;
    private int tg;

    public e() {
        Paint paint = new Paint();
        this.e = paint;
        paint.setAntiAlias(true);
    }

    public void e(Canvas canvas, bf bfVar, View view) {
        int iIntValue;
        int iIntValue2;
        float[] fArrBf;
        if (bfVar.getRippleValue() != 0.0f) {
            if (com.bytedance.sdk.component.adexpress.e.e.e.e().d() != null) {
                try {
                    fArrBf = p.bf((String) view.getTag(dt.ga(com.bytedance.sdk.component.adexpress.e.e.e.e().d().getContext(), "tt_id_ripple_bg")));
                } catch (Exception unused) {
                    fArrBf = null;
                }
                if (fArrBf != null) {
                    this.e.setColor(com.bytedance.sdk.component.adexpress.d.bf.e(fArrBf[3] * (1.0f - bfVar.getRippleValue()), fArrBf[0] / 256.0f, fArrBf[1] / 256.0f, fArrBf[2] / 256.0f));
                }
            }
            ((ViewGroup) view.getParent()).setClipChildren(true);
            canvas.drawCircle(this.d, this.tg, Math.min(r3, r10) * 2 * bfVar.getRippleValue(), this.e);
        }
        if (bfVar.getShineValue() != 0.0f) {
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).setClipChildren(true);
            }
            if (view.getParent().getParent() != null) {
                ((ViewGroup) view.getParent().getParent()).setClipChildren(true);
            }
            this.bf.reset();
            try {
                iIntValue2 = ((Integer) view.getTag(dt.ga(view.getContext(), "tt_id_shine_width"))).intValue();
            } catch (Exception unused2) {
                iIntValue2 = 0;
            }
            if (iIntValue2 >= 0) {
                int iE = (int) com.bytedance.sdk.component.adexpress.d.bf.e(view.getContext(), iIntValue2);
                Path path = this.bf;
                float shineValue = ((this.d * 2) + iE + (this.tg * 2)) * bfVar.getShineValue();
                int i = this.tg;
                path.moveTo((shineValue - ((i * 2) + iE)) + (i * 2), 0.0f);
                Path path2 = this.bf;
                float shineValue2 = ((this.d * 2) + iE + (this.tg * 2)) * bfVar.getShineValue();
                int i2 = this.tg;
                float f = iE;
                path2.lineTo((shineValue2 - ((i2 * 2) + iE)) + f + (i2 * 2), 0.0f);
                Path path3 = this.bf;
                float shineValue3 = ((this.d * 2) + iE + (this.tg * 2)) * bfVar.getShineValue();
                int i3 = this.tg;
                path3.lineTo((shineValue3 - ((i3 * 2) + iE)) + f, i3 * 2);
                Path path4 = this.bf;
                float shineValue4 = ((this.d * 2) + iE + (this.tg * 2)) * bfVar.getShineValue();
                int i4 = this.tg;
                path4.lineTo(shineValue4 - ((i4 * 2) + iE), i4 * 2);
                this.bf.close();
                float shineValue5 = ((this.d * 2) + iE + (this.tg * 2)) * bfVar.getShineValue();
                float f2 = this.tg + (shineValue5 - ((r11 * 2) + iE));
                float shineValue6 = ((this.d * 2) + iE + (r11 * 2)) * bfVar.getShineValue();
                int i5 = this.tg;
                this.e.setShader(new LinearGradient(f2, 0.0f, (iE / 2) + (shineValue6 - ((i5 * 2) + iE)) + i5, i5, Color.parseColor("#10ffffff"), Color.parseColor("#50ffffff"), Shader.TileMode.MIRROR));
                canvas.drawPath(this.bf, this.e);
            }
        }
        if (bfVar.getMarqueeValue() != 0.0f) {
            try {
                iIntValue = ((Integer) view.getTag(dt.ga(view.getContext(), "tt_id_width"))).intValue();
            } catch (Exception unused3) {
                iIntValue = 0;
            }
            if (iIntValue >= 0) {
                this.bf.reset();
                this.bf.moveTo(0.0f, 0.0f);
                this.bf.lineTo(this.d * 2, 0.0f);
                this.bf.lineTo(this.d * 2, this.tg * 2);
                this.bf.lineTo(0.0f, this.tg * 2);
                this.bf.lineTo(0.0f, 0.0f);
                this.e.setShader(new LinearGradient(0.0f, 0.0f, this.d * 2, this.tg * 2, new int[]{(int) (bfVar.getMarqueeValue() * (-65536.0f)), (int) ((1.0f - bfVar.getMarqueeValue()) * (-65536.0f))}, (float[]) null, Shader.TileMode.CLAMP));
                this.e.setColor(-65536);
                this.e.setStyle(Paint.Style.STROKE);
                this.e.setStrokeWidth(iIntValue);
                canvas.drawPath(this.bf, this.e);
            }
        }
    }

    public void e(View view, float f) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = (int) (this.ga * f);
        view.setTranslationX((r1 - r6) / 2);
        if (view instanceof DynamicImageView) {
            int i = 0;
            while (true) {
                ViewGroup viewGroup = (ViewGroup) view;
                if (i >= viewGroup.getChildCount()) {
                    break;
                }
                viewGroup.getChildAt(i).setTranslationX((-(this.ga - layoutParams.width)) / 2);
                i++;
            }
        }
        view.setLayoutParams(layoutParams);
    }

    public void e(View view, int i, int i2) {
        String str;
        this.d = i / 2;
        this.tg = i2 / 2;
        if (this.ga == 0 && view.getLayoutParams().width > 0) {
            this.ga = view.getLayoutParams().width;
        }
        try {
            str = (String) view.getTag(dt.ga(view.getContext(), "tt_id_direction"));
        } catch (Exception unused) {
            str = "";
        }
        if ("right".equals(str)) {
            view.setPivotX(this.d * 2);
            view.setPivotY(this.tg);
        } else if ("left".equals(str)) {
            view.setPivotX(0.0f);
            view.setPivotY(this.tg);
        } else {
            view.setPivotX(this.d);
            view.setPivotY(this.tg);
        }
    }
}
