package com.bytedance.adsdk.ugeno.swiper.indicator;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import androidx.core.internal.view.SupportMenu;
import com.bytedance.adsdk.ugeno.swiper.g;
import com.qmuiteam.qmui.widget.QMUIProgressBar;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BaseIndicator extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<View> f247a;
    protected int dl;
    private int e;
    private int fo;
    protected int g;
    private int gc;
    private boolean gz;
    private float kb;
    private int m;
    private float uy;
    private String wp;
    protected Context z;

    public abstract Drawable g(int i);

    public BaseIndicator(Context context) {
        super(context);
        this.gc = SupportMenu.CATEGORY_MASK;
        this.m = QMUIProgressBar.DEFAULT_PROGRESS_COLOR;
        this.e = 5;
        this.g = 40;
        this.dl = 20;
        this.wp = "row";
        this.z = context;
        this.f247a = new ArrayList();
        setOrientation(0);
    }

    public void setIndicatorX(float f) {
        this.uy = f;
    }

    public void setIndicatorY(float f) {
        this.kb = f;
    }

    public void setIndicatorDirection(String str) {
        this.wp = str;
        if (TextUtils.equals(str, "column")) {
            setOrientation(1);
        } else {
            setOrientation(0);
        }
    }

    public void setIndicatorWidth(int i) {
        this.g = i;
    }

    public void setIndicatorHeight(int i) {
        this.dl = i;
    }

    public void z(int i, int i2) {
        Iterator<View> it = this.f247a.iterator();
        while (it.hasNext()) {
            it.next().setBackground(g(this.m));
        }
        if (i < 0 || i >= this.f247a.size()) {
            i = 0;
        }
        if (this.f247a.size() > 0) {
            this.f247a.get(i).setBackground(g(this.gc));
            this.fo = i2;
        }
    }

    public int getSize() {
        return this.f247a.size();
    }

    public void setSelectedColor(int i) {
        this.gc = i;
    }

    public void setLoop(boolean z) {
        this.gz = z;
    }

    public void setUnSelectedColor(int i) {
        this.m = i;
    }

    public void z(int i) {
        if (this instanceof DotIndicator) {
            this.dl = this.g;
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.g, this.dl);
        if (getOrientation() == 1) {
            layoutParams.topMargin = this.e;
            layoutParams.bottomMargin = this.e;
        } else {
            layoutParams.leftMargin = this.e;
            layoutParams.rightMargin = this.e;
        }
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(this.g, this.dl);
        if (getOrientation() == 1) {
            layoutParams2.topMargin = this.e;
            layoutParams2.bottomMargin = this.e;
        } else {
            layoutParams2.leftMargin = this.e;
            layoutParams2.rightMargin = this.e;
        }
        int iZ = g.z(this.gz, this.fo, this.f247a.size());
        int iZ2 = g.z(this.gz, i, this.f247a.size());
        if (this.f247a.size() == 0) {
            iZ2 = 0;
        }
        if (!this.f247a.isEmpty() && g.z(iZ, this.f247a) && g.z(iZ2, this.f247a)) {
            this.f247a.get(iZ).setBackground(g(this.m));
            this.f247a.get(iZ).setLayoutParams(layoutParams2);
            this.f247a.get(iZ2).setBackground(g(this.gc));
            this.f247a.get(iZ2).setLayoutParams(layoutParams);
            this.fo = i;
        }
    }

    public void z() {
        View view = new View(getContext());
        view.setClickable(false);
        if (this instanceof DotIndicator) {
            this.dl = this.g;
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.g, this.dl);
        if (getOrientation() == 1) {
            layoutParams.topMargin = this.e;
            layoutParams.bottomMargin = this.e;
        } else {
            layoutParams.leftMargin = this.e;
            layoutParams.rightMargin = this.e;
        }
        addView(view, layoutParams);
        view.setBackground(g(this.m));
        this.f247a.add(view);
    }
}
