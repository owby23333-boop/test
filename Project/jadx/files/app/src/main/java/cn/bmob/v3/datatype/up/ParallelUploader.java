package cn.bmob.v3.datatype.up;

import anet.channel.strategy.dispatch.DispatchConstants;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.helper.ErrorCode;
import cn.bmob.v3.util.BLog;
import cn.bmob.v3.util.Base64Coder;
import com.anythink.expressad.foundation.d.c;
import com.baidu.tts.network.HttpClientUtil;
import com.bytedance.msdk.api.v2.GMNetworkPlatformConst;
import com.umeng.message.common.inter.ITagManager;
import com.umeng.message.utils.HttpRequest;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/* JADX INFO: loaded from: classes.dex */
public class ParallelUploader {
    private static final String AUTHORIZATION = "Authorization";
    private static final String BACKSLASH = "/";
    private static final int BLOCK_SIZE = 1048576;
    private static final String CONTENT_MD5 = "Content-MD5";
    private static final String CONTENT_SECRET = "Content-Secret";
    private static final String CONTENT_TYPE = "CContent-Type";
    private static final String HOST = "https://v0.api.upyun.com";
    private static final String X_UPYUN_MULTI_DISORDER = "X-Upyun-Multi-Disorder";
    private static final String X_UPYUN_MULTI_LENGTH = "X-Upyun-Multi-Length";
    private static final String X_UPYUN_MULTI_STAGE = "X-Upyun-Multi-Stage";
    private static final String X_UPYUN_MULTI_TYPE = "X-Upyun-Multi-Type";
    private static final String X_UPYUN_MULTI_UUID = "X-Upyun-Multi-UUID";
    private static final String X_UPYUN_PART_ID = "X-Upyun-Part-ID";
    private static final String X_Upyun_Meta_X = "X-Upyun-Meta-X";
    private final String DATE;
    private volatile int blockProgress;
    protected String bucketName;
    private boolean checkMD5;
    private String date;
    private ExecutorService executorService;
    private OkHttpClient mClient;
    private File mFile;
    private UpProgressListener onProgressListener;
    private int paralle;
    protected String password;
    private RandomAccessFile randomAccessFile;
    private String signature;
    private boolean signed;
    private int[] status;
    private int timeout;
    private int totalBlock;
    private String uri;
    private String url;
    protected String userName;
    private String uuid;

    public class Params {
        public static final String ACCEPT = "accept";
        public static final String AVOPTS = "avopts";
        public static final String BUCKET_NAME = "bucket_name";
        public static final String DESCRIPTION = "description";
        public static final String INFO = "info";
        public static final String NOTIFY_URL = "notify_url";
        public static final String PATH = "path";
        public static final String RETURN_INFO = "return_info";
        public static final String SAVE_AS = "save_as";
        public static final String SIGNATURE = "signature";
        public static final String SOURCE = "source";
        public static final String STATUS_CODE = "status_code";
        public static final String TASKS = "tasks";
        public static final String TASK_ID = "task_id";
        public static final String TASK_IDS = "task_ids";
        public static final String TIMESTAMP = "timestamp";
        public static final String TYPE = "type";

        public Params() {
        }
    }

    public ParallelUploader(String str, String str2, String str3) {
        this.DATE = HttpRequest.HEADER_DATE;
        this.bucketName = null;
        this.userName = null;
        this.password = null;
        this.uri = null;
        this.date = null;
        this.signature = null;
        this.timeout = 20;
        this.executorService = Executors.newSingleThreadExecutor();
        this.paralle = 4;
        this.bucketName = str;
        this.userName = str2;
        this.password = str3;
    }

    static /* synthetic */ int access$508(ParallelUploader parallelUploader) {
        int i2 = parallelUploader.blockProgress;
        parallelUploader.blockProgress = i2 + 1;
        return i2;
    }

    private void callRequest(Request request, int i2) throws BmobException, IOException {
        System.out.println("上传接口：" + request.toString());
        Response responseExecute = this.mClient.newCall(request).execute();
        if (!responseExecute.isSuccessful()) {
            throw new BmobException(responseExecute.code(), responseExecute.body().string());
        }
        UpProgressListener upProgressListener = this.onProgressListener;
        if (upProgressListener != null) {
            upProgressListener.onRequestProgress(i2, this.totalBlock);
        }
        this.uuid = responseExecute.header(X_UPYUN_MULTI_UUID, "");
    }

