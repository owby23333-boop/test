package com.amgcyo.cuttadon.adapter.bookcity;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.annotation.Nullable;
import com.amgcyo.cuttadon.adapter.bookcity.MkBanner1BeanIVB;
import com.amgcyo.cuttadon.utils.otherutils.w;
import com.amgcyo.cuttadon.view.otherview.ImageCycleView;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.fatcatfat.io.R;
import me.jessyan.art.http.imageloader.glide.ImageConfigImpl;

/* JADX INFO: compiled from: MkBanner1BeanIVB.java */
/* JADX INFO: loaded from: classes.dex */
class q implements com.bumptech.glide.request.g<Drawable> {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    final /* synthetic */ ImageCycleView.f f3046s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    final /* synthetic */ Context f3047t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    final /* synthetic */ MkBanner1BeanIVB.ViewHolder f3048u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    final /* synthetic */ MkBanner1BeanIVB f3049v;

    q(MkBanner1BeanIVB mkBanner1BeanIVB, ImageCycleView.f fVar, Context context, MkBanner1BeanIVB.ViewHolder viewHolder) {
        this.f3049v = mkBanner1BeanIVB;
        this.f3046s = fVar;
        this.f3047t = context;
        this.f3048u = viewHolder;
    }

    @Override // com.bumptech.glide.request.g
    public boolean a(@Nullable GlideException glideException, Object obj, com.bumptech.glide.request.k.j<Drawable> jVar, boolean z2) {
        return false;
    }

    @Override // com.bumptech.glide.request.g
    public boolean a(Drawable drawable, Object obj, com.bumptech.glide.request.k.j<Drawable> jVar, DataSource dataSource, boolean z2) {
        Drawable drawableA = w.a(com.amgcyo.cuttadon.f.o.a(drawable), 10);
        this.f3049v.a(drawableA, this.f3046s.a);
        if (this.f3049v.f3011d) {
            return false;
        }
        this.f3049v.b.a(this.f3047t, ImageConfigImpl.builder().placeholder(R.drawable.icon_pic_def).drawable(drawableA).imageView(this.f3048u.iv_banner_head_bg).build());
        this.f3049v.f3011d = true;
        return false;
    }
}
