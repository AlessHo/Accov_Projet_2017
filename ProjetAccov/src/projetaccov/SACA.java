/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetaccov;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author Aless
 */
public class SACA {

    public static ArrayList<String> list;

    public static void main(String[] zero) {

        /*ServerSocket socketserver  ;
         Socket socketduserveur ;
         BufferedReader in;
         PrintWriter out;
		
         try {
		
         socketserver = new ServerSocket(2009);
         System.out.println("Le serveur est à l'écoute du port "+socketserver.getLocalPort());
         socketduserveur = socketserver.accept(); 
         System.out.println("Un zéro s'est connecté");
         out = new PrintWriter(socketduserveur.getOutputStream());
         out.println("Vous êtes connecté zéro !");
         out.flush();
		                
         socketduserveur.close();
         socketserver.close();
		        
         }catch (IOException e) {
			
         e.printStackTrace();
         }*/
        
        ServerSocket serversocketAvion;
        ServerSocket serverSocketController;
        ServerSocket serversocketRadar;

        //int nbrAvion = 1;
        try {

            list = new ArrayList<String>();

            serversocketAvion = new ServerSocket(2009);
            serversocketRadar = new ServerSocket(2010);
            serverSocketController = new ServerSocket(2011);
            
            
            Socket socketRadar = serversocketRadar.accept();

            System.out.println("SACA est Pret!");

                //while (true){
            Connecter_Avion cA = new Connecter_Avion(serversocketAvion, socketRadar,list);
            cA.start();
            
            Connecter_Controller cC = new Connecter_Controller(serverSocketController,list);
            cC.start();

                //}
        } catch (IOException e) {
            System.out.println("Fin SACA");
            e.printStackTrace();
        }
    }
}
