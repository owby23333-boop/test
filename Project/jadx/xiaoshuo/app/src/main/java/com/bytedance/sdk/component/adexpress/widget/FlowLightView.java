package com.bytedance.sdk.component.adexpress.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.Xfermode;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.sdk.component.utils.dt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class FlowLightView extends View {
    Rect bf;
    private PorterDuff.Mode bh;
    private int d;
    Rect e;
    private int ga;
    private Bitmap m;
    private int p;
    private final List<e> s;
    private LinearGradient t;
    private int tg;
    private int v;
    private int vn;
    private Paint wu;
    private Xfermode xu;
    private int[] zk;

    public static class e {
        private int bf = 0;
        private final int e;

        public e(int i) {
            this.e = i;
        }

        public void e() {
            this.bf += this.e;
        }
    }

    public FlowLightView(Context context) {
        super(context);
        this.bh = PorterDuff.Mode.DST_IN;
        this.s = new ArrayList();
        e();
    }

    private void e() {
        this.d = dt.tg(getContext(), "tt_splash_unlock_image_arrow");
        this.tg = Color.parseColor("#00ffffff");
        this.ga = Color.parseColor("#ffffffff");
        int color = Color.parseColor("#00ffffff");
        this.vn = color;
        this.p = 10;
        this.v = 40;
        this.zk = new int[]{this.tg, this.ga, color};
        setLayerType(1, null);
        this.wu = new Paint(1);
        this.m = BitmapFactory.decodeResource(getResources(), this.d);
        this.xu = new PorterDuffXfermode(this.bh);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(this.m, this.e, this.bf, this.wu);
        canvas.save();
        Iterator<e> it = this.s.iterator();
        while (it.hasNext()) {
            e next = it.next();
            this.t = new LinearGradient(next.bf, 0.0f, next.bf + this.v, this.p, this.zk, (float[]) null, Shader.TileMode.CLAMP);
            this.wu.setColor(-1);
            this.wu.setShader(this.t);
            canvas.drawRect(0.0f, 0.0f, getWidth(), getHeight(), this.wu);
            this.wu.setShader(null);
            next.e();
            if (next.bf > getWidth()) {
                it.remove();
            }
        }
        this.wu.setXfermode(this.xu);
        canvas.drawBitmap(this.m, this.e, this.bf, this.wu);
        this.wu.setXfermode(null);
        canvas.restore();
        invalidate();
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.e = new Rect(0, 0, this.m.getWidth(), this.m.getHeight());
        this.bf = new Rect(0, 0, getWidth(), getHeight());
    }

    public FlowLightView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bh = PorterDuff.Mode.DST_IN;
        this.s = new ArrayList();
        e();
    }

    public FlowLightView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bh = PorterDuff.Mode.DST_IN;
        this.s = new ArrayList();
        e();
    }

    public void e(int i) {
        this.s.add(new e(i));
        postInvalidate();
    }
}
