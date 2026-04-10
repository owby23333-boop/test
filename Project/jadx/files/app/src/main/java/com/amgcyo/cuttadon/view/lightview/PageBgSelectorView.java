package com.amgcyo.cuttadon.view.lightview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.amgcyo.cuttadon.R$styleable;
import com.amgcyo.cuttadon.f.o;
import com.amgcyo.cuttadon.utils.otherutils.w0;
import com.fatcatfat.io.R;

/* JADX INFO: loaded from: classes.dex */
public class PageBgSelectorView extends LinearLayout implements View.OnClickListener {

    @BindView(R.id.ivWgCenter)
    protected ImageView ivWgCenter;

    @BindView(R.id.riWgInside)
    protected RoundedImageView riWgInside;

    @BindView(R.id.riWgOutside)
    protected RoundedImageView riWgOutside;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private a f4851s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f4852t;

    public interface a {
        void a(PageBgSelectorView pageBgSelectorView, boolean z2);
    }

    public PageBgSelectorView(Context context) {
        super(context);
        this.f4852t = false;
        a();
    }

    private void a(AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.PageBgSelectorView);
        if (typedArrayObtainStyledAttributes != null) {
            o.a((ImageView) this.riWgInside, typedArrayObtainStyledAttributes.getResourceId(1, 0));
            int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0);
            if (resourceId > 0) {
                o.a(this.ivWgCenter, resourceId);
            }
            int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(2, 0);
            this.riWgOutside.setAlpha(0.3f);
            o.a((ImageView) this.riWgOutside, resourceId2);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    private void b() {
        LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService("layout_inflater");
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        View viewInflate = layoutInflater.inflate(R.layout.mk_view_widget_light, (ViewGroup) null);
        ButterKnife.bind(this, viewInflate);
        addView(viewInflate, layoutParams);
    }

    private void c() {
        w0.a(this, this.riWgInside, this.riWgOutside);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f4852t) {
            return;
        }
        this.f4852t = true;
        o.a(this.riWgOutside, this.f4852t);
        a aVar = this.f4851s;
        if (aVar != null) {
            aVar.a(this, this.f4852t);
        }
    }

    public void setListener(a aVar) {
        this.f4851s = aVar;
    }

    public void setSelect(boolean z2) {
        this.f4852t = z2;
        o.a(this.riWgOutside, this.f4852t);
    }

    public PageBgSelectorView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4852t = false;
        a();
        a(attributeSet);
    }

    private void a() {
        b();
        c();
    }
}