    private boolean completeUpload() throws BmobException, IOException {
        RequestBody requestBodyCreate = RequestBody.create((MediaType) null, "");
        String strMd5 = this.checkMD5 ? UpYunUtils.md5("") : null;
        if (!this.signed) {
            this.date = getGMTDate();
            this.signature = sign("PUT", this.date, this.uri, this.userName, this.password, strMd5).trim();
        }
        Request.Builder builderPut = new Request.Builder().url(this.url).header(HttpRequest.HEADER_DATE, this.date).header("Authorization", this.signature).header(X_UPYUN_MULTI_STAGE, c.bX).header(X_UPYUN_MULTI_UUID, this.uuid).header("User-Agent", UpYunUtils.VERSION).put(requestBodyCreate);
        if (strMd5 != null) {
            builderPut.header(CONTENT_MD5, strMd5);
        }
        callRequest(builderPut.build(), this.totalBlock);
        this.uuid = null;
        this.status = null;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getGMTDate() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return simpleDateFormat.format(new Date());
    }

    private String getMimeType(String str) {
        String contentTypeFor = URLConnection.getFileNameMap().getContentTypeFor(str);
        if (contentTypeFor == null) {
            contentTypeFor = HttpClientUtil.APPLICATION_OCTET_STREAM;
        }
        BLog.e("getMimeType：" + contentTypeFor);
        return contentTypeFor;
    }

