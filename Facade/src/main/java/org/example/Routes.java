package org.example;

public class Routes {

    public static String calculadora(String query) throws Exception {
        return "HTTP/1.1 200 OK\r\n"
                + "Content-Type: text/html\r\n"
                + "\r\n" +
                "<html>\n" +
                "<head>\n" +
                "</head>\n" +
                "<body>\n" +
                "\t<h1>Ejecutar operaciones</h1>\n" +
                "\t<form action=\"\" method=\"get\" id=\"form\">\n" +
                "\t\tOperacion: <input type=\"text\" name=\"operation\"><br>\n" +
                "\t\tValores: <input type=\"text\" name=\"values\"><br>\n" +
                "\t\tExtra: <input type=\"extra\" name=\"extra\" value=\"\"><br>\n" +
                "\t\t <input type=\"submit\" value=\"Enviar\"><br>\n" +
                "\t</form>\n" +
                "\t<br><br>\n" +
                "\t<div id=\"result\">\n" +
                "\t\n" +
                "\t</div>\n" +
                "\t<script>\n" +
                "\t\n" +
                "\t\tlet form = document.querySelector(\"#form\");\n" +
                "\t\t\n" +
                "\t\tform.addEventListener(\"submit\", (ev) => {\n" +
                "\t\t\tev.preventDefault();\n" +
                "\t\t\tlet dataurl = \"(\" + form.elements.operation.value + \"),(\" + form.elements.values.value + \"),(\" + form.elements.extra.value + \")\";\n" +
                "\t\t\tlet url = \"http://localhost:36000/computar=\" + dataurl;\n" +
                "\t\t\t\n" +
                "\t\t\tfetch(url).then(res => res.json()).then(json => {\n" +
                "\t\t\t\tdocument.querySelector(\"#result\").innerHTML = \"El resultado es: \" + json.result;\n" +
                "\t\t\t});\n" +
                "\t\t\t\n" +
                "\t\t});\n" +
                "\t\n" +
                "\t</script>\n" +
                "</body>\n" +
                "</html>";
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

    public static String computar(String query) throws Exception {
        String res= Http.get("http://localhost:35000/compreflex=" + query.split("=")[1]);
        System.out.println(res);
        return "HTTP/1.1 200 OK\r\n"
                + "Content-Type: application/json\r\n"
                + "\r\n" + res;
    }

}
