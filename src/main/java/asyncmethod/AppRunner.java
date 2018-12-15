package asyncmethod;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;

import java.util.concurrent.CompletableFuture;

public class AppRunner implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(AppRunner.class);

    private final GitHubLookupService service;

    public AppRunner(GitHubLookupService service) {
        this.service = service;
    }

    @Override
    public void run(String... args) throws Exception {
        long start = System.currentTimeMillis();

        CompletableFuture<User> page1 = service.findUser("PivotalSoftware");
        CompletableFuture<User> page2 = service.findUser("CloudFoundry");
        CompletableFuture<User> page3 = service.findUser("Spring-Projects");

        CompletableFuture.allOf(page1, page2, page3).join();

        logger.info("Elapsed time: " + (System.currentTimeMillis() - start));
        logger.info("--> " + page1.get());
        logger.info("--> " + page2.get());
        logger.info("--> " + page3.get());

    }
}
