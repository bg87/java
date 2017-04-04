package com.astontech.console;

import com.astontech.bo.*;
import com.astontech.bo.interfaces.Home;
import com.astontech.bo.interfaces.ILocation;
import com.astontech.bo.interfaces.Site;
import com.astontech.dao.*;
import com.astontech.dao.mssql.*;
import common.helpers.DateHelper;
import org.apache.log4j.Logger;

import java.io.*;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.*;
import java.util.Date;


public class Main {

    // Get logg4j instance
    final static Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {

        //  fundamentals();
        //  strings();
        //  arraysAndLists();
//        try {
//            flowControl();
//        }
//        catch(Exception ex) {
//            System.out.println(ex.toString());
//        }
        //  LessonFizzBuzzLab();
        //  LessonCalculatorLab();
        //  LessonObjectsLAB();
        //  LessonCollections();
        //  LessonComplexProperties();
        //  LessonCollectionsLAB();
        //  LessonPolymorphism();
        //  LessonHash();
        //  LessonInterfacesTest();
        //  LessonLogging();
        //  LessonLogging myTest = new TestOne();
        //  IMethod(myTest);
        //  LessonExecQuery();
        //  LessonGetStoredProc();
        //  MicrosoftSQLQuery();
        //  LessonDAO();
        //  getEmployee();
        //  getPhone();
        //  getEmail();
        //  getVehicle();
        //  getVehicleMake();
        //  getVehicleModel();
        //  LessonDAOInsert();
        //  LessonDAOUpdate();
        //  LessonDAODelete();
        //  LessonReflection(Employee.class);
        //  LessonBoxUnboxCasting();
        //  LessonSerialize();
        //  LessonDeserialization();
        //  recursion(new File("/Users/Brandon.Gladen/Documents"));
        // getPerson();

    }

    private static void getPerson() {

        IPersonDAO personDAO = new PersonDAOIml();
        Person person = personDAO.getPersonById(3);

        System.out.println(person.getFirstName());

    }

    private static void recursion(File dir) {

        try {
            File[] files = dir.listFiles();
            for(File file : files) {
                if(file.isDirectory()) {
                    logger.info("Directory: " + file.getCanonicalPath());
                    recursion(file);
                } else {
                    logger.info("       file: " + file.getCanonicalPath());
                }
            }
        } catch(IOException ex) {
            logger.error(ex);
        }

    }

    private static void LessonDeserialization() {
        Person person = null;
        try {
            FileInputStream fileIn = new FileInputStream("./ser_person.txt");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            person = (Person) in.readObject();
            in.close();
            fileIn.close();
        } catch(FileNotFoundException ex) {
            logger.error(ex);
        } catch(IOException ex) {
            logger.error(ex);
        } catch(ClassNotFoundException ex) {
            logger.error(ex);
        }

        logger.info(person.toString());
    }

    private static void LessonSerialize() {

        // Get object from DB
        IPersonDAO personDAO = new PersonDAOIml();
        Person person = personDAO.getPersonById(2);

        // Serialize object to text file
        try {
            FileOutputStream fileOut = new FileOutputStream("./ser_person.txt ");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(person);
            out.close();
            fileOut.close();
            logger.info("Object serialized and written to file: ./ser_person.txt");
        } catch(IOException ex) {
            logger.error(ex);
        }
    }

    private static void LessonBoxUnboxCasting() {

        // Boxing - converting a value type to a reference type
        int x = 10;
        Object o = x;
        LessonReflection(o.getClass());

        // Unboxing - converting a reference type to a value type
        // explicit casting
        int y = (int) o;
        logger.info(y);

        // implicit casting
        int i = 100;
        double d = i;

    }

    private static <T> void LessonReflection(Class<T> genericClass) {

        logger.info("Full name: " +  genericClass.getName());
        logger.info("Simple name: " + genericClass.getSimpleName());
        for(Field field : genericClass.getDeclaredFields()) {
            logger.info("Field: " + field.getName() + " - Type: " + field.getType());
        }

    }

    private static void LessonDAODelete() {

        IPersonDAO personDAO = new PersonDAOIml();

        if(personDAO.deletePerson(17)) {
            logger.info("Person Deleted");
        } else {
            logger.info("Person Delete Failed");
        }


    }

    private static void LessonDAOUpdate() {

        IPersonDAO personDAO = new PersonDAOIml();

        // Get person to update
        Person person = personDAO.getPersonById(21);

        person.setDisplayFirstName("Sam");
        person.setTitle("Ms.");

        // Call update person
//        if(personDAO.updatePerson(person)) {
//            logger.info("Person Updated");
//        } else {
//            logger.info("Person Update Failed");
//        }

    }

