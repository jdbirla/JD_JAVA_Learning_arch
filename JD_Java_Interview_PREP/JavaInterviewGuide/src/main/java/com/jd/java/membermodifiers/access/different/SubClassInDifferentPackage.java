package com.jd.java.membermodifiers.access.different;

import com.jd.java.membermodifiers.access.ExampleClass;

public class SubClassInDifferentPackage extends ExampleClass {

	void subClassMethod() {
		publicVariable = 5;
		publicMethod();

		// privateVariable is not visible to SubClass
		// Below Line, uncommented, would give compiler error
		// privateVariable=5; //COMPILE ERROR
		// privateMethod();

		protectedVariable = 5;
		protectedMethod();

		// privateVariable is not visible to SubClass
		// Below Line, uncommented, would give compiler error
		// defaultVariable = 5; //COMPILE ERROR
		// defaultMethod();
	}
}