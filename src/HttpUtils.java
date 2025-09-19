import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpUtils {

    // GET genérico
    public static String get(String url) {
        try {
            HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();
            con.setRequestMethod("GET");
            int code = con.getResponseCode();
            System.out.println("GET Código HTTP: " + code);

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(code < 400 ? con.getInputStream() : con.getErrorStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = in.readLine()) != null) response.append(line);
            in.close();
            return response.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // POST genérico
    public static String post(String url, String json) {
        return sendWithBody("POST", url, json);
    }

    // PUT genérico
    public static String put(String url, String json) {
        return sendWithBody("PUT", url, json);
    }

    // DELETE genérico
    public static String delete(String url) {
        try {
            HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();
            con.setRequestMethod("DELETE");

            int code = con.getResponseCode();
            System.out.println("DELETE Código HTTP: " + code);

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(code < 400 ? con.getInputStream() : con.getErrorStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = in.readLine()) != null) response.append(line);
            in.close();
            return response.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // OPTIONS genérico
    public static String options(String url) {
        try {
            HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();
            con.setRequestMethod("OPTIONS");
            int code = con.getResponseCode();
            System.out.println("OPTIONS Código HTTP: " + code);

            String allowHeader = con.getHeaderField("Allow");
            return allowHeader != null ? allowHeader : "Nenhum método retornado";
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Método auxiliar para POST e PUT
    private static String sendWithBody(String method, String url, String json) {
        try {
            HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();
            con.setRequestMethod(method);
            con.setRequestProperty("Content-Type", "application/json; utf-8");
            con.setRequestProperty("Accept", "application/json");
            con.setDoOutput(true);

            try (DataOutputStream wr = new DataOutputStream(con.getOutputStream())) {
                wr.writeBytes(json);
                wr.flush();
            }

            int code = con.getResponseCode();
            System.out.println(method + " Código HTTP: " + code);

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(code < 400 ? con.getInputStream() : con.getErrorStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = in.readLine()) != null) response.append(line);
            in.close();
            return response.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
