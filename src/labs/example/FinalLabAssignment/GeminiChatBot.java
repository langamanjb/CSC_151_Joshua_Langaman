package labs.example.FinalLabAssignment;

import java.net.URI;
import java.net.URISyntaxException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;


public class GeminiChatBot 
{

    private static final String API_KEY = "AIzaSyBYaqHaT0eWoL7pVq1kvWLJ0ySVqD7uhRc";

    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Gemini Chatbot — type 'exit' to quit.");
        System.out.println("--------------------------------------");

        while (true) 
        {
            System.out.print("\nYou: ");
            String userInput = scanner.nextLine();

            if (userInput.equalsIgnoreCase("exit")) 
            {
                System.out.println("Chatbot: Goodbye!");
                break;
            }

            try 
            {
                String response = sendToGemini(userInput);
                String parsed = extractText(response);

                System.out.println("Gemini: " + parsed);

            } 
            catch (Exception e) 
            {
                System.out.println("Error communicating with Gemini: " + e.getMessage());
            }
        }

        scanner.close();
    }

    private static String sendToGemini(String userMessage) throws IOException, URISyntaxException 
    {
        URI uri = new URI
        (
            "https://generativelanguage.googleapis.com/v1beta/models/gemini-3-flash-preview:generateContent?key=" + API_KEY
        );

        URL url = uri.toURL();
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("POST");
        connection.setDoOutput(true);
        connection.setRequestProperty("Content-Type", "application/json");

        // JSON request body
        String jsonInput = "{ \"contents\": [{ \"parts\": [{ \"text\": \"" 
                + userMessage.replace("\"", "\\\"") + "\" }] }] }";

        // Send request
        try (OutputStream os = connection.getOutputStream()) 
        {
            byte[] input = jsonInput.getBytes(StandardCharsets.UTF_8);
            os.write(input, 0, input.length);
        }

        // Read response
        StringBuilder response = new StringBuilder();
        try (BufferedReader br = new BufferedReader(
            new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8))) 
        {

            String line;
            while ((line = br.readLine()) != null) 
            {
                response.append(line.trim());
            }
        }

        return response.toString();
     
    }

    // Extracts the chatbot text from the JSON response
    private static String extractText(String json) 
    {
        int index = json.indexOf("\"text\":");
        if (index == -1) return "(No response text found)";

        int start = json.indexOf("\"", index + 7) + 1;
        int end = json.indexOf("\"", start);

        if (start == -1 || end == -1) return "(Unable to parse response)";

        return json.substring(start, end);
    }
}

