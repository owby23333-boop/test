package com.anythink.network.baidu.impression;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes2.dex */
public class BDViews {
    private static View a(Context context) {
        if (context instanceof Activity) {
            return ((Activity) context).getWindow().getDecorView().findViewById(R.id.content);
        }
        return null;
    }

    public static View getTopmostView(Context context, View view) {
        View rootView;
        View viewFindViewById = null;
        View viewFindViewById2 = !(context instanceof Activity) ? null : ((Activity) context).getWindow().getDecorView().findViewById(R.id.content);
        if (view != null && (rootView = view.getRootView()) != null && (viewFindViewById = rootView.findViewById(R.id.content)) == null) {
            viewFindViewById = rootView;
        }
        return viewFindViewById2 != null ? viewFindViewById2 : viewFindViewById;
    }

    public static void removeFromParent(View view) {
        if (view == null || view.getParent() == null || !(view.getParent() instanceof ViewGroup)) {
            return;
        }
        ((ViewGroup) view.getParent()).removeView(view);
    }

    private static View a(View view) {
        View rootView;
        if (view == null || (rootView = view.getRootView()) == null) {
            return null;
        }
        View viewFindViewById = rootView.findViewById(R.id.content);
        return viewFindViewById != null ? viewFindViewById : rootView;
    }
}
