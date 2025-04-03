
public class RealEstateData {
    private String title;
    private String price;
    private String address;
    private String area;
    private String description;

    public RealEstateData(String title, String price, String address, String area, String description) {
        this.title = title;
        this.price = price;
        this.address = address;
        this.area = area;
        this.description = description;
    }

    @Override
    public String toString() {
        return String.format("\"%s\",\"%s\",\"%s\",\"%s\",\"%s\"", title, price, address, area, description);
    }
}
