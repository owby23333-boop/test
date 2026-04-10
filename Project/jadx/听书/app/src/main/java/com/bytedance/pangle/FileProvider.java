package com.bytedance.pangle;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.content.res.XmlResourceParser;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.bytedance.pangle.plugin.Plugin;
import com.bytedance.pangle.transform.ZeusTransformUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
public class FileProvider extends ContentProvider {
    private static z dl;
    private static final String[] z = {"_display_name", "_size"};
    private static final File g = new File("/");

    interface z {
        Uri z(File file);

        File z(Uri uri);
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    @Override // android.content.ContentProvider
    public void attachInfo(Context context, ProviderInfo providerInfo) {
        super.attachInfo(context, providerInfo);
        if (providerInfo.exported) {
            throw new SecurityException("Provider must not be exported");
        }
        if (!providerInfo.grantUriPermissions) {
            throw new SecurityException("Provider must grant uri permissions");
        }
        if (dl != null) {
            throw new SecurityException("仅允许定义一个FileProvider");
        }
        dl = new g(providerInfo.authority);
    }

    public static Uri getUriForFile(File file) {
        return dl.z(file);
    }

    public static void z(Plugin plugin, XmlResourceParser xmlResourceParser) {
        try {
            z(plugin.mPkgName, ZeusTransformUtils.wrapperContext(Zeus.getAppApplication(), plugin.mPkgName), (g) dl, xmlResourceParser);
        } catch (IOException | XmlPullParserException e) {
            com.bytedance.sdk.openadsdk.api.m.z(e);
        }
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        int i;
        File fileZ = dl.z(uri);
        if (strArr == null) {
            strArr = z;
        }
        String[] strArr3 = new String[strArr.length];
        Object[] objArr = new Object[strArr.length];
        int i2 = 0;
        for (String str3 : strArr) {
            if ("_display_name".equals(str3)) {
                strArr3[i2] = "_display_name";
                i = i2 + 1;
                objArr[i2] = fileZ.getName();
            } else if ("_size".equals(str3)) {
                strArr3[i2] = "_size";
                i = i2 + 1;
                objArr[i2] = Long.valueOf(fileZ.length());
            }
            i2 = i;
        }
        String[] strArrZ = z(strArr3, i2);
        Object[] objArrZ = z(objArr, i2);
        MatrixCursor matrixCursor = new MatrixCursor(strArrZ, 1);
        matrixCursor.addRow(objArrZ);
        return matrixCursor;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        File fileZ = dl.z(uri);
        int iLastIndexOf = fileZ.getName().lastIndexOf(46);
        if (iLastIndexOf < 0) {
            return "application/octet-stream";
        }
        String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileZ.getName().substring(iLastIndexOf + 1));
        return mimeTypeFromExtension != null ? mimeTypeFromExtension : "application/octet-stream";
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        throw new UnsupportedOperationException("No external inserts");
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        throw new UnsupportedOperationException("No external updates");
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        return dl.z(uri).delete() ? 1 : 0;
    }

    @Override // android.content.ContentProvider
    public ParcelFileDescriptor openFile(Uri uri, String str) throws FileNotFoundException {
        return ParcelFileDescriptor.open(dl.z(uri), z(str));
    }

    private static void z(String str, Context context, g gVar, XmlResourceParser xmlResourceParser) throws XmlPullParserException, IOException {
        while (true) {
            int next = xmlResourceParser.next();
            if (next == 1) {
                return;
            }
            if (next == 2) {
                String name = xmlResourceParser.getName();
                File cacheDir = null;
                String attributeValue = xmlResourceParser.getAttributeValue(null, "name");
                String attributeValue2 = xmlResourceParser.getAttributeValue(null, "path");
                if ("root-path".equals(name)) {
                    cacheDir = g;
                } else if ("files-path".equals(name)) {
                    cacheDir = context.getFilesDir();
                } else if ("cache-path".equals(name)) {
                    cacheDir = context.getCacheDir();
                } else if ("external-files-path".equals(name)) {
                    File[] fileArrZ = z(context, (String) null);
                    if (fileArrZ.length > 0) {
                        cacheDir = fileArrZ[0];
                    }
                } else if ("external-cache-path".equals(name)) {
                    File[] fileArrZ2 = z(context);
                    if (fileArrZ2.length > 0) {
                        cacheDir = fileArrZ2[0];
                    }
                } else if ("external-media-path".equals(name)) {
                    File[] externalMediaDirs = context.getExternalMediaDirs();
                    if (externalMediaDirs.length > 0) {
                        cacheDir = externalMediaDirs[0];
                    }
                }
                if (cacheDir != null) {
                    gVar.z(str + "_" + attributeValue, z(cacheDir, attributeValue2));
                }
            }
        }
    }

