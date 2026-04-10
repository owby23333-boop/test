package com.baidu.mobads.sdk.api;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.anythink.expressad.foundation.d.c;
import com.baidu.mobads.sdk.internal.ar;
import com.baidu.mobads.sdk.internal.bp;
import com.baidu.mobads.sdk.internal.w;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* JADX INFO: loaded from: classes2.dex */
public class FeedPortraitVideoView extends RelativeLayout {
    private static final String FEED_CLICK = "pauseBtnClick";
    private static final String PLAY_END = "playCompletion";
    private static final String PLAY_ERROR = "playError";
    private static final String PLAY_PAUSE = "playPause";
    private static final String PLAY_RESUME = "playResume";
    private static final String PLAY_START = "playRenderingStart";
    private static final String TAG = "FeedPortraitVideoView";
    private View mAdView;
    private IFeedPortraitListener mFeedVideoListener;
    private ClassLoader mLoader;
    private String mRemoteClassName;
    private Context mViewContext;
    private boolean useDownloadFrame;

    class InvocationHandlerImp implements InvocationHandler {
        InvocationHandlerImp() {
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            String name = method.getName();
            if (TextUtils.isEmpty(name)) {
                return null;
            }
            if (name.equals(FeedPortraitVideoView.PLAY_END)) {
                if (FeedPortraitVideoView.this.mFeedVideoListener != null) {
                    FeedPortraitVideoView.this.mFeedVideoListener.playCompletion();
                }
            } else if (name.equals(FeedPortraitVideoView.PLAY_ERROR)) {
                if (FeedPortraitVideoView.this.mFeedVideoListener != null) {
                    FeedPortraitVideoView.this.mFeedVideoListener.playError();
                }
            } else if (name.equals(FeedPortraitVideoView.PLAY_START)) {
                if (FeedPortraitVideoView.this.mFeedVideoListener != null) {
                    FeedPortraitVideoView.this.mFeedVideoListener.playRenderingStart();
                }
            } else if (name.equals(FeedPortraitVideoView.PLAY_PAUSE)) {
                if (FeedPortraitVideoView.this.mFeedVideoListener != null) {
                    FeedPortraitVideoView.this.mFeedVideoListener.playPause();
                }
            } else if (name.equals(FeedPortraitVideoView.PLAY_RESUME)) {
                if (FeedPortraitVideoView.this.mFeedVideoListener != null) {
                    FeedPortraitVideoView.this.mFeedVideoListener.playResume();
                }
            } else if (name.equals(FeedPortraitVideoView.FEED_CLICK) && FeedPortraitVideoView.this.mFeedVideoListener != null) {
                FeedPortraitVideoView.this.mFeedVideoListener.pauseBtnClick();
            }
            return null;
        }
    }

    public FeedPortraitVideoView(Context context) {
        this(context, null);
    }

    private void init(Context context) {
        this.mViewContext = context;
        Object[] objArr = {this.mViewContext};
        this.mLoader = bp.a(context);
        this.mAdView = (View) ar.a(this.mRemoteClassName, this.mLoader, (Class<?>[]) new Class[]{Context.class}, objArr);
        View view = this.mAdView;
        if (view != null) {
            addView(view, new RelativeLayout.LayoutParams(-1, -1));
        }
    }

    public long getCurrentPosition() {
        View view = this.mAdView;
        if (view != null) {
            return ((Long) ar.a(this.mRemoteClassName, view, this.mLoader, "getCurrentPosition", new Class[0], new Object[0])).longValue();
        }
        return 0L;
    }

    public long getDuration() {
        View view = this.mAdView;
        if (view != null) {
            return ((Long) ar.a(this.mRemoteClassName, view, this.mLoader, "getDuration", new Class[0], new Object[0])).longValue();
        }
        return 0L;
    }

    public void handleFeedCover(AbstractData abstractData) {
        View view = this.mAdView;
        if (view != null) {
            ar.a(this.mRemoteClassName, view, this.mLoader, "handleCover", new Class[]{Object.class}, abstractData);
        }
    }

    public void hideFeedCoverPic(AbstractData abstractData) {
        View view = this.mAdView;
        if (view != null) {
            ar.a(this.mRemoteClassName, view, this.mLoader, "hideFeedCoverPic", new Class[]{Object.class}, abstractData);
        }
    }

    public void hideFeedPauseBtn(AbstractData abstractData) {
        View view = this.mAdView;
        if (view != null) {
            ar.a(this.mRemoteClassName, view, this.mLoader, "hidePauseBtn", new Class[]{Object.class}, abstractData);
        }
    }

    public boolean isPlaying() {
        View view = this.mAdView;
        if (view != null) {
            Object objA = ar.a(this.mRemoteClassName, view, this.mLoader, "isPlaying", new Class[0], new Object[0]);
            if (objA instanceof Boolean) {
                return ((Boolean) objA).booleanValue();
            }
        }
        return false;
    }

    public boolean isShowEndFrame() {
        View view = this.mAdView;
        if (view != null) {
            return ((Boolean) ar.a(this.mRemoteClassName, view, this.mLoader, "isShowEndFrame", new Class[0], new Object[0])).booleanValue();
        }
        return false;
    }

    public void pause() {
        View view = this.mAdView;
        if (view != null) {
            ar.a(this.mRemoteClassName, view, this.mLoader, c.cb, new Class[0], new Object[0]);
        }
    }

