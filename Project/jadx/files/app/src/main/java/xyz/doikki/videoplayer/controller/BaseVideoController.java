package xyz.doikki.videoplayer.controller;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import androidx.annotation.AttrRes;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import xyz.doikki.videoplayer.controller.OrientationHelper;
import xyz.doikki.videoplayer.player.VideoViewManager;
import xyz.doikki.videoplayer.util.CutoutUtil;
import xyz.doikki.videoplayer.util.L;
import xyz.doikki.videoplayer.util.PlayerUtils;

/* JADX INFO: loaded from: classes4.dex */
public abstract class BaseVideoController extends FrameLayout implements IVideoController, OrientationHelper.OnOrientationChangeListener {

    @Nullable
    protected Activity mActivity;
    private boolean mAdaptCutout;
    protected LinkedHashMap<IControlComponent, Boolean> mControlComponents;
    protected ControlWrapper mControlWrapper;
    private int mCutoutHeight;
    protected int mDefaultTimeout;
    private boolean mEnableOrientation;
    protected final Runnable mFadeOut;
    private Boolean mHasCutout;
    private Animation mHideAnim;
    protected boolean mIsLocked;
    private boolean mIsStartProgress;
    private int mOrientation;
    protected OrientationHelper mOrientationHelper;
    private Animation mShowAnim;
    protected Runnable mShowProgress;
    protected boolean mShowing;

    public BaseVideoController(@NonNull Context context) {
        this(context, null);
    }

    private void checkCutout() {
        if (this.mAdaptCutout) {
            Activity activity = this.mActivity;
            if (activity != null && this.mHasCutout == null) {
                this.mHasCutout = Boolean.valueOf(CutoutUtil.allowDisplayToCutout(activity));
                if (this.mHasCutout.booleanValue()) {
                    this.mCutoutHeight = (int) PlayerUtils.getStatusBarHeightPortrait(this.mActivity);
                }
            }
            L.d("hasCutout: " + this.mHasCutout + " cutout height: " + this.mCutoutHeight);
        }
    }

