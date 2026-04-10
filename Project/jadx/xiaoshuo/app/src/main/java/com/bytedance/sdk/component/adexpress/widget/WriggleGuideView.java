package com.bytedance.sdk.component.adexpress.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.sdk.component.utils.dt;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class WriggleGuideView extends View {
    private int bf;
    private Bitmap d;
    private int e;
    private Paint ga;
    private e m;
    private final List<Object> p;
    private Bitmap tg;
    private boolean v;
    private int vn;
    private boolean zk;

    public interface e {
        void e();
    }

    public WriggleGuideView(Context context) {
        this(context, null);
    }

    private Bitmap bf(int i, int i2) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint(1);
        Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(getContext().getResources(), dt.tg(getContext(), "tt_wriggle_union_white"));
        if (bitmapDecodeResource != null) {
            canvas.drawBitmap(bitmapDecodeResource, (Rect) null, new RectF(0.0f, 0.0f, i, i2), paint);
        }
        return bitmapCreateBitmap;
    }

    private Bitmap d(int i, int i2) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint(1);
        paint.setColor(-1);
        canvas.drawCircle(i / 2, 10.0f, this.vn, paint);
        return bitmapCreateBitmap;
    }

    private Bitmap e(int i, int i2) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(getContext().getResources(), dt.tg(getContext(), "tt_wriggle_union"));
        if (bitmapDecodeResource != null) {
            canvas.drawBitmap(bitmapDecodeResource, (Rect) null, new RectF(0.0f, 0.0f, i, i2), this.ga);
        }
        return bitmapCreateBitmap;
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.m != null) {
            this.m = null;
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.v) {
            this.e = getWidth();
            int height = getHeight();
            this.bf = height;
            this.d = e(this.e, height);
            this.tg = bf(this.e, this.bf);
            this.v = false;
        }
        canvas.drawBitmap(this.d, 0.0f, 0.0f, this.ga);
        int iSaveLayer = canvas.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null, 31);
        canvas.drawBitmap(this.tg, 0.0f, 0.0f, this.ga);
        this.ga.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(d(this.e, this.bf), 0.0f, 0.0f, this.ga);
        this.ga.setXfermode(null);
        canvas.restoreToCount(iSaveLayer);
        if (this.zk) {
            this.vn += 5;
            invalidate();
            if (this.vn >= this.e) {
                e eVar = this.m;
                if (eVar != null) {
                    eVar.e();
                }
                this.zk = false;
            }
        }
    }

    public WriggleGuideView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WriggleGuideView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.e = 0;
        this.bf = 0;
        this.vn = 0;
        ArrayList arrayList = new ArrayList();
        this.p = arrayList;
        this.v = true;
        this.zk = false;
        setLayerType(1, null);
        this.ga = new Paint();
        this.ga = new Paint(1);
        arrayList.clear();
    }

    public void e(e eVar) {
        this.m = eVar;
        this.vn = 0;
        this.zk = true;
        invalidate();
    }
}
