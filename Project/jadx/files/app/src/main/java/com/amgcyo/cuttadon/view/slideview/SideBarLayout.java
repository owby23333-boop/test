package com.amgcyo.cuttadon.view.slideview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.amgcyo.cuttadon.R$styleable;
import com.amgcyo.cuttadon.view.slideview.SideBarSortView;
import com.fatcatfat.io.R;

/* JADX INFO: loaded from: classes.dex */
public class SideBarLayout extends RelativeLayout implements SideBarSortView.a {
    private float A;
    private Drawable B;
    private a C;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private Context f5505s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private TextView f5506t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private SideBarSortView f5507u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f5508v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f5509w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private float f5510x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private float f5511y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private int f5512z;

    public interface a {
        void a(String str);
    }

    public SideBarLayout(Context context) {
        super(context);
    }

    private void a(Context context, AttributeSet attributeSet) {
        this.f5505s = context;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = this.f5505s.obtainStyledAttributes(attributeSet, R$styleable.SideBarLayout);
            this.f5509w = typedArrayObtainStyledAttributes.getColor(4, Color.parseColor("#1ABDE6"));
            this.f5508v = typedArrayObtainStyledAttributes.getColor(2, Color.parseColor("#2E56D7"));
            this.f5510x = typedArrayObtainStyledAttributes.getDimension(3, a(this.f5505s, 12.0f));
            this.f5511y = typedArrayObtainStyledAttributes.getDimension(5, a(this.f5505s, 10.0f));
            this.A = typedArrayObtainStyledAttributes.getDimension(8, b(this.f5505s, 45.0f));
            this.f5512z = typedArrayObtainStyledAttributes.getColor(7, Color.parseColor("#FFFFFF"));
            this.B = typedArrayObtainStyledAttributes.getDrawable(6);
            if (this.B == null) {
                this.B = context.getResources().getDrawable(R.drawable.sort_text_view_hint_bg);
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    private void b() {
        View viewInflate = LayoutInflater.from(this.f5505s).inflate(R.layout.mk_view_sidebar_layout, (ViewGroup) null, true);
        this.f5506t = (TextView) viewInflate.findViewById(R.id.tvTips);
        this.f5507u = (SideBarSortView) viewInflate.findViewById(R.id.sortView);
        this.f5507u.setIndexChangedListener(this);
        this.f5507u.setmTextColor(this.f5509w);
        this.f5507u.setmTextSize(this.f5511y);
        this.f5507u.setmTextColorChoose(this.f5508v);
        this.f5507u.setmTextSizeChoose(this.f5510x);
        this.f5507u.invalidate();
        this.f5506t.setTextColor(this.f5512z);
        this.f5506t.setTextSize(b(this.f5505s, this.A));
        this.f5506t.setBackground(this.B);
        addView(viewInflate);
    }

    public void setSideBarLayout(a aVar) {
        this.C = aVar;
    }

    public SideBarLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context, attributeSet);
        b();
    }

    public SideBarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet);
        b();
    }

    @Override // com.amgcyo.cuttadon.view.slideview.SideBarSortView.a
    public void a(String str) {
        this.f5506t.setVisibility(0);
        this.f5506t.setText(str);
        a aVar = this.C;
        if (aVar != null) {
            aVar.a(str);
        }
    }

    public void b(String str) {
        if (this.C != null) {
            this.f5507u.a(str);
        }
    }

    public static int b(Context context, float f2) {
        return (int) ((f2 / context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    @Override // com.amgcyo.cuttadon.view.slideview.SideBarSortView.a
    public void a() {
        this.f5506t.setVisibility(8);
    }

    public static int a(Context context, float f2) {
        return (int) ((f2 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
