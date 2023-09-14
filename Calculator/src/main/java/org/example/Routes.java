package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Routes {

    public static String compreflex(String query) throws Exception {
        String data = query.split("=")[1];
        String[] params = data.split("\\),");
        String operation = params[0].substring(1);
        String values = params[1].substring(1);
        String extra = params.length > 2 ? params[2].substring(1) : "";

        if(!operation.contains("qck"))
            return "HTTP/1.1 200 OK\r\n"
                    + "Content-Type: text/html\r\n"
                    + "\r\n" +
                    "{\"result\": \"" + Reflect.executeFunction(operation, values, extra) + "\"}";
        else {
            String[] splittedValues = values.split(",");
            Double[] doubles = new Double[splittedValues.length];

            for (int i = 0; i < splittedValues.length; i++) {
                doubles[i] = Double.valueOf(splittedValues[i]);
            }

            ArrayList<Double> listDoubles = new ArrayList<>();

            for (Double d : doubles) {
                listDoubles.add(d);
            }

            doubles = Sorting.qck(listDoubles, 0, listDoubles.size() - 1).toArray(new Double[]{});
            String show = "";

            for (int i = 0; i < doubles.length; i++) {
                if(i + 1 < doubles.length)
                    show += doubles[i].toString() + ",";
                else
                    show += doubles[i].toString();
            }
            return "HTTP/1.1 200 OK\r\n"
                    + "Content-Type: text/html\r\n"
                    + "\r\n" +
                    "{\"result\": \"" + show + "\"}";
        }

    }

    public static String notFound(String query) throws Exception {
        return "HTTP/1.1 200 OK\r\n"
                + "Content-Type: text/html\r\n"
                + "\r\n"
                + "<!DOCTYPE html>\n"
                + "<html>\n"
                + "<head>\n"
                + "<meta charset=\"UTF-8\">\n"
                + "<title>Title of the document</title>\n"
                + "</head>\n"
                + "<body>\n"
                + "<h1>404 NOT FOUND</h1>\n"
                + "</body>\n"
                + "</html>\n";
    }

}
