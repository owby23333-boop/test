package com.mibi.sdk.widget;

import android.app.Dialog;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

/* JADX INFO: loaded from: classes17.dex */
public class SimpleProgressDialog extends Dialog {
    private static final String TAG = "SimpleProgressDialog";
    private TextView mMessageView;
    private ImageView mProgressStatus;

    public SimpleProgressDialog(Context context) {
        super(context, -1);
        init();
    }

    private Animation createProgressAnimation() {
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setDuration(1000L);
        rotateAnimation.setInterpolator(new LinearInterpolator());
        rotateAnimation.setRepeatMode(1);
        rotateAnimation.setRepeatCount(-1);
        return rotateAnimation;
    }

    private void init() {
        Log.d(TAG, "init");
        Window window = getWindow();
        if (window != null) {
            window.setWindowAnimations(R.style.Mibi_Animation_ProgressDialog);
            View viewFindViewById = window.getDecorView().findViewById(android.R.id.title);
            if (viewFindViewById != null) {
                viewFindViewById.setVisibility(8);
            }
        }
        setCanceledOnTouchOutside(false);
        View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.mibi_simple_dialog_progress, (ViewGroup) null);
        this.mMessageView = (TextView) viewInflate.findViewById(R.id.mibi_message);
        this.mProgressStatus = (ImageView) viewInflate.findViewById(R.id.progress_circle);
        setContentView(viewInflate);
    }

    public void setMessage(String str) {
        this.mMessageView.setText(str);
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        this.mProgressStatus.startAnimation(createProgressAnimation());
    }
}
