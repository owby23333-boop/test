package com.bytedance.sdk.component.adexpress.widget;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.text.TextUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.media3.exoplayer.ExoPlayer;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
public class ClickSlideUpView2 extends SlideUpView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ImageView f593a;
    private ImageView dl;
    private ImageView g;
    private int gc;
    private AnimatorSet m;
    private TextView z;

    @Override // com.bytedance.sdk.component.adexpress.widget.SlideUpView
    protected void z(Context context) {
    }

    public ClickSlideUpView2(Context context) {
        super(context);
        this.m = new AnimatorSet();
        g(context);
    }

    private void g(Context context) {
        addView(com.bytedance.sdk.component.adexpress.dl.z.g(context));
        this.g = (ImageView) findViewById(2097610751);
        this.dl = (ImageView) findViewById(2097610750);
        this.f593a = (ImageView) findViewById(2097610749);
        this.z = (TextView) findViewById(2097610748);
    }

    public void setButtonText(String str) {
        if (this.z == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.z.setText(str);
    }

    private void a() {
        ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(this, "alphaColor", 0, 60);
        objectAnimatorOfInt.setInterpolator(new LinearInterpolator());
        objectAnimatorOfInt.setDuration(ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
        objectAnimatorOfInt.setRepeatCount(-1);
        objectAnimatorOfInt.start();
    }

    public float getAlphaColor() {
        return this.gc;
    }

    public void setAlphaColor(int i) {
        if (i < 0 || i > 60) {
            return;
        }
        int i2 = i + MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_PERFER_VIDEO;
        this.f593a.setColorFilter(Color.rgb(i2, i2, i2), PorterDuff.Mode.SRC_IN);
        int i3 = ((i + 20) % 60) + MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_PERFER_VIDEO;
        this.dl.setColorFilter(Color.rgb(i3, i3, i3), PorterDuff.Mode.SRC_IN);
        int i4 = ((i + 40) % 60) + MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_PERFER_VIDEO;
        this.g.setColorFilter(Color.rgb(i4, i4, i4), PorterDuff.Mode.SRC_IN);
    }

    @Override // com.bytedance.sdk.component.adexpress.widget.SlideUpView
    public void z() {
        a();
    }

    @Override // com.bytedance.sdk.component.adexpress.widget.SlideUpView
    public void g() {
        this.m.cancel();
    }
}
