package com.total.demands.domain.validators;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DemandsDomainIdValidatorTest {

    @Test
    public void testBlankDesc() {
        assertThat(DemandsIdValidator.validate(null)).contains(ValidationError.EMPTY_FIELD);
    }

    @Test
    public void testNoBlankDesc() {
        assertThat(DemandsIdValidator.validate(-4545L)).contains(ValidationError.INVALID_NUMBER);
    }
}
