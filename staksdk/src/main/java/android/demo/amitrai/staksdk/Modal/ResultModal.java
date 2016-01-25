
package android.demo.amitrai.staksdk.Modal;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class ResultModal {

    @SerializedName("kiTAGS")
    @Expose
    private List<KiTAG> kiTAGS = new ArrayList<KiTAG>();
    @SerializedName("businesses")
    @Expose
    private List<Business> businesses = new ArrayList<Business>();
    @SerializedName("domains")
    @Expose
    private List<Domain> domains = new ArrayList<Domain>();
    @SerializedName("searchString")
    @Expose
    private String searchString;

    /**
     *
     * @return
     *     The kiTAGS
     */
    public List<KiTAG> getKiTAGS() {
        return kiTAGS;
    }

    /**
     *
     * @param kiTAGS
     *     The kiTAGS
     */
    public void setKiTAGS(List<KiTAG> kiTAGS) {
        this.kiTAGS = kiTAGS;
    }

    /**
     *
     * @return
     *     The businesses
     */
    public List<Business> getBusinesses() {
        return businesses;
    }

    /**
     *
     * @param businesses
     *     The businesses
     */
    public void setBusinesses(List<Business> businesses) {
        this.businesses = businesses;
    }

    /**
     *
     * @return
     *     The domains
     */
    public List<Domain> getDomains() {
        return domains;
    }

    /**
     *
     * @param domains
     *     The domains
     */
    public void setDomains(List<Domain> domains) {
        this.domains = domains;
    }

    /**
     *
     * @return
     *     The searchString
     */
    public String getSearchString() {
        return searchString;
    }

    /**
     *
     * @param searchString
     *     The searchString
     */
    public void setSearchString(String searchString) {
        this.searchString = searchString;
    }

}
