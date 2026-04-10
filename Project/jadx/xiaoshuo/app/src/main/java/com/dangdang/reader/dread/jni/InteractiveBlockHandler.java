package com.dangdang.reader.dread.jni;

import android.graphics.Rect;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes10.dex */
public class InteractiveBlockHandler {
    int mCount;
    List<InteractiveBlock> mInteractiveBlockList = new ArrayList();

    public class InteractiveBlock {
        private Rect mIconRect;
        private int mIndex;
        private InteractiveBlockType mType;

        public InteractiveBlock() {
        }

        public Rect getIconRect() {
            return this.mIconRect;
        }

        public int getIndex() {
            return this.mIndex;
        }

        public InteractiveBlockType getType() {
            return this.mType;
        }

        public void setIconRect(Rect rect) {
            this.mIconRect = rect;
        }

        public void setIndex(int i) {
            this.mIndex = i;
        }

        public void setType(InteractiveBlockType interactiveBlockType) {
            this.mType = interactiveBlockType;
        }
    }

    public enum InteractiveBlockType {
        type_code,
        type_table
    }

    public int getInteractiveBlockCount() {
        return this.mCount;
    }

    public List<InteractiveBlock> getInteractiveBlockList() {
        return this.mInteractiveBlockList;
    }

    public void setInteractiveBlockCount(int i) {
        this.mCount = i;
    }

    public void setInteractiveBlockInfo(int i, int i2, int i3, int i4, int i5, int i6) {
        InteractiveBlock interactiveBlock = new InteractiveBlock();
        Rect rect = new Rect();
        rect.set(i, i2, i3, i4);
        if (i5 == 1) {
            interactiveBlock.setType(InteractiveBlockType.type_table);
        } else if (i5 == 2) {
            interactiveBlock.setType(InteractiveBlockType.type_code);
        }
        interactiveBlock.setIndex(i6);
        interactiveBlock.setIconRect(rect);
        this.mInteractiveBlockList.add(interactiveBlock);
    }
}
