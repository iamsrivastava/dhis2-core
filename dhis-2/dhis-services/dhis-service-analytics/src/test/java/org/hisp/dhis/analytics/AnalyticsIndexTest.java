package org.hisp.dhis.analytics;

/*
 * Copyright (c) 2004-2018, University of Oslo
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * Redistributions of source code must retain the above copyright notice, this
 * list of conditions and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation
 * and/or other materials provided with the distribution.
 * Neither the name of the HISP project nor the names of its contributors may
 * be used to endorse or promote products derived from this software without
 * specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
 * ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

import org.junit.Test;

import com.google.common.collect.Lists;

import static org.junit.Assert.*;
import static org.hisp.dhis.analytics.util.AnalyticsSqlUtils.QUOTE;
import static org.hisp.dhis.analytics.util.AnalyticsSqlUtils.quote;

public class AnalyticsIndexTest
{
    @Test
    public void testGetIndexName()
    {
        AnalyticsIndex indexA = new AnalyticsIndex( "analytics_2017_temp", Lists.newArrayList( quote( "quarterly" ) ), null );
        AnalyticsIndex indexB = new AnalyticsIndex( "analytics_2018_temp", Lists.newArrayList( quote( "ax" ), quote( "co" ) ), null );
        AnalyticsIndex indexC = new AnalyticsIndex( "analytics_2019_temp", Lists.newArrayList( quote( "YtbsuPPo010" ) ), null );

        System.out.println( indexA.getIndexName( AnalyticsTableType.DATA_VALUE ) );
        System.out.println( indexB.getIndexName( AnalyticsTableType.DATA_VALUE ) );
        System.out.println( indexC.getIndexName( AnalyticsTableType.DATA_VALUE ) );
        assertTrue( indexA.getIndexName( AnalyticsTableType.DATA_VALUE ).startsWith( QUOTE + "in_quarterly_ax_2017_" ) );
        assertTrue( indexB.getIndexName( AnalyticsTableType.DATA_VALUE ).startsWith( QUOTE + "in_ax_co_ax_2018_" ) );
        assertTrue( indexC.getIndexName( AnalyticsTableType.DATA_VALUE ).startsWith( QUOTE + "in_YtbsuPPo010_ax_2019_" ) );

    }

}