    public void play() {
        View view = this.mAdView;
        if (view != null) {
            ar.a(this.mRemoteClassName, view, this.mLoader, "play", new Class[0], new Object[0]);
        }
    }

    public void resume() {
        View view = this.mAdView;
        if (view != null) {
            ar.a(this.mRemoteClassName, view, this.mLoader, c.cc, new Class[0], new Object[0]);
        }
    }

    public void seekTo(int i2) {
        View view = this.mAdView;
        if (view != null) {
            ar.a(this.mRemoteClassName, view, this.mLoader, "seekTo", new Class[]{Integer.TYPE}, Integer.valueOf(i2));
        }
    }

    public void setAdData(AbstractData abstractData) {
        View view;
        if (abstractData == null || (view = this.mAdView) == null) {
            return;
        }
        if (abstractData instanceof NativeCPUAdData) {
            ar.a(this.mRemoteClassName, view, this.mLoader, "setCpuAdData", new Class[]{Object.class}, abstractData);
        } else {
            ar.a(this.mRemoteClassName, view, this.mLoader, "setAdData", new Class[]{Object.class}, abstractData);
        }
    }

    public void setCanClickVideo(boolean z2) {
        View view = this.mAdView;
        if (view != null) {
            ar.a(this.mRemoteClassName, view, this.mLoader, "setCanClickVideo", new Class[]{Boolean.TYPE}, Boolean.valueOf(z2));
        }
    }

    public void setFeedPortraitListener(IFeedPortraitListener iFeedPortraitListener) {
        this.mFeedVideoListener = iFeedPortraitListener;
        try {
            Class<?> clsA = ar.a("com.component.feed.IFeedPortraitListener", this.mLoader);
            if (clsA != null) {
                Object objNewProxyInstance = Proxy.newProxyInstance(clsA.getClassLoader(), new Class[]{clsA}, new InvocationHandlerImp());
                if (this.mAdView != null) {
                    ar.a(this.mRemoteClassName, this.mAdView, this.mLoader, "setFeedPortraitListener", new Class[]{clsA}, objNewProxyInstance);
                }
            }
        } catch (Throwable unused) {
        }
    }

    public void setPlayBackSpeed(float f2) {
        View view = this.mAdView;
        if (view != null) {
            ar.a(this.mRemoteClassName, view, this.mLoader, "setPlayBackSpeed", new Class[]{Float.TYPE}, Float.valueOf(f2));
        }
    }

    public void setProgressBackgroundColor(int i2) {
        View view = this.mAdView;
        if (view != null) {
            ar.a(this.mRemoteClassName, view, this.mLoader, "setProgressBackgroundColor", new Class[]{Integer.TYPE}, Integer.valueOf(i2));
        }
    }

    public void setProgressBarColor(int i2) {
        View view = this.mAdView;
        if (view != null) {
            ar.a(this.mRemoteClassName, view, this.mLoader, "setProgressBarColor", new Class[]{Integer.TYPE}, Integer.valueOf(i2));
        }
    }

    public void setProgressHeightInDp(int i2) {
        View view = this.mAdView;
        if (view != null) {
            ar.a(this.mRemoteClassName, view, this.mLoader, "setProgressHeightDp", new Class[]{Integer.TYPE}, Integer.valueOf(i2));
        }
    }

    public void setShowProgress(boolean z2) {
        View view = this.mAdView;
        if (view != null) {
            ar.a(this.mRemoteClassName, view, this.mLoader, "setShowProgressBar", new Class[]{Boolean.TYPE}, Boolean.valueOf(z2));
        }
    }

    public void setUseDownloadFrame(boolean z2) {
        View view = this.mAdView;
        if (view != null) {
            ar.a(this.mRemoteClassName, view, this.mLoader, "setUseDownloadFrame", new Class[]{Boolean.TYPE}, Boolean.valueOf(z2));
        }
    }

    public void setVideoMute(boolean z2) {
        try {
            if (this.mAdView != null) {
                ar.a(this.mRemoteClassName, this.mAdView, this.mLoader, "userSetVideoMute", new Class[]{Boolean.TYPE}, Boolean.valueOf(z2));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void showFeedVideoCover(AbstractData abstractData) {
        View view = this.mAdView;
        if (view != null) {
            ar.a(this.mRemoteClassName, view, this.mLoader, "showFeedVideoCover", new Class[]{Object.class}, abstractData);
        }
    }

    public void showNormalPic(AbstractData abstractData) {
        View view;
        if (abstractData == null || (view = this.mAdView) == null) {
            return;
        }
        ar.a(this.mRemoteClassName, view, this.mLoader, "showNormalPic", new Class[]{Object.class}, abstractData);
    }

    public void stop() {
        View view = this.mAdView;
        if (view != null) {
            ar.a(this.mRemoteClassName, view, this.mLoader, "stop", new Class[0], new Object[0]);
        }
    }

    public void systemSetVideoMute(boolean z2) {
        try {
            if (this.mAdView != null) {
                ar.a(this.mRemoteClassName, this.mAdView, this.mLoader, "setVideoMute", new Class[]{Boolean.TYPE}, Boolean.valueOf(z2));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public FeedPortraitVideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FeedPortraitVideoView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mRemoteClassName = w.f13179d;
        this.useDownloadFrame = false;
        init(context);
    }
}
