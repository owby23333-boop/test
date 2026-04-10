package com.duokan.reader.common.cache;

import com.duokan.reader.common.cache.b;
import java.io.File;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class FileCache extends b<File> {
    public static final String n = ".file";
    public final b.e<File> m;

    public static class CacheKey extends b.c implements Serializable {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private static final long serialVersionUID = 1;
        public final Object mFileTag;

        public CacheKey(Object obj) {
            this.mFileTag = obj;
        }

        @Override // com.duokan.reader.common.cache.b.c
        public boolean equals(Object obj) {
            if (obj instanceof CacheKey) {
                return this.mFileTag.equals(((CacheKey) obj).mFileTag);
            }
            return false;
        }

        @Override // com.duokan.reader.common.cache.b.c
        public int hashCode() {
            return this.mFileTag.hashCode();
        }

        @Override // com.duokan.reader.common.cache.b.c
        public /* bridge */ /* synthetic */ boolean isSuitable(Object obj) {
            return super.isSuitable(obj);
        }
    }

    public class a implements b.e<File> {
        public a() {
        }

        @Override // com.duokan.reader.common.cache.b.e
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public File b(Object[] objArr) {
            try {
                FileCache fileCache = FileCache.this;
                return File.createTempFile(fileCache.d, FileCache.n, fileCache.c);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override // com.duokan.reader.common.cache.b.e
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public boolean a(File file, Object[] objArr) {
            return true;
        }
    }

    public FileCache(String str, int i, File file) {
        super(str, i, file);
        this.m = new a();
    }

    public b.d<File> D(CacheKey cacheKey, File file) {
        return super.b(cacheKey, this.m, file);
    }

    public b.d<File> E(CacheKey cacheKey) {
        return super.c(cacheKey);
    }

    public b.d<File> F(CacheKey cacheKey) {
        return super.d(cacheKey, this.m, new Object[0]);
    }

    public b.d<File> G(CacheKey cacheKey, File file) {
        return super.d(cacheKey, this.m, file);
    }

    @Override // com.duokan.reader.common.cache.b
    /* JADX INFO: renamed from: H, reason: merged with bridge method [inline-methods] */
    public boolean k(File file, boolean z) {
        file.delete();
        return true;
    }

    @Override // com.duokan.reader.common.cache.b
    /* JADX INFO: renamed from: I, reason: merged with bridge method [inline-methods] */
    public int s(File file) {
        return 0;
    }

    @Override // com.duokan.reader.common.cache.b
    public void j(b.d<File> dVar) {
    }

    @Override // com.duokan.reader.common.cache.b
    public void l(b.d<File> dVar) {
    }
}
