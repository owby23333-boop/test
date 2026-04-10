package cn.kuaipan.android.kss.upload;

import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.util.Log;
import cn.kuaipan.android.exception.ErrorCode;
import cn.kuaipan.android.exception.KscException;
import cn.kuaipan.android.exception.KscRuntimeException;
import cn.kuaipan.android.kss.KssDef;
import cn.kuaipan.android.utils.Encode;
import com.yuewen.yg3;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class UploadFileInfo implements KssDef {
    private static final String LOG_TAG = "UploadFileInfo";
    private final ArrayList<BlockInfo> mBlockInfos = new ArrayList<>();
    private String mSha1;

    public static class BlockInfo {
        public final String md5;
        public final String sha1;
        public final int size;

        private BlockInfo(String str, String str2, int i) {
            this.sha1 = str;
            this.md5 = str2;
            this.size = i;
        }
    }

    private UploadFileInfo() {
    }

    private JSONArray getBlockInfos() {
        try {
            JSONArray jSONArray = new JSONArray();
            for (BlockInfo blockInfo : this.mBlockInfos) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("sha1", blockInfo.sha1);
                jSONObject.put("md5", blockInfo.md5);
                jSONObject.put("size", blockInfo.size);
                jSONArray.put(jSONObject);
            }
            return jSONArray;
        } catch (Throwable unused) {
            Log.w(LOG_TAG, "Failed generate Json String for UploadRequestInfo");
            return null;
        }
    }

    public static UploadFileInfo getFileInfo(File file) throws Throwable {
        FileInputStream fileInputStream;
        String str;
        FileInputStream fileInputStream2;
        FileInputStream fileInputStream3;
        try {
            try {
                try {
                    fileInputStream2 = new FileInputStream(file);
                    try {
                        UploadFileInfo uploadFileInfo = new UploadFileInfo();
                        MessageDigest messageDigest = MessageDigest.getInstance(yg3.b.f20351b);
                        MessageDigest messageDigest2 = MessageDigest.getInstance(yg3.b.f20351b);
                        MessageDigest messageDigest3 = MessageDigest.getInstance("MD5");
                        byte[] bArr = new byte[8192];
                        int i = 1;
                        long j = 0;
                        while (true) {
                            int i2 = fileInputStream2.read(bArr);
                            fileInputStream3 = fileInputStream2;
                            if (i2 < 0) {
                                break;
                            }
                            j += (long) i2;
                            try {
                                messageDigest.update(bArr, 0, i2);
                                long j2 = i * 4194304;
                                if (j < j2) {
                                    messageDigest2.update(bArr, 0, i2);
                                    messageDigest3.update(bArr, 0, i2);
                                    fileInputStream2 = fileInputStream3;
                                } else {
                                    int i3 = i2 - ((int) (j - j2));
                                    int i4 = i + 1;
                                    messageDigest2.update(bArr, 0, i3);
                                    messageDigest3.update(bArr, 0, i3);
                                    uploadFileInfo.appendBlock(Encode.byteArrayToHexString(messageDigest2.digest()), Encode.byteArrayToHexString(messageDigest3.digest()), PlaybackStateCompat.ACTION_SET_PLAYBACK_SPEED);
                                    if (i2 > i3) {
                                        int i5 = i2 - i3;
                                        messageDigest2.update(bArr, i3, i5);
                                        messageDigest3.update(bArr, i3, i5);
                                    }
                                    fileInputStream2 = fileInputStream3;
                                    i = i4;
                                }
                            } catch (IOException e) {
                                e = e;
                                fileInputStream2 = fileInputStream3;
                                str = null;
                                try {
                                    throw KscException.newException(e, str);
                                } catch (Throwable th) {
                                    th = th;
                                    fileInputStream = fileInputStream2;
                                    try {
                                        fileInputStream.close();
                                    } catch (Throwable unused) {
                                    }
                                    throw th;
                                }
                            } catch (NoSuchAlgorithmException e2) {
                                e = e2;
                                fileInputStream = fileInputStream3;
                                try {
                                    throw new KscRuntimeException(ErrorCode.FRAMEWORK_UNSUPPORT, e);
                                } catch (Throwable th2) {
                                    th = th2;
                                    fileInputStream.close();
                                    throw th;
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                fileInputStream = fileInputStream3;
                                fileInputStream.close();
                                throw th;
                            }
                        }
                        long j3 = i * 4194304;
                        if (j3 > j && j3 < PlaybackStateCompat.ACTION_SET_PLAYBACK_SPEED + j) {
                            uploadFileInfo.appendBlock(Encode.byteArrayToHexString(messageDigest2.digest()), Encode.byteArrayToHexString(messageDigest3.digest()), j - ((long) ((i - 1) * 4194304)));
                        } else if (j == 0) {
                            throw new KscRuntimeException(ErrorCode.INVALID_PARAM, file + " read error.");
                        }
                        uploadFileInfo.setSha1(Encode.byteArrayToHexString(messageDigest.digest()));
                        try {
                            fileInputStream3.close();
                        } catch (Throwable unused2) {
                        }
                        return uploadFileInfo;
                    } catch (IOException e3) {
                        e = e3;
                    } catch (NoSuchAlgorithmException e4) {
                        e = e4;
                        fileInputStream3 = fileInputStream2;
                    } catch (Throwable th4) {
                        th = th4;
                        fileInputStream3 = fileInputStream2;
                    }
                } catch (NoSuchAlgorithmException e5) {
                    e = e5;
                    fileInputStream = null;
                }
            } catch (IOException e6) {
                e = e6;
                str = null;
                fileInputStream2 = null;
            } catch (Throwable th5) {
                th = th5;
                fileInputStream = null;
            }
        } catch (NoSuchAlgorithmException e7) {
            e = e7;
            fileInputStream = null;
        }
    }

    public void appendBlock(String str, String str2, long j) {
        this.mBlockInfos.add(new BlockInfo(str, str2, (int) j));
    }

    public BlockInfo getBlockInfo(int i) {
        if (i >= this.mBlockInfos.size()) {
            return null;
        }
        return this.mBlockInfos.get(i);
    }

    public String getKssString() {
        JSONArray blockInfos = getBlockInfos();
        if (blockInfos == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("block_infos", blockInfos);
            return jSONObject.toString();
        } catch (Throwable unused) {
            return String.valueOf(jSONObject);
        }
    }

    public String getSha1() {
        return this.mSha1;
    }

    public void setSha1(String str) {
        this.mSha1 = str;
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("block_infos", getBlockInfos());
            jSONObject.put("sha1", this.mSha1);
        } catch (Throwable unused) {
        }
        return String.valueOf(jSONObject);
    }

    public UploadFileInfo(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.mSha1 = jSONObject.optString("sha1");
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("block_infos");
            if (jSONArrayOptJSONArray == null) {
                return;
            }
            int length = jSONArrayOptJSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                String strOptString = null;
                String strOptString2 = jSONObjectOptJSONObject == null ? null : jSONObjectOptJSONObject.optString("sha1");
                if (jSONObjectOptJSONObject != null) {
                    strOptString = jSONObjectOptJSONObject.optString("md5");
                }
                int iOptInt = -1;
                if (jSONObjectOptJSONObject != null) {
                    iOptInt = jSONObjectOptJSONObject.optInt("size", -1);
                }
                if (!TextUtils.isEmpty(strOptString2) && !TextUtils.isEmpty(strOptString) && iOptInt >= 0) {
                    appendBlock(strOptString2, strOptString, iOptInt);
                }
            }
        } catch (JSONException e) {
            Log.w(LOG_TAG, "Failed parser UploadFileInfo from a String. The String:" + str, e);
        }
    }
}
