package com.amgcyo.cuttadon.api.presenter;

import com.amgcyo.cuttadon.api.entity.other.MkBook;
import com.amgcyo.cuttadon.api.entity.other.MkCatalog;
import io.reactivex.ObservableEmitter;
import java.util.ArrayList;

/* JADX INFO: compiled from: CatalogPresenter.java */
/* JADX INFO: loaded from: classes.dex */
class y extends com.amgcyo.cuttadon.f.p<ArrayList<MkCatalog>> {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    final /* synthetic */ ObservableEmitter f3425x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    final /* synthetic */ MkBook f3426y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    final /* synthetic */ CatalogPresenter f3427z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    y(CatalogPresenter catalogPresenter, me.jessyan.art.e.c cVar, String str, String str2, ObservableEmitter observableEmitter, MkBook mkBook) {
        super(cVar, str, str2);
        this.f3427z = catalogPresenter;
        this.f3425x = observableEmitter;
        this.f3426y = mkBook;
    }

    @Override // io.reactivex.Observer
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onNext(ArrayList<MkCatalog> arrayList) {
        if (com.amgcyo.cuttadon.utils.otherutils.g.a(arrayList)) {
            this.f3425x.onNext(arrayList);
            this.f3425x.onComplete();
        } else {
            this.f3426y.setUpdated(8);
            this.f3427z.f3247w = arrayList;
            this.f3425x.onNext(arrayList);
            this.f3425x.onComplete();
        }
    }
}