    private boolean processUpload() throws ExecutionException, BmobException, InterruptedException, IOException {
        this.blockProgress = 0;
        ExecutorService executorServiceNewFixedThreadPool = Executors.newFixedThreadPool(this.paralle);
        for (int i2 = 0; i2 < this.totalBlock - 2; i2++) {
            try {
                executorServiceNewFixedThreadPool.submit(uploadBlock(i2)).get();
            } catch (InterruptedException e2) {
                throw e2;
            } catch (ExecutionException e3) {
                throw e3;
            }
        }
        executorServiceNewFixedThreadPool.shutdown();
        try {
            executorServiceNewFixedThreadPool.awaitTermination(Long.MAX_VALUE, TimeUnit.MINUTES);
        } catch (InterruptedException e4) {
            e4.printStackTrace();
        }
        RandomAccessFile randomAccessFile = this.randomAccessFile;
        if (randomAccessFile != null) {
            randomAccessFile.close();
            this.randomAccessFile = null;
        }
        return completeUpload();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public byte[] readBlockByIndex(int i2) throws IOException {
        byte[] bArr = new byte[1048576];
        this.randomAccessFile.seek(i2 * 1048576);
        int i3 = this.randomAccessFile.read(bArr, 0, 1048576);
        if (i3 >= 1048576) {
            return bArr;
        }
        byte[] bArr2 = new byte[i3];
        System.arraycopy(bArr, 0, bArr2, 0, i3);
        return bArr2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String sign(String str, String str2, String str3, String str4, String str5, String str6) throws BmobException {
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
            return "UPYUN " + str4 + ":" + Base64Coder.encodeLines(bArrCalculateRFC2104HMACRaw);
        } catch (Exception unused) {
            throw new BmobException(ErrorCode.E9015, "calculate SHA1 wrong.");
        }
    }

    private boolean startUpload(Map<String, String> map) throws ExecutionException, BmobException, InterruptedException, IOException {
        if (this.uuid != null) {
            return processUpload();
        }
        RequestBody requestBodyCreate = RequestBody.create((MediaType) null, "");
        String strMd5 = this.checkMD5 ? UpYunUtils.md5("") : null;
        if (!this.signed) {
            this.date = getGMTDate();
            this.signature = sign("PUT", this.date, this.uri, this.userName, this.password, strMd5).trim();
        }
        Request.Builder builderPut = new Request.Builder().url(this.url).header(HttpRequest.HEADER_DATE, this.date).header("Authorization", this.signature).header(X_UPYUN_MULTI_DISORDER, ITagManager.STATUS_TRUE).header(X_UPYUN_MULTI_STAGE, "initiate").header(X_UPYUN_MULTI_TYPE, getMimeType(this.mFile.getPath())).header(X_UPYUN_MULTI_LENGTH, this.mFile.length() + "").header("User-Agent", UpYunUtils.VERSION).put(requestBodyCreate);
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                builderPut.header(entry.getKey(), entry.getValue());
            }
        }
        if (strMd5 != null) {
            builderPut.header(CONTENT_MD5, strMd5);
        }
        callRequest(builderPut.build(), 1);
        return processUpload();
    }

    private Runnable uploadBlock(final int i2) {
        return new Runnable() { // from class: cn.bmob.v3.datatype.up.ParallelUploader.7
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (ParallelUploader.this.status[i2] == 1) {
                        if (ParallelUploader.this.onProgressListener != null) {
                            ParallelUploader.this.onProgressListener.onRequestProgress(ParallelUploader.this.blockProgress + 2, ParallelUploader.this.totalBlock);
                        }
                        ParallelUploader.access$508(ParallelUploader.this);
                        return;
                    }
                    if (ParallelUploader.this.status[i2] == 2) {
                        return;
                    }
                    ParallelUploader.this.status[i2] = 2;
                    byte[] blockByIndex = ParallelUploader.this.readBlockByIndex(i2);
                    RequestBody requestBodyCreate = RequestBody.create((MediaType) null, blockByIndex);
                    String strMd5 = ParallelUploader.this.checkMD5 ? UpYunUtils.md5(blockByIndex) : null;
                    if (!ParallelUploader.this.signed) {
                        ParallelUploader.this.date = ParallelUploader.this.getGMTDate();
                        ParallelUploader.this.signature = ParallelUploader.this.sign("PUT", ParallelUploader.this.date, ParallelUploader.this.uri, ParallelUploader.this.userName, ParallelUploader.this.password, strMd5).trim();
                    }
                    Request.Builder builderPut = new Request.Builder().url(ParallelUploader.this.url).header(HttpRequest.HEADER_DATE, ParallelUploader.this.date).header("Authorization", ParallelUploader.this.signature).header(ParallelUploader.X_UPYUN_MULTI_STAGE, "upload").header(ParallelUploader.X_UPYUN_MULTI_UUID, ParallelUploader.this.uuid).header(ParallelUploader.X_UPYUN_PART_ID, i2 + "").header("User-Agent", UpYunUtils.VERSION).put(requestBodyCreate);
                    if (strMd5 != null) {
                        builderPut.header(ParallelUploader.CONTENT_MD5, strMd5);
                    }
                    ParallelUploader.this.uploadRequest(builderPut);
                    ParallelUploader.this.status[i2] = 1;
                } catch (Exception e2) {
                    ParallelUploader.this.status[i2] = 3;
                    throw new RuntimeException(e2.getMessage());
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Response uploadRequest(Request.Builder builder) {
        try {
            Response responseExecute = this.mClient.newCall(builder.build()).execute();
            if (responseExecute.isSuccessful()) {
                if (this.onProgressListener != null) {
                    this.onProgressListener.onRequestProgress(this.blockProgress + 2, this.totalBlock);
                }
                this.blockProgress++;
                return responseExecute;
            }
            int i2 = Integer.parseInt(responseExecute.header("X-Error-Code", GMNetworkPlatformConst.AD_NETWORK_NO_PRICE));
            if (i2 == 40011061 || i2 == 40011059) {
                this.uuid = null;
            }
            throw new RuntimeException(responseExecute.body().string());
        } catch (IOException e2) {
            throw new RuntimeException(e2.toString());
        }
    }

    public int[] getStatus() {
        return this.status;
    }

    public String getUuid() {
        return this.uuid;
    }

    public void setCheckMD5(boolean z2) {
        this.checkMD5 = z2;
    }

    public void setOnProgressListener(UpProgressListener upProgressListener) {
        this.onProgressListener = upProgressListener;
    }

    public void setParalle(int i2) {
        this.paralle = i2;
    }

    public void setStatus(int[] iArr) {
        this.status = iArr;
    }

    public void setTimeout(int i2) {
        this.timeout = i2;
    }

    public void setUuid(String str) {
        this.uuid = str;
    }

    public boolean upload(File file, String str, Map<String, String> map) throws ExecutionException, BmobException, InterruptedException, IOException {
        this.mFile = file;
        this.signed = false;
        double length = this.mFile.length();
        Double.isNaN(length);
        this.totalBlock = (int) Math.ceil((length / 1048576.0d) + 2.0d);
        this.randomAccessFile = new RandomAccessFile(this.mFile, "r");
        if (str.startsWith(BACKSLASH)) {
            this.uri = BACKSLASH + this.bucketName + BACKSLASH + URLEncoder.encode(str.substring(1));
        } else {
            this.uri = BACKSLASH + this.bucketName + BACKSLASH + URLEncoder.encode(str);
        }
        this.url = HOST + this.uri;
        this.mClient = new OkHttpClient.Builder().connectTimeout((long) this.timeout, TimeUnit.SECONDS).readTimeout((long) this.timeout, TimeUnit.SECONDS).writeTimeout((long) this.timeout, TimeUnit.SECONDS).build();
        int[] iArr = this.status;
        if (iArr == null || iArr.length != this.totalBlock - 2 || this.uuid == null) {
            this.status = new int[this.totalBlock - 2];
        }
        return startUpload(map);
    }

    public ParallelUploader() {
        this.DATE = HttpRequest.HEADER_DATE;
        this.bucketName = null;
        this.userName = null;
        this.password = null;
        this.uri = null;
        this.date = null;
        this.signature = null;
        this.timeout = 20;
        this.executorService = Executors.newSingleThreadExecutor();
        this.paralle = 4;
    }

    public boolean upload(File file, String str, String str2, String str3, Map<String, String> map) throws ExecutionException, BmobException, InterruptedException, IOException {
        this.signed = true;
        this.mFile = file;
        this.uri = str;
        this.date = str2;
        this.signature = str3;
        double length = this.mFile.length();
        Double.isNaN(length);
        this.totalBlock = (int) Math.ceil((length / 1048576.0d) + 2.0d);
        this.randomAccessFile = new RandomAccessFile(this.mFile, "r");
        this.url = HOST + str;
        this.mClient = new OkHttpClient.Builder().connectTimeout((long) this.timeout, TimeUnit.SECONDS).readTimeout((long) this.timeout, TimeUnit.SECONDS).writeTimeout((long) this.timeout, TimeUnit.SECONDS).build();
        int[] iArr = this.status;
        if (iArr == null || iArr.length != this.totalBlock - 2 || this.uuid == null) {
            this.status = new int[this.totalBlock - 2];
        }
        return startUpload(map);
    }

    public void upload(final File file, final String str, final Map<String, String> map, final Map<String, Object> map2, final UpCompleteListener upCompleteListener) throws BmobException {
        if (map2 == null) {
            upload(file, str, map, upCompleteListener);
        } else {
            final UpCompleteListener upCompleteListener2 = new UpCompleteListener() { // from class: cn.bmob.v3.datatype.up.ParallelUploader.1
                @Override // cn.bmob.v3.datatype.up.UpCompleteListener
                public void onComplete(final boolean z2, final String str2) {
                    AsyncRun.run(new Runnable() { // from class: cn.bmob.v3.datatype.up.ParallelUploader.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            UpCompleteListener upCompleteListener3 = upCompleteListener;
                            if (upCompleteListener3 != null) {
                                upCompleteListener3.onComplete(z2, str2);
                            }
                        }
                    });
                }
            };
            this.executorService.execute(new Runnable() { // from class: cn.bmob.v3.datatype.up.ParallelUploader.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        ParallelUploader.this.upload(file, str, map);
                        String gMTDate = ParallelUploader.this.getGMTDate();
                        String strSign = ParallelUploader.this.sign("POST", gMTDate, "/pretreatment/", ParallelUploader.this.userName, ParallelUploader.this.password, null);
                        map2.put(Params.TASKS, Base64Coder.encodeString(map2.get(Params.TASKS).toString()));
                        FormBody.Builder builder = new FormBody.Builder();
                        for (Map.Entry entry : map2.entrySet()) {
                            builder.addEncoded((String) entry.getKey(), entry.getValue().toString());
                        }
                        Response responseExecute = ParallelUploader.this.mClient.newCall(new Request.Builder().url("http://p0.api.upyun.com/pretreatment/").post(builder.build()).header(HttpRequest.HEADER_DATE, gMTDate).header("Authorization", strSign).header("User-Agent", UpYunUtils.VERSION).build()).execute();
                        if (responseExecute.isSuccessful()) {
                            upCompleteListener2.onComplete(true, responseExecute.body().string());
                        } else {
                            upCompleteListener2.onComplete(false, responseExecute.body().string());
                        }
                    } catch (BmobException e2) {
                        e2.printStackTrace();
                        upCompleteListener2.onComplete(false, e2.toString());
                    } catch (IOException e3) {
                        e3.printStackTrace();
                        upCompleteListener2.onComplete(false, e3.toString());
                    } catch (InterruptedException e4) {
                        e4.printStackTrace();
                        upCompleteListener2.onComplete(false, e4.toString());
                    } catch (ExecutionException e5) {
                        e5.printStackTrace();
                        upCompleteListener2.onComplete(false, e5.toString());
                    }
                }
            });
        }
    }

    public void upload(final File file, final String str, final String str2, final String str3, final Map<String, String> map, final UpCompleteListener upCompleteListener) {
        final UpCompleteListener upCompleteListener2 = new UpCompleteListener() { // from class: cn.bmob.v3.datatype.up.ParallelUploader.3
            @Override // cn.bmob.v3.datatype.up.UpCompleteListener
            public void onComplete(final boolean z2, final String str4) {
                System.out.println("上传成功后返回内容：" + str4);
                AsyncRun.run(new Runnable() { // from class: cn.bmob.v3.datatype.up.ParallelUploader.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        UpCompleteListener upCompleteListener3 = upCompleteListener;
                        if (upCompleteListener3 != null) {
                            upCompleteListener3.onComplete(z2, str4);
                        }
                    }
                });
            }
        };
        this.executorService.execute(new Runnable() { // from class: cn.bmob.v3.datatype.up.ParallelUploader.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    ParallelUploader.this.upload(file, str, str2, str3, map);
                    upCompleteListener2.onComplete(true, null);
                } catch (BmobException e2) {
                    e2.printStackTrace();
                    upCompleteListener2.onComplete(false, e2.toString());
                } catch (IOException e3) {
                    e3.printStackTrace();
                    upCompleteListener2.onComplete(false, e3.toString());
                } catch (InterruptedException e4) {
                    e4.printStackTrace();
                    upCompleteListener2.onComplete(false, e4.toString());
                } catch (ExecutionException e5) {
                    e5.printStackTrace();
                    upCompleteListener2.onComplete(false, e5.toString());
                }
            }
        });
    }

    public void upload(final File file, final String str, final Map<String, String> map, final UpCompleteListener upCompleteListener) {
        final UpCompleteListener upCompleteListener2 = new UpCompleteListener() { // from class: cn.bmob.v3.datatype.up.ParallelUploader.5
            @Override // cn.bmob.v3.datatype.up.UpCompleteListener
            public void onComplete(final boolean z2, final String str2) {
                AsyncRun.run(new Runnable() { // from class: cn.bmob.v3.datatype.up.ParallelUploader.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        UpCompleteListener upCompleteListener3 = upCompleteListener;
                        if (upCompleteListener3 != null) {
                            upCompleteListener3.onComplete(z2, str2);
                        }
                    }
                });
            }
        };
        this.executorService.execute(new Runnable() { // from class: cn.bmob.v3.datatype.up.ParallelUploader.6
            @Override // java.lang.Runnable
            public void run() {
                try {
                    ParallelUploader.this.upload(file, str, map);
                    upCompleteListener2.onComplete(true, null);
                } catch (BmobException e2) {
                    e2.printStackTrace();
                    upCompleteListener2.onComplete(false, e2.toString());
                } catch (IOException e3) {
                    e3.printStackTrace();
                    upCompleteListener2.onComplete(false, e3.toString());
                } catch (InterruptedException e4) {
                    e4.printStackTrace();
                    upCompleteListener2.onComplete(false, e4.toString());
                } catch (ExecutionException e5) {
                    e5.printStackTrace();
                    upCompleteListener2.onComplete(false, e5.toString());
                }
            }
        });
    }
}
