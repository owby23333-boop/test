package net.lucode.hackware.magicindicator.buildins.commonnavigator.titles;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IMeasurablePagerTitleView;

/* JADX INFO: loaded from: classes9.dex */
public class CommonPagerTitleView extends FrameLayout implements IMeasurablePagerTitleView {
    private ContentPositionDataProvider mContentPositionDataProvider;
    private OnPagerTitleChangeListener mOnPagerTitleChangeListener;

    public interface ContentPositionDataProvider {
        int getContentBottom();

        int getContentLeft();

        int getContentRight();

        int getContentTop();
    }

    public interface OnPagerTitleChangeListener {
        void onDeselected(int i, int i2);

        void onEnter(int i, int i2, float f, boolean z);

        void onLeave(int i, int i2, float f, boolean z);

        void onSelected(int i, int i2);
    }

    public CommonPagerTitleView(Context context) {
        super(context);
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IMeasurablePagerTitleView
    public int getContentBottom() {
        ContentPositionDataProvider contentPositionDataProvider = this.mContentPositionDataProvider;
        return contentPositionDataProvider != null ? contentPositionDataProvider.getContentBottom() : getBottom();
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IMeasurablePagerTitleView
    public int getContentLeft() {
        ContentPositionDataProvider contentPositionDataProvider = this.mContentPositionDataProvider;
        return contentPositionDataProvider != null ? contentPositionDataProvider.getContentLeft() : getLeft();
    }

    public ContentPositionDataProvider getContentPositionDataProvider() {
        return this.mContentPositionDataProvider;
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IMeasurablePagerTitleView
    public int getContentRight() {
        ContentPositionDataProvider contentPositionDataProvider = this.mContentPositionDataProvider;
        return contentPositionDataProvider != null ? contentPositionDataProvider.getContentRight() : getRight();
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IMeasurablePagerTitleView
    public int getContentTop() {
        ContentPositionDataProvider contentPositionDataProvider = this.mContentPositionDataProvider;
        return contentPositionDataProvider != null ? contentPositionDataProvider.getContentTop() : getTop();
    }

    public OnPagerTitleChangeListener getOnPagerTitleChangeListener() {
        return this.mOnPagerTitleChangeListener;
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView
    public void onDeselected(int i, int i2) {
        OnPagerTitleChangeListener onPagerTitleChangeListener = this.mOnPagerTitleChangeListener;
        if (onPagerTitleChangeListener != null) {
            onPagerTitleChangeListener.onDeselected(i, i2);
        }
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView
    public void onEnter(int i, int i2, float f, boolean z) {
        OnPagerTitleChangeListener onPagerTitleChangeListener = this.mOnPagerTitleChangeListener;
        if (onPagerTitleChangeListener != null) {
            onPagerTitleChangeListener.onEnter(i, i2, f, z);
        }
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView
    public void onLeave(int i, int i2, float f, boolean z) {
        OnPagerTitleChangeListener onPagerTitleChangeListener = this.mOnPagerTitleChangeListener;
        if (onPagerTitleChangeListener != null) {
            onPagerTitleChangeListener.onLeave(i, i2, f, z);
        }
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView
    public void onSelected(int i, int i2) {
        OnPagerTitleChangeListener onPagerTitleChangeListener = this.mOnPagerTitleChangeListener;
        if (onPagerTitleChangeListener != null) {
            onPagerTitleChangeListener.onSelected(i, i2);
        }
    }

    public void setContentPositionDataProvider(ContentPositionDataProvider contentPositionDataProvider) {
        this.mContentPositionDataProvider = contentPositionDataProvider;
    }

    public void setContentView(View view) {
        setContentView(view, null);
    }

    public void setOnPagerTitleChangeListener(OnPagerTitleChangeListener onPagerTitleChangeListener) {
        this.mOnPagerTitleChangeListener = onPagerTitleChangeListener;
    }

    public void setContentView(View view, FrameLayout.LayoutParams layoutParams) {
        removeAllViews();
        if (view != null) {
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(-1, -1);
            }
            addView(view, layoutParams);
        }
    }

    public void setContentView(int i) {
        setContentView(LayoutInflater.from(getContext()).inflate(i, (ViewGroup) null), null);
    }
}
