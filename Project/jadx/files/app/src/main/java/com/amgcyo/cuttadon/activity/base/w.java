package com.amgcyo.cuttadon.activity.base;

import android.graphics.Bitmap;
import com.amgcyo.cuttadon.utils.otherutils.ScannerUtils;
import java.util.List;

/* JADX INFO: compiled from: BaseWebViewAcitivity.java */
/* JADX INFO: loaded from: classes.dex */
class w implements com.hjq.permissions.a {
    final /* synthetic */ boolean[] a;
    final /* synthetic */ String b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Bitmap f2307c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ BaseWebViewAcitivity f2308d;

    w(BaseWebViewAcitivity baseWebViewAcitivity, boolean[] zArr, String str, Bitmap bitmap) {
        this.f2308d = baseWebViewAcitivity;
        this.a = zArr;
        this.b = str;
        this.f2307c = bitmap;
    }

    @Override // com.hjq.permissions.a
    public void a(List<String> list, boolean z2) {
        this.a[0] = false;
        com.amgcyo.cuttadon.f.o.b("二维码保存到相册失败，请授予存储权限后重试！");
    }

    @Override // com.hjq.permissions.a
    public void b(List<String> list, boolean z2) {
        this.a[0] = ScannerUtils.a(this.f2308d.a(), this.b, this.f2307c, ScannerUtils.ScannerType.RECEIVER);
        if (this.a[0]) {
            com.amgcyo.cuttadon.f.o.b("已成功保存图片到相册");
        }
    }
}
