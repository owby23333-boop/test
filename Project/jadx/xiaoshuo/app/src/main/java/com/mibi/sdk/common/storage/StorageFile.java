package com.mibi.sdk.common.storage;

import com.mibi.sdk.common.Coder;
import com.xiaomi.ad.common.util.SignatureUtils;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/* JADX INFO: loaded from: classes13.dex */
public class StorageFile extends File {
    private static HashMap<String, Object> sFileLocks = new HashMap<>();

    public StorageFile(File file, String str) {
        super(file, str);
    }

    public static Object getFileLock(File file) {
        Object obj;
        synchronized (sFileLocks) {
            String absolutePath = file.getAbsolutePath();
            obj = sFileLocks.get(absolutePath);
            if (obj == null) {
                obj = new Object();
                sFileLocks.put(absolutePath, obj);
            }
        }
        return obj;
    }

    public void append(String str) {
        FileOutputStream fileOutputStream;
        BufferedOutputStream bufferedOutputStream;
        PrintWriter printWriter;
        synchronized (getFileLock(this)) {
            PrintWriter printWriter2 = null;
            try {
                fileOutputStream = new FileOutputStream((File) this, true);
                try {
                    bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                    try {
                        printWriter = new PrintWriter(bufferedOutputStream);
                    } catch (Exception unused) {
                    } catch (Throwable th) {
                        th = th;
                    }
                } catch (Exception unused2) {
                    bufferedOutputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    bufferedOutputStream = null;
                }
            } catch (Exception unused3) {
                fileOutputStream = null;
                bufferedOutputStream = null;
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = null;
                bufferedOutputStream = null;
            }
            try {
                printWriter.println(Coder.encodeBase64(str));
                printWriter.flush();
                printWriter.close();
                try {
                    bufferedOutputStream.close();
                } catch (IOException unused4) {
                }
                try {
                    fileOutputStream.close();
                } catch (IOException unused5) {
                }
            } catch (Exception unused6) {
                printWriter2 = printWriter;
                if (printWriter2 != null) {
                    printWriter2.close();
                }
                if (bufferedOutputStream != null) {
                    try {
                        bufferedOutputStream.close();
                    } catch (IOException unused7) {
                    }
                }
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException unused8) {
                    }
                }
            } catch (Throwable th4) {
                th = th4;
                printWriter2 = printWriter;
                if (printWriter2 != null) {
                    printWriter2.close();
                }
                if (bufferedOutputStream != null) {
                    try {
                        bufferedOutputStream.close();
                    } catch (IOException unused9) {
                    }
                }
                if (fileOutputStream == null) {
                    throw th;
                }
                try {
                    fileOutputStream.close();
                    throw th;
                } catch (IOException unused10) {
                    throw th;
                }
            }
        }
    }

    @Override // java.io.File
    public boolean delete() {
        boolean zDelete;
        synchronized (getFileLock(this)) {
            zDelete = super.delete();
        }
        return zDelete;
    }

    @Override // java.io.File
    public long lastModified() {
        long jLastModified;
        synchronized (getFileLock(this)) {
            jLastModified = super.lastModified();
        }
        return jLastModified;
    }

    @Override // java.io.File
    public long length() {
        long length;
        synchronized (getFileLock(this)) {
            length = super.length();
        }
        return length;
    }

    public String read() {
        Scanner scanner;
        synchronized (getFileLock(this)) {
            StringBuilder sb = new StringBuilder();
            Scanner scanner2 = null;
            try {
                scanner = new Scanner(this);
                while (scanner.hasNextLine()) {
                    try {
                        sb.append(Coder.decodeBase64(scanner.nextLine()) + SignatureUtils.DELIMITER);
                    } catch (Exception unused) {
                        if (scanner != null) {
                            scanner.close();
                        }
                        return null;
                    } catch (Throwable th) {
                        th = th;
                        scanner2 = scanner;
                        if (scanner2 != null) {
                            scanner2.close();
                        }
                        throw th;
                    }
                }
                scanner.close();
                return sb.toString();
            } catch (Exception unused2) {
                scanner = null;
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    public ArrayList<String> readAndSplit() {
        Scanner scanner;
        ArrayList<String> arrayList = new ArrayList<>();
        synchronized (getFileLock(this)) {
            Scanner scanner2 = null;
            try {
                scanner = new Scanner(this);
                while (scanner.hasNextLine()) {
                    try {
                        arrayList.add(Coder.decodeBase64(scanner.nextLine()));
                    } catch (Exception unused) {
                        if (scanner != null) {
                            scanner.close();
                        }
                        return null;
                    } catch (Throwable th) {
                        th = th;
                        scanner2 = scanner;
                        if (scanner2 != null) {
                            scanner2.close();
                        }
                        throw th;
                    }
                }
                scanner.close();
                if (arrayList.isEmpty()) {
                    arrayList = null;
                }
                return arrayList;
            } catch (Exception unused2) {
                scanner = null;
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    public byte[] readBytes() {
        BufferedInputStream bufferedInputStream;
        Throwable th;
        synchronized (getFileLock(this)) {
            try {
                bufferedInputStream = new BufferedInputStream(new FileInputStream(this));
            } catch (Exception unused) {
                bufferedInputStream = null;
            } catch (Throwable th2) {
                bufferedInputStream = null;
                th = th2;
            }
            try {
                byte[] bArr = new byte[(int) super.length()];
                bufferedInputStream.read(bArr);
                try {
                    bufferedInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return bArr;
            } catch (Exception unused2) {
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
                return null;
            } catch (Throwable th3) {
                th = th3;
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                }
                throw th;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0051 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x005e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0059 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.io.Serializable readObject() {
        /*
            r7 = this;
            java.lang.Object r0 = getFileLock(r7)
            monitor-enter(r0)
            r1 = 0
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L37 java.lang.Exception -> L4c
            r2.<init>(r7)     // Catch: java.lang.Throwable -> L37 java.lang.Exception -> L4c
            java.io.InputStream r3 = com.mibi.sdk.common.Coder.decodeBase64Stream(r2)     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L35
            java.io.ObjectInputStream r4 = new java.io.ObjectInputStream     // Catch: java.lang.Throwable -> L29 java.lang.Exception -> L2e
            r4.<init>(r3)     // Catch: java.lang.Throwable -> L29 java.lang.Exception -> L2e
            java.lang.Object r5 = r4.readObject()     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L4f
            java.io.Serializable r5 = (java.io.Serializable) r5     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L4f
            r4.close()     // Catch: java.io.IOException -> L1d java.lang.Throwable -> L55
        L1d:
            if (r3 == 0) goto L22
            r3.close()     // Catch: java.io.IOException -> L22 java.lang.Throwable -> L55
        L22:
            r2.close()     // Catch: java.io.IOException -> L25 java.lang.Throwable -> L55
        L25:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L55
            return r5
        L27:
            r1 = move-exception
            goto L3c
        L29:
            r4 = move-exception
            r6 = r4
            r4 = r1
            r1 = r6
            goto L3c
        L2e:
            r4 = r1
            goto L4f
        L30:
            r3 = move-exception
            r4 = r1
            r1 = r3
            r3 = r4
            goto L3c
        L35:
            r3 = r1
            goto L4e
        L37:
            r2 = move-exception
            r3 = r1
            r4 = r3
            r1 = r2
            r2 = r4
        L3c:
            if (r4 == 0) goto L41
            r4.close()     // Catch: java.io.IOException -> L41 java.lang.Throwable -> L55
        L41:
            if (r3 == 0) goto L46
            r3.close()     // Catch: java.io.IOException -> L46 java.lang.Throwable -> L55
        L46:
            if (r2 == 0) goto L4b
            r2.close()     // Catch: java.io.IOException -> L4b java.lang.Throwable -> L55
        L4b:
            throw r1     // Catch: java.lang.Throwable -> L55
        L4c:
            r2 = r1
            r3 = r2
        L4e:
            r4 = r3
        L4f:
            if (r4 == 0) goto L57
            r4.close()     // Catch: java.lang.Throwable -> L55 java.io.IOException -> L57
            goto L57
        L55:
            r1 = move-exception
            goto L63
        L57:
            if (r3 == 0) goto L5c
            r3.close()     // Catch: java.lang.Throwable -> L55 java.io.IOException -> L5c
        L5c:
            if (r2 == 0) goto L61
            r2.close()     // Catch: java.lang.Throwable -> L55 java.io.IOException -> L61
        L61:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L55
            return r1
        L63:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L55
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mibi.sdk.common.storage.StorageFile.readObject():java.io.Serializable");
    }

    public void write(String str) {
        PrintWriter printWriter;
        synchronized (getFileLock(this)) {
            PrintWriter printWriter2 = null;
            try {
                printWriter = new PrintWriter(this);
            } catch (Exception unused) {
            } catch (Throwable th) {
                th = th;
            }
            try {
                printWriter.println(Coder.encodeBase64(str));
                printWriter.flush();
                printWriter.close();
            } catch (Exception unused2) {
                printWriter2 = printWriter;
                if (printWriter2 != null) {
                    printWriter2.close();
                }
            } catch (Throwable th2) {
                th = th2;
                printWriter2 = printWriter;
                if (printWriter2 != null) {
                    printWriter2.close();
                }
                throw th;
            }
        }
    }

    public void writeBytes(byte[] bArr) {
        BufferedOutputStream bufferedOutputStream;
        synchronized (getFileLock(this)) {
            if (bArr == null) {
                super.delete();
                return;
            }
            BufferedOutputStream bufferedOutputStream2 = null;
            try {
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(this));
            } catch (Exception unused) {
            } catch (Throwable th) {
                th = th;
            }
            try {
                bufferedOutputStream.write(bArr);
                bufferedOutputStream.flush();
                try {
                    bufferedOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (Exception unused2) {
                bufferedOutputStream2 = bufferedOutputStream;
                if (bufferedOutputStream2 != null) {
                    try {
                        bufferedOutputStream2.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                bufferedOutputStream2 = bufferedOutputStream;
                if (bufferedOutputStream2 != null) {
                    try {
                        bufferedOutputStream2.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                }
                throw th;
            }
        }
    }

    public void writeObject(Serializable serializable) {
        FileOutputStream fileOutputStream;
        OutputStream outputStreamEncodeBase64Stream;
        ObjectOutputStream objectOutputStream;
        synchronized (getFileLock(this)) {
            ObjectOutputStream objectOutputStream2 = null;
            try {
                fileOutputStream = new FileOutputStream(this);
                try {
                    outputStreamEncodeBase64Stream = Coder.encodeBase64Stream(fileOutputStream);
                    try {
                        objectOutputStream = new ObjectOutputStream(outputStreamEncodeBase64Stream);
                    } catch (Exception unused) {
                    } catch (Throwable th) {
                        th = th;
                    }
                    try {
                        objectOutputStream.writeObject(serializable);
                        try {
                            objectOutputStream.close();
                        } catch (IOException unused2) {
                        }
                        if (outputStreamEncodeBase64Stream != null) {
                            try {
                                outputStreamEncodeBase64Stream.close();
                            } catch (IOException unused3) {
                            }
                        }
                        try {
                            fileOutputStream.close();
                        } catch (IOException unused4) {
                        }
                    } catch (Exception unused5) {
                        objectOutputStream2 = objectOutputStream;
                        if (objectOutputStream2 != null) {
                            try {
                                objectOutputStream2.close();
                            } catch (IOException unused6) {
                            }
                        }
                        if (outputStreamEncodeBase64Stream != null) {
                            try {
                                outputStreamEncodeBase64Stream.close();
                            } catch (IOException unused7) {
                            }
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException unused8) {
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        objectOutputStream2 = objectOutputStream;
                        if (objectOutputStream2 != null) {
                            try {
                                objectOutputStream2.close();
                            } catch (IOException unused9) {
                            }
                        }
                        if (outputStreamEncodeBase64Stream != null) {
                            try {
                                outputStreamEncodeBase64Stream.close();
                            } catch (IOException unused10) {
                            }
                        }
                        if (fileOutputStream == null) {
                            throw th;
                        }
                        try {
                            fileOutputStream.close();
                            throw th;
                        } catch (IOException unused11) {
                            throw th;
                        }
                    }
                } catch (Exception unused12) {
                    outputStreamEncodeBase64Stream = null;
                } catch (Throwable th3) {
                    th = th3;
                    outputStreamEncodeBase64Stream = null;
                }
            } catch (Exception unused13) {
                fileOutputStream = null;
                outputStreamEncodeBase64Stream = null;
            } catch (Throwable th4) {
                th = th4;
                fileOutputStream = null;
                outputStreamEncodeBase64Stream = null;
            }
        }
    }

    public StorageFile(String str, String str2) {
        super(str, str2);
    }

    public StorageFile(String str) {
        super(str);
    }
}
