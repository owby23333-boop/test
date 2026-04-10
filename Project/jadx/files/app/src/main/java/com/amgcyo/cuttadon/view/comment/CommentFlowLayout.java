package com.amgcyo.cuttadon.view.comment;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.amgcyo.cuttadon.utils.otherutils.g;
import com.fatcatfat.io.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import me.jessyan.art.http.imageloader.glide.ImageConfigImpl;

/* JADX INFO: loaded from: classes.dex */
public class CommentFlowLayout extends ViewGroup {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private Context f4610s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private List<String> f4611t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f4612u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f4613v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private List<List<View>> f4614w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private List<Integer> f4615x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    protected me.jessyan.art.c.e.c f4616y;

    public CommentFlowLayout(Context context) {
        super(context);
        this.f4611t = new ArrayList();
        this.f4612u = false;
        this.f4613v = 30;
        this.f4614w = new ArrayList();
        this.f4615x = new ArrayList();
        this.f4610s = context;
    }

    public void a(List<String> list, me.jessyan.art.c.e.c cVar) {
        this.f4616y = cVar;
        this.f4611t.clear();
        this.f4611t.addAll(list);
        a();
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        this.f4614w.clear();
        this.f4615x.clear();
        int width = getWidth();
        ArrayList arrayList = new ArrayList();
        int childCount = getChildCount();
        ArrayList arrayList2 = arrayList;
        int iMax = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            if (measuredWidth + i6 + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin > (width - getPaddingRight()) - getPaddingLeft()) {
                this.f4615x.add(Integer.valueOf(iMax));
                this.f4614w.add(arrayList2);
                ArrayList arrayList3 = new ArrayList();
                i6 = 0;
                arrayList2 = arrayList3;
                iMax = marginLayoutParams.topMargin + measuredHeight + marginLayoutParams.bottomMargin;
            }
            i6 += ((measuredWidth + marginLayoutParams.leftMargin) + marginLayoutParams.rightMargin) - this.f4613v;
            iMax = Math.max(iMax, measuredHeight + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin);
            arrayList2.add(childAt);
        }
        this.f4615x.add(Integer.valueOf(iMax));
        this.f4614w.add(arrayList2);
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int size = this.f4614w.size();
        int i8 = paddingTop;
        int paddingLeft2 = paddingLeft;
        for (int i9 = 0; i9 < size; i9++) {
            List<View> list = this.f4614w.get(i9);
            int iIntValue = this.f4615x.get(i9).intValue();
            if (this.f4612u) {
                Collections.reverse(list);
            }
            int measuredWidth2 = paddingLeft2;
            for (int i10 = 0; i10 < list.size(); i10++) {
                View view = list.get(i10);
                if (view.getVisibility() != 8) {
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                    int i11 = marginLayoutParams2.leftMargin + measuredWidth2;
                    int i12 = marginLayoutParams2.topMargin + i8;
                    view.layout(i11, i12, view.getMeasuredWidth() + i11, view.getMeasuredHeight() + i12);
                    measuredWidth2 += ((view.getMeasuredWidth() + marginLayoutParams2.leftMargin) + marginLayoutParams2.rightMargin) - this.f4613v;
                }
            }
            paddingLeft2 = getPaddingLeft();
            i8 += iIntValue;
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int size2 = View.MeasureSpec.getSize(i3);
        int childCount = getChildCount();
        int i4 = 0;
        int i5 = 0;
        int iMax = 0;
        int iMax2 = 0;
        int i6 = 0;
        while (i4 < childCount) {
            View childAt = getChildAt(i4);
            measureChild(childAt, i2, i3);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
            int i7 = size2;
            int measuredWidth = childAt.getMeasuredWidth() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
            int measuredHeight = childAt.getMeasuredHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
            int i8 = i5 + measuredWidth;
            if (i8 > (size - getPaddingLeft()) - getPaddingRight()) {
                i6 += iMax2;
                iMax = Math.max(iMax, i5);
                iMax2 = measuredHeight;
                i5 = measuredWidth;
            } else {
                iMax2 = Math.max(iMax2, measuredHeight);
                i5 = i8;
            }
            if (i4 == childCount - 1) {
                i6 += iMax2;
                iMax = Math.max(i5, iMax);
            }
            i4++;
            size2 = i7;
        }
        int i9 = size2;
        if (mode != 1073741824) {
            size = iMax - ((childCount - 1) * this.f4613v);
        }
        if (mode2 == 1073741824) {
            i6 = i9;
        }
        setMeasuredDimension(size, i6);
    }

    public void setFlag(boolean z2) {
        this.f4612u = z2;
    }

    public void setOneUrls(String str) {
        this.f4611t.add(str);
        a();
    }

    public void setSpWidth(int i2) {
        this.f4613v = i2;
    }

    private void a() {
        removeAllViews();
        for (int i2 = 0; i2 < this.f4611t.size(); i2++) {
            String str = this.f4611t.get(i2);
            ImageView imageView = (ImageView) LayoutInflater.from(this.f4610s).inflate(R.layout.item_praise, (ViewGroup) this, false);
            if (com.amgcyo.cuttadon.a.f2254e.intValue() == 1) {
                if (g.s(str)) {
                    this.f4616y.a(this.f4610s, ImageConfigImpl.builder().isCircle(true).fallback(R.drawable.user_avatar).placeholder(R.drawable.user_avatar).errorPic(R.drawable.user_avatar).resId(R.drawable.user_avatar).imageView(imageView).build());
                } else {
                    a(str, imageView);
                }
            } else {
                a(str, imageView);
            }
            addView(imageView);
        }
    }

    public CommentFlowLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4611t = new ArrayList();
        this.f4612u = false;
        this.f4613v = 30;
        this.f4614w = new ArrayList();
        this.f4615x = new ArrayList();
        this.f4610s = context;
    }

    public CommentFlowLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f4611t = new ArrayList();
        this.f4612u = false;
        this.f4613v = 30;
        this.f4614w = new ArrayList();
        this.f4615x = new ArrayList();
        this.f4610s = context;
    }

    private void a(String str, ImageView imageView) {
        this.f4616y.a(this.f4610s, ImageConfigImpl.builder().isCircle(true).fallback(R.drawable.user_avatar).placeholder(R.drawable.user_avatar).errorPic(R.drawable.user_avatar).url(str).imageView(imageView).build());
    }
}
