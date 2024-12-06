import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Ride implements RideInterface {
    private String rideName;
    private int capacity;
    private Employee operator;
    private String rideID;
    private String rideType;
    private String duration;
    private String status;
    private String location;
    private Queue<Visitor> visitorQueue = new LinkedList<>();
    private LinkedList<Visitor> rideHistory = new LinkedList<>();
    private int maxRider;
    private int numOfCycles = 0;

    public Ride() {}

    public Ride(String rideName, int capacity, Employee operator, String rideID, String rideType, String duration, String status, String location, int maxRider) {
        this.rideName = rideName;
        this.capacity = capacity;
        this.operator = operator;
        this.rideID = rideID;
        this.rideType = rideType;
        this.duration = duration;
        this.status = status;
        this.location = location;
        this.maxRider = maxRider;
    }

    public String getRideName() { return rideName; }
    public void setRideName(String rideName) { this.rideName = rideName; }
    public int getCapacity() { return capacity; }
    public void setCapacity(int capacity) { this.capacity = capacity; }
    public Employee getOperator() { return operator; }
    public void setOperator(Employee operator) { this.operator = operator; }
    public String getRideID() { return rideID; }
    public void setRideID(String rideID) { this.rideID = rideID; }
    public String getRideType() { return rideType; }
    public void setRideType(String rideType) { this.rideType = rideType; }
    public String getDuration() { return duration; }
    public void setDuration(String duration) { this.duration = duration; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
    public int getMaxRider() { return maxRider; }
    public void setMaxRider(int maxRider) { this.maxRider = maxRider; }
    public int getNumOfCycles() { return numOfCycles; }

    @Override
    public void addVisitorToQueue(Visitor visitor) {
        visitorQueue.add(visitor);
        System.out.println("Visitor added to queue: " + visitor.getName());
    }

    @Override
    public void removeVisitorFromQueue() {
        Visitor removedVisitor = visitorQueue.poll();
        if (removedVisitor != null) {
            System.out.println("Visitor removed from queue: " + removedVisitor.getName());
        } else {
            System.out.println("Queue is empty, no visitor to remove.");
        }
    }

    @Override
    public void printQueue() {
        if (visitorQueue.isEmpty()) {
            System.out.println("Queue is empty.");
        } else {
            System.out.println("Visitors in queue:");
            for (Visitor visitor : visitorQueue) {
                System.out.println(visitor.getName());
            }
        }
    }

    @Override
    public void runOneCycle() {
        if (operator == null) {
            System.out.println("No operator assigned, cannot run the ride.");
            return;
        }
        if (visitorQueue.isEmpty()) {
            System.out.println("No visitors in queue, cannot run the ride.");
            return;
        }
        int riders = Math.min(maxRider, visitorQueue.size());
        for (int i = 0; i < riders; i++) {
            Visitor visitor = visitorQueue.poll();
            addVisitorToHistory(visitor);
            System.out.println("Visitor " + visitor.getName() + " took the ride.");
        }
        numOfCycles++;
    }

    @Override
    public void addVisitorToHistory(Visitor visitor) {
        rideHistory.add(visitor);
    }

    @Override
    public boolean checkVisitorFromHistory(Visitor visitor) {
        return rideHistory.contains(visitor);
    }

    @Override
    public int numberOfVisitors() {
        return rideHistory.size();
    }

    @Override
    public void printRideHistory() {
        if (rideHistory.isEmpty()) {
            System.out.println("No visitors have taken the ride.");
        } else {
            System.out.println("Ride history:");
            Iterator<Visitor> iterator = rideHistory.iterator();
            while (iterator.hasNext()) {
                Visitor visitor = iterator.next();
                System.out.println(visitor.getName());
            }
        }
    }

    public void sortRideHistory() {
        Collections.sort(rideHistory, new VisitorComparator());
        System.out.println("Ride history sorted.");
    }

    public void exportRideHistory(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Visitor visitor : rideHistory) {
                writer.write(visitor.getName() + "," + visitor.getAge() + "," + visitor.getGender() + "," + visitor.getContactNumber() + "," + visitor.getEmail() + "," + visitor.getAddress() + "," + visitor.getNationality() + "," + visitor.getIdNumber() + "," + visitor.getTicketType() + "," + visitor.isHasFastPass() + "," + visitor.getVisitorID() + "," + visitor.getVisitDate() + "," + visitor.getGroupSize() + "," + visitor.getPreferredRides());
                writer.newLine();
            }
            System.out.println("Ride history exported to " + filename);
        } catch (IOException e) {
            System.out.println("An error occurred while exporting ride history: " + e.getMessage());
        }
    }

    public void importRideHistory(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 14) {
                    Visitor visitor = new Visitor(
                        data[0], // name
                        Integer.parseInt(data[1]), // age
                        data[2], // gender
                        data[3], // contactNumber
                        data[4], // email
                        data[5], // address
                        data[6], // nationality
                        data[7], // idNumber
                        data[8], // ticketType
                        Boolean.parseBoolean(data[9]), // hasFastPass
                        data[10], // visitorID
                        data[11], // visitDate
                        data[12], // groupSize
                        data[13]  // preferredRides
                    );
                    addVisitorToHistory(visitor);
                }
            }
            System.out.println("Ride history imported from " + filename);
        } catch (IOException e) {
            System.out.println("An error occurred while importing ride history: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Data format error: " + e.getMessage());
        }
    }
}
