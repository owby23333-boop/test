package com.amgcyo.cuttadon.adapter.comic;

import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.internal.view.SupportMenu;
import com.amgcyo.cuttadon.api.entity.comic.ComicSourceBean;
import com.amgcyo.cuttadon.f.o;
import com.amgcyo.cuttadon.utils.otherutils.l;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.fatcatfat.io.R;
import java.util.List;

/* JADX INFO: compiled from: MkComicSourceMuiltQa.java */
/* JADX INFO: loaded from: classes.dex */
public class c extends BaseQuickAdapter<ComicSourceBean, com.chad.library.adapter.base.b> {
    private String K;
    private String L;

    public c(List<ComicSourceBean> list, String str, String str2) {
        super(R.layout.item_book_source_list, list);
        this.K = str;
        this.L = str2;
    }

    private void b(com.chad.library.adapter.base.b bVar, ComicSourceBean comicSourceBean) {
        int adapterPosition = bVar.getAdapterPosition();
        TextView textView = (TextView) bVar.a(R.id.tv_sourceName);
        TextView textView2 = (TextView) bVar.a(R.id.tv_first);
        String sourceId = comicSourceBean.getSourceId();
        ((TextView) bVar.a(R.id.tv_choose)).setVisibility(8);
        TextView textView3 = (TextView) bVar.a(R.id.tv_update);
        TextView textView4 = (TextView) bVar.a(R.id.tv_ischoice);
        ((TextView) bVar.a(R.id.tv_time)).setVisibility(8);
        textView.setText(sourceId);
        int[] iArr = l.a;
        GradientDrawable gradientDrawableA = o.a(-1, -1, 1, (String) null, adapterPosition < iArr.length ? iArr[adapterPosition] : SupportMenu.CATEGORY_MASK);
        textView2.setText(sourceId.substring(0, 1));
        textView2.setBackground(gradientDrawableA);
        Object[] objArr = new Object[1];
        objArr[0] = TextUtils.isEmpty(this.L) ? "暂无最新章节信息" : this.L;
        textView3.setText(String.format("更新至：%s", objArr));
        if (TextUtils.isEmpty(this.K) || !this.K.equals(sourceId)) {
            textView4.setVisibility(4);
        } else {
            textView4.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void a(@NonNull com.chad.library.adapter.base.b bVar, ComicSourceBean comicSourceBean) {
        b(bVar, comicSourceBean);
    }
}
