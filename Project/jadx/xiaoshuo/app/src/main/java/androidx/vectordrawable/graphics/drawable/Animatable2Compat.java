package androidx.vectordrawable.graphics.drawable;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Animatable2;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
public interface Animatable2Compat extends Animatable {

    public static abstract class AnimationCallback {
        Animatable2.AnimationCallback mPlatformCallback;

        @RequiresApi(23)
        public Animatable2.AnimationCallback getPlatformCallback() {
            if (this.mPlatformCallback == null) {
                this.mPlatformCallback = new Animatable2.AnimationCallback() { // from class: androidx.vectordrawable.graphics.drawable.Animatable2Compat.AnimationCallback.1
                    @Override // android.graphics.drawable.Animatable2.AnimationCallback
                    public void onAnimationEnd(Drawable drawable2) {
                        AnimationCallback.this.onAnimationEnd(drawable2);
                    }

                    @Override // android.graphics.drawable.Animatable2.AnimationCallback
                    public void onAnimationStart(Drawable drawable2) {
                        AnimationCallback.this.onAnimationStart(drawable2);
                    }
                };
            }
            return this.mPlatformCallback;
        }

        public void onAnimationEnd(Drawable drawable2) {
        }

        public void onAnimationStart(Drawable drawable2) {
        }
    }

    void clearAnimationCallbacks();

    void registerAnimationCallback(@NonNull AnimationCallback animationCallback);

    boolean unregisterAnimationCallback(@NonNull AnimationCallback animationCallback);
}
