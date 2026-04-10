package com.amgcyo.cuttadon.api.presenter;

import com.amgcyo.cuttadon.api.entity.other.MkBook;
import com.amgcyo.cuttadon.api.entity.other.MkCatalog;
import io.reactivex.ObservableEmitter;
import java.util.ArrayList;

/* JADX INFO: compiled from: CatalogPresenter.java */
/* JADX INFO: loaded from: classes.dex */
class a0 extends com.amgcyo.cuttadon.f.p<ArrayList<MkCatalog>> {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    final /* synthetic */ ObservableEmitter f3395x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    final /* synthetic */ MkBook f3396y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    final /* synthetic */ CatalogPresenter f3397z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    a0(CatalogPresenter catalogPresenter, me.jessyan.art.e.c cVar, String str, String str2, ObservableEmitter observableEmitter, MkBook mkBook) {
        super(cVar, str, str2);
        this.f3397z = catalogPresenter;
        this.f3395x = observableEmitter;
        this.f3396y = mkBook;
    }

    @Override // io.reactivex.Observer
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onNext(ArrayList<MkCatalog> arrayList) {
        if (com.amgcyo.cuttadon.utils.otherutils.g.a(arrayList)) {
            this.f3395x.onNext(arrayList);
            this.f3395x.onComplete();
            return;
        }
        this.f3396y.setUpdated(8);
        String str = "获取章节列表数据大小：" + arrayList.size();
        this.f3397z.f3247w = arrayList;
        this.f3395x.onNext(arrayList);
        this.f3395x.onComplete();
    }
}