    public static File[] z(Context context, String str) {
        return context.getExternalFilesDirs(str);
    }

    public static File[] z(Context context) {
        return context.getExternalCacheDirs();
    }

    static class g implements z {
        private final HashMap<String, File> g = new HashMap<>();
        private final String z;

        g(String str) {
            this.z = str;
        }

        void z(String str, File file) {
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("Name must not be empty");
            }
            try {
                this.g.put(str, file.getCanonicalFile());
            } catch (IOException e) {
                throw new IllegalArgumentException("Failed to resolve canonical path for ".concat(String.valueOf(file)), e);
            }
        }

        @Override // com.bytedance.pangle.FileProvider.z
        public Uri z(File file) {
            String strSubstring;
            try {
                String canonicalPath = file.getCanonicalPath();
                Map.Entry<String, File> entry = null;
                for (Map.Entry<String, File> entry2 : this.g.entrySet()) {
                    String path = entry2.getValue().getPath();
                    if (canonicalPath.startsWith(path) && (entry == null || path.length() > entry.getValue().getPath().length())) {
                        entry = entry2;
                    }
                }
                if (entry == null) {
                    throw new IllegalArgumentException("Failed to find configured root that contains ".concat(String.valueOf(canonicalPath)));
                }
                String path2 = entry.getValue().getPath();
                if (path2.endsWith("/")) {
                    strSubstring = canonicalPath.substring(path2.length());
                } else {
                    strSubstring = canonicalPath.substring(path2.length() + 1);
                }
                return new Uri.Builder().scheme("content").authority(this.z).encodedPath(Uri.encode(entry.getKey()) + '/' + Uri.encode(strSubstring, "/")).build();
            } catch (IOException unused) {
                throw new IllegalArgumentException("Failed to resolve canonical path for ".concat(String.valueOf(file)));
            }
        }

        @Override // com.bytedance.pangle.FileProvider.z
        public File z(Uri uri) {
            String encodedPath = uri.getEncodedPath();
            int iIndexOf = encodedPath.indexOf(47, 1);
            String strDecode = Uri.decode(encodedPath.substring(1, iIndexOf));
            String strDecode2 = Uri.decode(encodedPath.substring(iIndexOf + 1));
            File file = this.g.get(strDecode);
            if (file == null) {
                throw new IllegalArgumentException("Unable to find configured root for ".concat(String.valueOf(uri)));
            }
            File file2 = new File(file, strDecode2);
            try {
                File canonicalFile = file2.getCanonicalFile();
                if (canonicalFile.getPath().startsWith(file.getPath())) {
                    return canonicalFile;
                }
                throw new SecurityException("Resolved path jumped beyond configured root");
            } catch (IOException unused) {
                throw new IllegalArgumentException("Failed to resolve canonical path for ".concat(String.valueOf(file2)));
            }
        }
    }

    private static int z(String str) {
        if ("r".equals(str)) {
            return 268435456;
        }
        if ("w".equals(str) || "wt".equals(str)) {
            return 738197504;
        }
        if ("wa".equals(str)) {
            return 704643072;
        }
        if ("rw".equals(str)) {
            return 939524096;
        }
        if ("rwt".equals(str)) {
            return 1006632960;
        }
        throw new IllegalArgumentException("Invalid mode: ".concat(String.valueOf(str)));
    }

    private static File z(File file, String... strArr) {
        for (String str : strArr) {
            if (str != null) {
                file = new File(file, str);
            }
        }
        return file;
    }

    private static String[] z(String[] strArr, int i) {
        String[] strArr2 = new String[i];
        System.arraycopy(strArr, 0, strArr2, 0, i);
        return strArr2;
    }

    private static Object[] z(Object[] objArr, int i) {
        Object[] objArr2 = new Object[i];
        System.arraycopy(objArr, 0, objArr2, 0, i);
        return objArr2;
    }
}
