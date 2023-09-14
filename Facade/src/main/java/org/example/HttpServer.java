package org.example;

import java.net.*;
import java.io.*;

public class HttpServer {

    public static void main(String[] args) throws Exception {
        while(true) {
            ServerSocket serverSocket = null;
            try {
                serverSocket = new ServerSocket(36000);
            } catch (IOException e) {
                System.err.println("Could not listen on port: 35000.");
                System.exit(1);
            }

            Socket clientSocket = null;
            try {
                System.out.println("Listo para recibir ...");
                clientSocket = serverSocket.accept();
            } catch (IOException e) {
                System.err.println("Accept failed.");
                System.exit(1);
            }
            PrintWriter out = new PrintWriter(
                    clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));
            String inputLine, outputLine;
            String query = "";
            int i = 0;
            while ((inputLine = in.readLine()) != null) {

                //Primera linea
                if (i == 0) query = inputLine.split(" ")[1];

                System.out.println("Recibí: " + inputLine);
                if (!in.ready()) {
                    break;
                }
                i++;
            }

            if (query.startsWith("/calculadora")) {
                outputLine = Routes.calculadora(query);
            } else if(query.startsWith("/computar")) {
                outputLine = Routes.computar(query);
            } else {
                outputLine = Routes.notFound(query);
            }

            out.println(outputLine);
            out.close();
            in.close();
            clientSocket.close();
            serverSocket.close();
        }
    }

}
