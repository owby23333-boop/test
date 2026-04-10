package xyz.doikki.videoplayer.player;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import cn.bmob.v3.util.BmobDbOpenHelper;
import com.anythink.expressad.exoplayer.j.y;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import xyz.doikki.videoplayer.controller.BaseVideoController;
import xyz.doikki.videoplayer.controller.MediaPlayerControl;
import xyz.doikki.videoplayer.player.AbstractPlayer;
import xyz.doikki.videoplayer.render.IRenderView;
import xyz.doikki.videoplayer.render.RenderViewFactory;
import xyz.doikki.videoplayer.util.L;
import xyz.doikki.videoplayer.util.PlayerUtils;

/* JADX INFO: loaded from: classes4.dex */
public class BaseVideoView<P extends AbstractPlayer> extends FrameLayout implements MediaPlayerControl, AbstractPlayer.PlayerEventListener {
    public static final int PLAYER_FULL_SCREEN = 11;
    public static final int PLAYER_NORMAL = 10;
    public static final int PLAYER_TINY_SCREEN = 12;
    public static final int SCREEN_SCALE_16_9 = 1;
    public static final int SCREEN_SCALE_4_3 = 2;
    public static final int SCREEN_SCALE_CENTER_CROP = 5;
    public static final int SCREEN_SCALE_DEFAULT = 0;
    public static final int SCREEN_SCALE_MATCH_PARENT = 3;
    public static final int SCREEN_SCALE_ORIGINAL = 4;
    public static final int STATE_BUFFERED = 7;
    public static final int STATE_BUFFERING = 6;
    public static final int STATE_ERROR = -1;
    public static final int STATE_IDLE = 0;
    public static final int STATE_PAUSED = 4;
    public static final int STATE_PLAYBACK_COMPLETED = 5;
    public static final int STATE_PLAYING = 3;
    public static final int STATE_PREPARED = 2;
    public static final int STATE_PREPARING = 1;
    public static final int STATE_START_ABORT = 8;
    protected AssetFileDescriptor mAssetFileDescriptor;

    @Nullable
    protected AudioFocusHelper mAudioFocusHelper;
    protected int mCurrentPlayState;
    protected int mCurrentPlayerState;
    protected long mCurrentPosition;
    protected int mCurrentScreenScaleType;
    protected boolean mEnableAudioFocus;
    protected Map<String, String> mHeaders;
    protected boolean mIsFullScreen;
    protected boolean mIsLooping;
    protected boolean mIsMute;
    protected boolean mIsTinyScreen;
    protected P mMediaPlayer;
    protected List<OnStateChangeListener> mOnStateChangeListeners;
    private final int mPlayerBackgroundColor;
    protected FrameLayout mPlayerContainer;
    protected PlayerFactory<P> mPlayerFactory;

    @Nullable
    protected ProgressManager mProgressManager;
    protected IRenderView mRenderView;
    protected RenderViewFactory mRenderViewFactory;
    protected int[] mTinyScreenSize;
    protected String mUrl;

    @Nullable
    protected BaseVideoController mVideoController;
    protected int[] mVideoSize;

    public interface OnStateChangeListener {
        void onPlayStateChanged(int i2);

        void onPlayerStateChanged(int i2);
    }

    public static class SimpleOnStateChangeListener implements OnStateChangeListener {
        @Override // xyz.doikki.videoplayer.player.BaseVideoView.OnStateChangeListener
        public void onPlayStateChanged(int i2) {
        }

        @Override // xyz.doikki.videoplayer.player.BaseVideoView.OnStateChangeListener
        public void onPlayerStateChanged(int i2) {
        }
    }

    public BaseVideoView(@NonNull Context context) {
        this(context, null);
    }

    private void hideSysBar(ViewGroup viewGroup) {
        int systemUiVisibility = viewGroup.getSystemUiVisibility() | 2;
        if (Build.VERSION.SDK_INT >= 19) {
            systemUiVisibility |= 4096;
        }
        viewGroup.setSystemUiVisibility(systemUiVisibility);
        getActivity().getWindow().setFlags(1024, 1024);
    }

    private boolean isInStartAbortState() {
        return this.mCurrentPlayState == 8;
    }

    private void showSysBar(ViewGroup viewGroup) {
        int systemUiVisibility = viewGroup.getSystemUiVisibility() & (-3);
        if (Build.VERSION.SDK_INT >= 19) {
            systemUiVisibility &= -4097;
        }
        viewGroup.setSystemUiVisibility(systemUiVisibility);
        getActivity().getWindow().clearFlags(1024);
    }

