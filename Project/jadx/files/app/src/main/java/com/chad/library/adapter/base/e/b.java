package com.chad.library.adapter.base.e;

import android.widget.ImageView;
import com.chad.library.R$id;
import com.chad.library.R$layout;

/* JADX INFO: compiled from: SimpleLoadMoreView.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b extends a {
    @Override // com.chad.library.adapter.base.e.a
    public int a() {
        return R$layout.brvah_quick_view_load_more;
    }

    @Override // com.chad.library.adapter.base.e.a
    protected void a(com.chad.library.adapter.base.b bVar, ImageView imageView, boolean z2) {
    }

    @Override // com.chad.library.adapter.base.e.a
    public int b() {
        return R$id.load_more_load_end_view;
    }

    @Override // com.chad.library.adapter.base.e.a
    public int c() {
        return R$id.load_more_load_end_view_text;
    }

    @Override // com.chad.library.adapter.base.e.a
    public int d() {
        return R$id.load_more_load_fail_view;
    }

    @Override // com.chad.library.adapter.base.e.a
    protected int e() {
        return R$id.load_more_load_fail_view_text;
    }

    @Override // com.chad.library.adapter.base.e.a
    protected int g() {
        return R$id.load_more_loading;
    }

    @Override // com.chad.library.adapter.base.e.a
    public int h() {
        return R$id.load_more_loading_view;
    }

    @Override // com.chad.library.adapter.base.e.a
    public int i() {
        return R$id.load_more_loading_textview;
    }
}
