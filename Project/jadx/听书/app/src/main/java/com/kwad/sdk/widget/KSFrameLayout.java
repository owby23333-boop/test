package com.kwad.sdk.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.kwad.sdk.R;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.aj;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes4.dex */
public class KSFrameLayout extends FrameLayout implements com.kwad.sdk.core.view.d, g, k {
    private com.kwad.sdk.core.view.c aLK;
    private final aj.a aLL;
    private final AtomicBoolean bR;
    private i bdg;
    private k bdh;
    private View bdi;
    private float mRatio;
    private j mViewRCHelper;
    private boolean widthBasedRatio;

    private static float[] getRadius(float f, float f2, float f3, float f4) {
        return new float[]{f, f, f2, f2, f3, f3, f4, f4};
    }

    public KSFrameLayout(Context context) {
        super(context);
        this.bR = new AtomicBoolean(true);
        this.mRatio = 0.0f;
        this.aLL = new aj.a();
        this.aLK = new com.kwad.sdk.core.view.c();
        this.widthBasedRatio = true;
        init(context, null);
    }

    public KSFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bR = new AtomicBoolean(true);
        this.mRatio = 0.0f;
        this.aLL = new aj.a();
        this.aLK = new com.kwad.sdk.core.view.c();
        this.widthBasedRatio = true;
        init(context, attributeSet);
    }

    public KSFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bR = new AtomicBoolean(true);
        this.mRatio = 0.0f;
        this.aLL = new aj.a();
        this.aLK = new com.kwad.sdk.core.view.c();
        this.widthBasedRatio = true;
        init(context, attributeSet);
    }

    public KSFrameLayout(Context context, View view) {
        super(context);
        this.bR = new AtomicBoolean(true);
        this.mRatio = 0.0f;
        this.aLL = new aj.a();
        this.aLK = new com.kwad.sdk.core.view.c();
        this.widthBasedRatio = true;
        this.bdi = view;
        init(context, null);
    }

    protected void init(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            int i = R.attr.ksad_ratio;
            int[] iArr = {i};
            Arrays.sort(iArr);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
            this.mRatio = typedArrayObtainStyledAttributes.getFloat(Arrays.binarySearch(iArr, i), 0.0f);
            typedArrayObtainStyledAttributes.recycle();
        }
        i iVar = new i(getPvView(), this);
        this.bdg = iVar;
        iVar.co(true);
        j jVar = new j();
        this.mViewRCHelper = jVar;
        jVar.initAttrs(context, attributeSet);
    }

    private View getPvView() {
        View view = this.bdi;
        return view == null ? this : view;
    }

    @Override // android.view.ViewGroup, android.view.View
    @Deprecated
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        vX();
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        vX();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        vY();
    }

    @Override // android.view.ViewGroup, android.view.View
    @Deprecated
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        vY();
    }

    private void vX() {
        try {
            if (this.bR.getAndSet(false)) {
                aa();
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    private void vY() {
        try {
            if (this.bR.getAndSet(true)) {
                return;
            }
            ab();
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public void setWidthBasedRatio(boolean z) {
        this.widthBasedRatio = z;
    }

    protected void aa() {
        this.bdg.onAttachedToWindow();
    }

    protected void ab() {
        this.bdg.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        this.bdg.b(i, i2, i3, i4);
        super.onSizeChanged(i, i2, i3, i4);
        this.bdg.SP();
        this.mViewRCHelper.onSizeChanged(i, i2);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        this.mViewRCHelper.beforeDraw(canvas);
        super.draw(canvas);
        this.mViewRCHelper.afterDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        this.mViewRCHelper.beforeDispatchDraw(canvas);
        try {
            super.dispatchDraw(canvas);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
        this.mViewRCHelper.afterDispatchDraw(canvas);
    }

    public void setVisiblePercent(float f) {
        this.bdg.setVisiblePercent(f);
    }

    public void setViewVisibleListener(k kVar) {
        this.bdh = kVar;
    }

    public float getVisiblePercent() {
        return this.bdg.getVisiblePercent();
    }

    public void E(View view) {
        k kVar = this.bdh;
        if (kVar != null) {
            kVar.E(view);
        }
    }

    public void setRadius(float f) {
        this.mViewRCHelper.setRadius(f);
        postInvalidate();
    }

    public void setAllCorner(boolean z) {
        this.mViewRCHelper.getCornerConf().setAllCorner(z);
    }

    public final void setRadius(float f, float f2, float f3, float f4) {
        this.mViewRCHelper.setRadius(getRadius(f, f2, f3, f4));
        postInvalidate();
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.mRatio != 0.0f) {
            if (this.widthBasedRatio) {
                i2 = View.MeasureSpec.makeMeasureSpec((int) (View.MeasureSpec.getSize(i) * this.mRatio), 1073741824);
            } else {
                i = View.MeasureSpec.makeMeasureSpec((int) (View.MeasureSpec.getSize(i2) / this.mRatio), 1073741824);
            }
        }
        super.onMeasure(i, i2);
    }

    public void setRatio(float f) {
        this.mRatio = f;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.aLL.B(getWidth(), getHeight());
            this.aLL.e(motionEvent.getX(), motionEvent.getY());
        } else if (action == 1) {
            this.aLL.f(motionEvent.getX(), motionEvent.getY());
        }
        com.kwad.sdk.core.e.e(motionEvent);
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.kwad.sdk.widget.g
    public aj.a getTouchCoords() {
        return this.aLL;
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        this.aLK.j(this, z);
    }

    @Override // com.kwad.sdk.core.view.d
    public com.kwad.sdk.core.view.c getWindowFocusChangeHelper() {
        return this.aLK;
    }
}
