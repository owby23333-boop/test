package com.yuewen;

import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public class by3 implements SharedPreferences {
    public static final String h = "TaskQueueSp";
    public static final Boolean i = Boolean.FALSE;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f9471a = new AtomicBoolean(false);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentLinkedQueue<Runnable> f9472b = new ConcurrentLinkedQueue<>();
    public final CountDownLatch c = new CountDownLatch(1);
    public final SharedPreferences d;
    public final AtomicInteger e;
    public final Set<String> f;
    public final Runnable g;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (by3.i.booleanValue()) {
                qt1.a(by3.h, "等待SP加载，并执行队列...");
            }
            by3.this.f9471a.set(true);
            while (true) {
                Runnable runnable = (Runnable) by3.this.f9472b.poll();
                if (runnable == null) {
                    break;
                } else {
                    runnable.run();
                }
            }
            by3.this.f.clear();
            by3.this.c.countDown();
            if (by3.i.booleanValue()) {
                qt1.a(by3.h, "执行完毕...");
            }
        }
    }

    public final class b implements SharedPreferences.Editor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final SharedPreferences.Editor f9474a;

        public b(SharedPreferences.Editor editor) {
            this.f9474a = editor;
        }

        @Override // android.content.SharedPreferences.Editor
        public void apply() {
            this.f9474a.apply();
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor clear() {
            return this.f9474a.clear();
        }

        @Override // android.content.SharedPreferences.Editor
        public boolean commit() {
            return this.f9474a.commit();
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putBoolean(String str, boolean z) {
            by3.this.h(str);
            return this.f9474a.putBoolean(str, z);
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putFloat(String str, float f) {
            by3.this.h(str);
            return this.f9474a.putFloat(str, f);
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putInt(String str, int i) {
            by3.this.h(str);
            return this.f9474a.putInt(str, i);
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putLong(String str, long j) {
            by3.this.h(str);
            return this.f9474a.putLong(str, j);
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putString(String str, @Nullable String str2) {
            by3.this.h(str);
            return this.f9474a.putString(str, str2);
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putStringSet(String str, @Nullable Set<String> set) {
            by3.this.h(str);
            return this.f9474a.putStringSet(str, set);
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor remove(String str) {
            by3.this.h(str);
            return this.f9474a.remove(str);
        }
    }

    public by3(kv3<SharedPreferences> kv3Var) {
        AtomicInteger atomicInteger = new AtomicInteger();
        this.e = atomicInteger;
        this.f = new HashSet();
        a aVar = new a();
        this.g = aVar;
        this.d = kv3Var.get();
        Thread thread = new Thread(aVar);
        atomicInteger.set(thread.hashCode());
        thread.start();
    }

    @Override // android.content.SharedPreferences
    public boolean contains(String str) {
        i(str);
        return this.d.contains(str);
    }

    @Override // android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        i(null);
        return new b(this.d.edit());
    }

    public void g(String str) {
        this.f.add(str);
    }

    @Override // android.content.SharedPreferences
    public Map<String, ?> getAll() {
        return new HashMap();
    }

    @Override // android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z) {
        i(str);
        return this.d.getBoolean(str, z);
    }

    @Override // android.content.SharedPreferences
    public float getFloat(String str, float f) {
        i(str);
        return this.d.getFloat(str, f);
    }

    @Override // android.content.SharedPreferences
    public int getInt(String str, int i2) {
        i(str);
        return this.d.getInt(str, i2);
    }

    @Override // android.content.SharedPreferences
    public long getLong(String str, long j) {
        i(str);
        return this.d.getLong(str, j);
    }

    @Override // android.content.SharedPreferences
    @Nullable
    public String getString(String str, @Nullable String str2) {
        i(str);
        return this.d.getString(str, str2);
    }

    @Override // android.content.SharedPreferences
    @Nullable
    public Set<String> getStringSet(String str, @Nullable Set<String> set) {
        i(str);
        return this.d.getStringSet(str, set);
    }

    public final void h(String str) {
        if (this.f.isEmpty()) {
            return;
        }
        this.f.remove(str);
    }

    public void i(String str) {
        if (this.f9472b.isEmpty()) {
            if (i.booleanValue()) {
                qt1.a(h, "队列任务空 不必等待...");
                return;
            }
            return;
        }
        if (!TextUtils.isEmpty(str) && !this.f.contains(str)) {
            if (i.booleanValue()) {
                qt1.a(h, "非启动key，不必等待...");
            }
        } else {
            if (Thread.currentThread().hashCode() == this.e.get()) {
                if (i.booleanValue()) {
                    qt1.a(h, "队列任务不必等待...");
                    return;
                }
                return;
            }
            if (i.booleanValue()) {
                qt1.a(h, "非队列任务排队...");
            }
            try {
                this.c.await();
            } catch (Exception e) {
                qt1.p(e);
            }
            if (i.booleanValue()) {
                qt1.a(h, "非队列任务执行 ...");
            }
        }
    }

    public void j(Runnable runnable) {
        if (this.f9471a.get()) {
            if (i.booleanValue()) {
                qt1.a(h, "sp已加载，直接执行...");
            }
            runnable.run();
        } else {
            if (i.booleanValue()) {
                qt1.a(h, "sp加载中，先入队...");
            }
            this.f9472b.add(runnable);
        }
    }

    @Override // android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.d.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    @Override // android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.d.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }
}
