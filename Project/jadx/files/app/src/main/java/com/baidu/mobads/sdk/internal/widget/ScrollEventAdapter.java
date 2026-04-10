package com.baidu.mobads.sdk.internal.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.mobads.sdk.internal.widget.ViewPager2;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
final class ScrollEventAdapter extends RecyclerView.OnScrollListener {
    private static final int a = 0;
    private static final int b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f13211c = 2;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f13212d = 3;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f13213e = 4;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f13214f = -1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ViewPager2.OnPageChangeCallback f13215g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    private final ViewPager2 f13216h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    private final RecyclerView f13217i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NonNull
    private final LinearLayoutManager f13218j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f13219k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f13220l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private ScrollEventValues f13221m = new ScrollEventValues();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f13222n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f13223o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f13224p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f13225q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f13226r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f13227s;

    /* JADX INFO: loaded from: classes.dex */
    @Retention(RetentionPolicy.SOURCE)
    private @interface AdapterState {
    }

    private static final class ScrollEventValues {
        int a;
        float b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f13228c;

        ScrollEventValues() {
        }

        void a() {
            this.a = -1;
            this.b = 0.0f;
            this.f13228c = 0;
        }
    }

    ScrollEventAdapter(@NonNull ViewPager2 viewPager2) {
        this.f13216h = viewPager2;
        this.f13217i = this.f13216h.f13236j;
        this.f13218j = (LinearLayoutManager) this.f13217i.getLayoutManager();
        i();
    }

    private void a(boolean z2) {
        this.f13227s = z2;
        this.f13219k = z2 ? 4 : 1;
        int i2 = this.f13223o;
        if (i2 != -1) {
            this.f13222n = i2;
            this.f13223o = -1;
        } else if (this.f13222n == -1) {
            this.f13222n = l();
        }
        a(1);
    }

    private void i() {
        this.f13219k = 0;
        this.f13220l = 0;
        this.f13221m.a();
        this.f13222n = -1;
        this.f13223o = -1;
        this.f13224p = false;
        this.f13225q = false;
        this.f13227s = false;
        this.f13226r = false;
    }