    protected void addDisplay() {
        IRenderView iRenderView = this.mRenderView;
        if (iRenderView != null) {
            this.mPlayerContainer.removeView(iRenderView.getView());
            this.mRenderView.release();
        }
        this.mRenderView = this.mRenderViewFactory.createRenderView(getContext());
        this.mRenderView.attachToPlayer(this.mMediaPlayer);
        this.mPlayerContainer.addView(this.mRenderView.getView(), 0, new FrameLayout.LayoutParams(-1, -1, 17));
    }

    public void addOnStateChangeListener(@NonNull OnStateChangeListener onStateChangeListener) {
        if (this.mOnStateChangeListeners == null) {
            this.mOnStateChangeListeners = new ArrayList();
        }
        this.mOnStateChangeListeners.add(onStateChangeListener);
    }

    public void clearOnStateChangeListeners() {
        List<OnStateChangeListener> list = this.mOnStateChangeListeners;
        if (list != null) {
            list.clear();
        }
    }

    @Override // xyz.doikki.videoplayer.controller.MediaPlayerControl
    public Bitmap doScreenShot() {
        IRenderView iRenderView = this.mRenderView;
        if (iRenderView != null) {
            return iRenderView.doScreenShot();
        }
        return null;
    }

    protected Activity getActivity() {
        BaseVideoController baseVideoController = this.mVideoController;
        if (baseVideoController == null) {
            return PlayerUtils.scanForActivity(getContext());
        }
        Activity activityScanForActivity = PlayerUtils.scanForActivity(baseVideoController.getContext());
        return activityScanForActivity == null ? PlayerUtils.scanForActivity(getContext()) : activityScanForActivity;
    }

    @Override // xyz.doikki.videoplayer.controller.MediaPlayerControl
    public int getBufferedPercentage() {
        P p2 = this.mMediaPlayer;
        if (p2 != null) {
            return p2.getBufferedPercentage();
        }
        return 0;
    }

    protected ViewGroup getContentView() {
        Activity activity = getActivity();
        if (activity == null) {
            return null;
        }
        return (ViewGroup) activity.findViewById(R.id.content);
    }

    public int getCurrentPlayState() {
        return this.mCurrentPlayState;
    }

    public int getCurrentPlayerState() {
        return this.mCurrentPlayerState;
    }

    @Override // xyz.doikki.videoplayer.controller.MediaPlayerControl
    public long getCurrentPosition() {
        if (!isInPlaybackState()) {
            return 0L;
        }
        this.mCurrentPosition = this.mMediaPlayer.getCurrentPosition();
        return this.mCurrentPosition;
    }

    protected ViewGroup getDecorView() {
        Activity activity = getActivity();
        if (activity == null) {
            return null;
        }
        return (ViewGroup) activity.getWindow().getDecorView();
    }

    @Override // xyz.doikki.videoplayer.controller.MediaPlayerControl
    public long getDuration() {
        if (isInPlaybackState()) {
            return this.mMediaPlayer.getDuration();
        }
        return 0L;
    }

    @Override // xyz.doikki.videoplayer.controller.MediaPlayerControl
    public float getSpeed() {
        if (isInPlaybackState()) {
            return this.mMediaPlayer.getSpeed();
        }
        return 1.0f;
    }

    @Override // xyz.doikki.videoplayer.controller.MediaPlayerControl
    public long getTcpSpeed() {
        P p2 = this.mMediaPlayer;
        if (p2 != null) {
            return p2.getTcpSpeed();
        }
        return 0L;
    }

    @Override // xyz.doikki.videoplayer.controller.MediaPlayerControl
    public int[] getVideoSize() {
        return this.mVideoSize;
    }

    protected void initPlayer() {
        this.mMediaPlayer = (P) this.mPlayerFactory.createPlayer(getContext());
        this.mMediaPlayer.setPlayerEventListener(this);
        setInitOptions();
        this.mMediaPlayer.initPlayer();
        setOptions();
    }

    protected void initView() {
        this.mPlayerContainer = new FrameLayout(getContext());
        this.mPlayerContainer.setBackgroundColor(this.mPlayerBackgroundColor);
        addView(this.mPlayerContainer, new FrameLayout.LayoutParams(-1, -1));
    }

    @Override // xyz.doikki.videoplayer.controller.MediaPlayerControl
    public boolean isFullScreen() {
        return this.mIsFullScreen;
    }

