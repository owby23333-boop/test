package com.bumptech.glide;

import android.app.Activity;
import android.content.ComponentCallbacks2;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import android.view.View;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.d;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.l.p;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import com.bumptech.glide.load.data.e;
import com.bumptech.glide.load.data.k;
import com.bumptech.glide.load.j.a;
import com.bumptech.glide.load.j.b;
import com.bumptech.glide.load.j.d;
import com.bumptech.glide.load.j.e;
import com.bumptech.glide.load.j.f;
import com.bumptech.glide.load.j.k;
import com.bumptech.glide.load.j.s;
import com.bumptech.glide.load.j.t;
import com.bumptech.glide.load.j.u;
import com.bumptech.glide.load.j.v;
import com.bumptech.glide.load.j.w;
import com.bumptech.glide.load.j.x;
import com.bumptech.glide.load.j.y.a;
import com.bumptech.glide.load.j.y.b;
import com.bumptech.glide.load.j.y.c;
import com.bumptech.glide.load.j.y.d;
import com.bumptech.glide.load.j.y.e;
import com.bumptech.glide.load.k.d.a;
import com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser;
import com.bumptech.glide.load.resource.bitmap.VideoDecoder;
import com.bumptech.glide.load.resource.bitmap.l;
import com.bumptech.glide.load.resource.bitmap.o;
import com.bumptech.glide.load.resource.bitmap.q;
import com.bumptech.glide.load.resource.bitmap.s;
import com.bumptech.glide.load.resource.bitmap.u;
import com.bumptech.glide.load.resource.bitmap.x;
import com.bumptech.glide.load.resource.bitmap.z;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: Glide.java */
/* JADX INFO: loaded from: classes2.dex */
public class c implements ComponentCallbacks2 {

    @GuardedBy("Glide.class")
    private static volatile c B;
    private static volatile boolean C;

    @GuardedBy("managers")
    private final List<i> A = new ArrayList();

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.i f13284s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.x.e f13285t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.y.h f13286u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final e f13287v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final Registry f13288w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.x.b f13289x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final p f13290y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final com.bumptech.glide.l.d f13291z;

    /* JADX INFO: compiled from: Glide.java */
    public interface a {
        @NonNull
        com.bumptech.glide.request.h build();
    }

