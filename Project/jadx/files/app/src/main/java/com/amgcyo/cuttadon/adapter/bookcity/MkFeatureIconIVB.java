package com.amgcyo.cuttadon.adapter.bookcity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.amgcyo.cuttadon.activity.bookcity.MkClassifyActivity;
import com.amgcyo.cuttadon.activity.bookcity.MkEndBookActivity;
import com.amgcyo.cuttadon.activity.bookcity.MkListThemeActivity;
import com.amgcyo.cuttadon.activity.bookcity.MkRanIndexActivity;
import com.amgcyo.cuttadon.api.entity.bookcity.v7.V7IconBean;
import com.amgcyo.cuttadon.utils.otherutils.r0;
import com.amgcyo.cuttadon.utils.otherutils.x0;
import com.fatcatfat.io.R;
import java.util.regex.Pattern;
import me.jessyan.art.http.imageloader.glide.ImageConfigImpl;

/* JADX INFO: loaded from: classes.dex */
public class MkFeatureIconIVB extends me.drakeet.multitype.b<V7IconBean, ViewHolder> {
    private me.jessyan.art.c.e.c b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f3015c = com.amgcyo.cuttadon.utils.otherutils.h.L0();

    static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.img_category)
        ImageView imgCategory;

        @BindView(R.id.tv_title)
        TextView tvTitle;

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
            viewHolder.imgCategory = (ImageView) Utils.findRequiredViewAsType(view, R.id.img_category, "field 'imgCategory'", ImageView.class);
            viewHolder.tvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'tvTitle'", TextView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            ViewHolder viewHolder = this.a;
            if (viewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.a = null;
            viewHolder.imgCategory = null;
            viewHolder.tvTitle = null;
        }
    }

    public MkFeatureIconIVB(me.jessyan.art.c.e.c cVar) {
        this.b = cVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // me.drakeet.multitype.b
    @NonNull
    public ViewHolder a(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        return new ViewHolder(layoutInflater.inflate(R.layout.book_city_icon_holder, viewGroup, false));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // me.drakeet.multitype.b
    public void a(@NonNull ViewHolder viewHolder, @NonNull final V7IconBean v7IconBean) {
        final Context context = viewHolder.itemView.getContext();
        this.b.a(context, ImageConfigImpl.builder().isCircle(true).url(String.format("%s%s", com.amgcyo.cuttadon.utils.otherutils.g.E(), v7IconBean.getImage())).imageView(viewHolder.imgCategory).build());
        String name = v7IconBean.getName();
        if (!this.f3015c && Pattern.matches(".*(?=热评).*", name)) {
            name = name.replaceAll("热评", "最热");
        }
        viewHolder.tvTitle.setText(name);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.adapter.bookcity.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MkFeatureIconIVB.a(v7IconBean, context, view);
            }
        });
    }

    static /* synthetic */ void a(V7IconBean v7IconBean, Context context, View view) {
        int type_id = v7IconBean.getType_id();
        if (type_id == 1) {
            r0.startActivity(context, MkClassifyActivity.class);
            x0.c().a("[CITY]分类");
            return;
        }
        if (type_id == 2) {
            r0.startActivity(context, MkRanIndexActivity.class);
            x0.c().a("[CITY]排行");
            return;
        }
        if (type_id == 3) {
            r0.startActivity(context, MkListThemeActivity.class);
            x0.c().a("[CITY]书单");
        } else if (type_id == 4 || type_id == 5) {
            Bundle bundle = new Bundle();
            bundle.putInt("consume_type", v7IconBean.getData_id());
            r0.startActivity(context, bundle, MkEndBookActivity.class);
            x0.c().a("[CITY]热评");
        }
    }
}
