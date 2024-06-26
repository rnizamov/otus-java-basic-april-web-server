package ru.rnizamov.web.server.application.processors;

import com.google.gson.Gson;
import ru.rnizamov.web.server.HttpRequest;
import ru.rnizamov.web.server.application.Item;
import ru.rnizamov.web.server.application.ProductService;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.util.List;

public class GetAllProductsProcessor implements RequestProcessor {
    @Override
    public void execute(HttpRequest httpRequest, OutputStream output, ProductService productService) throws IOException, SQLException {
        List<Item> items = productService.getItems();
        Gson gson = new Gson();
        String result = "HTTP/1.1 200 OK\r\nContent-Type: application/json\r\n\r\n" + gson.toJson(items);
        output.write(result.getBytes(StandardCharsets.UTF_8));
    }
}
