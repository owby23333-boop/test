package miuix.appcompat.widget;

import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import miuix.internal.util.ViewUtils;
import miuix.theme.token.DimToken;

/* JADX INFO: loaded from: classes7.dex */
public class DimAnimator {
    public static void dismiss(View view) {
        float[] fArr = new float[2];
        fArr[0] = ViewUtils.isNightMode(view.getContext()) ? DimToken.DIM_DARK : DimToken.DIM_LIGHT;
        fArr[1] = 0.0f;
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "alpha", fArr);
        objectAnimatorOfFloat.setInterpolator(new DecelerateInterpolator(1.5f));
        objectAnimatorOfFloat.setDuration(250L);
        objectAnimatorOfFloat.start();
    }

    public static void show(View view) {
        float[] fArr = new float[2];
        fArr[0] = 0.0f;
        fArr[1] = ViewUtils.isNightMode(view.getContext()) ? DimToken.DIM_DARK : DimToken.DIM_LIGHT;
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "alpha", fArr);
        objectAnimatorOfFloat.setInterpolator(new DecelerateInterpolator(1.5f));
        objectAnimatorOfFloat.setDuration(300L);
        objectAnimatorOfFloat.start();
    }
}
