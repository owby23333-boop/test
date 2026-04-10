package cn.kuaipan.android.kss.download;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Log;
import cn.kuaipan.android.http.IKscTransferListener;
import cn.kuaipan.android.kss.IKssDownloadRequestResult;
import com.xiaomi.mipush.sdk.Constants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class LoadMap {
    private static final String KEY_BLOCKS = "blocks";
    private static final String KEY_BLOCK_END = "block_end";
    private static final String KEY_BLOCK_START = "block_start";
    private static final String KEY_SPACE = "space_info";
    private static final String LOG_TAG = "LoadMap";
    private static final int MAX_VERIFY_COUNT = 2;
    private static final int MIN_OBTAIN_SIZE = 65536;
    private final BlockSpace[] mBlocks;
    private IKscTransferListener mListener;
    private final HashMap<Space, LoadRecorder> mRecorders = new HashMap<>();
    private final ArrayList<Space> mEmptySpaces = new ArrayList<>();

    public class BlockSpace {
        private final long end;
        private final String sha1;
        private final long start;
        private VerifyState verifyState;
        private final ArrayList<Space> spaces = new ArrayList<>();
        private int verifyFailCount = 0;

        public BlockSpace(IKssDownloadRequestResult.Block block, long j) {
            this.sha1 = block.sha1;
            this.start = j;
            this.end = j + block.size;
            reset();
        }

        private boolean _verify(KssAccessor kssAccessor) {
            kssAccessor.lock();
            boolean zEqualsIgnoreCase = false;
            try {
                try {
                    long j = this.start;
                    String strSha1 = kssAccessor.sha1(j, this.end - j);
                    if (strSha1 != null) {
                        zEqualsIgnoreCase = strSha1.equalsIgnoreCase(this.sha1);
                    }
                } catch (Exception e) {
                    Log.w(LoadMap.LOG_TAG, "Meet exception when verify sha1.", e);
                }
                return zEqualsIgnoreCase;
            } finally {
                kssAccessor.unlock();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized Space[] getAllSpaces() {
            ArrayList<Space> arrayList;
            arrayList = this.spaces;
            return (Space[]) arrayList.toArray(new Space[arrayList.size()]);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized void reset() {
            this.verifyState = VerifyState.NOT_VERIFY;
            this.spaces.clear();
            this.spaces.add(LoadMap.this.new Space(this, this.start, this.end));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized long size() {
            long size;
            Iterator<Space> it = this.spaces.iterator();
            size = 0;
            while (it.hasNext()) {
                size += it.next().size();
            }
            return size;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized boolean tryMerge(Space space) {
            if (space.size() <= 0) {
                this.spaces.remove(space);
                return true;
            }
            for (Space space2 : this.spaces) {
                if (space2 != space && space2.tryMerge(space)) {
                    return true;
                }
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized boolean verify(KssAccessor kssAccessor, boolean z) throws IOException {
            boolean z_verify;
            VerifyState verifyState = this.verifyState;
            VerifyState verifyState2 = VerifyState.NOT_VERIFY;
            if (verifyState == verifyState2 && size() <= 0 && this.verifyFailCount < 2) {
                this.verifyState = VerifyState.VERIFING;
                try {
                    z_verify = _verify(kssAccessor);
                    if (!z_verify) {
                        if (z) {
                            try {
                                this.verifyFailCount++;
                            } catch (Throwable th) {
                                th = th;
                                if (z_verify) {
                                    this.verifyState = VerifyState.VERIFIED;
                                } else {
                                    this.verifyState = VerifyState.NOT_VERIFY;
                                }
                                throw th;
                            }
                        }
                        if (this.verifyFailCount >= 2) {
                            throw new IOException("Sha1 verify failed more than MAX_VERIFY_COUNT");
                        }
                    }
                    if (z_verify) {
                        this.verifyState = VerifyState.VERIFIED;
                    } else {
                        this.verifyState = verifyState2;
                    }
                    return z_verify;
                } catch (Throwable th2) {
                    th = th2;
                    z_verify = false;
                }
            }
            return true;
        }

        public boolean isVerified() {
            return this.verifyState == VerifyState.VERIFIED;
        }

        public synchronized void setSpaces(long[] jArr) {
            this.spaces.clear();
            this.verifyState = VerifyState.NOT_VERIFY;
            if (jArr == null || jArr.length % 2 != 0) {
                this.spaces.add(LoadMap.this.new Space(this, this.start, this.end));
            }
            int length = jArr.length / 2;
            for (int i = 0; i < length; i++) {
                int i2 = i * 2;
                this.spaces.add(LoadMap.this.new Space(this, jArr[i2], jArr[i2 + 1]));
            }
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Block(");
            sb.append(this.start);
            sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
            sb.append(this.end);
            sb.append("):");
            if (this.spaces.isEmpty()) {
                sb.append(this.verifyState);
            } else {
                sb.append(Arrays.toString(this.spaces.toArray()));
            }
            return sb.toString();
        }
    }

    public class Space {
        private final BlockSpace block;
        private long end;
        private long start;

        public Space(BlockSpace blockSpace, long j, long j2) {
            if (j2 < j) {
                throw new IndexOutOfBoundsException();
            }
            this.block = blockSpace;
            this.start = j;
            this.end = j2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Space halve() {
            long j = this.start;
            long j2 = this.end;
            long j3 = j + ((j2 - j) / 2);
            if (j3 % 1024 > 0) {
                j3 = ((j3 / 1024) + 1) * 1024;
            }
            Space space = LoadMap.this.new Space(this.block, j3, j2);
            this.block.spaces.add(this);
            this.end = j3;
            return space;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean tryMerge() {
            return this.block.tryMerge(this);
        }

        public long getStart() {
            return this.start;
        }

        public void remove(int i) {
            synchronized (this.block) {
                this.start = Math.min(this.start + ((long) i), this.end);
            }
        }

        public long size() {
            long j;
            synchronized (this.block) {
                j = this.end - this.start;
            }
            return j;
        }

        public String toString() {
            return this.start + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.end;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean tryMerge(Space space) {
            if (space.start != this.end) {
                return false;
            }
            this.end = space.end;
            return true;
        }
    }

    public enum VerifyState {
        NOT_VERIFY,
        VERIFING,
        VERIFIED
    }

    public LoadMap(IKssDownloadRequestResult iKssDownloadRequestResult, IKscTransferListener iKscTransferListener) {
        int blockCount = iKssDownloadRequestResult.getBlockCount();
        this.mBlocks = new BlockSpace[blockCount];
        int i = 0;
        for (int i2 = 0; i2 < blockCount; i2++) {
            IKssDownloadRequestResult.Block block = iKssDownloadRequestResult.getBlock(i2);
            long j = i;
            BlockSpace blockSpace = new BlockSpace(block, j);
            this.mBlocks[i2] = blockSpace;
            this.mEmptySpaces.addAll(Arrays.asList(blockSpace.getAllSpaces()));
            i = (int) (j + block.size);
        }
        this.mListener = iKscTransferListener;
        if (iKscTransferListener != null) {
            iKscTransferListener.setReceiveTotal(iKssDownloadRequestResult.getTotalSize());
        }
    }

    private Space allocEmptySpace() {
        long j = -1;
        int i = -1;
        for (int i2 = 0; i2 < this.mEmptySpaces.size(); i2++) {
            long size = this.mEmptySpaces.get(i2).size();
            if (j < size) {
                i = i2;
                j = size;
            }
        }
        if (i >= 0) {
            return this.mEmptySpaces.remove(i);
        }
        return null;
    }

    private Space findMaxInUsedSpace() {
        long j = -1;
        Space space = null;
        for (Space space2 : this.mRecorders.keySet()) {
            long size = space2.size();
            if (j < size) {
                space = space2;
                j = size;
            }
        }
        return space;
    }

    public long getBlockStart(long j) {
        long j2;
        if (j < 0) {
            throw new IndexOutOfBoundsException();
        }
        BlockSpace[] blockSpaceArr = this.mBlocks;
        int length = blockSpaceArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                j2 = -1;
                break;
            }
            BlockSpace blockSpace = blockSpaceArr[i];
            if (j >= blockSpace.start && j < blockSpace.end) {
                j2 = blockSpace.start;
                break;
            }
            i++;
        }
        if (j2 >= 0) {
            return j2;
        }
        throw new IndexOutOfBoundsException();
    }

    public long getSpaceSize() {
        long size = 0;
        for (BlockSpace blockSpace : this.mBlocks) {
            size += blockSpace.size();
        }
        return size;
    }

    public void initSize(long j) {
        synchronized (this) {
            int length = this.mBlocks.length;
            this.mEmptySpaces.clear();
            IKscTransferListener iKscTransferListener = this.mListener;
            if (iKscTransferListener != null) {
                iKscTransferListener.setReceivePos(0L);
            }
            int i = 0;
            for (int i2 = 0; i2 < length; i2++) {
                BlockSpace blockSpace = this.mBlocks[i2];
                blockSpace.reset();
                long j2 = i;
                long size = blockSpace.size() + j2;
                if (j >= size) {
                    blockSpace.setSpaces(new long[0]);
                    IKscTransferListener iKscTransferListener2 = this.mListener;
                    if (iKscTransferListener2 != null) {
                        iKscTransferListener2.received(blockSpace.end - blockSpace.start);
                    }
                } else {
                    blockSpace.setSpaces(new long[]{j2, size});
                }
                this.mEmptySpaces.addAll(Arrays.asList(blockSpace.getAllSpaces()));
                i = (int) size;
            }
        }
    }

    public boolean isCompleted() {
        for (BlockSpace blockSpace : this.mBlocks) {
            if (blockSpace.size() > 0 || !blockSpace.isVerified()) {
                return false;
            }
        }
        return true;
    }

    public boolean load(Bundle bundle) {
        int i;
        if (bundle == null) {
            return false;
        }
        try {
            ArrayList parcelableArrayList = bundle.getParcelableArrayList("blocks");
            int size = parcelableArrayList.size();
            if (size != this.mBlocks.length) {
                Log.w(LOG_TAG, "Block count is wrong in kinfo, ignore saved map");
                return false;
            }
            for (0; i < size; i + 1) {
                Bundle bundle2 = (Bundle) parcelableArrayList.get(i);
                long j = bundle2.getLong(KEY_BLOCK_START);
                long j2 = bundle2.getLong(KEY_BLOCK_END);
                BlockSpace blockSpace = this.mBlocks[i];
                i = (blockSpace.start == j && blockSpace.end == j2) ? i + 1 : 0;
                Log.w(LOG_TAG, "Block start/ends is wrong in kinfo, ignore saved map");
                return false;
            }
            synchronized (this) {
                this.mEmptySpaces.clear();
                IKscTransferListener iKscTransferListener = this.mListener;
                if (iKscTransferListener != null) {
                    iKscTransferListener.setReceivePos(0L);
                }
                long size2 = 0;
                for (int i2 = 0; i2 < size; i2++) {
                    Bundle bundle3 = (Bundle) parcelableArrayList.get(i2);
                    BlockSpace blockSpace2 = this.mBlocks[i2];
                    blockSpace2.reset();
                    blockSpace2.setSpaces(bundle3.getLongArray(KEY_SPACE));
                    this.mEmptySpaces.addAll(Arrays.asList(blockSpace2.getAllSpaces()));
                    if (this.mListener != null) {
                        size2 += (blockSpace2.end - blockSpace2.start) - blockSpace2.size();
                    }
                }
                IKscTransferListener iKscTransferListener2 = this.mListener;
                if (iKscTransferListener2 != null && size2 != 0) {
                    iKscTransferListener2.received(size2);
                }
            }
            return true;
        } catch (Throwable unused) {
            Log.w(LOG_TAG, "Meet exception Block count is wrony in kinfo, ignore saved map");
            return false;
        }
    }

    public synchronized LoadRecorder obtainRecorder() {
        Space spaceAllocEmptySpace = allocEmptySpace();
        if (spaceAllocEmptySpace != null) {
            LoadRecorder loadRecorder = new LoadRecorder(this, spaceAllocEmptySpace);
            this.mRecorders.put(spaceAllocEmptySpace, loadRecorder);
            return loadRecorder;
        }
        Space spaceFindMaxInUsedSpace = findMaxInUsedSpace();
        if (spaceFindMaxInUsedSpace != null && spaceFindMaxInUsedSpace.size() > PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) {
            Space spaceHalve = spaceFindMaxInUsedSpace.halve();
            LoadRecorder loadRecorder2 = new LoadRecorder(this, spaceHalve);
            this.mRecorders.put(spaceHalve, loadRecorder2);
            return loadRecorder2;
        }
        return null;
    }

    public void onSpaceRemoved(int i) {
        IKscTransferListener iKscTransferListener = this.mListener;
        if (iKscTransferListener != null) {
            iKscTransferListener.received(i);
        }
    }

    public synchronized void recycleRecorder(LoadRecorder loadRecorder) {
        Space space = loadRecorder.getSpace();
        if (this.mRecorders.remove(space) == null) {
            return;
        }
        if (space.tryMerge()) {
            return;
        }
        this.mEmptySpaces.add(space);
    }

    public void resetBlock(int i) {
        if (i >= 0) {
            BlockSpace[] blockSpaceArr = this.mBlocks;
            if (i < blockSpaceArr.length) {
                BlockSpace blockSpace = blockSpaceArr[i];
                synchronized (blockSpace) {
                    for (Space space : blockSpace.getAllSpaces()) {
                        LoadRecorder loadRecorderRemove = this.mRecorders.remove(space);
                        if (loadRecorderRemove != null) {
                            loadRecorderRemove.recycle();
                        }
                        this.mEmptySpaces.remove(space);
                    }
                    blockSpace.reset();
                    this.mEmptySpaces.addAll(Arrays.asList(blockSpace.getAllSpaces()));
                }
                return;
            }
        }
        throw new IndexOutOfBoundsException();
    }

    public void save(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        int length = this.mBlocks.length;
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>(length);
        for (int i = 0; i < length; i++) {
            BlockSpace blockSpace = this.mBlocks[i];
            Bundle bundle2 = new Bundle();
            bundle2.putLong(KEY_BLOCK_START, blockSpace.start);
            bundle2.putLong(KEY_BLOCK_END, blockSpace.end);
            ArrayList arrayList2 = blockSpace.spaces;
            int size = arrayList2.size();
            long[] jArr = new long[size * 2];
            for (int i2 = 0; i2 < size; i2++) {
                Space space = (Space) arrayList2.get(i2);
                int i3 = i2 * 2;
                jArr[i3] = space.start;
                jArr[i3 + 1] = space.end;
            }
            bundle2.putLongArray(KEY_SPACE, jArr);
            arrayList.add(bundle2);
        }
        bundle.putParcelableArrayList("blocks", arrayList);
    }

    public String toString() {
        return Arrays.toString(this.mBlocks);
    }

    public void verify(KssAccessor kssAccessor, boolean z) throws IOException {
        int i = 0;
        while (true) {
            BlockSpace[] blockSpaceArr = this.mBlocks;
            if (i >= blockSpaceArr.length) {
                return;
            }
            BlockSpace blockSpace = blockSpaceArr[i];
            if (!blockSpace.verify(kssAccessor, z)) {
                resetBlock(i);
                IKscTransferListener iKscTransferListener = this.mListener;
                if (iKscTransferListener != null) {
                    iKscTransferListener.received(blockSpace.start - blockSpace.end);
                }
            }
            i++;
        }
    }
}
