package miuix.overscroller.internal.dynamicanimation.animation;

import android.util.AndroidRuntimeException;
import android.view.View;
import androidx.constraintlayout.motion.widget.Key;
import java.util.ArrayList;
import miuix.overscroller.internal.dynamicanimation.animation.AnimationHandler;
import miuix.overscroller.internal.dynamicanimation.animation.DynamicAnimation;

/* JADX INFO: loaded from: classes2.dex */
public abstract class DynamicAnimation<T extends DynamicAnimation<T>> implements AnimationHandler.AnimationFrameCallback {
    public static final float MIN_VISIBLE_CHANGE_ALPHA = 0.00390625f;
    public static final float MIN_VISIBLE_CHANGE_PIXELS = 1.0f;
    public static final float MIN_VISIBLE_CHANGE_ROTATION_DEGREES = 0.1f;
    public static final float MIN_VISIBLE_CHANGE_SCALE = 0.002f;
    private static final float THRESHOLD_MULTIPLIER = 0.75f;
    private static final float UNSET = Float.MAX_VALUE;
    private final ArrayList<OnAnimationEndListener> mEndListeners;
    private long mLastFrameTimeNanos;
    float mMaxValue;
    float mMinValue;
    private float mMinVisibleChange;
    final FloatPropertyCompat mProperty;
    boolean mRunning;
    private long mStartDelay;
    boolean mStartValueIsSet;
    final Object mTarget;
    private final ArrayList<OnAnimationUpdateListener> mUpdateListeners;
    float mValue;
    float mVelocity;
    public static final ViewProperty TRANSLATION_X = new ViewProperty("translationX") { // from class: miuix.overscroller.internal.dynamicanimation.animation.DynamicAnimation.1
        @Override // miuix.overscroller.internal.dynamicanimation.animation.FloatPropertyCompat
        public float getValue(View view) {
            return view.getTranslationX();
        }

        @Override // miuix.overscroller.internal.dynamicanimation.animation.FloatPropertyCompat
        public void setValue(View view, float f) {
            view.setTranslationX(f);
        }
    };
    public static final ViewProperty TRANSLATION_Y = new ViewProperty("translationY") { // from class: miuix.overscroller.internal.dynamicanimation.animation.DynamicAnimation.2
        @Override // miuix.overscroller.internal.dynamicanimation.animation.FloatPropertyCompat
        public float getValue(View view) {
            return view.getTranslationY();
        }

        @Override // miuix.overscroller.internal.dynamicanimation.animation.FloatPropertyCompat
        public void setValue(View view, float f) {
            view.setTranslationY(f);
        }
    };
    public static final ViewProperty TRANSLATION_Z = new ViewProperty("translationZ") { // from class: miuix.overscroller.internal.dynamicanimation.animation.DynamicAnimation.3
        @Override // miuix.overscroller.internal.dynamicanimation.animation.FloatPropertyCompat
        public float getValue(View view) {
            return view.getTranslationZ();
        }

        @Override // miuix.overscroller.internal.dynamicanimation.animation.FloatPropertyCompat
        public void setValue(View view, float f) {
            view.setTranslationZ(f);
        }
    };
    public static final ViewProperty SCALE_X = new ViewProperty("scaleX") { // from class: miuix.overscroller.internal.dynamicanimation.animation.DynamicAnimation.4
        @Override // miuix.overscroller.internal.dynamicanimation.animation.FloatPropertyCompat
        public float getValue(View view) {
            return view.getScaleX();
        }

        @Override // miuix.overscroller.internal.dynamicanimation.animation.FloatPropertyCompat
        public void setValue(View view, float f) {
            view.setScaleX(f);
        }
    };
    public static final ViewProperty SCALE_Y = new ViewProperty("scaleY") { // from class: miuix.overscroller.internal.dynamicanimation.animation.DynamicAnimation.5
        @Override // miuix.overscroller.internal.dynamicanimation.animation.FloatPropertyCompat
        public float getValue(View view) {
            return view.getScaleY();
        }

        @Override // miuix.overscroller.internal.dynamicanimation.animation.FloatPropertyCompat
        public void setValue(View view, float f) {
            view.setScaleY(f);
        }
    };
    public static final ViewProperty ROTATION = new ViewProperty(Key.ROTATION) { // from class: miuix.overscroller.internal.dynamicanimation.animation.DynamicAnimation.6
        @Override // miuix.overscroller.internal.dynamicanimation.animation.FloatPropertyCompat
        public float getValue(View view) {
            return view.getRotation();
        }

        @Override // miuix.overscroller.internal.dynamicanimation.animation.FloatPropertyCompat
        public void setValue(View view, float f) {
            view.setRotation(f);
        }
    };
    public static final ViewProperty ROTATION_X = new ViewProperty("rotationX") { // from class: miuix.overscroller.internal.dynamicanimation.animation.DynamicAnimation.7
        @Override // miuix.overscroller.internal.dynamicanimation.animation.FloatPropertyCompat
        public float getValue(View view) {
            return view.getRotationX();
        }

        @Override // miuix.overscroller.internal.dynamicanimation.animation.FloatPropertyCompat
        public void setValue(View view, float f) {
            view.setRotationX(f);
        }
    };
    public static final ViewProperty ROTATION_Y = new ViewProperty("rotationY") { // from class: miuix.overscroller.internal.dynamicanimation.animation.DynamicAnimation.8
        @Override // miuix.overscroller.internal.dynamicanimation.animation.FloatPropertyCompat
        public float getValue(View view) {
            return view.getRotationY();
        }

        @Override // miuix.overscroller.internal.dynamicanimation.animation.FloatPropertyCompat
        public void setValue(View view, float f) {
            view.setRotationY(f);
        }
    };
    public static final ViewProperty X = new ViewProperty("x") { // from class: miuix.overscroller.internal.dynamicanimation.animation.DynamicAnimation.9
        @Override // miuix.overscroller.internal.dynamicanimation.animation.FloatPropertyCompat
        public float getValue(View view) {
            return view.getX();
        }

        @Override // miuix.overscroller.internal.dynamicanimation.animation.FloatPropertyCompat
        public void setValue(View view, float f) {
            view.setX(f);
        }
    };
    public static final ViewProperty Y = new ViewProperty("y") { // from class: miuix.overscroller.internal.dynamicanimation.animation.DynamicAnimation.10
        @Override // miuix.overscroller.internal.dynamicanimation.animation.FloatPropertyCompat
        public float getValue(View view) {
            return view.getY();
        }

        @Override // miuix.overscroller.internal.dynamicanimation.animation.FloatPropertyCompat
        public void setValue(View view, float f) {
            view.setY(f);
        }
    };
    public static final ViewProperty Z = new ViewProperty("z") { // from class: miuix.overscroller.internal.dynamicanimation.animation.DynamicAnimation.11
        @Override // miuix.overscroller.internal.dynamicanimation.animation.FloatPropertyCompat
        public float getValue(View view) {
            return view.getZ();
        }

        @Override // miuix.overscroller.internal.dynamicanimation.animation.FloatPropertyCompat
        public void setValue(View view, float f) {
            view.setZ(f);
        }
    };
    public static final ViewProperty ALPHA = new ViewProperty("alpha") { // from class: miuix.overscroller.internal.dynamicanimation.animation.DynamicAnimation.12
        @Override // miuix.overscroller.internal.dynamicanimation.animation.FloatPropertyCompat
        public float getValue(View view) {
            return view.getAlpha();
        }

        @Override // miuix.overscroller.internal.dynamicanimation.animation.FloatPropertyCompat
        public void setValue(View view, float f) {
            view.setAlpha(f);
        }
    };
    public static final ViewProperty SCROLL_X = new ViewProperty("scrollX") { // from class: miuix.overscroller.internal.dynamicanimation.animation.DynamicAnimation.13
        @Override // miuix.overscroller.internal.dynamicanimation.animation.FloatPropertyCompat
        public float getValue(View view) {
            return view.getScrollX();
        }

        @Override // miuix.overscroller.internal.dynamicanimation.animation.FloatPropertyCompat
        public void setValue(View view, float f) {
            view.setScrollX((int) f);
        }
    };
    public static final ViewProperty SCROLL_Y = new ViewProperty("scrollY") { // from class: miuix.overscroller.internal.dynamicanimation.animation.DynamicAnimation.14
        @Override // miuix.overscroller.internal.dynamicanimation.animation.FloatPropertyCompat
        public float getValue(View view) {
            return view.getScrollY();
        }

        @Override // miuix.overscroller.internal.dynamicanimation.animation.FloatPropertyCompat
        public void setValue(View view, float f) {
            view.setScrollY((int) f);
        }
    };

