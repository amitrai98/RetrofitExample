package android.stakbrowser.amitrai.retrofitexample.Modal;

/**
 * Created by amitrai on 11/1/16.
 */
public class DataModal {


    private String searchString;

    private Domains[] domains;

    private KiTAGS[] kiTAGS;

    private Businesses[] businesses;

    public String getSearchString ()
    {
        return searchString;
    }

    public void setSearchString (String searchString)
    {
        this.searchString = searchString;
    }

    public Domains[] getDomains ()
    {
        return domains;
    }

    public void setDomains (Domains[] domains)
    {
        this.domains = domains;
    }

    public KiTAGS[] getKiTAGS ()
    {
        return kiTAGS;
    }

    public void setKiTAGS (KiTAGS[] kiTAGS)
    {
        this.kiTAGS = kiTAGS;
    }

    public Businesses[] getBusinesses ()
    {
        return businesses;
    }

    public void setBusinesses (Businesses[] businesses)
    {
        this.businesses = businesses;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [searchString = "+searchString+", domains = "+domains+", KiTAGS = "+kiTAGS+", businesses = "+businesses+"]";
    }

}
