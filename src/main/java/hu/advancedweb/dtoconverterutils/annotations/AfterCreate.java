package hu.advancedweb.dtoconverterutils.annotations;

import hu.advancedweb.dtoconverterutils.AfterCreateConverter;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.ANNOTATION_TYPE, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface AfterCreate {
	Class<? extends AfterCreateConverter> value();
}
