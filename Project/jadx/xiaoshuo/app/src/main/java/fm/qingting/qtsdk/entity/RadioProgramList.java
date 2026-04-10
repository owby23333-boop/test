package fm.qingting.qtsdk.entity;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public class RadioProgramList extends QTEntity {

    @SerializedName("6")
    List<RadioProgram> FridayList;

    @SerializedName("2")
    List<RadioProgram> MondayList;

    @SerializedName("7")
    List<RadioProgram> SaturdayList;

    @SerializedName("1")
    List<RadioProgram> SundayList;

    @SerializedName("5")
    List<RadioProgram> ThursdayList;

    @SerializedName("3")
    List<RadioProgram> TuesdayList;

    @SerializedName("4")
    List<RadioProgram> WednesdayList;

    public List<RadioProgram> getFridayList() {
        return this.FridayList;
    }

    public List<RadioProgram> getMondayList() {
        return this.MondayList;
    }

    public List<RadioProgram> getSaturdayList() {
        return this.SaturdayList;
    }

    public List<RadioProgram> getSundayList() {
        return this.SundayList;
    }

    public List<RadioProgram> getThursdayList() {
        return this.ThursdayList;
    }

    public List<RadioProgram> getTuesdayList() {
        return this.TuesdayList;
    }

    public List<RadioProgram> getWednesdayList() {
        return this.WednesdayList;
    }

    public void setFridayList(List<RadioProgram> fridayList) {
        this.FridayList = fridayList;
    }

    public void setMondayList(List<RadioProgram> mondayList) {
        this.MondayList = mondayList;
    }

    public void setSaturdayList(List<RadioProgram> saturdayList) {
        this.SaturdayList = saturdayList;
    }

    public void setSundayList(List<RadioProgram> sundayList) {
        this.SundayList = sundayList;
    }

    public void setThursdayList(List<RadioProgram> thursdayList) {
        this.ThursdayList = thursdayList;
    }

    public void setTuesdayList(List<RadioProgram> tuesdayList) {
        this.TuesdayList = tuesdayList;
    }

    public void setWednesdayList(List<RadioProgram> wednesdayList) {
        this.WednesdayList = wednesdayList;
    }
}