    private static void LessonDAOInsert() {

        Person person = new Person();
        person.setTitle("Mr.");
        person.setFirstName("Benton");
        person.setMiddleName("Scott");
        person.setLastName("Gladen");
        person.setDisplayFirstName("Ben");
        person.setBirthDate(new Date());
        person.setSSN("231-43-5456");
        person.setGender("M");

        IPersonDAO personDAO = new PersonDAOIml();
        int id = personDAO.insertPerson(person);

        logger.info("ID: " + id);
    }

    private static void getVehicleModel() {

        IVehicleModelDAO vehicleModelDAO = new VehicleModelDAOIml();
        List<VehicleModel> vehicleModelList = vehicleModelDAO.getVehicleModelList();

        System.out.println(vehicleModelList);
    }

    private static void getVehicleMake() {

        IVehicleMakeDAO vehicleMakeDAO = new VehicleMakeDAOIml();
        List<VehicleMake> vehicleMakeList = vehicleMakeDAO.getVehicleMakeList();

        System.out.println(vehicleMakeList);
    }

    private static void getVehicle() {

        IVehicleDAO vehicleDAO = new VehicleDAOIml();
        List<Vehicle> vehicleList = vehicleDAO.getVehicleList();

        System.out.println(vehicleList);
    }

    private static void getEmail() {

        IEmailDAO emailDAO = new EmailDAOIml();
        List<Email> emailList = emailDAO.getEmailList();

        System.out.println(emailList);
    }

    private static void getPhone() {

        IPhoneDAO phoneDAO = new PhoneDAOIml();
        List<Phone> phoneList = phoneDAO.getPhoneList();

        System.out.println(phoneList);
    }

    private static void getEmployee() {

        IEmployeeDAO employeeDAO = new EmployeeDAOIml();
        List<Employee> employeeList = employeeDAO.getEmployeeList();

        System.out.println(employeeList);
    }

    private static void LessonDAO() {

        //region CREATE MENU

        IPersonDAO personDAO = new PersonDAOIml();
        List<Person> personList = personDAO.getPersonList();

        System.out.println("==============================");

        for(Person person : personList) {
            System.out.println(person.getPersonId() + ": " + person.getLastName() + ", " + person.getFirstName());
        }

        System.out.println("==============================");

        //endregion

        //region PROMPT USER

        Scanner reader = new Scanner(System.in);

        System.out.println("Select a person: ");

        String personId = reader.nextLine();

        //endregion

        //region GET PERSON DETAILS

        // convert personId to integer and getPersonById
        Person personDetail = personDAO.getPersonById(Integer.parseInt(personId));

        System.out.println("--------- PERSON DETAILS ---------");
        System.out.println(personDetail.getFullName());
        System.out.println(personDetail.getBirthDate());
        System.out.println(personDetail.getSSN());

        //endregion

    }

    private static void MircrosoftSQLQuery(){

        // connect to microsoft sql server
        Connection conn = MicrosoftSQLConnect();

        try {
            java.sql.Statement statement = conn.createStatement();

            // format sql statement
            String sql = "select personId, firstName, lastName from person";

            // execute query
            ResultSet rs = statement.executeQuery(sql);

            // rs.next will return tru if there is another row
            while(rs.next()) {
                logger.info(rs.getInt(1) + ": " + rs.getString(2) + " " + rs.getString(3));
            }

            // close sql connection
            conn.close();

        } catch(SQLException ex) {
            logger.error(ex);
        }
    }

    private static Connection MicrosoftSQLConnect() {

        String dbHost = "localhost";
        String dbName = "AstonEngineer";
        String dbUser = "brandon";
        String dbPass = "bg";
        String useSSL = "false";
        String procBod = "true";

//        try {
//            Class.forName("com.microsoft.sqlserver.jdbc");
//        } catch(ClassNotFoundException ex) {
//            logger.error("driver not found: " + ex);
//            return null;
//        }

        logger.info("Microsoft SQL driver registered");
        Connection connection = null;

        try{
            //  + "?useSSL=" + useSSL + "&noAccessToProcedureBodies=" + procBod
            connection = DriverManager.getConnection("jdbc:sqlserver://" + dbHost + ":1433;databaseName=" + dbName + ";user=" + dbUser + ";password=" + dbPass);
        } catch (SQLException ex) {
            logger.error("Connection failed: " + ex);
            return null;
        }

        if(connection != null) {
            logger.info("Connected to MySQL database");
            return connection;
        } else {
            logger.info("Connection failed");
            return null;
        }
    }


    private static void IMethod(ITest param){
        System.out.println(param);
    }

    private static void LessonLogging() {

        try {
            int i = 10/0;
        } catch (ArithmeticException ex) {
            logger.error(ex);
        }

    }

