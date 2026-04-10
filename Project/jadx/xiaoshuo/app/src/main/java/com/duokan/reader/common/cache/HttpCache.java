package com.duokan.reader.common.cache;

import com.duokan.reader.common.cache.FileCache;
import com.duokan.reader.common.cache.b;
import com.yuewen.fh1;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.message.BasicHttpResponse;

/* JADX INFO: loaded from: classes2.dex */
public class HttpCache extends com.duokan.reader.common.cache.b<HttpResponse> {
    public static final /* synthetic */ boolean o = false;
    public final FileCache m;
    public final b.e<HttpResponse> n;

    public static class CacheKey extends b.c implements Serializable {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private static final long serialVersionUID = 1;
        private final String[][] mRequestHeaders;
        private final String mRequestLine;

        public CacheKey(HttpRequest httpRequest) {
            this.mRequestLine = httpRequest.getRequestLine().toString();
            Header[] allHeaders = httpRequest.getAllHeaders();
            this.mRequestHeaders = (String[][]) Array.newInstance((Class<?>) String.class, allHeaders.length, 2);
            for (int i = 0; i < allHeaders.length; i++) {
                this.mRequestHeaders[i][0] = allHeaders[i].getName();
                this.mRequestHeaders[i][1] = allHeaders[i].getValue();
            }
        }

        @Override // com.duokan.reader.common.cache.b.c
        public boolean equals(Object obj) {
            if (!(obj instanceof CacheKey)) {
                return false;
            }
            CacheKey cacheKey = (CacheKey) obj;
            if (!this.mRequestLine.equals(cacheKey.mRequestLine) || this.mRequestHeaders.length != cacheKey.mRequestHeaders.length) {
                return false;
            }
            int i = 0;
            while (true) {
                String[][] strArr = this.mRequestHeaders;
                if (i >= strArr.length) {
                    return true;
                }
                if (!HttpCache.H(cacheKey.mRequestHeaders, strArr[i])) {
                    return false;
                }
                i++;
            }
        }

        @Override // com.duokan.reader.common.cache.b.c
        public int hashCode() {
            return this.mRequestLine.hashCode();
        }

        @Override // com.duokan.reader.common.cache.b.c
        public /* bridge */ /* synthetic */ boolean isSuitable(Object obj) {
            return super.isSuitable(obj);
        }
    }

    public static class FileCacheKey extends FileCache.CacheKey {
        private static final long serialVersionUID = 1;
        private final String[][] mRequestHeaders;
        private final String mRequestLine;

        public FileCacheKey(CacheKey cacheKey) {
            super(cacheKey.mRequestLine);
            this.mRequestLine = cacheKey.mRequestLine;
            this.mRequestHeaders = cacheKey.mRequestHeaders;
        }

        @Override // com.duokan.reader.common.cache.FileCache.CacheKey, com.duokan.reader.common.cache.b.c
        public boolean equals(Object obj) {
            if (!(obj instanceof FileCacheKey)) {
                return false;
            }
            FileCacheKey fileCacheKey = (FileCacheKey) obj;
            if (!this.mRequestLine.equals(fileCacheKey.mRequestLine) || this.mRequestHeaders.length != fileCacheKey.mRequestHeaders.length) {
                return false;
            }
            int i = 0;
            while (true) {
                String[][] strArr = this.mRequestHeaders;
                if (i >= strArr.length) {
                    return true;
                }
                if (!HttpCache.H(fileCacheKey.mRequestHeaders, strArr[i])) {
                    return false;
                }
                i++;
            }
        }
    }

    public class a implements b.e<HttpResponse> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ boolean f3978b = false;

        public a() {
        }

        @Override // com.duokan.reader.common.cache.b.e
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public HttpResponse b(Object[] objArr) {
            return (HttpResponse) objArr[0];
        }

