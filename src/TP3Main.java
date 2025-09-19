public class TP3Main {
    public static void main(String[] args) {
        // =========================
        // Exercício 1 a 4: API Entities
        // =========================
        System.out.println("=== EXERCÍCIOS 1 A 4 (Entities) ===\n");

        // 1️1 GET todos
        String allEntities = HttpUtils.get("https://apichallenges.eviltester.com/sim/entities");
        System.out.println("Todos os Entities: " + allEntities + "\n");

        // 2️2 GET entidade específica (IDs 1 a 8)
        for (int i = 1; i <= 8; i++) {
            String entity = HttpUtils.get("https://apichallenges.eviltester.com/sim/entities/" + i);
            System.out.println("Entity ID " + i + ": " + entity);
        }

        // 3️3 GET entidade inexistente (ID 13)
        String notFound = HttpUtils.get("https://apichallenges.eviltester.com/sim/entities/13");
        System.out.println("Entity ID 13: " + notFound + "\n");

        // 4️4 GET com parâmetros
        String urlParams = "https://apichallenges.eviltester.com/sim/entities?categoria=teste&limite=5";
        String paramResponse = HttpUtils.get(urlParams);
        System.out.println("GET com parâmetros: " + paramResponse + "\n");

        // =========================
        // Exercícios 5 a 8: Criar/Atualizar Entities
        // =========================
        System.out.println("=== EXERCÍCIOS 5 A 8 (CRUD Entities) ===\n");

        // 5️ POST criar nova entidade
        String postJson = "{\"name\":\"aluno\"}";
        String postResponse = HttpUtils.post("https://apichallenges.eviltester.com/sim/entities", postJson);
        System.out.println("POST resposta: " + postResponse + "\n");

        // 6️6 GET da entidade criada (ID 11 geralmente)
        String getNew = HttpUtils.get("https://apichallenges.eviltester.com/sim/entities/11");
        System.out.println("GET entidade criada: " + getNew + "\n");

        // 7️7 POST atualizar entidade 10
        String postUpdateJson = "{\"name\":\"atualizado\"}";
        String postUpdateResponse = HttpUtils.post("https://apichallenges.eviltester.com/sim/entities/10", postUpdateJson);
        System.out.println("POST atualizar ID 10: " + postUpdateResponse + "\n");

        // 8️ PUT atualizar entidade 10
        String putJson = "{\"name\":\"atualizado_put\"}";
        String putResponse = HttpUtils.put("https://apichallenges.eviltester.com/sim/entities/10", putJson);
        System.out.println("PUT atualizar ID 10: " + putResponse + "\n");

        // =========================
        // Exercícios 9 a 10: DELETE Entities
        // =========================
        System.out.println("=== EXERCÍCIOS 9 A 10 (DELETE Entities) ===\n");

        // 9️9 DELETE válido (ID 9)
        String delete9 = HttpUtils.delete("https://apichallenges.eviltester.com/sim/entities/9");
        System.out.println("DELETE ID 9: " + delete9 + "\n");

        // 10 DELETE inválido (ID 2)
        String delete2 = HttpUtils.delete("https://apichallenges.eviltester.com/sim/entities/2");
        System.out.println("DELETE ID 2: " + delete2 + "\n");

        // =========================
        // Exercício 11: OPTIONS
        // =========================
        System.out.println("=== EXERCÍCIO 11 (OPTIONS) ===\n");
        String allow = HttpUtils.options("https://apichallenges.eviltester.com/sim/entities");
        System.out.println("Métodos permitidos (Allow): " + allow + "\n");

        // =========================
        // Exercício 12: Simple API
        // =========================
        System.out.println("=== EXERCÍCIO 12 (Simple API) ===\n");

        // GET todos os itens
        String simpleAll = HttpUtils.get("https://apichallenges.eviltester.com/simpleapi/items");
        System.out.println("Itens atuais: " + simpleAll + "\n");

        // Gerar ISBN
        String isbn = HttpUtils.get("https://apichallenges.eviltester.com/simpleapi/randomisbn");
        System.out.println("ISBN gerado: " + isbn + "\n");

        // POST criar item
        String jsonPostItem = String.format("{\"type\":\"book\",\"isbn13\":\"%s\",\"price\":5.99,\"numberinstock\":5}", isbn);
        String postItem = HttpUtils.post("https://apichallenges.eviltester.com/simpleapi/items", jsonPostItem);
        System.out.println("POST item: " + postItem + "\n");

        // PUT atualizar item
        String jsonPutItem = String.format("{\"type\":\"book\",\"isbn13\":\"%s\",\"price\":7.99,\"numberinstock\":10}", isbn);
        String putItem = HttpUtils.put("https://apichallenges.eviltester.com/simpleapi/items", jsonPutItem);
        System.out.println("PUT item: " + putItem + "\n");

        // DELETE item
        String deleteItem = HttpUtils.delete("https://apichallenges.eviltester.com/simpleapi/items/" + isbn);
        System.out.println("DELETE item: " + deleteItem + "\n");
    }
}