    c(@NonNull Context context, @NonNull com.bumptech.glide.load.engine.i iVar, @NonNull com.bumptech.glide.load.engine.y.h hVar, @NonNull com.bumptech.glide.load.engine.x.e eVar, @NonNull com.bumptech.glide.load.engine.x.b bVar, @NonNull p pVar, @NonNull com.bumptech.glide.l.d dVar, int i2, @NonNull a aVar, @NonNull Map<Class<?>, j<?, ?>> map, @NonNull List<com.bumptech.glide.request.g<Object>> list, f fVar) {
        com.bumptech.glide.load.g gVar;
        com.bumptech.glide.load.g xVar;
        Object obj;
        String str;
        MemoryCategory memoryCategory = MemoryCategory.NORMAL;
        this.f13284s = iVar;
        this.f13285t = eVar;
        this.f13289x = bVar;
        this.f13286u = hVar;
        this.f13290y = pVar;
        this.f13291z = dVar;
        Resources resources = context.getResources();
        this.f13288w = new Registry();
        this.f13288w.a((ImageHeaderParser) new DefaultImageHeaderParser());
        if (Build.VERSION.SDK_INT >= 27) {
            this.f13288w.a((ImageHeaderParser) new o());
        }
        List<ImageHeaderParser> listA = this.f13288w.a();
        com.bumptech.glide.load.k.g.a aVar2 = new com.bumptech.glide.load.k.g.a(context, listA, eVar, bVar);
        com.bumptech.glide.load.g<ParcelFileDescriptor, Bitmap> gVarC = VideoDecoder.c(eVar);
        l lVar = new l(this.f13288w.a(), resources.getDisplayMetrics(), eVar, bVar);
        if (Build.VERSION.SDK_INT < 28 || !fVar.a(d.c.class)) {
            gVar = new com.bumptech.glide.load.resource.bitmap.g(lVar);
            xVar = new x(lVar, bVar);
        } else {
            xVar = new s();
            gVar = new com.bumptech.glide.load.resource.bitmap.h();
        }
        if (Build.VERSION.SDK_INT < 28 || !fVar.a(d.b.class)) {
            obj = GifDecoder.class;
        } else {
            obj = GifDecoder.class;
            this.f13288w.a("Animation", InputStream.class, Drawable.class, com.bumptech.glide.load.k.e.a.b(listA, bVar));
            this.f13288w.a("Animation", ByteBuffer.class, Drawable.class, com.bumptech.glide.load.k.e.a.a(listA, bVar));
        }
        com.bumptech.glide.load.k.e.f fVar2 = new com.bumptech.glide.load.k.e.f(context);
        s.c cVar = new s.c(resources);
        s.d dVar2 = new s.d(resources);
        s.b bVar2 = new s.b(resources);
        s.a aVar3 = new s.a(resources);
        com.bumptech.glide.load.resource.bitmap.c cVar2 = new com.bumptech.glide.load.resource.bitmap.c(bVar);
        com.bumptech.glide.load.k.h.a aVar4 = new com.bumptech.glide.load.k.h.a();
        com.bumptech.glide.load.k.h.d dVar3 = new com.bumptech.glide.load.k.h.d();
        ContentResolver contentResolver = context.getContentResolver();
        Registry registry = this.f13288w;
        registry.a(ByteBuffer.class, new com.bumptech.glide.load.j.c());
        registry.a(InputStream.class, new t(bVar));
        registry.a("Bitmap", ByteBuffer.class, Bitmap.class, gVar);
        registry.a("Bitmap", InputStream.class, Bitmap.class, xVar);
        if (ParcelFileDescriptorRewinder.c()) {
            str = "Animation";
            this.f13288w.a("Bitmap", ParcelFileDescriptor.class, Bitmap.class, new u(lVar));
        } else {
            str = "Animation";
        }
        Registry registry2 = this.f13288w;
        registry2.a("Bitmap", ParcelFileDescriptor.class, Bitmap.class, gVarC);
        registry2.a("Bitmap", AssetFileDescriptor.class, Bitmap.class, VideoDecoder.a(eVar));
        registry2.a(Bitmap.class, Bitmap.class, v.a.b());
        registry2.a("Bitmap", Bitmap.class, Bitmap.class, new z());
        registry2.a(Bitmap.class, (com.bumptech.glide.load.h) cVar2);
        registry2.a("BitmapDrawable", ByteBuffer.class, BitmapDrawable.class, new com.bumptech.glide.load.resource.bitmap.a(resources, gVar));
        registry2.a("BitmapDrawable", InputStream.class, BitmapDrawable.class, new com.bumptech.glide.load.resource.bitmap.a(resources, xVar));
        registry2.a("BitmapDrawable", ParcelFileDescriptor.class, BitmapDrawable.class, new com.bumptech.glide.load.resource.bitmap.a(resources, gVarC));
        registry2.a(BitmapDrawable.class, (com.bumptech.glide.load.h) new com.bumptech.glide.load.resource.bitmap.b(eVar, cVar2));
        com.bumptech.glide.load.k.g.j jVar = new com.bumptech.glide.load.k.g.j(listA, aVar2, bVar);
        String str2 = str;
        registry2.a(str2, InputStream.class, com.bumptech.glide.load.k.g.c.class, jVar);
        registry2.a(str2, ByteBuffer.class, com.bumptech.glide.load.k.g.c.class, aVar2);
        registry2.a(com.bumptech.glide.load.k.g.c.class, (com.bumptech.glide.load.h) new com.bumptech.glide.load.k.g.d());
        Object obj2 = obj;
        registry2.a((Class) obj2, (Class) obj2, (com.bumptech.glide.load.j.o) v.a.b());
        registry2.a("Bitmap", obj2, Bitmap.class, new com.bumptech.glide.load.k.g.h(eVar));
        registry2.a(Uri.class, Drawable.class, fVar2);
        registry2.a(Uri.class, Bitmap.class, new com.bumptech.glide.load.resource.bitmap.v(fVar2, eVar));
        registry2.a((e.a<?>) new a.C0273a());
        registry2.a(File.class, ByteBuffer.class, new d.b());
        registry2.a(File.class, InputStream.class, new f.e());
        registry2.a(File.class, File.class, new com.bumptech.glide.load.k.f.a());
        registry2.a(File.class, ParcelFileDescriptor.class, new f.b());
        registry2.a(File.class, File.class, v.a.b());
        registry2.a((e.a<?>) new k.a(bVar));
        if (ParcelFileDescriptorRewinder.c()) {
            this.f13288w.a((e.a<?>) new ParcelFileDescriptorRewinder.a());
        }
        Registry registry3 = this.f13288w;
        registry3.a(Integer.TYPE, InputStream.class, cVar);
        registry3.a(Integer.TYPE, ParcelFileDescriptor.class, bVar2);
        registry3.a(Integer.class, InputStream.class, cVar);
        registry3.a(Integer.class, ParcelFileDescriptor.class, bVar2);
        registry3.a(Integer.class, Uri.class, dVar2);
        registry3.a(Integer.TYPE, AssetFileDescriptor.class, aVar3);
        registry3.a(Integer.class, AssetFileDescriptor.class, aVar3);
        registry3.a(Integer.TYPE, Uri.class, dVar2);
        registry3.a(String.class, InputStream.class, new e.c());
        registry3.a(Uri.class, InputStream.class, new e.c());
        registry3.a(String.class, InputStream.class, new u.c());
        registry3.a(String.class, ParcelFileDescriptor.class, new u.b());
        registry3.a(String.class, AssetFileDescriptor.class, new u.a());
        registry3.a(Uri.class, InputStream.class, new a.c(context.getAssets()));
        registry3.a(Uri.class, AssetFileDescriptor.class, new a.b(context.getAssets()));
        registry3.a(Uri.class, InputStream.class, new b.a(context));
        registry3.a(Uri.class, InputStream.class, new c.a(context));
        if (Build.VERSION.SDK_INT >= 29) {
            this.f13288w.a(Uri.class, InputStream.class, new d.c(context));
            this.f13288w.a(Uri.class, ParcelFileDescriptor.class, new d.b(context));
        }
        Registry registry4 = this.f13288w;
        registry4.a(Uri.class, InputStream.class, new w.d(contentResolver));
        registry4.a(Uri.class, ParcelFileDescriptor.class, new w.b(contentResolver));
        registry4.a(Uri.class, AssetFileDescriptor.class, new w.a(contentResolver));
        registry4.a(Uri.class, InputStream.class, new x.a());
        registry4.a(URL.class, InputStream.class, new e.a());
        registry4.a(Uri.class, File.class, new k.a(context));
        registry4.a(com.bumptech.glide.load.j.g.class, InputStream.class, new a.C0270a());
        registry4.a(byte[].class, ByteBuffer.class, new b.a());
        registry4.a(byte[].class, InputStream.class, new b.d());
        registry4.a(Uri.class, Uri.class, v.a.b());
        registry4.a(Drawable.class, Drawable.class, v.a.b());
        registry4.a(Drawable.class, Drawable.class, new com.bumptech.glide.load.k.e.g());
        registry4.a(Bitmap.class, BitmapDrawable.class, new com.bumptech.glide.load.k.h.b(resources));
        registry4.a(Bitmap.class, byte[].class, aVar4);
        registry4.a(Drawable.class, byte[].class, new com.bumptech.glide.load.k.h.c(eVar, aVar4, dVar3));
        registry4.a(com.bumptech.glide.load.k.g.c.class, byte[].class, dVar3);
        if (Build.VERSION.SDK_INT >= 23) {
            com.bumptech.glide.load.g<ByteBuffer, Bitmap> gVarB = VideoDecoder.b(eVar);
            this.f13288w.a(ByteBuffer.class, Bitmap.class, gVarB);
            this.f13288w.a(ByteBuffer.class, BitmapDrawable.class, new com.bumptech.glide.load.resource.bitmap.a(resources, gVarB));
        }
        this.f13287v = new e(context, bVar, this.f13288w, new com.bumptech.glide.request.k.g(), aVar, map, list, iVar, fVar, i2);
    }

