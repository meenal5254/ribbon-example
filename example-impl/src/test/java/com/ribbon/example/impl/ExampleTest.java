package com.ribbon.example.impl;

import static org.junit.Assert.assertEquals;
import io.netty.buffer.ByteBuf;

import org.junit.Test;

import com.netflix.ribbon.Ribbon;
import com.netflix.ribbon.RibbonRequest;
import com.netflix.ribbon.proxy.annotation.Http;
import com.netflix.ribbon.proxy.annotation.Http.HttpMethod;

/**
 * Description.
 * @author Your Name
 */
public class ExampleTest {
    interface TestClient {
        @Http(method = HttpMethod.GET, uri = "/example-war")
        RibbonRequest<ByteBuf> getTenantByTenantKey();
    }

    @Test
    public void testConnection() {
        final TestClient testClient = Ribbon.from(TestClient.class);
        final RibbonRequest<ByteBuf> buf = testClient.getTenantByTenantKey();
        final ByteBuf bufer = buf.observe().toBlocking().single();
        final StringBuilder builder = new StringBuilder();
        for (int i = 0; i < bufer.capacity(); i++) {
            final byte b = bufer.getByte(i);
            builder.append((char) b);
        }
        assertEquals("hello", builder.toString());

    }
}