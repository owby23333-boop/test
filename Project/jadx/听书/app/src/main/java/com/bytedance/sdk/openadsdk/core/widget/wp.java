package com.bytedance.sdk.openadsdk.core.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.bytedance.sdk.component.utils.tb;
import com.bytedance.sdk.openadsdk.core.zw;

/* JADX INFO: loaded from: classes2.dex */
public class wp extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float[] f1427a;
    private int[] dl;
    private int e;
    private int fo;
    private int g;
    private LinearGradient gc;
    private int gz;
    private Paint kb;
    private int m;
    private RectF uy;
    private int z;

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public wp(int i, int[] iArr, float[] fArr, int i2, LinearGradient linearGradient, int i3, int i4, int i5, int i6) {
        this.z = i;
        this.dl = iArr;
        this.f1427a = fArr;
        this.g = i2;
        this.gc = linearGradient;
        this.m = i3;
        this.e = i4;
        this.gz = i5;
        this.fo = i6;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.uy == null) {
            Rect bounds = getBounds();
            this.uy = new RectF((bounds.left + this.e) - this.gz, (bounds.top + this.e) - this.fo, (bounds.right - this.e) - this.gz, (bounds.bottom - this.e) - this.fo);
        }
        if (this.kb == null) {
            z();
        }
        RectF rectF = this.uy;
        int i = this.m;
        canvas.drawRoundRect(rectF, i, i, this.kb);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        Paint paint = this.kb;
        if (paint != null) {
            paint.setAlpha(i);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Paint paint = this.kb;
        if (paint != null) {
            paint.setColorFilter(colorFilter);
        }
    }

    private void z() {
        int[] iArr;
        Paint paint = new Paint();
        this.kb = paint;
        paint.setAntiAlias(true);
        this.kb.setShadowLayer(this.e, this.gz, this.fo, this.g);
        if (this.uy != null && (iArr = this.dl) != null && iArr.length > 1) {
            float[] fArr = this.f1427a;
            boolean z2 = fArr != null && fArr.length > 0 && fArr.length == iArr.length;
            Paint paint2 = this.kb;
            LinearGradient linearGradient = this.gc;
            if (linearGradient == null) {
                linearGradient = new LinearGradient(this.uy.left, 0.0f, this.uy.right, 0.0f, this.dl, z2 ? this.f1427a : null, Shader.TileMode.CLAMP);
            }
            paint2.setShader(linearGradient);
            return;
        }
        this.kb.setColor(this.z);
    }

    public static void z(View view, z zVar) {
        if (view == null || zVar == null) {
            return;
        }
        view.setLayerType(1, null);
        view.setBackground(zVar.z());
    }

    public static class z {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private float[] f1428a;
        private int[] dl;
        private int fo;
        private LinearGradient gc;
        private int gz;
        private int z = tb.uy(zw.getContext(), "tt_ssxinmian8");
        private int g = tb.uy(zw.getContext(), "tt_ssxinxian3");
        private int m = 10;
        private int e = 16;

        public z() {
            this.gz = 0;
            this.fo = 0;
            this.gz = 0;
            this.fo = 0;
        }

        public z z(int i) {
            this.z = i;
            return this;
        }

        public z g(int i) {
            this.g = i;
            return this;
        }

        public z z(int[] iArr) {
            this.dl = iArr;
            return this;
        }

        public z dl(int i) {
            this.m = i;
            return this;
        }

        public z a(int i) {
            this.gz = i;
            return this;
        }

        public z gc(int i) {
            this.fo = i;
            return this;
        }

        public wp z() {
            return new wp(this.z, this.dl, this.f1428a, this.g, this.gc, this.m, this.e, this.gz, this.fo);
        }
    }
}
