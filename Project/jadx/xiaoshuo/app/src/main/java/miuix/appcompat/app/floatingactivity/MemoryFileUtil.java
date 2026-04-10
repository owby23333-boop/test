package miuix.appcompat.app.floatingactivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.util.Log;
import java.nio.ByteBuffer;
import java.util.HashMap;
import miuix.appcompat.app.floatingactivity.multiapp.IFloatingService;
import miuix.appcompat.app.floatingactivity.multiapp.MethodCodeHelper;

/* JADX INFO: loaded from: classes7.dex */
public class MemoryFileUtil {
    public static final String KEY_FD = "parcelFile";
    public static final String KEY_HEIGHT = "key_height";
    public static final String KEY_LENGTH = "parcelFileLength";
    public static final String KEY_WIDTH = "key_width";
    private static final String TAG = "MemoryFileUtil";

    public static Bitmap readBitmap(Bundle bundle) throws Throwable {
        HashMap map = (HashMap) bundle.getSerializable(KEY_FD);
        int i = bundle.getInt(KEY_LENGTH);
        int i2 = bundle.getInt(KEY_WIDTH);
        int i3 = bundle.getInt(KEY_HEIGHT);
        byte[] fromMemory = readFromMemory(map, i);
        Bitmap bitmapCreateBitmap = null;
        if (fromMemory == null) {
            Log.d(TAG, "getSnapShot with data is null");
            return null;
        }
        try {
            bitmapCreateBitmap = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
            bitmapCreateBitmap.copyPixelsFromBuffer(ByteBuffer.wrap(fromMemory));
            return bitmapCreateBitmap;
        } catch (IllegalArgumentException e) {
            Log.w(TAG, "catch illegal argument exception", e);
            return bitmapCreateBitmap;
        } catch (OutOfMemoryError e2) {
            Log.w(TAG, "catch oom exception", e2);
            return bitmapCreateBitmap;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x0052 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static byte[] readFromMemory(java.util.HashMap<java.lang.String, android.os.ParcelFileDescriptor> r6, int r7) throws java.lang.Throwable {
        /*
            java.lang.String r0 = "catch close fd error"
            java.lang.String r1 = "catch close FileInputStream error"
            java.lang.String r2 = "MemoryFileUtil"
            java.lang.String r3 = "parcelFile"
            java.lang.Object r6 = r6.get(r3)
            android.os.ParcelFileDescriptor r6 = (android.os.ParcelFileDescriptor) r6
            r3 = 0
            if (r6 == 0) goto L63
            byte[] r7 = new byte[r7]
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L32 java.lang.Exception -> L34
            java.io.FileDescriptor r5 = r6.getFileDescriptor()     // Catch: java.lang.Throwable -> L32 java.lang.Exception -> L34
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L32 java.lang.Exception -> L34
            r4.read(r7)     // Catch: java.lang.Exception -> L30 java.lang.Throwable -> L4e
            r4.close()     // Catch: java.io.IOException -> L23
            goto L27
        L23:
            r3 = move-exception
            android.util.Log.w(r2, r1, r3)
        L27:
            r6.close()     // Catch: java.io.IOException -> L2b
            goto L2f
        L2b:
            r6 = move-exception
            android.util.Log.w(r2, r0, r6)
        L2f:
            return r7
        L30:
            r7 = move-exception
            goto L36
        L32:
            r7 = move-exception
            goto L50
        L34:
            r7 = move-exception
            r4 = r3
        L36:
            java.lang.String r5 = "catch read from memory error"
            android.util.Log.w(r2, r5, r7)     // Catch: java.lang.Throwable -> L4e
            if (r4 == 0) goto L63
            r4.close()     // Catch: java.io.IOException -> L41
            goto L45
        L41:
            r7 = move-exception
            android.util.Log.w(r2, r1, r7)
        L45:
            r6.close()     // Catch: java.io.IOException -> L49
            goto L63
        L49:
            r6 = move-exception
            android.util.Log.w(r2, r0, r6)
            goto L63
        L4e:
            r7 = move-exception
            r3 = r4
        L50:
            if (r3 == 0) goto L62
            r3.close()     // Catch: java.io.IOException -> L56
            goto L5a
        L56:
            r3 = move-exception
            android.util.Log.w(r2, r1, r3)
        L5a:
            r6.close()     // Catch: java.io.IOException -> L5e
            goto L62
        L5e:
            r6 = move-exception
            android.util.Log.w(r2, r0, r6)
        L62:
            throw r7
        L63:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: miuix.appcompat.app.floatingactivity.MemoryFileUtil.readFromMemory(java.util.HashMap, int):byte[]");
    }

    public static void sendToFdServer(IFloatingService iFloatingService, byte[] bArr, int i, int i2, int i3, String str, int i4) throws Throwable {
        ParcelFileDescriptor parcelFileDescriptorWriteToMemory = writeToMemory(bArr, i);
        HashMap map = new HashMap(1);
        map.put(KEY_FD, parcelFileDescriptorWriteToMemory);
        Bundle bundle = new Bundle();
        bundle.putSerializable(KEY_FD, map);
        bundle.putInt(KEY_LENGTH, i);
        bundle.putInt(KEY_WIDTH, i2);
        bundle.putInt(KEY_HEIGHT, i3);
        bundle.putInt(MethodCodeHelper.KEY_TASK_ID, i4);
        bundle.putString(MethodCodeHelper.KEY_REQUEST_IDENTITY, str);
        if (iFloatingService != null) {
            try {
                iFloatingService.callServiceMethod(7, bundle);
            } catch (RemoteException e) {
                Log.w(TAG, "catch stash snapshot to service error", e);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x003f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.os.ParcelFileDescriptor writeToMemory(byte[] r4, int r5) throws java.lang.Throwable {
        /*
            r0 = 0
            android.os.MemoryFile r1 = new android.os.MemoryFile     // Catch: java.lang.Throwable -> L2c java.lang.Exception -> L2e
            java.lang.String r2 = ""
            r1.<init>(r2, r5)     // Catch: java.lang.Throwable -> L2c java.lang.Exception -> L2e
            r2 = 0
            r1.writeBytes(r4, r2, r2, r5)     // Catch: java.lang.Exception -> L2a java.lang.Throwable -> L3b
            java.lang.Class<android.os.MemoryFile> r4 = android.os.MemoryFile.class
            java.lang.String r5 = "getFileDescriptor"
            java.lang.Class[] r3 = new java.lang.Class[r2]     // Catch: java.lang.Exception -> L2a java.lang.Throwable -> L3b
            java.lang.reflect.Method r4 = r4.getDeclaredMethod(r5, r3)     // Catch: java.lang.Exception -> L2a java.lang.Throwable -> L3b
            r5 = 1
            r4.setAccessible(r5)     // Catch: java.lang.Exception -> L2a java.lang.Throwable -> L3b
            java.lang.Object[] r5 = new java.lang.Object[r2]     // Catch: java.lang.Exception -> L2a java.lang.Throwable -> L3b
            java.lang.Object r4 = r4.invoke(r1, r5)     // Catch: java.lang.Exception -> L2a java.lang.Throwable -> L3b
            java.io.FileDescriptor r4 = (java.io.FileDescriptor) r4     // Catch: java.lang.Exception -> L2a java.lang.Throwable -> L3b
            android.os.ParcelFileDescriptor r0 = android.os.ParcelFileDescriptor.dup(r4)     // Catch: java.lang.Exception -> L2a java.lang.Throwable -> L3b
        L26:
            r1.close()
            goto L3a
        L2a:
            r4 = move-exception
            goto L30
        L2c:
            r4 = move-exception
            goto L3d
        L2e:
            r4 = move-exception
            r1 = r0
        L30:
            java.lang.String r5 = "MemoryFileUtil"
            java.lang.String r2 = "catch write to memory error"
            android.util.Log.w(r5, r2, r4)     // Catch: java.lang.Throwable -> L3b
            if (r1 == 0) goto L3a
            goto L26
        L3a:
            return r0
        L3b:
            r4 = move-exception
            r0 = r1
        L3d:
            if (r0 == 0) goto L42
            r0.close()
        L42:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: miuix.appcompat.app.floatingactivity.MemoryFileUtil.writeToMemory(byte[], int):android.os.ParcelFileDescriptor");
    }
}
