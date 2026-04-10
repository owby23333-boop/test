package com.yuewen;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import java.util.List;

/* JADX INFO: loaded from: classes11.dex */
public class ly1 extends q63 {
    public View d;
    public List<View> e;
    public List<View> f;
    public FrameLayout.LayoutParams g;

    public ly1(ViewGroup viewGroup, me0 me0Var, ke0 ke0Var, View view, List<View> list, List<View> list2, FrameLayout.LayoutParams layoutParams) {
        super(viewGroup, me0Var, ke0Var);
        this.d = view;
        this.e = list;
        this.f = list2;
        this.g = layoutParams;
    }

    public View d() {
        return this.d;
    }

    public List<View> e() {
        return this.e;
    }

    public List<View> f() {
        return this.f;
    }

    public FrameLayout.LayoutParams g() {
        return this.g;
    }
}
