package com.qmuiteam.qmui.widget.pullLayout;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.collection.SimpleArrayMap;
import androidx.core.content.ContextCompat;
import androidx.swiperefreshlayout.widget.CircularProgressDrawable;
import com.qmuiteam.qmui.R;
import com.qmuiteam.qmui.skin.QMUISkinValueBuilder;
import com.qmuiteam.qmui.skin.defaultAttr.IQMUISkinDefaultAttrProvider;
import com.qmuiteam.qmui.util.QMUIResHelper;
import com.qmuiteam.qmui.widget.pullLayout.QMUIPullLayout;

/* JADX INFO: loaded from: classes4.dex */
public class QMUIPullRefreshView extends AppCompatImageView implements QMUIPullLayout.ActionPullWatcherView, IQMUISkinDefaultAttrProvider {
    static final int CIRCLE_DIAMETER = 40;
    static final int CIRCLE_DIAMETER_LARGE = 56;
    private static final int MAX_ALPHA = 255;
    private static final float TRIM_OFFSET = 0.4f;
    private static final float TRIM_RATE = 0.85f;
    private static SimpleArrayMap<String, Integer> sDefaultSkinAttrs;
    private int mCircleDiameter;
    private CircularProgressDrawable mProgress;

    public void doRefresh() {
    }

    static {
        SimpleArrayMap<String, Integer> simpleArrayMap = new SimpleArrayMap<>(4);
        sDefaultSkinAttrs = simpleArrayMap;
        simpleArrayMap.put(QMUISkinValueBuilder.TINT_COLOR, Integer.valueOf(R.attr.qmui_skin_support_pull_refresh_view_color));
    }

    public QMUIPullRefreshView(Context context) {
        this(context, null);
    }

    public QMUIPullRefreshView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mProgress = new CircularProgressDrawable(context);
        setColorSchemeColors(QMUIResHelper.getAttrColor(context, R.attr.qmui_skin_support_pull_refresh_view_color));
        this.mProgress.setStyle(0);
        this.mProgress.setAlpha(255);
        this.mProgress.setArrowScale(0.8f);
        setImageDrawable(this.mProgress);
        this.mCircleDiameter = (int) (getResources().getDisplayMetrics().density * 40.0f);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        int i3 = this.mCircleDiameter;
        setMeasuredDimension(i3, i3);
    }

    @Override // com.qmuiteam.qmui.widget.pullLayout.QMUIPullLayout.ActionPullWatcherView
    public void onActionTriggered() {
        this.mProgress.start();
    }

    @Override // com.qmuiteam.qmui.widget.pullLayout.QMUIPullLayout.ActionPullWatcherView
    public void onActionFinished() {
        this.mProgress.stop();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mProgress.stop();
    }

    @Override // com.qmuiteam.qmui.widget.pullLayout.QMUIPullLayout.ActionPullWatcherView
    public void onPull(QMUIPullLayout.PullAction pullAction, int i) {
        if (this.mProgress.isRunning()) {
            return;
        }
        int targetTriggerOffset = pullAction.getTargetTriggerOffset();
        float fMin = Math.min(targetTriggerOffset, i) * TRIM_RATE;
        float f = targetTriggerOffset;
        float f2 = (i * TRIM_OFFSET) / f;
        this.mProgress.setArrowEnabled(true);
        this.mProgress.setStartEndTrim(0.0f, fMin / f);
        this.mProgress.setProgressRotation(f2);
    }

    public void setSize(int i) {
        if (i == 0 || i == 1) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            if (i == 0) {
                this.mCircleDiameter = (int) (displayMetrics.density * 56.0f);
            } else {
                this.mCircleDiameter = (int) (displayMetrics.density * 40.0f);
            }
            setImageDrawable(null);
            this.mProgress.setStyle(i);
            setImageDrawable(this.mProgress);
        }
    }

    public void stop() {
        this.mProgress.stop();
    }

    public void setColorSchemeResources(int... iArr) {
        Context context = getContext();
        int[] iArr2 = new int[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            iArr2[i] = ContextCompat.getColor(context, iArr[i]);
        }
        setColorSchemeColors(iArr2);
    }

    public void setColorSchemeColors(int... iArr) {
        this.mProgress.setColorSchemeColors(iArr);
    }

    @Override // com.qmuiteam.qmui.skin.defaultAttr.IQMUISkinDefaultAttrProvider
    public SimpleArrayMap<String, Integer> getDefaultSkinAttrs() {
        return sDefaultSkinAttrs;
    }
}
