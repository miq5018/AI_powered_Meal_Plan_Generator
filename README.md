# AI_powered_Meal_Plan_Generator
Please add your OpenAI API Key to src/main/resources/application.properties in order to run the application. You can find your API keys in https://platform.openai.com/api-keys (you will likely need to add balance to your account in order to use the API).
- Replace your OpenAI API Key here `spring.ai.openai.apikey=${OPENAI_API_KEY}`

You can also adjust GPT model by changing `spring.ai.openai.chat.options.model=gpt-3.5-turbo` with "gpt-3.5-turbo" or "gpt-4"

Please run the Spring Boot with `./mvnw spring-boot:run` and the web application (UI) with Main.java  

In case you cannot run the application, please see the recorded demo video: https://drive.google.com/file/d/1saKUtK_UUL0Z0sCDdxTpM8IjiURFGxcm/view?usp=drive_link