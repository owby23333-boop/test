package com.yuewen;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.NestedScrollingChild;

/* JADX INFO: loaded from: classes6.dex */
public class dm3 implements cm3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f10212a;

    public dm3(View view) {
        this.f10212a = view;
    }

    @Override // com.yuewen.cm3
    public boolean a() {
        return !this.f10212a.canScrollVertically(1);
    }

    @Override // com.yuewen.cm3
    public boolean b() {
        return this.f10212a instanceof NestedScrollingChild;
    }

    @Override // com.yuewen.cm3
    public boolean c() {
        return !this.f10212a.canScrollVertically(-1);
    }

    @Override // com.yuewen.cm3
    @NonNull
    public View getView() {
        return this.f10212a;
    }
}
