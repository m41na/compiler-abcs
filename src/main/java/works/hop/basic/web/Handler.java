/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package works.hop.basic.web;

/**
 *
 * @author mainas
 */
public interface Handler {
    
    Object handle(Request request, Response response) throws Exception;
}
