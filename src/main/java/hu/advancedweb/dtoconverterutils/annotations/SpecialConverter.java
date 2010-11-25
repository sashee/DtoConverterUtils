package hu.advancedweb.dtoconverterutils.annotations;

import hu.advancedweb.dtoconverterutils.SpecialFieldConverter;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.METHOD, ElementType.ANNOTATION_TYPE, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface SpecialConverter {
	Class<? extends SpecialFieldConverter> value();
}
