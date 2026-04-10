package com.amgcyo.cuttadon.view.comic;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.amgcyo.cuttadon.R$styleable;
import com.fatcatfat.io.R;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class TagCloudView extends ViewGroup {
    private int A;
    private int B;
    private int C;
    private int D;
    private int E;
    private boolean F;
    private boolean G;
    private boolean H;
    private boolean I;
    private String J;
    private int K;
    private int L;
    private ImageView M;
    private int N;
    private int O;
    private TextView P;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private List<String> f4518s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private LayoutInflater f4519t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private b f4520u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f4521v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f4522w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private float f4523x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private int f4524y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private int f4525z;

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (TagCloudView.this.f4520u != null) {
                TagCloudView.this.f4520u.a(-1);
            }
        }
    }

    public interface b {
        void a(int i2);
    }

    public TagCloudView(Context context) {
        this(context, null);
    }

    private int b(int i2, int i3) {
        int i4 = i2 + this.A;
        int i5 = 0;
        if (getTextTotalWidth() < this.f4521v - this.K) {
            this.P = null;
            this.N = 0;
        }
        while (true) {
            if (i5 >= getChildCount()) {
                break;
            }
            View childAt = getChildAt(i5);
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            if (i5 == 0) {
                i4 += measuredWidth;
                i3 = this.A + measuredHeight;
            } else {
                i4 += this.B + measuredWidth;
            }
            if (childAt.getTag() != null && ((Integer) childAt.getTag()).intValue() == 1) {
                int i6 = this.B + i4;
                int i7 = this.A;
                if (i6 + i7 + i7 + this.N + this.K >= this.f4521v) {
                    i4 -= measuredWidth + i7;
                    break;
                }
                int i8 = this.C;
                childAt.layout((i4 - measuredWidth) + i8, i3 - measuredHeight, i8 + i4, i3);
            }
            i5++;
        }
        TextView textView = this.P;
        if (textView != null) {
            int i9 = this.A;
            int i10 = this.C;
            textView.layout(i4 + i9 + i10, i3 - this.O, i4 + i9 + i10 + this.N, i3);
        }
        int i11 = this.A;
        int i12 = i3 + i11;
        ImageView imageView = this.M;
        if (imageView != null) {
            int i13 = this.f4521v;
            int i14 = (i13 - this.K) - i11;
            int i15 = this.L;
            imageView.layout(i14, (i12 - i15) / 2, i13 - i11, ((i12 - i15) / 2) + i15);
        }
        return i12;
    }

    private void c(int i2, int i3) {
        if (this.F) {
            if (this.G) {
                this.M = new ImageView(getContext());
                this.M.setImageResource(this.E);
                this.M.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
                this.M.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                measureChild(this.M, i2, i3);
                this.K = this.M.getMeasuredWidth();
                this.L = this.M.getMeasuredHeight();
                addView(this.M);
            }
            if (this.H) {
                this.P = (TextView) this.f4519t.inflate(this.D, (ViewGroup) null);
                if (this.D == R.layout.item_tag) {
                    this.P.setBackgroundResource(this.f4525z);
                    this.P.setTextSize(2, this.f4523x);
                    this.P.setTextColor(this.f4524y);
                }
                this.P.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
                TextView textView = this.P;
                String str = this.J;
                textView.setText((str == null || str.equals("")) ? " … " : this.J);
                measureChild(this.P, i2, i3);
                this.O = this.P.getMeasuredHeight();
                this.N = this.P.getMeasuredWidth();
                addView(this.P);
                this.P.setOnClickListener(new a());
            }
        }
    }

    private int getTextTotalWidth() {
        if (getChildCount() == 0) {
            return 0;
        }
        int measuredWidth = 0;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getTag() != null && ((Integer) childAt.getTag()).intValue() == 1) {
                measuredWidth += childAt.getMeasuredWidth() + this.A;
            }
        }
        return measuredWidth + (this.B * 2);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return super.generateLayoutParams(attributeSet);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return (!this.I && this.F) || super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onMeasure(int i2, int i3) {
        View.MeasureSpec.getMode(i2);
        int mode = View.MeasureSpec.getMode(i3);
        this.f4521v = View.MeasureSpec.getSize(i2);
        this.f4522w = View.MeasureSpec.getSize(i3);
        measureChildren(i2, i3);
        c(i2, i3);
        int i4 = this.C;
        int iB = this.F ? b(0, i4) : a(0, i4);
        int i5 = this.f4521v;
        if (mode == 1073741824) {
            iB = this.f4522w;
        }
        setMeasuredDimension(i5, iB);
    }

    public void setOnTagClickListener(b bVar) {
        this.f4520u = bVar;
    }

    public void setTags(List<String> list) {
        this.f4518s = list;
        removeAllViews();
        List<String> list2 = this.f4518s;
        if (list2 != null && list2.size() > 0) {
            for (final int i2 = 0; i2 < this.f4518s.size(); i2++) {
                TextView textView = (TextView) this.f4519t.inflate(this.D, (ViewGroup) null);
                if (this.D == R.layout.item_tag) {
                    textView.setBackgroundResource(this.f4525z);
                    textView.setTextSize(2, this.f4523x);
                    textView.setTextColor(this.f4524y);
                }
                textView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
                textView.setText(this.f4518s.get(i2));
                textView.setTag(1);
                textView.setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.view.comic.h
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f4547s.a(i2, view);
                    }
                });
                addView(textView);
            }
        }
        postInvalidate();
    }

    public TagCloudView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private int a(int i2, int i3) {
        for (int i4 = 0; i4 < getChildCount(); i4++) {
            View childAt = getChildAt(i4);
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            int i5 = this.A;
            i2 += measuredWidth + i5;
            if (i4 == 0) {
                i3 = measuredHeight + i5;
            }
            int i6 = this.B;
            int i7 = this.A;
            if (i2 + i6 + i7 > this.f4521v) {
                i3 += this.C + measuredHeight;
                int i8 = i7 + measuredWidth;
                childAt.layout(i7 + i6, i3 - measuredHeight, i6 + i8, i3);
                i2 = i8;
            } else {
                childAt.layout((i2 - measuredWidth) + i6, i3 - measuredHeight, i6 + i2, i3);
            }
        }
        return i3 + this.A;
    }

    public TagCloudView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.M = null;
        this.N = 0;
        this.O = 0;
        this.P = null;
        this.f4519t = LayoutInflater.from(context);
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R$styleable.TagCloudView, i2, i2);
        this.f4523x = typedArrayObtainStyledAttributes.getInteger(13, 14);
        this.f4524y = typedArrayObtainStyledAttributes.getColor(12, -1);
        this.f4525z = typedArrayObtainStyledAttributes.getResourceId(0, R.drawable.tag_background);
        this.A = typedArrayObtainStyledAttributes.getDimensionPixelSize(1, 6);
        this.B = typedArrayObtainStyledAttributes.getDimensionPixelSize(5, 8);
        this.C = typedArrayObtainStyledAttributes.getDimensionPixelSize(6, 5);
        this.I = typedArrayObtainStyledAttributes.getBoolean(3, true);
        this.E = typedArrayObtainStyledAttributes.getResourceId(7, R.drawable.icon_join);
        this.F = typedArrayObtainStyledAttributes.getBoolean(10, false);
        this.G = typedArrayObtainStyledAttributes.getBoolean(9, true);
        this.H = typedArrayObtainStyledAttributes.getBoolean(8, true);
        this.J = typedArrayObtainStyledAttributes.getString(4);
        this.D = typedArrayObtainStyledAttributes.getResourceId(11, R.layout.item_tag);
        typedArrayObtainStyledAttributes.recycle();
    }

    public /* synthetic */ void a(int i2, View view) {
        b bVar = this.f4520u;
        if (bVar != null) {
            bVar.a(i2);
        }
    }
}
