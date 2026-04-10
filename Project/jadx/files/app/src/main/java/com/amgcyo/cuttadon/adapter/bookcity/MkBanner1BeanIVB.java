package com.amgcyo.cuttadon.adapter.bookcity;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.amgcyo.cuttadon.activity.bookcity.MkThemeDetailActivity;
import com.amgcyo.cuttadon.adapter.bookcity.MkBanner1BeanIVB;
import com.amgcyo.cuttadon.api.entity.bookcity.BookCityHeaderData;
import com.amgcyo.cuttadon.api.entity.bookcity.v7.V7BannerBean;
import com.amgcyo.cuttadon.api.entity.bookcity.v7.V7BannerBeanDataBean;
import com.amgcyo.cuttadon.api.entity.comic.ColorInfo;
import com.amgcyo.cuttadon.utils.otherutils.g0;
import com.amgcyo.cuttadon.utils.otherutils.r0;
import com.amgcyo.cuttadon.view.otherview.ImageCycleView;
import com.fatcatfat.io.R;
import java.util.ArrayList;
import java.util.List;
import me.jessyan.art.http.imageloader.glide.ImageConfigImpl;

/* JADX INFO: loaded from: classes.dex */
public class MkBanner1BeanIVB extends me.drakeet.multitype.b<BookCityHeaderData, ViewHolder> {
    private me.jessyan.art.c.e.c b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f3011d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private List<ColorInfo> f3012e = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f3010c = g0.a().a("key_city_sex_width", 0);

    static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.icv_topView)
        ImageCycleView icv_topView;

        @BindView(R.id.iv_banner_head_bg)
        ImageView iv_banner_head_bg;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    public class ViewHolder_ViewBinding implements Unbinder {
        private ViewHolder a;

        @UiThread
        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.a = viewHolder;
            viewHolder.icv_topView = (ImageCycleView) Utils.findRequiredViewAsType(view, R.id.icv_topView, "field 'icv_topView'", ImageCycleView.class);
            viewHolder.iv_banner_head_bg = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_banner_head_bg, "field 'iv_banner_head_bg'", ImageView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            ViewHolder viewHolder = this.a;
            if (viewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.a = null;
            viewHolder.icv_topView = null;
            viewHolder.iv_banner_head_bg = null;
        }
    }

    public MkBanner1BeanIVB(me.jessyan.art.c.e.c cVar) {
        this.b = cVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // me.drakeet.multitype.b
    @NonNull
    public ViewHolder a(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        return new ViewHolder(layoutInflater.inflate(R.layout.bookcity_banner_1, viewGroup, false));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // me.drakeet.multitype.b
    public void a(@NonNull ViewHolder viewHolder, @NonNull BookCityHeaderData bookCityHeaderData) {
        a(viewHolder, bookCityHeaderData.getBanner());
    }

    private void a(final ViewHolder viewHolder, List<V7BannerBean> list) {
        final Context context = viewHolder.itemView.getContext();
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            V7BannerBean v7BannerBean = list.get(i2);
            int i3 = v7BannerBean.getType() == 4 ? 3 : 1;
            String str = com.amgcyo.cuttadon.utils.otherutils.g.e(i3) + v7BannerBean.getImage();
            arrayList.add(new ImageCycleView.f(str, v7BannerBean.getTitle(), i3, i2, v7BannerBean.getData()));
            ColorInfo colorInfo = new ColorInfo();
            colorInfo.setImgUrl(str);
            this.f3012e.add(colorInfo);
            v7BannerBean.getImage();
        }
        viewHolder.icv_topView.a(arrayList, new ImageCycleView.g() { // from class: com.amgcyo.cuttadon.adapter.bookcity.c
            @Override // com.amgcyo.cuttadon.view.otherview.ImageCycleView.g
            public final ImageView a(ImageCycleView.f fVar) {
                return this.a.a(context, viewHolder, fVar);
            }
        });
        viewHolder.icv_topView.setOnPageClickListener(new a(context, viewHolder));
        if (this.f3010c <= 0) {
            viewHolder.icv_topView.post(new Runnable() { // from class: com.amgcyo.cuttadon.adapter.bookcity.b
                @Override // java.lang.Runnable
                public final void run() {
                    Context context2 = context;
                    MkBanner1BeanIVB.ViewHolder viewHolder2 = viewHolder;
                    g0.a().b("key_city_sex_width", com.amgcyo.cuttadon.utils.otherutils.n.b(context2, viewHolder2.icv_topView.getWidth()));
                }
            });
        }
    }

    class a implements ImageCycleView.h {
        final /* synthetic */ Context a;
        final /* synthetic */ ViewHolder b;

        a(Context context, ViewHolder viewHolder) {
            this.a = context;
            this.b = viewHolder;
        }

        @Override // com.amgcyo.cuttadon.view.otherview.ImageCycleView.h
        public void a(View view, ImageCycleView.f fVar) {
            V7BannerBeanDataBean v7BannerBeanDataBean = fVar.b;
            if (v7BannerBeanDataBean == null || this.a == null) {
                return;
            }
            if (v7BannerBeanDataBean.getBook_id() != 0) {
                r0.a(this.a, v7BannerBeanDataBean.getBook_id(), fVar.f4993c);
                return;
            }
            if (!TextUtils.isEmpty(v7BannerBeanDataBean.getUrl_path())) {
                r0.a(this.a, v7BannerBeanDataBean.getUrl_path());
            } else {
                if (TextUtils.isEmpty(v7BannerBeanDataBean.getBook_list_path())) {
                    return;
                }
                Bundle bundle = new Bundle();
                bundle.putString("theme_path", v7BannerBeanDataBean.getBook_list_path());
                bundle.putBoolean("theme_base_info", false);
                r0.startActivity(this.a, bundle, MkThemeDetailActivity.class);
            }
        }

        @Override // com.amgcyo.cuttadon.view.otherview.ImageCycleView.h
        public void a(int i2) {
            if (com.amgcyo.cuttadon.utils.otherutils.g.a((List<?>) MkBanner1BeanIVB.this.f3012e)) {
                return;
            }
            MkBanner1BeanIVB.this.b.a(this.a, ImageConfigImpl.builder().placeholderDrawable(this.b.iv_banner_head_bg.getDrawable()).drawable(((ColorInfo) MkBanner1BeanIVB.this.f3012e.get(i2)).getDrawable()).imageView(this.b.iv_banner_head_bg).build());
        }
    }

    public /* synthetic */ ImageView a(Context context, ViewHolder viewHolder, ImageCycleView.f fVar) {
        ImageView imageView = new ImageView(context);
        this.b.a(context, ImageConfigImpl.builder().form(fVar.f4993c).url(fVar.a).imageView(imageView).listener(new q(this, fVar, context, viewHolder)).build());
        return imageView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Drawable drawable, String str) {
        if (this.f3012e == null) {
            return;
        }
        for (int i2 = 0; i2 < this.f3012e.size(); i2++) {
            if (this.f3012e.get(i2).getImgUrl().equals(str)) {
                this.f3012e.get(i2).setDrawable(drawable);
            }
        }
    }
}
