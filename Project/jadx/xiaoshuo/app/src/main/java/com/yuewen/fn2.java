package com.yuewen;

import android.view.ViewGroup;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes13.dex */
public abstract class fn2<Data> extends xz<Data> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ec2 f11157a;

    public fn2(@NonNull ViewGroup parent, int layoutId) {
        super(parent, layoutId);
    }

    public void k(ec2 listener2) {
        this.f11157a = listener2;
    }
}