    @Nullable
    public static File a(@NonNull Context context, @NonNull String str) {
        File cacheDir = context.getCacheDir();
        if (cacheDir == null) {
            Log.isLoggable("Glide", 6);
            return null;
        }
        File file = new File(cacheDir, str);
        if (file.isDirectory() || file.mkdirs()) {
            return file;
        }
        return null;
    }

    @GuardedBy("Glide.class")
    private static void b(@NonNull Context context, @Nullable GeneratedAppGlideModule generatedAppGlideModule) {
        a(context, new d(), generatedAppGlideModule);
    }

    @Nullable
    public static File c(@NonNull Context context) {
        return a(context, "image_manager_disk_cache");
    }

    @VisibleForTesting
    public static void i() {
        q.c().a();
    }

    @VisibleForTesting
    public static void j() {
        synchronized (c.class) {
            if (B != null) {
                B.getContext().getApplicationContext().unregisterComponentCallbacks(B);
                B.f13284s.b();
            }
            B = null;
        }
    }

    @NonNull
    public com.bumptech.glide.load.engine.x.e d() {
        return this.f13285t;
    }

    com.bumptech.glide.l.d e() {
        return this.f13291z;
    }

    @NonNull
    e f() {
        return this.f13287v;
    }

    @NonNull
    public Registry g() {
        return this.f13288w;
    }

