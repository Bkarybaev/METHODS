import java.time.LocalDate;
import java.util.Arrays;

public class Main {
    static Person[] persons = new Person[0];
   static int size = 0;

    public static void main(String[] args) {
        Person person1 = new Person(1L,"aibek", "baiel@gmail.com", LocalDate.of(2004, 12, 30), "+996700047017");
        Person person2 = new Person(2L,"Baiel", "baiel@gmail.com", LocalDate.of(2004, 12, 30), "+996700047017");
        Person person3 = new Person(3L,"kanchoro", "baiel@gmail.com", LocalDate.of(2004, 12, 30), "+996700047017");
        createCustomer(person1);
        createCustomer(person2);
        createCustomer(person3);


        //get All
//        System.out.println(Arrays.toString(getAllCustomers()));

        //get by id
//        getByIdCustomer(3L);

        //update
//        updateCustomer(1L,new Person(1L,"kanbolot","kanbolot@gmail.com",LocalDate.of(2004, 12, 30),"+996700047024"));
//        getByIdCustomer(1L);

        //deleted
//        deleteCustomer(1L);
//        deleteCustomer(2L);
//        deleteCustomer(3L);
//        System.out.println(Arrays.toString(getAllCustomers()));

    }

    static void createCustomer(Person person) {

        persons = Arrays.copyOf(persons, persons.length + 1);
        persons[persons.length - 1] = person;
        size++;
    }


    public static Person[] getAllCustomers() {
        return persons;
    }

    public static void getByIdCustomer(Long id){
        boolean isblock = false;
        for (Person person : persons) {
            if (person.id.equals(id)){
                isblock= true;
                System.out.println("\nName :" + person.firstName);
                System.out.println("Date of Birth :" + person.dateOfBirth);
                System.out.println("Email :" + person.email);
                System.out.println("Phone Number :" + person.phoneNumber);
            }
        }
        if (!isblock){
            System.out.println("not found " + id + "!!!");
        }
    }

    public static void updateCustomer(Long id , Person person){
        boolean isblock = false;
        for (Person person1 : persons) {
            if (person1.id.equals(id)){
                isblock= true;
                person1.setEmail(person.email);
                person1.setId(person.id);
                person1.setDateOfBirth(person.dateOfBirth);
                person1.setPhoneNumber(person.phoneNumber);
                person1.setFirstName(person.firstName);
            }
        }
        if (!isblock){
            System.out.println("not found " + id + "!!!");
        }
    }

    public static void deleteCustomer(Long id){
        boolean isblock = false;
        for (int i = 0; i < size; i++) {
            if (persons[i].id.equals(id)){
                isblock= true;
                for (int j = i; j < size-1; j++) {
                    persons[j] = persons[j+1];
                    System.out.println("deleted!!");
                }
                size--;
            }
        }
        persons = Arrays.copyOf(persons,persons.length-1);
        if (!isblock){
            System.out.println("not found " + id + "!!!");
        }
    }
}