package cn.kuaipan.android.kss.download;

import android.os.Bundle;
import android.os.Parcel;
import android.util.Log;
import cn.kuaipan.android.utils.Base64;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/* JADX INFO: loaded from: classes.dex */
public class KInfo {
    private static final String KEY_DATA = "data";
    private static final String KEY_HASH = "hash";
    private static final String KEY_LOAD_MAP = "load_map";
    private static final String LOG_TAG = "KInfo";
    private static final String PREFIX = ".";
    private static final String SUFFIX = ".kinfo";
    private final File mFile;
    private final Bundle mData = new Bundle();
    private final Properties mProp = new Properties();

    public KInfo(File file) {
        this.mFile = file;
    }

    private static String bundleToString(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        Parcel parcelObtain = Parcel.obtain();
        try {
            bundle.writeToParcel(parcelObtain, 0);
            return Base64.encodeToString(parcelObtain.marshall(), 0);
        } finally {
            parcelObtain.recycle();
        }
    }

    public static File getInfoFile(File file) {
        String parent = file.getParent();
        String str = file.getName() + SUFFIX;
        if (!str.startsWith(".")) {
            str = "." + str;
        }
        return new File(parent, str);
    }

    private static Bundle stringToBundle(String str) {
        byte[] bArrDecode = Base64.decode(str, 0);
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.unmarshall(bArrDecode, 0, bArrDecode.length);
            parcelObtain.setDataPosition(0);
            return (Bundle) Bundle.CREATOR.createFromParcel(parcelObtain);
        } finally {
            parcelObtain.recycle();
        }
    }

    public void delete() {
        this.mFile.delete();
    }

    public String getHash() {
        return this.mData.getString("hash");
    }

    public void load() throws Throwable {
        FileInputStream fileInputStream;
        Throwable th;
        IOException e;
        if (this.mFile.exists()) {
            try {
                try {
                    fileInputStream = new FileInputStream(this.mFile);
                } catch (IOException e2) {
                    fileInputStream = null;
                    e = e2;
                } catch (Throwable th2) {
                    fileInputStream = null;
                    th = th2;
                    try {
                        fileInputStream.close();
                    } catch (Throwable unused) {
                    }
                    throw th;
                }
                try {
                    this.mProp.load(fileInputStream);
                    Bundle bundleStringToBundle = stringToBundle(this.mProp.getProperty("data"));
                    this.mData.clear();
                    this.mData.putAll(bundleStringToBundle);
                } catch (IOException e3) {
                    e = e3;
                    Log.w(LOG_TAG, "Failed load kinfo from " + this.mFile, e);
                }
                try {
                    fileInputStream.close();
                } catch (Throwable unused2) {
                }
            } catch (Throwable th3) {
                th = th3;
                fileInputStream.close();
                throw th;
            }
        }
    }

    public boolean loadToMap(LoadMap loadMap) {
        return loadMap.load(this.mData.getBundle(KEY_LOAD_MAP));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v9, types: [java.io.OutputStream] */
    public void save() throws Throwable {
        Throwable th;
        FileOutputStream fileOutputStream;
        IOException e;
        Properties properties = this.mProp;
        ?? BundleToString = bundleToString(this.mData);
        properties.put("data", BundleToString);
        try {
            try {
                fileOutputStream = new FileOutputStream(this.mFile);
            } catch (IOException e2) {
                fileOutputStream = null;
                e = e2;
            } catch (Throwable th2) {
                BundleToString = 0;
                th = th2;
                try {
                    BundleToString.close();
                } catch (Throwable unused) {
                }
                throw th;
            }
            try {
                this.mProp.store(fileOutputStream, (String) null);
                fileOutputStream.flush();
                BundleToString = fileOutputStream;
            } catch (IOException e3) {
                e = e3;
                Log.w(LOG_TAG, "Failed save kinfo to " + this.mFile, e);
                BundleToString = fileOutputStream;
            }
            try {
                BundleToString.close();
            } catch (Throwable unused2) {
            }
        } catch (Throwable th3) {
            th = th3;
            BundleToString.close();
            throw th;
        }
    }

    public void setHash(String str) {
        this.mData.putString("hash", str);
    }

    public void setLoadMap(LoadMap loadMap) {
        Bundle bundle = new Bundle();
        loadMap.save(bundle);
        this.mData.putBundle(KEY_LOAD_MAP, bundle);
    }
}
