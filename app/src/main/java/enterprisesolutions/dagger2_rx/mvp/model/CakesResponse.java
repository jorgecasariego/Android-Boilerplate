package enterprisesolutions.dagger2_rx.mvp.model;

public class CakesResponse {
    private String product;
    private CakesResponseStaffContacts[] staffContacts;
    private String releaseDate;
    private CakesResponseCakes[] cakes;
    private double version;

    public String getProduct() {
        return this.product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public CakesResponseStaffContacts[] getStaffContacts() {
        return this.staffContacts;
    }

    public void setStaffContacts(CakesResponseStaffContacts[] staffContacts) {
        this.staffContacts = staffContacts;
    }

    public String getReleaseDate() {
        return this.releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public CakesResponseCakes[] getCakes() {
        return this.cakes;
    }

    public void setCakes(CakesResponseCakes[] cakes) {
        this.cakes = cakes;
    }

    public double getVersion() {
        return this.version;
    }

    public void setVersion(double version) {
        this.version = version;
    }
}
