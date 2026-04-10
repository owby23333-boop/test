package com.dangdang.zframework.network.command;

import android.os.SystemClock;
import com.dangdang.zframework.log.LogM;
import com.dangdang.zframework.network.command.Cache;
import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes10.dex */
public class DiskBasedCache implements Cache {
    private static final int CACHE_MAGIC = 538183203;
    private static final int DEFAULT_DISK_USAGE_BYTES = 5242880;
    private static final float HYSTERESIS_FACTOR = 0.9f;
    private final Map<String, CacheHeader> mEntries;
    private final int mMaxCacheSizeInBytes;
    private final File mRootDirectory;
    private long mTotalSize;

    public static class CacheHeader {
        public long code;
        public String etag;
        public String key;
        public Map<String, String> responseHeaders;
        public long serverDate;
        public long size;
        public long softTtl;
        public long ttl;

        private CacheHeader() {
        }

        public static CacheHeader readHeader(InputStream inputStream) throws IOException {
            CacheHeader cacheHeader = new CacheHeader();
            if (DiskBasedCache.readInt(inputStream) != DiskBasedCache.CACHE_MAGIC) {
                throw new IOException();
            }
            cacheHeader.key = DiskBasedCache.readString(inputStream);
            String string = DiskBasedCache.readString(inputStream);
            cacheHeader.etag = string;
            if (string.equals("")) {
                cacheHeader.etag = null;
            }
            cacheHeader.serverDate = DiskBasedCache.readLong(inputStream);
            cacheHeader.ttl = DiskBasedCache.readLong(inputStream);
            cacheHeader.softTtl = DiskBasedCache.readLong(inputStream);
            cacheHeader.responseHeaders = DiskBasedCache.readStringStringMap(inputStream);
            cacheHeader.code = DiskBasedCache.readLong(inputStream);
            return cacheHeader;
        }

        public Cache.Entry toCacheEntry(byte[] bArr) {
            Cache.Entry entry = new Cache.Entry();
            try {
                entry.data = bArr;
            } catch (Exception e) {
                LogM.e(e.toString());
            }
            entry.etag = this.etag;
            entry.serverDate = this.serverDate;
            entry.ttl = this.ttl;
            entry.softTtl = this.softTtl;
            entry.responseHeaders = this.responseHeaders;
            entry.code = (int) this.code;
            return entry;
        }

        public boolean writeHeader(OutputStream outputStream) {
            try {
                DiskBasedCache.writeInt(outputStream, DiskBasedCache.CACHE_MAGIC);
                DiskBasedCache.writeString(outputStream, this.key);
                String str = this.etag;
                if (str == null) {
                    str = "";
                }
                DiskBasedCache.writeString(outputStream, str);
                DiskBasedCache.writeLong(outputStream, this.serverDate);
                DiskBasedCache.writeLong(outputStream, this.ttl);
                DiskBasedCache.writeLong(outputStream, this.softTtl);
                DiskBasedCache.writeStringStringMap(this.responseHeaders, outputStream);
                DiskBasedCache.writeLong(outputStream, this.code);
                outputStream.flush();
                return true;
            } catch (IOException e) {
                LogM.v("%s", e.toString());
                return false;
            }
        }

        public CacheHeader(String str, Cache.Entry entry) {
            this.key = str;
            this.size = entry.data.length;
            this.etag = entry.etag;
            this.serverDate = entry.serverDate;
            this.ttl = entry.ttl;
            this.softTtl = entry.softTtl;
            this.responseHeaders = entry.responseHeaders;
            this.code = entry.code;
        }
    }

    public static class CountingInputStream extends FilterInputStream {
        private int bytesRead;

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read() throws IOException {
            int i = super.read();
            if (i != -1) {
                this.bytesRead++;
            }
            return i;
        }

        private CountingInputStream(InputStream inputStream) {
            super(inputStream);
            this.bytesRead = 0;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            int i3 = super.read(bArr, i, i2);
            if (i3 != -1) {
                this.bytesRead += i3;
            }
            return i3;
        }
    }

    public DiskBasedCache(File file, int i) {
        this.mEntries = new LinkedHashMap(16, 0.75f, true);
        this.mTotalSize = 0L;
        this.mRootDirectory = file;
        this.mMaxCacheSizeInBytes = i;
    }

