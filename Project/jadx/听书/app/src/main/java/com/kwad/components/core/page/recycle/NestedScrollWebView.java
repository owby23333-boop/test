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

/* JADX INFO: loaded from: classes4.dex */
public class NestedScrollWebView extends KsAdWebView implements NestedScrollingChild {
    private int UP;
    private int UQ;
    private final int[] UR;
    private final int[] US;
    private int UT;
    private boolean UU;
    private int UV;
    private int UW;
    private NestedScrollingChildHelper UX;
    private VelocityTracker UY;
    private int UZ;

    public NestedScrollWebView(Context context) {
        super(context);
        this.UR = new int[2];
        this.US = new int[2];
        rF();
    }

    public NestedScrollWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.UR = new int[2];
        this.US = new int[2];
        rF();
    }

    public NestedScrollWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.UR = new int[2];
        this.US = new int[2];
        rF();
    }

    private void rF() {
        this.UZ = 0;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.UX = new NestedScrollingChildHelper(this);
        setNestedScrollingEnabled(true);
        this.UW = viewConfiguration.getScaledMaximumFlingVelocity();
        this.UV = viewConfiguration.getScaledMinimumFlingVelocity();
    }

    @Override // android.webkit.WebView, android.widget.AbsoluteLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int screenHeight;
        if (this.UZ != 0) {
            int statusBarHeight = com.kwad.components.core.t.d.tc() ? com.kwad.sdk.c.a.a.getStatusBarHeight(getContext()) : 0;
            if (getContext() instanceof Activity) {
                screenHeight = com.kwad.sdk.c.a.a.g((Activity) getContext());
            } else {
                screenHeight = com.kwad.sdk.c.a.a.getScreenHeight(getContext());
            }
            i2 = View.MeasureSpec.makeMeasureSpec((screenHeight - statusBarHeight) - this.UZ, 1073741824);
        }
        super.onMeasure(i, i2);
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00e0  */
    @Override // com.kwad.sdk.core.webview.KsAdWebView, android.webkit.WebView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r21) {
        /*
            Method dump skipped, instruction units count: 353
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.core.page.recycle.NestedScrollWebView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // com.kwad.sdk.core.webview.KsAdWebView, android.webkit.WebView, android.view.View
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (hasFocus()) {
            return;
        }
        requestFocus();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean z) {
        this.UX.setNestedScrollingEnabled(z);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean isNestedScrollingEnabled() {
        return this.UX.isNestedScrollingEnabled();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean startNestedScroll(int i) {
        return this.UX.startNestedScroll(i);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void stopNestedScroll() {
        this.UX.stopNestedScroll();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean hasNestedScrollingParent() {
        return this.UX.hasNestedScrollingParent();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return this.UX.dispatchNestedScroll(i, i2, i3, i4, iArr);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return this.UX.dispatchNestedPreScroll(i, i2, iArr, iArr2);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.UX.dispatchNestedFling(f, f2, z);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.UX.dispatchNestedPreFling(f, f2);
    }
}
