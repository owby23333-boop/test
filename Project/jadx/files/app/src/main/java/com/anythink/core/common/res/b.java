package com.anythink.core.common.res;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.anythink.core.common.b.n;
import com.anythink.core.common.res.image.a;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class b {
    private static final String b = "ImageLoader";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile b f7895c;
    Context a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Map<String, Integer> f7896d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private c<String, SoftReference<Bitmap>> f7897e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Object f7898f = new Object();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private LinkedHashMap<String, List<a>> f7899g = new LinkedHashMap<>();

    /* JADX INFO: renamed from: com.anythink.core.common.res.b$1, reason: invalid class name */
    final class AnonymousClass1 implements Runnable {
        final /* synthetic */ Bitmap a;
        final /* synthetic */ a b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f7900c;

        AnonymousClass1(Bitmap bitmap, a aVar, String str) {
            this.a = bitmap;
            this.b = aVar;
            this.f7900c = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Bitmap bitmap = this.a;
            if (bitmap != null) {
                this.b.onSuccess(this.f7900c, bitmap);
            } else {
                this.b.onFail(this.f7900c, "Bitmap load fail");
            }
        }
    }

    /* JADX INFO: renamed from: com.anythink.core.common.res.b$2, reason: invalid class name */
    final class AnonymousClass2 implements Runnable {
        final /* synthetic */ a a;
        final /* synthetic */ String b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f7902c;

        AnonymousClass2(a aVar, String str, String str2) {
            this.a = aVar;
            this.b = str;
            this.f7902c = str2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.onFail(this.b, this.f7902c);
        }
    }

    public interface a {
        void onFail(String str, String str2);

        void onSuccess(String str, Bitmap bitmap);
    }

    private b(Context context) {
        this.a = context.getApplicationContext();
        int iMaxMemory = ((int) Runtime.getRuntime().maxMemory()) / 5;
        StringBuilder sb = new StringBuilder("ImageLoad init cache size: ");
        sb.append(iMaxMemory);
        sb.append("B");
        this.f7897e = new c<String, SoftReference<Bitmap>>(iMaxMemory) { // from class: com.anythink.core.common.res.b.3
            @Override // com.anythink.core.common.res.c
            protected final /* synthetic */ int a(String str, SoftReference<Bitmap> softReference) {
                String str2 = str;
                SoftReference<Bitmap> softReference2 = softReference;
                Bitmap bitmap = softReference2 != null ? softReference2.get() : null;
                if (b.this.f7896d == null) {
                    b.this.f7896d = new HashMap(8);
                }
                if (bitmap != null) {
                    int rowBytes = bitmap.getRowBytes() * bitmap.getHeight();
                    b.this.f7896d.put(str2, Integer.valueOf(rowBytes));
                    return rowBytes;
                }
                Integer num = (Integer) b.this.f7896d.get(str2);
                if (num != null) {
                    return num.intValue();
                }
                return 0;
            }

            @Override // com.anythink.core.common.res.c
            protected final /* synthetic */ void a(boolean z2, String str, SoftReference<Bitmap> softReference, SoftReference<Bitmap> softReference2) {
                Bitmap bitmap;
                String str2 = str;
                SoftReference<Bitmap> softReference3 = softReference;
                SoftReference<Bitmap> softReference4 = softReference2;
                super.a(z2, str2, softReference3, softReference4);
                if (softReference3 != null) {
                    try {
                        bitmap = softReference3.get();
                    } catch (Exception unused) {
                        return;
                    }
                } else {
                    bitmap = null;
                }
                if (b.this.f7896d != null) {
                    b.this.f7896d.remove(str2);
                }
                if (softReference3 == null || softReference3.equals(softReference4) || bitmap == null || bitmap.isRecycled()) {
                    return;
                }
                bitmap.recycle();
            }

            /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
            private int a2(String str, SoftReference<Bitmap> softReference) {
                Bitmap bitmap = softReference != null ? softReference.get() : null;
                if (b.this.f7896d == null) {
                    b.this.f7896d = new HashMap(8);
                }
                if (bitmap == null) {
                    Integer num = (Integer) b.this.f7896d.get(str);
                    if (num != null) {
                        return num.intValue();
                    }
                    return 0;
                }
                int rowBytes = bitmap.getRowBytes() * bitmap.getHeight();
                b.this.f7896d.put(str, Integer.valueOf(rowBytes));
                return rowBytes;
            }

            /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
            private void a2(boolean z2, String str, SoftReference<Bitmap> softReference, SoftReference<Bitmap> softReference2) {
                Bitmap bitmap;
                super.a(z2, str, softReference, softReference2);
                if (softReference != null) {
                    try {
                        bitmap = softReference.get();
                    } catch (Exception unused) {
                        return;
                    }
                } else {
                    bitmap = null;
                }
                if (b.this.f7896d != null) {
                    b.this.f7896d.remove(str);
                }
                if (softReference == null || softReference.equals(softReference2) || bitmap == null || bitmap.isRecycled()) {
                    return;
                }
                bitmap.recycle();
            }
        };
    }

    private void b(String str, Bitmap bitmap) {
        synchronized (this.f7899g) {
            LinkedList<a> linkedList = (LinkedList) this.f7899g.remove(str);
            if (linkedList != null) {
                for (a aVar : linkedList) {
                    if (aVar != null) {
                        n.a().a(new AnonymousClass1(bitmap, aVar, str));
                    }
                }
            }
        }
    }

    private void a(String str, String str2) {
        synchronized (this.f7899g) {
            LinkedList<a> linkedList = (LinkedList) this.f7899g.remove(str);
            if (linkedList != null) {
                for (a aVar : linkedList) {
                    if (aVar != null) {
                        n.a().a(new AnonymousClass2(aVar, str, str2));
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: com.anythink.core.common.res.b$5, reason: invalid class name */
    final class AnonymousClass5 implements a.InterfaceC0171a {
        final /* synthetic */ int a;
        final /* synthetic */ int b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ e f7907c;

        AnonymousClass5(int i2, int i3, e eVar) {
            this.a = i2;
            this.b = i3;
            this.f7907c = eVar;
        }

        @Override // com.anythink.core.common.res.image.a.InterfaceC0171a
        public final void a(e eVar) {
            new StringBuilder("Load Success:").append(eVar.f7927f);
            Bitmap bitmapA = b.this.a(eVar, this.a, this.b);
            if (bitmapA != null) {
                b.this.a(eVar.f7927f, bitmapA);
            }
            b.a(b.this, this.f7907c.f7927f, bitmapA);
        }

        @Override // com.anythink.core.common.res.image.a.InterfaceC0171a
        public final void a(e eVar, String str) {
            b.a(b.this, eVar.f7927f, str);
        }
    }

    private void b(e eVar, int i2, int i3, a aVar) {
        synchronized (this.f7899g) {
            if (!this.f7899g.containsKey(eVar.f7927f)) {
                LinkedList linkedList = new LinkedList();
                linkedList.add(aVar);
                this.f7899g.put(eVar.f7927f, linkedList);
                com.anythink.core.common.res.image.a aVar2 = new com.anythink.core.common.res.image.a(eVar);
                aVar2.a(new AnonymousClass5(i2, i3, eVar));
                aVar2.d();
            } else {
                LinkedList linkedList2 = (LinkedList) this.f7899g.get(eVar.f7927f);
                if (linkedList2 != null && !linkedList2.contains(aVar)) {
                    linkedList2.add(aVar);
                }
            }
        }
    }

    public final void a(String str, Bitmap bitmap) {
        if (a(str) != null || bitmap == null) {
            return;
        }
        this.f7897e.b(str, new SoftReference<>(bitmap));
    }

    private Bitmap a(String str) {
        SoftReference<Bitmap> softReferenceA = this.f7897e.a(str);
        if (softReferenceA != null) {
            return softReferenceA.get();
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x004b A[EXC_TOP_SPLITTER, PHI: r0
  0x004b: PHI (r0v2 android.graphics.Bitmap) = (r0v0 android.graphics.Bitmap), (r0v4 android.graphics.Bitmap) binds: [B:22:0x004f, B:19:0x0049] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.graphics.Bitmap a(com.anythink.core.common.res.e r5, int r6, int r7) {
        /*
            r4 = this;
            r0 = 0
            if (r5 == 0) goto L57
            java.lang.String r1 = r5.f7927f
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 == 0) goto Lc
            goto L57
        Lc:
            java.lang.String r1 = r5.f7927f
            java.lang.String r1 = com.anythink.core.common.k.f.a(r1)
            if (r6 > 0) goto L20
            android.content.Context r2 = r4.a     // Catch: java.lang.Throwable -> L2e
            android.content.res.Resources r2 = r2.getResources()     // Catch: java.lang.Throwable -> L2e
            android.util.DisplayMetrics r2 = r2.getDisplayMetrics()     // Catch: java.lang.Throwable -> L2e
            int r6 = r2.widthPixels     // Catch: java.lang.Throwable -> L2e
        L20:
            if (r7 > 0) goto L2e
            android.content.Context r2 = r4.a     // Catch: java.lang.Throwable -> L2e
            android.content.res.Resources r2 = r2.getResources()     // Catch: java.lang.Throwable -> L2e
            android.util.DisplayMetrics r2 = r2.getDisplayMetrics()     // Catch: java.lang.Throwable -> L2e
            int r7 = r2.heightPixels     // Catch: java.lang.Throwable -> L2e
        L2e:
            java.lang.Object r2 = r4.f7898f
            monitor-enter(r2)
            android.content.Context r3 = r4.a     // Catch: java.lang.Throwable -> L54
            com.anythink.core.common.res.d r3 = com.anythink.core.common.res.d.a(r3)     // Catch: java.lang.Throwable -> L54
            int r5 = r5.f7926e     // Catch: java.lang.Throwable -> L54
            java.io.FileInputStream r5 = r3.a(r5, r1)     // Catch: java.lang.Throwable -> L54
            if (r5 != 0) goto L41
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L54
            return r0
        L41:
            java.io.FileDescriptor r1 = r5.getFD()     // Catch: java.lang.Throwable -> L4f
            android.graphics.Bitmap r0 = com.anythink.core.common.k.b.a(r1, r6, r7)     // Catch: java.lang.Throwable -> L4f
            if (r5 == 0) goto L52
        L4b:
            r5.close()     // Catch: java.lang.Exception -> L52 java.lang.Throwable -> L54
            goto L52
        L4f:
            if (r5 == 0) goto L52
            goto L4b
        L52:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L54
            return r0
        L54:
            r5 = move-exception
            monitor-exit(r2)
            throw r5
        L57:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.core.common.res.b.a(com.anythink.core.common.res.e, int, int):android.graphics.Bitmap");
    }

    public static b a(Context context) {
        if (f7895c == null) {
            synchronized (b.class) {
                if (f7895c == null) {
                    f7895c = new b(context);
                }
            }
        }
        return f7895c;
    }

    public final void a(e eVar, a aVar) {
        a(eVar, -1, -1, aVar);
    }

    public final void a(final e eVar, final int i2, final int i3, final a aVar) {
        if (eVar == null || TextUtils.isEmpty(eVar.f7927f)) {
            if (aVar != null) {
                aVar.onFail("", "No url info.");
            }
        } else {
            Bitmap bitmapA = a(eVar.f7927f);
            if (bitmapA != null && !bitmapA.isRecycled()) {
                aVar.onSuccess(eVar.f7927f, bitmapA);
            } else {
                com.anythink.core.common.k.b.a.a().a(new Runnable() { // from class: com.anythink.core.common.res.b.4
                    @Override // java.lang.Runnable
                    public final void run() {
                        Bitmap bitmapA2 = b.this.a(eVar, i2, i3);
                        if (bitmapA2 == null || bitmapA2.isRecycled()) {
                            b.a(b.this, eVar, i2, i3, aVar);
                            return;
                        }
                        StringBuilder sb = new StringBuilder("url image [");
                        sb.append(eVar.f7927f);
                        sb.append("] is downloaded");
                        b.this.a(eVar.f7927f, bitmapA2);
                        LinkedList linkedList = new LinkedList();
                        linkedList.add(aVar);
                        b.this.f7899g.put(eVar.f7927f, linkedList);
                        b.a(b.this, eVar.f7927f, bitmapA2);
                    }
                });
            }
        }
    }

    private void a() {
        try {
            if (this.f7897e != null) {
                this.f7897e.a();
            }
            if (this.f7899g != null) {
                this.f7899g.clear();
            }
        } catch (Exception unused) {
        }
    }

    static /* synthetic */ void a(b bVar, String str, Bitmap bitmap) {
        synchronized (bVar.f7899g) {
            LinkedList<a> linkedList = (LinkedList) bVar.f7899g.remove(str);
            if (linkedList != null) {
                for (a aVar : linkedList) {
                    if (aVar != null) {
                        n.a().a(bVar.new AnonymousClass1(bitmap, aVar, str));
                    }
                }
            }
        }
    }

    static /* synthetic */ void a(b bVar, e eVar, int i2, int i3, a aVar) {
        synchronized (bVar.f7899g) {
            if (!bVar.f7899g.containsKey(eVar.f7927f)) {
                LinkedList linkedList = new LinkedList();
                linkedList.add(aVar);
                bVar.f7899g.put(eVar.f7927f, linkedList);
                com.anythink.core.common.res.image.a aVar2 = new com.anythink.core.common.res.image.a(eVar);
                aVar2.a(bVar.new AnonymousClass5(i2, i3, eVar));
                aVar2.d();
            } else {
                LinkedList linkedList2 = (LinkedList) bVar.f7899g.get(eVar.f7927f);
                if (linkedList2 != null && !linkedList2.contains(aVar)) {
                    linkedList2.add(aVar);
                }
            }
        }
    }

    static /* synthetic */ void a(b bVar, String str, String str2) {
        synchronized (bVar.f7899g) {
            LinkedList<a> linkedList = (LinkedList) bVar.f7899g.remove(str);
            if (linkedList != null) {
                for (a aVar : linkedList) {
                    if (aVar != null) {
                        n.a().a(bVar.new AnonymousClass2(aVar, str, str2));
                    }
                }
            }
        }
    }
}
