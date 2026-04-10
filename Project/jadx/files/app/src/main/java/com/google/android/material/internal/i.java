package com.google.android.material.internal;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextPaint;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: TextDrawableHelper.java */
/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class i {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f15533c;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    private com.google.android.material.i.d f15536f;
    private final TextPaint a = new TextPaint(1);
    private final com.google.android.material.i.f b = new a();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f15534d = true;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    private WeakReference<b> f15535e = new WeakReference<>(null);

    /* JADX INFO: compiled from: TextDrawableHelper.java */
    public interface b {
        void a();

        @NonNull
        int[] getState();

        boolean onStateChange(int[] iArr);
    }

    public i(@Nullable b bVar) {
        a(bVar);
    }

    @NonNull
    public TextPaint b() {
        return this.a;
    }

    /* JADX INFO: compiled from: TextDrawableHelper.java */
    class a extends com.google.android.material.i.f {
        a() {
        }

        @Override // com.google.android.material.i.f
        public void a(@NonNull Typeface typeface, boolean z2) {
            if (z2) {
                return;
            }
            i.this.f15534d = true;
            b bVar = (b) i.this.f15535e.get();
            if (bVar != null) {
                bVar.a();
            }
        }

        @Override // com.google.android.material.i.f
        public void a(int i2) {
            i.this.f15534d = true;
            b bVar = (b) i.this.f15535e.get();
            if (bVar != null) {
                bVar.a();
            }
        }
    }

    public void a(@Nullable b bVar) {
        this.f15535e = new WeakReference<>(bVar);
    }

    public void a(boolean z2) {
        this.f15534d = z2;
    }

    public float a(String str) {
        if (!this.f15534d) {
            return this.f15533c;
        }
        this.f15533c = a((CharSequence) str);
        this.f15534d = false;
        return this.f15533c;
    }

    private float a(@Nullable CharSequence charSequence) {
        if (charSequence == null) {
            return 0.0f;
        }
        return this.a.measureText(charSequence, 0, charSequence.length());
    }

    @Nullable
    public com.google.android.material.i.d a() {
        return this.f15536f;
    }

    public void a(@Nullable com.google.android.material.i.d dVar, Context context) {
        if (this.f15536f != dVar) {
            this.f15536f = dVar;
            if (dVar != null) {
                dVar.c(context, this.a, this.b);
                b bVar = this.f15535e.get();
                if (bVar != null) {
                    this.a.drawableState = bVar.getState();
                }
                dVar.b(context, this.a, this.b);
                this.f15534d = true;
            }
            b bVar2 = this.f15535e.get();
            if (bVar2 != null) {
                bVar2.a();
                bVar2.onStateChange(bVar2.getState());
            }
        }
    }

    public void a(Context context) {
        this.f15536f.b(context, this.a, this.b);
    }
}
