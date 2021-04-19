package com.total.demands.demands.infra.repository;

import com.total.demands.demands.infra.InfraConfiguration;
import com.total.demands.demands.infra.R2dbcConfiguration;
import com.total.demands.infrastructure.ReactiveDemandsDAL;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.r2dbc.DataR2dbcTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.test.StepVerifier;

import java.time.LocalDateTime;
import java.time.Month;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {InfraConfiguration.class, R2dbcConfiguration.class})
@ActiveProfiles({"test"})
@DataR2dbcTest
public class DemandsDomainRepositoryTest {

    public static final String TITLE = "sortir le chien";

    private static final LocalDateTime CREATION_DATE = LocalDateTime.of(2018, Month.JULY,
            2, 15, 47, 00);
    private static final LocalDateTime DUE_DATE = LocalDateTime.of(2018, Month.JULY,
            2, 16, 47, 00);
    public static final String DESCRIPTION = "le pauvre";
    public static final String TITLE1 = "Finir le tricot";
    public static final String DESCRIPTION1 = "devant Julien Lepers";


    @Autowired
    ReactiveDemandsDAL demandsDAL;

    @Test
    public void testReadDemandss() {
        demandsDAL.readDemands()
                .as(StepVerifier::create)
                .assertNext(actuel -> {
                    assertThat(actuel.getId() != null);
                }).verifyComplete();
//        assertThat(summaries).size().isEqualTo(2);
//        DemandsSummary one = summaries.get(0);
//        assertThat(one.id).isEqualTo(1L);
//        assertThat(one.title).isEqualTo(TITLE);
    }
}
