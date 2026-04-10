package com.yuewen;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.yuewen.bc3;
import com.yuewen.rt2;

/* JADX INFO: loaded from: classes2.dex */
public class hl3 implements bc3.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f12051a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f12052b;
    public View c;

    @Override // com.yuewen.bc3.b
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View viewInflate = layoutInflater.inflate(rt2.n.z0, viewGroup, false);
        this.f12051a = (TextView) viewInflate.findViewById(rt2.k.n4);
        this.f12052b = (TextView) viewInflate.findViewById(rt2.k.m4);
        this.c = viewInflate.findViewById(rt2.k.k4);
        return viewInflate;
    }
}
