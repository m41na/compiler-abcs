/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package works.hop.basic.web;

import io.netty.handler.codec.http.HttpMethod;
import java.util.ArrayList;

/**
 *
 * @author mainas
 */
public class RouteTable {

    private final ArrayList<Route> routes;

    public RouteTable() {
        this.routes = new ArrayList<>();
    }

    public void addRoute(final Route route) {
        this.routes.add(route);
    }

    public Route findRoute(final HttpMethod method, final String path) {
        for (final Route route : routes) {
            if (route.matches(method, path)) {
                return route;
            }
        }

        return null;
    }
}