    @NonNull
    public Context getContext() {
        return this.f13287v.getBaseContext();
    }

    @NonNull
    public p h() {
        return this.f13290y;
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        b();
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int i2) {
        a(i2);
    }

    @Nullable
    private static GeneratedAppGlideModule b(Context context) {
        try {
            return (GeneratedAppGlideModule) Class.forName("com.bumptech.glide.GeneratedAppGlideModuleImpl").getDeclaredConstructor(Context.class).newInstance(context.getApplicationContext());
        } catch (ClassNotFoundException unused) {
            Log.isLoggable("Glide", 5);
            return null;
        } catch (IllegalAccessException e2) {
            a(e2);
            throw null;
        } catch (InstantiationException e3) {
            a(e3);
            throw null;
        } catch (NoSuchMethodException e4) {
            a(e4);
            throw null;
        } catch (InvocationTargetException e5) {
            a(e5);
            throw null;
        }
    }

    @NonNull
    private static p d(@Nullable Context context) {
        com.bumptech.glide.util.k.a(context, "You cannot start a load on a not yet attached View or a Fragment where getActivity() returns null (which usually occurs when getActivity() is called before the Fragment is attached or after the Fragment is destroyed).");
        return a(context).h();
    }

    @NonNull
    public static i e(@NonNull Context context) {
        return d(context).a(context);
    }

    @NonNull
    public com.bumptech.glide.load.engine.x.b c() {
        return this.f13289x;
    }

    @NonNull
    public static c a(@NonNull Context context) {
        if (B == null) {
            GeneratedAppGlideModule generatedAppGlideModuleB = b(context.getApplicationContext());
            synchronized (c.class) {
                if (B == null) {
                    a(context, generatedAppGlideModuleB);
                }
            }
        }
        return B;
    }

    public void b() {
        com.bumptech.glide.util.l.b();
        this.f13286u.a();
        this.f13285t.a();
        this.f13289x.a();
    }

    @GuardedBy("Glide.class")
    private static void a(@NonNull Context context, @Nullable GeneratedAppGlideModule generatedAppGlideModule) {
        if (!C) {
            C = true;
            b(context, generatedAppGlideModule);
            C = false;
            return;
        }
        throw new IllegalStateException("You cannot call Glide.get() in registerComponents(), use the provided Glide instance instead");
    }

    void b(i iVar) {
        synchronized (this.A) {
            if (this.A.contains(iVar)) {
                this.A.remove(iVar);
            } else {
                throw new IllegalStateException("Cannot unregister not yet registered manager");
            }
        }
    }

    @VisibleForTesting
    @Deprecated
    public static synchronized void a(c cVar) {
        if (B != null) {
            j();
        }
        B = cVar;
    }

    @VisibleForTesting
    public static void a(@NonNull Context context, @NonNull d dVar) {
        GeneratedAppGlideModule generatedAppGlideModuleB = b(context);
        synchronized (c.class) {
            if (B != null) {
                j();
            }
            a(context, dVar, generatedAppGlideModuleB);
        }
    }

