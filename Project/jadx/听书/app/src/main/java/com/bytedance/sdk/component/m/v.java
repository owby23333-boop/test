package com.bytedance.sdk.component.m;

import android.graphics.Bitmap;
import android.widget.ImageView;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes2.dex */
public interface v {
    v cache(g gVar);

    v cacheDir(String str);

    v config(Bitmap.Config config);

    v converter(uy uyVar);

    v from(String str);

    v headers(boolean z);

    v height(int i);

    v key(String str);

    v loadSetp(tb tbVar);

    v maxHeight(int i);

    v maxWidth(int i);

    v requestTime(boolean z);

    v runIn(ExecutorService executorService);

    v scaleType(ImageView.ScaleType scaleType);

    v sync(boolean z);

    wp to(ImageView imageView);

    wp to(io ioVar);

    wp to(io ioVar, int i);

    v track(h hVar);

    v type(int i);

    v width(int i);
}
