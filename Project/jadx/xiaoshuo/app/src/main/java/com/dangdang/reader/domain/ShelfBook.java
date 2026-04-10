package com.dangdang.reader.domain;

import com.dangdang.zframework.network.download.DownloadConstant;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes10.dex */
public class ShelfBook extends ShelfBaseBook {
    private static Set<String> selectedBooks = new HashSet();
    private static final long serialVersionUID = 1;
    private String audioAuthor;
    private long borrowEndTime;
    private boolean channelHall;
    private long getNewChapterTime;
    private boolean isDown;
    private boolean isFollow;
    private boolean isImport;
    private boolean isPreload;
    private boolean isSelect;
    private boolean isSplitEPub;
    private boolean isUpdate;
    public int isValid;
    private int localLastIndexOrder;
    private String mAuthType;
    private String mBookDir;
    private int mBookFinish;
    private byte[] mBookKey;
    private BookType mBookType;
    private long mBorrowStartTime;
    private long mBorrowTotalTime;
    private long mDeadline;
    private DownloadConstant.Status mDownloadStatus;
    private int mGroupId;
    private boolean mIsOthers;
    private long mLastTime;
    private MonthlyPaymentType mMonthlyPaymentType;
    private int mOverDue;
    private String mReadProgress;
    private String mTotalTime;
    private TryOrFull mTryOrFull;
    private String parentCategoryIds;
    private int serverLastIndexOrder;
    private int subscriptionCount;
    private String virtualGroupId;
    private boolean mCanBorrow = true;
    private int mStealPercent = 100;
    private int progress = -1;

    public enum BookType {
        BOOK_TYPE_IS_FULL_NO(0),
        BOOK_TYPE_IS_FULL_YES(1),
        BOOK_TYPE_IS_COMICS_FULL_NO(2),
        BOOK_TYPE_IS_COMICS_FULL_YES(3),
        BOOK_TYPE_IS_LISTEN(4),
        BOOK_TYPE_NOT_NOVEL(Integer.MAX_VALUE);

        private int mCode;

        BookType(int i) {
            this.mCode = i;
        }

        public int getValue() {
            return this.mCode;
        }

        public static BookType valueOf(int i) {
            return i != 0 ? i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != Integer.MAX_VALUE ? BOOK_TYPE_NOT_NOVEL : BOOK_TYPE_NOT_NOVEL : BOOK_TYPE_IS_LISTEN : BOOK_TYPE_IS_COMICS_FULL_YES : BOOK_TYPE_IS_COMICS_FULL_NO : BOOK_TYPE_IS_FULL_YES : BOOK_TYPE_IS_FULL_NO;
        }
    }

    public enum MonthlyPaymentType {
        DEFAULT_VALUE,
        ALL;

        public static MonthlyPaymentType valueOf(int i) {
            return i != 1 ? DEFAULT_VALUE : ALL;
        }
    }

    public enum TryOrFull {
        INNER_TRY(1),
        TRY(1),
        FULL(200),
        INNER_FULL(200),
        LIMIT_TIME_FULL(100),
        MONTH_FULL(100),
        GIFT_FULL(200),
        COMPANY_VIP(100),
        LISTEN_MONTHLY(100),
        CHAPTER_BUY(10),
        VIP(100),
        FREE_GET(1);

        private int permissionLevel;

        TryOrFull(int i) {
            this.permissionLevel = i;
        }

        public int compareLevel(TryOrFull tryOrFull) {
            return this.permissionLevel - tryOrFull.permissionLevel;
        }

        public static TryOrFull valueOf(int i) {
            switch (i) {
                case 0:
                    return INNER_TRY;
                case 1:
                    return TRY;
                case 2:
                    return FULL;
                case 3:
                    return INNER_FULL;
                case 4:
                    return LIMIT_TIME_FULL;
                case 5:
                    return MONTH_FULL;
                case 6:
                    return GIFT_FULL;
                case 7:
                    return COMPANY_VIP;
                case 8:
                    return LISTEN_MONTHLY;
                case 9:
                    return CHAPTER_BUY;
                case 10:
                    return VIP;
                case 11:
                    return FREE_GET;
                default:
                    return FULL;
            }
        }
    }

    public static Set<String> getSelectedBooks() {
        return selectedBooks;
    }

    public boolean canBorrow() {
        return this.mCanBorrow;
    }

    public String getAudioAuthor() {
        return this.audioAuthor;
    }

    public String getAuthorityType() {
        return this.mAuthType;
    }

    public String getBookDir() {
        return this.mBookDir;
    }

    public int getBookFinish() {
        return this.mBookFinish;
    }

    public byte[] getBookKey() {
        return this.mBookKey;
    }

    public BookType getBookType() {
        return this.mBookType;
    }

    public long getBorrowEndTime() {
        return this.borrowEndTime;
    }

    public long getBorrowStartTime() {
        return this.mBorrowStartTime;
    }

    public long getBorrowTotalTime() {
        return this.mBorrowTotalTime;
    }

    public long getDeadline() {
        return this.mDeadline;
    }

    public DownloadConstant.Status getDownloadStatus() {
        return this.mDownloadStatus;
    }

    public long getGetNewChapterTime() {
        return this.getNewChapterTime;
    }

    public int getGroupId() {
        return this.mGroupId;
    }

    public boolean getIsOthers() {
        return this.mIsOthers;
    }

    public long getLastTime() {
        return this.mLastTime;
    }

    public int getLocalLastIndexOrder() {
        return this.localLastIndexOrder;
    }

