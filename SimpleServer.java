import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class SimpleServer {
    public static void main(String[] args) throws IOException {
        int port = 8080;
        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);

        // Map endpoint path to our custom Servlet-like Handler
        server.createContext("/api/users", new UserHandler());
        server.setExecutor(null); // Default multi-threaded executor

        System.out.println("==================================================");
        System.out.println("Java Servlet-style Server running on http://localhost:" + port + "/api/users");
        System.out.println("Press Ctrl+C to stop.");
        System.out.println("==================================================");

        server.start();
    }

    // Thread-safe in-memory database
    private static final Map<Integer, String> userDb = new ConcurrentHashMap<>();
    private static final AtomicInteger idCounter = new AtomicInteger(0);

    static {
        // Pre-fill seed data: ID -> JSON String representation
        int id1 = idCounter.incrementAndGet();
        userDb.put(id1, "{\"id\":" + id1 + ", \"name\":\"Alice\", \"email\":\"alice@example.com\"}");
        
        int id2 = idCounter.incrementAndGet();
        userDb.put(id2, "{\"id\":" + id2 + ", \"name\":\"Bob\", \"email\":\"bob@example.com\"}");
    }

    

    // Handlers in com.sun.net.httpserver act just like Jakarta/Javax Servlets
    static class UserHandler implements HttpHandler {

        @Override
        public void handle(HttpExchange exchange) throws IOException {
            // Set Response Headers (JSON)
            exchange.getResponseHeaders().set("Content-Type", "application/json; charset=UTF-8");

            String method = exchange.getRequestMethod();
            String path = exchange.getRequestURI().getPath(); // e.g. "/api/users" or "/api/users/1"
            
            // Extract ID from path if present (e.g., /api/users/1 -> 1)
            Integer userId = parseIdFromPath(path);

            try {
                switch (method) {
                    case "GET":
                        handleGet(exchange, userId);
                        break;
                    case "POST":
                        handlePost(exchange);
                        break;
                    case "PUT":
                        handlePut(exchange, userId);
                        break;
                    case "DELETE":
                        handleDelete(exchange, userId);
                        break;
                    default:
                        sendResponse(exchange, 451, "{\"error\": \"Method not allowed\"}");
                        break;
                }
            } catch (Exception e) {
                sendResponse(exchange, 500, "{\"error\": \"Internal Server Error: " + e.getMessage() + "\"}");
            }
        }

        // ==========================================
        // 1. READ (GET)
        // ==========================================
        private void handleGet(HttpExchange exchange, Integer userId) throws IOException {
            if (userId != null) {
                // Fetch Single User
                String userJson = userDb.get(userId);
                if (userJson != null) {
                    sendResponse(exchange, 200, userJson);
                } else {
                    sendResponse(exchange, 404, "{\"error\": \"User not found\"}");
                }
            } else {
                // Fetch All Users
                StringBuilder jsonArray = new StringBuilder("[");
                int count = 0;
                for (String user : userDb.values()) {
                    jsonArray.append(user);
                    if (++count < userDb.size()) jsonArray.append(",");
                }
                jsonArray.append("]");
                sendResponse(exchange, 200, jsonArray.toString());
            }
        }

        // ==========================================
        // 2. CREATE (POST)
        // ==========================================
        private void handlePost(HttpExchange exchange) throws IOException {
            String requestBody = readRequestBody(exchange);
            
            if (requestBody.isEmpty()) {
                sendResponse(exchange, 400, "{\"error\": \"Request body cannot be empty\"}");
                return;
            }

            int newId = idCounter.incrementAndGet();
            
            // For simplicity without third-party JSON parsers: inject generated ID
            String newUserJson;
            if (requestBody.trim().startsWith("{")) {
                newUserJson = "{\"id\":" + newId + ", " + requestBody.trim().substring(1);
            } else {
                newUserJson = "{\"id\":" + newId + ", \"data\":\"" + requestBody + "\"}";
            }

            userDb.put(newId, newUserJson);
            sendResponse(exchange, 201, newUserJson);
        }

        // ==========================================
        // 3. UPDATE (PUT)
        // ==========================================
        private void handlePut(HttpExchange exchange, Integer userId) throws IOException {
            if (userId == null) {
                sendResponse(exchange, 400, "{\"error\": \"User ID required in path (e.g. /api/users/1)\"}");
                return;
            }

            if (!userDb.containsKey(userId)) {
                sendResponse(exchange, 404, "{\"error\": \"User not found\"}");
                return;
            }

            String requestBody = readRequestBody(exchange);
            String updatedJson;

            if (requestBody.trim().startsWith("{")) {
                updatedJson = "{\"id\":" + userId + ", " + requestBody.trim().substring(1);
            } else {
                updatedJson = "{\"id\":" + userId + ", \"data\":\"" + requestBody + "\"}";
            }

            userDb.put(userId, updatedJson);
            sendResponse(exchange, 200, updatedJson);
        }

        // ==========================================
        // 4. DELETE (DELETE)
        // ==========================================
        private void handleDelete(HttpExchange exchange, Integer userId) throws IOException {
            if (userId == null) {
                sendResponse(exchange, 400, "{\"error\": \"User ID required in path (e.g. /api/users/1)\"}");
                return;
            }

            if (userDb.remove(userId) != null) {
                sendResponse(exchange, 200, "{\"message\": \"User " + userId + " deleted successfully\"}");
            } else {
                sendResponse(exchange, 404, "{\"error\": \"User not found\"}");
            }
        }

        // --- Helper Methods ---

        private Integer parseIdFromPath(String path) {
            String[] parts = path.split("/");
            if (parts.length > 3) {
                try {
                    return Integer.parseInt(parts[3]);
                } catch (NumberFormatException ignored) {}
            }
            return null;
        }

        private String readRequestBody(HttpExchange exchange) throws IOException {
            try (InputStream is = exchange.getRequestBody()) {
                return new String(is.readAllBytes(), StandardCharsets.UTF_8);
            }
        }

        private void sendResponse(HttpExchange exchange, int statusCode, String responseText) throws IOException {
            byte[] bytes = responseText.getBytes(StandardCharsets.UTF_8);
            exchange.sendResponseHeaders(statusCode, bytes.length);
            try (OutputStream os = exchange.getResponseBody()) {
                os.write(bytes);
            }
        }
    }
}