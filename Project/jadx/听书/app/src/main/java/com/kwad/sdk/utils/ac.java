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

/* JADX INFO: loaded from: classes4.dex */
public final class ac {
    private static Handler iK = new Handler(Looper.getMainLooper());
    private static volatile boolean Mg = false;

    static /* synthetic */ boolean access$002(boolean z) {
        Mg = false;
        return false;
    }

    public static void Q(Context context, String str) {
        b(context, str, R.layout.ksad_content_alliance_toast_2);
    }

    public static void c(Context context, String str, long j) {
        a(context, str, R.layout.ksad_content_alliance_toast_2, 0L);
    }

    public static void d(Context context, String str, long j) {
        a(context, str, R.layout.ksad_toast_corner, 0L);
    }

    private static void b(Context context, String str, int i) {
        a(context, str, i, 800L);
    }

    private static void a(Context context, String str, int i, long j) {
        if (com.kwad.framework.a.a.akZ.booleanValue() && !Mg) {
            Mg = true;
            View viewInflate = com.kwad.sdk.o.m.inflate(context, i, null);
            ((TextView) viewInflate.findViewById(R.id.ksad_message_toast_txt)).setText(str);
            Toast toast = new Toast(context.getApplicationContext());
            toast.setGravity(17, 0, 0);
            toast.setDuration(0);
            toast.setView(viewInflate);
            toast.show();
            iK.postDelayed(new bg() { // from class: com.kwad.sdk.utils.ac.1
                @Override // com.kwad.sdk.utils.bg
                public final void doTask() {
                    ac.access$002(false);
                }
            }, j);
        }
    }

    public static void c(Context context, String str, int i) {
        if (com.kwad.framework.a.a.akZ.booleanValue()) {
            View viewInflate = LayoutInflater.from(context).inflate(R.layout.ksad_content_alliance_toast, (ViewGroup) null);
            ((TextView) viewInflate.findViewById(R.id.ksad_message_toast_txt)).setText(str);
            Toast toast = new Toast(context);
            toast.setGravity(17, 0, 0);
            toast.setDuration(0);
            toast.setView(viewInflate);
            toast.show();
        }
    }
}
