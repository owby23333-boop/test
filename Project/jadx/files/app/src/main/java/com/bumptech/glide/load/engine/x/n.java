package com.bumptech.glide.load.engine.x;

import android.graphics.Bitmap;
import android.os.Build;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import com.umeng.message.proguard.ad;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/* JADX INFO: compiled from: SizeConfigStrategy.java */
/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(19)
public class n implements l {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Bitmap.Config[] f13627d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Bitmap.Config[] f13628e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Bitmap.Config[] f13629f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Bitmap.Config[] f13630g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final Bitmap.Config[] f13631h;
    private final c a = new c();
    private final h<b, Bitmap> b = new h<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map<Bitmap.Config, NavigableMap<Integer, Integer>> f13632c = new HashMap();

    /* JADX INFO: compiled from: SizeConfigStrategy.java */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a = new int[Bitmap.Config.values().length];

        static {
            try {
                a[Bitmap.Config.ARGB_8888.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[Bitmap.Config.RGB_565.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[Bitmap.Config.ARGB_4444.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[Bitmap.Config.ALPHA_8.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: compiled from: SizeConfigStrategy.java */
    @VisibleForTesting
    static class c extends d<b> {
        c() {
        }

        public b a(int i2, Bitmap.Config config) {
            b bVarB = b();
            bVarB.a(i2, config);
            return bVarB;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.bumptech.glide.load.engine.x.d
        public b a() {
            return new b(this);
        }
    }

    static {
        Bitmap.Config[] configArr = {Bitmap.Config.ARGB_8888, null};
        if (Build.VERSION.SDK_INT >= 26) {
            configArr = (Bitmap.Config[]) Arrays.copyOf(configArr, configArr.length + 1);
            configArr[configArr.length - 1] = Bitmap.Config.RGBA_F16;
        }
        f13627d = configArr;
        f13628e = f13627d;
        f13629f = new Bitmap.Config[]{Bitmap.Config.RGB_565};
        f13630g = new Bitmap.Config[]{Bitmap.Config.ARGB_4444};
        f13631h = new Bitmap.Config[]{Bitmap.Config.ALPHA_8};
    }

    private NavigableMap<Integer, Integer> b(Bitmap.Config config) {
        NavigableMap<Integer, Integer> navigableMap = this.f13632c.get(config);
        if (navigableMap != null) {
            return navigableMap;
        }
        TreeMap treeMap = new TreeMap();
        this.f13632c.put(config, treeMap);
        return treeMap;
    }

    @Override // com.bumptech.glide.load.engine.x.l
    public void a(Bitmap bitmap) {
        b bVarA = this.a.a(com.bumptech.glide.util.l.a(bitmap), bitmap.getConfig());
        this.b.a(bVarA, bitmap);
        NavigableMap<Integer, Integer> navigableMapB = b(bitmap.getConfig());
        Integer num = (Integer) navigableMapB.get(Integer.valueOf(bVarA.b));
        navigableMapB.put(Integer.valueOf(bVarA.b), Integer.valueOf(num != null ? 1 + num.intValue() : 1));
    }

    @Override // com.bumptech.glide.load.engine.x.l
    public int c(Bitmap bitmap) {
        return com.bumptech.glide.util.l.a(bitmap);
    }

    @Override // com.bumptech.glide.load.engine.x.l
    @Nullable
    public Bitmap removeLast() {
        Bitmap bitmapA = this.b.a();
        if (bitmapA != null) {
            a(Integer.valueOf(com.bumptech.glide.util.l.a(bitmapA)), bitmapA);
        }
        return bitmapA;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SizeConfigStrategy{groupedMap=");
        sb.append(this.b);
        sb.append(", sortedSizes=(");
        for (Map.Entry<Bitmap.Config, NavigableMap<Integer, Integer>> entry : this.f13632c.entrySet()) {
            sb.append(entry.getKey());
            sb.append('[');
            sb.append(entry.getValue());
            sb.append("], ");
        }
        if (!this.f13632c.isEmpty()) {
            sb.replace(sb.length() - 2, sb.length(), "");
        }
        sb.append(")}");
        return sb.toString();
    }

    /* JADX INFO: compiled from: SizeConfigStrategy.java */
    @VisibleForTesting
    static final class b implements m {
        private final c a;
        int b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Bitmap.Config f13633c;

        public b(c cVar) {
            this.a = cVar;
        }

        public void a(int i2, Bitmap.Config config) {
            this.b = i2;
            this.f13633c = config;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.b == bVar.b && com.bumptech.glide.util.l.b(this.f13633c, bVar.f13633c);
        }

        public int hashCode() {
            int i2 = this.b * 31;
            Bitmap.Config config = this.f13633c;
            return i2 + (config != null ? config.hashCode() : 0);
        }

        public String toString() {
            return n.b(this.b, this.f13633c);
        }

        @Override // com.bumptech.glide.load.engine.x.m
        public void a() {
            this.a.a(this);
        }
    }

    @Override // com.bumptech.glide.load.engine.x.l
    public String b(Bitmap bitmap) {
        return b(com.bumptech.glide.util.l.a(bitmap), bitmap.getConfig());
    }

    @Override // com.bumptech.glide.load.engine.x.l
    public String b(int i2, int i3, Bitmap.Config config) {
        return b(com.bumptech.glide.util.l.a(i2, i3, config), config);
    }

    @Override // com.bumptech.glide.load.engine.x.l
    @Nullable
    public Bitmap a(int i2, int i3, Bitmap.Config config) {
        b bVarA = a(com.bumptech.glide.util.l.a(i2, i3, config), config);
        Bitmap bitmapA = this.b.a(bVarA);
        if (bitmapA != null) {
            a(Integer.valueOf(bVarA.b), bitmapA);
            bitmapA.reconfigure(i2, i3, config);
        }
        return bitmapA;
    }

    static String b(int i2, Bitmap.Config config) {
        return "[" + i2 + "](" + config + ad.f20406s;
    }

    private b a(int i2, Bitmap.Config config) {
        b bVarA = this.a.a(i2, config);
        for (Bitmap.Config config2 : a(config)) {
            Integer numCeilingKey = b(config2).ceilingKey(Integer.valueOf(i2));
            if (numCeilingKey != null && numCeilingKey.intValue() <= i2 * 8) {
                if (numCeilingKey.intValue() == i2) {
                    if (config2 == null) {
                        if (config == null) {
                            return bVarA;
                        }
                    } else if (config2.equals(config)) {
                        return bVarA;
                    }
                }
                this.a.a(bVarA);
                return this.a.a(numCeilingKey.intValue(), config2);
            }
        }
        return bVarA;
    }

    private void a(Integer num, Bitmap bitmap) {
        NavigableMap<Integer, Integer> navigableMapB = b(bitmap.getConfig());
        Integer num2 = (Integer) navigableMapB.get(num);
        if (num2 != null) {
            if (num2.intValue() == 1) {
                navigableMapB.remove(num);
                return;
            } else {
                navigableMapB.put(num, Integer.valueOf(num2.intValue() - 1));
                return;
            }
        }
        throw new NullPointerException("Tried to decrement empty size, size: " + num + ", removed: " + b(bitmap) + ", this: " + this);
    }

    private static Bitmap.Config[] a(Bitmap.Config config) {
        if (Build.VERSION.SDK_INT >= 26 && Bitmap.Config.RGBA_F16.equals(config)) {
            return f13628e;
        }
        int i2 = a.a[config.ordinal()];
        if (i2 == 1) {
            return f13627d;
        }
        if (i2 == 2) {
            return f13629f;
        }
        if (i2 != 3) {
            return i2 != 4 ? new Bitmap.Config[]{config} : f13631h;
        }
        return f13630g;
    }
}
