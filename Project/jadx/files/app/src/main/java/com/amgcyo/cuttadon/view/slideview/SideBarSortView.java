package com.amgcyo.cuttadon.view.slideview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.tts.tools.cuid.util.DeviceId;

/* JADX INFO: loaded from: classes.dex */
public class SideBarSortView extends View {
    public static String[] A = {"#", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "C", "D", ExifInterface.LONGITUDE_EAST, "F", "G", "H", "I", "J", "K", "L", "M", "N", DeviceId.CUIDInfo.I_FIXED, "P", "Q", "R", ExifInterface.LATITUDE_SOUTH, ExifInterface.GPS_DIRECTION_TRUE, "U", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, ExifInterface.LONGITUDE_WEST, "X", "Y", "Z"};

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private Canvas f5513s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f5514t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private float f5515u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f5516v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private float f5517w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int f5518x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Paint f5519y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private a f5520z;

    public interface a {
        void a();

        void a(String str);
    }

    public SideBarSortView(Context context) {
        super(context);
        this.f5514t = 0;
        this.f5519y = new Paint();
    }

    private void a() {
        int height = getHeight() / A.length;
        for (int i2 = 0; i2 < A.length; i2++) {
            if (i2 == this.f5514t) {
                this.f5519y.setColor(this.f5518x);
                this.f5519y.setTextSize(this.f5517w);
            } else {
                this.f5519y.setColor(this.f5516v);
                this.f5519y.setTextSize(this.f5515u);
            }
            this.f5519y.setAntiAlias(true);
            this.f5519y.setTypeface(Typeface.DEFAULT_BOLD);
            this.f5513s.drawText(A[i2], (getWidth() / 2.0f) - (this.f5519y.measureText(A[i2]) / 2.0f), (height * i2) + height, this.f5519y);
            this.f5519y.reset();
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f5513s = canvas;
        a();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0010  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0018  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r4) {
        /*
            r3 = this;
            int r0 = r4.getAction()
            r1 = 1
            if (r0 == 0) goto L18
            if (r0 == r1) goto L10
            r2 = 2
            if (r0 == r2) goto L18
            r4 = 3
            if (r0 == r4) goto L10
            goto L3c
        L10:
            com.amgcyo.cuttadon.view.slideview.SideBarSortView$a r4 = r3.f5520z
            if (r4 == 0) goto L3c
            r4.a()
            goto L3c
        L18:
            float r4 = r4.getY()
            int r0 = r3.getHeight()
            float r0 = (float) r0
            float r4 = r4 / r0
            java.lang.String[] r0 = com.amgcyo.cuttadon.view.slideview.SideBarSortView.A
            int r2 = r0.length
            float r2 = (float) r2
            float r4 = r4 * r2
            int r4 = (int) r4
            if (r4 < 0) goto L3c
            int r2 = r0.length
            if (r4 >= r2) goto L3c
            com.amgcyo.cuttadon.view.slideview.SideBarSortView$a r2 = r3.f5520z
            if (r2 == 0) goto L37
            r0 = r0[r4]
            r2.a(r0)
        L37:
            r3.f5514t = r4
            r3.invalidate()
        L3c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amgcyo.cuttadon.view.slideview.SideBarSortView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setIndexChangedListener(a aVar) {
        this.f5520z = aVar;
    }

    public void setmTextColor(int i2) {
        this.f5516v = i2;
    }

    public void setmTextColorChoose(int i2) {
        this.f5518x = i2;
    }

    public void setmTextSize(float f2) {
        this.f5515u = f2;
    }

    public void setmTextSizeChoose(float f2) {
        this.f5517w = f2;
    }

    public SideBarSortView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5514t = 0;
        this.f5519y = new Paint();
    }

    public void a(String str) {
        int i2 = 0;
        while (true) {
            String[] strArr = A;
            if (i2 >= strArr.length) {
                return;
            }
            if (strArr[i2].equals(str) && this.f5514t != i2) {
                this.f5514t = i2;
                invalidate();
            }
            i2++;
        }
    }
}
