package dto.validation;

@FunctionalInterface
public interface Validator<T> {
    boolean validate(T dto);

    default boolean stringParamValidate(String param, String regex) {
        return param.matches(regex);
    }

    default boolean numberParamValid(long param, long minValue, long maxValue) {
        return param > minValue || param < maxValue;
    }
}
