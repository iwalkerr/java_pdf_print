package com.greejoy;

import com.sun.jersey.spi.container.servlet.ServletContainer;
import org.mortbay.jetty.Server;
import org.mortbay.jetty.servlet.Context;
import org.mortbay.jetty.servlet.ServletHolder;

/**
 * 主函数入口
 */
public class Main {
    public static void main(String[] args) throws Exception {
        int port = 4385;
        if (args.length > 0) {
            try {
                port = Integer.parseInt(args[0]);
            }catch (Exception e){
                System.out.println("端口格式不符,使用默认端口！");
            }
        }

        Server server = new Server(port);
        ServletHolder sh = new ServletHolder(ServletContainer.class);
        sh.setInitParameter("com.sun.jersey.config.property.resourceConfigClass", "com.sun.jersey.api.core.PackagesResourceConfig");
        sh.setInitParameter("com.sun.jersey.config.property.packages", "com.greejoy");
        sh.setInitParameter("com.sun.jersey.api.json.POJOMappingFeature", "true");

        Context context = new Context(server, "/");
        context.addServlet(sh, "/*");
        server.start();
        server.join();
    }
}
