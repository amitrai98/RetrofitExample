package android.stakbrowser.amitrai.retrofitexample.Modal;

/**
 * Created by amitrai on 18/1/16.
 */
public class Domains {

    private String _id;

    private String headerColor;

    private String name;

    private String iconColor;

    private String headerTextColor;

    public String get_id ()
    {
        return _id;
    }

    public void set_id (String _id)
    {
        this._id = _id;
    }

    public String getHeaderColor ()
    {
        return headerColor;
    }

    public void setHeaderColor (String headerColor)
    {
        this.headerColor = headerColor;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getIconColor ()
    {
        return iconColor;
    }

    public void setIconColor (String iconColor)
    {
        this.iconColor = iconColor;
    }

    public String getHeaderTextColor ()
    {
        return headerTextColor;
    }

    public void setHeaderTextColor (String headerTextColor)
    {
        this.headerTextColor = headerTextColor;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [_id = "+_id+", headerColor = "+headerColor+", name = "+name+", iconColor = "+iconColor+", headerTextColor = "+headerTextColor+"]";
    }
}