    private void handleLockStateChanged(boolean z2) {
        Iterator<Map.Entry<IControlComponent, Boolean>> it = this.mControlComponents.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getKey().onLockStateChanged(z2);
        }
        onLockStateChanged(z2);
    }

    private void handlePlayStateChanged(int i2) {
        Iterator<Map.Entry<IControlComponent, Boolean>> it = this.mControlComponents.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getKey().onPlayStateChanged(i2);
        }
        onPlayStateChanged(i2);
    }

    private void handlePlayerStateChanged(int i2) {
        Iterator<Map.Entry<IControlComponent, Boolean>> it = this.mControlComponents.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getKey().onPlayerStateChanged(i2);
        }
        onPlayerStateChanged(i2);
    }

    private void handleSetProgress(int i2, int i3) {
        Iterator<Map.Entry<IControlComponent, Boolean>> it = this.mControlComponents.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getKey().setProgress(i2, i3);
        }
        setProgress(i2, i3);
    }

    private void handleVisibilityChanged(boolean z2, Animation animation) {
        if (!this.mIsLocked) {
            Iterator<Map.Entry<IControlComponent, Boolean>> it = this.mControlComponents.entrySet().iterator();
            while (it.hasNext()) {
                it.next().getKey().onVisibilityChanged(z2, animation);
            }
        }
        onVisibilityChanged(z2, animation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int setProgress() {
        int currentPosition = (int) this.mControlWrapper.getCurrentPosition();
        handleSetProgress((int) this.mControlWrapper.getDuration(), currentPosition);
        return currentPosition;
    }

    public void addControlComponent(IControlComponent... iControlComponentArr) {
        for (IControlComponent iControlComponent : iControlComponentArr) {
            addControlComponent(iControlComponent, false);
        }
    }

    @Override // xyz.doikki.videoplayer.controller.IVideoController
    public int getCutoutHeight() {
        return this.mCutoutHeight;
    }

    protected abstract int getLayoutId();

    @Override // xyz.doikki.videoplayer.controller.IVideoController
    public boolean hasCutout() {
        Boolean bool = this.mHasCutout;
        return bool != null && bool.booleanValue();
    }

    @Override // xyz.doikki.videoplayer.controller.IVideoController
    public void hide() {
        if (this.mShowing) {
            stopFadeOut();
            handleVisibilityChanged(false, this.mHideAnim);
            this.mShowing = false;
        }
    }

    protected void initView() {
        if (getLayoutId() != 0) {
            LayoutInflater.from(getContext()).inflate(getLayoutId(), (ViewGroup) this, true);
        }
        this.mOrientationHelper = new OrientationHelper(getContext().getApplicationContext());
        this.mEnableOrientation = VideoViewManager.getConfig().mEnableOrientation;
        this.mAdaptCutout = VideoViewManager.getConfig().mAdaptCutout;
        this.mShowAnim = new AlphaAnimation(0.0f, 1.0f);
        this.mShowAnim.setDuration(300L);
        this.mHideAnim = new AlphaAnimation(1.0f, 0.0f);
        this.mHideAnim.setDuration(300L);
        this.mActivity = PlayerUtils.scanForActivity(getContext());
    }

    @Override // xyz.doikki.videoplayer.controller.IVideoController
    public boolean isLocked() {
        return this.mIsLocked;
    }

    @Override // xyz.doikki.videoplayer.controller.IVideoController
    public boolean isShowing() {
        return this.mShowing;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        checkCutout();
    }

    public boolean onBackPressed() {
        return false;
    }

    protected void onLockStateChanged(boolean z2) {
    }

    @Override // xyz.doikki.videoplayer.controller.OrientationHelper.OnOrientationChangeListener
    @CallSuper
    public void onOrientationChanged(int i2) {
        Activity activity = this.mActivity;
        if (activity == null || activity.isFinishing()) {
            return;
        }
        int i3 = this.mOrientation;
        if (i2 == -1) {
            this.mOrientation = -1;
            return;
        }
        if (i2 > 350 || i2 < 10) {
            if ((this.mActivity.getRequestedOrientation() == 0 && i3 == 0) || this.mOrientation == 0) {
                return;
            }
            this.mOrientation = 0;
            onOrientationPortrait(this.mActivity);
            return;
        }
        if (i2 > 80 && i2 < 100) {
            if ((this.mActivity.getRequestedOrientation() == 1 && i3 == 90) || this.mOrientation == 90) {
                return;
            }
            this.mOrientation = 90;
            onOrientationReverseLandscape(this.mActivity);
            return;
        }
        if (i2 <= 260 || i2 >= 280) {
            return;
        }
        if ((this.mActivity.getRequestedOrientation() == 1 && i3 == 270) || this.mOrientation == 270) {
            return;
        }
        this.mOrientation = SubsamplingScaleImageView.ORIENTATION_270;
        onOrientationLandscape(this.mActivity);
    }

    protected void onOrientationLandscape(Activity activity) {
        activity.setRequestedOrientation(0);
        if (this.mControlWrapper.isFullScreen()) {
            handlePlayerStateChanged(11);
        } else {
            this.mControlWrapper.startFullScreen();
        }
    }

    protected void onOrientationPortrait(Activity activity) {
        if (!this.mIsLocked && this.mEnableOrientation) {
            activity.setRequestedOrientation(1);
            this.mControlWrapper.stopFullScreen();
        }
    }

    protected void onOrientationReverseLandscape(Activity activity) {
        activity.setRequestedOrientation(8);
        if (this.mControlWrapper.isFullScreen()) {
            handlePlayerStateChanged(11);
        } else {
            this.mControlWrapper.startFullScreen();
        }
    }

    @CallSuper
    protected void onPlayStateChanged(int i2) {
        if (i2 == -1) {
            this.mShowing = false;
            return;
        }
        if (i2 != 0) {
            if (i2 != 5) {
                return;
            }
            this.mIsLocked = false;
            this.mShowing = false;
            return;
        }
        this.mOrientationHelper.disable();
        this.mOrientation = 0;
        this.mIsLocked = false;
        this.mShowing = false;
        removeAllDissociateComponents();
    }

    @CallSuper
    protected void onPlayerStateChanged(int i2) {
        switch (i2) {
            case 10:
                if (this.mEnableOrientation) {
                    this.mOrientationHelper.enable();
                } else {
                    this.mOrientationHelper.disable();
                }
                if (hasCutout()) {
                    CutoutUtil.adaptCutoutAboveAndroidP(getContext(), false);
                }
                break;
            case 11:
                this.mOrientationHelper.enable();
                if (hasCutout()) {
                    CutoutUtil.adaptCutoutAboveAndroidP(getContext(), true);
                }
                break;
            case 12:
                this.mOrientationHelper.disable();
                break;
        }
    }

    protected void onVisibilityChanged(boolean z2, Animation animation) {
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z2) {
        super.onWindowFocusChanged(z2);
        if (this.mControlWrapper.isPlaying()) {
            if (this.mEnableOrientation || this.mControlWrapper.isFullScreen()) {
                if (z2) {
                    postDelayed(new Runnable() { // from class: xyz.doikki.videoplayer.controller.BaseVideoController.3
                        @Override // java.lang.Runnable
                        public void run() {
                            BaseVideoController.this.mOrientationHelper.enable();
                        }
                    }, 800L);
                } else {
                    this.mOrientationHelper.disable();
                }
            }
        }
    }

    public void removeAllControlComponent() {
        Iterator<Map.Entry<IControlComponent, Boolean>> it = this.mControlComponents.entrySet().iterator();
        while (it.hasNext()) {
            removeView(it.next().getKey().getView());
        }
        this.mControlComponents.clear();
    }

    public void removeAllDissociateComponents() {
        Iterator<Map.Entry<IControlComponent, Boolean>> it = this.mControlComponents.entrySet().iterator();
        while (it.hasNext()) {
            if (it.next().getValue().booleanValue()) {
                it.remove();
            }
        }
    }

    public void removeControlComponent(IControlComponent iControlComponent) {
        removeView(iControlComponent.getView());
        this.mControlComponents.remove(iControlComponent);
    }

    public void setAdaptCutout(boolean z2) {
        this.mAdaptCutout = z2;
    }

    public void setDismissTimeout(int i2) {
        if (i2 > 0) {
            this.mDefaultTimeout = i2;
        }
    }

    public void setEnableOrientation(boolean z2) {
        this.mEnableOrientation = z2;
    }

    @Override // xyz.doikki.videoplayer.controller.IVideoController
    public void setLocked(boolean z2) {
        this.mIsLocked = z2;
        handleLockStateChanged(z2);
    }

    @CallSuper
    public void setMediaPlayer(MediaPlayerControl mediaPlayerControl) {
        this.mControlWrapper = new ControlWrapper(mediaPlayerControl, this);
        Iterator<Map.Entry<IControlComponent, Boolean>> it = this.mControlComponents.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getKey().attach(this.mControlWrapper);
        }
        this.mOrientationHelper.setOnOrientationChangeListener(this);
    }

    @CallSuper
    public void setPlayState(int i2) {
        handlePlayStateChanged(i2);
    }

    @CallSuper
    public void setPlayerState(int i2) {
        handlePlayerStateChanged(i2);
    }

    protected void setProgress(int i2, int i3) {
    }

    @Override // xyz.doikki.videoplayer.controller.IVideoController
    public void show() {
        if (this.mShowing) {
            return;
        }
        handleVisibilityChanged(true, this.mShowAnim);
        startFadeOut();
        this.mShowing = true;
    }

    public boolean showNetWarning() {
        return PlayerUtils.getNetworkType(getContext()) == 4 && !VideoViewManager.instance().playOnMobileNetwork();
    }

    @Override // xyz.doikki.videoplayer.controller.IVideoController
    public void startFadeOut() {
        stopFadeOut();
        postDelayed(this.mFadeOut, this.mDefaultTimeout);
    }

    protected boolean startFullScreen() {
        Activity activity = this.mActivity;
        if (activity == null || activity.isFinishing()) {
            return false;
        }
        this.mActivity.setRequestedOrientation(0);
        this.mControlWrapper.startFullScreen();
        return true;
    }

    @Override // xyz.doikki.videoplayer.controller.IVideoController
    public void startProgress() {
        if (this.mIsStartProgress) {
            return;
        }
        post(this.mShowProgress);
        this.mIsStartProgress = true;
    }

    @Override // xyz.doikki.videoplayer.controller.IVideoController
    public void stopFadeOut() {
        removeCallbacks(this.mFadeOut);
    }

    protected boolean stopFullScreen() {
        Activity activity = this.mActivity;
        if (activity == null || activity.isFinishing()) {
            return false;
        }
        this.mActivity.setRequestedOrientation(1);
        this.mControlWrapper.stopFullScreen();
        return true;
    }

    @Override // xyz.doikki.videoplayer.controller.IVideoController
    public void stopProgress() {
        if (this.mIsStartProgress) {
            removeCallbacks(this.mShowProgress);
            this.mIsStartProgress = false;
        }
    }

    protected void toggleFullScreen() {
        this.mControlWrapper.toggleFullScreen(this.mActivity);
    }

    protected void togglePlay() {
        this.mControlWrapper.togglePlay();
    }

    public BaseVideoController(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BaseVideoController(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i2) {
        super(context, attributeSet, i2);
        this.mDefaultTimeout = 4000;
        this.mControlComponents = new LinkedHashMap<>();
        this.mFadeOut = new Runnable() { // from class: xyz.doikki.videoplayer.controller.BaseVideoController.1
            @Override // java.lang.Runnable
            public void run() {
                BaseVideoController.this.hide();
            }
        };
        this.mShowProgress = new Runnable() { // from class: xyz.doikki.videoplayer.controller.BaseVideoController.2
            @Override // java.lang.Runnable
            public void run() {
                int progress = BaseVideoController.this.setProgress();
                if (!BaseVideoController.this.mControlWrapper.isPlaying()) {
                    BaseVideoController.this.mIsStartProgress = false;
                } else {
                    BaseVideoController baseVideoController = BaseVideoController.this;
                    baseVideoController.postDelayed(this, (long) ((1000 - (progress % 1000)) / baseVideoController.mControlWrapper.getSpeed()));
                }
            }
        };
        this.mOrientation = 0;
        initView();
    }

    public void addControlComponent(IControlComponent iControlComponent, boolean z2) {
        this.mControlComponents.put(iControlComponent, Boolean.valueOf(z2));
        ControlWrapper controlWrapper = this.mControlWrapper;
        if (controlWrapper != null) {
            iControlComponent.attach(controlWrapper);
        }
        View view = iControlComponent.getView();
        if (view == null || z2) {
            return;
        }
        addView(view, 0);
    }
}
