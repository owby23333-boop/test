package cn.bmob.v3.util;

import android.text.TextUtils;
import cn.bmob.v3.Bmob;
import cn.bmob.v3.encry.digest.DigestUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;
import org.json.JSONTokener;

/* JADX INFO: loaded from: classes.dex */
public class CacheHelper {
    static int maxKeyValueCacheBytes = 2097152;
    static int maxKeyValueCacheFiles = 1000;

    static void addToStringer(JSONStringer jSONStringer, Object obj) throws JSONException {
        if (!(obj instanceof JSONObject)) {
            if (!(obj instanceof JSONArray)) {
                jSONStringer.value(obj);
                return;
            }
            JSONArray jSONArray = (JSONArray) obj;
            jSONStringer.array();
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                addToStringer(jSONStringer, jSONArray.get(i2));
            }
            jSONStringer.endArray();
            return;
        }
        jSONStringer.object();
        JSONObject jSONObject = (JSONObject) obj;
        Iterator<String> itKeys = jSONObject.keys();
        ArrayList<String> arrayList = new ArrayList();
        while (itKeys.hasNext()) {
            arrayList.add(itKeys.next());
        }
        Collections.sort(arrayList);
        for (String str : arrayList) {
            jSONStringer.key(str);
            addToStringer(jSONStringer, jSONObject.opt(str));
        }
        jSONStringer.endObject();
    }

    public static void clearCacheDir() {
        File[] fileArrListFiles = getKeyValueCacheDir().listFiles();
        if (fileArrListFiles == null) {
            return;
        }
        for (File file : fileArrListFiles) {
            file.delete();
        }
    }

    public static void clearFromKeyValueCache(String str) {
        File keyValueCacheFile = getKeyValueCacheFile(str);
        if (keyValueCacheFile == null || !keyValueCacheFile.exists()) {
            return;
        }
        keyValueCacheFile.delete();
    }

    static File createKeyValueCacheFile(String str) {
        return new File(getKeyValueCacheDir(), String.valueOf(new Date().getTime()) + '.' + str);
    }

    public static String getCacheKey(JSONObject jSONObject) {
        try {
            if (jSONObject.has("timestamp")) {
                jSONObject.remove("timestamp");
            }
            if (jSONObject.has(BmobDbOpenHelper.SESSION_TOKEN)) {
                jSONObject.remove(BmobDbOpenHelper.SESSION_TOKEN);
            }
            jSONObject.remove("client");
            jSONObject.remove("v");
            jSONObject.remove("appSign");
            String deterministicString = toDeterministicString(jSONObject);
            String sessionToken = BmobContentProvider.getSessionToken();
            if (!TextUtils.isEmpty(sessionToken)) {
                deterministicString = deterministicString + sessionToken;
            }
            return "RequestCommand.find.3." + DigestUtils.md5Hex(deterministicString);
        } catch (JSONException e2) {
            throw new RuntimeException(e2.getMessage());
        }
    }

    static long getKeyValueCacheAge(File file) {
        String name = file.getName();
        try {
            return Long.parseLong(name.substring(0, name.indexOf(46)));
        } catch (NumberFormatException unused) {
            return 0L;
        }
    }

    static synchronized File getKeyValueCacheDir() {
        File cacheDir;
        cacheDir = Bmob.getCacheDir("BmobKeyValueCache");
        if (!cacheDir.isDirectory() && !cacheDir.mkdir()) {
            throw new RuntimeException("could not create Bmob cache directory");
        }
        return cacheDir;
    }

    static File getKeyValueCacheFile(String str) {
        final String str2 = '.' + str;
        File[] fileArrListFiles = getKeyValueCacheDir().listFiles(new FilenameFilter() { // from class: cn.bmob.v3.util.CacheHelper.2
            @Override // java.io.FilenameFilter
            public boolean accept(File file, String str3) {
                return str3.endsWith(str2);
            }
        });
        if (fileArrListFiles.length == 0) {
            return null;
        }
        return fileArrListFiles[0];
    }

    public static Object jsonFromKeyValueCache(String str, long j2) throws Throwable {
        String strLoadFromKeyValueCache = loadFromKeyValueCache(str, j2);
        if (strLoadFromKeyValueCache == null) {
            return null;
        }
        try {
            return new JSONTokener(ZipUtil.uncompress(strLoadFromKeyValueCache)).nextValue();
        } catch (JSONException unused) {
            clearFromKeyValueCache(str);
            return null;
        }
    }

    public static String loadFromKeyValueCache(String str, long j2) throws Throwable {
        RandomAccessFile randomAccessFile;
        File keyValueCacheFile = getKeyValueCacheFile(str);
        if (keyValueCacheFile == null) {
            return null;
        }
        Date date = new Date();
        if (getKeyValueCacheAge(keyValueCacheFile) < Math.max(0L, date.getTime() - j2)) {
            return null;
        }
        keyValueCacheFile.setLastModified(date.getTime());
        try {
            randomAccessFile = new RandomAccessFile(keyValueCacheFile, "r");
        } catch (IOException e2) {
            e = e2;
            randomAccessFile = null;
        } catch (Throwable th) {
            th = th;
            randomAccessFile = null;
            IOUtils.closeQuietly(randomAccessFile);
            throw th;
        }
        try {
            try {
                byte[] bArr = new byte[(int) randomAccessFile.length()];
                randomAccessFile.readFully(bArr);
                randomAccessFile.close();
                String str2 = new String(bArr, "UTF-8");
                IOUtils.closeQuietly(randomAccessFile);
                return str2;
            } catch (Throwable th2) {
                th = th2;
                IOUtils.closeQuietly(randomAccessFile);
                throw th;
            }
        } catch (IOException e3) {
            e = e3;
            e.printStackTrace();
            IOUtils.closeQuietly(randomAccessFile);
            return null;
        }
    }

    public static void saveToKeyValueCache(String str, String str2) {
        File keyValueCacheFile = getKeyValueCacheFile(str);
        if (keyValueCacheFile != null) {
            keyValueCacheFile.delete();
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(createKeyValueCacheFile(str));
            fileOutputStream.write(str2.getBytes("UTF-8"));
            fileOutputStream.close();
        } catch (UnsupportedEncodingException | IOException unused) {
        }
        File[] fileArrListFiles = getKeyValueCacheDir().listFiles();
        int length = fileArrListFiles.length;
        int length2 = 0;
        for (File file : fileArrListFiles) {
            length2 = (int) (((long) length2) + file.length());
        }
        if (length > maxKeyValueCacheFiles || length2 > maxKeyValueCacheBytes) {
            Arrays.sort(fileArrListFiles, new Comparator<File>() { // from class: cn.bmob.v3.util.CacheHelper.1
                @Override // java.util.Comparator
                public int compare(File file2, File file3) {
                    Long lValueOf = Long.valueOf(file2.lastModified());
                    Long lValueOf2 = Long.valueOf(file3.lastModified());
                    if (lValueOf.longValue() < lValueOf2.longValue()) {
                        return -1;
                    }
                    return lValueOf.longValue() > lValueOf2.longValue() ? 1 : 0;
                }
            });
            for (File file2 : fileArrListFiles) {
                length--;
                length2 = (int) (((long) length2) - file2.length());
                file2.delete();
                if (length <= maxKeyValueCacheFiles && length2 <= maxKeyValueCacheBytes) {
                    return;
                }
            }
        }
    }

    static String toDeterministicString(Object obj) throws JSONException {
        JSONStringer jSONStringer = new JSONStringer();
        addToStringer(jSONStringer, obj);
        return jSONStringer.toString();
    }
}
