package android.stakbrowser.amitrai.retrofitexample.RetrofiltCode;

/**
 * Created by amitrai on 18/1/16.
 */
public class Address {

    private String zip;

    private String state;

    private String addressLine2;

    private String addressLine1;

    private String city;

    private String country;

    public String getZip ()
    {
        return zip;
    }

    public void setZip (String zip)
    {
        this.zip = zip;
    }

    public String getState ()
    {
        return state;
    }

    public void setState (String state)
    {
        this.state = state;
    }

    public String getAddressLine2 ()
    {
        return addressLine2;
    }

    public void setAddressLine2 (String addressLine2)
    {
        this.addressLine2 = addressLine2;
    }

    public String getAddressLine1 ()
    {
        return addressLine1;
    }

    public void setAddressLine1 (String addressLine1)
    {
        this.addressLine1 = addressLine1;
    }

    public String getCity ()
    {
        return city;
    }

    public void setCity (String city)
    {
        this.city = city;
    }

    public String getCountry ()
    {
        return country;
    }

    public void setCountry (String country)
    {
        this.country = country;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [zip = "+zip+", state = "+state+", addressLine2 = "+addressLine2+", addressLine1 = "+addressLine1+", city = "+city+", country = "+country+"]";
    }
}
