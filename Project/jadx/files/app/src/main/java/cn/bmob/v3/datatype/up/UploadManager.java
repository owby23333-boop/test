package cn.bmob.v3.datatype.up;

import anet.channel.strategy.dispatch.DispatchConstants;
import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobConstants;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.helper.ErrorCode;
import cn.bmob.v3.http.RequestUtils;
import cn.bmob.v3.util.BLog;
import cn.bmob.v3.util.Base64Coder;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes.dex */
public class UploadManager {
    public static final int UPLOAD_TYPE_BLOCK = 0;
    public static final int UPLOAD_TYPE_FORM = 1;
    public static final int UPLOAD_TYPE_PARALLEL = 2;
    private static volatile UploadManager instance;
    private ExecutorService executor = Executors.newFixedThreadPool(UpConfig.CONCURRENCY);
    private UploadClient upLoaderClient = new UploadClient();

    private UploadManager() {
    }

    private String getGMTDate() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return simpleDateFormat.format(new Date());
    }

    public static UploadManager getInstance() {
        if (instance == null) {
            synchronized (UploadManager.class) {
                if (instance == null) {
                    instance = new UploadManager();
                }
            }
        }
        return instance;
    }

    private String sign(String str, String str2, String str3, String str4, String str5, String str6) throws BmobException {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append(str3);
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append(str2);
        if (str6 != null) {
            sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
            sb.append(str6);
        }
        try {
            byte[] bArrCalculateRFC2104HMACRaw = UpYunUtils.calculateRFC2104HMACRaw(str5, sb.toString().trim());
            if (bArrCalculateRFC2104HMACRaw == null) {
                return null;
            }
            return "UPYUN " + str4 + ":" + Base64Coder.encodeLines(bArrCalculateRFC2104HMACRaw).replace("\n", "").replace("\r", "").replace("\t", "");
        } catch (Exception unused) {
            throw new BmobException(ErrorCode.E9016, "calculate SHA1 wrong.");
        }
    }

    public void blockUpload(File file, Map<String, Object> map, String str, UpCompleteListener upCompleteListener, UpProgressListener upProgressListener) throws BmobException {
        upload(0, file, map, str, null, upCompleteListener, upProgressListener);
    }

    public void formUpload(File file, Map<String, Object> map, String str, UpCompleteListener upCompleteListener, UpProgressListener upProgressListener) throws BmobException {
        upload(1, file, map, str, null, upCompleteListener, upProgressListener);
    }

    public void parallelUpload(File file, Map<String, Object> map, SignatureListener signatureListener, UpCompleteListener upCompleteListener, UpProgressListener upProgressListener) {
        upload(2, file, map, null, signatureListener, upCompleteListener, upProgressListener);
    }

    protected void upload(File file, Map<String, Object> map, String str, UpCompleteListener upCompleteListener, UpProgressListener upProgressListener) throws BmobException {
        upload(file, map, str, null, upCompleteListener, upProgressListener);
    }

    public void blockUpload(File file, Map<String, Object> map, SignatureListener signatureListener, UpCompleteListener upCompleteListener, UpProgressListener upProgressListener) throws BmobException {
        upload(0, file, map, null, signatureListener, upCompleteListener, upProgressListener);
    }

    public void formUpload(File file, Map<String, Object> map, SignatureListener signatureListener, UpCompleteListener upCompleteListener, UpProgressListener upProgressListener) throws BmobException {
        upload(1, file, map, null, signatureListener, upCompleteListener, upProgressListener);
    }

    public void parallelUpload(File file, Map<String, Object> map, final UpCompleteListener upCompleteListener, final UpProgressListener upProgressListener) throws BmobException {
        String strSign;
        ParallelUploader parallelUploader = new ParallelUploader();
        String str = (String) map.remove(Params.BUCKET);
        BLog.e("空间名:" + str);
        String str2 = (String) map.remove(Params.SAVE_KEY);
        BLog.e("保存路径:" + str2);
        String str3 = (String) map.get("path");
        if (str2 != null && str3 == null) {
            map.put("path", str2);
        }
        final String str4 = (String) map.get("path");
        BLog.e("路径:" + str4);
        String str5 = "/" + str + str2;
        BLog.e("uri：" + str5);
        String gMTDate = getGMTDate();
        BLog.e("date：" + gMTDate);
        try {
            strSign = sign("PUT", gMTDate, str5, BmobConstants.TAG, "a5a15e08f251d517524383ba61f489d3", null);
        } catch (BmobException e2) {
            e2.printStackTrace();
            strSign = null;
        }
        BLog.e("sign：" + strSign);
        parallelUploader.setOnProgressListener(new UpProgressListener() { // from class: cn.bmob.v3.datatype.up.UploadManager.3
            @Override // cn.bmob.v3.datatype.up.UpProgressListener
            public void onRequestProgress(long j2, long j3) {
                upProgressListener.onRequestProgress(j2, j3);
            }
        });
        parallelUploader.upload(file, str5, gMTDate, strSign, null, new UpCompleteListener() { // from class: cn.bmob.v3.datatype.up.UploadManager.4
            @Override // cn.bmob.v3.datatype.up.UpCompleteListener
            public void onComplete(boolean z2, String str6) {
                if (z2) {
                    upCompleteListener.onComplete(z2, str4);
                } else {
                    upCompleteListener.onComplete(z2, str6);
                }
                BLog.e("onComplete", "isSuccess:" + z2 + "  result:" + str6);
            }
        });
    }

    protected void upload(File file, Map<String, Object> map, SignatureListener signatureListener, UpCompleteListener upCompleteListener, UpProgressListener upProgressListener) throws BmobException {
        upload(file, map, null, signatureListener, upCompleteListener, upProgressListener);
    }

    protected void upload(File file, Map<String, Object> map, String str, SignatureListener signatureListener, UpCompleteListener upCompleteListener, UpProgressListener upProgressListener) throws BmobException {
        if (file.length() < UpConfig.FILE_BOUND) {
            upload(1, file, map, str, signatureListener, upCompleteListener, upProgressListener);
        } else {
            upload(0, file, map, str, signatureListener, upCompleteListener, upProgressListener);
        }
    }

    protected void upload(int i2, File file, Map<String, Object> map, String str, SignatureListener signatureListener, final UpCompleteListener upCompleteListener, final UpProgressListener upProgressListener) throws BmobException {
        if (file == null) {
            upCompleteListener.onComplete(false, "文件不可以为空");
            return;
        }
        if (map == null) {
            upCompleteListener.onComplete(false, "参数不可为空");
            return;
        }
        if (str == null && signatureListener == null) {
            upCompleteListener.onComplete(false, "APIkey和signatureListener不可同时为null");
            return;
        }
        if (upCompleteListener != null) {
            if (map.get(Params.BUCKET) == null) {
                map.put(Params.BUCKET, UpConfig.BUCKET);
            }
            if (map.get(Params.EXPIRATION) == null) {
                map.put(Params.EXPIRATION, Long.valueOf(RequestUtils.getTimeStamp() + Bmob.getFileExpiration()));
            }
            UpProgressListener upProgressListener2 = new UpProgressListener() { // from class: cn.bmob.v3.datatype.up.UploadManager.1
                @Override // cn.bmob.v3.datatype.up.UpProgressListener
                public void onRequestProgress(final long j2, final long j3) {
                    AsyncRun.run(new Runnable() { // from class: cn.bmob.v3.datatype.up.UploadManager.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            UpProgressListener upProgressListener3 = upProgressListener;
                            if (upProgressListener3 != null) {
                                upProgressListener3.onRequestProgress(j2, j3);
                            }
                        }
                    });
                }
            };
            UpCompleteListener upCompleteListener2 = new UpCompleteListener() { // from class: cn.bmob.v3.datatype.up.UploadManager.2
                @Override // cn.bmob.v3.datatype.up.UpCompleteListener
                public void onComplete(final boolean z2, final String str2) {
                    AsyncRun.run(new Runnable() { // from class: cn.bmob.v3.datatype.up.UploadManager.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            upCompleteListener.onComplete(z2, str2);
                        }
                    });
                }
            };
            HashMap map2 = new HashMap();
            map2.putAll(map);
            if (i2 == 0) {
                this.executor.execute(new BlockUploader(this.upLoaderClient, file, map2, str, signatureListener, upCompleteListener2, upProgressListener2));
                return;
            } else if (i2 == 1) {
                this.executor.execute(new FormUploader(this.upLoaderClient, file, map2, str, signatureListener, upCompleteListener2, upProgressListener2));
                return;
            } else {
                if (i2 != 2) {
                    return;
                }
                parallelUpload(file, map2, upCompleteListener2, upProgressListener2);
                return;
            }
        }
        throw new RuntimeException("completeListener 不可为null");
    }
}
