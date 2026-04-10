package com.kwad.components.core.page.recycle;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingChildHelper;
import com.kwad.sdk.core.webview.KsAdWebView;

/* JADX INFO: loaded from: classes3.dex */
public class NestedScrollWebView extends KsAdWebView implements NestedScrollingChild {
    private int MJ;
    private int MK;
    private final int[] ML;
    private final int[] MM;
    private int MN;
    private boolean MO;
    private int MP;
    private int MQ;
    private NestedScrollingChildHelper MR;
    private VelocityTracker MS;
    private int MT;

    public NestedScrollWebView(Context context) {
        super(context);
        this.ML = new int[2];
        this.MM = new int[2];
        pc();
    }

    public NestedScrollWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ML = new int[2];
        this.MM = new int[2];
        pc();
    }

    public NestedScrollWebView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.ML = new int[2];
        this.MM = new int[2];
        pc();
    }

    private void pc() {
        this.MT = 0;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.MR = new NestedScrollingChildHelper(this);
        setNestedScrollingEnabled(true);
        this.MQ = viewConfiguration.getScaledMaximumFlingVelocity();
        this.MP = viewConfiguration.getScaledMinimumFlingVelocity();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedFling(float f2, float f3, boolean z2) {
        return this.MR.dispatchNestedFling(f2, f3, z2);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreFling(float f2, float f3) {
        return this.MR.dispatchNestedPreFling(f2, f3);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2) {
        return this.MR.dispatchNestedPreScroll(i2, i3, iArr, iArr2);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr) {
        return this.MR.dispatchNestedScroll(i2, i3, i4, i5, iArr);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean hasNestedScrollingParent() {
        return this.MR.hasNestedScrollingParent();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean isNestedScrollingEnabled() {
        return this.MR.isNestedScrollingEnabled();
    }

    @Override // android.webkit.WebView, android.widget.AbsoluteLayout, android.view.View
    protected void onMeasure(int i2, int i3) {
        if (this.MT != 0) {
            i3 = View.MeasureSpec.makeMeasureSpec(((getContext() instanceof Activity ? com.kwad.sdk.b.kwai.a.d((Activity) getContext()) : com.kwad.sdk.b.kwai.a.getScreenHeight(getContext())) - (com.kwad.components.core.r.e.qe() ? com.kwad.sdk.b.kwai.a.getStatusBarHeight(getContext()) : 0)) - this.MT, 1073741824);
        }
        super.onMeasure(i2, i3);
    }

    @Override // com.kwad.sdk.core.webview.KsAdWebView, android.webkit.WebView, android.view.View
    public void onScrollChanged(int i2, int i3, int i4, int i5) {
        super.onScrollChanged(i2, i3, i4, i5);
        if (hasFocus()) {
            return;
        }
        requestFocus();
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00e2  */
    @Override // android.webkit.WebView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r21) {
        /*
            Method dump skipped, instruction units count: 355
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.core.page.recycle.NestedScrollWebView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean z2) {
        this.MR.setNestedScrollingEnabled(z2);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean startNestedScroll(int i2) {
        return this.MR.startNestedScroll(i2);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void stopNestedScroll() {
        this.MR.stopNestedScroll();
    }
}
