package com.amgcyo.cuttadon.api.repository;

import androidx.annotation.NonNull;
import io.reactivex.ObservableEmitter;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/* JADX INFO: compiled from: ConfigRepository.java */
/* JADX INFO: loaded from: classes.dex */
class x3 implements Callback {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    final /* synthetic */ ObservableEmitter f3570s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    final /* synthetic */ String[] f3571t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    final /* synthetic */ ConfigRepository f3572u;

    x3(ConfigRepository configRepository, ObservableEmitter observableEmitter, String[] strArr) {
        this.f3572u = configRepository;
        this.f3570s = observableEmitter;
        this.f3571t = strArr;
    }

    @Override // okhttp3.Callback
    public void onFailure(@NonNull Call call, @NonNull IOException iOException) {
        String str = "下发的域名或者默认的域名都有问题，不用说了，开始检测域名吧  " + iOException.getMessage();
        this.f3572u.check(this.f3570s);
    }

    @Override // okhttp3.Callback
    public void onResponse(@NonNull Call call, @NonNull Response response) {
        int iCode = response.code();
        String str = this.f3571t[0] + " 域名响应码为: " + iCode;
        if (com.amgcyo.cuttadon.utils.otherutils.g.i(iCode)) {
            this.f3572u.successFindDomain(this.f3570s, this.f3571t[0], false);
        } else {
            this.f3572u.check(this.f3570s);
        }
    }
}
