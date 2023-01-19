package com.camel.caamelTuto;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

//@Component
public class FileMoverRoute extends RouteBuilder {


    @Override
    public void configure() throws Exception {
        from("file:///F:/Tutorials/Apache camel/test").log("${headers}").log("${body}").to("file:///F:/Tutorials/Apache camel/test/processed");
    }
}
