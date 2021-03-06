/**
 * Copyright 2017 Pivotal Software, Inc.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.micrometer.graphite;

import io.micrometer.core.instrument.Meter;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GraphiteNamingConventionTest {
    private GraphiteNamingConvention convention = new GraphiteNamingConvention();

    @Test
    void name() {
        assertThat(convention.name("name([{id}])/1", Meter.Type.TIMER)).isEqualTo("name___id____1");
    }

    @Test
    void dotNotationIsConvertedToCamelCase() {
        assertThat(convention.name("gauge.size", Meter.Type.GAUGE)).isEqualTo("gaugeSize");
    }
}
