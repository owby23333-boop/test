package com.duokan.reader.ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.RequiresApi;
import java.util.Collection;
import miuix.animation.Folme;
import miuix.animation.base.AnimConfig;
import miuix.animation.listener.TransitionListener;
import miuix.animation.listener.UpdateInfo;
import miuix.nestedheader.R;
import miuix.nestedheader.widget.NestedScrollingLayout;

/* JADX INFO: loaded from: classes5.dex */
public class DkNestedHeaderLayout extends NestedScrollingLayout {
    public static final String t = "NestedHeaderLayout";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f6606a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f6607b;
    public float c;
    public View d;
    public View e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public boolean o;
    public boolean p;
    public boolean q;
    public c r;
    public NestedScrollingLayout.OnNestedChangedListener s;

    public class a implements NestedScrollingLayout.OnNestedChangedListener {
        public a() {
        }

        @Override // miuix.nestedheader.widget.NestedScrollingLayout.OnNestedChangedListener
        public void onStartNestedScroll(int i) {
            if (i == 0) {
                DkNestedHeaderLayout.this.p = true;
            }
        }

        @Override // miuix.nestedheader.widget.NestedScrollingLayout.OnNestedChangedListener
        public void onStopNestedScroll(int i) {
            if (i == 0) {
                DkNestedHeaderLayout.this.p = false;
            }
        }

        @Override // miuix.nestedheader.widget.NestedScrollingLayout.OnNestedChangedListener
        public void onStopNestedScrollAccepted(int i) {
            if (!DkNestedHeaderLayout.this.q || DkNestedHeaderLayout.this.o || DkNestedHeaderLayout.this.getScrollingProgress() == 0 || DkNestedHeaderLayout.this.getScrollingProgress() >= DkNestedHeaderLayout.this.g || DkNestedHeaderLayout.this.getScrollingProgress() <= DkNestedHeaderLayout.this.f) {
                return;
            }
            DkNestedHeaderLayout.this.autoAdsorption((DkNestedHeaderLayout.this.getScrollingProgress() <= DkNestedHeaderLayout.this.f || ((float) DkNestedHeaderLayout.this.getScrollingProgress()) >= ((float) DkNestedHeaderLayout.this.f) * 0.5f) ? ((((float) DkNestedHeaderLayout.this.getScrollingProgress()) < ((float) DkNestedHeaderLayout.this.f) * 0.5f || DkNestedHeaderLayout.this.getScrollingProgress() >= 0) && (DkNestedHeaderLayout.this.getScrollingProgress() <= 0 || ((float) DkNestedHeaderLayout.this.getScrollingProgress()) >= ((float) DkNestedHeaderLayout.this.g) * 0.5f) && ((float) DkNestedHeaderLayout.this.getScrollingProgress()) >= ((float) DkNestedHeaderLayout.this.g) * 0.5f && DkNestedHeaderLayout.this.getScrollingProgress() < DkNestedHeaderLayout.this.g) ? DkNestedHeaderLayout.this.g : 0 : DkNestedHeaderLayout.this.f);
        }
    }

    public class b extends TransitionListener {
        public b() {
        }

        @Override // miuix.animation.listener.TransitionListener
        public void onComplete(Object obj) {
            DkNestedHeaderLayout.this.o = false;
        }

        @Override // miuix.animation.listener.TransitionListener
        public void onUpdate(Object obj, Collection<UpdateInfo> collection) {
            UpdateInfo updateInfoFindByName = UpdateInfo.findByName(collection, "targe");
            if (updateInfoFindByName == null || DkNestedHeaderLayout.this.p) {
                return;
            }
            DkNestedHeaderLayout.this.syncScrollingProgress(updateInfoFindByName.getIntValue());
        }
    }

    public interface c {
        void a(int i);

        void onHeaderClosed(View view);

        void onHeaderOpened(View view);

        void onTriggerClosed(View view);

        void onTriggerOpened(View view);
    }

    public DkNestedHeaderLayout(Context context) {
        this(context, null);
    }

    public final void autoAdsorption(int i) {
        Folme.useValue(new Object[0]).setTo("targe", Integer.valueOf(getScrollingProgress())).to("targe", Integer.valueOf(i), new AnimConfig().addListeners(new b()));
    }

