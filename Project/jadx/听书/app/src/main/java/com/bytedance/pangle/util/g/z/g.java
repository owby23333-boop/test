package com.bytedance.pangle.util.g.z;

import com.bytedance.pangle.util.g.g.a;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class g {
    public void z(a aVar, RandomAccessFile randomAccessFile) throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream;
        if (aVar == null || randomAccessFile == null) {
            throw new IOException("input parameters is null, cannot finalize zip file");
        }
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
        } catch (Throwable th) {
            th = th;
        }
        try {
            long filePointer = randomAccessFile.getFilePointer();
            z(aVar, byteArrayOutputStream);
            z(aVar, byteArrayOutputStream.size(), (int) filePointer, byteArrayOutputStream);
            randomAccessFile.write(byteArrayOutputStream.toByteArray());
            byteArrayOutputStream.close();
        } catch (Throwable th2) {
            th = th2;
            byteArrayOutputStream2 = byteArrayOutputStream;
            if (byteArrayOutputStream2 != null) {
                byteArrayOutputStream2.close();
            }
            throw th;
        }
    }

    private void z(a aVar, ByteArrayOutputStream byteArrayOutputStream) throws IOException {
        if (aVar.z() == null || aVar.z().z() == null || aVar.z().z().size() <= 0) {
            return;
        }
        Iterator<com.bytedance.pangle.util.g.g.dl> it = aVar.z().z().iterator();
        while (it.hasNext()) {
            z(it.next(), byteArrayOutputStream, aVar.a());
        }
    }

    private void z(com.bytedance.pangle.util.g.g.dl dlVar, ByteArrayOutputStream byteArrayOutputStream, dl dlVar2) throws IOException {
        if (dlVar == null) {
            throw new IOException("input parameters is null, cannot write local file header");
        }
        byte[] bArr = {0, 0};
        dlVar2.z((OutputStream) byteArrayOutputStream, 33639248);
        dlVar2.z(byteArrayOutputStream, 0);
        dlVar2.z(byteArrayOutputStream, 0);
        dlVar2.z(byteArrayOutputStream, 0);
        dlVar2.z(byteArrayOutputStream, dlVar.z());
        dlVar2.z(byteArrayOutputStream, 2081);
        dlVar2.z(byteArrayOutputStream, 545);
        dlVar2.z((OutputStream) byteArrayOutputStream, (int) dlVar.e());
        dlVar2.z((OutputStream) byteArrayOutputStream, (int) dlVar.gz());
        dlVar2.z((OutputStream) byteArrayOutputStream, (int) dlVar.fo());
        byte[] bArrZ = new byte[0];
        if (dlVar.wp() != null && dlVar.wp().trim().length() > 0) {
            bArrZ = z(dlVar.wp());
        }
        dlVar2.z(byteArrayOutputStream, bArrZ.length);
        int iKb = dlVar.kb();
        dlVar2.z(byteArrayOutputStream, iKb);
        dlVar2.z(byteArrayOutputStream, 0);
        byteArrayOutputStream.write(bArr);
        byteArrayOutputStream.write(bArr);
        byteArrayOutputStream.write(bArr);
        byteArrayOutputStream.write(bArr);
        dlVar2.z((OutputStream) byteArrayOutputStream, (int) dlVar.i());
        if (bArrZ.length > 0) {
            byteArrayOutputStream.write(bArrZ);
        }
        if (iKb > 0) {
            byteArrayOutputStream.write(new byte[iKb]);
        }
    }

    private void z(a aVar, int i, int i2, ByteArrayOutputStream byteArrayOutputStream) throws IOException {
        aVar.a().z((OutputStream) byteArrayOutputStream, 101010256);
        aVar.a().z(byteArrayOutputStream, 0);
        aVar.a().z(byteArrayOutputStream, 0);
        int size = aVar.z().z().size();
        aVar.a().z(byteArrayOutputStream, size);
        aVar.a().z(byteArrayOutputStream, size);
        aVar.a().z((OutputStream) byteArrayOutputStream, i);
        aVar.a().z((OutputStream) byteArrayOutputStream, i2);
        aVar.a().z(byteArrayOutputStream, 0);
    }

    private byte[] z(String str) {
        return str.getBytes(Charset.forName("UTF-8"));
    }
}
