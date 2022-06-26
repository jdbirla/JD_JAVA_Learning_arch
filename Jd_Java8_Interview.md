# Java 8 Interview

### Example Instructor
```java
public static List<Instructor> getAll(){
        Instructor instructor1 = new Instructor("Mike", 10, "Software Developer"
         , "M", true, Arrays.asList("Java Programming", "C++ Programming", "Python Programming"));

        Instructor instructor2 = new Instructor("Jenny", 5, "Engineer"
                , "F", false, Arrays.asList("Multi-Threaded Programming", "CI/CD", "Unit Testing"));

        Instructor instructor3 = new Instructor("Gene", 6, "Manager"
                , "M", false, Arrays.asList("C++ Programming", "C Programming", "React Native"));

        Instructor instructor4 = new Instructor("Anthony", 15, "Senior Developer"
                , "M", true, Arrays.asList("Java Programming", "Angular Programming", "React Native"));

        Instructor instructor5 = new Instructor("Syed", 15, "Principal Engineer"
                , "M", true, Arrays.asList("Java Programming", "Java Multi-Threaded Programming", "React Native"));

        List<Instructor> list = Arrays.asList(instructor1,instructor2,instructor3,instructor4,instructor5);
        return list;

    }
```
### Consumer
```java
 List<Instructor> instructors = Instructors.getAll();
        Consumer jdprint = (s1) -> System.out.print("   ::  -->");
        Consumer jdprint1 = (s1) -> System.out.print("\n");
	
  instructors.forEach(s1->{ 
			  if(s1.yearsOfExperience > 5 && s1.isOnlineCourses())
			  {
		  c1.andThen(jdprint).andThen(c2).andThen(jdprint1).accept(s1); } }
		  );
```
### Predictate
```java
List<Instructor> instructors = Instructors.getAll();
        BiPredicate<Boolean, Integer> p3 = (online, experience) -> online==true && experience>10;

        //Biconsumer print name and courses
        BiConsumer<String, List<String>> biConsumer = (name, courses) ->
                System.out.println("name is: " + name + " courses : " + courses);

        instructors.forEach(instructor -> {
            if(p3.test(instructor.isOnlineCourses(), instructor.getYearsOfExperience()))
                biConsumer.accept(instructor.getName(), instructor.getCourses());
        });
```
 ### Function
 ```java
   //Map of instructors with name and years of experience
        //Function which will List<Instructors> and return a Map<String, Integer>
        //Predicate will return true if instructor has online courses
        Predicate<Instructor> p1 = (i) -> i.isOnlineCourses()==true;
        Function<List<Instructor>, Map<String,Integer>> mapFunction = (instructors -> {
            Map<String,Integer> map = new HashMap<>();
            instructors.forEach(instructor -> {
                if(p1.test(instructor)) {
                    map.put(instructor.getName(), instructor.getYearsOfExperience());
                }
            });
            return map;
        });

        System.out.println(mapFunction.apply(Instructors.getAll()));
    }
    
   //BiFunction
    //Bifuction 2 inputs List<Instructors> and second is predicate which will filter if instructor has online
        //courses and return a map of <String,Integer> string is name and Integer is the years of experience

        Predicate<Instructor> p1 = (i) -> i.isOnlineCourses()==true;
        BiFunction<List<Instructor>, Predicate<Instructor>, Map<String,Integer>> mapBiFunction =
                ((instructors, instructorPredicate) -> {
                    Map<String, Integer> map = new HashMap<>();
                    instructors.forEach(instructor -> {
                        if(instructorPredicate.test(instructor)){
                            map.put(instructor.getName(), instructor.getYearsOfExperience());
                        }
                    });
                    return map;
                });
        System.out.println(mapBiFunction.apply(Instructors.getAll(), p1));
   
```
### Supplier
```java
 Supplier<Integer> supplier = () -> (int) (Math.random() * 1000);
        System.out.println(supplier.get());
```
### MethodReferenceExample 
```java
 Predicate<Instructor> p2 = ConvertToMethodReferenceExample::greaterThanTenYearsOfExperience;

        Instructors.getAll().forEach(instructor -> {
                if (p2.test(instructor)){
                    System.out.println(instructor);
                }
        });
    }
    public static boolean greaterThanTenYearsOfExperience(Instructor instructor) {
        if (instructor.getYearsOfExperience()>10)
            return true;
        return false;
    }
```
### VariableScope
```java
 static int l=0;
    public static void main(String[] args) {
        //Case1
    	//int a =10; //local variable
       // IntConsumer intConsumer = (a) -> System.out.println(a*10); //Compile time Error {Lambda expression's parameter a cannot redeclare another local variable defined in an enclosing scope. }

    	int b =10; //local variable
        IntConsumer intConsumer = (a) -> System.out.println(a*10); //

        //Case 2
        int k=0;
        List<Instructor> instructors =  Instructors.getAll();
        instructors.forEach(instructor  ->{
       //  	System.out.println( k++); //Compile time Error  {Local variable k defined in an enclosing scope must be final or effectively final}
        });
        
        //Case 3
     
        List<Instructor> instructors1 =  Instructors.getAll();
        instructors1.forEach(instructor  ->{
        	System.out.println( instructor + " " +l); //No error as variable define as class level and its static
            l++;
        });
        		
        
    }
```
## Stream
#### Map

