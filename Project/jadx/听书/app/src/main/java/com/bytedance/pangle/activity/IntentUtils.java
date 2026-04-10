package com.bytedance.pangle.activity;

import android.content.Intent;
import android.os.Bundle;
import com.bytedance.pangle.Zeus;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class IntentUtils {
    static HashMap<Long, WeakReference<Bundle>> z = new HashMap<>();

    public static void setUseMemory(Intent intent) {
        intent.putExtra("pangle_use_memory", System.currentTimeMillis());
    }

    public static void z(Intent intent, String str) {
        long longExtra = intent.getLongExtra("pangle_use_memory", 0L);
        if (Zeus.getPlugin(str).mUseMemoryForActivityIntent && longExtra == 0) {
            longExtra = System.currentTimeMillis();
        }
        if (longExtra != 0) {
            Bundle extras = intent.getExtras();
            intent.replaceExtras((Bundle) null);
            z(longExtra, extras);
            intent.putExtra("pangle_use_memory", longExtra);
        }
    }

    private static void z(long j, Bundle bundle) {
        z.put(Long.valueOf(j), new WeakReference<>(bundle));
    }

    public static void z(Intent intent) {
        Bundle bundleZ;
        long longExtra = intent.getLongExtra("pangle_use_memory", 0L);
        if (longExtra == 0 || (bundleZ = z(longExtra)) == null) {
            return;
        }
        intent.putExtras(bundleZ);
    }

    private static Bundle z(long j) {
        WeakReference<Bundle> weakReferenceRemove = z.remove(Long.valueOf(j));
        if (weakReferenceRemove != null) {
            return weakReferenceRemove.get();
        }
        return null;
    }
}
