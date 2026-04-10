package com.kuaishou.pushad;

import android.R;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.b.b;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class PushAdViewHelper {
    private static final String TAG = "PushAdViewHelper";

    public static void appendPushAd(Activity activity, View view) {
        ViewGroup viewGroupObtainDecorView;
        if (view == null || (viewGroupObtainDecorView = obtainDecorView(activity)) == null) {
            return;
        }
        removePushAd(viewGroupObtainDecorView);
        viewGroupObtainDecorView.addView(view, new ViewGroup.LayoutParams(-1, -1));
    }

    @Nullable
    private static ViewGroup obtainDecorView(@Nullable Activity activity) {
        if (activity == null) {
            b.we();
            activity = b.getCurrentActivity();
        }
        if (activity == null) {
            return null;
        }
        View viewFindViewById = activity.getWindow().getDecorView().findViewById(R.id.content);
        if (viewFindViewById instanceof ViewGroup) {
            return (ViewGroup) viewFindViewById;
        }
        return null;
    }

    public static void removePushAd(@Nullable ViewGroup viewGroup) {
        if (viewGroup == null) {
            viewGroup = obtainDecorView(null);
        }
        if (viewGroup != null) {
            ArrayList arrayList = new ArrayList();
            int childCount = viewGroup.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = viewGroup.getChildAt(i2);
                if (PushAdView.PUSH_VIEW_TAG.equals(childAt.getTag())) {
                    arrayList.add(childAt);
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                viewGroup.removeView((View) it.next());
            }
        }
    }
}
