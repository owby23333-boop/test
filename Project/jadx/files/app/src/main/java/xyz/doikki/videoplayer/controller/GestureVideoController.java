package xyz.doikki.videoplayer.controller;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.anythink.expressad.exoplayer.k.o;
import java.util.Iterator;
import java.util.Map;
import xyz.doikki.videoplayer.util.PlayerUtils;

/* JADX INFO: loaded from: classes4.dex */
public abstract class GestureVideoController extends BaseVideoController implements GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener, View.OnTouchListener {
    private AudioManager mAudioManager;
    private float mBrightness;
    private boolean mCanChangePosition;
    private boolean mCanSlide;
    private boolean mChangeBrightness;
    private boolean mChangePosition;
    private boolean mChangeVolume;
    private int mCurPlayState;
    private boolean mEnableInNormal;
    private boolean mFirstTouch;
    private GestureDetector mGestureDetector;
    private boolean mIsDoubleTapTogglePlayEnabled;
    private boolean mIsGestureEnabled;
    private int mSeekPosition;
    private int mStreamVolume;

    public GestureVideoController(@NonNull Context context) {
        super(context);
        this.mIsGestureEnabled = true;
        this.mSeekPosition = -1;
        this.mCanChangePosition = true;
        this.mIsDoubleTapTogglePlayEnabled = true;
    }

    private boolean isInPlaybackState() {
        int i2;
        return (this.mControlWrapper == null || (i2 = this.mCurPlayState) == -1 || i2 == 0 || i2 == 1 || i2 == 2 || i2 == 8 || i2 == 5) ? false : true;
    }

    private void stopSlide() {
        Iterator<Map.Entry<IControlComponent, Boolean>> it = this.mControlComponents.entrySet().iterator();
        while (it.hasNext()) {
            IControlComponent key = it.next().getKey();
            if (key instanceof IGestureComponent) {
                ((IGestureComponent) key).onStopSlide();
            }
        }
    }

