import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Exercicio8 {
    public static void main(String[] args) {
        try {
            int id = 10;
            String url = "https://apichallenges.eviltester.com/sim/entities/" + id;

            // 1️PUT para atualizar
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("PUT");
            con.setRequestProperty("Content-Type", "application/json; utf-8");
            con.setRequestProperty("Accept", "application/json");
            con.setDoOutput(true);

            String jsonInputString = "{\"name\": \"atualizadoPUT\"}";

            try (DataOutputStream wr = new DataOutputStream(con.getOutputStream())) {
                wr.writeBytes(jsonInputString);
                wr.flush();
            }

            int responseCode = con.getResponseCode();
            System.out.println("PUT Código HTTP: " + responseCode);

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            System.out.println("Resposta do PUT:");
            System.out.println(response.toString());

            // GET para verificar a atualização
            System.out.println("\nVerificando a atualização via GET...");
            URL getUrl = new URL(url);
            HttpURLConnection getCon = (HttpURLConnection) getUrl.openConnection();
            getCon.setRequestMethod("GET");

            int getResponseCode = getCon.getResponseCode();
            System.out.println("GET Código HTTP: " + getResponseCode);

            BufferedReader getIn = new BufferedReader(new InputStreamReader(getCon.getInputStream()));
            StringBuilder getResponse = new StringBuilder();
            while ((inputLine = getIn.readLine()) != null) {
                getResponse.append(inputLine);
            }
            getIn.close();

            System.out.println("Resposta do GET:");
            System.out.println(getResponse.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
