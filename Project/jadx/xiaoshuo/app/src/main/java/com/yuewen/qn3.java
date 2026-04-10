package com.yuewen;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.duokan.advertisement.i;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes12.dex */
public class qn3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<dl1> f16562a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f16563b;
    public final WeakReference<ViewGroup> c;
    public final WeakReference<ImageView> d;
    public final String e;

    public qn3(@NonNull ViewGroup viewGroup, ImageView imageView, @NonNull dl1 dl1Var, @NonNull String str) {
        this.c = new WeakReference<>(viewGroup);
        this.d = new WeakReference<>(imageView);
        this.f16563b = viewGroup.getContext().getApplicationContext();
        this.f16562a = new WeakReference<>(dl1Var);
        this.e = str;
    }

    public void a(String str) {
        WeakReference<ImageView> weakReference = this.d;
        ImageView imageView = weakReference == null ? null : weakReference.get();
        if (imageView == null) {
            return;
        }
        str.hashCode();
        if (str.equals(o5.d)) {
            imageView.setImageResource(i.h.Au);
        } else if (str.equals("yimi")) {
            imageView.setImageResource(i.h.zu);
        }
    }
}
