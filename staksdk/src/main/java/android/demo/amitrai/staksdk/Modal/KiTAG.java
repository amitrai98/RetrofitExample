
package android.demo.amitrai.staksdk.Modal;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class KiTAG {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("keyword")
    @Expose
    private String keyword;
    @SerializedName("domain")
    @Expose
    private String domain;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("kiTAG")
    @Expose
    private String kiTAG;
    @SerializedName("seo")
    @Expose
    private Boolean seo;
    @SerializedName("address")
    @Expose
    private List<Object> address = new ArrayList<Object>();
    @SerializedName("isDomainCard")
    @Expose
    private Boolean isDomainCard;
    @SerializedName("notes")
    @Expose
    private String notes;
    @SerializedName("objects")
    @Expose
    private Objects objects;
    @SerializedName("businessId")
    @Expose
    private String businessId;
    @SerializedName("kiTAGViewId")
    @Expose
    private Object kiTAGViewId;

    /**
     * 
     * @return
     *     The id
     */
    public String getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 
     * @return
     *     The keyword
     */
    public String getKeyword() {
        return keyword;
    }

    /**
     * 
     * @param keyword
     *     The keyword
     */
    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    /**
     * 
     * @return
     *     The domain
     */
    public String getDomain() {
        return domain;
    }

    /**
     * 
     * @param domain
     *     The domain
     */
    public void setDomain(String domain) {
        this.domain = domain;
    }

    /**
     * 
     * @return
     *     The title
     */
    public String getTitle() {
        return title;
    }

    /**
     * 
     * @param title
     *     The title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 
     * @return
     *     The type
     */
    public String getType() {
        return type;
    }

    /**
     * 
     * @param type
     *     The type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 
     * @return
     *     The kiTAG
     */
    public String getKiTAG() {
        return kiTAG;
    }

    /**
     * 
     * @param kiTAG
     *     The kiTAG
     */
    public void setKiTAG(String kiTAG) {
        this.kiTAG = kiTAG;
    }

    /**
     * 
     * @return
     *     The seo
     */
    public Boolean getSeo() {
        return seo;
    }

    /**
     * 
     * @param seo
     *     The seo
     */
    public void setSeo(Boolean seo) {
        this.seo = seo;
    }

    /**
     * 
     * @return
     *     The address
     */
    public List<Object> getAddress() {
        return address;
    }

    /**
     * 
     * @param address
     *     The address
     */
    public void setAddress(List<Object> address) {
        this.address = address;
    }

    /**
     * 
     * @return
     *     The isDomainCard
     */
    public Boolean getIsDomainCard() {
        return isDomainCard;
    }

    /**
     * 
     * @param isDomainCard
     *     The isDomainCard
     */
    public void setIsDomainCard(Boolean isDomainCard) {
        this.isDomainCard = isDomainCard;
    }

    /**
     * 
     * @return
     *     The notes
     */
    public String getNotes() {
        return notes;
    }

    /**
     * 
     * @param notes
     *     The notes
     */
    public void setNotes(String notes) {
        this.notes = notes;
    }

    /**
     * 
     * @return
     *     The objects
     */
    public Objects getObjects() {
        return objects;
    }

    /**
     * 
     * @param objects
     *     The objects
     */
    public void setObjects(Objects objects) {
        this.objects = objects;
    }

    /**
     * 
     * @return
     *     The businessId
     */
    public String getBusinessId() {
        return businessId;
    }

    /**
     * 
     * @param businessId
     *     The businessId
     */
    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }

    /**
     * 
     * @return
     *     The kiTAGViewId
     */
    public Object getKiTAGViewId() {
        return kiTAGViewId;
    }

    /**
     * 
     * @param kiTAGViewId
     *     The kiTAGViewId
     */
    public void setKiTAGViewId(Object kiTAGViewId) {
        this.kiTAGViewId = kiTAGViewId;
    }

}
