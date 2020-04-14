package dto.validation;

import static java.util.Objects.isNull;

@FunctionalInterface
public interface Validator<T> {
    boolean validate(T dto);

    default boolean stringParamValidate(String param, String regex) {
        return isNull(param) || !param.matches(regex);
    }

    default boolean numberParamValid(long param, long minValue, long maxValue) {
        return param > minValue || param < maxValue;
    }
}
