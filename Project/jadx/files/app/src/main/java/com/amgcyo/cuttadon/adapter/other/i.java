package com.amgcyo.cuttadon.adapter.other;

import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.amgcyo.cuttadon.api.entity.reader.FontBean;
import com.amgcyo.cuttadon.utils.otherutils.z;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.fatcatfat.io.R;
import java.util.List;
import me.jessyan.art.http.imageloader.glide.ImageConfigImpl;

/* JADX INFO: compiled from: MkFontBeanAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public class i extends BaseQuickAdapter<FontBean, com.chad.library.adapter.base.b> {
    private me.jessyan.art.c.e.c K;
    private String L;

    public i(@Nullable List<FontBean> list, me.jessyan.art.c.e.c cVar, String str) {
        super(R.layout.recycler_view_font_item, list);
        this.K = cVar;
        this.L = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void a(@NonNull com.chad.library.adapter.base.b bVar, FontBean fontBean) {
        ImageView imageView = (ImageView) bVar.a(R.id.iv_font_url);
        TextView textView = (TextView) bVar.a(R.id.tv_font_size);
        TextView textView2 = (TextView) bVar.a(R.id.download);
        bVar.a(R.id.download);
        String font_en_name = fontBean.getFont_en_name();
        if (!z.d(font_en_name, fontBean.getFontmd5())) {
            textView2.setText("点击下载");
            textView2.setEnabled(true);
        } else if (TextUtils.isEmpty(this.L) || !font_en_name.equals(this.L)) {
            textView2.setText("点击启用");
            textView2.setEnabled(true);
        } else {
            textView2.setText("当前使用");
            textView2.setEnabled(false);
        }
        this.K.a(this.f14735w, ImageConfigImpl.builder().placeholder(R.drawable.font_place).imageRadius(8).url(fontBean.getImg()).imageView(imageView).build());
        textView.setText(String.format("%sM", Float.valueOf(fontBean.getSize())));
    }
}
