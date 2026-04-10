package com.amgcyo.cuttadon.view.comic;

import android.graphics.drawable.AnimationDrawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.amgcyo.cuttadon.utils.otherutils.n;
import com.fatcatfat.io.R;

/* JADX INFO: compiled from: ComicLoadmoreView.java */
/* JADX INFO: loaded from: classes.dex */
public final class i extends com.chad.library.adapter.base.e.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f4549f;

    public i(boolean z2) {
        this.f4549f = z2;
    }

    @Override // com.chad.library.adapter.base.e.a
    public int a() {
        return R.layout.comic_view_load_more;
    }

    @Override // com.chad.library.adapter.base.e.a
    protected void a(com.chad.library.adapter.base.b bVar, ImageView imageView, boolean z2) {
        int iA = n.a(imageView.getContext());
        if (this.f4549f) {
            int i2 = (int) (iA / 2.6f);
            LinearLayout linearLayout = (LinearLayout) bVar.a(h());
            View viewA = bVar.a(i());
            if (viewA instanceof TextView) {
                ((TextView) viewA).setTextColor(-1);
            }
            ((FrameLayout.LayoutParams) linearLayout.getLayoutParams()).topMargin = i2;
            View viewA2 = bVar.a(e());
            if (viewA2 instanceof TextView) {
                ((TextView) viewA2).setTextColor(-1);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewA2.getLayoutParams();
                layoutParams.height = iA;
                layoutParams.topMargin = iA / 2;
            }
        } else {
            ((FrameLayout) bVar.a(d())).getLayoutParams().height = n.a(200.0f);
        }
        if (z2) {
            ((AnimationDrawable) imageView.getDrawable()).start();
        } else {
            ((AnimationDrawable) imageView.getDrawable()).stop();
        }
    }

    @Override // com.chad.library.adapter.base.e.a
    public int b() {
        return R.id.load_more_load_end_view;
    }

    @Override // com.chad.library.adapter.base.e.a
    public int c() {
        return R.id.load_more_load_end_view_text;
    }

    @Override // com.chad.library.adapter.base.e.a
    public int d() {
        return R.id.load_more_load_fail_view;
    }

    @Override // com.chad.library.adapter.base.e.a
    protected int e() {
        return R.id.load_more_load_fail_view_text;
    }

    @Override // com.chad.library.adapter.base.e.a
    protected int g() {
        return R.id.load_more_loading;
    }

    @Override // com.chad.library.adapter.base.e.a
    public int h() {
        return R.id.load_more_loading_view;
    }

    @Override // com.chad.library.adapter.base.e.a
    public int i() {
        return R.id.load_more_loading_textview;
    }
}
