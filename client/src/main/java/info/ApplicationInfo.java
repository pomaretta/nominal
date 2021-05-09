package info;

public class ApplicationInfo {

    private final String title;
    private final String version;
    private final String company;

    /**
     *
     * The application info to customize the properties.
     *
     * @param title the title of the application.
     * @param version the version of the application.
     * @param company the company who owns the application.
     */
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