    private static void LessonInterfacesTest() {

        Site MNO10 = new Site();
        MNO10.setSiteName("MN010");
        MNO10.setCoffeeMachines(2);
        MNO10.setConfrenceRooms(4);
        MNO10.setCubicles(10);
        MNO10.setOffices(4);
        MNO10.setTrainingDesks(30);

        Home house = new Home();
        house.setAddress("4324 23th st");
        house.setOwner(new Employee("scott", "smith"));

        LessonInterfaces(MNO10);
        LessonInterfaces(house);
    }

    private static void LessonInterfaces(ILocation ILocation) {

        System.out.println("Location name: " + ILocation.getLocationName());
        System.out.println("Can have meetings: " + ILocation.canHoldMeetings());
        System.out.println("Number of work spaces: " + ILocation.numberOfWorkspaces());
        System.out.println("Has coffee: " + ILocation.hasCoffee());

    }

    private static void LessonHash() {
        // Hashtable
            // Doesn't allow null for key or value
            // Last in first out

        Hashtable<Integer, String> hashTable = new Hashtable<>();

        hashTable.put(1, "first value");
        hashTable.put(2, "second value");
        hashTable.put(3, "third value");
        hashTable.put(4, "fourth value");

        for(Integer key : hashTable.keySet()) {
            System.out.println(hashTable.get(key));
        }

        // HashMap
            // Does allow for null key or value
            // First in first out

        HashMap<Integer, String> hashMap = new HashMap<>();

        hashMap.put(1, "first hashmap value");
        hashMap.put(2, "two hashmap value");
        hashMap.put(3, "three hashmap value");
        hashMap.put(4, "four hashmap value");

        for(Integer key : hashMap.keySet()){
            System.out.println(hashMap.get(key));
        }

        // HashSet
            // A list of unique values. No duplicates.

        HashSet<String> hashSet = new HashSet<>();

        hashSet.add("Item1");
        hashSet.add("Item2");
        hashSet.add("Item3");

        for(String s : hashSet) {
            System.out.println(s);
        }
    }

    private static void LessonPolymorphism() {

        // Same name different behavior

        // Compile time polymorphism - overload
            // methods have the same name but different params

        // Run time polymorphism - override
            // methods in the class hierarchy will 'override' methods higher in the hierarchy.
    }

    private static void LessonCollectionsLAB(){

        List<Vehicle> vehicles = new ArrayList();

        vehicles.add(new Vehicle("Ford", "Taurus"));
        vehicles.add(new Vehicle("Ford", "fiesta"));
        vehicles.add(new Vehicle("Chevy", "cobalt"));
        vehicles.add(new Vehicle("Volkswagen", "Jetta"));

        for(Vehicle v : vehicles) {
            System.out.println(v.getMake() + " " + v.getModel());
        }
    }

    private static void LessonComplexProperties() {

        Employee myEmployee = new Employee("b", "g");
        myEmployee.getEmails().add(new Email("b@b.com"));
        myEmployee.getEmails().add(new Email("b@work.com"));
        myEmployee.getEmails().add(new Email("b@home.com"));

        for(Email email : myEmployee.getEmails()) {
            System.out.println(email.getEmailAddress());
        }


    }

    private static void LessonCollections() {

        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee("jon", "smith"));
        employees.add(new Employee("sarah", "jonson"));
        employees.add(new Employee("sam", "roberts"));
        employees.add(new Employee("jack", "day"));
        employees.add(new Employee("quinn", "landwehr"));

        System.out.println(employees.get(2).getFullName() + "\n");

