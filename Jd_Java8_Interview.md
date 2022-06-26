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
