package com.kwad.sdk.core.threads;

import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.sdk.utils.bk;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class a {
    private static Map<String, WeakReference<C0444a>> alJ = new ConcurrentHashMap();

    /* JADX INFO: renamed from: com.kwad.sdk.core.threads.a$a, reason: collision with other inner class name */
    public static class C0444a {
        private HandlerThread alK;
        private Handler mHandler;

        public C0444a(String str) {
            String str2;
            if (TextUtils.isEmpty(str)) {
                str2 = "ksad-HT";
            } else {
                str2 = "ksad-" + str;
            }
            this.alK = new HandlerThread(str2);
            this.alK.start();
            this.mHandler = new Handler(this.alK.getLooper());
        }

        public final bk b(bk.a aVar) {
            return new bk(aVar, this.alK.getLooper());
        }

        public final Handler getHandler() {
            return this.mHandler;
        }
    }

    public static synchronized bk a(bk.a aVar) {
        return cq("commonHT").b(aVar);
    }

    @NonNull
    private static C0444a cq(String str) {
        WeakReference<C0444a> weakReference = alJ.get(str);
        if (weakReference != null && weakReference.get() != null) {
            return weakReference.get();
        }
        C0444a c0444a = new C0444a(str);
        alJ.put(str, new WeakReference<>(c0444a));
        return c0444a;
    }

    public static synchronized Handler xU() {
        return cq("commonHT").getHandler();
    }

    public static synchronized Handler xV() {
        return cq("reportHT").getHandler();
    }
}
