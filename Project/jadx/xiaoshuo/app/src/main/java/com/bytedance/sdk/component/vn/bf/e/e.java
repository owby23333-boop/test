package com.bytedance.sdk.component.vn.bf.e;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.keva.Keva;
import com.bytedance.keva.KevaBuilder;
import com.bytedance.keva.KevaMonitor;
import com.bytedance.sdk.component.vn.d;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class e implements com.bytedance.sdk.component.vn.bf.e {
    private static final Map<String, com.bytedance.sdk.component.vn.e> bf = new HashMap();
    private static volatile boolean d = false;
    private static volatile boolean tg = true;
    private Keva e;

    private e(String str, boolean z) {
        if (z) {
            this.e = Keva.getRepo(str, 1);
        } else {
            this.e = Keva.getRepo(str, 0);
        }
    }

    @Override // com.bytedance.sdk.component.vn.e
    public int bf(String str, int i) {
        return this.e.getInt(str, i);
    }

    public static com.bytedance.sdk.component.vn.e e(Context context, String str, boolean z) {
        if (!tg) {
            return null;
        }
        try {
            if (!d) {
                d = e(context);
            }
            if (TextUtils.isEmpty(str)) {
                str = "tt_ad_sdk_keva";
            }
            Map<String, com.bytedance.sdk.component.vn.e> map = bf;
            com.bytedance.sdk.component.vn.e eVar = map.get(str);
            if (eVar != null) {
                return eVar;
            }
            e eVar2 = new e(str, z);
            map.put(str, eVar2);
            return eVar2;
        } catch (Throwable unused) {
            tg = false;
            return null;
        }
    }

    @Override // com.bytedance.sdk.component.vn.e
    public long bf(String str, long j) {
        return this.e.getLong(str, j);
    }

    @Override // com.bytedance.sdk.component.vn.e
    public float bf(String str, float f) {
        return this.e.getFloat(str, f);
    }

    @Override // com.bytedance.sdk.component.vn.e
    public boolean bf(String str, boolean z) {
        return this.e.getBoolean(str, z);
    }

    @Override // com.bytedance.sdk.component.vn.e
    public String bf(String str, String str2) {
        return this.e.getString(str, str2);
    }

    @Override // com.bytedance.sdk.component.vn.e
    public Set<String> bf(String str, Set<String> set) {
        return this.e.getStringSet(str, set);
    }

    @Override // com.bytedance.sdk.component.vn.e
    public void bf() {
        this.e.clear();
    }

    private static boolean e(Context context) {
        if (context == null) {
            context = d.getContext();
        }
        if (context == null) {
            return false;
        }
        KevaBuilder kevaBuilder = KevaBuilder.getInstance();
        kevaBuilder.setMonitor(new KevaMonitor() { // from class: com.bytedance.sdk.component.vn.bf.e.e.1
            @Override // com.bytedance.keva.KevaMonitor
            public void loadLibrary(String str) {
                try {
                    super.loadLibrary(str);
                } catch (Throwable th) {
                    boolean unused = e.tg = false;
                    reportThrowable(1, null, null, null, th);
                }
            }

            @Override // com.bytedance.keva.KevaMonitor
            public void logDebug(String str) {
            }

            @Override // com.bytedance.keva.KevaMonitor
            public void onLoadRepo(String str, int i) {
            }

            @Override // com.bytedance.keva.KevaMonitor
            public void reportThrowable(int i, String str, String str2, Object obj, Throwable th) {
            }

            @Override // com.bytedance.keva.KevaMonitor
            public void reportWarning(int i, String str, String str2, Object obj, String str3) {
            }
        });
        kevaBuilder.setContext(context);
        return true;
    }

    @Override // com.bytedance.sdk.component.vn.e
    public void e(String str, int i) {
        this.e.storeInt(str, i);
    }

    @Override // com.bytedance.sdk.component.vn.e
    public void e(String str, long j) {
        this.e.storeLong(str, j);
    }

    @Override // com.bytedance.sdk.component.vn.e
    public void e(String str, float f) {
        this.e.storeFloat(str, f);
    }

    @Override // com.bytedance.sdk.component.vn.e
    public void e(String str, boolean z) {
        this.e.storeBoolean(str, z);
    }

    @Override // com.bytedance.sdk.component.vn.e
    public void e(String str, String str2) {
        this.e.storeString(str, str2);
    }

    @Override // com.bytedance.sdk.component.vn.e
    public void e(String str, Set<String> set) {
        this.e.storeStringSet(str, set);
    }

    @Override // com.bytedance.sdk.component.vn.e
    public Map<String, ?> e() {
        return this.e.getAll();
    }

    @Override // com.bytedance.sdk.component.vn.e
    public void e(String str) {
        this.e.erase(str);
    }
}
