package cn.kuaipan.android.kss;

/* JADX INFO: loaded from: classes.dex */
public interface IKssDownloadRequestResult {
    public static final int STATUS_REQUEST_FAILED = -1;
    public static final int STATUS_REQUEST_SUCCESS = 0;

    public static class Block {
        public final String sha1;
        public final long size;
        public final String[] urls;

        public Block(String str, String[] strArr, long j) {
            this.sha1 = str;
            this.urls = strArr;
            this.size = j;
        }

        public String[] getUrls() {
            return this.urls;
        }
    }

    Block getBlock(int i);

    int getBlockCount();

    String[] getBlockUrls(long j);

    String getHash();

    String getMessage();

    long getModifyTime();

    byte[] getSecureKey();

    int getStatus();

    long getTotalSize();
}
