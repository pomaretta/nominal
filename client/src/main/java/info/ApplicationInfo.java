package info;

public class ApplicationInfo {

    private final String title;
    private final String version;
    private final String company;

    public ApplicationInfo(String title, String version, String company) {
        this.title = title;
        this.version = version;
        this.company = company;
    }

    public String getTitle() {
        return title;
    }

    public String getVersion() {
        return version;
    }

    public String getCompany() {
        return company;
    }

}
