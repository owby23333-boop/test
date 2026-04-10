package com.kwad.sdk.utils;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.kwad.sdk.R;
import com.kwad.sdk.api.loader.Wrapper;

/* JADX INFO: loaded from: classes3.dex */
public final class u {
    private static Handler mHandler = new Handler(Looper.getMainLooper());
    private static volatile boolean GI = false;

    public static void F(Context context, String str) {
        c(context, str, R.layout.ksad_content_alliance_toast_2);
    }

    private static void a(Context context, String str, int i2, long j2) {
        if (com.kwad.b.kwai.a.XX.booleanValue() && !GI) {
            GI = true;
            View viewInflate = Wrapper.wrapInflaterIfNeed(LayoutInflater.from(context)).inflate(i2, (ViewGroup) null);
            ((TextView) viewInflate.findViewById(R.id.ksad_message_toast_txt)).setText(str);
            Toast toast = new Toast(context.getApplicationContext());
            toast.setGravity(17, 0, 0);
            toast.setDuration(0);
            toast.setView(viewInflate);
            toast.show();
            mHandler.postDelayed(new Runnable() { // from class: com.kwad.sdk.utils.u.1
                @Override // java.lang.Runnable
                public final void run() {
                    u.access$002(false);
                }
            }, j2);
        }
    }

    static /* synthetic */ boolean access$002(boolean z2) {
        GI = false;
        return false;
    }

    private static void c(Context context, String str, int i2) {
        a(context, str, i2, 800L);
    }

    public static void c(Context context, String str, long j2) {
        a(context, str, R.layout.ksad_content_alliance_toast_2, 0L);
    }

    public static void d(Context context, String str, int i2) {
        if (com.kwad.b.kwai.a.XX.booleanValue()) {
            View viewInflate = LayoutInflater.from(context).inflate(R.layout.ksad_content_alliance_toast, (ViewGroup) null);
            ((TextView) viewInflate.findViewById(R.id.ksad_message_toast_txt)).setText(str);
            Toast toast = new Toast(context);
            toast.setGravity(17, 0, 0);
            toast.setDuration(0);
            toast.setView(viewInflate);
            toast.show();
        }
    }

    public static void d(Context context, String str, long j2) {
        a(context, str, R.layout.ksad_toast_corner, 0L);
    }
}
