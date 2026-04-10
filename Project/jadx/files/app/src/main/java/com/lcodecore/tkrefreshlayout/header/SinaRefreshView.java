package com.lcodecore.tkrefreshlayout.header;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import com.lcodecore.tkrefreshlayout.R$id;
import com.lcodecore.tkrefreshlayout.R$layout;
import com.lcodecore.tkrefreshlayout.b;
import com.lcodecore.tkrefreshlayout.c;

/* JADX INFO: loaded from: classes3.dex */
public class SinaRefreshView extends FrameLayout implements b {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private ImageView f17066s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private ImageView f17067t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private TextView f17068u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private LinearLayout f17069v;

    public SinaRefreshView(Context context) {
        this(context, null);
    }

    private void a() {
        View viewInflate = LayoutInflater.from(getContext()).inflate(R$layout.view_sinaheader, (ViewGroup) null, false);
        this.f17066s = (ImageView) viewInflate.findViewById(R$id.iv_arrow);
        this.f17068u = (TextView) viewInflate.findViewById(R$id.tv);
        this.f17069v = (LinearLayout) viewInflate.findViewById(R$id.ll_root);
        this.f17067t = (ImageView) viewInflate.findViewById(R$id.iv_loading);
        addView(viewInflate);
    }

    @Override // com.lcodecore.tkrefreshlayout.b
    public void a(float f2, float f3, float f4) {
    }

    @Override // com.lcodecore.tkrefreshlayout.b
    public void b(float f2, float f3, float f4) {
        this.f17067t.setVisibility(0);
    }

    @Override // com.lcodecore.tkrefreshlayout.b
    public View getView() {
        return this;
    }

    @Override // com.lcodecore.tkrefreshlayout.b
    public void reset() {
    }

    public void setArrowResource(@DrawableRes int i2) {
        this.f17066s.setImageResource(i2);
    }

    public void setHeadViewBgColor(@ColorInt int i2) {
        this.f17069v.setBackgroundColor(i2);
    }

    public void setPullDownStr(String str) {
    }

    public void setRefreshingStr(String str) {
    }

    public void setReleaseRefreshStr(String str) {
    }

    public void setTextColor(@ColorInt int i2) {
        this.f17068u.setTextColor(i2);
    }

    public SinaRefreshView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SinaRefreshView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a();
    }

    @Override // com.lcodecore.tkrefreshlayout.b
    public void a(float f2, float f3) {
        this.f17067t.setVisibility(0);
        ((AnimationDrawable) this.f17067t.getDrawable()).start();
    }

    @Override // com.lcodecore.tkrefreshlayout.b
    public void a(c cVar) {
        cVar.a();
    }
}
