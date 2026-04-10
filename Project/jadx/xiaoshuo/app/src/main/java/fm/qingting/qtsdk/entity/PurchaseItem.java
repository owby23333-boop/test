package fm.qingting.qtsdk.entity;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes8.dex */
public class PurchaseItem {

    @SerializedName("item_id")
    private String mItemId;

    @SerializedName("item_type")
    private String mItemType;

    @SerializedName("price")
    private Double mPrice;

    public String getItemId() {
        return this.mItemId;
    }

    public String getItemType() {
        return this.mItemType;
    }

    public Double getPrice() {
        return this.mPrice;
    }

    public void setItemId(String itemId) {
        this.mItemId = itemId;
    }

    public void setItemType(String itemType) {
        this.mItemType = itemType;
    }

    public void setPrice(Double price) {
        this.mPrice = price;
    }
}
