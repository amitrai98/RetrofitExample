
package android.demo.amitrai.staksdk.Modal;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Objects {

    @SerializedName("countryOnCallCard")
    @Expose
    private String countryOnCallCard;
    @SerializedName("callTagDescription")
    @Expose
    private String callTagDescription;
    @SerializedName("phoneNumber")
    @Expose
    private String phoneNumber;


    @SerializedName("urlType")
    @Expose
    private String urlType;
    @SerializedName("urlImage")
    @Expose
    private String urlImage;
    @SerializedName("urlTagDescription")
    @Expose
    private String urlTagDescription;
    @SerializedName("url")
    @Expose
    private String url;

    /**
     *
     * @return
     * The urlType
     */
    public String getUrlType() {
        return urlType;
    }

    /**
     *
     * @param urlType
     * The urlType
     */
    public void setUrlType(String urlType) {
        this.urlType = urlType;
    }

    /**
     *
     * @return
     * The urlImage
     */
    public String getUrlImage() {
        return urlImage;
    }

    /**
     *
     * @param urlImage
     * The urlImage
     */
    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    /**
     *
     * @return
     * The urlTagDescription
     */
    public String getUrlTagDescription() {
        return urlTagDescription;
    }

    /**
     *
     * @param urlTagDescription
     * The urlTagDescription
     */
    public void setUrlTagDescription(String urlTagDescription) {
        this.urlTagDescription = urlTagDescription;
    }

    /**
     *
     * @return
     * The url
     */
    public String getUrl() {
        return url;
    }

    /**
     *
     * @param url
     * The url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 
     * @return
     *     The countryOnCallCard
     */
    public String getCountryOnCallCard() {
        return countryOnCallCard;
    }

    /**
     * 
     * @param countryOnCallCard
     *     The countryOnCallCard
     */
    public void setCountryOnCallCard(String countryOnCallCard) {
        this.countryOnCallCard = countryOnCallCard;
    }

    /**
     * 
     * @return
     *     The callTagDescription
     */
    public String getCallTagDescription() {
        return callTagDescription;
    }

    /**
     * 
     * @param callTagDescription
     *     The callTagDescription
     */
    public void setCallTagDescription(String callTagDescription) {
        this.callTagDescription = callTagDescription;
    }

    /**
     * 
     * @return
     *     The phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * 
     * @param phoneNumber
     *     The phoneNumber
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
