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
package io.micrometer.core.instrument.noop;

import io.micrometer.core.instrument.*;

import java.util.List;
import java.util.function.Function;

import static java.util.Collections.emptyList;

public class NoopMeter extends AbstractMeter {
    public NoopMeter(Id id) {
        super(id);
    }

    @Override
    public List<Measurement> measure() {
        return emptyList();
    }

    @Override
    public <T> T match(Function<Gauge, T> visitGauge,
                       Function<Counter, T> visitCounter,
                       Function<Timer, T> visitTimer,
                       Function<DistributionSummary, T> visitSummary,
                       Function<LongTaskTimer, T> visitLongTaskTimer,
                       Function<TimeGauge, T> visitTimeGauge,
                       Function<FunctionCounter, T> visitFunctionCounter,
                       Function<FunctionTimer, T> visitFunctionTimer,
                       Function<Meter, T> visitMeter) {
        return visitMeter.apply(this);
    }
}
