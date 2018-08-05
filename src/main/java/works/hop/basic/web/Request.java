/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package works.hop.basic.web;

import io.netty.handler.codec.http.FullHttpRequest;
import java.nio.charset.StandardCharsets;

/**
 *
 * @author mainas
 */
public class Request {
    
    private final FullHttpRequest request;


    /**
     * Creates a new Request.
     *
     * @param request The Netty HTTP request.
     */
    public Request(final FullHttpRequest request) {
        this.request = request;
    }


    /**
     * Returns the body of the request.
     *
     * @return The request body.
     */
    public String body() {
        return request.content().toString(StandardCharsets.UTF_8);
    }
}
