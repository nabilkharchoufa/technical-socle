package com.total.demands.presentation;

import com.total.demands.domain.validators.ValidationError;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class DemandsUpdateRequestDomainTest {

    @Test
    public void DemandsCreationRequestContainsErrors() {
        Throwable throwable = catchThrowable(() ->
                DemandsUpdateRequest.factory(null," ", " ", null));

        assertThat(throwable)
                .isNotNull()
                .isInstanceOf(DemandsDomainException.class);

        DemandsDomainException ex = (DemandsDomainException) throwable;
        assertThat(ex.errors).hasSize(4);

        assertThat(ex.errors.get(0).field).isEqualTo("id");
        assertThat(ex.errors.get(0).description).isEqualTo(ValidationError.EMPTY_FIELD.message);
        assertThat(ex.errors.get(0).code).isEqualTo(ValidationError.EMPTY_FIELD.code);

        assertThat(ex.errors.get(1).field).isEqualTo("title");
        assertThat(ex.errors.get(1).description).isEqualTo(ValidationError.EMPTY_FIELD.message);
        assertThat(ex.errors.get(1).code).isEqualTo(ValidationError.EMPTY_FIELD.code);

        assertThat(ex.errors.get(2).field).isEqualTo("description");
        assertThat(ex.errors.get(2).description).isEqualTo(ValidationError.EMPTY_FIELD.message);
        assertThat(ex.errors.get(2).code).isEqualTo(ValidationError.EMPTY_FIELD.code);

        assertThat(ex.errors.get(3).field).isEqualTo("dueDate");
        assertThat(ex.errors.get(3).description).isEqualTo(ValidationError.EMPTY_FIELD.message);
        assertThat(ex.errors.get(3).code).isEqualTo(ValidationError.EMPTY_FIELD.code);
    }

    @Test
    public void DemandsCreationRequestOk() throws DemandsDomainException {
        DemandsUpdateRequest.factory(123L,"title", "description", 12345L);
    }
}
