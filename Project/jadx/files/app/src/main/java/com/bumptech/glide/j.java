package com.bumptech.glide;

import androidx.annotation.NonNull;
import com.bumptech.glide.j;
import com.bumptech.glide.util.k;

/* JADX INFO: compiled from: TransitionOptions.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class j<CHILD extends j<CHILD, TranscodeType>, TranscodeType> implements Cloneable {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private com.bumptech.glide.request.l.e<? super TranscodeType> f13358s = com.bumptech.glide.request.l.c.b();

    private CHILD b() {
        return this;
    }

    @NonNull
    public final CHILD a(@NonNull com.bumptech.glide.request.l.e<? super TranscodeType> eVar) {
        k.a(eVar);
        this.f13358s = eVar;
        b();
        return this;
    }

    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public final CHILD m61clone() {
        try {
            return (CHILD) super.clone();
        } catch (CloneNotSupportedException e2) {
            throw new RuntimeException(e2);
        }
    }

    final com.bumptech.glide.request.l.e<? super TranscodeType> a() {
        return this.f13358s;
    }
}