    public static class MassState {
        float mValue;
        float mVelocity;
    }

    public interface OnAnimationEndListener {
        void onAnimationEnd(DynamicAnimation dynamicAnimation, boolean z, float f, float f2);
    }

    public interface OnAnimationUpdateListener {
        void onAnimationUpdate(DynamicAnimation dynamicAnimation, float f, float f2);
    }

    public static abstract class ViewProperty extends FloatPropertyCompat<View> {
        private ViewProperty(String str) {
            super(str);
        }
    }

    public DynamicAnimation(final FloatValueHolder floatValueHolder) {
        this.mVelocity = 0.0f;
        this.mValue = Float.MAX_VALUE;
        this.mStartValueIsSet = false;
        this.mRunning = false;
        this.mMaxValue = Float.MAX_VALUE;
        this.mMinValue = -Float.MAX_VALUE;
        this.mLastFrameTimeNanos = 0L;
        this.mStartDelay = 0L;
        this.mEndListeners = new ArrayList<>();
        this.mUpdateListeners = new ArrayList<>();
        this.mTarget = null;
        this.mProperty = new FloatPropertyCompat("FloatValueHolder") { // from class: miuix.overscroller.internal.dynamicanimation.animation.DynamicAnimation.15
            @Override // miuix.overscroller.internal.dynamicanimation.animation.FloatPropertyCompat
            public float getValue(Object obj) {
                return floatValueHolder.getValue();
            }

            @Override // miuix.overscroller.internal.dynamicanimation.animation.FloatPropertyCompat
            public void setValue(Object obj, float f) {
                floatValueHolder.setValue(f);
            }
        };
        this.mMinVisibleChange = 1.0f;
    }

