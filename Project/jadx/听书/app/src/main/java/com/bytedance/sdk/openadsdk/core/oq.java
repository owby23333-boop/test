package com.bytedance.sdk.openadsdk.core;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import java.util.HashSet;

/* JADX INFO: loaded from: classes2.dex */
public class oq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f1290a;
    private static int dl;
    private static final HashSet<String> e;
    private static final boolean g;
    private static int gc;
    private static final HashSet<String> gz;
    private static Handler m;
    private static final boolean z;

    static {
        z = com.bytedance.sdk.openadsdk.core.un.sy.ls();
        g = z();
        dl = -1;
        f1290a = -1;
        gc = -1;
        m = null;
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("HUAWEI C8812");
        hashSet.add("HUAWEI C8812E");
        hashSet.add("HUAWEI C8825D");
        hashSet.add("HUAWEI U8825D");
        hashSet.add("HUAWEI C8950D");
        hashSet.add("HUAWEI U8950D");
        e = hashSet;
        HashSet<String> hashSet2 = new HashSet<>();
        hashSet2.add("ZTE V955");
        hashSet2.add("ZTE N881E");
        hashSet2.add("ZTE N881F");
        hashSet2.add("ZTE N880G");
        hashSet2.add("ZTE N880F");
        hashSet2.add("ZTE V889F");
        gz = hashSet2;
    }

    public static void z(final Context context, final com.bytedance.sdk.component.i.dl dlVar) {
        com.bytedance.sdk.openadsdk.hh.e.z(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.oq.1
            @Override // java.lang.Runnable
            public void run() {
                oq.g(context, dlVar);
            }
        });
    }

    public static void g(Context context, com.bytedance.sdk.component.i.dl dlVar) {
        if (context == null || dlVar == null || !(context instanceof Activity)) {
            return;
        }
        Activity activity = (Activity) context;
        if (activity.isFinishing()) {
            try {
                dlVar.loadUrl("about:blank");
                if (gc > 0) {
                    View rootView = dlVar.getView().getRootView();
                    if (rootView instanceof ViewGroup) {
                        View childAt = ((ViewGroup) rootView).getChildAt(0);
                        childAt.setDrawingCacheEnabled(true);
                        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(childAt.getDrawingCache());
                        childAt.setDrawingCacheEnabled(false);
                        ImageView imageView = new ImageView(activity);
                        imageView.setImageBitmap(bitmapCreateBitmap);
                        imageView.setVisibility(0);
                        ((ViewGroup) rootView).addView(imageView, new ViewGroup.LayoutParams(-1, -1));
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    private static boolean z() {
        return z;
    }

    public static void z(final com.bytedance.sdk.component.i.dl dlVar) {
        com.bytedance.sdk.openadsdk.hh.e.z(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.oq.2
            @Override // java.lang.Runnable
            public void run() {
                oq.dl(dlVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void dl(com.bytedance.sdk.component.i.dl dlVar) {
        if (dlVar == null) {
            return;
        }
        dlVar.setWebChromeClient(null);
        dlVar.setWebViewClient(null);
        View view = dlVar.getView();
        ViewParent parent = view.getParent();
        if (parent != null && (parent instanceof ViewGroup)) {
            ((ViewGroup) parent).removeView(view);
        }
        dlVar.removeAllViews();
        try {
            dlVar.destroy();
        } catch (Throwable unused) {
        }
    }
}
