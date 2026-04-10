package com.amgcyo.cuttadon.api.presenter;

import com.amgcyo.cuttadon.api.entity.other.MkCatalog;
import io.reactivex.ObservableEmitter;
import java.util.ArrayList;

/* JADX INFO: compiled from: CatalogPresenter.java */
/* JADX INFO: loaded from: classes.dex */
class z extends com.amgcyo.cuttadon.f.p<ArrayList<MkCatalog>> {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    final /* synthetic */ me.jessyan.art.mvp.e f3428x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    final /* synthetic */ ObservableEmitter f3429y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    final /* synthetic */ CatalogPresenter f3430z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    z(CatalogPresenter catalogPresenter, me.jessyan.art.mvp.e eVar, boolean z2, me.jessyan.art.e.c cVar, String str, String str2, me.jessyan.art.mvp.e eVar2, ObservableEmitter observableEmitter) {
        super(eVar, z2, cVar, str, str2);
        this.f3430z = catalogPresenter;
        this.f3428x = eVar2;
        this.f3429y = observableEmitter;
    }

    @Override // io.reactivex.Observer
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onNext(ArrayList<MkCatalog> arrayList) {
        if (com.amgcyo.cuttadon.utils.otherutils.g.a(arrayList)) {
            this.f3428x.showMessage("获取章节列表失败,请重试!");
            this.f3429y.onNext(arrayList);
            this.f3429y.onComplete();
        } else {
            this.f3430z.f3247w = arrayList;
            this.f3429y.onNext(arrayList);
            this.f3429y.onComplete();
        }
    }
}
