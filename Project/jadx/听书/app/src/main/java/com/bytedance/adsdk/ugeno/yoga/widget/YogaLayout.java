package com.bytedance.adsdk.ugeno.yoga.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.adsdk.ugeno.dl;
import com.bytedance.adsdk.ugeno.yoga.a;
import com.bytedance.adsdk.ugeno.yoga.fo;
import com.bytedance.adsdk.ugeno.yoga.gc;
import com.bytedance.adsdk.ugeno.yoga.i;
import com.bytedance.adsdk.ugeno.yoga.kb;
import com.bytedance.adsdk.ugeno.yoga.m;
import com.bytedance.adsdk.ugeno.yoga.uy;
import com.bytedance.adsdk.ugeno.yoga.v;
import com.bytedance.adsdk.ugeno.z.e;
import com.bytedance.adsdk.ugeno.z.gz;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class YogaLayout extends ViewGroup implements com.bytedance.adsdk.ugeno.g.g, e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private gz f266a;
    private dl dl;
    private final uy g;
    private final Map<View, uy> z;

    public YogaLayout(Context context) {
        this(context, null, 0);
    }

    public YogaLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f266a = new gz(this);
        uy uyVarZ = kb.z();
        this.g = uyVarZ;
        this.z = new HashMap();
        uyVarZ.z(this);
        uyVarZ.z((com.bytedance.adsdk.ugeno.yoga.e) new g());
        z((z) generateDefaultLayoutParams(), uyVarZ, this);
    }

    public uy getYogaNode() {
        return this.g;
    }

    public uy z(View view) {
        return this.z.get(view);
    }

    @Override // com.bytedance.adsdk.ugeno.g.g
    public void z(int i) {
        uy uyVar = this.g;
        if (uyVar != null) {
            z(uyVar, i);
            requestLayout();
        }
    }

    @Override // com.bytedance.adsdk.ugeno.g.g
    public void g(int i) {
        uy uyVar = this.g;
        if (uyVar != null) {
            g(uyVar, i);
            requestLayout();
        }
    }

    @Override // com.bytedance.adsdk.ugeno.g.g
    public void z(View view, int i) {
        uy uyVarZ;
        if (view == null || (uyVarZ = z(view)) == null) {
            return;
        }
        z(uyVarZ, i);
        view.requestLayout();
    }

    @Override // com.bytedance.adsdk.ugeno.g.g
    public void g(View view, int i) {
        uy uyVarZ;
        if (view == null || (uyVarZ = z(view)) == null) {
            return;
        }
        g(uyVarZ, i);
        view.requestLayout();
    }

    private void z(uy uyVar, int i) {
        if (i == -1) {
            uyVar.gc(100.0f);
        } else if (i == -2) {
            uyVar.a();
        } else {
            uyVar.a(i);
        }
    }

    private void g(uy uyVar, int i) {
        if (i == -1) {
            uyVar.e(100.0f);
        } else if (i == -2) {
            uyVar.gc();
        } else {
            uyVar.m(i);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.g.g
    public void dl(View view, int i) {
        a(view, i);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        uy uyVarZ;
        this.g.z((com.bytedance.adsdk.ugeno.yoga.e) null);
        if (view instanceof VirtualYogaLayout) {
            VirtualYogaLayout virtualYogaLayout = (VirtualYogaLayout) view;
            virtualYogaLayout.z(this);
            uy yogaNode = virtualYogaLayout.getYogaNode();
            uy uyVar = this.g;
            uyVar.z(yogaNode, uyVar.z());
            return;
        }
        super.addView(view, i, layoutParams);
        if (this.z.containsKey(view)) {
            return;
        }
        if (view instanceof YogaLayout) {
            uyVarZ = ((YogaLayout) view).getYogaNode();
        } else {
            if (this.z.containsKey(view)) {
                uyVarZ = this.z.get(view);
            } else {
                uyVarZ = kb.z();
            }
            uyVarZ.z(view);
            uyVarZ.z((com.bytedance.adsdk.ugeno.yoga.e) new g());
        }
        z((z) view.getLayoutParams(), uyVarZ, view);
        this.z.put(view, uyVarZ);
        if (view.getVisibility() == 8) {
            view.setTag(151060224, Integer.valueOf(this.g.z()));
        } else {
            uy uyVar2 = this.g;
            uyVar2.z(uyVarZ, uyVar2.z());
        }
    }

    public void a(View view, int i) {
        int iZ;
        view.setVisibility(i);
        try {
            uy uyVar = this.z.get(view);
            Object tag = view.getTag(151060224);
            if (i != 0) {
                if (i != 8 || (iZ = this.g.z(uyVar)) == -1) {
                    return;
                }
                this.g.g(iZ);
                view.setTag(151060224, Integer.valueOf(iZ));
                z(this.g);
                return;
            }
            if (tag == null || this.g.z(uyVar) != -1) {
                return;
            }
            int iIntValue = ((Integer) tag).intValue();
            if (iIntValue < this.g.z()) {
                this.g.z(this.z.get(view), iIntValue);
            } else {
                this.g.z(this.z.get(view), this.g.z());
            }
            z(this.g);
        } catch (Throwable unused) {
        }
    }

    private void z(uy uyVar) {
        if (uyVar.g() != null) {
            z(uyVar.g());
        } else {
            uyVar.z(Float.NaN, Float.NaN);
        }
    }

    public void z(View view, uy uyVar) {
        this.z.put(view, uyVar);
        addView(view);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        z(view, false);
        super.removeView(view);
    }

    @Override // android.view.ViewGroup
    public void removeViewAt(int i) {
        z(getChildAt(i), false);
        super.removeViewAt(i);
    }

    @Override // android.view.ViewGroup
    public void removeViewInLayout(View view) {
        z(view, true);
        super.removeViewInLayout(view);
    }

    @Override // android.view.ViewGroup
    public void removeViews(int i, int i2) {
        for (int i3 = i; i3 < i + i2; i3++) {
            z(getChildAt(i3), false);
        }
        super.removeViews(i, i2);
    }

    @Override // android.view.ViewGroup
    public void removeViewsInLayout(int i, int i2) {
        for (int i3 = i; i3 < i + i2; i3++) {
            z(getChildAt(i3), true);
        }
        super.removeViewsInLayout(i, i2);
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            z(getChildAt(i), false);
        }
        super.removeAllViews();
    }

    @Override // android.view.ViewGroup
    public void removeAllViewsInLayout() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            z(getChildAt(i), true);
        }
        super.removeAllViewsInLayout();
    }

    private void z(View view, boolean z2) {
        uy uyVar = this.z.get(view);
        if (uyVar == null) {
            return;
        }
        uy uyVarG = uyVar.g();
        int i = 0;
        while (true) {
            if (i >= uyVarG.z()) {
                break;
            }
            if (uyVarG.z(i).equals(uyVar)) {
                uyVarG.g(i);
                break;
            }
            i++;
        }
        uyVar.z((Object) null);
        this.z.remove(view);
        if (z2) {
            this.g.z(Float.NaN, Float.NaN);
        }
    }

    private void z(uy uyVar, float f, float f2) {
        View view = (View) uyVar.uy();
        if (view != null && view != this) {
            if (view.getVisibility() == 8) {
                return;
            }
            int iRound = Math.round(uyVar.m() + f);
            int iRound2 = Math.round(uyVar.e() + f2);
            view.measure(View.MeasureSpec.makeMeasureSpec(Math.round(uyVar.gz()), 1073741824), View.MeasureSpec.makeMeasureSpec(Math.round(uyVar.fo()), 1073741824));
            view.layout(iRound, iRound2, view.getMeasuredWidth() + iRound, view.getMeasuredHeight() + iRound2);
        }
        int iZ = uyVar.z();
        for (int i = 0; i < iZ; i++) {
            if (equals(view)) {
                z(uyVar.z(i), f, f2);
            } else if (!(view instanceof YogaLayout)) {
                z(uyVar.z(i), uyVar.m() + f, uyVar.e() + f2);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        dl dlVar = this.dl;
        if (dlVar != null) {
            dlVar.z(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z2, int i, int i2, int i3, int i4) {
        dl dlVar = this.dl;
        if (dlVar != null) {
            dlVar.a();
        }
        if (!(getParent() instanceof YogaLayout)) {
            z(View.MeasureSpec.makeMeasureSpec(i3 - i, 1073741824), View.MeasureSpec.makeMeasureSpec(i4 - i2, 1073741824));
        }
        z(this.g, 0.0f, 0.0f);
        dl dlVar2 = this.dl;
        if (dlVar2 != null) {
            dlVar2.z(i, i2, i3, i4);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        if (!(getParent() instanceof YogaLayout)) {
            z(i, i2);
        }
        dl dlVar = this.dl;
        if (dlVar != null) {
            int[] iArrZ = dlVar.z(i, i2);
            setMeasuredDimension(iArrZ[0], iArrZ[1]);
        } else {
            setMeasuredDimension(Math.round(this.g.gz()), Math.round(this.g.fo()));
        }
        dl dlVar2 = this.dl;
        if (dlVar2 != null) {
            dlVar2.dl();
        }
    }

    private void z(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        if (mode2 == 1073741824) {
            this.g.m(size2);
        }
        if (mode == 1073741824) {
            this.g.a(size);
        }
        if (mode2 == Integer.MIN_VALUE) {
            this.g.kb(size2);
        }
        if (mode == Integer.MIN_VALUE) {
            this.g.uy(size);
        }
        this.g.z(Float.NaN, Float.NaN);
    }

    protected static void z(z zVar, uy uyVar, View view) {
        if (view.getResources().getConfiguration().getLayoutDirection() == 1) {
            uyVar.z(com.bytedance.adsdk.ugeno.yoga.dl.RTL);
        }
        Drawable background = view.getBackground();
        if (background != null) {
            if (background.getPadding(new Rect())) {
                uyVar.g(a.LEFT, r0.left);
                uyVar.g(a.TOP, r0.top);
                uyVar.g(a.RIGHT, r0.right);
                uyVar.g(a.BOTTOM, r0.bottom);
            }
        }
        for (int i = 0; i < zVar.z.size(); i++) {
            int iKeyAt = zVar.z.keyAt(i);
            float fFloatValue = zVar.z.valueAt(i).floatValue();
            if (iKeyAt == 4) {
                uyVar.dl(com.bytedance.adsdk.ugeno.yoga.z.z(Math.round(fFloatValue)));
            } else if (iKeyAt == 0) {
                uyVar.z(com.bytedance.adsdk.ugeno.yoga.z.z(Math.round(fFloatValue)));
            } else if (iKeyAt == 9) {
                uyVar.g(com.bytedance.adsdk.ugeno.yoga.z.z(Math.round(fFloatValue)));
            } else if (iKeyAt == 25) {
                uyVar.wp(fFloatValue);
            } else if (iKeyAt == 8) {
                if (fFloatValue < 0.0f) {
                    uyVar.dl();
                } else {
                    uyVar.dl(fFloatValue);
                }
            } else if (iKeyAt == 1) {
                uyVar.z(gc.z(Math.round(fFloatValue)));
            } else if (iKeyAt == 6) {
                uyVar.z(fFloatValue);
            } else if (iKeyAt == 7) {
                uyVar.g(fFloatValue);
            } else if (iKeyAt == 16) {
                if (fFloatValue == -1.0f) {
                    uyVar.e(100.0f);
                } else if (fFloatValue == -2.0f) {
                    uyVar.gc();
                } else {
                    uyVar.m(fFloatValue);
                }
            } else if (iKeyAt == 18) {
                uyVar.z(a.LEFT, fFloatValue);
            } else if (iKeyAt == 3) {
                uyVar.z(m.z(Math.round(fFloatValue)));
            } else if (iKeyAt == 17) {
                uyVar.z(a.TOP, fFloatValue);
            } else if (iKeyAt == 20) {
                uyVar.z(a.RIGHT, fFloatValue);
            } else if (iKeyAt == 19) {
                uyVar.z(a.BOTTOM, fFloatValue);
            } else if (iKeyAt == 28) {
                uyVar.fo(fFloatValue);
            } else if (iKeyAt == 27) {
                uyVar.gz(fFloatValue);
            } else if (iKeyAt == 22) {
                uyVar.g(a.LEFT, fFloatValue);
            } else if (iKeyAt == 21) {
                uyVar.g(a.TOP, fFloatValue);
            } else if (iKeyAt == 24) {
                uyVar.g(a.RIGHT, fFloatValue);
            } else if (iKeyAt == 23) {
                uyVar.g(a.BOTTOM, fFloatValue);
            } else if (iKeyAt == 11) {
                uyVar.dl(a.LEFT, fFloatValue);
            } else if (iKeyAt == 10) {
                uyVar.dl(a.TOP, fFloatValue);
            } else if (iKeyAt == 13) {
                uyVar.dl(a.RIGHT, fFloatValue);
            } else if (iKeyAt == 12) {
                uyVar.dl(a.BOTTOM, fFloatValue);
            } else if (iKeyAt == 14) {
                uyVar.z(i.z(Math.round(fFloatValue)));
            } else if (iKeyAt == 15) {
                if (fFloatValue == -1.0f) {
                    uyVar.gc(100.0f);
                } else if (fFloatValue == -2.0f) {
                    uyVar.a();
                } else {
                    uyVar.a(fFloatValue);
                }
            } else if (iKeyAt == 2) {
                uyVar.z(v.z(Math.round(fFloatValue)));
            }
        }
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new z(-1, -1);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new z(layoutParams);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof z;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        dl dlVar = this.dl;
        if (dlVar != null) {
            dlVar.gc();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        dl dlVar = this.dl;
        if (dlVar != null) {
            dlVar.m();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z2) {
        super.onWindowFocusChanged(z2);
        dl dlVar = this.dl;
        if (dlVar != null) {
            dlVar.z(z2);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        dl dlVar = this.dl;
        if (dlVar != null) {
            dlVar.g(i, i2, i3, i4);
        }
    }

    public void z(com.bytedance.adsdk.ugeno.g.dl dlVar) {
        this.dl = dlVar;
    }

    public void setBorderRadius(float f) {
        this.f266a.z(f);
    }

    public float getBorderRadius() {
        return this.f266a.z();
    }

    public void setRipple(float f) {
        gz gzVar = this.f266a;
        if (gzVar != null) {
            gzVar.g(f);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.z.e
    public float getRipple() {
        return this.f266a.getRipple();
    }

    public void setShine(float f) {
        gz gzVar = this.f266a;
        if (gzVar != null) {
            gzVar.dl(f);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.z.e
    public float getShine() {
        return this.f266a.getShine();
    }

    public void setStretch(float f) {
        gz gzVar = this.f266a;
        if (gzVar != null) {
            gzVar.a(f);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.z.e
    public float getStretch() {
        return this.f266a.getStretch();
    }

    public void setRubIn(float f) {
        gz gzVar = this.f266a;
        if (gzVar != null) {
            gzVar.gc(f);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.z.e
    public float getRubIn() {
        return this.f266a.getRubIn();
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.f266a.z(i);
    }

    public static class z extends ViewGroup.LayoutParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private float f267a;
        private float dl;
        private float e;
        private float fo;
        private float fv;
        SparseArray<String> g;
        private float gc;
        private float gz;
        private float i;
        private float js;
        private float kb;
        private float ls;
        private float m;
        private float p;
        private float pf;
        private float uy;
        private float v;
        private float wp;
        SparseArray<Float> z;

        public z(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            if (layoutParams instanceof z) {
                z zVar = (z) layoutParams;
                this.z = zVar.z.clone();
                this.g = zVar.g.clone();
                return;
            }
            this.z = new SparseArray<>();
            this.g = new SparseArray<>();
            if (layoutParams.width >= 0) {
                this.z.put(15, Float.valueOf(this.width));
            }
            if (layoutParams.height >= 0) {
                this.z.put(16, Float.valueOf(this.height));
            }
        }

        public z(int i, int i2) {
            super(i, i2);
            this.z = new SparseArray<>();
            this.g = new SparseArray<>();
            if (i == -2 || i == -1 || i >= 0) {
                this.z.put(15, Float.valueOf(i));
            }
            if (i2 == -2 || i2 == -1 || i2 >= 0) {
                this.z.put(16, Float.valueOf(i2));
            }
        }

        public void z(float f) {
            this.e = f;
            this.z.put(5, Float.valueOf(f));
        }

        public void g(float f) {
            this.gz = f;
            this.z.put(6, Float.valueOf(f));
        }

        public void dl(float f) {
            this.fo = f;
            this.z.put(7, Float.valueOf(f));
        }

        public void a(float f) {
            this.uy = f;
            this.z.put(8, Float.valueOf(f));
        }

        public void gc(float f) {
            this.kb = f;
            this.z.put(9, Float.valueOf(f));
        }

        public void m(float f) {
            this.wp = f;
            this.z.put(14, Float.valueOf(f));
        }

        public void e(float f) {
            this.i = f;
            this.z.put(10, Float.valueOf(f));
        }

        public void gz(float f) {
            this.v = f;
            this.z.put(11, Float.valueOf(f));
        }

        public void fo(float f) {
            this.pf = f;
            this.z.put(12, Float.valueOf(f));
        }

        public void uy(float f) {
            this.ls = f;
            this.z.put(13, Float.valueOf(f));
        }

        public void kb(float f) {
            this.dl = f;
            this.z.put(17, Float.valueOf(f));
        }

        public void wp(float f) {
            this.f267a = f;
            this.z.put(18, Float.valueOf(f));
        }

        public void i(float f) {
            this.gc = f;
            this.z.put(19, Float.valueOf(f));
        }

        public void v(float f) {
            this.m = f;
            this.z.put(20, Float.valueOf(f));
        }

        public void pf(float f) {
            this.p = f;
            this.z.put(25, Float.valueOf(f));
        }

        public void ls(float f) {
            this.fv = f;
            this.z.put(27, Float.valueOf(f));
        }

        public void p(float f) {
            this.js = f;
            this.z.put(28, Float.valueOf(f));
        }
    }

    public static class g implements com.bytedance.adsdk.ugeno.yoga.e {
        @Override // com.bytedance.adsdk.ugeno.yoga.e
        public long z(uy uyVar, float f, com.bytedance.adsdk.ugeno.yoga.gz gzVar, float f2, com.bytedance.adsdk.ugeno.yoga.gz gzVar2) {
            View view = (View) uyVar.uy();
            if (view == null || (view instanceof YogaLayout)) {
                return fo.z(0, 0);
            }
            view.measure(View.MeasureSpec.makeMeasureSpec((int) f, z(gzVar)), View.MeasureSpec.makeMeasureSpec((int) f2, z(gzVar2)));
            return fo.z(view.getMeasuredWidth(), view.getMeasuredHeight());
        }

        private int z(com.bytedance.adsdk.ugeno.yoga.gz gzVar) {
            if (gzVar == com.bytedance.adsdk.ugeno.yoga.gz.AT_MOST) {
                return Integer.MIN_VALUE;
            }
            return gzVar == com.bytedance.adsdk.ugeno.yoga.gz.EXACTLY ? 1073741824 : 0;
        }
    }
}
