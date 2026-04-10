package com.amgcyo.cuttadon.api.entity.comic;

import com.amgcyo.cuttadon.api.entity.adbean.NormalAdParams;
import com.chad.library.adapter.base.d.b;
import com.tencent.smtt.sdk.TbsMediaPlayer;
import java.io.File;
import java.io.Serializable;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public class ComicChapter implements Serializable, b {
    public static final int AD = 1;
    public static final int DATA_LIST = 2;
    public static final int DATA_REWARD = 3;
    private NormalAdParams adParams;
    private String book_img;
    private File cacheFile;
    private String chapter_path;
    private int count;
    private List<DanmakuContent> danmakuContents;
    private String encrypt_info;
    private int encrypt_type;
    private int height;
    private int id;
    private String image_type;
    private int index;
    private boolean is_content;
    private int itemType;
    private int ownerChapterIndex;
    private String ownerChapterPath;
    private String path;
    private int state;
    private String tempName;
    private String tips;
    private long updated_at;
    private int width;
    private ZymkChapter zymkChapter;

    public ComicChapter(int i2) {
        this.itemType = 2;
        this.itemType = i2;
    }

    public NormalAdParams getAdParams() {
        return this.adParams;
    }

    public String getBook_img() {
        return this.book_img;
    }

    public File getCacheFile() {
        return this.cacheFile;
    }

    public String getChapter_path() {
        return this.chapter_path;
    }

    public int getCount() {
        return this.count;
    }

    public List<DanmakuContent> getDanmakuContents() {
        return this.danmakuContents;
    }

    public String getEncrypt_info() {
        return this.encrypt_info;
    }

    public int getEncrypt_type() {
        return this.encrypt_type;
    }

    public int getHeight() {
        return this.height;
    }

    public int getId() {
        return this.id;
    }

    public String getImage_type() {
        return this.image_type;
    }

    public int getIndex() {
        return this.index;
    }

    @Override // com.chad.library.adapter.base.d.b
    public int getItemType() {
        return this.itemType;
    }

    public int getOwnerChapterIndex() {
        return this.ownerChapterIndex;
    }

    public String getOwnerChapterPath() {
        return this.ownerChapterPath;
    }

    public String getPath() {
        return this.path;
    }

    public long getSize() {
        return this.height * this.width;
    }

    public int getState() {
        return this.state;
    }

    public String getTempName() {
        return this.tempName;
    }

    public String getTips() {
        return this.tips;
    }

    public long getUpdated_at() {
        return this.updated_at;
    }

    public int getWidth() {
        if (this.width <= 0) {
            this.width = TbsMediaPlayer.TbsMediaPlayerListener.MEDIA_INFO_BAD_INTERLEAVING;
        }
        return this.width;
    }

    public ZymkChapter getZymkChapter() {
        return this.zymkChapter;
    }

    public boolean isIs_content() {
        return this.is_content;
    }

    public void setAdParams(NormalAdParams normalAdParams) {
        this.adParams = normalAdParams;
    }

    public void setBook_img(String str) {
        this.book_img = str;
    }

    public void setCacheFile(File file) {
        this.cacheFile = file;
    }

    public void setChapter_path(String str) {
        this.chapter_path = str;
    }

    public void setCount(int i2) {
        this.count = i2;
    }

    public void setDanmakuContents(List<DanmakuContent> list) {
        this.danmakuContents = list;
    }

    public void setEncrypt_info(String str) {
        this.encrypt_info = str;
    }

    public void setEncrypt_type(int i2) {
        this.encrypt_type = i2;
    }

    public void setHeight(int i2) {
        this.height = i2;
    }

    public void setId(int i2) {
        this.id = i2;
    }

    public void setImage_type(String str) {
        this.image_type = str;
    }

    public void setIndex(int i2) {
        this.index = i2;
    }

    public void setIs_content(boolean z2) {
        this.is_content = z2;
    }

    public void setItemType(int i2) {
        this.itemType = i2;
    }

    public void setOwnerChapterIndex(int i2) {
        this.ownerChapterIndex = i2;
    }

    public void setOwnerChapterPath(String str) {
        this.ownerChapterPath = str;
    }

    public void setPath(String str) {
        this.path = str;
    }

    public void setState(int i2) {
        this.state = i2;
    }

    public void setTempName(String str) {
        this.tempName = str;
    }

    public void setTips(String str) {
        this.tips = str;
    }

    public void setUpdated_at(long j2) {
        this.updated_at = j2;
    }

    public void setWidth(int i2) {
        this.width = i2;
    }

    public void setZymkChapter(ZymkChapter zymkChapter) {
        this.zymkChapter = zymkChapter;
    }

    @NotNull
    public String toString() {
        return "ComicChapter{id=" + this.id + ", encrypt_type=" + this.encrypt_type + ", encrypt_info='" + this.encrypt_info + "', path='" + this.path + "', image_type='" + this.image_type + "', width=" + this.width + ", height=" + this.height + ", cacheFile=" + this.cacheFile + ", index=" + this.index + ", tempName='" + this.tempName + "', count=" + this.count + ", ownerChapterIndex=" + this.ownerChapterIndex + ", is_content=" + this.is_content + ", ownerChapterPath='" + this.ownerChapterPath + "', updated_at=" + this.updated_at + ", state=" + this.state + ", chapter_path='" + this.chapter_path + "', itemType=" + this.itemType + ", danmakuContents=" + this.danmakuContents + '}';
    }

    public ComicChapter() {
        this.itemType = 2;
    }

    public ComicChapter(int i2, int i3, String str, NormalAdParams normalAdParams) {
        this.itemType = 2;
        this.itemType = i2;
        this.adParams = normalAdParams;
        this.index = i3;
        this.tempName = str;
    }

    public ComicChapter(int i2, int i3, int i4, String str, NormalAdParams normalAdParams) {
        this.itemType = 2;
        this.itemType = i2;
        this.adParams = normalAdParams;
        this.index = i3;
        this.count = i4;
        this.tempName = str;
    }

    public ComicChapter(int i2, int i3, String str, String str2, String str3, ZymkChapter zymkChapter, NormalAdParams normalAdParams) {
        this.itemType = 2;
        this.itemType = i2;
        this.book_img = str;
        this.count = i3;
        this.tips = str2;
        this.tempName = str3;
        this.adParams = normalAdParams;
        this.zymkChapter = zymkChapter;
    }
}
