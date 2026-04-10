package cn.bmob.v3.datatype.up;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.helper.ErrorCode;
import cn.bmob.v3.util.BLog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: loaded from: classes.dex */
public class BlockUploader implements Runnable {
    private String apiKey;
    private int[] blockIndex;
    private String bucket;
    private UploadClient client;
    private UpCompleteListener completeListener;
    private long expiration;
    private File file;
    private Map<String, Object> params;
    private PostData postData;
    private UpProgressListener progressListener;
    private int retryTime;
    private String saveToken;
    private SignatureListener signatureListener;
    private String tokenSecret;
    private int totalBlockNum;
    private String url;
    private String userPolicy;
    private String userSignature;
    private RandomAccessFile randomAccessFile = null;
    private int blockSize = Bmob.getFileBlockSize();

    public BlockUploader(UploadClient uploadClient, File file, Map<String, Object> map, String str, SignatureListener signatureListener, UpCompleteListener upCompleteListener, UpProgressListener upProgressListener) {
        this.client = uploadClient;
        this.file = file;
        this.params = map;
        this.progressListener = upProgressListener;
        this.completeListener = upCompleteListener;
        this.apiKey = str;
        this.signatureListener = signatureListener;
    }

    private void blockUpload(int i2) {
        int i3;
        while (true) {
            if (this.postData == null) {
                this.postData = new PostData();
            }
            try {
                this.postData.data = readBlockByIndex(i2);
            } catch (BmobException e2) {
                this.completeListener.onComplete(false, e2.toString());
            }
            HashMap map = new HashMap();
            map.put(Params.SAVE_TOKEN, this.saveToken);
            map.put(Params.EXPIRATION, Long.valueOf(this.expiration));
            map.put(Params.BLOCK_INDEX, Integer.valueOf(this.blockIndex[i2]));
            map.put(Params.BLOCK_MD5, UpYunUtils.md5(this.postData.data));
            String policy = UpYunUtils.getPolicy(map);
            String signature = UpYunUtils.getSignature(map, this.tokenSecret);
            HashMap map2 = new HashMap();
            map2.put("policy", policy);
            map2.put("signature", signature);
            this.postData.fileName = this.file.getName();
            PostData postData = this.postData;
            postData.params = map2;
            try {
                try {
                    this.client.blockMultipartPost(this.url, postData);
                    if (this.progressListener != null) {
                        this.progressListener.onRequestProgress(i2, this.blockIndex.length);
                    }
                    i3 = i2 + 1;
                    try {
                    } catch (BmobException | IOException e3) {
                        e = e3;
                        i2 = i3;
                        int i4 = this.retryTime + 1;
                        this.retryTime = i4;
                        boolean z2 = i4 > 2;
                        boolean z3 = (e instanceof BmobException) && ((BmobException) e).getErrorCode() / 100 != 5;
                        if (z2 || z3) {
                            this.completeListener.onComplete(false, e.getMessage());
                        } else {
                            this.postData = null;
                        }
                    }
                } catch (BmobException e4) {
                    e = e4;
                } catch (IOException e5) {
                    e = e5;
                }
                if (i2 == this.blockIndex.length - 1) {
                    mergeRequest();
                    break;
                } else {
                    this.postData = null;
                    i2 = i3;
                }
            } finally {
                this.postData = null;
            }
        }
        this.completeListener.onComplete(false, e.getMessage());
    }