    protected boolean isInIdleState() {
        return this.mCurrentPlayState == 0;
    }

    protected boolean isInPlaybackState() {
        int i2;
        return (this.mMediaPlayer == null || (i2 = this.mCurrentPlayState) == -1 || i2 == 0 || i2 == 1 || i2 == 8 || i2 == 5) ? false : true;
    }

    protected boolean isLocalDataSource() {
        if (this.mAssetFileDescriptor != null) {
            return true;
        }
        if (TextUtils.isEmpty(this.mUrl)) {
            return false;
        }
        Uri uri = Uri.parse(this.mUrl);
        return "android.resource".equals(uri.getScheme()) || BmobDbOpenHelper.FILE.equals(uri.getScheme()) || y.a.equals(uri.getScheme());
    }

    @Override // xyz.doikki.videoplayer.controller.MediaPlayerControl
    public boolean isMute() {
        return this.mIsMute;
    }

    @Override // xyz.doikki.videoplayer.controller.MediaPlayerControl
    public boolean isPlaying() {
        return isInPlaybackState() && this.mMediaPlayer.isPlaying();
    }

    @Override // xyz.doikki.videoplayer.controller.MediaPlayerControl
    public boolean isTinyScreen() {
        return this.mIsTinyScreen;
    }

    public boolean onBackPressed() {
        BaseVideoController baseVideoController = this.mVideoController;
        return baseVideoController != null && baseVideoController.onBackPressed();
    }

    @Override // xyz.doikki.videoplayer.player.AbstractPlayer.PlayerEventListener
    public void onCompletion() {
        this.mPlayerContainer.setKeepScreenOn(false);
        this.mCurrentPosition = 0L;
        ProgressManager progressManager = this.mProgressManager;
        if (progressManager != null) {
            progressManager.saveProgress(this.mUrl, 0L);
        }
        setPlayState(5);
    }

    @Override // xyz.doikki.videoplayer.player.AbstractPlayer.PlayerEventListener
    public void onError() {
        this.mPlayerContainer.setKeepScreenOn(false);
        setPlayState(-1);
    }

    @Override // xyz.doikki.videoplayer.player.AbstractPlayer.PlayerEventListener
    public void onInfo(int i2, int i3) {
        if (i2 == 3) {
            setPlayState(3);
            this.mPlayerContainer.setKeepScreenOn(true);
            return;
        }
        if (i2 == 10001) {
            IRenderView iRenderView = this.mRenderView;
            if (iRenderView != null) {
                iRenderView.setVideoRotation(i3);
                return;
            }
            return;
        }
        if (i2 == 701) {
            setPlayState(6);
        } else {
            if (i2 != 702) {
                return;
            }
            setPlayState(7);
        }
    }

    @Override // xyz.doikki.videoplayer.player.AbstractPlayer.PlayerEventListener
    public void onPrepared() {
        AudioFocusHelper audioFocusHelper;
        setPlayState(2);
        if (!isMute() && (audioFocusHelper = this.mAudioFocusHelper) != null) {
            audioFocusHelper.requestFocus();
        }
        long j2 = this.mCurrentPosition;
        if (j2 > 0) {
            seekTo(j2);
        }
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        L.d("onSaveInstanceState: " + this.mCurrentPosition);
        saveProgress();
        return super.onSaveInstanceState();
    }

