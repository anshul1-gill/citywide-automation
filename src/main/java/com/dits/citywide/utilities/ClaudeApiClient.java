package com.dits.citywide.utilities;

import okhttp3.*;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ClaudeApiClient {

    private static final String API_URL    = "https://api.anthropic.com/v1/messages";
    private static final String MODEL      = "claude-sonnet-4-6";
    private static final String VERSION    = "2023-06-01";
    private static final int    MAX_TOKENS = 2048;

    private final OkHttpClient httpClient;
    private final String apiKey;

    public ClaudeApiClient() {
        this.apiKey = System.getenv("CLAUDE_API_KEY");
        if (this.apiKey == null || this.apiKey.isBlank()) {
            throw new IllegalStateException(
                "CLAUDE_API_KEY environment variable is not set.\n" +
                "In Eclipse: Run Configurations -> Environment -> Add CLAUDE_API_KEY"
            );
        }
        this.httpClient = new OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(60,    TimeUnit.SECONDS)
            .build();
    }

    /**
     * Sends a prompt to Claude and returns the plain-text response.
     *
     * @param systemPrompt  Instructions that define Claude's behaviour
     * @param userPrompt    Your actual question or request
     * @return              Claude's response as plain text
     */
    public String ask(String systemPrompt, String userPrompt) throws IOException {

        JSONObject body = new JSONObject()
            .put("model",      MODEL)
            .put("max_tokens", MAX_TOKENS)
            .put("system",     systemPrompt)
            .put("messages",   new JSONArray()
                .put(new JSONObject()
                    .put("role",    "user")
                    .put("content", userPrompt)));

        Request request = new Request.Builder()
            .url(API_URL)
            .post(RequestBody.create(
                body.toString(),
                MediaType.get("application/json")))
            .addHeader("x-api-key",         apiKey)
            .addHeader("anthropic-version", VERSION)
            .addHeader("content-type",      "application/json")
            .build();

        try (Response response = httpClient.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException(
                    "Claude API error " + response.code() +
                    ": " + response.body().string()
                );
            }
            JSONObject json = new JSONObject(response.body().string());
            return json.getJSONArray("content")
                       .getJSONObject(0)
                       .getString("text");
        }
    }
}