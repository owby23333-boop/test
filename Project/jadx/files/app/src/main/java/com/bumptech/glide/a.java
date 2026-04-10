package com.bumptech.glide;

import android.content.Context;
import androidx.annotation.NonNull;
import com.bumptech.glide.l.l;
import com.bumptech.glide.l.p;
import com.bumptech.glide.l.q;
import me.jessyan.art.http.imageloader.glide.GlideRequests;

/* JADX INFO: compiled from: GeneratedRequestManagerFactory.java */
/* JADX INFO: loaded from: classes2.dex */
final class a implements p.b {
    a() {
    }

    @Override // com.bumptech.glide.l.p.b
    @NonNull
    public i a(@NonNull c cVar, @NonNull l lVar, @NonNull q qVar, @NonNull Context context) {
        return new GlideRequests(cVar, lVar, qVar, context);
    }
}
