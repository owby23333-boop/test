package fi.harism.curl;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes8.dex */
public interface PageProvider {
    void afterDrawFrame();

    void afterFlip(boolean z);

    void afterSurfaceChanged();

    void flipPage(CurlDirection curlDirection);

    Bitmap getBackgroundBitmap();

    Bitmap getPageBitmap(CurlAnchor curlAnchor);

    boolean isFirstPage(CurlAnchor curlAnchor);

    boolean isLastPage(CurlAnchor curlAnchor);

    CurlAnchor nextPageAnchor(CurlAnchor curlAnchor);

    void onPageSizeChanged(int i, int i2);

    CurlAnchor prevPageAnchor(CurlAnchor curlAnchor);
}