    private String getFilenameForKey(String str) {
        int length = str.length() / 2;
        return String.valueOf(str.substring(0, length).hashCode()) + String.valueOf(str.substring(length).hashCode());
    }

    private void pruneIfNeeded(int i) {
        if (this.mTotalSize + i < this.mMaxCacheSizeInBytes) {
            return;
        }
        LogM.d("Pruning old cache entries.");
        long j = this.mTotalSize;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        Iterator<Map.Entry<String, CacheHeader>> it = this.mEntries.entrySet().iterator();
        int i2 = 0;
        while (it.hasNext()) {
            CacheHeader value = it.next().getValue();
            if (getFileForKey(value.key).delete()) {
                this.mTotalSize -= value.size;
            } else {
                LogM.d("Could not delete cache entry for key=" + value.key + ", filename=" + getFilenameForKey(value.key));
            }
            it.remove();
            i2++;
            if (this.mTotalSize + r2 < this.mMaxCacheSizeInBytes * 0.9f) {
                break;
            }
        }
        LogM.v("pruned %d files, %d bytes, %d ms", Integer.valueOf(i2), Long.valueOf(this.mTotalSize - j), Long.valueOf(SystemClock.elapsedRealtime() - jElapsedRealtime));
    }

    private void putEntry(String str, CacheHeader cacheHeader) {
        if (this.mEntries.containsKey(str)) {
            this.mTotalSize += cacheHeader.size - this.mEntries.get(str).size;
        } else {
            this.mTotalSize += cacheHeader.size;
        }
        this.mEntries.put(str, cacheHeader);
    }

    private static int read(InputStream inputStream) throws IOException {
        int i = inputStream.read();
        if (i != -1) {
            return i;
        }
        throw new EOFException();
    }

    public static int readInt(InputStream inputStream) throws IOException {
        return (read(inputStream) << 24) | (read(inputStream) << 0) | 0 | (read(inputStream) << 8) | (read(inputStream) << 16);
    }

    public static long readLong(InputStream inputStream) throws IOException {
        return ((((long) read(inputStream)) & 255) << 0) | 0 | ((((long) read(inputStream)) & 255) << 8) | ((((long) read(inputStream)) & 255) << 16) | ((((long) read(inputStream)) & 255) << 24) | ((((long) read(inputStream)) & 255) << 32) | ((((long) read(inputStream)) & 255) << 40) | ((((long) read(inputStream)) & 255) << 48) | ((255 & ((long) read(inputStream))) << 56);
    }

    public static String readString(InputStream inputStream) throws IOException {
        return new String(streamToBytes(inputStream, (int) readLong(inputStream)), "UTF-8");
    }

    public static Map<String, String> readStringStringMap(InputStream inputStream) throws IOException {
        int i = readInt(inputStream);
        Map<String, String> mapEmptyMap = i == 0 ? Collections.emptyMap() : new HashMap<>(i);
        for (int i2 = 0; i2 < i; i2++) {
            mapEmptyMap.put(readString(inputStream).intern(), readString(inputStream).intern());
        }
        return mapEmptyMap;
    }

    private void removeEntry(String str) {
        CacheHeader cacheHeader = this.mEntries.get(str);
        if (cacheHeader != null) {
            this.mTotalSize -= cacheHeader.size;
            this.mEntries.remove(str);
        }
    }

    private static byte[] streamToBytes(InputStream inputStream, int i) throws IOException {
        byte[] bArr = new byte[i];
        int i2 = 0;
        while (i2 < i) {
            int i3 = inputStream.read(bArr, i2, i - i2);
            if (i3 == -1) {
                break;
            }
            i2 += i3;
        }
        if (i2 == i) {
            return bArr;
        }
        throw new IOException("Expected " + i + " bytes, read " + i2 + " bytes");
    }

    public static void writeInt(OutputStream outputStream, int i) throws IOException {
        outputStream.write((i >> 0) & 255);
        outputStream.write((i >> 8) & 255);
        outputStream.write((i >> 16) & 255);
        outputStream.write((i >> 24) & 255);
    }

    public static void writeLong(OutputStream outputStream, long j) throws IOException {
        outputStream.write((byte) (j >>> 0));
        outputStream.write((byte) (j >>> 8));
        outputStream.write((byte) (j >>> 16));
        outputStream.write((byte) (j >>> 24));
        outputStream.write((byte) (j >>> 32));
        outputStream.write((byte) (j >>> 40));
        outputStream.write((byte) (j >>> 48));
        outputStream.write((byte) (j >>> 56));
    }

