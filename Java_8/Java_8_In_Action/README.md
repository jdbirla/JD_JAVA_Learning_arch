Java8InAction
===============

## Books instructions
This repository contains all the source code for the examples and quizzes in the book Java 8 in Action: Lambdas, Streams and functional-style programming.

You can purchase the book here: [http://manning.com/urma/](http://manning.com/urma/) or on Amazon

The source code for all examples can be found in the directory [src/main/java/lambdasinaction](https://github.com/java8/Java8InAction/tree/master/src/main/java/lambdasinaction)

* Chapter 1: Java 8: why should you care?
* Chapter 2: Passing code with behavior parameterization
* Chapter 3: Lambda expressions
* Chapter 4: Working with Streams
* Chapter 5: Processing data with streams
* Chapter 6: Collecting data with streams
* Chapter 7: Parallel data processing and performance
* Chapter 8: Refactoring, testing, debugging
* Chapter 9: Default methods
* Chapter 10: Using Optional as a better alternative to null
* Chapter 11: CompletableFuture: composable asynchronous programming
* Chapter 12: New Date and Time API
* Chapter 13: Thinking functionally
* Chapter 14: Functional programming techniques
* Chapter 15: Blending OOP and FP: comparing Java 8 and Scala
* Chapter 16: Conclusions and "where next" for Java
* Appendix A: Miscellaneous language updates
* Appendix B: Miscellaneous library updates
* Appendix C: Performing multiple operations in parallel on a Stream
* Appendix D: Lambdas and JVM bytecode
We will update the repository as we update the book. Stay tuned!

### Make sure to have JDK8 installed
The latest binary can be found here: http://www.oracle.com/technetwork/java/javase/overview/java8-2100321.html

$ java -version

java version "1.8.0_05"
Java(TM) SE Runtime Environment (build 1.8.0_05-b13)
Java HotSpot(TM) 64-Bit Server VM (build 25.5-b02, mixed mode)


You can download a preview version here: https://jdk8.java.net/

### Compile/Run the examples
Using maven:

$ mvn compile

$ cd target/classes

$ java lambdasinaction/chap1/FilteringApples


Alternatively you can compile the files manually inside the directory src/main/java

You can also import the project in your favorite IDE:
    * In IntelliJ use "File->Open" menu and navigate to the folder where the project resides
    * In Eclipse use "File->Import->Existing Maven Projects" (also modify "Reduntant super interfaces" to report as Warnings instead of Errors
    * In Netbeans use "File->Open Project" menu
    
---
## Jd Learning
### Java-migoscode:
 ![image](https://user-images.githubusercontent.com/69948118/176043997-625126d1-ae18-4018-aaab-d280e01b074e.png)
![image](https://user-images.githubusercontent.com/69948118/176044007-16ded556-b074-4342-8250-5159b54fd6be.png)

### Java in action:

### Chapter 1. Java 8: why should you care?

![image](https://user-images.githubusercontent.com/69948118/176044065-20e0a33d-4c53-4b92-be59-324fd63a6245.png)

Chapter 2. Passing code with behavior Parameterization

![image](https://user-images.githubusercontent.com/69948118/176044290-b4628d1d-f68a-49c7-af69-99778d7494fe.png)
Chapter 3. Lambda expressions
 ![image](https://user-images.githubusercontent.com/69948118/176044354-a315a8a8-e915-4887-baf4-768640c84480.png)

![image](https://user-images.githubusercontent.com/69948118/176044369-adad87a4-a719-4d33-a3d1-4cac2c1d432d.png)

![image](https://user-images.githubusercontent.com/69948118/176044373-337aa810-307d-45ff-a069-ab71f00d58ed.png)
![image](https://user-images.githubusercontent.com/69948118/176044384-594bfb81-9d6f-4190-89d7-518b5215973c.png)
![image](https://user-images.githubusercontent.com/69948118/176044396-4c539a66-24c3-4df0-8361-0017a66c63cf.png)
![image](https://user-images.githubusercontent.com/69948118/176044412-c3b654c9-bfb5-4ba9-872f-d156fa7322d3.png)
![image](https://user-images.githubusercontent.com/69948118/176044428-049bedeb-e3fb-4274-9b35-16e6584335aa.png)

![image](https://user-images.githubusercontent.com/69948118/176044438-780dcba2-4099-4dee-b910-2e423a4e4c15.png)
![image](https://user-images.githubusercontent.com/69948118/176044449-796dfd11-6327-4c1a-81a8-470ec15230c4.png)
![image](https://user-images.githubusercontent.com/69948118/176044462-233f6a7f-8cd3-4a06-a3ae-6bda1086bdfe.png)
![image](https://user-images.githubusercontent.com/69948118/176044494-e1676a4c-9cd3-4b6e-8bc3-e05bf0e1f247.png)

Table 3.2. Common functional interfaces in Java 8

![image](https://user-images.githubusercontent.com/69948118/176044501-7f0cf678-a102-4b2b-b871-8ec94d2b8044.png)

![image](https://user-images.githubusercontent.com/69948118/176044514-1971641b-6602-4b78-baf3-b3ddf0264a98.png)

![image](https://user-images.githubusercontent.com/69948118/176044527-c6888fd2-0a90-41b8-8f12-8e4c109c0a0c.png)
![image](https://user-images.githubusercontent.com/69948118/176044538-eb64765f-3cb8-4cd7-ac42-a9d625905e52.png)

![image](https://user-images.githubusercontent.com/69948118/176044580-b84170ca-4e36-487f-8a22-9dd9634dcf4d.png)


Chapter 4. Introducing streams

![image](https://user-images.githubusercontent.com/69948118/176044602-100d0f7a-7f6c-4817-9e26-42fb930344cc.png)

Chapter 5. Working with streams
![image](https://user-images.githubusercontent.com/69948118/176044837-c0aae1c8-49bc-49bf-b0c1-0aca252cd7c7.png)
![image](https://user-images.githubusercontent.com/69948118/176044853-a464e60e-11eb-450d-9a81-c8839e31a3ae.png)



```java
package streams.world;
 
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
 
public class JavaInActionExcercise1 {
 
public static void main(String[] args) {
List<Transaction> transactions = dataPopulate();
 
System.out.println("transactions : " + transactions);
 
System.out
.println("*****//Q1: Find all transactions in the year 2011 and sort them by value(small to high)***");
 
List<Transaction> transaction2011 = transactions.stream().filter(t -> t.getYear() == 2011)
.sorted(Comparator.comparing(Transaction::getValue)).collect(Collectors.toList());
System.out.println("transaction2011 : " + transaction2011);
System.out.println("*******************************************************************************");
 
System.out.println("*****//Q2: What are all the unique cities where the traders work***");
 
List<String> uniqueCities = transactions.stream().map(Transaction::getTrader).map(Trader::getCity).distinct()
.collect(Collectors.toList());
 
System.out.println("uniqueCities : " + uniqueCities);
 
System.out.println("*****//Q3 :  Find all traders from Cambridge and sort them by name***");
List<Trader> listTraders = transactions.stream().map(Transaction::getTrader)
.filter(t -> t.getCity() == "Cambridge").sorted(Comparator.comparing(Trader::getName))
.collect(Collectors.toList());
System.out.println("listTraders : " + listTraders);
 
System.out.println("*****//Q4 :  Return a string of all traders names sorted alphabetically***");
 
String sortedNames = transactions.stream().map(t -> t.getTrader().getName()).distinct().sorted().reduce("",
(n1, n2) -> n1 + " " + n2);
System.out.println("SortedNames : " + sortedNames);
 
System.out.println("*****//Q5 : Are any traders based in Milan***");
System.out.println(transactions.stream().map(Transaction::getTrader).anyMatch(t -> t.getCity() == "Milan"));
 
System.out.println(
transactions.stream().map(Transaction::getTrader).filter(t -> t.getCity() == "Milan").findAny());
 
System.out.println("*****//Q6 :Print all transactions values from the traders living in cambridge ***");
List<Integer> listCambridgeTrx = transactions.stream().filter(t -> t.getTrader().getCity() == "Cambridge")
.map(Transaction::getValue).collect(Collectors.toList());
System.out.println("listCambridgeTrx : " + listCambridgeTrx);
 
System.out.println("*****//Q7 :What's the highest value of all the transaction?***");
Optional<Integer> highestValue = transactions.stream().map(Transaction::getValue).reduce(Integer::max);
System.out.println("highestValue : " + highestValue.get());
 
System.out.println("*****//Q8 :Find the transaction with the smallest value***");
Optional<Transaction> smallesValue = transactions.stream()
.reduce((t1, t2) -> t1.getValue() < t2.getValue() ? t1 : t2);
System.out.println("smallesValue : " + smallesValue.get());
 
}
 
private static List<Transaction> dataPopulate() {
Trader raoul = new Trader("Raoul", "Cambridge");
Trader mario = new Trader("Mario", "Milan");
Trader alan = new Trader("Alan", "Cambridge");
Trader brian = new Trader("Brian", "Cambridge");
 
List<Transaction> transactions = Arrays.asList(new Transaction(brian, 2011, 300),
new Transaction(raoul, 2012, 1000), new Transaction(raoul, 2011, 400),
new Transaction(mario, 2012, 710), new Transaction(mario, 2012, 700), new Transaction(alan, 2012, 950));
 
return transactions;
}
}

```

![image](https://user-images.githubusercontent.com/69948118/176044894-5b0e5b23-7a3d-4252-80fa-ca1897ca36dc.png)


Chapter 6. Collecting data with streams








 