        for(Employee e : employees) {
            System.out.println(e.getFullName());
        }
    }

    private static void LessonObjectsLAB() {
        Address myAddress = new Address("USA");
        Client myClient =  new Client("UHG", 5);
        Employee myEmployee = new Employee("Brandon", "Gladen");
        LoyaltyCompanyType myCompany = new LoyaltyCompanyType("Hertz");
        Project myProject = new Project("ProjectOne");
        Review myReview = new Review(1);
        Training javaTraining = new Training(1, "Java");
        Vehicle myVehicle = new Vehicle("Ford", "Fiesta");

        System.out.println(myAddress.getCountry());
        System.out.println(myClient.getClientName());
        System.out.println(myEmployee.getFirstName());
        System.out.println(myCompany.getCompanyName());
        System.out.println(myProject.getName());
        System.out.println(myReview.getReviewId());
        System.out.println(javaTraining.getName());
        System.out.println(myVehicle.getMake());
    }

    private static void fundamentals() {

        //    Write code that prompts the user to enter a value from 1-10,
        //    adds 1.75 to the number then outputs it to the console.

        Scanner read = new Scanner(System.in);
        System.out.println("Pick a number from 1 to 10: ");

        double userNumber = read.nextInt();

        if(userNumber > 0 && userNumber < 10) {
            System.out.println("Your number is now " + (userNumber + 1.75));
        } else {
            System.out.println("You did it wrong.");
        }

        //   Research the eight data types in Java, create variables for these,
        //   and output the default, max, and min values (where applicable).

        byte maxByte = 127;
        byte minByte = -128;

        short maxShort = 32767;
        short minShort = -32768;

        int maxInt = (int) (Math.pow(2, 31)) - 1;
        int minInt = (int) (Math.pow(-2, 31));

        long maxLong = (int) (Math.pow(2, 63)) - 1;
        long minLong = (int) (Math.pow(-2, 31));

        float myFloat = 3.4f;

        double myDouble = 24243213423.434321;

        boolean bool = true;

        char myChar = 'b';

        System.out.println(maxByte);
        System.out.println(minByte);
        System.out.println(maxShort);
        System.out.println(minShort);
        System.out.println(maxInt);
        System.out.println(minInt);
        System.out.println(maxLong);
        System.out.println(minLong);
        System.out.println(myFloat);
        System.out.println(myDouble);
        System.out.println(bool);
        System.out.println(myChar);
    }

    private static void strings() {
        //  Strings are not part of the eight primitive data types, why not?
        //  Which of the data types is a String actually composed of? Prove this in your code.

        // A string is an array of chars

        String myString = "This is a string";
        System.out.println(myString.indexOf('s'));
    }

    private static void arraysAndLists() {
        //  Create a List, populate it with values and then iterate through those values
        //  outputting them to the console.  Why can you not create a List of 'char' or 'int'?

        // A list cannot be of a primitive type.

        List<String> myList = new ArrayList<String>();
        List<Integer> intList = new ArrayList<Integer>();
        String[] myArray = new String[3];


        myList.add("one string");
        myList.add("two string");
        myList.add("another string");
        myList.add("this string");

        intList.add(13);
        intList.add(54);
        intList.add(92);
        intList.add(2);

        myArray[0] = "one";
        myArray[1] = "two";
        myArray[2] = "three";

        for(String singleString : myList) {
            System.out.println(singleString);
        }

        for(int number : intList) {
            System.out.println(number);
        }

        System.out.println(myArray);

        for(String item : myArray) {
            System.out.println(item);
        }


    }

    private static void lottery() {
        String gameName = "Powerball";
        double cost = 2.39;
        String drawingDate = "13-12-14";
        int powerball = 5;
        int multiplier = 2;
        String match = "5 numbers + powerball";
        long win = 250000000;
        String odds = "1 in 1000000000";

        List<Integer> winningNumbers = new ArrayList<Integer>();

        winningNumbers.add(34);
        winningNumbers.add(12);
        winningNumbers.add(3);
        winningNumbers.add(76);
        winningNumbers.add(12);

        for(int number : winningNumbers) {
            System.out.println(number);
        }
    }

    private static void flowControl() throws Exception {

       String name = "bg";

       try {
           int i = Integer.parseInt(name);
           System.out.println(i);
       }
       catch(Exception ex)
       {
           throw new Exception("Something went wrong.", ex);
       }
        finally
       {
           System.out.println("hello");
       }


    }

    private static void LessonFizzBuzzLab() {

        for(int i = 0; i < 101; i++) {
            if (i % 15 == 0) {
                System.out.println("FizzBuzz");
            } else if (i % 5 == 0) {
                System.out.println("Buzz");
            } else if (i % 3 == 0) {
                System.out.println("Fizz");
            } else {
                System.out.println(i);
            }
        }
    }

    private static void LessonCalculatorLab() {

        int firstNumber = getNumber();
        int secondNumber = getNumber();
        String operator = getOperator();

        switch(operator) {
            case "+":
            {
                System.out.println(firstNumber + secondNumber);
                break;
            }
            case "-":
            {
                System.out.println(firstNumber - secondNumber);
                break;
            }
            case "/":
            {
                System.out.println(firstNumber / secondNumber);
                break;
            }
            case "*":
            {
                System.out.println(firstNumber * secondNumber);
                break;
            }
        }

    }

    private static int getNumber() {
        try {
            Scanner number = new Scanner(System.in);
            System.out.println("Give me a number from 0-9: ");
            int input = number.nextInt();

            if(input > 9 || input < 0) {
                System.out.println("INVALID");
                getNumber();
            }
            return input;
        }
        catch(Exception ex) {
            getNumber();
        }
        return 0;
    }

    private static String getOperator() {
        try {
            Scanner operator = new Scanner(System.in);
            System.out.println("Give me an operator: ");
            String userOp = operator.nextLine();

            if(!userOp.equals("+") && !userOp.equals("-") && !userOp.equals("/") && !userOp.equals("*")) {
                System.out.println("INVALID");
                getOperator();
            }
            return userOp;
        }
        catch(Exception ex) {
            getNumber();
        }
        return "0";
    }
}
