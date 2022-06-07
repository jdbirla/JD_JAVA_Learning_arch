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





