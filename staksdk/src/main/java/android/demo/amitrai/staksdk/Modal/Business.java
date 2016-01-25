package android.demo.amitrai.staksdk.Modal;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Business {

    @SerializedName("_id")
    @Expose
    private String Id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("clientId")
    @Expose
    private String clientId;
    @SerializedName("__v")
    @Expose
    private Integer V;
    @SerializedName("logoFilePath")
    @Expose
    private String logoFilePath;
    @SerializedName("businessCategory")
    @Expose
    private String businessCategory;
    @SerializedName("dataChecksum")
    @Expose
    private String dataChecksum;
    @SerializedName("updatedAt")
    @Expose
    private String updatedAt;
    @SerializedName("createdAt")
    @Expose
    private String createdAt;
    @SerializedName("deleted")
    @Expose
    private String deleted;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("contact")
    @Expose
    private List<Contact> contact = new ArrayList<Contact>();
    @SerializedName("address")
    @Expose
    private List<Address> address = new ArrayList<Address>();
    @SerializedName("emailAddress")
    @Expose
    private String emailAddress;
    @SerializedName("primaryURL")
    @Expose
    private String primaryURL;
    @SerializedName("primaryPhone")
    @Expose
    private String primaryPhone;

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
     *     The clientId
     */
    public String getClientId() {
        return clientId;
    }

    /**
     * 
     * @param clientId
     *     The clientId
     */
    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    /**
     * 
     * @return
     *     The V
     */
    public Integer getV() {
        return V;
    }

    /**
     * 
     * @param V
     *     The __v
     */
    public void setV(Integer V) {
        this.V = V;
    }

    /**
     * 
     * @return
     *     The logoFilePath
     */
    public String getLogoFilePath() {
        return logoFilePath;
    }

    /**
     * 
     * @param logoFilePath
     *     The logoFilePath
     */
    public void setLogoFilePath(String logoFilePath) {
        this.logoFilePath = logoFilePath;
    }

    /**
     * 
     * @return
     *     The businessCategory
     */
    public String getBusinessCategory() {
        return businessCategory;
    }

    /**
     * 
     * @param businessCategory
     *     The businessCategory
     */
    public void setBusinessCategory(String businessCategory) {
        this.businessCategory = businessCategory;
    }

    /**
     * 
     * @return
     *     The dataChecksum
     */
    public String getDataChecksum() {
        return dataChecksum;
    }

    /**
     * 
     * @param dataChecksum
     *     The dataChecksum
     */
    public void setDataChecksum(String dataChecksum) {
        this.dataChecksum = dataChecksum;
    }

    /**
     * 
     * @return
     *     The updatedAt
     */
    public String getUpdatedAt() {
        return updatedAt;
    }

    /**
     * 
     * @param updatedAt
     *     The updatedAt
     */
    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    /**
     * 
     * @return
     *     The createdAt
     */
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * 
     * @param createdAt
     *     The createdAt
     */
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * 
     * @return
     *     The deleted
     */
    public String getDeleted() {
        return deleted;
    }

    /**
     * 
     * @param deleted
     *     The deleted
     */
    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }

    /**
     * 
     * @return
     *     The status
     */
    public String getStatus() {
        return status;
    }

    /**
     * 
     * @param status
     *     The status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 
     * @return
     *     The contact
     */
    public List<Contact> getContact() {
        return contact;
    }

    /**
     * 
     * @param contact
     *     The contact
     */
    public void setContact(List<Contact> contact) {
        this.contact = contact;
    }

    /**
     * 
     * @return
     *     The address
     */
    public List<Address> getAddress() {
        return address;
    }

    /**
     * 
     * @param address
     *     The address
     */
    public void setAddress(List<Address> address) {
        this.address = address;
    }

    /**
     * 
     * @return
     *     The emailAddress
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * 
     * @param emailAddress
     *     The emailAddress
     */
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    /**
     * 
     * @return
     *     The primaryURL
     */
    public String getPrimaryURL() {
        return primaryURL;
    }

    /**
     * 
     * @param primaryURL
     *     The primaryURL
     */
    public void setPrimaryURL(String primaryURL) {
        this.primaryURL = primaryURL;
    }

    /**
     * 
     * @return
     *     The primaryPhone
     */
    public String getPrimaryPhone() {
        return primaryPhone;
    }

    /**
     * 
     * @param primaryPhone
     *     The primaryPhone
     */
    public void setPrimaryPhone(String primaryPhone) {
        this.primaryPhone = primaryPhone;
    }

}
