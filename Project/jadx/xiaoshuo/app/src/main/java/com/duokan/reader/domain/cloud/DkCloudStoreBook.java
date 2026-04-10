package com.duokan.reader.domain.cloud;

import android.text.TextUtils;
import com.duokan.reader.domain.store.DkStoreBookSourceType;
import java.text.Collator;

/* JADX INFO: loaded from: classes3.dex */
public abstract class DkCloudStoreBook extends DkCloudBook {
    protected static final String[][] FALLBACK_LABELS = {new String[]{"其他", ""}};

    public DkCloudStoreBook(String str) {
        super(str);
    }

    public int compareNameTo(Collator collator, DkCloudStoreBook dkCloudStoreBook) {
        int iCompare = collator.compare(getTitle(), dkCloudStoreBook.getTitle());
        if (iCompare < 0) {
            return -1;
        }
        if (iCompare > 0) {
            return 1;
        }
        if (TextUtils.equals(getBookUuid(), dkCloudStoreBook.getBookUuid())) {
            return 0;
        }
        return getBookUuid().compareTo(dkCloudStoreBook.getBookUuid()) < 0 ? -1 : 1;
    }

    public int comparePurchaseTimeTo(DkCloudStoreBook dkCloudStoreBook) {
        if (getPurchaseTimeInSeconds() < dkCloudStoreBook.getPurchaseTimeInSeconds()) {
            return -1;
        }
        if (getPurchaseTimeInSeconds() > dkCloudStoreBook.getPurchaseTimeInSeconds()) {
            return 1;
        }
        if (TextUtils.equals(getBookUuid(), dkCloudStoreBook.getBookUuid())) {
            return 0;
        }
        return getBookUuid().compareTo(dkCloudStoreBook.getBookUuid()) < 0 ? -1 : 1;
    }

    public int compareUpdateTimeTo(DkCloudStoreBook dkCloudStoreBook) {
        if (getUpdateTimeInSeconds() < dkCloudStoreBook.getUpdateTimeInSeconds()) {
            return -1;
        }
        if (getUpdateTimeInSeconds() > dkCloudStoreBook.getUpdateTimeInSeconds()) {
            return 1;
        }
        if (TextUtils.equals(getBookUuid(), dkCloudStoreBook.getBookUuid())) {
            return 0;
        }
        return getBookUuid().compareTo(dkCloudStoreBook.getBookUuid()) < 0 ? -1 : 1;
    }

    public abstract String getAuthorLine();

    public abstract DkStoreBookSourceType getBookSourceType();

    public abstract String getCoverUri();

    public abstract String getEditorLine();

    public abstract String[][] getLabels();

    public abstract long getPurchaseTimeInSeconds();

    public abstract long getUpdateTimeInSeconds();

    public int labelLevels(String[] strArr) {
        if (strArr == null) {
            return 0;
        }
        for (int i = 0; i < strArr.length; i++) {
            if (strArr[i] == null) {
                return i;
            }
        }
        return strArr.length;
    }

    public DkCloudStoreBook(DkCloudStoreBook dkCloudStoreBook) {
        super(dkCloudStoreBook);
    }
}
