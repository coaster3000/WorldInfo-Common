package tk.coaster3000.worldinfo.annotations;


import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.CLASS)
@Documented
@Target(value = {ElementType.FIELD,
		ElementType.LOCAL_VARIABLE,
		ElementType.METHOD,
		ElementType.PACKAGE,
		ElementType.PARAMETER})
public @interface Nullable {
	When value() default When.MAYBE;

	String[] causes() default "";
}
