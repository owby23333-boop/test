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
import android.view.View;
import com.bytedance.sdk.component.utils.tb;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class FlowLightView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f597a;
    private int dl;
    private int e;
    private int[] fo;
    Rect g;
    private int gc;
    private int gz;
    private PorterDuff.Mode i;
    private Paint kb;
    private int m;
    private final List<z> pf;
    private Bitmap uy;
    private LinearGradient v;
    private Xfermode wp;
    Rect z;

    public FlowLightView(Context context) {
        super(context);
        this.i = PorterDuff.Mode.DST_IN;
        this.pf = new ArrayList();
        z();
    }

    private void z() {
        this.dl = tb.gc(getContext(), "tt_splash_unlock_image_arrow");
        this.f597a = Color.parseColor("#00ffffff");
        this.gc = Color.parseColor("#ffffffff");
        int color = Color.parseColor("#00ffffff");
        this.m = color;
        this.e = 10;
        this.gz = 40;
        this.fo = new int[]{this.f597a, this.gc, color};
        setLayerType(1, null);
        this.kb = new Paint(1);
        this.uy = BitmapFactory.decodeResource(getResources(), this.dl);
        this.wp = new PorterDuffXfermode(this.i);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(this.uy, this.z, this.g, this.kb);
        canvas.save();
        Iterator<z> it = this.pf.iterator();
        while (it.hasNext()) {
            z next = it.next();
            this.v = new LinearGradient(next.g, 0.0f, next.g + this.gz, this.e, this.fo, (float[]) null, Shader.TileMode.CLAMP);
            this.kb.setColor(-1);
            this.kb.setShader(this.v);
            canvas.drawRect(0.0f, 0.0f, getWidth(), getHeight(), this.kb);
            this.kb.setShader(null);
            next.z();
            if (next.g > getWidth()) {
                it.remove();
            }
        }
        this.kb.setXfermode(this.wp);
        canvas.drawBitmap(this.uy, this.z, this.g, this.kb);
        this.kb.setXfermode(null);
        canvas.restore();
        invalidate();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.uy == null) {
            return;
        }
        this.z = new Rect(0, 0, this.uy.getWidth(), this.uy.getHeight());
        this.g = new Rect(0, 0, getWidth(), getHeight());
    }

    public void z(int i) {
        this.pf.add(new z(i));
        postInvalidate();
    }

    public static class z {
        private int g = 0;
        private final int z;

        public z(int i) {
            this.z = i;
        }

        public void z() {
            this.g += this.z;
        }
    }
}
