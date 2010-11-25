package hu.advancedweb.dtoconverterutils.customconverter;

import hu.advancedweb.dtoconverterutils.annotations.SpecialConverter;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@SpecialConverter(ToIntSpecialFieldConverter.class)
public @interface TestNamedSpecialConverter {
}
