package com.amgcyo.cuttadon.fragment.books;

import com.amgcyo.cuttadon.view.showcaseview.MaterialShowcaseView;

/* JADX INFO: compiled from: BookAndComicFragment.java */
/* JADX INFO: loaded from: classes.dex */
class t0 implements com.amgcyo.cuttadon.view.showcaseview.e {
    final /* synthetic */ int a;

    t0(BookAndComicFragment bookAndComicFragment, int i2) {
        this.a = i2;
    }

    @Override // com.amgcyo.cuttadon.view.showcaseview.e
    public void a(MaterialShowcaseView materialShowcaseView) {
    }

    @Override // com.amgcyo.cuttadon.view.showcaseview.e
    public void b(MaterialShowcaseView materialShowcaseView) {
        com.amgcyo.cuttadon.utils.otherutils.g0.a().b("shelf_guider", this.a + 1);
    }
}
