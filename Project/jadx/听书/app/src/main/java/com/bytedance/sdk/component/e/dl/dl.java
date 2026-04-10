package com.bytedance.sdk.component.e.dl;

import android.content.SharedPreferences;
import androidx.core.app.NotificationCompat;
import com.bytedance.sdk.component.a.e;
import com.bytedance.sdk.component.uy.uy;
import com.funny.audio.core.utils.FileUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class dl implements com.bytedance.sdk.component.a.g.dl {
    private static int g = 3;
    private static ThreadPoolExecutor z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final File f701a;
    private final File dl;
    private long fo;
    private volatile boolean gz;
    private long kb;
    private final boolean v;
    private final com.bytedance.sdk.component.e.g wp;
    private final Object gc = new Object();
    private final Map<String, Object> m = new ConcurrentHashMap();
    private Map<String, Object> e = new HashMap();
    private final List<Runnable> uy = new ArrayList();
    private AtomicBoolean i = new AtomicBoolean(false);

    @Override // com.bytedance.sdk.component.a.g.dl, android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
    }

    @Override // com.bytedance.sdk.component.a.g.dl, android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
    }

    static /* synthetic */ long dl(dl dlVar) {
        long j = dlVar.fo;
        dlVar.fo = 1 + j;
        return j;
    }

    public dl(File file, com.bytedance.sdk.component.e.z zVar, com.bytedance.sdk.component.e.g gVar, boolean z2) {
        this.gz = false;
        this.v = z2;
        File file2 = new File(file.getParent(), file.getName() + ".prop");
        if (file2.exists() && file2.length() > 0) {
            zVar = new com.bytedance.sdk.component.e.dl.z(null);
            file = file2;
        }
        this.dl = file;
        this.f701a = new File(file.getPath() + ".bak");
        this.gz = false;
        zVar = zVar == null ? new com.bytedance.sdk.component.e.dl.z(null) : zVar;
        if (gVar == null) {
            this.wp = new com.bytedance.sdk.component.e.dl.z(null);
        } else {
            this.wp = gVar;
        }
        z(zVar);
    }

    private void z(final com.bytedance.sdk.component.e.z zVar) {
        synchronized (this.gc) {
            this.gz = false;
        }
        dl().execute(new Runnable() { // from class: com.bytedance.sdk.component.e.dl.dl.1
            @Override // java.lang.Runnable
            public void run() {
                dl.this.g(zVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(com.bytedance.sdk.component.e.z zVar) {
        Map<String, Object> mapZ;
        synchronized (this.gc) {
            if (this.gz) {
                return;
            }
            if (this.f701a.exists()) {
                this.dl.delete();
                this.f701a.renameTo(this.dl);
            }
            try {
                mapZ = zVar.z(this.dl);
            } catch (Throwable th) {
                z("loadFromDisk error", th);
                mapZ = null;
            }
            synchronized (this.gc) {
                this.gz = true;
                if (mapZ != null) {
                    try {
                        for (Map.Entry<String, Object> entry : mapZ.entrySet()) {
                            Object value = entry.getValue();
                            if (value != null) {
                                String key = entry.getKey();
                                if (key == null) {
                                    key = "";
                                }
                                this.m.put(key, value);
                            }
                        }
                    } finally {
                        this.gc.notifyAll();
                    }
                }
            }
            synchronized (this.uy) {
                Iterator<Runnable> it = this.uy.iterator();
                while (it.hasNext()) {
                    it.next().run();
                }
                this.uy.clear();
            }
        }
    }

    private void g() {
        while (!this.gz) {
            try {
                this.gc.wait();
            } catch (InterruptedException unused) {
            }
        }
    }

    private static ThreadPoolExecutor dl() {
        ThreadPoolExecutor threadPoolExecutor = z;
        if (threadPoolExecutor != null) {
            return threadPoolExecutor;
        }
        synchronized (dl.class) {
            ThreadPoolExecutor threadPoolExecutor2 = z;
            if (threadPoolExecutor2 != null) {
                return threadPoolExecutor2;
            }
            int i = g;
            com.bytedance.sdk.component.uy.a.a aVar = new com.bytedance.sdk.component.uy.a.a(i, i, 1000L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new uy("SharedPreferencesImpl"));
            z = aVar;
            return aVar;
        }
    }

    @Override // com.bytedance.sdk.component.a.g.dl, android.content.SharedPreferences
    public Map<String, ?> getAll() {
        Map<String, ?> mapA;
        if (this.v) {
            synchronized (this.gc) {
                g();
                mapA = a();
            }
            return mapA;
        }
        return a();
    }

    private Map<String, ?> a() {
        HashMap map = new HashMap(this.m);
        map.putAll(this.e);
        return map;
    }

    @Override // com.bytedance.sdk.component.a.g.dl, android.content.SharedPreferences
    public String getString(String str, String str2) {
        String strZ;
        if (str == null) {
            str = "";
        }
        if (this.v) {
            synchronized (this.gc) {
                g();
                strZ = z(str, str2);
            }
            return strZ;
        }
        return z(str, str2);
    }

    private String z(String str, String str2) {
        try {
            Object obj = this.e.get(str);
            if (obj == null) {
                obj = this.m.get(str);
            }
            return obj != null ? String.valueOf(obj) : str2;
        } catch (Exception e) {
            z("getValue error key =".concat(String.valueOf(str)), (Throwable) e);
            return str2;
        }
    }

    @Override // com.bytedance.sdk.component.a.g.dl, android.content.SharedPreferences
    public Set<String> getStringSet(String str, Set<String> set) {
        Set<String> setZ;
        if (str == null) {
            str = "";
        }
        if (this.v) {
            synchronized (this.gc) {
                g();
                setZ = z(str, set);
            }
            return setZ;
        }
        return z(str, set);
    }

    private Set<String> z(String str, Set<String> set) {
        try {
            Set<String> set2 = (Set) this.e.get(str);
            if (set2 == null) {
                set2 = (Set) this.m.get(str);
            }
            return set2 != null ? set2 : set;
        } catch (Exception e) {
            z("getValue error key =".concat(String.valueOf(str)), (Throwable) e);
            return set;
        }
    }

    @Override // com.bytedance.sdk.component.a.g.dl, android.content.SharedPreferences
    public int getInt(String str, int i) {
        int iZ;
        if (str == null) {
            str = "";
        }
        if (this.v) {
            synchronized (this.gc) {
                g();
                iZ = z(str, i);
            }
            return iZ;
        }
        return z(str, i);
    }

    private int z(String str, int i) {
        try {
            Object obj = this.e.get(str);
            if (obj == null) {
                obj = this.m.get(str);
            }
            if (obj instanceof Integer) {
                return ((Integer) obj).intValue();
            }
            if (obj instanceof Float) {
                return ((Float) obj).intValue();
            }
            return obj != null ? ((Integer) obj).intValue() : i;
        } catch (Exception e) {
            z("getValue error key =".concat(String.valueOf(str)), (Throwable) e);
            return i;
        }
    }

    @Override // com.bytedance.sdk.component.a.g.dl, android.content.SharedPreferences
    public long getLong(String str, long j) {
        long jZ;
        if (str == null) {
            str = "";
        }
        if (this.v) {
            synchronized (this.gc) {
                g();
                jZ = z(str, j);
            }
            return jZ;
        }
        return z(str, j);
    }

    private long z(String str, long j) {
        try {
            Long l = (Long) this.e.get(str);
            if (l == null) {
                l = (Long) this.m.get(str);
            }
            return l != null ? l.longValue() : j;
        } catch (Exception e) {
            z("getValue error key =".concat(String.valueOf(str)), (Throwable) e);
            return j;
        }
    }

    @Override // com.bytedance.sdk.component.a.g.dl, android.content.SharedPreferences
    public float getFloat(String str, float f) {
        float fZ;
        if (str == null) {
            str = "";
        }
        if (this.v) {
            synchronized (this.gc) {
                g();
                fZ = z(str, f);
            }
            return fZ;
        }
        return z(str, f);
    }

    private float z(String str, float f) {
        try {
            Object obj = this.e.get(str);
            if (obj == null) {
                obj = this.m.get(str);
            }
            if (obj instanceof Integer) {
                return ((Integer) obj).floatValue();
            }
            if (obj instanceof Float) {
                return ((Float) obj).floatValue();
            }
            return obj != null ? ((Float) obj).floatValue() : f;
        } catch (Exception e) {
            z("getValue error key =".concat(String.valueOf(str)), (Throwable) e);
            return f;
        }
    }

    @Override // com.bytedance.sdk.component.a.g.dl, android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z2) {
        boolean z3;
        if (str == null) {
            str = "";
        }
        if (this.v) {
            synchronized (this.gc) {
                g();
                z3 = z(str, z2);
            }
            return z3;
        }
        return z(str, z2);
    }

    private boolean z(String str, boolean z2) {
        try {
            Boolean bool = (Boolean) this.e.get(str);
            if (bool == null) {
                bool = (Boolean) this.m.get(str);
            }
            return bool != null ? bool.booleanValue() : z2;
        } catch (Exception e) {
            z("getValue error key =".concat(String.valueOf(str)), (Throwable) e);
            return z2;
        }
    }

    @Override // com.bytedance.sdk.component.a.g.dl, android.content.SharedPreferences
    public boolean contains(String str) {
        boolean zContainsKey;
        if (str == null) {
            str = "";
        }
        synchronized (this.gc) {
            g();
            zContainsKey = this.m.containsKey(str);
        }
        return zContainsKey;
    }

    @Override // com.bytedance.sdk.component.a.g.dl, android.content.SharedPreferences
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public z edit() {
        synchronized (this.gc) {
            g();
        }
        return new z();
    }

    private void z(Runnable runnable) {
        synchronized (this.uy) {
            if (this.gz) {
                runnable.run();
            } else {
                this.uy.add(runnable);
            }
        }
    }

    @Override // com.bytedance.sdk.component.a.g.dl
    public int get(String str, int i) {
        return getInt(str, i);
    }

    @Override // com.bytedance.sdk.component.a.g.dl
    public long get(String str, long j) {
        return getLong(str, j);
    }

    @Override // com.bytedance.sdk.component.a.g.dl
    public float get(String str, float f) {
        return getFloat(str, f);
    }

    @Override // com.bytedance.sdk.component.a.g.dl
    public boolean get(String str, boolean z2) {
        return getBoolean(str, z2);
    }

    @Override // com.bytedance.sdk.component.a.g.dl
    public String get(String str, String str2) {
        return getString(str, str2);
    }

    @Override // com.bytedance.sdk.component.a.g.dl
    public Set<String> get(String str, Set<String> set) {
        return getStringSet(str, set);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public <T> void z(String str, T t) {
        if (str == null) {
            str = "";
        }
        synchronized ("SharedPreferencesImpl") {
            this.e.put(str, t);
            this.fo++;
        }
    }

    @Override // com.bytedance.sdk.component.a.g.dl
    public void put(String str, int i) {
        z(str, Integer.valueOf(i));
    }

    @Override // com.bytedance.sdk.component.a.g.dl
    public void put(String str, long j) {
        z(str, Long.valueOf(j));
    }

    @Override // com.bytedance.sdk.component.a.g.dl
    public void put(String str, float f) {
        z(str, Float.valueOf(f));
    }

    @Override // com.bytedance.sdk.component.a.g.dl
    public void put(String str, boolean z2) {
        z(str, Boolean.valueOf(z2));
    }

    @Override // com.bytedance.sdk.component.a.g.dl
    public void put(String str, String str2) {
        z(str, str2);
    }

    @Override // com.bytedance.sdk.component.a.g.dl
    public void put(String str, Set<String> set) {
        z(str, set);
    }

    @Override // com.bytedance.sdk.component.a.g.dl
    public void remove(String str) {
        synchronized ("SharedPreferencesImpl") {
            this.e.put(str, null);
            this.fo++;
        }
    }

    @Override // com.bytedance.sdk.component.a.g.dl
    public void clear() {
        if (this.gz) {
            this.m.clear();
            synchronized ("SharedPreferencesImpl") {
                this.e.clear();
                this.fo++;
            }
            return;
        }
        z(new Runnable() { // from class: com.bytedance.sdk.component.e.dl.dl.2
            @Override // java.lang.Runnable
            public void run() {
                dl.this.m.clear();
                synchronized ("SharedPreferencesImpl") {
                    dl.this.e.clear();
                    dl.dl(dl.this);
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.a.g.dl
    public void apply() {
        if (!this.gz) {
            if (this.i.compareAndSet(false, true)) {
                z(new Runnable() { // from class: com.bytedance.sdk.component.e.dl.dl.3
                    @Override // java.lang.Runnable
                    public void run() {
                        dl.this.i.set(false);
                        dl.this.apply();
                    }
                });
            }
        } else if (this.kb != this.fo && this.i.compareAndSet(false, true)) {
            dl().execute(new Runnable() { // from class: com.bytedance.sdk.component.e.dl.dl.4
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        Map<String, Object> mapGc = dl.this.gc();
                        if (mapGc != null) {
                            dl.this.wp.z(mapGc, dl.this.dl);
                        }
                        dl.this.i.set(false);
                    } catch (Exception e) {
                        dl.this.z("apply write error", (Throwable) e);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, Object> gc() {
        HashMap map;
        synchronized ("SharedPreferencesImpl") {
            map = new HashMap(this.e);
            this.e = new HashMap();
        }
        HashMap map2 = new HashMap(this.m);
        if (map.isEmpty() && map2.isEmpty()) {
            return map2;
        }
        int i = 0;
        for (Map.Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            Object value = entry.getValue();
            Object obj = map2.get(str);
            if (value == null) {
                if (obj != null) {
                    map2.remove(str);
                    i++;
                }
            } else if (!value.equals(obj)) {
                map2.put(str, value);
                i++;
            }
        }
        if (i > 0) {
            return map2;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(String str, Throwable th) {
        e eVar = (e) com.bytedance.sdk.openadsdk.ats.dl.z(NotificationCompat.CATEGORY_EVENT);
        if (eVar != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(FileUtils.URI_TYPE_FILE, this.dl.getAbsolutePath());
                jSONObject.put(NotificationCompat.CATEGORY_MESSAGE, str);
                jSONObject.put("class", "SharedPreferencesImpl");
            } catch (JSONException unused) {
            }
            eVar.onExceptionEvent("kv", jSONObject, th);
        }
    }

    @Override // com.bytedance.sdk.component.a.g.dl
    public void applySync() {
        if (!this.gz) {
            if (this.i.compareAndSet(false, true)) {
                z(new Runnable() { // from class: com.bytedance.sdk.component.e.dl.dl.5
                    @Override // java.lang.Runnable
                    public void run() {
                        dl.this.i.set(false);
                        dl.this.applySync();
                    }
                });
            }
        } else if (this.i.compareAndSet(false, true)) {
            try {
                Map<String, Object> mapGc = gc();
                if (mapGc != null) {
                    this.wp.z(mapGc, this.dl);
                }
                this.i.set(false);
            } catch (Exception e) {
                z("applySync write error", (Throwable) e);
            }
        }
    }

    public final class z implements SharedPreferences.Editor {
        @Override // android.content.SharedPreferences.Editor
        public boolean commit() {
            return true;
        }

        public z() {
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putString(String str, String str2) {
            dl.this.z(str, str2);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putStringSet(String str, Set<String> set) {
            dl.this.z(str, set);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putInt(String str, int i) {
            dl.this.z(str, Integer.valueOf(i));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putLong(String str, long j) {
            dl.this.z(str, Long.valueOf(j));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putFloat(String str, float f) {
            dl.this.z(str, Float.valueOf(f));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putBoolean(String str, boolean z) {
            dl.this.z(str, Boolean.valueOf(z));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor remove(String str) {
            dl.this.remove(str);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor clear() {
            try {
                dl.dl(dl.this);
                dl.this.e.clear();
            } catch (Exception unused) {
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public void apply() {
            dl.this.apply();
        }
    }
}
