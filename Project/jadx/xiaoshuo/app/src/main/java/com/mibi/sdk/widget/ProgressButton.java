package com.mibi.sdk.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes17.dex */
public class ProgressButton extends FrameLayout {
    private Animation mAnimation;
    private Button mButton;
    private ImageView mProgressCircleView;

    public interface IOnClickListener {
        void onClick(View view);
    }

    public ProgressButton(Context context) {
        this(context, null);
    }

    private Animation createProgressAnimation() {
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setDuration(1000L);
        rotateAnimation.setInterpolator(new LinearInterpolator());
        rotateAnimation.setRepeatMode(1);
        rotateAnimation.setRepeatCount(-1);
        return rotateAnimation;
    }

    public void setClickListener(final IOnClickListener iOnClickListener) {
        this.mButton.setOnClickListener(new View.OnClickListener() { // from class: com.mibi.sdk.widget.ProgressButton.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                iOnClickListener.onClick(view);
            }
        });
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        throw new IllegalStateException("should not use this method,use setClickListener instead");
    }

    public void setText(CharSequence charSequence) {
        this.mButton.setText(charSequence);
    }

    public void startProgress() {
        this.mButton.setVisibility(4);
        this.mProgressCircleView.setVisibility(0);
        this.mProgressCircleView.startAnimation(this.mAnimation);
    }

    public void stopProgress() {
        this.mButton.setVisibility(0);
        this.mProgressCircleView.setVisibility(4);
        this.mProgressCircleView.clearAnimation();
    }

    public ProgressButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Mibi_ProgressButton);
        String string = typedArrayObtainStyledAttributes.getString(R.styleable.Mibi_ProgressButton_btnText);
        typedArrayObtainStyledAttributes.recycle();
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.mibi_progress_button, this);
        this.mButton = (Button) viewInflate.findViewById(R.id.button);
        this.mProgressCircleView = (ImageView) viewInflate.findViewById(R.id.progress_circle);
        if (!TextUtils.isEmpty(string)) {
            this.mButton.setText(string);
        }
        this.mAnimation = createProgressAnimation();
    }
}
