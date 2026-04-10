package com.dangdang.reader.dread.data;

import android.text.TextUtils;
import android.util.Base64;
import com.dangdang.common.PubReadConstant;
import com.dangdang.reader.domain.ShelfBook;
import com.dangdang.reader.dread.format.BaseReadInfo;
import com.dangdang.reader.dread.format.Book;
import com.dangdang.reader.dread.jni.EpubWrap;
import com.dangdang.reader.format.Chapter;
import com.dangdang.reader.utils.DReaderConstants;
import com.dangdang.zframework.log.LogM;
import java.io.File;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public class ReadInfo extends BaseReadInfo {
    public static final int BSTATUS_FULL = 1;
    public static final int BSTATUS_TRY = 0;
    private static final String JSONK_EPUBVERSION = "epubversion";
    private static final String JSONK_INDEXINHTML = "elementindex";
    private static final String JSONK_PROGRESS_OPERATETIME = "progress_operatetime";
    private static final String JSONK_READPLAN_FINISH_RATE = "readplan_finish_rate";
    private static final String JSONK_READPLAN_READING_CHAPTER = "readplan_reading_chapter";
    private static final String JSONK_READPLAN_READING_ELEMENT = "readplan_reading_element";
    private static final String JSONK_READPLAN_RECORD_TIME = "readplan_record_time";
    private static final String JSONK_READPLAN_START_CHAPTER = "readplan_start_chapter";
    private static final String JSONK_READPLAN_START_ELEMENT = "readplan_start_element";
    private static final String JSONK_READPLAN_TARGET_RATE = "readplan_target_rate";
    private static final String JSONK_READ_AUTOBUY_CHECKED = "read_autobuy_checked";
    private static final String JSONK_READ_AUTOBUY_HASSET = "read_autobuy_hasset";
    private static final String JSONK_READ_DIR_REVERSE = "read_dir_reverse";
    private static final String JSONK_UNZIP_STATUSINT = "unzipstatus";
    private static final String JSONK_VERSION_TIME = "versiontime";
    private String avUrlSpEpubDownload;
    private byte[] bookCertKey;
    private List<Chapter> chapterList;
    private int elementIndex;
    private String htmlUrlSpEpubDownload;
    private String internetBookCover;
    private boolean isBigVipUser;
    private int kernelComsVersion;
    private int kernelVersion;
    private int[] mBeforeChapterReadCount;
    private String mBookCover;
    private String mBookJson;
    private float mDayFinishRate;
    private int mDayReadEndChapterIndex;
    private int mDayReadEndElementIndex;
    private boolean mHasSetAutoBuy;
    private boolean mIsEPubSplitRead;
    private boolean mIsLandScape;
    private boolean mIsOthers;
    private boolean mIsReverseDir;
    private boolean mIsUseGoldBellOnly;
    private float mProcessRateToday;
    private int mReadCountPerSample;
    private long mReadPlanClientRecordTime;
    private String mRelatedMediaId;
    private float mTodayCoverageRate;
    private float mTotalFinishRate;
    private int mTotalWeighedReadCount;
    private int mTrainingStatus;
    private int mTryOrFull;
    private List<Book.BaseNavPoint> navPointList;
    private String picUrlSpEpubDownload;
    private int prevChapterIndex;
    private int prevElementIndex;
    private long prevOperateTime;
    private Chapter readChapter;
    private String userId;
    private String bookDesc = "";
    private String authorName = "";
    private int chapterIndex = 0;
    private boolean hasLocalProgress = false;
    private String epubVersion = "";
    private String epubModVersion = DReaderConstants.BOOK_MODIFY_VERSION;
    private int unZipStatusToInt = -2;
    private long operateTime = 0;
    private long versionTime = 0;
    private byte[] bookStructDatas = null;
    private int mTryReadEndChapterIndex = -1;
    private int mTryReadEndElementIndex = -1;
    private float mTryReadRate = 0.3f;
    private int mPlanType = 0;
    private int mDayReadStartChapterIndex = 0;
    private int mDayReadStartElementIndex = 0;
    private float mDayReadRate = 0.1f;
    private int mDayReadCurChapterIndex = -1;
    private int mDayReadCurElementIndex = -1;
    private float mImageWeight = 2.0f;
    private byte[] mTotalReadCoverage = new byte[125];
    private byte[] mReadCoverage = new byte[125];
    private String mTrainingId = "mTrainingId";
    private boolean mIsAutobuyChecked = true;
    private boolean mIsShowAllBtns = true;

    public static class EpubStatus {
        public static final int S_DEFAULT = -2;
        public static final int S_FAILED = -1;
        public static final int S_SUCCESS = 1;
    }

    public static boolean isFullBook(int i) {
        return 1 == i;
    }

    public static boolean isTryBook(int i) {
        return i == 0;
    }

    private void printLog(String str) {
        LogM.i(getClass().getSimpleName(), "" + str);
    }

    public void addOneSample(int i) {
        if (i >= 1000 || i < 0) {
            return;
        }
        int i2 = i / 8;
        byte b2 = (byte) (1 << (7 - (i % 8)));
        byte[] bArr = this.mReadCoverage;
        bArr[i2] = (byte) (bArr[i2] | b2);
        byte[] bArr2 = this.mTotalReadCoverage;
        bArr2[i2] = (byte) (b2 | bArr2[i2]);
    }

    public String buildProgressInfo(boolean z) {
        String progressInfo = getProgressInfo();
        try {
            JSONObject jSONObject = TextUtils.isEmpty(progressInfo) ? new JSONObject() : new JSONObject(progressInfo);
            jSONObject.put(PubReadConstant.JSONK_HTMLINDEX, this.chapterIndex);
            if (z) {
                jSONObject.put(PubReadConstant.JSONK_PAGEINDEX, this.chapterIndex);
                jSONObject.put(PubReadConstant.JSONK_PDFREFLOW_STATUS, 1);
            }
            jSONObject.put("elementindex", this.elementIndex);
            jSONObject.put(JSONK_EPUBVERSION, this.epubVersion);
            jSONObject.put("kernel_version", this.kernelVersion);
            jSONObject.put(PubReadConstant.JSONK_KERNEL_COMPOSVERSION, this.kernelComsVersion);
            jSONObject.put(JSONK_UNZIP_STATUSINT, this.unZipStatusToInt);
            jSONObject.put("progress", getProgressFloat());
            jSONObject.put(JSONK_VERSION_TIME, this.versionTime);
            jSONObject.put(JSONK_PROGRESS_OPERATETIME, this.operateTime);
            jSONObject.put(JSONK_READ_DIR_REVERSE, this.mIsReverseDir);
            jSONObject.put(JSONK_READ_AUTOBUY_CHECKED, this.mIsAutobuyChecked);
            jSONObject.put(JSONK_READ_AUTOBUY_HASSET, this.mHasSetAutoBuy);
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return progressInfo;
        }
    }

    public float calcReadCoverRage() {
        int i = 0;
        for (int i2 = 0; i2 < 125; i2++) {
            byte b2 = this.mReadCoverage[i2];
            for (int i3 = 0; i3 < 8; i3++) {
                if ((((byte) (1 << i3)) & b2) != 0) {
                    i++;
                }
            }
        }
        return i / 1000.0f;
    }

    public float calcTodayReadCoverRage(int i, int i2) {
        if (i >= 1000 || i < 0 || i2 < 0) {
            return 0.0f;
        }
        if (i2 >= 1000) {
            i2 = 999;
        }
        int i3 = i / 8;
        int i4 = i % 8;
        int i5 = i2 / 8;
        int i6 = i2 % 8;
        int i7 = 0;
        if (i3 == i2) {
            byte b2 = (byte) (this.mTotalReadCoverage[i3] & ((byte) (255 >> i4)));
            while (i4 <= i6) {
                if ((((byte) (1 << (7 - i4))) & b2) != 0) {
                    i7++;
                }
                i4++;
            }
        } else {
            byte b3 = (byte) (((byte) (255 >> i4)) & this.mTotalReadCoverage[i3]);
            int i8 = 0;
            while (i4 < 8) {
                if ((((byte) (1 << (7 - i4))) & b3) != 0) {
                    i8++;
                }
                i4++;
            }
            while (true) {
                i3++;
                if (i3 > i5 - 1) {
                    break;
                }
                byte b4 = this.mTotalReadCoverage[i3];
                for (int i9 = 0; i9 < 8; i9++) {
                    if ((((byte) (1 << i9)) & b4) != 0) {
                        i8++;
                    }
                }
            }
            byte b5 = this.mTotalReadCoverage[i5];
            while (i7 <= i6) {
                if ((((byte) (1 << (7 - i7))) & b5) != 0) {
                    i8++;
                }
                i7++;
            }
            i7 = i8;
        }
        return i7 / ((i2 - i) + 1);
    }

    public boolean calcTryReadEndIndex() {
        int i;
        if (this.mBeforeChapterReadCount == null || (i = this.mTotalWeighedReadCount) <= 0) {
            setTryReadEndChapterIndex(2);
            setTryReadEndElementIndex(0);
            return false;
        }
        int i2 = (int) (i * this.mTryReadRate);
        int i3 = 1;
        while (true) {
            int[] iArr = this.mBeforeChapterReadCount;
            if (i3 >= iArr.length) {
                break;
            }
            if (iArr[i3] > i2) {
                int i4 = i3 - 1;
                setTryReadEndChapterIndex(i4);
                setTryReadEndElementIndex(i2 - this.mBeforeChapterReadCount[i4]);
                break;
            }
            i3++;
        }
        return true;
    }

    public boolean checkTryReadRange() {
        return this.mIsEPubSplitRead;
    }

    public boolean convertData(ShelfBook shelfBook, boolean z) {
        if (shelfBook == null) {
            return false;
        }
        this.userId = shelfBook.getUserId();
        this.bookCertKey = shelfBook.getBookKey();
        parserProgressInfo(shelfBook.getReadProgress(), z);
        setBookStructDatas(shelfBook.getBookStructDatas());
        if (shelfBook.getTryOrFull() != null) {
            this.mTryOrFull = shelfBook.getTryOrFull().ordinal();
        }
        this.mBookCover = shelfBook.getCoverPic();
        this.mBookJson = shelfBook.getBookJson();
        this.mIsOthers = shelfBook.getIsOthers();
        return true;
    }

    public String getAuthorName() {
        return this.authorName;
    }

    @Override // com.dangdang.reader.dread.format.BaseReadInfo
    public String getAvUrlSpEpubDownload() {
        return this.avUrlSpEpubDownload;
    }

    public int getBeforeChapterReadCount(int i) {
        int[] iArr = this.mBeforeChapterReadCount;
        if (iArr == null || i >= iArr.length) {
            return 0;
        }
        return iArr[i];
    }

    public byte[] getBookCertKey() {
        return this.bookCertKey;
    }

    public String getBookCover() {
        return this.mBookCover;
    }

    public String getBookDesc() {
        return this.bookDesc;
    }

    public String getBookJson() {
        return this.mBookJson;
    }

    public byte[] getBookStructDatas() {
        return this.bookStructDatas;
    }

    public int getBookType() {
        return isBoughtToInt();
    }

    public int getChapterIndex() {
        return this.chapterIndex;
    }

    public List<Chapter> getChapterList() {
        return this.chapterList;
    }

    public float getDayFinishRate() {
        return this.mDayFinishRate;
    }

    public int getDayReadCurChapterIndex() {
        return this.mDayReadCurChapterIndex;
    }

    public int getDayReadCurElementIndex() {
        return this.mDayReadCurElementIndex;
    }

    public int getDayReadEndChapterIndex() {
        return this.mDayReadEndChapterIndex;
    }

    public int getDayReadEndElementIndex() {
        return this.mDayReadEndElementIndex;
    }

    public float getDayReadRate() {
        return this.mDayReadRate;
    }

    public int getDayReadStartChapterIndex() {
        return this.mDayReadStartChapterIndex;
    }

    public int getDayReadStartElementIndex() {
        return this.mDayReadStartElementIndex;
    }

    public int getElementIndex() {
        return this.elementIndex;
    }

    public String getEpubModVersion() {
        return this.epubModVersion;
    }

    public String getEpubVersion() {
        return this.epubVersion;
    }

    @Override // com.dangdang.reader.dread.format.BaseReadInfo
    public String getHtmlUrlSpEpubDownload() {
        return this.htmlUrlSpEpubDownload;
    }

    public float getImageWeight() {
        return this.mImageWeight;
    }

    public String getInternetBookCover() {
        return this.internetBookCover;
    }

    public boolean getIsOthers() {
        return this.mIsOthers;
    }

    public int getKernelComsVersion() {
        return this.kernelComsVersion;
    }

    public int getKernelVersion() {
        return this.kernelVersion;
    }

    public List<Book.BaseNavPoint> getNavPointList() {
        return this.navPointList;
    }

    public long getOperateTime() {
        return this.operateTime;
    }

    @Override // com.dangdang.reader.dread.format.BaseReadInfo
    public String getPicUrlSpEpubDownload() {
        return this.picUrlSpEpubDownload;
    }

    public int getPlanType() {
        return this.mPlanType;
    }

    public int getPrevChapterIndex() {
        return this.prevChapterIndex;
    }

    public int getPrevElementIndex() {
        return this.prevElementIndex;
    }

    public long getPrevOperateTime() {
        return this.prevOperateTime;
    }

    public float getProcessRateToday() {
        return this.mProcessRateToday;
    }

    public Chapter getReadChapter() {
        return this.readChapter;
    }

    public int getReadCountPerSample() {
        return this.mReadCountPerSample;
    }

    public String getReadCoverage() {
        return Base64.encodeToString(this.mReadCoverage, 0);
    }

    public String getRelatedMediaId() {
        return this.mRelatedMediaId;
    }

    public float getTodayCoverageRate() {
        return this.mTodayCoverageRate;
    }

    public float getTotalFinishRate() {
        return this.mTotalFinishRate;
    }

    public String getTotalReadCoverage() {
        return Base64.encodeToString(this.mTotalReadCoverage, 0);
    }

    public int getTotalWeighedReadCount() {
        return this.mTotalWeighedReadCount;
    }

    public String getTrainingId() {
        return this.mTrainingId;
    }

    public int getTrainingStatus() {
        return this.mTrainingStatus;
    }

    public int getTryOrFull() {
        return this.mTryOrFull;
    }

    public String getTryOrFullStatisticsString() {
        return this.mIsOthers ? "steal" : "";
    }

    public int getTryReadEndChapterIndex() {
        return this.mTryReadEndChapterIndex;
    }

    public int getTryReadEndElementIndex() {
        return this.mTryReadEndElementIndex;
    }

    public float getTryReadRate() {
        return this.mTryReadRate;
    }

    public String getUserId() {
        return this.userId;
    }

    public long getVersionTime() {
        return this.versionTime;
    }

    public boolean hasCacheChapterList() {
        List<Chapter> list = this.chapterList;
        return list != null && list.size() > 0;
    }

    public boolean hasLocalProgress() {
        return this.hasLocalProgress;
    }

    public void initBeforeChapterReadCount(int i) {
        int[] iArr = this.mBeforeChapterReadCount;
        if ((iArr == null || iArr.length != i) && i > 0) {
            this.mBeforeChapterReadCount = new int[i];
        }
    }

    public void initChapterIndexAndElementIndex(int i, int i2) {
        this.chapterIndex = i;
        this.elementIndex = i2;
    }

    public boolean isAutobuyChecked() {
        return this.mIsAutobuyChecked;
    }

    public boolean isBigVipUser() {
        return this.isBigVipUser;
    }

    public boolean isDDBook() {
        return getProductId().matches("\\d*");
    }

    public boolean isHasSetAutoBuy() {
        return this.mHasSetAutoBuy;
    }

    public boolean isIsEPubSplitRead() {
        return this.mIsEPubSplitRead;
    }

    public boolean isLandScape() {
        return this.mIsLandScape;
    }

    public boolean isReverseDir() {
        return this.mIsReverseDir;
    }

    public boolean isShowAllBtns() {
        return this.mIsShowAllBtns;
    }

    public boolean isTheSameFile(String str, long j) {
        boolean z = true;
        try {
            if (new File(str).length() != j) {
                z = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        printLog(" isTheSameFile = " + z);
        return z;
    }

    public boolean isUnZipDefaultStatus() {
        return this.unZipStatusToInt == -2;
    }

    public boolean isUnZipStatus() {
        return this.unZipStatusToInt == 1;
    }

    public boolean isUseGoldBellOnly() {
        return this.mIsUseGoldBellOnly;
    }

    public void mergeReadCoverage(String str) {
        if (str == null) {
            return;
        }
        int i = 0;
        byte[] bArrDecode = Base64.decode(str, 0);
        if (bArrDecode == null) {
            return;
        }
        while (true) {
            byte[] bArr = this.mReadCoverage;
            if (i >= bArr.length || i >= bArrDecode.length) {
                return;
            }
            bArr[i] = (byte) (bArr[i] | bArrDecode[i]);
            i++;
        }
    }

    public void mergeTotalReadCoverage(String str) {
        if (str == null) {
            return;
        }
        int i = 0;
        byte[] bArrDecode = Base64.decode(str, 0);
        if (bArrDecode == null) {
            return;
        }
        while (true) {
            byte[] bArr = this.mTotalReadCoverage;
            if (i >= bArr.length || i >= bArrDecode.length) {
                return;
            }
            bArr[i] = (byte) (bArr[i] | bArrDecode[i]);
            i++;
        }
    }

    public void parserProgressInfo(String str, boolean z) {
        try {
            printLog(str);
            if (str == null) {
                return;
            }
            JSONObject jSONObject = new JSONObject(str);
            setProgressInfo(str);
            this.hasLocalProgress = true;
            this.chapterIndex = jSONObject.optInt(PubReadConstant.JSONK_HTMLINDEX);
            this.elementIndex = jSONObject.optInt("elementindex");
            this.epubVersion = jSONObject.optString(JSONK_EPUBVERSION);
            this.kernelVersion = jSONObject.optInt("kernel_version");
            this.kernelComsVersion = jSONObject.optInt(PubReadConstant.JSONK_KERNEL_COMPOSVERSION);
            this.unZipStatusToInt = jSONObject.optInt(JSONK_UNZIP_STATUSINT, -2);
            this.versionTime = jSONObject.optLong(JSONK_VERSION_TIME);
            this.mIsReverseDir = jSONObject.optBoolean(JSONK_READ_DIR_REVERSE);
            this.mIsAutobuyChecked = jSONObject.optBoolean(JSONK_READ_AUTOBUY_CHECKED, true);
            this.mHasSetAutoBuy = jSONObject.optBoolean(JSONK_READ_AUTOBUY_HASSET, false);
            float fOptDouble = (float) jSONObject.optDouble("progress");
            long jOptLong = jSONObject.optLong(JSONK_PROGRESS_OPERATETIME);
            setProgressFloat(fOptDouble);
            setOperateTime(jOptLong);
            setPrevOperateTime(jOptLong);
            this.prevChapterIndex = this.chapterIndex;
            this.prevElementIndex = this.elementIndex;
        } catch (JSONException unused) {
            LogM.e(getClass().getSimpleName(), " setProgressInfo Exception ");
        }
    }

    public void recalcTryIndex(Book book) {
        if (book != null) {
            Chapter chapter = book.getChapter(getTryReadEndChapterIndex());
            setTryReadEndElementIndex(chapter != null ? new EpubWrap().convertWeightedIndexToIndex(chapter.getPath(), getTryReadEndElementIndex(), getImageWeight()) : 0);
        }
    }

    public void resetProgress() {
        this.chapterIndex = 0;
        this.elementIndex = 0;
        this.epubVersion = "";
        this.unZipStatusToInt = -2;
        setProgressFloat(0.0f);
    }

    public void setAuthorName(String str) {
        this.authorName = str;
    }

    public void setAvUrlSpEpubDownload(String str) {
        this.avUrlSpEpubDownload = str;
    }

    public void setBeforeChapterReadCount(int i, int i2) {
        int[] iArr = this.mBeforeChapterReadCount;
        if (iArr == null || i >= iArr.length) {
            return;
        }
        iArr[i] = i2;
    }

    public void setBigVipUser(boolean z) {
        this.isBigVipUser = z;
    }

    public void setBookCertKey(byte[] bArr) {
        this.bookCertKey = bArr;
    }

    public void setBookDesc(String str) {
        this.bookDesc = str;
    }

    public void setBookStructDatas(byte[] bArr) {
        this.bookStructDatas = bArr;
    }

    public void setChapterIndex(int i) {
        this.chapterIndex = i;
    }

    public void setChapterList(List<Chapter> list) {
        this.chapterList = list;
    }

    public void setDayFinishRate(float f) {
        this.mDayFinishRate = f;
    }

    public void setDayReadCurChapterIndex(int i) {
        this.mDayReadCurChapterIndex = i;
    }

    public void setDayReadCurElementIndex(int i) {
        this.mDayReadCurElementIndex = i;
    }

    public void setDayReadEndChapterIndex(int i) {
        this.mDayReadEndChapterIndex = i;
    }

    public void setDayReadEndElementIndex(int i) {
        this.mDayReadEndElementIndex = i;
    }

    public void setDayReadRate(float f) {
        this.mDayReadRate = f;
    }

    public void setDayReadStartChapterIndex(int i) {
        this.mDayReadStartChapterIndex = i;
    }

    public void setDayReadStartElementIndex(int i) {
        this.mDayReadStartElementIndex = i;
    }

    public void setElementIndex(int i) {
        this.elementIndex = i;
    }

    public void setEpubModVersion(String str) {
        this.epubModVersion = str;
    }

    public void setEpubVersion(String str) {
        this.epubVersion = str;
    }

    public void setHasLocalProgress() {
        this.hasLocalProgress = true;
    }

    public void setHasSetAutoBuy(boolean z) {
        this.mHasSetAutoBuy = z;
    }

    public void setHtmlUrlSpEpubDownload(String str) {
        this.htmlUrlSpEpubDownload = str;
    }

    public void setImageWeight(float f) {
        this.mImageWeight = f;
    }

    public void setInternetBookCover(String str) {
        this.internetBookCover = str;
    }

    public void setIsAutobuyChecked(boolean z) {
        this.mIsAutobuyChecked = z;
    }

    public void setIsEPubSplitRead(boolean z) {
        this.mIsEPubSplitRead = z;
    }

    public void setIsReverseDir(boolean z) {
        this.mIsReverseDir = z;
    }

    public void setIsUseGoldBellOnly(boolean z) {
        this.mIsUseGoldBellOnly = z;
    }

    public void setKernelComsVersion(int i) {
        this.kernelComsVersion = i;
    }

    public void setKernelVersion(int i) {
        this.kernelVersion = i;
    }

    public void setLandScape(boolean z) {
        this.mIsLandScape = z;
    }

    public void setNavPointList(List<Book.BaseNavPoint> list) {
        this.navPointList = list;
    }

    public void setOperateTime(long j) {
        this.operateTime = j;
    }

    public void setPicUrlSpEpubDownload(String str) {
        this.picUrlSpEpubDownload = str;
    }

    public void setPlanType(int i) {
        this.mPlanType = i;
    }

    public void setPrevChapterIndex(int i) {
        this.prevChapterIndex = i;
    }

    public void setPrevElementIndex(int i) {
        this.prevElementIndex = i;
    }

    public void setPrevOperateTime(long j) {
        this.prevOperateTime = j;
    }

    public void setProcessRateToday(float f) {
        this.mProcessRateToday = f;
    }

    public void setReadChapter(Chapter chapter) {
        this.readChapter = chapter;
    }

    public void setReadCountPerSample(int i) {
        this.mReadCountPerSample = i;
    }

    public void setRelatedMediaId(String str) {
        this.mRelatedMediaId = str;
    }

    public void setShowAllBtns(boolean z) {
        this.mIsShowAllBtns = z;
    }

    public void setTodayCoverageRate(float f) {
        this.mTodayCoverageRate = f;
    }

    public void setTotalFinishRate(float f) {
        this.mTotalFinishRate = f;
    }

    public void setTotalWeightedReadCount(int i) {
        this.mTotalWeighedReadCount = i;
    }

    public void setTrainingId(String str) {
        this.mTrainingId = str;
    }

    public void setTrainingStatus(int i) {
        this.mTrainingStatus = i;
    }

    public void setTryOrFull(int i) {
        this.mTryOrFull = i;
    }

    public void setTryReadEndChapterIndex(int i) {
        this.mTryReadEndChapterIndex = i;
    }

    public void setTryReadEndElementIndex(int i) {
        this.mTryReadEndElementIndex = i;
    }

    public void setTryReadRate(float f) {
        this.mTryReadRate = f;
    }

    public void setUnZipStatus(boolean z) {
        this.unZipStatusToInt = z ? 1 : -1;
    }

    public void setUserId(String str) {
        this.userId = str;
    }

    public void setVersionTime(long j) {
        this.versionTime = j;
    }

    public boolean updateMaxReadProgress(int i, int i2) {
        int i3 = this.mDayReadCurChapterIndex;
        if (i3 < i) {
            this.mDayReadCurChapterIndex = i;
            this.mDayReadCurElementIndex = i2;
            return true;
        }
        if (i3 != i || i2 <= this.mDayReadCurElementIndex) {
            return false;
        }
        this.mDayReadCurElementIndex = i2;
        return true;
    }
}
