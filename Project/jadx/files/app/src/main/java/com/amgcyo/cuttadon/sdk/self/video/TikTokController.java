package com.amgcyo.cuttadon.sdk.self.video;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import xyz.doikki.videoplayer.controller.BaseVideoController;

/* JADX INFO: loaded from: classes.dex */
public class TikTokController extends BaseVideoController {
    public TikTokController(@NonNull Context context) {
        super(context);
    }

    @Override // xyz.doikki.videoplayer.controller.BaseVideoController
    protected int getLayoutId() {
        return 0;
    }

    @Override // xyz.doikki.videoplayer.controller.BaseVideoController
    public boolean showNetWarning() {
        return false;
    }

    public TikTokController(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public TikTokController(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