    @Override // xyz.doikki.videoplayer.controller.BaseVideoController
    protected void initView() {
        super.initView();
        this.mAudioManager = (AudioManager) getContext().getSystemService(o.b);
        this.mGestureDetector = new GestureDetector(getContext(), this);
        setOnTouchListener(this);
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTap(MotionEvent motionEvent) {
        if (!this.mIsDoubleTapTogglePlayEnabled || isLocked() || !isInPlaybackState()) {
            return true;
        }
        togglePlay();
        return true;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        if (isInPlaybackState() && this.mIsGestureEnabled && !PlayerUtils.isEdge(getContext(), motionEvent)) {
            this.mStreamVolume = this.mAudioManager.getStreamVolume(3);
            Activity activityScanForActivity = PlayerUtils.scanForActivity(getContext());
            if (activityScanForActivity == null) {
                this.mBrightness = 0.0f;
            } else {
                this.mBrightness = activityScanForActivity.getWindow().getAttributes().screenBrightness;
            }
            this.mFirstTouch = true;
            this.mChangePosition = false;
            this.mChangeBrightness = false;
            this.mChangeVolume = false;
        }
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        if (isInPlaybackState() && this.mIsGestureEnabled && this.mCanSlide && !isLocked() && !PlayerUtils.isEdge(getContext(), motionEvent)) {
            float x2 = motionEvent.getX() - motionEvent2.getX();
            float y2 = motionEvent.getY() - motionEvent2.getY();
            if (this.mFirstTouch) {
                this.mChangePosition = Math.abs(f2) >= Math.abs(f3);
                if (!this.mChangePosition) {
                    if (motionEvent2.getX() > PlayerUtils.getScreenWidth(getContext(), true) / 2) {
                        this.mChangeVolume = true;
                    } else {
                        this.mChangeBrightness = true;
                    }
                }
                if (this.mChangePosition) {
                    this.mChangePosition = this.mCanChangePosition;
                }
                if (this.mChangePosition || this.mChangeBrightness || this.mChangeVolume) {
                    Iterator<Map.Entry<IControlComponent, Boolean>> it = this.mControlComponents.entrySet().iterator();
                    while (it.hasNext()) {
                        IControlComponent key = it.next().getKey();
                        if (key instanceof IGestureComponent) {
                            ((IGestureComponent) key).onStartSlide();
                        }
                    }
                }
                this.mFirstTouch = false;
            }
            if (this.mChangePosition) {
                slideToChangePosition(x2);
            } else if (this.mChangeBrightness) {
                slideToChangeBrightness(y2);
            } else if (this.mChangeVolume) {
                slideToChangeVolume(y2);
            }
        }
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        if (!isInPlaybackState()) {
            return true;
        }
        this.mControlWrapper.toggleShowState();
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return this.mGestureDetector.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.mGestureDetector.onTouchEvent(motionEvent)) {
            int action = motionEvent.getAction();
            if (action == 1) {
                stopSlide();
                int i2 = this.mSeekPosition;
                if (i2 >= 0) {
                    this.mControlWrapper.seekTo(i2);
                    this.mSeekPosition = -1;
                }
            } else if (action == 3) {
                stopSlide();
                this.mSeekPosition = -1;
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setCanChangePosition(boolean z2) {
        this.mCanChangePosition = z2;
    }

    public void setDoubleTapTogglePlayEnabled(boolean z2) {
        this.mIsDoubleTapTogglePlayEnabled = z2;
    }

    public void setEnableInNormal(boolean z2) {
        this.mEnableInNormal = z2;
    }

    public void setGestureEnabled(boolean z2) {
        this.mIsGestureEnabled = z2;
    }

    @Override // xyz.doikki.videoplayer.controller.BaseVideoController
    public void setPlayState(int i2) {
        super.setPlayState(i2);
        this.mCurPlayState = i2;
    }

    @Override // xyz.doikki.videoplayer.controller.BaseVideoController
    public void setPlayerState(int i2) {
        super.setPlayerState(i2);
        if (i2 == 10) {
            this.mCanSlide = this.mEnableInNormal;
        } else if (i2 == 11) {
            this.mCanSlide = true;
        }
    }

    protected void slideToChangeBrightness(float f2) {
        Activity activityScanForActivity = PlayerUtils.scanForActivity(getContext());
        if (activityScanForActivity == null) {
            return;
        }
        Window window = activityScanForActivity.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        int measuredHeight = getMeasuredHeight();
        if (this.mBrightness == -1.0f) {
            this.mBrightness = 0.5f;
        }
        float f3 = ((f2 * 2.0f) / measuredHeight) + this.mBrightness;
        if (f3 < 0.0f) {
            f3 = 0.0f;
        }
        if (f3 > 1.0f) {
            f3 = 1.0f;
        }
        int i2 = (int) (100.0f * f3);
        attributes.screenBrightness = f3;
        window.setAttributes(attributes);
        Iterator<Map.Entry<IControlComponent, Boolean>> it = this.mControlComponents.entrySet().iterator();
        while (it.hasNext()) {
            IControlComponent key = it.next().getKey();
            if (key instanceof IGestureComponent) {
                ((IGestureComponent) key).onBrightnessChange(i2);
            }
        }
    }

    protected void slideToChangePosition(float f2) {
        int measuredWidth = getMeasuredWidth();
        int duration = (int) this.mControlWrapper.getDuration();
        int currentPosition = (int) this.mControlWrapper.getCurrentPosition();
        int i2 = (int) ((((-f2) / measuredWidth) * 120000.0f) + currentPosition);
        if (i2 > duration) {
            i2 = duration;
        }
        if (i2 < 0) {
            i2 = 0;
        }
        Iterator<Map.Entry<IControlComponent, Boolean>> it = this.mControlComponents.entrySet().iterator();
        while (it.hasNext()) {
            IControlComponent key = it.next().getKey();
            if (key instanceof IGestureComponent) {
                ((IGestureComponent) key).onPositionChange(i2, currentPosition, duration);
            }
        }
        this.mSeekPosition = i2;
    }

    protected void slideToChangeVolume(float f2) {
        float streamMaxVolume = this.mAudioManager.getStreamMaxVolume(3);
        float measuredHeight = (((f2 * 2.0f) / getMeasuredHeight()) * streamMaxVolume) + this.mStreamVolume;
        if (measuredHeight > streamMaxVolume) {
            measuredHeight = streamMaxVolume;
        }
        if (measuredHeight < 0.0f) {
            measuredHeight = 0.0f;
        }
        int i2 = (int) ((measuredHeight / streamMaxVolume) * 100.0f);
        this.mAudioManager.setStreamVolume(3, (int) measuredHeight, 0);
        Iterator<Map.Entry<IControlComponent, Boolean>> it = this.mControlComponents.entrySet().iterator();
        while (it.hasNext()) {
            IControlComponent key = it.next().getKey();
            if (key instanceof IGestureComponent) {
                ((IGestureComponent) key).onVolumeChange(i2);
            }
        }
    }

    public GestureVideoController(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mIsGestureEnabled = true;
        this.mSeekPosition = -1;
        this.mCanChangePosition = true;
        this.mIsDoubleTapTogglePlayEnabled = true;
    }

    public GestureVideoController(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mIsGestureEnabled = true;
        this.mSeekPosition = -1;
        this.mCanChangePosition = true;
        this.mIsDoubleTapTogglePlayEnabled = true;
    }
}