    private int[] getBlockIndex(JSONArray jSONArray) throws JSONException {
        int i2 = 0;
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            if (jSONArray.getInt(i3) == 0) {
                i2++;
            }
        }
        int[] iArr = new int[i2];
        int i4 = 0;
        for (int i5 = 0; i5 < jSONArray.length(); i5++) {
            if (jSONArray.getInt(i5) == 0) {
                iArr[i4] = i5;
                i4++;
            }
        }
        return iArr;
    }

    private String getParamsString(Map<String, Object> map) {
        Object[] array = map.keySet().toArray();
        Arrays.sort(array);
        StringBuffer stringBuffer = new StringBuffer();
        for (Object obj : array) {
            stringBuffer.append(obj);
            stringBuffer.append(map.get(obj));
        }
        return stringBuffer.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0076  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void initRequest() {
        /*
            r6 = this;
            java.util.LinkedHashMap r0 = new java.util.LinkedHashMap
            r0.<init>()
            java.lang.String r1 = r6.userPolicy
            java.lang.String r2 = "policy"
            r0.put(r2, r1)
            java.lang.String r1 = r6.userSignature
            java.lang.String r2 = "signature"
            r0.put(r2, r1)
            r1 = 0
            cn.bmob.v3.datatype.up.UploadClient r2 = r6.client     // Catch: org.json.JSONException -> L4b cn.bmob.v3.exception.BmobException -> L56 java.io.IOException -> L58
            java.lang.String r3 = r6.url     // Catch: org.json.JSONException -> L4b cn.bmob.v3.exception.BmobException -> L56 java.io.IOException -> L58
            java.lang.String r0 = r2.post(r3, r0)     // Catch: org.json.JSONException -> L4b cn.bmob.v3.exception.BmobException -> L56 java.io.IOException -> L58
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch: org.json.JSONException -> L4b cn.bmob.v3.exception.BmobException -> L56 java.io.IOException -> L58
            r2.<init>(r0)     // Catch: org.json.JSONException -> L4b cn.bmob.v3.exception.BmobException -> L56 java.io.IOException -> L58
            java.lang.String r0 = "save_token"
            java.lang.String r0 = r2.optString(r0)     // Catch: org.json.JSONException -> L4b cn.bmob.v3.exception.BmobException -> L56 java.io.IOException -> L58
            r6.saveToken = r0     // Catch: org.json.JSONException -> L4b cn.bmob.v3.exception.BmobException -> L56 java.io.IOException -> L58
            java.lang.String r0 = "token_secret"
            java.lang.String r0 = r2.optString(r0)     // Catch: org.json.JSONException -> L4b cn.bmob.v3.exception.BmobException -> L56 java.io.IOException -> L58
            r6.tokenSecret = r0     // Catch: org.json.JSONException -> L4b cn.bmob.v3.exception.BmobException -> L56 java.io.IOException -> L58
            java.lang.String r0 = "status"
            org.json.JSONArray r0 = r2.getJSONArray(r0)     // Catch: org.json.JSONException -> L4b cn.bmob.v3.exception.BmobException -> L56 java.io.IOException -> L58
            int[] r0 = r6.getBlockIndex(r0)     // Catch: org.json.JSONException -> L4b cn.bmob.v3.exception.BmobException -> L56 java.io.IOException -> L58
            r6.blockIndex = r0     // Catch: org.json.JSONException -> L4b cn.bmob.v3.exception.BmobException -> L56 java.io.IOException -> L58
            int[] r0 = r6.blockIndex     // Catch: org.json.JSONException -> L4b cn.bmob.v3.exception.BmobException -> L56 java.io.IOException -> L58
            int r0 = r0.length     // Catch: org.json.JSONException -> L4b cn.bmob.v3.exception.BmobException -> L56 java.io.IOException -> L58
            if (r0 != 0) goto L47
            r6.mergeRequest()     // Catch: org.json.JSONException -> L4b cn.bmob.v3.exception.BmobException -> L56 java.io.IOException -> L58
            goto L89
        L47:
            r6.blockUpload(r1)     // Catch: org.json.JSONException -> L4b cn.bmob.v3.exception.BmobException -> L56 java.io.IOException -> L58
            goto L89
        L4b:
            r0 = move-exception
            cn.bmob.v3.datatype.up.UpCompleteListener r2 = r6.completeListener
            java.lang.String r0 = r0.getMessage()
            r2.onComplete(r1, r0)
            goto L89
        L56:
            r0 = move-exception
            goto L59
        L58:
            r0 = move-exception
        L59:
            int r2 = r6.retryTime
            r3 = 1
            int r2 = r2 + r3
            r6.retryTime = r2
            r4 = 2
            if (r2 <= r4) goto L64
            r2 = 1
            goto L65
        L64:
            r2 = 0
        L65:
            boolean r4 = r0 instanceof cn.bmob.v3.exception.BmobException
            if (r4 == 0) goto L76
            r4 = r0
            cn.bmob.v3.exception.BmobException r4 = (cn.bmob.v3.exception.BmobException) r4
            int r4 = r4.getErrorCode()
            int r4 = r4 / 100
            r5 = 5
            if (r4 == r5) goto L76
            goto L77
        L76:
            r3 = 0
        L77:
            if (r2 != 0) goto L80
            if (r3 == 0) goto L7c
            goto L80
        L7c:
            r6.initRequest()
            goto L89
        L80:
            cn.bmob.v3.datatype.up.UpCompleteListener r2 = r6.completeListener
            java.lang.String r0 = r0.getMessage()
            r2.onComplete(r1, r0)
        L89:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.bmob.v3.datatype.up.BlockUploader.initRequest():void");
    }

    private void mergeRequest() {
        HashMap map = new HashMap();
        map.put(Params.EXPIRATION, Long.valueOf(this.expiration));
        map.put(Params.SAVE_TOKEN, this.saveToken);
        String policy = UpYunUtils.getPolicy(map);
        String signature = UpYunUtils.getSignature(map, this.tokenSecret);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("policy", policy);
        linkedHashMap.put("signature", signature);
        try {
            String strPost = this.client.post(this.url, linkedHashMap);
            this.progressListener.onRequestProgress(this.blockIndex.length, this.blockIndex.length);
            this.randomAccessFile.close();
            BLog.e(strPost);
            this.completeListener.onComplete(true, strPost);
        } catch (BmobException | IOException e2) {
            int i2 = this.retryTime + 1;
            this.retryTime = i2;
            boolean z2 = i2 > 2;
            boolean z3 = (e2 instanceof BmobException) && ((BmobException) e2).getErrorCode() / 100 != 5;
            if (z2 || z3) {
                this.completeListener.onComplete(false, e2.getMessage());
            } else {
                mergeRequest();
            }
        }
    }

    private byte[] readBlockByIndex(int i2) throws BmobException {
        if (i2 > this.totalBlockNum) {
            BLog.e("Block index error", "the index is bigger than totalBlockNum.");
            throw new BmobException(ErrorCode.E9015, "readBlockByIndex: the index is bigger than totalBlockNum.");
        }
        byte[] bArr = new byte[this.blockSize];
        try {
            this.randomAccessFile.seek(this.blockIndex[i2] * r0);
            int i3 = this.randomAccessFile.read(bArr, 0, this.blockSize);
            if (i3 >= this.blockSize) {
                return bArr;
            }
            byte[] bArr2 = new byte[i3];
            System.arraycopy(bArr, 0, bArr2, 0, i3);
            return bArr2;
        } catch (IOException e2) {
            throw new BmobException(ErrorCode.E9015, "readBlockByIndex failed:" + e2.getMessage());
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.bucket = (String) this.params.remove(Params.BUCKET);
            this.url = "http://m0.api.upyun.com/" + this.bucket;
            this.expiration = ((Long) this.params.get(Params.EXPIRATION)).longValue();
            this.params.put(Params.BLOCK_NUM, Integer.valueOf(UpYunUtils.getBlockNum(this.file, this.blockSize)));
            this.params.put(Params.FILE_SIZE, Long.valueOf(this.file.length()));
            this.params.put(Params.FILE_MD5, UpYunUtils.md5Hex(this.file));
            String str = (String) this.params.remove(Params.SAVE_KEY);
            String str2 = (String) this.params.get("path");
            if (str != null && str2 == null) {
                this.params.put("path", str);
            }
            this.userPolicy = UpYunUtils.getPolicy(this.params);
            if (this.apiKey != null) {
                this.userSignature = UpYunUtils.getSignature(this.params, this.apiKey);
            } else {
                if (this.signatureListener == null) {
                    throw new RuntimeException("apikey 和 signatureListener 不可都为null");
                }
                this.userSignature = this.signatureListener.getSignature(getParamsString(this.params));
            }
            this.randomAccessFile = new RandomAccessFile(this.file, "r");
            this.totalBlockNum = UpYunUtils.getBlockNum(this.file, this.blockSize);
            initRequest();
        } catch (FileNotFoundException e2) {
            throw new RuntimeException("文件不存在", e2);
        }
    }
}
