package hu.advancedweb.dtoconverterutils.annotations.predefinedconverters;

import hu.advancedweb.dtoconverterutils.annotations.SpecialConverter;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD, ElementType.FIELD })
@SpecialConverter(ToBase64DecodedStringArraySpecialFieldConverter.class)
public @interface Base64DecodedStringArray {

}
