/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package works.hop.basic.web;

import io.netty.handler.codec.http.HttpMethod;

/**
 *
 * @author mainas
 */
public class Route {

    private final HttpMethod method;
    private final String path;
    private final Handler handler;

    public Route(final HttpMethod method, final String path, final Handler handler) {
        this.method = method;
        this.path = path;
        this.handler = handler;
    }

    public HttpMethod getMethod() {
        return method;
    }

    public String getPath() {
        return path;
    }

    public Handler getHandler() {
        return handler;
    }

    public boolean matches(final HttpMethod method, final String path) {
        return this.method.equals(method) && this.path.equals(path);
    }
}
