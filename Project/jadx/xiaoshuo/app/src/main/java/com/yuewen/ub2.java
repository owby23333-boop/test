package com.yuewen;

import android.view.View;
import com.duokan.reader.ui.view.DkNestedHeaderLayout;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ub2 implements DkNestedHeaderLayout.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f18417a = 1;

    @Override // com.duokan.reader.ui.view.DkNestedHeaderLayout.c
    public void a(int i) {
        if (this.f18417a == i) {
            return;
        }
        b(i);
        this.f18417a = i;
    }

    public abstract void b(int i);

    @Override // com.duokan.reader.ui.view.DkNestedHeaderLayout.c
    public void onHeaderClosed(View view) {
    }

    @Override // com.duokan.reader.ui.view.DkNestedHeaderLayout.c
    public void onHeaderOpened(View view) {
    }

    @Override // com.duokan.reader.ui.view.DkNestedHeaderLayout.c
    public void onTriggerClosed(View view) {
    }

    @Override // com.duokan.reader.ui.view.DkNestedHeaderLayout.c
    public void onTriggerOpened(View view) {
    }
}
