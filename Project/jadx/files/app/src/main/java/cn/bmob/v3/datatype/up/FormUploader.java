package cn.bmob.v3.datatype.up;

import anet.channel.strategy.dispatch.DispatchConstants;
import cn.bmob.v3.exception.BmobException;
import java.io.File;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class FormUploader implements Runnable {
    private String apiKey;
    private String bucket;
    private UploadClient client;
    private UpCompleteListener completeListener;
    private File file;
    private Map<String, Object> params;
    private String policy;
    private UpProgressListener progressListener;
    private int retryTime;
    private String signature;
    private SignatureListener signatureListener;

    public FormUploader(UploadClient uploadClient, File file, Map<String, Object> map, String str, SignatureListener signatureListener, UpCompleteListener upCompleteListener, UpProgressListener upProgressListener) {
        this.client = uploadClient;
        this.file = file;
        this.bucket = (String) map.get(Params.BUCKET);
        this.params = map;
        this.apiKey = str;
        this.signatureListener = signatureListener;
        this.completeListener = upCompleteListener;
        this.progressListener = upProgressListener;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str = (String) this.params.get(Params.SAVE_KEY);
        String str2 = (String) this.params.remove("path");
        if (str == null && str2 != null) {
            this.params.put(Params.SAVE_KEY, str2);
        }
        this.policy = UpYunUtils.getPolicy(this.params);
        String str3 = this.apiKey;
        if (str3 != null) {
            this.signature = UpYunUtils.getSignature(this.policy, str3);
        } else {
            SignatureListener signatureListener = this.signatureListener;
            if (signatureListener == null) {
                throw new RuntimeException("apiKey 和 signatureListener 不能同时为null");
            }
            this.signature = signatureListener.getSignature(this.policy + DispatchConstants.SIGN_SPLIT_SYMBOL);
        }
        try {
            this.completeListener.onComplete(true, this.client.fromUpLoad(this.file, "http://v0.api.upyun.com/" + this.bucket, this.policy, this.signature, this.progressListener));
        } catch (BmobException | IOException e2) {
            int i2 = this.retryTime + 1;
            this.retryTime = i2;
            boolean z2 = i2 > 2;
            boolean z3 = (e2 instanceof BmobException) && ((BmobException) e2).getErrorCode() / 100 != 5;
            if (z2 || z3) {
                this.completeListener.onComplete(false, e2.toString());
            } else {
                run();
            }
        }
    }
}
