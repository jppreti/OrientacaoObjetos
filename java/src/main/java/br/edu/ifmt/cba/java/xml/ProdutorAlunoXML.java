package br.edu.ifmt.cba.java.xml;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

public class ProdutorAlunoXML {

    public static void main(String[] args) {
        File apontador = new File("Alunos.xml");
        String matricula;
        String nome;
        try {
            PrintWriter print = new PrintWriter(new FileWriter(apontador));
            print.println("<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>");
            print.println("<alunos>");
            do {
                print.println("\t<aluno>");
                matricula = JOptionPane.showInputDialog("Forneça a matricula do aluno");
                nome = JOptionPane.showInputDialog("Forneça o nome do aluno");
                print.println("\t\t<matricula>" + matricula + "</matricula>");
                print.println("\t\t<nome>" + nome + "</nome>");
                print.println("\t</aluno>");
            } while (JOptionPane.showConfirmDialog(null, "Deseja digitar outro aluno") == JOptionPane.OK_OPTION);
            print.println("</alunos>");
            print.close();
            JOptionPane.showMessageDialog(null, "Gravação realizada com sucesso");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