    private void endAnimationInternal(boolean z) {
        this.mRunning = false;
        AnimationHandler.getInstance().removeCallback(this);
        this.mLastFrameTimeNanos = 0L;
        this.mStartValueIsSet = false;
        for (int i = 0; i < this.mEndListeners.size(); i++) {
            if (this.mEndListeners.get(i) != null) {
                this.mEndListeners.get(i).onAnimationEnd(this, z, this.mValue, this.mVelocity);
            }
        }
        removeNullEntries(this.mEndListeners);
    }

    private float getPropertyValue() {
        return this.mProperty.getValue(this.mTarget);
    }

    private static <T> void removeEntry(ArrayList<T> arrayList, T t) {
        int iIndexOf = arrayList.indexOf(t);
        if (iIndexOf >= 0) {
            arrayList.set(iIndexOf, null);
        }
    }

    private static <T> void removeNullEntries(ArrayList<T> arrayList) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size) == null) {
                arrayList.remove(size);
            }
        }
    }

    private void startAnimationInternal(boolean z) {
        if (this.mRunning) {
            return;
        }
        this.mRunning = true;
        if (!this.mStartValueIsSet) {
            this.mValue = getPropertyValue();
        }
        float f = this.mValue;
        if (f > this.mMaxValue || f < this.mMinValue) {
            throw new IllegalArgumentException("Starting value need to be in between min value and max value");
        }
        if (z) {
            return;
        }
        AnimationHandler.getInstance().addAnimationFrameCallback(this, this.mStartDelay);
    }

    public T addEndListener(OnAnimationEndListener onAnimationEndListener) {
        if (!this.mEndListeners.contains(onAnimationEndListener)) {
            this.mEndListeners.add(onAnimationEndListener);
        }
        return this;
    }

    public T addUpdateListener(OnAnimationUpdateListener onAnimationUpdateListener) {
        if (isRunning()) {
            throw new UnsupportedOperationException("Error: Update listeners must be added beforethe miuix.animation.");
        }
        if (!this.mUpdateListeners.contains(onAnimationUpdateListener)) {
            this.mUpdateListeners.add(onAnimationUpdateListener);
        }
        return this;
    }

    public void cancel() {
        if (!getAnimationHandler().isCurrentThread()) {
            throw new AndroidRuntimeException("Animations may only be canceled from the same thread as the animation handler");
        }
        if (this.mRunning) {
            endAnimationInternal(true);
        }
    }

    @Override // miuix.overscroller.internal.dynamicanimation.animation.AnimationHandler.AnimationFrameCallback
    public boolean doAnimationFrame(long j) {
        long frameDeltaNanos = AnimationHandler.getInstance().getFrameDeltaNanos();
        long j2 = this.mLastFrameTimeNanos;
        if (j2 == 0) {
            this.mLastFrameTimeNanos = j;
            setPropertyValue(this.mValue);
            return false;
        }
        if (frameDeltaNanos == 0) {
            frameDeltaNanos = j - j2;
        }
        this.mLastFrameTimeNanos = j;
        boolean zUpdateValueAndVelocity = updateValueAndVelocity(frameDeltaNanos);
        float fMin = Math.min(this.mValue, this.mMaxValue);
        this.mValue = fMin;
        float fMax = Math.max(fMin, this.mMinValue);
        this.mValue = fMax;
        setPropertyValue(fMax);
        if (zUpdateValueAndVelocity) {
            endAnimationInternal(false);
        }
        return zUpdateValueAndVelocity;
    }

    public abstract float getAcceleration(float f, float f2);

    public AnimationHandler getAnimationHandler() {
        return AnimationHandler.getInstance();
    }

    public float getMinimumVisibleChange() {
        return this.mMinVisibleChange;
    }

    public float getValueThreshold() {
        return this.mMinVisibleChange * 0.75f;
    }

    public abstract boolean isAtEquilibrium(float f, float f2);

    public boolean isRunning() {
        return this.mRunning;
    }

    public void removeEndListener(OnAnimationEndListener onAnimationEndListener) {
        removeEntry(this.mEndListeners, onAnimationEndListener);
    }

    public void removeUpdateListener(OnAnimationUpdateListener onAnimationUpdateListener) {
        removeEntry(this.mUpdateListeners, onAnimationUpdateListener);
    }

    public T setMaxValue(float f) {
        this.mMaxValue = f;
        return this;
    }

    public T setMinValue(float f) {
        this.mMinValue = f;
        return this;
    }

    public T setMinimumVisibleChange(float f) {
        if (f <= 0.0f) {
            throw new IllegalArgumentException("Minimum visible change must be positive.");
        }
        this.mMinVisibleChange = f;
        setValueThreshold(f * 0.75f);
        return this;
    }

    public void setPropertyValue(float f) {
        this.mProperty.setValue(this.mTarget, f);
        for (int i = 0; i < this.mUpdateListeners.size(); i++) {
            if (this.mUpdateListeners.get(i) != null) {
                this.mUpdateListeners.get(i).onAnimationUpdate(this, this.mValue, this.mVelocity);
            }
        }
        removeNullEntries(this.mUpdateListeners);
    }

    public void setStartDelay(long j) {
        if (j < 0) {
            j = 0;
        }
        this.mStartDelay = j;
    }

    public T setStartValue(float f) {
        this.mValue = f;
        this.mStartValueIsSet = true;
        return this;
    }

    public T setStartVelocity(float f) {
        this.mVelocity = f;
        return this;
    }

    public abstract void setValueThreshold(float f);

    public void start() {
        start(false);
    }

    public abstract boolean updateValueAndVelocity(long j);

    public void start(boolean z) {
        if (!getAnimationHandler().isCurrentThread()) {
            throw new AndroidRuntimeException("Animations may only be started on the main thread");
        }
        if (this.mRunning) {
            return;
        }
        startAnimationInternal(z);
    }

    public <K> DynamicAnimation(K k, FloatPropertyCompat<K> floatPropertyCompat) {
        this.mVelocity = 0.0f;
        this.mValue = Float.MAX_VALUE;
        this.mStartValueIsSet = false;
        this.mRunning = false;
        this.mMaxValue = Float.MAX_VALUE;
        this.mMinValue = -Float.MAX_VALUE;
        this.mLastFrameTimeNanos = 0L;
        this.mStartDelay = 0L;
        this.mEndListeners = new ArrayList<>();
        this.mUpdateListeners = new ArrayList<>();
        this.mTarget = k;
        this.mProperty = floatPropertyCompat;
        if (floatPropertyCompat != ROTATION && floatPropertyCompat != ROTATION_X && floatPropertyCompat != ROTATION_Y) {
            if (floatPropertyCompat == ALPHA) {
                this.mMinVisibleChange = 0.00390625f;
                return;
            } else if (floatPropertyCompat != SCALE_X && floatPropertyCompat != SCALE_Y) {
                this.mMinVisibleChange = 1.0f;
                return;
            } else {
                this.mMinVisibleChange = 0.00390625f;
                return;
            }
        }
        this.mMinVisibleChange = 0.1f;
    }
}