    @GuardedBy("Glide.class")
    private static void a(@NonNull Context context, @NonNull d dVar, @Nullable GeneratedAppGlideModule generatedAppGlideModule) {
        Context applicationContext = context.getApplicationContext();
        List<com.bumptech.glide.m.c> listEmptyList = Collections.emptyList();
        if (generatedAppGlideModule == null || generatedAppGlideModule.isManifestParsingEnabled()) {
            listEmptyList = new com.bumptech.glide.m.e(applicationContext).a();
        }
        if (generatedAppGlideModule != null && !generatedAppGlideModule.a().isEmpty()) {
            Set<Class<?>> setA = generatedAppGlideModule.a();
            Iterator<com.bumptech.glide.m.c> it = listEmptyList.iterator();
            while (it.hasNext()) {
                com.bumptech.glide.m.c next = it.next();
                if (setA.contains(next.getClass())) {
                    if (Log.isLoggable("Glide", 3)) {
                        String str = "AppGlideModule excludes manifest GlideModule: " + next;
                    }
                    it.remove();
                }
            }
        }
        if (Log.isLoggable("Glide", 3)) {
            Iterator<com.bumptech.glide.m.c> it2 = listEmptyList.iterator();
            while (it2.hasNext()) {
                String str2 = "Discovered GlideModule from manifest: " + it2.next().getClass();
            }
        }
        dVar.a(generatedAppGlideModule != null ? generatedAppGlideModule.b() : null);
        Iterator<com.bumptech.glide.m.c> it3 = listEmptyList.iterator();
        while (it3.hasNext()) {
            it3.next().applyOptions(applicationContext, dVar);
        }
        if (generatedAppGlideModule != null) {
            generatedAppGlideModule.applyOptions(applicationContext, dVar);
        }
        c cVarA = dVar.a(applicationContext);
        for (com.bumptech.glide.m.c cVar : listEmptyList) {
            try {
                cVar.registerComponents(applicationContext, cVarA, cVarA.f13288w);
            } catch (AbstractMethodError e2) {
                throw new IllegalStateException("Attempting to register a Glide v3 module. If you see this, you or one of your dependencies may be including Glide v3 even though you're using Glide v4. You'll need to find and remove (or update) the offending dependency. The v3 module name is: " + cVar.getClass().getName(), e2);
            }
        }
        if (generatedAppGlideModule != null) {
            generatedAppGlideModule.registerComponents(applicationContext, cVarA, cVarA.f13288w);
        }
        applicationContext.registerComponentCallbacks(cVarA);
        B = cVarA;
    }

    private static void a(Exception exc) {
        throw new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", exc);
    }

    public void a(int i2) {
        com.bumptech.glide.util.l.b();
        synchronized (this.A) {
            Iterator<i> it = this.A.iterator();
            while (it.hasNext()) {
                it.next().onTrimMemory(i2);
            }
        }
        this.f13286u.trimMemory(i2);
        this.f13285t.trimMemory(i2);
        this.f13289x.trimMemory(i2);
    }

    public void a() {
        com.bumptech.glide.util.l.a();
        this.f13284s.a();
    }

    @NonNull
    public static i a(@NonNull Activity activity) {
        return d(activity).a(activity);
    }

    @NonNull
    public static i a(@NonNull FragmentActivity fragmentActivity) {
        return d(fragmentActivity).a(fragmentActivity);
    }

    @NonNull
    public static i a(@NonNull Fragment fragment) {
        return d(fragment.getContext()).a(fragment);
    }

    @NonNull
    @Deprecated
    public static i a(@NonNull android.app.Fragment fragment) {
        return d(fragment.getActivity()).a(fragment);
    }

    @NonNull
    public static i a(@NonNull View view) {
        return d(view.getContext()).a(view);
    }

    boolean a(@NonNull com.bumptech.glide.request.k.j<?> jVar) {
        synchronized (this.A) {
            Iterator<i> it = this.A.iterator();
            while (it.hasNext()) {
                if (it.next().untrack(jVar)) {
                    return true;
                }
            }
            return false;
        }
    }

    void a(i iVar) {
        synchronized (this.A) {
            if (!this.A.contains(iVar)) {
                this.A.add(iVar);
            } else {
                throw new IllegalStateException("Cannot register already registered manager");
            }
        }
    }
}
