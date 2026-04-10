package com.amgcyo.cuttadon.adapter.bookcity;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.amgcyo.cuttadon.activity.bookcity.MkBookCityMoreActivity;
import com.amgcyo.cuttadon.activity.bookcity.MkCategoryAllActivity;
import com.amgcyo.cuttadon.activity.bookcity.MkListThemeSexActivity;
import com.amgcyo.cuttadon.activity.bookcity.MkRanIndexActivity;
import com.amgcyo.cuttadon.api.entity.other.MultiTile;
import com.amgcyo.cuttadon.utils.otherutils.r;
import com.amgcyo.cuttadon.utils.otherutils.r0;
import com.amgcyo.cuttadon.utils.otherutils.x0;
import com.amgcyo.cuttadon.view.otherview.CustomTextView;
import com.baidu.mobads.sdk.api.ArticleInfo;
import com.fatcatfat.io.R;

/* JADX INFO: loaded from: classes.dex */
public class MkMultiTileNoMarginIVB extends me.drakeet.multitype.b<MultiTile, ViewHolder> {

    static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_more)
        TextView tvMore;

        @BindView(R.id.tv_tab_title)
        CustomTextView tvTabTitle;

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
            viewHolder.tvTabTitle = (CustomTextView) Utils.findRequiredViewAsType(view, R.id.tv_tab_title, "field 'tvTabTitle'", CustomTextView.class);
            viewHolder.tvMore = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_more, "field 'tvMore'", TextView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            ViewHolder viewHolder = this.a;
            if (viewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.a = null;
            viewHolder.tvTabTitle = null;
            viewHolder.tvMore = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // me.drakeet.multitype.b
    @NonNull
    public ViewHolder a(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        return new ViewHolder(layoutInflater.inflate(R.layout.multi_item_title_nomargin, viewGroup, false));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // me.drakeet.multitype.b
    public void a(@NonNull ViewHolder viewHolder, @NonNull final MultiTile multiTile) {
        viewHolder.tvTabTitle.setText(multiTile.name);
        final Context context = viewHolder.itemView.getContext();
        viewHolder.tvMore.setVisibility(TextUtils.isEmpty(multiTile.more) ? 8 : 0);
        if (multiTile.isRankIndex) {
            viewHolder.tvMore.setText("全部榜单");
        } else {
            viewHolder.tvMore.setText("查看更多");
        }
        viewHolder.tvMore.setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.adapter.bookcity.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MkMultiTileNoMarginIVB.a(multiTile, context, view);
            }
        });
    }

    static /* synthetic */ void a(MultiTile multiTile, Context context, View view) {
        Bundle bundle = new Bundle();
        if (multiTile.isSortBook) {
            bundle.putInt(ArticleInfo.USER_SEX, multiTile.sexInt);
            bundle.putInt("ltype", multiTile.category);
            bundle.putString("key_desc", multiTile.desc);
            bundle.putString("title", multiTile.name);
            if (!com.amgcyo.cuttadon.utils.otherutils.g.a(multiTile.ltype_list)) {
                String strA = r.a(multiTile.ltype_list);
                if (!TextUtils.isEmpty(strA)) {
                    bundle.putString("LtypeListBean", strA);
                }
            }
            r0.startActivity(context, bundle, MkCategoryAllActivity.class);
            return;
        }
        if (multiTile.isShudan) {
            bundle.putInt(ArticleInfo.USER_SEX, multiTile.sexInt);
            r0.startActivity(context, bundle, MkListThemeSexActivity.class);
        } else {
            if (multiTile.isRankIndex) {
                r0.startActivity(context, MkRanIndexActivity.class);
                x0.c().a("[CITY]排行");
                return;
            }
            bundle.putInt("key_multitle", multiTile.category);
            bundle.putString(ArticleInfo.USER_SEX, multiTile.sexStr);
            bundle.putInt("type_id", multiTile.type_id);
            bundle.putString("title", multiTile.name);
            r0.startActivity(context, bundle, MkBookCityMoreActivity.class);
        }
    }
}
