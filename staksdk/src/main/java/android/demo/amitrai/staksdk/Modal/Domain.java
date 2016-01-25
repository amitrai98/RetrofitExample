
package android.demo.amitrai.staksdk.Modal;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Domain {

    @SerializedName("_id")
    @Expose
    private String Id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("headerTextColor")
    @Expose
    private String headerTextColor;
    @SerializedName("iconColor")
    @Expose
    private String iconColor;
    @SerializedName("headerColor")
    @Expose
    private String headerColor;

    /**
     * 
     * @return
     *     The Id
     */
    public String getId() {
        return Id;
    }

    /**
     * 
     * @param Id
     *     The _id
     */
    public void setId(String Id) {
        this.Id = Id;
    }

    /**
     * 
     * @return
     *     The name
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name
     *     The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * @return
     *     The headerTextColor
     */
    public String getHeaderTextColor() {
        return headerTextColor;
    }

    /**
     * 
     * @param headerTextColor
     *     The headerTextColor
     */
    public void setHeaderTextColor(String headerTextColor) {
        this.headerTextColor = headerTextColor;
    }

    /**
     * 
     * @return
     *     The iconColor
     */
    public String getIconColor() {
        return iconColor;
    }

    /**
     * 
     * @param iconColor
     *     The iconColor
     */
    public void setIconColor(String iconColor) {
        this.iconColor = iconColor;
    }

    /**
     * 
     * @return
     *     The headerColor
     */
    public String getHeaderColor() {
        return headerColor;
    }

    /**
     * 
     * @param headerColor
     *     The headerColor
     */
    public void setHeaderColor(String headerColor) {
        this.headerColor = headerColor;
    }

}