    public static void writeString(OutputStream outputStream, String str) throws IOException {
        byte[] bytes = str.getBytes("UTF-8");
        writeLong(outputStream, bytes.length);
        outputStream.write(bytes, 0, bytes.length);
    }

    public static void writeStringStringMap(Map<String, String> map, OutputStream outputStream) throws IOException {
        if (map == null) {
            writeInt(outputStream, 0);
            return;
        }
        writeInt(outputStream, map.size());
        for (Map.Entry<String, String> entry : map.entrySet()) {
            writeString(outputStream, entry.getKey());
            writeString(outputStream, entry.getValue());
        }
    }

    @Override // com.dangdang.zframework.network.command.Cache
    public synchronized void clear() {
        File[] fileArrListFiles = this.mRootDirectory.listFiles();
        if (fileArrListFiles != null) {
            for (File file : fileArrListFiles) {
                file.delete();
            }
        }
        this.mEntries.clear();
        this.mTotalSize = 0L;
        LogM.d("Cache cleared.");
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x006f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.dangdang.zframework.network.command.Cache
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized com.dangdang.zframework.network.command.Cache.Entry get(java.lang.String r9) {
        /*
            r8 = this;
            monitor-enter(r8)
            java.util.Map<java.lang.String, com.dangdang.zframework.network.command.DiskBasedCache$CacheHeader> r0 = r8.mEntries     // Catch: java.lang.Throwable -> L76
            java.lang.Object r0 = r0.get(r9)     // Catch: java.lang.Throwable -> L76
            com.dangdang.zframework.network.command.DiskBasedCache$CacheHeader r0 = (com.dangdang.zframework.network.command.DiskBasedCache.CacheHeader) r0     // Catch: java.lang.Throwable -> L76
            r1 = 0
            if (r0 != 0) goto Le
            monitor-exit(r8)
            return r1
        Le:
            java.io.File r2 = r8.getFileForKey(r9)     // Catch: java.lang.Throwable -> L76
            com.dangdang.zframework.network.command.DiskBasedCache$CountingInputStream r3 = new com.dangdang.zframework.network.command.DiskBasedCache$CountingInputStream     // Catch: java.lang.Throwable -> L3b java.io.IOException -> L3e
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L3b java.io.IOException -> L3e
            r4.<init>(r2)     // Catch: java.lang.Throwable -> L3b java.io.IOException -> L3e
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L3b java.io.IOException -> L3e
            com.dangdang.zframework.network.command.DiskBasedCache.CacheHeader.readHeader(r3)     // Catch: java.io.IOException -> L39 java.lang.Throwable -> L6c
            long r4 = r2.length()     // Catch: java.io.IOException -> L39 java.lang.Throwable -> L6c
            int r6 = com.dangdang.zframework.network.command.DiskBasedCache.CountingInputStream.access$100(r3)     // Catch: java.io.IOException -> L39 java.lang.Throwable -> L6c
            long r6 = (long) r6     // Catch: java.io.IOException -> L39 java.lang.Throwable -> L6c
            long r4 = r4 - r6
            int r4 = (int) r4     // Catch: java.io.IOException -> L39 java.lang.Throwable -> L6c
            byte[] r4 = streamToBytes(r3, r4)     // Catch: java.io.IOException -> L39 java.lang.Throwable -> L6c
            com.dangdang.zframework.network.command.Cache$Entry r9 = r0.toCacheEntry(r4)     // Catch: java.io.IOException -> L39 java.lang.Throwable -> L6c
            r3.close()     // Catch: java.io.IOException -> L37 java.lang.Throwable -> L76
            monitor-exit(r8)
            return r9
        L37:
            monitor-exit(r8)
            return r1
        L39:
            r0 = move-exception
            goto L40
        L3b:
            r9 = move-exception
            r3 = r1
            goto L6d
        L3e:
            r0 = move-exception
            r3 = r1
        L40:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L6c
            r4.<init>()     // Catch: java.lang.Throwable -> L6c
            java.lang.String r2 = r2.getAbsolutePath()     // Catch: java.lang.Throwable -> L6c
            r4.append(r2)     // Catch: java.lang.Throwable -> L6c
            java.lang.String r2 = ":"
            r4.append(r2)     // Catch: java.lang.Throwable -> L6c
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L6c
            r4.append(r0)     // Catch: java.lang.Throwable -> L6c
            java.lang.String r0 = r4.toString()     // Catch: java.lang.Throwable -> L6c
            com.dangdang.zframework.log.LogM.d(r0)     // Catch: java.lang.Throwable -> L6c
            r8.remove(r9)     // Catch: java.lang.Throwable -> L6c
            if (r3 == 0) goto L6a
            r3.close()     // Catch: java.io.IOException -> L68 java.lang.Throwable -> L76
            goto L6a
        L68:
            monitor-exit(r8)
            return r1
        L6a:
            monitor-exit(r8)
            return r1
        L6c:
            r9 = move-exception
        L6d:
            if (r3 == 0) goto L75
            r3.close()     // Catch: java.io.IOException -> L73 java.lang.Throwable -> L76
            goto L75
        L73:
            monitor-exit(r8)
            return r1
        L75:
            throw r9     // Catch: java.lang.Throwable -> L76
        L76:
            r9 = move-exception
            monitor-exit(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dangdang.zframework.network.command.DiskBasedCache.get(java.lang.String):com.dangdang.zframework.network.command.Cache$Entry");
    }

    public File getFileForKey(String str) {
        return new File(this.mRootDirectory, getFilenameForKey(str));
    }

    @Override // com.dangdang.zframework.network.command.Cache
    public synchronized void initialize() {
        if (!this.mRootDirectory.exists()) {
            if (!this.mRootDirectory.mkdirs()) {
                LogM.e("Unable to create cache dir %s", this.mRootDirectory.getAbsolutePath());
            }
            return;
        }
        File[] fileArrListFiles = this.mRootDirectory.listFiles();
        if (fileArrListFiles == null) {
            return;
        }
        for (File file : fileArrListFiles) {
            BufferedInputStream bufferedInputStream = null;
            try {
                try {
                    BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file));
                    try {
                        CacheHeader header = CacheHeader.readHeader(bufferedInputStream2);
                        header.size = file.length();
                        putEntry(header.key, header);
                        try {
                            bufferedInputStream2.close();
                        } catch (IOException unused) {
                        }
                    } catch (IOException unused2) {
                        bufferedInputStream = bufferedInputStream2;
                        if (file != null) {
                            file.delete();
                        }
                        if (bufferedInputStream != null) {
                            bufferedInputStream.close();
                        }
                    } catch (Throwable th) {
                        th = th;
                        bufferedInputStream = bufferedInputStream2;
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (IOException unused3) {
                            }
                        }
                        throw th;
                    }
                } catch (IOException unused4) {
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    @Override // com.dangdang.zframework.network.command.Cache
    public synchronized void invalidate(String str, boolean z) {
        Cache.Entry entry = get(str);
        if (entry != null) {
            entry.softTtl = 0L;
            if (z) {
                entry.ttl = 0L;
            }
            put(str, entry);
        }
    }

    @Override // com.dangdang.zframework.network.command.Cache
    public synchronized void put(String str, Cache.Entry entry) {
        File fileForKey;
        try {
            pruneIfNeeded(entry.data.length);
            fileForKey = getFileForKey(str);
        } catch (Exception e) {
            LogM.e(e.toString());
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fileForKey);
            CacheHeader cacheHeader = new CacheHeader(str, entry);
            if (!cacheHeader.writeHeader(fileOutputStream)) {
                fileOutputStream.close();
                LogM.v("Failed to write header for %s", fileForKey.getAbsolutePath());
                throw new IOException();
            }
            fileOutputStream.write(entry.data);
            fileOutputStream.close();
            putEntry(str, cacheHeader);
        } catch (IOException unused) {
            if (!fileForKey.delete()) {
                LogM.v("Could not clean up file %s", fileForKey.getAbsolutePath());
            }
        }
    }

    @Override // com.dangdang.zframework.network.command.Cache
    public synchronized void remove(String str) {
        boolean zDelete = getFileForKey(str).delete();
        removeEntry(str);
        if (!zDelete) {
            LogM.v("Could not delete cache entry for key=%s, filename=%s", str, getFilenameForKey(str));
        }
    }

    public DiskBasedCache(File file) {
        this(file, 5242880);
    }
}
