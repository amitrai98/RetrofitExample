package android.stakbrowser.amitrai.retrofitexample.RetrofiltCode;

/**
 * Created by amitrai on 18/1/16.
 */
public class Contact {

    private String contactPhone;

    private String contactEmail;

    private String contactName;

    public String getContactPhone ()
    {
        return contactPhone;
    }

    public void setContactPhone (String contactPhone)
    {
        this.contactPhone = contactPhone;
    }

    public String getContactEmail ()
    {
        return contactEmail;
    }

    public void setContactEmail (String contactEmail)
    {
        this.contactEmail = contactEmail;
    }

    public String getContactName ()
    {
        return contactName;
    }

    public void setContactName (String contactName)
    {
        this.contactName = contactName;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [contactPhone = "+contactPhone+", contactEmail = "+contactEmail+", contactName = "+contactName+"]";
    }

}
