package com.bytedance.pangle.util.g.z;

import android.support.v4.media.session.PlaybackStateCompat;
import com.bytedance.pangle.util.g.g.a;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class z {
    public a z(String str) throws Throwable {
        RandomAccessFile randomAccessFile;
        RandomAccessFile randomAccessFile2 = null;
        try {
            randomAccessFile = new RandomAccessFile(str, "r");
        } catch (Throwable th) {
            th = th;
        }
        try {
            if (randomAccessFile.length() < 22) {
                throw new IOException("Zip file size less than minimum expected zip file size. Probably not a zip file or a corrupted zip file");
            }
            a aVar = new a(str);
            z(randomAccessFile, aVar);
            if (aVar.g().z() != 0) {
                g(randomAccessFile, aVar);
                try {
                    randomAccessFile.close();
                } catch (IOException unused) {
                }
                return aVar;
            }
            try {
                randomAccessFile.close();
            } catch (IOException unused2) {
            }
            return aVar;
        } catch (Throwable th2) {
            th = th2;
            randomAccessFile2 = randomAccessFile;
            if (randomAccessFile2 != null) {
                try {
                    randomAccessFile2.close();
                } catch (IOException unused3) {
                }
            }
            throw th;
        }
    }

    private void z(RandomAccessFile randomAccessFile, a aVar) throws IOException {
        randomAccessFile.seek(dl(randomAccessFile, aVar) + 4);
        com.bytedance.pangle.util.g.g.g gVar = new com.bytedance.pangle.util.g.g.g();
        randomAccessFile.skipBytes(6);
        gVar.z(aVar.a().g(randomAccessFile));
        randomAccessFile.skipBytes(4);
        gVar.z(aVar.a().z(randomAccessFile));
        aVar.z(gVar);
    }

    private void g(RandomAccessFile randomAccessFile, a aVar) throws IOException {
        com.bytedance.pangle.util.g.g.z zVar = new com.bytedance.pangle.util.g.g.z();
        ArrayList arrayList = new ArrayList();
        long jG = aVar.g().g();
        long jZ = aVar.g().z();
        randomAccessFile.seek(jG);
        for (int i = 0; i < jZ; i++) {
            com.bytedance.pangle.util.g.g.dl dlVar = new com.bytedance.pangle.util.g.g.dl();
            if (aVar.a().z(randomAccessFile) != 33639248) {
                throw new IOException("Expected central directory entry not found (#" + (i + 1) + ")");
            }
            randomAccessFile.skipBytes(6);
            dlVar.z(aVar.a().g(randomAccessFile));
            randomAccessFile.skipBytes(4);
            dlVar.z(aVar.a().z(randomAccessFile));
            dlVar.g(aVar.a().z(randomAccessFile));
            dlVar.dl(aVar.a().z(randomAccessFile));
            int iG = aVar.a().g(randomAccessFile);
            dlVar.dl(iG);
            dlVar.a(aVar.a().g(randomAccessFile));
            int iG2 = aVar.a().g(randomAccessFile);
            randomAccessFile.skipBytes(8);
            dlVar.a(aVar.a().z(randomAccessFile));
            if (iG > 0) {
                byte[] bArr = new byte[iG];
                randomAccessFile.readFully(bArr);
                dlVar.z(z(bArr));
                randomAccessFile.skipBytes(dlVar.kb());
                if (iG2 > 0) {
                    randomAccessFile.skipBytes(iG2);
                }
                long filePointer = randomAccessFile.getFilePointer();
                randomAccessFile.seek(dlVar.i() + 28);
                dlVar.g(aVar.a().g(randomAccessFile));
                randomAccessFile.seek(filePointer);
                arrayList.add(dlVar);
            } else {
                throw new IOException("Invalid entry name in file header");
            }
        }
        zVar.z(arrayList);
        aVar.z(zVar);
    }

    private long dl(RandomAccessFile randomAccessFile, a aVar) throws IOException {
        long length = randomAccessFile.length();
        if (length < 22) {
            throw new IOException("Zip file size less than size of zip headers. Probably not a zip file.");
        }
        long j = length - 22;
        randomAccessFile.seek(j);
        return ((long) aVar.a().z(randomAccessFile)) == 101010256 ? j : a(randomAccessFile, aVar);
    }

    private long a(RandomAccessFile randomAccessFile, a aVar) throws IOException {
        long length = randomAccessFile.length() - 22;
        long length2 = randomAccessFile.length();
        long length3 = PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
        if (length2 < PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) {
            length3 = randomAccessFile.length();
        }
        while (length3 > 0 && length > 0) {
            length--;
            randomAccessFile.seek(length);
            if (aVar.a().z(randomAccessFile) == 101010256) {
                return length;
            }
            length3--;
        }
        throw new IOException("Zip headers not found. Probably not a zip file");
    }

    private String z(byte[] bArr) {
        return new String(bArr, Charset.forName("UTF-8"));
    }
}
