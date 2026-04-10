package xyz.doikki.videoplayer.controller;

import android.content.Context;
import android.view.OrientationEventListener;

/* JADX INFO: loaded from: classes4.dex */
public class OrientationHelper extends OrientationEventListener {
    private long mLastTime;
    private OnOrientationChangeListener mOnOrientationChangeListener;

    public interface OnOrientationChangeListener {
        void onOrientationChanged(int i2);
    }

    public OrientationHelper(Context context) {
        super(context);
    }

    @Override // android.view.OrientationEventListener
    public void onOrientationChanged(int i2) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.mLastTime < 300) {
            return;
        }
        OnOrientationChangeListener onOrientationChangeListener = this.mOnOrientationChangeListener;
        if (onOrientationChangeListener != null) {
            onOrientationChangeListener.onOrientationChanged(i2);
        }
        this.mLastTime = jCurrentTimeMillis;
    }

    public void setOnOrientationChangeListener(OnOrientationChangeListener onOrientationChangeListener) {
        this.mOnOrientationChangeListener = onOrientationChangeListener;
    }
}
