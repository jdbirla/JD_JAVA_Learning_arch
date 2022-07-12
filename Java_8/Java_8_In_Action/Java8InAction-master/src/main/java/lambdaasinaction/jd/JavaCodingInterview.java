package lambdaasinaction.jd;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JavaCodingInterview {

	public static Map<String,String> strMap;
	static
	{
		
		 strMap = new HashMap<String,String>(); 
        strMap.put("Effective Java", "Kathy Sierra");
        strMap.put("Spring in Action", "Craig Walls");
        strMap.put("Hibernate in Action", "Gavin King");
        strMap.put("Pro Angular", "Freeman");
        strMap.put("Pro Spring Boot", "Felipe Gutierrez");
	}
	
	public static void main(String[] args)
	{
		 System.out.println("Que1:How to print keys & values of a Map in Java 8 ?");

		strMap.keySet().stream().iterator().forEachRemaining(System.out::println);
	    System.out.println("-----------------------------------------------------");

		strMap.values().stream().forEach(a -> System.out.println(a));
	    System.out.println("-========================================================");

		System.out.println("Que2: How to iterate a Map containing a List of String in Java 8 ?");
        Map<String, List<String>> listOfAnimals = new HashMap<String, List<String>>();

		 // List #1: Creating list of Animals in Mammals Category
        List<String> listOfMammals = Arrays.asList("Cat", "Dog", "Monkey", "Cow"); 
        //Adding listOfMammals into Mammal's Category
        listOfAnimals.put("Mammals", listOfMammals);

        // List #2: Creating list of Animals in Birds Category
        List<String> listOfBirds = Arrays.asList("Crow", "Parrot", "Peacock", "Flamingo"); 
        //Adding listOfMammals into Bird's Category
        listOfAnimals.put("Birds", listOfBirds);

        // List #3: Creating list of Animals in Reptiles Category
        List<String> listOfReptiles = Arrays.asList("Lizard", "Turtle", "Crocodile", "Python"); 
        //Adding listOfMammals into Reptile's Category
        listOfAnimals.put("Reptiles", listOfReptiles);
        
        listOfAnimals.forEach((k,v)-> System.out.println(k+v));
        
	 
        System.out.println("-========================================================");
        System.out.println("Que3:How to count occurrences of each character of a String in Java 8?");
	
        String someString = "JAVA PROGRAMMER";
        char[] strArray = someString.toCharArray();
        
        //getting distinct characters in strArray
        Set<Character> set = new TreeSet<>();
        for (char c : strArray){
          set.add(c);
        }
        //set.forEach(System.out::println);

        for (char c : set) {
           // Using Streams & Lambda Expressions in Java 8
           long count = someString.chars().filter(ch -> ch == c).count();
           System.out.println("Occurances of Character '" +c+ "' : " +count);
        }
        System.out.println("-------------------------------------------------");

         Map<Character,Integer> cntmap = new HashMap<Character, Integer>();
         for(char c: strArray)
         {
        	 int count = 1;
        	 if(cntmap.containsKey(c))
        	 {
        		 int curCont = cntmap.get(c);
        		  cntmap.put(c,curCont+1);
        	 }else
        	 {
        	 cntmap.put(c,count);
        	 }
         }
         System.out.println(cntmap);
      
        System.out.println("-========================================================");

        System.out.println("Que4: Given a list of integers, find out all the even numbers exist in the list using Stream functions?");
	
        List<Integer> myList = Arrays.asList(10,15,8,49,25,98,32);
        myList.stream().filter(n-> n%2==0).forEach(System.out::println);
        myList.stream().filter(n-> n%2==0).iterator().forEachRemaining(System.out::println);
        
        System.out.println("-========================================================");

        System.out.println("Que4: Given a list of integers, find out all the numbers starting with 1 using Stream functions??");
        List<Integer> myList1 = Arrays.asList(10,15,8,49,25,98,32);
        myList1.stream().map(a-> a.toString()).filter(s->s.startsWith("1")).forEach(System.out::println);
	
        System.out.println("-========================================================");

        System.out.println("Que5: How to find duplicate elements in a given integers list in java using Stream functions?\r\n"
        		+ "");
        List<Integer> myList2 = Arrays.asList(10,15,8,10,25,15,32,15);
        HashSet<Integer> s =  new HashSet<Integer>();
        
        myList2.stream().filter(a -> !s.add(a)).forEach(System.out::println);
        System.out.println("----------------------------------------------------");
        myList2.stream().filter(a -> !s.add(a)).collect(Collectors.toSet()).forEach(System.out::println);

        
        System.out.println("-========================================================");

        System.out.println("Que6: Q6 Given a list of integers, find the maximum value element present in it using Stream functions?");
	   
        List<Integer> myList3 = Arrays.asList(10,15,8,49,25,98,98,32,15);
      // myList3.stream().max(Comparator.comparing(Integer::intValue)).ifPresent(System
    //		   .out::println);
        myList3.stream().distinct().collect(Collectors.maxBy(Comparator.comparing(Integer::intValue))).ifPresent(System.out::println);
        //myList3.stream().distinct().peek(System.out::println).collect(Collectors.maxBy(Comparator.comparing(Integer::intValue))).ifPresent(System.out::println);

        System.out.println("-========================================================");

        System.out.println(" Que7: Given a list of integers, sort all the values present in it using Stream functions?\r\n"
        		+ "");
        
        List<Integer> myList4 = Arrays.asList(10,15,8,49,25,98,98,32,15);
	   myList4.stream().sorted().forEach(System.out::println);
       System.out.println("--------------------------------------------------------------");

	   Comparator<Integer> com = (a1,a2)->a1.compareTo(a2);
	   myList4.sort(com);
	   System.out.println(myList4);
       System.out.println("--------------------------------------------------------------");

	   Collections.sort(myList4);
	   System.out.println(myList4);
	   
	   System.out.println("--------------------------------------------------------------");
	   Comparator<Integer> com1 = (a1,a2)-> -a1.compareTo(a2);
	   Collections.sort(myList4,com1);
	   System.out.println(myList4);
	   System.out.println("--------------------------------------------------------------");
	   Comparator<Integer> com2 = (a1,a2)-> 
	   {
		   if(a1<a2)
			 return  -1;
		   else if (a1>a2)
			   return +1;
		   else
			   return 0;
	   };
	   
	   Collections.sort(myList4,com2);
	   System.out.println(myList4);
	   
	   System.out.println("--------------------------------------------------------------");
	   Comparator<Integer> com3 = (a1,a2)-> 
	   {
		   if(a1<a2)
			 return  +1;
		   else if (a1>a2)
			   return -1;
		   else
			   return 0;
	   };
	   
	   Collections.sort(myList4,com3);
	   System.out.println(myList4);
	   
	   System.out.println("-========================================================");

       System.out.println("Que 8: Given a list of integers, sort all the values present in it in descending order using Stream functions?");
	
       List<Integer> myList6 = Arrays.asList(10,15,8,49,25,98,98,32,15);
       myList6.stream().sorted(Collections.reverseOrder()).forEach(System.out::println);

       myList6.stream().sorted(Comparator.comparing(Integer::intValue).reversed()).forEach(System.out::println);
	
       System.out.println("-========================================================");

       System.out.println("Que 9: Write a program to multiply 2 nos using functional interface");
     
       MultiplyInterface mul = (a,b) -> a*b;
       System.out.println(mul.multiply(15, 10));
       
       BinaryOperator<Integer> mul1 = (a,b) -> a*b;
       System.out.println(mul1.apply(15, 115));
	
       System.out.println("-========================================================");

       System.out.println("Que 10: Count the no of occurance of words in given string using java 8");
       String input = "welcome to code decode and code decode welcome you";
       
       List<String> list =  Arrays.asList(input.split(" "));
       
       Map<String, Long> collect = list.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
       
       System.out.println(collect);
       
       Map<String, Long> collect1 = list.stream().collect(Collectors.groupingBy(a-> a,Collectors.counting()));
       
       System.out.println(collect1);
       System.out.println("--------------------------------------------------------------");

       List<Integer> myList7 = Arrays.asList(10,15,8,10,25,15,32,15);

       Map<Integer, Long> collect2 = myList7.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
	   System.out.println(collect2);
	   
	   System.out.println("-========================================================");

       System.out.println("Que 11: Map and flatmap");

       List<Customer> customers = EkartDataBase.getAll();

	    List<String> collect3 = customers.stream().map(Customer::getEmail).collect(Collectors.toList());
	
	  System.out.println(collect3);
	   System.out.println("------------------------------------------------------------");

	  List<List<String>> collect4 = customers.stream().map(Customer::getPhoneNumbers).collect(Collectors.toList());
		
	  System.out.println(collect4);
	  
	  System.out.println("------------------------------------------------------------");

	  List<String> collect5 = customers.stream().map(Customer::getPhoneNumbers).flatMap(a-> a.stream()).collect(Collectors.toList());
		
	  System.out.println(collect5);
	  System.out.println("------------------------------------------------------------");

	  List<String> collect6 = customers.stream().flatMap(a-> a.getPhoneNumbers().stream()).collect(Collectors.toList());
		
	  System.out.println(collect6);
	}
	
	
}

interface MultiplyInterface
{
	    public int multiply(int a, int b);
	   
};


 class Customer {

    private int id;
    private String name;
    private String email;
    private List<String> phoneNumbers;

    public Customer() {
    }

    public Customer(int id, String name, String email, List<String> phoneNumbers) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNumbers = phoneNumbers;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(List<String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }
};
 class EkartDataBase {


    public static List<Customer> getAll() {
        return Stream.of(
                new Customer(101, "john", "john@gmail.com", Arrays.asList("397937955", "21654725")),
                new Customer(102, "smith", "smith@gmail.com", Arrays.asList("89563865", "2487238947")),
                new Customer(103, "peter", "peter@gmail.com", Arrays.asList("38946328654", "3286487236")),
                new Customer(104, "kely", "kely@gmail.com", Arrays.asList("389246829364", "948609467"))
        ).collect(Collectors.toList());
    }


};