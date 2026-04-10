package com.bytedance.sdk.component.utils;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
public class g {

    public interface z {
        void z();

        void z(Throwable th);
    }

    public static boolean z(Context context, Intent intent, z zVar) {
        if (context != null && intent != null) {
            try {
                if (!(context instanceof Activity)) {
                    intent.addFlags(268435456);
                }
                context.startActivity(intent);
                if (zVar == null) {
                    return true;
                }
                zVar.z();
                return true;
            } catch (Throwable th) {
                if (zVar != null) {
                    zVar.z(th);
                }
            }
        }
        return false;
    }

    public static boolean z(Context context, Intent intent, z zVar, boolean z2) {
        if (context == null || intent == null) {
            return false;
        }
        if (z2) {
            intent.putExtra("start_only_for_android", true);
        }
        return z(context, intent, zVar);
    }

    public static void startActivity(Context context, Intent intent, boolean z2) {
        if (context == null || intent == null) {
            return;
        }
        if (z2) {
            intent.putExtra("start_only_for_android", true);
        }
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }

    public static Activity z(View view) {
        View viewFindViewById;
        Context context;
        if (view == null) {
            return null;
        }
        Context context2 = view.getContext();
        if (context2 instanceof Activity) {
            return (Activity) context2;
        }
        View rootView = view.getRootView();
        if (rootView == null || (viewFindViewById = rootView.findViewById(R.id.content)) == null || (context = viewFindViewById.getContext()) == null) {
            return null;
        }
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            Context baseContext = ((ContextWrapper) context).getBaseContext();
            if (baseContext instanceof Activity) {
                return (Activity) baseContext;
            }
        }
        return null;
    }
}
