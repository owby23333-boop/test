package com.lxj.xpopup.c;

import android.content.Context;
import android.view.View;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import com.lxj.xpopup.core.ImageViewerPopupView;
import com.lxj.xpopup.photoview.PhotoView;
import java.io.File;

/* JADX INFO: compiled from: XPopupImageLoader.java */
/* JADX INFO: loaded from: classes3.dex */
public interface i {
    View a(int i2, @NonNull Object obj, @NonNull ImageViewerPopupView imageViewerPopupView, @NonNull PhotoView photoView, @NonNull ProgressBar progressBar);

    File a(@NonNull Context context, @NonNull Object obj);

    void a(@NonNull Object obj, @NonNull PhotoView photoView);
}
