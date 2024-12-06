public class AssignmentTwo {
    public static void main(String[] args) {
        AssignmentTwo assignment = new AssignmentTwo();
        
        System.out.println("Part 3: Queue Management");
        assignment.partThree();
        
        System.out.println("\nPart 4A: Visitor History Management");
        assignment.partFourA();
        
        System.out.println("\nPart 4B: Sorting Visitor History");
        assignment.partFourB();
        
        System.out.println("\nPart 5: Running a Ride Cycle");
        assignment.partFive();
        
        System.out.println("\nPart 6: Exporting Ride History");
        assignment.partSix();
        
        System.out.println("\nPart 7: Importing Ride History");
        assignment.partSeven();
    }
    
    public void partThree() {
        Employee operator = new Employee("John", 40, "Male", "1234567890", "john@example.com", "123 Street", "Country", "ID006", "Operator", 50000, "E001", "Operations", "Morning", "2020-01-01");
        Ride ride = new Ride("Roller Coaster", 5, operator, "R001", "Thrill", "2 mins", "Open", "Zone A", 3);
        
        Visitor visitor1 = new Visitor("Alice", 25, "Female", "1234567890", "alice@example.com", "123 Street", "Country", "ID001", "Regular", true, "V001", "2024-12-01", "3", "Roller Coaster");
        Visitor visitor2 = new Visitor("Bob", 30, "Male", "0987654321", "bob@example.com", "456 Avenue", "Country", "ID002", "Regular", false, "V002", "2024-12-01", "2", "Ferris Wheel");
        Visitor visitor3 = new Visitor("Charlie", 22, "Male", "1122334455", "charlie@example.com", "789 Boulevard", "Country", "ID003", "VIP", true, "V003", "2024-12-01", "1", "Haunted House");
        Visitor visitor4 = new Visitor("Diana", 28, "Female", "6677889900", "diana@example.com", "321 Road", "Country", "ID004", "Regular", false, "V004", "2024-12-01", "4", "Water Slide");
        Visitor visitor5 = new Visitor("Eve", 35, "Female", "5566778899", "eve@example.com", "654 Lane", "Country", "ID005", "VIP", true, "V005", "2024-12-01", "5", "Bumper Cars");

        ride.addVisitorToQueue(visitor1);
        ride.addVisitorToQueue(visitor2);
        ride.addVisitorToQueue(visitor3);
        ride.addVisitorToQueue(visitor4);
        ride.addVisitorToQueue(visitor5);

        ride.removeVisitorFromQueue();
        ride.printQueue();
    }
    
    public void partFourA() {
        Employee operator = new Employee("John", 40, "Male", "1234567890", "john@example.com", "123 Street", "Country", "ID006", "Operator", 50000, "E001", "Operations", "Morning", "2020-01-01");
        Ride ride = new Ride("Roller Coaster", 5, operator, "R001", "Thrill", "2 mins", "Open", "Zone A", 3);
        
        Visitor visitor1 = new Visitor("Alice", 25, "Female", "1234567890", "alice@example.com", "123 Street", "Country", "ID001", "Regular", true, "V001", "2024-12-01", "3", "Roller Coaster");
        Visitor visitor2 = new Visitor("Bob", 30, "Male", "0987654321", "bob@example.com", "456 Avenue", "Country", "ID002", "Regular", false, "V002", "2024-12-01", "2", "Ferris Wheel");
        Visitor visitor3 = new Visitor("Charlie", 22, "Male", "1122334455", "charlie@example.com", "789 Boulevard", "Country", "ID003", "VIP", true, "V003", "2024-12-01", "1", "Haunted House");
        Visitor visitor4 = new Visitor("Diana", 28, "Female", "6677889900", "diana@example.com", "321 Road", "Country", "ID004", "Regular", false, "V004", "2024-12-01", "4", "Water Slide");
        Visitor visitor5 = new Visitor("Eve", 35, "Female", "5566778899", "eve@example.com", "654 Lane", "Country", "ID005", "VIP", true, "V005", "2024-12-01", "5", "Bumper Cars");

        ride.addVisitorToHistory(visitor1);
        ride.addVisitorToHistory(visitor2);
        ride.addVisitorToHistory(visitor3);
        ride.addVisitorToHistory(visitor4);
        ride.addVisitorToHistory(visitor5);

        System.out.println("Check if Bob is in history: " + ride.checkVisitorFromHistory(visitor2));
        System.out.println("Number of visitors in history: " + ride.numberOfVisitors());
        ride.printRideHistory();
    }

    public void partFourB() {
        Employee operator = new Employee("John", 40, "Male", "1234567890", "john@example.com", "123 Street", "Country", "ID006", "Operator", 50000, "E001", "Operations", "Morning", "2020-01-01");
        Ride ride = new Ride("Roller Coaster", 5, operator, "R001", "Thrill", "2 mins", "Open", "Zone A", 3);
        
        Visitor visitor1 = new Visitor("Alice", 25, "Female", "1234567890", "alice@example.com", "123 Street", "Country", "ID001", "Regular", true, "V001", "2024-12-01", "3", "Roller Coaster");
        Visitor visitor2 = new Visitor("Bob", 30, "Male", "0987654321", "bob@example.com", "456 Avenue", "Country", "ID002", "Regular", false, "V002", "2024-12-01", "2", "Ferris Wheel");
        Visitor visitor3 = new Visitor("Charlie", 22, "Male", "1122334455", "charlie@example.com", "789 Boulevard", "Country", "ID003", "VIP", true, "V003", "2024-12-01", "1", "Haunted House");
        Visitor visitor4 = new Visitor("Diana", 28, "Female", "6677889900", "diana@example.com", "321 Road", "Country", "ID004", "Regular", false, "V004", "2024-12-01", "4", "Water Slide");
        Visitor visitor5 = new Visitor("Eve", 35, "Female", "5566778899", "eve@example.com", "654 Lane", "Country", "ID005", "VIP", true, "V005", "2024-12-01", "5", "Bumper Cars");

        ride.addVisitorToHistory(visitor1);
        ride.addVisitorToHistory(visitor2);
        ride.addVisitorToHistory(visitor3);
        ride.addVisitorToHistory(visitor4);
        ride.addVisitorToHistory(visitor5);

        System.out.println("Before sorting:");
        ride.printRideHistory();

        ride.sortRideHistory();

        System.out.println("After sorting:");
        ride.printRideHistory();
    }

    public void partFive() {
        Ride ride = new Ride("Roller Coaster", 5, new Employee("John", 40, "Male", "1234567890", "john@example.com", "123 Street", "Country", "ID006", "Operator", 50000, "E001", "Operations", "Morning", "2020-01-01"), "R001", "Thrill", "2 mins", "Open", "Zone A", 3);
        
        Visitor visitor1 = new Visitor("Alice", 25, "Female", "1234567890", "alice@example.com", "123 Street", "Country", "ID001", "Regular", true, "V001", "2024-12-01", "3", "Roller Coaster");
        Visitor visitor2 = new Visitor("Bob", 30, "Male", "0987654321", "bob@example.com", "456 Avenue", "Country", "ID002", "Regular", false, "V002", "2024-12-01", "2", "Ferris Wheel");
        Visitor visitor3 = new Visitor("Charlie", 22, "Male", "1122334455", "charlie@example.com", "789 Boulevard", "Country", "ID003", "VIP", true, "V003", "2024-12-01", "1", "Haunted House");
        Visitor visitor4 = new Visitor("Diana", 28, "Female", "6677889900", "diana@example.com", "321 Road", "Country", "ID004", "Regular", false, "V004", "2024-12-01", "4", "Water Slide");
        Visitor visitor5 = new Visitor("Eve", 35, "Female", "5566778899", "eve@example.com", "654 Lane", "Country", "ID005", "VIP", true, "V005", "2024-12-01", "5", "Bumper Cars");
        Visitor visitor6 = new Visitor("Frank", 29, "Male", "9988776655", "frank@example.com", "987 Street", "Country", "ID006", "Regular", true, "V006", "2024-12-01", "2", "Roller Coaster");
        Visitor visitor7 = new Visitor("Grace", 31, "Female", "8877665544", "grace@example.com", "654 Avenue", "Country", "ID007", "Regular", false, "V007", "2024-12-01", "3", "Ferris Wheel");
        Visitor visitor8 = new Visitor("Hank", 27, "Male", "7766554433", "hank@example.com", "321 Boulevard", "Country", "ID008", "VIP", true, "V008", "2024-12-01", "1", "Haunted House");
        Visitor visitor9 = new Visitor("Ivy", 26, "Female", "6655443322", "ivy@example.com", "123 Road", "Country", "ID009", "Regular", false, "V009", "2024-12-01", "4", "Water Slide");
        Visitor visitor10 = new Visitor("Jack", 32, "Male", "5544332211", "jack@example.com", "456 Lane", "Country", "ID010", "VIP", true, "V010", "2024-12-01", "5", "Bumper Cars");

        ride.addVisitorToQueue(visitor1);
        ride.addVisitorToQueue(visitor2);
        ride.addVisitorToQueue(visitor3);
        ride.addVisitorToQueue(visitor4);
        ride.addVisitorToQueue(visitor5);
        ride.addVisitorToQueue(visitor6);
        ride.addVisitorToQueue(visitor7);
        ride.addVisitorToQueue(visitor8);
        ride.addVisitorToQueue(visitor9);
        ride.addVisitorToQueue(visitor10);

        System.out.println("Visitors in queue before running a cycle:");
        ride.printQueue();

        ride.runOneCycle();

        System.out.println("Visitors in queue after running a cycle:");
        ride.printQueue();

        System.out.println("Visitors in ride history:");
        ride.printRideHistory();
    }

    public void partSix() {
        Ride ride = new Ride("Roller Coaster", 5, new Employee("John", 40, "Male", "1234567890", "john@example.com", "123 Street", "Country", "ID006", "Operator", 50000, "E001", "Operations", "Morning", "2020-01-01"), "R001", "Thrill", "2 mins", "Open", "Zone A", 3);
        
        Visitor visitor1 = new Visitor("Alice", 25, "Female", "1234567890", "alice@example.com", "123 Street", "Country", "ID001", "Regular", true, "V001", "2024-12-01", "3", "Roller Coaster");
        Visitor visitor2 = new Visitor("Bob", 30, "Male", "0987654321", "bob@example.com", "456 Avenue", "Country", "ID002", "Regular", false, "V002", "2024-12-01", "2", "Ferris Wheel");
        Visitor visitor3 = new Visitor("Charlie", 22, "Male", "1122334455", "charlie@example.com", "789 Boulevard", "Country", "ID003", "VIP", true, "V003", "2024-12-01", "1", "Haunted House");
        Visitor visitor4 = new Visitor("Diana", 28, "Female", "6677889900", "diana@example.com", "321 Road", "Country", "ID004", "Regular", false, "V004", "2024-12-01", "4", "Water Slide");
        Visitor visitor5 = new Visitor("Eve", 35, "Female", "5566778899", "eve@example.com", "654 Lane", "Country", "ID005", "VIP", true, "V005", "2024-12-01", "5", "Bumper Cars");

        ride.addVisitorToHistory(visitor1);
        ride.addVisitorToHistory(visitor2);
        ride.addVisitorToHistory(visitor3);
        ride.addVisitorToHistory(visitor4);
        ride.addVisitorToHistory(visitor5);

        ride.exportRideHistory("ride_history.csv");
    }

    public void partSeven() {
        Ride ride = new Ride("Roller Coaster", 5, new Employee("John", 40, "Male", "1234567890", "john@example.com", "123 Street", "Country", "ID006", "Operator", 50000, "E001", "Operations", "Morning", "2020-01-01"), "R001", "Thrill", "2 mins", "Open", "Zone A", 3);
        
        ride.importRideHistory("ride_history.csv");

        System.out.println("Number of visitors in history after import: " + ride.numberOfVisitors());
        ride.printRideHistory();
    }
} 