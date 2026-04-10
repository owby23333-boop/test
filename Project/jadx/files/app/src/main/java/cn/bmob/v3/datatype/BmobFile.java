package cn.bmob.v3.datatype;

import android.content.Context;
import android.text.TextUtils;
import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobConstants;
import cn.bmob.v3.datatype.up.BmobUploader;
import cn.bmob.v3.datatype.up.UpYunUploader;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.helper.ErrorCode;
import cn.bmob.v3.helper.GsonUtil;
import cn.bmob.v3.http.BmobClient;
import cn.bmob.v3.http.BmobFactory;
import cn.bmob.v3.http.BmobFileDownloader;
import cn.bmob.v3.http.RequestUtils;
import cn.bmob.v3.http.RxBmob;
import cn.bmob.v3.http.bean.Upyun;
import cn.bmob.v3.listener.BmobErrorCallback;
import cn.bmob.v3.listener.DeleteBatchListener;
import cn.bmob.v3.listener.DownloadFileListener;
import cn.bmob.v3.listener.ProgressCallback;
import cn.bmob.v3.listener.UpdateListener;
import cn.bmob.v3.listener.UploadBatchListener;
import cn.bmob.v3.listener.UploadFileListener;
import cn.bmob.v3.util.BLog;
import cn.bmob.v3.util.BmobContentProvider;
import cn.bmob.v3.util.ManifestUtils;
import cn.bmob.v3.util.Utils;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class BmobFile implements Serializable {
    private static final long serialVersionUID = -9145726747813570773L;
    private String __type;
    private transient Context context;
    private transient BmobFileDownloader downloader;
    private String filename;
    private String group;
    private transient File localFile;
    private transient BmobUploader uploader;
    protected String url;

    public BmobFile() {
        this.filename = null;
        this.group = null;
        this.url = null;
        this.__type = "File";
        this.context = Bmob.getApplicationContext();
    }

    private void cancelDownload() {
        BmobFileDownloader bmobFileDownloader = this.downloader;
        if (bmobFileDownloader != null) {
            bmobFileDownloader.cancel(true);
        }
    }

    private void cancelUpload() {
        BmobUploader bmobUploader = this.uploader;
        if (bmobUploader != null) {
            bmobUploader.cancel(true);
        }
    }

    private Disposable cdnUpload(UploadFileListener uploadFileListener) {
        if (!checkContext(uploadFileListener) || !checkFile(this.localFile, uploadFileListener)) {
            return null;
        }
        if (uploadFileListener != null) {
            uploadFileListener.internalStart();
        }
        return uploadRequest(uploadFileListener).getDisposable();
    }

    private boolean checkContext(BmobErrorCallback bmobErrorCallback) {
        if (this.context == null && bmobErrorCallback != null) {
            bmobErrorCallback.doneError(ErrorCode.E9012, ErrorCode.E9012S);
            return false;
        }
        if (TextUtils.isEmpty(RequestUtils.getAppKey())) {
            if (bmobErrorCallback != null) {
                bmobErrorCallback.doneError(9001, ErrorCode.E9001S);
            } else {
                BLog.e(BmobConstants.TAG, ErrorCode.E9001S);
            }
            return false;
        }
        if (!ManifestUtils.detectNetWork(this.context)) {
            if (bmobErrorCallback != null) {
                bmobErrorCallback.doneError(ErrorCode.E9016, ErrorCode.E9016S);
            } else {
                BLog.e(BmobConstants.TAG, ErrorCode.E9016S);
            }
            return false;
        }
        if (Utils.checkPermission(this.context, "android.permission.WAKE_LOCK")) {
            return true;
        }
        if (bmobErrorCallback != null) {
            bmobErrorCallback.doneError(ErrorCode.E9021, ErrorCode.E9021S);
        } else {
            BLog.e(BmobConstants.TAG, ErrorCode.E9021S);
        }
        return false;
    }

    private boolean checkFile(File file, BmobErrorCallback bmobErrorCallback) {
        if (file == null || !file.exists()) {
            if (bmobErrorCallback != null) {
                bmobErrorCallback.doneError(ErrorCode.E9008, "the file does not exist.");
            } else {
                BLog.e(BmobConstants.TAG, "the file does not exist(9008)");
            }
            return false;
        }
        if (file.length() != 0) {
            return true;
        }
        if (bmobErrorCallback != null) {
            bmobErrorCallback.doneError(ErrorCode.E9007, "the file length must be greater than zero.");
        } else {
            BLog.e(BmobConstants.TAG, "the file length must be greater than zero(9007)");
        }
        return false;
    }

    public static BmobFile createEmptyFile() {
        BmobFile bmobFile = new BmobFile(new File(""));
        bmobFile.setFilename("test.apk");
        return bmobFile;
    }

    public static Disposable deleteBatch(String[] strArr, DeleteBatchListener deleteBatchListener) {
        return BmobFactory.getInstance().createDeleteBatchCDNRequest(strArr, deleteBatchListener).getDisposable();
    }

    public static Observable<BmobReturn<String[]>> deleteBatchObservable(String[] strArr) {
        return BmobFactory.getInstance().createDeleteBatchCDNRequest(strArr, null).getObservable();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doUpload(Upyun upyun, UploadFileListener uploadFileListener) {
        cancelUpload();
        this.uploader = getUploader(this.context, upyun, uploadFileListener);
        this.uploader.execute();
    }

    private BmobUploader getUploader(Context context, Upyun upyun, UploadFileListener uploadFileListener) {
        return new UpYunUploader(context, upyun, this, uploadFileListener);
    }

    private String get__type() {
        return this.__type;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Observable<BmobException> rxUploadObservable(final Upyun upyun, final ProgressCallback progressCallback) {
        return Observable.create(new ObservableOnSubscribe<BmobException>() { // from class: cn.bmob.v3.datatype.BmobFile.5
            @Override // io.reactivex.ObservableOnSubscribe
            public void subscribe(final ObservableEmitter<BmobException> observableEmitter) throws Exception {
                if (observableEmitter.isDisposed()) {
                    BLog.i("uploadObservable:subscriber is cancel");
                } else {
                    BmobFile.this.doUpload(upyun, new UploadFileListener() { // from class: cn.bmob.v3.datatype.BmobFile.5.1
                        @Override // cn.bmob.v3.listener.UploadFileListener
                        public void done(BmobException bmobException) {
                            if (bmobException != null) {
                                observableEmitter.onError(bmobException);
                            } else {
                                observableEmitter.onNext(new BmobException());
                            }
                        }

                        @Override // cn.bmob.v3.listener.UploadFileListener
                        public void onProgress(Integer num) {
                            super.onProgress(num);
                            AnonymousClass5 anonymousClass5 = AnonymousClass5.this;
                            ProgressCallback progressCallback2 = progressCallback;
                            if (progressCallback2 != null) {
                                progressCallback2.onProgress(num, BmobFile.this.getLocalFile().length());
                            }
                        }
                    });
                }
            }
        }).concatMap(new Function<BmobException, Observable<? extends BmobException>>() { // from class: cn.bmob.v3.datatype.BmobFile.4
            @Override // io.reactivex.functions.Function
            public Observable<? extends BmobException> apply(BmobException bmobException) {
                return BmobFactory.getInstance().saveCDN(BmobFile.this.getFileUrl(), BmobFile.this.getFilename(), BmobFile.this.getLocalFile().length());
            }
        });
    }

    public static void uploadBatch(String[] strArr, UploadBatchListener uploadBatchListener) {
        if (strArr != null && strArr.length != 0) {
            uploadFile(0, strArr, new ArrayList(), new ArrayList(), uploadBatchListener);
        } else if (uploadBatchListener != null) {
            uploadBatchListener.onError(ErrorCode.E9008, "the files does not exist.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void uploadFile(int i2, String[] strArr, List<BmobFile> list, List<String> list2, UploadBatchListener uploadBatchListener) {
        int length = strArr.length;
        if (i2 + 1 < length) {
            uploadIndex(false, length, i2, strArr, list, list2, uploadBatchListener);
        } else {
            uploadIndex(true, length, i2, strArr, list, list2, uploadBatchListener);
        }
    }

    private static void uploadIndex(final boolean z2, final int i2, final int i3, final String[] strArr, final List<BmobFile> list, final List<String> list2, final UploadBatchListener uploadBatchListener) {
        BmobFile bmobFile = new BmobFile(new File(strArr[i3]));
        bmobFile.uploadblock(new UploadFileListener() { // from class: cn.bmob.v3.datatype.BmobFile.7
            @Override // cn.bmob.v3.listener.UploadFileListener
            public void done(BmobException bmobException) {
                if (bmobException != null) {
                    uploadBatchListener.onError(bmobException.getErrorCode(), bmobException.getMessage());
                    return;
                }
                String fileUrl = BmobFile.this.getFileUrl();
                list.add(BmobFile.this);
                list2.add(fileUrl);
                uploadBatchListener.onSuccess(list, list2);
                if (z2) {
                    return;
                }
                BmobFile.uploadFile(i3 + 1, strArr, list, list2, uploadBatchListener);
            }

            @Override // cn.bmob.v3.listener.UploadFileListener
            public void onProgress(Integer num) {
                UploadBatchListener uploadBatchListener2 = uploadBatchListener;
                int i4 = i3 + 1;
                int iIntValue = num.intValue();
                int i5 = i2;
                uploadBatchListener2.onProgress(i4, iIntValue, i5, Utils.calculatePercent(i3 + 1, i5));
            }
        });
    }

    private RxBmob uploadRequest(final UploadFileListener uploadFileListener) {
        return new RxBmob.Builder().create(uploadObservable(new ProgressCallback() { // from class: cn.bmob.v3.datatype.BmobFile.1
            @Override // cn.bmob.v3.listener.ProgressCallback
            public void onProgress(Integer num, long j2) {
                UploadFileListener uploadFileListener2 = uploadFileListener;
                if (uploadFileListener2 != null) {
                    uploadFileListener2.onProgress(num);
                }
            }
        })).subscribe(uploadFileListener).build();
    }

    public void cancel() {
        cancelUpload();
        cancelDownload();
    }

    public Disposable delete() {
        return delete(null);
    }

    public Observable<Void> deleteObservable() {
        String url = getUrl();
        return BmobFactory.getInstance().createDeleteCDNRequest(BmobFactory.rByNull(url, "url can't be empty"), url, null).getObservable();
    }

    public void download(DownloadFileListener downloadFileListener) {
        if (this.context == null) {
            if (downloadFileListener != null) {
                downloadFileListener.doneError(ErrorCode.E9012, "context is null.");
            }
        } else {
            download(new File(this.context.getApplicationContext().getCacheDir() + "/bmob/", getFilename()), downloadFileListener);
        }
    }

    public Observable<String> downloadObservable(ProgressCallback progressCallback) {
        return downloadObservable(new File(this.context.getApplicationContext().getCacheDir() + "/bmob/", getFilename()), progressCallback);
    }

    public String getFileUrl() {
        if (this.url.startsWith("http")) {
            return this.url;
        }
        return BmobContentProvider.getFile() + "/" + this.url;
    }

    public String getFilename() {
        return this.filename;
    }

    public String getGroup() {
        return this.group;
    }

    public File getLocalFile() {
        return this.localFile;
    }

    public String getUrl() {
        return this.url;
    }

    public void obtain(String str, String str2, String str3) {
        this.context = Bmob.getApplicationContext();
        this.filename = str;
        this.group = str2;
        this.url = str3;
    }

    protected void setFilename(String str) {
        this.filename = str;
    }

    protected void setGroup(String str) {
        this.group = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public Disposable upload(UploadFileListener uploadFileListener) {
        return uploadblock(uploadFileListener);
    }

    public Observable<BmobException> uploadObservable(final ProgressCallback progressCallback) {
        if (checkContext(null) && checkFile(this.localFile, null)) {
            return Observable.create(new ObservableOnSubscribe<String>() { // from class: cn.bmob.v3.datatype.BmobFile.3
                @Override // io.reactivex.ObservableOnSubscribe
                public void subscribe(ObservableEmitter<String> observableEmitter) throws Exception {
                    int upyunVersion = BmobContentProvider.getUpyunVersion();
                    String upyun = BmobContentProvider.getUpyun();
                    if (upyunVersion == -1 || upyunVersion < BmobClient.curCDNVersion || TextUtils.isEmpty(upyun)) {
                        observableEmitter.onNext(upyun);
                    } else {
                        observableEmitter.onNext(upyun);
                    }
                }
            }).concatMap(new Function<String, Observable<? extends BmobException>>() { // from class: cn.bmob.v3.datatype.BmobFile.2
                @Override // io.reactivex.functions.Function
                public Observable<? extends BmobException> apply(String str) {
                    BLog.e(str);
                    if (TextUtils.isEmpty(str)) {
                        return BmobFactory.getInstance().createCDNObservable().concatMap(new Function<Upyun, Observable<? extends BmobException>>() { // from class: cn.bmob.v3.datatype.BmobFile.2.1
                            @Override // io.reactivex.functions.Function
                            public Observable<? extends BmobException> apply(Upyun upyun) {
                                AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                return BmobFile.this.rxUploadObservable(upyun, progressCallback);
                            }
                        });
                    }
                    return BmobFile.this.rxUploadObservable((Upyun) GsonUtil.toObject(str, Upyun.class), progressCallback);
                }
            });
        }
        return null;
    }

    public Disposable uploadblock(UploadFileListener uploadFileListener) {
        return cdnUpload(uploadFileListener);
    }

    public Disposable delete(UpdateListener updateListener) {
        String url = getUrl();
        return BmobFactory.getInstance().createDeleteCDNRequest(BmobFactory.rByNull(url, "url can't be empty"), url, updateListener).getDisposable();
    }

    public Observable<String> downloadObservable(final File file, final ProgressCallback progressCallback) {
        return Observable.create(new ObservableOnSubscribe<String>() { // from class: cn.bmob.v3.datatype.BmobFile.6
            @Override // io.reactivex.ObservableOnSubscribe
            public void subscribe(final ObservableEmitter<String> observableEmitter) throws Exception {
                if (observableEmitter.isDisposed()) {
                    BLog.i("downloadObservable:subscriber is cancel");
                } else {
                    BmobFile.this.download(file, new DownloadFileListener() { // from class: cn.bmob.v3.datatype.BmobFile.6.1
                        @Override // cn.bmob.v3.listener.ProgressCallback
                        public void onProgress(Integer num, long j2) {
                            ProgressCallback progressCallback2 = progressCallback;
                            if (progressCallback2 != null) {
                                progressCallback2.onProgress(num, j2);
                            }
                        }

                        @Override // cn.bmob.v3.listener.DownloadFileListener, cn.bmob.v3.listener.BmobErrorCallback
                        public void done(String str, BmobException bmobException) {
                            if (bmobException == null) {
                                observableEmitter.onNext(str);
                            } else {
                                observableEmitter.onError(bmobException);
                            }
                            observableEmitter.onComplete();
                        }
                    });
                }
            }
        });
    }

    public void download(File file, DownloadFileListener downloadFileListener) {
        if (checkContext(downloadFileListener)) {
            String fileUrl = getFileUrl();
            if (TextUtils.isEmpty(fileUrl)) {
                if (downloadFileListener != null) {
                    downloadFileListener.doneError(ErrorCode.E9018, "fileUrl can't be empty");
                }
            } else if (file == null) {
                if (downloadFileListener != null) {
                    downloadFileListener.doneError(ErrorCode.E9018, "savePath must not be null");
                }
            } else {
                cancelDownload();
                this.downloader = new BmobFileDownloader(this.context, fileUrl, file, downloadFileListener);
                this.downloader.execute(new Void[0]);
            }
        }
    }

    public BmobFile(File file) {
        this.filename = null;
        this.group = null;
        this.url = null;
        this.__type = "File";
        this.context = Bmob.getApplicationContext();
        this.localFile = file;
    }

    public BmobFile(String str, String str2, String str3) {
        this.filename = null;
        this.group = null;
        this.url = null;
        this.__type = "File";
        this.context = Bmob.getApplicationContext();
        this.filename = str;
        this.group = str2;
        this.url = str3;
    }
}