    public final void checkSendHeaderChangeListener(int i, int i2, boolean z) {
        if (this.r != null) {
            if (z) {
                if (i2 == 0 && getHeaderViewVisible()) {
                    this.r.onHeaderOpened(this.d);
                } else if (i2 == this.g && getTriggerViewVisible()) {
                    this.r.onTriggerOpened(this.e);
                }
                if (i >= 0 || i2 <= 0 || !getHeaderViewVisible()) {
                    return;
                }
                this.r.onHeaderOpened(this.d);
                return;
            }
            if (i2 == 0 && getTriggerViewVisible()) {
                this.r.onTriggerClosed(this.e);
            } else if (i2 == this.f && getHeaderViewVisible()) {
                this.r.onHeaderClosed(this.d);
            } else if (i2 == this.f && !getHeaderViewVisible()) {
                this.r.onTriggerClosed(this.e);
            }
            int i3 = getHeaderViewVisible() ? 0 : this.f;
            if (i <= i3 || i2 >= i3 || !getTriggerViewVisible()) {
                return;
            }
            this.r.onTriggerClosed(this.e);
        }
    }

    public boolean getHeaderViewVisible() {
        View view = this.d;
        return view != null && view.getVisibility() == 0;
    }

    public boolean getTriggerViewVisible() {
        View view = this.e;
        return view != null && view.getVisibility() == 0;
    }

    public boolean isAutoAnim() {
        return this.q;
    }

    public boolean isHeaderOpen() {
        return getHeaderViewVisible() && getScrollingProgress() >= 0;
    }

    public boolean isTriggerOpen() {
        return getTriggerViewVisible() && ((getHeaderViewVisible() && getScrollingProgress() >= this.g) || (!getHeaderViewVisible() && getScrollingProgress() >= 0));
    }

    @Override // miuix.nestedheader.widget.NestedScrollingLayout, android.view.View
    @RequiresApi(api = 21)
    public void onFinishInflate() {
        super.onFinishInflate();
        this.d = findViewById(this.f6606a);
        View viewFindViewById = findViewById(this.f6607b);
        this.e = viewFindViewById;
        if (this.d == null && viewFindViewById == null) {
            throw new IllegalArgumentException("The headerView or triggerView attribute is required and must refer to a valid child.");
        }
    }

