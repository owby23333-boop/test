package com.dangdang.reader.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/* JADX INFO: loaded from: classes10.dex */
public class ParserEpubN {
    private ZipUtil mUnZip;
    private final String ENCODING = "UTF-8";
    private String mOpfPath = "";
    private String mNcxPath = "";

    private Document buildDocument(InputStream inputStream) {
        try {
            return DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } catch (ParserConfigurationException e2) {
            e2.printStackTrace();
            return null;
        } catch (SAXException e3) {
            e3.printStackTrace();
            return null;
        }
    }

    private void closeStream(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private ZipEntry getNcxEntry(Enumeration<? extends ZipEntry> enumeration) {
        if (this.mNcxPath == null) {
            return null;
        }
        while (enumeration.hasMoreElements()) {
            ZipEntry zipEntryNextElement = enumeration.nextElement();
            printLog(" getNcxEntry entry = " + zipEntryNextElement);
            if (zipEntryNextElement.getName().toLowerCase().contains(this.mNcxPath.toLowerCase()) || zipEntryNextElement.getName().equalsIgnoreCase(this.mNcxPath)) {
                return zipEntryNextElement;
            }
        }
        return null;
    }

    private ZipEntry getOneEntry(Enumeration<? extends ZipEntry> enumeration, String str) {
        while (enumeration.hasMoreElements()) {
            ZipEntry zipEntryNextElement = enumeration.nextElement();
            printLog(" getOneEntry entry = " + zipEntryNextElement);
            if (zipEntryNextElement.getName().toLowerCase().contains(str.toLowerCase()) || zipEntryNextElement.getName().equalsIgnoreCase(str)) {
                return zipEntryNextElement;
            }
        }
        return null;
    }

    private ZipEntry getOpfEntry(Enumeration<? extends ZipEntry> enumeration) {
        if (this.mOpfPath == null) {
            return null;
        }
        while (enumeration.hasMoreElements()) {
            ZipEntry zipEntryNextElement = enumeration.nextElement();
            printLog(" getOpfEntry entry = " + zipEntryNextElement);
            if (zipEntryNextElement.getName().equalsIgnoreCase(this.mOpfPath) || zipEntryNextElement.getName().toLowerCase().contains(this.mOpfPath.toLowerCase())) {
                return zipEntryNextElement;
            }
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [com.dangdang.reader.utils.ParserEpubN] */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.lang.String] */
    private String parserVersionInner(InputStream inputStream, int i) {
        String str = "";
        try {
            try {
                byte[] bArr = new byte[i];
                if (inputStream.read(bArr) > -1) {
                    str = new String(bArr, "UTF-8");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            closeStream(inputStream);
            inputStream = " [ parseVersion  " + str + " ] ";
            printLog(inputStream);
            return str;
        } catch (Throwable th) {
            closeStream(inputStream);
            throw th;
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0018 -> B:28:0x002d). Please report as a decompilation issue!!! */
    public boolean checkExistOne(String str, String str2) throws Throwable {
        ZipFile zipFile = null;
        try {
            try {
                try {
                    ZipFile zipFile2 = new ZipFile(str);
                    try {
                        z = getOneEntry(zipFile2.entries(), str2) != null;
                        zipFile2.close();
                    } catch (Exception e) {
                        e = e;
                        zipFile = zipFile2;
                        e.printStackTrace();
                        if (zipFile != null) {
                            zipFile.close();
                        }
                        return z;
                    } catch (Throwable th) {
                        th = th;
                        zipFile = zipFile2;
                        if (zipFile != null) {
                            try {
                                zipFile.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (Exception e3) {
                    e = e3;
                }
            } catch (IOException e4) {
                e4.printStackTrace();
            }
            return z;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public void destory() {
        ZipUtil zipUtil = this.mUnZip;
        if (zipUtil != null) {
            zipUtil.finishUnZip();
        }
    }

    public boolean epubExists(String str) {
        return new File(str).exists();
    }

    public String getNcxPath() {
        return this.mNcxPath;
    }

    public String getOpfPath() {
        return this.mOpfPath;
    }

    public String getOpsPath() {
        String str = this.mOpfPath;
        if (str == null || str.trim().length() <= 0) {
            return "";
        }
        String str2 = this.mOpfPath;
        return str2.substring(0, str2.lastIndexOf("/") + 1);
    }

    public boolean hasFileDirectory(String str, String str2) {
        return new File(str2).isDirectory();
    }

    public void parseContainerOpfAndNcx(String str) {
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x003e -> B:33:0x0060). Please report as a decompilation issue!!! */
    public String parseVersion(String str) throws Throwable {
        String str2;
        FileInputStream fileInputStream;
        Exception e;
        File file = new File(str + DangdangFileManager.OLD_ROOT_NAME);
        str2 = "";
        if (file.exists()) {
            FileInputStream fileInputStream2 = null;
            try {
                try {
                    try {
                        fileInputStream = new FileInputStream(file);
                    } catch (Exception e2) {
                        fileInputStream = null;
                        e = e2;
                    } catch (Throwable th) {
                        th = th;
                        if (0 != 0) {
                            try {
                                fileInputStream2.close();
                            } catch (Exception e3) {
                                e3.printStackTrace();
                            }
                        }
                        throw th;
                    }
                    try {
                        byte[] bArr = new byte[fileInputStream.available()];
                        str2 = fileInputStream.read(bArr) > -1 ? new String(bArr, "UTF-8") : "";
                        fileInputStream.close();
                    } catch (Exception e4) {
                        e = e4;
                        e.printStackTrace();
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        printLog(" [ parseVersion  " + str2 + " ] ");
                        return str2;
                    }
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        printLog(" [ parseVersion  " + str2 + " ] ");
        return str2;
    }

    public void printLog(String str) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.io.InputStream, java.util.zip.ZipFile] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9 */
    public String readInnerZipFile(String str, String str2) throws Throwable {
        ZipFile zipFile;
        ZipEntry zipEntryNextElement;
        String str3 = "";
        ?? inputStream = 0;
        inputStream = 0;
        inputStream = 0;
        inputStream = 0;
        inputStream = 0;
        try {
            try {
                try {
                    zipFile = new ZipFile(str);
                } catch (IOException e) {
                    e = e;
                    zipFile = null;
                } catch (IllegalArgumentException e2) {
                    e = e2;
                    zipFile = null;
                } catch (Throwable th) {
                    th = th;
                    if (0 != 0) {
                        try {
                            inputStream.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                            throw th;
                        }
                    }
                    if (0 != 0) {
                        inputStream.close();
                    }
                    throw th;
                }
                try {
                    Enumeration<? extends ZipEntry> enumerationEntries = zipFile.entries();
                    while (true) {
                        if (!enumerationEntries.hasMoreElements()) {
                            zipEntryNextElement = null;
                            break;
                        }
                        zipEntryNextElement = enumerationEntries.nextElement();
                        if (zipEntryNextElement.getName().compareToIgnoreCase(str2) == 0) {
                            break;
                        }
                    }
                    if (zipEntryNextElement != null) {
                        inputStream = zipFile.getInputStream(zipEntryNextElement);
                        byte[] bArr = new byte[(int) zipEntryNextElement.getSize()];
                        if (inputStream.read(bArr) > 0) {
                            str3 = new String(bArr, "UTF-8");
                        }
                    }
                    if (inputStream != 0) {
                        inputStream.close();
                    }
                    zipFile.close();
                } catch (IOException e4) {
                    e = e4;
                    e.printStackTrace();
                    if (inputStream != 0) {
                        inputStream.close();
                    }
                    if (zipFile != null) {
                        zipFile.close();
                    }
                } catch (IllegalArgumentException e5) {
                    e = e5;
                    e.printStackTrace();
                    if (inputStream != 0) {
                        inputStream.close();
                    }
                    if (zipFile != null) {
                        zipFile.close();
                    }
                }
            } catch (IOException e6) {
                e6.printStackTrace();
            }
            return str3;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public void unZipEpub(String str, String str2) throws Throwable {
        printLog(" start unZipEpub ");
        ZipUtil zipUtil = new ZipUtil();
        this.mUnZip = zipUtil;
        zipUtil.unZip(str, str2);
        printLog(" end unZipEpub ");
    }
}
