package cn.kuaipan.android.kss.upload;

import cn.kuaipan.android.kss.KssDef;
import cn.kuaipan.android.utils.ApiDataHelper;
import java.util.HashSet;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
class UploadChunkInfo implements KssDef {
    private static final HashSet<String> sReRequestSet;
    public final String commit_meta;
    public ServerExpect expect_info;
    public long left_bytes;
    public long next_pos;
    public final String stat;
    public final String upload_id;

    static {
        HashSet<String> hashSet = new HashSet<>();
        sReRequestSet = hashSet;
        hashSet.add(KssDef.ERR_INVALID_FILE_META);
        hashSet.add(KssDef.ERR_INVALID_BLOCK_META);
        hashSet.add(KssDef.ERR_INVALID_UPLOAD_ID);
        hashSet.add(KssDef.ERR_INVALID_CHUNK_POS);
        hashSet.add(KssDef.ERR_INVALID_CHUNK_SIZE);
        hashSet.add(KssDef.ERR_CHUNK_OUT_OF_RANGE);
        hashSet.add(KssDef.ERR_CHUNK_CORRUPTED);
        hashSet.add(KssDef.ERR_BLOCK_CORRUPTED);
        hashSet.add(KssDef.ERR_SERVER_EXCEPTION);
        hashSet.add(KssDef.ERR_STORAGE_REQUEST_ERROR);
        hashSet.add(KssDef.ERR_STORAGE_REQUEST_FAILED);
    }

    public UploadChunkInfo(long j, long j2) {
        this.stat = "CONTINUE_UPLOAD";
        this.next_pos = j;
        this.left_bytes = j2;
        this.upload_id = null;
        this.commit_meta = null;
    }

    public boolean canRetry() {
        return KssDef.ERR_CHUNK_CORRUPTED.equalsIgnoreCase(this.stat);
    }

    public boolean isComplete() {
        return "BLOCK_COMPLETED".equalsIgnoreCase(this.stat);
    }

    public boolean isContinue() {
        return "CONTINUE_UPLOAD".equalsIgnoreCase(this.stat);
    }

    public boolean needRequestAgain() {
        String str = this.stat;
        return sReRequestSet.contains(str == null ? null : str.toUpperCase());
    }

    public UploadChunkInfo(Map<String, Object> map) {
        this.stat = ApiDataHelper.asString(map, "stat");
        this.next_pos = ApiDataHelper.asNumber(map.get(KssDef.KEY_NEXT_POS), -1).longValue();
        this.left_bytes = ApiDataHelper.asNumber(map.get(KssDef.KEY_LEFT_BYTES), -1).longValue();
        this.upload_id = ApiDataHelper.asString(map, "upload_id");
        this.commit_meta = ApiDataHelper.asString(map, "commit_meta");
    }
}
