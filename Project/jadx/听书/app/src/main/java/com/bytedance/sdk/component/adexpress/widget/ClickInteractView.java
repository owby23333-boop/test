package com.bytedance.sdk.component.adexpress.widget;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.media3.exoplayer.ExoPlayer;
import com.bytedance.sdk.component.adexpress.a.gz;
import com.bytedance.sdk.component.utils.tb;

/* JADX INFO: loaded from: classes2.dex */
public class ClickInteractView extends FrameLayout {
    private AnimatorSet g;
    private ImageView z;

    public ClickInteractView(Context context) {
        super(context);
        dl();
        a();
    }

    private void dl() {
        ImageView imageView = new ImageView(getContext());
        this.z = imageView;
        imageView.setImageResource(tb.gc(getContext(), "tt_white_hand"));
        int iZ = (int) gz.z(getContext(), 20.0f);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(iZ, iZ);
        layoutParams.gravity = 17;
        addView(this.z, layoutParams);
    }

    private void a() {
        this.g = new AnimatorSet();
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.z, "scaleX", 1.0f, 1.5f, 1.0f, 1.0f, 1.0f);
        objectAnimatorOfFloat.setDuration(ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
        objectAnimatorOfFloat.setRepeatMode(2);
        objectAnimatorOfFloat.setRepeatCount(-1);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.z, "scaleY", 1.0f, 1.5f, 1.0f, 1.0f, 1.0f);
        objectAnimatorOfFloat2.setDuration(ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
        objectAnimatorOfFloat2.setRepeatMode(2);
        objectAnimatorOfFloat2.setRepeatCount(-1);
        this.g.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
    }

    public void z() {
        AnimatorSet animatorSet = this.g;
        if (animatorSet != null) {
            animatorSet.start();
        }
    }

    public void g() {
        AnimatorSet animatorSet = this.g;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
    }
}