    private void j() {
        int top;
        ScrollEventValues scrollEventValues = this.f13221m;
        scrollEventValues.a = this.f13218j.findFirstVisibleItemPosition();
        int i2 = scrollEventValues.a;
        if (i2 == -1) {
            scrollEventValues.a();
            return;
        }
        View viewFindViewByPosition = this.f13218j.findViewByPosition(i2);
        if (viewFindViewByPosition == null) {
            scrollEventValues.a();
            return;
        }
        int leftDecorationWidth = this.f13218j.getLeftDecorationWidth(viewFindViewByPosition);
        int rightDecorationWidth = this.f13218j.getRightDecorationWidth(viewFindViewByPosition);
        int topDecorationHeight = this.f13218j.getTopDecorationHeight(viewFindViewByPosition);
        int bottomDecorationHeight = this.f13218j.getBottomDecorationHeight(viewFindViewByPosition);
        ViewGroup.LayoutParams layoutParams = viewFindViewByPosition.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            leftDecorationWidth += marginLayoutParams.leftMargin;
            rightDecorationWidth += marginLayoutParams.rightMargin;
            topDecorationHeight += marginLayoutParams.topMargin;
            bottomDecorationHeight += marginLayoutParams.bottomMargin;
        }
        int height = viewFindViewByPosition.getHeight() + topDecorationHeight + bottomDecorationHeight;
        int width = rightDecorationWidth + viewFindViewByPosition.getWidth() + leftDecorationWidth;
        if (this.f13218j.getOrientation() == 0) {
            top = (viewFindViewByPosition.getLeft() - leftDecorationWidth) - this.f13217i.getPaddingLeft();
            if (this.f13216h.c()) {
                top = -top;
            }
        } else {
            top = (viewFindViewByPosition.getTop() - topDecorationHeight) - this.f13217i.getPaddingTop();
            width = height;
        }
        scrollEventValues.f13228c = -top;
        int i3 = scrollEventValues.f13228c;
        if (i3 >= 0) {
            scrollEventValues.b = width == 0 ? 0.0f : i3 / width;
        } else {
            if (!new AnimateLayoutChangeDetector(this.f13218j).a()) {
                throw new IllegalStateException(String.format(Locale.US, "Page can only be offset by a positive amount, not by %d", Integer.valueOf(scrollEventValues.f13228c)));
            }
            throw new IllegalStateException("Page(s) contain a ViewGroup with a LayoutTransition (or animateLayoutChanges=\"true\"), which interferes with the scrolling animation. Make sure to call getLayoutTransition().setAnimateParentHierarchy(false) on all ViewGroups with a LayoutTransition before an animation is started.");
        }
    }

    private boolean k() {
        int i2 = this.f13219k;
        return i2 == 1 || i2 == 4;
    }

    private int l() {
        return this.f13218j.findFirstVisibleItemPosition();
    }

    void b() {
        this.f13219k = 4;
        a(true);
    }

    void c() {
        if (!f() || this.f13227s) {
            this.f13227s = false;
            j();
            ScrollEventValues scrollEventValues = this.f13221m;
            if (scrollEventValues.f13228c != 0) {
                a(2);
                return;
            }
            int i2 = scrollEventValues.a;
            if (i2 != this.f13222n) {
                b(i2);
            }
            a(0);
            i();
        }
    }

    int d() {
        return this.f13220l;
    }

    boolean e() {
        return this.f13220l == 0;
    }

    boolean f() {
        return this.f13220l == 1;
    }

    boolean g() {
        return this.f13227s;
    }

    double h() {
        j();
        ScrollEventValues scrollEventValues = this.f13221m;
        double d2 = scrollEventValues.a;
        double d3 = scrollEventValues.b;
        Double.isNaN(d2);
        Double.isNaN(d3);
        return d2 + d3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i2) {
        boolean z2 = true;
        if (!(this.f13219k == 1 && this.f13220l == 1) && i2 == 1) {
            a(false);
            return;
        }
        if (k() && i2 == 2) {
            if (this.f13225q) {
                a(2);
                this.f13224p = true;
                return;
            }
            return;
        }
        if (k() && i2 == 0) {
            j();
            if (this.f13225q) {
                ScrollEventValues scrollEventValues = this.f13221m;
                if (scrollEventValues.f13228c == 0) {
                    int i3 = this.f13222n;
                    int i4 = scrollEventValues.a;
                    if (i3 != i4) {
                        b(i4);
                    }
                } else {
                    z2 = false;
                }
            } else {
                int i5 = this.f13221m.a;
                if (i5 != -1) {
                    a(i5, 0.0f, 0);
                }
            }
            if (z2) {
                a(0);
                i();
            }
        }
        if (this.f13219k == 2 && i2 == 0 && this.f13226r) {
            j();
            ScrollEventValues scrollEventValues2 = this.f13221m;
            if (scrollEventValues2.f13228c == 0) {
                int i6 = this.f13223o;
                int i7 = scrollEventValues2.a;
                if (i6 != i7) {
                    if (i7 == -1) {
                        i7 = 0;
                    }
                    b(i7);
                }
                a(0);
                i();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0022  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x002f  */
    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onScrolled(@androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView r4, int r5, int r6) {
        /*
            r3 = this;
            r4 = 1
            r3.f13225q = r4
            r3.j()
            boolean r0 = r3.f13224p
            r1 = -1
            r2 = 0
            if (r0 == 0) goto L3f
            r3.f13224p = r2
            if (r6 > 0) goto L22
            if (r6 != 0) goto L20
            if (r5 >= 0) goto L16
            r5 = 1
            goto L17
        L16:
            r5 = 0
        L17:
            com.baidu.mobads.sdk.internal.widget.ViewPager2 r6 = r3.f13216h
            boolean r6 = r6.c()
            if (r5 != r6) goto L20
            goto L22
        L20:
            r5 = 0
            goto L23
        L22:
            r5 = 1
        L23:
            if (r5 == 0) goto L2f
            com.baidu.mobads.sdk.internal.widget.ScrollEventAdapter$ScrollEventValues r5 = r3.f13221m
            int r6 = r5.f13228c
            if (r6 == 0) goto L2f
            int r5 = r5.a
            int r5 = r5 + r4
            goto L33
        L2f:
            com.baidu.mobads.sdk.internal.widget.ScrollEventAdapter$ScrollEventValues r5 = r3.f13221m
            int r5 = r5.a
        L33:
            r3.f13223o = r5
            int r5 = r3.f13222n
            int r6 = r3.f13223o
            if (r5 == r6) goto L4d
            r3.b(r6)
            goto L4d
        L3f:
            int r5 = r3.f13219k
            if (r5 != 0) goto L4d
            com.baidu.mobads.sdk.internal.widget.ScrollEventAdapter$ScrollEventValues r5 = r3.f13221m
            int r5 = r5.a
            if (r5 != r1) goto L4a
            r5 = 0
        L4a:
            r3.b(r5)
        L4d:
            com.baidu.mobads.sdk.internal.widget.ScrollEventAdapter$ScrollEventValues r5 = r3.f13221m
            int r5 = r5.a
            if (r5 != r1) goto L54
            r5 = 0
        L54:
            com.baidu.mobads.sdk.internal.widget.ScrollEventAdapter$ScrollEventValues r6 = r3.f13221m
            float r0 = r6.b
            int r6 = r6.f13228c
            r3.a(r5, r0, r6)
            com.baidu.mobads.sdk.internal.widget.ScrollEventAdapter$ScrollEventValues r5 = r3.f13221m
            int r5 = r5.a
            int r6 = r3.f13223o
            if (r5 == r6) goto L67
            if (r6 != r1) goto L77
        L67:
            com.baidu.mobads.sdk.internal.widget.ScrollEventAdapter$ScrollEventValues r5 = r3.f13221m
            int r5 = r5.f13228c
            if (r5 != 0) goto L77
            int r5 = r3.f13220l
            if (r5 == r4) goto L77
            r3.a(r2)
            r3.i()
        L77:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.sdk.internal.widget.ScrollEventAdapter.onScrolled(androidx.recyclerview.widget.RecyclerView, int, int):void");
    }

    private void b(int i2) {
        ViewPager2.OnPageChangeCallback onPageChangeCallback = this.f13215g;
        if (onPageChangeCallback != null) {
            onPageChangeCallback.onPageSelected(i2);
        }
    }

    void a() {
        this.f13226r = true;
    }

    void a(int i2, boolean z2) {
        this.f13219k = z2 ? 2 : 3;
        this.f13227s = false;
        boolean z3 = this.f13223o != i2;
        this.f13223o = i2;
        a(2);
        if (z3) {
            b(i2);
        }
    }

    void a(ViewPager2.OnPageChangeCallback onPageChangeCallback) {
        this.f13215g = onPageChangeCallback;
    }

    private void a(int i2) {
        if ((this.f13219k == 3 && this.f13220l == 0) || this.f13220l == i2) {
            return;
        }
        this.f13220l = i2;
        ViewPager2.OnPageChangeCallback onPageChangeCallback = this.f13215g;
        if (onPageChangeCallback != null) {
            onPageChangeCallback.onPageScrollStateChanged(i2);
        }
    }

    private void a(int i2, float f2, int i3) {
        ViewPager2.OnPageChangeCallback onPageChangeCallback = this.f13215g;
        if (onPageChangeCallback != null) {
            onPageChangeCallback.onPageScrolled(i2, f2, i3);
        }
    }
}