```java
 //return only instructor names from the instructor list
        Set<String> instructorNames = Instructors.getAll().stream()
                                        .map(Instructor::getName)
                                        .map(String::toUpperCase)
                                        .collect(Collectors.toSet());
        System.out.println(instructorNames);
```
###  FlatMap

```java
 //Get a list of all the courses which instructors offers
        Set<String> instructorsCourses = Instructors.getAll().stream()
                                        .map(Instructor::getCourses)
                                        .flatMap(List::stream)
                                        .collect(Collectors.toSet());
        System.out.println(instructorsCourses);
```
### distinct,count,sorted, allmatch and NoneMatch
```java
//count   distinct :: Returns the count of elements in this stream.

        Long count = Instructors.getAll().stream()
                .map(Instructor::getCourses)
                .flatMap(List::stream)
                .distinct()
                .count();

        System.out.println(count);
        //distinct Returns a stream consisting of the distinct elements (according to Object.equals(Object)) of this stream.

        List<String> courses = Instructors.getAll().stream()
                .map(Instructor::getCourses)
                .flatMap(List::stream)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        System.out.println(courses);

        //anymatch,  true if any elements of the stream match the provided predicate, otherwise false


        boolean match = Instructors.getAll().stream()
                .map(Instructor::getCourses)
                .flatMap(List::stream)
                .anyMatch(s-> s.startsWith("J"));
        
        System.out.println(match);
        // allmatch : true if either all elements of the stream match the provided predicate or the stream is empty, otherwise false

        boolean allmatch = Instructors.getAll().stream()
                .map(Instructor::getCourses)
                .flatMap(List::stream)
                .allMatch(s-> s.startsWith("J"));
        
        System.out.println(allmatch);
        
        //None mathc : true if either no elements of the stream match the provided predicate or the stream is empty, otherwise false

        boolean nonematch = Instructors.getAll().stream()
                .map(Instructor::getCourses)
                .flatMap(List::stream)
                .noneMatch(s-> s.startsWith("J"));
   //an Optional describing some element of this stream, or an empty Optional if the stream is empty     
	Optional<T> findAny()
	
  // findFirst :: an Optional describing the first element of this stream, or an empty Optional if the stream is empty

  Optional<T> findFirst()
  
  
  //limit :: Returns a stream consisting of the elements of this stream, truncated to be no longer than maxSize in length.
  Stream<T>	limit(long maxSize)
	

// max :: Returns the maximum element of this stream according to the provided Comparator. This is a special case of a reduction.
Optional<T> max(Comparator<? super T> comparator)

// min: Returns the minimum element of this stream according to the provided Comparator. This is a special case of a reduction.

Optional<T> min(Comparator<? super T> comparator)

//skip ::Returns a stream consisting of the remaining elements of this stream after discarding the first n elements of the stream. If this stream contains fewer than n elements then an empty stream will be returned.
Stream<T> skip(long n)

// sorted :: Returns a stream consisting of the elements of this stream, sorted according to natural order. If the elements of this stream are not Comparable, a java.lang.ClassCastException may be thrown when the terminal operation is executed
Stream<T> sorted()

//  sorted :: Returns a stream consisting of the elements of this stream, sorted according to the provided Comparator.
For ordered streams, the sort is stable. For unordered streams, no stability guarantees are made.
Stream<T> sorted(Comparator<? super T> comparator)

// 

```
### 
```java

```

```java

```

```java

```

```java

```

```java

```

```java

```

```java

```

```java

```

```java

```

