/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.webservice;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
/**
 * @author bipinpatel
 * JAX-RS configuration to host JAX-RS web services under the /rest/ path.
 */
@ApplicationPath("rest")
public class ApplicationConfig extends Application {
}