    @Override // xyz.doikki.videoplayer.player.AbstractPlayer.PlayerEventListener
    public void onVideoSizeChanged(int i2, int i3) {
        int[] iArr = this.mVideoSize;
        iArr[0] = i2;
        iArr[1] = i3;
        IRenderView iRenderView = this.mRenderView;
        if (iRenderView != null) {
            iRenderView.setScaleType(this.mCurrentScreenScaleType);
            this.mRenderView.setVideoSize(i2, i3);
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z2) {
        super.onWindowFocusChanged(z2);
        if (z2 && this.mIsFullScreen) {
            hideSysBar(getDecorView());
        }
    }

    @Override // xyz.doikki.videoplayer.controller.MediaPlayerControl
    public void pause() {
        if (isInPlaybackState() && this.mMediaPlayer.isPlaying()) {
            this.mMediaPlayer.pause();
            setPlayState(4);
            if (this.mAudioFocusHelper != null && !isMute()) {
                this.mAudioFocusHelper.abandonFocus();
            }
            this.mPlayerContainer.setKeepScreenOn(false);
        }
    }

    protected boolean prepareDataSource() {
        AssetFileDescriptor assetFileDescriptor = this.mAssetFileDescriptor;
        if (assetFileDescriptor != null) {
            this.mMediaPlayer.setDataSource(assetFileDescriptor);
            return true;
        }
        if (TextUtils.isEmpty(this.mUrl)) {
            return false;
        }
        this.mMediaPlayer.setDataSource(this.mUrl, this.mHeaders);
        return true;
    }

    public void release() {
        if (isInIdleState()) {
            return;
        }
        P p2 = this.mMediaPlayer;
        if (p2 != null) {
            p2.release();
            this.mMediaPlayer = null;
        }
        IRenderView iRenderView = this.mRenderView;
        if (iRenderView != null) {
            this.mPlayerContainer.removeView(iRenderView.getView());
            this.mRenderView.release();
            this.mRenderView = null;
        }
        AssetFileDescriptor assetFileDescriptor = this.mAssetFileDescriptor;
        if (assetFileDescriptor != null) {
            try {
                assetFileDescriptor.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
        AudioFocusHelper audioFocusHelper = this.mAudioFocusHelper;
        if (audioFocusHelper != null) {
            audioFocusHelper.abandonFocus();
            this.mAudioFocusHelper = null;
        }
        this.mPlayerContainer.setKeepScreenOn(false);
        saveProgress();
        this.mCurrentPosition = 0L;
        setPlayState(0);
    }

    public void removeOnStateChangeListener(@NonNull OnStateChangeListener onStateChangeListener) {
        List<OnStateChangeListener> list = this.mOnStateChangeListeners;
        if (list != null) {
            list.remove(onStateChangeListener);
        }
    }

    @Override // xyz.doikki.videoplayer.controller.MediaPlayerControl
    public void replay(boolean z2) {
        if (z2) {
            this.mCurrentPosition = 0L;
        }
        addDisplay();
        startPrepare(true);
    }

    public void resume() {
        if (!isInPlaybackState() || this.mMediaPlayer.isPlaying()) {
            return;
        }
        this.mMediaPlayer.start();
        setPlayState(3);
        if (this.mAudioFocusHelper != null && !isMute()) {
            this.mAudioFocusHelper.requestFocus();
        }
        this.mPlayerContainer.setKeepScreenOn(true);
    }

    protected void saveProgress() {
        if (this.mProgressManager == null || this.mCurrentPosition <= 0) {
            return;
        }
        L.d("saveProgress: " + this.mCurrentPosition);
        this.mProgressManager.saveProgress(this.mUrl, this.mCurrentPosition);
    }

    @Override // xyz.doikki.videoplayer.controller.MediaPlayerControl
    public void seekTo(long j2) {
        if (isInPlaybackState()) {
            this.mMediaPlayer.seekTo(j2);
        }
    }

    public void setAssetFileDescriptor(AssetFileDescriptor assetFileDescriptor) {
        this.mUrl = null;
        this.mAssetFileDescriptor = assetFileDescriptor;
    }

    public void setEnableAudioFocus(boolean z2) {
        this.mEnableAudioFocus = z2;
    }

    protected void setInitOptions() {
    }

    public void setLooping(boolean z2) {
        this.mIsLooping = z2;
        P p2 = this.mMediaPlayer;
        if (p2 != null) {
            p2.setLooping(z2);
        }
    }

    @Override // xyz.doikki.videoplayer.controller.MediaPlayerControl
    public void setMirrorRotation(boolean z2) {
        IRenderView iRenderView = this.mRenderView;
        if (iRenderView != null) {
            iRenderView.getView().setScaleX(z2 ? -1.0f : 1.0f);
        }
    }

    @Override // xyz.doikki.videoplayer.controller.MediaPlayerControl
    public void setMute(boolean z2) {
        this.mIsMute = z2;
        if (this.mMediaPlayer != null) {
            float f2 = z2 ? 0.0f : 1.0f;
            this.mMediaPlayer.setVolume(f2, f2);
        }
    }

    public void setOnStateChangeListener(@NonNull OnStateChangeListener onStateChangeListener) {
        List<OnStateChangeListener> list = this.mOnStateChangeListeners;
        if (list == null) {
            this.mOnStateChangeListeners = new ArrayList();
        } else {
            list.clear();
        }
        this.mOnStateChangeListeners.add(onStateChangeListener);
    }

    protected void setOptions() {
        this.mMediaPlayer.setLooping(this.mIsLooping);
        float f2 = this.mIsMute ? 0.0f : 1.0f;
        this.mMediaPlayer.setVolume(f2, f2);
    }

    protected void setPlayState(int i2) {
        this.mCurrentPlayState = i2;
        BaseVideoController baseVideoController = this.mVideoController;
        if (baseVideoController != null) {
            baseVideoController.setPlayState(i2);
        }
        List<OnStateChangeListener> list = this.mOnStateChangeListeners;
        if (list != null) {
            for (OnStateChangeListener onStateChangeListener : PlayerUtils.getSnapshot(list)) {
                if (onStateChangeListener != null) {
                    onStateChangeListener.onPlayStateChanged(i2);
                }
            }
        }
    }

    public void setPlayerBackgroundColor(int i2) {
        this.mPlayerContainer.setBackgroundColor(i2);
    }

    public void setPlayerFactory(PlayerFactory playerFactory) {
        if (playerFactory == null) {
            throw new IllegalArgumentException("PlayerFactory can not be null!");
        }
        this.mPlayerFactory = playerFactory;
    }

    protected void setPlayerState(int i2) {
        this.mCurrentPlayerState = i2;
        BaseVideoController baseVideoController = this.mVideoController;
        if (baseVideoController != null) {
            baseVideoController.setPlayerState(i2);
        }
        List<OnStateChangeListener> list = this.mOnStateChangeListeners;
        if (list != null) {
            for (OnStateChangeListener onStateChangeListener : PlayerUtils.getSnapshot(list)) {
                if (onStateChangeListener != null) {
                    onStateChangeListener.onPlayerStateChanged(i2);
                }
            }
        }
    }

    public void setProgressManager(@Nullable ProgressManager progressManager) {
        this.mProgressManager = progressManager;
    }

    public void setRenderViewFactory(RenderViewFactory renderViewFactory) {
        if (renderViewFactory == null) {
            throw new IllegalArgumentException("RenderViewFactory can not be null!");
        }
        this.mRenderViewFactory = renderViewFactory;
    }

    @Override // android.view.View, xyz.doikki.videoplayer.controller.MediaPlayerControl
    public void setRotation(float f2) {
        IRenderView iRenderView = this.mRenderView;
        if (iRenderView != null) {
            iRenderView.setVideoRotation((int) f2);
        }
    }

    @Override // xyz.doikki.videoplayer.controller.MediaPlayerControl
    public void setScreenScaleType(int i2) {
        this.mCurrentScreenScaleType = i2;
        IRenderView iRenderView = this.mRenderView;
        if (iRenderView != null) {
            iRenderView.setScaleType(i2);
        }
    }

    @Override // xyz.doikki.videoplayer.controller.MediaPlayerControl
    public void setSpeed(float f2) {
        if (isInPlaybackState()) {
            this.mMediaPlayer.setSpeed(f2);
        }
    }

    public void setTinyScreenSize(int[] iArr) {
        this.mTinyScreenSize = iArr;
    }

    public void setUrl(String str) {
        setUrl(str, null);
    }

    public void setVideoController(@Nullable BaseVideoController baseVideoController) {
        this.mPlayerContainer.removeView(this.mVideoController);
        this.mVideoController = baseVideoController;
        if (baseVideoController != null) {
            baseVideoController.setMediaPlayer(this);
            this.mPlayerContainer.addView(this.mVideoController, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public void setVolume(float f2, float f3) {
        P p2 = this.mMediaPlayer;
        if (p2 != null) {
            p2.setVolume(f2, f3);
        }
    }

    protected boolean showNetWarning() {
        BaseVideoController baseVideoController;
        return (isLocalDataSource() || (baseVideoController = this.mVideoController) == null || !baseVideoController.showNetWarning()) ? false : true;
    }

    public void skipPositionWhenPlay(int i2) {
        this.mCurrentPosition = i2;
    }

    @Override // xyz.doikki.videoplayer.controller.MediaPlayerControl
    public void start() {
        if (isInIdleState() || isInStartAbortState()) {
            startPlay();
        } else if (isInPlaybackState()) {
            startInPlaybackState();
        }
    }

    @Override // xyz.doikki.videoplayer.controller.MediaPlayerControl
    public void startFullScreen() {
        ViewGroup decorView;
        if (this.mIsFullScreen || (decorView = getDecorView()) == null) {
            return;
        }
        this.mIsFullScreen = true;
        hideSysBar(decorView);
        removeView(this.mPlayerContainer);
        decorView.addView(this.mPlayerContainer);
        setPlayerState(11);
    }

    protected void startInPlaybackState() {
        this.mMediaPlayer.start();
        setPlayState(3);
        if (this.mAudioFocusHelper != null && !isMute()) {
            this.mAudioFocusHelper.requestFocus();
        }
        this.mPlayerContainer.setKeepScreenOn(true);
    }

    protected boolean startPlay() {
        if (showNetWarning()) {
            setPlayState(8);
            return false;
        }
        if (this.mEnableAudioFocus) {
            this.mAudioFocusHelper = new AudioFocusHelper(this);
        }
        ProgressManager progressManager = this.mProgressManager;
        if (progressManager != null) {
            this.mCurrentPosition = progressManager.getSavedProgress(this.mUrl);
        }
        initPlayer();
        addDisplay();
        startPrepare(false);
        return true;
    }

    protected void startPrepare(boolean z2) {
        if (z2) {
            this.mMediaPlayer.reset();
            setOptions();
        }
        if (prepareDataSource()) {
            this.mMediaPlayer.prepareAsync();
            setPlayState(1);
            setPlayerState(isFullScreen() ? 11 : isTinyScreen() ? 12 : 10);
        }
    }

    @Override // xyz.doikki.videoplayer.controller.MediaPlayerControl
    public void startTinyScreen() {
        ViewGroup contentView;
        if (this.mIsTinyScreen || (contentView = getContentView()) == null) {
            return;
        }
        removeView(this.mPlayerContainer);
        int screenWidth = this.mTinyScreenSize[0];
        if (screenWidth <= 0) {
            screenWidth = PlayerUtils.getScreenWidth(getContext(), false) / 2;
        }
        int i2 = this.mTinyScreenSize[1];
        if (i2 <= 0) {
            i2 = (screenWidth * 9) / 16;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(screenWidth, i2);
        layoutParams.gravity = 8388693;
        contentView.addView(this.mPlayerContainer, layoutParams);
        this.mIsTinyScreen = true;
        setPlayerState(12);
    }

    @Override // xyz.doikki.videoplayer.controller.MediaPlayerControl
    public void stopFullScreen() {
        ViewGroup decorView;
        if (this.mIsFullScreen && (decorView = getDecorView()) != null) {
            this.mIsFullScreen = false;
            showSysBar(decorView);
            decorView.removeView(this.mPlayerContainer);
            addView(this.mPlayerContainer);
            setPlayerState(10);
        }
    }

    @Override // xyz.doikki.videoplayer.controller.MediaPlayerControl
    public void stopTinyScreen() {
        ViewGroup contentView;
        if (this.mIsTinyScreen && (contentView = getContentView()) != null) {
            contentView.removeView(this.mPlayerContainer);
            addView(this.mPlayerContainer, new FrameLayout.LayoutParams(-1, -1));
            this.mIsTinyScreen = false;
            setPlayerState(10);
        }
    }

    public BaseVideoView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setUrl(String str, Map<String, String> map) {
        this.mAssetFileDescriptor = null;
        this.mUrl = str;
        this.mHeaders = map;
    }

    public BaseVideoView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mVideoSize = new int[]{0, 0};
        this.mCurrentPlayState = 0;
        this.mCurrentPlayerState = 10;
        this.mTinyScreenSize = new int[]{0, 0};
        VideoViewConfig config = VideoViewManager.getConfig();
        this.mEnableAudioFocus = config.mEnableAudioFocus;
        this.mProgressManager = config.mProgressManager;
        this.mPlayerFactory = config.mPlayerFactory;
        this.mCurrentScreenScaleType = config.mScreenScaleType;
        this.mRenderViewFactory = config.mRenderViewFactory;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, xyz.doikki.videoplayer.R.styleable.BaseVideoView);
        this.mEnableAudioFocus = typedArrayObtainStyledAttributes.getBoolean(xyz.doikki.videoplayer.R.styleable.BaseVideoView_enableAudioFocus, this.mEnableAudioFocus);
        this.mIsLooping = typedArrayObtainStyledAttributes.getBoolean(xyz.doikki.videoplayer.R.styleable.BaseVideoView_looping, false);
        this.mCurrentScreenScaleType = typedArrayObtainStyledAttributes.getInt(xyz.doikki.videoplayer.R.styleable.BaseVideoView_screenScaleType, this.mCurrentScreenScaleType);
        this.mPlayerBackgroundColor = typedArrayObtainStyledAttributes.getColor(xyz.doikki.videoplayer.R.styleable.BaseVideoView_playerBackgroundColor, -16777216);
        typedArrayObtainStyledAttributes.recycle();
        initView();
    }
}
