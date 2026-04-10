package com.kwad.sdk.core.videocache.kwai;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
final class d {

    static final class a implements Comparator<File> {
        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(File file, File file2) {
            return compareLong(file.lastModified(), file2.lastModified());
        }

        private static int compareLong(long j2, long j3) {
            if (j2 < j3) {
                return -1;
            }
            return j2 == j3 ? 0 : 1;
        }
    }

    static void p(File file) throws IOException {
        if (!file.exists()) {
            if (!file.mkdirs()) {
                throw new IOException(String.format("Directory %s can't be created", file.getAbsolutePath()));
            }
        } else {
            if (file.isDirectory()) {
                return;
            }
            throw new IOException("File " + file + " is not directory!");
        }
    }

    static List<File> q(File file) {
        LinkedList linkedList = new LinkedList();
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            return linkedList;
        }
        List<File> listAsList = Arrays.asList(fileArrListFiles);
        Collections.sort(listAsList, new a((byte) 0));
        return listAsList;
    }

    static void r(File file) throws Throwable {
        if (file.exists()) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (file.setLastModified(jCurrentTimeMillis)) {
                return;
            }
            s(file);
            if (file.lastModified() < jCurrentTimeMillis) {
                com.kwad.sdk.core.d.b.w("Files", String.format("Last modified date %s is not set for file %s", new Date(file.lastModified()), file.getAbsolutePath()));
            }
        }
    }

    private static void s(File file) throws Throwable {
        long length = file.length();
        if (length == 0) {
            t(file);
            return;
        }
        RandomAccessFile randomAccessFile = null;
        try {
            try {
                RandomAccessFile randomAccessFile2 = new RandomAccessFile(file, "rwd");
                long j2 = length - 1;
                try {
                    randomAccessFile2.seek(j2);
                    byte b = randomAccessFile2.readByte();
                    randomAccessFile2.seek(j2);
                    randomAccessFile2.write(b);
                    com.kwad.sdk.crash.utils.b.closeQuietly(randomAccessFile2);
                } catch (IOException e2) {
                    e = e2;
                    randomAccessFile = randomAccessFile2;
                    com.kwad.sdk.core.d.b.printStackTraceOnly(e);
                    com.kwad.sdk.crash.utils.b.closeQuietly(randomAccessFile);
                } catch (Throwable th) {
                    th = th;
                    randomAccessFile = randomAccessFile2;
                    com.kwad.sdk.crash.utils.b.closeQuietly(randomAccessFile);
                    throw th;
                }
            } catch (IOException e3) {
                e = e3;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static void t(File file) throws IOException {
        if (file.delete() && file.createNewFile()) {
            return;
        }
        throw new IOException("Error recreate zero-size file " + file);
    }
}
