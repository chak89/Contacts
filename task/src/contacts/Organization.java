package contacts;

public class Organization extends Contacts{

    private String orgName;
    private String orgAddress;

    public Organization(Type type) {
        setType(type);
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getOrgAddress() {
        return orgAddress;
    }

    public void setOrgAddress(String orgAddress) {
        this.orgAddress = orgAddress;
    }

    @Override
    public String getNameInfo() {
        return getOrgName();
    }


    @Override
    public String toString() {
        return "Organization name: " + getOrgName() + "\n"
                + "Address: " + getOrgAddress() + "\n"
                + "Number: " + getNumber() + "\n"
                + "Time created: " + getCreated() + "\n"
                + "Time last edit: " + getLastEdit() + "\n";
    }
}
