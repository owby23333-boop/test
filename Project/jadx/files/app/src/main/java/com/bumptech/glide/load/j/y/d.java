package com.bumptech.glide.load.j.y;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.d;
import com.bumptech.glide.load.f;
import com.bumptech.glide.load.j.n;
import com.bumptech.glide.load.j.o;
import com.bumptech.glide.load.j.r;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;

/* JADX INFO: compiled from: QMediaStoreUriLoader.java */
/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(29)
public final class d<DataT> implements n<Uri, DataT> {
    private final Context a;
    private final n<File, DataT> b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final n<Uri, DataT> f13695c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Class<DataT> f13696d;

    /* JADX INFO: compiled from: QMediaStoreUriLoader.java */
    private static abstract class a<DataT> implements o<Uri, DataT> {
        private final Context a;
        private final Class<DataT> b;

        a(Context context, Class<DataT> cls) {
            this.a = context;
            this.b = cls;
        }

        @Override // com.bumptech.glide.load.j.o
        @NonNull
        public final n<Uri, DataT> a(@NonNull r rVar) {
            return new d(this.a, rVar.a(File.class, this.b), rVar.a(Uri.class, this.b), this.b);
        }

        @Override // com.bumptech.glide.load.j.o
        public final void a() {
        }
    }

    /* JADX INFO: compiled from: QMediaStoreUriLoader.java */
    @RequiresApi(29)
    public static final class b extends a<ParcelFileDescriptor> {
        public b(Context context) {
            super(context, ParcelFileDescriptor.class);
        }
    }

    /* JADX INFO: compiled from: QMediaStoreUriLoader.java */
    @RequiresApi(29)
    public static final class c extends a<InputStream> {
        public c(Context context) {
            super(context, InputStream.class);
        }
    }

    d(Context context, n<File, DataT> nVar, n<Uri, DataT> nVar2, Class<DataT> cls) {
        this.a = context.getApplicationContext();
        this.b = nVar;
        this.f13695c = nVar2;
        this.f13696d = cls;
    }

    @Override // com.bumptech.glide.load.j.n
    public n.a<DataT> a(@NonNull Uri uri, int i2, int i3, @NonNull f fVar) {
        return new n.a<>(new com.bumptech.glide.o.d(uri), new C0271d(this.a, this.b, this.f13695c, uri, i2, i3, fVar, this.f13696d));
    }

    @Override // com.bumptech.glide.load.j.n
    public boolean a(@NonNull Uri uri) {
        return Build.VERSION.SDK_INT >= 29 && com.bumptech.glide.load.data.o.b.b(uri);
    }

    /* JADX INFO: renamed from: com.bumptech.glide.load.j.y.d$d, reason: collision with other inner class name */
    /* JADX INFO: compiled from: QMediaStoreUriLoader.java */
    private static final class C0271d<DataT> implements com.bumptech.glide.load.data.d<DataT> {
        private static final String[] C = {"_data"};
        private volatile boolean A;

        @Nullable
        private volatile com.bumptech.glide.load.data.d<DataT> B;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private final Context f13697s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        private final n<File, DataT> f13698t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        private final n<Uri, DataT> f13699u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        private final Uri f13700v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        private final int f13701w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        private final int f13702x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        private final f f13703y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        private final Class<DataT> f13704z;

        C0271d(Context context, n<File, DataT> nVar, n<Uri, DataT> nVar2, Uri uri, int i2, int i3, f fVar, Class<DataT> cls) {
            this.f13697s = context.getApplicationContext();
            this.f13698t = nVar;
            this.f13699u = nVar2;
            this.f13700v = uri;
            this.f13701w = i2;
            this.f13702x = i3;
            this.f13703y = fVar;
            this.f13704z = cls;
        }

        @Nullable
        private n.a<DataT> c() throws FileNotFoundException {
            if (Environment.isExternalStorageLegacy()) {
                return this.f13698t.a(a(this.f13700v), this.f13701w, this.f13702x, this.f13703y);
            }
            return this.f13699u.a(e() ? MediaStore.setRequireOriginal(this.f13700v) : this.f13700v, this.f13701w, this.f13702x, this.f13703y);
        }

        @Nullable
        private com.bumptech.glide.load.data.d<DataT> d() throws FileNotFoundException {
            n.a<DataT> aVarC = c();
            if (aVarC != null) {
                return aVarC.f13681c;
            }
            return null;
        }

        private boolean e() {
            return this.f13697s.checkSelfPermission("android.permission.ACCESS_MEDIA_LOCATION") == 0;
        }

        @Override // com.bumptech.glide.load.data.d
        public void a(@NonNull Priority priority, @NonNull d.a<? super DataT> aVar) {
            try {
                com.bumptech.glide.load.data.d<DataT> dVarD = d();
                if (dVarD == null) {
                    aVar.a((Exception) new IllegalArgumentException("Failed to build fetcher for: " + this.f13700v));
                    return;
                }
                this.B = dVarD;
                if (this.A) {
                    cancel();
                } else {
                    dVarD.a(priority, aVar);
                }
            } catch (FileNotFoundException e2) {
                aVar.a((Exception) e2);
            }
        }

        @Override // com.bumptech.glide.load.data.d
        public void b() {
            com.bumptech.glide.load.data.d<DataT> dVar = this.B;
            if (dVar != null) {
                dVar.b();
            }
        }

        @Override // com.bumptech.glide.load.data.d
        public void cancel() {
            this.A = true;
            com.bumptech.glide.load.data.d<DataT> dVar = this.B;
            if (dVar != null) {
                dVar.cancel();
            }
        }

        @Override // com.bumptech.glide.load.data.d
        @NonNull
        public DataSource getDataSource() {
            return DataSource.LOCAL;
        }

        @Override // com.bumptech.glide.load.data.d
        @NonNull
        public Class<DataT> a() {
            return this.f13704z;
        }

        @NonNull
        private File a(Uri uri) throws FileNotFoundException {
            Cursor cursor = null;
            try {
                Cursor cursorQuery = this.f13697s.getContentResolver().query(uri, C, null, null, null);
                if (cursorQuery != null && cursorQuery.moveToFirst()) {
                    String string = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_data"));
                    if (!TextUtils.isEmpty(string)) {
                        File file = new File(string);
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        return file;
                    }
                    throw new FileNotFoundException("File path was empty in media store for: " + uri);
                }
                throw new FileNotFoundException("Failed to media store entry for: " + uri);
            } catch (Throwable th) {
                if (0 != 0) {
                    cursor.close();
                }
                throw th;
            }
        }
    }
}
