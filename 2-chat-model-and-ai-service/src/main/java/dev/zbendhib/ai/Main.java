package dev.zbendhib.ai;

import dev.langchain4j.model.chat.ChatLanguageModel;
import io.quarkiverse.langchain4j.RegisterAiService;
import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

/**
 * This class isn't mine, it was copied from here
 */
@QuarkusMain
public class Main implements QuarkusApplication {

    @Inject
    ChatLanguageModel model;

    @Inject
    MyAiService ai;


    @Override
    public int run(String... args) {
        System.out.println("Chat Model : "
                + model.chat("Quel jour est on aujourd'hui ?"));
        System.out.println("-------------------");
        System.out.println("AI Service: "
                + ai.answer("What date is it today?"));
        return 0;
    }

    @RegisterAiService
    @ApplicationScoped
    public interface MyAiService {

        String answer(String question);
    }


    public static void main(String[] args) {
        Quarkus.run(Main.class, args);
    }
}
