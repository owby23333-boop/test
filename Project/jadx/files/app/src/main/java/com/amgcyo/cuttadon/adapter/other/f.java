package com.amgcyo.cuttadon.adapter.other;

import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.amgcyo.cuttadon.api.entity.other.MkBookclassifyBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.fatcatfat.io.R;
import java.util.List;
import me.jessyan.art.http.imageloader.glide.ImageConfigImpl;

/* JADX INFO: compiled from: MkClassSexBeanAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public class f extends BaseQuickAdapter<MkBookclassifyBean, com.chad.library.adapter.base.b> {
    private me.jessyan.art.c.e.c K;
    private int L;

    public f(@Nullable List<MkBookclassifyBean> list, me.jessyan.art.c.e.c cVar, int i2) {
        super(R.layout.item_book_classify_list_new, list);
        this.K = cVar;
        this.L = i2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void a(@NonNull com.chad.library.adapter.base.b bVar, MkBookclassifyBean mkBookclassifyBean) {
        ((TextView) bVar.a(R.id.class_name)).setText(mkBookclassifyBean.getLtype_name());
        this.K.a(this.f14735w, ImageConfigImpl.builder().url(String.format("%s%s", com.amgcyo.cuttadon.utils.otherutils.g.e(this.L), mkBookclassifyBean.getLtype_image())).imageView((ImageView) bVar.a(R.id.class_cover)).form(this.L).build());
    }
}
