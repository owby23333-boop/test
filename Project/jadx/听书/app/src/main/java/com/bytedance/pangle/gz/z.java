package com.bytedance.pangle.gz;

import android.content.pm.Signature;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.security.cert.Certificate;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.concurrent.atomic.AtomicReference;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/* JADX INFO: loaded from: classes2.dex */
public class z {
    private static final AtomicReference<byte[]> z = new AtomicReference<>();

    public static pf z(String str, boolean z2) throws Throwable {
        JarFile jarFile = null;
        try {
            try {
                JarFile jarFile2 = new JarFile(str);
                try {
                    ArrayList<JarEntry> arrayList = new ArrayList();
                    JarEntry jarEntry = jarFile2.getJarEntry("AndroidManifest.xml");
                    if (jarEntry == null) {
                        throw new p(1, "Package " + str + " has no manifest");
                    }
                    Certificate[][] certificateArrZ = z(jarFile2, jarEntry);
                    if (com.bytedance.pangle.util.a.z(certificateArrZ)) {
                        throw new p(4, "Package " + str + " has no certificates at entry AndroidManifest.xml");
                    }
                    Signature[] signatureArrZ = a.z(certificateArrZ);
                    if (z2) {
                        Enumeration<JarEntry> enumerationEntries = jarFile2.entries();
                        while (enumerationEntries.hasMoreElements()) {
                            JarEntry jarEntryNextElement = enumerationEntries.nextElement();
                            if (!jarEntryNextElement.isDirectory()) {
                                String name = jarEntryNextElement.getName();
                                if (!name.startsWith("META-INF/") && !name.equals("AndroidManifest.xml")) {
                                    arrayList.add(jarEntryNextElement);
                                }
                            }
                        }
                        for (JarEntry jarEntry2 : arrayList) {
                            Certificate[][] certificateArrZ2 = z(jarFile2, jarEntry2);
                            if (com.bytedance.pangle.util.a.z(certificateArrZ2)) {
                                throw new p(4, "Package " + str + " has no certificates at entry " + jarEntry2.getName());
                            }
                            if (!pf.z(signatureArrZ, a.z(certificateArrZ2))) {
                                throw new p(3, "Package " + str + " has mismatched certificates at entry " + jarEntry2.getName());
                            }
                        }
                    }
                    pf pfVar = new pf(signatureArrZ, 1, null, null, null);
                    try {
                        jarFile2.close();
                    } catch (Exception unused) {
                    }
                    return pfVar;
                } catch (IOException e) {
                    e = e;
                    throw new p(4, "Failed to collect certificates from ".concat(String.valueOf(str)), e);
                } catch (RuntimeException e2) {
                    e = e2;
                    throw new p(4, "Failed to collect certificates from ".concat(String.valueOf(str)), e);
                } catch (GeneralSecurityException e3) {
                    e = e3;
                    throw new p(2, "Failed to collect certificates from ".concat(String.valueOf(str)), e);
                } catch (Throwable th) {
                    th = th;
                    jarFile = jarFile2;
                    if (jarFile != null) {
                        try {
                            jarFile.close();
                        } catch (Exception unused2) {
                        }
                    }
                    throw th;
                }
            } catch (IOException e4) {
                e = e4;
            } catch (RuntimeException e5) {
                e = e5;
            } catch (GeneralSecurityException e6) {
                e = e6;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static Certificate[][] z(JarFile jarFile, JarEntry jarEntry) throws p {
        InputStream inputStream = null;
        try {
            try {
                InputStream inputStream2 = jarFile.getInputStream(jarEntry);
                z(inputStream2);
                Certificate[][] certificateArr = {jarEntry.getCertificates()};
                if (inputStream2 != null) {
                    try {
                        inputStream2.close();
                    } catch (RuntimeException e) {
                        throw e;
                    } catch (Exception unused) {
                    }
                }
                return certificateArr;
            } catch (IOException | RuntimeException e2) {
                throw new p(5, "Failed reading " + jarEntry.getName() + " in " + jarFile, e2);
            }
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    inputStream.close();
                } catch (RuntimeException e3) {
                    throw e3;
                } catch (Exception unused2) {
                }
            }
            throw th;
        }
    }

    private static void z(InputStream inputStream) throws IOException {
        byte[] andSet = z.getAndSet(null);
        if (andSet == null) {
            andSet = new byte[4096];
        }
        while (inputStream.read(andSet, 0, andSet.length) != -1) {
        }
        z.set(andSet);
    }
}
