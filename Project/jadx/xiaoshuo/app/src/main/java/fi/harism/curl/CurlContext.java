package fi.harism.curl;

import android.graphics.PointF;

/* JADX INFO: loaded from: classes8.dex */
public interface CurlContext {
    void destroy();

    CurlAnchor getCurrentPageAnchor();

    CurlDirection getDirection();

    int getVisibility();

    boolean isAnimating();

    void onDragEnd(PointF pointF, PointF pointF2);

    void onDragMove(PointF pointF);

    void onDragStart(PointF pointF, CurlDirection curlDirection);

    void pageDownSmoothly(PointF pointF, Runnable runnable, Runnable runnable2);

    void pageUpSmoothly(PointF pointF, Runnable runnable, Runnable runnable2);

    void setAnimationQuality(int i);

    void setColorScale(float f, float f2, float f3);

    void setCurrentPageAnchor(CurlAnchor curlAnchor);

    void setPageProvider(PageProvider pageProvider);

    void setRtlMode(boolean z);

    void setViewMode(CurlViewMode curlViewMode);

    void setVisibility(int i);
}