    public MonthlyPaymentType getMonthlyPaymentType() {
        return this.mMonthlyPaymentType;
    }

    public int getOverDue() {
        return this.mOverDue;
    }

    public String getParentCategoryIds() {
        return this.parentCategoryIds;
    }

    public int getProgress() {
        return this.progress;
    }

    public String getReadProgress() {
        return this.mReadProgress;
    }

    public int getServerLastIndexOrder() {
        return this.serverLastIndexOrder;
    }

    public int getStealPercent() {
        return this.mStealPercent;
    }

    public int getSubscriptionCount() {
        return this.subscriptionCount;
    }

    public String getTotalTime() {
        return this.mTotalTime;
    }

    public TryOrFull getTryOrFull() {
        return this.mTryOrFull;
    }

    public String getVirtualGroupId() {
        return this.virtualGroupId;
    }

    public boolean hasNewChapter() {
        return this.subscriptionCount > 0;
    }

    public boolean isChannelHall() {
        return this.channelHall;
    }

    public boolean isDown() {
        return this.isDown;
    }

    public boolean isDownloading() {
        if (getDownloadStatus() == null || getBookFinish() == 1) {
            return false;
        }
        return getDownloadStatus() == DownloadConstant.Status.DOWNLOADING || getDownloadStatus() == DownloadConstant.Status.PENDING || getDownloadStatus() == DownloadConstant.Status.RESUME || getDownloadStatus() == DownloadConstant.Status.WAIT;
    }

    public boolean isFollow() {
        return this.isFollow;
    }

    public boolean isImport() {
        return this.isImport;
    }

    public boolean isPreload() {
        return this.isPreload;
    }

    public boolean isSelect() {
        return this.isSelect;
    }

    public boolean isSplitEPub() {
        return this.isSplitEPub;
    }

    public boolean isUpdate() {
        return this.isUpdate;
    }

    public void setAudioAuthor(String str) {
        this.audioAuthor = str;
    }

    public void setAuthorityType(String str) {
        this.mAuthType = str;
    }

    public void setBookDir(String str) {
        this.mBookDir = str;
    }

    public void setBookFinish(int i) {
        this.mBookFinish = i;
    }

    public void setBookKey(byte[] bArr) {
        this.mBookKey = bArr;
    }

    public void setBookType(BookType bookType) {
        this.mBookType = bookType;
    }

    public void setBorrowEndTime(long j) {
        this.borrowEndTime = j;
    }

    public void setBorrowStartTime(long j) {
        this.mBorrowStartTime = j;
    }

    public void setBorrowTotalTime(long j) {
        this.mBorrowTotalTime = j;
    }

    public void setCanBorrow(boolean z) {
        this.mCanBorrow = z;
    }

    public void setChannelHall(boolean z) {
        this.channelHall = z;
    }

    public void setDeadline(long j) {
        this.mDeadline = j;
    }

    public void setDown(boolean z) {
        this.isDown = z;
    }

    public void setDownloadStatus(DownloadConstant.Status status) {
        this.mDownloadStatus = status;
    }

    public void setFollow(boolean z) {
        this.isFollow = z;
    }

    public void setGetNewChapterTime(long j) {
        this.getNewChapterTime = j;
    }

    public void setGroupId(int i) {
        this.mGroupId = i;
    }

    public void setImport(boolean z) {
        this.isImport = z;
    }

    public void setIsOthers(boolean z) {
        this.mIsOthers = z;
    }

    public void setLastTime(long j) {
        this.mLastTime = j;
    }

    public void setLocalLastIndexOrder(int i) {
        this.localLastIndexOrder = i;
    }

    public void setMonthlyPaymentType(MonthlyPaymentType monthlyPaymentType) {
        this.mMonthlyPaymentType = monthlyPaymentType;
    }

    public void setOverDue(int i) {
        this.mOverDue = i;
    }

    public void setParentCategoryIds(String str) {
        this.parentCategoryIds = str;
    }

    public void setPreload(boolean z) {
        this.isPreload = z;
    }

    public void setProgress(int i) {
        this.progress = i;
    }

    public void setReadProgress(String str) {
        this.mReadProgress = str;
    }

    public void setSelect(boolean z) {
        this.isSelect = z;
        if (z) {
            selectedBooks.add(getMediaId());
        } else {
            selectedBooks.remove(getMediaId());
        }
    }

    public void setServerLastIndexOrder(int i) {
        this.serverLastIndexOrder = i;
    }

    public void setSplitEPub(boolean z) {
        this.isSplitEPub = z;
    }

    public void setStealPercent(int i) {
        this.mStealPercent = i;
    }

    public void setSubscriptionCount(int i) {
        this.subscriptionCount = i;
    }

    public void setTotalTime(String str) {
        this.mTotalTime = str;
    }

    public void setTryOrFull(TryOrFull tryOrFull) {
        this.mTryOrFull = tryOrFull;
    }

    public void setUpdate(boolean z) {
        this.isUpdate = z;
    }

    public void setVirtualGroupId(String str) {
        this.virtualGroupId = str;
    }

    public boolean thisCanPresent() {
        return (BookType.BOOK_TYPE_IS_FULL_YES == getBookType() || BookType.BOOK_TYPE_IS_COMICS_FULL_YES == getBookType()) ? TryOrFull.GIFT_FULL != getTryOrFull() && "1".equals(getAuthorityType()) : BookType.BOOK_TYPE_NOT_NOVEL == getBookType() && TryOrFull.GIFT_FULL != getTryOrFull();
    }
}
