package com.github.novicezk.midjourney;

import com.github.novicezk.midjourney.enums.TranslateWay;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@Data
@Component
@ConfigurationProperties(prefix = "mj")
public class ProxyProperties {

 
    private final TaskStore taskStore = new TaskStore();
    

    private String accountChooseRule = "BestWaitIdleRule";

    private final List<DiscordAccountConfig> accounts = new ArrayList<>();
 
    private final ProxyConfig proxy = new ProxyConfig();
    

    private final NgDiscordConfig ngDiscord = new NgDiscordConfig();
    
  
    private final BaiduTranslateConfig baiduTranslate = new BaiduTranslateConfig();
    
 
    private final OpenaiConfig openai = new OpenaiConfig();
 
    private TranslateWay translateWay = TranslateWay.NULL;

    private String apiSecret;
 
    private String notifyHook;
    
 
    private int notifyPoolSize = 10;

    @Data
    public static class DiscordAccountConfig {

     
        private String guildId;
    
        private String channelId;
        
    
        private String userToken;
        
      
        private String userAgent = Constants.DEFAULT_DISCORD_USER_AGENT;
        
     
        private boolean enable = true;
     
        private int coreSize = 3;
        
       
        private int queueSize = 10;
        
      
        private int timeoutMinutes = 5;
    }

    @Data
    public static class BaiduTranslateConfig {
       
        private String appid;

     
        private String appSecret;
    }

    @Data
    public static class OpenaiConfig {
   
        private String gptApiUrl;

        private String gptApiKey;

        private Duration timeout = Duration.ofSeconds(30);

        private String model = "gpt-3.5-turbo";

    
        private int maxTokens = 2048;

        private double temperature = 0;
    }

    @Data
    public static class TaskStore {
     
        private Duration timeout = Duration.ofDays(30);

       
        private Type type = Type.IN_MEMORY;

        public enum Type {
         
            REDIS,

         
            IN_MEMORY
        }
    }

    @Data
    public static class ProxyConfig {
     
        private String host;

   
        private Integer port;
    }

    @Data
    public static class NgDiscordConfig {
    
        private String server;

     
        private String cdn;

     
        private String wss;

        private String resumeWss;

    
        private String uploadServer;
    }

    @Data
    public static class TaskQueueConfig {
     
        private int coreSize = 3;

     
        private int queueSize = 10;

        private int timeoutMinutes = 5;
    }
}
