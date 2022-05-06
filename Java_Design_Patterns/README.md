# Java Design Patterns For Beginners


## Example Java Files
### src/com/in28minutes/patterns/AdapterPattern.java
```
package com.in28minutes.patterns;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*
 * translates one interface for a class into a compatible interface.[1] An adapter allows classes to work together that normally could not because of incompatible interfaces
 */
public class AdapterPattern {
	static class CountriesInterface {
		public List<String> getList() {
			List<String> countries = Arrays.asList("IND",
					"PAK", "SL");
			return countries;
		}
	}
	static class CountriesAdapter {
		private static Map<String, String> countryCodeNameMapping = new HashMap<String, String>();
		static {
			countryCodeNameMapping.put("IND", "India");
			countryCodeNameMapping.put("PAK", "Pakistan");
			countryCodeNameMapping.put("SL", "Sri Lanka");
			//...A lot of others as well
		}
		public List<String> getTranslatedList() {
			List<String> countryCodes = new CountriesInterface()
					.getList();
			List<String> countryNames = new ArrayList<String>();
			for (String country : countryCodes) {
				countryNames.add(countryCodeNameMapping
						.get(country));
			}
			return countryNames;
		}
	}
	public static void main(String[] args) {
		System.out.println(new CountriesAdapter()
				.getTranslatedList());
	}
}
```
### src/com/in28minutes/patterns/BuilderPattern.java
```
package com.in28minutes.patterns;
public class BuilderPattern {
	static class Coffee {
		private Coffee(Builder builder) {
			this.type = builder.type;
			this.sugar = builder.sugar;
			this.milk = builder.milk;
			this.size = builder.size;
		}
		private String type;//Should be a enum Lazy bum
		private boolean sugar;
		private boolean milk;
		private String size;//Should be a enum Lazy bum
		public static class Builder {
			private String type;//Should be a enum Lazy bum
			private boolean sugar;
			private boolean milk;
			private String size;//Should be a enum Lazy bum
			public Builder(String type) {
				this.type = type;
			}
			public Builder sugar(boolean value) {
				sugar = value;
				return this;
			}
			public Builder milk(boolean value) {
				milk = value;
				return this;
			}
			public Builder size(String value) {
				size = value;
				return this;
			}
			public Coffee build() {
				return new Coffee(this);
			}
		}
		@Override
		public String toString() {
			return String
					.format("Coffee [type=%s, sugar=%s, milk=%s, size=%s]",
							type, sugar, milk, size);
		}
	}
	public static void main(String[] args) {
		Coffee coffee = new Coffee.Builder("Mocha").milk(
				true).sugar(false).size("Large").build();
		System.out.println(coffee);
		
		//Simplifies Creation
		//More Readable Code
		//Values cannot be modified
	}
}
```
### src/com/in28minutes/patterns/FactoryPattern.java
```
package com.in28minutes.patterns;
/*
 * instantiate an object from one among a set of classes based on some logic
 */
public class FactoryPattern {
	public static class PersonFactory {
		public static Person getPerson(String name,
				String gender) {
			if(gender.equalsIgnoreCase("M")){
				return new Male(name);
			}else if(gender.equalsIgnoreCase("F")){
				return new Female(name);
			} //So on..
			return null;
		}
	}
	static abstract class Person {
		Person(String name){
			this.name = name;
		}
		private String name;
		abstract String getSalutation();
		String getNameAndSalutation(){
			return getSalutation() + " " + name;
		}
	}
	
	static class Male extends Person{
		public Male(String name) {
			super(name);
		}
		@Override
		String getSalutation() {
			return "Mr";
		}
		
	}
	
	static class Female extends Person{
		public Female(String name) {
			super(name);
		}
		@Override
		String getSalutation() {
			return "Miss/Mrs";
		}
		
	}
	
	public static void main(String[] args) {
		Person male = PersonFactory.getPerson("Robinhood","M");
		System.out.println(male.getNameAndSalutation());
		Person female = PersonFactory.getPerson("Mary","F");
		System.out.println(female.getNameAndSalutation());
	}
}
```
### src/com/in28minutes/patterns/MySingletonUsingEnum.java
```
package com.in28minutes.patterns;
public enum MySingletonUsingEnum {
	INSTANCE;
	private MySingletonUsingEnum() {
		System.out.println("Here");
	}
	public String retrieveSomething() {
		return "DUMMY";
	}
}
```
### src/com/in28minutes/patterns/ObserverPattern.java
```
package com.in28minutes.patterns;
import java.util.ArrayList;
import java.util.List;
/*
 * You want to know when an event happens
 */
public class ObserverPattern {
	static class SachinCenturyNotifier{
		List<SachinFan> fans = new ArrayList<SachinFan>();
		void register(SachinFan fan){
			fans.add(fan);
		}
		void sachinScoredACentury(){
			for(SachinFan fan:fans){
				fan.announce();
			}
		}
	}
	
	static class SachinFan {
		private String name;
		SachinFan(String name){
			this.name = name;
		}
		void announce(){
			System.out.println(name + "  notified");
		}
	}
	
	public static void main(String[] args) {
		SachinCenturyNotifier notifier = new SachinCenturyNotifier();
		notifier.register(new SachinFan("Ranga"));
		notifier.register(new SachinFan("Ramya"));
		notifier.register(new SachinFan("Veena"));
		notifier.sachinScoredACentury();	
		
		/*
		 * Ranga  notified
Ramya  notified
Veena  notified
		 */
	}
}
```
### src/com/in28minutes/patterns/SingletonPattern.java
```
package com.in28minutes.patterns;
public class SingletonPattern {
	static class Singleton {
		private static Singleton instance = new Singleton();
		private Singleton() {
		}
		public static Singleton getSingleInstance() {
			return instance;
		}
	}
}
```
### src/com/in28minutes/patterns/StatePattern.java
```
package com.in28minutes.patterns;
/*
 */
public class StatePattern {
	static class FanWallControl {
		private SpeedLevel current;
		public FanWallControl() {
			current = new Off();
		}
		public void set_state(SpeedLevel state) {
			current = state;
		}
		public void rotate() {
			current.rotate(this);
		}
		@Override
		public String toString() {
			return String.format(
					"FanWallControl [current=%s]", current);
		}
	}
	interface SpeedLevel {
		void rotate(FanWallControl fanWallControl);
	}
	static class Off implements SpeedLevel {
		public void rotate(FanWallControl fanWallControl) {
			fanWallControl.set_state(new SpeedLevel1());
		}
	}
	static class SpeedLevel1 implements SpeedLevel {
		public void rotate(FanWallControl fanWallControl) {
			fanWallControl.set_state(new SpeedLevel2());
		}
	}
	static class SpeedLevel2 implements SpeedLevel {
		public void rotate(FanWallControl fanWallControl) {
			fanWallControl.set_state(new SpeedLevel3());
		}
	}
	static class SpeedLevel3 implements SpeedLevel {
		public void rotate(FanWallControl fanWallControl) {
			fanWallControl.set_state(new Off());
		}
	}
	public static void main(String[] args) {
		FanWallControl fanControl = new FanWallControl();
		System.out.println(fanControl);
		fanControl.rotate();
		System.out.println(fanControl);
		fanControl.rotate();
		System.out.println(fanControl);
		fanControl.rotate();
		System.out.println(fanControl);
		fanControl.rotate();
		
		/*
		 * 
		 * FanWallControl [current=com.rithus.patterns.StatePattern$Off@7a6d084b]
FanWallControl [current=com.rithus.patterns.StatePattern$SpeedLevel1@2352544e]
FanWallControl [current=com.rithus.patterns.StatePattern$SpeedLevel2@457471e0]
FanWallControl [current=com.rithus.patterns.StatePattern$SpeedLevel3@7ecec0c5]
		 * 
		 */
	}
}
```
### src/com/in28minutes/patterns/StrategyPattern.java
```
package com.in28minutes.patterns;
/*
 * Separates Strategy - how you do something - into a separate class.
 * Allows easy change of strategy at a later point.
 */
public class StrategyPattern {
	interface Sortable {
		public int[] sort(int[] numbers);
	}
	static class BubbleSort implements Sortable {
		@Override
		public int[] sort(int[] numbers) {
			// Ideally the bubble sort is implemented completely here
			return numbers;
		}
	}
	static class QuickSort implements Sortable {
		@Override
		public int[] sort(int[] numbers) {
			// Ideally the quick sort is implemented completely here
			return numbers;
		}
	}
	static class ComplexClass {
		Sortable sorter;
		ComplexClass(Sortable sorter) {
			this.sorter = sorter;
		}
		void doAComplexThing() {
			int[] values = null; // get from somewhere..
			// ..logic..
			sorter.sort(values);
			// ..logic..
		}
	}
	public static void main(String[] args) {
		ComplexClass complexClassInstance = new ComplexClass(new BubbleSort());
		// This can also be a setter..
		complexClassInstance.doAComplexThing();
	}
}
```