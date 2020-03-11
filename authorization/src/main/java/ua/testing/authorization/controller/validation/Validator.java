package ua.testing.authorization.controller.validation;

public interface Validator<DTO> {
    boolean isValid(DTO dto);
}
