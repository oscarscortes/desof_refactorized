package org.oscars;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Main.class);
        Environment env = app.run(args).getEnvironment();
        logApplicationStartup(env);
    }

    private static void logApplicationStartup(Environment env) {
        String protocol = "http";
        if (env.getProperty("server.ssl.key-store") != null) {
            protocol = "https";
        }
        String serverPort = env.getProperty("server.port");
        String contextPath = env.getProperty("server.servlet.context-path");
        if (contextPath == null ||contextPath.trim().isEmpty()) {
            contextPath = "/";
        }
        String hostAddress = "localhost";
        logger.info("\n-----------------------------------------------------\n\t" +
                "Application '{}' is running! Access URLs:\n\t" +
                "Local      :\t{}://localhost:{}{}\n\t" +
                "External   :\t{}://{}:{}{}\n\t\n-----------------------------------------------------",
                env.getProperty("spring.application.name"),
                protocol,
                serverPort,
                contextPath,
                protocol,
                hostAddress,
                serverPort,
                contextPath);
    }
}