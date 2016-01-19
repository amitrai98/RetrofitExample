package android.stakbrowser.amitrai.retrofitexample.Modal;

import java.util.Objects;

/**
 * Created by amitrai on 18/1/16.
 */
public class KiTAGS {

    private String id;

    private String kiTAGViewId;

    private String title;

    private String[] address;

    private String kiTAG;

    private String keyword;

    private String isDomainCard;

    private String domain;

    private String seo;

    private String businessId;

    private String notes;

    private String type;

    private Objects objects;

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getKiTAGViewId ()
    {
        return kiTAGViewId;
    }

    public void setKiTAGViewId (String kiTAGViewId)
    {
        this.kiTAGViewId = kiTAGViewId;
    }

    public String getTitle ()
    {
        return title;
    }

    public void setTitle (String title)
    {
        this.title = title;
    }

    public String[] getAddress ()
    {
        return address;
    }

    public void setAddress (String[] address)
    {
        this.address = address;
    }

    public String getKiTAG ()
    {
        return kiTAG;
    }

    public void setKiTAG (String kiTAG)
    {
        this.kiTAG = kiTAG;
    }

    public String getKeyword ()
    {
        return keyword;
    }

    public void setKeyword (String keyword)
    {
        this.keyword = keyword;
    }

    public String getIsDomainCard ()
    {
        return isDomainCard;
    }

    public void setIsDomainCard (String isDomainCard)
    {
        this.isDomainCard = isDomainCard;
    }

    public String getDomain ()
    {
        return domain;
    }

    public void setDomain (String domain)
    {
        this.domain = domain;
    }

    public String getSeo ()
    {
        return seo;
    }

    public void setSeo (String seo)
    {
        this.seo = seo;
    }

    public String getBusinessId ()
    {
        return businessId;
    }

    public void setBusinessId (String businessId)
    {
        this.businessId = businessId;
    }

    public String getNotes ()
    {
        return notes;
    }

    public void setNotes (String notes)
    {
        this.notes = notes;
    }

    public String getType ()
    {
        return type;
    }

    public void setType (String type)
    {
        this.type = type;
    }

    public Objects getObjects ()
    {
        return objects;
    }

    public void setObjects (Objects objects)
    {
        this.objects = objects;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [id = "+id+", kiTAGViewId = "+kiTAGViewId+", title = "+title+", address = "+address+", kiTAG = "+kiTAG+", keyword = "+keyword+", isDomainCard = "+isDomainCard+", domain = "+domain+", seo = "+seo+", businessId = "+businessId+", notes = "+notes+", type = "+type+", objects = "+objects+"]";
    }
}
