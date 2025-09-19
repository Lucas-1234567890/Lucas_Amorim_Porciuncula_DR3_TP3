import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Exercicio2 {
    public static void main(String[] args) {
        // IDs que vamos testar (1 a 8)
        int[] ids = {1,2,3,4,5,6,7,8};

        for (int id : ids) {
            try {
                // Monta a URL com o ID
                String url = "https://apichallenges.eviltester.com/sim/entities/" + id;
                URL obj = new URL(url);

                HttpURLConnection con = (HttpURLConnection) obj.openConnection();
                con.setRequestMethod("GET");

                int responseCode = con.getResponseCode();
                System.out.println("=================================");
                System.out.println("Requisição para entidade ID: " + id);
                System.out.println("Código HTTP: " + responseCode);

                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                System.out.println("Resposta da API:");
                System.out.println(response.toString());
                System.out.println();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
