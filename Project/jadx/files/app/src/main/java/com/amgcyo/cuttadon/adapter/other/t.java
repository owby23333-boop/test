package com.amgcyo.cuttadon.adapter.other;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.amgcyo.cuttadon.api.entity.other.NewApiAd;
import com.amgcyo.cuttadon.view.otherview.RoundRelativeLayout;
import com.amgcyo.cuttadon.view.otherview.SelfAdLogoFrameLayout;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.fatcatfat.io.R;
import me.jessyan.art.http.imageloader.glide.ImageConfigImpl;

/* JADX INFO: compiled from: MkWanyiwanAdListAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public class t extends BaseQuickAdapter<NewApiAd, com.chad.library.adapter.base.b> {
    private me.jessyan.art.c.e.c K;

    /* JADX INFO: compiled from: MkWanyiwanAdListAdapter.java */
    class a implements com.bumptech.glide.request.g<Drawable> {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ SelfAdLogoFrameLayout f3104s;

        a(t tVar, SelfAdLogoFrameLayout selfAdLogoFrameLayout) {
            this.f3104s = selfAdLogoFrameLayout;
        }

        @Override // com.bumptech.glide.request.g
        public boolean a(@Nullable GlideException glideException, Object obj, com.bumptech.glide.request.k.j<Drawable> jVar, boolean z2) {
            this.f3104s.a();
            return false;
        }

        @Override // com.bumptech.glide.request.g
        public boolean a(Drawable drawable, Object obj, com.bumptech.glide.request.k.j<Drawable> jVar, DataSource dataSource, boolean z2) {
            this.f3104s.a();
            return false;
        }
    }

    public t(me.jessyan.art.c.e.c cVar) {
        super(R.layout.book_city_wanyiwan);
        this.K = cVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void a(@NonNull com.chad.library.adapter.base.b bVar, NewApiAd newApiAd) {
        TextView textView = (TextView) bVar.a(R.id.top_title);
        ((RoundRelativeLayout) bVar.a(R.id.roundrelativelayout)).setCornerRadius(8);
        SelfAdLogoFrameLayout selfAdLogoFrameLayout = (SelfAdLogoFrameLayout) bVar.a(R.id.selfadlogo_fl);
        ImageView iv_native_image = selfAdLogoFrameLayout.getIv_native_image();
        TextView textView2 = (TextView) bVar.a(R.id.top_des);
        ((TextView) bVar.a(R.id.top_count)).setText(String.format("%s%s%s", newApiAd.getAuthor(), " · ", newApiAd.getType()));
        textView.setText(newApiAd.getName());
        textView2.setText(newApiAd.getDesc());
        String image = newApiAd.getImage();
        if (TextUtils.isEmpty(image)) {
            return;
        }
        this.K.a(this.f14735w, ImageConfigImpl.builder().isNeedPlaceholder(false).listener(new a(this, selfAdLogoFrameLayout)).url(image).imageView(iv_native_image).build());
    }
}
