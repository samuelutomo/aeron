/*
 * Copyright 2017 Real Logic Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.aeron.driver.ext;

import io.aeron.driver.CongestionControl;
import io.aeron.driver.CongestionControlSupplier;
import io.aeron.driver.MediaDriver;
import io.aeron.driver.media.UdpChannel;
import org.agrona.concurrent.NanoClock;
import org.agrona.concurrent.status.CountersManager;

public class CubicCongestionControlSupplier implements CongestionControlSupplier
{
    public CongestionControl newInstance(
        final long registrationId,
        final UdpChannel udpChannel,
        final int streamId,
        final int sessionId,
        final int termLength,
        final int senderMtuLength,
        final NanoClock clock,
        final MediaDriver.Context context,
        final CountersManager countersManager)
    {
        return new CubicCongestionControl(
            registrationId, udpChannel, streamId, sessionId, termLength, senderMtuLength, clock, context, countersManager);
    }
}
