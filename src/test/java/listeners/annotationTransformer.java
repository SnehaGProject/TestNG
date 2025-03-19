package listeners;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class annotationTransformer implements IAnnotationTransformer {
    public void transform(
            ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {

        if (testMethod.getName().equalsIgnoreCase("disabledTest")){
            annotation.setEnabled(false);
            System.out.println("disabled test :"+testMethod.getName());
        }
    }


}
