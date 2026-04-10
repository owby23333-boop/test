package com.kwad.sdk.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import com.kwad.sdk.R;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.aj;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes4.dex */
public class KSLinearLayout extends LinearLayout implements k {
    private final aj.a aLL;
    private final AtomicBoolean bR;
    private i bdg;
    private k bdh;
    private float mRatio;
    private j mViewRCHelper;

    public KSLinearLayout(Context context) {
        super(context);
        this.bR = new AtomicBoolean(true);
        this.mRatio = 0.0f;
        this.aLL = new aj.a();
        init(context, null);
    }

    public KSLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bR = new AtomicBoolean(true);
        this.mRatio = 0.0f;
        this.aLL = new aj.a();
        init(context, attributeSet);
    }

    public KSLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bR = new AtomicBoolean(true);
        this.mRatio = 0.0f;
        this.aLL = new aj.a();
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            int i = R.attr.ksad_ratio;
            int[] iArr = {i};
            Arrays.sort(iArr);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
            this.mRatio = typedArrayObtainStyledAttributes.getFloat(Arrays.binarySearch(iArr, i), 0.0f);
            typedArrayObtainStyledAttributes.recycle();
        }
        i iVar = new i(this, this);
        this.bdg = iVar;
        iVar.co(true);
        j jVar = new j();
        this.mViewRCHelper = jVar;
        jVar.initAttrs(context, attributeSet);
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
        if (this.bR.getAndSet(false)) {
            aa();
        }
    }

    private void vY() {
        if (this.bR.getAndSet(true)) {
            return;
        }
        ab();
    }

    private void aa() {
        this.bdg.onAttachedToWindow();
    }

    private void ab() {
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

    @Override // com.kwad.sdk.widget.k
    public final void E(View view) {
        k kVar = this.bdh;
        if (kVar != null) {
            kVar.E(view);
        }
    }

    public void setRadius(float f) {
        this.mViewRCHelper.setRadius(f);
        postInvalidate();
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.mRatio != 0.0f) {
            i2 = View.MeasureSpec.makeMeasureSpec((int) (View.MeasureSpec.getSize(i) * this.mRatio), 1073741824);
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
        return super.dispatchTouchEvent(motionEvent);
    }

    public aj.a getTouchCoords() {
        return this.aLL;
    }
}
