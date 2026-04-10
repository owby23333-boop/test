package com.dangdang.zframework.utils;

import com.dangdang.execption.UnZipException;
import com.dangdang.zframework.log.LogM;
import com.yuewen.yh4;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

/* JADX INFO: loaded from: classes10.dex */
public class ZipExecutor {
    private final LogM logger = LogM.getLog(ZipExecutor.class);
    private ExecutorService executorService = Executors.newSingleThreadExecutor();

    private ZipExecutor() {
    }

    public static ZipExecutor getZipE() {
        return new ZipExecutor();
    }

    public void addUnZip(String str, String str2, String str3) {
        this.executorService.submit(new UnZipOperator(str, str2, str3));
    }

    public void clear() {
        this.executorService.shutdownNow();
    }

    public static class UnZipOperator implements Runnable {
        private File destDir;
        private File sourceFile;
        private File ttfFile;

        public UnZipOperator(String str) {
            try {
                File file = new File(str);
                this.destDir = file;
                if (file.exists()) {
                    return;
                }
                this.destDir.mkdirs();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        private void ensureZipPathSafety(File file, File file2) throws Exception {
            String canonicalPath = file2.getCanonicalPath();
            String canonicalPath2 = file.getCanonicalPath();
            if (!canonicalPath2.startsWith(canonicalPath)) {
                throw new Exception(String.format("Found Zip Path Traversal Vulnerability with %s", canonicalPath2));
            }
        }

        private void printLog(String str) {
        }

        public void UnZip(InputStream inputStream) throws Throwable {
            ZipInputStream zipInputStream;
            Throwable th;
            ZipFile zipFile;
            ZipInputStream zipInputStream2;
            Exception e;
            File file;
            InputStream inputStream2 = null;
            try {
                try {
                    try {
                        zipFile = new ZipFile(this.sourceFile);
                    } catch (Exception e2) {
                        zipInputStream2 = null;
                        e = e2;
                        zipFile = null;
                    } catch (Throwable th2) {
                        zipInputStream = null;
                        th = th2;
                        zipFile = null;
                    }
                    try {
                        zipInputStream2 = new ZipInputStream(new FileInputStream(this.sourceFile));
                        FileOutputStream fileOutputStream = null;
                        while (true) {
                            try {
                                ZipEntry nextEntry = zipInputStream2.getNextEntry();
                                if (nextEntry == null) {
                                    printLog("[   End  End  End  unZip <path= " + this.sourceFile.getAbsolutePath() + " >]");
                                    zipInputStream2.close();
                                    zipFile.close();
                                    return;
                                }
                                try {
                                    try {
                                        printLog("[unZip fileName=" + nextEntry.getName() + "]");
                                        if (nextEntry.getName().toLowerCase().endsWith(yh4.Q)) {
                                            file = this.ttfFile;
                                            ensureZipPathSafety(file, file.getParentFile());
                                        } else {
                                            file = new File(this.destDir, nextEntry.getName());
                                            ensureZipPathSafety(file, this.destDir);
                                        }
                                        if (!file.exists()) {
                                            file.createNewFile();
                                        }
                                        inputStream2 = zipFile.getInputStream(nextEntry);
                                        FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                                        try {
                                            byte[] bArr = new byte[10240];
                                            while (true) {
                                                int i = inputStream2.read(bArr);
                                                if (i == -1) {
                                                    break;
                                                } else {
                                                    fileOutputStream2.write(bArr, 0, i);
                                                }
                                            }
                                            inputStream2.close();
                                            fileOutputStream2.close();
                                            fileOutputStream = fileOutputStream2;
                                        } catch (Exception e3) {
                                            e = e3;
                                            fileOutputStream = fileOutputStream2;
                                            e.printStackTrace();
                                            if (inputStream2 != null) {
                                                inputStream2.close();
                                            }
                                            if (fileOutputStream != null) {
                                                fileOutputStream.close();
                                            }
                                        } catch (Throwable th3) {
                                            th = th3;
                                            fileOutputStream = fileOutputStream2;
                                            if (inputStream2 != null) {
                                                inputStream2.close();
                                            }
                                            if (fileOutputStream != null) {
                                                fileOutputStream.close();
                                            }
                                            throw th;
                                        }
                                    } catch (Exception e4) {
                                        e = e4;
                                    }
                                } catch (Throwable th4) {
                                    th = th4;
                                }
                            } catch (Exception e5) {
                                e = e5;
                                e.printStackTrace();
                                if (zipInputStream2 != null) {
                                    zipInputStream2.close();
                                }
                                if (zipFile != null) {
                                    zipFile.close();
                                    return;
                                }
                                return;
                            }
                        }
                    } catch (Exception e6) {
                        zipInputStream2 = null;
                        e = e6;
                    } catch (Throwable th5) {
                        zipInputStream = null;
                        th = th5;
                        if (zipInputStream != null) {
                            try {
                                zipInputStream.close();
                            } catch (Exception e7) {
                                e7.printStackTrace();
                                throw th;
                            }
                        }
                        if (zipFile != null) {
                            zipFile.close();
                        }
                        throw th;
                    }
                } catch (Throwable th6) {
                    th = th6;
                }
            } catch (Exception e8) {
                e8.printStackTrace();
            }
        }

        @Override // java.lang.Runnable
        public void run() throws Throwable {
            try {
                unZip();
            } catch (UnZipException e) {
                e.printStackTrace();
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:73:0x013e A[Catch: Exception -> 0x013a, TRY_LEAVE, TryCatch #9 {Exception -> 0x013a, blocks: (B:69:0x0136, B:73:0x013e), top: B:81:0x0136 }] */
        /* JADX WARN: Removed duplicated region for block: B:81:0x0136 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void unZip() throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 326
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.dangdang.zframework.utils.ZipExecutor.UnZipOperator.unZip():void");
        }

        public void unZipNormal() throws Throwable {
            ZipInputStream zipInputStream;
            Throwable th;
            ZipFile zipFile;
            Exception e;
            InputStream inputStream = null;
            try {
                try {
                    zipFile = new ZipFile(this.sourceFile);
                    try {
                        zipInputStream = new ZipInputStream(new FileInputStream(this.sourceFile));
                        FileOutputStream fileOutputStream = null;
                        while (true) {
                            try {
                                try {
                                    ZipEntry nextEntry = zipInputStream.getNextEntry();
                                    if (nextEntry == null) {
                                        printLog("[   End  End  End  unZip <path= " + this.sourceFile.getAbsolutePath() + " >]");
                                        zipInputStream.close();
                                        zipFile.close();
                                        return;
                                    }
                                    try {
                                        try {
                                            printLog("[unZip fileName=" + nextEntry.getName() + "]");
                                        } catch (Exception e2) {
                                            e = e2;
                                        }
                                        if (nextEntry.isDirectory()) {
                                            new File(this.destDir + File.separator + nextEntry.getName()).mkdirs();
                                            if (inputStream != null) {
                                                inputStream.close();
                                            }
                                            if (fileOutputStream != null) {
                                                fileOutputStream.close();
                                            }
                                        } else {
                                            File file = new File(this.destDir, nextEntry.getName());
                                            ensureZipPathSafety(file, this.destDir);
                                            if (!file.exists()) {
                                                file.createNewFile();
                                            }
                                            inputStream = zipFile.getInputStream(nextEntry);
                                            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                                            try {
                                                byte[] bArr = new byte[10240];
                                                while (true) {
                                                    int i = inputStream.read(bArr);
                                                    if (i == -1) {
                                                        break;
                                                    } else {
                                                        fileOutputStream2.write(bArr, 0, i);
                                                    }
                                                }
                                                inputStream.close();
                                                fileOutputStream2.close();
                                                fileOutputStream = fileOutputStream2;
                                            } catch (Exception e3) {
                                                e = e3;
                                                fileOutputStream = fileOutputStream2;
                                                e.printStackTrace();
                                                if (inputStream != null) {
                                                    inputStream.close();
                                                }
                                                if (fileOutputStream != null) {
                                                    fileOutputStream.close();
                                                }
                                            } catch (Throwable th2) {
                                                th = th2;
                                                fileOutputStream = fileOutputStream2;
                                                if (inputStream != null) {
                                                    inputStream.close();
                                                }
                                                if (fileOutputStream != null) {
                                                    fileOutputStream.close();
                                                }
                                                throw th;
                                            }
                                        }
                                    } catch (Throwable th3) {
                                        th = th3;
                                    }
                                } catch (Throwable th4) {
                                    th = th4;
                                    if (zipInputStream != null) {
                                        try {
                                            zipInputStream.close();
                                        } catch (Exception e4) {
                                            e4.printStackTrace();
                                            throw th;
                                        }
                                    }
                                    if (zipFile != null) {
                                        zipFile.close();
                                    }
                                    throw th;
                                }
                            } catch (Exception e5) {
                                e = e5;
                                e.printStackTrace();
                                if (zipInputStream != null) {
                                    zipInputStream.close();
                                }
                                if (zipFile != null) {
                                    zipFile.close();
                                    return;
                                }
                                return;
                            }
                        }
                    } catch (Exception e6) {
                        zipInputStream = null;
                        e = e6;
                    } catch (Throwable th5) {
                        zipInputStream = null;
                        th = th5;
                    }
                } catch (Exception e7) {
                    zipInputStream = null;
                    e = e7;
                    zipFile = null;
                } catch (Throwable th6) {
                    zipInputStream = null;
                    th = th6;
                    zipFile = null;
                }
            } catch (Exception e8) {
                e8.printStackTrace();
            }
        }

        public UnZipOperator(String str, String str2) {
            try {
                this.sourceFile = new File(str);
                File file = new File(str2);
                this.destDir = file;
                if (file.exists()) {
                    return;
                }
                this.destDir.mkdirs();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public UnZipOperator(String str, String str2, String str3) {
            try {
                this.sourceFile = new File(str);
                File file = new File(str2);
                this.destDir = file;
                if (!file.exists()) {
                    this.destDir.mkdirs();
                }
                File file2 = new File(str3);
                this.ttfFile = file2;
                if (!file2.exists()) {
                    File parentFile = this.ttfFile.getParentFile();
                    if (!parentFile.exists()) {
                        parentFile.mkdirs();
                    }
                } else {
                    this.ttfFile.delete();
                }
                this.ttfFile.createNewFile();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
