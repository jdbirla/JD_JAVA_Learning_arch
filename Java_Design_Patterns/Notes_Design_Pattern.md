## Design Patterns in Java
src : https://refactoring.guru/design-patterns/catalog
![image](https://user-images.githubusercontent.com/69948118/172313772-21bf1902-2c87-4faa-89a5-7aa5fa772a1e.png)

### 1.Creational Design Pattern
- Factory Pattern
- Abstract Factory Pattern
- Singleton Pattern
- Prototype Pattern
- Builder Pattern.
### 2. Structural Design Pattern
- Adapter Pattern
- Bridge Pattern
- Composite Pattern
- Decorator Pattern
- Facade Pattern
- Flyweight Pattern
- Proxy Pattern
### 3. Behavioral Design Pattern
- Chain Of Responsibility Pattern
- Command Pattern
- Interpreter Pattern
- Iterator Pattern
- Mediator Pattern
- Memento Pattern
- Observer Pattern
- State Pattern
- Strategy Pattern
- Template Pattern
- Visitor Pattern

---
src : https://www.youtube.com/watch?v=jcGSowIzmzM&list=PLt4nG7RVVk1h9lxOYSOGI9pcP3I5oblbx&index=2
## Creational Design Pattern
### Singleton Pattern

![image](https://user-images.githubusercontent.com/69948118/172492937-6e2bb168-586c-4426-bfbb-fee4752ce721.png)
![image](https://user-images.githubusercontent.com/69948118/172493004-42e7ded8-8ac0-41ab-9028-8d99622d17ba.png)
```java
class SingletonEagar {
  private static SingletonEagar instance = new SingletonEagar(); 
  
  private SingletonEagar(){}
  
  public static SingletonEagar getInstance() {
    return instance;
  }
}

class Singleton {
  private static Singleton instance; 
  
  private Singleton(){}
  
  public static Singleton getInstance() {
    if(instance == null) {
      instance = new Singleton();
    }
    
    return instance;
  }
}

class SingletonSynchronizedMethod {
  private static SingletonSynchronizedMethod instance; 
  
  private SingletonSynchronizedMethod(){}
  
  public static synchronized SingletonSynchronizedMethod getInstance() {
    if(instance == null) {
      instance = new SingletonSynchronizedMethod();
    }
    return instance;
  }
}

class SingletonSynchronized {
  private static SingletonSynchronized instance; 
  
  private SingletonSynchronized(){}
  
  public static SingletonSynchronized getInstance() {
    if(instance == null) {
      synchronized (SingletonSynchronized.class) {
        if(instance == null) {
          instance = new SingletonSynchronized();
        }
      }
    }
    return instance;
  }
}

public class SingletonExample {

  public static void main(String[] args) {
    SingletonSynchronized instance = SingletonSynchronized.getInstance();
    
    System.out.println(instance);
    
    SingletonSynchronized instance1 = SingletonSynchronized.getInstance();
    
    System.out.println(instance1);
  }
}
```
#### Another example
![image](https://user-images.githubusercontent.com/69948118/172319200-09b19402-ad86-498a-8512-5461858a612f.png)
![image](https://user-images.githubusercontent.com/69948118/172320051-cbad2b89-a3f8-4af2-81ab-fb4668197024.png)
![image](https://user-images.githubusercontent.com/69948118/172320299-aaa52e03-8573-4f95-aed9-dacd7e84ed1a.png)

---
### Factory Pattern
![image](https://user-images.githubusercontent.com/69948118/172494120-f7c0c3cf-3749-40b5-b188-b0d6be43d8d9.png)
![image](https://user-images.githubusercontent.com/69948118/172494393-ee0cbc11-eb53-4772-8ab4-a8028ea07311.png)
```java
abstract class Vehicle {
  public abstract int getWheel();
  
  public String toString() {
    return "Wheel: " + this.getWheel();
  }
}

class Car extends Vehicle {
  int wheel;
  
  Car(int wheel) {
    this.wheel = wheel;
  }

  @Override
  public int getWheel() {
    return this.wheel;
  }
}

class Bike extends Vehicle {
  int wheel;
  
  Bike(int wheel) {
    this.wheel = wheel;
  }
  
  @Override
  public int getWheel() {
    return this.wheel;
  }
}

class VehicleFactory {
  public static Vehicle getInstance(String type, int wheel) {
    if(type == "car") {
      return new Car(wheel);
    } else if(type == "bike") {
      return new Bike(wheel);
    }
    
    return null;
  }
}

public class FactoryPatternExample {

  public static void main(String[] args) {
    Vehicle car = VehicleFactory.getInstance("car", 4);
    System.out.println(car);
    
    Vehicle bike = VehicleFactory.getInstance("bike", 2);
    System.out.println(bike);
  }

}
```
### Builder Pattern.
![image](https://user-images.githubusercontent.com/69948118/172495506-3a99409e-92c4-45ad-9ee8-b570533736a6.png)
![image](https://user-images.githubusercontent.com/69948118/172495689-2ec81448-49b1-4f1c-addf-5855786d366f.png)
![image](https://user-images.githubusercontent.com/69948118/172495918-acde8273-f425-461a-a3d3-40a74878f953.png)


```java
package builder;

class Vehicle {
  //required parameter
  private String engine;
  private int wheel;
  
  //optional parameter
  private int airbags;
  
  public String getEngine() {
    return this.engine;
  }
  
  public int getWheel() {
    return this.wheel;
  }
  
  public int getAirbags() {
    return this.airbags;
  }
  
  private Vehicle(VehicleBuilder builder) {
    this.engine = builder.engine;
    this.wheel = builder.wheel;
    this.airbags = builder.airbags;
  }
  
  public static class VehicleBuilder {
    private String engine;
    private int wheel;
    
    private int airbags;
    
    public VehicleBuilder(String engine, int wheel) {
      this.engine = engine;
      this.wheel = wheel;
    }
    
    public VehicleBuilder setAirbags(int airbags) {
      this.airbags = airbags;
      return this;
    }
    
    public Vehicle build() {
      return new Vehicle(this);
    }
  }
}

public class BuilderPatternExample {
  
  public static void main(String[] args) {
    Vehicle car = new Vehicle.VehicleBuilder("1500cc", 4).setAirbags(4).build();
    Vehicle bike = new Vehicle.VehicleBuilder("250cc", 2).build();
    
    System.out.println(car.getEngine());
    System.out.println(car.getWheel());
    System.out.println(car.getAirbags());
    
    System.out.println(bike.getEngine());
    System.out.println(bike.getWheel());
    System.out.println(bike.getAirbags());
  }
}
```
---
###  Prototype Pattern

![image](https://user-images.githubusercontent.com/69948118/172498539-40caf98c-c16b-464c-92ce-e8e495b2ae04.png)
![image](https://user-images.githubusercontent.com/69948118/172498641-0297c1a2-02fd-4f14-af55-75518ef6b592.png)
```java
package prototype;
import java.util.ArrayList;
import java.util.List;

class Vehicle implements Cloneable {
  private List<String> vehicleList;
  
  public Vehicle() {
    this.vehicleList = new ArrayList<String>();
  }
  
  public Vehicle(List<String> list) {
    this.vehicleList = list;
  }
  
  public void insertData() {
    vehicleList.add("Honda amaze");
    vehicleList.add("Audi A4");
    vehicleList.add("Hyundai Creta");
    vehicleList.add("Maruti Baleno");
    vehicleList.add("Renault Duster");
  }
  
  public List<String> getVehicleList() {
    return this.vehicleList;
  }
  
  @Override
  public Object clone() throws CloneNotSupportedException {
    List<String> tempList = new ArrayList<String>();
    
    for(String s : this.getVehicleList()) {
      tempList.add(s);
    }
    
    return new Vehicle(tempList);
  }
}

public class PrototypePatternExample {

  public static void main(String[] args) throws CloneNotSupportedException {
    Vehicle a = new Vehicle();
    a.insertData();
    
    Vehicle b = (Vehicle) a.clone();
    List<String> list = b.getVehicleList();
    list.add("Honda new Amaze");
    
    System.out.println(a.getVehicleList());
    System.out.println(list);
    
    b.getVehicleList().remove("Audi A4");
    System.out.println(list);
    System.out.println(a.getVehicleList());
  }

}
```
---
## 2. Structural Design Pattern
### Proxy Pattern
![image](https://user-images.githubusercontent.com/69948118/172499361-c6c61982-a283-433a-8279-82f40e209ad6.png)
![image](https://user-images.githubusercontent.com/69948118/172499536-93f5ba48-663a-4f02-9af5-f8295aa51886.png)

```java
package proxy;
interface DatabaseExecuter {
  public void executeDatabase(String query) throws Exception;
}

class DatabaseExecuterImpl implements DatabaseExecuter {

  @Override
  public void executeDatabase(String query) throws Exception {
    System.out.println("Going to execute Query: " + query);
  }
  
}

class DatabaseExecuterProxy implements DatabaseExecuter {
  boolean ifAdmin;
  DatabaseExecuterImpl dbExecuter;
  
  public DatabaseExecuterProxy(String name, String passwd) {
    if(name == "Admin" && passwd == "Admin@123") {
      ifAdmin = true;
    }
    dbExecuter = new DatabaseExecuterImpl();
  }

  @Override
  public void executeDatabase(String query) throws Exception {
    if(ifAdmin) {
      dbExecuter.executeDatabase(query);
    } else {
      if(query.equals("DELETE")) {
        throw new Exception("DELETE not allowed for non-admin user");
      } else {
        dbExecuter.executeDatabase(query);
      }
    }
  }
}

public class ProxyPatternExample {

  public static void main(String[] args) throws Exception {
    DatabaseExecuter nonAdminExecuter = new DatabaseExecuterProxy("NonAdmin", "Admin@123");
    nonAdminExecuter.executeDatabase("DELEE");
    
    DatabaseExecuter nonAdminExecuterDELETE = new DatabaseExecuterProxy("NonAdmin", "Admin@123");
    nonAdminExecuterDELETE.executeDatabase("DELETE");

    
    DatabaseExecuter adminExecuter = new DatabaseExecuterProxy("Admin", "Admin@123");
    adminExecuter.executeDatabase("DELETE");
    
  }

}
```
### Facade Pattern
![image](https://user-images.githubusercontent.com/69948118/172500167-eb8ac5f6-51c6-4428-a25f-feb0000a09c3.png)
![image](https://user-images.githubusercontent.com/69948118/172500340-f3e86597-cf13-4749-9c78-1005c711a6df.png)

```java
package facade;
import java.sql.Driver;

class Firefox {
  public static Driver getFirefoxDriver() {
    return null;
  }
  
  public static void generateHTMLReport(String test, Driver driver) {
    System.out.println("Generating HTML Report for Firefox Driver");
  }
  
  public static void generateJUnitReport(String test, Driver driver) {
    System.out.println("Generating JUNIT Report for Firefox Driver");
  }
}

class Chrome {
  public static Driver getChromeDriver() {
    return null;
  }
  
  public static void generateHTMLReport(String test, Driver driver) {
    System.out.println("Generating HTML Report for Chrome Driver");
  }
  
  public static void generateJUnitReport(String test, Driver driver) {
    System.out.println("Generating JUNIT Report for Chrome Driver");
  }
}

class WebExplorerHelperFacade {
  public static void generateReports(String explorer, String report, String test) {
    Driver driver = null;
    switch(explorer) {
    case "firefox":
      driver = Firefox.getFirefoxDriver();
      switch(report) {
      case "html":
        Firefox.generateHTMLReport(test, driver);
        break;
      case "junit":
        Firefox.generateJUnitReport(test, driver);
        break;
      }
    break;
    case "chrome":
      driver = Chrome.getChromeDriver();
      switch(report) {
      case "html":
        Chrome.generateHTMLReport(test, driver);
        break;
      case "junit":
        Chrome.generateJUnitReport(test, driver);
        break;
      }
    }
  }
}


public class FacadePatternExample {

  public static void main(String[] args) {
    String test = "CheckElementPresent";
    
    WebExplorerHelperFacade.generateReports("firefox", "html", test);
    WebExplorerHelperFacade.generateReports("firefox", "junit", test);
    WebExplorerHelperFacade.generateReports("chrome", "html", test);
    WebExplorerHelperFacade.generateReports("chrome", "junit", test);
  }

}
```
---
### Composite Pattern
![image](https://user-images.githubusercontent.com/69948118/172500727-69bd4e54-6c5e-44bf-98a7-43174e2888f7.png)
![image](https://user-images.githubusercontent.com/69948118/172501001-23a2c3ce-2f41-4ae3-90f0-c2111e318427.png)
```java
package composite;

import java.util.ArrayList;
import java.util.List;

abstract class Account {
  public abstract float getBalance();
}

class DepositeAccount extends Account {
  private String accountNo;
  private float accountBalance;

  public DepositeAccount(String accountNo, float accountBalance) {
    super();
    this.accountNo = accountNo;
    this.accountBalance = accountBalance;
  }

  public float getBalance() {
    return accountBalance;
  }

}

class SavingAccount extends Account {
  private String accountNo;
  private float accountBalance;

  public SavingAccount(String accountNo, float accountBalance) {
    super();
    this.accountNo = accountNo;
    this.accountBalance = accountBalance;
  }

  public float getBalance() {
    return accountBalance;
  }
}

class CompositeAccount extends Account {
  private float totalBalance;
  private List<Account> accountList = new ArrayList<Account>();

  public float getBalance() {
    totalBalance = 0;
    for (Account f : accountList) {
      totalBalance = totalBalance + f.getBalance();
    }
    return totalBalance;
  }

  public void addAccount(Account acc) {
    accountList.add(acc);
  }

  public void removeAccount(Account acc) {
    accountList.add(acc);
  }
}

public class Client {

  public static void main(String[] args) {
    CompositeAccount component = new CompositeAccount();

    component.addAccount(new DepositeAccount("DA001", 100));
    component.addAccount(new DepositeAccount("DA002", 150));
    component.addAccount(new SavingAccount("SA001", 200));

    float totalBalance = component.getBalance();
    System.out.println("Total Balance : " + totalBalance);
  }

}
```
---
### Decorator Pattern
![image](https://user-images.githubusercontent.com/69948118/172501416-0a60c0da-e440-4bfb-8a81-138ab4290997.png)
![image](https://user-images.githubusercontent.com/69948118/172501564-1b0de5c6-982a-4246-9637-2e5a52b79a0f.png)
```java
package decorator;

interface Dress {
  public void assemble();
}

class BasicDress implements Dress {
  @Override
  public void assemble() {
    System.out.println("Basic Dress Features");
  }
}

class DressDecorator implements Dress {
  protected Dress dress;
  
  public DressDecorator(Dress c) {
    this.dress = c;
  }

  @Override
  public void assemble() {
    this.dress.assemble();
  }
}

class CasualDress extends DressDecorator {
  public CasualDress(Dress c) {
    super(c);
  }
  
  @Override
  public void assemble() {
    super.assemble();
    System.out.println("Adding Casual Dress Features");
  }
}


class SportyDress extends DressDecorator {
  public SportyDress(Dress c) {
    super(c);
  }
  
  @Override
  public void assemble() {
    super.assemble();
    System.out.println("Adding Sporty Dress Features");
  }
}

class FancyDress extends DressDecorator {
  public FancyDress(Dress c) {
    super(c);
  }
  
  @Override
  public void assemble() {
    super.assemble();
    System.out.println("Adding Fancy Dress Features");
  }
}

public class DecoratorPatterTest {

  public static void main(String[] args) {

    Dress sportyDress = new SportyDress(new BasicDress());
    sportyDress.assemble();
    System.out.println();
    
    Dress fancyDress = new FancyDress(new BasicDress());
    fancyDress.assemble();
    System.out.println();
    
    Dress casualDress = new CasualDress(new BasicDress());
    casualDress.assemble();
    System.out.println();
    
    
    Dress sportyFancyDress = new SportyDress(new FancyDress(new BasicDress()));
    sportyFancyDress.assemble();
    System.out.println();
    
    Dress casualFancyDress = new CasualDress(new FancyDress(new BasicDress()));
    casualFancyDress.assemble();
    
  }
}
```



