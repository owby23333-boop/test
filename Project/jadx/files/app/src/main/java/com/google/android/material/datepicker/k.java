package com.google.android.material.datepicker;

import androidx.fragment.app.Fragment;
import java.util.LinkedHashSet;

/* JADX INFO: compiled from: PickerFragment.java */
/* JADX INFO: loaded from: classes2.dex */
abstract class k<S> extends Fragment {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    protected final LinkedHashSet<j<S>> f15334s = new LinkedHashSet<>();

    k() {
    }

    boolean a(j<S> jVar) {
        return this.f15334s.add(jVar);
    }

    void f() {
        this.f15334s.clear();
    }
}
