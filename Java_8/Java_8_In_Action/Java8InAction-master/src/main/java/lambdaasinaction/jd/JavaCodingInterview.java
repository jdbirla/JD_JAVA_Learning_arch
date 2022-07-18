package lambdaasinaction.jd;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
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
         System.out.println("-------------------------------------------------");
         String someString1 = "Jitendra Birla";
         // String[] arrstr =  someString1.split("");  
          String[] arrstr =  someString1.replaceAll("\\W","").split("");   
           Stream s1 = Arrays.stream(arrstr);
           Map<String, Long> collectjd= (Map<String, Long>) s1.collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
           System.out.println(collectjd);
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
	  

	   System.out.println("-========================================================");

      System.out.println("Que 12: Reduce operation practice");
      List<Integer> numbers = Arrays.asList(3, 7, 8, 1, 5, 9);

	   Optional<Integer> reduce = numbers.stream().reduce((a,b)->a+b);
	   if(reduce.isPresent())
		   System.out.println(reduce.get());
	   Optional<Integer> reduce1 = numbers.stream().reduce(Integer::sum);
	   if(reduce1.isPresent())
		   System.out.println(reduce1.get());
     
	   Integer maxval = numbers.stream().reduce(0,(a,b) -> a>b?a:b);
		   System.out.println(maxval);
		   
		   Integer maxval2 = numbers.stream().reduce(Integer::max).get();
		   System.out.println(maxval2);


	  List<String> words = Arrays.asList("corejava", "spring", "hibernate");
	  Optional<String> reduce2 = words.stream().reduce((a,b) -> a.length()>b.length()?a:b);
	  System.out.println(reduce2.get());

	  Double asa = EmployeeDatabase.getEmployees().stream().filter(A -> A.getGrade()=="A").map(Employee::getSalary).mapToDouble(a->a).average().getAsDouble();
	
	System.out.println(asa);
	   System.out.println("-========================================================");

	      System.out.println("Que 12: Assume you have list of employee in various dept, WAP to find highest paid employee from each dept");
		
	      BinaryOperator<Employee> be = (a,b) -> a.getSalary()>b.getSalary()?a:b;
	      Map<String, Optional<Employee>> collect7 = EmployeeDatabase.getEmployees().stream().collect(
	    		  Collectors.groupingBy(
	    				  Employee::getDept,Collectors.reducing(be))
	    		  );
	        System.out.println("Que 12:Programe to sort employee data base on salary and return in Map");
	// https://javarevisited.blogspot.com/2017/09/java-8-sorting-hashmap-by-values-in.html#axzz7ZNa70ML6
	}

  
};

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
    };
 }
  

class Employee {
        private int id;
        private String name;
        private String grade;
        private String dept;
        private double salary;

        public Employee() {
        }

		public Employee(int id, String name, String grade, String dept, double salary) {
			super();
			this.id = id;
			this.name = name;
			this.grade = grade;
			this.dept = dept;
			this.salary = salary;
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

		public String getGrade() {
			return grade;
		}

		public void setGrade(String grade) {
			this.grade = grade;
		}

		public String getDept() {
			return dept;
		}

		public void setDept(String dept) {
			this.dept = dept;
		}

		public double getSalary() {
			return salary;
		}

		public void setSalary(double salary) {
			this.salary = salary;
		}

		@Override
		public String toString() {
			return "Employee [id=" + id + ", name=" + name + ", grade=" + grade + ", dept=" + dept + ", salary="
					+ salary + "]";
		}



        

    };
    
     class EmployeeDatabase {


        public static List<Employee> getEmployees(){
          return  Stream.of(new Employee(101,"john","A","DEV",60000),
                  new Employee(109,"peter","B","DEV",30000),
                  new Employee(102,"mak","A","QA",80000),
                  new Employee(103,"kim","A","QA",90000),
                  new Employee(104,"json","C","DEVOPS",15000))
                  .collect(Collectors.toList());
        }
    }
