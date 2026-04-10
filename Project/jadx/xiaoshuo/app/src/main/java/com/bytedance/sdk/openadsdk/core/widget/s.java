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
import com.bytedance.sdk.component.utils.dt;
import com.bytedance.sdk.openadsdk.core.lc;

/* JADX INFO: loaded from: classes10.dex */
public class s extends Drawable {
    private int bf;
    private int[] d;
    private int e;
    private LinearGradient ga;
    private RectF m;
    private int p;
    private float[] tg;
    private int v;
    private int vn;
    private Paint wu;
    private int zk;

    public static class e {
        private int[] d;
        private LinearGradient ga;
        private float[] tg;
        private int v;
        private int zk;
        private int e = dt.wu(lc.getContext(), "tt_ssxinmian8");
        private int bf = dt.wu(lc.getContext(), "tt_ssxinxian3");
        private int vn = 10;
        private int p = 16;

        public e() {
            this.v = 0;
            this.zk = 0;
            this.v = 0;
            this.zk = 0;
        }

        public e bf(int i) {
            this.bf = i;
            return this;
        }

        public e d(int i) {
            this.vn = i;
            return this;
        }

        public e e(int i) {
            this.e = i;
            return this;
        }

        public e ga(int i) {
            this.zk = i;
            return this;
        }

        public e tg(int i) {
            this.v = i;
            return this;
        }

        public e e(int[] iArr) {
            this.d = iArr;
            return this;
        }

        public s e() {
            return new s(this.e, this.d, this.tg, this.bf, this.ga, this.vn, this.p, this.v, this.zk);
        }
    }

    public s(int i, int[] iArr, float[] fArr, int i2, LinearGradient linearGradient, int i3, int i4, int i5, int i6) {
        this.e = i;
        this.d = iArr;
        this.tg = fArr;
        this.bf = i2;
        this.ga = linearGradient;
        this.vn = i3;
        this.p = i4;
        this.v = i5;
        this.zk = i6;
    }

    private void e() {
        int[] iArr;
        Paint paint = new Paint();
        this.wu = paint;
        paint.setAntiAlias(true);
        this.wu.setShadowLayer(this.p, this.v, this.zk, this.bf);
        if (this.m == null || (iArr = this.d) == null || iArr.length <= 1) {
            this.wu.setColor(this.e);
            return;
        }
        float[] fArr = this.tg;
        boolean z = fArr != null && fArr.length > 0 && fArr.length == iArr.length;
        Paint paint2 = this.wu;
        LinearGradient linearGradient = this.ga;
        if (linearGradient == null) {
            RectF rectF = this.m;
            linearGradient = new LinearGradient(rectF.left, 0.0f, rectF.right, 0.0f, this.d, z ? this.tg : null, Shader.TileMode.CLAMP);
        }
        paint2.setShader(linearGradient);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.m == null) {
            Rect bounds = getBounds();
            int i = bounds.left;
            int i2 = this.p;
            int i3 = this.v;
            int i4 = bounds.top + i2;
            int i5 = this.zk;
            this.m = new RectF((i + i2) - i3, i4 - i5, (bounds.right - i2) - i3, (bounds.bottom - i2) - i5);
        }
        if (this.wu == null) {
            e();
        }
        RectF rectF = this.m;
        int i6 = this.vn;
        canvas.drawRoundRect(rectF, i6, i6, this.wu);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        Paint paint = this.wu;
        if (paint != null) {
            paint.setAlpha(i);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Paint paint = this.wu;
        if (paint != null) {
            paint.setColorFilter(colorFilter);
        }
    }

    public static void e(View view, e eVar) {
        if (view == null || eVar == null) {
            return;
        }
        view.setLayerType(1, null);
        view.setBackground(eVar.e());
    }
}
