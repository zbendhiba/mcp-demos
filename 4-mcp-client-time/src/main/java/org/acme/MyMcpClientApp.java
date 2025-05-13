package org.acme;

import io.quarkiverse.langchain4j.RegisterAiService;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@QuarkusMain
public class MyMcpClientApp implements QuarkusApplication {

    @Inject
    Assistant assistant;

    @ConfigProperty(name = "zineb.telegram.id")
    String telegramId;

    @Override
    public int run(String... args) {
        String prompt = """
                Hello please send to Zineb on her Telegram account  the current time? Her telegram id is %s
                """;

        String answer = assistant.answer(String.format(prompt, telegramId));
        System.out.println(answer);
        return 0;
    }

    @RegisterAiService
    @ApplicationScoped
    interface Assistant {
        String answer(String question);
    }

}
