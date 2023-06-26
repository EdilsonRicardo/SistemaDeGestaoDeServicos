/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import dao.ModuloConexao;
import java.text.DateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import java.sql.*;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import org.apache.commons.dbcp.ConnectionFactory;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;

import com.itextpdf.text.pdf.PdfWriter;
import com.lowagie.text.BadElementException;
import com.lowagie.text.Cell;
import com.lowagie.text.Element;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Phrase;
import com.lowagie.text.Table;
import com.mysql.cj.x.protobuf.MysqlxCrud.Column;
import java.awt.Color;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Edilson Ricardo
 */
public class TelaPrincipal extends javax.swing.JFrame {

    Connection conexao = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    /**
     * Creates new form TelaPrincipal
     */
     public TelaPrincipal() {
        initComponents();
        conexao = ModuloConexao.conector();
        menuRelatorio.setVisible(false);
        menuCadastroUsuario.setVisible(false);
        //As linhas abaixo substituem a label DATA "lblData", pela data actual do sistema ao inicializar o form
        //Poderia ter colocado este dado no metodo "formWindowActivated"
        Date data = new Date();
        DateFormat formato = DateFormat.getDateInstance(DateFormat.SHORT);
        lblData.setText(formato.format(data));
    }
    //OS METODOS GERAR RELATORIO E GERARCOMPROVATIVO NAO FORAM USADOS 
    public void gerarRelatorio() {
        Document documento = new Document(PageSize.A4);
        documento.setMargins(40f, 40f, 40f, 40f);
        try {
            PdfWriter.getInstance(documento, new FileOutputStream("relatorioCliente.pdf")); //Cria relatorio fisico no HD
            documento.open(); //Abre o documento criado para que possa ser editado
            
            Paragraph tituloDoRelatorio = new Paragraph("Relatório de Clientes Cadastrados");
            
            documento.add(tituloDoRelatorio);
            
            Table tabela = new Table(5);
            tabela.setBorder(3);
            tabela.setBorderWidth(3);
            tabela.setWidth(100f);
            tabela.setWidths(new float[]{10f, 30f, 20f, 20f,20f});
            
            Paragraph paragrafoID = new Paragraph("ID");
            paragrafoID.setAlignment(Element.ALIGN_CENTER);
            
            Paragraph paragrafoNome = new Paragraph("Nome");
            paragrafoNome.setAlignment(Element.ALIGN_CENTER);
            
            Paragraph paragrafoEndereco = new Paragraph("Endereço");
            paragrafoEndereco.setAlignment(Element.ALIGN_CENTER);
            
            Paragraph paragrafoTelefone = new Paragraph("Telefone");
            paragrafoTelefone.setAlignment(Element.ALIGN_CENTER);
            
            Paragraph paragrafoEmail = new Paragraph("Email");
            paragrafoEmail.setAlignment(Element.ALIGN_CENTER);
            
            Cell celulaID = new Cell();
            celulaID.add(paragrafoID);
//            Cell celulaNome = new Cell((Element) paragrafoNome);
//            Cell celulaEndereco = new Cell((Element) paragrafoEndereco);
//            Cell celulaTelefone = new Cell((Element) paragrafoTelefone);
//            Cell celulaEmail = new Cell((Element) paragrafoEmail);
            
            tabela.addCell(celulaID);
//            tabela.addCell(celulaNome);
//            tabela.addCell(celulaEndereco);
//            tabela.addCell(celulaTelefone);
//            tabela.addCell(celulaEmail);
            
            //documento.add(tabela);
            
            Runtime.getRuntime().exec(new String[]{"cmd.exe","/c", "start","relatorioCliente.pdf"});
            
            documento.close();
            
        } catch (FileNotFoundException ex) {
           JOptionPane.showMessageDialog(null, ex);

        } catch (DocumentException ex) {
           JOptionPane.showMessageDialog(null, ex);

        } catch (IOException ex) {
                       JOptionPane.showMessageDialog(null, ex);

        } catch (BadElementException ex) {
                       JOptionPane.showMessageDialog(null, ex);
            
        }
    }

    
    
    
    
    
    public void gerarComprovativo() {

        String email = "rufragosystem@gmail.com";
        String arquivo = "Comprovativo.pdf";
        Document document = new Document(PageSize.A4);
        Date date = new Date();
        ArrayList<Object> arrayUsuarios = new ArrayList<>();

        String sql = "select * from tbclientes";
        try {
            ps = conexao.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                PdfWriter.getInstance(document, new FileOutputStream(arquivo));
                document.open();
                Paragraph p1 = new Paragraph("Clientes");
                // Paragraph p2 = new Paragraph("Maputo-Cidade");
                //Paragraph p3 = new Paragraph("Universidade Eduardo Mondlane");
                //Paragraph p4 = new Paragraph("Comprovativo");

                Paragraph p6 = new Paragraph(date.toString());
                Paragraph p7 = new Paragraph(" ");
                Paragraph p8 = new Paragraph(" ");
                Paragraph p10 = new Paragraph("          id:         " + "      " + rs.getString(1));
                Paragraph p11 = new Paragraph("          Nome:           " + "      " + rs.getString(2));
                Paragraph p12 = new Paragraph("          Endereço:         " + "      ");
                Paragraph p13 = new Paragraph("          :  " + "      ");
                Paragraph p14 = new Paragraph("          Data Check-Out: " + "      " + LocalDate.now());
                Paragraph p15 = new Paragraph("          Consumo:        " + "      "
                );
                Paragraph p16 = new Paragraph("          Valor Total:    " + "      ");
                Paragraph p18 = new Paragraph(" ");
                Paragraph p19 = new Paragraph("          Contacto:       " + "      " + 01010101010101l);
                Paragraph p20 = new Paragraph("          Email:          " + "      " + email);

                p1.setAlignment(1);
                //p2.setAlignment(1);
                //p3.setAlignment(1);
                //p4.setAlignment(1);
                p6.setAlignment(1);
                p7.setAlignment(0);
                p8.setAlignment(0);
                p10.setAlignment(0);
                p11.setAlignment(0);
                p12.setAlignment(0);
                p13.setAlignment(0);
                p14.setAlignment(0);
                p15.setAlignment(0);
                p16.setAlignment(0);

                document.add(p1);
                //document.add(p2);
                //document.add(p3);
                //document.add(p4);
                document.add(p6);
                document.add(p7);
                document.add(p8);
                document.add(p10);
                document.add(p11);
                document.add(p12);
                document.add(p13);
                document.add(p14);
                document.add(p15);
                document.add(p16);
                document.add(p18);
                document.add(p19);
                document.add(p20);

                document.close();
            }
            Desktop.getDesktop().open(new File(arquivo));
        } catch (Exception e) {

            System.out.println("Erro ao tentar gerar comprovativo em pdf" + e);
        }
    }

   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktop = new javax.swing.JDesktopPane();
        lblUsuario = new javax.swing.JLabel();
        lblData = new javax.swing.JLabel();
        menu = new javax.swing.JMenuBar();
        menuCadastro = new javax.swing.JMenu();
        menuCadastroCliente = new javax.swing.JMenuItem();
        menuCadastroOS = new javax.swing.JMenuItem();
        menuCadastroUsuario = new javax.swing.JMenuItem();
        menuRelatorio = new javax.swing.JMenu();
        menuRelClientes = new javax.swing.JMenuItem();
        menuRelatorioServicos = new javax.swing.JMenuItem();
        menuAjuda = new javax.swing.JMenu();
        menuAjudaSobre = new javax.swing.JMenuItem();
        menuOpcoes = new javax.swing.JMenu();
        menuOpcoesSair = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        javax.swing.GroupLayout desktopLayout = new javax.swing.GroupLayout(desktop);
        desktop.setLayout(desktopLayout);
        desktopLayout.setHorizontalGroup(
            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 876, Short.MAX_VALUE)
        );
        desktopLayout.setVerticalGroup(
            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        lblUsuario.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblUsuario.setText("Usuário");

        lblData.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblData.setText("Data");

        menuCadastro.setText("Cadastro  |");
        menuCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCadastroActionPerformed(evt);
            }
        });

        menuCadastroCliente.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_DOWN_MASK));
        menuCadastroCliente.setText("Cliente");
        menuCadastroCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCadastroClienteActionPerformed(evt);
            }
        });
        menuCadastro.add(menuCadastroCliente);

        menuCadastroOS.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.ALT_DOWN_MASK));
        menuCadastroOS.setText("OS");
        menuCadastroOS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCadastroOSActionPerformed(evt);
            }
        });
        menuCadastro.add(menuCadastroOS);

        menuCadastroUsuario.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.ALT_DOWN_MASK));
        menuCadastroUsuario.setText("Usuário");
        menuCadastroUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCadastroUsuarioActionPerformed(evt);
            }
        });
        menuCadastro.add(menuCadastroUsuario);

        menu.add(menuCadastro);

        menuRelatorio.setText("Relatório  |");

        menuRelClientes.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.ALT_DOWN_MASK));
        menuRelClientes.setText("Clientes");
        menuRelClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuRelClientesActionPerformed(evt);
            }
        });
        menuRelatorio.add(menuRelClientes);

        menuRelatorioServicos.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_DOWN_MASK));
        menuRelatorioServicos.setText("Serviços");
        menuRelatorioServicos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuRelatorioServicosActionPerformed(evt);
            }
        });
        menuRelatorio.add(menuRelatorioServicos);

        menu.add(menuRelatorio);

        menuAjuda.setText("Ajuda  |");

        menuAjudaSobre.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, java.awt.event.InputEvent.ALT_DOWN_MASK));
        menuAjudaSobre.setText("Sobre");
        menuAjuda.add(menuAjudaSobre);

        menu.add(menuAjuda);

        menuOpcoes.setText("Opções");

        menuOpcoesSair.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_DOWN_MASK));
        menuOpcoesSair.setText("Sair");
        menuOpcoesSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuOpcoesSairActionPerformed(evt);
            }
        });
        menuOpcoes.add(menuOpcoesSair);

        menu.add(menuOpcoes);

        setJMenuBar(menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(desktop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 106, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblUsuario)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblData)
                        .addGap(13, 13, 13)))
                .addGap(94, 94, 94))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(lblUsuario)
                .addGap(18, 18, 18)
                .addComponent(lblData)
                .addContainerGap(472, Short.MAX_VALUE))
            .addComponent(desktop)
        );

        setSize(new java.awt.Dimension(1127, 651));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void menuOpcoesSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuOpcoesSairActionPerformed
        // TODO add your handling code here:
        int sair = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja sair?", "Sair", JOptionPane.YES_NO_OPTION);

        if (sair == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_menuOpcoesSairActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:


    }//GEN-LAST:event_formWindowActivated

    private void menuCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCadastroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menuCadastroActionPerformed

    private void menuCadastroUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCadastroUsuarioActionPerformed
        // TODO add your handling code here:
        TelaCadUsuario telaUsuario = new TelaCadUsuario();
        telaUsuario.setVisible(true);
        desktop.add(telaUsuario);
    }//GEN-LAST:event_menuCadastroUsuarioActionPerformed

    private void menuCadastroClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCadastroClienteActionPerformed
        // TODO add your handling code here:
        TelaCadCliente tCliente = new TelaCadCliente();
        tCliente.setVisible(true);
        desktop.add(tCliente);
    }//GEN-LAST:event_menuCadastroClienteActionPerformed

    private void menuCadastroOSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCadastroOSActionPerformed
        // TODO add your handling code here:
        TelaOS telaOS = new TelaOS();
        telaOS.setVisible(true);
        desktop.add(telaOS);
    }//GEN-LAST:event_menuCadastroOSActionPerformed

    private void menuRelClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuRelClientesActionPerformed
        // TODO add your handling code here:
//        int gerar = JOptionPane.showConfirmDialog(null, "Confirma a impressao", "Atencao", JOptionPane.YES_NO_OPTION);
//        if (gerar == JOptionPane.YES_OPTION) {
//            try {
////                //Usando a classe jasperprint para preparar a impressao do relatorio
//////                JasperReport compilado = JasperCompileManager.compileReport("G:\\CODING\\Relatorios do Projecto Java + DB\\Relatorio de Clientes.jasper");
//////                JasperPrint relatorio = JasperFillManager.fillReport(compilado, null, conexao);
////                JasperPrint print = JasperFillManager.fillReport(getClass().getResourceAsStream("/reportss/Relatorio de Clientes.jasper"), null, conexao);
////                // A linha abaixo exibe o relatorio atraves da clasee JasperViewer
////                JasperViewer.viewReport(print, false);
//                gerarRelatorio();
//            } catch (Exception e) {
//                JOptionPane.showMessageDialog(null, e);
//            }
//        }
        //JasperReport compilado = JasperCompileManager.compileReport("caminho onde seu relatório está");
        //JasperPrint relatorio = JasperFillManager.fillReport(compilado, null, new ConnectionFactory().getConnection());
                gerarComprovativo();


    }//GEN-LAST:event_menuRelClientesActionPerformed

    private void menuRelatorioServicosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuRelatorioServicosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menuRelatorioServicosActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane desktop;
    private javax.swing.JLabel lblData;
    public static javax.swing.JLabel lblUsuario;
    private javax.swing.JMenuBar menu;
    private javax.swing.JMenu menuAjuda;
    private javax.swing.JMenuItem menuAjudaSobre;
    private javax.swing.JMenu menuCadastro;
    private javax.swing.JMenuItem menuCadastroCliente;
    private javax.swing.JMenuItem menuCadastroOS;
    public static javax.swing.JMenuItem menuCadastroUsuario;
    private javax.swing.JMenu menuOpcoes;
    private javax.swing.JMenuItem menuOpcoesSair;
    private javax.swing.JMenuItem menuRelClientes;
    public static javax.swing.JMenu menuRelatorio;
    private javax.swing.JMenuItem menuRelatorioServicos;
    // End of variables declaration//GEN-END:variables
}