    @Override // miuix.nestedheader.widget.NestedScrollingLayout, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        updateScrollingRange(true, false, false);
    }

    @Override // miuix.nestedheader.widget.NestedScrollingLayout
    public void onScrollingProgressUpdated(int i) {
        int iMax;
        int i2;
        super.onScrollingProgressUpdated(i);
        c cVar = this.r;
        if (cVar != null) {
            cVar.a(i);
        }
        View view = this.e;
        if (view == null || view.getVisibility() == 8) {
            iMax = i;
            i2 = 0;
        } else {
            iMax = i - Math.max(0, Math.min(this.g, i));
            int iMax2 = Math.max(this.f, Math.min(this.g, i));
            int i3 = this.k;
            View view2 = this.d;
            if (view2 == null || view2.getVisibility() == 8) {
                i2 = this.k + this.j + this.m;
            } else {
                i3 += ((((this.i + this.h) - this.k) - this.j) + this.l) - this.m;
                i2 = 0;
            }
            View view3 = this.e;
            view3.offsetTopAndBottom((iMax2 + i3) - view3.getTop());
        }
        View view4 = this.d;
        if (view4 != null && view4.getVisibility() != 8) {
            View view5 = this.d;
            view5.offsetTopAndBottom((iMax + this.i) - view5.getTop());
            i2 = this.l + this.i + this.h;
        }
        View view6 = this.mScrollableView;
        view6.offsetTopAndBottom((i2 + i) - view6.getTop());
        int i4 = this.n;
        if (i - i4 > 0) {
            checkSendHeaderChangeListener(i4, i, true);
        } else if (i - i4 < 0) {
            checkSendHeaderChangeListener(i4, i, false);
        }
        this.n = i;
    }

    public void removeNestedHeaderChangedListener() {
        this.r = null;
    }

    public void setAutoAllClose(boolean z) {
        if (z) {
            int scrollingProgress = getScrollingProgress();
            int i = this.f;
            if (scrollingProgress > i) {
                autoAdsorption(i);
                return;
            }
        }
        syncScrollingProgress(this.f);
    }

    public void setAutoAllOpen(boolean z) {
        if (z) {
            int scrollingProgress = getScrollingProgress();
            int i = this.g;
            if (scrollingProgress < i) {
                autoAdsorption(i);
                return;
            }
        }
        syncScrollingProgress(this.g);
    }

    public void setAutoAnim(boolean z) {
        this.q = z;
    }

    public void setAutoHeaderClose(boolean z) {
        if (getHeaderViewVisible()) {
            int scrollingProgress = getScrollingProgress();
            int i = this.f;
            if (scrollingProgress > i) {
                if (z) {
                    autoAdsorption(i);
                } else if (getHeaderViewVisible()) {
                    syncScrollingProgress(this.f);
                }
            }
        }
    }

    public void setAutoHeaderOpen(boolean z) {
        if (!getHeaderViewVisible() || getScrollingProgress() >= 0) {
            return;
        }
        if (z) {
            autoAdsorption(0);
        } else {
            syncScrollingProgress(0);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setAutoTriggerClose(boolean r4) {
        /*
            r3 = this;
            boolean r0 = r3.getTriggerViewVisible()
            r1 = -1
            if (r0 == 0) goto L15
            boolean r0 = r3.getHeaderViewVisible()
            if (r0 == 0) goto L15
            int r0 = r3.getScrollingProgress()
            if (r0 <= 0) goto L15
            r0 = 0
            goto L2c
        L15:
            boolean r0 = r3.getTriggerViewVisible()
            if (r0 == 0) goto L2b
            boolean r0 = r3.getHeaderViewVisible()
            if (r0 != 0) goto L2b
            int r0 = r3.getScrollingProgress()
            int r2 = r3.f
            if (r0 <= r2) goto L2b
            r0 = r2
            goto L2c
        L2b:
            r0 = r1
        L2c:
            if (r0 == r1) goto L34
            if (r4 == 0) goto L34
            r3.autoAdsorption(r0)
            goto L39
        L34:
            if (r0 == r1) goto L39
            r3.syncScrollingProgress(r0)
        L39:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.duokan.reader.ui.view.DkNestedHeaderLayout.setAutoTriggerClose(boolean):void");
    }

    public void setAutoTriggerOpen(boolean z) {
        if (getTriggerViewVisible()) {
            int scrollingProgress = getScrollingProgress();
            int i = this.g;
            if (scrollingProgress < i) {
                if (z) {
                    autoAdsorption(i);
                } else {
                    syncScrollingProgress(i);
                }
            }
        }
    }

    public void setHeaderViewVisible(boolean z) {
        View view = this.d;
        if (view != null) {
            view.setVisibility(z ? 0 : 8);
            updateScrollingRange(false, false, z);
        }
    }

    public void setNestedHeaderChangedListener(c cVar) {
        this.r = cVar;
    }

    public void setTriggerViewVisible(boolean z) {
        View view = this.e;
        if (view != null) {
            view.setVisibility(z ? 0 : 8);
            updateScrollingRange(false, z, false);
        }
    }

    public final void syncScrollingProgress(int i) {
        updateScrollingProgress(i);
        onScrollingProgressUpdated(i);
    }

    public final void updateScrollingRange(boolean z, boolean z2, boolean z3) {
        int i;
        boolean z4;
        int i2;
        int i3;
        boolean z5;
        View view = this.d;
        if (view == null || view.getVisibility() == 8) {
            i = 0;
            z4 = false;
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.d.getLayoutParams();
            this.h = marginLayoutParams.bottomMargin;
            this.i = marginLayoutParams.topMargin;
            this.l = this.d.getMeasuredHeight();
            i = ((int) ((((-r0) + this.c) - this.i) - this.h)) + 0;
            z4 = true;
        }
        View view2 = this.e;
        if (view2 == null || view2.getVisibility() == 8) {
            i2 = i;
            i3 = 0;
            z5 = false;
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.e.getLayoutParams();
            this.j = marginLayoutParams2.bottomMargin;
            this.k = marginLayoutParams2.topMargin;
            int measuredHeight = this.e.getMeasuredHeight();
            this.m = measuredHeight;
            int i4 = measuredHeight + this.k + this.j + 0;
            if (z4) {
                i2 = i;
                z5 = true;
                i3 = i4;
            } else {
                i2 = -i4;
                z5 = true;
                i3 = 0;
            }
        }
        this.f = i2;
        this.g = i3;
        setScrollingRange(i2, i3, z4, z5, z, z2, z3);
    }

    public DkNestedHeaderLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DkNestedHeaderLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.h = 0;
        this.i = 0;
        this.j = 0;
        this.k = 0;
        this.l = 0;
        this.m = 0;
        this.n = 0;
        this.o = false;
        this.p = false;
        this.q = true;
        this.s = new a();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.NestedHeaderLayout);
        this.f6606a = typedArrayObtainStyledAttributes.getResourceId(R.styleable.NestedHeaderLayout_headerView, R.id.header_view);
        this.f6607b = typedArrayObtainStyledAttributes.getResourceId(R.styleable.NestedHeaderLayout_triggerView, R.id.trigger_view);
        this.c = typedArrayObtainStyledAttributes.getDimension(R.styleable.NestedHeaderLayout_rangeOffset, 0.0f);
        typedArrayObtainStyledAttributes.recycle();
        addOnScrollListener(this.s);
    }
}
