package tn.enig.myatelier2;

public class ContactModal {

    // variables for our contact modal,
    // description, tracks and duration, id.
    private String contactName;
    private String contactTel;
    private String contactEmail;
    private int id;

    // creating getter and setter methods
    public String getContactName() { return contactName; }

    public void setContactName(String contactName)
    {
        this.contactName = contactName;
    }
    public String getContactTel()
    {
        return contactTel;
    }

    public void setContactTel(String contactTel)
    {
        this.contactTel = contactTel;
    }

    public String getContactEmail() { return contactEmail; }

    public void setContactEmail(String contactEmail)
    {
        this.contactEmail = contactEmail;
    }


    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    // constructor
    public ContactModal(String string, String contactName,
                        String contactTel,
                        String contactEmail)
    {
        this.contactName = contactName;
        this.contactTel = contactTel;
        this.contactEmail = contactEmail;
    }
}
