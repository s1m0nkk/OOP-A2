public class Visitor extends Person {
    private String ticketType;
    private boolean hasFastPass;
    private String visitorID;
    private String visitDate;
    private String groupSize;
    private String preferredRides;

    public Visitor() {}

    public Visitor(String name, int age, String gender, String contactNumber, String email, String address, String nationality, String idNumber, String ticketType, boolean hasFastPass, String visitorID, String visitDate, String groupSize, String preferredRides) {
        super(name, age, gender, contactNumber, email, address, nationality, idNumber);
        this.ticketType = ticketType;
        this.hasFastPass = hasFastPass;
        this.visitorID = visitorID;
        this.visitDate = visitDate;
        this.groupSize = groupSize;
        this.preferredRides = preferredRides;
    }

    public String getTicketType() { return ticketType; }
    public void setTicketType(String ticketType) { this.ticketType = ticketType; }
    public boolean isHasFastPass() { return hasFastPass; }
    public void setHasFastPass(boolean hasFastPass) { this.hasFastPass = hasFastPass; }
    public String getVisitorID() { return visitorID; }
    public void setVisitorID(String visitorID) { this.visitorID = visitorID; }
    public String getVisitDate() { return visitDate; }
    public void setVisitDate(String visitDate) { this.visitDate = visitDate; }
    public String getGroupSize() { return groupSize; }
    public void setGroupSize(String groupSize) { this.groupSize = groupSize; }
    public String getPreferredRides() { return preferredRides; }
    public void setPreferredRides(String preferredRides) { this.preferredRides = preferredRides; }
} 