        @Override // com.duokan.reader.common.cache.b.e
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public boolean a(HttpResponse httpResponse, Object[] objArr) {
            return false;
        }
    }

    public static class b extends BasicHttpResponse {
        public b(StatusLine statusLine) {
            super(statusLine);
        }
    }

    public HttpCache(String str, int i) {
        this(str, i, null);
    }

    public static boolean H(String[][] strArr, String[] strArr2) {
        for (int i = 0; i < strArr.length; i++) {
            if (strArr[i][0].equals(strArr2[0]) && strArr[i][1].equals(strArr2[1])) {
                return true;
            }
        }
        return false;
    }

    public b.d<HttpResponse> E(CacheKey cacheKey, Object... objArr) {
        return super.b(cacheKey, this.n, objArr);
    }

    public b.d<HttpResponse> F(CacheKey cacheKey) {
        return super.c(cacheKey);
    }

    public b.d<HttpResponse> G(CacheKey cacheKey, Object... objArr) {
        return super.d(cacheKey, this.n, objArr);
    }

    public final void I(FileCacheKey fileCacheKey) {
        FileCache fileCache = this.m;
        if (fileCache == null) {
            return;
        }
        fileCache.i(fileCacheKey);
    }

    @Override // com.duokan.reader.common.cache.b
    /* JADX INFO: renamed from: J, reason: merged with bridge method [inline-methods] */
    public boolean k(HttpResponse httpResponse, boolean z) {
        fh1.a(httpResponse);
        return true;
    }

    public final boolean K(FileCacheKey fileCacheKey, HttpResponse httpResponse) {
        b.d<File> dVarF;
        FileOutputStream fileOutputStream;
        ObjectOutputStream objectOutputStream;
        FileCache fileCache = this.m;
        if (fileCache == null || (dVarF = fileCache.F(fileCacheKey)) == null) {
            return false;
        }
        try {
            StatusLine statusLine = httpResponse.getStatusLine();
            Header[] allHeaders = httpResponse.getAllHeaders();
            HttpEntity entity = httpResponse.getEntity();
            String[][] strArr = (String[][]) Array.newInstance((Class<?>) String.class, allHeaders.length, 2);
            for (int i = 0; i < strArr.length; i++) {
                strArr[i][0] = allHeaders[i].getName();
                strArr[i][1] = allHeaders[i].getValue();
            }
            byte[] bArr = new byte[0];
            ByteArrayOutputStream byteArrayOutputStream = null;
            byteArrayOutputStream = null;
            objectOutputStream = null;
            objectOutputStream = null;
            objectOutputStream = null;
            ObjectOutputStream objectOutputStream2 = null;
            try {
                try {
                    if (entity == null) {
                        fileOutputStream = new FileOutputStream(dVarF.f4002b);
                        objectOutputStream = new ObjectOutputStream(fileOutputStream);
                        objectOutputStream.writeObject(statusLine.getProtocolVersion());
                        objectOutputStream.writeInt(statusLine.getStatusCode());
                        objectOutputStream.writeObject(statusLine.getReasonPhrase());
                        objectOutputStream.writeObject(strArr);
                        objectOutputStream.writeObject(bArr);
                        objectOutputStream.close();
                        fileOutputStream.close();
                        return true;
                    }
                    try {
                        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream(1024);
                        try {
                            entity.writeTo(byteArrayOutputStream2);
                            byte[] byteArray = byteArrayOutputStream2.toByteArray();
                            try {
                                byteArrayOutputStream2.close();
                            } catch (Exception unused) {
                            }
                            bArr = byteArray;
                            try {
                                fileOutputStream = new FileOutputStream(dVarF.f4002b);
                                try {
                                    try {
                                        objectOutputStream = new ObjectOutputStream(fileOutputStream);
                                        try {
                                            objectOutputStream.writeObject(statusLine.getProtocolVersion());
                                            objectOutputStream.writeInt(statusLine.getStatusCode());
                                            objectOutputStream.writeObject(statusLine.getReasonPhrase());
                                            objectOutputStream.writeObject(strArr);
                                            objectOutputStream.writeObject(bArr);
                                            try {
                                                objectOutputStream.close();
                                            } catch (Exception unused2) {
                                            }
                                            try {
                                                fileOutputStream.close();
                                            } catch (Exception unused3) {
                                            }
                                            return true;
                                        } catch (Exception e) {
                                            e = e;
                                            objectOutputStream2 = objectOutputStream;
                                            e.printStackTrace();
                                            if (objectOutputStream2 != null) {
                                                try {
                                                    objectOutputStream2.close();
                                                } catch (Exception unused4) {
                                                }
                                            }
                                            if (fileOutputStream != null) {
                                                fileOutputStream.close();
                                            }
                                            return false;
                                        } catch (Throwable th) {
                                            th = th;
                                            objectOutputStream2 = objectOutputStream;
                                            if (objectOutputStream2 != null) {
                                                try {
                                                    objectOutputStream2.close();
                                                } catch (Exception unused5) {
                                                }
                                            }
                                            if (fileOutputStream == null) {
                                                throw th;
                                            }
                                            try {
                                                fileOutputStream.close();
                                                throw th;
                                            } catch (Exception unused6) {
                                                throw th;
                                            }
                                        }
                                    } catch (Exception e2) {
                                        e = e2;
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                }
                            } catch (Exception e3) {
                                e = e3;
                                fileOutputStream = null;
                            } catch (Throwable th3) {
                                th = th3;
                                fileOutputStream = null;
                            }
                        } catch (Exception e4) {
                            e = e4;
                            byteArrayOutputStream = byteArrayOutputStream2;
                            e.printStackTrace();
                            if (byteArrayOutputStream != null) {
                                byteArrayOutputStream.close();
                            }
                            return false;
                        } catch (Throwable th4) {
                            th = th4;
                            byteArrayOutputStream = byteArrayOutputStream2;
                            if (byteArrayOutputStream != null) {
                                try {
                                    byteArrayOutputStream.close();
                                } catch (Exception unused7) {
                                }
                            }
                            throw th;
                        }
                    } catch (Exception e5) {
                        e = e5;
                    }
                } catch (Throwable th5) {
                    th = th5;
                }
            } catch (Exception unused8) {
            }
            return false;
        } finally {
            this.m.v(dVarF);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x00a3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x009e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final org.apache.http.HttpResponse L(com.duokan.reader.common.cache.HttpCache.FileCacheKey r17) throws java.lang.Throwable {
        /*
            r16 = this;
            r1 = r16
            com.duokan.reader.common.cache.FileCache r0 = r1.m
            r2 = 0
            if (r0 != 0) goto L8
            return r2
        L8:
            r3 = r17
            com.duokan.reader.common.cache.b$d r3 = r0.E(r3)
            if (r3 != 0) goto L11
            return r2
        L11:
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L81 java.lang.Exception -> L84
            T r0 = r3.f4002b     // Catch: java.lang.Throwable -> L81 java.lang.Exception -> L84
            java.io.File r0 = (java.io.File) r0     // Catch: java.lang.Throwable -> L81 java.lang.Exception -> L84
            r4.<init>(r0)     // Catch: java.lang.Throwable -> L81 java.lang.Exception -> L84
            java.io.ObjectInputStream r5 = new java.io.ObjectInputStream     // Catch: java.lang.Throwable -> L7c java.lang.Exception -> L7e
            r5.<init>(r4)     // Catch: java.lang.Throwable -> L7c java.lang.Exception -> L7e
            java.lang.Object r0 = r5.readObject()     // Catch: java.lang.Exception -> L7a java.lang.Throwable -> L9a
            org.apache.http.ProtocolVersion r0 = (org.apache.http.ProtocolVersion) r0     // Catch: java.lang.Exception -> L7a java.lang.Throwable -> L9a
            int r6 = r5.readInt()     // Catch: java.lang.Exception -> L7a java.lang.Throwable -> L9a
            java.lang.Object r7 = r5.readObject()     // Catch: java.lang.Exception -> L7a java.lang.Throwable -> L9a
            java.lang.String r7 = (java.lang.String) r7     // Catch: java.lang.Exception -> L7a java.lang.Throwable -> L9a
            java.lang.Object r8 = r5.readObject()     // Catch: java.lang.Exception -> L7a java.lang.Throwable -> L9a
            java.lang.String[][] r8 = (java.lang.String[][]) r8     // Catch: java.lang.Exception -> L7a java.lang.Throwable -> L9a
            java.lang.Object r9 = r5.readObject()     // Catch: java.lang.Exception -> L7a java.lang.Throwable -> L9a
            byte[] r9 = (byte[]) r9     // Catch: java.lang.Exception -> L7a java.lang.Throwable -> L9a
            org.apache.http.message.BasicStatusLine r10 = new org.apache.http.message.BasicStatusLine     // Catch: java.lang.Exception -> L7a java.lang.Throwable -> L9a
            r10.<init>(r0, r6, r7)     // Catch: java.lang.Exception -> L7a java.lang.Throwable -> L9a
            int r0 = r8.length     // Catch: java.lang.Exception -> L7a java.lang.Throwable -> L9a
            org.apache.http.Header[] r6 = new org.apache.http.Header[r0]     // Catch: java.lang.Exception -> L7a java.lang.Throwable -> L9a
            r7 = 0
            r11 = r7
        L45:
            if (r11 >= r0) goto L58
            org.apache.http.message.BasicHeader r12 = new org.apache.http.message.BasicHeader     // Catch: java.lang.Exception -> L7a java.lang.Throwable -> L9a
            r13 = r8[r11]     // Catch: java.lang.Exception -> L7a java.lang.Throwable -> L9a
            r14 = r13[r7]     // Catch: java.lang.Exception -> L7a java.lang.Throwable -> L9a
            r15 = 1
            r13 = r13[r15]     // Catch: java.lang.Exception -> L7a java.lang.Throwable -> L9a
            r12.<init>(r14, r13)     // Catch: java.lang.Exception -> L7a java.lang.Throwable -> L9a
            r6[r11] = r12     // Catch: java.lang.Exception -> L7a java.lang.Throwable -> L9a
            int r11 = r11 + 1
            goto L45
        L58:
            int r0 = r9.length     // Catch: java.lang.Exception -> L7a java.lang.Throwable -> L9a
            if (r0 <= 0) goto L61
            org.apache.http.entity.ByteArrayEntity r0 = new org.apache.http.entity.ByteArrayEntity     // Catch: java.lang.Exception -> L7a java.lang.Throwable -> L9a
            r0.<init>(r9)     // Catch: java.lang.Exception -> L7a java.lang.Throwable -> L9a
            r2 = r0
        L61:
            r5.close()     // Catch: java.lang.Exception -> L64
        L64:
            r4.close()     // Catch: java.lang.Exception -> L67
        L67:
            com.duokan.reader.common.cache.FileCache r0 = r1.m
            r0.v(r3)
            com.duokan.reader.common.cache.HttpCache$b r0 = new com.duokan.reader.common.cache.HttpCache$b
            r0.<init>(r10)
            r0.setHeaders(r6)
            if (r2 == 0) goto L79
            r0.setEntity(r2)
        L79:
            return r0
        L7a:
            r0 = move-exception
            goto L87
        L7c:
            r0 = move-exception
            goto L9c
        L7e:
            r0 = move-exception
            r5 = r2
            goto L87
        L81:
            r0 = move-exception
            r4 = r2
            goto L9c
        L84:
            r0 = move-exception
            r4 = r2
            r5 = r4
        L87:
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L9a
            if (r5 == 0) goto L8f
            r5.close()     // Catch: java.lang.Exception -> L8f
        L8f:
            if (r4 == 0) goto L94
            r4.close()     // Catch: java.lang.Exception -> L94
        L94:
            com.duokan.reader.common.cache.FileCache r0 = r1.m
            r0.v(r3)
            return r2
        L9a:
            r0 = move-exception
            r2 = r5
        L9c:
            if (r2 == 0) goto La1
            r2.close()     // Catch: java.lang.Exception -> La1
        La1:
            if (r4 == 0) goto La6
            r4.close()     // Catch: java.lang.Exception -> La6
        La6:
            com.duokan.reader.common.cache.FileCache r2 = r1.m
            r2.v(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.duokan.reader.common.cache.HttpCache.L(com.duokan.reader.common.cache.HttpCache$FileCacheKey):org.apache.http.HttpResponse");
    }

    @Override // com.duokan.reader.common.cache.b
    /* JADX INFO: renamed from: M, reason: merged with bridge method [inline-methods] */
    public int s(HttpResponse httpResponse) {
        return 0;
    }

    @Override // com.duokan.reader.common.cache.b
    public void j(b.d<HttpResponse> dVar) {
        I(new FileCacheKey((CacheKey) dVar.f4001a));
    }

    @Override // com.duokan.reader.common.cache.b
    public void l(b.d<HttpResponse> dVar) {
        CacheKey cacheKey = (CacheKey) dVar.f4001a;
        HttpResponse httpResponse = dVar.f4002b;
        if (httpResponse instanceof b) {
            return;
        }
        K(new FileCacheKey(cacheKey), httpResponse);
    }

    @Override // com.duokan.reader.common.cache.b
    public b.d<HttpResponse> n(b.c cVar, boolean z) {
        HttpResponse httpResponseL;
        CacheKey cacheKey = (CacheKey) cVar;
        b.d<HttpResponse> dVarN = super.n(cVar, true);
        if (dVarN == null) {
            return (dVarN != null || (httpResponseL = L(new FileCacheKey(cacheKey))) == null) ? dVarN : a(cVar, this.n, httpResponseL);
        }
        if (z || !dVarN.c) {
            return dVarN;
        }
        return null;
    }

    public HttpCache(String str, int i, FileCache fileCache) {
        super(str, i, null);
        this.n = new a();
        this.m = fileCache;
    }
}
