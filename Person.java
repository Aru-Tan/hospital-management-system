public class Person {

    protected int id;
    protected String name;
    protected int age;
    protected String phone;

    public Person(int id, String name, int age, String phone) {
        setId(id);
        setName(name);
        setAge(age);
        setPhone(phone);
    }

    public String getRole() {
        return "Person";
    }

    public void work() {
        System.out.println(name + " is doing some work in the hospital.");
    }

    public String basicInfo() {
        return "ID: " + id + ", Name: " + name + ", Age: " + age + ", Phone: " + phone;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getPhone() { return phone; }

    public void setId(int id) {
        if (id > 0) this.id = id;
        else {
            System.out.println("Invalid ID. Setting ID = 1");
            this.id = 1;
        }
    }

    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) this.name = name.trim();
        else {
            System.out.println("Invalid name. Setting name = Unknown");
            this.name = "Unknown";
        }
    }

    public void setAge(int age) {
        if (age >= 0) this.age = age;
        else {
            System.out.println("Invalid age. Setting age = 0");
            this.age = 0;
        }
    }

    public void setPhone(String phone) {
        if (phone != null && phone.trim().length() >= 5) this.phone = phone.trim();
        else {
            System.out.println("Invalid phone. Setting phone = N/A");
            this.phone = "N/A";
        }
    }

    @Override
    public String toString() {
        return getRole() + " {" + basicInfo() + "}";
    }
}
