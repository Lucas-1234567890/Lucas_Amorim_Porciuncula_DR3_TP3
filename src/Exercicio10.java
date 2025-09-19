import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Exercicio10 {
    public static void main(String[] args) {
        try {
            int id = 2; 
            String url = "https://apichallenges.eviltester.com/sim/entities/" + id;

            // DELETE da entidade
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("DELETE");

            int deleteResponseCode = con.getResponseCode();
            System.out.println("DELETE Código HTTP: " + deleteResponseCode);

            // Ler resposta, se houver
            BufferedReader in;
            try {
                in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            } catch (Exception e) {
                in = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            }

            String inputLine;
            StringBuilder deleteResponse = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                deleteResponse.append(inputLine);
            }
            in.close();

            System.out.println("Resposta do DELETE:");
            System.out.println(deleteResponse.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
