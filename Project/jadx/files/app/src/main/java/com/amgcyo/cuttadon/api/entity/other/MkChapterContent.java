package com.amgcyo.cuttadon.api.entity.other;

import androidx.room.Ignore;
import com.amgcyo.cuttadon.api.entity.adbean.NormalAdParams;
import com.amgcyo.cuttadon.api.entity.config.BaseAd;
import com.chad.library.adapter.base.d.b;
import java.io.Serializable;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public class MkChapterContent implements Serializable, b {

    @Ignore
    public static final int AD = 1;

    @Ignore
    public static final int DATA_LIST = 2;

    @Ignore
    public static final int DATA_REWARD = 3;
    private transient NormalAdParams adParams;
    private BaseAd baseAdBean;
    private String cacheFilePath;
    private int catalogId;
    private String content;
    private List<String> contentStrList;
    private String error_msg;
    private boolean is_content;
    private boolean is_encrypt;

    @Ignore
    private int itemType;
    private String name;
    private int num_words;
    private boolean onErrorReturn;
    private String path;
    private Slippage slippage;

    public MkChapterContent(boolean z2, int i2, int i3, String str, String str2) {
        this.is_content = true;
        this.onErrorReturn = z2;
        this.itemType = i2;
        this.catalogId = i3;
        this.name = str;
        this.path = str2;
    }

    public NormalAdParams getAdParams() {
        return this.adParams;
    }

    public BaseAd getBaseAdBean() {
        return this.baseAdBean;
    }

    public String getCacheFilePath() {
        return this.cacheFilePath;
    }

    public int getCatalogId() {
        return this.catalogId;
    }

    public String getContent() {
        return this.content;
    }

    public List<String> getContentStrList() {
        return this.contentStrList;
    }

    public String getError_msg() {
        return this.error_msg;
    }

    @Override // com.chad.library.adapter.base.d.b
    public int getItemType() {
        return this.itemType;
    }

    public String getName() {
        return this.name;
    }

    public int getNum_words() {
        return this.num_words;
    }

    public String getPath() {
        return this.path;
    }

    public Slippage getSlippage() {
        return this.slippage;
    }

    public boolean isIs_content() {
        return this.is_content;
    }

    public boolean isIs_encrypt() {
        return this.is_encrypt;
    }

    public boolean isOnErrorReturn() {
        return this.onErrorReturn;
    }

    public void setAdParams(NormalAdParams normalAdParams) {
        this.adParams = normalAdParams;
    }

    public void setBaseAdBean(BaseAd baseAd) {
        this.baseAdBean = baseAd;
    }

    public void setCacheFilePath(String str) {
        this.cacheFilePath = str;
    }

    public void setCatalogId(int i2) {
        this.catalogId = i2;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setContentStrList(List<String> list) {
        this.contentStrList = list;
    }

    public void setError_msg(String str) {
        this.error_msg = str;
    }

    public void setIs_content(boolean z2) {
        this.is_content = z2;
    }

    public void setIs_encrypt(boolean z2) {
        this.is_encrypt = z2;
    }

    public void setItemType(int i2) {
        this.itemType = i2;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setNum_words(int i2) {
        this.num_words = i2;
    }

    public void setOnErrorReturn(boolean z2) {
        this.onErrorReturn = z2;
    }

    public void setPath(String str) {
        this.path = str;
    }

    public void setSlippage(Slippage slippage) {
        this.slippage = slippage;
    }

    @NotNull
    public String toString() {
        return "MkChapterContent{, name='" + this.name + "', num_words=" + this.num_words + ", is_encrypt=" + this.is_encrypt + ", catalogId='" + this.catalogId + "'}";
    }

    public MkChapterContent(String str, String str2) {
        this.is_content = true;
        this.cacheFilePath = str;
        this.name = str2;
    }

    public MkChapterContent(int i2) {
        this.is_content = true;
        this.itemType = i2;
    }

    public MkChapterContent(int i2, NormalAdParams normalAdParams) {
        this.is_content = true;
        this.itemType = i2;
        this.adParams = normalAdParams;
    }

    public MkChapterContent(String str, int i2, String str2) {
        this.is_content = true;
        this.cacheFilePath = str;
        this.catalogId = i2;
        this.name = str2;
    }

    public MkChapterContent(String str, int i2, String str2, boolean z2) {
        this.is_content = true;
        this.cacheFilePath = str;
        this.catalogId = i2;
        this.name = str2;
        this.is_content = z2;
    }
}
