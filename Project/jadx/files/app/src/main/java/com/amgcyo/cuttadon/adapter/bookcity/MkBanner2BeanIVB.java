package com.amgcyo.cuttadon.adapter.bookcity;

import android.content.Context;
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
import com.amgcyo.cuttadon.adapter.bookcity.MkBanner2BeanIVB;
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
public class MkBanner2BeanIVB extends me.drakeet.multitype.b<BookCityHeaderData, ViewHolder> {
    private me.jessyan.art.c.e.c b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f3014c = g0.a().a("key_city_sex_width", 0);

    static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.icv_topView)
        ImageCycleView icv_topView;

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
        }
    }

    class a implements ImageCycleView.h {
        final /* synthetic */ Context a;

        a(MkBanner2BeanIVB mkBanner2BeanIVB, Context context) {
            this.a = context;
        }

        @Override // com.amgcyo.cuttadon.view.otherview.ImageCycleView.h
        public void a(int i2) {
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
    }

    public MkBanner2BeanIVB(me.jessyan.art.c.e.c cVar) {
        this.b = cVar;
        Integer.valueOf(com.amgcyo.cuttadon.utils.otherutils.n.b(600.0f));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // me.drakeet.multitype.b
    @NonNull
    public ViewHolder a(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        return new ViewHolder(layoutInflater.inflate(R.layout.bookcity_banner_2, viewGroup, false));
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
            new ColorInfo().setImgUrl(str);
            v7BannerBean.getImage();
        }
        viewHolder.icv_topView.a(arrayList, new ImageCycleView.g() { // from class: com.amgcyo.cuttadon.adapter.bookcity.d
            @Override // com.amgcyo.cuttadon.view.otherview.ImageCycleView.g
            public final ImageView a(ImageCycleView.f fVar) {
                return this.a.a(context, fVar);
            }
        });
        viewHolder.icv_topView.setOnPageClickListener(new a(this, context));
        if (this.f3014c <= 0) {
            viewHolder.icv_topView.post(new Runnable() { // from class: com.amgcyo.cuttadon.adapter.bookcity.e
                @Override // java.lang.Runnable
                public final void run() {
                    Context context2 = context;
                    MkBanner2BeanIVB.ViewHolder viewHolder2 = viewHolder;
                    g0.a().b("key_city_sex_width", com.amgcyo.cuttadon.utils.otherutils.n.b(context2, viewHolder2.icv_topView.getWidth()));
                }
            });
        }
    }

    public /* synthetic */ ImageView a(Context context, ImageCycleView.f fVar) {
        ImageView imageView = new ImageView(context);
        this.b.a(context, ImageConfigImpl.builder().form(fVar.f4993c).url(fVar.a).imageView(imageView).build());
        return imageView;
    }
}
