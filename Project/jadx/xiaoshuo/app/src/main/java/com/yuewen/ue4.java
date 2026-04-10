package com.yuewen;

import com.duokan.reader.ui.zxing.ViewfinderView;
import com.google.zxing.ResultPoint;
import com.google.zxing.ResultPointCallback;

/* JADX INFO: loaded from: classes5.dex */
public final class ue4 implements ResultPointCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewfinderView f18444a;

    public ue4(ViewfinderView viewfinderView) {
        this.f18444a = viewfinderView;
    }

    @Override // com.google.zxing.ResultPointCallback
    public void foundPossibleResultPoint(ResultPoint resultPoint) {
        this.f18444a.a(resultPoint);
    }
}
