package android.demo.amitrai.staksdk.Modal;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Contact {

    @SerializedName("contactPhone")
    @Expose
    private String contactPhone;
    @SerializedName("contactEmail")
    @Expose
    private String contactEmail;
    @SerializedName("contactName")
    @Expose
    private String contactName;

    /**
     * 
     * @return
     *     The contactPhone
     */
    public String getContactPhone() {
        return contactPhone;
    }

    /**
     * 
     * @param contactPhone
     *     The contactPhone
     */
    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    /**
     * 
     * @return
     *     The contactEmail
     */
    public String getContactEmail() {
        return contactEmail;
    }

    /**
     * 
     * @param contactEmail
     *     The contactEmail
     */
    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    /**
     * 
     * @return
     *     The contactName
     */
    public String getContactName() {
        return contactName;
    }

    /**
     * 
     * @param contactName
     *     The contactName
     */
    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

}
