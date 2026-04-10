package com.yuewen;

import android.view.View;
import android.view.ViewGroup;
import com.duokan.reader.domain.cloud.DkCloudStoreBook;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public abstract class up2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f18540a = false;

    public abstract void a(List<DkCloudStoreBook> list, List<DkCloudStoreBook> list2, List<DkCloudStoreBook> list3, Runnable runnable);

    public abstract View b(int i, View view, ViewGroup viewGroup);

    public abstract View c(int i, View view, ViewGroup viewGroup);

    public abstract int d();

    public abstract int e();

    public abstract int f(int i);

    public abstract Object g(int i);

    public void h() {
        this.f18540a = false;
    }

    public boolean i() {
        return this.f18540a;
    }

    public void j() {
        this.f18540a = true;
    }
}
