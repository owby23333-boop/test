package androidx.recyclerview.widget;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class DiffUtil {
    private static final Comparator<Diagonal> DIAGONAL_COMPARATOR = new Comparator<Diagonal>() { // from class: androidx.recyclerview.widget.DiffUtil.1
        @Override // java.util.Comparator
        public int compare(Diagonal diagonal, Diagonal diagonal2) {
            return diagonal.f170x - diagonal2.f170x;
        }
    };

    public static abstract class Callback {
        public abstract boolean areContentsTheSame(int i2, int i3);

        public abstract boolean areItemsTheSame(int i2, int i3);

        @Nullable
        public Object getChangePayload(int i2, int i3) {
            return null;
        }

        public abstract int getNewListSize();

        public abstract int getOldListSize();
    }

    static class CenteredArray {
        private final int[] mData;
        private final int mMid;

        CenteredArray(int i2) {
            this.mData = new int[i2];
            this.mMid = this.mData.length / 2;
        }

        int[] backingData() {
            return this.mData;
        }

        public void fill(int i2) {
            Arrays.fill(this.mData, i2);
        }

        int get(int i2) {
            return this.mData[i2 + this.mMid];
        }

        void set(int i2, int i3) {
            this.mData[i2 + this.mMid] = i3;
        }
    }

    static class Diagonal {
        public final int size;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public final int f170x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public final int f171y;

        Diagonal(int i2, int i3, int i4) {
            this.f170x = i2;
            this.f171y = i3;
            this.size = i4;
        }

        int endX() {
            return this.f170x + this.size;
        }

        int endY() {
            return this.f171y + this.size;
        }
    }

    public static class DiffResult {
        private static final int FLAG_CHANGED = 2;
        private static final int FLAG_MASK = 15;
        private static final int FLAG_MOVED = 12;
        private static final int FLAG_MOVED_CHANGED = 4;
        private static final int FLAG_MOVED_NOT_CHANGED = 8;
        private static final int FLAG_NOT_CHANGED = 1;
        private static final int FLAG_OFFSET = 4;
        public static final int NO_POSITION = -1;
        private final Callback mCallback;
        private final boolean mDetectMoves;
        private final List<Diagonal> mDiagonals;
        private final int[] mNewItemStatuses;
        private final int mNewListSize;
        private final int[] mOldItemStatuses;
        private final int mOldListSize;

        DiffResult(Callback callback, List<Diagonal> list, int[] iArr, int[] iArr2, boolean z2) {
            this.mDiagonals = list;
            this.mOldItemStatuses = iArr;
            this.mNewItemStatuses = iArr2;
            Arrays.fill(this.mOldItemStatuses, 0);
            Arrays.fill(this.mNewItemStatuses, 0);
            this.mCallback = callback;
            this.mOldListSize = callback.getOldListSize();
            this.mNewListSize = callback.getNewListSize();
            this.mDetectMoves = z2;
            addEdgeDiagonals();
            findMatchingItems();
        }

        private void addEdgeDiagonals() {
            Diagonal diagonal = this.mDiagonals.isEmpty() ? null : this.mDiagonals.get(0);
            if (diagonal == null || diagonal.f170x != 0 || diagonal.f171y != 0) {
                this.mDiagonals.add(0, new Diagonal(0, 0, 0));
            }
            this.mDiagonals.add(new Diagonal(this.mOldListSize, this.mNewListSize, 0));
        }

        private void findMatchingAddition(int i2) {
            int size = this.mDiagonals.size();
            int iEndY = 0;
            for (int i3 = 0; i3 < size; i3++) {
                Diagonal diagonal = this.mDiagonals.get(i3);
                while (iEndY < diagonal.f171y) {
                    if (this.mNewItemStatuses[iEndY] == 0 && this.mCallback.areItemsTheSame(i2, iEndY)) {
                        int i4 = this.mCallback.areContentsTheSame(i2, iEndY) ? 8 : 4;
                        this.mOldItemStatuses[i2] = (iEndY << 4) | i4;
                        this.mNewItemStatuses[iEndY] = (i2 << 4) | i4;
                        return;
                    }
                    iEndY++;
                }
                iEndY = diagonal.endY();
            }
        }

        private void findMatchingItems() {
            for (Diagonal diagonal : this.mDiagonals) {
                for (int i2 = 0; i2 < diagonal.size; i2++) {
                    int i3 = diagonal.f170x + i2;
                    int i4 = diagonal.f171y + i2;
                    int i5 = this.mCallback.areContentsTheSame(i3, i4) ? 1 : 2;
                    this.mOldItemStatuses[i3] = (i4 << 4) | i5;
                    this.mNewItemStatuses[i4] = (i3 << 4) | i5;
                }
            }
            if (this.mDetectMoves) {
                findMoveMatches();
            }
        }

        private void findMoveMatches() {
            int iEndX = 0;
            for (Diagonal diagonal : this.mDiagonals) {
                while (iEndX < diagonal.f170x) {
                    if (this.mOldItemStatuses[iEndX] == 0) {
                        findMatchingAddition(iEndX);
                    }
                    iEndX++;
                }
                iEndX = diagonal.endX();
            }
        }

        @Nullable
        private static PostponedUpdate getPostponedUpdate(Collection<PostponedUpdate> collection, int i2, boolean z2) {
            PostponedUpdate next;
            Iterator<PostponedUpdate> it = collection.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (next.posInOwnerList == i2 && next.removal == z2) {
                    it.remove();
                    break;
                }
            }
            while (it.hasNext()) {
                PostponedUpdate next2 = it.next();
                if (z2) {
                    next2.currentPos--;
                } else {
                    next2.currentPos++;
                }
            }
            return next;
        }

        public int convertNewPositionToOld(@IntRange(from = 0) int i2) {
            if (i2 >= 0 && i2 < this.mNewListSize) {
                int i3 = this.mNewItemStatuses[i2];
                if ((i3 & 15) == 0) {
                    return -1;
                }
                return i3 >> 4;
            }
            throw new IndexOutOfBoundsException("Index out of bounds - passed position = " + i2 + ", new list size = " + this.mNewListSize);
        }

        public int convertOldPositionToNew(@IntRange(from = 0) int i2) {
            if (i2 >= 0 && i2 < this.mOldListSize) {
                int i3 = this.mOldItemStatuses[i2];
                if ((i3 & 15) == 0) {
                    return -1;
                }
                return i3 >> 4;
            }
            throw new IndexOutOfBoundsException("Index out of bounds - passed position = " + i2 + ", old list size = " + this.mOldListSize);
        }

        public void dispatchUpdatesTo(@NonNull RecyclerView.Adapter adapter) {
            dispatchUpdatesTo(new AdapterListUpdateCallback(adapter));
        }

        public void dispatchUpdatesTo(@NonNull ListUpdateCallback listUpdateCallback) {
            int i2;
            BatchingListUpdateCallback batchingListUpdateCallback = listUpdateCallback instanceof BatchingListUpdateCallback ? (BatchingListUpdateCallback) listUpdateCallback : new BatchingListUpdateCallback(listUpdateCallback);
            int i3 = this.mOldListSize;
            ArrayDeque arrayDeque = new ArrayDeque();
            int i4 = this.mOldListSize;
            int i5 = this.mNewListSize;
            for (int size = this.mDiagonals.size() - 1; size >= 0; size--) {
                Diagonal diagonal = this.mDiagonals.get(size);
                int iEndX = diagonal.endX();
                int iEndY = diagonal.endY();
                while (true) {
                    if (i4 <= iEndX) {
                        break;
                    }
                    i4--;
                    int i6 = this.mOldItemStatuses[i4];
                    if ((i6 & 12) != 0) {
                        int i7 = i6 >> 4;
                        PostponedUpdate postponedUpdate = getPostponedUpdate(arrayDeque, i7, false);
                        if (postponedUpdate != null) {
                            int i8 = (i3 - postponedUpdate.currentPos) - 1;
                            batchingListUpdateCallback.onMoved(i4, i8);
                            if ((i6 & 4) != 0) {
                                batchingListUpdateCallback.onChanged(i8, 1, this.mCallback.getChangePayload(i4, i7));
                            }
                        } else {
                            arrayDeque.add(new PostponedUpdate(i4, (i3 - i4) - 1, true));
                        }
                    } else {
                        batchingListUpdateCallback.onRemoved(i4, 1);
                        i3--;
                    }
                }
                while (i5 > iEndY) {
                    i5--;
                    int i9 = this.mNewItemStatuses[i5];
                    if ((i9 & 12) != 0) {
                        int i10 = i9 >> 4;
                        PostponedUpdate postponedUpdate2 = getPostponedUpdate(arrayDeque, i10, true);
                        if (postponedUpdate2 == null) {
                            arrayDeque.add(new PostponedUpdate(i5, i3 - i4, false));
                        } else {
                            batchingListUpdateCallback.onMoved((i3 - postponedUpdate2.currentPos) - 1, i4);
                            if ((i9 & 4) != 0) {
                                batchingListUpdateCallback.onChanged(i4, 1, this.mCallback.getChangePayload(i10, i5));
                            }
                        }
                    } else {
                        batchingListUpdateCallback.onInserted(i4, 1);
                        i3++;
                    }
                }
                int i11 = diagonal.f170x;
                int i12 = diagonal.f171y;
                for (i2 = 0; i2 < diagonal.size; i2++) {
                    if ((this.mOldItemStatuses[i11] & 15) == 2) {
                        batchingListUpdateCallback.onChanged(i11, 1, this.mCallback.getChangePayload(i11, i12));
                    }
                    i11++;
                    i12++;
                }
                i4 = diagonal.f170x;
                i5 = diagonal.f171y;
            }
            batchingListUpdateCallback.dispatchLastEvent();
        }
    }

    public static abstract class ItemCallback<T> {
        public abstract boolean areContentsTheSame(@NonNull T t2, @NonNull T t3);

        public abstract boolean areItemsTheSame(@NonNull T t2, @NonNull T t3);

        @Nullable
        public Object getChangePayload(@NonNull T t2, @NonNull T t3) {
            return null;
        }
    }

    private static class PostponedUpdate {
        int currentPos;
        int posInOwnerList;
        boolean removal;

        PostponedUpdate(int i2, int i3, boolean z2) {
            this.posInOwnerList = i2;
            this.currentPos = i3;
            this.removal = z2;
        }
    }

    static class Range {
        int newListEnd;
        int newListStart;
        int oldListEnd;
        int oldListStart;

        public Range() {
        }

        int newSize() {
            return this.newListEnd - this.newListStart;
        }

        int oldSize() {
            return this.oldListEnd - this.oldListStart;
        }

        public Range(int i2, int i3, int i4, int i5) {
            this.oldListStart = i2;
            this.oldListEnd = i3;
            this.newListStart = i4;
            this.newListEnd = i5;
        }
    }

    static class Snake {
        public int endX;
        public int endY;
        public boolean reverse;
        public int startX;
        public int startY;

        Snake() {
        }

        int diagonalSize() {
            return Math.min(this.endX - this.startX, this.endY - this.startY);
        }

        boolean hasAdditionOrRemoval() {
            return this.endY - this.startY != this.endX - this.startX;
        }

        boolean isAddition() {
            return this.endY - this.startY > this.endX - this.startX;
        }

        @NonNull
        Diagonal toDiagonal() {
            if (hasAdditionOrRemoval()) {
                return this.reverse ? new Diagonal(this.startX, this.startY, diagonalSize()) : isAddition() ? new Diagonal(this.startX, this.startY + 1, diagonalSize()) : new Diagonal(this.startX + 1, this.startY, diagonalSize());
            }
            int i2 = this.startX;
            return new Diagonal(i2, this.startY, this.endX - i2);
        }
    }

    private DiffUtil() {
    }

    @Nullable
    private static Snake backward(Range range, Callback callback, CenteredArray centeredArray, CenteredArray centeredArray2, int i2) {
        int i3;
        int i4;
        int i5;
        boolean z2 = (range.oldSize() - range.newSize()) % 2 == 0;
        int iOldSize = range.oldSize() - range.newSize();
        int i6 = -i2;
        for (int i7 = i6; i7 <= i2; i7 += 2) {
            if (i7 == i6 || (i7 != i2 && centeredArray2.get(i7 + 1) < centeredArray2.get(i7 - 1))) {
                i3 = centeredArray2.get(i7 + 1);
                i4 = i3;
            } else {
                int i8 = centeredArray2.get(i7 - 1);
                i4 = i8;
                i3 = i8 - 1;
            }
            int i9 = range.newListEnd - ((range.oldListEnd - i3) - i7);
            int i10 = (i2 == 0 || i3 != i4) ? i9 : i9 + 1;
            while (i3 > range.oldListStart && i9 > range.newListStart) {
                if (!callback.areItemsTheSame(i3 - 1, i9 - 1)) {
                    break;
                }
                i3--;
                i9--;
            }
            centeredArray2.set(i7, i3);
            if (z2 && (i5 = iOldSize - i7) >= i6 && i5 <= i2) {
                if (centeredArray.get(i5) >= i3) {
                    Snake snake = new Snake();
                    snake.startX = i3;
                    snake.startY = i9;
                    snake.endX = i4;
                    snake.endY = i10;
                    snake.reverse = true;
                    return snake;
                }
            }
        }
        return null;
    }

    @NonNull
    public static DiffResult calculateDiff(@NonNull Callback callback) {
        return calculateDiff(callback, true);
    }

    @Nullable
    private static Snake forward(Range range, Callback callback, CenteredArray centeredArray, CenteredArray centeredArray2, int i2) {
        int i3;
        int i4;
        int i5;
        boolean z2 = Math.abs(range.oldSize() - range.newSize()) % 2 == 1;
        int iOldSize = range.oldSize() - range.newSize();
        int i6 = -i2;
        for (int i7 = i6; i7 <= i2; i7 += 2) {
            if (i7 == i6 || (i7 != i2 && centeredArray.get(i7 + 1) > centeredArray.get(i7 - 1))) {
                i3 = centeredArray.get(i7 + 1);
                i4 = i3;
            } else {
                int i8 = centeredArray.get(i7 - 1);
                i4 = i8;
                i3 = i8 + 1;
            }
            int i9 = (range.newListStart + (i3 - range.oldListStart)) - i7;
            int i10 = (i2 == 0 || i3 != i4) ? i9 : i9 - 1;
            while (i3 < range.oldListEnd && i9 < range.newListEnd) {
                if (!callback.areItemsTheSame(i3, i9)) {
                    break;
                }
                i3++;
                i9++;
            }
            centeredArray.set(i7, i3);
            if (z2 && (i5 = iOldSize - i7) >= i6 + 1 && i5 <= i2 - 1) {
                if (centeredArray2.get(i5) <= i3) {
                    Snake snake = new Snake();
                    snake.startX = i4;
                    snake.startY = i10;
                    snake.endX = i3;
                    snake.endY = i9;
                    snake.reverse = false;
                    return snake;
                }
            }
        }
        return null;
    }

    @Nullable
    private static Snake midPoint(Range range, Callback callback, CenteredArray centeredArray, CenteredArray centeredArray2) {
        if (range.oldSize() >= 1 && range.newSize() >= 1) {
            int iOldSize = ((range.oldSize() + range.newSize()) + 1) / 2;
            centeredArray.set(1, range.oldListStart);
            centeredArray2.set(1, range.oldListEnd);
            for (int i2 = 0; i2 < iOldSize; i2++) {
                Snake snakeForward = forward(range, callback, centeredArray, centeredArray2, i2);
                if (snakeForward != null) {
                    return snakeForward;
                }
                Snake snakeBackward = backward(range, callback, centeredArray, centeredArray2, i2);
                if (snakeBackward != null) {
                    return snakeBackward;
                }
            }
        }
        return null;
    }

    @NonNull
    public static DiffResult calculateDiff(@NonNull Callback callback, boolean z2) {
        int oldListSize = callback.getOldListSize();
        int newListSize = callback.getNewListSize();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new Range(0, oldListSize, 0, newListSize));
        int i2 = ((((oldListSize + newListSize) + 1) / 2) * 2) + 1;
        CenteredArray centeredArray = new CenteredArray(i2);
        CenteredArray centeredArray2 = new CenteredArray(i2);
        ArrayList arrayList3 = new ArrayList();
        while (!arrayList2.isEmpty()) {
            Range range = (Range) arrayList2.remove(arrayList2.size() - 1);
            Snake snakeMidPoint = midPoint(range, callback, centeredArray, centeredArray2);
            if (snakeMidPoint != null) {
                if (snakeMidPoint.diagonalSize() > 0) {
                    arrayList.add(snakeMidPoint.toDiagonal());
                }
                Range range2 = arrayList3.isEmpty() ? new Range() : (Range) arrayList3.remove(arrayList3.size() - 1);
                range2.oldListStart = range.oldListStart;
                range2.newListStart = range.newListStart;
                range2.oldListEnd = snakeMidPoint.startX;
                range2.newListEnd = snakeMidPoint.startY;
                arrayList2.add(range2);
                range.oldListEnd = range.oldListEnd;
                range.newListEnd = range.newListEnd;
                range.oldListStart = snakeMidPoint.endX;
                range.newListStart = snakeMidPoint.endY;
                arrayList2.add(range);
            } else {
                arrayList3.add(range);
            }
        }
        Collections.sort(arrayList, DIAGONAL_COMPARATOR);
        return new DiffResult(callback, arrayList, centeredArray.backingData(), centeredArray2.backingData(), z2);
    }
}
